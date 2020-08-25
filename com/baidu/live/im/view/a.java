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
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class a extends ReplacementSpan {
    private Resources bdG;
    private float bdH;
    private float bdI;
    private float bdJ;
    private Paint bdK;
    private float bdL;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bdI;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bdJ) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bdG.getDimensionPixelOffset(a.e.sdk_ds14);
        this.bdK.setShader(new LinearGradient(f, 0.0f, f + this.bdI, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.bdI + f, this.bdJ + f2), this.bdL, this.bdL, this.bdK);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        canvas.drawText("*", dimensionPixelOffset + f, ((((this.bdJ - f3) * 0.5f) + f2) - fontMetrics2.top) + 4, this.mTextPaint);
        canvas.drawText(this.mText, this.bdH + f + dimensionPixelOffset, (((this.bdJ - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.bdG = context.getResources();
        this.mTextSize = this.bdG.getDimensionPixelSize(a.e.sdk_fontsize18);
        this.mText = str;
        sr();
        KJ();
        this.bdL = this.bdJ / 2.0f;
    }

    private void KJ() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bdH = this.mTextPaint.measureText("*") + 4.0f;
        this.bdI = rect.width() + this.bdH + (this.bdG.getDimensionPixelOffset(a.e.sdk_ds14) * 2);
        this.bdJ = rect.height() + (this.bdG.getDimensionPixelOffset(a.e.sdk_ds6) * 2);
    }

    private void sr() {
        KK();
        KL();
    }

    private void KK() {
        this.bdK = new Paint();
        this.bdK.setAntiAlias(true);
        this.bdK.setStyle(Paint.Style.FILL);
    }

    private void KL() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(Color.parseColor("#FFFFFFFF"));
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    }
}
