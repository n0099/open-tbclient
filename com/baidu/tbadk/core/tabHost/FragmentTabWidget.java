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
    private int afA;
    private int afB;
    private a afC;
    private c afD;
    private final Rect afE;
    private final Rect afF;
    private final Rect afG;
    private int afH;
    private int afI;
    private int afJ;
    private int afK;
    private int afL;
    private int afM;
    private int afN;
    private boolean afO;
    private boolean afP;
    private boolean afQ;
    private int afR;
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
        this.afB = -1;
        this.afE = new Rect();
        this.afF = new Rect();
        this.afG = new Rect();
        this.mPaint = new Paint();
        this.afK = 0;
        this.afO = true;
        this.afP = false;
        this.afQ = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afB = -1;
        this.afE = new Rect();
        this.afF = new Rect();
        this.afG = new Rect();
        this.mPaint = new Paint();
        this.afK = 0;
        this.afO = true;
        this.afP = false;
        this.afQ = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.afH = getResources().getDimensionPixelSize(d.f.ds1);
        this.afI = k.dip2px(getContext(), 1.0f);
        this.afJ = k.dip2px(getContext(), 3.0f);
        this.afR = getResources().getDimensionPixelSize(d.f.ds10);
        setWillNotDraw(false);
        this.afA = d.e.common_color_10274;
    }

    public void h(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.afB != i) {
                if (this.afB != -1) {
                    getChildAt(this.afB).setSelected(false);
                }
                this.afB = i;
                getChildAt(this.afB).setSelected(true);
                if (z) {
                    b(this.afB, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.afD != null) {
            this.afD.onSizeChanged(i, i2, i3, i4);
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
        if (this.afQ) {
            view.setPadding(0, 0, 0, this.afR);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.afB = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.afN = this.mWidth / this.mChildCount;
            if (this.afB != -1) {
                b(this.afB, 0.0f);
            }
            int i5 = this.mHeight - this.afH;
            this.afF.set(0, i5, this.mWidth, this.afH + i5);
            this.afG.set(0, 0, this.mWidth, this.afI);
        }
    }

    public void b(int i, float f) {
        this.left = this.afN * i;
        this.left += (int) (this.afN * f);
        int i2 = this.mHeight - this.afJ;
        if (this.afK == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof FragmentTabIndicator)) {
                TextView contentTv = ((FragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.afE.set(childAt.getLeft() + contentTv.getLeft(), i2, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.afE.set((this.left + (this.afN / 2)) - (this.afK / 2), i2, this.left + (this.afN / 2) + (this.afK / 2), this.mHeight);
                }
            } else {
                this.afE.set((this.left + (this.afN / 2)) - (this.afK / 2), i2, this.left + (this.afN / 2) + (this.afK / 2), this.mHeight);
            }
        } else if (this.afK != 0) {
            this.afE.set((this.left + (this.afN / 2)) - (this.afK / 2), i2, this.left + (this.afN / 2) + (this.afK / 2), this.mHeight);
        } else {
            this.afE.set(this.left, i2, this.left + this.afN, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.afA = i;
    }

    public void onChangeSkinType(int i) {
        if (this.afA != 0) {
            ai.k(this, this.afA);
        }
        if (this.afM == 0) {
            this.afM = ai.getColor(d.e.cp_link_tip_a);
        }
        this.afL = ai.getColor(d.e.cp_bg_line_c);
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
        this.mPaint.setColor(this.afL);
        canvas.drawRect(this.afF, this.mPaint);
        if (this.afP) {
            canvas.drawRect(this.afG, this.mPaint);
        }
        if (this.afO) {
            this.mPaint.setColor(this.afM);
            canvas.drawRect(this.afE, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.afO = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.afP = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.afC = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.afD = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int afS;

        private b(int i) {
            this.afS = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.afC.f(this.afS, true);
        }
    }

    public void aB(boolean z) {
        this.afQ = z;
    }

    public void setDviderRectWidth(int i) {
        this.afK = i;
    }

    public void setDviderRectHeight(int i) {
        this.afJ = i;
    }

    public void setDiverColor(int i) {
        this.afM = i;
    }
}
