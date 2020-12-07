package com.baidu.live.gift.e;

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
    private String aUL;
    private Resources bhC;
    private float bhD;
    private float bhE;
    private Paint bhF;
    private float bhG;
    private String endColor;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;
    private String startColor;

    public a(Context context, String str, String str2, String str3, String str4, int i) {
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aUL = "#FFFFFFFF";
        this.startColor = str2;
        this.endColor = str3;
        this.aUL = str4;
        this.mTextSize = i;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bhD;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bhE) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bhC.getDimensionPixelOffset(a.d.sdk_ds14);
        this.bhF.setShader(new LinearGradient(f, 0.0f, f + this.bhD, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.bhD + f, this.bhE + f2), this.bhG, this.bhG, this.bhF);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bhE - (fontMetrics2.bottom - fontMetrics2.top)) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.bhC = context.getResources();
        if (this.mTextSize <= 0) {
            this.mTextSize = this.bhC.getDimensionPixelSize(a.d.sdk_fontsize18);
        }
        this.mText = str;
        sz();
        LF();
        this.bhG = this.bhE / 2.0f;
    }

    private void LF() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bhD = rect.width() + (this.bhC.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        this.bhE = rect.height() + (this.bhC.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void sz() {
        LG();
        LH();
    }

    private void LG() {
        this.bhF = new Paint();
        this.bhF.setAntiAlias(true);
        this.bhF.setStyle(Paint.Style.FILL);
    }

    private void LH() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        this.mTextPaint.setColor(Color.parseColor(this.aUL));
        this.mTextPaint.setTextSize(this.mTextSize);
    }
}
