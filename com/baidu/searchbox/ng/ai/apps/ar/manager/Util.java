package com.baidu.searchbox.ng.ai.apps.ar.manager;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Util {
    private static final String KEY_CAMERA = "ARCamera";
    private static final String KEY_CAMERA_ID = "ARCameraId";
    private static final String KEY_ERROR_DATA = "data";
    private static final String KEY_ERROR_MSG = "message";
    private static final String KEY_ERROR_STATUS = "status";
    private static final String KEY_EXCEPTION_TYPE = "eType";
    private static final String KEY_SLAVE_ID = "wvID";
    private static final String VALUE_EXCEPTION_ERROR = "error";
    private static final String VALUE_LOADED = "load";
    private static final String VALUE_SCAN_END = "scancode";

    public static void onExceptionError(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", str);
        hashMap.put(KEY_CAMERA_ID, str2);
        hashMap.put(KEY_EXCEPTION_TYPE, "error");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", -1);
            jSONObject.put("message", "ar camera using error");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put("data", jSONObject.toString());
        AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage("ARCamera", hashMap));
    }

    public static void onLoaded(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", str);
        hashMap.put(KEY_CAMERA_ID, str2);
        hashMap.put(KEY_EXCEPTION_TYPE, "load");
        AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage("ARCamera", hashMap));
    }

    public static void onScanEnd(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", str);
        hashMap.put(KEY_CAMERA_ID, str2);
        hashMap.put(KEY_EXCEPTION_TYPE, VALUE_SCAN_END);
        AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage("ARCamera", hashMap));
    }

    public static void onLoadError(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", str);
        hashMap.put(KEY_CAMERA_ID, str2);
        hashMap.put(KEY_EXCEPTION_TYPE, "error");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", -1);
            jSONObject.put("message", "load res error");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put("data", jSONObject.toString());
        AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage("ARCamera", hashMap));
    }

    public static boolean hasCameraPermission(Context context) {
        return Build.VERSION.SDK_INT < 23 || ActivityCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0;
    }

    public static boolean hasRecordPermission(Context context) {
        return Build.VERSION.SDK_INT < 23 || ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }
}
