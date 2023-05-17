package com.baidu.searchbox.toolbar.statistic;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class CommonToolbarUBC {
    public static void click(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "tool");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("type", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("source", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("page", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("value", str5);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (AppConfig.isDebug()) {
            Log.e("CommonToolbarUBC", "click =" + jSONObject.toString());
        }
        if (!TextUtils.isEmpty(str)) {
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject.toString());
        }
    }

    public static void show(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("from", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("type", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("source", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("page", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                jSONObject.put("value", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                jSONObject.put("ext", str7);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (AppConfig.isDebug()) {
            Log.e("CommonToolbarUBC", "show =" + jSONObject.toString());
        }
        if (!TextUtils.isEmpty(str)) {
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject.toString());
        }
    }
}
