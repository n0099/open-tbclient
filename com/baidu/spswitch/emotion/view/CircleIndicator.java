package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.spswitch.b.a;
import com.baidu.spswitch.b.f;
import com.baidu.spswitch.emotion.c;
/* loaded from: classes13.dex */
public class CircleIndicator extends View {
    private int bab;
    private int bac;
    private int bad;
    private int bae;
    private int baf;
    private int bag;
    private final ViewPager.OnPageChangeListener bah;
    private int mCurrentPos;
    private int mHeight;
    private int mRadius;
    private Paint mTabPaint;
    private ViewPager mViewPager;
    private int mWidth;
    private int nd;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nd = 1;
        this.bae = 0;
        this.bah = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.f(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.mCurrentPos = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.be(CircleIndicator.this.getContext().getApplicationContext()).Gr();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.Gv().isNightMode()) {
            this.baf = -13421773;
            this.bag = -11184811;
            return;
        }
        this.baf = -2565928;
        this.bag = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.bab = (int) f.g(getContext(), 10.0f);
        this.bad = (this.mWidth - (this.bab * (this.nd - 1))) / 2;
        this.mRadius = this.bab / 5;
        this.bac = this.bab;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.bag);
        int i = (this.bad + this.bae) - (this.bab / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.bac + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.baf);
        for (int i = 0; i < this.nd; i++) {
            canvas.drawCircle(this.bad + (this.bab * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void f(int i, float f) {
        this.bae = (int) (this.bab * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            Gt();
            this.mViewPager.removeOnPageChangeListener(this.bah);
            this.mViewPager.addOnPageChangeListener(this.bah);
            this.mCurrentPos = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void Gt() {
        this.nd = this.mViewPager.getAdapter().getCount();
        if (this.nd > 0) {
            this.bab = (int) f.g(getContext(), 10.0f);
            this.bad = (this.mWidth - (this.bab * (this.nd - 1))) / 2;
            this.mRadius = this.bab / 5;
            invalidate();
        }
    }
}
