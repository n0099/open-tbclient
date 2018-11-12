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
    private int awb;
    private a awc;
    private c awd;
    private final Rect awe;
    private final Rect awf;
    private final Rect awg;
    private int awh;
    private int awi;
    private int awj;
    private int awk;
    private int awl;
    private int awm;
    private boolean awn;
    private boolean awo;
    private boolean awp;
    private int awq;
    private boolean awr;
    private boolean aws;
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
        this.awe = new Rect();
        this.awf = new Rect();
        this.awg = new Rect();
        this.mPaint = new Paint();
        this.awk = 0;
        this.awn = true;
        this.awo = false;
        this.awp = false;
        this.awr = false;
        this.aws = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.awe = new Rect();
        this.awf = new Rect();
        this.awg = new Rect();
        this.mPaint = new Paint();
        this.awk = 0;
        this.awn = true;
        this.awo = false;
        this.awp = false;
        this.awr = false;
        this.aws = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.awh = getResources().getDimensionPixelSize(e.C0200e.ds1);
        this.awi = l.dip2px(getContext(), 1.0f);
        this.awj = l.dip2px(getContext(), 2.0f);
        this.awq = getResources().getDimensionPixelSize(e.C0200e.ds10);
        setWillNotDraw(false);
        this.awb = e.d.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.cB(i == i2);
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
        if (this.awd != null) {
            this.awd.onSizeChanged(i, i2, i3, i4);
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
        if (this.awr) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.awp) {
            view.setPadding(0, 0, 0, this.awq);
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
            this.awm = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.awh;
            this.awf.set(0, i5, this.mWidth, this.awh + i5);
            this.awg.set(0, 0, this.mWidth, this.awi);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0200e.ds64);
        int i2 = (this.awm - dimensionPixelSize) / 2;
        this.left = this.awm * i;
        this.left += (int) (this.awm * f);
        int i3 = this.mHeight - this.awj;
        if (this.awk == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.awe.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.awe.set((this.left + (this.awm / 2)) - (this.awk / 2), i3, this.left + (this.awm / 2) + (this.awk / 2), this.mHeight);
                }
            } else {
                this.awe.set((this.left + (this.awm / 2)) - (this.awk / 2), i3, this.left + (this.awm / 2) + (this.awk / 2), this.mHeight);
            }
        } else if (this.awk != 0) {
            this.awe.set((this.left + (this.awm / 2)) - (this.awk / 2), i3, this.left + (this.awm / 2) + (this.awk / 2), this.mHeight);
        } else {
            this.awe.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.awb = i;
    }

    public void onChangeSkinType(int i) {
        if (this.awb != 0) {
            al.j(this, this.awb);
        }
        this.awl = al.getColor(e.d.cp_cont_b);
        this.mDividerColor = al.getColor(e.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).eo(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.aws) {
            canvas.drawRect(this.awf, this.mPaint);
        }
        if (this.awo) {
            canvas.drawRect(this.awg, this.mPaint);
        }
        if (this.awn) {
            this.mPaint.setColor(this.awl);
            canvas.drawRoundRect(new RectF(this.awe), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.aws = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.awn = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.awo = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.awc = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.awd = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int awt;

        private b(int i) {
            this.awt = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.awc.onTabSelectionChanged(this.awt, true);
        }
    }

    public void bq(boolean z) {
        this.awp = z;
    }

    public void setDviderRectWidth(int i) {
        this.awk = i;
    }

    public void setDviderRectHeight(int i) {
        this.awj = i;
    }

    public void setDiverColor(int i) {
        this.awl = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.awr = z;
    }
}
