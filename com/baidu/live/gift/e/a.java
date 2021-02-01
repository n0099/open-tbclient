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
    private String aGI;
    private Resources bhB;
    private float bhC;
    private float bhD;
    private Paint bhE;
    private Paint bhF;
    private float bhG;
    private String endColor;
    private String mText;
    private int mTextSize;
    private String startColor;

    public a(Context context, String str, String str2, String str3, String str4, int i) {
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aGI = "#FFFFFFFF";
        this.startColor = str2;
        this.endColor = str3;
        this.aGI = str4;
        this.mTextSize = i;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bhC;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bhD) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bhB.getDimensionPixelOffset(a.d.sdk_ds14);
        this.bhE.setShader(new LinearGradient(f, 0.0f, f + this.bhC, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.bhC + f, this.bhD + f2), this.bhG, this.bhG, this.bhE);
        Paint.FontMetrics fontMetrics2 = this.bhF.getFontMetrics();
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bhD - (fontMetrics2.bottom - fontMetrics2.top)) * 0.5f) + f2) - fontMetrics2.top, this.bhF);
    }

    private void init(Context context, String str) {
        this.bhB = context.getResources();
        if (this.mTextSize <= 0) {
            this.mTextSize = this.bhB.getDimensionPixelSize(a.d.sdk_fontsize18);
        }
        this.mText = str;
        rX();
        Iz();
        this.bhG = this.bhD / 2.0f;
    }

    private void Iz() {
        Rect rect = new Rect();
        this.bhF.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bhC = rect.width() + (this.bhB.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        this.bhD = rect.height() + (this.bhB.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void rX() {
        IA();
        IB();
    }

    private void IA() {
        this.bhE = new Paint();
        this.bhE.setAntiAlias(true);
        this.bhE.setStyle(Paint.Style.FILL);
    }

    private void IB() {
        this.bhF = new TextPaint();
        this.bhF.setAntiAlias(true);
        this.bhF.setFakeBoldText(true);
        this.bhF.setTextAlign(Paint.Align.LEFT);
        this.bhF.setColor(Color.parseColor(this.aGI));
        this.bhF.setTextSize(this.mTextSize);
    }
}
