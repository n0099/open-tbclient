package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaSetGlobalAlpha extends AbsDrawAction {
    public static final String ACTION_TYPE = "setGlobalAlpha";
    private float mGlobalAlpha = -1.0f;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.mGlobalAlpha = (float) jSONArray.optDouble(0);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mGlobalAlpha >= 0.0f && this.mGlobalAlpha <= 1.0f) {
            canvasContext.mGlobalAlpha = (int) (this.mGlobalAlpha * 255.0f);
        }
    }
}
