package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int GQ;
    private int GR;
    private d GS;
    private final Rect GT;
    private final Rect GU;
    private int GV;
    private int GW;
    private int GX;
    private int GY;
    private boolean GZ;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    public FragmentTabWidget(Context context) {
        super(context);
        this.GR = -1;
        this.GT = new Rect();
        this.GU = new Rect();
        this.mPaint = new Paint();
        this.GZ = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GR = -1;
        this.GT = new Rect();
        this.GU = new Rect();
        this.mPaint = new Paint();
        this.GZ = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.GV = l.dip2px(getContext(), 1.0f);
        this.GW = l.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.GQ = v.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.GR != i) {
            if (this.GR != -1) {
                getChildAt(this.GR).setSelected(false);
            }
            this.GR = i;
            getChildAt(this.GR).setSelected(true);
            if (z) {
                a(this.GR, 0.0f);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        l(view);
        super.addView(view);
        view.setOnClickListener(new e(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        l(view);
        super.addView(view, i);
        view.setOnClickListener(new e(this, getChildCount() - 1, null));
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
        this.GR = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.GY = this.mWidth / this.mChildCount;
            if (this.GR != -1) {
                a(this.GR, 0.0f);
            }
            int i5 = this.mHeight - this.GV;
            this.GU.set(0, i5, this.mWidth, this.GV + i5);
        }
    }

    public void a(int i, float f) {
        this.left = this.GY * i;
        this.left += (int) (this.GY * f);
        this.GT.set(this.left, this.mHeight - this.GW, this.left + this.GY, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.GQ = i;
    }

    public void onChangeSkinType(int i) {
        bc.i(this, this.GQ);
        this.GX = bc.getColor(t.cp_link_tip_a);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).ct(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.GZ) {
            this.mPaint.setColor(this.GX);
            canvas.drawRect(this.GT, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.GZ = z;
    }

    public void setTabSelectionListener(d dVar) {
        this.GS = dVar;
    }
}
