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
    private int Gp;
    private int bGj;
    private int bGk;
    private int bGl;
    private int bGm;
    private int bGn;
    private int bGo;
    private int bGp;
    private final ViewPager.OnPageChangeListener bGq;
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
        this.Gp = 1;
        this.bGn = 0;
        this.bGq = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.bGj = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.aU(CircleIndicator.this.getContext().getApplicationContext()).Qq();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.Qu().isNightMode()) {
            this.bGo = -13421773;
            this.bGp = -11184811;
            return;
        }
        this.bGo = -2565928;
        this.bGp = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.bGk = (int) d.g(getContext(), 10.0f);
        this.bGm = (this.mWidth - (this.bGk * (this.Gp - 1))) / 2;
        this.mRadius = this.bGk / 5;
        this.bGl = this.bGk;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.bGp);
        int i = (this.bGm + this.bGn) - (this.bGk / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.bGl + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.bGo);
        for (int i = 0; i < this.Gp; i++) {
            canvas.drawCircle(this.bGm + (this.bGk * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.bGn = (int) (this.bGk * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            Qs();
            this.mViewPager.removeOnPageChangeListener(this.bGq);
            this.mViewPager.addOnPageChangeListener(this.bGq);
            this.bGj = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void Qs() {
        this.Gp = this.mViewPager.getAdapter().getCount();
        if (this.Gp > 0) {
            this.bGk = (int) d.g(getContext(), 10.0f);
            this.bGm = (this.mWidth - (this.bGk * (this.Gp - 1))) / 2;
            this.mRadius = this.bGk / 5;
            invalidate();
        }
    }
}
