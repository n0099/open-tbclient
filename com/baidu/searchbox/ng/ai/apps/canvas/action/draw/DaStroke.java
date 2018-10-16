package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaStroke extends AbsDrawAction {
    public static final String ACTION_TYPE = "stroke";

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        int alpha = canvasContext.mStrokePaint.getAlpha();
        canvasContext.applyGlobal(canvasContext.mStrokePaint);
        canvas.drawPath(canvasContext.mPath, canvasContext.mStrokePaint);
        canvasContext.mStrokePaint.setAlpha(alpha);
    }
}
