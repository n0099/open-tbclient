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
    private int aZO;
    private int aZP;
    private int aZQ;
    private int aZR;
    private int aZS;
    private int aZT;
    private final ViewPager.OnPageChangeListener aZU;
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
        this.aZR = 0;
        this.aZU = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
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
                c.bf(CircleIndicator.this.getContext().getApplicationContext()).Gm();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.Gq().isNightMode()) {
            this.aZS = -13421773;
            this.aZT = -11184811;
            return;
        }
        this.aZS = -2565928;
        this.aZT = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.aZO = (int) f.g(getContext(), 10.0f);
        this.aZQ = (this.mWidth - (this.aZO * (this.ne - 1))) / 2;
        this.mRadius = this.aZO / 5;
        this.aZP = this.aZO;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.aZT);
        int i = (this.aZQ + this.aZR) - (this.aZO / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.aZP + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.aZS);
        for (int i = 0; i < this.ne; i++) {
            canvas.drawCircle(this.aZQ + (this.aZO * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void f(int i, float f) {
        this.aZR = (int) (this.aZO * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            Go();
            this.mViewPager.removeOnPageChangeListener(this.aZU);
            this.mViewPager.addOnPageChangeListener(this.aZU);
            this.mCurrentPos = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void Go() {
        this.ne = this.mViewPager.getAdapter().getCount();
        if (this.ne > 0) {
            this.aZO = (int) f.g(getContext(), 10.0f);
            this.aZQ = (this.mWidth - (this.aZO * (this.ne - 1))) / 2;
            this.mRadius = this.aZO / 5;
            invalidate();
        }
    }
}
