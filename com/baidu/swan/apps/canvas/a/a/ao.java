package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ao extends a {
    private int aGl;
    private int aGm;
    private String mText;
    private float aGT = -1.0f;
    private float aGU = 0.0f;
    private float mStrokeWidth = 1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.aGl = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
                this.aGm = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.aGT = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(3));
                }
                this.mStrokeWidth = com.baidu.swan.apps.an.z.S(1.0f);
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
            TextPaint textPaint = bVar.aFT;
            int i = bVar.aFY;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.aGm;
            float f3 = fontMetrics.ascent + this.aGm;
            float f4 = fontMetrics.bottom + this.aGm;
            switch (i) {
                case 1:
                    f = this.aGm + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.aGm + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.aGm - (f3 - f2);
                    break;
                default:
                    f = this.aGm;
                    break;
            }
            if (this.aGU == 0.0d) {
                textPaint.getTextBounds(this.mText, 0, this.mText.length(), new Rect());
                if (this.aGT == -1.0f || rect.width() <= this.aGT) {
                    this.aGU = 1.0f;
                } else {
                    this.aGU = this.aGT / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.mStrokeColor);
            bVar.a(textPaint);
            canvas.scale(this.aGU, 1.0f);
            canvas.drawText(this.mText, this.aGl, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
