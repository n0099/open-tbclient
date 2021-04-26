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
    public a.C1722a f6464d;

    /* renamed from: e  reason: collision with root package name */
    public c f6465e;

    /* renamed from: f  reason: collision with root package name */
    public f f6466f;

    /* renamed from: g  reason: collision with root package name */
    public b f6467g;

    /* renamed from: h  reason: collision with root package name */
    public List<a.d<String>> f6468h;

    /* renamed from: i  reason: collision with root package name */
    public g f6469i;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f6470e;

        public a(a.d dVar) {
            this.f6470e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GaidProvider.this.f6467g.f6472a.get()) {
                GaidProvider.this.j(this.f6470e);
            } else {
                GaidProvider.this.f6468h.add(this.f6470e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public AtomicBoolean f6472a = new AtomicBoolean(false);

        public b(GaidProvider gaidProvider) {
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public long f6473a;

        /* renamed from: d  reason: collision with root package name */
        public String f6476d;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6474b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.g.c.a.e f6475c = new d.a.q.g.c.a.e();

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f6477e = new ArrayList<>();

        public c() {
        }

        public String a() {
            return this.f6476d;
        }

        public void b(long j, long j2) {
            if (this.f6475c.c(j, j2)) {
                this.f6474b = true;
            }
        }

        public void c(String str) {
            String str2 = this.f6476d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f6476d = str;
                this.f6474b = true;
            }
        }

        public long d() {
            return this.f6473a;
        }

        public void e(long j) {
            if (this.f6473a != j) {
                this.f6473a = j;
                this.f6474b = true;
            }
        }

        public void f(String str) {
            if (this.f6477e.contains(str)) {
                return;
            }
            this.f6477e.add(str);
            this.f6474b = true;
        }

        public boolean g() {
            String g2 = GaidProvider.this.f6464d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f6476d = jSONObject.optString("form_id");
                    this.f6473a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f6475c.b(jSONObject.getLong("flags"));
                    this.f6477e.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i2 = optJSONObject.getInt("count");
                        for (int i3 = 0; i3 < i2; i3++) {
                            String string = optJSONObject.getString("id_" + i3);
                            if (TextUtils.isEmpty(string)) {
                                this.f6477e.clear();
                                return false;
                            }
                            this.f6477e.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f6474b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f6476d);
                    jSONObject.put("lst_fe_ts", this.f6473a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f6475c.d());
                    int size = this.f6477e.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f6477e.get((size - min) + i2));
                        }
                    }
                    GaidProvider.this.f6464d.i("cache.dat", jSONObject.toString(), true);
                    this.f6474b = false;
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
        public IBinder f6479a;

        /* renamed from: b  reason: collision with root package name */
        public String f6480b;

        public d(IBinder iBinder) {
            this.f6479a = iBinder;
            try {
                this.f6480b = com.baidu.helios.ids.gaid.c.a(d.a.q.h.d.a.c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.f6480b);
                this.f6479a.transact(1, obtain, obtain2, 0);
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
                obtain.writeInterfaceToken(this.f6480b);
                obtain.writeInt(z ? 1 : 0);
                this.f6479a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f6479a;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ServiceConnection {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ IBinder f6482e;

            /* renamed from: com.baidu.helios.ids.gaid.GaidProvider$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0087a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f6484e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f6485f;

                public RunnableC0087a(String str, boolean z) {
                    this.f6484e = str;
                    this.f6485f = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!GaidProvider.this.f6467g.f6472a.get()) {
                        GaidProvider.this.i();
                        GaidProvider.this.f6467g.f6472a.set(true);
                    }
                    GaidProvider.this.f6465e.b(this.f6485f ? 1L : 2L, 3L);
                    if (!TextUtils.isEmpty(this.f6484e)) {
                        try {
                            String b2 = d.a.q.h.a.b("A20", new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f6484e.getBytes("UTF-8")));
                            GaidProvider.this.f6465e.c(b2);
                            GaidProvider.this.f6465e.f(b2);
                        } catch (Exception unused) {
                        }
                    }
                    GaidProvider.this.f6465e.h();
                }
            }

            public a(IBinder iBinder) {
                this.f6482e = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    d dVar = new d(this.f6482e);
                    String a2 = dVar.a();
                    boolean a3 = dVar.a(false);
                    if (GaidProvider.this.f6469i != null) {
                        GaidProvider.this.f6469i.removeMessages(0);
                    }
                    GaidProvider.this.f63738b.f63745d.submit(new RunnableC0087a(a2, a3));
                    GaidProvider.this.f63738b.f63742a.unbindService(e.this);
                } catch (Exception unused) {
                }
            }
        }

        public e() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            GaidProvider.this.f63738b.f63746e.submit(new a(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f6487a;

        /* renamed from: b  reason: collision with root package name */
        public String f6488b;

        public f() {
            try {
                this.f6487a = com.baidu.helios.ids.gaid.c.a(d.a.q.h.d.a.a());
                this.f6488b = com.baidu.helios.ids.gaid.c.a(d.a.q.h.d.a.b());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public final String a() {
            return this.f6487a;
        }

        public final String c() {
            return this.f6488b;
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
                if (GaidProvider.this.f6467g.f6472a.get()) {
                    return;
                }
                GaidProvider.this.f6467g.f6472a.set(true);
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
            GaidProvider.this.f63738b.f63745d.submit(new a());
        }
    }

    public GaidProvider() {
        super("gaid");
        this.f6465e = new c();
        this.f6468h = new ArrayList();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f6465e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        String a2;
        b bVar = new b(this);
        this.f6467g = bVar;
        this.f6464d = this.f63737a.f("gaid");
        Context context = this.f63738b.f63742a;
        this.f6466f = new f(null);
        PackageManager packageManager = context.getPackageManager();
        try {
            a2 = this.f6466f.a();
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (a2 == null) {
            bVar.f6472a.set(true);
            return;
        }
        packageManager.getPackageInfo(a2, 0);
        this.f6465e.g();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f6465e.d()) > 604800000) {
            this.f6465e.e(currentTimeMillis);
            this.f6465e.h();
            try {
                String c2 = this.f6466f.c();
                if (c2 == null) {
                    bVar.f6472a.set(true);
                    return;
                } else if (!context.bindService(new Intent(c2).setPackage(a2), new e(), 1)) {
                    bVar.f6472a.set(true);
                    return;
                } else {
                    g gVar = new g(Looper.getMainLooper());
                    this.f6469i = gVar;
                    gVar.sendEmptyMessageDelayed(0, 50000L);
                    return;
                }
            } catch (Exception unused2) {
                bVar.f6472a.set(true);
                return;
            }
        }
        bVar.f6472a.set(true);
    }

    @Override // d.a.q.h.a
    public void g(a.d<String> dVar) {
        this.f63738b.f63745d.submit(new a(dVar));
    }

    public void i() {
        for (a.d<String> dVar : this.f6468h) {
            j(dVar);
        }
        this.f6468h.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f6465e.a())) {
            dVar.b(-1, null, bundle);
        } else {
            dVar.a(this.f6465e.a(), bundle);
        }
    }
}
