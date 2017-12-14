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
    private int aeF;
    private int aeG;
    private a aeH;
    private c aeI;
    private final Rect aeJ;
    private final Rect aeK;
    private final Rect aeL;
    private int aeM;
    private int aeN;
    private int aeO;
    private int aeP;
    private int aeQ;
    private int aeR;
    private boolean aeS;
    private boolean aeT;
    private boolean aeU;
    private int aeV;
    private boolean aeW;
    private int left;
    private int mChildCount;
    private int mDividerColor;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void e(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.aeG = -1;
        this.aeJ = new Rect();
        this.aeK = new Rect();
        this.aeL = new Rect();
        this.mPaint = new Paint();
        this.aeP = 0;
        this.aeS = true;
        this.aeT = false;
        this.aeU = false;
        this.aeW = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeG = -1;
        this.aeJ = new Rect();
        this.aeK = new Rect();
        this.aeL = new Rect();
        this.mPaint = new Paint();
        this.aeP = 0;
        this.aeS = true;
        this.aeT = false;
        this.aeU = false;
        this.aeW = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aeM = getResources().getDimensionPixelSize(d.e.ds1);
        this.aeN = l.dip2px(getContext(), 1.0f);
        this.aeO = l.dip2px(getContext(), 2.0f);
        this.aeV = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.aeF = d.C0096d.common_color_10274;
    }

    public void a(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    e eVar = (e) getChildAt(i2);
                    eVar.setCheckDescriptionText(i == i2);
                    eVar.bL(i == i2);
                    i2++;
                }
            }
            if (this.aeG != i) {
                if (this.aeG != -1) {
                    getChildAt(this.aeG).setSelected(false);
                }
                this.aeG = i;
                getChildAt(this.aeG).setSelected(true);
                if (z) {
                    b(this.aeG, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aeI != null) {
            this.aeI.onSizeChanged(i, i2, i3, i4);
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
        LinearLayout.LayoutParams layoutParams;
        if (this.aeW) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aeU) {
            view.setPadding(0, 0, 0, this.aeV);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.aeG = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aeR = this.mWidth / this.mChildCount;
            if (this.aeG != -1) {
                b(this.aeG, 0.0f);
            }
            int i5 = this.mHeight - this.aeM;
            this.aeK.set(0, i5, this.mWidth, this.aeM + i5);
            this.aeL.set(0, 0, this.mWidth, this.aeN);
        }
    }

    public void b(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.aeR - dimensionPixelSize) / 2;
        this.left = this.aeR * i;
        this.left += (int) (this.aeR * f);
        int i3 = this.mHeight - this.aeO;
        if (this.aeP == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof e)) {
                View contentTv = ((e) childAt).getContentTv();
                if (contentTv != null) {
                    this.aeJ.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aeJ.set((this.left + (this.aeR / 2)) - (this.aeP / 2), i3, this.left + (this.aeR / 2) + (this.aeP / 2), this.mHeight);
                }
            } else {
                this.aeJ.set((this.left + (this.aeR / 2)) - (this.aeP / 2), i3, this.left + (this.aeR / 2) + (this.aeP / 2), this.mHeight);
            }
        } else if (this.aeP != 0) {
            this.aeJ.set((this.left + (this.aeR / 2)) - (this.aeP / 2), i3, this.left + (this.aeR / 2) + (this.aeP / 2), this.mHeight);
        } else {
            this.aeJ.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aeF = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aeF != 0) {
            aj.k(this, this.aeF);
        }
        this.aeQ = aj.getColor(d.C0096d.cp_cont_b);
        this.mDividerColor = aj.getColor(d.C0096d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dE(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.mDividerColor);
        canvas.drawRect(this.aeK, this.mPaint);
        if (this.aeT) {
            canvas.drawRect(this.aeL, this.mPaint);
        }
        if (this.aeS) {
            this.mPaint.setColor(this.aeQ);
            canvas.drawRoundRect(new RectF(this.aeJ), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aeS = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aeT = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aeH = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aeI = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aeX;

        private b(int i) {
            this.aeX = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aeH.e(this.aeX, true);
        }
    }

    public void ay(boolean z) {
        this.aeU = z;
    }

    public void setDviderRectWidth(int i) {
        this.aeP = i;
    }

    public void setDviderRectHeight(int i) {
        this.aeO = i;
    }

    public void setDiverColor(int i) {
        this.aeQ = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aeW = z;
    }
}
