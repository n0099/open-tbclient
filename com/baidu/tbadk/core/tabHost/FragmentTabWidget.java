package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int YO;
    private int YP;
    private a YQ;
    private final Rect YR;
    private final Rect YS;
    private int YT;
    private int YU;
    private int YV;
    private int YW;
    private boolean YX;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, boolean z);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.YP = -1;
        this.YR = new Rect();
        this.YS = new Rect();
        this.mPaint = new Paint();
        this.YX = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YP = -1;
        this.YR = new Rect();
        this.YS = new Rect();
        this.mPaint = new Paint();
        this.YX = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.YT = k.dip2px(getContext(), 1.0f);
        this.YU = k.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.YO = i.e.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.YP != i) {
            if (this.YP != -1) {
                getChildAt(this.YP).setSelected(false);
            }
            this.YP = i;
            getChildAt(this.YP).setSelected(true);
            if (z) {
                b(this.YP, 0.0f);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        o(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        o(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void o(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.YP = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.YW = this.mWidth / this.mChildCount;
            if (this.YP != -1) {
                b(this.YP, 0.0f);
            }
            int i5 = this.mHeight - this.YT;
            this.YS.set(0, i5, this.mWidth, this.YT + i5);
        }
    }

    public void b(int i, float f) {
        this.left = this.YW * i;
        this.left += (int) (this.YW * f);
        this.YR.set(this.left, this.mHeight - this.YU, this.left + this.YW, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.YO = i;
    }

    public void onChangeSkinType(int i) {
        al.h(this, this.YO);
        this.YV = al.getColor(i.c.cp_link_tip_a);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).cO(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.YX) {
            this.mPaint.setColor(this.YV);
            canvas.drawRect(this.YR, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.YX = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.YQ = aVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int YY;

        private b(int i) {
            this.YY = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.YQ.c(this.YY, true);
        }
    }
}
