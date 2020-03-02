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
    private int aZN;
    private int aZO;
    private int aZP;
    private int aZQ;
    private int aZR;
    private int aZS;
    private final ViewPager.OnPageChangeListener aZT;
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
        this.aZQ = 0;
        this.aZT = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
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
            this.aZR = -13421773;
            this.aZS = -11184811;
            return;
        }
        this.aZR = -2565928;
        this.aZS = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.aZN = (int) f.g(getContext(), 10.0f);
        this.aZP = (this.mWidth - (this.aZN * (this.ne - 1))) / 2;
        this.mRadius = this.aZN / 5;
        this.aZO = this.aZN;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.aZS);
        int i = (this.aZP + this.aZQ) - (this.aZN / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.aZO + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.aZR);
        for (int i = 0; i < this.ne; i++) {
            canvas.drawCircle(this.aZP + (this.aZN * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void f(int i, float f) {
        this.aZQ = (int) (this.aZN * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            Go();
            this.mViewPager.removeOnPageChangeListener(this.aZT);
            this.mViewPager.addOnPageChangeListener(this.aZT);
            this.mCurrentPos = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void Go() {
        this.ne = this.mViewPager.getAdapter().getCount();
        if (this.ne > 0) {
            this.aZN = (int) f.g(getContext(), 10.0f);
            this.aZP = (this.mWidth - (this.aZN * (this.ne - 1))) / 2;
            this.mRadius = this.aZN / 5;
            invalidate();
        }
    }
}
