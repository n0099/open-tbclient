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
    private String aKy;
    private float bgA;
    private float bgB;
    private Paint bgC;
    private float bgD;
    private boolean bgE;
    private boolean bgF;
    private boolean bgG;
    private Resources bgy;
    private float bgz;
    private String endColor;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;
    private String startColor;

    public a(Context context, String str, boolean z, boolean z2, boolean z3) {
        this.bgG = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aKy = "#FFFFFFFF";
        this.bgE = z;
        this.bgF = z2;
        this.bgG = z3;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4) {
        this.bgG = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aKy = "#FFFFFFFF";
        this.bgE = z;
        this.bgF = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aKy = str4;
        init(context, str);
    }

    public a(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4, boolean z3) {
        this.bgG = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aKy = "#FFFFFFFF";
        this.bgE = z;
        this.bgF = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aKy = str4;
        this.bgG = z3;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bgA;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bgB) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bgy.getDimensionPixelOffset(a.e.sdk_ds14);
        if (this.bgE) {
            this.bgC.setShader(new LinearGradient(f, 0.0f, f + this.bgA, 0.0f, this.bgy.getColor(a.d.sdk_active_rate_start), this.bgy.getColor(a.d.sdk_active_rate_end), Shader.TileMode.CLAMP));
        } else if (this.bgF) {
            this.bgC.setShader(new LinearGradient(f, 0.0f, f + this.bgA, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        } else {
            this.bgC.setShader(new LinearGradient(f, 0.0f, f + this.bgA, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(new RectF(f, f2, this.bgA + f, this.bgB + f2), this.bgD, this.bgD, this.bgC);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        if (this.bgG) {
            canvas.drawText("×", dimensionPixelOffset + f, (((this.bgB - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            canvas.drawText(this.mText, this.bgz + f + dimensionPixelOffset, (((this.bgB - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
            return;
        }
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bgB - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.bgy = context.getResources();
        this.mTextSize = this.bgy.getDimensionPixelSize(a.e.sdk_fontsize18);
        this.mText = str;
        sw();
        Lq();
        this.bgD = this.bgB / 2.0f;
    }

    private void Lq() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bgz = this.mTextPaint.measureText("×") + 4.0f;
        if (this.bgG) {
            this.bgA = rect.width() + this.bgz + (this.bgy.getDimensionPixelOffset(a.e.sdk_ds14) * 2);
        } else {
            this.bgA = rect.width() + (this.bgy.getDimensionPixelOffset(a.e.sdk_ds14) * 2);
        }
        this.bgB = rect.height() + (this.bgy.getDimensionPixelOffset(a.e.sdk_ds6) * 2);
    }

    private void sw() {
        Lr();
        Ls();
    }

    private void Lr() {
        this.bgC = new Paint();
        this.bgC.setAntiAlias(true);
        this.bgC.setStyle(Paint.Style.FILL);
    }

    private void Ls() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        this.mTextPaint.setColor(Color.parseColor(this.aKy));
        if (this.bgF) {
            this.mTextSize = this.bgy.getDimensionPixelSize(a.e.sdk_fontsize22);
        }
        this.mTextPaint.setTextSize(this.mTextSize);
    }
}
