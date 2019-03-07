package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ao extends a {
    private int alA;
    private String alI;
    private int alz;
    private float amj = -1.0f;
    private float amk = 0.0f;
    private float mStrokeWidth = 1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.alI = jSONArray.optString(0);
                this.alz = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.alA = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.amj = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(3));
                }
                this.mStrokeWidth = com.baidu.swan.apps.an.x.ad(1.0f);
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        float f;
        Rect rect;
        if (!TextUtils.isEmpty(this.alI)) {
            TextPaint textPaint = bVar.alg;
            int i = bVar.alm;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.alA;
            float f3 = fontMetrics.ascent + this.alA;
            float f4 = fontMetrics.bottom + this.alA;
            switch (i) {
                case 1:
                    f = this.alA + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.alA + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.alA - (f3 - f2);
                    break;
                default:
                    f = this.alA;
                    break;
            }
            if (this.amk == 0.0d) {
                textPaint.getTextBounds(this.alI, 0, this.alI.length(), new Rect());
                if (this.amj == -1.0f || rect.width() <= this.amj) {
                    this.amk = 1.0f;
                } else {
                    this.amk = this.amj / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.mStrokeColor);
            bVar.a(textPaint);
            canvas.scale(this.amk, 1.0f);
            canvas.drawText(this.alI, this.alz, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
