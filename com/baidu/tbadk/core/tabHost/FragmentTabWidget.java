package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int ZC;
    private int ZD;
    private a ZE;
    private c ZF;
    private final Rect ZG;
    private final Rect ZH;
    private final Rect ZI;
    private int ZJ;
    private int ZK;
    private int ZL;
    private int ZM;
    private int ZN;
    private int ZO;
    private int ZP;
    private boolean ZQ;
    private boolean ZR;
    private boolean ZS;
    private int ZT;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.ZD = -1;
        this.ZG = new Rect();
        this.ZH = new Rect();
        this.ZI = new Rect();
        this.mPaint = new Paint();
        this.ZM = 0;
        this.ZQ = true;
        this.ZR = false;
        this.ZS = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZD = -1;
        this.ZG = new Rect();
        this.ZH = new Rect();
        this.ZI = new Rect();
        this.mPaint = new Paint();
        this.ZM = 0;
        this.ZQ = true;
        this.ZR = false;
        this.ZS = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.ZJ = getResources().getDimensionPixelSize(r.e.ds1);
        this.ZK = k.dip2px(getContext(), 1.0f);
        this.ZL = k.dip2px(getContext(), 3.0f);
        this.ZT = getResources().getDimensionPixelSize(r.e.ds10);
        setWillNotDraw(false);
        this.ZC = r.d.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.ZD != i) {
                if (this.ZD != -1) {
                    getChildAt(this.ZD).setSelected(false);
                }
                this.ZD = i;
                getChildAt(this.ZD).setSelected(true);
                if (z) {
                    b(this.ZD, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.ZF != null) {
            this.ZF.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        B(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        B(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void B(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.ZS) {
            view.setPadding(0, 0, 0, this.ZT);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.ZD = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.ZP = this.mWidth / this.mChildCount;
            if (this.ZD != -1) {
                b(this.ZD, 0.0f);
            }
            int i5 = this.mHeight - this.ZJ;
            this.ZH.set(0, i5, this.mWidth, this.ZJ + i5);
            this.ZI.set(0, 0, this.mWidth, this.ZK);
        }
    }

    public void b(int i, float f) {
        this.left = this.ZP * i;
        this.left += (int) (this.ZP * f);
        int i2 = this.mHeight - this.ZL;
        if (this.ZM != 0) {
            this.ZG.set((this.left + (this.ZP / 2)) - (this.ZM / 2), i2, this.left + (this.ZP / 2) + (this.ZM / 2), this.mHeight);
        } else {
            this.ZG.set(this.left, i2, this.left + this.ZP, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.ZC = i;
    }

    public void onChangeSkinType(int i) {
        if (this.ZC != 0) {
            at.l(this, this.ZC);
        }
        this.ZO = at.getColor(r.d.cp_link_tip_a);
        this.ZN = at.getColor(r.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dm(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.ZN);
        canvas.drawRect(this.ZH, this.mPaint);
        if (this.ZR) {
            canvas.drawRect(this.ZI, this.mPaint);
        }
        if (this.ZQ) {
            this.mPaint.setColor(this.ZO);
            canvas.drawRect(this.ZG, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.ZQ = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.ZR = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.ZE = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.ZF = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int ZU;

        private b(int i) {
            this.ZU = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.ZE.f(this.ZU, true);
        }
    }

    public void aC(boolean z) {
        this.ZS = z;
    }

    public void setDviderRectWidth(int i) {
        this.ZM = i;
    }
}
