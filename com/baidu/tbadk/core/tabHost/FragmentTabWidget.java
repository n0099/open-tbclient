package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int adg;
    private int adh;
    private a adi;
    private c adj;
    private final Rect adk;
    private final Rect adl;
    private final Rect adm;
    private int adn;
    private int ado;
    private int adp;
    private int adq;
    private int adr;
    private int ads;
    private int adt;
    private boolean adu;
    private boolean adv;
    private boolean adw;
    private int adx;
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
        this.adh = -1;
        this.adk = new Rect();
        this.adl = new Rect();
        this.adm = new Rect();
        this.mPaint = new Paint();
        this.adq = 0;
        this.adu = true;
        this.adv = false;
        this.adw = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adh = -1;
        this.adk = new Rect();
        this.adl = new Rect();
        this.adm = new Rect();
        this.mPaint = new Paint();
        this.adq = 0;
        this.adu = true;
        this.adv = false;
        this.adw = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.adn = getResources().getDimensionPixelSize(w.f.ds1);
        this.ado = k.dip2px(getContext(), 1.0f);
        this.adp = k.dip2px(getContext(), 3.0f);
        this.adx = getResources().getDimensionPixelSize(w.f.ds10);
        setWillNotDraw(false);
        this.adg = w.e.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.adh != i) {
                if (this.adh != -1) {
                    getChildAt(this.adh).setSelected(false);
                }
                this.adh = i;
                getChildAt(this.adh).setSelected(true);
                if (z) {
                    b(this.adh, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.adj != null) {
            this.adj.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        x(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        x(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void x(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.adw) {
            view.setPadding(0, 0, 0, this.adx);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.adh = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.adt = this.mWidth / this.mChildCount;
            if (this.adh != -1) {
                b(this.adh, 0.0f);
            }
            int i5 = this.mHeight - this.adn;
            this.adl.set(0, i5, this.mWidth, this.adn + i5);
            this.adm.set(0, 0, this.mWidth, this.ado);
        }
    }

    public void b(int i, float f) {
        this.left = this.adt * i;
        this.left += (int) (this.adt * f);
        int i2 = this.mHeight - this.adp;
        if (this.adq != 0) {
            this.adk.set((this.left + (this.adt / 2)) - (this.adq / 2), i2, this.left + (this.adt / 2) + (this.adq / 2), this.mHeight);
        } else {
            this.adk.set(this.left, i2, this.left + this.adt, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.adg = i;
    }

    public void onChangeSkinType(int i) {
        if (this.adg != 0) {
            aq.k(this, this.adg);
        }
        this.ads = aq.getColor(w.e.cp_link_tip_a);
        this.adr = aq.getColor(w.e.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dm(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.adr);
        canvas.drawRect(this.adl, this.mPaint);
        if (this.adv) {
            canvas.drawRect(this.adm, this.mPaint);
        }
        if (this.adu) {
            this.mPaint.setColor(this.ads);
            canvas.drawRect(this.adk, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.adu = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.adv = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.adi = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.adj = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int ady;

        private b(int i) {
            this.ady = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.adi.f(this.ady, true);
        }
    }

    public void aC(boolean z) {
        this.adw = z;
    }

    public void setDviderRectWidth(int i) {
        this.adq = i;
    }
}
