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
    private int YF;
    private int YG;
    private a YH;
    private final Rect YI;
    private final Rect YJ;
    private int YK;
    private int YL;
    private int YM;
    private int YN;
    private boolean YO;
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
        this.YG = -1;
        this.YI = new Rect();
        this.YJ = new Rect();
        this.mPaint = new Paint();
        this.YO = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YG = -1;
        this.YI = new Rect();
        this.YJ = new Rect();
        this.mPaint = new Paint();
        this.YO = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.YK = k.dip2px(getContext(), 1.0f);
        this.YL = k.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.YF = i.e.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.YG != i) {
            if (this.YG != -1) {
                getChildAt(this.YG).setSelected(false);
            }
            this.YG = i;
            getChildAt(this.YG).setSelected(true);
            if (z) {
                b(this.YG, 0.0f);
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
        this.YG = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.YN = this.mWidth / this.mChildCount;
            if (this.YG != -1) {
                b(this.YG, 0.0f);
            }
            int i5 = this.mHeight - this.YK;
            this.YJ.set(0, i5, this.mWidth, this.YK + i5);
        }
    }

    public void b(int i, float f) {
        this.left = this.YN * i;
        this.left += (int) (this.YN * f);
        this.YI.set(this.left, this.mHeight - this.YL, this.left + this.YN, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.YF = i;
    }

    public void onChangeSkinType(int i) {
        al.i(this, this.YF);
        this.YM = al.getColor(i.c.cp_link_tip_a);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).cI(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.YO) {
            this.mPaint.setColor(this.YM);
            canvas.drawRect(this.YI, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.YO = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.YH = aVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int YP;

        private b(int i) {
            this.YP = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.YH.c(this.YP, true);
        }
    }
}
