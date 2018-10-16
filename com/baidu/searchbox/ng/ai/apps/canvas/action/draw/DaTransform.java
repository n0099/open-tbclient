package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaTransform extends AbsDrawAction {
    public static final String ACTION_TYPE = "transform";
    private float mA;
    private float mB;
    private float mC;
    private float mD;
    private int mE;
    private int mF;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.mA = (float) jSONArray.optDouble(0);
                this.mB = (float) jSONArray.optDouble(1);
                this.mC = (float) jSONArray.optDouble(2);
                this.mD = (float) jSONArray.optDouble(3);
                this.mE = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(4));
                this.mF = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(5));
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (canvasContext.GetMatrixOrigin() == 0) {
            canvasContext.SaveMatrixOrigin(canvas.save());
        }
        if (this.mA > 0.0f && this.mD > 0.0f) {
            canvas.scale(this.mA, this.mD);
        }
        canvas.skew(this.mC, this.mB);
        canvas.translate(this.mE, this.mF);
    }
}
