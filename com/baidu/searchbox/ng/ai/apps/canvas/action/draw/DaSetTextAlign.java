package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaSetTextAlign extends AbsDrawAction {
    public static final String ACTION_TYPE = "setTextAlign";
    private Paint.Align mAlign;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, "left")) {
                    this.mAlign = Paint.Align.LEFT;
                } else if (TextUtils.equals(optString, "center")) {
                    this.mAlign = Paint.Align.CENTER;
                } else if (TextUtils.equals(optString, "right")) {
                    this.mAlign = Paint.Align.RIGHT;
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (this.mAlign != null) {
            canvasContext.mFontPaint.setTextAlign(this.mAlign);
        }
    }
}
