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
    private int bPM;
    private a bPN;
    private c bPO;
    private final Rect bPP;
    private final Rect bPQ;
    private final Rect bPR;
    private int bPS;
    private int bPT;
    private int bPU;
    private int bPV;
    private int bPW;
    private int bPX;
    private boolean bPY;
    private boolean bPZ;
    private boolean bQa;
    private int bQb;
    private boolean bQc;
    private boolean bQd;
    private View bQe;
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
        this.bPP = new Rect();
        this.bPQ = new Rect();
        this.bPR = new Rect();
        this.mPaint = new Paint();
        this.bPV = 0;
        this.bPY = true;
        this.bPZ = false;
        this.bQa = false;
        this.bQc = false;
        this.bQd = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.bPP = new Rect();
        this.bPQ = new Rect();
        this.bPR = new Rect();
        this.mPaint = new Paint();
        this.bPV = 0;
        this.bPY = true;
        this.bPZ = false;
        this.bQa = false;
        this.bQc = false;
        this.bQd = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.bPS = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.bPT = l.dip2px(getContext(), 1.0f);
        this.bPU = l.dip2px(getContext(), 2.0f);
        this.bQb = getResources().getDimensionPixelSize(R.dimen.ds10);
        setWillNotDraw(false);
        this.bPM = R.color.common_color_10274;
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
        if (this.bPO != null) {
            this.bPO.onSizeChanged(i, i2, i3, i4);
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
            this.bQe = view;
        }
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public View getWriteView() {
        return this.bQe;
    }

    public void e(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int g = !z ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds73) : 0;
        if (this.bQc) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, g, 0, 0);
        if (this.bQa) {
            view.setPadding(0, 0, 0, this.bQb);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    private void aH(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bQc) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.bQa) {
            view.setPadding(0, 0, 0, this.bQb);
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
            this.bPX = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.bPS;
            this.bPQ.set(0, i5, this.mWidth, this.bPS + i5);
            this.bPR.set(0, 0, this.mWidth, this.bPT);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int i2 = (this.bPX - dimensionPixelSize) / 2;
        this.left = this.bPX * i;
        this.left += (int) (this.bPX * f);
        int i3 = this.mHeight - this.bPU;
        if (this.bPV == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.bPP.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.bPP.set((this.left + (this.bPX / 2)) - (this.bPV / 2), i3, this.left + (this.bPX / 2) + (this.bPV / 2), this.mHeight);
                }
            } else {
                this.bPP.set((this.left + (this.bPX / 2)) - (this.bPV / 2), i3, this.left + (this.bPX / 2) + (this.bPV / 2), this.mHeight);
            }
        } else if (this.bPV != 0) {
            this.bPP.set((this.left + (this.bPX / 2)) - (this.bPV / 2), i3, this.left + (this.bPX / 2) + (this.bPV / 2), this.mHeight);
        } else {
            this.bPP.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.bPM = i;
    }

    public void onChangeSkinType(int i) {
        if (this.bPM != 0) {
            al.l(this, this.bPM);
        }
        this.bPW = al.getColor(R.color.cp_cont_b);
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
        if (this.bQd) {
            canvas.drawRect(this.bPQ, this.mPaint);
        }
        if (this.bPZ) {
            canvas.drawRect(this.bPR, this.mPaint);
        }
        if (this.bPY) {
            this.mPaint.setColor(this.bPW);
            canvas.drawRoundRect(new RectF(this.bPP), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.bQd = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.bPY = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.bPZ = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.bPN = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.bPO = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int bQf;

        private b(int i) {
            this.bQf = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.bPN.onTabSelectionChanged(this.bQf, true);
        }
    }

    public void setDviderRectWidth(int i) {
        this.bPV = i;
    }

    public void setDviderRectHeight(int i) {
        this.bPU = i;
    }

    public void setDiverColor(int i) {
        this.bPW = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.bQc = z;
    }
}
