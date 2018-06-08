package com.baidu.ar.bean;

import android.text.TextUtils;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.util.MD5Utils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ARConfig {
    public static final int LAUNCH_AR_TAB = 2;
    public static final int LAUNCH_AR_TAB_CASE = 3;
    public static final int LAUNCH_MODE_H5 = 1;
    public static final int LAUNCH_MODE_TAKE_PICTURE = 0;
    public static final int TYPE_CLOUD_IR = 7;
    public static final int TYPE_GAME = 2;
    public static final int TYPE_IMU = 8;
    public static final int TYPE_LBS = 1;
    public static final int TYPE_NPC = 4;
    public static final int TYPE_ON_DEVICE_IR = 6;
    public static final int TYPE_SLAM = 5;
    public static final int TYPE_TRACK = 0;
    public static final int TYPE_UDT = 3;
    private static String a;
    private static String b;
    private static int e;
    private static String f;
    private static String g;
    private static String i;
    private static long j;
    private static IToken l;
    private static int c = -1;
    private static int d = -1;
    private static boolean h = false;
    private static boolean k = false;

    private static void a(long j2) {
        j = j2;
    }

    public static String getARExtraInfo() {
        return i;
    }

    public static String getARId() {
        return f;
    }

    public static int getARInitialType() {
        return d;
    }

    public static String getARKey() {
        return b;
    }

    public static int getARLaunchMode() {
        return e;
    }

    public static int getARType() {
        return c;
    }

    public static String getArFrom() {
        return g;
    }

    public static String getArValue() {
        return a;
    }

    public static String getIsAip() {
        return isAipAuth() ? "1" : "2";
    }

    public static String getSignature() {
        long currentTimeMillis = System.currentTimeMillis();
        a(currentTimeMillis);
        return MD5Utils.md5(DuMixARConfig.getAipAppId() + DuMixARConfig.getAPIKey() + "777078ec21930de508131ba36035de6b" + currentTimeMillis);
    }

    public static long getTimestamp() {
        return j;
    }

    public static String getToken() {
        if (l != null) {
            return l.getToken();
        }
        return null;
    }

    public static void initARConfig(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = str;
            setARKey(jSONObject.has("ar_key") ? jSONObject.getString("ar_key") : jSONObject.has(ARConfigKey.OLD_AR_KEY) ? jSONObject.getString(ARConfigKey.OLD_AR_KEY) : null);
            String string = jSONObject.has("ar_type") ? jSONObject.getString("ar_type") : jSONObject.has(ARConfigKey.OLD_AR_TYPE) ? jSONObject.getString(ARConfigKey.OLD_AR_TYPE) : null;
            if (TextUtils.isEmpty(string)) {
                setARType(0);
            } else {
                setARType(Integer.parseInt(string));
                setARInitialType(Integer.parseInt(string));
            }
            String string2 = jSONObject.has(ARConfigKey.AR_LAUNCH_MODE) ? jSONObject.getString(ARConfigKey.AR_LAUNCH_MODE) : null;
            if (TextUtils.isEmpty(string2)) {
                setARLaunchMode(0);
            } else {
                setARLaunchMode(Integer.parseInt(string2));
            }
            String string3 = jSONObject.has("ar_id") ? jSONObject.getString("ar_id") : null;
            setARId(string3);
            if (TextUtils.isEmpty(getARKey()) && string3 != null) {
                try {
                    setARKey(new JSONObject(string3).optString("content_id"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (jSONObject.has(ARConfigKey.AR_FROM)) {
                setARExtraInfo(jSONObject.getString(ARConfigKey.AR_FROM));
            }
            if (jSONObject.has(ARConfigKey.AR_NEED_LAST_PREVIEW)) {
                setIsNeedLastPreview(jSONObject.getBoolean(ARConfigKey.AR_NEED_LAST_PREVIEW));
            }
            if (jSONObject.has(ARConfigKey.EXTRA_INFO)) {
                setARExtraInfo(jSONObject.getString(ARConfigKey.EXTRA_INFO));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static boolean isAipAuth() {
        return k;
    }

    public static boolean isBox() {
        return "2".equals(DuMixARConfig.getAipAppId());
    }

    public static boolean isNeedLastPreview() {
        return h;
    }

    public static void setARExtraInfo(String str) {
        i = str;
    }

    public static void setARId(String str) {
        f = str;
    }

    public static void setARInitialType(int i2) {
        d = i2;
    }

    public static void setARKey(String str) {
        b = str;
    }

    public static void setARLaunchMode(int i2) {
        e = i2;
    }

    public static void setARType(int i2) {
        c = i2;
    }

    public static void setArFrom(String str) {
        g = str;
    }

    public static void setIsAipAuth(boolean z) {
        k = z;
    }

    public static void setIsNeedLastPreview(boolean z) {
        h = z;
    }

    public static void setToken(IToken iToken) {
        l = iToken;
    }
}
