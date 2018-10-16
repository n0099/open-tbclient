package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaScale extends AbsDrawAction {
    public static final String ACTION_TYPE = "scale";
    private float mScaleHeight;
    private float mScaleWidth;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.mScaleWidth = (float) jSONArray.optDouble(0);
            this.mScaleHeight = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mScaleWidth > 0.0f && this.mScaleHeight > 0.0f) {
            if (canvasContext.GetMatrixOrigin() == 0) {
                canvasContext.SaveMatrixOrigin(canvas.save());
            }
            canvas.scale(this.mScaleWidth, this.mScaleHeight);
        }
    }
}
