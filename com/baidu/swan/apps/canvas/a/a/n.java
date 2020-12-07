package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class n extends a {
    private int cHC;
    private int cHD;
    private String mText;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.cHC = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
                this.cHD = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(2));
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
            TextPaint textPaint = bVar.cHd;
            int i = bVar.cHi;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.cHD;
            float f3 = fontMetrics.ascent + this.cHD;
            float f4 = fontMetrics.bottom + this.cHD;
            switch (i) {
                case 1:
                    f = this.cHD + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.cHD + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.cHD - (f3 - f2);
                    break;
                default:
                    f = this.cHD;
                    break;
            }
            int alpha = textPaint.getAlpha();
            bVar.a(textPaint);
            canvas.drawText(this.mText, this.cHC, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }
}
