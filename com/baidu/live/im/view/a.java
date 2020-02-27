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
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends ReplacementSpan {
    private Resources auG;
    private float auH;
    private float auI;
    private Paint auJ;
    private float auK;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.auH;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.auI) * 0.5f) + i4 + fontMetrics.ascent;
        this.auJ.setShader(new LinearGradient(f, 0.0f, f + this.auH, 0.0f, Color.parseColor("#FFFED33B"), Color.parseColor("#FFFEAF01"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.auH + f, this.auI + f2), this.auK, this.auK, this.auJ);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        canvas.drawText(this.mText, (this.auH * 0.5f) + f, (((this.auI - (fontMetrics2.bottom - fontMetrics2.top)) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.auG = context.getResources();
        this.mTextSize = this.auG.getDimensionPixelSize(a.e.sdk_fontsize24);
        this.mText = str;
        xY();
        lQ();
        this.auK = this.auG.getDimensionPixelOffset(a.e.sdk_ds6);
    }

    private void xY() {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.auH = rect.width() + (this.auG.getDimensionPixelOffset(a.e.sdk_ds6) * 2);
        this.auI = rect.height() + (this.auG.getDimensionPixelOffset(a.e.sdk_ds4) * 2);
    }

    private void lQ() {
        xZ();
        ya();
    }

    private void xZ() {
        this.auJ = new Paint();
        this.auJ.setAntiAlias(true);
        this.auJ.setStyle(Paint.Style.FILL);
    }

    private void ya() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(Color.parseColor("#FFFFFFFF"));
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    }
}
