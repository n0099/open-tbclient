package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private boolean YA;
    private int YB;
    private int Yk;
    private int Yl;
    private a Ym;
    private c Yn;
    private final Rect Yo;
    private final Rect Yp;
    private final Rect Yq;
    private int Yr;
    private int Ys;
    private int Yt;
    private int Yu;
    private int Yv;
    private int Yw;
    private int Yx;
    private boolean Yy;
    private boolean Yz;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.Yl = -1;
        this.Yo = new Rect();
        this.Yp = new Rect();
        this.Yq = new Rect();
        this.mPaint = new Paint();
        this.Yu = 0;
        this.Yy = true;
        this.Yz = false;
        this.YA = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yl = -1;
        this.Yo = new Rect();
        this.Yp = new Rect();
        this.Yq = new Rect();
        this.mPaint = new Paint();
        this.Yu = 0;
        this.Yy = true;
        this.Yz = false;
        this.YA = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.Yr = getResources().getDimensionPixelSize(r.f.ds1);
        this.Ys = k.dip2px(getContext(), 1.0f);
        this.Yt = k.dip2px(getContext(), 3.0f);
        this.YB = getResources().getDimensionPixelSize(r.f.ds10);
        setWillNotDraw(false);
        this.Yk = r.e.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.Yl != i) {
                if (this.Yl != -1) {
                    getChildAt(this.Yl).setSelected(false);
                }
                this.Yl = i;
                getChildAt(this.Yl).setSelected(true);
                if (z) {
                    b(this.Yl, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.Yn != null) {
            this.Yn.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        z(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        z(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void z(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.YA) {
            view.setPadding(0, 0, 0, this.YB);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.Yl = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.Yx = this.mWidth / this.mChildCount;
            if (this.Yl != -1) {
                b(this.Yl, 0.0f);
            }
            int i5 = this.mHeight - this.Yr;
            this.Yp.set(0, i5, this.mWidth, this.Yr + i5);
            this.Yq.set(0, 0, this.mWidth, this.Ys);
        }
    }

    public void b(int i, float f) {
        this.left = this.Yx * i;
        this.left += (int) (this.Yx * f);
        int i2 = this.mHeight - this.Yt;
        if (this.Yu != 0) {
            this.Yo.set((this.left + (this.Yx / 2)) - (this.Yu / 2), i2, this.left + (this.Yx / 2) + (this.Yu / 2), this.mHeight);
        } else {
            this.Yo.set(this.left, i2, this.left + this.Yx, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.Yk = i;
    }

    public void onChangeSkinType(int i) {
        if (this.Yk != 0) {
            ap.k(this, this.Yk);
        }
        this.Yw = ap.getColor(r.e.cp_link_tip_a);
        this.Yv = ap.getColor(r.e.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dp(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.Yv);
        canvas.drawRect(this.Yp, this.mPaint);
        if (this.Yz) {
            canvas.drawRect(this.Yq, this.mPaint);
        }
        if (this.Yy) {
            this.mPaint.setColor(this.Yw);
            canvas.drawRect(this.Yo, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.Yy = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.Yz = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.Ym = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.Yn = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int YC;

        private b(int i) {
            this.YC = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.Ym.f(this.YC, true);
        }
    }

    public void aD(boolean z) {
        this.YA = z;
    }

    public void setDviderRectWidth(int i) {
        this.Yu = i;
    }
}
