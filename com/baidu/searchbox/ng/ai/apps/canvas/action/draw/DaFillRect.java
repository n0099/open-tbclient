package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaFillRect extends AbsDrawAction {
    public static final String ACTION_TYPE = "fillRect";
    private Rect mRect;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int dp2px = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
                int dp2px2 = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
                this.mRect = new Rect(dp2px, dp2px2, AiAppsUIUtils.dp2px((float) jSONArray.optDouble(2)) + dp2px, AiAppsUIUtils.dp2px((float) jSONArray.optDouble(3)) + dp2px2);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mRect != null) {
            int alpha = canvasContext.mFillPaint.getAlpha();
            canvasContext.applyGlobal(canvasContext.mFillPaint);
            canvas.drawRect(this.mRect, canvasContext.mFillPaint);
            canvasContext.mFillPaint.setAlpha(alpha);
        }
    }
}
