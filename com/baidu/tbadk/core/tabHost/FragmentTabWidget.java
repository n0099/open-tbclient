package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int adN;
    private int adO;
    private a adP;
    private c adQ;
    private final Rect adR;
    private final Rect adS;
    private final Rect adT;
    private int adU;
    private int adV;
    private int adW;
    private int adX;
    private int adY;
    private int adZ;
    private int aea;
    private boolean aeb;
    private boolean aec;
    private boolean aed;
    private int aee;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.adO = -1;
        this.adR = new Rect();
        this.adS = new Rect();
        this.adT = new Rect();
        this.mPaint = new Paint();
        this.adX = 0;
        this.aeb = true;
        this.aec = false;
        this.aed = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adO = -1;
        this.adR = new Rect();
        this.adS = new Rect();
        this.adT = new Rect();
        this.mPaint = new Paint();
        this.adX = 0;
        this.aeb = true;
        this.aec = false;
        this.aed = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.adU = getResources().getDimensionPixelSize(w.f.ds1);
        this.adV = k.dip2px(getContext(), 1.0f);
        this.adW = k.dip2px(getContext(), 3.0f);
        this.aee = getResources().getDimensionPixelSize(w.f.ds10);
        setWillNotDraw(false);
        this.adN = w.e.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.adO != i) {
                if (this.adO != -1) {
                    getChildAt(this.adO).setSelected(false);
                }
                this.adO = i;
                getChildAt(this.adO).setSelected(true);
                if (z) {
                    b(this.adO, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.adQ != null) {
            this.adQ.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        x(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        x(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void x(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aed) {
            view.setPadding(0, 0, 0, this.aee);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.adO = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aea = this.mWidth / this.mChildCount;
            if (this.adO != -1) {
                b(this.adO, 0.0f);
            }
            int i5 = this.mHeight - this.adU;
            this.adS.set(0, i5, this.mWidth, this.adU + i5);
            this.adT.set(0, 0, this.mWidth, this.adV);
        }
    }

    public void b(int i, float f) {
        this.left = this.aea * i;
        this.left += (int) (this.aea * f);
        int i2 = this.mHeight - this.adW;
        if (this.adX != 0) {
            this.adR.set((this.left + (this.aea / 2)) - (this.adX / 2), i2, this.left + (this.aea / 2) + (this.adX / 2), this.mHeight);
        } else {
            this.adR.set(this.left, i2, this.left + this.aea, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.adN = i;
    }

    public void onChangeSkinType(int i) {
        if (this.adN != 0) {
            aq.k(this, this.adN);
        }
        this.adZ = aq.getColor(w.e.cp_link_tip_a);
        this.adY = aq.getColor(w.e.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).m14do(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.adY);
        canvas.drawRect(this.adS, this.mPaint);
        if (this.aec) {
            canvas.drawRect(this.adT, this.mPaint);
        }
        if (this.aeb) {
            this.mPaint.setColor(this.adZ);
            canvas.drawRect(this.adR, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aeb = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aec = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.adP = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.adQ = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aef;

        private b(int i) {
            this.aef = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.adP.f(this.aef, true);
        }
    }

    public void aE(boolean z) {
        this.aed = z;
    }

    public void setDviderRectWidth(int i) {
        this.adX = i;
    }
}
