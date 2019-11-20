package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i {
    private Shader aFR;
    private int mColor;
    private String mType = "";

    i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(JSONArray jSONArray) {
        n(jSONArray);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mType);
    }

    public boolean CU() {
        return TextUtils.equals(this.mType, "linearGradient") || TextUtils.equals(this.mType, "circularGradient");
    }

    public int getColor() {
        return this.mColor;
    }

    public Shader CV() {
        return this.aFR;
    }

    public void n(JSONArray jSONArray) {
        int length;
        try {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "normal")) {
                JSONArray optJSONArray = jSONArray.optJSONArray(1);
                if (optJSONArray.length() == 4) {
                    this.mColor = Color.argb(optJSONArray.optInt(3), optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2));
                    this.mType = "normal";
                }
            } else if (TextUtils.equals(optString, "linearGradient") || TextUtils.equals(optString, "circularGradient")) {
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
                        fArr[i] = (float) optJSONObject.optDouble("stop");
                    }
                }
                if (iArr != null && fArr != null && iArr.length >= 2 && iArr.length == fArr.length) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(2);
                    if (TextUtils.equals(optString, "linearGradient")) {
                        this.aFR = new LinearGradient(com.baidu.swan.apps.an.z.S(optJSONObject2.optInt("x0")), com.baidu.swan.apps.an.z.S(optJSONObject2.optInt("y0")), com.baidu.swan.apps.an.z.S(optJSONObject2.optInt("x1")), com.baidu.swan.apps.an.z.S(optJSONObject2.optInt("y1")), iArr, fArr, Shader.TileMode.CLAMP);
                        this.mType = "linearGradient";
                        return;
                    }
                    this.aFR = new RadialGradient(com.baidu.swan.apps.an.z.S(optJSONObject2.optInt(Config.EVENT_HEAT_X)), com.baidu.swan.apps.an.z.S(optJSONObject2.optInt("y")), com.baidu.swan.apps.an.z.S(optJSONObject2.optInt("r")), iArr, fArr, Shader.TileMode.CLAMP);
                    this.mType = "circularGradient";
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
