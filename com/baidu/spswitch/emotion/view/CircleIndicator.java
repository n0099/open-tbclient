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
    private int In;
    private ViewPager Ze;
    private int cBr;
    private int cBs;
    private int cBt;
    private int cBu;
    private int cBv;
    private int cBw;
    private int cBx;
    private final ViewPager.OnPageChangeListener cBy;
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
        this.In = 1;
        this.cBv = 0;
        this.cBy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.cBr = i2;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.bT(CircleIndicator.this.getContext().getApplicationContext()).afK();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.afO().isNightMode()) {
            this.cBw = -13421773;
            this.cBx = -11184811;
            return;
        }
        this.cBw = -2565928;
        this.cBx = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.cBs = (int) d.g(getContext(), 10.0f);
        this.cBu = (this.mWidth - (this.cBs * (this.In - 1))) / 2;
        this.mRadius = this.cBs / 5;
        this.cBt = this.cBs;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        n(canvas);
        m(canvas);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.cBx);
        int i = (this.cBu + this.cBv) - (this.cBs / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.cBt + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void n(Canvas canvas) {
        this.mTabPaint.setColor(this.cBw);
        for (int i = 0; i < this.In; i++) {
            canvas.drawCircle(this.cBu + (this.cBs * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.cBv = (int) (this.cBs * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.Ze = viewPager;
        if (this.Ze != null && this.Ze.getAdapter() != null) {
            afM();
            this.Ze.removeOnPageChangeListener(this.cBy);
            this.Ze.addOnPageChangeListener(this.cBy);
            this.cBr = this.Ze.getCurrentItem();
            invalidate();
        }
    }

    private void afM() {
        this.In = this.Ze.getAdapter().getCount();
        if (this.In > 0) {
            this.cBs = (int) d.g(getContext(), 10.0f);
            this.cBu = (this.mWidth - (this.cBs * (this.In - 1))) / 2;
            this.mRadius = this.cBs / 5;
            invalidate();
        }
    }
}
