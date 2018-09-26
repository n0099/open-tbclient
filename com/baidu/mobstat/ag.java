package com.baidu.mobstat;

import android.content.Context;
import com.baidu.ar.audio.AudioParams;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ag {
    public static final ag a = new ag();

    public void a(Context context, JSONObject jSONObject) {
        bi.c().a("startDataAnynalyzed start");
        a(jSONObject);
        af a2 = af.a(context);
        boolean a3 = a2.a();
        bi.c().a("is data collect closed:" + a3);
        if (!a3) {
            if (!r.AP_LIST.b(10000)) {
                c(context);
            }
            if (!r.APP_LIST.b(10000)) {
                d(context);
            }
            if (!r.APP_TRACE.b(10000)) {
                e(context);
            }
            if (ai.e && !r.APP_APK.b(10000)) {
                f(context);
            }
            boolean q = cc.q(context);
            if (q && a2.l()) {
                bi.c().a("sendLog");
                g(context);
            } else if (!q) {
                bi.c().a("isWifiAvailable = false, will not sendLog");
            } else {
                bi.c().a("can not sendLog due to time stratergy");
            }
        }
        bi.c().a("startDataAnynalyzed finished");
    }

    private void a(JSONObject jSONObject) {
        aj ajVar = new aj(jSONObject);
        ai.b = ajVar.a;
        ai.c = ajVar.b;
        ai.d = ajVar.c;
    }

    private void c(Context context) {
        bi.c().a("collectAPWithStretegy 1");
        af a2 = af.a(context);
        long a3 = a2.a(n.AP_LIST);
        long currentTimeMillis = System.currentTimeMillis();
        long e = a2.e();
        bi.c().a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + e);
        if (a3 == 0 || currentTimeMillis - a3 > e) {
            bi.c().a("collectAPWithStretegy 2");
            j.a(context);
        }
    }

    private void d(Context context) {
        bi.c().a("collectAPPListWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        af a2 = af.a(context);
        long a3 = a2.a(n.APP_USER_LIST);
        long f = a2.f();
        bi.c().a("now time: " + currentTimeMillis + ": last time: " + a3 + "; userInterval : " + f);
        if (a3 == 0 || currentTimeMillis - a3 > f || !a2.a(a3)) {
            bi.c().a("collectUserAPPListWithStretegy 2");
            j.a(context, false);
        }
        long a4 = a2.a(n.APP_SYS_LIST);
        long g = a2.g();
        bi.c().a("now time: " + currentTimeMillis + ": last time: " + a4 + "; sysInterval : " + g);
        if (a4 == 0 || currentTimeMillis - a4 > g) {
            bi.c().a("collectSysAPPListWithStretegy 2");
            j.a(context, true);
        }
    }

    private void e(Context context) {
        bi.c().a("collectAPPTraceWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        af a2 = af.a(context);
        long a3 = a2.a(n.APP_TRACE_HIS);
        long i = a2.i();
        bi.c().a("now time: " + currentTimeMillis + ": last time: " + a3 + "; time interval: " + i);
        if (a3 == 0 || currentTimeMillis - a3 > i) {
            bi.c().a("collectAPPTraceWithStretegy 2");
            j.b(context, false);
        }
    }

    private void f(Context context) {
        bi.c().a("collectAPKWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        af a2 = af.a(context);
        long a3 = a2.a(n.APP_APK);
        long h = a2.h();
        bi.c().a("now time: " + currentTimeMillis + ": last time: " + a3 + "; interval : " + h);
        if (a3 == 0 || currentTimeMillis - a3 > h) {
            bi.c().a("collectAPKWithStretegy 2");
            j.b(context);
        }
    }

    public void a(Context context, String str) {
        af.a(context).a(str);
    }

    public void b(Context context, String str) {
        af.a(context).b(str);
    }

    public void a(Context context, long j) {
        af.a(context).a(n.LAST_UPDATE, j);
    }

    private void g(Context context) {
        af.a(context).a(n.LAST_SEND, System.currentTimeMillis());
        JSONObject a2 = o.a(context);
        bi.c().a("header: " + a2);
        int i = 0;
        while (a()) {
            int i2 = i + 1;
            if (i > 0) {
                o.c(a2);
            }
            b(context, a2);
            i = i2;
        }
    }

    private boolean a() {
        return (r.AP_LIST.b() && r.APP_LIST.b() && r.APP_TRACE.b() && r.APP_CHANGE.b() && r.APP_APK.b()) ? false : true;
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
            bi.c().a(e);
        }
        bi.c().a("APP_MEM");
        try {
            if (!af.a(context).b()) {
                String x = cc.x(context);
                JSONArray jSONArray6 = new JSONArray();
                bi.c().a(x);
                jSONArray6.put(x);
                if (jSONArray6.length() > 0) {
                    try {
                        jSONObject2.put("app_mem3", jSONArray6);
                        i = i2 + jSONArray6.toString().length();
                    } catch (JSONException e2) {
                        bi.c().a(e2);
                    }
                    bi.c().a("APP_APK");
                    List<String> a2 = r.APP_APK.a(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
                    jSONArray = new JSONArray();
                    for (String str : a2) {
                        bi.c().a(str);
                        jSONArray.put(str);
                    }
                    if (jSONArray.length() > 0) {
                        try {
                            jSONObject2.put("app_apk3", jSONArray);
                            i += jSONArray.toString().length();
                        } catch (JSONException e3) {
                            bi.c().a(e3);
                        }
                    }
                    bi.c().a("APP_CHANGE");
                    List<String> a3 = r.APP_CHANGE.a(10240);
                    jSONArray2 = new JSONArray();
                    for (String str2 : a3) {
                        bi.c().a(str2);
                        jSONArray2.put(str2);
                    }
                    if (jSONArray2.length() > 0) {
                        try {
                            jSONObject2.put("app_change3", jSONArray2);
                            i += jSONArray2.toString().length();
                        } catch (JSONException e4) {
                            bi.c().a(e4);
                        }
                    }
                    bi.c().a("APP_TRACE");
                    List<String> a4 = r.APP_TRACE.a(15360);
                    jSONArray3 = new JSONArray();
                    for (String str3 : a4) {
                        bi.c().a(str3);
                        jSONArray3.put(str3);
                    }
                    if (jSONArray3.length() > 0) {
                        try {
                            jSONObject2.put("app_trace3", jSONArray3);
                            i += jSONArray3.toString().length();
                        } catch (JSONException e5) {
                            bi.c().a(e5);
                        }
                    }
                    bi.c().a("APP_LIST");
                    List<String> a5 = r.APP_LIST.a(46080);
                    jSONArray4 = new JSONArray();
                    for (String str4 : a5) {
                        bi.c().a(str4);
                        jSONArray4.put(str4);
                    }
                    if (jSONArray4.length() > 0) {
                        try {
                            jSONObject2.put("app_list3", jSONArray4);
                            i += jSONArray4.toString().length();
                        } catch (JSONException e6) {
                            bi.c().a(e6);
                        }
                    }
                    bi.c().a("AP_LIST");
                    List<String> a6 = r.AP_LIST.a(Config.MAX_CACHE_JSON_CAPACITY - i);
                    jSONArray5 = new JSONArray();
                    for (String str5 : a6) {
                        bi.c().a(str5);
                        jSONArray5.put(str5);
                    }
                    if (jSONArray5.length() > 0) {
                        try {
                            jSONObject2.put("ap_list3", jSONArray5);
                            i += jSONArray5.toString().length();
                        } catch (JSONException e7) {
                            bi.c().a(e7);
                        }
                    }
                    bi.c().a("log in bytes is almost :" + i);
                    JSONArray jSONArray7 = new JSONArray();
                    jSONArray7.put(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("payload", jSONArray7);
                    z.a().a(context, jSONObject3.toString());
                    return;
                }
            }
            jSONObject3.put("payload", jSONArray7);
            z.a().a(context, jSONObject3.toString());
            return;
        } catch (Exception e8) {
            bi.c().a(e8);
            return;
        }
        i = i2;
        bi.c().a("APP_APK");
        List<String> a22 = r.APP_APK.a(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
        jSONArray = new JSONArray();
        while (r4.hasNext()) {
        }
        if (jSONArray.length() > 0) {
        }
        bi.c().a("APP_CHANGE");
        List<String> a32 = r.APP_CHANGE.a(10240);
        jSONArray2 = new JSONArray();
        while (r4.hasNext()) {
        }
        if (jSONArray2.length() > 0) {
        }
        bi.c().a("APP_TRACE");
        List<String> a42 = r.APP_TRACE.a(15360);
        jSONArray3 = new JSONArray();
        while (r4.hasNext()) {
        }
        if (jSONArray3.length() > 0) {
        }
        bi.c().a("APP_LIST");
        List<String> a52 = r.APP_LIST.a(46080);
        jSONArray4 = new JSONArray();
        while (r4.hasNext()) {
        }
        if (jSONArray4.length() > 0) {
        }
        bi.c().a("AP_LIST");
        List<String> a62 = r.AP_LIST.a(Config.MAX_CACHE_JSON_CAPACITY - i);
        jSONArray5 = new JSONArray();
        while (r4.hasNext()) {
        }
        if (jSONArray5.length() > 0) {
        }
        bi.c().a("log in bytes is almost :" + i);
        JSONArray jSONArray72 = new JSONArray();
        jSONArray72.put(jSONObject2);
        JSONObject jSONObject32 = new JSONObject();
    }

    public boolean a(Context context) {
        af a2 = af.a(context);
        long a3 = a2.a(n.LAST_UPDATE);
        long c = a2.c();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a3 > c) {
            bi.c().a("need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c);
            return true;
        }
        bi.c().a("no need to update, checkWithLastUpdateTime lastUpdateTime =" + a3 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c);
        return false;
    }

    public boolean b(Context context) {
        return !af.a(context).a() || a(context);
    }
}
