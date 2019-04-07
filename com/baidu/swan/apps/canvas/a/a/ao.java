package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ao extends a {
    private int alE;
    private int alF;
    private String alN;
    private float amo = -1.0f;
    private float amp = 0.0f;
    private float mStrokeWidth = 1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.alN = jSONArray.optString(0);
                this.alE = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.alF = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.amo = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(3));
                }
                this.mStrokeWidth = com.baidu.swan.apps.an.x.ad(1.0f);
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
        if (!TextUtils.isEmpty(this.alN)) {
            TextPaint textPaint = bVar.alm;
            int i = bVar.alr;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.alF;
            float f3 = fontMetrics.ascent + this.alF;
            float f4 = fontMetrics.bottom + this.alF;
            switch (i) {
                case 1:
                    f = this.alF + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.alF + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.alF - (f3 - f2);
                    break;
                default:
                    f = this.alF;
                    break;
            }
            if (this.amp == 0.0d) {
                textPaint.getTextBounds(this.alN, 0, this.alN.length(), new Rect());
                if (this.amo == -1.0f || rect.width() <= this.amo) {
                    this.amp = 1.0f;
                } else {
                    this.amp = this.amo / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.mStrokeColor);
            bVar.a(textPaint);
            canvas.scale(this.amp, 1.0f);
            canvas.drawText(this.alN, this.alE, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
