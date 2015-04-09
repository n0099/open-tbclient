package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int SU;
    private int SV;
    private c SW;
    private final Rect SX;
    private final Rect SY;
    private int SZ;
    private int Ta;
    private int Tb;
    private int Tc;
    private boolean Td;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    public FragmentTabWidget(Context context) {
        super(context);
        this.SV = -1;
        this.SX = new Rect();
        this.SY = new Rect();
        this.mPaint = new Paint();
        this.Td = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SV = -1;
        this.SX = new Rect();
        this.SY = new Rect();
        this.mPaint = new Paint();
        this.Td = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.SZ = n.dip2px(getContext(), 1.0f);
        this.Ta = n.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.SU = u.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.SV != i) {
            if (this.SV != -1) {
                getChildAt(this.SV).setSelected(false);
            }
            this.SV = i;
            getChildAt(this.SV).setSelected(true);
            if (z) {
                a(this.SV, 0.0f);
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
        this.SV = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.Tc = this.mWidth / this.mChildCount;
            if (this.SV != -1) {
                a(this.SV, 0.0f);
            }
            int i5 = this.mHeight - this.SZ;
            this.SY.set(0, i5, this.mWidth, this.SZ + i5);
        }
    }

    public void a(int i, float f) {
        this.left = this.Tc * i;
        this.left += (int) (this.Tc * f);
        this.SX.set(this.left, this.mHeight - this.Ta, this.left + this.Tc, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.SU = i;
    }

    public void onChangeSkinType(int i) {
        ba.i(this, this.SU);
        this.Tb = ba.getColor(s.cp_link_tip_a);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).cu(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.Td) {
            this.mPaint.setColor(this.Tb);
            canvas.drawRect(this.SX, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.Td = z;
    }

    public void setTabSelectionListener(c cVar) {
        this.SW = cVar;
    }
}
