package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ao extends a {
    private int alR;
    private int alS;
    private String ama;
    private float amB = -1.0f;
    private float amC = 0.0f;
    private float mStrokeWidth = 1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.ama = jSONArray.optString(0);
                this.alR = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
                this.alS = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.amB = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(3));
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
        if (!TextUtils.isEmpty(this.ama)) {
            TextPaint textPaint = bVar.alz;
            int i = bVar.alE;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.alS;
            float f3 = fontMetrics.ascent + this.alS;
            float f4 = fontMetrics.bottom + this.alS;
            switch (i) {
                case 1:
                    f = this.alS + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.alS + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.alS - (f3 - f2);
                    break;
                default:
                    f = this.alS;
                    break;
            }
            if (this.amC == 0.0d) {
                textPaint.getTextBounds(this.ama, 0, this.ama.length(), new Rect());
                if (this.amB == -1.0f || rect.width() <= this.amB) {
                    this.amC = 1.0f;
                } else {
                    this.amC = this.amB / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.mStrokeColor);
            bVar.a(textPaint);
            canvas.scale(this.amC, 1.0f);
            canvas.drawText(this.ama, this.alR, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
