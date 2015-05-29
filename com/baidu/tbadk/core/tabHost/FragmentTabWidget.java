package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int TD;
    private int TE;
    private c TF;
    private final Rect TG;
    private final Rect TH;
    private int TI;
    private int TJ;
    private int TK;
    private int TL;
    private boolean TM;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    public FragmentTabWidget(Context context) {
        super(context);
        this.TE = -1;
        this.TG = new Rect();
        this.TH = new Rect();
        this.mPaint = new Paint();
        this.TM = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TE = -1;
        this.TG = new Rect();
        this.TH = new Rect();
        this.mPaint = new Paint();
        this.TM = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.TI = n.dip2px(getContext(), 1.0f);
        this.TJ = n.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.TD = p.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.TE != i) {
            if (this.TE != -1) {
                getChildAt(this.TE).setSelected(false);
            }
            this.TE = i;
            getChildAt(this.TE).setSelected(true);
            if (z) {
                a(this.TE, 0.0f);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        n(view);
        super.addView(view);
        view.setOnClickListener(new d(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        n(view);
        super.addView(view, i);
        view.setOnClickListener(new d(this, getChildCount() - 1, null));
    }

    private void n(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.TE = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.TL = this.mWidth / this.mChildCount;
            if (this.TE != -1) {
                a(this.TE, 0.0f);
            }
            int i5 = this.mHeight - this.TI;
            this.TH.set(0, i5, this.mWidth, this.TI + i5);
        }
    }

    public void a(int i, float f) {
        this.left = this.TL * i;
        this.left += (int) (this.TL * f);
        this.TG.set(this.left, this.mHeight - this.TJ, this.left + this.TL, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.TD = i;
    }

    public void onChangeSkinType(int i) {
        ay.i(this, this.TD);
        this.TK = ay.getColor(com.baidu.tieba.n.cp_link_tip_a);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).cz(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.TM) {
            this.mPaint.setColor(this.TK);
            canvas.drawRect(this.TG, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.TM = z;
    }

    public void setTabSelectionListener(c cVar) {
        this.TF = cVar;
    }
}
