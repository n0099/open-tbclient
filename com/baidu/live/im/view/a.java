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
    private String aOi;
    private Resources blJ;
    private float blK;
    private float blL;
    private float blM;
    private Paint blN;
    private float blO;
    private boolean blP;
    private boolean blQ;
    private boolean blR;
    private String endColor;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;
    private String startColor;

    public a(Context context, String str, boolean z, boolean z2, boolean z3) {
        this.blR = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aOi = "#FFFFFFFF";
        this.blP = z;
        this.blQ = z2;
        this.blR = z3;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4) {
        this.blR = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aOi = "#FFFFFFFF";
        this.blP = z;
        this.blQ = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aOi = str4;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4) {
        this.blR = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aOi = "#FFFFFFFF";
        this.blP = z;
        this.blQ = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aOi = str4;
        this.blR = z3;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4, boolean z3) {
        this.blR = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aOi = "#FFFFFFFF";
        this.blP = z;
        this.blQ = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aOi = str4;
        this.blR = z3;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.blL;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.blM) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.blJ.getDimensionPixelOffset(a.e.sdk_ds14);
        if (this.blP) {
            this.blN.setShader(new LinearGradient(f, 0.0f, f + this.blL, 0.0f, this.blJ.getColor(a.d.sdk_active_rate_start), this.blJ.getColor(a.d.sdk_active_rate_end), Shader.TileMode.CLAMP));
        } else if (this.blQ) {
            this.blN.setShader(new LinearGradient(f, 0.0f, f + this.blL, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        } else {
            this.blN.setShader(new LinearGradient(f, 0.0f, f + this.blL, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(new RectF(f, f2, this.blL + f, this.blM + f2), this.blO, this.blO, this.blN);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        if (this.blR) {
            canvas.drawText("×", dimensionPixelOffset + f, (((this.blM - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            canvas.drawText(this.mText, this.blK + f + dimensionPixelOffset, (((this.blM - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            return;
        }
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.blM - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.blJ = context.getResources();
        this.mTextSize = this.blJ.getDimensionPixelSize(a.e.sdk_fontsize18);
        this.mText = str;
        sw();
        MP();
        this.blO = this.blM / 2.0f;
    }

    private void MP() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.blK = this.mTextPaint.measureText("×") + 4.0f;
        if (this.blR) {
            this.blL = rect.width() + this.blK + (this.blJ.getDimensionPixelOffset(a.e.sdk_ds14) * 2);
        } else {
            this.blL = rect.width() + (this.blJ.getDimensionPixelOffset(a.e.sdk_ds14) * 2);
        }
        this.blM = rect.height() + (this.blJ.getDimensionPixelOffset(a.e.sdk_ds6) * 2);
    }

    private void sw() {
        MQ();
        MR();
    }

    private void MQ() {
        this.blN = new Paint();
        this.blN.setAntiAlias(true);
        this.blN.setStyle(Paint.Style.FILL);
    }

    private void MR() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        this.mTextPaint.setColor(Color.parseColor(this.aOi));
        if (this.blQ) {
            this.mTextSize = this.blJ.getDimensionPixelSize(a.e.sdk_fontsize22);
        }
        this.mTextPaint.setTextSize(this.mTextSize);
    }
}
