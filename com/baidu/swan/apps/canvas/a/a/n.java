package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n extends a {
    private int alA;
    private int alB;
    private String alJ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.alJ = jSONArray.optString(0);
                this.alA = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.alB = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(2));
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
            int alpha = textPaint.getAlpha();
            bVar.a(textPaint);
            canvas.drawText(this.alJ, this.alA, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }
}
