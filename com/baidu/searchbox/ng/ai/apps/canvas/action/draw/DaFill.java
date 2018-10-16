package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaFill extends AbsDrawAction {
    public static final String ACTION_TYPE = "fill";

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        int alpha = canvasContext.mFillPaint.getAlpha();
        canvasContext.applyGlobal(canvasContext.mFillPaint);
        canvas.drawPath(canvasContext.mPath, canvasContext.mFillPaint);
        canvasContext.mFillPaint.setAlpha(alpha);
    }
}
