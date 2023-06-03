package com.baidu.searchbox.download.util;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.MigrateStatisticConstants;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MigrateStatisticUtils {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String EXT_INFO = "ext_info";
    public static final String TAG = "MigrateStatisticUtils";
    public static final String TIME_MS = "time_ms";

    public static JSONObject build(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TIME_MS, String.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(EXT_INFO, str);
                return jSONObject;
            }
            return jSONObject;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void invoke(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("type", str);
            }
            if (jSONObject != null) {
                jSONObject2.put("value", jSONObject);
            }
            UBC.onEvent(MigrateStatisticConstants.DOWNLOAD_ID, jSONObject2);
            if (DEBUG) {
                Log.e(TAG, "new ubc id =1205 content=" + jSONObject2.toString());
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
