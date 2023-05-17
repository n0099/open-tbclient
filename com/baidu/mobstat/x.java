package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x {
    public static final x a = new x();
    public Handler b = new Handler();
    public boolean c = false;
    public int d = 0;

    private void a(JSONObject jSONObject) {
        aa aaVar = new aa(jSONObject);
        z.b = aaVar.a;
        z.c = aaVar.b;
        z.d = aaVar.c;
    }

    private boolean h(Context context) {
        if (!k.AP_LIST.b(context) || !k.APP_LIST.b(context) || !k.APP_TRACE.b(context) || !k.APP_CHANGE.b(context) || !k.APP_APK.b(context)) {
            return true;
        }
        return false;
    }

    public boolean b(Context context) {
        if (w.a(context).a() && !a(context)) {
            return false;
        }
        return true;
    }

    private void b(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        int i = 0;
        try {
            jSONObject.put("detector_count", this.d);
            jSONObject2.put(Config.HEADER_PART, jSONObject);
            i = 0 + jSONObject.toString().length();
        } catch (JSONException e) {
            ba.c().a(e);
        }
        ba.c().a("APP_MEM");
        if (!w.a(context).b()) {
            String v = bw.v(context);
            JSONArray jSONArray = new JSONArray();
            ba.c().a(v);
            jSONArray.put(v);
            if (jSONArray.length() > 0) {
                try {
                    jSONObject2.put("app_mem3", jSONArray);
                    i += jSONArray.toString().length();
                } catch (JSONException e2) {
                    ba.c().a(e2);
                }
            }
        }
        ba.c().a("APP_APK");
        List<String> a2 = k.APP_APK.a(context, 20480);
        JSONArray jSONArray2 = new JSONArray();
        for (String str : a2) {
            ba.c().a(str);
            jSONArray2.put(str);
        }
        if (jSONArray2.length() > 0) {
            try {
                jSONObject2.put("app_apk3", jSONArray2);
                i += jSONArray2.toString().length();
            } catch (JSONException e3) {
                ba.c().a(e3);
            }
        }
        ba.c().a("APP_CHANGE");
        List<String> a3 = k.APP_CHANGE.a(context, 10240);
        JSONArray jSONArray3 = new JSONArray();
        for (String str2 : a3) {
            ba.c().a(str2);
            jSONArray3.put(str2);
        }
        if (jSONArray3.length() > 0) {
            try {
                jSONObject2.put("app_change3", jSONArray3);
                i += jSONArray3.toString().length();
            } catch (JSONException e4) {
                ba.c().a(e4);
            }
        }
        ba.c().a("APP_TRACE");
        List<String> a4 = k.APP_TRACE.a(context, 15360);
        JSONArray jSONArray4 = new JSONArray();
        for (String str3 : a4) {
            ba.c().a(str3);
            jSONArray4.put(str3);
        }
        if (jSONArray4.length() > 0) {
            try {
                jSONObject2.put("app_trace3", jSONArray4);
                i += jSONArray4.toString().length();
            } catch (JSONException e5) {
                ba.c().a(e5);
            }
        }
        ba.c().a("APP_LIST");
        List<String> a5 = k.APP_LIST.a(context, 46080);
        JSONArray jSONArray5 = new JSONArray();
        for (String str4 : a5) {
            ba.c().a(str4);
            jSONArray5.put(str4);
        }
        if (jSONArray5.length() > 0) {
            try {
                jSONObject2.put("app_list3", jSONArray5);
                i += jSONArray5.toString().length();
            } catch (JSONException e6) {
                ba.c().a(e6);
            }
        }
        ba.c().a("AP_LIST");
        List<String> a6 = k.AP_LIST.a(context, 184320 - i);
        JSONArray jSONArray6 = new JSONArray();
        for (String str5 : a6) {
            ba.c().a(str5);
            jSONArray6.put(str5);
        }
        if (jSONArray6.length() > 0) {
            try {
                jSONObject2.put("ap_list3", jSONArray6);
                i += jSONArray6.toString().length();
            } catch (JSONException e7) {
                ba.c().a(e7);
            }
        }
        ba c = ba.c();
        c.a("log in bytes is almost :" + i);
        JSONArray jSONArray7 = new JSONArray();
        jSONArray7.put(jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("payload", jSONArray7);
            r.a().a(context, jSONObject3.toString());
        } catch (Exception e8) {
            ba.c().a(e8);
        }
    }

    private void c(Context context) {
        ba.c().a("collectAPWithStretegy 1");
        w a2 = w.a(context);
        long a3 = a2.a(g.AP_LIST);
        long currentTimeMillis = System.currentTimeMillis();
        long e = a2.e();
        ba c = ba.c();
        c.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + e);
        if (a3 == 0 || currentTimeMillis - a3 > e) {
            ba.c().a("collectAPWithStretegy 2");
            c.a(context);
        }
    }

    private void e(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        w a2 = w.a(context);
        long a3 = a2.a(g.APP_TRACE_HIS);
        long i = a2.i();
        ba c = ba.c();
        c.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + i);
        if (a3 == 0 || currentTimeMillis - a3 > i) {
            ba.c().a("collectAPPTraceWithStretegy 2");
            c.b(context, false);
        }
    }

    private void f(Context context) {
        ba.c().a("collectAPKWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        w a2 = w.a(context);
        long a3 = a2.a(g.APP_APK);
        long h = a2.h();
        ba c = ba.c();
        c.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; interval : " + h);
        if (a3 == 0 || currentTimeMillis - a3 > h) {
            ba.c().a("collectAPKWithStretegy 2");
            c.b(context);
        }
    }

    private void d(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        w a2 = w.a(context);
        long a3 = a2.a(g.APP_USER_LIST);
        long f = a2.f();
        ba c = ba.c();
        c.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; userInterval : " + f);
        if (a3 == 0 || currentTimeMillis - a3 > f || !a2.a(a3)) {
            ba.c().a("collectUserAPPListWithStretegy 1");
            c.a(context, false);
        }
        long a4 = a2.a(g.APP_SYS_LIST);
        long g = a2.g();
        ba c2 = ba.c();
        c2.a("now time: " + currentTimeMillis + ": last time: " + a4 + "; sysInterval : " + g);
        if (a4 == 0 || currentTimeMillis - a4 > g) {
            ba.c().a("collectSysAPPListWithStretegy 2");
            c.a(context, true);
        }
    }

    private void g(Context context) {
        w.a(context).a(g.LAST_SEND, System.currentTimeMillis());
        JSONObject a2 = h.a(context);
        ba c = ba.c();
        c.a("header: " + a2);
        int i = 0;
        while (h(context)) {
            int i2 = i + 1;
            if (i > 0) {
                h.c(a2);
            }
            b(context, a2);
            i = i2;
        }
    }

    public void a(Context context, long j) {
        w.a(context).a(g.LAST_UPDATE, j);
    }

    public void b(Context context, String str) {
        w.a(context).b(str);
    }

    public void a(Context context, String str) {
        w.a(context).a(str);
    }

    public void a(Context context, JSONObject jSONObject) {
        int i;
        boolean z = true;
        if (bp.a().y(context) != 0) {
            i = bp.a().y(context) + 1;
        } else {
            i = 0;
        }
        this.d = i;
        ba.c().a("startDataAnynalyzed start");
        a(jSONObject);
        w a2 = w.a(context);
        boolean a3 = a2.a();
        ba c = ba.c();
        c.a("is data collect closed:" + a3);
        if (!a3) {
            if (!k.AP_LIST.b(context, 10000)) {
                c(context);
            }
            String str = android.os.Build.MANUFACTURER;
            z = (TextUtils.isEmpty(str) || !RomUtils.MANUFACTURER_HUAWEI.equals(str.trim().toLowerCase()) || Build.VERSION.SDK_INT < 28) ? false : false;
            if (!k.APP_LIST.b(context, 10000) && !z) {
                d(context);
            }
            if (!k.APP_TRACE.b(context, 10000) && !z) {
                e(context);
            }
            if (z.e && !k.APP_APK.b(context, 10000) && !z) {
                f(context);
            }
            boolean o = bw.o(context);
            if (o && a2.l()) {
                ba.c().a("sendLog");
                g(context);
            } else if (!o) {
                ba.c().a("isWifiAvailable = false, will not sendLog");
            } else {
                ba.c().a("can not sendLog due to time stratergy");
            }
        }
        ba.c().a("startDataAnynalyzed finished");
    }

    public boolean a(Context context) {
        if (!bw.c().booleanValue()) {
            return false;
        }
        w a2 = w.a(context);
        long a3 = a2.a(g.LAST_UPDATE);
        long c = a2.c();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a3 > c) {
            ba c2 = ba.c();
            c2.a("need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c);
            return true;
        }
        ba c3 = ba.c();
        c3.a("no need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c);
        return false;
    }
}
