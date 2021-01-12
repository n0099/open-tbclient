package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class n extends a {
    private int cHF;
    private int cHG;
    private String mText;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.cHF = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
                this.cHG = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(2));
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
        if (!TextUtils.isEmpty(this.mText)) {
            TextPaint textPaint = bVar.cHi;
            int i = bVar.cHn;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.cHG;
            float f3 = fontMetrics.ascent + this.cHG;
            float f4 = fontMetrics.bottom + this.cHG;
            switch (i) {
                case 1:
                    f = this.cHG + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.cHG + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.cHG - (f3 - f2);
                    break;
                default:
                    f = this.cHG;
                    break;
            }
            int alpha = textPaint.getAlpha();
            bVar.b(textPaint);
            canvas.drawText(this.mText, this.cHF, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }
}
