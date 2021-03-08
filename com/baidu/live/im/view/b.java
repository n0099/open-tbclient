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
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class b extends ReplacementSpan {
    private String aIi;
    private Resources bjd;
    private float bje;
    private float bjf;
    private Paint bjg;
    private Paint bjh;
    private float bji;
    private float bsK;
    private boolean bsL;
    private boolean bsM;
    private boolean bsN;
    private String endColor;
    private String mText;
    private int mTextSize;
    private String startColor;

    public b(Context context, String str, boolean z, boolean z2, boolean z3) {
        this.bsN = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aIi = "#FFFFFFFF";
        this.bsL = z;
        this.bsM = z2;
        this.bsN = z3;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4) {
        this.bsN = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aIi = "#FFFFFFFF";
        this.bsL = z;
        this.bsM = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aIi = str4;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4) {
        this.bsN = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aIi = "#FFFFFFFF";
        this.bsL = z;
        this.bsM = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aIi = str4;
        this.bsN = z3;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4, boolean z3) {
        this.bsN = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aIi = "#FFFFFFFF";
        this.bsL = z;
        this.bsM = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aIi = str4;
        this.bsN = z3;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bje;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bjf) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bjd.getDimensionPixelOffset(a.d.sdk_ds14);
        if (this.bsL) {
            this.bjg.setShader(new LinearGradient(f, 0.0f, f + this.bje, 0.0f, this.bjd.getColor(a.c.sdk_active_rate_start), this.bjd.getColor(a.c.sdk_active_rate_end), Shader.TileMode.CLAMP));
        } else if (this.bsM) {
            this.bjg.setShader(new LinearGradient(f, 0.0f, f + this.bje, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        } else {
            this.bjg.setShader(new LinearGradient(f, 0.0f, f + this.bje, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(new RectF(f, f2, this.bje + f, this.bjf + f2), this.bji, this.bji, this.bjg);
        Paint.FontMetrics fontMetrics2 = this.bjh.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        if (this.bsN) {
            canvas.drawText("×", dimensionPixelOffset + f, (((this.bjf - f3) * 0.5f) + f2) - fontMetrics2.top, this.bjh);
            canvas.drawText(this.mText, this.bsK + f + dimensionPixelOffset, (((this.bjf - f3) * 0.5f) + f2) - fontMetrics2.top, this.bjh);
            return;
        }
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bjf - f3) * 0.5f) + f2) - fontMetrics2.top, this.bjh);
    }

    private void init(Context context, String str) {
        this.bjd = context.getResources();
        this.mTextSize = this.bjd.getDimensionPixelSize(a.d.sdk_fontsize18);
        this.mText = str;
        rX();
        IC();
        this.bji = this.bjf / 2.0f;
    }

    private void IC() {
        Rect rect = new Rect();
        this.bjh.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bsK = this.bjh.measureText("×") + 4.0f;
        if (this.bsN) {
            this.bje = rect.width() + this.bsK + (this.bjd.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        } else {
            this.bje = rect.width() + (this.bjd.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        }
        this.bjf = rect.height() + (this.bjd.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void rX() {
        ID();
        IE();
    }

    private void ID() {
        this.bjg = new Paint();
        this.bjg.setAntiAlias(true);
        this.bjg.setStyle(Paint.Style.FILL);
    }

    private void IE() {
        this.bjh = new TextPaint();
        this.bjh.setAntiAlias(true);
        this.bjh.setFakeBoldText(true);
        this.bjh.setTextAlign(Paint.Align.LEFT);
        this.bjh.setColor(Color.parseColor(this.aIi));
        if (this.bsM) {
            this.mTextSize = this.bjd.getDimensionPixelSize(a.d.sdk_fontsize22);
        }
        this.bjh.setTextSize(this.mTextSize);
    }
}
