package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes4.dex */
public class PinnedHeaderListView extends ListView {
    public b a;
    public View b;
    public boolean c;
    public int d;
    public int e;
    public AbsListView.OnScrollListener f;

    /* loaded from: classes4.dex */
    public interface b {
        void configurePinnedHeader(View view2, int i, int i2);

        int getPinnedHeaderState(int i);
    }

    /* loaded from: classes4.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            PinnedHeaderListView.this.b(i);
            if (PinnedHeaderListView.this.f != null) {
                PinnedHeaderListView.this.f.onScroll(absListView, i, i2, i3);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (PinnedHeaderListView.this.f != null) {
                PinnedHeaderListView.this.f.onScrollStateChanged(absListView, i);
            }
        }
    }

    public PinnedHeaderListView(Context context) {
        super(context);
        c(context);
    }

    public final void c(Context context) {
        super.setOnScrollListener(new a());
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.c) {
            drawChild(canvas, this.b, getDrawingTime());
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f = onScrollListener;
    }

    public void setPinnedHeaderView(View view2) {
        this.b = view2;
        if (view2 != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view2 = this.b;
        if (view2 != null) {
            measureChild(view2, i, i2);
            this.d = this.b.getMeasuredWidth();
            this.e = this.b.getMeasuredHeight();
        }
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }

    public void b(int i) {
        b bVar;
        int i2;
        if (this.b != null && (bVar = this.a) != null) {
            int pinnedHeaderState = bVar.getPinnedHeaderState(i);
            if (pinnedHeaderState != 0) {
                int i3 = 255;
                if (pinnedHeaderState != 1) {
                    if (pinnedHeaderState == 2) {
                        int bottom = getChildAt(0).getBottom();
                        int height = this.b.getHeight();
                        if (bottom < height) {
                            i2 = bottom - height;
                            i3 = ((height + i2) * 255) / height;
                        } else {
                            i2 = 0;
                        }
                        this.a.configurePinnedHeader(this.b, i, i3);
                        if (this.b.getTop() != i2) {
                            this.b.layout(0, i2, this.d, this.e + i2);
                        }
                        this.c = true;
                        return;
                    }
                    return;
                }
                this.a.configurePinnedHeader(this.b, i, 255);
                if (this.b.getTop() != 0) {
                    this.b.layout(0, 0, this.d, this.e);
                }
                this.c = true;
                return;
            }
            this.c = false;
        }
    }

    public View getPinnedHeaderView() {
        return this.b;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view2 = this.b;
        if (view2 != null) {
            view2.layout(0, 0, this.d, this.e);
            b(getFirstVisiblePosition());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof b) {
            this.a = (b) listAdapter;
        }
    }
}
