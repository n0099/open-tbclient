package com.baidu.prologue.business.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.prologue.a.c.k;
import com.coremedia.iso.boxes.FreeSpaceBox;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SplashStyleRecorder {
    public static void aA(JSONObject jSONObject) {
        if (jSONObject != null) {
            String string = k.getString("splash_style", "");
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.equals(string, jSONObject2)) {
                k.setString("splash_style", jSONObject2);
            }
        }
    }

    public static JSONObject a(SplashElements splashElements, boolean z) {
        String string = k.getString("splash_style", "");
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(string).getJSONObject(z ? splashElements.name + "_f" : splashElements.name);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public static JSONObject b(SplashElements splashElements, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("l_gravity", Integer.valueOf(c(splashElements, z)));
            jSONObject.putOpt("margin", d(splashElements, z));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static int c(SplashElements splashElements, boolean z) {
        switch (splashElements) {
            case LOGO:
                return 5;
            case SKIP:
            case WIFI_TIP:
                return 9;
            case LABEL:
                return 6;
            case VOICE:
                return 10;
            default:
                return 0;
        }
    }

    public static String d(SplashElements splashElements, boolean z) {
        switch (splashElements) {
            case LOGO:
                return "15_20_0_0";
            case SKIP:
                return "0_20_15_0";
            case LABEL:
                if (z) {
                    return "0_0_0_65";
                }
                return "0_0_0_0";
            case VOICE:
                return "0_0_9_20";
            case WIFI_TIP:
                return "0_58_15_0";
            default:
                return "";
        }
    }

    public static int aB(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.optInt("l_gravity");
    }

    public static int[] aC(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("margin");
            if (!TextUtils.isEmpty(optString)) {
                int[] iArr = new int[4];
                String[] split = optString.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 4) {
                    for (int i = 0; i < iArr.length; i++) {
                        try {
                            iArr[i] = Integer.parseInt(split[i]);
                        } catch (Exception e) {
                            iArr[i] = 0;
                        }
                    }
                }
                return iArr;
            }
        }
        return null;
    }

    /* loaded from: classes5.dex */
    public enum SplashElements {
        LOGO("logo"),
        SKIP(FreeSpaceBox.TYPE),
        LABEL("label"),
        VOICE("voice"),
        WIFI_TIP("wifi_tip");
        
        private String name;

        SplashElements(String str) {
            setName(str);
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }
    }
}
