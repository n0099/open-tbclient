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
    public static final String f5148a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5149b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static a f5150c;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f5151d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, b> f5152e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f5153f;

    /* renamed from: com.baidu.fsg.base.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0077a {
        void a(c cVar);
    }

    /* loaded from: classes2.dex */
    public final class b extends ContentObserver {

        /* renamed from: b  reason: collision with root package name */
        public final c f5155b;

        /* renamed from: c  reason: collision with root package name */
        public final HashSet<InterfaceC0077a> f5156c;

        /* renamed from: d  reason: collision with root package name */
        public long f5157d;

        /* renamed from: e  reason: collision with root package name */
        public long f5158e;

        /* renamed from: f  reason: collision with root package name */
        public int f5159f;

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            a.this.a(this.f5155b);
            long currentTimeMillis = System.currentTimeMillis();
            if ((this.f5159f == this.f5155b.a() && this.f5157d == this.f5155b.b()) || this.f5158e == currentTimeMillis) {
                return;
            }
            if (2 == this.f5155b.a()) {
                c cVar = this.f5155b;
                cVar.c(((cVar.b() - this.f5157d) * 1000) / (currentTimeMillis - this.f5158e));
            } else {
                this.f5155b.c(0L);
            }
            this.f5157d = this.f5155b.b();
            this.f5159f = this.f5155b.a();
            this.f5158e = currentTimeMillis;
            synchronized (this) {
                int size = this.f5156c.size();
                InterfaceC0077a[] interfaceC0077aArr = new InterfaceC0077a[size];
                this.f5156c.toArray(interfaceC0077aArr);
                for (int i = 0; i < size; i++) {
                    interfaceC0077aArr[i].a(this.f5155b);
                }
            }
        }

        public b(Context context, long j) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            this.f5156c = new HashSet<>();
            this.f5157d = 0L;
            this.f5158e = 0L;
            this.f5159f = 1;
            this.f5155b = new c(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(InterfaceC0077a interfaceC0077a) {
            return this.f5156c.remove(interfaceC0077a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(InterfaceC0077a interfaceC0077a) {
            return this.f5156c.add(interfaceC0077a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void b() {
            this.f5156c.clear();
        }

        public boolean a() {
            return this.f5156c.isEmpty();
        }
    }

    public a(Context context) {
        this.f5153f = null;
        this.f5153f = context;
        this.f5151d = (DownloadManager) context.getSystemService("download");
    }

    public static a a(Context context) {
        if (f5150c == null) {
            f5150c = new a(context);
        }
        return f5150c;
    }

    public void b(Context context, long j, InterfaceC0077a interfaceC0077a) {
        b bVar;
        if (j == -1 || (bVar = this.f5152e.get(Long.valueOf(j))) == null) {
            return;
        }
        bVar.b(interfaceC0077a);
        if (bVar.a()) {
            context.getContentResolver().unregisterContentObserver(bVar);
            this.f5152e.remove(Uri.parse("content://downloads/my_downloads/" + j));
        }
    }

    public void a(Context context, long j, InterfaceC0077a interfaceC0077a) {
        if (interfaceC0077a == null || -1 == j) {
            return;
        }
        b bVar = this.f5152e.get(Long.valueOf(j));
        if (bVar == null) {
            bVar = new b(context, j);
            this.f5152e.put(Long.valueOf(j), bVar);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j), true, bVar);
        }
        bVar.a(interfaceC0077a);
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
        if (j == -1 || (bVar = this.f5152e.get(Long.valueOf(j))) == null) {
            return;
        }
        bVar.b();
        context.getContentResolver().unregisterContentObserver(bVar);
        this.f5152e.remove(Uri.parse("content://downloads/my_downloads/" + j));
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
            return this.f5151d.enqueue(b(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
        }
        return -1L;
    }

    public long a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        if (TextUtils.isEmpty(str3)) {
            return -1L;
        }
        if (str3.startsWith("http://") || str3.startsWith("https://")) {
            return this.f5151d.enqueue(b(str, str2, str3, z, z2, z3, str4));
        }
        return -1L;
    }

    public void a(long j) {
        this.f5151d.remove(j);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(c cVar) {
        if (-1 == cVar.d()) {
            return;
        }
        Cursor query = this.f5151d.query(new DownloadManager.Query().setFilterById(cVar.d()));
        if (query != null) {
            try {
                if (query.getCount() != 0 && query.moveToFirst()) {
                    int columnIndexOrThrow = query.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
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
