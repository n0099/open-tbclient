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
/* loaded from: classes19.dex */
public class CircleIndicator extends View {
    private int HW;
    private int ctE;
    private int ctF;
    private int ctG;
    private int ctH;
    private int ctI;
    private int ctJ;
    private int ctK;
    private final ViewPager.OnPageChangeListener ctL;
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
        this.ctI = 0;
        this.ctL = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.ctE = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.bg(CircleIndicator.this.getContext().getApplicationContext()).afv();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.afz().isNightMode()) {
            this.ctJ = -13421773;
            this.ctK = -11184811;
            return;
        }
        this.ctJ = -2565928;
        this.ctK = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.ctF = (int) d.g(getContext(), 10.0f);
        this.ctH = (this.mWidth - (this.ctF * (this.HW - 1))) / 2;
        this.mRadius = this.ctF / 5;
        this.ctG = this.ctF;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.ctK);
        int i = (this.ctH + this.ctI) - (this.ctF / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.ctG + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.ctJ);
        for (int i = 0; i < this.HW; i++) {
            canvas.drawCircle(this.ctH + (this.ctF * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.ctI = (int) (this.ctF * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            afx();
            this.mViewPager.removeOnPageChangeListener(this.ctL);
            this.mViewPager.addOnPageChangeListener(this.ctL);
            this.ctE = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void afx() {
        this.HW = this.mViewPager.getAdapter().getCount();
        if (this.HW > 0) {
            this.ctF = (int) d.g(getContext(), 10.0f);
            this.ctH = (this.mWidth - (this.ctF * (this.HW - 1))) / 2;
            this.mRadius = this.ctF / 5;
            invalidate();
        }
    }
}
