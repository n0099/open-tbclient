package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int aeJ;
    private int aeK;
    private a aeL;
    private c aeM;
    private final Rect aeN;
    private final Rect aeO;
    private final Rect aeP;
    private int aeQ;
    private int aeR;
    private int aeS;
    private int aeT;
    private int aeU;
    private int aeV;
    private int aeW;
    private boolean aeX;
    private boolean aeY;
    private boolean aeZ;
    private int afa;
    private int left;
    private int mChildCount;
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
        this.aeK = -1;
        this.aeN = new Rect();
        this.aeO = new Rect();
        this.aeP = new Rect();
        this.mPaint = new Paint();
        this.aeT = 0;
        this.aeX = true;
        this.aeY = false;
        this.aeZ = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeK = -1;
        this.aeN = new Rect();
        this.aeO = new Rect();
        this.aeP = new Rect();
        this.mPaint = new Paint();
        this.aeT = 0;
        this.aeX = true;
        this.aeY = false;
        this.aeZ = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aeQ = getResources().getDimensionPixelSize(d.f.ds1);
        this.aeR = k.dip2px(getContext(), 1.0f);
        this.aeS = k.dip2px(getContext(), 3.0f);
        this.afa = getResources().getDimensionPixelSize(d.f.ds10);
        setWillNotDraw(false);
        this.aeJ = d.e.common_color_10274;
    }

    public void a(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    e eVar = (e) getChildAt(i2);
                    eVar.setCheckDescriptionText(i == i2);
                    eVar.bR(i == i2);
                    i2++;
                }
            }
            if (this.aeK != i) {
                if (this.aeK != -1) {
                    getChildAt(this.aeK).setSelected(false);
                }
                this.aeK = i;
                getChildAt(this.aeK).setSelected(true);
                if (z) {
                    a(this.aeK, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aeM != null) {
            this.aeM.onSizeChanged(i, i2, i3, i4);
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
        if (this.aeZ) {
            view.setPadding(0, 0, 0, this.afa);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.aeK = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aeW = this.mWidth / this.mChildCount;
            if (this.aeK != -1) {
                a(this.aeK, 0.0f);
            }
            int i5 = this.mHeight - this.aeQ;
            this.aeO.set(0, i5, this.mWidth, this.aeQ + i5);
            this.aeP.set(0, 0, this.mWidth, this.aeR);
        }
    }

    public void a(int i, float f) {
        this.left = this.aeW * i;
        this.left += (int) (this.aeW * f);
        int i2 = this.mHeight - this.aeS;
        if (this.aeT == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof e)) {
                View contentTv = ((e) childAt).getContentTv();
                if (contentTv != null) {
                    this.aeN.set(childAt.getLeft() + contentTv.getLeft(), i2, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aeN.set((this.left + (this.aeW / 2)) - (this.aeT / 2), i2, this.left + (this.aeW / 2) + (this.aeT / 2), this.mHeight);
                }
            } else {
                this.aeN.set((this.left + (this.aeW / 2)) - (this.aeT / 2), i2, this.left + (this.aeW / 2) + (this.aeT / 2), this.mHeight);
            }
        } else if (this.aeT != 0) {
            this.aeN.set((this.left + (this.aeW / 2)) - (this.aeT / 2), i2, this.left + (this.aeW / 2) + (this.aeT / 2), this.mHeight);
        } else {
            this.aeN.set(this.left, i2, this.left + this.aeW, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aeJ = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aeJ != 0) {
            aj.k(this, this.aeJ);
        }
        if (this.aeV == 0) {
            this.aeV = aj.getColor(d.e.cp_link_tip_a);
        }
        this.aeU = aj.getColor(d.e.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).du(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.aeU);
        canvas.drawRect(this.aeO, this.mPaint);
        if (this.aeY) {
            canvas.drawRect(this.aeP, this.mPaint);
        }
        if (this.aeX) {
            this.mPaint.setColor(this.aeV);
            canvas.drawRect(this.aeN, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aeX = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aeY = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aeL = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aeM = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int afb;

        private b(int i) {
            this.afb = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aeL.e(this.afb, true);
        }
    }

    public void aB(boolean z) {
        this.aeZ = z;
    }

    public void setDviderRectWidth(int i) {
        this.aeT = i;
    }

    public void setDviderRectHeight(int i) {
        this.aeS = i;
    }

    public void setDiverColor(int i) {
        this.aeV = i;
    }
}
