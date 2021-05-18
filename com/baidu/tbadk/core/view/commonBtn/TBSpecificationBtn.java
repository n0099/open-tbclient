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
import d.a.c.e.p.l;
import d.a.j0.r.f0.m.b;
/* loaded from: classes3.dex */
public class TBSpecificationBtn extends View {

    /* renamed from: e  reason: collision with root package name */
    public Object f12565e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationButtonConfig f12566f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f12567g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f12568h;

    /* renamed from: i  reason: collision with root package name */
    public String f12569i;
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
            if (width <= 0 || TBSpecificationBtn.this.getLayoutParams().width != -2 || TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.f12566f.j + TBSpecificationBtn.this.f12566f.k == width) {
                return;
            }
            TBSpecificationBtn.this.requestLayout();
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void b() {
            TBSpecificationBtn.this.o();
            int width = TBSpecificationBtn.this.getWidth();
            if (width > 0 && TBSpecificationBtn.this.getLayoutParams().width == -2 && TBSpecificationBtn.this.getContentWidth() + TBSpecificationBtn.this.f12566f.j + TBSpecificationBtn.this.f12566f.k != width) {
                TBSpecificationBtn.this.requestLayout();
            } else {
                TBSpecificationBtn.this.invalidate();
            }
        }

        @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig.a
        public void c() {
            TBSpecificationBtn tBSpecificationBtn = TBSpecificationBtn.this;
            tBSpecificationBtn.n(tBSpecificationBtn.p);
            TBSpecificationBtn.this.invalidate();
        }
    }

    public TBSpecificationBtn(Context context) {
        super(context);
        this.f12565e = null;
        this.f12569i = "";
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
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f12566f;
        int i2 = 0;
        if (tBSpecificationButtonConfig.f12575e[0] > 0) {
            i2 = tBSpecificationButtonConfig.f12577g;
            if (!StringUtils.isNull(this.f12569i)) {
                i2 += this.f12566f.m;
            }
        }
        TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f12566f;
        if (tBSpecificationButtonConfig2.f12575e[1] > 0) {
            i2 = tBSpecificationButtonConfig2.f12577g;
            if (!StringUtils.isNull(this.f12569i)) {
                i2 += this.f12566f.m;
            }
        }
        return i2 + this.l.width();
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        int[] drawableState;
        boolean z = true;
        boolean z2 = false;
        for (int i2 : getDrawableState()) {
            if (i2 == 16842910) {
                z = false;
            } else if (i2 == 16842919) {
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
        return this.f12566f;
    }

    public void k() {
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(int i2) {
        this.p = i2;
        this.f12566f.q = i2;
        o();
        n(i2);
        invalidate();
    }

    public final void m() {
        this.p = TbadkCoreApplication.getInst().getSkinType();
        b bVar = new b();
        this.f12566f = bVar;
        bVar.s = this.r;
        Paint paint = new Paint();
        this.f12568h = paint;
        paint.setTextSize(l.g(getContext(), R.dimen.T_X08));
        this.f12568h.setAntiAlias(true);
    }

    public final void n(int i2) {
        if (getHeight() == 0) {
            return;
        }
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f12566f;
        tBSpecificationButtonConfig.q = i2;
        this.f12567g = tBSpecificationButtonConfig.a(getHeight() / 2);
        Paint paint = this.f12568h;
        TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f12566f;
        paint.setColor(tBSpecificationButtonConfig2.p ? SkinManager.getColor(i2, tBSpecificationButtonConfig2.f12572b) : tBSpecificationButtonConfig2.f12572b);
    }

    public final void o() {
        this.j = this.f12566f.c();
        this.k = this.f12566f.d();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.m) {
            n(this.p);
            o();
            this.m = false;
        }
        Drawable drawable = this.f12567g;
        if (drawable != null) {
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setCornerRadius(getHeight() / 2);
            }
            this.f12567g.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.f12567g.draw(canvas);
        }
        int width = ((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft();
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f12566f;
        int i2 = tBSpecificationButtonConfig.j;
        if (width != tBSpecificationButtonConfig.k + i2) {
            i2 = ((((getWidth() - getContentWidth()) - getPaddingRight()) - getPaddingLeft()) / 2) + getPaddingLeft();
        }
        int height = (getHeight() + getPaddingTop()) / 2;
        int i3 = this.f12566f.f12577g;
        int i4 = i3 / 2;
        Drawable drawable2 = this.j;
        if (drawable2 != null) {
            drawable2.setBounds(i2, height - i4, i3 + i2, height + i4);
            this.j.draw(canvas);
            TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.f12566f;
            i2 += tBSpecificationButtonConfig2.f12577g + tBSpecificationButtonConfig2.m;
        }
        Drawable drawable3 = this.k;
        if (drawable3 != null) {
            TBSpecificationButtonConfig tBSpecificationButtonConfig3 = this.f12566f;
            int i5 = tBSpecificationButtonConfig3.m;
            drawable3.setBounds(i2 + i5, height - i4, i5 + i2 + tBSpecificationButtonConfig3.f12577g, height + i4);
            this.k.draw(canvas);
        }
        if (this.o) {
            i2 = (getWidth() - this.l.width()) / 2;
        }
        if (StringUtils.isNull(this.f12569i)) {
            return;
        }
        Paint paint = this.f12568h;
        String str = this.f12569i;
        paint.getTextBounds(str, 0, str.length(), this.l);
        canvas.drawText(this.f12569i, i2, (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.l.centerY(), this.f12568h);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int q = q(i2);
        setMeasuredDimension(q, !this.f12566f.f12579i ? p(i3) : q);
    }

    public final int p(int i2) {
        float textSize = this.f12568h.getTextSize();
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            return View.MeasureSpec.getSize(i2);
        }
        return (int) Math.max(this.f12566f.o, textSize + (this.f12566f.l * 2) + getPaddingTop() + getPaddingBottom());
    }

    public final int q(int i2) {
        float contentWidth = getContentWidth();
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            return View.MeasureSpec.getSize(i2);
        }
        TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f12566f;
        return (int) Math.max(this.f12566f.n, contentWidth + tBSpecificationButtonConfig.j + tBSpecificationButtonConfig.k + getPaddingLeft() + getPaddingRight());
    }

    public void setClickState(boolean z) {
        this.n = z;
    }

    public void setConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        if (tBSpecificationButtonConfig == null) {
            return;
        }
        this.f12566f = tBSpecificationButtonConfig;
        tBSpecificationButtonConfig.s = this.r;
        this.m = true;
    }

    public void setText(String str) {
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.f12569i = str;
        this.f12568h.getTextBounds(str, 0, str.length(), this.l);
        int width = getWidth();
        if (width > 0) {
            if (getLayoutParams().width == -2) {
                int contentWidth = getContentWidth();
                TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f12566f;
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

    public void setTextSize(@DimenRes int i2) {
        this.f12568h.setTextSize(l.g(getContext(), i2));
        Paint paint = this.f12568h;
        String str = this.f12569i;
        paint.getTextBounds(str, 0, str.length(), this.l);
        int width = getWidth();
        if (width > 0 && getLayoutParams().width == -2) {
            int contentWidth = getContentWidth();
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.f12566f;
            if (contentWidth + tBSpecificationButtonConfig.j + tBSpecificationButtonConfig.k != width) {
                requestLayout();
                return;
            }
        }
        int height = getHeight();
        if (height <= 0 || getLayoutParams().height != -2 || ((int) this.f12568h.getTextSize()) + (this.f12566f.l * 2) == height) {
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
        this.f12565e = null;
        this.f12569i = "";
        this.l = new Rect();
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = 0;
        this.q = false;
        this.r = new a();
        m();
    }

    public TBSpecificationBtn(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12565e = null;
        this.f12569i = "";
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
