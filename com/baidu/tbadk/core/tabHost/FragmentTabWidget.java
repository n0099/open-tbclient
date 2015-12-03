package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private a ZA;
    private c ZB;
    private final Rect ZC;
    private final Rect ZD;
    private int ZE;
    private int ZF;
    private int ZG;
    private int ZH;
    private boolean ZI;
    private int Zy;
    private int Zz;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.Zz = -1;
        this.ZC = new Rect();
        this.ZD = new Rect();
        this.mPaint = new Paint();
        this.ZI = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zz = -1;
        this.ZC = new Rect();
        this.ZD = new Rect();
        this.mPaint = new Paint();
        this.ZI = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.ZE = k.dip2px(getContext(), 1.0f);
        this.ZF = k.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.Zy = n.e.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.Zz != i) {
            if (this.Zz != -1) {
                getChildAt(this.Zz).setSelected(false);
            }
            this.Zz = i;
            getChildAt(this.Zz).setSelected(true);
            if (z) {
                b(this.Zz, 0.0f);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.ZB != null) {
            this.ZB.onSizeChanged(i, i2, i3, i4);
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
        this.Zz = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.ZH = this.mWidth / this.mChildCount;
            if (this.Zz != -1) {
                b(this.Zz, 0.0f);
            }
            int i5 = this.mHeight - this.ZE;
            this.ZD.set(0, i5, this.mWidth, this.ZE + i5);
        }
    }

    public void b(int i, float f) {
        this.left = this.ZH * i;
        this.left += (int) (this.ZH * f);
        this.ZC.set(this.left, this.mHeight - this.ZF, this.left + this.ZH, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.Zy = i;
    }

    public void onChangeSkinType(int i) {
        as.i(this, this.Zy);
        this.ZG = as.getColor(n.c.s_actionbar_text_line_color_s);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).cX(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.ZI) {
            this.mPaint.setColor(this.ZG);
            canvas.drawRect(this.ZC, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.ZI = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.ZA = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.ZB = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int ZJ;

        private b(int i) {
            this.ZJ = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.ZA.c(this.ZJ, true);
        }
    }
}
