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
    private int adA;
    private a adB;
    private c adC;
    private final Rect adD;
    private final Rect adE;
    private final Rect adF;
    private int adG;
    private int adH;
    private int adI;
    private int adJ;
    private int adK;
    private int adL;
    private int adM;
    private boolean adN;
    private boolean adO;
    private boolean adP;
    private int adQ;
    private int adz;
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
        this.adA = -1;
        this.adD = new Rect();
        this.adE = new Rect();
        this.adF = new Rect();
        this.mPaint = new Paint();
        this.adJ = 0;
        this.adN = true;
        this.adO = false;
        this.adP = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adA = -1;
        this.adD = new Rect();
        this.adE = new Rect();
        this.adF = new Rect();
        this.mPaint = new Paint();
        this.adJ = 0;
        this.adN = true;
        this.adO = false;
        this.adP = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.adG = getResources().getDimensionPixelSize(w.f.ds1);
        this.adH = k.dip2px(getContext(), 1.0f);
        this.adI = k.dip2px(getContext(), 3.0f);
        this.adQ = getResources().getDimensionPixelSize(w.f.ds10);
        setWillNotDraw(false);
        this.adz = w.e.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.adA != i) {
                if (this.adA != -1) {
                    getChildAt(this.adA).setSelected(false);
                }
                this.adA = i;
                getChildAt(this.adA).setSelected(true);
                if (z) {
                    b(this.adA, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.adC != null) {
            this.adC.onSizeChanged(i, i2, i3, i4);
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
        if (this.adP) {
            view.setPadding(0, 0, 0, this.adQ);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.adA = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.adM = this.mWidth / this.mChildCount;
            if (this.adA != -1) {
                b(this.adA, 0.0f);
            }
            int i5 = this.mHeight - this.adG;
            this.adE.set(0, i5, this.mWidth, this.adG + i5);
            this.adF.set(0, 0, this.mWidth, this.adH);
        }
    }

    public void b(int i, float f) {
        this.left = this.adM * i;
        this.left += (int) (this.adM * f);
        int i2 = this.mHeight - this.adI;
        if (this.adJ != 0) {
            this.adD.set((this.left + (this.adM / 2)) - (this.adJ / 2), i2, this.left + (this.adM / 2) + (this.adJ / 2), this.mHeight);
        } else {
            this.adD.set(this.left, i2, this.left + this.adM, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.adz = i;
    }

    public void onChangeSkinType(int i) {
        if (this.adz != 0) {
            aq.k(this, this.adz);
        }
        this.adL = aq.getColor(w.e.cp_link_tip_a);
        this.adK = aq.getColor(w.e.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dl(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.adK);
        canvas.drawRect(this.adE, this.mPaint);
        if (this.adO) {
            canvas.drawRect(this.adF, this.mPaint);
        }
        if (this.adN) {
            this.mPaint.setColor(this.adL);
            canvas.drawRect(this.adD, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.adN = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.adO = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.adB = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.adC = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int adR;

        private b(int i) {
            this.adR = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.adB.f(this.adR, true);
        }
    }

    public void aC(boolean z) {
        this.adP = z;
    }

    public void setDviderRectWidth(int i) {
        this.adJ = i;
    }
}
