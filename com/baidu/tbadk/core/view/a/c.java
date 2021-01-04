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
    private Drawable fqc;
    private Drawable fqd;
    private int fqe;
    private int fqf;
    private int fqg;
    private int fqh;
    private int fqi;
    private int fqk;
    private boolean fql;
    private int mSize;
    private int fpY = R.drawable.icon_pure_evaluation_star24_n;
    private int fpZ = R.color.CAM_X0112;
    private int fqa = R.drawable.icon_pure_evaluation_star24_n;
    private int fqb = R.color.CAM_X0305;
    private int fqj = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.fqk = i;
        this.fqe = i2;
        this.fqf = i3;
        this.fqg = i4;
        this.fqi = i5;
        this.fql = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.fqj * this.fqf) + (this.fqe * (this.fqj - 1)) + this.fqg + this.fqi;
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        byy();
        this.fqh = (int) paint.getTextSize();
        int i6 = this.fqi + ((int) f);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (com.baidu.tbadk.core.elementsMaven.view.a.k(charSequence)) {
            com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, (int) paint.getTextSize());
            dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        } else {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds3) + 0;
        }
        int max = fontMetricsInt.ascent + i4 + dimenPixelSize + Math.max(0, (this.fql ? (i5 - i4) / 2 : 0) + ((this.fqh - this.fqf) / 2));
        int i7 = i6;
        for (int i8 = 0; i8 < this.fqk; i8++) {
            this.fqd.setBounds(i7, max, this.fqf + i7, this.fqf + max);
            this.fqd.draw(canvas);
            i7 += this.fqe + this.fqf;
        }
        int i9 = i7;
        for (int i10 = this.fqk; i10 < this.fqj; i10++) {
            this.fqc.setBounds(i9, max, this.fqf + i9, this.fqf + max);
            this.fqc.draw(canvas);
            i9 += this.fqe + this.fqf;
        }
    }

    private void byy() {
        this.fqc = SvgManager.bwq().a(this.fpY, this.fpZ, (SvgManager.SvgResourceStateType) null);
        this.fqd = SvgManager.bwq().a(this.fqa, this.fqb, (SvgManager.SvgResourceStateType) null);
    }
}
