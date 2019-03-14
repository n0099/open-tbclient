package cn.jiguang.d.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jpush.android.service.PushReceiver;
import com.baidu.mobstat.Config;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.Cipher;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class aa {
    private static String b = "";
    private static String c = "/v3/report";
    public static JSONObject a = null;

    public static JSONObject I(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String g = cn.jiguang.d.h.f.g(cn.jiguang.d.h.f.K(context, str));
            if (cn.jiguang.g.i.a(g)) {
                return null;
            }
            return new JSONObject(g.trim());
        } catch (Throwable th) {
            return null;
        }
    }

    public static int a(Context context, Set<String> set, JSONObject jSONObject, File file) {
        Set<String> d;
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    if (cn.jiguang.g.a.d(context)) {
                        boolean equalsIgnoreCase = "CN".equalsIgnoreCase(cn.jiguang.d.a.lf.a());
                        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
                        if (equalsIgnoreCase && (d = f.bU().ai(context).d(set)) != null) {
                            for (String str : d) {
                                if (!TextUtils.isEmpty(str)) {
                                    linkedHashSet.add(str);
                                }
                            }
                        }
                        String g = cn.jiguang.d.a.lf.g();
                        if (!TextUtils.isEmpty(g)) {
                            linkedHashSet.add("https://" + g);
                        }
                        if (equalsIgnoreCase) {
                            String c2 = cn.jiguang.d.a.d.c();
                            if (!TextUtils.isEmpty(c2)) {
                                linkedHashSet.add("https://" + c2);
                            }
                        }
                        if (linkedHashSet.isEmpty()) {
                            return -1;
                        }
                        new StringBuilder(" type=").append(set);
                        for (String str2 : linkedHashSet) {
                            if (!TextUtils.isEmpty(str2)) {
                                if (!str2.endsWith(c)) {
                                    str2 = str2 + c;
                                }
                                switch (k.a(str2, jSONObject.toString(), context, true, 3, 1).a()) {
                                    case -3:
                                        s.a(context);
                                        return -2;
                                    case 0:
                                        cn.jiguang.d.h.f.a(file);
                                        return 0;
                                }
                            }
                        }
                        return -1;
                    }
                    return -2;
                }
            } catch (Throwable th) {
                return -1;
            }
        }
        return -1;
    }

    public static String a(String str) {
        try {
            RSAPublicKey P = cn.jiguang.d.h.a.b.P("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCi0v4VEUhOdfIEfFCrPC72pcDsQF/luTmr4q34NY0EZYGKzfQuTrUAm916P52HCgF+342gjZ/Nvijts5543qYNyoLvgtu4NRcHJmuGI/w7qifhfsivYeoEj9wYphXOyB9HUjzwn1BtAih+1RyUrcErCi249yabUOIKQygPZ9OXXQIDAQAB");
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, P);
            return new String(Base64.encode(cipher.doFinal(str.getBytes()), 2), HTTP.UTF_8);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (cn.jiguang.g.i.a(str)) {
            return null;
        }
        long c2 = cn.jiguang.d.a.d.c(null);
        if (c2 != 0) {
            String c3 = cn.jiguang.g.a.c(c2 + cn.jiguang.g.a.b(cn.jiguang.d.a.d.e(null)) + str);
            if (cn.jiguang.g.i.a(c3)) {
                return null;
            }
            try {
                return Base64.encodeToString((c2 + Config.TRACE_TODAY_VISIT_SPLIT + c3 + Config.TRACE_TODAY_VISIT_SPLIT + str2).getBytes(), 10);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static ArrayList<JSONArray> a(JSONArray jSONArray, int i, int i2) {
        int i3;
        int i4;
        int a2;
        int i5;
        JSONArray jSONArray2;
        int i6 = 0;
        ArrayList<JSONArray> arrayList = new ArrayList<>();
        if (jSONArray == null || jSONArray.length() == 0) {
            return arrayList;
        }
        if (jSONArray.length() == 1) {
            arrayList.add(jSONArray);
            return arrayList;
        }
        JSONArray jSONArray3 = new JSONArray();
        int length = jSONArray.length() - 1;
        int i7 = 0;
        while (length >= 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(length);
            if (optJSONObject != null && optJSONObject.length() != 0) {
                try {
                    a2 = cn.jiguang.d.h.h.a(optJSONObject);
                } catch (Exception e) {
                }
                if (i6 + a2 > 204800) {
                    break;
                }
                if (i7 + a2 > 40960) {
                    if (jSONArray3.length() > 0) {
                        arrayList.add(jSONArray3);
                    }
                    jSONArray2 = new JSONArray();
                    try {
                        jSONArray2.put(optJSONObject);
                        i5 = a2;
                    } catch (Exception e2) {
                        jSONArray3 = jSONArray2;
                    }
                } else {
                    jSONArray3.put(optJSONObject);
                    JSONArray jSONArray4 = jSONArray3;
                    i5 = i7 + a2;
                    jSONArray2 = jSONArray4;
                }
                JSONArray jSONArray5 = jSONArray2;
                i3 = a2 + i6;
                i4 = i5;
                jSONArray3 = jSONArray5;
                length--;
                i7 = i4;
                i6 = i3;
            }
            i3 = i6;
            i4 = i7;
            length--;
            i7 = i4;
            i6 = i3;
        }
        if (jSONArray3.length() > 0) {
            arrayList.add(jSONArray3);
        }
        return arrayList;
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("itime", cn.jiguang.api.e.bx());
            jSONObject.put("type", str);
            jSONObject.put("account_id", cn.jiguang.d.a.d.m(context));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static void a(Context context) {
        s.b(context);
    }

    public static void a(Context context, int i) {
        int i2;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        int i3 = 0;
        if (a == null) {
            return;
        }
        JSONObject jSONObject2 = a;
        if (i >= 204800) {
            f(context);
            return;
        }
        try {
            i2 = jSONObject2.toString().getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e) {
            i2 = 0;
        }
        int i4 = (i2 + i) - 204800;
        if (i4 <= 0 || (optJSONArray = jSONObject2.optJSONArray("content")) == null || optJSONArray.length() <= 0) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i5);
                if (jSONObject3 != null) {
                    if (i3 >= i4) {
                        jSONArray.put(jSONObject3);
                    }
                    i3 += jSONObject3.toString().getBytes("utf-8").length;
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject2.put("content", jSONArray);
                jSONObject = jSONObject2;
            } else {
                jSONObject = null;
            }
            synchronized ("jpush_stat_cache_history.json") {
                a = jSONObject;
                b(context, "jpush_stat_cache_history.json", jSONObject);
            }
        } catch (UnsupportedEncodingException e2) {
        } catch (JSONException e3) {
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        try {
            s.b(context);
            if (jSONArray != null && jSONArray.length() != 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        jSONArray2.put(optJSONObject);
                    }
                }
                jSONArray = jSONArray2;
            }
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            cn.jiguang.api.e.a("BUILD_REPORT", new ab(jSONArray, context), 4);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, JSONArray jSONArray, Set set) {
        try {
            String c2 = f.bU().ah(context).c(set);
            JSONObject d = d(context);
            ArrayList<JSONArray> a2 = a(jSONArray, 40960, 204800);
            boolean z = d == null;
            Iterator<JSONArray> it = a2.iterator();
            while (it.hasNext()) {
                JSONObject c3 = c(it.next(), d);
                File a3 = s.a(context, File.separator + c2 + File.separator + (d != null ? "tmp" : "nowrap"), c3);
                if (z) {
                    s.a(a3);
                } else {
                    cn.jiguang.api.e.a("UPLOAD_REPORT", new b(context, set, c3, a3), new int[0]);
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            s.b(context);
            if (jSONObject == null || jSONObject.length() == 0) {
                return;
            }
            cn.jiguang.api.e.a("BUILD_REPORT", new ac(jSONObject, context), 4);
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, JSONObject jSONObject, cn.jiguang.api.j jVar) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject d = d(context);
                    if (d != null) {
                        JSONObject c2 = c(new JSONArray().put(jSONObject), d);
                        String e = e(jSONObject);
                        HashSet hashSet = new HashSet();
                        hashSet.add(e);
                        int a2 = a(context, hashSet, c2, null);
                        if (jVar != null) {
                            jVar.a(a2);
                        }
                    } else if (jVar != null) {
                        jVar.a(-1);
                    }
                }
            } catch (Throwable th) {
            }
        }
        s.b(context);
    }

    public static void b(Context context) {
        try {
            l.bY().d(context, "report_history", new Bundle());
        } catch (Throwable th) {
        }
    }

    public static boolean b(Context context, String str, JSONObject jSONObject) {
        boolean z = false;
        try {
            if (cn.jiguang.g.i.a(str) || context == null) {
                return false;
            }
            z = cn.jiguang.d.h.f.b(cn.jiguang.d.h.f.K(context, str), jSONObject != null ? jSONObject.toString() : "");
            return z;
        } catch (Throwable th) {
            return z;
        }
    }

    private static JSONObject c(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("content", jSONArray);
        } catch (JSONException e) {
        }
        cn.jiguang.d.h.h.a(jSONObject2, jSONObject);
        return jSONObject2;
    }

    public static void c(Context context) {
        try {
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction("cn.jpush.android.intent.ACTION_REPORT_HISTORY");
            String packageName = context.getPackageName();
            intent.addCategory(packageName);
            intent.setPackage(packageName);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
        }
    }

    public static JSONObject d(Context context) {
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", Config.APP_VERSION_CODE);
            long c2 = cn.jiguang.d.a.d.c(context);
            if (c2 != 0) {
                jSONObject.put("uid", c2);
                String b2 = cn.jiguang.d.a.b(context);
                if (!cn.jiguang.g.i.a(b2)) {
                    jSONObject.put("app_key", b2);
                    e.bT().a(jSONObject);
                    jSONObject.put("core_sdk_ver", "1.2.5");
                    String H = cn.jiguang.d.a.a.H("");
                    if (cn.jiguang.g.i.a(H)) {
                        cn.jiguang.e.c.c("ReportUtils", "miss channel when wrap container info,but continue report...");
                    } else {
                        jSONObject.put(LogBuilder.KEY_CHANNEL, H);
                    }
                    Pair<String, Integer> Y = cn.jiguang.d.a.Y(context);
                    if (cn.jiguang.g.i.a((String) Y.first)) {
                        cn.jiguang.e.c.c("ReportUtils", "miss app version when wrap container info,but continue report...");
                    } else {
                        jSONObject.put(Constants.EXTRA_KEY_APP_VERSION, Y.first);
                    }
                    z = true;
                }
            }
            if (z) {
                return jSONObject;
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("type");
        }
        return null;
    }

    public static Set<String> e(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String e = e(jSONArray.optJSONObject(i));
                if (e == null) {
                    e = "";
                }
                hashSet.add(e);
            }
        }
        return hashSet;
    }

    public static void e(Context context) {
        b(context, "jpush_stat_cache.json", null);
        f(context);
    }

    public static Set<String> f(JSONObject jSONObject) {
        return jSONObject == null ? new HashSet() : e(jSONObject.optJSONArray("content"));
    }

    private static void f(Context context) {
        synchronized ("jpush_stat_cache_history.json") {
            a = null;
            if (!b(context, "jpush_stat_cache_history.json", null)) {
                cn.jiguang.d.h.f.a(cn.jiguang.d.h.f.K(context, "jpush_stat_cache_history.json"));
            }
        }
    }
}
