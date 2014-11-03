package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int CA;
    private c CB;
    private final Rect CC;
    private final Rect CD;
    private int CE;
    private int CF;
    private int CG;
    private int CH;
    private Paint gs;
    private int left;
    private int mChildCount;
    private int mHeight;
    private int mWidth;

    public FragmentTabWidget(Context context) {
        super(context);
        this.CA = -1;
        this.CC = new Rect();
        this.CD = new Rect();
        this.gs = new Paint();
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CA = -1;
        this.CC = new Rect();
        this.CD = new Rect();
        this.gs = new Paint();
        init();
    }

    private void init() {
        this.gs = new Paint(6);
        this.gs.setAntiAlias(true);
        this.gs.setStyle(Paint.Style.FILL);
        this.CE = m.dip2px(getContext(), 1.0f);
        this.CF = m.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.CA != i) {
            if (this.CA != -1) {
                getChildAt(this.CA).setSelected(false);
            }
            this.CA = i;
            getChildAt(this.CA).setSelected(true);
            if (z) {
                a(this.CA, 0.0f);
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
        this.CA = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.CH = this.mWidth / this.mChildCount;
            if (this.CA != -1) {
                a(this.CA, 0.0f);
            }
            int i5 = this.mHeight - this.CE;
            this.CD.set(0, i5, this.mWidth, this.CE + i5);
        }
    }

    public void a(int i, float f) {
        this.left = this.CH * i;
        this.left += (int) (this.CH * f);
        this.CC.set(this.left, this.mHeight - this.CF, this.left + this.CH, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void onChangeSkinType(int i) {
        aw.h(this, u.bg_navigation_bar);
        this.CG = aw.getColor(s.cp_link_tip_a);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).bN(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.gs.setColor(this.CG);
        canvas.drawRect(this.CC, this.gs);
    }

    public void setTabSelectionListener(c cVar) {
        this.CB = cVar;
    }
}
