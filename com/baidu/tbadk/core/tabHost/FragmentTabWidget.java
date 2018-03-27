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
    private int TM;
    private int aUA;
    private int aUB;
    private int aUC;
    private boolean aUD;
    private boolean aUE;
    private boolean aUF;
    private int aUG;
    private boolean aUH;
    private int aUr;
    private a aUs;
    private c aUt;
    private final Rect aUu;
    private final Rect aUv;
    private final Rect aUw;
    private int aUx;
    private int aUy;
    private int aUz;
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
        this.TM = -1;
        this.aUu = new Rect();
        this.aUv = new Rect();
        this.aUw = new Rect();
        this.mPaint = new Paint();
        this.aUA = 0;
        this.aUD = true;
        this.aUE = false;
        this.aUF = false;
        this.aUH = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TM = -1;
        this.aUu = new Rect();
        this.aUv = new Rect();
        this.aUw = new Rect();
        this.mPaint = new Paint();
        this.aUA = 0;
        this.aUD = true;
        this.aUE = false;
        this.aUF = false;
        this.aUH = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aUx = getResources().getDimensionPixelSize(d.e.ds1);
        this.aUy = l.dip2px(getContext(), 1.0f);
        this.aUz = l.dip2px(getContext(), 2.0f);
        this.aUG = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.aUr = d.C0141d.common_color_10274;
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
            if (this.TM != i) {
                if (this.TM != -1) {
                    getChildAt(this.TM).setSelected(false);
                }
                this.TM = i;
                getChildAt(this.TM).setSelected(true);
                if (z) {
                    g(this.TM, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aUt != null) {
            this.aUt.onSizeChanged(i, i2, i3, i4);
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
        if (this.aUH) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.aUF) {
            view.setPadding(0, 0, 0, this.aUG);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.TM = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aUC = this.mWidth / this.mChildCount;
            if (this.TM != -1) {
                g(this.TM, 0.0f);
            }
            int i5 = this.mHeight - this.aUx;
            this.aUv.set(0, i5, this.mWidth, this.aUx + i5);
            this.aUw.set(0, 0, this.mWidth, this.aUy);
        }
    }

    public void g(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.aUC - dimensionPixelSize) / 2;
        this.left = this.aUC * i;
        this.left += (int) (this.aUC * f);
        int i3 = this.mHeight - this.aUz;
        if (this.aUA == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof e)) {
                View contentTv = ((e) childAt).getContentTv();
                if (contentTv != null) {
                    this.aUu.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aUu.set((this.left + (this.aUC / 2)) - (this.aUA / 2), i3, this.left + (this.aUC / 2) + (this.aUA / 2), this.mHeight);
                }
            } else {
                this.aUu.set((this.left + (this.aUC / 2)) - (this.aUA / 2), i3, this.left + (this.aUC / 2) + (this.aUA / 2), this.mHeight);
            }
        } else if (this.aUA != 0) {
            this.aUu.set((this.left + (this.aUC / 2)) - (this.aUA / 2), i3, this.left + (this.aUC / 2) + (this.aUA / 2), this.mHeight);
        } else {
            this.aUu.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aUr = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aUr != 0) {
            aj.t(this, this.aUr);
        }
        this.aUB = aj.getColor(d.C0141d.cp_cont_b);
        this.mDividerColor = aj.getColor(d.C0141d.cp_bg_line_c);
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
        canvas.drawRect(this.aUv, this.mPaint);
        if (this.aUE) {
            canvas.drawRect(this.aUw, this.mPaint);
        }
        if (this.aUD) {
            this.mPaint.setColor(this.aUB);
            canvas.drawRoundRect(new RectF(this.aUu), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aUD = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aUE = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aUs = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aUt = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aUI;

        private b(int i) {
            this.aUI = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aUs.u(this.aUI, true);
        }
    }

    public void bk(boolean z) {
        this.aUF = z;
    }

    public void setDviderRectWidth(int i) {
        this.aUA = i;
    }

    public void setDviderRectHeight(int i) {
        this.aUz = i;
    }

    public void setDiverColor(int i) {
        this.aUB = i;
    }

    public void setAbsoluteWeight(boolean z) {
        this.aUH = z;
    }
}
