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
    private int azB;
    private a azC;
    private c azD;
    private final Rect azE;
    private final Rect azF;
    private final Rect azG;
    private int azH;
    private int azI;
    private int azJ;
    private int azK;
    private int azL;
    private int azM;
    private boolean azN;
    private boolean azO;
    private boolean azP;
    private int azQ;
    private boolean azR;
    private boolean azS;
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
        this.azE = new Rect();
        this.azF = new Rect();
        this.azG = new Rect();
        this.mPaint = new Paint();
        this.azK = 0;
        this.azN = true;
        this.azO = false;
        this.azP = false;
        this.azR = false;
        this.azS = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.azE = new Rect();
        this.azF = new Rect();
        this.azG = new Rect();
        this.mPaint = new Paint();
        this.azK = 0;
        this.azN = true;
        this.azO = false;
        this.azP = false;
        this.azR = false;
        this.azS = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.azH = getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.azI = l.dip2px(getContext(), 1.0f);
        this.azJ = l.dip2px(getContext(), 2.0f);
        this.azQ = getResources().getDimensionPixelSize(e.C0210e.ds10);
        setWillNotDraw(false);
        this.azB = e.d.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.cC(i == i2);
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
        if (this.azD != null) {
            this.azD.onSizeChanged(i, i2, i3, i4);
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
        if (this.azR) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.azP) {
            view.setPadding(0, 0, 0, this.azQ);
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
            this.azM = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.azH;
            this.azF.set(0, i5, this.mWidth, this.azH + i5);
            this.azG.set(0, 0, this.mWidth, this.azI);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds64);
        int i2 = (this.azM - dimensionPixelSize) / 2;
        this.left = this.azM * i;
        this.left += (int) (this.azM * f);
        int i3 = this.mHeight - this.azJ;
        if (this.azK == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.azE.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.azE.set((this.left + (this.azM / 2)) - (this.azK / 2), i3, this.left + (this.azM / 2) + (this.azK / 2), this.mHeight);
                }
            } else {
                this.azE.set((this.left + (this.azM / 2)) - (this.azK / 2), i3, this.left + (this.azM / 2) + (this.azK / 2), this.mHeight);
            }
        } else if (this.azK != 0) {
            this.azE.set((this.left + (this.azM / 2)) - (this.azK / 2), i3, this.left + (this.azM / 2) + (this.azK / 2), this.mHeight);
        } else {
            this.azE.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.azB = i;
    }

    public void onChangeSkinType(int i) {
        if (this.azB != 0) {
            al.j(this, this.azB);
        }
        this.azL = al.getColor(e.d.cp_cont_b);
        this.mDividerColor = al.getColor(e.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).eC(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.azS) {
            canvas.drawRect(this.azF, this.mPaint);
        }
        if (this.azO) {
            canvas.drawRect(this.azG, this.mPaint);
        }
        if (this.azN) {
            this.mPaint.setColor(this.azL);
            canvas.drawRoundRect(new RectF(this.azE), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.azS = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.azN = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.azO = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.azC = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.azD = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int azT;

        private b(int i) {
            this.azT = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.azC.onTabSelectionChanged(this.azT, true);
        }
    }

    public void br(boolean z) {
        this.azP = z;
    }

    public void setDviderRectWidth(int i) {
        this.azK = i;
    }

    public void setDviderRectHeight(int i) {
        this.azJ = i;
    }

    public void setDiverColor(int i) {
        this.azL = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.azR = z;
    }
}
