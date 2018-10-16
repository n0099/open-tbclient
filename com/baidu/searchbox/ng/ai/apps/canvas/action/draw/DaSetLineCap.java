package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaSetLineCap extends AbsDrawAction {
    public static final String ACTION_TYPE = "setLineCap";
    private static final String CAP_TYPE_BUTT = "butt";
    private static final String CAP_TYPE_ROUND = "round";
    private static final String CAP_TYPE_SQUARE = "square";
    private Paint.Cap mCap;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, CAP_TYPE_BUTT)) {
                this.mCap = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, CAP_TYPE_ROUND)) {
                this.mCap = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, CAP_TYPE_SQUARE)) {
                this.mCap = Paint.Cap.SQUARE;
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mCap != null) {
            canvasContext.mStrokePaint.setStrokeCap(this.mCap);
        }
    }
}
