package com.baidu.tbadk.core.elementsMaven.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.elementsMaven.view.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EMRichTextAnyIconSpan extends ReplacementSpan {
    private static final int DEFAULT_PADDING = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
    private int eYQ;
    private IconType eYR;
    private int eYS;
    private int eYT;
    private int eYU;
    private int eYV;

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    public EMRichTextAnyIconSpan(int i, int i2, IconType iconType) {
        this.eYQ = i;
        this.eYR = iconType;
        this.eYS = i2;
        setPadding(DEFAULT_PADDING);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.eYT = (int) paint.getTextSize();
        return this.eYU + this.eYV + this.eYT;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable;
        float dimenPixelSize;
        if (this.eYR == IconType.WEBP) {
            drawable = WebPManager.a(this.eYQ, ao.getColor(this.eYS), WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.eYR == IconType.SVG) {
            drawable = SvgManager.bwr().a(this.eYQ, this.eYS, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            drawable = ao.getDrawable(this.eYQ);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.eYT, this.eYT);
            canvas.save();
            float f2 = f + this.eYU;
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (!a.k(charSequence)) {
                dimenPixelSize = 0.0f + UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            } else {
                a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = 0.0f - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            }
            canvas.translate(f2, dimenPixelSize + fontMetricsInt.ascent + i4);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public void setLeftPadding(int i) {
        this.eYU = i;
    }

    public void setRightPadding(int i) {
        this.eYV = i;
    }

    public void setPadding(int i) {
        this.eYU = i;
        this.eYV = i;
    }
}
