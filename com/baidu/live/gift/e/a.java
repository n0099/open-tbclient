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
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class a extends ReplacementSpan {
    private String aIi;
    private Resources bjd;
    private float bje;
    private float bjf;
    private Paint bjg;
    private Paint bjh;
    private float bji;
    private String endColor;
    private String mText;
    private int mTextSize;
    private String startColor;

    public a(Context context, String str, String str2, String str3, String str4, int i) {
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aIi = "#FFFFFFFF";
        this.startColor = str2;
        this.endColor = str3;
        this.aIi = str4;
        this.mTextSize = i;
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
        this.bjg.setShader(new LinearGradient(f, 0.0f, f + this.bje, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.bje + f, this.bjf + f2), this.bji, this.bji, this.bjg);
        Paint.FontMetrics fontMetrics2 = this.bjh.getFontMetrics();
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bjf - (fontMetrics2.bottom - fontMetrics2.top)) * 0.5f) + f2) - fontMetrics2.top, this.bjh);
    }

    private void init(Context context, String str) {
        this.bjd = context.getResources();
        if (this.mTextSize <= 0) {
            this.mTextSize = this.bjd.getDimensionPixelSize(a.d.sdk_fontsize18);
        }
        this.mText = str;
        rX();
        IC();
        this.bji = this.bjf / 2.0f;
    }

    private void IC() {
        Rect rect = new Rect();
        this.bjh.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bje = rect.width() + (this.bjd.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
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
        this.bjh.setFakeBoldText(true);
        this.bjh.setTextAlign(Paint.Align.LEFT);
        this.bjh.setColor(Color.parseColor(this.aIi));
        this.bjh.setTextSize(this.mTextSize);
    }
}
