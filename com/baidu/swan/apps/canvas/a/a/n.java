package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n extends a {
    private int alR;
    private int alS;
    private String ama;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.ama = jSONArray.optString(0);
                this.alR = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
                this.alS = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(2));
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
            int alpha = textPaint.getAlpha();
            bVar.a(textPaint);
            canvas.drawText(this.ama, this.alR, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }
}
