package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int YI;
    private int YJ;
    private a YK;
    private c YL;
    private final Rect YM;
    private final Rect YN;
    private int YO;
    private int YP;
    private int YQ;
    private int YR;
    private boolean YS;
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
        this.YJ = -1;
        this.YM = new Rect();
        this.YN = new Rect();
        this.mPaint = new Paint();
        this.YS = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YJ = -1;
        this.YM = new Rect();
        this.YN = new Rect();
        this.mPaint = new Paint();
        this.YS = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.YO = k.dip2px(getContext(), 1.0f);
        this.YP = k.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.YI = i.e.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.YJ != i) {
            if (this.YJ != -1) {
                getChildAt(this.YJ).setSelected(false);
            }
            this.YJ = i;
            getChildAt(this.YJ).setSelected(true);
            if (z) {
                b(this.YJ, 0.0f);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.YL != null) {
            this.YL.onSizeChanged(i, i2, i3, i4);
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
        this.YJ = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.YR = this.mWidth / this.mChildCount;
            if (this.YJ != -1) {
                b(this.YJ, 0.0f);
            }
            int i5 = this.mHeight - this.YO;
            this.YN.set(0, i5, this.mWidth, this.YO + i5);
        }
    }

    public void b(int i, float f) {
        this.left = this.YR * i;
        this.left += (int) (this.YR * f);
        this.YM.set(this.left, this.mHeight - this.YP, this.left + this.YR, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.YI = i;
    }

    public void onChangeSkinType(int i) {
        an.i(this, this.YI);
        this.YQ = an.getColor(i.c.s_actionbar_text_line_color_s);
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
        if (this.YS) {
            this.mPaint.setColor(this.YQ);
            canvas.drawRect(this.YM, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.YS = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.YK = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.YL = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int YT;

        private b(int i) {
            this.YT = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.YK.c(this.YT, true);
        }
    }
}
