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
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class a extends ReplacementSpan {
    private Resources aqQ;
    private float aqR;
    private float aqS;
    private Paint aqT;
    private float aqU;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.aqR;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.aqS) * 0.5f) + i4 + fontMetrics.ascent;
        this.aqT.setShader(new LinearGradient(f, 0.0f, f + this.aqR, 0.0f, Color.parseColor("#FFFED33B"), Color.parseColor("#FFFEAF01"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.aqR + f, this.aqS + f2), this.aqU, this.aqU, this.aqT);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        canvas.drawText(this.mText, (this.aqR * 0.5f) + f, (((this.aqS - (fontMetrics2.bottom - fontMetrics2.top)) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.aqQ = context.getResources();
        this.mTextSize = this.aqQ.getDimensionPixelSize(a.e.sdk_fontsize24);
        this.mText = str;
        vQ();
        lB();
        this.aqU = this.aqQ.getDimensionPixelOffset(a.e.sdk_ds6);
    }

    private void vQ() {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.aqR = rect.width() + (this.aqQ.getDimensionPixelOffset(a.e.sdk_ds6) * 2);
        this.aqS = rect.height() + (this.aqQ.getDimensionPixelOffset(a.e.sdk_ds4) * 2);
    }

    private void lB() {
        vR();
        vS();
    }

    private void vR() {
        this.aqT = new Paint();
        this.aqT.setAntiAlias(true);
        this.aqT.setStyle(Paint.Style.FILL);
    }

    private void vS() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(Color.parseColor("#FFFFFFFF"));
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    }
}
