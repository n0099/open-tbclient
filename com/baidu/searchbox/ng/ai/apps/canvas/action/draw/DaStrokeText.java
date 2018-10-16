package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaStrokeText extends AbsDrawAction {
    public static final String ACTION_TYPE = "strokeText";
    private String mText;
    private int mX;
    private int mY;
    private float mMaxWidth = -1.0f;
    private float mXScale = 0.0f;
    private float mStrokeWidth = 1.0f;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.mX = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(1));
                this.mY = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.mMaxWidth = AiAppsUIUtils.dp2px((float) jSONArray.optDouble(3));
                }
                this.mStrokeWidth = AiAppsUIUtils.dp2px(1.0f);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        float f;
        Rect rect;
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
            if (this.mXScale == 0.0d) {
                textPaint.getTextBounds(this.mText, 0, this.mText.length(), new Rect());
                if (this.mMaxWidth == -1.0f || rect.width() <= this.mMaxWidth) {
                    this.mXScale = 1.0f;
                } else {
                    this.mXScale = this.mMaxWidth / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(canvasContext.mStrokeColor);
            canvasContext.applyGlobal(textPaint);
            canvas.scale(this.mXScale, 1.0f);
            canvas.drawText(this.mText, this.mX, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
