package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int aac;
    private int aad;
    private a aae;
    private c aaf;
    private final Rect aag;
    private final Rect aah;
    private int aai;
    private int aaj;
    private int aak;
    private int aal;
    private boolean aam;
    private int left;
    private int mChildCount;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.aad = -1;
        this.aag = new Rect();
        this.aah = new Rect();
        this.mPaint = new Paint();
        this.aam = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aad = -1;
        this.aag = new Rect();
        this.aah = new Rect();
        this.mPaint = new Paint();
        this.aam = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aai = k.dip2px(getContext(), 1.0f);
        this.aaj = k.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.aac = n.f.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.aad != i) {
            if (this.aad != -1) {
                getChildAt(this.aad).setSelected(false);
            }
            this.aad = i;
            getChildAt(this.aad).setSelected(true);
            if (z) {
                b(this.aad, 0.0f);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aaf != null) {
            this.aaf.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        o(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        o(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void o(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.aad = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aal = this.mWidth / this.mChildCount;
            if (this.aad != -1) {
                b(this.aad, 0.0f);
            }
            int i5 = this.mHeight - this.aai;
            this.aah.set(0, i5, this.mWidth, this.aai + i5);
        }
    }

    public void b(int i, float f) {
        this.left = this.aal * i;
        this.left += (int) (this.aal * f);
        this.aag.set(this.left, this.mHeight - this.aaj, this.left + this.aal, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aac = i;
    }

    public void onChangeSkinType(int i) {
        as.i(this, this.aac);
        this.aak = as.getColor(n.d.s_actionbar_text_line_color_s);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).cR(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.aam) {
            this.mPaint.setColor(this.aak);
            canvas.drawRect(this.aag, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aam = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aae = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aaf = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aan;

        private b(int i) {
            this.aan = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aae.c(this.aan, true);
        }
    }
}
