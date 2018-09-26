package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class af {
    private static af a;
    private Context b;
    private JSONObject c = new JSONObject();
    private long d = 24;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private long h = 5;
    private long i = 24;
    private long j = 15;
    private long k = 15;
    private long l = 30;
    private long m = 12;
    private long n = 1;
    private long o = 24;
    private String p = "";
    private String q = "";

    public static af a(Context context) {
        if (a == null) {
            synchronized (af.class) {
                if (a == null) {
                    a = new af(context);
                }
            }
        }
        return a;
    }

    private af(Context context) {
        this.b = context;
        m();
        j();
        k();
    }

    private void m() {
        String b = bv.b("backups/system/.timestamp");
        try {
            if (!TextUtils.isEmpty(b)) {
                this.c = new JSONObject(b);
            }
        } catch (Exception e) {
        }
    }

    public boolean a() {
        return this.e != 0;
    }

    public boolean b() {
        return this.f != 0;
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

    public void j() {
        try {
            String str = new String(cb.b(false, bx.a(), bw.a(bv.a(this.b, ".config2").getBytes())));
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.e = jSONObject.getLong("c");
                } catch (JSONException e) {
                    bi.c().b(e);
                }
                try {
                    this.h = jSONObject.getLong("d");
                } catch (JSONException e2) {
                    bi.c().b(e2);
                }
                try {
                    this.i = jSONObject.getLong("e");
                } catch (JSONException e3) {
                    bi.c().b(e3);
                }
                try {
                    this.j = jSONObject.getLong("i");
                } catch (JSONException e4) {
                    bi.c().b(e4);
                }
                try {
                    this.d = jSONObject.getLong("f");
                } catch (JSONException e5) {
                    bi.c().b(e5);
                }
                try {
                    this.o = jSONObject.getLong("s");
                } catch (JSONException e6) {
                    bi.c().b(e6);
                }
                try {
                    this.k = jSONObject.getLong(PushConstants.URI_PACKAGE_NAME);
                } catch (JSONException e7) {
                    bi.c().b(e7);
                }
                try {
                    this.l = jSONObject.getLong("at");
                } catch (JSONException e8) {
                    bi.c().b(e8);
                }
                try {
                    this.m = jSONObject.getLong(AdvanceSetting.ADVANCE_SETTING);
                } catch (JSONException e9) {
                    bi.c().b(e9);
                }
                try {
                    this.n = jSONObject.getLong("ac");
                } catch (JSONException e10) {
                    bi.c().b(e10);
                }
                try {
                    this.f = jSONObject.getLong(Config.DEVICE_MAC_ID);
                } catch (JSONException e11) {
                    bi.c().b(e11);
                }
                try {
                    this.g = jSONObject.getLong("lsc");
                } catch (JSONException e12) {
                    bi.c().b(e12);
                }
            }
        } catch (Exception e13) {
            bi.c().b(e13);
        }
    }

    public void k() {
        try {
            String str = new String(cb.b(false, bx.a(), bw.a(bv.a(this.b, ".sign").getBytes())));
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.q = jSONObject.getString("sign");
                } catch (Exception e) {
                    bi.c().b(e);
                }
                try {
                    this.p = jSONObject.getString("ver");
                } catch (Exception e2) {
                    bi.c().b(e2);
                }
            }
        } catch (Exception e3) {
            bi.c().b(e3);
        }
    }

    public void a(String str) {
        bv.a(this.b, ".config2", str, false);
        j();
    }

    public void b(String str) {
        bv.a(this.b, ".sign", str, false);
        k();
    }

    public String c(String str) {
        return (TextUtils.isEmpty(this.p) || !this.p.equals(str) || TextUtils.isEmpty(this.q)) ? "" : this.q;
    }

    public long a(n nVar) {
        long j = nVar.j;
        try {
            String nVar2 = nVar.toString();
            if (this.c.has(nVar2)) {
                j = this.c.getLong(nVar2);
            }
        } catch (Exception e) {
            bi.c().a(e);
        }
        return b(j);
    }

    public void a(n nVar, long j) {
        nVar.j = j;
        try {
            this.c.put(nVar.toString(), j);
        } catch (Exception e) {
            bi.c().a(e);
        }
        try {
            bv.a("backups/system/.timestamp", this.c.toString(), false);
        } catch (Exception e2) {
            bi.c().a(e2);
        }
    }

    public boolean l() {
        long currentTimeMillis = System.currentTimeMillis();
        long a2 = a(n.LAST_SEND);
        long d = d();
        bi.c().a("canSend now=" + currentTimeMillis + ";lastSendTime=" + a2 + ";sendLogTimeInterval=" + d);
        return currentTimeMillis - a2 > d || !a(a2);
    }

    public boolean a(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(Long.valueOf(j)).equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
    }

    private long b(long j) {
        if (j - System.currentTimeMillis() > 0) {
            return 0L;
        }
        return j;
    }
}
