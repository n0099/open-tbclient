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
    private int cfh;
    private int cfi;
    private int cfj;
    private int cfk;
    private int cfl;
    private int cfm;
    private int cfn;
    private final ViewPager.OnPageChangeListener cfo;
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
        this.cfl = 0;
        this.cfo = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.cfh = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.bg(CircleIndicator.this.getContext().getApplicationContext()).abb();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.abf().isNightMode()) {
            this.cfm = -13421773;
            this.cfn = -11184811;
            return;
        }
        this.cfm = -2565928;
        this.cfn = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.cfi = (int) d.g(getContext(), 10.0f);
        this.cfk = (this.mWidth - (this.cfi * (this.HW - 1))) / 2;
        this.mRadius = this.cfi / 5;
        this.cfj = this.cfi;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.cfn);
        int i = (this.cfk + this.cfl) - (this.cfi / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.cfj + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.cfm);
        for (int i = 0; i < this.HW; i++) {
            canvas.drawCircle(this.cfk + (this.cfi * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.cfl = (int) (this.cfi * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            abd();
            this.mViewPager.removeOnPageChangeListener(this.cfo);
            this.mViewPager.addOnPageChangeListener(this.cfo);
            this.cfh = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void abd() {
        this.HW = this.mViewPager.getAdapter().getCount();
        if (this.HW > 0) {
            this.cfi = (int) d.g(getContext(), 10.0f);
            this.cfk = (this.mWidth - (this.cfi * (this.HW - 1))) / 2;
            this.mRadius = this.cfi / 5;
            invalidate();
        }
    }
}
