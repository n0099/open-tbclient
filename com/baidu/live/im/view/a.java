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
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class a extends ReplacementSpan {
    private Resources arC;
    private float arD;
    private float arE;
    private Paint arF;
    private float arG;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.arD;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.arE) * 0.5f) + i4 + fontMetrics.ascent;
        this.arF.setShader(new LinearGradient(f, 0.0f, f + this.arD, 0.0f, Color.parseColor("#FFFED33B"), Color.parseColor("#FFFEAF01"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.arD + f, this.arE + f2), this.arG, this.arG, this.arF);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        canvas.drawText(this.mText, (this.arD * 0.5f) + f, (((this.arE - (fontMetrics2.bottom - fontMetrics2.top)) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.arC = context.getResources();
        this.mTextSize = this.arC.getDimensionPixelSize(a.e.sdk_fontsize24);
        this.mText = str;
        wh();
        lB();
        this.arG = this.arC.getDimensionPixelOffset(a.e.sdk_ds6);
    }

    private void wh() {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.arD = rect.width() + (this.arC.getDimensionPixelOffset(a.e.sdk_ds6) * 2);
        this.arE = rect.height() + (this.arC.getDimensionPixelOffset(a.e.sdk_ds4) * 2);
    }

    private void lB() {
        wi();
        wj();
    }

    private void wi() {
        this.arF = new Paint();
        this.arF.setAntiAlias(true);
        this.arF.setStyle(Paint.Style.FILL);
    }

    private void wj() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(Color.parseColor("#FFFFFFFF"));
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    }
}
