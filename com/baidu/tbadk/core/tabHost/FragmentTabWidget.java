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
    private int aeA;
    private int aeB;
    private int aeC;
    private boolean aeD;
    private boolean aeE;
    private boolean aeF;
    private int aeG;
    private int aeq;
    private int aer;
    private a aes;
    private c aet;
    private final Rect aeu;
    private final Rect aev;
    private final Rect aew;
    private int aex;
    private int aey;
    private int aez;
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
        this.aer = -1;
        this.aeu = new Rect();
        this.aev = new Rect();
        this.aew = new Rect();
        this.mPaint = new Paint();
        this.aeA = 0;
        this.aeD = true;
        this.aeE = false;
        this.aeF = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aer = -1;
        this.aeu = new Rect();
        this.aev = new Rect();
        this.aew = new Rect();
        this.mPaint = new Paint();
        this.aeA = 0;
        this.aeD = true;
        this.aeE = false;
        this.aeF = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aex = getResources().getDimensionPixelSize(d.e.ds1);
        this.aey = l.dip2px(getContext(), 1.0f);
        this.aez = l.dip2px(getContext(), 2.0f);
        this.aeG = getResources().getDimensionPixelSize(d.e.ds10);
        setWillNotDraw(false);
        this.aeq = d.C0080d.common_color_10274;
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
            if (this.aer != i) {
                if (this.aer != -1) {
                    getChildAt(this.aer).setSelected(false);
                }
                this.aer = i;
                getChildAt(this.aer).setSelected(true);
                if (z) {
                    b(this.aer, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aet != null) {
            this.aet.onSizeChanged(i, i2, i3, i4);
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
        if (this.aeF) {
            view.setPadding(0, 0, 0, this.aeG);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.aer = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aeC = this.mWidth / this.mChildCount;
            if (this.aer != -1) {
                b(this.aer, 0.0f);
            }
            int i5 = this.mHeight - this.aex;
            this.aev.set(0, i5, this.mWidth, this.aex + i5);
            this.aew.set(0, 0, this.mWidth, this.aey);
        }
    }

    public void b(int i, float f) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
        int i2 = (this.aeC - dimensionPixelSize) / 2;
        this.left = this.aeC * i;
        this.left += (int) (this.aeC * f);
        int i3 = this.mHeight - this.aez;
        if (this.aeA == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof e)) {
                View contentTv = ((e) childAt).getContentTv();
                if (contentTv != null) {
                    this.aeu.set(childAt.getLeft() + contentTv.getLeft(), i3, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aeu.set((this.left + (this.aeC / 2)) - (this.aeA / 2), i3, this.left + (this.aeC / 2) + (this.aeA / 2), this.mHeight);
                }
            } else {
                this.aeu.set((this.left + (this.aeC / 2)) - (this.aeA / 2), i3, this.left + (this.aeC / 2) + (this.aeA / 2), this.mHeight);
            }
        } else if (this.aeA != 0) {
            this.aeu.set((this.left + (this.aeC / 2)) - (this.aeA / 2), i3, this.left + (this.aeC / 2) + (this.aeA / 2), this.mHeight);
        } else {
            this.aeu.set(this.left + i2, i3, dimensionPixelSize + i2 + this.left, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aeq = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aeq != 0) {
            aj.k(this, this.aeq);
        }
        if (this.aeB == 0) {
            this.aeB = aj.getColor(d.C0080d.cp_cont_b);
        }
        this.mDividerColor = aj.getColor(d.C0080d.cp_bg_line_c);
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
        canvas.drawRect(this.aev, this.mPaint);
        if (this.aeE) {
            canvas.drawRect(this.aew, this.mPaint);
        }
        if (this.aeD) {
            this.mPaint.setColor(this.aeB);
            canvas.drawRoundRect(new RectF(this.aeu), 10.0f, 10.0f, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aeD = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aeE = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aes = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aet = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aeH;

        private b(int i) {
            this.aeH = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aes.e(this.aeH, true);
        }
    }

    public void ay(boolean z) {
        this.aeF = z;
    }

    public void setDviderRectWidth(int i) {
        this.aeA = i;
    }

    public void setDviderRectHeight(int i) {
        this.aez = i;
    }

    public void setDiverColor(int i) {
        this.aeB = i;
    }
}
