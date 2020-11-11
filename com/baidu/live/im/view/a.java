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
    private String aTu;
    private Resources bnd;
    private float bne;
    private float bnf;
    private float bng;
    private Paint bnh;
    private float bni;
    private boolean bnj;
    private boolean bnk;
    private boolean bnl;
    private String endColor;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;
    private String startColor;

    public a(Context context, String str, boolean z, boolean z2, boolean z3) {
        this.bnl = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aTu = "#FFFFFFFF";
        this.bnj = z;
        this.bnk = z2;
        this.bnl = z3;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4) {
        this.bnl = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aTu = "#FFFFFFFF";
        this.bnj = z;
        this.bnk = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aTu = str4;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4) {
        this.bnl = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aTu = "#FFFFFFFF";
        this.bnj = z;
        this.bnk = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aTu = str4;
        this.bnl = z3;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4, boolean z3) {
        this.bnl = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aTu = "#FFFFFFFF";
        this.bnj = z;
        this.bnk = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aTu = str4;
        this.bnl = z3;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bnf;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bng) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bnd.getDimensionPixelOffset(a.d.sdk_ds14);
        if (this.bnj) {
            this.bnh.setShader(new LinearGradient(f, 0.0f, f + this.bnf, 0.0f, this.bnd.getColor(a.c.sdk_active_rate_start), this.bnd.getColor(a.c.sdk_active_rate_end), Shader.TileMode.CLAMP));
        } else if (this.bnk) {
            this.bnh.setShader(new LinearGradient(f, 0.0f, f + this.bnf, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        } else {
            this.bnh.setShader(new LinearGradient(f, 0.0f, f + this.bnf, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(new RectF(f, f2, this.bnf + f, this.bng + f2), this.bni, this.bni, this.bnh);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        if (this.bnl) {
            canvas.drawText("×", dimensionPixelOffset + f, (((this.bng - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            canvas.drawText(this.mText, this.bne + f + dimensionPixelOffset, (((this.bng - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            return;
        }
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bng - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.bnd = context.getResources();
        this.mTextSize = this.bnd.getDimensionPixelSize(a.d.sdk_fontsize18);
        this.mText = str;
        sw();
        Np();
        this.bni = this.bng / 2.0f;
    }

    private void Np() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bne = this.mTextPaint.measureText("×") + 4.0f;
        if (this.bnl) {
            this.bnf = rect.width() + this.bne + (this.bnd.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        } else {
            this.bnf = rect.width() + (this.bnd.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        }
        this.bng = rect.height() + (this.bnd.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void sw() {
        Nq();
        Nr();
    }

    private void Nq() {
        this.bnh = new Paint();
        this.bnh.setAntiAlias(true);
        this.bnh.setStyle(Paint.Style.FILL);
    }

    private void Nr() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        this.mTextPaint.setColor(Color.parseColor(this.aTu));
        if (this.bnk) {
            this.mTextSize = this.bnd.getDimensionPixelSize(a.d.sdk_fontsize22);
        }
        this.mTextPaint.setTextSize(this.mTextSize);
    }
}
