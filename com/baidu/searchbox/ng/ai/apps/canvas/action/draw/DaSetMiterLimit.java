package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaSetMiterLimit extends AbsDrawAction {
    public static final String ACTION_TYPE = "setMiterLimit";
    private int mMiterLimit = -1;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.mMiterLimit = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(0));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mMiterLimit >= 0) {
            canvasContext.mStrokePaint.setStrokeMiter(this.mMiterLimit);
        }
    }
}
