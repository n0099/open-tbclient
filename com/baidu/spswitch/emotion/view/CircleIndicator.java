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
    private int Gl;
    private int byB;
    private int byC;
    private int byD;
    private int byE;
    private int byF;
    private int byG;
    private int byH;
    private final ViewPager.OnPageChangeListener byI;
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
        this.Gl = 1;
        this.byF = 0;
        this.byI = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.byB = i2;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.aW(CircleIndicator.this.getContext().getApplicationContext()).Oe();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.Oi().isNightMode()) {
            this.byG = -13421773;
            this.byH = -11184811;
            return;
        }
        this.byG = -2565928;
        this.byH = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.byC = (int) d.g(getContext(), 10.0f);
        this.byE = (this.mWidth - (this.byC * (this.Gl - 1))) / 2;
        this.mRadius = this.byC / 5;
        this.byD = this.byC;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
        l(canvas);
    }

    private void l(Canvas canvas) {
        this.mTabPaint.setColor(this.byH);
        int i = (this.byE + this.byF) - (this.byC / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.byD + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.byG);
        for (int i = 0; i < this.Gl; i++) {
            canvas.drawCircle(this.byE + (this.byC * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.byF = (int) (this.byC * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (this.mViewPager != null && this.mViewPager.getAdapter() != null) {
            Og();
            this.mViewPager.removeOnPageChangeListener(this.byI);
            this.mViewPager.addOnPageChangeListener(this.byI);
            this.byB = this.mViewPager.getCurrentItem();
            invalidate();
        }
    }

    private void Og() {
        this.Gl = this.mViewPager.getAdapter().getCount();
        if (this.Gl > 0) {
            this.byC = (int) d.g(getContext(), 10.0f);
            this.byE = (this.mWidth - (this.byC * (this.Gl - 1))) / 2;
            this.mRadius = this.byC / 5;
            invalidate();
        }
    }
}
