package com.baidu.adp.widget;

import android.content.Context;
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
    private AbsListView.OnScrollListener f466a;
    private View b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private f k;

    public PinnedHeaderListView(Context context) {
        this(context, null, 0);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = -1;
        this.h = this.g;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof f)) {
            throw new RuntimeException("Adapter must extended from PinnedHeaderListAdapter");
        }
        super.setAdapter(listAdapter);
        this.k = (f) listAdapter;
        this.c = this.k.b();
        this.b = this.k.c_();
        if (this.b != null) {
            setFadingEdgeLength(0);
        }
    }

    private void a(int i, int i2) {
        int i3;
        int i4;
        if (this.b != null) {
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
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
            this.b.measure(i3, i4);
            this.d = this.b.getMeasuredWidth();
            this.e = this.b.getMeasuredHeight();
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
        if (this.j) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.f);
            drawChild(canvas, this.b, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void c() {
        if (this.b != null) {
            f fVar = this.k;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = fVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = fVar.getItemViewType(i);
            if (this.j) {
                if (itemViewType2 == this.c) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.f = Math.min(this.e, Math.max(0, this.e - childAt.getTop()));
                        invalidate(0, 0, this.d, this.e);
                    }
                } else if (itemViewType == this.c && firstVisiblePosition != this.g) {
                    fVar.a(this.b, this, firstVisiblePosition);
                    a(getMeasuredWidth(), getMeasuredHeight());
                    this.b.layout(0, 0, this.d, this.e);
                    invalidate(0, 0, this.d, this.e);
                    this.g = firstVisiblePosition;
                    this.i = this.g;
                } else {
                    this.f = 0;
                    invalidate(0, 0, this.d, this.e);
                }
                int a2 = a(i);
                if (a2 == -1) {
                    this.j = false;
                    fVar.a(null, this, -1);
                } else if (a2 != this.i) {
                    fVar.a(this.b, this, a2);
                    a(getMeasuredWidth(), getMeasuredHeight());
                    this.b.layout(0, 0, this.d, this.e);
                    invalidate(0, 0, this.d, this.e);
                    this.i = a2;
                    this.g = this.h;
                }
            } else if (itemViewType == this.c) {
                this.j = true;
                this.f = 0;
                fVar.a(this.b, this, firstVisiblePosition);
                a(getMeasuredWidth(), getMeasuredHeight());
                this.b.layout(0, 0, this.d, this.e);
                invalidate(0, 0, this.d, this.e);
                this.g = firstVisiblePosition;
                this.h = firstVisiblePosition;
            }
        }
    }

    private int a(int i) {
        f fVar = this.k;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (fVar.getItemViewType(i2) == this.c) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f466a = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f466a != null) {
            this.f466a.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        c();
        if (this.f466a != null) {
            this.f466a.onScroll(absListView, i, i2, i3);
        }
    }
}
