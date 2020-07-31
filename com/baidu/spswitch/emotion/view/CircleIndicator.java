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
/* loaded from: classes3.dex */
public class CircleIndicator extends View {
    private int GR;
    private final ViewPager.OnPageChangeListener bLA;
    private int bLt;
    private int bLu;
    private int bLv;
    private int bLw;
    private int bLx;
    private int bLy;
    private int bLz;
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
        this.bLx = 0;
        this.bLA = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.bLt = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.aW(CircleIndicator.this.getContext().getApplicationContext()).RL();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.RP().isNightMode()) {
            this.bLy = -13421773;
            this.bLz = -11184811;
            return;
        }
        this.bLy = -2565928;
        this.bLz = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.bLu = (int) d.g(getContext(), 10.0f);
        this.bLw = (this.mWidth - (this.bLu * (this.GR - 1))) / 2;
        this.mRadius = this.bLu / 5;
        this.bLv = this.bLu;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.bLz);
        int i = (this.bLw + this.bLx) - (this.bLu / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.bLv + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.bLy);
        for (int i = 0; i < this.GR; i++) {
            canvas.drawCircle(this.bLw + (this.bLu * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.bLx = (int) (this.bLu * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            RN();
            this.mViewPager.removeOnPageChangeListener(this.bLA);
            this.mViewPager.addOnPageChangeListener(this.bLA);
            this.bLt = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void RN() {
        this.GR = this.mViewPager.getAdapter().getCount();
        if (this.GR > 0) {
            this.bLu = (int) d.g(getContext(), 10.0f);
            this.bLw = (this.mWidth - (this.bLu * (this.GR - 1))) / 2;
            this.mRadius = this.bLu / 5;
            invalidate();
        }
    }
}
