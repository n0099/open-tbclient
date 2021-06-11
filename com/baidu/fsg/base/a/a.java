package com.baidu.fsg.base.a;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.searchbox.pms.db.PackageTable;
import java.util.HashMap;
import java.util.HashSet;
@TargetApi(9)
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5075a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5076b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static a f5077c;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f5078d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, b> f5079e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f5080f;

    /* renamed from: com.baidu.fsg.base.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0078a {
        void a(c cVar);
    }

    /* loaded from: classes2.dex */
    public final class b extends ContentObserver {

        /* renamed from: b  reason: collision with root package name */
        public final c f5082b;

        /* renamed from: c  reason: collision with root package name */
        public final HashSet<InterfaceC0078a> f5083c;

        /* renamed from: d  reason: collision with root package name */
        public long f5084d;

        /* renamed from: e  reason: collision with root package name */
        public long f5085e;

        /* renamed from: f  reason: collision with root package name */
        public int f5086f;

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            a.this.a(this.f5082b);
            long currentTimeMillis = System.currentTimeMillis();
            if ((this.f5086f == this.f5082b.a() && this.f5084d == this.f5082b.b()) || this.f5085e == currentTimeMillis) {
                return;
            }
            if (2 == this.f5082b.a()) {
                c cVar = this.f5082b;
                cVar.c(((cVar.b() - this.f5084d) * 1000) / (currentTimeMillis - this.f5085e));
            } else {
                this.f5082b.c(0L);
            }
            this.f5084d = this.f5082b.b();
            this.f5086f = this.f5082b.a();
            this.f5085e = currentTimeMillis;
            synchronized (this) {
                int size = this.f5083c.size();
                InterfaceC0078a[] interfaceC0078aArr = new InterfaceC0078a[size];
                this.f5083c.toArray(interfaceC0078aArr);
                for (int i2 = 0; i2 < size; i2++) {
                    interfaceC0078aArr[i2].a(this.f5082b);
                }
            }
        }

        public b(Context context, long j) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            this.f5083c = new HashSet<>();
            this.f5084d = 0L;
            this.f5085e = 0L;
            this.f5086f = 1;
            this.f5082b = new c(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(InterfaceC0078a interfaceC0078a) {
            return this.f5083c.remove(interfaceC0078a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(InterfaceC0078a interfaceC0078a) {
            return this.f5083c.add(interfaceC0078a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void b() {
            this.f5083c.clear();
        }

        public boolean a() {
            return this.f5083c.isEmpty();
        }
    }

    public a(Context context) {
        this.f5080f = null;
        this.f5080f = context;
        this.f5078d = (DownloadManager) context.getSystemService("download");
    }

    public static a a(Context context) {
        if (f5077c == null) {
            f5077c = new a(context);
        }
        return f5077c;
    }

    public void b(Context context, long j, InterfaceC0078a interfaceC0078a) {
        b bVar;
        if (j == -1 || (bVar = this.f5079e.get(Long.valueOf(j))) == null) {
            return;
        }
        bVar.b(interfaceC0078a);
        if (bVar.a()) {
            context.getContentResolver().unregisterContentObserver(bVar);
            this.f5079e.remove(Uri.parse("content://downloads/my_downloads/" + j));
        }
    }

    public void a(Context context, long j, InterfaceC0078a interfaceC0078a) {
        if (interfaceC0078a == null || -1 == j) {
            return;
        }
        b bVar = this.f5079e.get(Long.valueOf(j));
        if (bVar == null) {
            bVar = new b(context, j);
            this.f5079e.put(Long.valueOf(j), bVar);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j), true, bVar);
        }
        bVar.a(interfaceC0078a);
    }

    private DownloadManager.Request b(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
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

    public void a(Context context, long j) {
        b bVar;
        if (j == -1 || (bVar = this.f5079e.get(Long.valueOf(j))) == null) {
            return;
        }
        bVar.b();
        context.getContentResolver().unregisterContentObserver(bVar);
        this.f5079e.remove(Uri.parse("content://downloads/my_downloads/" + j));
    }

    public c b(long j) {
        if (j == -1) {
            return null;
        }
        c cVar = new c(j);
        a(cVar);
        return cVar;
    }

    public long a(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str2)) {
            return -1L;
        }
        if (str2.startsWith("http://") || str2.startsWith("https://")) {
            return this.f5078d.enqueue(b(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
        }
        return -1L;
    }

    public long a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        if (TextUtils.isEmpty(str3)) {
            return -1L;
        }
        if (str3.startsWith("http://") || str3.startsWith("https://")) {
            return this.f5078d.enqueue(b(str, str2, str3, z, z2, z3, str4));
        }
        return -1L;
    }

    public void a(long j) {
        this.f5078d.remove(j);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(c cVar) {
        if (-1 == cVar.d()) {
            return;
        }
        Cursor query = this.f5078d.query(new DownloadManager.Query().setFilterById(cVar.d()));
        if (query != null) {
            try {
                if (query.getCount() != 0 && query.moveToFirst()) {
                    int columnIndexOrThrow = query.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                    int columnIndexOrThrow2 = query.getColumnIndexOrThrow("bytes_so_far");
                    int columnIndex = query.getColumnIndex("status");
                    long j = query.getLong(columnIndexOrThrow);
                    long j2 = query.getLong(columnIndexOrThrow2);
                    int i2 = query.getInt(columnIndex);
                    cVar.b(j);
                    cVar.a(j2);
                    cVar.a(i2);
                    if (query != null) {
                        query.close();
                        return;
                    }
                    return;
                }
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        cVar.a(0L);
        cVar.b(-1L);
        cVar.a(1);
    }
}
