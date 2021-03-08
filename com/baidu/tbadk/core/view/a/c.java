package com.baidu.tbadk.core.view.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends ReplacementSpan {
    private Drawable fpk;
    private Drawable fpl;
    private int fpm;
    private int fpn;
    private int fpo;
    private int fpp;
    private int fpq;
    private int fpt;
    private boolean fpu;
    private int mSize;
    private int fpg = R.drawable.icon_pure_evaluation_star24_n;
    private int fph = R.color.CAM_X0112;
    private int fpi = R.drawable.icon_pure_evaluation_star24_n;
    private int fpj = R.color.CAM_X0305;
    private int fpr = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.fpt = i;
        this.fpm = i2;
        this.fpn = i3;
        this.fpo = i4;
        this.fpq = i5;
        this.fpu = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.fpr * this.fpn) + (this.fpm * (this.fpr - 1)) + this.fpo + this.fpq;
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        bvc();
        this.fpp = (int) paint.getTextSize();
        int i6 = this.fpq + ((int) f);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (com.baidu.tbadk.core.elementsMaven.view.a.k(charSequence)) {
            com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, (int) paint.getTextSize());
            dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        } else {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds3) + 0;
        }
        int max = fontMetricsInt.ascent + i4 + dimenPixelSize + Math.max(0, (this.fpu ? (i5 - i4) / 2 : 0) + ((this.fpp - this.fpn) / 2));
        int i7 = i6;
        for (int i8 = 0; i8 < this.fpt; i8++) {
            this.fpl.setBounds(i7, max, this.fpn + i7, this.fpn + max);
            this.fpl.draw(canvas);
            i7 += this.fpm + this.fpn;
        }
        int i9 = i7;
        for (int i10 = this.fpt; i10 < this.fpr; i10++) {
            this.fpk.setBounds(i9, max, this.fpn + i9, this.fpn + max);
            this.fpk.draw(canvas);
            i9 += this.fpm + this.fpn;
        }
    }

    private void bvc() {
        this.fpk = SvgManager.bsU().a(this.fpg, this.fph, (SvgManager.SvgResourceStateType) null);
        this.fpl = SvgManager.bsU().a(this.fpi, this.fpj, (SvgManager.SvgResourceStateType) null);
    }
}
