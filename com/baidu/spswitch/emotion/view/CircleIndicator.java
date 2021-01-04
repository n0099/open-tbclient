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
    private int Iq;
    private ViewPager Zk;
    private int cDH;
    private int cDI;
    private int cDJ;
    private int cDK;
    private int cDL;
    private int cDM;
    private int cDN;
    private final ViewPager.OnPageChangeListener cDO;
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
        this.Iq = 1;
        this.cDL = 0;
        this.cDO = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.cDH = i2;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.bV(CircleIndicator.this.getContext().getApplicationContext()).aje();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.aji().isNightMode()) {
            this.cDM = -13421773;
            this.cDN = -11184811;
            return;
        }
        this.cDM = -2565928;
        this.cDN = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.cDI = (int) d.g(getContext(), 10.0f);
        this.cDK = (this.mWidth - (this.cDI * (this.Iq - 1))) / 2;
        this.mRadius = this.cDI / 5;
        this.cDJ = this.cDI;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        n(canvas);
        m(canvas);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.cDN);
        int i = (this.cDK + this.cDL) - (this.cDI / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.cDJ + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void n(Canvas canvas) {
        this.mTabPaint.setColor(this.cDM);
        for (int i = 0; i < this.Iq; i++) {
            canvas.drawCircle(this.cDK + (this.cDI * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.cDL = (int) (this.cDI * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.Zk = viewPager;
        if (this.Zk != null && this.Zk.getAdapter() != null) {
            ajg();
            this.Zk.removeOnPageChangeListener(this.cDO);
            this.Zk.addOnPageChangeListener(this.cDO);
            this.cDH = this.Zk.getCurrentItem();
            invalidate();
        }
    }

    private void ajg() {
        this.Iq = this.Zk.getAdapter().getCount();
        if (this.Iq > 0) {
            this.cDI = (int) d.g(getContext(), 10.0f);
            this.cDK = (this.mWidth - (this.cDI * (this.Iq - 1))) / 2;
            this.mRadius = this.cDI / 5;
            invalidate();
        }
    }
}
