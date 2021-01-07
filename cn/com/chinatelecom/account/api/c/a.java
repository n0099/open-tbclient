package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1119a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, String> f1120b = new HashMap<>();

    public static long a(Context context) {
        return c.b(context, "key_difference_time", 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
        r2.f1108a = b(r1, "gw_auth");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cn.com.chinatelecom.account.api.b.b a(Context context, HttpURLConnection httpURLConnection, boolean z) {
        int i = 0;
        if (z) {
            cn.com.chinatelecom.account.api.b.b bVar = new cn.com.chinatelecom.account.api.b.b();
            try {
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                List<String> list = headerFields.get("p");
                if (list != null && list.size() > 0) {
                    bVar.f1109b = a(context, list.get(0));
                }
                List<String> list2 = headerFields.get(SM.SET_COOKIE);
                if (list2 != null && list2.size() > 0) {
                    while (true) {
                        int i2 = i;
                        if (i2 >= list2.size()) {
                            break;
                        }
                        String str = list2.get(0);
                        if (!TextUtils.isEmpty(str) && str.contains("gw_auth")) {
                            break;
                        }
                        i = i2 + 1;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return bVar;
        }
        return null;
    }

    public static String a(Context context, cn.com.chinatelecom.account.api.b.e eVar, String str, Network network, boolean z) {
        if (eVar == null || TextUtils.isEmpty(eVar.f1116b)) {
            return "{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}";
        }
        if (eVar.f1115a == -1) {
            return eVar.f1116b;
        }
        try {
            JSONObject jSONObject = new JSONObject(eVar.f1116b);
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("result");
                String optString = jSONObject.optString("data");
                if ((optInt == 0 || optInt == 30002) && !TextUtils.isEmpty(optString)) {
                    String a2 = f.a(optString, str);
                    if (!TextUtils.isEmpty(a2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(a2);
                            jSONObject.put("data", jSONObject2);
                            a(jSONObject2.optString("accessCode"), eVar.d);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            jSONObject.put("data", a2);
                        }
                        if (optInt == 30002 && z) {
                            ArrayList arrayList = new ArrayList();
                            JSONArray optJSONArray = ((JSONObject) jSONObject.opt("data")).optJSONArray("urls");
                            if (optJSONArray != null) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    arrayList.add(optJSONArray.getString(i));
                                }
                            }
                            if (arrayList == null || arrayList.isEmpty()) {
                                return null;
                            }
                            return a(context, arrayList, str, network);
                        }
                        return jSONObject.toString();
                    }
                } else if (optInt == -10009 || optInt == -30001) {
                    long optLong = jSONObject.optLong("timeStamp", -1L);
                    if (optLong == -1) {
                        c(context);
                    } else {
                        a(context, optLong);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return eVar.f1116b;
    }

    public static String a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("result");
            String optString = jSONObject.optString("responseData");
            if (optInt != 0 || TextUtils.isEmpty(optString)) {
                if (optInt == -30001) {
                    long optLong = jSONObject.optLong("timeStamp", -1L);
                    if (optLong == -1) {
                        c(context);
                        return str;
                    }
                    a(context, optLong);
                    return str;
                }
                return str;
            }
            String b2 = f.b(optString, str2);
            if (TextUtils.isEmpty(b2)) {
                return str;
            }
            try {
                jSONObject.put("responseData", new JSONObject(b2));
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject.put("responseData", b2);
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    private static String a(Context context, List<String> list, String str, Network network) {
        for (int i = 0; i < list.size(); i++) {
            try {
                String str2 = list.get(i);
                if (TextUtils.isEmpty(str2)) {
                    continue;
                } else {
                    if (Build.VERSION.SDK_INT < 21) {
                        cn.com.chinatelecom.account.api.b.c.a(context, str2);
                    }
                    String a2 = a(context, cn.com.chinatelecom.account.api.b.c.a(context, str2, network), str, network, false);
                    try {
                        if (new JSONObject(a2).optInt("result") == 0) {
                            return a2;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i.a(-8001, "请求网络异常- redirect 30002 ");
    }

    public static String a(String str) {
        return (TextUtils.isEmpty(str) || !f1120b.containsKey(str)) ? "" : f1120b.get(str);
    }

    private static synchronized void a(Context context, int i) {
        synchronized (a.class) {
            try {
                c.a(context, "key_p_a_p", i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void a(Context context, long j) {
        if (j > 0) {
            c.a(context, "key_difference_time", j - System.currentTimeMillis());
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f1120b.put(str, str2);
    }

    public static synchronized boolean a(Context context, String str) {
        boolean z = false;
        synchronized (a.class) {
            if (str != null) {
                try {
                    if (HttpHost.DEFAULT_SCHEME_NAME.equals(str.toLowerCase()) || "https".equals(str.toLowerCase())) {
                        if (!(c.b(context, "key_p_a_p", 0) == 1 ? "https" : HttpHost.DEFAULT_SCHEME_NAME).equals(str.toLowerCase())) {
                            a(context, str.toLowerCase().equals("https") ? 1 : 0);
                            z = true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return z;
    }

    private static String b(String str, String str2) {
        try {
            String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(str2)) {
                    return split[i].split("=")[1];
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (cn.com.chinatelecom.account.api.c.c.b(r5, "key_p_a_p", 0) == 1) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean b(Context context) {
        boolean z = false;
        synchronized (a.class) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
        z = true;
        return z;
    }

    private static void c(Context context) {
        JSONObject jSONObject = null;
        String str = cn.com.chinatelecom.account.api.b.c.a(context, "https://open.e.189.cn/openapi/special/getTimeStamp.do", "", null, null, false, 0, "reqTimestamp").f1116b;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject != null) {
            a(context, jSONObject.optLong("msg", -1L));
        }
    }
}
