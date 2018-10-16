package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaQuadraticCurveTo extends AbsDrawAction {
    public static final String ACTION_TYPE = "quadraticCurveTo";
    private float mCpx;
    private float mCpy;
    private boolean mIsValid = false;
    private float mX;
    private float mY;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 3) {
            this.mCpx = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
            this.mCpy = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
            this.mX = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(2));
            this.mY = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(3));
            this.mIsValid = true;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mIsValid) {
            canvasContext.mPath.quadTo(this.mCpx, this.mCpy, this.mX, this.mY);
        }
    }
}
