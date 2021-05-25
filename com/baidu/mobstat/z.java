package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public static final z f8878a = new z();

    private void c(Context context) {
        bb.c().a("collectAPWithStretegy 1");
        y a2 = y.a(context);
        long a3 = a2.a(g.AP_LIST);
        long currentTimeMillis = System.currentTimeMillis();
        long e2 = a2.e();
        bb c2 = bb.c();
        c2.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + e2);
        if (a3 == 0 || currentTimeMillis - a3 > e2) {
            bb.c().a("collectAPWithStretegy 2");
            c.a(context);
        }
    }

    private void d(Context context) {
        bb.c().a("collectAPPListWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        y a2 = y.a(context);
        long a3 = a2.a(g.APP_USER_LIST);
        long f2 = a2.f();
        bb c2 = bb.c();
        c2.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; userInterval : " + f2);
        if (a3 == 0 || currentTimeMillis - a3 > f2 || !a2.a(a3)) {
            bb.c().a("collectUserAPPListWithStretegy 2");
            c.a(context, false);
        }
        long a4 = a2.a(g.APP_SYS_LIST);
        long g2 = a2.g();
        bb c3 = bb.c();
        c3.a("now time: " + currentTimeMillis + ": last time: " + a4 + "; sysInterval : " + g2);
        if (a4 == 0 || currentTimeMillis - a4 > g2) {
            bb.c().a("collectSysAPPListWithStretegy 2");
            c.a(context, true);
        }
    }

    private void e(Context context) {
        bb.c().a("collectAPPTraceWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        y a2 = y.a(context);
        long a3 = a2.a(g.APP_TRACE_HIS);
        long i2 = a2.i();
        bb c2 = bb.c();
        c2.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + i2);
        if (a3 == 0 || currentTimeMillis - a3 > i2) {
            bb.c().a("collectAPPTraceWithStretegy 2");
            c.b(context, false);
        }
    }

    private void f(Context context) {
        bb.c().a("collectAPKWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        y a2 = y.a(context);
        long a3 = a2.a(g.APP_APK);
        long h2 = a2.h();
        bb c2 = bb.c();
        c2.a("now time: " + currentTimeMillis + ": last time: " + a3 + "; interval : " + h2);
        if (a3 == 0 || currentTimeMillis - a3 > h2) {
            bb.c().a("collectAPKWithStretegy 2");
            c.b(context);
        }
    }

    private void g(Context context) {
        y.a(context).a(g.LAST_SEND, System.currentTimeMillis());
        JSONObject a2 = h.a(context);
        bb c2 = bb.c();
        c2.a("header: " + a2);
        int i2 = 0;
        while (a()) {
            int i3 = i2 + 1;
            if (i2 > 0) {
                h.c(a2);
            }
            b(context, a2);
            i2 = i3;
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        bb.c().a("startDataAnynalyzed start");
        a(jSONObject);
        y a2 = y.a(context);
        boolean a3 = a2.a();
        bb c2 = bb.c();
        c2.a("is data collect closed:" + a3);
        if (!a3) {
            if (!k.AP_LIST.b(10000)) {
                c(context);
            }
            String str = android.os.Build.MANUFACTURER;
            int i2 = Build.VERSION.SDK_INT;
            boolean z = false;
            if (!TextUtils.isEmpty(str) && RomUtils.MANUFACTURER_HUAWEI.equals(str.trim().toLowerCase()) && i2 >= 28) {
                z = true;
            }
            if (!k.APP_LIST.b(10000) && !z) {
                d(context);
            }
            if (!k.APP_TRACE.b(10000) && !z) {
                e(context);
            }
            if (ab.f8467e && !k.APP_APK.b(10000) && !z) {
                f(context);
            }
            boolean q = bw.q(context);
            if (q && a2.l()) {
                bb.c().a("sendLog");
                g(context);
            } else if (!q) {
                bb.c().a("isWifiAvailable = false, will not sendLog");
            } else {
                bb.c().a("can not sendLog due to time stratergy");
            }
        }
        bb.c().a("startDataAnynalyzed finished");
    }

    public void b(Context context, String str) {
        y.a(context).b(str);
    }

    private void b(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 0;
        try {
            jSONObject2.put(Config.HEADER_PART, jSONObject);
            i2 = 0 + jSONObject.toString().length();
        } catch (JSONException e2) {
            bb.c().a(e2);
        }
        bb.c().a("APP_MEM");
        if (!y.a(context).b()) {
            String x = bw.x(context);
            JSONArray jSONArray = new JSONArray();
            bb.c().a(x);
            jSONArray.put(x);
            if (jSONArray.length() > 0) {
                try {
                    jSONObject2.put("app_mem3", jSONArray);
                    i2 += jSONArray.toString().length();
                } catch (JSONException e3) {
                    bb.c().a(e3);
                }
            }
        }
        bb.c().a("APP_APK");
        List<String> a2 = k.APP_APK.a(LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA);
        JSONArray jSONArray2 = new JSONArray();
        for (String str : a2) {
            bb.c().a(str);
            jSONArray2.put(str);
        }
        if (jSONArray2.length() > 0) {
            try {
                jSONObject2.put("app_apk3", jSONArray2);
                i2 += jSONArray2.toString().length();
            } catch (JSONException e4) {
                bb.c().a(e4);
            }
        }
        bb.c().a("APP_CHANGE");
        List<String> a3 = k.APP_CHANGE.a(10240);
        JSONArray jSONArray3 = new JSONArray();
        for (String str2 : a3) {
            bb.c().a(str2);
            jSONArray3.put(str2);
        }
        if (jSONArray3.length() > 0) {
            try {
                jSONObject2.put("app_change3", jSONArray3);
                i2 += jSONArray3.toString().length();
            } catch (JSONException e5) {
                bb.c().a(e5);
            }
        }
        bb.c().a("APP_TRACE");
        List<String> a4 = k.APP_TRACE.a(15360);
        JSONArray jSONArray4 = new JSONArray();
        for (String str3 : a4) {
            bb.c().a(str3);
            jSONArray4.put(str3);
        }
        if (jSONArray4.length() > 0) {
            try {
                jSONObject2.put("app_trace3", jSONArray4);
                i2 += jSONArray4.toString().length();
            } catch (JSONException e6) {
                bb.c().a(e6);
            }
        }
        bb.c().a("APP_LIST");
        List<String> a5 = k.APP_LIST.a(46080);
        JSONArray jSONArray5 = new JSONArray();
        for (String str4 : a5) {
            bb.c().a(str4);
            jSONArray5.put(str4);
        }
        if (jSONArray5.length() > 0) {
            try {
                jSONObject2.put("app_list3", jSONArray5);
                i2 += jSONArray5.toString().length();
            } catch (JSONException e7) {
                bb.c().a(e7);
            }
        }
        bb.c().a("AP_LIST");
        List<String> a6 = k.AP_LIST.a(Config.MAX_CACHE_JSON_CAPACITY - i2);
        JSONArray jSONArray6 = new JSONArray();
        for (String str5 : a6) {
            bb.c().a(str5);
            jSONArray6.put(str5);
        }
        if (jSONArray6.length() > 0) {
            try {
                jSONObject2.put("ap_list3", jSONArray6);
                i2 += jSONArray6.toString().length();
            } catch (JSONException e8) {
                bb.c().a(e8);
            }
        }
        bb c2 = bb.c();
        c2.a("log in bytes is almost :" + i2);
        JSONArray jSONArray7 = new JSONArray();
        jSONArray7.put(jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("payload", jSONArray7);
            s.a().a(context, jSONObject3.toString());
        } catch (Exception e9) {
            bb.c().a(e9);
        }
    }

    private void a(JSONObject jSONObject) {
        ac acVar = new ac(jSONObject);
        ab.f8464b = acVar.f8468a;
        ab.f8465c = acVar.f8469b;
        ab.f8466d = acVar.f8470c;
    }

    public void a(Context context, String str) {
        y.a(context).a(str);
    }

    public void a(Context context, long j) {
        y.a(context).a(g.LAST_UPDATE, j);
    }

    private boolean a() {
        return (k.AP_LIST.b() && k.APP_LIST.b() && k.APP_TRACE.b() && k.APP_CHANGE.b() && k.APP_APK.b()) ? false : true;
    }

    public boolean a(Context context) {
        if (bw.c().booleanValue()) {
            y a2 = y.a(context);
            long a3 = a2.a(g.LAST_UPDATE);
            long c2 = a2.c();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a3 > c2) {
                bb c3 = bb.c();
                c3.a("need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c2);
                return true;
            }
            bb c4 = bb.c();
            c4.a("no need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c2);
            return false;
        }
        return false;
    }

    public boolean b(Context context) {
        return !y.a(context).a() || a(context);
    }
}
