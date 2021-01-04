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
/* loaded from: classes11.dex */
public class a extends ReplacementSpan {
    private String aWd;
    private Resources bjk;
    private float bjl;
    private float bjm;
    private Paint bjn;
    private Paint bjo;
    private float bjp;
    private String endColor;
    private String mText;
    private int mTextSize;
    private String startColor;

    public a(Context context, String str, String str2, String str3, String str4, int i) {
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aWd = "#FFFFFFFF";
        this.startColor = str2;
        this.endColor = str3;
        this.aWd = str4;
        this.mTextSize = i;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bjl;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bjm) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bjk.getDimensionPixelOffset(a.d.sdk_ds14);
        this.bjn.setShader(new LinearGradient(f, 0.0f, f + this.bjl, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.bjl + f, this.bjm + f2), this.bjp, this.bjp, this.bjn);
        Paint.FontMetrics fontMetrics2 = this.bjo.getFontMetrics();
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bjm - (fontMetrics2.bottom - fontMetrics2.top)) * 0.5f) + f2) - fontMetrics2.top, this.bjo);
    }

    private void init(Context context, String str) {
        this.bjk = context.getResources();
        if (this.mTextSize <= 0) {
            this.mTextSize = this.bjk.getDimensionPixelSize(a.d.sdk_fontsize18);
        }
        this.mText = str;
        sa();
        Le();
        this.bjp = this.bjm / 2.0f;
    }

    private void Le() {
        Rect rect = new Rect();
        this.bjo.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bjl = rect.width() + (this.bjk.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        this.bjm = rect.height() + (this.bjk.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void sa() {
        Lf();
        Lg();
    }

    private void Lf() {
        this.bjn = new Paint();
        this.bjn.setAntiAlias(true);
        this.bjn.setStyle(Paint.Style.FILL);
    }

    private void Lg() {
        this.bjo = new TextPaint();
        this.bjo.setAntiAlias(true);
        this.bjo.setFakeBoldText(true);
        this.bjo.setTextAlign(Paint.Align.LEFT);
        this.bjo.setColor(Color.parseColor(this.aWd));
        this.bjo.setTextSize(this.mTextSize);
    }
}
