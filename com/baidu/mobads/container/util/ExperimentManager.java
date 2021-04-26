package com.baidu.mobads.container.util;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExperimentManager {
    public static final String ID_CTR_LP_BACK = "18797";
    public static final String ID_HIT_LP_BACK = "18798";
    public static final String KEY_CONTROL_FLAG = "control_flag";
    public static final String KEY_EXP_ID_ARRAY = "expids";
    public static final String TAG = "ExperimentManager";

    /* loaded from: classes2.dex */
    public enum ExpHitStatus {
        HIT_EXP_ID,
        HIT_CTR_ID,
        HIT_NONE
    }

    public static ExpHitStatus getHitResultForExp(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String optString = jSONObject.optString(KEY_CONTROL_FLAG);
            if (TextUtils.isEmpty(optString)) {
                return ExpHitStatus.HIT_NONE;
            }
            try {
                JSONArray optJSONArray = new JSONObject(optString).optJSONArray(KEY_EXP_ID_ARRAY);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (str.equals(optJSONArray.optString(i2))) {
                            return ExpHitStatus.HIT_EXP_ID;
                        }
                        if (str2.equals(optJSONArray.optString(i2))) {
                            return ExpHitStatus.HIT_CTR_ID;
                        }
                    }
                }
            } catch (JSONException unused) {
                RemoteXAdLogger.getInstance().e(TAG, "parse json error.");
            }
            return ExpHitStatus.HIT_NONE;
        }
        return ExpHitStatus.HIT_NONE;
    }

    public static boolean isAdInfoMatchLpBackExp(JSONObject jSONObject) {
        ExpHitStatus hitResultForExp = getHitResultForExp(jSONObject, ID_HIT_LP_BACK, ID_CTR_LP_BACK);
        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
        remoteXAdLogger.d(TAG, "Lp back experiment: " + hitResultForExp);
        return ExpHitStatus.HIT_EXP_ID == hitResultForExp;
    }
}
