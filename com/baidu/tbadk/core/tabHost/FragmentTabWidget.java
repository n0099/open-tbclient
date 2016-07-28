package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int We;
    private int Wf;
    private a Wg;
    private c Wh;
    private final Rect Wi;
    private final Rect Wj;
    private final Rect Wk;
    private int Wl;
    private int Wm;
    private int Wn;
    private int Wo;
    private int Wp;
    private int Wq;
    private boolean Wr;
    private boolean Ws;
    private boolean Wt;
    private int Wu;
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
        this.Wf = -1;
        this.Wi = new Rect();
        this.Wj = new Rect();
        this.Wk = new Rect();
        this.mPaint = new Paint();
        this.Wr = true;
        this.Ws = false;
        this.Wt = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wf = -1;
        this.Wi = new Rect();
        this.Wj = new Rect();
        this.Wk = new Rect();
        this.mPaint = new Paint();
        this.Wr = true;
        this.Ws = false;
        this.Wt = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.Wl = getResources().getDimensionPixelSize(u.e.ds1);
        this.Wm = k.dip2px(getContext(), 1.0f);
        this.Wn = k.dip2px(getContext(), 3.0f);
        this.Wu = getResources().getDimensionPixelSize(u.e.ds10);
        setWillNotDraw(false);
        this.We = u.d.common_color_10274;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.Wf != i) {
                if (this.Wf != -1) {
                    getChildAt(this.Wf).setSelected(false);
                }
                this.Wf = i;
                getChildAt(this.Wf).setSelected(true);
                if (z) {
                    b(this.Wf, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.Wh != null) {
            this.Wh.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        A(view);
        super.addView(view);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        A(view);
        super.addView(view, i);
        view.setOnClickListener(new b(this, getChildCount() - 1, null));
    }

    private void A(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.Wt) {
            view.setPadding(0, 0, 0, this.Wu);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.Wf = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.Wq = this.mWidth / this.mChildCount;
            if (this.Wf != -1) {
                b(this.Wf, 0.0f);
            }
            int i5 = this.mHeight - this.Wl;
            this.Wj.set(0, i5, this.mWidth, this.Wl + i5);
            this.Wk.set(0, 0, this.mWidth, this.Wm);
        }
    }

    public void b(int i, float f) {
        this.left = this.Wq * i;
        this.left += (int) (this.Wq * f);
        this.Wi.set(this.left, this.mHeight - this.Wn, this.left + this.Wq, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.We = i;
    }

    public void onChangeSkinType(int i) {
        if (this.We != 0) {
            av.l(this, this.We);
        }
        this.Wp = av.getColor(u.d.cp_link_tip_a);
        this.Wo = av.getColor(u.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).cX(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.Wo);
        canvas.drawRect(this.Wj, this.mPaint);
        if (this.Ws) {
            canvas.drawRect(this.Wk, this.mPaint);
        }
        if (this.Wr) {
            this.mPaint.setColor(this.Wp);
            canvas.drawRect(this.Wi, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.Wr = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.Ws = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.Wg = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.Wh = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int Wv;

        private b(int i) {
            this.Wv = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.Wg.f(this.Wv, true);
        }
    }

    public void ay(boolean z) {
        this.Wt = z;
    }
}
