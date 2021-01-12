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
    private int flA;
    private boolean flB;
    private Drawable fls;
    private Drawable flt;
    private int flu;
    private int flv;
    private int flw;
    private int flx;
    private int fly;
    private int mSize;
    private int flo = R.drawable.icon_pure_evaluation_star24_n;
    private int flp = R.color.CAM_X0112;
    private int flq = R.drawable.icon_pure_evaluation_star24_n;
    private int flr = R.color.CAM_X0305;
    private int flz = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.flA = i;
        this.flu = i2;
        this.flv = i3;
        this.flw = i4;
        this.fly = i5;
        this.flB = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.flz * this.flv) + (this.flu * (this.flz - 1)) + this.flw + this.fly;
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        buF();
        this.flx = (int) paint.getTextSize();
        int i6 = this.fly + ((int) f);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (com.baidu.tbadk.core.elementsMaven.view.a.k(charSequence)) {
            com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, (int) paint.getTextSize());
            dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        } else {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds3) + 0;
        }
        int max = fontMetricsInt.ascent + i4 + dimenPixelSize + Math.max(0, (this.flB ? (i5 - i4) / 2 : 0) + ((this.flx - this.flv) / 2));
        int i7 = i6;
        for (int i8 = 0; i8 < this.flA; i8++) {
            this.flt.setBounds(i7, max, this.flv + i7, this.flv + max);
            this.flt.draw(canvas);
            i7 += this.flu + this.flv;
        }
        int i9 = i7;
        for (int i10 = this.flA; i10 < this.flz; i10++) {
            this.fls.setBounds(i9, max, this.flv + i9, this.flv + max);
            this.fls.draw(canvas);
            i9 += this.flu + this.flv;
        }
    }

    private void buF() {
        this.fls = SvgManager.bsx().a(this.flo, this.flp, (SvgManager.SvgResourceStateType) null);
        this.flt = SvgManager.bsx().a(this.flq, this.flr, (SvgManager.SvgResourceStateType) null);
    }
}
