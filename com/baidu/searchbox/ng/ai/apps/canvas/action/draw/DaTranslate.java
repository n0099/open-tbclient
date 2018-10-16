package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaTranslate extends AbsDrawAction {
    public static final String ACTION_TYPE = "translate";
    private int mX;
    private int mY;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.mX = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
            this.mY = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (canvasContext.GetMatrixOrigin() == 0) {
            canvasContext.SaveMatrixOrigin(canvas.save());
        }
        canvas.translate(this.mX, this.mY);
    }
}
