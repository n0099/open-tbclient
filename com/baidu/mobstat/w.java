package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class w {
    public static w a;
    public Context b;
    public JSONObject c = new JSONObject();
    public long d = 24;
    public long e = 0;
    public long f = 0;
    public long g = 0;
    public long h = 5;
    public long i = 24;
    public long j = 15;
    public long k = 15;
    public long l = 30;
    public long m = 12;
    public long n = 1;
    public long o = 24;
    public String p = "";
    public String q = "";

    public w(Context context) {
        this.b = context;
        m();
        j();
        k();
    }

    public static w a(Context context) {
        if (a == null) {
            synchronized (w.class) {
                if (a == null) {
                    a = new w(context);
                }
            }
        }
        return a;
    }

    private long b(long j) {
        if (j - System.currentTimeMillis() > 0) {
            return 0L;
        }
        return j;
    }

    private void m() {
        String a2 = bn.a(this.b, y.d);
        try {
            if (!TextUtils.isEmpty(a2)) {
                this.c = new JSONObject(a2);
            }
        } catch (Exception unused) {
        }
    }

    public boolean a() {
        if (this.e != 0) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f != 0) {
            return true;
        }
        return false;
    }

    public long c() {
        return this.d * 60 * 60 * 1000;
    }

    public long d() {
        return this.o * 60 * 60 * 1000;
    }

    public long e() {
        return this.h * 60 * 1000;
    }

    public long f() {
        return this.i * 60 * 60 * 1000;
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

    public long a(g gVar) {
        long j = gVar.j;
        try {
            String str = gVar.toString();
            if (this.c.has(str)) {
                j = this.c.getLong(str);
            }
        } catch (Exception e) {
            ba.c().a(e);
        }
        return b(j);
    }

    public void b(String str) {
        bn.a(this.b, ".sign", str, false);
        k();
    }

    public void a(g gVar, long j) {
        gVar.j = j;
        try {
            this.c.put(gVar.toString(), j);
        } catch (Exception e) {
            ba.c().a(e);
        }
        try {
            bn.a(this.b, y.d, this.c.toString(), false);
        } catch (Exception e2) {
            ba.c().a(e2);
        }
    }

    public void a(String str) {
        bn.a(this.b, ".config2", str, false);
        j();
    }

    public boolean a(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(Long.valueOf(j)).equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
    }

    public void j() {
        try {
            String str = new String(bv.b(false, bq.a(), bo.a(bn.a(this.b, ".config2").getBytes())));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            try {
                this.e = jSONObject.getLong("c");
            } catch (JSONException e) {
                ba.c().b(e);
            }
            try {
                this.h = jSONObject.getLong("d");
            } catch (JSONException e2) {
                ba.c().b(e2);
            }
            try {
                this.i = jSONObject.getLong("e");
            } catch (JSONException e3) {
                ba.c().b(e3);
            }
            try {
                this.j = jSONObject.getLong("i");
            } catch (JSONException e4) {
                ba.c().b(e4);
            }
            try {
                this.d = jSONObject.getLong("f");
            } catch (JSONException e5) {
                ba.c().b(e5);
            }
            try {
                this.o = jSONObject.getLong("s");
            } catch (JSONException e6) {
                ba.c().b(e6);
            }
            try {
                this.k = jSONObject.getLong(PushConstants.URI_PACKAGE_NAME);
            } catch (JSONException e7) {
                ba.c().b(e7);
            }
            try {
                this.l = jSONObject.getLong("at");
            } catch (JSONException e8) {
                ba.c().b(e8);
            }
            try {
                this.m = jSONObject.getLong("as");
            } catch (JSONException e9) {
                ba.c().b(e9);
            }
            try {
                this.n = jSONObject.getLong("ac");
            } catch (JSONException e10) {
                ba.c().b(e10);
            }
            try {
                this.f = jSONObject.getLong(Config.DEVICE_MAC_ID);
            } catch (JSONException e11) {
                ba.c().b(e11);
            }
            try {
                this.g = jSONObject.getLong("lsc");
            } catch (JSONException e12) {
                ba.c().b(e12);
            }
        } catch (Exception e13) {
            ba.c().b(e13);
        }
    }

    public void k() {
        try {
            String str = new String(bv.b(false, bq.a(), bo.a(bn.a(this.b, ".sign").getBytes())));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            try {
                this.q = jSONObject.getString("sign");
            } catch (Exception e) {
                ba.c().b(e);
            }
            try {
                this.p = jSONObject.getString("ver");
            } catch (Exception e2) {
                ba.c().b(e2);
            }
        } catch (Exception e3) {
            ba.c().b(e3);
        }
    }

    public boolean l() {
        long currentTimeMillis = System.currentTimeMillis();
        long a2 = a(g.LAST_SEND);
        long d = d();
        ba c = ba.c();
        c.a("canSend now=" + currentTimeMillis + ";lastSendTime=" + a2 + ";sendLogTimeInterval=" + d);
        if (currentTimeMillis - a2 <= d && a(a2)) {
            return false;
        }
        return true;
    }
}
