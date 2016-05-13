package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int Vf;
    private int Vg;
    private a Vh;
    private c Vi;
    private final Rect Vj;
    private final Rect Vk;
    private final Rect Vl;
    private int Vm;
    private int Vn;
    private int Vo;
    private int Vp;
    private int Vq;
    private int Vr;
    private boolean Vs;
    private boolean Vt;
    private boolean Vu;
    private int Vv;
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
        this.Vg = -1;
        this.Vj = new Rect();
        this.Vk = new Rect();
        this.Vl = new Rect();
        this.mPaint = new Paint();
        this.Vs = true;
        this.Vt = false;
        this.Vu = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Vg = -1;
        this.Vj = new Rect();
        this.Vk = new Rect();
        this.Vl = new Rect();
        this.mPaint = new Paint();
        this.Vs = true;
        this.Vt = false;
        this.Vu = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.Vm = getResources().getDimensionPixelSize(t.e.ds1);
        this.Vn = k.dip2px(getContext(), 1.0f);
        this.Vo = k.dip2px(getContext(), 3.0f);
        this.Vv = getResources().getDimensionPixelSize(t.e.ds10);
        setWillNotDraw(false);
        this.Vf = t.d.navigation_bar_bg;
    }

    public void f(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.Vg != i) {
                if (this.Vg != -1) {
                    getChildAt(this.Vg).setSelected(false);
                }
                this.Vg = i;
                getChildAt(this.Vg).setSelected(true);
                if (z) {
                    b(this.Vg, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.Vi != null) {
            this.Vi.onSizeChanged(i, i2, i3, i4);
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
        if (this.Vu) {
            view.setPadding(0, 0, 0, this.Vv);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.Vg = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.Vr = this.mWidth / this.mChildCount;
            if (this.Vg != -1) {
                b(this.Vg, 0.0f);
            }
            int i5 = this.mHeight - this.Vm;
            this.Vk.set(0, i5, this.mWidth, this.Vm + i5);
            this.Vl.set(0, 0, this.mWidth, this.Vn);
        }
    }

    public void b(int i, float f) {
        this.left = this.Vr * i;
        this.left += (int) (this.Vr * f);
        this.Vj.set(this.left, this.mHeight - this.Vo, this.left + this.Vr, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.Vf = i;
    }

    public void onChangeSkinType(int i) {
        if (this.Vf != 0) {
            at.l(this, this.Vf);
        }
        this.Vq = at.getColor(t.d.s_actionbar_text_line_color_s);
        this.Vp = at.getColor(t.d.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).cV(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.Vp);
        canvas.drawRect(this.Vk, this.mPaint);
        if (this.Vt) {
            canvas.drawRect(this.Vl, this.mPaint);
        }
        if (this.Vs) {
            this.mPaint.setColor(this.Vq);
            canvas.drawRect(this.Vj, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.Vs = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.Vt = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.Vh = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.Vi = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int Vw;

        private b(int i) {
            this.Vw = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.Vh.e(this.Vw, true);
        }
    }

    public void ax(boolean z) {
        this.Vu = z;
    }
}
