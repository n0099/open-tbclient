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
/* loaded from: classes11.dex */
public class b extends ReplacementSpan {
    private String aWd;
    private Resources bjk;
    private float bjl;
    private float bjm;
    private Paint bjn;
    private Paint bjo;
    private float bjp;
    private float bsv;
    private boolean bsw;
    private boolean bsx;
    private boolean bsy;
    private String endColor;
    private String mText;
    private int mTextSize;
    private String startColor;

    public b(Context context, String str, boolean z, boolean z2, boolean z3) {
        this.bsy = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aWd = "#FFFFFFFF";
        this.bsw = z;
        this.bsx = z2;
        this.bsy = z3;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4) {
        this.bsy = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aWd = "#FFFFFFFF";
        this.bsw = z;
        this.bsx = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aWd = str4;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4) {
        this.bsy = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aWd = "#FFFFFFFF";
        this.bsw = z;
        this.bsx = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aWd = str4;
        this.bsy = z3;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4, boolean z3) {
        this.bsy = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aWd = "#FFFFFFFF";
        this.bsw = z;
        this.bsx = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aWd = str4;
        this.bsy = z3;
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bjl;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bjm) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bjk.getDimensionPixelOffset(a.d.sdk_ds14);
        if (this.bsw) {
            this.bjn.setShader(new LinearGradient(f, 0.0f, f + this.bjl, 0.0f, this.bjk.getColor(a.c.sdk_active_rate_start), this.bjk.getColor(a.c.sdk_active_rate_end), Shader.TileMode.CLAMP));
        } else if (this.bsx) {
            this.bjn.setShader(new LinearGradient(f, 0.0f, f + this.bjl, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        } else {
            this.bjn.setShader(new LinearGradient(f, 0.0f, f + this.bjl, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(new RectF(f, f2, this.bjl + f, this.bjm + f2), this.bjp, this.bjp, this.bjn);
        Paint.FontMetrics fontMetrics2 = this.bjo.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        if (this.bsy) {
            canvas.drawText("×", dimensionPixelOffset + f, (((this.bjm - f3) * 0.5f) + f2) - fontMetrics2.top, this.bjo);
            canvas.drawText(this.mText, this.bsv + f + dimensionPixelOffset, (((this.bjm - f3) * 0.5f) + f2) - fontMetrics2.top, this.bjo);
            return;
        }
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bjm - f3) * 0.5f) + f2) - fontMetrics2.top, this.bjo);
    }

    private void init(Context context, String str) {
        this.bjk = context.getResources();
        this.mTextSize = this.bjk.getDimensionPixelSize(a.d.sdk_fontsize18);
        this.mText = str;
        sa();
        Le();
        this.bjp = this.bjm / 2.0f;
    }

    private void Le() {
        Rect rect = new Rect();
        this.bjo.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bsv = this.bjo.measureText("×") + 4.0f;
        if (this.bsy) {
            this.bjl = rect.width() + this.bsv + (this.bjk.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        } else {
            this.bjl = rect.width() + (this.bjk.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        }
        this.bjm = rect.height() + (this.bjk.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void sa() {
        Lf();
        Lg();
    }

    private void Lf() {
        this.bjn = new Paint();
        this.bjn.setAntiAlias(true);
        this.bjn.setStyle(Paint.Style.FILL);
    }

    private void Lg() {
        this.bjo = new TextPaint();
        this.bjo.setAntiAlias(true);
        this.bjo.setFakeBoldText(true);
        this.bjo.setTextAlign(Paint.Align.LEFT);
        this.bjo.setColor(Color.parseColor(this.aWd));
        if (this.bsx) {
            this.mTextSize = this.bjk.getDimensionPixelSize(a.d.sdk_fontsize22);
        }
        this.bjo.setTextSize(this.mTextSize);
    }
}
