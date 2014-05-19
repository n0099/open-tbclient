package com.baidu.kirin;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.kirin.c.c;
import com.baidu.kirin.d.d;
import com.baidu.kirin.objects.KirinCheckState;
import com.baidu.mobstat.a.e;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class StatUpdateAgent {
    private static Handler b;
    static HandlerThread a = new HandlerThread("CheckUpdateManagerKirinAgent");
    private static JSONObject c = null;
    private static JSONObject d = null;

    private static JSONObject a(Context context, String str) {
        JSONObject jSONObject;
        JSONException e;
        if (com.baidu.kirin.b.a.a(context).a(str) || KirinConfig.DEBUG_MODE) {
            d.a("can update!");
            com.baidu.kirin.c.b bVar = new com.baidu.kirin.c.b(context, KirinConfig.UPDATE_QUERY);
            bVar.a("updateMoment", str);
            try {
                JSONObject c2 = bVar.c();
                if (KirinConfig.DEBUG_MODE) {
                    c = bVar.a();
                    d = c2;
                }
                d.a("updateResult is : " + c2.toString());
                try {
                    c2.put("returncode", bVar.d());
                    return c2;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return c2;
                }
            } catch (Exception e3) {
                d.c("send update query error!!");
                return null;
            }
        }
        d.a("can not update");
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e4) {
            jSONObject = null;
            e = e4;
        }
        try {
            jSONObject.put("need_update", "0");
            jSONObject.put("returncode", 0);
            if (KirinConfig.DEBUG_MODE) {
                c = new JSONObject();
                c.put("Send", "didn't send request! at moment : " + str);
                d = jSONObject;
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e5) {
            e = e5;
            e.printStackTrace();
            return jSONObject;
        }
    }

    private static void a() {
        if (!a.isAlive()) {
            a.start();
            b = new Handler(a.getLooper());
        }
        if (b == null) {
            b = new Handler(a.getLooper());
        }
    }

    private static boolean a(JSONObject jSONObject, HashMap<String, String> hashMap) {
        try {
            hashMap.put("updatetype", jSONObject.getString("updatetype"));
            hashMap.put("note", jSONObject.getString("note"));
            hashMap.put("time", jSONObject.getString("time"));
            hashMap.put("appurl", jSONObject.getString("appurl"));
            hashMap.put("appname", jSONObject.getString("appname"));
            hashMap.put("version", jSONObject.getString("version"));
            hashMap.put("buildid", jSONObject.getString("buildid"));
            hashMap.put("attach", jSONObject.getJSONArray("attach").toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, int i, PostChoiceListener postChoiceListener) {
        if (com.baidu.kirin.b.a.a(context).c()) {
            c cVar = new c(context, KirinConfig.POST_CHOICE);
            cVar.a("updateType", i + "");
            JSONObject c2 = cVar.c();
            if (postChoiceListener != null) {
                postChoiceListener.PostUpdateChoiceResponse(c2);
            }
            if (KirinConfig.DEBUG_MODE) {
                c = cVar.a();
                d = c2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, boolean z, CheckUpdateListener checkUpdateListener) {
        KirinCheckState kirinCheckState;
        JSONObject a2;
        if (checkUpdateListener == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        KirinCheckState kirinCheckState2 = KirinCheckState.ERROR_CHECK_VERSION;
        try {
            a2 = z ? a(context, KirinConfig.ATSTART) : a(context, KirinConfig.ATSETTING);
        } catch (Exception e) {
            kirinCheckState = KirinCheckState.ERROR_CHECK_VERSION;
            d.c("Error checking online version: " + e.getMessage());
            e.printStackTrace();
        }
        if (a2 == null) {
            d.c("updateResult is null, net error!");
            checkUpdateListener.checkUpdateResponse(kirinCheckState2, new HashMap<>());
            return;
        }
        int i = a2.getInt("returncode");
        d.a("updateQuery's retCode is : " + i);
        if (i != 0) {
            d.b("KirinSDK protocol error when mutual with backend");
            kirinCheckState = KirinCheckState.ALREADY_UP_TO_DATE;
        } else if (Integer.parseInt(a2.getString("need_update")) != 1) {
            kirinCheckState = KirinCheckState.ALREADY_UP_TO_DATE;
        } else if (Integer.parseInt(a2.getString("buildid")) <= com.baidu.kirin.a.a.d(context)) {
            kirinCheckState = KirinCheckState.ALREADY_UP_TO_DATE;
        } else if (!a(a2, hashMap)) {
            checkUpdateListener.checkUpdateResponse(KirinCheckState.ALREADY_UP_TO_DATE, hashMap);
            return;
        } else if ("".endsWith(a2.getString("appurl")) || a2.getString("appurl") == null) {
            d.c("appurl is null or appurl'size is 0!");
            kirinCheckState = KirinCheckState.ALREADY_UP_TO_DATE;
        } else if (a2.getString("appurl").startsWith("http://")) {
            kirinCheckState = KirinCheckState.NEWER_VERSION_FOUND;
        } else {
            d.c("appurl is not start with http://");
            kirinCheckState = KirinCheckState.ERROR_CHECK_VERSION;
        }
        checkUpdateListener.checkUpdateResponse(kirinCheckState, hashMap);
    }

    public static void checkUpdate(Context context, boolean z, CheckUpdateListener checkUpdateListener) {
        a();
        if (checkUpdateListener == null) {
            e.c("sdkstat", "The param of CheckUpdateListener is null, please new a instance of CheckUpdateListener");
        } else {
            b.post(new a(context, z, checkUpdateListener));
        }
    }

    public static void postUserChoice(Context context, int i, PostChoiceListener postChoiceListener) {
        a();
        b.post(new b(context, i, postChoiceListener));
    }

    public static void setTestMode() {
        KirinConfig.DEBUG_MODE = true;
        KirinConfig.DEFAULT_UPDATE_INTERVAL = 0;
    }
}
