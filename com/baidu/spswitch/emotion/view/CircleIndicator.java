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
/* loaded from: classes6.dex */
public class CircleIndicator extends View {
    private int HW;
    private int crS;
    private int crT;
    private int crU;
    private int crV;
    private int crW;
    private int crX;
    private int crY;
    private final ViewPager.OnPageChangeListener crZ;
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
        this.HW = 1;
        this.crW = 0;
        this.crZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.crS = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.bg(CircleIndicator.this.getContext().getApplicationContext()).aeN();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.aeR().isNightMode()) {
            this.crX = -13421773;
            this.crY = -11184811;
            return;
        }
        this.crX = -2565928;
        this.crY = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.crT = (int) d.g(getContext(), 10.0f);
        this.crV = (this.mWidth - (this.crT * (this.HW - 1))) / 2;
        this.mRadius = this.crT / 5;
        this.crU = this.crT;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.crY);
        int i = (this.crV + this.crW) - (this.crT / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.crU + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.crX);
        for (int i = 0; i < this.HW; i++) {
            canvas.drawCircle(this.crV + (this.crT * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.crW = (int) (this.crT * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            aeP();
            this.mViewPager.removeOnPageChangeListener(this.crZ);
            this.mViewPager.addOnPageChangeListener(this.crZ);
            this.crS = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void aeP() {
        this.HW = this.mViewPager.getAdapter().getCount();
        if (this.HW > 0) {
            this.crT = (int) d.g(getContext(), 10.0f);
            this.crV = (this.mWidth - (this.crT * (this.HW - 1))) / 2;
            this.mRadius = this.crT / 5;
            invalidate();
        }
    }
}
