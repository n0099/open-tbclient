package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class FragmentTabWidget extends LinearLayout {
    public boolean A;
    public int B;
    public boolean C;
    public boolean D;
    public View E;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f12983e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f12984f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f12985g;

    /* renamed from: h  reason: collision with root package name */
    public int f12986h;
    public int i;
    public int j;
    public b k;
    public d l;
    public int m;
    public Paint n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public interface b {
        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final int f12987e;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.k.onTabSelectionChanged(this.f12987e, true);
        }

        public c(int i) {
            this.f12987e = i;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.f12983e = new Rect();
        this.f12984f = new Rect();
        this.f12985g = new Rect();
        this.f12986h = 0;
        this.j = -1;
        this.n = new Paint();
        this.r = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.C = false;
        this.D = true;
        f();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        d(view);
        super.addView(view);
        view.setOnClickListener(new c(getChildCount() - 1));
    }

    public void b(View view, int i, boolean z) {
        e(view, z);
        super.addView(view, i);
        if (z) {
            this.E = view;
        }
        view.setOnClickListener(new c(getChildCount() - 1));
    }

    public void c(int i, float f2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int i2 = this.x;
        int i3 = (i2 - dimensionPixelSize) / 2;
        int i4 = i2 * i;
        this.m = i4;
        int i5 = i4 + ((int) (i2 * f2));
        this.m = i5;
        int i6 = this.w;
        int i7 = i6 - this.q;
        int i8 = this.r;
        if (i8 == -2) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.f12983e.set(childAt.getLeft() + contentTv.getLeft(), i7, childAt.getLeft() + contentTv.getRight(), this.w);
                } else {
                    Rect rect = this.f12983e;
                    int i9 = this.m;
                    int i10 = this.x;
                    int i11 = this.r;
                    rect.set(((i10 / 2) + i9) - (i11 / 2), i7, i9 + (i10 / 2) + (i11 / 2), this.w);
                }
            } else {
                Rect rect2 = this.f12983e;
                int i12 = this.m;
                int i13 = this.x;
                int i14 = this.r;
                rect2.set(((i13 / 2) + i12) - (i14 / 2), i7, i12 + (i13 / 2) + (i14 / 2), this.w);
            }
        } else if (i8 != 0) {
            this.f12983e.set(((i2 / 2) + i5) - (i8 / 2), i7, i5 + (i2 / 2) + (i8 / 2), i6);
        } else {
            this.f12983e.set(i5 + i3, i7, i5 + i3 + dimensionPixelSize, i6);
        }
        postInvalidateDelayed(16L);
    }

    public final void d(View view) {
        LinearLayout.LayoutParams layoutParams;
        if (this.C) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.A) {
            view.setPadding(0, 0, 0, this.B);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.n.setColor(this.s);
        if (this.D) {
            canvas.drawRect(this.f12984f, this.n);
        }
        if (this.z) {
            canvas.drawRect(this.f12985g, this.n);
        }
        if (this.y) {
            this.n.setColor(this.t);
            canvas.drawRoundRect(new RectF(this.f12983e), 10.0f, 10.0f, this.n);
        }
    }

    public void e(View view, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (this.C) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        if (this.A) {
            view.setPadding(0, 0, 0, this.B);
        }
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public final void f() {
        Paint paint = new Paint(6);
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setStyle(Paint.Style.FILL);
        this.o = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.p = l.e(getContext(), 1.0f);
        this.q = l.e(getContext(), 2.0f);
        this.B = getResources().getDimensionPixelSize(R.dimen.ds10);
        setWillNotDraw(false);
        this.i = R.color.common_color_10274;
    }

    public void g(int i) {
        int i2 = this.i;
        if (i2 != 0 && this.f12986h == 0) {
            SkinManager.setBackgroundColor(this, i2);
        }
        this.t = SkinManager.getColor(R.color.CAM_X0105);
        this.s = SkinManager.getColor(R.color.CAM_X0204);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).e(i);
            }
        }
        invalidate();
    }

    public View getWriteView() {
        return this.E;
    }

    public void h() {
        removeAllViews();
        this.j = -1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int childCount = getChildCount();
        this.u = childCount;
        if (childCount == 0) {
            return;
        }
        int i5 = i3 - i;
        this.v = i5;
        this.w = i4 - i2;
        this.x = i5 / childCount;
        int i6 = this.j;
        if (i6 != -1) {
            c(i6, 0.0f);
        }
        int i7 = this.w;
        int i8 = this.o;
        int i9 = i7 - i8;
        this.f12984f.set(0, i9, this.v, i8 + i9);
        this.f12985g.set(0, 0, this.v, this.p);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d dVar = this.l;
        if (dVar != null) {
            dVar.onSizeChanged(i, i2, i3, i4);
        }
    }

    public void setAbsoluteWeight(boolean z) {
        this.C = z;
    }

    public void setBackGroundDrawableResId(int i) {
        this.i = i;
    }

    public void setBackGroundStyle(int i) {
        this.f12986h = i;
    }

    public void setCurrentTab(int i, boolean z, boolean z2) {
        if (i < 0 || i >= getChildCount()) {
            return;
        }
        if (z2) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i2);
                tbFragmentTabIndicator.setCheckDescriptionText(i == i2);
                tbFragmentTabIndicator.f(i == i2);
                i2++;
            }
        }
        int i3 = this.j;
        if (i3 == i) {
            return;
        }
        if (i3 != -1) {
            getChildAt(i3).setSelected(false);
        }
        this.j = i;
        getChildAt(i).setSelected(true);
        if (z) {
            c(this.j, 0.0f);
        }
    }

    public void setDiverColor(int i) {
        this.t = i;
    }

    public void setDviderRectHeight(int i) {
        this.q = i;
    }

    public void setDviderRectWidth(int i) {
        this.r = i;
    }

    public void setOnSizeChangedListener(d dVar) {
        this.l = dVar;
    }

    public void setShouldDrawDividerLine(boolean z) {
        this.D = z;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        this.y = z;
    }

    public void setShouldDrawTopLine(boolean z) {
        this.z = z;
    }

    public void setTabSelectionListener(b bVar) {
        this.k = bVar;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        d(view);
        super.addView(view, i);
        view.setOnClickListener(new c(getChildCount() - 1));
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12983e = new Rect();
        this.f12984f = new Rect();
        this.f12985g = new Rect();
        this.f12986h = 0;
        this.j = -1;
        this.n = new Paint();
        this.r = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.C = false;
        this.D = true;
        f();
    }
}
