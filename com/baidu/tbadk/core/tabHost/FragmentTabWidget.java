package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private final Rect aqA;
    private final Rect aqB;
    private final Rect aqC;
    private int aqD;
    private int aqE;
    private int aqF;
    private int aqG;
    private int aqH;
    private int aqI;
    private boolean aqJ;
    private boolean aqK;
    private boolean aqL;
    private int aqM;
    private boolean aqN;
    private boolean aqO;
    private int aqx;
    private a aqy;
    private c aqz;
    private int left;
    private int mChildCount;
    private int mDividerColor;
    private int mHeight;
    private Paint mPaint;
    private int mSelectedTabIndex;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.mSelectedTabIndex = -1;
        this.aqA = new Rect();
        this.aqB = new Rect();
        this.aqC = new Rect();
        this.mPaint = new Paint();
        this.aqG = 0;
        this.aqJ = true;
        this.aqK = false;
        this.aqL = false;
        this.aqN = false;
        this.aqO = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.aqA = new Rect();
        this.aqB = new Rect();
        this.aqC = new Rect();
        this.mPaint = new Paint();
        this.aqG = 0;
        this.aqJ = true;
        this.aqK = false;
        this.aqL = false;
        this.aqN = false;
        this.aqO = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aqD = getResources().getDimensionPixelSize(e.C0141e.ds1);
        this.aqE = l.dip2px(getContext(), 1.0f);
        this.aqF = l.dip2px(getContext(), 2.0f);
        this.aqM = getResources().getDimensionPixelSize(e.C0141e.ds10);
        setWillNotDraw(false);
        this.aqx = e.d.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.cb(i == i2);
                    i2++;
                }
            }
            if (this.mSelectedTabIndex != i) {
                if (this.mSelectedTabIndex != -1) {
                    getChildAt(this.mSelectedTabIndex).setSelected(false);
                }
                this.mSelectedTabIndex = i;
                getChildAt(this.mSelectedTabIndex).setSelected(true);
                if (z) {
                    d(this.mSelectedTabIndex, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aqz != null) {
            this.aqz.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        I(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        I(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    private void I(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.aqN) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aqL) {
            view.setPadding(0, 0, 0, this.aqM);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.mSelectedTabIndex = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aqI = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.aqD;
            this.aqB.set(0, i5, this.mWidth, this.aqD + i5);
            this.aqC.set(0, 0, this.mWidth, this.aqE);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0141e.ds64);
        int i2 = (this.aqI - dimensionPixelSize) / 2;
        this.left = this.aqI * i;
        this.left += (int) (this.aqI * f);
        int i3 = this.mHeight - this.aqF;
        if (this.aqG == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.aqA.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aqA.set((this.left + (this.aqI / 2)) - (this.aqG / 2), i3, this.left + (this.aqI / 2) + (this.aqG / 2), this.mHeight);
                }
            } else {
                this.aqA.set((this.left + (this.aqI / 2)) - (this.aqG / 2), i3, this.left + (this.aqI / 2) + (this.aqG / 2), this.mHeight);
            }
        } else if (this.aqG != 0) {
            this.aqA.set((this.left + (this.aqI / 2)) - (this.aqG / 2), i3, this.left + (this.aqI / 2) + (this.aqG / 2), this.mHeight);
        } else {
            this.aqA.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aqx = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aqx != 0) {
            al.j(this, this.aqx);
        }
        this.aqH = al.getColor(e.d.cp_cont_b);
        this.mDividerColor = al.getColor(e.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dQ(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.aqO) {
            canvas.drawRect(this.aqB, this.mPaint);
        }
        if (this.aqK) {
            canvas.drawRect(this.aqC, this.mPaint);
        }
        if (this.aqJ) {
            this.mPaint.setColor(this.aqH);
            canvas.drawRoundRect(new RectF(this.aqA), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.aqO = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aqJ = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aqK = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aqy = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aqz = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aqP;

        private b(int i) {
            this.aqP = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aqy.onTabSelectionChanged(this.aqP, true);
        }
    }

    public void aQ(boolean z) {
        this.aqL = z;
    }

    public void setDviderRectWidth(int i) {
        this.aqG = i;
    }

    public void setDviderRectHeight(int i) {
        this.aqF = i;
    }

    public void setDiverColor(int i) {
        this.aqH = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aqN = z;
    }
}
