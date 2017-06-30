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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int adH;
    private int adI;
    private a adJ;
    private c adK;
    private final Rect adL;
    private final Rect adM;
    private final Rect adN;
    private int adO;
    private int adP;
    private int adQ;
    private int adR;
    private int adS;
    private int adT;
    private int adU;
    private boolean adV;
    private boolean adW;
    private boolean adX;
    private int adY;
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
        this.adI = -1;
        this.adL = new Rect();
        this.adM = new Rect();
        this.adN = new Rect();
        this.mPaint = new Paint();
        this.adR = 0;
        this.adV = true;
        this.adW = false;
        this.adX = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adI = -1;
        this.adL = new Rect();
        this.adM = new Rect();
        this.adN = new Rect();
        this.mPaint = new Paint();
        this.adR = 0;
        this.adV = true;
        this.adW = false;
        this.adX = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.adO = getResources().getDimensionPixelSize(w.f.ds1);
        this.adP = k.dip2px(getContext(), 1.0f);
        this.adQ = k.dip2px(getContext(), 3.0f);
        this.adY = getResources().getDimensionPixelSize(w.f.ds10);
        setWillNotDraw(false);
        this.adH = w.e.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.adI != i) {
                if (this.adI != -1) {
                    getChildAt(this.adI).setSelected(false);
                }
                this.adI = i;
                getChildAt(this.adI).setSelected(true);
                if (z) {
                    b(this.adI, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.adK != null) {
            this.adK.onSizeChanged(i, i2, i3, i4);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.adX) {
            view.setPadding(0, 0, 0, this.adY);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.adI = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.adU = this.mWidth / this.mChildCount;
            if (this.adI != -1) {
                b(this.adI, 0.0f);
            }
            int i5 = this.mHeight - this.adO;
            this.adM.set(0, i5, this.mWidth, this.adO + i5);
            this.adN.set(0, 0, this.mWidth, this.adP);
        }
    }

    public void b(int i, float f) {
        this.left = this.adU * i;
        this.left += (int) (this.adU * f);
        int i2 = this.mHeight - this.adQ;
        if (this.adR != 0) {
            this.adL.set((this.left + (this.adU / 2)) - (this.adR / 2), i2, this.left + (this.adU / 2) + (this.adR / 2), this.mHeight);
        } else {
            this.adL.set(this.left, i2, this.left + this.adU, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.adH = i;
    }

    public void onChangeSkinType(int i) {
        if (this.adH != 0) {
            as.k(this, this.adH);
        }
        if (this.adT == 0) {
            this.adT = as.getColor(w.e.cp_link_tip_a);
        }
        this.adS = as.getColor(w.e.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dp(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.adS);
        canvas.drawRect(this.adM, this.mPaint);
        if (this.adW) {
            canvas.drawRect(this.adN, this.mPaint);
        }
        if (this.adV) {
            this.mPaint.setColor(this.adT);
            canvas.drawRect(this.adL, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.adV = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.adW = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.adJ = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.adK = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int adZ;

        private b(int i) {
            this.adZ = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.adJ.f(this.adZ, true);
        }
    }

    public void aC(boolean z) {
        this.adX = z;
    }

    public void setDviderRectWidth(int i) {
        this.adR = i;
    }

    public void setDviderRectHeight(int i) {
        this.adQ = i;
    }

    public void setDiverColor(int i) {
        this.adT = i;
    }
}
