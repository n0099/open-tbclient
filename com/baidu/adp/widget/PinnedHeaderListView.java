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
    private p m;

    @Override // android.widget.AbsListView, android.view.ViewGroup
    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return e();
    }

    public PinnedHeaderListView(Context context) {
        this(context, null, 0);
        a();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new n(this);
        this.d = -1;
        this.i = this.h;
        this.l = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        a();
    }

    private void a() {
        setOnScrollToPullListener(new o(this));
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof p)) {
            throw new RuntimeException("Adapter must extended from PinnedHeaderListAdapter");
        }
        super.setAdapter(listAdapter);
        this.m = (p) listAdapter;
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
                layoutParams = e();
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
        d();
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

    private void d() {
        if (this.c != null) {
            p pVar = this.m;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = pVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = pVar.getItemViewType(i);
            if (this.k) {
                if (itemViewType2 == this.d) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.g = Math.min(this.f, Math.max(0, this.f - childAt.getTop()));
                        invalidate(0, 0, this.e, this.f);
                    }
                } else if (itemViewType == this.d && firstVisiblePosition != this.h) {
                    pVar.a(this.c, this, firstVisiblePosition);
                    a(getMeasuredWidth(), getMeasuredHeight());
                    this.c.layout(0, 0, this.e, this.f);
                    invalidate(0, 0, this.e, this.f);
                    this.h = firstVisiblePosition;
                    this.j = this.h;
                } else {
                    this.g = 0;
                    invalidate(0, 0, this.e, this.f);
                }
                p pVar2 = this.m;
                int i2 = i - 1;
                while (true) {
                    if (i2 >= 0) {
                        if (pVar2.getItemViewType(i2) == this.d) {
                            break;
                        }
                        i2--;
                    } else {
                        i2 = -1;
                        break;
                    }
                }
                if (i2 == -1) {
                    this.k = false;
                    pVar.a(null, this, -1);
                } else if (i2 != this.j || i2 == 0) {
                    pVar.a(this.c, this, i2);
                    a(getMeasuredWidth(), getMeasuredHeight());
                    this.c.layout(0, 0, this.e, this.f);
                    invalidate(0, 0, this.e, this.f);
                    this.j = i2;
                    this.h = this.i;
                }
            } else if (itemViewType == this.d) {
                this.k = true;
                this.g = 0;
                pVar.a(this.c, this, firstVisiblePosition);
                a(getMeasuredWidth(), getMeasuredHeight());
                this.c.layout(0, 0, this.e, this.f);
                invalidate(0, 0, this.e, this.f);
                this.h = firstVisiblePosition;
                this.i = firstVisiblePosition;
            }
        }
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
        d();
        if (this.a != null) {
            this.a.onScroll(absListView, i, i2, i3);
        }
    }

    private static AbsListView.LayoutParams e() {
        return new AbsListView.LayoutParams(-1, -2);
    }
}
