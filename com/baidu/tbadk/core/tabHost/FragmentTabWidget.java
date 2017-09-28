package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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
    private int aeg;
    private int aeh;
    private a aei;
    private c aej;
    private final Rect aek;
    private final Rect ael;
    private final Rect aem;
    private int aen;
    private int aeo;
    private int aep;
    private int aeq;
    private int aer;
    private int aes;
    private int aet;
    private boolean aeu;
    private boolean aev;
    private boolean aew;
    private int aex;
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
        this.aeh = -1;
        this.aek = new Rect();
        this.ael = new Rect();
        this.aem = new Rect();
        this.mPaint = new Paint();
        this.aeq = 0;
        this.aeu = true;
        this.aev = false;
        this.aew = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeh = -1;
        this.aek = new Rect();
        this.ael = new Rect();
        this.aem = new Rect();
        this.mPaint = new Paint();
        this.aeq = 0;
        this.aeu = true;
        this.aev = false;
        this.aew = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aen = getResources().getDimensionPixelSize(d.f.ds1);
        this.aeo = l.dip2px(getContext(), 1.0f);
        this.aep = l.dip2px(getContext(), 3.0f);
        this.aex = getResources().getDimensionPixelSize(d.f.ds10);
        setWillNotDraw(false);
        this.aeg = d.e.common_color_10274;
    }

    public void a(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    e eVar = (e) getChildAt(i2);
                    eVar.setCheckDescriptionText(i == i2);
                    eVar.bQ(i == i2);
                    i2++;
                }
            }
            if (this.aeh != i) {
                if (this.aeh != -1) {
                    getChildAt(this.aeh).setSelected(false);
                }
                this.aeh = i;
                getChildAt(this.aeh).setSelected(true);
                if (z) {
                    a(this.aeh, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aej != null) {
            this.aej.onSizeChanged(i, i2, i3, i4);
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
        if (this.aew) {
            view.setPadding(0, 0, 0, this.aex);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.aeh = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aet = this.mWidth / this.mChildCount;
            if (this.aeh != -1) {
                a(this.aeh, 0.0f);
            }
            int i5 = this.mHeight - this.aen;
            this.ael.set(0, i5, this.mWidth, this.aen + i5);
            this.aem.set(0, 0, this.mWidth, this.aeo);
        }
    }

    public void a(int i, float f) {
        this.left = this.aet * i;
        this.left += (int) (this.aet * f);
        int i2 = this.mHeight - this.aep;
        if (this.aeq == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof e)) {
                View contentTv = ((e) childAt).getContentTv();
                if (contentTv != null) {
                    this.aek.set(childAt.getLeft() + contentTv.getLeft(), i2, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.aek.set((this.left + (this.aet / 2)) - (this.aeq / 2), i2, this.left + (this.aet / 2) + (this.aeq / 2), this.mHeight);
                }
            } else {
                this.aek.set((this.left + (this.aet / 2)) - (this.aeq / 2), i2, this.left + (this.aet / 2) + (this.aeq / 2), this.mHeight);
            }
        } else if (this.aeq != 0) {
            this.aek.set((this.left + (this.aet / 2)) - (this.aeq / 2), i2, this.left + (this.aet / 2) + (this.aeq / 2), this.mHeight);
        } else {
            this.aek.set(this.left, i2, this.left + this.aet, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aeg = i;
    }

    public void onChangeSkinType(int i) {
        if (this.aeg != 0) {
            aj.k(this, this.aeg);
        }
        if (this.aes == 0) {
            this.aes = aj.getColor(d.e.cp_link_tip_a);
        }
        this.aer = aj.getColor(d.e.cp_bg_line_c);
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
        this.mPaint.setColor(this.aer);
        canvas.drawRect(this.ael, this.mPaint);
        if (this.aev) {
            canvas.drawRect(this.aem, this.mPaint);
        }
        if (this.aeu) {
            this.mPaint.setColor(this.aes);
            canvas.drawRect(this.aek, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aeu = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aev = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aei = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aej = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aey;

        private b(int i) {
            this.aey = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aei.e(this.aey, true);
        }
    }

    public void aB(boolean z) {
        this.aew = z;
    }

    public void setDviderRectWidth(int i) {
        this.aeq = i;
    }

    public void setDviderRectHeight(int i) {
        this.aep = i;
    }

    public void setDiverColor(int i) {
        this.aes = i;
    }
}
