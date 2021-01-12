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
    private Resources bes;
    private float beu;
    private float bev;
    private Paint bew;
    private Paint bex;
    private float bey;
    private float bnJ;
    private String mText;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.beu;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bev) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bes.getDimensionPixelOffset(a.d.sdk_ds14);
        this.bew.setShader(new LinearGradient(f, 0.0f, f + this.beu, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.beu + f, this.bev + f2), this.bey, this.bey, this.bew);
        Paint.FontMetrics fontMetrics2 = this.bex.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        canvas.drawText("*", dimensionPixelOffset + f, ((((this.bev - f3) * 0.5f) + f2) - fontMetrics2.top) + 4, this.bex);
        canvas.drawText(this.mText, this.bnJ + f + dimensionPixelOffset, (((this.bev - f3) * 0.5f) + f2) - fontMetrics2.top, this.bex);
    }

    private void init(Context context, String str) {
        this.bes = context.getResources();
        this.mTextSize = this.bes.getDimensionPixelSize(a.d.sdk_fontsize18);
        this.mText = str;
        sa();
        Hj();
        this.bey = this.bev / 2.0f;
    }

    private void Hj() {
        Rect rect = new Rect();
        this.bex.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bnJ = this.bex.measureText("*") + 4.0f;
        this.beu = rect.width() + this.bnJ + (this.bes.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        this.bev = rect.height() + (this.bes.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void sa() {
        Hk();
        Hl();
    }

    private void Hk() {
        this.bew = new Paint();
        this.bew.setAntiAlias(true);
        this.bew.setStyle(Paint.Style.FILL);
    }

    private void Hl() {
        this.bex = new TextPaint();
        this.bex.setAntiAlias(true);
        this.bex.setColor(Color.parseColor("#FFFFFFFF"));
        this.bex.setFakeBoldText(true);
        this.bex.setTextSize(this.mTextSize);
        this.bex.setTextAlign(Paint.Align.LEFT);
    }
}
