package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaArc extends AbsDrawAction {
    public static final String ACTION_TYPE = "arc";
    private RectF mOval;
    private float mStartAngle;
    private float mSweepAngle;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int dp2px = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
            int dp2px2 = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
            int dp2px3 = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            this.mOval = new RectF(dp2px - dp2px3, dp2px2 - dp2px3, dp2px + dp2px3, dp2px2 + dp2px3);
            this.mStartAngle = degrees;
            this.mSweepAngle = ((float) Math.toDegrees((float) jSONArray.optDouble(4))) - degrees;
        }
        if (jSONArray.length() > 5 && jSONArray.optBoolean(5)) {
            this.mSweepAngle = -Math.abs(this.mSweepAngle);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mOval != null) {
            if (Math.abs(this.mSweepAngle) < 360.0f) {
                canvasContext.mPath.arcTo(this.mOval, this.mStartAngle, this.mSweepAngle);
                return;
            }
            float f = this.mSweepAngle % 360.0f;
            canvasContext.mPath.arcTo(this.mOval, this.mStartAngle, 180.0f);
            canvasContext.mPath.arcTo(this.mOval, this.mStartAngle, -180.0f, true);
            if (f != 0.0f) {
                canvasContext.mPath.arcTo(this.mOval, this.mStartAngle, f, true);
            }
        }
    }
}
