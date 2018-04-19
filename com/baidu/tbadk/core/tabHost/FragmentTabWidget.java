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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int afL;
    private a afM;
    private c afN;
    private final Rect afO;
    private final Rect afP;
    private final Rect afQ;
    private int afR;
    private int afS;
    private int afT;
    private int afU;
    private int afV;
    private boolean afW;
    private boolean afX;
    private boolean afY;
    private int afZ;
    private boolean aga;
    private int left;
    private int mChildCount;
    private int mDividerColor;
    private int mHeight;
    private int mItemWidth;
    private Paint mPaint;
    private int mSelectedTabIndex;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.mSelectedTabIndex = -1;
        this.afO = new Rect();
        this.afP = new Rect();
        this.afQ = new Rect();
        this.mPaint = new Paint();
        this.afU = 0;
        this.afW = true;
        this.afX = false;
        this.afY = false;
        this.aga = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.afO = new Rect();
        this.afP = new Rect();
        this.afQ = new Rect();
        this.mPaint = new Paint();
        this.afU = 0;
        this.afW = true;
        this.afX = false;
        this.afY = false;
        this.aga = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.afR = getResources().getDimensionPixelSize(d.e.ds1);
        this.afS = l.dip2px(getContext(), 1.0f);
        this.afT = l.dip2px(getContext(), 2.0f);
        this.afZ = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.afL = d.C0126d.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.bJ(i == i2);
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
                    b(this.mSelectedTabIndex, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.afN != null) {
            this.afN.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        y(view2);
        super.addView(view2);
        view2.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i) {
        y(view2);
        super.addView(view2, i);
        view2.setOnClickListener(new b(getChildCount() - 1));
    }

    private void y(View view2) {
        LinearLayout.LayoutParams layoutParams;
        if (this.aga) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.afY) {
            view2.setPadding(0, 0, 0, this.afZ);
        }
        view2.setLayoutParams(layoutParams);
        view2.setFocusable(true);
        view2.setClickable(true);
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
            this.mItemWidth = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                b(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.afR;
            this.afP.set(0, i5, this.mWidth, this.afR + i5);
            this.afQ.set(0, 0, this.mWidth, this.afS);
        }
    }

    public void b(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.mItemWidth - dimensionPixelSize) / 2;
        this.left = this.mItemWidth * i;
        this.left += (int) (this.mItemWidth * f);
        int i3 = this.mHeight - this.afT;
        if (this.afU == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.afO.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.afO.set((this.left + (this.mItemWidth / 2)) - (this.afU / 2), i3, this.left + (this.mItemWidth / 2) + (this.afU / 2), this.mHeight);
                }
            } else {
                this.afO.set((this.left + (this.mItemWidth / 2)) - (this.afU / 2), i3, this.left + (this.mItemWidth / 2) + (this.afU / 2), this.mHeight);
            }
        } else if (this.afU != 0) {
            this.afO.set((this.left + (this.mItemWidth / 2)) - (this.afU / 2), i3, this.left + (this.mItemWidth / 2) + (this.afU / 2), this.mHeight);
        } else {
            this.afO.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.afL = i;
    }

    public void onChangeSkinType(int i) {
        if (this.afL != 0) {
            ak.j(this, this.afL);
        }
        this.afV = ak.getColor(d.C0126d.cp_cont_b);
        this.mDividerColor = ak.getColor(d.C0126d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dz(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        canvas.drawRect(this.afP, this.mPaint);
        if (this.afX) {
            canvas.drawRect(this.afQ, this.mPaint);
        }
        if (this.afW) {
            this.mPaint.setColor(this.afV);
            canvas.drawRoundRect(new RectF(this.afO), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.afW = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.afX = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.afM = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.afN = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int agb;

        private b(int i) {
            this.agb = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FragmentTabWidget.this.afM.i(this.agb, true);
        }
    }

    public void aC(boolean z) {
        this.afY = z;
    }

    public void setDviderRectWidth(int i) {
        this.afU = i;
    }

    public void setDviderRectHeight(int i) {
        this.afT = i;
    }

    public void setDiverColor(int i) {
        this.afV = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aga = z;
    }
}
