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
    private float aOA;
    private float aOB;
    private Paint aOC;
    private float aOD;
    private Resources aOy;
    private float aOz;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.aOA;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.aOB) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.aOy.getDimensionPixelOffset(a.e.sdk_ds14);
        this.aOC.setShader(new LinearGradient(f, 0.0f, f + this.aOA, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.aOA + f, this.aOB + f2), this.aOD, this.aOD, this.aOC);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        canvas.drawText("*", dimensionPixelOffset + f, ((((this.aOB - f3) * 0.5f) + f2) - fontMetrics2.top) + 4, this.mTextPaint);
        canvas.drawText(this.mText, this.aOz + f + dimensionPixelOffset, (((this.aOB - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.aOy = context.getResources();
        this.mTextSize = this.aOy.getDimensionPixelSize(a.e.sdk_fontsize18);
        this.mText = str;
        qs();
        CU();
        this.aOD = this.aOB / 2.0f;
    }

    private void CU() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.aOz = this.mTextPaint.measureText("*") + 4.0f;
        this.aOA = rect.width() + this.aOz + (this.aOy.getDimensionPixelOffset(a.e.sdk_ds14) * 2);
        this.aOB = rect.height() + (this.aOy.getDimensionPixelOffset(a.e.sdk_ds6) * 2);
    }

    private void qs() {
        CV();
        CW();
    }

    private void CV() {
        this.aOC = new Paint();
        this.aOC.setAntiAlias(true);
        this.aOC.setStyle(Paint.Style.FILL);
    }

    private void CW() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(Color.parseColor("#FFFFFFFF"));
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    }
}
