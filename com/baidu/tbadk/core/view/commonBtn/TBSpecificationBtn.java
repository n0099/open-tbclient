package com.baidu.tbadk.core.view.commonBtn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DimenRes;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.r.f0.m.b;
/* loaded from: classes3.dex */
public class TBSpecificationBtn extends View {

    /* renamed from: e  reason: collision with root package name */
    public Object f13262e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationButtonConfig f13263f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f13264g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f13265h;
    public String i;
    public Drawable j;
    public Drawable k;
    public Rect l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public TBSpecificationButtonConfig.a r;

    /* loaded from: classes3.dex */
    public class a implements TBSpecificationButtonConfig.a {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void a() {
            int width = TBSpecificationBtn.this.getWidth();
            if (width <= 0 || TBSpecificationBtn.this.getLayoutParams().width != -2 || TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.f13263f.j + TBSpecificationBtn.this.f13263f.k == width) {
                return;
            }
            TBSpecificationBtn.this.requestLayout();
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void b() {
            TBSpecificationBtn tBSpecificationBtn = TBSpecificationBtn.this;
            tBSpecificationBtn.n(tBSpecificationBtn.p);
            TBSpecificationBtn.this.invalidate();
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void c() {
            TBSpecificationBtn.this.o();
            int width = TBSpecificationBtn.this.getWidth();
            if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.f13263f.j + TBSpecificationBtn.this.f13263f.k != width) {
                TBSpecificationBtn.this.requestLayout();
            } else {
                TBSpecificationBtn.this.invalidate();
            }
        }
    }

    public TBSpecificationBtn(Context context) {
        super(context);
        this.f13262e = null;
        this.i = "";
        this.l = new Rect();
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = 0;
        this.q = false;
        this.r = new a();
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentWidth() {
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f13263f;
        int i = 0;
        if (tBSpecificationButtonConfig.f13271e[0] > 0) {
            i = tBSpecificationButtonConfig.f13273g;
            if (!StringUtils.isNull(this.i)) {
                i += this.f13263f.m;
            }
        }
        TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f13263f;
        if (tBSpecificationButtonConfig2.f13271e[1] > 0) {
            i = tBSpecificationButtonConfig2.f13273g;
            if (!StringUtils.isNull(this.i)) {
                i += this.f13263f.m;
            }
        }
        return i + this.l.width();
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        int[] drawableState;
        boolean z = true;
        boolean z2 = false;
        for (int i : getDrawableState()) {
            if (i == 16842910) {
                z = false;
            } else if (i == 16842919) {
                z2 = true;
            }
        }
        if (this.n) {
            if (z) {
                setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
            } else if (z2 && isClickable()) {
                setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
            } else {
                setAlpha(1.0f);
            }
        } else if (this.q) {
            setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
        } else {
            setAlpha(1.0f);
        }
        super.drawableStateChanged();
    }

    public TBSpecificationButtonConfig getStyleConfig() {
        return this.f13263f;
    }

    public void k() {
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(int i) {
        this.p = i;
        this.f13263f.q = i;
        o();
        n(i);
        invalidate();
    }

    public final void m() {
        this.p = TbadkCoreApplication.getInst().getSkinType();
        b bVar = new b();
        this.f13263f = bVar;
        bVar.s = this.r;
        Paint paint = new Paint();
        this.f13265h = paint;
        paint.setTextSize(l.g(getContext(), R.dimen.T_X08));
        this.f13265h.setAntiAlias(true);
    }

    public final void n(int i) {
        if (getHeight() == 0) {
            return;
        }
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f13263f;
        tBSpecificationButtonConfig.q = i;
        this.f13264g = tBSpecificationButtonConfig.a(getHeight() / 2);
        Paint paint = this.f13265h;
        TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f13263f;
        paint.setColor(tBSpecificationButtonConfig2.p ? SkinManager.getColor(i, tBSpecificationButtonConfig2.f13268b) : tBSpecificationButtonConfig2.f13268b);
    }

    public final void o() {
        this.j = this.f13263f.c();
        this.k = this.f13263f.d();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.m) {
            n(this.p);
            o();
            this.m = false;
        }
        Drawable drawable = this.f13264g;
        if (drawable != null) {
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setCornerRadius(getHeight() / 2);
            }
            this.f13264g.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.f13264g.draw(canvas);
        }
        int width = ((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft();
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f13263f;
        int i = tBSpecificationButtonConfig.j;
        if (width != tBSpecificationButtonConfig.k + i) {
            i = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i2 = this.f13263f.f13273g;
        int i3 = i2 / 2;
        Drawable drawable2 = this.j;
        if (drawable2 != null) {
            drawable2.setBounds(i, height - i3, i2 + i, height + i3);
            this.j.draw(canvas);
            TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f13263f;
            i += tBSpecificationButtonConfig2.f13273g + tBSpecificationButtonConfig2.m;
        }
        Drawable drawable3 = this.k;
        if (drawable3 != null) {
            TBSpecificationButtonConfig tBSpecificationButtonConfig3 = this.f13263f;
            int i4 = tBSpecificationButtonConfig3.m;
            drawable3.setBounds(i + i4, height - i3, i4 + i + tBSpecificationButtonConfig3.f13273g, height + i3);
            this.k.draw(canvas);
        }
        if (this.o) {
            i = (getWidth() - this.l.width()) / 2;
        }
        if (StringUtils.isNull(this.i)) {
            return;
        }
        Paint paint = this.f13265h;
        String str = this.i;
        paint.getTextBounds(str, 0, str.length(), this.l);
        canvas.drawText(this.i, i, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.l.centerY(), this.f13265h);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int q = q(i);
        setMeasuredDimension(q, !this.f13263f.i ? p(i2) : q);
    }

    public final int p(int i) {
        float textSize = this.f13265h.getTextSize();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return (int) Math.max(this.f13263f.o, textSize + (this.f13263f.l * 2) + getPaddingTop() + getPaddingBottom());
    }

    public final int q(int i) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f13263f;
        return (int) Math.max(this.f13263f.n, contentWidth + tBSpecificationButtonConfig.j + tBSpecificationButtonConfig.k + getPaddingLeft() + getPaddingRight());
    }

    public void setClickState(boolean z) {
        this.n = z;
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig == null) {
            return;
        }
        this.f13263f = tBSpecificationButtonConfig;
        tBSpecificationButtonConfig.s = this.r;
        this.m = true;
    }

    public void setText(String str) {
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.i = str;
        this.f13265h.getTextBounds(str, 0, str.length(), this.l);
        int width = getWidth();
        if (width > 0) {
            if (getLayoutParams().width == -2) {
                int contentWidth = getContentWidth();
                TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f13263f;
                if (contentWidth + tBSpecificationButtonConfig.j + tBSpecificationButtonConfig.k != width) {
                    requestLayout();
                    return;
                } else {
                    invalidate();
                    return;
                }
            }
            invalidate();
        }
    }

    public void setTextHorizontalCenter(boolean z) {
        this.o = z;
    }

    public void setTextSize(@DimenRes int i) {
        this.f13265h.setTextSize(l.g(getContext(), i));
        Paint paint = this.f13265h;
        String str = this.i;
        paint.getTextBounds(str, 0, str.length(), this.l);
        int width = getWidth();
        if (width > 0 && getLayoutParams().width == -2) {
            int contentWidth = getContentWidth();
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f13263f;
            if (contentWidth + tBSpecificationButtonConfig.j + tBSpecificationButtonConfig.k != width) {
                requestLayout();
                return;
            }
        }
        int height = getHeight();
        if (height <= 0 || getLayoutParams().height != -2 || ((int) this.f13265h.getTextSize()) + (this.f13263f.l * 2) == height) {
            return;
        }
        requestLayout();
    }

    public void setUseDisableState(boolean z) {
        this.n = false;
        this.q = z;
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13262e = null;
        this.i = "";
        this.l = new Rect();
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = 0;
        this.q = false;
        this.r = new a();
        m();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13262e = null;
        this.i = "";
        this.l = new Rect();
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = 0;
        this.q = false;
        this.r = new a();
        m();
    }
}
