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
    private Drawable eYW;
    private Drawable eYX;
    private int eYY;
    private int eYZ;
    private int eZa;
    private int eZb;
    private int eZc;
    private int eZe;
    private boolean eZf;
    private int mSize;
    private int eYS = R.drawable.icon_pure_evaluation_star24_n;
    private int eYT = R.color.CAM_X0112;
    private int eYU = R.drawable.icon_pure_evaluation_star24_n;
    private int eYV = R.color.CAM_X0305;
    private int eZd = 5;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.eZe = i;
        this.eYY = i2;
        this.eYZ = i3;
        this.eZa = i4;
        this.eZc = i5;
        this.eZf = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (this.eZd * this.eYZ) + (this.eYY * (this.eZd - 1)) + this.eZa + this.eZc;
        if (fontMetricsInt != null) {
            this.eZb = fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        bsE();
        this.eZb = Math.max(this.eZb, (int) paint.getTextSize());
        int i6 = this.eZc + ((int) f);
        int max = i3 + Math.max(0, (this.eZf ? (i5 - i4) / 2 : 0) + ((this.eZb - this.eYZ) / 2));
        for (int i7 = 0; i7 < this.eZe; i7++) {
            this.eYX.setBounds(i6, max, this.eYZ + i6, this.eYZ + max);
            this.eYX.draw(canvas);
            i6 += this.eYY + this.eYZ;
        }
        for (int i8 = this.eZe; i8 < this.eZd; i8++) {
            this.eYW.setBounds(i6, max, this.eYZ + i6, this.eYZ + max);
            this.eYW.draw(canvas);
            i6 += this.eYY + this.eYZ;
        }
    }

    private void bsE() {
        this.eYW = SvgManager.bqB().a(this.eYS, this.eYT, (SvgManager.SvgResourceStateType) null);
        this.eYX = SvgManager.bqB().a(this.eYU, this.eYV, (SvgManager.SvgResourceStateType) null);
    }
}
