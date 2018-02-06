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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int TT;
    private int aUB;
    private a aUC;
    private c aUD;
    private final Rect aUE;
    private final Rect aUF;
    private final Rect aUG;
    private int aUH;
    private int aUI;
    private int aUJ;
    private int aUK;
    private int aUL;
    private int aUM;
    private boolean aUN;
    private boolean aUO;
    private boolean aUP;
    private int aUQ;
    private boolean aUR;
    private int left;
    private int mChildCount;
    private int mDividerColor;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void u(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.TT = -1;
        this.aUE = new Rect();
        this.aUF = new Rect();
        this.aUG = new Rect();
        this.mPaint = new Paint();
        this.aUK = 0;
        this.aUN = true;
        this.aUO = false;
        this.aUP = false;
        this.aUR = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TT = -1;
        this.aUE = new Rect();
        this.aUF = new Rect();
        this.aUG = new Rect();
        this.mPaint = new Paint();
        this.aUK = 0;
        this.aUN = true;
        this.aUO = false;
        this.aUP = false;
        this.aUR = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aUH = getResources().getDimensionPixelSize(d.e.ds1);
        this.aUI = l.dip2px(getContext(), 1.0f);
        this.aUJ = l.dip2px(getContext(), 2.0f);
        this.aUQ = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.aUB = d.C0140d.common_color_10274;
    }

    public void a(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    e eVar = (e) getChildAt(i2);
                    eVar.setCheckDescriptionText(i == i2);
                    eVar.cr(i == i2);
                    i2++;
                }
            }
            if (this.TT != i) {
                if (this.TT != -1) {
                    getChildAt(this.TT).setSelected(false);
                }
                this.TT = i;
                getChildAt(this.TT).setSelected(true);
                if (z) {
                    g(this.TT, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aUD != null) {
            this.aUD.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        aQ(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        aQ(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    private void aQ(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.aUR) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aUP) {
            view.setPadding(0, 0, 0, this.aUQ);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.TT = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aUM = this.mWidth / this.mChildCount;
            if (this.TT != -1) {
                g(this.TT, 0.0f);
            }
            int i5 = this.mHeight - this.aUH;
            this.aUF.set(0, i5, this.mWidth, this.aUH + i5);
            this.aUG.set(0, 0, this.mWidth, this.aUI);
        }
    }

    public void g(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.aUM - dimensionPixelSize) / 2;
        this.left = this.aUM * i;
        this.left += (int) (this.aUM * f);
        int i3 = this.mHeight - this.aUJ;
        if (this.aUK == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof e)) {
                View contentTv = ((e) childAt).getContentTv();
                if (contentTv != null) {
                    this.aUE.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aUE.set((this.left + (this.aUM / 2)) - (this.aUK / 2), i3, this.left + (this.aUM / 2) + (this.aUK / 2), this.mHeight);
                }
            } else {
                this.aUE.set((this.left + (this.aUM / 2)) - (this.aUK / 2), i3, this.left + (this.aUM / 2) + (this.aUK / 2), this.mHeight);
            }
        } else if (this.aUK != 0) {
            this.aUE.set((this.left + (this.aUM / 2)) - (this.aUK / 2), i3, this.left + (this.aUM / 2) + (this.aUK / 2), this.mHeight);
        } else {
            this.aUE.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aUB = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aUB != 0) {
            aj.t(this, this.aUB);
        }
        this.aUL = aj.getColor(d.C0140d.cp_cont_b);
        this.mDividerColor = aj.getColor(d.C0140d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).gB(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        canvas.drawRect(this.aUF, this.mPaint);
        if (this.aUO) {
            canvas.drawRect(this.aUG, this.mPaint);
        }
        if (this.aUN) {
            this.mPaint.setColor(this.aUL);
            canvas.drawRoundRect(new RectF(this.aUE), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aUN = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aUO = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aUC = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aUD = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aUS;

        private b(int i) {
            this.aUS = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aUC.u(this.aUS, true);
        }
    }

    public void bk(boolean z) {
        this.aUP = z;
    }

    public void setDviderRectWidth(int i) {
        this.aUK = i;
    }

    public void setDviderRectHeight(int i) {
        this.aUJ = i;
    }

    public void setDiverColor(int i) {
        this.aUL = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aUR = z;
    }
}
