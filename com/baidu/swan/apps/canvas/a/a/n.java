package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n extends a {
    private int amS;
    private int amT;
    private String anb;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.anb = jSONArray.optString(0);
                this.amS = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
                this.amT = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
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
            int alpha = textPaint.getAlpha();
            bVar.a(textPaint);
            canvas.drawText(this.anb, this.amS, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }
}
