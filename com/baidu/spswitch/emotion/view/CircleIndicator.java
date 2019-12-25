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
/* loaded from: classes11.dex */
public class CircleIndicator extends View {
    private int aUI;
    private int aUJ;
    private int aUK;
    private int aUL;
    private int aUM;
    private int aUN;
    private final ViewPager.OnPageChangeListener aUO;
    private int mCurrentPos;
    private int mHeight;
    private int mRadius;
    private Paint mTabPaint;
    private ViewPager mViewPager;
    private int mWidth;
    private int ne;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ne = 1;
        this.aUL = 0;
        this.aUO = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
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
                c.bb(CircleIndicator.this.getContext().getApplicationContext()).Dz();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.DD().isNightMode()) {
            this.aUM = -13421773;
            this.aUN = -11184811;
            return;
        }
        this.aUM = -2565928;
        this.aUN = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.aUI = (int) f.g(getContext(), 10.0f);
        this.aUK = (this.mWidth - (this.aUI * (this.ne - 1))) / 2;
        this.mRadius = this.aUI / 5;
        this.aUJ = this.aUI;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.aUN);
        int i = (this.aUK + this.aUL) - (this.aUI / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.aUJ + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.aUM);
        for (int i = 0; i < this.ne; i++) {
            canvas.drawCircle(this.aUK + (this.aUI * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void f(int i, float f) {
        this.aUL = (int) (this.aUI * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            DB();
            this.mViewPager.removeOnPageChangeListener(this.aUO);
            this.mViewPager.addOnPageChangeListener(this.aUO);
            this.mCurrentPos = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void DB() {
        this.ne = this.mViewPager.getAdapter().getCount();
        if (this.ne > 0) {
            this.aUI = (int) f.g(getContext(), 10.0f);
            this.aUK = (this.mWidth - (this.aUI * (this.ne - 1))) / 2;
            this.mRadius = this.aUI / 5;
            invalidate();
        }
    }
}
