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
    private int acX;
    private int acY;
    private a acZ;
    private c ada;
    private final Rect adb;
    private final Rect adc;
    private final Rect ade;
    private int adf;
    private int adg;
    private int adh;
    private int adi;
    private int adj;
    private int adk;
    private int adl;
    private boolean adm;
    private boolean adn;
    private boolean ado;
    private int adp;
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
        this.acY = -1;
        this.adb = new Rect();
        this.adc = new Rect();
        this.ade = new Rect();
        this.mPaint = new Paint();
        this.adi = 0;
        this.adm = true;
        this.adn = false;
        this.ado = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acY = -1;
        this.adb = new Rect();
        this.adc = new Rect();
        this.ade = new Rect();
        this.mPaint = new Paint();
        this.adi = 0;
        this.adm = true;
        this.adn = false;
        this.ado = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.adf = getResources().getDimensionPixelSize(w.f.ds1);
        this.adg = k.dip2px(getContext(), 1.0f);
        this.adh = k.dip2px(getContext(), 3.0f);
        this.adp = getResources().getDimensionPixelSize(w.f.ds10);
        setWillNotDraw(false);
        this.acX = w.e.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.acY != i) {
                if (this.acY != -1) {
                    getChildAt(this.acY).setSelected(false);
                }
                this.acY = i;
                getChildAt(this.acY).setSelected(true);
                if (z) {
                    b(this.acY, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.ada != null) {
            this.ada.onSizeChanged(i, i2, i3, i4);
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
        if (this.ado) {
            view.setPadding(0, 0, 0, this.adp);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.acY = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.adl = this.mWidth / this.mChildCount;
            if (this.acY != -1) {
                b(this.acY, 0.0f);
            }
            int i5 = this.mHeight - this.adf;
            this.adc.set(0, i5, this.mWidth, this.adf + i5);
            this.ade.set(0, 0, this.mWidth, this.adg);
        }
    }

    public void b(int i, float f) {
        this.left = this.adl * i;
        this.left += (int) (this.adl * f);
        int i2 = this.mHeight - this.adh;
        if (this.adi != 0) {
            this.adb.set((this.left + (this.adl / 2)) - (this.adi / 2), i2, this.left + (this.adl / 2) + (this.adi / 2), this.mHeight);
        } else {
            this.adb.set(this.left, i2, this.left + this.adl, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.acX = i;
    }

    public void onChangeSkinType(int i) {
        if (this.acX != 0) {
            aq.k(this, this.acX);
        }
        if (this.adk == 0) {
            this.adk = aq.getColor(w.e.cp_link_tip_a);
        }
        this.adj = aq.getColor(w.e.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dn(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.adj);
        canvas.drawRect(this.adc, this.mPaint);
        if (this.adn) {
            canvas.drawRect(this.ade, this.mPaint);
        }
        if (this.adm) {
            this.mPaint.setColor(this.adk);
            canvas.drawRect(this.adb, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.adm = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.adn = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.acZ = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.ada = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int adq;

        private b(int i) {
            this.adq = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.acZ.f(this.adq, true);
        }
    }

    public void aB(boolean z) {
        this.ado = z;
    }

    public void setDviderRectWidth(int i) {
        this.adi = i;
    }

    public void setDiverColor(int i) {
        this.adk = i;
    }
}
