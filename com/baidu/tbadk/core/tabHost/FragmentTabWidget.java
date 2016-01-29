package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int aaA;
    private int aaB;
    private a aaC;
    private c aaD;
    private final Rect aaE;
    private final Rect aaF;
    private int aaG;
    private int aaH;
    private int aaI;
    private int aaJ;
    private boolean aaK;
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
        this.aaB = -1;
        this.aaE = new Rect();
        this.aaF = new Rect();
        this.mPaint = new Paint();
        this.aaK = true;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaB = -1;
        this.aaE = new Rect();
        this.aaF = new Rect();
        this.mPaint = new Paint();
        this.aaK = true;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aaG = k.dip2px(getContext(), 1.0f);
        this.aaH = k.dip2px(getContext(), 3.0f);
        setWillNotDraw(false);
        this.aaA = t.f.bg_navigation_bar;
    }

    public void d(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.aaB != i) {
            if (this.aaB != -1) {
                getChildAt(this.aaB).setSelected(false);
            }
            this.aaB = i;
            getChildAt(this.aaB).setSelected(true);
            if (z) {
                b(this.aaB, 0.0f);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aaD != null) {
            this.aaD.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        B(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        B(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void B(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.aaB = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aaJ = this.mWidth / this.mChildCount;
            if (this.aaB != -1) {
                b(this.aaB, 0.0f);
            }
            int i5 = this.mHeight - this.aaG;
            this.aaF.set(0, i5, this.mWidth, this.aaG + i5);
        }
    }

    public void b(int i, float f) {
        this.left = this.aaJ * i;
        this.left += (int) (this.aaJ * f);
        this.aaE.set(this.left, this.mHeight - this.aaH, this.left + this.aaJ, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.aaA = i;
    }

    public void onChangeSkinType(int i) {
        ar.k(this, this.aaA);
        this.aaI = ar.getColor(t.d.s_actionbar_text_line_color_s);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dk(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.aaK) {
            this.mPaint.setColor(this.aaI);
            canvas.drawRect(this.aaE, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aaK = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.aaC = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.aaD = cVar;
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {
        private final int aaL;

        private b(int i) {
            this.aaL = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.aaC.c(this.aaL, true);
        }
    }
}
