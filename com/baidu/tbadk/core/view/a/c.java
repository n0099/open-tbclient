package com.baidu.tbadk.core.view.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends ReplacementSpan {
    private Drawable exl;
    private Drawable exm;
    private int exn;
    private int exo;
    private int exp;
    private int exq;
    private int exr;
    private int exu;
    private boolean exv;
    private int mSize;
    private int exh = R.drawable.icon_pure_evaluation_star24_n;
    private int exi = R.color.cp_cont_i;
    private int exj = R.drawable.icon_pure_evaluation_star24_n;
    private int exk = R.color.cp_link_tip_d;
    private int exs = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.exu = i;
        this.exn = i2;
        this.exo = i3;
        this.exp = i4;
        this.exr = i5;
        this.exv = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.exs * this.exo) + (this.exn * (this.exs - 1)) + this.exp + this.exr;
        if (fontMetricsInt != null) {
            this.exq = fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        blq();
        this.exq = Math.max(this.exq, (int) paint.getTextSize());
        int i6 = this.exr + ((int) f);
        int max = i3 + Math.max(0, (this.exv ? (i5 - i4) / 2 : 0) + ((this.exq - this.exo) / 2));
        for (int i7 = 0; i7 < this.exu; i7++) {
            this.exm.setBounds(i6, max, this.exo + i6, this.exo + max);
            this.exm.draw(canvas);
            i6 += this.exn + this.exo;
        }
        for (int i8 = this.exu; i8 < this.exs; i8++) {
            this.exl.setBounds(i6, max, this.exo + i6, this.exo + max);
            this.exl.draw(canvas);
            i6 += this.exn + this.exo;
        }
    }

    private void blq() {
        this.exl = SvgManager.bjq().a(this.exh, this.exi, (SvgManager.SvgResourceStateType) null);
        this.exm = SvgManager.bjq().a(this.exj, this.exk, (SvgManager.SvgResourceStateType) null);
    }
}
