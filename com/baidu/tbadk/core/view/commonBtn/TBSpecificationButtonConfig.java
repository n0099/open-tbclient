package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public abstract class TBSpecificationButtonConfig {

    /* renamed from: a  reason: collision with root package name */
    public WebpType f12541a;

    /* renamed from: b  reason: collision with root package name */
    public int f12542b;

    /* renamed from: c  reason: collision with root package name */
    public int f12543c;

    /* renamed from: d  reason: collision with root package name */
    public int f12544d;

    /* renamed from: f  reason: collision with root package name */
    public IconType f12546f;

    /* renamed from: h  reason: collision with root package name */
    public int f12548h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12549i;
    public a s;
    public boolean p = true;
    public int q = 0;
    public GradientDrawable.Orientation r = GradientDrawable.Orientation.LEFT_RIGHT;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f12545e = new int[2];
    public int j = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    public int k = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    public int l = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    public int m = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    public int n = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    public int o = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);

    /* renamed from: g  reason: collision with root package name */
    public int f12547g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes3.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* loaded from: classes3.dex */
    public enum WebpType {
        MASK,
        PURE
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public abstract Drawable a(float f2);

    public final Drawable b(int i2) {
        Drawable drawable;
        IconType iconType = this.f12546f;
        if (iconType == IconType.SVG) {
            int i3 = this.f12548h;
            if (i3 <= 0) {
                i3 = this.f12542b;
            }
            drawable = SvgManager.getInstance().getPureDrawableColorInt(i2, SkinManager.getColor(this.q, i3), SvgManager.SvgResourceStateType.NORMAL);
        } else if (iconType == IconType.WEBP) {
            if (this.f12541a == WebpType.MASK) {
                drawable = WebPManager.getMaskDrawable(i2, (WebPManager.ResourceStateType) null);
            } else {
                int i4 = this.f12548h;
                if (i4 <= 0) {
                    i4 = this.f12542b;
                }
                drawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(this.q, i4), null);
            }
        } else {
            drawable = SkinManager.getDrawable(this.q, i2);
        }
        if (drawable != null) {
            int i5 = this.f12547g;
            drawable.setBounds(0, 0, i5, i5);
        }
        return drawable;
    }

    public Drawable c() {
        return b(this.f12545e[0]);
    }

    public Drawable d() {
        return b(this.f12545e[1]);
    }

    public void e(GradientDrawable.Orientation orientation) {
        this.r = orientation;
    }

    public void f(int i2) {
        this.m = i2;
    }

    public void g(int i2) {
        if (i2 <= 0 || this.f12547g == i2) {
            return;
        }
        this.f12547g = i2;
        a aVar = this.s;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void h(@ColorRes int i2) {
        if (this.f12548h != i2) {
            this.f12548h = i2;
            a aVar = this.s;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void i(int i2, int i3, IconType iconType) {
        int[] iArr = this.f12545e;
        if (iArr[0] == i2 && iArr[1] == i3 && this.f12546f == iconType) {
            return;
        }
        int[] iArr2 = this.f12545e;
        iArr2[0] = i2;
        iArr2[1] = i3;
        this.f12546f = iconType;
        a aVar = this.s;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void j(int i2, int i3) {
        if (i2 > 0) {
            this.n = i2;
        }
        if (i3 > 0) {
            this.o = i3;
        }
    }

    public void k(int i2) {
        this.j = i2;
        this.k = i2;
    }

    public void l(int i2, int i3) {
        this.j = i2;
        this.k = i3;
    }

    public void m(int i2) {
        this.l = i2;
    }

    public void n(WebpType webpType) {
        this.f12541a = webpType;
    }
}
