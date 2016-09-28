package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int Ze;
    private int Zf;
    private a Zg;
    private c Zh;
    private final Rect Zi;
    private final Rect Zj;
    private final Rect Zk;
    private int Zl;
    private int Zm;
    private int Zn;
    private int Zo;
    private int Zp;
    private int Zq;
    private int Zr;
    private boolean Zs;
    private boolean Zt;
    private boolean Zu;
    private int Zv;
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
        this.Zf = -1;
        this.Zi = new Rect();
        this.Zj = new Rect();
        this.Zk = new Rect();
        this.mPaint = new Paint();
        this.Zo = 0;
        this.Zs = true;
        this.Zt = false;
        this.Zu = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zf = -1;
        this.Zi = new Rect();
        this.Zj = new Rect();
        this.Zk = new Rect();
        this.mPaint = new Paint();
        this.Zo = 0;
        this.Zs = true;
        this.Zt = false;
        this.Zu = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.Zl = getResources().getDimensionPixelSize(r.e.ds1);
        this.Zm = k.dip2px(getContext(), 1.0f);
        this.Zn = k.dip2px(getContext(), 3.0f);
        this.Zv = getResources().getDimensionPixelSize(r.e.ds10);
        setWillNotDraw(false);
        this.Ze = r.d.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.Zf != i) {
                if (this.Zf != -1) {
                    getChildAt(this.Zf).setSelected(false);
                }
                this.Zf = i;
                getChildAt(this.Zf).setSelected(true);
                if (z) {
                    b(this.Zf, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.Zh != null) {
            this.Zh.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        B(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        B(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void B(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.Zu) {
            view.setPadding(0, 0, 0, this.Zv);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.Zf = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.Zr = this.mWidth / this.mChildCount;
            if (this.Zf != -1) {
                b(this.Zf, 0.0f);
            }
            int i5 = this.mHeight - this.Zl;
            this.Zj.set(0, i5, this.mWidth, this.Zl + i5);
            this.Zk.set(0, 0, this.mWidth, this.Zm);
        }
    }

    public void b(int i, float f) {
        this.left = this.Zr * i;
        this.left += (int) (this.Zr * f);
        int i2 = this.mHeight - this.Zn;
        if (this.Zo != 0) {
            this.Zi.set((this.left + (this.Zr / 2)) - (this.Zo / 2), i2, this.left + (this.Zr / 2) + (this.Zo / 2), this.mHeight);
        } else {
            this.Zi.set(this.left, i2, this.left + this.Zr, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.Ze = i;
    }

    public void onChangeSkinType(int i) {
        if (this.Ze != 0) {
            av.l(this, this.Ze);
        }
        this.Zq = av.getColor(r.d.cp_link_tip_a);
        this.Zp = av.getColor(r.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dl(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.Zp);
        canvas.drawRect(this.Zj, this.mPaint);
        if (this.Zt) {
            canvas.drawRect(this.Zk, this.mPaint);
        }
        if (this.Zs) {
            this.mPaint.setColor(this.Zq);
            canvas.drawRect(this.Zi, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.Zs = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.Zt = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.Zg = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.Zh = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int Zw;

        private b(int i) {
            this.Zw = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.Zg.f(this.Zw, true);
        }
    }

    public void az(boolean z) {
        this.Zu = z;
    }

    public void setDviderRectWidth(int i) {
        this.Zo = i;
    }
}
