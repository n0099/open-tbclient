package com.baidu.tbadk.core.elementsMaven.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.elementsMaven.view.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EMRichTextAnyIconSpan extends ReplacementSpan {
    private static final int DEFAULT_PADDING = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
    private int eOR;
    private IconType eOS;
    private int eOT;
    private int eOU;
    private int eOV;
    private int eOW;

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    public EMRichTextAnyIconSpan(int i, int i2, IconType iconType) {
        this.eOR = i;
        this.eOS = iconType;
        this.eOT = i2;
        setPadding(DEFAULT_PADDING);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.eOU = (int) paint.getTextSize();
        return this.eOV + this.eOW + this.eOU;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable;
        float dimenPixelSize;
        if (this.eOS == IconType.WEBP) {
            drawable = WebPManager.a(this.eOR, ap.getColor(this.eOT), WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.eOS == IconType.SVG) {
            drawable = SvgManager.btW().a(this.eOR, this.eOT, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            drawable = ap.getDrawable(this.eOR);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.eOU, this.eOU);
            canvas.save();
            float f2 = f + this.eOV;
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
        this.eOV = i;
    }

    public void setRightPadding(int i) {
        this.eOW = i;
    }

    public void setPadding(int i) {
        this.eOV = i;
        this.eOW = i;
    }
}
