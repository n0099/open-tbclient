package com.baidu.tbadk.core.elementsMaven.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.elementsMaven.a.a;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EMRichTextAnyIconSpan extends ReplacementSpan {
    private static final int DEFAULT_PADDING = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
    private int eHH;
    private IconType eHI;
    private int eHJ;
    private int eHK;
    private int eHL;
    private int eHM;

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    public EMRichTextAnyIconSpan(int i, int i2, IconType iconType) {
        this.eHH = i;
        this.eHI = iconType;
        this.eHJ = i2;
        setPadding(DEFAULT_PADDING);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.eHK = (int) paint.getTextSize();
        return this.eHL + this.eHM + this.eHK;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable;
        float dimenPixelSize;
        if (this.eHI == IconType.WEBP) {
            drawable = WebPManager.a(this.eHH, ap.getColor(this.eHJ), WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.eHI == IconType.SVG) {
            drawable = SvgManager.bqB().a(this.eHH, this.eHJ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            drawable = ap.getDrawable(this.eHH);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.eHK, this.eHK);
            canvas.save();
            float f2 = f + this.eHL;
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (!k(charSequence)) {
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

    public void setPadding(int i) {
        this.eHL = i;
        this.eHM = i;
    }

    private boolean k(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            return ((EMTextView.a[]) spanned.getSpans(0, spanned.length(), EMTextView.a.class)).length > 0;
        }
        return false;
    }
}
