package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes3.dex */
public class PinnedHeaderListView extends ListView {

    /* renamed from: e  reason: collision with root package name */
    public b f11172e;

    /* renamed from: f  reason: collision with root package name */
    public View f11173f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11174g;

    /* renamed from: h  reason: collision with root package name */
    public int f11175h;

    /* renamed from: i  reason: collision with root package name */
    public int f11176i;
    public AbsListView.OnScrollListener j;

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            PinnedHeaderListView.this.b(i2);
            if (PinnedHeaderListView.this.j != null) {
                PinnedHeaderListView.this.j.onScroll(absListView, i2, i3, i4);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (PinnedHeaderListView.this.j != null) {
                PinnedHeaderListView.this.j.onScrollStateChanged(absListView, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, int i2, int i3);

        int b(int i2);
    }

    public PinnedHeaderListView(Context context) {
        super(context);
        c(context);
    }

    public void b(int i2) {
        b bVar;
        int i3;
        if (this.f11173f == null || (bVar = this.f11172e) == null) {
            return;
        }
        int b2 = bVar.b(i2);
        if (b2 == 0) {
            this.f11174g = false;
            return;
        }
        int i4 = 255;
        if (b2 == 1) {
            this.f11172e.a(this.f11173f, i2, 255);
            if (this.f11173f.getTop() != 0) {
                this.f11173f.layout(0, 0, this.f11175h, this.f11176i);
            }
            this.f11174g = true;
        } else if (b2 != 2) {
        } else {
            int bottom = getChildAt(0).getBottom();
            int height = this.f11173f.getHeight();
            if (bottom < height) {
                i3 = bottom - height;
                i4 = ((height + i3) * 255) / height;
            } else {
                i3 = 0;
            }
            this.f11172e.a(this.f11173f, i2, i4);
            if (this.f11173f.getTop() != i3) {
                this.f11173f.layout(0, i3, this.f11175h, this.f11176i + i3);
            }
            this.f11174g = true;
        }
    }

    public final void c(Context context) {
        super.setOnScrollListener(new a());
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f11174g) {
            drawChild(canvas, this.f11173f, getDrawingTime());
        }
    }

    public View getPinnedHeaderView() {
        return this.f11173f;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f11173f;
        if (view != null) {
            view.layout(0, 0, this.f11175h, this.f11176i);
            b(getFirstVisiblePosition());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = this.f11173f;
        if (view != null) {
            measureChild(view, i2, i3);
            this.f11175h = this.f11173f.getMeasuredWidth();
            this.f11176i = this.f11173f.getMeasuredHeight();
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.j = onScrollListener;
    }

    public void setPinnedHeaderView(View view) {
        this.f11173f = view;
        if (view != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof b) {
            this.f11172e = (b) listAdapter;
        }
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context);
    }
}
