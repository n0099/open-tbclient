package com.baidu.live.yuyinim.view;

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
/* loaded from: classes4.dex */
public class a extends ReplacementSpan {
    private Resources bls;
    private float blt;
    private float blu;
    private float blv;
    private Paint blw;
    private float blx;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.blu;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.blv) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bls.getDimensionPixelOffset(a.d.sdk_ds14);
        this.blw.setShader(new LinearGradient(f, 0.0f, f + this.blu, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.blu + f, this.blv + f2), this.blx, this.blx, this.blw);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        canvas.drawText("*", dimensionPixelOffset + f, ((((this.blv - f3) * 0.5f) + f2) - fontMetrics2.top) + 4, this.mTextPaint);
        canvas.drawText(this.mText, this.blt + f + dimensionPixelOffset, (((this.blv - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.bls = context.getResources();
        this.mTextSize = this.bls.getDimensionPixelSize(a.d.sdk_fontsize18);
        this.mText = str;
        sw();
        MG();
        this.blx = this.blv / 2.0f;
    }

    private void MG() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.blt = this.mTextPaint.measureText("*") + 4.0f;
        this.blu = rect.width() + this.blt + (this.bls.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        this.blv = rect.height() + (this.bls.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void sw() {
        MH();
        MI();
    }

    private void MH() {
        this.blw = new Paint();
        this.blw.setAntiAlias(true);
        this.blw.setStyle(Paint.Style.FILL);
    }

    private void MI() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(Color.parseColor("#FFFFFFFF"));
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    }
}
