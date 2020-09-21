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
    private int ezA;
    private int ezB;
    private int ezC;
    private int ezE;
    private boolean ezF;
    private Drawable ezw;
    private Drawable ezx;
    private int ezy;
    private int ezz;
    private int mSize;
    private int ezs = R.drawable.icon_pure_evaluation_star24_n;
    private int ezt = R.color.cp_cont_i;
    private int ezu = R.drawable.icon_pure_evaluation_star24_n;
    private int ezv = R.color.cp_link_tip_d;
    private int ezD = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.ezE = i;
        this.ezy = i2;
        this.ezz = i3;
        this.ezA = i4;
        this.ezC = i5;
        this.ezF = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.ezD * this.ezz) + (this.ezy * (this.ezD - 1)) + this.ezA + this.ezC;
        if (fontMetricsInt != null) {
            this.ezB = fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        bml();
        this.ezB = Math.max(this.ezB, (int) paint.getTextSize());
        int i6 = this.ezC + ((int) f);
        int max = i3 + Math.max(0, (this.ezF ? (i5 - i4) / 2 : 0) + ((this.ezB - this.ezz) / 2));
        for (int i7 = 0; i7 < this.ezE; i7++) {
            this.ezx.setBounds(i6, max, this.ezz + i6, this.ezz + max);
            this.ezx.draw(canvas);
            i6 += this.ezy + this.ezz;
        }
        for (int i8 = this.ezE; i8 < this.ezD; i8++) {
            this.ezw.setBounds(i6, max, this.ezz + i6, this.ezz + max);
            this.ezw.draw(canvas);
            i6 += this.ezy + this.ezz;
        }
    }

    private void bml() {
        this.ezw = SvgManager.bkl().a(this.ezs, this.ezt, (SvgManager.SvgResourceStateType) null);
        this.ezx = SvgManager.bkl().a(this.ezu, this.ezv, (SvgManager.SvgResourceStateType) null);
    }
}
