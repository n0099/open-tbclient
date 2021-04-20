package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public abstract class TBSpecificationButtonConfig {

    /* renamed from: a  reason: collision with root package name */
    public WebpType f13267a;

    /* renamed from: b  reason: collision with root package name */
    public int f13268b;

    /* renamed from: c  reason: collision with root package name */
    public int f13269c;

    /* renamed from: d  reason: collision with root package name */
    public int f13270d;

    /* renamed from: f  reason: collision with root package name */
    public IconType f13272f;

    /* renamed from: h  reason: collision with root package name */
    public int f13274h;
    public boolean i;
    public a s;
    public boolean p = true;
    public int q = 0;
    public GradientDrawable.Orientation r = GradientDrawable.Orientation.LEFT_RIGHT;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f13271e = new int[2];
    public int j = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    public int k = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    public int l = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    public int m = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    public int n = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    public int o = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);

    /* renamed from: g  reason: collision with root package name */
    public int f13273g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

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

    public final Drawable b(int i) {
        Drawable drawable;
        IconType iconType = this.f13272f;
        if (iconType == IconType.SVG) {
            int i2 = this.f13274h;
            if (i2 <= 0) {
                i2 = this.f13268b;
            }
            drawable = SvgManager.getInstance().getPureDrawableColorInt(i, SkinManager.getColor(this.q, i2), SvgManager.SvgResourceStateType.NORMAL);
        } else if (iconType == IconType.WEBP) {
            if (this.f13267a == WebpType.MASK) {
                drawable = WebPManager.getMaskDrawable(i, null);
            } else {
                int i3 = this.f13274h;
                if (i3 <= 0) {
                    i3 = this.f13268b;
                }
                drawable = WebPManager.getPureDrawable(i, SkinManager.getColor(this.q, i3), null);
            }
        } else {
            drawable = SkinManager.getDrawable(this.q, i);
        }
        if (drawable != null) {
            int i4 = this.f13273g;
            drawable.setBounds(0, 0, i4, i4);
        }
        return drawable;
    }

    public Drawable c() {
        return b(this.f13271e[0]);
    }

    public Drawable d() {
        return b(this.f13271e[1]);
    }

    public void e(GradientDrawable.Orientation orientation) {
        this.r = orientation;
    }

    public void f(int i) {
        this.m = i;
    }

    public void g(int i) {
        if (i <= 0 || this.f13273g == i) {
            return;
        }
        this.f13273g = i;
        a aVar = this.s;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void h(@ColorRes int i) {
        if (this.f13274h != i) {
            this.f13274h = i;
            a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void i(int i, int i2, IconType iconType) {
        int[] iArr = this.f13271e;
        if (iArr[0] == i && iArr[1] == i2 && this.f13272f == iconType) {
            return;
        }
        int[] iArr2 = this.f13271e;
        iArr2[0] = i;
        iArr2[1] = i2;
        this.f13272f = iconType;
        a aVar = this.s;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void j(int i, int i2) {
        if (i > 0) {
            this.n = i;
        }
        if (i2 > 0) {
            this.o = i2;
        }
    }

    public void k(int i) {
        this.j = i;
        this.k = i;
    }

    public void l(int i, int i2) {
        this.j = i;
        this.k = i2;
    }

    public void m(int i) {
        this.l = i;
    }

    public void n(WebpType webpType) {
        this.f13267a = webpType;
    }
}
