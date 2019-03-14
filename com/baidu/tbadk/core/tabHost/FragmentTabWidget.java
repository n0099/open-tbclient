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
    private int bHY;
    private a bHZ;
    private c bIa;
    private final Rect bIb;
    private final Rect bIc;
    private final Rect bId;
    private int bIe;
    private int bIf;
    private int bIg;
    private int bIh;
    private int bIi;
    private int bIj;
    private boolean bIk;
    private boolean bIl;
    private boolean bIm;
    private int bIn;
    private boolean bIo;
    private boolean bIp;
    private View bIq;
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
        this.bIb = new Rect();
        this.bIc = new Rect();
        this.bId = new Rect();
        this.mPaint = new Paint();
        this.bIh = 0;
        this.bIk = true;
        this.bIl = false;
        this.bIm = false;
        this.bIo = false;
        this.bIp = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedTabIndex = -1;
        this.bIb = new Rect();
        this.bIc = new Rect();
        this.bId = new Rect();
        this.mPaint = new Paint();
        this.bIh = 0;
        this.bIk = true;
        this.bIl = false;
        this.bIm = false;
        this.bIo = false;
        this.bIp = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.bIe = getResources().getDimensionPixelSize(d.e.ds1);
        this.bIf = l.dip2px(getContext(), 1.0f);
        this.bIg = l.dip2px(getContext(), 2.0f);
        this.bIn = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.bHY = d.C0277d.common_color_10274;
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
        if (this.bIa != null) {
            this.bIa.onSizeChanged(i, i2, i3, i4);
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
            this.bIq = view;
        }
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    public View getWriteView() {
        return this.bIq;
    }

    public void e(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int h = !z ? l.h(TbadkCoreApplication.getInst(), d.e.tbds73) : 0;
        if (this.bIo) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, h, 0, 0);
        if (this.bIm) {
            view.setPadding(0, 0, 0, this.bIn);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    private void aB(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bIo) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.bIm) {
            view.setPadding(0, 0, 0, this.bIn);
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
            this.bIj = this.mWidth / this.mChildCount;
            if (this.mSelectedTabIndex != -1) {
                d(this.mSelectedTabIndex, 0.0f);
            }
            int i5 = this.mHeight - this.bIe;
            this.bIc.set(0, i5, this.mWidth, this.bIe + i5);
            this.bId.set(0, 0, this.mWidth, this.bIf);
        }
    }

    public void d(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.bIj - dimensionPixelSize) / 2;
        this.left = this.bIj * i;
        this.left += (int) (this.bIj * f);
        int i3 = this.mHeight - this.bIg;
        if (this.bIh == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.bIb.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.bIb.set((this.left + (this.bIj / 2)) - (this.bIh / 2), i3, this.left + (this.bIj / 2) + (this.bIh / 2), this.mHeight);
                }
            } else {
                this.bIb.set((this.left + (this.bIj / 2)) - (this.bIh / 2), i3, this.left + (this.bIj / 2) + (this.bIh / 2), this.mHeight);
            }
        } else if (this.bIh != 0) {
            this.bIb.set((this.left + (this.bIj / 2)) - (this.bIh / 2), i3, this.left + (this.bIj / 2) + (this.bIh / 2), this.mHeight);
        } else {
            this.bIb.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.bHY = i;
    }

    public void onChangeSkinType(int i) {
        if (this.bHY != 0) {
            al.l(this, this.bHY);
        }
        this.bIi = al.getColor(d.C0277d.cp_cont_b);
        this.mDividerColor = al.getColor(d.C0277d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).ij(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        if (this.bIp) {
            canvas.drawRect(this.bIc, this.mPaint);
        }
        if (this.bIl) {
            canvas.drawRect(this.bId, this.mPaint);
        }
        if (this.bIk) {
            this.mPaint.setColor(this.bIi);
            canvas.drawRoundRect(new RectF(this.bIb), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.bIp = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.bIk = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.bIl = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.bHZ = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.bIa = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int bIr;

        private b(int i) {
            this.bIr = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.bHZ.onTabSelectionChanged(this.bIr, true);
        }
    }

    public void setDviderRectWidth(int i) {
        this.bIh = i;
    }

    public void setDviderRectHeight(int i) {
        this.bIg = i;
    }

    public void setDiverColor(int i) {
        this.bIi = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.bIo = z;
    }
}
