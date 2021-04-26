package com.baidu.apollon.downloadmanager;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.searchbox.pms.db.PackageTable;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
@TargetApi(9)
/* loaded from: classes.dex */
public final class ApollonDownloadManager {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3653a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3654b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static ApollonDownloadManager f3655c;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f3656d;

    /* renamed from: g  reason: collision with root package name */
    public Context f3659g;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, a> f3657e = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<DownloadManager.Request> f3660h = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public final String f3658f = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;

    /* loaded from: classes.dex */
    public interface DownloadListener {
        void onChanged(DownloadItemInfo downloadItemInfo);
    }

    /* loaded from: classes.dex */
    public final class a extends ContentObserver {

        /* renamed from: b  reason: collision with root package name */
        public DownloadItemInfo f3662b;

        /* renamed from: c  reason: collision with root package name */
        public final HashSet<DownloadListener> f3663c;

        /* renamed from: d  reason: collision with root package name */
        public long f3664d;

        /* renamed from: e  reason: collision with root package name */
        public long f3665e;

        /* renamed from: f  reason: collision with root package name */
        public int f3666f;

        /* renamed from: g  reason: collision with root package name */
        public Context f3667g;

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (ApollonDownloadManager.this.a(this.f3662b)) {
                long currentTimeMillis = System.currentTimeMillis();
                if ((this.f3666f == this.f3662b.getDownloadState() && this.f3664d == this.f3662b.getCurrentBytes()) || this.f3665e == currentTimeMillis) {
                    return;
                }
                if (2 == this.f3662b.getDownloadState()) {
                    DownloadItemInfo downloadItemInfo = this.f3662b;
                    downloadItemInfo.setSpeed(((downloadItemInfo.getCurrentBytes() - this.f3664d) * 1000) / (currentTimeMillis - this.f3665e));
                } else {
                    this.f3662b.setSpeed(0L);
                }
                this.f3664d = this.f3662b.getCurrentBytes();
                this.f3666f = this.f3662b.getDownloadState();
                this.f3665e = currentTimeMillis;
                synchronized (this) {
                    int size = this.f3663c.size();
                    DownloadListener[] downloadListenerArr = new DownloadListener[size];
                    this.f3663c.toArray(downloadListenerArr);
                    for (int i2 = 0; i2 < size; i2++) {
                        downloadListenerArr[i2].onChanged(this.f3662b);
                    }
                }
                if ((this.f3662b.getDownloadState() & 24) != 0) {
                    ApollonDownloadManager.this.unregisterObserver(this.f3667g, this.f3662b.getDownloadId());
                }
            }
        }

        public a(Context context, long j) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            this.f3663c = new HashSet<>();
            this.f3664d = 0L;
            this.f3665e = 0L;
            this.f3666f = 1;
            this.f3662b = new DownloadItemInfo(j);
            this.f3667g = context.getApplicationContext();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(DownloadListener downloadListener) {
            return this.f3663c.remove(downloadListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void b() {
            this.f3663c.clear();
        }

        public void a(DownloadItemInfo downloadItemInfo) {
            this.f3662b = downloadItemInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(DownloadListener downloadListener) {
            return this.f3663c.add(downloadListener);
        }

        public boolean a() {
            return this.f3663c.isEmpty();
        }
    }

    public ApollonDownloadManager(Context context) {
        this.f3659g = null;
        this.f3659g = context;
        this.f3656d = (DownloadManager) context.getSystemService("download");
    }

    public static ApollonDownloadManager getInstance(Context context) {
        if (f3655c == null) {
            f3655c = new ApollonDownloadManager(context);
        }
        return f3655c;
    }

    public void cancelDownload(long j) {
        this.f3656d.remove(j);
    }

    public int createTask(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        String a2;
        if (TextUtils.isEmpty(str3)) {
            return -1;
        }
        if ((str3.startsWith("http://") || str3.startsWith("https://")) && (a2 = a(str2)) != null) {
            DownloadManager.Request a3 = a(str, a2, str3, z, z2, z3, str4);
            int hashCode = a3.hashCode();
            this.f3660h.put(hashCode, a3);
            return hashCode;
        }
        return -1;
    }

    @Deprecated
    public long doDownload(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str2)) {
            return -1L;
        }
        if (str2.startsWith("http://") || str2.startsWith("https://")) {
            return this.f3656d.enqueue(a(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
        }
        return -1L;
    }

    public DownloadItemInfo queryDownloadData(long j) {
        if (j == -1) {
            return null;
        }
        DownloadItemInfo downloadItemInfo = new DownloadItemInfo(j);
        a(downloadItemInfo);
        return downloadItemInfo;
    }

    public void registerObserver(Context context, long j, DownloadListener downloadListener) {
        if (downloadListener == null || -1 == j) {
            return;
        }
        a aVar = this.f3657e.get(Long.valueOf(j));
        if (aVar == null) {
            aVar = new a(context, j);
            this.f3657e.put(Long.valueOf(j), aVar);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j), true, aVar);
        }
        aVar.a(downloadListener);
    }

    public void unregisterObserver(Context context, long j, DownloadListener downloadListener) {
        a aVar;
        if (j == -1 || (aVar = this.f3657e.get(Long.valueOf(j))) == null) {
            return;
        }
        aVar.b(downloadListener);
        if (aVar.a()) {
            context.getContentResolver().unregisterContentObserver(aVar);
            this.f3657e.remove(Uri.parse("content://downloads/my_downloads/" + j));
        }
    }

    private String a(String str) {
        String str2 = str.startsWith(this.f3658f) ? null : this.f3658f;
        File parentFile = new File(str2, str).getParentFile();
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return str2 == null ? str.substring(this.f3658f.length()) : str;
        }
        return null;
    }

    @Deprecated
    public long doDownload(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        if (TextUtils.isEmpty(str3)) {
            return -1L;
        }
        if (str3.startsWith("http://") || str3.startsWith("https://")) {
            return this.f3656d.enqueue(a(str, str2, str3, z, z2, z3, str4));
        }
        return -1L;
    }

    public void doDownload(int i2) {
        if (-1 == i2) {
            return;
        }
        DownloadManager.Request request = this.f3660h.get(i2, null);
        if (request != null) {
            this.f3660h.delete(i2);
        }
        ContentResolver contentResolver = this.f3659g.getContentResolver();
        a remove = this.f3657e.remove(Long.valueOf(i2));
        if (remove == null) {
            return;
        }
        contentResolver.unregisterContentObserver(remove);
        long enqueue = this.f3656d.enqueue(request);
        this.f3657e.put(Long.valueOf(enqueue), remove);
        remove.a(new DownloadItemInfo(enqueue));
        contentResolver.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, remove);
    }

    public void unregisterObserver(Context context, long j) {
        a aVar;
        if (j == -1 || (aVar = this.f3657e.get(Long.valueOf(j))) == null) {
            return;
        }
        aVar.b();
        context.getContentResolver().unregisterContentObserver(aVar);
        this.f3657e.remove(Uri.parse("content://downloads/my_downloads/" + j));
    }

    private DownloadManager.Request a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str3));
        if (z3) {
            request.setAllowedNetworkTypes(2);
        } else {
            request.setAllowedNetworkTypes(3);
        }
        request.setShowRunningNotification(z);
        request.setVisibleInDownloadsUi(z2);
        request.setDestinationInExternalPublicDir(str, str2 + str4);
        return request;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
        if (0 == 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(DownloadItemInfo downloadItemInfo) {
        if (-1 == downloadItemInfo.getDownloadId()) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = this.f3656d.query(new DownloadManager.Query().setFilterById(downloadItemInfo.getDownloadId()));
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        if (cursor != null && cursor.getCount() != 0 && cursor.moveToFirst()) {
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
            int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("bytes_so_far");
            int columnIndex = cursor.getColumnIndex("status");
            long j = cursor.getLong(columnIndexOrThrow);
            long j2 = cursor.getLong(columnIndexOrThrow2);
            int i2 = cursor.getInt(columnIndex);
            downloadItemInfo.setTotalBytes(j);
            downloadItemInfo.setCurrentBytes(j2);
            downloadItemInfo.setDownloadState(i2);
            if (cursor != null) {
                cursor.close();
            }
            return true;
        }
        downloadItemInfo.setCurrentBytes(0L);
        downloadItemInfo.setTotalBytes(-1L);
        downloadItemInfo.setDownloadState(1);
        if (cursor != null) {
            cursor.close();
        }
        return false;
    }
}
