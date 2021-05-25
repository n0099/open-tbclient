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
    public a.C1788a f6218d;

    /* renamed from: e  reason: collision with root package name */
    public c f6219e;

    /* renamed from: f  reason: collision with root package name */
    public f f6220f;

    /* renamed from: g  reason: collision with root package name */
    public b f6221g;

    /* renamed from: h  reason: collision with root package name */
    public List<a.d<String>> f6222h;

    /* renamed from: i  reason: collision with root package name */
    public g f6223i;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f6224e;

        public a(a.d dVar) {
            this.f6224e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GaidProvider.this.f6221g.f6226a.get()) {
                GaidProvider.this.j(this.f6224e);
            } else {
                GaidProvider.this.f6222h.add(this.f6224e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public AtomicBoolean f6226a = new AtomicBoolean(false);

        public b(GaidProvider gaidProvider) {
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public long f6227a;

        /* renamed from: d  reason: collision with root package name */
        public String f6230d;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6228b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.g.c.a.e f6229c = new d.a.q.g.c.a.e();

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f6231e = new ArrayList<>();

        public c() {
        }

        public String a() {
            return this.f6230d;
        }

        public void b(long j, long j2) {
            if (this.f6229c.c(j, j2)) {
                this.f6228b = true;
            }
        }

        public void c(String str) {
            String str2 = this.f6230d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f6230d = str;
                this.f6228b = true;
            }
        }

        public long d() {
            return this.f6227a;
        }

        public void e(long j) {
            if (this.f6227a != j) {
                this.f6227a = j;
                this.f6228b = true;
            }
        }

        public void f(String str) {
            if (this.f6231e.contains(str)) {
                return;
            }
            this.f6231e.add(str);
            this.f6228b = true;
        }

        public boolean g() {
            String g2 = GaidProvider.this.f6218d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f6230d = jSONObject.optString("form_id");
                    this.f6227a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f6229c.b(jSONObject.getLong("flags"));
                    this.f6231e.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i2 = optJSONObject.getInt("count");
                        for (int i3 = 0; i3 < i2; i3++) {
                            String string = optJSONObject.getString("id_" + i3);
                            if (TextUtils.isEmpty(string)) {
                                this.f6231e.clear();
                                return false;
                            }
                            this.f6231e.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f6228b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f6230d);
                    jSONObject.put("lst_fe_ts", this.f6227a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f6229c.d());
                    int size = this.f6231e.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f6231e.get((size - min) + i2));
                        }
                    }
                    GaidProvider.this.f6218d.i("cache.dat", jSONObject.toString(), true);
                    this.f6228b = false;
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
        public IBinder f6233a;

        /* renamed from: b  reason: collision with root package name */
        public String f6234b;

        public d(IBinder iBinder) {
            this.f6233a = iBinder;
            try {
                this.f6234b = com.baidu.helios.ids.gaid.c.a(d.a.q.h.d.a.c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.f6234b);
                this.f6233a.transact(1, obtain, obtain2, 0);
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
                obtain.writeInterfaceToken(this.f6234b);
                obtain.writeInt(z ? 1 : 0);
                this.f6233a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f6233a;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ServiceConnection {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ IBinder f6236e;

            /* renamed from: com.baidu.helios.ids.gaid.GaidProvider$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0087a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f6238e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f6239f;

                public RunnableC0087a(String str, boolean z) {
                    this.f6238e = str;
                    this.f6239f = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!GaidProvider.this.f6221g.f6226a.get()) {
                        GaidProvider.this.i();
                        GaidProvider.this.f6221g.f6226a.set(true);
                    }
                    GaidProvider.this.f6219e.b(this.f6239f ? 1L : 2L, 3L);
                    if (!TextUtils.isEmpty(this.f6238e)) {
                        try {
                            String b2 = d.a.q.h.a.b("A20", new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f6238e.getBytes("UTF-8")));
                            GaidProvider.this.f6219e.c(b2);
                            GaidProvider.this.f6219e.f(b2);
                        } catch (Exception unused) {
                        }
                    }
                    GaidProvider.this.f6219e.h();
                }
            }

            public a(IBinder iBinder) {
                this.f6236e = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    d dVar = new d(this.f6236e);
                    String a2 = dVar.a();
                    boolean a3 = dVar.a(false);
                    if (GaidProvider.this.f6223i != null) {
                        GaidProvider.this.f6223i.removeMessages(0);
                    }
                    GaidProvider.this.f64251b.f64258d.submit(new RunnableC0087a(a2, a3));
                    GaidProvider.this.f64251b.f64255a.unbindService(e.this);
                } catch (Exception unused) {
                }
            }
        }

        public e() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            GaidProvider.this.f64251b.f64259e.submit(new a(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f6241a;

        /* renamed from: b  reason: collision with root package name */
        public String f6242b;

        public f() {
            try {
                this.f6241a = com.baidu.helios.ids.gaid.c.a(d.a.q.h.d.a.a());
                this.f6242b = com.baidu.helios.ids.gaid.c.a(d.a.q.h.d.a.b());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public final String a() {
            return this.f6241a;
        }

        public final String c() {
            return this.f6242b;
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
                if (GaidProvider.this.f6221g.f6226a.get()) {
                    return;
                }
                GaidProvider.this.f6221g.f6226a.set(true);
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
            GaidProvider.this.f64251b.f64258d.submit(new a());
        }
    }

    public GaidProvider() {
        super("gaid");
        this.f6219e = new c();
        this.f6222h = new ArrayList();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f6219e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        String a2;
        b bVar = new b(this);
        this.f6221g = bVar;
        this.f6218d = this.f64250a.f("gaid");
        Context context = this.f64251b.f64255a;
        this.f6220f = new f(null);
        PackageManager packageManager = context.getPackageManager();
        try {
            a2 = this.f6220f.a();
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (a2 == null) {
            bVar.f6226a.set(true);
            return;
        }
        packageManager.getPackageInfo(a2, 0);
        this.f6219e.g();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f6219e.d()) > 604800000) {
            this.f6219e.e(currentTimeMillis);
            this.f6219e.h();
            try {
                String c2 = this.f6220f.c();
                if (c2 == null) {
                    bVar.f6226a.set(true);
                    return;
                } else if (!context.bindService(new Intent(c2).setPackage(a2), new e(), 1)) {
                    bVar.f6226a.set(true);
                    return;
                } else {
                    g gVar = new g(Looper.getMainLooper());
                    this.f6223i = gVar;
                    gVar.sendEmptyMessageDelayed(0, 50000L);
                    return;
                }
            } catch (Exception unused2) {
                bVar.f6226a.set(true);
                return;
            }
        }
        bVar.f6226a.set(true);
    }

    @Override // d.a.q.h.a
    public void g(a.d<String> dVar) {
        this.f64251b.f64258d.submit(new a(dVar));
    }

    public void i() {
        for (a.d<String> dVar : this.f6222h) {
            j(dVar);
        }
        this.f6222h.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f6219e.a())) {
            dVar.b(-1, null, bundle);
        } else {
            dVar.a(this.f6219e.a(), bundle);
        }
    }
}
