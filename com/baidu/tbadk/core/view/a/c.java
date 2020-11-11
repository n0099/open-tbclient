package com.baidu.tbadk.core.view.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends ReplacementSpan {
    private Drawable eZO;
    private Drawable eZP;
    private int eZQ;
    private int eZR;
    private int eZS;
    private int eZT;
    private int eZU;
    private int eZW;
    private boolean eZX;
    private int mSize;
    private int eZK = R.drawable.icon_pure_evaluation_star24_n;
    private int eZL = R.color.cp_cont_i;
    private int eZM = R.drawable.icon_pure_evaluation_star24_n;
    private int eZN = R.color.cp_link_tip_d;
    private int eZV = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.eZW = i;
        this.eZQ = i2;
        this.eZR = i3;
        this.eZS = i4;
        this.eZU = i5;
        this.eZX = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.eZV * this.eZR) + (this.eZQ * (this.eZV - 1)) + this.eZS + this.eZU;
        if (fontMetricsInt != null) {
            this.eZT = fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        bto();
        this.eZT = Math.max(this.eZT, (int) paint.getTextSize());
        int i6 = this.eZU + ((int) f);
        int max = i3 + Math.max(0, (this.eZX ? (i5 - i4) / 2 : 0) + ((this.eZT - this.eZR) / 2));
        for (int i7 = 0; i7 < this.eZW; i7++) {
            this.eZP.setBounds(i6, max, this.eZR + i6, this.eZR + max);
            this.eZP.draw(canvas);
            i6 += this.eZQ + this.eZR;
        }
        for (int i8 = this.eZW; i8 < this.eZV; i8++) {
            this.eZO.setBounds(i6, max, this.eZR + i6, this.eZR + max);
            this.eZO.draw(canvas);
            i6 += this.eZQ + this.eZR;
        }
    }

    private void bto() {
        this.eZO = SvgManager.brn().a(this.eZK, this.eZL, (SvgManager.SvgResourceStateType) null);
        this.eZP = SvgManager.brn().a(this.eZM, this.eZN, (SvgManager.SvgResourceStateType) null);
    }
}
