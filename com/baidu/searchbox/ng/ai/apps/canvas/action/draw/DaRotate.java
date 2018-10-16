package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaRotate extends AbsDrawAction {
    public static final String ACTION_TYPE = "rotate";
    private float mRotateAngle;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.mRotateAngle = (float) jSONArray.optDouble(0);
            this.mRotateAngle = (float) Math.toDegrees(this.mRotateAngle);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (canvasContext.GetMatrixOrigin() == 0) {
            canvasContext.SaveMatrixOrigin(canvas.save());
        }
        canvas.rotate(this.mRotateAngle);
    }
}
