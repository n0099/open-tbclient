package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class ao extends a {
    private int cHF;
    private int cHG;
    private float cIf = -1.0f;
    private float cIg = 0.0f;
    private float mStrokeWidth = 1.0f;
    private String mText;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.cHF = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
                this.cHG = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.cIf = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(3));
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
            TextPaint textPaint = bVar.cHi;
            int i = bVar.cHn;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.cHG;
            float f3 = fontMetrics.ascent + this.cHG;
            float f4 = fontMetrics.bottom + this.cHG;
            switch (i) {
                case 1:
                    f = this.cHG + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.cHG + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.cHG - (f3 - f2);
                    break;
                default:
                    f = this.cHG;
                    break;
            }
            if (this.cIg == 0.0d) {
                textPaint.getTextBounds(this.mText, 0, this.mText.length(), new Rect());
                if (this.cIf == -1.0f || rect.width() <= this.cIf) {
                    this.cIg = 1.0f;
                } else {
                    this.cIg = this.cIf / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.aDE);
            bVar.b(textPaint);
            canvas.scale(this.cIg, 1.0f);
            canvas.drawText(this.mText, this.cHF, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
