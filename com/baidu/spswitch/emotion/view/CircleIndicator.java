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
    private int bQP;
    private int bQQ;
    private int bQR;
    private int bQS;
    private int bQT;
    private int bQU;
    private int bQV;
    private final ViewPager.OnPageChangeListener bQW;
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
        this.bQT = 0;
        this.bQW = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.bQP = i2;
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
            this.bQU = -13421773;
            this.bQV = -11184811;
            return;
        }
        this.bQU = -2565928;
        this.bQV = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.bQQ = (int) d.g(getContext(), 10.0f);
        this.bQS = (this.mWidth - (this.bQQ * (this.Hx - 1))) / 2;
        this.mRadius = this.bQQ / 5;
        this.bQR = this.bQQ;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.bQV);
        int i = (this.bQS + this.bQT) - (this.bQQ / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.bQR + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.bQU);
        for (int i = 0; i < this.Hx; i++) {
            canvas.drawCircle(this.bQS + (this.bQQ * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.bQT = (int) (this.bQQ * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            XI();
            this.mViewPager.removeOnPageChangeListener(this.bQW);
            this.mViewPager.addOnPageChangeListener(this.bQW);
            this.bQP = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void XI() {
        this.Hx = this.mViewPager.getAdapter().getCount();
        if (this.Hx > 0) {
            this.bQQ = (int) d.g(getContext(), 10.0f);
            this.bQS = (this.mWidth - (this.bQQ * (this.Hx - 1))) / 2;
            this.mRadius = this.bQQ / 5;
            invalidate();
        }
    }
}
