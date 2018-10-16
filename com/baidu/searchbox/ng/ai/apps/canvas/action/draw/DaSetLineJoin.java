package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaSetLineJoin extends AbsDrawAction {
    public static final String ACTION_TYPE = "setLineJoin";
    private static final String JOIN_TYPE_BUTT = "bevel";
    private static final String JOIN_TYPE_MITER = "miter";
    private static final String JOIN_TYPE_ROUND = "round";
    private Paint.Join mJoin;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, JOIN_TYPE_BUTT)) {
                this.mJoin = Paint.Join.BEVEL;
            } else if (TextUtils.equals(optString, JOIN_TYPE_ROUND)) {
                this.mJoin = Paint.Join.ROUND;
            } else if (TextUtils.equals(optString, JOIN_TYPE_MITER)) {
                this.mJoin = Paint.Join.MITER;
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mJoin != null) {
            canvasContext.mStrokePaint.setStrokeJoin(this.mJoin);
        }
    }
}
