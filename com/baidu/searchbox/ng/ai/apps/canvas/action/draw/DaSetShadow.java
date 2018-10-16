package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaSetShadow extends AbsDrawAction {
    public static final String ACTION_TYPE = "setShadow";
    private DaShadow mShadow;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        this.mShadow = new DaShadow(jSONArray);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mShadow != null && this.mShadow.isValid()) {
            canvasContext.mShadow = this.mShadow;
        }
    }
}
