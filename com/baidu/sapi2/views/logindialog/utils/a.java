package com.baidu.sapi2.views.logindialog.utils;

import android.os.Build;
import android.util.Base64;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static final String a = "auto_statistic";
    public static final String b = "login_dialog";
    public static final String d = "show_time_consume";
    public static final String e = "show_login_type";
    public static final String f = "clickevent";
    public static final String g = "login_result";
    public static final String h = "login_type";
    public static final String j = "0";
    public static final String k = "1";
    public static final String l = "name";
    public static final String m = "time_consume";
    public static final String n = "result_code";
    public static final String o = "result_msg";
    public static LinkedHashMap<String, String> c = new LinkedHashMap<>();
    public static JSONArray i = new JSONArray();

    public static String a() {
        return "{eventType:login_dialog}";
    }

    /* renamed from: com.baidu.sapi2.views.logindialog.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0142a extends HttpHandlerWrap {
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
        }

        public C0142a(boolean z) {
            super(z);
        }
    }

    public static void b() {
        i = new JSONArray();
        c.clear();
    }

    public static void a(long j2, QuickLoginType quickLoginType) {
        c.put(d, String.valueOf(j2));
        c.put(e, quickLoginType.getValue());
    }

    public static void a(long j2, String str) {
        c.put(d, String.valueOf(j2));
        c.put(e, str);
    }

    public static void a(String str) {
        try {
            if (i.length() == 20 && Build.VERSION.SDK_INT >= 19) {
                i.remove(0);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            i.put(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, long j2, int i2, String str2) {
        try {
            if (i.length() == 20 && Build.VERSION.SDK_INT >= 19) {
                i.remove(0);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            jSONObject.put(m, j2);
            jSONObject.put("result_code", i2);
            jSONObject.put("result_msg", str2);
            i.put(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, QuickLoginType quickLoginType) {
        c.put(g, str);
        c.put("login_type", quickLoginType.getValue());
    }

    public static void a(String str, String str2) {
        c.put(g, str);
        c.put("login_type", str2);
    }

    public static void c() {
        try {
            SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
            if (sapiAccountManager == null || sapiAccountManager.getConfignation() == null) {
                return;
            }
            c.put(f, String.valueOf(i));
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
            httpHashMapWrap.put("pid", "111");
            httpHashMapWrap.put("type", SmartLaunchStats.UBC_START_LAUNCH_ID);
            httpHashMapWrap.put("source", "native");
            httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
            httpHashMapWrap.put("data_source", CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT);
            httpHashMapWrap.put("name", "auto_statistic");
            httpHashMapWrap.put("auto_statistic", Base64.encodeToString(a().getBytes(), 2));
            if (c != null) {
                for (String str : c.keySet()) {
                    httpHashMapWrap.put(str, c.get(str));
                }
            }
            new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), ReqPriority.LOW, httpHashMapWrap, null, null, new C0142a(true));
            b();
        } catch (Exception e2) {
            Log.e(Log.TAG, e2.getMessage());
        }
    }
}
