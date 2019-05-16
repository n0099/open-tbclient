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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int bPL;
    private a bPM;
    private c bPN;
    private final Rect bPO;
    private final Rect bPP;
    private final Rect bPQ;
    private int bPR;
    private int bPS;
    private int bPT;
    private int bPU;
    private int bPV;
    private int bPW;
    private boolean bPX;
    private boolean bPY;
    private boolean bPZ;
    private int bQa;
    private boolean bQb;
    private boolean bQc;
    private View bQd;
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
        this.bPO = new Rect();
        this.bPP = new Rect();
        this.bPQ = new Rect();
        this.mPaint = new Paint();
        this.bPU = 0;
        this.bPX = true;
        this.bPY = false;
        this.bPZ = false;
        this.bQb = false;
        this.bQc = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.bPO = new Rect();
        this.bPP = new Rect();
        this.bPQ = new Rect();
        this.mPaint = new Paint();
        this.bPU = 0;
        this.bPX = true;
        this.bPY = false;
        this.bPZ = false;
        this.bQb = false;
        this.bQc = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.bPR = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.bPS = l.dip2px(getContext(), 1.0f);
        this.bPT = l.dip2px(getContext(), 2.0f);
        this.bQa = getResources().getDimensionPixelSize(R.dimen.ds10);
        setWillNotDraw(false);
        this.bPL = R.color.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.fp(i == i2);
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
        if (this.bPN != null) {
            this.bPN.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        aH(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        aH(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public void addView(View view, int i, boolean z) {
        e(view, z);
        super.addView(view, i);
        if (z) {
            this.bQd = view;
        }
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public View getWriteView() {
        return this.bQd;
    }

    public void e(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int g = !z ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds73) : 0;
        if (this.bQb) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, g, 0, 0);
        if (this.bPZ) {
            view.setPadding(0, 0, 0, this.bQa);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    private void aH(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bQb) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.bPZ) {
            view.setPadding(0, 0, 0, this.bQa);
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
            this.bPW = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.bPR;
            this.bPP.set(0, i5, this.mWidth, this.bPR + i5);
            this.bPQ.set(0, 0, this.mWidth, this.bPS);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int i2 = (this.bPW - dimensionPixelSize) / 2;
        this.left = this.bPW * i;
        this.left += (int) (this.bPW * f);
        int i3 = this.mHeight - this.bPT;
        if (this.bPU == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.bPO.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.bPO.set((this.left + (this.bPW / 2)) - (this.bPU / 2), i3, this.left + (this.bPW / 2) + (this.bPU / 2), this.mHeight);
                }
            } else {
                this.bPO.set((this.left + (this.bPW / 2)) - (this.bPU / 2), i3, this.left + (this.bPW / 2) + (this.bPU / 2), this.mHeight);
            }
        } else if (this.bPU != 0) {
            this.bPO.set((this.left + (this.bPW / 2)) - (this.bPU / 2), i3, this.left + (this.bPW / 2) + (this.bPU / 2), this.mHeight);
        } else {
            this.bPO.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.bPL = i;
    }

    public void onChangeSkinType(int i) {
        if (this.bPL != 0) {
            al.l(this, this.bPL);
        }
        this.bPV = al.getColor(R.color.cp_cont_b);
        this.mDividerColor = al.getColor(R.color.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).iW(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.bQc) {
            canvas.drawRect(this.bPP, this.mPaint);
        }
        if (this.bPY) {
            canvas.drawRect(this.bPQ, this.mPaint);
        }
        if (this.bPX) {
            this.mPaint.setColor(this.bPV);
            canvas.drawRoundRect(new RectF(this.bPO), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.bQc = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.bPX = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.bPY = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.bPM = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.bPN = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int bQe;

        private b(int i) {
            this.bQe = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.bPM.onTabSelectionChanged(this.bQe, true);
        }
    }

    public void setDviderRectWidth(int i) {
        this.bPU = i;
    }

    public void setDviderRectHeight(int i) {
        this.bPT = i;
    }

    public void setDiverColor(int i) {
        this.bPV = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.bQb = z;
    }
}
