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
    private int aeL;
    private int aeM;
    private a aeN;
    private c aeO;
    private final Rect aeP;
    private final Rect aeQ;
    private final Rect aeR;
    private int aeS;
    private int aeT;
    private int aeU;
    private int aeV;
    private int aeW;
    private int aeX;
    private boolean aeY;
    private boolean aeZ;
    private boolean afa;
    private int afb;
    private boolean afc;
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
        this.aeM = -1;
        this.aeP = new Rect();
        this.aeQ = new Rect();
        this.aeR = new Rect();
        this.mPaint = new Paint();
        this.aeV = 0;
        this.aeY = true;
        this.aeZ = false;
        this.afa = false;
        this.afc = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeM = -1;
        this.aeP = new Rect();
        this.aeQ = new Rect();
        this.aeR = new Rect();
        this.mPaint = new Paint();
        this.aeV = 0;
        this.aeY = true;
        this.aeZ = false;
        this.afa = false;
        this.afc = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aeS = getResources().getDimensionPixelSize(d.e.ds1);
        this.aeT = l.dip2px(getContext(), 1.0f);
        this.aeU = l.dip2px(getContext(), 2.0f);
        this.afb = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.aeL = d.C0082d.common_color_10274;
    }

    public void a(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    e eVar = (e) getChildAt(i2);
                    eVar.setCheckDescriptionText(i == i2);
                    eVar.bK(i == i2);
                    i2++;
                }
            }
            if (this.aeM != i) {
                if (this.aeM != -1) {
                    getChildAt(this.aeM).setSelected(false);
                }
                this.aeM = i;
                getChildAt(this.aeM).setSelected(true);
                if (z) {
                    b(this.aeM, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aeO != null) {
            this.aeO.onSizeChanged(i, i2, i3, i4);
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
        if (this.afc) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.afa) {
            view.setPadding(0, 0, 0, this.afb);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.aeM = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aeX = this.mWidth / this.mChildCount;
            if (this.aeM != -1) {
                b(this.aeM, 0.0f);
            }
            int i5 = this.mHeight - this.aeS;
            this.aeQ.set(0, i5, this.mWidth, this.aeS + i5);
            this.aeR.set(0, 0, this.mWidth, this.aeT);
        }
    }

    public void b(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.aeX - dimensionPixelSize) / 2;
        this.left = this.aeX * i;
        this.left += (int) (this.aeX * f);
        int i3 = this.mHeight - this.aeU;
        if (this.aeV == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof e)) {
                View contentTv = ((e) childAt).getContentTv();
                if (contentTv != null) {
                    this.aeP.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aeP.set((this.left + (this.aeX / 2)) - (this.aeV / 2), i3, this.left + (this.aeX / 2) + (this.aeV / 2), this.mHeight);
                }
            } else {
                this.aeP.set((this.left + (this.aeX / 2)) - (this.aeV / 2), i3, this.left + (this.aeX / 2) + (this.aeV / 2), this.mHeight);
            }
        } else if (this.aeV != 0) {
            this.aeP.set((this.left + (this.aeX / 2)) - (this.aeV / 2), i3, this.left + (this.aeX / 2) + (this.aeV / 2), this.mHeight);
        } else {
            this.aeP.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aeL = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aeL != 0) {
            aj.k(this, this.aeL);
        }
        this.aeW = aj.getColor(d.C0082d.cp_cont_b);
        this.mDividerColor = aj.getColor(d.C0082d.cp_bg_line_c);
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
        canvas.drawRect(this.aeQ, this.mPaint);
        if (this.aeZ) {
            canvas.drawRect(this.aeR, this.mPaint);
        }
        if (this.aeY) {
            this.mPaint.setColor(this.aeW);
            canvas.drawRoundRect(new RectF(this.aeP), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aeY = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aeZ = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aeN = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aeO = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int afd;

        private b(int i) {
            this.afd = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aeN.e(this.afd, true);
        }
    }

    public void ay(boolean z) {
        this.afa = z;
    }

    public void setDviderRectWidth(int i) {
        this.aeV = i;
    }

    public void setDviderRectHeight(int i) {
        this.aeU = i;
    }

    public void setDiverColor(int i) {
        this.aeW = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.afc = z;
    }
}
