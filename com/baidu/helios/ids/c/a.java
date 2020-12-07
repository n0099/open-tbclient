package com.baidu.helios.ids.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.core.MdidSdk;
import com.bun.miitmdid.supplier.IdSupplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class a extends com.baidu.helios.ids.a {
    private a.C0149a axM;
    private b aya;
    private C0156a ayb;
    private List<a.c<String>> i;

    /* renamed from: com.baidu.helios.ids.c.a$2  reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Handler f1811a;
        final /* synthetic */ C0156a ayf;
        final /* synthetic */ Context b;

        AnonymousClass2(Handler handler, Context context, C0156a c0156a) {
            this.f1811a = handler;
            this.b = context;
            this.ayf = c0156a;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1811a.sendEmptyMessageDelayed(0, 50000L);
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                final int InitSdk = new MdidSdk().InitSdk(this.b, new c() { // from class: com.baidu.helios.ids.c.a.2.1
                    @Override // com.baidu.helios.ids.c.a.c
                    public void a(final boolean z, IdSupplier idSupplier) {
                        final String oaid = idSupplier.getOAID();
                        AnonymousClass2.this.f1811a.removeMessages(0);
                        final long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        AnonymousClass2.this.ayf.ayk = a.this.axC.avJ.submit(new Runnable() { // from class: com.baidu.helios.ids.c.a.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.aya.c(elapsedRealtime2 - elapsedRealtime);
                                a.this.aya.a(z ? 1L : 2L, 3L);
                                a.this.aya.a(16L, 124L);
                                a.this.aya.b(oaid);
                                if (!TextUtils.isEmpty(oaid)) {
                                    try {
                                        String af = com.baidu.helios.ids.a.af("A10", new com.baidu.helios.common.b.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(oaid.getBytes("UTF-8")));
                                        a.this.aya.a(af);
                                        a.this.aya.d(af);
                                        a.this.aya.a(32L, 124L);
                                    } catch (Exception e) {
                                    }
                                }
                                a.this.aya.d();
                                if (AnonymousClass2.this.ayf.d.get()) {
                                    return;
                                }
                                a.this.a();
                                AnonymousClass2.this.ayf.d.set(true);
                            }
                        });
                    }
                });
                this.ayf.ayj = a.this.axC.avJ.submit(new Runnable() { // from class: com.baidu.helios.ids.c.a.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InitSdk == 1008612 || InitSdk == 1008611 || InitSdk == 1008615) {
                            if (!AnonymousClass2.this.ayf.d.get()) {
                                AnonymousClass2.this.ayf.d.set(true);
                                a.this.a();
                            }
                            AnonymousClass2.this.f1811a.removeMessages(0);
                        }
                        a.this.aya.a(InitSdk);
                        a.this.aya.a(8L, 124L);
                        a.this.aya.d();
                    }
                });
            } catch (Throwable th) {
                a.this.axC.avJ.submit(new Runnable() { // from class: com.baidu.helios.ids.c.a.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2.this.f1811a.removeMessages(0);
                        a.this.aya.c(Log.getStackTraceString(th));
                        a.this.aya.d();
                        if (AnonymousClass2.this.ayf.d.get()) {
                            return;
                        }
                        AnonymousClass2.this.ayf.d.set(true);
                        a.this.a();
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.helios.ids.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class C0156a {

        /* renamed from: a  reason: collision with root package name */
        Future<?> f1816a;
        Future<?> ayj;
        Future<?> ayk;
        AtomicBoolean d = new AtomicBoolean(false);

        public C0156a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b {
        public String l;
        private long o;
        private String r;
        private int s;
        private int v;
        private long w;
        private String x;
        private boolean p = true;
        private e aym = new e();
        private ArrayList<String> ayn = new ArrayList<>();

        b() {
        }

        private JSONObject e() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.r);
                jSONObject.put("lst_fe_ts", this.o);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.aym.zL());
                jSONObject.put("init_res", this.s);
                jSONObject.put("acquire_ts_cost", this.w);
                jSONObject.put("oid", this.x);
                int size = this.ayn.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i = 0; i < min; i++) {
                        jSONObject2.put("id_" + i, this.ayn.get((size - min) + i));
                    }
                }
            } catch (Exception e) {
            }
            return jSONObject;
        }

        public String a() {
            return this.r;
        }

        public void a(int i) {
            if (this.s != i) {
                this.s = i;
                this.p = true;
            }
        }

        public void a(long j, long j2) {
            if (this.aym.d(j, j2)) {
                this.p = true;
            }
        }

        public void a(String str) {
            if (this.r == str) {
                return;
            }
            if (str == null || !str.equals(this.r)) {
                this.r = str;
                this.p = true;
            }
        }

        public long b() {
            return this.o;
        }

        public void b(long j) {
            if (this.o != j) {
                this.o = j;
                this.p = true;
            }
        }

        public void b(String str) {
            if (this.x == str) {
                return;
            }
            if (str == null || !str.equals(this.x)) {
                this.x = str;
                this.p = true;
            }
        }

        public void c(long j) {
            if (this.w != j) {
                this.w = j;
                this.p = true;
            }
        }

        public void c(String str) {
            if (this.l == str) {
                return;
            }
            if (str == null || !str.equals(this.x)) {
                this.l = str;
                this.p = true;
            }
        }

        public boolean c() {
            String p = a.this.axM.p("cache.dat", true);
            if (TextUtils.isEmpty(p)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(p);
                this.r = jSONObject.optString("form_id");
                this.o = jSONObject.getLong("lst_fe_ts");
                this.v = jSONObject.getInt("c_form_ver");
                this.aym.P(jSONObject.getLong("flags"));
                this.s = jSONObject.optInt("init_res");
                this.w = jSONObject.optLong("acquire_ts_cost");
                this.x = jSONObject.optString("oid");
                this.ayn.clear();
                JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                if (optJSONObject != null) {
                    int i = optJSONObject.getInt("count");
                    for (int i2 = 0; i2 < i; i2++) {
                        String string = optJSONObject.getString("id_" + i2);
                        if (TextUtils.isEmpty(string)) {
                            this.ayn.clear();
                            return false;
                        }
                        this.ayn.add(string);
                    }
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public void d(String str) {
            if (this.ayn.contains(str)) {
                return;
            }
            this.ayn.add(str);
            this.p = true;
        }

        public boolean d() {
            if (this.p) {
                try {
                    a.this.axM.d("cache.dat", e().toString(), true);
                    this.p = false;
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
            return false;
        }
    }

    /* loaded from: classes18.dex */
    static abstract class c implements IIdentifierListener {
        c() {
        }

        @Override // com.bun.miitmdid.core.IIdentifierListener
        public void OnSupport(boolean z, IdSupplier idSupplier) {
            a(z, idSupplier);
        }

        public abstract void a(boolean z, IdSupplier idSupplier);
    }

    public a() {
        super("oid");
        this.aya = new b();
        this.i = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        for (a.c<String> cVar : this.i) {
            b(cVar);
        }
        this.i.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.c<String> cVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.aya.a())) {
            cVar.a(this.aya.s, null, bundle);
        } else {
            cVar.a(this.aya.a(), bundle);
        }
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        this.axM = this.axB.fB(getName());
        Context context = this.axC.applicationContext;
        final C0156a c0156a = new C0156a();
        this.ayb = c0156a;
        this.aya.c();
        long currentTimeMillis = System.currentTimeMillis();
        if (!bVar.axG && Math.abs(currentTimeMillis - this.aya.b()) <= 604800000) {
            c0156a.d.set(true);
            return;
        }
        this.aya.b(currentTimeMillis);
        this.aya.a(4L, 124L);
        this.aya.c(0L);
        this.aya.d();
        c0156a.f1816a = this.axC.avK.submit(new AnonymousClass2(new Handler(Looper.getMainLooper()) { // from class: com.baidu.helios.ids.c.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    a.this.axC.avJ.submit(new Runnable() { // from class: com.baidu.helios.ids.c.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c0156a.d.get()) {
                                return;
                            }
                            a.this.aya.a(64L, 124L);
                            a.this.aya.d();
                            a.this.a();
                            c0156a.d.set(true);
                        }
                    });
                }
            }
        }, context, c0156a));
    }

    @Override // com.baidu.helios.ids.a
    public void a(final a.c<String> cVar) {
        this.axC.avJ.submit(new Runnable() { // from class: com.baidu.helios.ids.c.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ayb.d.get()) {
                    a.this.b(cVar);
                } else {
                    a.this.i.add(cVar);
                }
            }
        });
    }

    @Override // com.baidu.helios.ids.a
    public String zT() {
        return this.aya.a();
    }
}
