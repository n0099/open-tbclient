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
    private String aRq;
    private Resources bes;
    private float beu;
    private float bev;
    private Paint bew;
    private Paint bex;
    private float bey;
    private float bnJ;
    private boolean bnK;
    private boolean bnL;
    private boolean bnM;
    private String endColor;
    private String mText;
    private int mTextSize;
    private String startColor;

    public b(Context context, String str, boolean z, boolean z2, boolean z3) {
        this.bnM = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aRq = "#FFFFFFFF";
        this.bnK = z;
        this.bnL = z2;
        this.bnM = z3;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4) {
        this.bnM = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aRq = "#FFFFFFFF";
        this.bnK = z;
        this.bnL = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aRq = str4;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4) {
        this.bnM = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aRq = "#FFFFFFFF";
        this.bnK = z;
        this.bnL = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aRq = str4;
        this.bnM = z3;
        init(context, str);
    }

    public b(Context context, String str, boolean z, boolean z2, String str2, String str3, String str4, boolean z3) {
        this.bnM = false;
        this.startColor = "#FFFFFFFF";
        this.endColor = "#FFFFFFFF";
        this.aRq = "#FFFFFFFF";
        this.bnK = z;
        this.bnL = z2;
        this.startColor = str2;
        this.endColor = str3;
        this.aRq = str4;
        this.bnM = z3;
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
        if (this.bnK) {
            this.bew.setShader(new LinearGradient(f, 0.0f, f + this.beu, 0.0f, this.bes.getColor(a.c.sdk_active_rate_start), this.bes.getColor(a.c.sdk_active_rate_end), Shader.TileMode.CLAMP));
        } else if (this.bnL) {
            this.bew.setShader(new LinearGradient(f, 0.0f, f + this.beu, 0.0f, Color.parseColor(this.startColor), Color.parseColor(this.endColor), Shader.TileMode.CLAMP));
        } else {
            this.bew.setShader(new LinearGradient(f, 0.0f, f + this.beu, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        }
        canvas.drawRoundRect(new RectF(f, f2, this.beu + f, this.bev + f2), this.bey, this.bey, this.bew);
        Paint.FontMetrics fontMetrics2 = this.bex.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        if (this.bnM) {
            canvas.drawText("×", dimensionPixelOffset + f, (((this.bev - f3) * 0.5f) + f2) - fontMetrics2.top, this.bex);
            canvas.drawText(this.mText, this.bnJ + f + dimensionPixelOffset, (((this.bev - f3) * 0.5f) + f2) - fontMetrics2.top, this.bex);
            return;
        }
        canvas.drawText(this.mText, dimensionPixelOffset + f, (((this.bev - f3) * 0.5f) + f2) - fontMetrics2.top, this.bex);
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
        this.bnJ = this.bex.measureText("×") + 4.0f;
        if (this.bnM) {
            this.beu = rect.width() + this.bnJ + (this.bes.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        } else {
            this.beu = rect.width() + (this.bes.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        }
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
        this.bex.setFakeBoldText(true);
        this.bex.setTextAlign(Paint.Align.LEFT);
        this.bex.setColor(Color.parseColor(this.aRq));
        if (this.bnL) {
            this.mTextSize = this.bes.getDimensionPixelSize(a.d.sdk_fontsize22);
        }
        this.bex.setTextSize(this.mTextSize);
    }
}
