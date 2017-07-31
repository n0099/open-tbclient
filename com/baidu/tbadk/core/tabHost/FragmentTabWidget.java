package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private a afA;
    private c afB;
    private final Rect afC;
    private final Rect afD;
    private final Rect afE;
    private int afF;
    private int afG;
    private int afH;
    private int afI;
    private int afJ;
    private int afK;
    private int afL;
    private boolean afM;
    private boolean afN;
    private boolean afO;
    private int afP;
    private int afy;
    private int afz;
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
        this.afz = -1;
        this.afC = new Rect();
        this.afD = new Rect();
        this.afE = new Rect();
        this.mPaint = new Paint();
        this.afI = 0;
        this.afM = true;
        this.afN = false;
        this.afO = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afz = -1;
        this.afC = new Rect();
        this.afD = new Rect();
        this.afE = new Rect();
        this.mPaint = new Paint();
        this.afI = 0;
        this.afM = true;
        this.afN = false;
        this.afO = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.afF = getResources().getDimensionPixelSize(d.f.ds1);
        this.afG = k.dip2px(getContext(), 1.0f);
        this.afH = k.dip2px(getContext(), 3.0f);
        this.afP = getResources().getDimensionPixelSize(d.f.ds10);
        setWillNotDraw(false);
        this.afy = d.e.common_color_10274;
    }

    public void h(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.afz != i) {
                if (this.afz != -1) {
                    getChildAt(this.afz).setSelected(false);
                }
                this.afz = i;
                getChildAt(this.afz).setSelected(true);
                if (z) {
                    b(this.afz, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.afB != null) {
            this.afB.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        x(view);
        super.addView(view);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        x(view);
        super.addView(view, i);
        view.setOnClickListener(new b(getChildCount() - 1));
    }

    private void x(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.afO) {
            view.setPadding(0, 0, 0, this.afP);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.afz = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.afL = this.mWidth / this.mChildCount;
            if (this.afz != -1) {
                b(this.afz, 0.0f);
            }
            int i5 = this.mHeight - this.afF;
            this.afD.set(0, i5, this.mWidth, this.afF + i5);
            this.afE.set(0, 0, this.mWidth, this.afG);
        }
    }

    public void b(int i, float f) {
        this.left = this.afL * i;
        this.left += (int) (this.afL * f);
        int i2 = this.mHeight - this.afH;
        if (this.afI == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof FragmentTabIndicator)) {
                TextView contentTv = ((FragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.afC.set(childAt.getLeft() + contentTv.getLeft(), i2, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.afC.set((this.left + (this.afL / 2)) - (this.afI / 2), i2, this.left + (this.afL / 2) + (this.afI / 2), this.mHeight);
                }
            } else {
                this.afC.set((this.left + (this.afL / 2)) - (this.afI / 2), i2, this.left + (this.afL / 2) + (this.afI / 2), this.mHeight);
            }
        } else if (this.afI != 0) {
            this.afC.set((this.left + (this.afL / 2)) - (this.afI / 2), i2, this.left + (this.afL / 2) + (this.afI / 2), this.mHeight);
        } else {
            this.afC.set(this.left, i2, this.left + this.afL, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.afy = i;
    }

    public void onChangeSkinType(int i) {
        if (this.afy != 0) {
            ai.k(this, this.afy);
        }
        if (this.afK == 0) {
            this.afK = ai.getColor(d.e.cp_link_tip_a);
        }
        this.afJ = ai.getColor(d.e.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dt(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.afJ);
        canvas.drawRect(this.afD, this.mPaint);
        if (this.afN) {
            canvas.drawRect(this.afE, this.mPaint);
        }
        if (this.afM) {
            this.mPaint.setColor(this.afK);
            canvas.drawRect(this.afC, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.afM = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.afN = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.afA = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.afB = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int afQ;

        private b(int i) {
            this.afQ = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.afA.f(this.afQ, true);
        }
    }

    public void aB(boolean z) {
        this.afO = z;
    }

    public void setDviderRectWidth(int i) {
        this.afI = i;
    }

    public void setDviderRectHeight(int i) {
        this.afH = i;
    }

    public void setDiverColor(int i) {
        this.afK = i;
    }
}
