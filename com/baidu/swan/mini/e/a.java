package com.baidu.swan.mini.e;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    @NonNull
    public static String b(@NonNull String str, com.baidu.swan.mini.b.a aVar) {
        String ti = b.ti(aVar.aGx().getAppId());
        return "window.___NA_SWAN_MINI___.___swan_mini_master_loaded___('" + str + "', '" + ti + "', '" + b.ti(aVar.aGx().getBundleId()) + "');";
    }

    @NonNull
    public static String u(@NonNull String str, @NonNull String str2, boolean z) {
        return "var event = new Object(); event.type = 'AppReady';event.isShowing = " + z + ";event.appPackagePath = '" + b.ti(str) + "';event.appConfig = '{}'; event.appCodeInfoStr = '" + b.ti(str2) + "'; _naSwan.dispatchEvent(event);";
    }

    @NonNull
    public static String a(String str, @NonNull String str2, @NonNull com.baidu.swan.mini.b.a aVar) {
        String ti = b.ti(aVar.aGx().getAppId());
        return "window.___NA_SWAN_MINI___.___swan_mini_slave_app_loaded___('" + ti + "', '" + b.ti(aVar.aGx().getBundleId()) + "', " + str2 + ", '" + str + "');";
    }

    @NonNull
    public static String a(@Nullable List<String> list, int i, @Nullable String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONArray.put(str2);
                    }
                }
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        jSONObject.put("errCode", i);
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("errMessage", str);
        }
        jSONObject.put("instanceIds", jSONArray);
        jSONObject.put("needDispose", z);
        return "window.___NA_SWAN_MINI___.onError(" + jSONObject.toString() + ");";
    }
}
