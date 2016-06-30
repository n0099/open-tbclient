package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.p;
/* loaded from: classes.dex */
public class CirclePageIndicator extends View implements PageIndicator {
    private ViewPager a;
    private ViewPager.OnPageChangeListener b;
    private int c;
    private float d;
    private boolean e;
    private boolean f;
    private int g;
    private float h;
    private int i;
    private final Paint j;
    private final Paint k;
    private final Paint l;

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new Paint(1);
        this.k = new Paint(1);
        this.l = new Paint(1);
        this.d = getResources().getDimension(p.k(context, "default_circle_indicator_radius"));
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setColor(Color.parseColor(c(context)));
        this.j.setStrokeWidth(getResources().getDimension(p.k(context, "default_circle_indicator_stroke_width")));
        this.k.setStyle(Paint.Style.FILL);
        this.k.setColor(Color.parseColor(b(context)));
        this.l.setStyle(Paint.Style.FILL);
        this.l.setColor(Color.parseColor(a(context)));
        this.e = true;
        this.f = false;
        setBackgroundColor(Color.parseColor(p.b(context)));
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.a == null) {
            return size;
        }
        int count = this.a.getAdapter().getCount();
        int paddingLeft = (int) (((count - 1) * this.d) + getPaddingLeft() + getPaddingRight() + (count * 2 * this.d) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private String a(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#FF888888" : "#FFFFFFFF";
    }

    private int b(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((2.0f * this.d) + getPaddingTop() + getPaddingBottom() + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    private String b(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#00000000" : "#00000000";
    }

    private String c(Context context) {
        return SocialShare.getInstance(context).getTheme() == SocialShare.Theme.LIGHT ? "#FF000000" : "#FFDDDDDD";
    }

    @Override // com.baidu.cloudsdk.social.share.uiwithlayout.PageIndicator
    public void notifyDataSetChanged() {
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int count;
        super.onDraw(canvas);
        if (this.a == null || (count = this.a.getAdapter().getCount()) == 0) {
            return;
        }
        if (this.c >= count) {
            setCurrentItem(count - 1);
            return;
        }
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        float f = this.d * 3.0f;
        float f2 = this.d + paddingTop;
        float f3 = paddingLeft + this.d;
        if (this.e) {
            f3 += (((width - paddingLeft) - paddingRight) / 2.0f) - ((count * f) / 2.0f);
        }
        float f4 = this.d;
        if (this.j.getStrokeWidth() > 0.0f) {
            f4 -= this.j.getStrokeWidth() / 2.0f;
        }
        for (int i = 0; i < count; i++) {
            float f5 = (i * f) + f3;
            if (this.k.getAlpha() > 0) {
                canvas.drawCircle(f5, f2, f4, this.k);
            }
            if (f4 != this.d) {
                canvas.drawCircle(f5, f2, this.d, this.j);
            }
        }
        float f6 = (this.f ? this.g : this.c) * f;
        if (!this.f) {
            f6 += this.h * f;
        }
        canvas.drawCircle(f3 + f6, f2, this.d, this.l);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(i), b(i2));
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        this.i = i;
        if (this.b != null) {
            this.b.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.c = i;
        this.h = f;
        invalidate();
        if (this.b != null) {
            this.b.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.f || this.i == 0) {
            this.c = i;
            this.g = i;
            invalidate();
        }
        if (this.b != null) {
            this.b.onPageSelected(i);
        }
    }

    @Override // com.baidu.cloudsdk.social.share.uiwithlayout.PageIndicator
    public void setCurrentItem(int i) {
        if (this.a == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.a.setCurrentItem(i);
        this.c = i;
        invalidate();
    }

    @Override // com.baidu.cloudsdk.social.share.uiwithlayout.PageIndicator
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.b = onPageChangeListener;
    }

    @Override // com.baidu.cloudsdk.social.share.uiwithlayout.PageIndicator
    public void setViewPager(ViewPager viewPager) {
        if (this.a == viewPager) {
            return;
        }
        if (this.a != null) {
            this.a.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.a = viewPager;
        this.a.setOnPageChangeListener(this);
        invalidate();
    }

    @Override // com.baidu.cloudsdk.social.share.uiwithlayout.PageIndicator
    public void setViewPager(ViewPager viewPager, int i) {
        setViewPager(viewPager);
        setCurrentItem(i);
    }
}
