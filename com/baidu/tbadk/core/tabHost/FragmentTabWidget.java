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
    private int aed;
    private int aee;
    private a aef;
    private c aeg;
    private final Rect aeh;
    private final Rect aei;
    private final Rect aej;
    private int aek;
    private int ael;
    private int aem;
    private int aen;
    private int aeo;
    private int aep;
    private int aeq;
    private boolean aer;
    private boolean aes;
    private boolean aet;
    private int aeu;
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
        this.aee = -1;
        this.aeh = new Rect();
        this.aei = new Rect();
        this.aej = new Rect();
        this.mPaint = new Paint();
        this.aen = 0;
        this.aer = true;
        this.aes = false;
        this.aet = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aee = -1;
        this.aeh = new Rect();
        this.aei = new Rect();
        this.aej = new Rect();
        this.mPaint = new Paint();
        this.aen = 0;
        this.aer = true;
        this.aes = false;
        this.aet = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aek = getResources().getDimensionPixelSize(d.f.ds1);
        this.ael = k.dip2px(getContext(), 1.0f);
        this.aem = k.dip2px(getContext(), 3.0f);
        this.aeu = getResources().getDimensionPixelSize(d.f.ds10);
        setWillNotDraw(false);
        this.aed = d.e.common_color_10274;
    }

    public void h(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.aee != i) {
                if (this.aee != -1) {
                    getChildAt(this.aee).setSelected(false);
                }
                this.aee = i;
                getChildAt(this.aee).setSelected(true);
                if (z) {
                    b(this.aee, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aeg != null) {
            this.aeg.onSizeChanged(i, i2, i3, i4);
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
        if (this.aet) {
            view.setPadding(0, 0, 0, this.aeu);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.aee = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aeq = this.mWidth / this.mChildCount;
            if (this.aee != -1) {
                b(this.aee, 0.0f);
            }
            int i5 = this.mHeight - this.aek;
            this.aei.set(0, i5, this.mWidth, this.aek + i5);
            this.aej.set(0, 0, this.mWidth, this.ael);
        }
    }

    public void b(int i, float f) {
        this.left = this.aeq * i;
        this.left += (int) (this.aeq * f);
        int i2 = this.mHeight - this.aem;
        if (this.aen == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof FragmentTabIndicator)) {
                TextView contentTv = ((FragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.aeh.set(childAt.getLeft() + contentTv.getLeft(), i2, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aeh.set((this.left + (this.aeq / 2)) - (this.aen / 2), i2, this.left + (this.aeq / 2) + (this.aen / 2), this.mHeight);
                }
            } else {
                this.aeh.set((this.left + (this.aeq / 2)) - (this.aen / 2), i2, this.left + (this.aeq / 2) + (this.aen / 2), this.mHeight);
            }
        } else if (this.aen != 0) {
            this.aeh.set((this.left + (this.aeq / 2)) - (this.aen / 2), i2, this.left + (this.aeq / 2) + (this.aen / 2), this.mHeight);
        } else {
            this.aeh.set(this.left, i2, this.left + this.aeq, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aed = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aed != 0) {
            ai.k(this, this.aed);
        }
        if (this.aep == 0) {
            this.aep = ai.getColor(d.e.cp_link_tip_a);
        }
        this.aeo = ai.getColor(d.e.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dr(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.aeo);
        canvas.drawRect(this.aei, this.mPaint);
        if (this.aes) {
            canvas.drawRect(this.aej, this.mPaint);
        }
        if (this.aer) {
            this.mPaint.setColor(this.aep);
            canvas.drawRect(this.aeh, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aer = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aes = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aef = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aeg = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aev;

        private b(int i) {
            this.aev = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aef.f(this.aev, true);
        }
    }

    public void aB(boolean z) {
        this.aet = z;
    }

    public void setDviderRectWidth(int i) {
        this.aen = i;
    }

    public void setDviderRectHeight(int i) {
        this.aem = i;
    }

    public void setDiverColor(int i) {
        this.aep = i;
    }
}
