package com.baidu.tbadk.core.view.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends ReplacementSpan {
    private int fgB;
    private boolean fgC;
    private Drawable fgt;
    private Drawable fgu;
    private int fgv;
    private int fgw;
    private int fgx;
    private int fgy;
    private int fgz;
    private int mSize;
    private int fgp = R.drawable.icon_pure_evaluation_star24_n;
    private int fgq = R.color.CAM_X0112;
    private int fgr = R.drawable.icon_pure_evaluation_star24_n;
    private int fgs = R.color.CAM_X0305;
    private int fgA = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.fgB = i;
        this.fgv = i2;
        this.fgw = i3;
        this.fgx = i4;
        this.fgz = i5;
        this.fgC = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.fgA * this.fgw) + (this.fgv * (this.fgA - 1)) + this.fgx + this.fgz;
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        bwe();
        this.fgy = (int) paint.getTextSize();
        int i6 = this.fgz + ((int) f);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (!com.baidu.tbadk.core.elementsMaven.view.a.k(charSequence)) {
            dimenPixelSize = 0 + UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        } else {
            com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, (int) paint.getTextSize());
            dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        }
        int max = fontMetricsInt.ascent + i4 + dimenPixelSize + Math.max(0, (this.fgC ? (i5 - i4) / 2 : 0) + ((this.fgy - this.fgw) / 2));
        for (int i7 = 0; i7 < this.fgB; i7++) {
            this.fgu.setBounds(i6, max, this.fgw + i6, this.fgw + max);
            this.fgu.draw(canvas);
            i6 += this.fgv + this.fgw;
        }
        for (int i8 = this.fgB; i8 < this.fgA; i8++) {
            this.fgt.setBounds(i6, max, this.fgw + i6, this.fgw + max);
            this.fgt.draw(canvas);
            i6 += this.fgv + this.fgw;
        }
    }

    private void bwe() {
        this.fgt = SvgManager.btW().a(this.fgp, this.fgq, (SvgManager.SvgResourceStateType) null);
        this.fgu = SvgManager.btW().a(this.fgr, this.fgs, (SvgManager.SvgResourceStateType) null);
    }
}
