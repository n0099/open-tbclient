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
    private Drawable eTZ;
    private Drawable eUa;
    private int eUb;
    private int eUc;
    private int eUd;
    private int eUe;
    private int eUf;
    private int eUh;
    private boolean eUi;
    private int mSize;
    private int eTV = R.drawable.icon_pure_evaluation_star24_n;
    private int eTW = R.color.cp_cont_i;
    private int eTX = R.drawable.icon_pure_evaluation_star24_n;
    private int eTY = R.color.cp_link_tip_d;
    private int eUg = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.eUh = i;
        this.eUb = i2;
        this.eUc = i3;
        this.eUd = i4;
        this.eUf = i5;
        this.eUi = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.eUg * this.eUc) + (this.eUb * (this.eUg - 1)) + this.eUd + this.eUf;
        if (fontMetricsInt != null) {
            this.eUe = fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        bqO();
        this.eUe = Math.max(this.eUe, (int) paint.getTextSize());
        int i6 = this.eUf + ((int) f);
        int max = i3 + Math.max(0, (this.eUi ? (i5 - i4) / 2 : 0) + ((this.eUe - this.eUc) / 2));
        for (int i7 = 0; i7 < this.eUh; i7++) {
            this.eUa.setBounds(i6, max, this.eUc + i6, this.eUc + max);
            this.eUa.draw(canvas);
            i6 += this.eUb + this.eUc;
        }
        for (int i8 = this.eUh; i8 < this.eUg; i8++) {
            this.eTZ.setBounds(i6, max, this.eUc + i6, this.eUc + max);
            this.eTZ.draw(canvas);
            i6 += this.eUb + this.eUc;
        }
    }

    private void bqO() {
        this.eTZ = SvgManager.boN().a(this.eTV, this.eTW, (SvgManager.SvgResourceStateType) null);
        this.eUa = SvgManager.boN().a(this.eTX, this.eTY, (SvgManager.SvgResourceStateType) null);
    }
}
