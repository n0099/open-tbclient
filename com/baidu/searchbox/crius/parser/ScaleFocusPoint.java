package com.baidu.searchbox.crius.parser;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ScaleFocusPoint {
    public static final float DEFAULT_VALUE = 0.5f;
    public float x = 0.5f;
    public float y = 0.5f;

    @Nullable
    public static ScaleFocusPoint getFocusPoint(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            ScaleFocusPoint scaleFocusPoint = new ScaleFocusPoint();
            scaleFocusPoint.x = (float) jSONObject.optDouble("x", 0.5d);
            scaleFocusPoint.y = (float) jSONObject.optDouble("y", 0.5d);
            return scaleFocusPoint;
        }
        return null;
    }
}
