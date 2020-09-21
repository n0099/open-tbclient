package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class ao extends a {
    private float ccc = -1.0f;
    private float ccd = 0.0f;
    private float mStrokeWidth = 1.0f;
    private String mText;
    private int mX;
    private int mY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.mText = jSONArray.optString(0);
                this.mX = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(1));
                this.mY = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.ccc = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(3));
                }
                this.mStrokeWidth = com.baidu.swan.apps.ap.ah.H(1.0f);
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
        if (!TextUtils.isEmpty(this.mText)) {
            TextPaint textPaint = bVar.cbj;
            int i = bVar.cbo;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top + this.mY;
            float f3 = fontMetrics.ascent + this.mY;
            float f4 = fontMetrics.bottom + this.mY;
            switch (i) {
                case 1:
                    f = this.mY + ((f4 - f2) / 2.0f) + (f3 - f2);
                    break;
                case 2:
                    f = (this.mY + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
                    break;
                case 3:
                    f = this.mY - (f3 - f2);
                    break;
                default:
                    f = this.mY;
                    break;
            }
            if (this.ccd == 0.0d) {
                textPaint.getTextBounds(this.mText, 0, this.mText.length(), new Rect());
                if (this.ccc == -1.0f || rect.width() <= this.ccc) {
                    this.ccd = 1.0f;
                } else {
                    this.ccd = this.ccc / rect.width();
                }
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.mStrokeWidth);
            textPaint.setColor(bVar.mStrokeColor);
            bVar.a(textPaint);
            canvas.scale(this.ccd, 1.0f);
            canvas.drawText(this.mText, this.mX, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }
}
