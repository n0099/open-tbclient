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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int anP;
    private a anQ;
    private c anR;
    private final Rect anS;
    private final Rect anT;
    private final Rect anU;
    private int anV;
    private int anW;
    private int anX;
    private int anY;
    private int anZ;
    private boolean aoa;
    private boolean aob;
    private boolean aoc;
    private int aod;
    private boolean aoe;
    private boolean aof;
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
        this.anS = new Rect();
        this.anT = new Rect();
        this.anU = new Rect();
        this.mPaint = new Paint();
        this.anY = 0;
        this.aoa = true;
        this.aob = false;
        this.aoc = false;
        this.aoe = false;
        this.aof = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.anS = new Rect();
        this.anT = new Rect();
        this.anU = new Rect();
        this.mPaint = new Paint();
        this.anY = 0;
        this.aoa = true;
        this.aob = false;
        this.aoc = false;
        this.aoe = false;
        this.aof = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.anV = getResources().getDimensionPixelSize(d.e.ds1);
        this.anW = l.dip2px(getContext(), 1.0f);
        this.anX = l.dip2px(getContext(), 2.0f);
        this.aod = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.anP = d.C0141d.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.bN(i == i2);
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
        if (this.anR != null) {
            this.anR.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        y(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        y(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    private void y(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.aoe) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aoc) {
            view.setPadding(0, 0, 0, this.aod);
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
            this.mItemWidth = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.anV;
            this.anT.set(0, i5, this.mWidth, this.anV + i5);
            this.anU.set(0, 0, this.mWidth, this.anW);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.mItemWidth - dimensionPixelSize) / 2;
        this.left = this.mItemWidth * i;
        this.left += (int) (this.mItemWidth * f);
        int i3 = this.mHeight - this.anX;
        if (this.anY == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.anS.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.anS.set((this.left + (this.mItemWidth / 2)) - (this.anY / 2), i3, this.left + (this.mItemWidth / 2) + (this.anY / 2), this.mHeight);
                }
            } else {
                this.anS.set((this.left + (this.mItemWidth / 2)) - (this.anY / 2), i3, this.left + (this.mItemWidth / 2) + (this.anY / 2), this.mHeight);
            }
        } else if (this.anY != 0) {
            this.anS.set((this.left + (this.mItemWidth / 2)) - (this.anY / 2), i3, this.left + (this.mItemWidth / 2) + (this.anY / 2), this.mHeight);
        } else {
            this.anS.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.anP = i;
    }

    public void onChangeSkinType(int i) {
        if (this.anP != 0) {
            al.j(this, this.anP);
        }
        this.anZ = al.getColor(d.C0141d.cp_cont_b);
        this.mDividerColor = al.getColor(d.C0141d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dC(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.aof) {
            canvas.drawRect(this.anT, this.mPaint);
        }
        if (this.aob) {
            canvas.drawRect(this.anU, this.mPaint);
        }
        if (this.aoa) {
            this.mPaint.setColor(this.anZ);
            canvas.drawRoundRect(new RectF(this.anS), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.aof = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aoa = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aob = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.anQ = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.anR = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aog;

        private b(int i) {
            this.aog = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.anQ.i(this.aog, true);
        }
    }

    public void aG(boolean z) {
        this.aoc = z;
    }

    public void setDviderRectWidth(int i) {
        this.anY = i;
    }

    public void setDviderRectHeight(int i) {
        this.anX = i;
    }

    public void setDiverColor(int i) {
        this.anZ = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aoe = z;
    }
}
