package com.baidu.android.systemmonitor.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.a.g;
import com.baidu.android.a.s;
import com.baidu.android.nebula.cmd.k;
import com.baidu.android.systemmonitor.util.e;
import com.baidu.android.systemmonitor.util.f;
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
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("commonprams", a());
            JSONObject jSONObject2 = new JSONObject();
            Iterator it = arrayList.iterator();
            boolean z5 = false;
            boolean z6 = false;
            while (it.hasNext()) {
                switch (c.a[((g) it.next()).ordinal()]) {
                    case 1:
                        jSONObject2.put("apptrace", d());
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        break;
                    case 2:
                        jSONObject2.put("appchange", c());
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        break;
                    case 3:
                        jSONObject2.put("event_active", b());
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        break;
                    case 4:
                        jSONObject2.put("operationevent_power", d(j));
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        break;
                    case 5:
                        jSONObject2.put("operationevent_charge", c(j));
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        break;
                    case 6:
                        jSONObject2.put("storeinformation", b(j));
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        break;
                    case 7:
                        jSONObject2.put("operationevent_network", a(j));
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        break;
                    case 8:
                        jSONObject2.put("operationevent_apkdownload", e(j));
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        break;
                    case 9:
                        z = z4;
                        z2 = z5;
                        z3 = true;
                        break;
                    case 10:
                        z = z4;
                        z3 = z6;
                        z2 = true;
                        break;
                    case 11:
                        z = true;
                        z2 = z5;
                        z3 = z6;
                        break;
                    default:
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        break;
                }
                z6 = z3;
                z5 = z2;
                z4 = z;
            }
            if (z6) {
                jSONObject.put("logtype", "inapppv");
                if (k.a().b().length() == 0) {
                    return null;
                }
                jSONObject.put("data", k.a().b());
            } else if (z5) {
                jSONObject.put("logtype", "userlist");
                jSONObject.put("data", h());
            } else if (z4) {
                jSONObject.put("logtype", "localserver");
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", "failed");
                jSONObject3.put("time", System.currentTimeMillis());
                jSONArray.put(jSONObject3);
                jSONObject.put("data", jSONArray);
            } else {
                jSONObject.put("data", jSONObject2);
            }
        } catch (JSONException e) {
        }
        try {
            str = com.baidu.android.systemmonitor.security.a.a(jSONObject.toString());
        } catch (Exception e2) {
            str = null;
        }
        return f.a(str.getBytes());
    }

    public static void g() {
        if (a != null) {
            a.f();
            a = null;
        }
    }

    private JSONArray h() {
        JSONArray jSONArray = new JSONArray();
        try {
            for (ResolveInfo resolveInfo : this.b.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.android.moplus.action.START"), 0)) {
                JSONObject jSONObject = new JSONObject();
                String str = resolveInfo.activityInfo.packageName;
                SharedPreferences sharedPreferences = this.b.createPackageContext(str, 2).getSharedPreferences(str + ".push_sync", 1);
                int i = sharedPreferences.getInt("version", 0);
                long j = sharedPreferences.getLong("priority", 0L);
                jSONObject.put("packageName", str);
                jSONObject.put("verison", i);
                jSONObject.put("priority", j);
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONArray a(long j) {
        JSONArray jSONArray = new JSONArray();
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.g.a(this.b).a(3, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                com.baidu.android.systemmonitor.devicestatistic.a.f fVar = (com.baidu.android.systemmonitor.devicestatistic.a.f) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(fVar.n / 1000));
                jSONObject.put("stopstamp", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.c) fVar).a / 1000));
                jSONObject.put("netflow", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.c) fVar).c));
                jSONObject.put("nettype", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.c) fVar).b));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vername", com.baidu.android.nebula.a.d.a(this.b).c());
            jSONObject.put("appname", com.baidu.android.nebula.a.d.a(this.b).b());
            jSONObject.put("appid", com.baidu.android.nebula.a.d.a(this.b).a());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void a(ArrayList arrayList) {
        new b(this, arrayList, System.currentTimeMillis()).start();
    }

    public JSONArray b(long j) {
        JSONArray jSONArray = new JSONArray();
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.g.a(this.b).a(4, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                com.baidu.android.systemmonitor.devicestatistic.a.f fVar = (com.baidu.android.systemmonitor.devicestatistic.a.f) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(fVar.n / 1000));
                jSONObject.put("phonecontactsnum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).a));
                jSONObject.put("simcontactsnum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).b));
                jSONObject.put("smsnum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).c));
                jSONObject.put("smsinfo", ((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).d);
                jSONObject.put("calllognum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).e));
                jSONObject.put("callloginfo", ((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).f);
                jSONObject.put("sdcardfreeall", ((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).g);
                jSONObject.put("phonefreeall", ((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).h);
                jSONObject.put("phonephotonum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).i));
                jSONObject.put("sdcardphotonum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).j));
                jSONObject.put("phonemp3num", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).k));
                jSONObject.put("sdcardmp3num", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).l));
                jSONObject.put("sdcardtvnum", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) fVar).m));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public JSONObject b() {
        String a2 = e.a(this.b);
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
            jSONObject.put("deviceid", com.baidu.android.nebula.a.b.a(this.b));
            jSONObject.put("imei", com.baidu.android.systemmonitor.util.b.c(this.b));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("osversion", Build.VERSION.RELEASE);
            jSONObject.put("pix", com.baidu.android.systemmonitor.util.b.e(this.b));
            jSONObject.put("basebandversion", com.baidu.android.systemmonitor.util.b.h());
            jSONObject.put("kernelversion", com.baidu.android.systemmonitor.util.b.g());
            jSONObject.put("operator", com.baidu.android.systemmonitor.util.b.d(this.b));
            jSONObject.put("location", com.baidu.android.nebula.a.e.a(this.b).c());
            jSONObject.put("nettype", String.valueOf(com.baidu.android.systemmonitor.util.b.b(this.b)));
            jSONObject.put("ip", com.baidu.android.systemmonitor.util.b.d());
        } catch (JSONException e3) {
        }
        try {
            e.a(this.b, com.baidu.android.systemmonitor.security.a.a(jSONObject.toString()));
            return jSONObject;
        } catch (Exception e4) {
            return jSONObject;
        }
    }

    public JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        ArrayList f = com.baidu.android.systemmonitor.freqstatistic.c.a(this.b).f();
        try {
            new JSONObject();
            Iterator it = f.iterator();
            while (it.hasNext()) {
                com.baidu.android.systemmonitor.freqstatistic.e eVar = (com.baidu.android.systemmonitor.freqstatistic.e) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event", String.valueOf(eVar.c));
                jSONObject.put("packagename", eVar.a);
                jSONObject.put("appname", eVar.h);
                jSONObject.put("time", String.valueOf(eVar.b / 1000));
                if (eVar.c == 1) {
                    jSONObject.put("vercodebefore", String.valueOf(eVar.e));
                    jSONObject.put("vernamebefore", eVar.d);
                    jSONObject.put("vercodeafter", String.valueOf(eVar.g));
                    jSONObject.put("vernameafter", eVar.f);
                } else {
                    jSONObject.put("vercode", String.valueOf(eVar.e));
                    jSONObject.put("vername", eVar.d);
                }
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public JSONArray c(long j) {
        JSONArray jSONArray = new JSONArray();
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.g.a(this.b).a(2, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                com.baidu.android.systemmonitor.devicestatistic.a.f fVar = (com.baidu.android.systemmonitor.devicestatistic.a.f) it.next();
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
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.g.a(this.b).a(1, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                com.baidu.android.systemmonitor.devicestatistic.a.f fVar = (com.baidu.android.systemmonitor.devicestatistic.a.f) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(fVar.n / 1000));
                jSONObject.put("stopstamp", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) fVar).a / 1000));
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
            HashMap c = com.baidu.android.systemmonitor.freqstatistic.c.a(this.b).c();
            new JSONObject();
            for (com.baidu.android.systemmonitor.freqstatistic.k kVar : c.values()) {
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
        ArrayList a2 = com.baidu.android.systemmonitor.devicestatistic.g.a(this.b).a(5, j);
        try {
            new JSONObject();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                com.baidu.android.systemmonitor.devicestatistic.a.f fVar = (com.baidu.android.systemmonitor.devicestatistic.a.f) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startstamp", String.valueOf(fVar.n / 1000));
                jSONObject.put("downloadpath", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).a));
                jSONObject.put("apkname", String.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.a) fVar).b));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray;
    }

    public void e() {
        new com.baidu.android.a.a(this.b).a();
        if (s.a(this.b).a()) {
            ArrayList arrayList = new ArrayList();
            if (!e.b(this.b)) {
                arrayList.add(g.ACTIVE_EVENT);
            }
            arrayList.add(g.FREQ_STATISTIC);
            arrayList.add(g.APPCHANGE_STATISTIC);
            a(arrayList);
        }
        this.c.postDelayed(this.d, 30000L);
    }

    public void f() {
    }
}
