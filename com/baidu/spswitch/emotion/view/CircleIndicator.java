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
/* loaded from: classes9.dex */
public class CircleIndicator extends View {
    private int Hx;
    private int bQT;
    private int bQU;
    private int bQV;
    private int bQW;
    private int bQX;
    private int bQY;
    private int bQZ;
    private final ViewPager.OnPageChangeListener bRa;
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
        this.Hx = 1;
        this.bQX = 0;
        this.bRa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.bQT = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.bb(CircleIndicator.this.getContext().getApplicationContext()).XG();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.XK().isNightMode()) {
            this.bQY = -13421773;
            this.bQZ = -11184811;
            return;
        }
        this.bQY = -2565928;
        this.bQZ = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.bQU = (int) d.g(getContext(), 10.0f);
        this.bQW = (this.mWidth - (this.bQU * (this.Hx - 1))) / 2;
        this.mRadius = this.bQU / 5;
        this.bQV = this.bQU;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.bQZ);
        int i = (this.bQW + this.bQX) - (this.bQU / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.bQV + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.bQY);
        for (int i = 0; i < this.Hx; i++) {
            canvas.drawCircle(this.bQW + (this.bQU * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.bQX = (int) (this.bQU * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            XI();
            this.mViewPager.removeOnPageChangeListener(this.bRa);
            this.mViewPager.addOnPageChangeListener(this.bRa);
            this.bQT = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void XI() {
        this.Hx = this.mViewPager.getAdapter().getCount();
        if (this.Hx > 0) {
            this.bQU = (int) d.g(getContext(), 10.0f);
            this.bQW = (this.mWidth - (this.bQU * (this.Hx - 1))) / 2;
            this.mRadius = this.bQU / 5;
            invalidate();
        }
    }
}
