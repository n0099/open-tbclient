package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class FragmentTabWidget extends LinearLayout {
    private int a;
    private c b;
    private final Rect c;
    private final Rect d;
    private int e;
    private Paint f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public FragmentTabWidget(Context context) {
        super(context);
        this.a = -1;
        this.c = new Rect();
        this.d = new Rect();
        this.f = new Paint();
        b();
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.c = new Rect();
        this.d = new Rect();
        this.f = new Paint();
        b();
    }

    private void b() {
        this.f = new Paint(6);
        this.f.setAntiAlias(true);
        this.f.setStyle(Paint.Style.FILL);
        this.g = j.a(getContext(), 1.0f);
        this.h = j.a(getContext(), 3.0f);
        setWillNotDraw(false);
    }

    public void a(int i, boolean z) {
        if (i >= 0 && i < getChildCount() && this.a != i) {
            if (this.a != -1) {
                getChildAt(this.a).setSelected(false);
            }
            this.a = i;
            getChildAt(this.a).setSelected(true);
            if (z) {
                a(this.a, 0.0f);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        a(view);
        super.addView(view);
        view.setOnClickListener(new d(this, getChildCount() - 1, null));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        a(view);
        super.addView(view, i);
        view.setOnClickListener(new d(this, getChildCount() - 1, null));
    }

    private void a(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void a() {
        removeAllViews();
        this.a = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.j = getChildCount();
        if (this.j != 0) {
            this.k = i3 - i;
            this.l = i4 - i2;
            this.m = this.k / this.j;
            if (this.a != -1) {
                a(this.a, 0.0f);
            }
            int i5 = this.l - this.g;
            this.d.set(0, i5, this.k, this.g + i5);
        }
    }

    public void a(int i, float f) {
        this.e = this.m * i;
        this.e += (int) (this.m * f);
        this.c.set(this.e, this.l - this.h, this.e + this.m, this.l);
        postInvalidateDelayed(16L);
    }

    public void a(int i) {
        if (i == 1) {
            setBackgroundResource(u.bg_navigation_bar_1);
            this.i = getResources().getColor(s.cp_link_tip_a_1);
        } else {
            setBackgroundResource(u.bg_navigation_bar);
            this.i = getResources().getColor(s.cp_link_tip_a);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).a(i);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f.setColor(this.i);
        canvas.drawRect(this.c, this.f);
    }

    public void setTabSelectionListener(c cVar) {
        this.b = cVar;
    }
}
