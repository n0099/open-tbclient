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
    private int adU;
    private int adV;
    private a adW;
    private c adX;
    private final Rect adY;
    private final Rect adZ;
    private final Rect aea;
    private int aeb;
    private int aec;
    private int aed;
    private int aee;
    private int aef;
    private int aeg;
    private int aeh;
    private boolean aei;
    private boolean aej;
    private boolean aek;
    private int ael;
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
        this.adV = -1;
        this.adY = new Rect();
        this.adZ = new Rect();
        this.aea = new Rect();
        this.mPaint = new Paint();
        this.aee = 0;
        this.aei = true;
        this.aej = false;
        this.aek = false;
        init();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adV = -1;
        this.adY = new Rect();
        this.adZ = new Rect();
        this.aea = new Rect();
        this.mPaint = new Paint();
        this.aee = 0;
        this.aei = true;
        this.aej = false;
        this.aek = false;
        init();
    }

    private void init() {
        this.mPaint = new Paint(6);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.aeb = getResources().getDimensionPixelSize(d.f.ds1);
        this.aec = l.dip2px(getContext(), 1.0f);
        this.aed = l.dip2px(getContext(), 3.0f);
        this.ael = getResources().getDimensionPixelSize(d.f.ds10);
        setWillNotDraw(false);
        this.adU = d.e.common_color_10274;
    }

    public void a(int i, boolean z, boolean z2) {
        if (i >= 0 && i < getChildCount()) {
            if (z2) {
                int i2 = 0;
                while (i2 < getChildCount()) {
                    e eVar = (e) getChildAt(i2);
                    eVar.setCheckDescriptionText(i == i2);
                    eVar.bP(i == i2);
                    i2++;
                }
            }
            if (this.adV != i) {
                if (this.adV != -1) {
                    getChildAt(this.adV).setSelected(false);
                }
                this.adV = i;
                getChildAt(this.adV).setSelected(true);
                if (z) {
                    a(this.adV, 0.0f);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.adX != null) {
            this.adX.onSizeChanged(i, i2, i3, i4);
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
        if (this.aek) {
            view.setPadding(0, 0, 0, this.ael);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        removeAllViews();
        this.adV = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mChildCount = getChildCount();
        if (this.mChildCount != 0) {
            this.mWidth = i3 - i;
            this.mHeight = i4 - i2;
            this.aeh = this.mWidth / this.mChildCount;
            if (this.adV != -1) {
                a(this.adV, 0.0f);
            }
            int i5 = this.mHeight - this.aeb;
            this.adZ.set(0, i5, this.mWidth, this.aeb + i5);
            this.aea.set(0, 0, this.mWidth, this.aec);
        }
    }

    public void a(int i, float f) {
        this.left = this.aeh * i;
        this.left += (int) (this.aeh * f);
        int i2 = this.mHeight - this.aed;
        if (this.aee == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof e)) {
                View contentTv = ((e) childAt).getContentTv();
                if (contentTv != null) {
                    this.adY.set(childAt.getLeft() + contentTv.getLeft(), i2, contentTv.getRight() + childAt.getLeft(), this.mHeight);
                } else {
                    this.adY.set((this.left + (this.aeh / 2)) - (this.aee / 2), i2, this.left + (this.aeh / 2) + (this.aee / 2), this.mHeight);
                }
            } else {
                this.adY.set((this.left + (this.aeh / 2)) - (this.aee / 2), i2, this.left + (this.aeh / 2) + (this.aee / 2), this.mHeight);
            }
        } else if (this.aee != 0) {
            this.adY.set((this.left + (this.aeh / 2)) - (this.aee / 2), i2, this.left + (this.aeh / 2) + (this.aee / 2), this.mHeight);
        } else {
            this.adY.set(this.left, i2, this.left + this.aeh, this.mHeight);
        }
        postInvalidateDelayed(16L);
    }

    public void setBackGroundDrawableResId(int i) {
        this.adU = i;
    }

    public void onChangeSkinType(int i) {
        if (this.adU != 0) {
            aj.k(this, this.adU);
        }
        if (this.aeg == 0) {
            this.aeg = aj.getColor(d.e.cp_link_tip_a);
        }
        this.aef = aj.getColor(d.e.cp_bg_line_c);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).dD(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setColor(this.aef);
        canvas.drawRect(this.adZ, this.mPaint);
        if (this.aej) {
            canvas.drawRect(this.aea, this.mPaint);
        }
        if (this.aei) {
            this.mPaint.setColor(this.aeg);
            canvas.drawRect(this.adY, this.mPaint);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.aei = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.aej = z;
    }

    public void setTabSelectionListener(a aVar) {
        this.adW = aVar;
    }

    public void setOnSizeChangedListener(c cVar) {
        this.adX = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aem;

        private b(int i) {
            this.aem = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.adW.e(this.aem, true);
        }
    }

    public void aA(boolean z) {
        this.aek = z;
    }

    public void setDviderRectWidth(int i) {
        this.aee = i;
    }

    public void setDviderRectHeight(int i) {
        this.aed = i;
    }

    public void setDiverColor(int i) {
        this.aeg = i;
    }
}
