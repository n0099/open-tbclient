package com.baidu.android.systemmonitor.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.a.j;
import com.baidu.android.a.n;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.nebula.cmd.m;
import com.baidu.android.nebula.util.BDLocationManager;
import com.baidu.android.systemmonitor.devicestatistic.a.f;
import com.baidu.android.systemmonitor.freqstatistic.e;
import com.baidu.android.systemmonitor.freqstatistic.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    private static a a = null;
    private Context b;
    private Handler c = new Handler();
    private Runnable d = new d(this);

    private a(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a(context);
            }
            aVar = a;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(ArrayList arrayList, long j) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("commonprams", a());
            JSONObject jSONObject2 = new JSONObject();
            boolean z2 = false;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                switch (c.a[((n) it.next()).ordinal()]) {
                    case 1:
                        jSONObject2.put("apptrace", d());
                        z = z2;
                        break;
                    case 2:
                        jSONObject2.put("appchange", c());
                        z = z2;
                        break;
                    case 3:
                        jSONObject2.put("event_active", b());
                        z = z2;
                        break;
                    case 4:
                        jSONObject2.put("operationevent_power", d(j));
                        z = z2;
                        break;
                    case 5:
                        jSONObject2.put("operationevent_charge", c(j));
                        z = z2;
                        break;
                    case 6:
                        jSONObject2.put("storeinformation", b(j));
                        z = z2;
                        break;
                    case 7:
                        jSONObject2.put("operationevent_network", a(j));
                        z = z2;
                        break;
                    case 8:
                        jSONObject2.put("operationevent_apkdownload", e(j));
                        z = z2;
                        break;
                    case 9:
                        z = true;
                        break;
                    default:
                        z = z2;
                        break;
                }
                z2 = z;
            }
            if (z2) {
                jSONObject.put("logtype", "inapppv");
                jSONObject.put("data", m.a().b());
            } else {
                jSONObject.put("data", jSONObject2);
            }
        } catch (JSONException e) {
        }
        String str = null;
        try {
            str = com.baidu.android.systemmonitor.security.a.a(jSONObject.toString());
        } catch (Exception e2) {
        }
        return com.baidu.android.systemmonitor.c.c.a(str.getBytes());
    }

    public static void g() {
        if (a != null) {
            a.f();
            a = null;
        }
    }

    public JSONArray a(long j) {
        JSONArray jSONArray = new JSONArray();
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.d.a(this.b).a(3, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(fVar.n / 1000));
                jSONObject.put("stopstamp", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).a / 1000));
                jSONObject.put("netflow", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).c));
                jSONObject.put("nettype", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).b));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vername", com.baidu.android.nebula.util.d.a(this.b).c());
            jSONObject.put("appname", com.baidu.android.nebula.util.d.a(this.b).b());
            jSONObject.put("appid", com.baidu.android.nebula.util.d.a(this.b).a());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void a(ArrayList arrayList) {
        new b(this, arrayList, System.currentTimeMillis()).start();
    }

    public JSONArray b(long j) {
        JSONArray jSONArray = new JSONArray();
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.d.a(this.b).a(4, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(fVar.n / 1000));
                jSONObject.put("phonecontactsnum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).a));
                jSONObject.put("simcontactsnum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).b));
                jSONObject.put("smsnum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).c));
                jSONObject.put("smsinfo", ((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).d);
                jSONObject.put("calllognum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).e));
                jSONObject.put("callloginfo", ((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).f);
                jSONObject.put("sdcardfreeall", ((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).g);
                jSONObject.put("phonefreeall", ((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).h);
                jSONObject.put("phonephotonum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).i));
                jSONObject.put("sdcardphotonum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).j));
                jSONObject.put("phonemp3num", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).k));
                jSONObject.put("sdcardmp3num", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).l));
                jSONObject.put("sdcardtvnum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).m));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public JSONObject b() {
        String a2 = com.baidu.android.systemmonitor.c.b.a(this.b);
        if (!TextUtils.isEmpty(a2)) {
            try {
                return new JSONObject(com.baidu.android.systemmonitor.security.a.b(a2));
            } catch (JSONException e) {
            } catch (Exception e2) {
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("activetime", String.valueOf(System.currentTimeMillis() / 1000));
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("deviceid", DeviceId.getDeviceID(this.b));
            jSONObject.put("imei", com.baidu.android.systemmonitor.c.d.c(this.b));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("osversion", Build.VERSION.RELEASE);
            jSONObject.put("pix", com.baidu.android.systemmonitor.c.d.e(this.b));
            jSONObject.put("basebandversion", com.baidu.android.systemmonitor.c.d.h());
            jSONObject.put("kernelversion", com.baidu.android.systemmonitor.c.d.g());
            jSONObject.put("operator", com.baidu.android.systemmonitor.c.d.d(this.b));
            jSONObject.put("location", BDLocationManager.c(this.b.getApplicationContext()));
            jSONObject.put("nettype", String.valueOf(com.baidu.android.systemmonitor.c.d.b(this.b)));
            jSONObject.put("ip", com.baidu.android.systemmonitor.c.d.d());
        } catch (JSONException e3) {
        }
        try {
            com.baidu.android.systemmonitor.c.b.a(this.b, com.baidu.android.systemmonitor.security.a.a(jSONObject.toString()));
            return jSONObject;
        } catch (Exception e4) {
            return jSONObject;
        }
    }

    public JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        ArrayList f = e.a(this.b).f();
        try {
            new JSONObject();
            Iterator it = f.iterator();
            while (it.hasNext()) {
                com.baidu.android.systemmonitor.freqstatistic.d dVar = (com.baidu.android.systemmonitor.freqstatistic.d) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event", String.valueOf(dVar.c));
                jSONObject.put("packagename", dVar.a);
                jSONObject.put("appname", dVar.h);
                jSONObject.put("time", String.valueOf(dVar.b / 1000));
                if (dVar.c == 1) {
                    jSONObject.put("vercodebefore", String.valueOf(dVar.e));
                    jSONObject.put("vernamebefore", dVar.d);
                    jSONObject.put("vercodeafter", String.valueOf(dVar.g));
                    jSONObject.put("vernameafter", dVar.f);
                } else {
                    jSONObject.put("vercode", String.valueOf(dVar.e));
                    jSONObject.put("vername", dVar.d);
                }
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public JSONArray c(long j) {
        JSONArray jSONArray = new JSONArray();
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.d.a(this.b).a(2, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(fVar.n / 1000));
                jSONObject.put("stopstamp", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.e) fVar).e / 1000));
                jSONObject.put("type", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.e) fVar).f));
                jSONObject.put("startlevel", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.e) fVar).b));
                jSONObject.put("stoplevel", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.e) fVar).c));
                jSONObject.put("nettype", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.e) fVar).d));
                jSONObject.put("location", ((com.baidu.android.systemmonitor.devicestatistic.a.e) fVar).a);
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public JSONArray d(long j) {
        JSONArray jSONArray = new JSONArray();
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.d.a(this.b).a(1, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(fVar.n / 1000));
                jSONObject.put("stopstamp", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.c) fVar).a / 1000));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public JSONObject d() {
        System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap c = e.a(this.b).c();
            new JSONObject();
            for (k kVar : c.values()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appname", kVar.b);
                jSONObject2.put("issysapp", String.valueOf(kVar.e));
                jSONObject2.put("install", String.valueOf(kVar.o));
                jSONObject2.put("signmd5", kVar.t);
                jSONObject2.put("apkmd5", kVar.u);
                if (kVar.f != null && kVar.f.length() > 0) {
                    jSONObject2.put("vername", kVar.f);
                }
                if (kVar.g > 0) {
                    jSONObject2.put("vercode", String.valueOf(kVar.g));
                }
                if (kVar.n.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('[');
                    Iterator it = kVar.n.iterator();
                    while (it.hasNext()) {
                        long[] jArr = (long[]) it.next();
                        sb.append(jArr[0]);
                        sb.append('@');
                        sb.append(jArr[1]);
                        sb.append(',');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(']');
                    jSONObject2.put("tracedata", sb.toString());
                }
                if (kVar.r.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('[');
                    Iterator it2 = kVar.r.iterator();
                    while (it2.hasNext()) {
                        int[] iArr = (int[]) it2.next();
                        sb2.append(iArr[0]);
                        sb2.append('@');
                        sb2.append(iArr[1]);
                        sb2.append(',');
                    }
                    sb2.deleteCharAt(sb2.length() - 1);
                    sb2.append(']');
                    jSONObject2.put("powerdata", sb2.toString());
                }
                if (kVar.q.size() > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append('[');
                    Iterator it3 = kVar.q.iterator();
                    while (it3.hasNext()) {
                        sb3.append((String) it3.next());
                        sb3.append(',');
                    }
                    if (sb3.length() > 1) {
                        sb3.deleteCharAt(sb3.length() - 1);
                        sb3.append(']');
                        jSONObject2.put("locationdata", sb3.toString());
                    }
                }
                if (kVar.s.size() > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append('[');
                    Iterator it4 = kVar.s.iterator();
                    while (it4.hasNext()) {
                        sb4.append(((Integer) it4.next()).intValue());
                        sb4.append(',');
                    }
                    sb4.deleteCharAt(sb4.length() - 1);
                    sb4.append(']');
                    jSONObject2.put("nettypedata", sb4.toString());
                }
                if (kVar.p.size() > 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append('[');
                    Iterator it5 = kVar.p.iterator();
                    while (it5.hasNext()) {
                        sb5.append((Long) it5.next());
                        sb5.append(',');
                    }
                    sb5.deleteCharAt(sb5.length() - 1);
                    sb5.append(']');
                    jSONObject2.put("netflowdata", sb5.toString());
                }
                jSONObject.put(kVar.c, jSONObject2);
            }
        } catch (OutOfMemoryError e) {
        } catch (JSONException e2) {
        }
        return jSONObject;
    }

    public JSONArray e(long j) {
        JSONArray jSONArray = new JSONArray();
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.d.a(this.b).a(5, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(fVar.n / 1000));
                jSONObject.put("downloadpath", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) fVar).a));
                jSONObject.put("apkname", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) fVar).b));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public void e() {
        new com.baidu.android.a.e(this.b).a();
        if (j.a(this.b).a()) {
            ArrayList arrayList = new ArrayList();
            if (!com.baidu.android.systemmonitor.c.b.b(this.b)) {
                arrayList.add(n.ACTIVE_EVENT);
            }
            arrayList.add(n.FREQ_STATISTIC);
            arrayList.add(n.APPCHANGE_STATISTIC);
            a(arrayList);
        }
        this.c.postDelayed(this.d, 30000L);
    }

    public void f() {
    }
}
