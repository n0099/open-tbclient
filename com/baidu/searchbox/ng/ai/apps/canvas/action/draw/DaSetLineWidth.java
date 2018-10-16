package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaSetLineWidth extends AbsDrawAction {
    public static final String ACTION_TYPE = "setLineWidth";
    private int mLineWidth = -1;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.mLineWidth = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mLineWidth >= 0) {
            canvasContext.mStrokePaint.setStrokeWidth(this.mLineWidth);
        }
    }
}
