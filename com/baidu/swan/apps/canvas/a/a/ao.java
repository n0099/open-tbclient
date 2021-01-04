package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class ao extends a {
    private int cMr;
    private int cMs;
    private String mText;
    private float cMR = -1.0f;
    private float cMS = 0.0f;
    private float mStrokeWidth = 1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.cMr = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
                this.cMs = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.cMR = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(3));
                }
                this.mStrokeWidth = com.baidu.swan.apps.ao.ah.O(1.0f);
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        float f;
        Rect rect;
        if (!TextUtils.isEmpty(this.mText)) {
            TextPaint textPaint = bVar.cLU;
            int i = bVar.cLZ;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.cMs;
            float f3 = fontMetrics.ascent + this.cMs;
            float f4 = fontMetrics.bottom + this.cMs;
            switch (i) {
                case 1:
                    f = this.cMs + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.cMs + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.cMs - (f3 - f2);
                    break;
                default:
                    f = this.cMs;
                    break;
            }
            if (this.cMS == 0.0d) {
                textPaint.getTextBounds(this.mText, 0, this.mText.length(), new Rect());
                if (this.cMR == -1.0f || rect.width() <= this.cMR) {
                    this.cMS = 1.0f;
                } else {
                    this.cMS = this.cMR / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.aIr);
            bVar.b(textPaint);
            canvas.scale(this.cMS, 1.0f);
            canvas.drawText(this.mText, this.cMr, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
