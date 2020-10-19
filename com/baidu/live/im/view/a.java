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
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class a extends ReplacementSpan {
    private String aND;
    private Resources bko;
    private float bkp;
    private float bkq;
    private float bkr;
    private Paint bks;
    private float bkt;
    private boolean bku;
    private boolean bkv;
    private boolean bkw;
    private String endColor;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;
    private String startColor;

    public a(Context context, String str, boolean z, boolean z2, boolean z3) {
        this.bkw = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aND = "#FFFFFFFF";
        this.bku = z;
        this.bkv = z2;
        this.bkw = z3;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4) {
        this.bkw = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aND = "#FFFFFFFF";
        this.bku = z;
        this.bkv = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aND = str4;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4, boolean z3) {
        this.bkw = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aND = "#FFFFFFFF";
        this.bku = z;
        this.bkv = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aND = str4;
        this.bkw = z3;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bkq;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bkr) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bko.getDimensionPixelOffset(a.e.sdk_ds14);
        if (this.bku) {
            this.bks.setShader(new LinearGradient(f, 0.0f, f + this.bkq, 0.0f, this.bko.getColor(a.d.sdk_active_rate_start), this.bko.getColor(a.d.sdk_active_rate_end), Shader.TileMode.CLAMP));
        } else if (this.bkv) {
            this.bks.setShader(new LinearGradient(f, 0.0f, f + this.bkq, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        } else {
            this.bks.setShader(new LinearGradient(f, 0.0f, f + this.bkq, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(new RectF(f, f2, this.bkq + f, this.bkr + f2), this.bkt, this.bkt, this.bks);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        if (this.bkw) {
            canvas.drawText("×", dimensionPixelOffset + f, (((this.bkr - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            canvas.drawText(this.mText, this.bkp + f + dimensionPixelOffset, (((this.bkr - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            return;
        }
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bkr - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.bko = context.getResources();
        this.mTextSize = this.bko.getDimensionPixelSize(a.e.sdk_fontsize18);
        this.mText = str;
        sw();
        Mv();
        this.bkt = this.bkr / 2.0f;
    }

    private void Mv() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bkp = this.mTextPaint.measureText("×") + 4.0f;
        if (this.bkw) {
            this.bkq = rect.width() + this.bkp + (this.bko.getDimensionPixelOffset(a.e.sdk_ds14) * 2);
        } else {
            this.bkq = rect.width() + (this.bko.getDimensionPixelOffset(a.e.sdk_ds14) * 2);
        }
        this.bkr = rect.height() + (this.bko.getDimensionPixelOffset(a.e.sdk_ds6) * 2);
    }

    private void sw() {
        Mw();
        Mx();
    }

    private void Mw() {
        this.bks = new Paint();
        this.bks.setAntiAlias(true);
        this.bks.setStyle(Paint.Style.FILL);
    }

    private void Mx() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        this.mTextPaint.setColor(Color.parseColor(this.aND));
        if (this.bkv) {
            this.mTextSize = this.bko.getDimensionPixelSize(a.e.sdk_fontsize22);
        }
        this.mTextPaint.setTextSize(this.mTextSize);
    }
}
