package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ao extends a {
    private int aFT;
    private int aFU;
    private float aGB = -1.0f;
    private float aGC = 0.0f;
    private float mStrokeWidth = 1.0f;
    private String mText;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.aFT = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
                this.aFU = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.aGB = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(3));
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
            TextPaint textPaint = bVar.aFB;
            int i = bVar.aFG;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.aFU;
            float f3 = fontMetrics.ascent + this.aFU;
            float f4 = fontMetrics.bottom + this.aFU;
            switch (i) {
                case 1:
                    f = this.aFU + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.aFU + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.aFU - (f3 - f2);
                    break;
                default:
                    f = this.aFU;
                    break;
            }
            if (this.aGC == 0.0d) {
                textPaint.getTextBounds(this.mText, 0, this.mText.length(), new Rect());
                if (this.aGB == -1.0f || rect.width() <= this.aGB) {
                    this.aGC = 1.0f;
                } else {
                    this.aGC = this.aGB / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.mStrokeColor);
            bVar.a(textPaint);
            canvas.scale(this.aGC, 1.0f);
            canvas.drawText(this.mText, this.aFT, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
