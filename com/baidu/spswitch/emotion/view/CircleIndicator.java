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
    private int IT;
    private int cyO;
    private int cyP;
    private int cyQ;
    private int cyR;
    private int cyS;
    private int cyT;
    private int cyU;
    private final ViewPager.OnPageChangeListener cyV;
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
        this.IT = 1;
        this.cyS = 0;
        this.cyV = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.cyO = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.bM(CircleIndicator.this.getContext().getApplicationContext()).ahV();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.ahZ().isNightMode()) {
            this.cyT = -13421773;
            this.cyU = -11184811;
            return;
        }
        this.cyT = -2565928;
        this.cyU = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.cyP = (int) d.g(getContext(), 10.0f);
        this.cyR = (this.mWidth - (this.cyP * (this.IT - 1))) / 2;
        this.mRadius = this.cyP / 5;
        this.cyQ = this.cyP;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.cyU);
        int i = (this.cyR + this.cyS) - (this.cyP / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.cyQ + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.cyT);
        for (int i = 0; i < this.IT; i++) {
            canvas.drawCircle(this.cyR + (this.cyP * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.cyS = (int) (this.cyP * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            ahX();
            this.mViewPager.removeOnPageChangeListener(this.cyV);
            this.mViewPager.addOnPageChangeListener(this.cyV);
            this.cyO = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void ahX() {
        this.IT = this.mViewPager.getAdapter().getCount();
        if (this.IT > 0) {
            this.cyP = (int) d.g(getContext(), 10.0f);
            this.cyR = (this.mWidth - (this.cyP * (this.IT - 1))) / 2;
            this.mRadius = this.cyP / 5;
            invalidate();
        }
    }
}
