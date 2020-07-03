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
    private int GR;
    private int bKX;
    private int bKY;
    private int bKZ;
    private int bLa;
    private int bLb;
    private int bLc;
    private int bLd;
    private final ViewPager.OnPageChangeListener bLe;
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
        this.GR = 1;
        this.bLb = 0;
        this.bLe = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.bKX = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.aV(CircleIndicator.this.getContext().getApplicationContext()).Rw();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.RA().isNightMode()) {
            this.bLc = -13421773;
            this.bLd = -11184811;
            return;
        }
        this.bLc = -2565928;
        this.bLd = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.bKY = (int) d.g(getContext(), 10.0f);
        this.bLa = (this.mWidth - (this.bKY * (this.GR - 1))) / 2;
        this.mRadius = this.bKY / 5;
        this.bKZ = this.bKY;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.bLd);
        int i = (this.bLa + this.bLb) - (this.bKY / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.bKZ + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.bLc);
        for (int i = 0; i < this.GR; i++) {
            canvas.drawCircle(this.bLa + (this.bKY * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.bLb = (int) (this.bKY * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            Ry();
            this.mViewPager.removeOnPageChangeListener(this.bLe);
            this.mViewPager.addOnPageChangeListener(this.bLe);
            this.bKX = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void Ry() {
        this.GR = this.mViewPager.getAdapter().getCount();
        if (this.GR > 0) {
            this.bKY = (int) d.g(getContext(), 10.0f);
            this.bLa = (this.mWidth - (this.bKY * (this.GR - 1))) / 2;
            this.mRadius = this.bKY / 5;
            invalidate();
        }
    }
}
