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
    public b f12549e;

    /* renamed from: f  reason: collision with root package name */
    public View f12550f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12551g;

    /* renamed from: h  reason: collision with root package name */
    public int f12552h;
    public int i;
    public AbsListView.OnScrollListener j;

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            PinnedHeaderListView.this.b(i);
            if (PinnedHeaderListView.this.j != null) {
                PinnedHeaderListView.this.j.onScroll(absListView, i, i2, i3);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (PinnedHeaderListView.this.j != null) {
                PinnedHeaderListView.this.j.onScrollStateChanged(absListView, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, int i, int i2);

        int b(int i);
    }

    public PinnedHeaderListView(Context context) {
        super(context);
        c(context);
    }

    public void b(int i) {
        b bVar;
        int i2;
        if (this.f12550f == null || (bVar = this.f12549e) == null) {
            return;
        }
        int b2 = bVar.b(i);
        if (b2 == 0) {
            this.f12551g = false;
            return;
        }
        int i3 = 255;
        if (b2 == 1) {
            this.f12549e.a(this.f12550f, i, 255);
            if (this.f12550f.getTop() != 0) {
                this.f12550f.layout(0, 0, this.f12552h, this.i);
            }
            this.f12551g = true;
        } else if (b2 != 2) {
        } else {
            int bottom = getChildAt(0).getBottom();
            int height = this.f12550f.getHeight();
            if (bottom < height) {
                i2 = bottom - height;
                i3 = ((height + i2) * 255) / height;
            } else {
                i2 = 0;
            }
            this.f12549e.a(this.f12550f, i, i3);
            if (this.f12550f.getTop() != i2) {
                this.f12550f.layout(0, i2, this.f12552h, this.i + i2);
            }
            this.f12551g = true;
        }
    }

    public final void c(Context context) {
        super.setOnScrollListener(new a());
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f12551g) {
            drawChild(canvas, this.f12550f, getDrawingTime());
        }
    }

    public View getPinnedHeaderView() {
        return this.f12550f;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f12550f;
        if (view != null) {
            view.layout(0, 0, this.f12552h, this.i);
            b(getFirstVisiblePosition());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.f12550f;
        if (view != null) {
            measureChild(view, i, i2);
            this.f12552h = this.f12550f.getMeasuredWidth();
            this.i = this.f12550f.getMeasuredHeight();
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.j = onScrollListener;
    }

    public void setPinnedHeaderView(View view) {
        this.f12550f = view;
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
            this.f12549e = (b) listAdapter;
        }
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
