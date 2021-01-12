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
    private int Io;
    private ViewPager Zi;
    private int cyV;
    private int cyW;
    private int cyX;
    private int cyY;
    private int cyZ;
    private int cza;
    private int czb;
    private final ViewPager.OnPageChangeListener czc;
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
        this.Io = 1;
        this.cyZ = 0;
        this.czc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.spswitch.emotion.view.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f > 0.0f) {
                    CircleIndicator.this.d(i2, f);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator.this.cyV = i2;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                c.bU(CircleIndicator.this.getContext().getApplicationContext()).afl();
            }
        };
        init();
    }

    private void init() {
        this.mTabPaint = new Paint();
        this.mTabPaint.setAntiAlias(true);
        if (a.afp().isNightMode()) {
            this.cza = -13421773;
            this.czb = -11184811;
            return;
        }
        this.cza = -2565928;
        this.czb = -6579301;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.mWidth = i;
        this.cyW = (int) d.g(getContext(), 10.0f);
        this.cyY = (this.mWidth - (this.cyW * (this.Io - 1))) / 2;
        this.mRadius = this.cyW / 5;
        this.cyX = this.cyW;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        n(canvas);
        m(canvas);
    }

    private void m(Canvas canvas) {
        this.mTabPaint.setColor(this.czb);
        int i = (this.cyY + this.cyZ) - (this.cyW / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.cyX + i, (this.mRadius * 2) + 0), 10.0f, 10.0f, this.mTabPaint);
    }

    private void n(Canvas canvas) {
        this.mTabPaint.setColor(this.cza);
        for (int i = 0; i < this.Io; i++) {
            canvas.drawCircle(this.cyY + (this.cyW * i), this.mRadius, this.mRadius, this.mTabPaint);
        }
    }

    public void d(int i, float f) {
        this.cyZ = (int) (this.cyW * (i + f));
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.Zi = viewPager;
        if (this.Zi != null && this.Zi.getAdapter() != null) {
            afn();
            this.Zi.removeOnPageChangeListener(this.czc);
            this.Zi.addOnPageChangeListener(this.czc);
            this.cyV = this.Zi.getCurrentItem();
            invalidate();
        }
    }

    private void afn() {
        this.Io = this.Zi.getAdapter().getCount();
        if (this.Io > 0) {
            this.cyW = (int) d.g(getContext(), 10.0f);
            this.cyY = (this.mWidth - (this.cyW * (this.Io - 1))) / 2;
            this.mRadius = this.cyW / 5;
            invalidate();
        }
    }
}
