package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int YG;
    private int YH;
    private a YI;
    private c YJ;
    private final Rect YK;
    private final Rect YL;
    private int YM;
    private int YN;
    private int YO;
    private int YP;
    private boolean YQ;
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
        this.YH = -1;
        this.YK = new Rect();
        this.YL = new Rect();
        this.mPaint = new Paint();
        this.YQ = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YH = -1;
        this.YK = new Rect();
        this.YL = new Rect();
        this.mPaint = new Paint();
        this.YQ = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.YM = k.dip2px(getContext(), 1.0f);
        this.YN = k.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.YG = i.e.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.YH != i) {
            if (this.YH != -1) {
                getChildAt(this.YH).setSelected(false);
            }
            this.YH = i;
            getChildAt(this.YH).setSelected(true);
            if (z) {
                b(this.YH, 0.0f);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.YJ != null) {
            this.YJ.onSizeChanged(i, i2, i3, i4);
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
        this.YH = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.YP = this.mWidth / this.mChildCount;
            if (this.YH != -1) {
                b(this.YH, 0.0f);
            }
            int i5 = this.mHeight - this.YM;
            this.YL.set(0, i5, this.mWidth, this.YM + i5);
        }
    }

    public void b(int i, float f) {
        this.left = this.YP * i;
        this.left += (int) (this.YP * f);
        this.YK.set(this.left, this.mHeight - this.YN, this.left + this.YP, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.YG = i;
    }

    public void onChangeSkinType(int i) {
        am.i(this, this.YG);
        this.YO = am.getColor(i.c.s_actionbar_text_line_color_s);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).cP(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.YQ) {
            this.mPaint.setColor(this.YO);
            canvas.drawRect(this.YK, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.YQ = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.YI = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.YJ = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int YR;

        private b(int i) {
            this.YR = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.YI.c(this.YR, true);
        }
    }
}
