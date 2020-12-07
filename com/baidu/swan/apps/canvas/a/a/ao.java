package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class ao extends a {
    private int cHC;
    private int cHD;
    private float cIa = -1.0f;
    private float cIb = 0.0f;
    private float mStrokeWidth = 1.0f;
    private String mText;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.cHC = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
                this.cHD = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.cIa = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(3));
                }
                this.mStrokeWidth = com.baidu.swan.apps.ap.ah.M(1.0f);
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
            TextPaint textPaint = bVar.cHd;
            int i = bVar.cHi;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.cHD;
            float f3 = fontMetrics.ascent + this.cHD;
            float f4 = fontMetrics.bottom + this.cHD;
            switch (i) {
                case 1:
                    f = this.cHD + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.cHD + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.cHD - (f3 - f2);
                    break;
                default:
                    f = this.cHD;
                    break;
            }
            if (this.cIb == 0.0d) {
                textPaint.getTextBounds(this.mText, 0, this.mText.length(), new Rect());
                if (this.cIa == -1.0f || rect.width() <= this.cIa) {
                    this.cIb = 1.0f;
                } else {
                    this.cIb = this.cIa / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.mStrokeColor);
            bVar.a(textPaint);
            canvas.scale(this.cIb, 1.0f);
            canvas.drawText(this.mText, this.cHC, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
