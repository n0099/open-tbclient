package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int GJ;
    private int GK;
    private c GL;
    private final Rect GM;
    private final Rect GN;
    private int GP;
    private int GQ;
    private int GR;
    private int GS;
    private boolean GT;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    public FragmentTabWidget(Context context) {
        super(context);
        this.GK = -1;
        this.GM = new Rect();
        this.GN = new Rect();
        this.mPaint = new Paint();
        this.GT = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GK = -1;
        this.GM = new Rect();
        this.GN = new Rect();
        this.mPaint = new Paint();
        this.GT = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.GP = l.dip2px(getContext(), 1.0f);
        this.GQ = l.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.GJ = v.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.GK != i) {
            if (this.GK != -1) {
                getChildAt(this.GK).setSelected(false);
            }
            this.GK = i;
            getChildAt(this.GK).setSelected(true);
            if (z) {
                a(this.GK, 0.0f);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        l(view);
        super.addView(view);
        view.setOnClickListener(new d(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        l(view);
        super.addView(view, i);
        view.setOnClickListener(new d(this, getChildCount() - 1, null));
    }

    private void l(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.GK = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.GS = this.mWidth / this.mChildCount;
            if (this.GK != -1) {
                a(this.GK, 0.0f);
            }
            int i5 = this.mHeight - this.GP;
            this.GN.set(0, i5, this.mWidth, this.GP + i5);
        }
    }

    public void a(int i, float f) {
        this.left = this.GS * i;
        this.left += (int) (this.GS * f);
        this.GM.set(this.left, this.mHeight - this.GQ, this.left + this.GS, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.GJ = i;
    }

    public void onChangeSkinType(int i) {
        ax.i(this, this.GJ);
        this.GR = ax.getColor(t.cp_link_tip_a);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).cm(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.GT) {
            this.mPaint.setColor(this.GR);
            canvas.drawRect(this.GM, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.GT = z;
    }

    public void setTabSelectionListener(c cVar) {
        this.GL = cVar;
    }
}
