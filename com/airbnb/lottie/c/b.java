package com.airbnb.lottie.c;

import android.graphics.PointF;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static PointF a(JSONObject jSONObject, float f) {
        return new PointF(l(jSONObject.opt(Config.EVENT_HEAT_X)) * f, l(jSONObject.opt("y")) * f);
    }

    public static PointF a(JSONArray jSONArray, float f) {
        if (jSONArray.length() < 2) {
            throw new IllegalArgumentException("Unable to parse point for " + jSONArray);
        }
        return new PointF(((float) jSONArray.optDouble(0, 1.0d)) * f, ((float) jSONArray.optDouble(1, 1.0d)) * f);
    }

    public static float l(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Double) {
            return (float) ((Double) obj).doubleValue();
        }
        if (obj instanceof JSONArray) {
            return (float) ((JSONArray) obj).optDouble(0);
        }
        return 0.0f;
    }
}
