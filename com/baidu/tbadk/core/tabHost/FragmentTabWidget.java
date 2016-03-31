package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int ZM;
    private int ZN;
    private a ZO;
    private c ZP;
    private final Rect ZQ;
    private final Rect ZR;
    private int ZS;
    private int ZT;
    private int ZU;
    private int ZV;
    private boolean ZW;
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
        this.ZN = -1;
        this.ZQ = new Rect();
        this.ZR = new Rect();
        this.mPaint = new Paint();
        this.ZW = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZN = -1;
        this.ZQ = new Rect();
        this.ZR = new Rect();
        this.mPaint = new Paint();
        this.ZW = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.ZS = k.dip2px(getContext(), 1.0f);
        this.ZT = k.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.ZM = t.f.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.ZN != i) {
                if (this.ZN != -1) {
                    getChildAt(this.ZN).setSelected(false);
                }
                this.ZN = i;
                getChildAt(this.ZN).setSelected(true);
                if (z) {
                    b(this.ZN, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.ZP != null) {
            this.ZP.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        B(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        B(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void B(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.ZN = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.ZV = this.mWidth / this.mChildCount;
            if (this.ZN != -1) {
                b(this.ZN, 0.0f);
            }
            int i5 = this.mHeight - this.ZS;
            this.ZR.set(0, i5, this.mWidth, this.ZS + i5);
        }
    }

    public void b(int i, float f) {
        this.left = this.ZV * i;
        this.left += (int) (this.ZV * f);
        this.ZQ.set(this.left, this.mHeight - this.ZT, this.left + this.ZV, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.ZM = i;
    }

    public void onChangeSkinType(int i) {
        at.k(this, this.ZM);
        this.ZU = at.getColor(t.d.s_actionbar_text_line_color_s);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dn(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.ZW) {
            this.mPaint.setColor(this.ZU);
            canvas.drawRect(this.ZQ, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.ZW = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.ZO = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.ZP = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int ZX;

        private b(int i) {
            this.ZX = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.ZO.c(this.ZX, true);
        }
    }
}
