package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public abstract class AbsDrawAction {
    protected static final int INVALID_COORDINATE = Integer.MAX_VALUE;
    protected static final String MODULE_TAG = "CanvasDraw";

    public abstract void draw(CanvasContext canvasContext, Canvas canvas);

    public abstract void parseJson(JSONArray jSONArray);
}
