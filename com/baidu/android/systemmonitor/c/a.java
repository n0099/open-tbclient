package com.baidu.android.systemmonitor.c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.nebula.util.BDLocationManager;
import com.baidu.android.nebula.util.e;
import com.baidu.android.systemmonitor.d.a.k;
import com.baidu.android.systemmonitor.d.a.l;
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
    private static a f679a = null;
    private Context b;
    private Handler c = new Handler();
    private Runnable d = new b(this);

    private a(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f679a == null) {
                f679a = new a(context);
            }
            aVar = f679a;
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
                switch (c.f681a[((l) it.next()).ordinal()]) {
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
        return com.baidu.android.systemmonitor.d.a.a(str.getBytes());
    }

    public static void g() {
        if (f679a != null) {
            f679a.f();
            f679a = null;
        }
    }

    public JSONArray a(long j) {
        JSONArray jSONArray = new JSONArray();
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.d.a(this.b).a(3, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                com.baidu.android.systemmonitor.devicestatistic.a.c cVar = (com.baidu.android.systemmonitor.devicestatistic.a.c) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(cVar.g / 1000));
                jSONObject.put("stopstamp", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) cVar).f703a / 1000));
                jSONObject.put("netflow", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) cVar).c));
                jSONObject.put("nettype", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) cVar).b));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vername", e.a(this.b).c());
            jSONObject.put("appname", e.a(this.b).b());
            jSONObject.put("appid", e.a(this.b).a());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void a(ArrayList arrayList) {
        new d(this, arrayList, System.currentTimeMillis()).start();
    }

    public JSONArray b(long j) {
        JSONArray jSONArray = new JSONArray();
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.d.a(this.b).a(4, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                com.baidu.android.systemmonitor.devicestatistic.a.c cVar = (com.baidu.android.systemmonitor.devicestatistic.a.c) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(cVar.g / 1000));
                jSONObject.put("phonecontactsnum", String.valueOf(((f) cVar).f705a));
                jSONObject.put("simcontactsnum", String.valueOf(((f) cVar).b));
                jSONObject.put("smsnum", String.valueOf(((f) cVar).c));
                jSONObject.put("smsinfo", ((f) cVar).d);
                jSONObject.put("calllognum", String.valueOf(((f) cVar).e));
                jSONObject.put("callloginfo", ((f) cVar).f);
                jSONObject.put("sdcardfreeall", ((f) cVar).i);
                jSONObject.put("phonefreeall", ((f) cVar).j);
                jSONObject.put("phonephotonum", String.valueOf(((f) cVar).k));
                jSONObject.put("sdcardphotonum", String.valueOf(((f) cVar).l));
                jSONObject.put("phonemp3num", String.valueOf(((f) cVar).m));
                jSONObject.put("sdcardmp3num", String.valueOf(((f) cVar).n));
                jSONObject.put("sdcardtvnum", String.valueOf(((f) cVar).o));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public JSONObject b() {
        String a2 = com.baidu.android.systemmonitor.d.b.a(this.b);
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
            jSONObject.put("imei", com.baidu.android.systemmonitor.d.c.c(this.b));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("osversion", Build.VERSION.RELEASE);
            jSONObject.put("pix", com.baidu.android.systemmonitor.d.c.e(this.b));
            jSONObject.put("basebandversion", com.baidu.android.systemmonitor.d.c.h());
            jSONObject.put("kernelversion", com.baidu.android.systemmonitor.d.c.g());
            jSONObject.put("operator", com.baidu.android.systemmonitor.d.c.d(this.b));
            jSONObject.put(Headers.LOCATION, BDLocationManager.c(this.b.getApplicationContext()));
            jSONObject.put("nettype", String.valueOf(com.baidu.android.systemmonitor.d.c.b(this.b)));
            jSONObject.put("ip", com.baidu.android.systemmonitor.d.c.d());
        } catch (JSONException e3) {
        }
        try {
            com.baidu.android.systemmonitor.d.b.a(this.b, com.baidu.android.systemmonitor.security.a.a(jSONObject.toString()));
            return jSONObject;
        } catch (Exception e4) {
            return jSONObject;
        }
    }

    public JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        ArrayList f = com.baidu.android.systemmonitor.b.d.a(this.b).f();
        try {
            new JSONObject();
            Iterator it = f.iterator();
            while (it.hasNext()) {
                com.baidu.android.systemmonitor.b.a aVar = (com.baidu.android.systemmonitor.b.a) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event", String.valueOf(aVar.c));
                jSONObject.put("packagename", aVar.f664a);
                jSONObject.put("appname", aVar.h);
                jSONObject.put("time", String.valueOf(aVar.b / 1000));
                if (aVar.c == 1) {
                    jSONObject.put("vercodebefore", String.valueOf(aVar.e));
                    jSONObject.put("vernamebefore", aVar.d);
                    jSONObject.put("vercodeafter", String.valueOf(aVar.g));
                    jSONObject.put("vernameafter", aVar.f);
                } else {
                    jSONObject.put("vercode", String.valueOf(aVar.e));
                    jSONObject.put("vername", aVar.d);
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
                com.baidu.android.systemmonitor.devicestatistic.a.c cVar = (com.baidu.android.systemmonitor.devicestatistic.a.c) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(cVar.g / 1000));
                jSONObject.put("stopstamp", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).e / 1000));
                jSONObject.put("type", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).f));
                jSONObject.put("startlevel", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).b));
                jSONObject.put("stoplevel", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).c));
                jSONObject.put("nettype", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).d));
                jSONObject.put(Headers.LOCATION, ((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).f702a);
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
                com.baidu.android.systemmonitor.devicestatistic.a.c cVar = (com.baidu.android.systemmonitor.devicestatistic.a.c) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(cVar.g / 1000));
                jSONObject.put("stopstamp", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.e) cVar).f704a / 1000));
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
            HashMap c = com.baidu.android.systemmonitor.b.d.a(this.b).c();
            new JSONObject();
            for (com.baidu.android.systemmonitor.b.b bVar : c.values()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appname", bVar.b);
                jSONObject2.put("issysapp", String.valueOf(bVar.e));
                jSONObject2.put("install", String.valueOf(bVar.o));
                jSONObject2.put("signmd5", bVar.t);
                jSONObject2.put("apkmd5", bVar.u);
                if (bVar.f != null && bVar.f.length() > 0) {
                    jSONObject2.put("vername", bVar.f);
                }
                if (bVar.g > 0) {
                    jSONObject2.put("vercode", String.valueOf(bVar.g));
                }
                if (bVar.n.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('[');
                    Iterator it = bVar.n.iterator();
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
                if (bVar.r.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('[');
                    Iterator it2 = bVar.r.iterator();
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
                if (bVar.q.size() > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append('[');
                    Iterator it3 = bVar.q.iterator();
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
                if (bVar.s.size() > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append('[');
                    Iterator it4 = bVar.s.iterator();
                    while (it4.hasNext()) {
                        sb4.append(((Integer) it4.next()).intValue());
                        sb4.append(',');
                    }
                    sb4.deleteCharAt(sb4.length() - 1);
                    sb4.append(']');
                    jSONObject2.put("nettypedata", sb4.toString());
                }
                if (bVar.p.size() > 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append('[');
                    Iterator it5 = bVar.p.iterator();
                    while (it5.hasNext()) {
                        sb5.append((Long) it5.next());
                        sb5.append(',');
                    }
                    sb5.deleteCharAt(sb5.length() - 1);
                    sb5.append(']');
                    jSONObject2.put("netflowdata", sb5.toString());
                }
                jSONObject.put(bVar.c, jSONObject2);
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
                com.baidu.android.systemmonitor.devicestatistic.a.c cVar = (com.baidu.android.systemmonitor.devicestatistic.a.c) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(cVar.g / 1000));
                jSONObject.put("downloadpath", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) cVar).f701a));
                jSONObject.put("apkname", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) cVar).b));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public void e() {
        new com.baidu.android.systemmonitor.d.a.d(this.b).a();
        if (k.a(this.b).a()) {
            ArrayList arrayList = new ArrayList();
            if (!com.baidu.android.systemmonitor.d.b.b(this.b)) {
                arrayList.add(l.ACTIVE_EVENT);
            }
            arrayList.add(l.FREQ_STATISTIC);
            arrayList.add(l.APPCHANGE_STATISTIC);
            a(arrayList);
            this.c.postDelayed(this.d, 30000L);
        }
    }

    public void f() {
    }
}
