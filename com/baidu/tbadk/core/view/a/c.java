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
    private Drawable egY;
    private Drawable egZ;
    private int eha;
    private int ehb;
    private int ehc;
    private int ehd;
    private int ehe;
    private int ehg;
    private boolean ehh;
    private int mSize;
    private int egU = R.drawable.icon_pure_evaluation_star24_n;
    private int egV = R.color.cp_cont_i;
    private int egW = R.drawable.icon_pure_evaluation_star24_n;
    private int egX = R.color.cp_link_tip_d;
    private int ehf = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.ehg = i;
        this.eha = i2;
        this.ehb = i3;
        this.ehc = i4;
        this.ehe = i5;
        this.ehh = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.ehf * this.ehb) + (this.eha * (this.ehf - 1)) + this.ehc + this.ehe;
        if (fontMetricsInt != null) {
            this.ehd = fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        aYW();
        this.ehd = Math.max(this.ehd, (int) paint.getTextSize());
        int i6 = this.ehe + ((int) f);
        int max = i3 + Math.max(0, (this.ehh ? (i5 - i4) / 2 : 0) + ((this.ehd - this.ehb) / 2));
        for (int i7 = 0; i7 < this.ehg; i7++) {
            this.egZ.setBounds(i6, max, this.ehb + i6, this.ehb + max);
            this.egZ.draw(canvas);
            i6 += this.eha + this.ehb;
        }
        for (int i8 = this.ehg; i8 < this.ehf; i8++) {
            this.egY.setBounds(i6, max, this.ehb + i6, this.ehb + max);
            this.egY.draw(canvas);
            i6 += this.eha + this.ehb;
        }
    }

    private void aYW() {
        this.egY = SvgManager.aWQ().a(this.egU, this.egV, (SvgManager.SvgResourceStateType) null);
        this.egZ = SvgManager.aWQ().a(this.egW, this.egX, (SvgManager.SvgResourceStateType) null);
    }
}
