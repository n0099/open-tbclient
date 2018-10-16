package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Region;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaClip extends AbsDrawAction {
    public static final String ACTION_TYPE = "clip";

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        canvasContext.mIsClip = true;
        canvas.clipPath(canvasContext.mPath, Region.Op.INTERSECT);
    }
}
