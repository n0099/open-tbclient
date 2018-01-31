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
    private int TU;
    private int aSW;
    private a aSX;
    private c aSY;
    private final Rect aSZ;
    private final Rect aTa;
    private final Rect aTb;
    private int aTc;
    private int aTd;
    private int aTe;
    private int aTf;
    private int aTg;
    private int aTh;
    private boolean aTi;
    private boolean aTj;
    private boolean aTk;
    private int aTl;
    private boolean aTm;
    private int left;
    private int mChildCount;
    private int mDividerColor;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void p(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.TU = -1;
        this.aSZ = new Rect();
        this.aTa = new Rect();
        this.aTb = new Rect();
        this.mPaint = new Paint();
        this.aTf = 0;
        this.aTi = true;
        this.aTj = false;
        this.aTk = false;
        this.aTm = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TU = -1;
        this.aSZ = new Rect();
        this.aTa = new Rect();
        this.aTb = new Rect();
        this.mPaint = new Paint();
        this.aTf = 0;
        this.aTi = true;
        this.aTj = false;
        this.aTk = false;
        this.aTm = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aTc = getResources().getDimensionPixelSize(d.e.ds1);
        this.aTd = l.dip2px(getContext(), 1.0f);
        this.aTe = l.dip2px(getContext(), 2.0f);
        this.aTl = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.aSW = d.C0108d.common_color_10274;
    }

    public void a(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    e eVar = (e) getChildAt(i2);
                    eVar.setCheckDescriptionText(i == i2);
                    eVar.cn(i == i2);
                    i2++;
                }
            }
            if (this.TU != i) {
                if (this.TU != -1) {
                    getChildAt(this.TU).setSelected(false);
                }
                this.TU = i;
                getChildAt(this.TU).setSelected(true);
                if (z) {
                    g(this.TU, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aSY != null) {
            this.aSY.onSizeChanged(i, i2, i3, i4);
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
        if (this.aTm) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aTk) {
            view.setPadding(0, 0, 0, this.aTl);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.TU = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aTh = this.mWidth / this.mChildCount;
            if (this.TU != -1) {
                g(this.TU, 0.0f);
            }
            int i5 = this.mHeight - this.aTc;
            this.aTa.set(0, i5, this.mWidth, this.aTc + i5);
            this.aTb.set(0, 0, this.mWidth, this.aTd);
        }
    }

    public void g(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.aTh - dimensionPixelSize) / 2;
        this.left = this.aTh * i;
        this.left += (int) (this.aTh * f);
        int i3 = this.mHeight - this.aTe;
        if (this.aTf == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof e)) {
                View contentTv = ((e) childAt).getContentTv();
                if (contentTv != null) {
                    this.aSZ.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aSZ.set((this.left + (this.aTh / 2)) - (this.aTf / 2), i3, this.left + (this.aTh / 2) + (this.aTf / 2), this.mHeight);
                }
            } else {
                this.aSZ.set((this.left + (this.aTh / 2)) - (this.aTf / 2), i3, this.left + (this.aTh / 2) + (this.aTf / 2), this.mHeight);
            }
        } else if (this.aTf != 0) {
            this.aSZ.set((this.left + (this.aTh / 2)) - (this.aTf / 2), i3, this.left + (this.aTh / 2) + (this.aTf / 2), this.mHeight);
        } else {
            this.aSZ.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aSW = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aSW != 0) {
            aj.t(this, this.aSW);
        }
        this.aTg = aj.getColor(d.C0108d.cp_cont_b);
        this.mDividerColor = aj.getColor(d.C0108d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).gz(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        canvas.drawRect(this.aTa, this.mPaint);
        if (this.aTj) {
            canvas.drawRect(this.aTb, this.mPaint);
        }
        if (this.aTi) {
            this.mPaint.setColor(this.aTg);
            canvas.drawRoundRect(new RectF(this.aSZ), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aTi = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aTj = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aSX = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aSY = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aTn;

        private b(int i) {
            this.aTn = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aSX.p(this.aTn, true);
        }
    }

    public void bh(boolean z) {
        this.aTk = z;
    }

    public void setDviderRectWidth(int i) {
        this.aTf = i;
    }

    public void setDviderRectHeight(int i) {
        this.aTe = i;
    }

    public void setDiverColor(int i) {
        this.aTg = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aTm = z;
    }
}
