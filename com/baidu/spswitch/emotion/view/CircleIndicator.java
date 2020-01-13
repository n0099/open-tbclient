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
/* loaded from: classes12.dex */
public class CircleIndicator extends View {
    private int aVA;
    private int aVB;
    private int aVC;
    private int aVD;
    private int aVE;
    private int aVF;
    private final ViewPager.OnPageChangeListener aVG;
    private int mCurrentPos;
    private int mHeight;
    private int mRadius;
    private Paint mTabPaint;
    private ViewPager mViewPager;
    private int mWidth;
    private int nb;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nb = 1;
        this.aVD = 0;
        this.aVG = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
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
                c.bb(CircleIndicator.this.getContext().getApplicationContext()).DV();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.DZ().isNightMode()) {
            this.aVE = -13421773;
            this.aVF = -11184811;
            return;
        }
        this.aVE = -2565928;
        this.aVF = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.aVA = (int) f.g(getContext(), 10.0f);
        this.aVC = (this.mWidth - (this.aVA * (this.nb - 1))) / 2;
        this.mRadius = this.aVA / 5;
        this.aVB = this.aVA;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.aVF);
        int i = (this.aVC + this.aVD) - (this.aVA / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.aVB + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.aVE);
        for (int i = 0; i < this.nb; i++) {
            canvas.drawCircle(this.aVC + (this.aVA * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void f(int i, float f) {
        this.aVD = (int) (this.aVA * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            DX();
            this.mViewPager.removeOnPageChangeListener(this.aVG);
            this.mViewPager.addOnPageChangeListener(this.aVG);
            this.mCurrentPos = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void DX() {
        this.nb = this.mViewPager.getAdapter().getCount();
        if (this.nb > 0) {
            this.aVA = (int) f.g(getContext(), 10.0f);
            this.aVC = (this.mWidth - (this.aVA * (this.nb - 1))) / 2;
            this.mRadius = this.aVA / 5;
            invalidate();
        }
    }
}
