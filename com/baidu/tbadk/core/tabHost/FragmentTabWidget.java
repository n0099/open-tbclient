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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int anR;
    private a anS;
    private c anT;
    private final Rect anU;
    private final Rect anV;
    private final Rect anW;
    private int anX;
    private int anY;
    private int anZ;
    private int aoa;
    private int aob;
    private int aoc;
    private boolean aod;
    private boolean aoe;
    private boolean aof;
    private int aog;
    private boolean aoh;
    private boolean aoi;
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
        this.anU = new Rect();
        this.anV = new Rect();
        this.anW = new Rect();
        this.mPaint = new Paint();
        this.aoa = 0;
        this.aod = true;
        this.aoe = false;
        this.aof = false;
        this.aoh = false;
        this.aoi = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.anU = new Rect();
        this.anV = new Rect();
        this.anW = new Rect();
        this.mPaint = new Paint();
        this.aoa = 0;
        this.aod = true;
        this.aoe = false;
        this.aof = false;
        this.aoh = false;
        this.aoi = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.anX = getResources().getDimensionPixelSize(f.e.ds1);
        this.anY = l.dip2px(getContext(), 1.0f);
        this.anZ = l.dip2px(getContext(), 2.0f);
        this.aog = getResources().getDimensionPixelSize(f.e.ds10);
        setWillNotDraw(false);
        this.anR = f.d.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.bP(i == i2);
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
        if (this.anT != null) {
            this.anT.onSizeChanged(i, i2, i3, i4);
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
        if (this.aoh) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aof) {
            view.setPadding(0, 0, 0, this.aog);
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
            this.aoc = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.anX;
            this.anV.set(0, i5, this.mWidth, this.anX + i5);
            this.anW.set(0, 0, this.mWidth, this.anY);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.e.ds64);
        int i2 = (this.aoc - dimensionPixelSize) / 2;
        this.left = this.aoc * i;
        this.left += (int) (this.aoc * f);
        int i3 = this.mHeight - this.anZ;
        if (this.aoa == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.anU.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.anU.set((this.left + (this.aoc / 2)) - (this.aoa / 2), i3, this.left + (this.aoc / 2) + (this.aoa / 2), this.mHeight);
                }
            } else {
                this.anU.set((this.left + (this.aoc / 2)) - (this.aoa / 2), i3, this.left + (this.aoc / 2) + (this.aoa / 2), this.mHeight);
            }
        } else if (this.aoa != 0) {
            this.anU.set((this.left + (this.aoc / 2)) - (this.aoa / 2), i3, this.left + (this.aoc / 2) + (this.aoa / 2), this.mHeight);
        } else {
            this.anU.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.anR = i;
    }

    public void onChangeSkinType(int i) {
        if (this.anR != 0) {
            am.j(this, this.anR);
        }
        this.aob = am.getColor(f.d.cp_cont_b);
        this.mDividerColor = am.getColor(f.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dF(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.aoi) {
            canvas.drawRect(this.anV, this.mPaint);
        }
        if (this.aoe) {
            canvas.drawRect(this.anW, this.mPaint);
        }
        if (this.aod) {
            this.mPaint.setColor(this.aob);
            canvas.drawRoundRect(new RectF(this.anU), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.aoi = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aod = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aoe = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.anS = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.anT = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aoj;

        private b(int i) {
            this.aoj = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.anS.onTabSelectionChanged(this.aoj, true);
        }
    }

    public void aH(boolean z) {
        this.aof = z;
    }

    public void setDviderRectWidth(int i) {
        this.aoa = i;
    }

    public void setDviderRectHeight(int i) {
        this.anZ = i;
    }

    public void setDiverColor(int i) {
        this.aob = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aoh = z;
    }
}
