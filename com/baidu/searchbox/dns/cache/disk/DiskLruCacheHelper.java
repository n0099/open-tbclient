package com.baidu.searchbox.dns.cache.disk;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.searchbox.dns.cache.ICache;
import com.baidu.searchbox.dns.cache.disk.DiskLruCache;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes3.dex */
public class DiskLruCacheHelper implements ICache {
    public static final int DEFAULT_APP_VERSION = 1;
    public static final int DEFAULT_VALUE_COUNT = 1;
    public static final String DIR_NAME = "diskCache";
    public static final int MAX_COUNT = 5242880;
    public static final String TAG = "DiskLruCacheHelper";
    public Context mContext;
    public File mDir;
    public DiskLruCache mDiskLruCache;
    public int mMaxCount;

    @Override // com.baidu.searchbox.dns.cache.ICache
    public boolean isEmpty() {
        return false;
    }

    public DiskLruCacheHelper(Context context) {
        this(context, DIR_NAME, 5242880);
    }

    private String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append(TransactionIdCreater.FILL_BYTE);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private DiskLruCache.Editor editor(String str) {
        try {
            String hashKeyForDisk = hashKeyForDisk(str);
            if (this.mDiskLruCache != null) {
                return this.mDiskLruCache.edit(hashKeyForDisk);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int getAppVersion(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return 1;
            }
        }
        return 1;
    }

    private InputStream getInputStream(String str) {
        DiskLruCache.Snapshot snapshot;
        try {
            if (this.mDiskLruCache == null || (snapshot = this.mDiskLruCache.get(hashKeyForDisk(str))) == null) {
                return null;
            }
            return new GZIPInputStream(snapshot.getInputStream(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String hashKeyForDisk(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public boolean remove(String str) {
        if (isClosed()) {
            this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
        }
        try {
            String hashKeyForDisk = hashKeyForDisk(str);
            if (this.mDiskLruCache != null) {
                return this.mDiskLruCache.remove(hashKeyForDisk);
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setMaxSize(long j) {
        if (isClosed()) {
            this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
        }
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            diskLruCache.setMaxSize(j);
        }
    }

    public DiskLruCacheHelper(Context context, File file) {
        this(context, file, 5242880);
    }

    private File getDiskCacheDir(Context context, String str) {
        String path = context.getCacheDir().getPath();
        return new File(path + File.separator + str);
    }

    public DiskLruCacheHelper(Context context, File file, int i) {
        this.mContext = context.getApplicationContext();
        this.mDir = file;
        this.mMaxCount = i;
        this.mDiskLruCache = generateCache(context, file, i);
    }

    private DiskLruCache generateCache(Context context, File file, int i) {
        try {
            return DiskLruCache.open(file, getAppVersion(context), 1, i);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public DiskLruCacheHelper(Context context, String str) {
        this(context, str, 5242880);
    }

    public DiskLruCacheHelper(Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        File diskCacheDir = getDiskCacheDir(context, str);
        this.mDir = diskCacheDir;
        this.mMaxCount = i;
        this.mDiskLruCache = generateCache(context, diskCacheDir, i);
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public void clear() {
        if (isClosed()) {
            this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
        }
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            try {
                diskLruCache.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() throws IOException {
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            diskLruCache.close();
        }
    }

    public void flush() throws IOException {
        if (isClosed()) {
            this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
        }
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            diskLruCache.flush();
        }
    }

    public File getDirectory() {
        return this.mDir;
    }

    public long getMaxSize() {
        if (isClosed()) {
            this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
        }
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            return diskLruCache.getMaxSize();
        }
        return 0L;
    }

    public boolean isClosed() {
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            return diskLruCache.isClosed();
        }
        return true;
    }

    public long size() {
        if (isClosed()) {
            this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
        }
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            return diskLruCache.size();
        }
        return 0L;
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public String get(String str) {
        if (isClosed()) {
            this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
        }
        InputStream inputStream = getInputStream(str);
        if (inputStream == null) {
            return null;
        }
        try {
            return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            try {
                inputStream.close();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f A[Catch: IOException -> 0x0053, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x0053, blocks: (B:12:0x0034, B:29:0x004f), top: B:49:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.searchbox.dns.cache.ICache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void put(String str, String str2) {
        BufferedWriter bufferedWriter;
        DiskLruCache.Editor editor;
        if (isClosed()) {
            this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
        }
        BufferedWriter bufferedWriter2 = null;
        DiskLruCache.Editor editor2 = null;
        try {
            try {
                try {
                    editor = editor(str);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = null;
            }
            if (editor == null) {
                return;
            }
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(editor.newOutputStream(0))));
            } catch (IOException e3) {
                e = e3;
                bufferedWriter = null;
            }
            try {
                try {
                    bufferedWriter.write(str2);
                    editor.commit();
                    bufferedWriter.close();
                } catch (IOException e4) {
                    e = e4;
                    editor2 = editor;
                    e.printStackTrace();
                    try {
                        editor2.abort();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        if (bufferedWriter == null) {
                            bufferedWriter.close();
                        }
                        return;
                    }
                    if (bufferedWriter == null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedWriter2 = bufferedWriter;
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (bufferedWriter2 != null) {
            }
            throw th;
        }
    }
}
