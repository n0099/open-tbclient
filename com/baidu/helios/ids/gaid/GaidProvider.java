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
import d.b.p.g.d.a;
import d.b.p.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GaidProvider extends d.b.p.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1765a f6281d;

    /* renamed from: e  reason: collision with root package name */
    public c f6282e;

    /* renamed from: f  reason: collision with root package name */
    public f f6283f;

    /* renamed from: g  reason: collision with root package name */
    public b f6284g;

    /* renamed from: h  reason: collision with root package name */
    public List<a.d<String>> f6285h;
    public g i;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f6286e;

        public a(a.d dVar) {
            this.f6286e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GaidProvider.this.f6284g.f6288a.get()) {
                GaidProvider.this.j(this.f6286e);
            } else {
                GaidProvider.this.f6285h.add(this.f6286e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public AtomicBoolean f6288a = new AtomicBoolean(false);

        public b(GaidProvider gaidProvider) {
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public long f6289a;

        /* renamed from: d  reason: collision with root package name */
        public String f6292d;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6290b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.b.p.g.c.a.e f6291c = new d.b.p.g.c.a.e();

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f6293e = new ArrayList<>();

        public c() {
        }

        public String a() {
            return this.f6292d;
        }

        public void b(long j, long j2) {
            if (this.f6291c.c(j, j2)) {
                this.f6290b = true;
            }
        }

        public void c(String str) {
            String str2 = this.f6292d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f6292d = str;
                this.f6290b = true;
            }
        }

        public long d() {
            return this.f6289a;
        }

        public void e(long j) {
            if (this.f6289a != j) {
                this.f6289a = j;
                this.f6290b = true;
            }
        }

        public void f(String str) {
            if (this.f6293e.contains(str)) {
                return;
            }
            this.f6293e.add(str);
            this.f6290b = true;
        }

        public boolean g() {
            String g2 = GaidProvider.this.f6281d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f6292d = jSONObject.optString("form_id");
                    this.f6289a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f6291c.b(jSONObject.getLong("flags"));
                    this.f6293e.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i = optJSONObject.getInt("count");
                        for (int i2 = 0; i2 < i; i2++) {
                            String string = optJSONObject.getString("id_" + i2);
                            if (TextUtils.isEmpty(string)) {
                                this.f6293e.clear();
                                return false;
                            }
                            this.f6293e.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f6290b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f6292d);
                    jSONObject.put("lst_fe_ts", this.f6289a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f6291c.d());
                    int size = this.f6293e.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i = 0; i < min; i++) {
                            jSONObject2.put("id_" + i, this.f6293e.get((size - min) + i));
                        }
                    }
                    GaidProvider.this.f6281d.i("cache.dat", jSONObject.toString(), true);
                    this.f6290b = false;
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
        public IBinder f6295a;

        /* renamed from: b  reason: collision with root package name */
        public String f6296b;

        public d(IBinder iBinder) {
            this.f6295a = iBinder;
            try {
                this.f6296b = com.baidu.helios.ids.gaid.c.a(d.b.p.h.d.a.c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.f6296b);
                this.f6295a.transact(1, obtain, obtain2, 0);
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
                obtain.writeInterfaceToken(this.f6296b);
                obtain.writeInt(z ? 1 : 0);
                this.f6295a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f6295a;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ServiceConnection {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ IBinder f6298e;

            /* renamed from: com.baidu.helios.ids.gaid.GaidProvider$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0087a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f6300e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f6301f;

                public RunnableC0087a(String str, boolean z) {
                    this.f6300e = str;
                    this.f6301f = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!GaidProvider.this.f6284g.f6288a.get()) {
                        GaidProvider.this.i();
                        GaidProvider.this.f6284g.f6288a.set(true);
                    }
                    GaidProvider.this.f6282e.b(this.f6301f ? 1L : 2L, 3L);
                    if (!TextUtils.isEmpty(this.f6300e)) {
                        try {
                            String b2 = d.b.p.h.a.b("A20", new d.b.p.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f6300e.getBytes("UTF-8")));
                            GaidProvider.this.f6282e.c(b2);
                            GaidProvider.this.f6282e.f(b2);
                        } catch (Exception unused) {
                        }
                    }
                    GaidProvider.this.f6282e.h();
                }
            }

            public a(IBinder iBinder) {
                this.f6298e = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    d dVar = new d(this.f6298e);
                    String a2 = dVar.a();
                    boolean a3 = dVar.a(false);
                    if (GaidProvider.this.i != null) {
                        GaidProvider.this.i.removeMessages(0);
                    }
                    GaidProvider.this.f65155b.f65162d.submit(new RunnableC0087a(a2, a3));
                    GaidProvider.this.f65155b.f65159a.unbindService(e.this);
                } catch (Exception unused) {
                }
            }
        }

        public e() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            GaidProvider.this.f65155b.f65163e.submit(new a(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f6303a;

        /* renamed from: b  reason: collision with root package name */
        public String f6304b;

        public f() {
            try {
                this.f6303a = com.baidu.helios.ids.gaid.c.a(d.b.p.h.d.a.a());
                this.f6304b = com.baidu.helios.ids.gaid.c.a(d.b.p.h.d.a.b());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public final String a() {
            return this.f6303a;
        }

        public final String c() {
            return this.f6304b;
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
                if (GaidProvider.this.f6284g.f6288a.get()) {
                    return;
                }
                GaidProvider.this.f6284g.f6288a.set(true);
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
            GaidProvider.this.f65155b.f65162d.submit(new a());
        }
    }

    public GaidProvider() {
        super("gaid");
        this.f6282e = new c();
        this.f6285h = new ArrayList();
    }

    @Override // d.b.p.h.a
    public String c() {
        return this.f6282e.a();
    }

    @Override // d.b.p.h.a
    public void f(a.c cVar) {
        String a2;
        b bVar = new b(this);
        this.f6284g = bVar;
        this.f6281d = this.f65154a.f("gaid");
        Context context = this.f65155b.f65159a;
        this.f6283f = new f(null);
        PackageManager packageManager = context.getPackageManager();
        try {
            a2 = this.f6283f.a();
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (a2 == null) {
            bVar.f6288a.set(true);
            return;
        }
        packageManager.getPackageInfo(a2, 0);
        this.f6282e.g();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f6282e.d()) > 604800000) {
            this.f6282e.e(currentTimeMillis);
            this.f6282e.h();
            try {
                String c2 = this.f6283f.c();
                if (c2 == null) {
                    bVar.f6288a.set(true);
                    return;
                } else if (!context.bindService(new Intent(c2).setPackage(a2), new e(), 1)) {
                    bVar.f6288a.set(true);
                    return;
                } else {
                    g gVar = new g(Looper.getMainLooper());
                    this.i = gVar;
                    gVar.sendEmptyMessageDelayed(0, 50000L);
                    return;
                }
            } catch (Exception unused2) {
                bVar.f6288a.set(true);
                return;
            }
        }
        bVar.f6288a.set(true);
    }

    @Override // d.b.p.h.a
    public void g(a.d<String> dVar) {
        this.f65155b.f65162d.submit(new a(dVar));
    }

    public void i() {
        for (a.d<String> dVar : this.f6285h) {
            j(dVar);
        }
        this.f6285h.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f6282e.a())) {
            dVar.b(-1, null, bundle);
        } else {
            dVar.a(this.f6282e.a(), bundle);
        }
    }
}
