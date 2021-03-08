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
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class a extends ReplacementSpan {
    private Resources bjd;
    private float bje;
    private float bjf;
    private Paint bjg;
    private Paint bjh;
    private float bji;
    private float bsK;
    private String mText;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bje;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bjf) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bjd.getDimensionPixelOffset(a.d.sdk_ds14);
        this.bjg.setShader(new LinearGradient(f, 0.0f, f + this.bje, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.bje + f, this.bjf + f2), this.bji, this.bji, this.bjg);
        Paint.FontMetrics fontMetrics2 = this.bjh.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        canvas.drawText("*", dimensionPixelOffset + f, ((((this.bjf - f3) * 0.5f) + f2) - fontMetrics2.top) + 4, this.bjh);
        canvas.drawText(this.mText, this.bsK + f + dimensionPixelOffset, (((this.bjf - f3) * 0.5f) + f2) - fontMetrics2.top, this.bjh);
    }

    private void init(Context context, String str) {
        this.bjd = context.getResources();
        this.mTextSize = this.bjd.getDimensionPixelSize(a.d.sdk_fontsize18);
        this.mText = str;
        rX();
        IC();
        this.bji = this.bjf / 2.0f;
    }

    private void IC() {
        Rect rect = new Rect();
        this.bjh.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bsK = this.bjh.measureText("*") + 4.0f;
        this.bje = rect.width() + this.bsK + (this.bjd.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        this.bjf = rect.height() + (this.bjd.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void rX() {
        ID();
        IE();
    }

    private void ID() {
        this.bjg = new Paint();
        this.bjg.setAntiAlias(true);
        this.bjg.setStyle(Paint.Style.FILL);
    }

    private void IE() {
        this.bjh = new TextPaint();
        this.bjh.setAntiAlias(true);
        this.bjh.setColor(Color.parseColor("#FFFFFFFF"));
        this.bjh.setFakeBoldText(true);
        this.bjh.setTextSize(this.mTextSize);
        this.bjh.setTextAlign(Paint.Align.LEFT);
    }
}
