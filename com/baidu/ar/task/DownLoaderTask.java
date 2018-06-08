package com.baidu.ar.task;

import android.content.ContentResolver;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.base.d;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.ArResourceUtils;
import com.baidu.ar.util.FileUtils;
import com.baidu.ar.util.HttpUtils;
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.MD5Utils;
import com.baidu.ar.util.ZipUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* loaded from: classes3.dex */
public class DownLoaderTask extends AsyncTask<String, Integer, String> {
    private static long g;
    private String a;
    private String b;
    private ActionResponseListener<String> c;
    private boolean d = false;
    private boolean e;
    private ContentResolver f;
    private long h;

    public DownLoaderTask(String str, String str2, boolean z, long j, ActionResponseListener<String> actionResponseListener) {
        this.a = "";
        this.b = null;
        this.a = str;
        this.b = str2;
        this.c = actionResponseListener;
        this.e = z;
        this.h = j;
    }

    public DownLoaderTask(String str, String str2, boolean z, ContentResolver contentResolver, long j, ActionResponseListener<String> actionResponseListener) {
        this.a = "";
        this.b = null;
        this.a = str;
        this.b = str2;
        this.c = actionResponseListener;
        this.e = z;
        this.f = contentResolver;
        this.h = j;
    }

    private void a() {
        while (this.d) {
            ARLog.d("mIsPause = " + this.d);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean a(String str, File file) {
        String[] list;
        return (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0 && ARFileUtils.checkKeyInFile(str, ".successUnzip.txt")) ? false : true;
    }

    private String b(String str) {
        ZipFile zipFile;
        ZipFile zipFile2;
        InputStream inputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (str.length() <= 4) {
            return null;
        }
        String aRCaseDirPath = ARFileUtils.getARCaseDirPath(this.a);
        File file2 = new File(aRCaseDirPath);
        ARLog.e("bdar: unzipFilePath " + aRCaseDirPath);
        File file3 = new File(ARFileUtils.getARCaseFullPath(this.a));
        String md5 = MD5Utils.md5(str);
        if (!this.e) {
            if (!a(md5, file3)) {
                return aRCaseDirPath;
            }
            if (file3.exists()) {
                ARFileUtils.deleteDir(file3);
            }
        }
        try {
            zipFile = new ZipFile(file);
            try {
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        a();
                        ZipEntry nextElement = entries.nextElement();
                        if (!nextElement.getName().contains("../") && !nextElement.isDirectory()) {
                            File file4 = new File(file2, nextElement.getName());
                            if (!file4.exists() || file4.length() != nextElement.getSize()) {
                                if (!file4.getParentFile().exists()) {
                                    ARLog.d("file path = " + file4.getAbsolutePath() + ", parent path = " + file4.getParentFile().getAbsolutePath());
                                    file4.getParentFile().mkdirs();
                                }
                                try {
                                    inputStream = zipFile.getInputStream(nextElement);
                                    try {
                                        try {
                                            IoUtils.copyStream(inputStream, file4);
                                            IoUtils.closeQuietly(inputStream);
                                        } catch (IOException e) {
                                            e = e;
                                            e.printStackTrace();
                                            IoUtils.closeQuietly(inputStream);
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        IoUtils.closeQuietly(inputStream);
                                        throw th;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    inputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = null;
                                }
                            }
                        }
                    }
                    ZipUtils.closeZipFile(zipFile);
                    if (!this.e) {
                        ARFileUtils.putKeyToFile(md5, ".successUnzip.txt");
                    }
                    return aRCaseDirPath;
                } catch (Throwable th3) {
                    th = th3;
                    ZipUtils.closeZipFile(zipFile);
                    throw th;
                }
            } catch (ZipException e3) {
                e = e3;
                zipFile2 = zipFile;
                try {
                    e.printStackTrace();
                    ZipUtils.closeZipFile(zipFile2);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    zipFile = zipFile2;
                    ZipUtils.closeZipFile(zipFile);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                ZipUtils.closeZipFile(zipFile);
                return null;
            }
        } catch (ZipException e5) {
            e = e5;
            zipFile2 = null;
        } catch (IOException e6) {
            e = e6;
            zipFile = null;
        } catch (Throwable th5) {
            th = th5;
            zipFile = null;
        }
    }

    public static DownLoaderTask doDownLoadWork(String str, String str2, String str3, boolean z, ContentResolver contentResolver, ActionResponseListener<String> actionResponseListener) {
        g = System.currentTimeMillis();
        DownLoaderTask downLoaderTask = new DownLoaderTask(str, str2, z, contentResolver, g, actionResponseListener);
        downLoaderTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str3);
        return downLoaderTask;
    }

    public static DownLoaderTask doDownLoadWork(String str, String str2, String str3, boolean z, ActionResponseListener<String> actionResponseListener) {
        g = System.currentTimeMillis();
        DownLoaderTask downLoaderTask = new DownLoaderTask(str, str2, z, g, actionResponseListener);
        downLoaderTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str3);
        return downLoaderTask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        RandomAccessFile randomAccessFile;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        IOException e;
        RandomAccessFile randomAccessFile2;
        int i = 0;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        String str = strArr[0];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f != null) {
            ARFileUtils.hideARResourceFile(this.f);
        }
        if (TextUtils.isEmpty(this.b)) {
            return null;
        }
        File file = new File(this.b);
        FileUtils.ensureDir(file.getParentFile());
        int length = HttpUtils.getLength(str);
        ARLog.d("download length = " + length);
        if (length <= 0) {
            return null;
        }
        if (file.exists()) {
            if (length == file.length() && ZipUtils.isZipFile(this.b)) {
                d.a((int) MsgField.MSG_STAT_FIRST_LOAD_START_FILE_MANAGE);
                String b = b(this.b);
                if (TextUtils.isEmpty(b)) {
                    d.a((int) MsgField.MSG_STAT_FIRST_LOAD_FILE_MANAGE_FAILURE);
                } else {
                    d.a((int) MsgField.MSG_STAT_FIRST_LOAD_FILE_MANAGE_SUCCESS);
                }
                a();
                return ArResourceUtils.generateResult(b);
            }
            file.delete();
        } else if (!FileUtils.ensureDirectoryExist(file.getParentFile())) {
            ARLog.e("create file error!");
            return null;
        } else {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                ARLog.e("create zip file error!");
                e2.printStackTrace();
                return null;
            }
        }
        File file2 = new File(ARFileUtils.getARCaseFullPath(this.a));
        if (file2.exists()) {
            ARFileUtils.deleteDir(file2);
        }
        d.a((int) MsgField.MSG_STAT_START_DOWNLOAD_3D_RES);
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(10000);
            openConnection.setRequestProperty("Range", "bytes=0-" + length);
            randomAccessFile = new RandomAccessFile(this.b, "rw");
            try {
                randomAccessFile.seek(0L);
                byte[] bArr = new byte[8192];
                bufferedInputStream = new BufferedInputStream(openConnection.getInputStream(), 8192);
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr, 0, 8192);
                        if (read == -1) {
                            d.a((int) MsgField.MSG_STAT_DOWNLOAD_3D_RES_SUCCESS);
                            IoUtils.closeQuietly(bufferedInputStream);
                            IoUtils.closeQuietly(randomAccessFile);
                            break;
                        }
                        ARLog.d("one while read start n =" + read);
                        randomAccessFile.write(bArr, 0, read);
                        i += read;
                        a();
                        if (isCancelled()) {
                            ARLog.d("cancelled");
                            IoUtils.closeQuietly(bufferedInputStream);
                            IoUtils.closeQuietly(randomAccessFile);
                            return null;
                        }
                        ARLog.d("one while read end count = " + i);
                    } catch (IOException e3) {
                        e = e3;
                        bufferedInputStream2 = bufferedInputStream;
                        randomAccessFile2 = randomAccessFile;
                        try {
                            e.printStackTrace();
                            d.a((int) MsgField.MSG_STAT_DOWNLOAD_3D_RES_FAILURE);
                            IoUtils.closeQuietly(bufferedInputStream2);
                            IoUtils.closeQuietly(randomAccessFile2);
                            d.a((int) MsgField.MSG_STAT_FIRST_LOAD_START_FILE_MANAGE);
                            String b2 = b(this.b);
                            if (TextUtils.isEmpty(b2)) {
                                d.a((int) MsgField.MSG_STAT_FIRST_LOAD_FILE_MANAGE_FAILURE);
                            } else {
                                d.a((int) MsgField.MSG_STAT_FIRST_LOAD_FILE_MANAGE_SUCCESS);
                            }
                            a();
                            return ArResourceUtils.generateResult(b2);
                        } catch (Throwable th2) {
                            th = th2;
                            RandomAccessFile randomAccessFile3 = randomAccessFile2;
                            bufferedInputStream = bufferedInputStream2;
                            randomAccessFile = randomAccessFile3;
                            IoUtils.closeQuietly(bufferedInputStream);
                            IoUtils.closeQuietly(randomAccessFile);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        IoUtils.closeQuietly(bufferedInputStream);
                        IoUtils.closeQuietly(randomAccessFile);
                        throw th;
                    }
                }
            } catch (IOException e4) {
                randomAccessFile2 = randomAccessFile;
                bufferedInputStream2 = null;
                e = e4;
            } catch (Throwable th4) {
                bufferedInputStream = null;
                th = th4;
            }
        } catch (IOException e5) {
            bufferedInputStream2 = null;
            e = e5;
            randomAccessFile2 = null;
        } catch (Throwable th5) {
            randomAccessFile = null;
            bufferedInputStream = null;
            th = th5;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str) || this.h != g || "{}".equals(str)) {
            this.c.onErrorResponse("download error!");
        } else {
            this.c.onResponse(str);
        }
    }

    public boolean isPause() {
        return this.d;
    }

    public void setPause(boolean z) {
        this.d = z;
    }
}
