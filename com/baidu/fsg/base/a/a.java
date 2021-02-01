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
import com.baidu.sapi2.utils.SapiUtils;
import java.util.HashMap;
import java.util.HashSet;
@TargetApi(9)
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1859a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1860b = "content://downloads/my_downloads/";
    private static a c;
    private final DownloadManager d;
    private final HashMap<Long, b> e = new HashMap<>();
    private Context f;

    /* renamed from: com.baidu.fsg.base.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0107a {
        void a(c cVar);
    }

    private a(Context context) {
        this.f = null;
        this.f = context;
        this.d = (DownloadManager) this.f.getSystemService("download");
    }

    public static a a(Context context) {
        if (c == null) {
            c = new a(context);
        }
        return c;
    }

    public void a(Context context, long j, InterfaceC0107a interfaceC0107a) {
        b bVar;
        if (interfaceC0107a != null && -1 != j) {
            b bVar2 = this.e.get(Long.valueOf(j));
            if (bVar2 == null) {
                bVar = new b(context, j);
                this.e.put(Long.valueOf(j), bVar);
                context.getContentResolver().registerContentObserver(Uri.parse(f1860b + j), true, bVar);
            } else {
                bVar = bVar2;
            }
            bVar.a(interfaceC0107a);
        }
    }

    public void b(Context context, long j, InterfaceC0107a interfaceC0107a) {
        b bVar;
        if (j == -1 || (bVar = this.e.get(Long.valueOf(j))) == null) {
            return;
        }
        bVar.b(interfaceC0107a);
        if (bVar.a()) {
            context.getContentResolver().unregisterContentObserver(bVar);
            this.e.remove(Uri.parse(f1860b + j));
        }
    }

    public void a(Context context, long j) {
        b bVar;
        if (j == -1 || (bVar = this.e.get(Long.valueOf(j))) == null) {
            return;
        }
        bVar.b();
        context.getContentResolver().unregisterContentObserver(bVar);
        this.e.remove(Uri.parse(f1860b + j));
    }

    public long a(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str2) || (!str2.startsWith("http://") && !str2.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            return -1L;
        }
        return this.d.enqueue(b(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
    }

    public long a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        if (TextUtils.isEmpty(str3) || (!str3.startsWith("http://") && !str3.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            return -1L;
        }
        return this.d.enqueue(b(str, str2, str3, z, z2, z3, str4));
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

    public void a(long j) {
        this.d.remove(j);
    }

    public c b(long j) {
        if (j == -1) {
            return null;
        }
        c cVar = new c(j);
        a(cVar);
        return cVar;
    }

    public void a(c cVar) {
        if (-1 != cVar.d()) {
            Cursor query = this.d.query(new DownloadManager.Query().setFilterById(cVar.d()));
            if (query != null) {
                try {
                    if (query.getCount() != 0 && query.moveToFirst()) {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("total_size");
                        int columnIndexOrThrow2 = query.getColumnIndexOrThrow("bytes_so_far");
                        int columnIndex = query.getColumnIndex("status");
                        long j = query.getLong(columnIndexOrThrow);
                        long j2 = query.getLong(columnIndexOrThrow2);
                        int i = query.getInt(columnIndex);
                        cVar.b(j);
                        cVar.a(j2);
                        cVar.a(i);
                        if (query != null) {
                            query.close();
                        }
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

    /* loaded from: classes5.dex */
    private final class b extends ContentObserver {

        /* renamed from: b  reason: collision with root package name */
        private final c f1862b;
        private final HashSet<InterfaceC0107a> c;
        private long d;
        private long e;
        private int f;

        private b(Context context, long j) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            this.c = new HashSet<>();
            this.d = 0L;
            this.e = 0L;
            this.f = 1;
            this.f1862b = new c(j);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            a.this.a(this.f1862b);
            long currentTimeMillis = System.currentTimeMillis();
            if ((this.f != this.f1862b.a() || this.d != this.f1862b.b()) && this.e != currentTimeMillis) {
                if (2 == this.f1862b.a()) {
                    this.f1862b.c(((this.f1862b.b() - this.d) * 1000) / (currentTimeMillis - this.e));
                } else {
                    this.f1862b.c(0L);
                }
                this.d = this.f1862b.b();
                this.f = this.f1862b.a();
                this.e = currentTimeMillis;
                synchronized (this) {
                    InterfaceC0107a[] interfaceC0107aArr = new InterfaceC0107a[this.c.size()];
                    this.c.toArray(interfaceC0107aArr);
                    for (InterfaceC0107a interfaceC0107a : interfaceC0107aArr) {
                        interfaceC0107a.a(this.f1862b);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(InterfaceC0107a interfaceC0107a) {
            return this.c.add(interfaceC0107a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(InterfaceC0107a interfaceC0107a) {
            return this.c.remove(interfaceC0107a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void b() {
            this.c.clear();
        }

        public boolean a() {
            return this.c.isEmpty();
        }
    }
}
