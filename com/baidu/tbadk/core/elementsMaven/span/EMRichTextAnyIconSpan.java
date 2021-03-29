package com.baidu.tbadk.core.elementsMaven.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.b.h0.r.u.e.a;
/* loaded from: classes3.dex */
public class EMRichTextAnyIconSpan extends ReplacementSpan {
    public static final int k = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);

    /* renamed from: e  reason: collision with root package name */
    public int f13250e;

    /* renamed from: f  reason: collision with root package name */
    public IconType f13251f;

    /* renamed from: g  reason: collision with root package name */
    public int f13252g;

    /* renamed from: h  reason: collision with root package name */
    public int f13253h;
    public int i;
    public int j;

    /* loaded from: classes3.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    public EMRichTextAnyIconSpan(int i, int i2, IconType iconType) {
        this.f13250e = i;
        this.f13251f = iconType;
        this.f13252g = i2;
        b(k);
    }

    public void a(int i) {
        this.i = i;
    }

    public void b(int i) {
        this.i = i;
        this.j = i;
    }

    public void c(int i) {
        this.j = i;
    }

    public void d(int i) {
        this.f13253h = i;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable;
        float dimenPixelSize;
        IconType iconType = this.f13251f;
        if (iconType == IconType.WEBP) {
            drawable = WebPManager.getPureDrawable(this.f13250e, SkinManager.getColor(this.f13252g), WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (iconType == IconType.SVG) {
            drawable = SvgManager.getInstance().getPureDrawable(this.f13250e, this.f13252g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            drawable = SkinManager.getDrawable(this.f13250e);
        }
        if (drawable == null) {
            return;
        }
        int i6 = this.f13253h;
        drawable.setBounds(0, 0, i6, i6);
        canvas.save();
        float f3 = f2 + this.i;
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (a.b(charSequence)) {
            a.a(fontMetricsInt, (int) paint.getTextSize());
            dimenPixelSize = 0.0f - UtilHelper.getDimenPixelSize(R.dimen.tbds2);
        } else {
            dimenPixelSize = 0.0f + UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        }
        canvas.translate(f3, dimenPixelSize + i4 + fontMetricsInt.ascent);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        if (this.f13253h == 0) {
            this.f13253h = (int) paint.getTextSize();
        }
        return this.i + this.j + this.f13253h;
    }
}
