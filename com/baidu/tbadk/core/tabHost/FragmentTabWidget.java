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
    private int aeI;
    private int aeJ;
    private a aeK;
    private c aeL;
    private final Rect aeM;
    private final Rect aeN;
    private final Rect aeO;
    private int aeP;
    private int aeQ;
    private int aeR;
    private int aeS;
    private int aeT;
    private int aeU;
    private boolean aeV;
    private boolean aeW;
    private boolean aeX;
    private int aeY;
    private boolean aeZ;
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
        this.aeJ = -1;
        this.aeM = new Rect();
        this.aeN = new Rect();
        this.aeO = new Rect();
        this.mPaint = new Paint();
        this.aeS = 0;
        this.aeV = true;
        this.aeW = false;
        this.aeX = false;
        this.aeZ = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeJ = -1;
        this.aeM = new Rect();
        this.aeN = new Rect();
        this.aeO = new Rect();
        this.mPaint = new Paint();
        this.aeS = 0;
        this.aeV = true;
        this.aeW = false;
        this.aeX = false;
        this.aeZ = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aeP = getResources().getDimensionPixelSize(d.e.ds1);
        this.aeQ = l.dip2px(getContext(), 1.0f);
        this.aeR = l.dip2px(getContext(), 2.0f);
        this.aeY = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.aeI = d.C0095d.common_color_10274;
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
            if (this.aeJ != i) {
                if (this.aeJ != -1) {
                    getChildAt(this.aeJ).setSelected(false);
                }
                this.aeJ = i;
                getChildAt(this.aeJ).setSelected(true);
                if (z) {
                    b(this.aeJ, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aeL != null) {
            this.aeL.onSizeChanged(i, i2, i3, i4);
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
        if (this.aeZ) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aeX) {
            view.setPadding(0, 0, 0, this.aeY);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.aeJ = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aeU = this.mWidth / this.mChildCount;
            if (this.aeJ != -1) {
                b(this.aeJ, 0.0f);
            }
            int i5 = this.mHeight - this.aeP;
            this.aeN.set(0, i5, this.mWidth, this.aeP + i5);
            this.aeO.set(0, 0, this.mWidth, this.aeQ);
        }
    }

    public void b(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.aeU - dimensionPixelSize) / 2;
        this.left = this.aeU * i;
        this.left += (int) (this.aeU * f);
        int i3 = this.mHeight - this.aeR;
        if (this.aeS == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof e)) {
                View contentTv = ((e) childAt).getContentTv();
                if (contentTv != null) {
                    this.aeM.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aeM.set((this.left + (this.aeU / 2)) - (this.aeS / 2), i3, this.left + (this.aeU / 2) + (this.aeS / 2), this.mHeight);
                }
            } else {
                this.aeM.set((this.left + (this.aeU / 2)) - (this.aeS / 2), i3, this.left + (this.aeU / 2) + (this.aeS / 2), this.mHeight);
            }
        } else if (this.aeS != 0) {
            this.aeM.set((this.left + (this.aeU / 2)) - (this.aeS / 2), i3, this.left + (this.aeU / 2) + (this.aeS / 2), this.mHeight);
        } else {
            this.aeM.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aeI = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aeI != 0) {
            aj.k(this, this.aeI);
        }
        this.aeT = aj.getColor(d.C0095d.cp_cont_b);
        this.mDividerColor = aj.getColor(d.C0095d.cp_bg_line_c);
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
        canvas.drawRect(this.aeN, this.mPaint);
        if (this.aeW) {
            canvas.drawRect(this.aeO, this.mPaint);
        }
        if (this.aeV) {
            this.mPaint.setColor(this.aeT);
            canvas.drawRoundRect(new RectF(this.aeM), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aeV = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aeW = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aeK = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aeL = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int afa;

        private b(int i) {
            this.afa = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aeK.e(this.afa, true);
        }
    }

    public void ay(boolean z) {
        this.aeX = z;
    }

    public void setDviderRectWidth(int i) {
        this.aeS = i;
    }

    public void setDviderRectHeight(int i) {
        this.aeR = i;
    }

    public void setDiverColor(int i) {
        this.aeT = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aeZ = z;
    }
}
