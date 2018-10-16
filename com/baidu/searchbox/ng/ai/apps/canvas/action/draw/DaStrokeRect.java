package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaStrokeRect extends AbsDrawAction {
    public static final String ACTION_TYPE = "strokeRect";
    private Path mPath;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int dp2px = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
                int dp2px2 = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
                int dp2px3 = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(2));
                int dp2px4 = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(3));
                this.mPath = new Path();
                this.mPath.addRect(new RectF(dp2px, dp2px2, dp2px + dp2px3, dp2px2 + dp2px4), Path.Direction.CW);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mPath != null) {
            int alpha = canvasContext.mStrokePaint.getAlpha();
            canvasContext.applyGlobal(canvasContext.mStrokePaint);
            canvas.drawPath(this.mPath, canvasContext.mStrokePaint);
            canvasContext.mStrokePaint.setAlpha(alpha);
        }
    }
}
