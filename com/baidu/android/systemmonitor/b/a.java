package com.baidu.android.systemmonitor.b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.nebula.util.BDLocationManager;
import com.baidu.android.systemmonitor.a.a.h;
import com.baidu.android.systemmonitor.a.a.o;
import com.baidu.android.systemmonitor.d.e;
import com.baidu.android.systemmonitor.d.m;
import com.baidu.android.systemmonitor.devicestatistic.a.f;
import com.baidu.zeus.Headers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f658a = null;
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
            if (f658a == null) {
                f658a = new a(context);
            }
            aVar = f658a;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(ArrayList arrayList, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("commonprams", a());
            JSONObject jSONObject2 = new JSONObject();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                switch (c.f660a[((h) it.next()).ordinal()]) {
                    case 1:
                        jSONObject2.put("apptrace", d());
                        break;
                    case 2:
                        jSONObject2.put("appchange", c());
                        break;
                    case 3:
                        jSONObject2.put("event_active", b());
                        break;
                    case 4:
                        jSONObject2.put("operationevent_power", d(j));
                        break;
                    case 5:
                        jSONObject2.put("operationevent_charge", c(j));
                        break;
                    case 6:
                        jSONObject2.put("storeinformation", b(j));
                        break;
                    case 7:
                        jSONObject2.put("operationevent_network", a(j));
                        break;
                    case 8:
                        jSONObject2.put("operationevent_apkdownload", e(j));
                        break;
                }
            }
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e) {
        }
        String str = null;
        try {
            str = com.baidu.android.systemmonitor.security.a.a(jSONObject.toString());
        } catch (Exception e2) {
        }
        return com.baidu.android.systemmonitor.a.c.a(str.getBytes());
    }

    public static void g() {
        if (f658a != null) {
            f658a.f();
            f658a = null;
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
                jSONObject.put("stopstamp", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).f683a / 1000));
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
                jSONObject.put("phonecontactsnum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).f680a));
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
        String a2 = com.baidu.android.systemmonitor.a.b.a(this.b);
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
            jSONObject.put("imei", com.baidu.android.systemmonitor.a.d.c(this.b));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("osversion", Build.VERSION.RELEASE);
            jSONObject.put("pix", com.baidu.android.systemmonitor.a.d.e(this.b));
            jSONObject.put("basebandversion", com.baidu.android.systemmonitor.a.d.h());
            jSONObject.put("kernelversion", com.baidu.android.systemmonitor.a.d.g());
            jSONObject.put("operator", com.baidu.android.systemmonitor.a.d.d(this.b));
            jSONObject.put(Headers.LOCATION, BDLocationManager.c(this.b.getApplicationContext()));
            jSONObject.put("nettype", String.valueOf(com.baidu.android.systemmonitor.a.d.b(this.b)));
            jSONObject.put("ip", com.baidu.android.systemmonitor.a.d.d());
        } catch (JSONException e3) {
        }
        try {
            com.baidu.android.systemmonitor.a.b.a(this.b, com.baidu.android.systemmonitor.security.a.a(jSONObject.toString()));
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
                com.baidu.android.systemmonitor.d.d dVar = (com.baidu.android.systemmonitor.d.d) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event", String.valueOf(dVar.c));
                jSONObject.put("packagename", dVar.f668a);
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
                jSONObject.put(Headers.LOCATION, ((com.baidu.android.systemmonitor.devicestatistic.a.e) fVar).f684a);
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
                jSONObject.put("stopstamp", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.c) fVar).f682a / 1000));
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
            for (m mVar : c.values()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appname", mVar.b);
                jSONObject2.put("issysapp", String.valueOf(mVar.e));
                jSONObject2.put("install", String.valueOf(mVar.o));
                jSONObject2.put("signmd5", mVar.t);
                jSONObject2.put("apkmd5", mVar.u);
                if (mVar.f != null && mVar.f.length() > 0) {
                    jSONObject2.put("vername", mVar.f);
                }
                if (mVar.g > 0) {
                    jSONObject2.put("vercode", String.valueOf(mVar.g));
                }
                if (mVar.n.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('[');
                    Iterator it = mVar.n.iterator();
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
                if (mVar.r.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('[');
                    Iterator it2 = mVar.r.iterator();
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
                if (mVar.q.size() > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append('[');
                    Iterator it3 = mVar.q.iterator();
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
                if (mVar.s.size() > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append('[');
                    Iterator it4 = mVar.s.iterator();
                    while (it4.hasNext()) {
                        sb4.append(((Integer) it4.next()).intValue());
                        sb4.append(',');
                    }
                    sb4.deleteCharAt(sb4.length() - 1);
                    sb4.append(']');
                    jSONObject2.put("nettypedata", sb4.toString());
                }
                if (mVar.p.size() > 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append('[');
                    Iterator it5 = mVar.p.iterator();
                    while (it5.hasNext()) {
                        sb5.append((Long) it5.next());
                        sb5.append(',');
                    }
                    sb5.deleteCharAt(sb5.length() - 1);
                    sb5.append(']');
                    jSONObject2.put("netflowdata", sb5.toString());
                }
                jSONObject.put(mVar.c, jSONObject2);
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
                jSONObject.put("downloadpath", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) fVar).f681a));
                jSONObject.put("apkname", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) fVar).b));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public void e() {
        new com.baidu.android.systemmonitor.a.a.e(this.b).a();
        if (o.a(this.b).a()) {
            ArrayList arrayList = new ArrayList();
            if (!com.baidu.android.systemmonitor.a.b.b(this.b)) {
                arrayList.add(h.ACTIVE_EVENT);
            }
            arrayList.add(h.FREQ_STATISTIC);
            arrayList.add(h.APPCHANGE_STATISTIC);
            a(arrayList);
            this.c.postDelayed(this.d, 30000L);
        }
    }

    public void f() {
    }
}
