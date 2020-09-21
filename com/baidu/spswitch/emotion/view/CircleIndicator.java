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
/* loaded from: classes24.dex */
public class CircleIndicator extends View {
    private int HF;
    private int bST;
    private int bSU;
    private int bSV;
    private int bSW;
    private int bSX;
    private int bSY;
    private int bSZ;
    private final ViewPager.OnPageChangeListener bTa;
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
        this.HF = 1;
        this.bSX = 0;
        this.bTa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.bST = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.ba(CircleIndicator.this.getContext().getApplicationContext()).Yp();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.Yt().isNightMode()) {
            this.bSY = -13421773;
            this.bSZ = -11184811;
            return;
        }
        this.bSY = -2565928;
        this.bSZ = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.bSU = (int) d.g(getContext(), 10.0f);
        this.bSW = (this.mWidth - (this.bSU * (this.HF - 1))) / 2;
        this.mRadius = this.bSU / 5;
        this.bSV = this.bSU;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.bSZ);
        int i = (this.bSW + this.bSX) - (this.bSU / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.bSV + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.bSY);
        for (int i = 0; i < this.HF; i++) {
            canvas.drawCircle(this.bSW + (this.bSU * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.bSX = (int) (this.bSU * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            Yr();
            this.mViewPager.removeOnPageChangeListener(this.bTa);
            this.mViewPager.addOnPageChangeListener(this.bTa);
            this.bST = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void Yr() {
        this.HF = this.mViewPager.getAdapter().getCount();
        if (this.HF > 0) {
            this.bSU = (int) d.g(getContext(), 10.0f);
            this.bSW = (this.mWidth - (this.bSU * (this.HF - 1))) / 2;
            this.mRadius = this.bSU / 5;
            invalidate();
        }
    }
}
