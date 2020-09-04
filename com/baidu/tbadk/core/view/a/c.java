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
    private Drawable exp;
    private Drawable exq;
    private int exr;
    private int exs;
    private int exu;
    private int exv;
    private int exw;
    private int exy;
    private boolean exz;
    private int mSize;
    private int exl = R.drawable.icon_pure_evaluation_star24_n;
    private int exm = R.color.cp_cont_i;
    private int exn = R.drawable.icon_pure_evaluation_star24_n;
    private int exo = R.color.cp_link_tip_d;
    private int exx = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.exy = i;
        this.exr = i2;
        this.exs = i3;
        this.exu = i4;
        this.exw = i5;
        this.exz = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.exx * this.exs) + (this.exr * (this.exx - 1)) + this.exu + this.exw;
        if (fontMetricsInt != null) {
            this.exv = fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        blq();
        this.exv = Math.max(this.exv, (int) paint.getTextSize());
        int i6 = this.exw + ((int) f);
        int max = i3 + Math.max(0, (this.exz ? (i5 - i4) / 2 : 0) + ((this.exv - this.exs) / 2));
        for (int i7 = 0; i7 < this.exy; i7++) {
            this.exq.setBounds(i6, max, this.exs + i6, this.exs + max);
            this.exq.draw(canvas);
            i6 += this.exr + this.exs;
        }
        for (int i8 = this.exy; i8 < this.exx; i8++) {
            this.exp.setBounds(i6, max, this.exs + i6, this.exs + max);
            this.exp.draw(canvas);
            i6 += this.exr + this.exs;
        }
    }

    private void blq() {
        this.exp = SvgManager.bjq().a(this.exl, this.exm, (SvgManager.SvgResourceStateType) null);
        this.exq = SvgManager.bjq().a(this.exn, this.exo, (SvgManager.SvgResourceStateType) null);
    }
}
