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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int bIb;
    private a bIc;
    private c bId;
    private final Rect bIe;
    private final Rect bIf;
    private final Rect bIg;
    private int bIh;
    private int bIi;
    private int bIj;
    private int bIk;
    private int bIl;
    private int bIm;
    private boolean bIn;
    private boolean bIo;
    private boolean bIp;
    private int bIq;
    private boolean bIr;
    private boolean bIs;
    private View bIt;
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
        this.bIe = new Rect();
        this.bIf = new Rect();
        this.bIg = new Rect();
        this.mPaint = new Paint();
        this.bIk = 0;
        this.bIn = true;
        this.bIo = false;
        this.bIp = false;
        this.bIr = false;
        this.bIs = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.bIe = new Rect();
        this.bIf = new Rect();
        this.bIg = new Rect();
        this.mPaint = new Paint();
        this.bIk = 0;
        this.bIn = true;
        this.bIo = false;
        this.bIp = false;
        this.bIr = false;
        this.bIs = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.bIh = getResources().getDimensionPixelSize(d.e.ds1);
        this.bIi = l.dip2px(getContext(), 1.0f);
        this.bIj = l.dip2px(getContext(), 2.0f);
        this.bIq = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.bIb = d.C0277d.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.eT(i == i2);
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
        if (this.bId != null) {
            this.bId.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        aB(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        aB(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public void addView(View view, int i, boolean z) {
        e(view, z);
        super.addView(view, i);
        if (z) {
            this.bIt = view;
        }
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public View getWriteView() {
        return this.bIt;
    }

    public void e(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int h = !z ? l.h(TbadkCoreApplication.getInst(), d.e.tbds73) : 0;
        if (this.bIr) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, h, 0, 0);
        if (this.bIp) {
            view.setPadding(0, 0, 0, this.bIq);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    private void aB(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bIr) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.bIp) {
            view.setPadding(0, 0, 0, this.bIq);
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
            this.bIm = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.bIh;
            this.bIf.set(0, i5, this.mWidth, this.bIh + i5);
            this.bIg.set(0, 0, this.mWidth, this.bIi);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.bIm - dimensionPixelSize) / 2;
        this.left = this.bIm * i;
        this.left += (int) (this.bIm * f);
        int i3 = this.mHeight - this.bIj;
        if (this.bIk == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.bIe.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.bIe.set((this.left + (this.bIm / 2)) - (this.bIk / 2), i3, this.left + (this.bIm / 2) + (this.bIk / 2), this.mHeight);
                }
            } else {
                this.bIe.set((this.left + (this.bIm / 2)) - (this.bIk / 2), i3, this.left + (this.bIm / 2) + (this.bIk / 2), this.mHeight);
            }
        } else if (this.bIk != 0) {
            this.bIe.set((this.left + (this.bIm / 2)) - (this.bIk / 2), i3, this.left + (this.bIm / 2) + (this.bIk / 2), this.mHeight);
        } else {
            this.bIe.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.bIb = i;
    }

    public void onChangeSkinType(int i) {
        if (this.bIb != 0) {
            al.l(this, this.bIb);
        }
        this.bIl = al.getColor(d.C0277d.cp_cont_b);
        this.mDividerColor = al.getColor(d.C0277d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).ii(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.bIs) {
            canvas.drawRect(this.bIf, this.mPaint);
        }
        if (this.bIo) {
            canvas.drawRect(this.bIg, this.mPaint);
        }
        if (this.bIn) {
            this.mPaint.setColor(this.bIl);
            canvas.drawRoundRect(new RectF(this.bIe), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.bIs = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.bIn = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.bIo = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.bIc = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.bId = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int bIu;

        private b(int i) {
            this.bIu = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.bIc.onTabSelectionChanged(this.bIu, true);
        }
    }

    public void setDviderRectWidth(int i) {
        this.bIk = i;
    }

    public void setDviderRectHeight(int i) {
        this.bIj = i;
    }

    public void setDiverColor(int i) {
        this.bIl = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.bIr = z;
    }
}
