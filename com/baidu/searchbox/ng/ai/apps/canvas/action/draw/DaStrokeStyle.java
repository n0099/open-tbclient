package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaStrokeStyle extends AbsDrawAction {
    public static final String ACTION_TYPE = "strokeStyle";
    private DaColor mColor;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.mColor = new DaColor(jSONArray);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mColor != null && this.mColor.isValid()) {
            if (this.mColor.isShader()) {
                canvasContext.mStrokePaint.setShader(this.mColor.getShader());
                return;
            }
            canvasContext.mStrokeColor = this.mColor.getColor();
            canvasContext.mStrokePaint.setColor(this.mColor.getColor());
            canvasContext.mFillPaint.setShader(null);
        }
    }
}
