package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaSetFontSize extends AbsDrawAction {
    public static final String ACTION_TYPE = "setFontSize";
    private int mFontSize;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                this.mFontSize = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mFontSize > 0) {
            canvasContext.mFontPaint.setTextSize(this.mFontSize);
        }
    }
}
