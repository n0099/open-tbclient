package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n extends a {
    private String amD;
    private int amu;
    private int amv;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.amD = jSONArray.optString(0);
                this.amu = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
                this.amv = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
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
        if (!TextUtils.isEmpty(this.amD)) {
            TextPaint textPaint = bVar.amc;
            int i = bVar.amh;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.amv;
            float f3 = fontMetrics.ascent + this.amv;
            float f4 = fontMetrics.bottom + this.amv;
            switch (i) {
                case 1:
                    f = this.amv + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.amv + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.amv - (f3 - f2);
                    break;
                default:
                    f = this.amv;
                    break;
            }
            int alpha = textPaint.getAlpha();
            bVar.a(textPaint);
            canvas.drawText(this.amD, this.amu, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }
}
