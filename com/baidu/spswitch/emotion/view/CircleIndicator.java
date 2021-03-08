package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.spswitch.b.a;
import com.baidu.spswitch.b.d;
import com.baidu.spswitch.emotion.c;
/* loaded from: classes3.dex */
public class CircleIndicator extends View {
    private int JK;
    private ViewPager aaw;
    private int cCR;
    private int cCS;
    private int cCT;
    private int cCU;
    private int cCV;
    private int cCW;
    private int cCX;
    private final ViewPager.OnPageChangeListener cCY;
    private int mHeight;
    private int mRadius;
    private Paint mTabPaint;
    private int mWidth;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.JK = 1;
        this.cCV = 0;
        this.cCY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.cCR = i2;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.bS(CircleIndicator.this.getContext().getApplicationContext()).afN();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.afR().isNightMode()) {
            this.cCW = -13421773;
            this.cCX = -11184811;
            return;
        }
        this.cCW = -2565928;
        this.cCX = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.cCS = (int) d.g(getContext(), 10.0f);
        this.cCU = (this.mWidth - (this.cCS * (this.JK - 1))) / 2;
        this.mRadius = this.cCS / 5;
        this.cCT = this.cCS;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        n(canvas);
        m(canvas);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.cCX);
        int i = (this.cCU + this.cCV) - (this.cCS / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.cCT + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void n(Canvas canvas) {
        this.mTabPaint.setColor(this.cCW);
        for (int i = 0; i < this.JK; i++) {
            canvas.drawCircle(this.cCU + (this.cCS * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.cCV = (int) (this.cCS * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.aaw = viewPager;
        if (this.aaw != null && this.aaw.getAdapter() != null) {
            afP();
            this.aaw.removeOnPageChangeListener(this.cCY);
            this.aaw.addOnPageChangeListener(this.cCY);
            this.cCR = this.aaw.getCurrentItem();
            invalidate();
        }
    }

    private void afP() {
        this.JK = this.aaw.getAdapter().getCount();
        if (this.JK > 0) {
            this.cCS = (int) d.g(getContext(), 10.0f);
            this.cCU = (this.mWidth - (this.cCS * (this.JK - 1))) / 2;
            this.mRadius = this.cCS / 5;
            invalidate();
        }
    }
}
