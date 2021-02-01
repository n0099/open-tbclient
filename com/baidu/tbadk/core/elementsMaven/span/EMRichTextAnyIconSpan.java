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
    private int eWA;
    private int eWv;
    private IconType eWw;
    private int eWx;
    private int eWy;
    private int eWz;

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    public EMRichTextAnyIconSpan(int i, int i2, IconType iconType) {
        this.eWv = i;
        this.eWw = iconType;
        this.eWx = i2;
        setPadding(DEFAULT_PADDING);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        if (this.eWy == 0) {
            this.eWy = (int) paint.getTextSize();
        }
        return this.eWz + this.eWA + this.eWy;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable;
        float dimenPixelSize;
        if (this.eWw == IconType.WEBP) {
            drawable = WebPManager.a(this.eWv, ap.getColor(this.eWx), WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.eWw == IconType.SVG) {
            drawable = SvgManager.bsR().a(this.eWv, this.eWx, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            drawable = ap.getDrawable(this.eWv);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.eWy, this.eWy);
            canvas.save();
            float f2 = f + this.eWz;
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

    public void on(int i) {
        this.eWy = i;
    }

    public void setLeftPadding(int i) {
        this.eWz = i;
    }

    public void setRightPadding(int i) {
        this.eWA = i;
    }

    public void setPadding(int i) {
        this.eWz = i;
        this.eWA = i;
    }
}
