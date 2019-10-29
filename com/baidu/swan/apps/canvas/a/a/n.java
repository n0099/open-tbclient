package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n extends a {
    private int aGl;
    private int aGm;
    private String mText;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.aGl = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
                this.aGm = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(2));
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
            TextPaint textPaint = bVar.aFT;
            int i = bVar.aFY;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.aGm;
            float f3 = fontMetrics.ascent + this.aGm;
            float f4 = fontMetrics.bottom + this.aGm;
            switch (i) {
                case 1:
                    f = this.aGm + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.aGm + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.aGm - (f3 - f2);
                    break;
                default:
                    f = this.aGm;
                    break;
            }
            int alpha = textPaint.getAlpha();
            bVar.a(textPaint);
            canvas.drawText(this.mText, this.aGl, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }
}
