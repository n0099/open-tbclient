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
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class FragmentTabWidget extends LinearLayout {
    public boolean A;
    public int B;
    public boolean C;
    public boolean D;
    public View E;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f12253e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f12254f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f12255g;

    /* renamed from: h  reason: collision with root package name */
    public int f12256h;

    /* renamed from: i  reason: collision with root package name */
    public int f12257i;
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
        void onTabSelectionChanged(int i2, boolean z);
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final int f12258e;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentTabWidget.this.k.onTabSelectionChanged(this.f12258e, true);
        }

        public c(int i2) {
            this.f12258e = i2;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onSizeChanged(int i2, int i3, int i4, int i5);
    }

    public FragmentTabWidget(Context context) {
        super(context);
        this.f12253e = new Rect();
        this.f12254f = new Rect();
        this.f12255g = new Rect();
        this.f12256h = 0;
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

    public void b(View view, int i2, boolean z) {
        e(view, z);
        super.addView(view, i2);
        if (z) {
            this.E = view;
        }
        view.setOnClickListener(new c(getChildCount() - 1));
    }

    public void c(int i2, float f2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int i3 = this.x;
        int i4 = (i3 - dimensionPixelSize) / 2;
        int i5 = i3 * i2;
        this.m = i5;
        int i6 = i5 + ((int) (i3 * f2));
        this.m = i6;
        int i7 = this.w;
        int i8 = i7 - this.q;
        int i9 = this.r;
        if (i9 == -2) {
            View childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof TbFragmentTabIndicator)) {
                View contentTv = ((TbFragmentTabIndicator) childAt).getContentTv();
                if (contentTv != null) {
                    this.f12253e.set(childAt.getLeft() + contentTv.getLeft(), i8, childAt.getLeft() + contentTv.getRight(), this.w);
                } else {
                    Rect rect = this.f12253e;
                    int i10 = this.m;
                    int i11 = this.x;
                    int i12 = this.r;
                    rect.set(((i11 / 2) + i10) - (i12 / 2), i8, i10 + (i11 / 2) + (i12 / 2), this.w);
                }
            } else {
                Rect rect2 = this.f12253e;
                int i13 = this.m;
                int i14 = this.x;
                int i15 = this.r;
                rect2.set(((i14 / 2) + i13) - (i15 / 2), i8, i13 + (i14 / 2) + (i15 / 2), this.w);
            }
        } else if (i9 != 0) {
            this.f12253e.set(((i3 / 2) + i6) - (i9 / 2), i8, i6 + (i3 / 2) + (i9 / 2), i7);
        } else {
            this.f12253e.set(i6 + i4, i8, i6 + i4 + dimensionPixelSize, i7);
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
            canvas.drawRect(this.f12254f, this.n);
        }
        if (this.z) {
            canvas.drawRect(this.f12255g, this.n);
        }
        if (this.y) {
            this.n.setColor(this.t);
            canvas.drawRoundRect(new RectF(this.f12253e), 10.0f, 10.0f, this.n);
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
        this.f12257i = R.color.common_color_10274;
    }

    public void g(int i2) {
        int i3 = this.f12257i;
        if (i3 != 0 && this.f12256h == 0) {
            SkinManager.setBackgroundColor(this, i3);
        }
        this.t = SkinManager.getColor(R.color.CAM_X0105);
        this.s = SkinManager.getColor(R.color.CAM_X0204);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt instanceof FragmentTabIndicator) {
                ((FragmentTabIndicator) childAt).e(i2);
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
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int childCount = getChildCount();
        this.u = childCount;
        if (childCount == 0) {
            return;
        }
        int i6 = i4 - i2;
        this.v = i6;
        this.w = i5 - i3;
        this.x = i6 / childCount;
        int i7 = this.j;
        if (i7 != -1) {
            c(i7, 0.0f);
        }
        int i8 = this.w;
        int i9 = this.o;
        int i10 = i8 - i9;
        this.f12254f.set(0, i10, this.v, i9 + i10);
        this.f12255g.set(0, 0, this.v, this.p);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        d dVar = this.l;
        if (dVar != null) {
            dVar.onSizeChanged(i2, i3, i4, i5);
        }
    }

    public void setAbsoluteWeight(boolean z) {
        this.C = z;
    }

    public void setBackGroundDrawableResId(int i2) {
        this.f12257i = i2;
    }

    public void setBackGroundStyle(int i2) {
        this.f12256h = i2;
    }

    public void setCurrentTab(int i2, boolean z, boolean z2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            return;
        }
        if (z2) {
            int i3 = 0;
            while (i3 < getChildCount()) {
                TbFragmentTabIndicator tbFragmentTabIndicator = (TbFragmentTabIndicator) getChildAt(i3);
                tbFragmentTabIndicator.setCheckDescriptionText(i2 == i3);
                tbFragmentTabIndicator.f(i2 == i3);
                i3++;
            }
        }
        int i4 = this.j;
        if (i4 == i2) {
            return;
        }
        if (i4 != -1) {
            getChildAt(i4).setSelected(false);
        }
        this.j = i2;
        getChildAt(i2).setSelected(true);
        if (z) {
            c(this.j, 0.0f);
        }
    }

    public void setDiverColor(int i2) {
        this.t = i2;
    }

    public void setDviderRectHeight(int i2) {
        this.q = i2;
    }

    public void setDviderRectWidth(int i2) {
        this.r = i2;
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
    public void addView(View view, int i2) {
        d(view);
        super.addView(view, i2);
        view.setOnClickListener(new c(getChildCount() - 1));
    }

    public FragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12253e = new Rect();
        this.f12254f = new Rect();
        this.f12255g = new Rect();
        this.f12256h = 0;
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
