package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n extends a {
    private int alE;
    private int alF;
    private String alN;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.alN = jSONArray.optString(0);
                this.alE = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.alF = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
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
            int alpha = textPaint.getAlpha();
            bVar.a(textPaint);
            canvas.drawText(this.alN, this.alE, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }
}
