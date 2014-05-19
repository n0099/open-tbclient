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
    private AbsListView.OnScrollListener a;
    private final DataSetObserver b;
    private View c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private q m;

    public PinnedHeaderListView(Context context) {
        this(context, null, 0);
        b();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new o(this);
        this.d = -1;
        this.i = this.h;
        this.l = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        b();
    }

    private void b() {
        setOnScrollToPullListener(new p(this));
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof q)) {
            throw new RuntimeException("Adapter must extended from PinnedHeaderListAdapter");
        }
        super.setAdapter(listAdapter);
        this.m = (q) listAdapter;
        this.d = this.m.b();
        this.c = this.m.c();
        if (this.c.getLayoutParams() == null) {
            this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
        if (this.c != null) {
            setFadingEdgeLength(0);
        }
        this.m.registerDataSetObserver(this.b);
    }

    private void a(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.c != null) {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            switch (layoutParams.width) {
                case -2:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
                    break;
                default:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                    break;
            }
            switch (layoutParams.height) {
                case -2:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                    break;
                default:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                    break;
            }
            this.c.measure(makeMeasureSpec, makeMeasureSpec2);
            this.e = this.c.getMeasuredWidth();
            this.f = this.c.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.k && !this.l && this.c.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.g);
            drawChild(canvas, this.c, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void e() {
        if (this.c != null) {
            q qVar = this.m;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = qVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = qVar.getItemViewType(i);
            if (this.k) {
                if (itemViewType2 == this.d) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.g = Math.min(this.f, Math.max(0, this.f - childAt.getTop()));
                        invalidate(0, 0, this.e, this.f);
                    }
                } else if (itemViewType == this.d && firstVisiblePosition != this.h) {
                    qVar.a(this.c, this, firstVisiblePosition);
                    a(getMeasuredWidth(), getMeasuredHeight());
                    this.c.layout(0, 0, this.e, this.f);
                    invalidate(0, 0, this.e, this.f);
                    this.h = firstVisiblePosition;
                    this.j = this.h;
                } else {
                    this.g = 0;
                    invalidate(0, 0, this.e, this.f);
                }
                int a = a(i);
                if (a == -1) {
                    this.k = false;
                    qVar.a(null, this, -1);
                } else if (a != this.j || a == 0) {
                    qVar.a(this.c, this, a);
                    a(getMeasuredWidth(), getMeasuredHeight());
                    this.c.layout(0, 0, this.e, this.f);
                    invalidate(0, 0, this.e, this.f);
                    this.j = a;
                    this.h = this.i;
                }
            } else if (itemViewType == this.d) {
                this.k = true;
                this.g = 0;
                qVar.a(this.c, this, firstVisiblePosition);
                a(getMeasuredWidth(), getMeasuredHeight());
                this.c.layout(0, 0, this.e, this.f);
                invalidate(0, 0, this.e, this.f);
                this.h = firstVisiblePosition;
                this.i = firstVisiblePosition;
            }
        }
    }

    private int a(int i) {
        q qVar = this.m;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (qVar.getItemViewType(i2) == this.d) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.a = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.a != null) {
            this.a.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        e();
        if (this.a != null) {
            this.a.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: a */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }
}
