package com.baidu.helios.ids.gaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.text.TextUtils;
import d.a.q.g.d.a;
import d.a.q.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GaidProvider extends d.a.q.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1846a f6261d;

    /* renamed from: e  reason: collision with root package name */
    public c f6262e;

    /* renamed from: f  reason: collision with root package name */
    public f f6263f;

    /* renamed from: g  reason: collision with root package name */
    public b f6264g;

    /* renamed from: h  reason: collision with root package name */
    public List<a.d<String>> f6265h;

    /* renamed from: i  reason: collision with root package name */
    public g f6266i;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f6267e;

        public a(a.d dVar) {
            this.f6267e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GaidProvider.this.f6264g.f6269a.get()) {
                GaidProvider.this.j(this.f6267e);
            } else {
                GaidProvider.this.f6265h.add(this.f6267e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public AtomicBoolean f6269a = new AtomicBoolean(false);

        public b(GaidProvider gaidProvider) {
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public long f6270a;

        /* renamed from: d  reason: collision with root package name */
        public String f6273d;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6271b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.g.c.a.e f6272c = new d.a.q.g.c.a.e();

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f6274e = new ArrayList<>();

        public c() {
        }

        public String a() {
            return this.f6273d;
        }

        public void b(long j, long j2) {
            if (this.f6272c.c(j, j2)) {
                this.f6271b = true;
            }
        }

        public void c(String str) {
            String str2 = this.f6273d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f6273d = str;
                this.f6271b = true;
            }
        }

        public long d() {
            return this.f6270a;
        }

        public void e(long j) {
            if (this.f6270a != j) {
                this.f6270a = j;
                this.f6271b = true;
            }
        }

        public void f(String str) {
            if (this.f6274e.contains(str)) {
                return;
            }
            this.f6274e.add(str);
            this.f6271b = true;
        }

        public boolean g() {
            String g2 = GaidProvider.this.f6261d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f6273d = jSONObject.optString("form_id");
                    this.f6270a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f6272c.b(jSONObject.getLong("flags"));
                    this.f6274e.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i2 = optJSONObject.getInt("count");
                        for (int i3 = 0; i3 < i2; i3++) {
                            String string = optJSONObject.getString("id_" + i3);
                            if (TextUtils.isEmpty(string)) {
                                this.f6274e.clear();
                                return false;
                            }
                            this.f6274e.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f6271b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f6273d);
                    jSONObject.put("lst_fe_ts", this.f6270a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f6272c.d());
                    int size = this.f6274e.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f6274e.get((size - min) + i2));
                        }
                    }
                    GaidProvider.this.f6261d.i("cache.dat", jSONObject.toString(), true);
                    this.f6271b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f6276a;

        /* renamed from: b  reason: collision with root package name */
        public String f6277b;

        public d(IBinder iBinder) {
            this.f6276a = iBinder;
            try {
                this.f6277b = com.baidu.helios.ids.gaid.c.a(d.a.q.h.d.a.c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.f6277b);
                this.f6276a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean a(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.f6277b);
                obtain.writeInt(z ? 1 : 0);
                this.f6276a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f6276a;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ServiceConnection {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ IBinder f6279e;

            /* renamed from: com.baidu.helios.ids.gaid.GaidProvider$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0088a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f6281e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f6282f;

                public RunnableC0088a(String str, boolean z) {
                    this.f6281e = str;
                    this.f6282f = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!GaidProvider.this.f6264g.f6269a.get()) {
                        GaidProvider.this.i();
                        GaidProvider.this.f6264g.f6269a.set(true);
                    }
                    GaidProvider.this.f6262e.b(this.f6282f ? 1L : 2L, 3L);
                    if (!TextUtils.isEmpty(this.f6281e)) {
                        try {
                            String b2 = d.a.q.h.a.b("A20", new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f6281e.getBytes("UTF-8")));
                            GaidProvider.this.f6262e.c(b2);
                            GaidProvider.this.f6262e.f(b2);
                        } catch (Exception unused) {
                        }
                    }
                    GaidProvider.this.f6262e.h();
                }
            }

            public a(IBinder iBinder) {
                this.f6279e = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    d dVar = new d(this.f6279e);
                    String a2 = dVar.a();
                    boolean a3 = dVar.a(false);
                    if (GaidProvider.this.f6266i != null) {
                        GaidProvider.this.f6266i.removeMessages(0);
                    }
                    GaidProvider.this.f67969b.f67976d.submit(new RunnableC0088a(a2, a3));
                    GaidProvider.this.f67969b.f67973a.unbindService(e.this);
                } catch (Exception unused) {
                }
            }
        }

        public e() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            GaidProvider.this.f67969b.f67977e.submit(new a(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f6284a;

        /* renamed from: b  reason: collision with root package name */
        public String f6285b;

        public f() {
            try {
                this.f6284a = com.baidu.helios.ids.gaid.c.a(d.a.q.h.d.a.a());
                this.f6285b = com.baidu.helios.ids.gaid.c.a(d.a.q.h.d.a.b());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public final String a() {
            return this.f6284a;
        }

        public final String c() {
            return this.f6285b;
        }
    }

    /* loaded from: classes2.dex */
    public class g extends Handler {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (GaidProvider.this.f6264g.f6269a.get()) {
                    return;
                }
                GaidProvider.this.f6264g.f6269a.set(true);
                GaidProvider.this.i();
            }
        }

        public g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            GaidProvider.this.f67969b.f67976d.submit(new a());
        }
    }

    public GaidProvider() {
        super("gaid");
        this.f6262e = new c();
        this.f6265h = new ArrayList();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f6262e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        String a2;
        b bVar = new b(this);
        this.f6264g = bVar;
        this.f6261d = this.f67968a.f("gaid");
        Context context = this.f67969b.f67973a;
        this.f6263f = new f(null);
        PackageManager packageManager = context.getPackageManager();
        try {
            a2 = this.f6263f.a();
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (a2 == null) {
            bVar.f6269a.set(true);
            return;
        }
        packageManager.getPackageInfo(a2, 0);
        this.f6262e.g();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f6262e.d()) > 604800000) {
            this.f6262e.e(currentTimeMillis);
            this.f6262e.h();
            try {
                String c2 = this.f6263f.c();
                if (c2 == null) {
                    bVar.f6269a.set(true);
                    return;
                } else if (!context.bindService(new Intent(c2).setPackage(a2), new e(), 1)) {
                    bVar.f6269a.set(true);
                    return;
                } else {
                    g gVar = new g(Looper.getMainLooper());
                    this.f6266i = gVar;
                    gVar.sendEmptyMessageDelayed(0, 50000L);
                    return;
                }
            } catch (Exception unused2) {
                bVar.f6269a.set(true);
                return;
            }
        }
        bVar.f6269a.set(true);
    }

    @Override // d.a.q.h.a
    public void g(a.d<String> dVar) {
        this.f67969b.f67976d.submit(new a(dVar));
    }

    public void i() {
        for (a.d<String> dVar : this.f6265h) {
            j(dVar);
        }
        this.f6265h.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f6262e.a())) {
            dVar.b(-1, null, bundle);
        } else {
            dVar.a(this.f6262e.a(), bundle);
        }
    }
}
