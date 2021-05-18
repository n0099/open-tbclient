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
import d.a.j0.r.u.e.a;
/* loaded from: classes3.dex */
public class EMRichTextAnyIconSpan extends ReplacementSpan {
    public static final int k = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);

    /* renamed from: e  reason: collision with root package name */
    public int f12175e;

    /* renamed from: f  reason: collision with root package name */
    public IconType f12176f;

    /* renamed from: g  reason: collision with root package name */
    public int f12177g;

    /* renamed from: h  reason: collision with root package name */
    public int f12178h;

    /* renamed from: i  reason: collision with root package name */
    public int f12179i;
    public int j;

    /* loaded from: classes3.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    public EMRichTextAnyIconSpan(int i2, int i3, IconType iconType) {
        this.f12175e = i2;
        this.f12176f = iconType;
        this.f12177g = i3;
        b(k);
    }

    public void a(int i2) {
        this.f12179i = i2;
    }

    public void b(int i2) {
        this.f12179i = i2;
        this.j = i2;
    }

    public void c(int i2) {
        this.j = i2;
    }

    public void d(int i2) {
        this.f12178h = i2;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        Drawable drawable;
        float dimenPixelSize;
        IconType iconType = this.f12176f;
        if (iconType == IconType.WEBP) {
            drawable = WebPManager.getPureDrawable(this.f12175e, SkinManager.getColor(this.f12177g), WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (iconType == IconType.SVG) {
            drawable = SvgManager.getInstance().getPureDrawable(this.f12175e, this.f12177g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            drawable = SkinManager.getDrawable(this.f12175e);
        }
        if (drawable == null) {
            return;
        }
        int i7 = this.f12178h;
        drawable.setBounds(0, 0, i7, i7);
        canvas.save();
        float f3 = f2 + this.f12179i;
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (a.b(charSequence)) {
            a.a(fontMetricsInt, (int) paint.getTextSize());
            dimenPixelSize = 0.0f - UtilHelper.getDimenPixelSize(R.dimen.tbds2);
        } else {
            dimenPixelSize = 0.0f + UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        }
        canvas.translate(f3, dimenPixelSize + i5 + fontMetricsInt.ascent);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        if (this.f12178h == 0) {
            this.f12178h = (int) paint.getTextSize();
        }
        return this.f12179i + this.j + this.f12178h;
    }
}
