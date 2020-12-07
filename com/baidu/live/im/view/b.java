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
public class b extends ReplacementSpan {
    private String aUL;
    private Resources bhC;
    private float bhD;
    private float bhE;
    private Paint bhF;
    private float bhG;
    private float bqE;
    private boolean bqF;
    private boolean bqG;
    private boolean bqH;
    private String endColor;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;
    private String startColor;

    public b(Context context, String str, boolean z, boolean z2, boolean z3) {
        this.bqH = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aUL = "#FFFFFFFF";
        this.bqF = z;
        this.bqG = z2;
        this.bqH = z3;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4) {
        this.bqH = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aUL = "#FFFFFFFF";
        this.bqF = z;
        this.bqG = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aUL = str4;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4) {
        this.bqH = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aUL = "#FFFFFFFF";
        this.bqF = z;
        this.bqG = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aUL = str4;
        this.bqH = z3;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4, boolean z3) {
        this.bqH = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aUL = "#FFFFFFFF";
        this.bqF = z;
        this.bqG = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aUL = str4;
        this.bqH = z3;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bhD;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bhE) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bhC.getDimensionPixelOffset(a.d.sdk_ds14);
        if (this.bqF) {
            this.bhF.setShader(new LinearGradient(f, 0.0f, f + this.bhD, 0.0f, this.bhC.getColor(a.c.sdk_active_rate_start), this.bhC.getColor(a.c.sdk_active_rate_end), Shader.TileMode.CLAMP));
        } else if (this.bqG) {
            this.bhF.setShader(new LinearGradient(f, 0.0f, f + this.bhD, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        } else {
            this.bhF.setShader(new LinearGradient(f, 0.0f, f + this.bhD, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(new RectF(f, f2, this.bhD + f, this.bhE + f2), this.bhG, this.bhG, this.bhF);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        if (this.bqH) {
            canvas.drawText("×", dimensionPixelOffset + f, (((this.bhE - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            canvas.drawText(this.mText, this.bqE + f + dimensionPixelOffset, (((this.bhE - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            return;
        }
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bhE - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.bhC = context.getResources();
        this.mTextSize = this.bhC.getDimensionPixelSize(a.d.sdk_fontsize18);
        this.mText = str;
        sz();
        LF();
        this.bhG = this.bhE / 2.0f;
    }

    private void LF() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bqE = this.mTextPaint.measureText("×") + 4.0f;
        if (this.bqH) {
            this.bhD = rect.width() + this.bqE + (this.bhC.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        } else {
            this.bhD = rect.width() + (this.bhC.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        }
        this.bhE = rect.height() + (this.bhC.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void sz() {
        LG();
        LH();
    }

    private void LG() {
        this.bhF = new Paint();
        this.bhF.setAntiAlias(true);
        this.bhF.setStyle(Paint.Style.FILL);
    }

    private void LH() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        this.mTextPaint.setColor(Color.parseColor(this.aUL));
        if (this.bqG) {
            this.mTextSize = this.bhC.getDimensionPixelSize(a.d.sdk_fontsize22);
        }
        this.mTextPaint.setTextSize(this.mTextSize);
    }
}
