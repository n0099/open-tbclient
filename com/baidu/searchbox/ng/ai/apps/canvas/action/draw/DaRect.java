package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaRect extends AbsDrawAction {
    public static final String ACTION_TYPE = "rect";
    private RectF mRect;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int dp2px = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
                int dp2px2 = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
                this.mRect = new RectF(dp2px, dp2px2, dp2px + AiAppsUIUtils.dp2px((float) jSONArray.optDouble(2)), dp2px2 + AiAppsUIUtils.dp2px((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mRect != null) {
            canvasContext.mPath.addRect(this.mRect, Path.Direction.CW);
        }
    }
}
