package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n extends a {
    private int alF;
    private int alG;
    private String alO;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.alO = jSONArray.optString(0);
                this.alF = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.alG = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
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
            int alpha = textPaint.getAlpha();
            bVar.a(textPaint);
            canvas.drawText(this.alO, this.alF, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }
}
