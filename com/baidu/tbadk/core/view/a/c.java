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
    private Drawable eLD;
    private Drawable eLE;
    private int eLF;
    private int eLG;
    private int eLH;
    private int eLI;
    private int eLJ;
    private int eLL;
    private boolean eLM;
    private int mSize;
    private int eLz = R.drawable.icon_pure_evaluation_star24_n;
    private int eLA = R.color.cp_cont_i;
    private int eLB = R.drawable.icon_pure_evaluation_star24_n;
    private int eLC = R.color.cp_link_tip_d;
    private int eLK = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.eLL = i;
        this.eLF = i2;
        this.eLG = i3;
        this.eLH = i4;
        this.eLJ = i5;
        this.eLM = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.eLK * this.eLG) + (this.eLF * (this.eLK - 1)) + this.eLH + this.eLJ;
        if (fontMetricsInt != null) {
            this.eLI = fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        boV();
        this.eLI = Math.max(this.eLI, (int) paint.getTextSize());
        int i6 = this.eLJ + ((int) f);
        int max = i3 + Math.max(0, (this.eLM ? (i5 - i4) / 2 : 0) + ((this.eLI - this.eLG) / 2));
        for (int i7 = 0; i7 < this.eLL; i7++) {
            this.eLE.setBounds(i6, max, this.eLG + i6, this.eLG + max);
            this.eLE.draw(canvas);
            i6 += this.eLF + this.eLG;
        }
        for (int i8 = this.eLL; i8 < this.eLK; i8++) {
            this.eLD.setBounds(i6, max, this.eLG + i6, this.eLG + max);
            this.eLD.draw(canvas);
            i6 += this.eLF + this.eLG;
        }
    }

    private void boV() {
        this.eLD = SvgManager.bmU().a(this.eLz, this.eLA, (SvgManager.SvgResourceStateType) null);
        this.eLE = SvgManager.bmU().a(this.eLB, this.eLC, (SvgManager.SvgResourceStateType) null);
    }
}
