package com.baidu.adp.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class PinnedHeaderListView extends BdListView implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private AbsListView.OnScrollListener f581a;
    private DataSetObserver b;
    private View c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private t l;

    public PinnedHeaderListView(Context context) {
        this(context, null, 0);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new s(this);
        this.d = -1;
        this.i = this.h;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof t)) {
            throw new RuntimeException("Adapter must extended from PinnedHeaderListAdapter");
        }
        super.setAdapter(listAdapter);
        this.l = (t) listAdapter;
        this.d = this.l.b();
        this.c = this.l.c();
        if (this.c != null) {
            setFadingEdgeLength(0);
        }
        this.l.registerDataSetObserver(this.b);
    }

    private void a(int i, int i2) {
        int i3;
        int i4;
        if (this.c != null) {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            switch (layoutParams.width) {
                case -2:
                    i3 = i - 2147483648;
                    break;
                case -1:
                    i3 = i + 1073741824;
                    break;
                default:
                    i3 = layoutParams.width + 1073741824;
                    break;
            }
            switch (layoutParams.height) {
                case -2:
                    i4 = i2 - 2147483648;
                    break;
                case -1:
                    i4 = i2 + 1073741824;
                    break;
                default:
                    i4 = layoutParams.height + 1073741824;
                    break;
            }
            this.c.measure(i3, i4);
            this.e = this.c.getMeasuredWidth();
            this.f = this.c.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.k) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.g);
            drawChild(canvas, this.c, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void c() {
        if (this.c != null) {
            t tVar = this.l;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = tVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = tVar.getItemViewType(i);
            if (this.k) {
                if (itemViewType2 == this.d) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.g = Math.min(this.f, Math.max(0, this.f - childAt.getTop()));
                        invalidate(0, 0, this.e, this.f);
                    }
                } else if (itemViewType == this.d && firstVisiblePosition != this.h) {
                    tVar.a(this.c, this, firstVisiblePosition);
                    a(getMeasuredWidth(), getMeasuredHeight());
                    this.c.layout(0, 0, this.e, this.f);
                    invalidate(0, 0, this.e, this.f);
                    this.h = firstVisiblePosition;
                    this.j = this.h;
                } else {
                    this.g = 0;
                    invalidate(0, 0, this.e, this.f);
                }
                int a2 = a(i);
                if (a2 == -1) {
                    this.k = false;
                    tVar.a(null, this, -1);
                } else if (a2 != this.j || a2 == 0) {
                    tVar.a(this.c, this, a2);
                    a(getMeasuredWidth(), getMeasuredHeight());
                    this.c.layout(0, 0, this.e, this.f);
                    invalidate(0, 0, this.e, this.f);
                    this.j = a2;
                    this.h = this.i;
                }
            } else if (itemViewType == this.d) {
                this.k = true;
                this.g = 0;
                tVar.a(this.c, this, firstVisiblePosition);
                a(getMeasuredWidth(), getMeasuredHeight());
                this.c.layout(0, 0, this.e, this.f);
                invalidate(0, 0, this.e, this.f);
                this.h = firstVisiblePosition;
                this.i = firstVisiblePosition;
            }
        }
    }

    private int a(int i) {
        t tVar = this.l;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (tVar.getItemViewType(i2) == this.d) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f581a = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f581a != null) {
            this.f581a.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        c();
        if (this.f581a != null) {
            this.f581a.onScroll(absListView, i, i2, i3);
        }
    }
}
