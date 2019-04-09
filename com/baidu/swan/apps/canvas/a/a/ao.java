package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ao extends a {
    private int alF;
    private int alG;
    private String alO;
    private float amp = -1.0f;
    private float amq = 0.0f;
    private float mStrokeWidth = 1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.alO = jSONArray.optString(0);
                this.alF = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.alG = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.amp = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(3));
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
        if (!TextUtils.isEmpty(this.alO)) {
            TextPaint textPaint = bVar.aln;
            int i = bVar.als;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.alG;
            float f3 = fontMetrics.ascent + this.alG;
            float f4 = fontMetrics.bottom + this.alG;
            switch (i) {
                case 1:
                    f = this.alG + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.alG + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.alG - (f3 - f2);
                    break;
                default:
                    f = this.alG;
                    break;
            }
            if (this.amq == 0.0d) {
                textPaint.getTextBounds(this.alO, 0, this.alO.length(), new Rect());
                if (this.amp == -1.0f || rect.width() <= this.amp) {
                    this.amq = 1.0f;
                } else {
                    this.amq = this.amp / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.mStrokeColor);
            bVar.a(textPaint);
            canvas.scale(this.amq, 1.0f);
            canvas.drawText(this.alO, this.alF, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
