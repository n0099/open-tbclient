package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import com.baidu.ar.paddle.PaddleController;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class DaColor {
    private static final String TYPE_CIRCULAR = "circularGradient";
    private static final String TYPE_LINEAR = "linearGradient";
    private static final String TYPE_NORMAL = "normal";
    private int mColor;
    private Shader mShader;
    private String mType = "";

    DaColor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DaColor(JSONArray jSONArray) {
        parseFrom(jSONArray);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mType);
    }

    public boolean isShader() {
        return TextUtils.equals(this.mType, TYPE_LINEAR) || TextUtils.equals(this.mType, TYPE_CIRCULAR);
    }

    public int getColor() {
        return this.mColor;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public void parseFrom(JSONArray jSONArray) {
        int length;
        try {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "normal")) {
                JSONArray optJSONArray = jSONArray.optJSONArray(1);
                if (optJSONArray.length() == 4) {
                    this.mColor = Color.argb(optJSONArray.optInt(3), optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2));
                    this.mType = "normal";
                }
            } else if (TextUtils.equals(optString, TYPE_LINEAR) || TextUtils.equals(optString, TYPE_CIRCULAR)) {
                int[] iArr = null;
                float[] fArr = null;
                JSONArray optJSONArray2 = jSONArray.optJSONArray(1);
                if (optJSONArray2 != null && (length = optJSONArray2.length()) > 0) {
                    iArr = new int[length];
                    fArr = new float[length];
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray("color");
                        if (optJSONArray3.length() == 4) {
                            iArr[i] = Color.argb(optJSONArray3.optInt(3), optJSONArray3.optInt(0), optJSONArray3.optInt(1), optJSONArray3.optInt(2));
                        }
                        fArr[i] = (float) optJSONObject.optDouble(IntentConfig.STOP);
                    }
                }
                if (iArr != null && fArr != null && iArr.length >= 2 && iArr.length == fArr.length) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(2);
                    if (TextUtils.equals(optString, TYPE_LINEAR)) {
                        this.mShader = new LinearGradient(AiAppsUIUtils.dp2px(optJSONObject2.optInt("x0")), AiAppsUIUtils.dp2px(optJSONObject2.optInt("y0")), AiAppsUIUtils.dp2px(optJSONObject2.optInt(PaddleController.SDK_TO_LUA_GESTURE_RESULT_X1)), AiAppsUIUtils.dp2px(optJSONObject2.optInt(PaddleController.SDK_TO_LUA_GESTURE_RESULT_Y1)), iArr, fArr, Shader.TileMode.CLAMP);
                        this.mType = TYPE_LINEAR;
                        return;
                    }
                    this.mShader = new RadialGradient(AiAppsUIUtils.dp2px(optJSONObject2.optInt(Config.EVENT_HEAT_X)), AiAppsUIUtils.dp2px(optJSONObject2.optInt("y")), AiAppsUIUtils.dp2px(optJSONObject2.optInt("r")), iArr, fArr, Shader.TileMode.CLAMP);
                    this.mType = TYPE_CIRCULAR;
                }
            }
        } catch (Exception e) {
        }
    }
}
