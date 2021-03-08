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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EMRichTextAnyIconSpan extends ReplacementSpan {
    private static final int DEFAULT_PADDING = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
    private int eXU;
    private IconType eXV;
    private int eXW;
    private int eXX;
    private int eXY;
    private int eXZ;

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    public EMRichTextAnyIconSpan(int i, int i2, IconType iconType) {
        this.eXU = i;
        this.eXV = iconType;
        this.eXW = i2;
        setPadding(DEFAULT_PADDING);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        if (this.eXX == 0) {
            this.eXX = (int) paint.getTextSize();
        }
        return this.eXY + this.eXZ + this.eXX;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable;
        float dimenPixelSize;
        if (this.eXV == IconType.WEBP) {
            drawable = WebPManager.a(this.eXU, ap.getColor(this.eXW), WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.eXV == IconType.SVG) {
            drawable = SvgManager.bsU().a(this.eXU, this.eXW, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            drawable = ap.getDrawable(this.eXU);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.eXX, this.eXX);
            canvas.save();
            float f2 = f + this.eXY;
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

    public void oo(int i) {
        this.eXX = i;
    }

    public void setLeftPadding(int i) {
        this.eXY = i;
    }

    public void setRightPadding(int i) {
        this.eXZ = i;
    }

    public void setPadding(int i) {
        this.eXY = i;
        this.eXZ = i;
    }
}
