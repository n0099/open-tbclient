package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public static final z f2638a = new z();

    public void a(Context context, JSONObject jSONObject) {
        bb.c().a("startDataAnynalyzed start");
        a(jSONObject);
        y a2 = y.a(context);
        boolean a3 = a2.a();
        bb.c().a("is data collect closed:" + a3);
        if (!a3) {
            if (!k.AP_LIST.b(10000)) {
                c(context);
            }
            String str = android.os.Build.MANUFACTURER;
            int i = Build.VERSION.SDK_INT;
            boolean z = false;
            if (!TextUtils.isEmpty(str) && RomUtils.MANUFACTURER_HUAWEI.equals(str.trim().toLowerCase()) && i >= 28) {
                z = true;
            }
            if (!k.APP_LIST.b(10000) && !z) {
                d(context);
            }
            if (!k.APP_TRACE.b(10000) && !z) {
                e(context);
            }
            if (ab.e && !k.APP_APK.b(10000) && !z) {
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

    private void a(JSONObject jSONObject) {
        ac acVar = new ac(jSONObject);
        ab.b = acVar.f2521a;
        ab.c = acVar.b;
        ab.d = acVar.c;
    }

    private void c(Context context) {
        bb.c().a("collectAPWithStretegy 1");
        y a2 = y.a(context);
        long a3 = a2.a(g.AP_LIST);
        long currentTimeMillis = System.currentTimeMillis();
        long e = a2.e();
        bb.c().a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + e);
        if (a3 == 0 || currentTimeMillis - a3 > e) {
            bb.c().a("collectAPWithStretegy 2");
            c.a(context);
        }
    }

    private void d(Context context) {
        bb.c().a("collectAPPListWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        y a2 = y.a(context);
        long a3 = a2.a(g.APP_USER_LIST);
        long f = a2.f();
        bb.c().a("now time: " + currentTimeMillis + ": last time: " + a3 + "; userInterval : " + f);
        if (a3 == 0 || currentTimeMillis - a3 > f || !a2.a(a3)) {
            bb.c().a("collectUserAPPListWithStretegy 2");
            c.a(context, false);
        }
        long a4 = a2.a(g.APP_SYS_LIST);
        long g = a2.g();
        bb.c().a("now time: " + currentTimeMillis + ": last time: " + a4 + "; sysInterval : " + g);
        if (a4 == 0 || currentTimeMillis - a4 > g) {
            bb.c().a("collectSysAPPListWithStretegy 2");
            c.a(context, true);
        }
    }

    private void e(Context context) {
        bb.c().a("collectAPPTraceWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        y a2 = y.a(context);
        long a3 = a2.a(g.APP_TRACE_HIS);
        long i = a2.i();
        bb.c().a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + i);
        if (a3 == 0 || currentTimeMillis - a3 > i) {
            bb.c().a("collectAPPTraceWithStretegy 2");
            c.b(context, false);
        }
    }

    private void f(Context context) {
        bb.c().a("collectAPKWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        y a2 = y.a(context);
        long a3 = a2.a(g.APP_APK);
        long h = a2.h();
        bb.c().a("now time: " + currentTimeMillis + ": last time: " + a3 + "; interval : " + h);
        if (a3 == 0 || currentTimeMillis - a3 > h) {
            bb.c().a("collectAPKWithStretegy 2");
            c.b(context);
        }
    }

    public void a(Context context, String str) {
        y.a(context).a(str);
    }

    public void b(Context context, String str) {
        y.a(context).b(str);
    }

    public void a(Context context, long j) {
        y.a(context).a(g.LAST_UPDATE, j);
    }

    private void g(Context context) {
        y.a(context).a(g.LAST_SEND, System.currentTimeMillis());
        JSONObject a2 = h.a(context);
        bb.c().a("header: " + a2);
        int i = 0;
        while (a()) {
            int i2 = i + 1;
            if (i > 0) {
                h.c(a2);
            }
            b(context, a2);
            i = i2;
        }
    }

    private boolean a() {
        return (k.AP_LIST.b() && k.APP_LIST.b() && k.APP_TRACE.b() && k.APP_CHANGE.b() && k.APP_APK.b()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073 A[LOOP:0: B:12:0x006d->B:14:0x0073, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cd A[LOOP:1: B:25:0x00c7->B:27:0x00cd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011d A[LOOP:2: B:35:0x0117->B:37:0x011d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016e A[LOOP:3: B:45:0x0168->B:47:0x016e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01c0 A[LOOP:4: B:55:0x01ba->B:57:0x01c0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Context context, JSONObject jSONObject) {
        int i;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        JSONArray jSONArray5;
        int i2 = 0;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(Config.HEADER_PART, jSONObject);
            i2 = 0 + jSONObject.toString().length();
        } catch (JSONException e) {
            bb.c().a(e);
        }
        bb.c().a("APP_MEM");
        try {
            if (!y.a(context).b()) {
                String x = bw.x(context);
                JSONArray jSONArray6 = new JSONArray();
                bb.c().a(x);
                jSONArray6.put(x);
                if (jSONArray6.length() > 0) {
                    try {
                        jSONObject2.put("app_mem3", jSONArray6);
                        i = i2 + jSONArray6.toString().length();
                    } catch (JSONException e2) {
                        bb.c().a(e2);
                    }
                    bb.c().a("APP_APK");
                    List<String> a2 = k.APP_APK.a(20480);
                    jSONArray = new JSONArray();
                    for (String str : a2) {
                        bb.c().a(str);
                        jSONArray.put(str);
                    }
                    if (jSONArray.length() > 0) {
                        try {
                            jSONObject2.put("app_apk3", jSONArray);
                            i += jSONArray.toString().length();
                        } catch (JSONException e3) {
                            bb.c().a(e3);
                        }
                    }
                    bb.c().a("APP_CHANGE");
                    List<String> a3 = k.APP_CHANGE.a(10240);
                    jSONArray2 = new JSONArray();
                    for (String str2 : a3) {
                        bb.c().a(str2);
                        jSONArray2.put(str2);
                    }
                    if (jSONArray2.length() > 0) {
                        try {
                            jSONObject2.put("app_change3", jSONArray2);
                            i += jSONArray2.toString().length();
                        } catch (JSONException e4) {
                            bb.c().a(e4);
                        }
                    }
                    bb.c().a("APP_TRACE");
                    List<String> a4 = k.APP_TRACE.a(15360);
                    jSONArray3 = new JSONArray();
                    for (String str3 : a4) {
                        bb.c().a(str3);
                        jSONArray3.put(str3);
                    }
                    if (jSONArray3.length() > 0) {
                        try {
                            jSONObject2.put("app_trace3", jSONArray3);
                            i += jSONArray3.toString().length();
                        } catch (JSONException e5) {
                            bb.c().a(e5);
                        }
                    }
                    bb.c().a("APP_LIST");
                    List<String> a5 = k.APP_LIST.a(46080);
                    jSONArray4 = new JSONArray();
                    for (String str4 : a5) {
                        bb.c().a(str4);
                        jSONArray4.put(str4);
                    }
                    if (jSONArray4.length() > 0) {
                        try {
                            jSONObject2.put("app_list3", jSONArray4);
                            i += jSONArray4.toString().length();
                        } catch (JSONException e6) {
                            bb.c().a(e6);
                        }
                    }
                    bb.c().a("AP_LIST");
                    List<String> a6 = k.AP_LIST.a(Config.MAX_CACHE_JSON_CAPACITY - i);
                    jSONArray5 = new JSONArray();
                    for (String str5 : a6) {
                        bb.c().a(str5);
                        jSONArray5.put(str5);
                    }
                    if (jSONArray5.length() > 0) {
                        try {
                            jSONObject2.put("ap_list3", jSONArray5);
                            i += jSONArray5.toString().length();
                        } catch (JSONException e7) {
                            bb.c().a(e7);
                        }
                    }
                    bb.c().a("log in bytes is almost :" + i);
                    JSONArray jSONArray7 = new JSONArray();
                    jSONArray7.put(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("payload", jSONArray7);
                    s.a().a(context, jSONObject3.toString());
                    return;
                }
            }
            jSONObject3.put("payload", jSONArray7);
            s.a().a(context, jSONObject3.toString());
            return;
        } catch (Exception e8) {
            bb.c().a(e8);
            return;
        }
        i = i2;
        bb.c().a("APP_APK");
        List<String> a22 = k.APP_APK.a(20480);
        jSONArray = new JSONArray();
        while (r4.hasNext()) {
        }
        if (jSONArray.length() > 0) {
        }
        bb.c().a("APP_CHANGE");
        List<String> a32 = k.APP_CHANGE.a(10240);
        jSONArray2 = new JSONArray();
        while (r4.hasNext()) {
        }
        if (jSONArray2.length() > 0) {
        }
        bb.c().a("APP_TRACE");
        List<String> a42 = k.APP_TRACE.a(15360);
        jSONArray3 = new JSONArray();
        while (r4.hasNext()) {
        }
        if (jSONArray3.length() > 0) {
        }
        bb.c().a("APP_LIST");
        List<String> a52 = k.APP_LIST.a(46080);
        jSONArray4 = new JSONArray();
        while (r4.hasNext()) {
        }
        if (jSONArray4.length() > 0) {
        }
        bb.c().a("AP_LIST");
        List<String> a62 = k.AP_LIST.a(Config.MAX_CACHE_JSON_CAPACITY - i);
        jSONArray5 = new JSONArray();
        while (r4.hasNext()) {
        }
        if (jSONArray5.length() > 0) {
        }
        bb.c().a("log in bytes is almost :" + i);
        JSONArray jSONArray72 = new JSONArray();
        jSONArray72.put(jSONObject2);
        JSONObject jSONObject32 = new JSONObject();
    }

    public boolean a(Context context) {
        if (bw.c().booleanValue()) {
            y a2 = y.a(context);
            long a3 = a2.a(g.LAST_UPDATE);
            long c = a2.c();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a3 > c) {
                bb.c().a("need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c);
                return true;
            }
            bb.c().a("no need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c);
            return false;
        }
        return false;
    }

    public boolean b(Context context) {
        return !y.a(context).a() || a(context);
    }
}
