package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaFillText extends AbsDrawAction {
    public static final String ACTION_TYPE = "fillText";
    private String mText;
    private int mX;
    private int mY;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.mX = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
                this.mY = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(2));
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        float f;
        if (!TextUtils.isEmpty(this.mText)) {
            TextPaint textPaint = canvasContext.mFontPaint;
            int i = canvasContext.mTextBaseLine;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.mY;
            float f3 = fontMetrics.ascent + this.mY;
            float f4 = fontMetrics.bottom + this.mY;
            switch (i) {
                case 1:
                    f = this.mY + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.mY + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.mY - (f3 - f2);
                    break;
                default:
                    f = this.mY;
                    break;
            }
            int alpha = textPaint.getAlpha();
            canvasContext.applyGlobal(textPaint);
            canvas.drawText(this.mText, this.mX, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }
}
