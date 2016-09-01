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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int YR;
    private int YS;
    private a YT;
    private c YU;
    private final Rect YV;
    private final Rect YW;
    private final Rect YX;
    private int YY;
    private int YZ;
    private int Za;
    private int Zb;
    private int Zc;
    private int Zd;
    private int Ze;
    private boolean Zf;
    private boolean Zg;
    private boolean Zh;
    private int Zi;
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
        this.YS = -1;
        this.YV = new Rect();
        this.YW = new Rect();
        this.YX = new Rect();
        this.mPaint = new Paint();
        this.Zb = 0;
        this.Zf = true;
        this.Zg = false;
        this.Zh = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YS = -1;
        this.YV = new Rect();
        this.YW = new Rect();
        this.YX = new Rect();
        this.mPaint = new Paint();
        this.Zb = 0;
        this.Zf = true;
        this.Zg = false;
        this.Zh = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.YY = getResources().getDimensionPixelSize(t.e.ds1);
        this.YZ = k.dip2px(getContext(), 1.0f);
        this.Za = k.dip2px(getContext(), 3.0f);
        this.Zi = getResources().getDimensionPixelSize(t.e.ds10);
        setWillNotDraw(false);
        this.YR = t.d.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.YS != i) {
                if (this.YS != -1) {
                    getChildAt(this.YS).setSelected(false);
                }
                this.YS = i;
                getChildAt(this.YS).setSelected(true);
                if (z) {
                    b(this.YS, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.YU != null) {
            this.YU.onSizeChanged(i, i2, i3, i4);
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
        if (this.Zh) {
            view.setPadding(0, 0, 0, this.Zi);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.YS = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.Ze = this.mWidth / this.mChildCount;
            if (this.YS != -1) {
                b(this.YS, 0.0f);
            }
            int i5 = this.mHeight - this.YY;
            this.YW.set(0, i5, this.mWidth, this.YY + i5);
            this.YX.set(0, 0, this.mWidth, this.YZ);
        }
    }

    public void b(int i, float f) {
        this.left = this.Ze * i;
        this.left += (int) (this.Ze * f);
        int i2 = this.mHeight - this.Za;
        if (this.Zb != 0) {
            this.YV.set((this.left + (this.Ze / 2)) - (this.Zb / 2), i2, this.left + (this.Ze / 2) + (this.Zb / 2), this.mHeight);
        } else {
            this.YV.set(this.left, i2, this.left + this.Ze, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.YR = i;
    }

    public void onChangeSkinType(int i) {
        if (this.YR != 0) {
            av.l(this, this.YR);
        }
        this.Zd = av.getColor(t.d.cp_link_tip_a);
        this.Zc = av.getColor(t.d.cp_bg_line_c);
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
        this.mPaint.setColor(this.Zc);
        canvas.drawRect(this.YW, this.mPaint);
        if (this.Zg) {
            canvas.drawRect(this.YX, this.mPaint);
        }
        if (this.Zf) {
            this.mPaint.setColor(this.Zd);
            canvas.drawRect(this.YV, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.Zf = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.Zg = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.YT = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.YU = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int Zj;

        private b(int i) {
            this.Zj = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.YT.f(this.Zj, true);
        }
    }

    public void az(boolean z) {
        this.Zh = z;
    }

    public void setDviderRectWidth(int i) {
        this.Zb = i;
    }
}
