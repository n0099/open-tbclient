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
    private Resources ajk;
    private float ajl;
    private float ajm;
    private Paint ajn;
    private Paint ajo;
    private float ajp;
    private String mText;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.ajl;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.ajm) * 0.5f) + i4 + fontMetrics.ascent;
        this.ajn.setShader(new LinearGradient(f, 0.0f, f + this.ajl, 0.0f, Color.parseColor("#FFFED33B"), Color.parseColor("#FFFEAF01"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.ajl + f, this.ajm + f2), this.ajp, this.ajp, this.ajn);
        Paint.FontMetrics fontMetrics2 = this.ajo.getFontMetrics();
        canvas.drawText(this.mText, (this.ajl * 0.5f) + f, (((this.ajm - (fontMetrics2.bottom - fontMetrics2.top)) * 0.5f) + f2) - fontMetrics2.top, this.ajo);
    }

    private void init(Context context, String str) {
        this.ajk = context.getResources();
        this.mTextSize = this.ajk.getDimensionPixelSize(a.e.sdk_fontsize24);
        this.mText = str;
        tU();
        lj();
        this.ajp = this.ajk.getDimensionPixelOffset(a.e.sdk_ds6);
    }

    private void tU() {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.ajl = rect.width() + (this.ajk.getDimensionPixelOffset(a.e.sdk_ds6) * 2);
        this.ajm = rect.height() + (this.ajk.getDimensionPixelOffset(a.e.sdk_ds4) * 2);
    }

    private void lj() {
        tV();
        tW();
    }

    private void tV() {
        this.ajn = new Paint();
        this.ajn.setAntiAlias(true);
        this.ajn.setStyle(Paint.Style.FILL);
    }

    private void tW() {
        this.ajo = new TextPaint();
        this.ajo.setAntiAlias(true);
        this.ajo.setColor(Color.parseColor("#FFFFFFFF"));
        this.ajo.setFakeBoldText(true);
        this.ajo.setTextSize(this.mTextSize);
        this.ajo.setTextAlign(Paint.Align.CENTER);
    }
}
