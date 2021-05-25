package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static y f8869a;

    /* renamed from: b  reason: collision with root package name */
    public Context f8870b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f8871c = new JSONObject();

    /* renamed from: d  reason: collision with root package name */
    public long f8872d = 24;

    /* renamed from: e  reason: collision with root package name */
    public long f8873e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f8874f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f8875g = 0;

    /* renamed from: h  reason: collision with root package name */
    public long f8876h = 5;

    /* renamed from: i  reason: collision with root package name */
    public long f8877i = 24;
    public long j = 15;
    public long k = 15;
    public long l = 30;
    public long m = 12;
    public long n = 1;
    public long o = 24;
    public String p = "";
    public String q = "";

    public y(Context context) {
        this.f8870b = context;
        m();
        j();
        k();
    }

    public static y a(Context context) {
        if (f8869a == null) {
            synchronized (y.class) {
                if (f8869a == null) {
                    f8869a = new y(context);
                }
            }
        }
        return f8869a;
    }

    private void m() {
        String b2 = bo.b("backups/system/.timestamp");
        try {
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            this.f8871c = new JSONObject(b2);
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        return this.f8874f != 0;
    }

    public long c() {
        return this.f8872d * 60 * 60 * 1000;
    }

    public long d() {
        return this.o * 60 * 60 * 1000;
    }

    public long e() {
        return this.f8876h * 60 * 1000;
    }

    public long f() {
        return this.f8877i * 60 * 60 * 1000;
    }

    public long g() {
        return this.j * 24 * 60 * 60 * 1000;
    }

    public long h() {
        return this.k * 24 * 60 * 60 * 1000;
    }

    public long i() {
        return this.m * 60 * 60 * 1000;
    }

    public void j() {
        try {
            String str = new String(bv.b(false, br.a(), bp.a(bo.a(this.f8870b, ".config2").getBytes())));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            try {
                this.f8873e = jSONObject.getLong("c");
            } catch (JSONException e2) {
                bb.c().b(e2);
            }
            try {
                this.f8876h = jSONObject.getLong("d");
            } catch (JSONException e3) {
                bb.c().b(e3);
            }
            try {
                this.f8877i = jSONObject.getLong("e");
            } catch (JSONException e4) {
                bb.c().b(e4);
            }
            try {
                this.j = jSONObject.getLong("i");
            } catch (JSONException e5) {
                bb.c().b(e5);
            }
            try {
                this.f8872d = jSONObject.getLong("f");
            } catch (JSONException e6) {
                bb.c().b(e6);
            }
            try {
                this.o = jSONObject.getLong("s");
            } catch (JSONException e7) {
                bb.c().b(e7);
            }
            try {
                this.k = jSONObject.getLong("pk");
            } catch (JSONException e8) {
                bb.c().b(e8);
            }
            try {
                this.l = jSONObject.getLong("at");
            } catch (JSONException e9) {
                bb.c().b(e9);
            }
            try {
                this.m = jSONObject.getLong("as");
            } catch (JSONException e10) {
                bb.c().b(e10);
            }
            try {
                this.n = jSONObject.getLong("ac");
            } catch (JSONException e11) {
                bb.c().b(e11);
            }
            try {
                this.f8874f = jSONObject.getLong(Config.DEVICE_MAC_ID);
            } catch (JSONException e12) {
                bb.c().b(e12);
            }
            try {
                this.f8875g = jSONObject.getLong("lsc");
            } catch (JSONException e13) {
                bb.c().b(e13);
            }
        } catch (Exception e14) {
            bb.c().b(e14);
        }
    }

    public void k() {
        try {
            String str = new String(bv.b(false, br.a(), bp.a(bo.a(this.f8870b, ".sign").getBytes())));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            try {
                this.q = jSONObject.getString("sign");
            } catch (Exception e2) {
                bb.c().b(e2);
            }
            try {
                this.p = jSONObject.getString("ver");
            } catch (Exception e3) {
                bb.c().b(e3);
            }
        } catch (Exception e4) {
            bb.c().b(e4);
        }
    }

    public boolean l() {
        long currentTimeMillis = System.currentTimeMillis();
        long a2 = a(g.LAST_SEND);
        long d2 = d();
        bb c2 = bb.c();
        c2.a("canSend now=" + currentTimeMillis + ";lastSendTime=" + a2 + ";sendLogTimeInterval=" + d2);
        return currentTimeMillis - a2 > d2 || !a(a2);
    }

    public void b(String str) {
        bo.a(this.f8870b, ".sign", str, false);
        k();
    }

    public String c(String str) {
        return (TextUtils.isEmpty(this.p) || !this.p.equals(str) || TextUtils.isEmpty(this.q)) ? "" : this.q;
    }

    private long b(long j) {
        if (j - System.currentTimeMillis() > 0) {
            return 0L;
        }
        return j;
    }

    public boolean a() {
        return this.f8873e != 0;
    }

    public void a(String str) {
        bo.a(this.f8870b, ".config2", str, false);
        j();
    }

    public long a(g gVar) {
        long j = gVar.j;
        try {
            String str = gVar.toString();
            if (this.f8871c.has(str)) {
                j = this.f8871c.getLong(str);
            }
        } catch (Exception e2) {
            bb.c().a(e2);
        }
        return b(j);
    }

    public void a(g gVar, long j) {
        gVar.j = j;
        try {
            this.f8871c.put(gVar.toString(), j);
        } catch (Exception e2) {
            bb.c().a(e2);
        }
        try {
            bo.a("backups/system/.timestamp", this.f8871c.toString(), false);
        } catch (Exception e3) {
            bb.c().a(e3);
        }
    }

    public boolean a(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(Long.valueOf(j)).equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
    }
}
