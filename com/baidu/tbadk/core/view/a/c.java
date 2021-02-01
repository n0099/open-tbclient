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
    private Drawable fnK;
    private Drawable fnL;
    private int fnM;
    private int fnN;
    private int fnO;
    private int fnP;
    private int fnQ;
    private int fnS;
    private boolean fnT;
    private int mSize;
    private int fnG = R.drawable.icon_pure_evaluation_star24_n;
    private int fnH = R.color.CAM_X0112;
    private int fnI = R.drawable.icon_pure_evaluation_star24_n;
    private int fnJ = R.color.CAM_X0305;
    private int fnR = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.fnS = i;
        this.fnM = i2;
        this.fnN = i3;
        this.fnO = i4;
        this.fnQ = i5;
        this.fnT = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.fnR * this.fnN) + (this.fnM * (this.fnR - 1)) + this.fnO + this.fnQ;
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        buZ();
        this.fnP = (int) paint.getTextSize();
        int i6 = this.fnQ + ((int) f);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (com.baidu.tbadk.core.elementsMaven.view.a.k(charSequence)) {
            com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, (int) paint.getTextSize());
            dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        } else {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds3) + 0;
        }
        int max = fontMetricsInt.ascent + i4 + dimenPixelSize + Math.max(0, (this.fnT ? (i5 - i4) / 2 : 0) + ((this.fnP - this.fnN) / 2));
        int i7 = i6;
        for (int i8 = 0; i8 < this.fnS; i8++) {
            this.fnL.setBounds(i7, max, this.fnN + i7, this.fnN + max);
            this.fnL.draw(canvas);
            i7 += this.fnM + this.fnN;
        }
        int i9 = i7;
        for (int i10 = this.fnS; i10 < this.fnR; i10++) {
            this.fnK.setBounds(i9, max, this.fnN + i9, this.fnN + max);
            this.fnK.draw(canvas);
            i9 += this.fnM + this.fnN;
        }
    }

    private void buZ() {
        this.fnK = SvgManager.bsR().a(this.fnG, this.fnH, (SvgManager.SvgResourceStateType) null);
        this.fnL = SvgManager.bsR().a(this.fnI, this.fnJ, (SvgManager.SvgResourceStateType) null);
    }
}
