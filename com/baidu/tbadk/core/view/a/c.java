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
    private Drawable eni;
    private Drawable enj;
    private int enk;
    private int enl;
    private int enm;
    private int enn;
    private int eno;
    private int enq;
    private boolean enr;
    private int mSize;
    private int ene = R.drawable.icon_pure_evaluation_star24_n;
    private int enf = R.color.cp_cont_i;
    private int eng = R.drawable.icon_pure_evaluation_star24_n;
    private int enh = R.color.cp_link_tip_d;
    private int enp = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.enq = i;
        this.enk = i2;
        this.enl = i3;
        this.enm = i4;
        this.eno = i5;
        this.enr = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.enp * this.enl) + (this.enk * (this.enp - 1)) + this.enm + this.eno;
        if (fontMetricsInt != null) {
            this.enn = fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        bcT();
        this.enn = Math.max(this.enn, (int) paint.getTextSize());
        int i6 = this.eno + ((int) f);
        int max = i3 + Math.max(0, (this.enr ? (i5 - i4) / 2 : 0) + ((this.enn - this.enl) / 2));
        for (int i7 = 0; i7 < this.enq; i7++) {
            this.enj.setBounds(i6, max, this.enl + i6, this.enl + max);
            this.enj.draw(canvas);
            i6 += this.enk + this.enl;
        }
        for (int i8 = this.enq; i8 < this.enp; i8++) {
            this.eni.setBounds(i6, max, this.enl + i6, this.enl + max);
            this.eni.draw(canvas);
            i6 += this.enk + this.enl;
        }
    }

    private void bcT() {
        this.eni = SvgManager.baR().a(this.ene, this.enf, (SvgManager.SvgResourceStateType) null);
        this.enj = SvgManager.baR().a(this.eng, this.enh, (SvgManager.SvgResourceStateType) null);
    }
}
