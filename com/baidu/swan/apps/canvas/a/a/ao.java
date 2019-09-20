package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ao extends a {
    private int amS;
    private int amT;
    private String anb;
    private float anC = -1.0f;
    private float anD = 0.0f;
    private float mStrokeWidth = 1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.anb = jSONArray.optString(0);
                this.amS = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
                this.amT = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.anC = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(3));
                }
                this.mStrokeWidth = com.baidu.swan.apps.an.z.ad(1.0f);
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
        if (!TextUtils.isEmpty(this.anb)) {
            TextPaint textPaint = bVar.amA;
            int i = bVar.amF;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.amT;
            float f3 = fontMetrics.ascent + this.amT;
            float f4 = fontMetrics.bottom + this.amT;
            switch (i) {
                case 1:
                    f = this.amT + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.amT + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.amT - (f3 - f2);
                    break;
                default:
                    f = this.amT;
                    break;
            }
            if (this.anD == 0.0d) {
                textPaint.getTextBounds(this.anb, 0, this.anb.length(), new Rect());
                if (this.anC == -1.0f || rect.width() <= this.anC) {
                    this.anD = 1.0f;
                } else {
                    this.anD = this.anC / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.mStrokeColor);
            bVar.a(textPaint);
            canvas.scale(this.anD, 1.0f);
            canvas.drawText(this.anb, this.amS, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
