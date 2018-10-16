package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaBezierCurveTo extends AbsDrawAction {
    public static final String ACTION_TYPE = "bezierCurveTo";
    private float mCp1x;
    private float mCp1y;
    private float mCp2x;
    private float mCp2y;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 5) {
            this.mCp1x = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
            this.mCp1y = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
            this.mCp2x = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(2));
            this.mCp2y = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(3));
            this.mX = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(4));
            this.mY = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(5));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mIsValid) {
            canvasContext.mPath.cubicTo(this.mCp1x, this.mCp1y, this.mCp2x, this.mCp2y, this.mX, this.mY);
        }
    }
}
