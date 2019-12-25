package com.baidu.searchbox.suspensionball;

import com.baidu.android.util.sp.SharedPrefsWrapper;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class SuspensionSpUtil {
    private static final String SUSPENSION_BALL_DATA = "suspension_ball_data";
    public static final String SUSPENSION_BALL_SWITCH = "suspension_ball_switch";
    public static final String SUSPENSION_BALL_XCOORDINATE = "suspension_ball_xcoordinate";
    public static final String SUSPENSION_BALL_YCOORDINATE = "suspension_ball_ycoordinate";
    private static final SharedPrefsWrapper sharedPrefsWrapper = new SharedPrefsWrapper(SuspensionSchemeUtil.DEFAULT_KEY_PREFIX);

    public static int getInt(String str, int i) {
        return sharedPrefsWrapper.getInt(str, i);
    }

    public static void putInt(String str, int i) {
        sharedPrefsWrapper.putInt(str, i);
    }

    public static String getString(String str, String str2) {
        return sharedPrefsWrapper.getString(str, str2);
    }

    public static void putString(String str, String str2) {
        sharedPrefsWrapper.putString(str, str2);
    }

    public static boolean getBoolean(String str, boolean z) {
        return sharedPrefsWrapper.getBoolean(str, z);
    }

    public static void putBoolean(String str, boolean z) {
        sharedPrefsWrapper.putBoolean(str, z);
    }

    public static void putBallData(Map<String, SuspensionBallEntity> map) {
        sharedPrefsWrapper.putString(SUSPENSION_BALL_DATA, mapToJson(map));
    }

    public static String getBallData() {
        return sharedPrefsWrapper.getString(SUSPENSION_BALL_DATA, "");
    }

    private static String mapToJson(Map<String, SuspensionBallEntity> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            jSONArray.put(map.get(str).toJsonObject());
        }
        return jSONArray.toString();
    }
}
