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
    private final Rect VA;
    private final Rect VB;
    private int VC;
    private int VD;
    private int VE;
    private int VF;
    private int VG;
    private int VH;
    private boolean VI;
    private boolean VJ;
    private boolean VK;
    private int VL;
    private int Vv;
    private int Vw;
    private a Vx;
    private c Vy;
    private final Rect Vz;
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
        this.Vw = -1;
        this.Vz = new Rect();
        this.VA = new Rect();
        this.VB = new Rect();
        this.mPaint = new Paint();
        this.VI = true;
        this.VJ = false;
        this.VK = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Vw = -1;
        this.Vz = new Rect();
        this.VA = new Rect();
        this.VB = new Rect();
        this.mPaint = new Paint();
        this.VI = true;
        this.VJ = false;
        this.VK = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.VC = getResources().getDimensionPixelSize(u.e.ds1);
        this.VD = k.dip2px(getContext(), 1.0f);
        this.VE = k.dip2px(getContext(), 3.0f);
        this.VL = getResources().getDimensionPixelSize(u.e.ds10);
        setWillNotDraw(false);
        this.Vv = u.d.common_color_10274;
    }

    public void f(int i, boolean z) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                ((FragmentTabIndicator) getChildAt(i2)).setCheckDescriptionText(i == i2);
                i2++;
            }
            if (this.Vw != i) {
                if (this.Vw != -1) {
                    getChildAt(this.Vw).setSelected(false);
                }
                this.Vw = i;
                getChildAt(this.Vw).setSelected(true);
                if (z) {
                    b(this.Vw, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.Vy != null) {
            this.Vy.onSizeChanged(i, i2, i3, i4);
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
        if (this.VK) {
            view.setPadding(0, 0, 0, this.VL);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.Vw = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.VH = this.mWidth / this.mChildCount;
            if (this.Vw != -1) {
                b(this.Vw, 0.0f);
            }
            int i5 = this.mHeight - this.VC;
            this.VA.set(0, i5, this.mWidth, this.VC + i5);
            this.VB.set(0, 0, this.mWidth, this.VD);
        }
    }

    public void b(int i, float f) {
        this.left = this.VH * i;
        this.left += (int) (this.VH * f);
        this.Vz.set(this.left, this.mHeight - this.VE, this.left + this.VH, this.mHeight);
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.Vv = i;
    }

    public void onChangeSkinType(int i) {
        if (this.Vv != 0) {
            av.l(this, this.Vv);
        }
        this.VG = av.getColor(u.d.cp_link_tip_a);
        this.VF = av.getColor(u.d.cp_bg_line_c);
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
        this.mPaint.setColor(this.VF);
        canvas.drawRect(this.VA, this.mPaint);
        if (this.VJ) {
            canvas.drawRect(this.VB, this.mPaint);
        }
        if (this.VI) {
            this.mPaint.setColor(this.VG);
            canvas.drawRect(this.Vz, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.VI = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.VJ = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.Vx = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.Vy = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int VM;

        private b(int i) {
            this.VM = i;
        }

        /* synthetic */ b(FragmentTabWidget fragmentTabWidget, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.Vx.e(this.VM, true);
        }
    }

    public void av(boolean z) {
        this.VK = z;
    }
}
