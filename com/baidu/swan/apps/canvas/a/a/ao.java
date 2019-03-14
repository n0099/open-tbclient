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
    private int alB;
    private String alJ;
    private float amk = -1.0f;
    private float aml = 0.0f;
    private float mStrokeWidth = 1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.alJ = jSONArray.optString(0);
                this.alA = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.alB = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.amk = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(3));
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
        if (!TextUtils.isEmpty(this.alJ)) {
            TextPaint textPaint = bVar.alh;
            int i = bVar.aln;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.alB;
            float f3 = fontMetrics.ascent + this.alB;
            float f4 = fontMetrics.bottom + this.alB;
            switch (i) {
                case 1:
                    f = this.alB + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.alB + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.alB - (f3 - f2);
                    break;
                default:
                    f = this.alB;
                    break;
            }
            if (this.aml == 0.0d) {
                textPaint.getTextBounds(this.alJ, 0, this.alJ.length(), new Rect());
                if (this.amk == -1.0f || rect.width() <= this.amk) {
                    this.aml = 1.0f;
                } else {
                    this.aml = this.amk / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.mStrokeColor);
            bVar.a(textPaint);
            canvas.scale(this.aml, 1.0f);
            canvas.drawText(this.alJ, this.alA, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
