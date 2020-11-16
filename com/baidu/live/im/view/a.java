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
    private String aRJ;
    private boolean blA;
    private Resources bls;
    private float blt;
    private float blu;
    private float blv;
    private Paint blw;
    private float blx;
    private boolean bly;
    private boolean blz;
    private String endColor;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;
    private String startColor;

    public a(Context context, String str, boolean z, boolean z2, boolean z3) {
        this.blA = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aRJ = "#FFFFFFFF";
        this.bly = z;
        this.blz = z2;
        this.blA = z3;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4) {
        this.blA = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aRJ = "#FFFFFFFF";
        this.bly = z;
        this.blz = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aRJ = str4;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4) {
        this.blA = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aRJ = "#FFFFFFFF";
        this.bly = z;
        this.blz = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aRJ = str4;
        this.blA = z3;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4, boolean z3) {
        this.blA = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aRJ = "#FFFFFFFF";
        this.bly = z;
        this.blz = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aRJ = str4;
        this.blA = z3;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.blu;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.blv) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bls.getDimensionPixelOffset(a.d.sdk_ds14);
        if (this.bly) {
            this.blw.setShader(new LinearGradient(f, 0.0f, f + this.blu, 0.0f, this.bls.getColor(a.c.sdk_active_rate_start), this.bls.getColor(a.c.sdk_active_rate_end), Shader.TileMode.CLAMP));
        } else if (this.blz) {
            this.blw.setShader(new LinearGradient(f, 0.0f, f + this.blu, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        } else {
            this.blw.setShader(new LinearGradient(f, 0.0f, f + this.blu, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(new RectF(f, f2, this.blu + f, this.blv + f2), this.blx, this.blx, this.blw);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        if (this.blA) {
            canvas.drawText("×", dimensionPixelOffset + f, (((this.blv - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            canvas.drawText(this.mText, this.blt + f + dimensionPixelOffset, (((this.blv - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            return;
        }
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.blv - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.bls = context.getResources();
        this.mTextSize = this.bls.getDimensionPixelSize(a.d.sdk_fontsize18);
        this.mText = str;
        sw();
        MG();
        this.blx = this.blv / 2.0f;
    }

    private void MG() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.blt = this.mTextPaint.measureText("×") + 4.0f;
        if (this.blA) {
            this.blu = rect.width() + this.blt + (this.bls.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        } else {
            this.blu = rect.width() + (this.bls.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        }
        this.blv = rect.height() + (this.bls.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void sw() {
        MH();
        MI();
    }

    private void MH() {
        this.blw = new Paint();
        this.blw.setAntiAlias(true);
        this.blw.setStyle(Paint.Style.FILL);
    }

    private void MI() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        this.mTextPaint.setColor(Color.parseColor(this.aRJ));
        if (this.blz) {
            this.mTextSize = this.bls.getDimensionPixelSize(a.d.sdk_fontsize22);
        }
        this.mTextPaint.setTextSize(this.mTextSize);
    }
}
