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
import com.baidu.spswitch.b.d;
import com.baidu.spswitch.emotion.c;
/* loaded from: classes13.dex */
public class CircleIndicator extends View {
    private int Go;
    private int byG;
    private int byH;
    private int byI;
    private int byJ;
    private int byK;
    private int byL;
    private int byM;
    private final ViewPager.OnPageChangeListener byN;
    private int mHeight;
    private int mRadius;
    private Paint mTabPaint;
    private ViewPager mViewPager;
    private int mWidth;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Go = 1;
        this.byK = 0;
        this.byN = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.byG = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.aK(CircleIndicator.this.getContext().getApplicationContext()).Od();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.Oh().isNightMode()) {
            this.byL = -13421773;
            this.byM = -11184811;
            return;
        }
        this.byL = -2565928;
        this.byM = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.byH = (int) d.g(getContext(), 10.0f);
        this.byJ = (this.mWidth - (this.byH * (this.Go - 1))) / 2;
        this.mRadius = this.byH / 5;
        this.byI = this.byH;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.byM);
        int i = (this.byJ + this.byK) - (this.byH / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.byI + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.byL);
        for (int i = 0; i < this.Go; i++) {
            canvas.drawCircle(this.byJ + (this.byH * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.byK = (int) (this.byH * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            Of();
            this.mViewPager.removeOnPageChangeListener(this.byN);
            this.mViewPager.addOnPageChangeListener(this.byN);
            this.byG = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void Of() {
        this.Go = this.mViewPager.getAdapter().getCount();
        if (this.Go > 0) {
            this.byH = (int) d.g(getContext(), 10.0f);
            this.byJ = (this.mWidth - (this.byH * (this.Go - 1))) / 2;
            this.mRadius = this.byH / 5;
            invalidate();
        }
    }
}
