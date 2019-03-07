package cn.jiguang.a.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.d.d.aa;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class b {
    private static final String a = b.class.getSimpleName();

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r10v3 long)] */
    public static JSONObject a(Context context) {
        JSONObject a2;
        try {
            JSONObject jSONObject = new JSONObject();
            String a3 = cn.jiguang.g.a.a();
            String a4 = cn.jiguang.g.a.a(context);
            String format = String.format(Locale.ENGLISH, "%.1f", Double.valueOf(cn.jiguang.g.a.as(context)));
            String str = Build.VERSION.RELEASE;
            String format2 = String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
            String locale = context.getResources().getConfiguration().locale.toString();
            String b = cn.jiguang.g.a.b(cn.jiguang.d.a.d, "");
            String format3 = String.format(Locale.ENGLISH, Build.MANUFACTURER, new Object[0]);
            long rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            String sb = rawOffset > 0 ? "+" + rawOffset : rawOffset < 0 ? Constants.ACCEPT_TIME_SEPARATOR_SERVER + rawOffset : new StringBuilder().append(rawOffset).toString();
            if (cn.jiguang.g.i.a(a3)) {
                a3 = "";
            }
            jSONObject.put("cpu_info", a3);
            if (cn.jiguang.g.i.a(a4)) {
                a4 = "";
            }
            jSONObject.put("resolution", a4);
            if (cn.jiguang.g.i.a(str)) {
                str = "";
            }
            jSONObject.put("os_version", str);
            if (cn.jiguang.g.i.a(locale)) {
                locale = "";
            }
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, locale);
            if (cn.jiguang.g.i.a(sb)) {
                sb = "";
            }
            jSONObject.put("timezone", sb);
            if (cn.jiguang.g.i.a(format2)) {
                format2 = "";
            }
            jSONObject.put("model", format2);
            if (cn.jiguang.g.i.a(format)) {
                format = "";
            }
            jSONObject.put("screensize", format);
            if (cn.jiguang.g.i.a(b)) {
                b = "";
            }
            jSONObject.put("mac", b);
            if (cn.jiguang.g.i.a(format3)) {
                format3 = "";
            }
            jSONObject.put("manufacturer", format3);
            ArrayList<cn.jiguang.g.c.a> a5 = cn.jiguang.g.c.b.a(context.getApplicationContext());
            JSONArray jSONArray = new JSONArray();
            if (a5 != null) {
                Iterator<cn.jiguang.g.c.a> it = a5.iterator();
                while (it.hasNext()) {
                    cn.jiguang.g.c.a next = it.next();
                    if (next != null && (a2 = next.a()) != null) {
                        jSONArray.put(a2);
                    }
                }
            }
            jSONObject.put("sim_slots", jSONArray);
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    public static JSONObject a(Context context, cn.jiguang.d.h.e eVar) {
        JSONObject a2;
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<cn.jiguang.g.c.a> a3 = cn.jiguang.g.c.b.a(context.getApplicationContext());
            JSONArray jSONArray = new JSONArray();
            if (a3 != null) {
                Iterator<cn.jiguang.g.c.a> it = a3.iterator();
                while (it.hasNext()) {
                    cn.jiguang.g.c.a next = it.next();
                    if (next != null && (a2 = next.a()) != null) {
                        jSONArray.put(a2);
                    }
                }
            }
            jSONObject.put("sim_slots", jSONArray);
            jSONObject.put("pkgname", context.getPackageName());
            jSONObject.put("appkey", cn.jiguang.d.a.b(context));
            jSONObject.put("platform", 0);
            jSONObject.put("apkversion", eVar.a);
            jSONObject.put("systemversion", eVar.b);
            jSONObject.put("modelnumber", eVar.c);
            jSONObject.put("basebandversion", eVar.d);
            jSONObject.put("buildnumber", eVar.e);
            jSONObject.put(LogBuilder.KEY_CHANNEL, eVar.k);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PushSDKVer", eVar.f);
            jSONObject2.put("StatisticSDKVer", eVar.g);
            jSONObject2.put("ShareSDKVer", eVar.h);
            jSONObject2.put("CoreSDKVer", eVar.i);
            jSONObject.put("sdkver", jSONObject2);
            jSONObject.put("installation", eVar.l);
            jSONObject.put("resolution", eVar.m);
            jSONObject.put("business", (int) eVar.n);
            jSONObject.put("device_id_status", eVar.o);
            jSONObject.put("device_id", eVar.p);
            jSONObject.put("android_id", eVar.q);
            jSONObject.put("mac_address", eVar.r);
            jSONObject.put("serial_number", eVar.s);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("jpush_device_info", 0).edit();
        edit.putString("device_session", str);
        edit.commit();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0038: IGET  (r2v1 java.lang.Object A[REMOVE]) = (r2v0 android.util.Pair<java.lang.String, java.lang.Integer>) android.util.Pair.second java.lang.Object)] */
    public static void b(Context context) {
        JSONObject a2;
        if (cn.jiguang.d.a.d.d(context) && (a2 = a(context)) != null) {
            String jSONObject = a2.toString();
            if (TextUtils.isEmpty(jSONObject)) {
                return;
            }
            StringBuilder append = new StringBuilder().append(jSONObject);
            String H = cn.jiguang.d.a.a.H("");
            String b = cn.jiguang.d.a.b(context);
            Pair<String, Integer> Y = cn.jiguang.d.a.Y(context);
            String str = (String) Y.first;
            String sb = new StringBuilder().append(Y.second).toString();
            String str2 = cn.jiguang.d.a.c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(H);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (TextUtils.isEmpty(b)) {
                b = "";
            }
            sb2.append(b);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb2.append(str);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb2.append(TextUtils.isEmpty(sb) ? "" : sb);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb2.append(TextUtils.isEmpty("1.2.5") ? "" : "1.2.5");
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb2.append(TextUtils.isEmpty("125") ? "" : "125");
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb2.append(TextUtils.isEmpty(str2) ? "" : str2);
            String b2 = cn.jiguang.g.i.b(append.append(sb2.toString()).toString());
            if (b2 == null || TextUtils.equals(b2, context.getSharedPreferences("jpush_device_info", 0).getString("device_session", null))) {
                return;
            }
            try {
                aa.a(context, a2, "device_info");
                aa.a(context, a2, new c(context, b2));
            } catch (Throwable th) {
            }
        }
    }

    public static void b(Context context, cn.jiguang.d.h.e eVar) {
        cn.jiguang.d.a.a.H(context, a(context, eVar).toString());
    }
}
