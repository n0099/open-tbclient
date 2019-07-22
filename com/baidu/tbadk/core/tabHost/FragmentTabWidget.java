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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int bQM;
    private a bQN;
    private c bQO;
    private final Rect bQP;
    private final Rect bQQ;
    private final Rect bQR;
    private int bQS;
    private int bQT;
    private int bQU;
    private int bQV;
    private int bQW;
    private int bQX;
    private boolean bQY;
    private boolean bQZ;
    private boolean bRa;
    private int bRb;
    private boolean bRc;
    private boolean bRd;
    private View bRe;
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
        this.bQP = new Rect();
        this.bQQ = new Rect();
        this.bQR = new Rect();
        this.mPaint = new Paint();
        this.bQV = 0;
        this.bQY = true;
        this.bQZ = false;
        this.bRa = false;
        this.bRc = false;
        this.bRd = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.bQP = new Rect();
        this.bQQ = new Rect();
        this.bQR = new Rect();
        this.mPaint = new Paint();
        this.bQV = 0;
        this.bQY = true;
        this.bQZ = false;
        this.bRa = false;
        this.bRc = false;
        this.bRd = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.bQS = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.bQT = l.dip2px(getContext(), 1.0f);
        this.bQU = l.dip2px(getContext(), 2.0f);
        this.bRb = getResources().getDimensionPixelSize(R.dimen.ds10);
        setWillNotDraw(false);
        this.bQM = R.color.common_color_10274;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                    tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                    tbFragmentTabIndicator.ft(i == i2);
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
        if (this.bQO != null) {
            this.bQO.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        aJ(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        aJ(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public void addView(View view, int i, boolean z) {
        e(view, z);
        super.addView(view, i);
        if (z) {
            this.bRe = view;
        }
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public View getWriteView() {
        return this.bRe;
    }

    public void e(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int g = !z ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds73) : 0;
        if (this.bRc) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, g, 0, 0);
        if (this.bRa) {
            view.setPadding(0, 0, 0, this.bRb);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    private void aJ(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bRc) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.bRa) {
            view.setPadding(0, 0, 0, this.bRb);
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
            this.bQX = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.bQS;
            this.bQQ.set(0, i5, this.mWidth, this.bQS + i5);
            this.bQR.set(0, 0, this.mWidth, this.bQT);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int i2 = (this.bQX - dimensionPixelSize) / 2;
        this.left = this.bQX * i;
        this.left += (int) (this.bQX * f);
        int i3 = this.mHeight - this.bQU;
        if (this.bQV == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.bQP.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.bQP.set((this.left + (this.bQX / 2)) - (this.bQV / 2), i3, this.left + (this.bQX / 2) + (this.bQV / 2), this.mHeight);
                }
            } else {
                this.bQP.set((this.left + (this.bQX / 2)) - (this.bQV / 2), i3, this.left + (this.bQX / 2) + (this.bQV / 2), this.mHeight);
            }
        } else if (this.bQV != 0) {
            this.bQP.set((this.left + (this.bQX / 2)) - (this.bQV / 2), i3, this.left + (this.bQX / 2) + (this.bQV / 2), this.mHeight);
        } else {
            this.bQP.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.bQM = i;
    }

    public void onChangeSkinType(int i) {
        if (this.bQM != 0) {
            am.l(this, this.bQM);
        }
        this.bQW = am.getColor(R.color.cp_cont_b);
        this.mDividerColor = am.getColor(R.color.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).jc(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.bRd) {
            canvas.drawRect(this.bQQ, this.mPaint);
        }
        if (this.bQZ) {
            canvas.drawRect(this.bQR, this.mPaint);
        }
        if (this.bQY) {
            this.mPaint.setColor(this.bQW);
            canvas.drawRoundRect(new RectF(this.bQP), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.bRd = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.bQY = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.bQZ = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.bQN = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.bQO = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int bRf;

        private b(int i) {
            this.bRf = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.bQN.onTabSelectionChanged(this.bRf, true);
        }
    }

    public void setDviderRectWidth(int i) {
        this.bQV = i;
    }

    public void setDviderRectHeight(int i) {
        this.bQU = i;
    }

    public void setDiverColor(int i) {
        this.bQW = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.bRc = z;
    }
}
