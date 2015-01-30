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
    private int GT;
    private int GU;
    private d GV;
    private final Rect GW;
    private final Rect GX;
    private int GY;
    private int GZ;
    private int Ha;
    private int Hb;
    private boolean Hc;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    public FragmentTabWidget(Context context) {
        super(context);
        this.GU = -1;
        this.GW = new Rect();
        this.GX = new Rect();
        this.mPaint = new Paint();
        this.Hc = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GU = -1;
        this.GW = new Rect();
        this.GX = new Rect();
        this.mPaint = new Paint();
        this.Hc = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.GY = l.dip2px(getContext(), 1.0f);
        this.GZ = l.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.GT = v.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.GU != i) {
            if (this.GU != -1) {
                getChildAt(this.GU).setSelected(false);
            }
            this.GU = i;
            getChildAt(this.GU).setSelected(true);
            if (z) {
                a(this.GU, 0.0f);
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
        this.GU = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.Hb = this.mWidth / this.mChildCount;
            if (this.GU != -1) {
                a(this.GU, 0.0f);
            }
            int i5 = this.mHeight - this.GY;
            this.GX.set(0, i5, this.mWidth, this.GY + i5);
        }
    }

    public void a(int i, float f) {
        this.left = this.Hb * i;
        this.left += (int) (this.Hb * f);
        this.GW.set(this.left, this.mHeight - this.GZ, this.left + this.Hb, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.GT = i;
    }

    public void onChangeSkinType(int i) {
        bc.i(this, this.GT);
        this.Ha = bc.getColor(t.cp_link_tip_a);
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
        if (this.Hc) {
            this.mPaint.setColor(this.Ha);
            canvas.drawRect(this.GW, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.Hc = z;
    }

    public void setTabSelectionListener(d dVar) {
        this.GV = dVar;
    }
}
