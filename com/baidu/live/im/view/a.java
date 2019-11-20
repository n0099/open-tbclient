package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class a extends ReplacementSpan {
    private Resources aiS;
    private float aiT;
    private float aiU;
    private Paint aiV;
    private Paint aiW;
    private float aiX;
    private String mText;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.aiT;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.aiU) * 0.5f) + i4 + fontMetrics.ascent;
        this.aiV.setShader(new LinearGradient(f, 0.0f, f + this.aiT, 0.0f, Color.parseColor("#FFFED33B"), Color.parseColor("#FFFEAF01"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.aiT + f, this.aiU + f2), this.aiX, this.aiX, this.aiV);
        Paint.FontMetrics fontMetrics2 = this.aiW.getFontMetrics();
        canvas.drawText(this.mText, (this.aiT * 0.5f) + f, (((this.aiU - (fontMetrics2.bottom - fontMetrics2.top)) * 0.5f) + f2) - fontMetrics2.top, this.aiW);
    }

    private void init(Context context, String str) {
        this.aiS = context.getResources();
        this.mTextSize = this.aiS.getDimensionPixelSize(a.e.sdk_fontsize24);
        this.mText = str;
        tV();
        lj();
        this.aiX = this.aiS.getDimensionPixelOffset(a.e.sdk_ds6);
    }

    private void tV() {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.aiT = rect.width() + (this.aiS.getDimensionPixelOffset(a.e.sdk_ds6) * 2);
        this.aiU = rect.height() + (this.aiS.getDimensionPixelOffset(a.e.sdk_ds4) * 2);
    }

    private void lj() {
        tW();
        tX();
    }

    private void tW() {
        this.aiV = new Paint();
        this.aiV.setAntiAlias(true);
        this.aiV.setStyle(Paint.Style.FILL);
    }

    private void tX() {
        this.aiW = new TextPaint();
        this.aiW.setAntiAlias(true);
        this.aiW.setColor(Color.parseColor("#FFFFFFFF"));
        this.aiW.setFakeBoldText(true);
        this.aiW.setTextSize(this.mTextSize);
        this.aiW.setTextAlign(Paint.Align.CENTER);
    }
}
