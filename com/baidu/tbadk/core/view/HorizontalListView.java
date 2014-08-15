package com.baidu.tbadk.core.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public boolean a;
    protected ListAdapter b;
    protected int c;
    protected int d;
    protected Scroller e;
    private int f;
    private int g;
    private int h;
    private int i;
    private GestureDetector j;
    private Queue<View> k;
    private AdapterView.OnItemSelectedListener l;
    private AdapterView.OnItemClickListener m;
    private AdapterView.OnItemLongClickListener n;
    private boolean o;
    private DataSetObserver p;
    private GestureDetector.OnGestureListener q;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.f = -1;
        this.g = 0;
        this.h = Integer.MAX_VALUE;
        this.i = 0;
        this.k = new LinkedList();
        this.o = false;
        this.p = new h(this);
        this.q = new i(this);
        a();
    }

    private synchronized void a() {
        this.f = -1;
        this.g = 0;
        this.i = 0;
        this.c = 0;
        this.d = 0;
        this.h = Integer.MAX_VALUE;
        this.e = new Scroller(getContext());
        this.j = new GestureDetector(getContext(), this.q);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.l = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.m = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.n = onItemLongClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.b;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.b != null) {
            this.b.unregisterDataSetObserver(this.p);
        }
        this.b = listAdapter;
        this.b.registerDataSetObserver(this.p);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        a();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
    }

    private void a(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b != null) {
            if (this.o) {
                int i5 = this.c;
                a();
                removeAllViewsInLayout();
                this.d = i5;
                this.o = false;
            }
            if (this.e.computeScrollOffset()) {
                this.d = this.e.getCurrX();
            }
            if (this.d <= 0) {
                this.d = 0;
                this.e.forceFinished(true);
            }
            if (this.d >= this.h) {
                this.d = this.h;
                this.e.forceFinished(true);
            }
            int i6 = this.c - this.d;
            b(i6);
            a(i6);
            c(i6);
            this.c = this.d;
            if (!this.e.isFinished()) {
                post(new j(this));
            }
        }
    }

    private void a(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        a(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        b(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void a(int i, int i2) {
        while (i + i2 < getWidth() && this.g < this.b.getCount()) {
            View view = this.b.getView(this.g, this.k.poll(), this);
            a(view, -1);
            i += view.getMeasuredWidth();
            if (this.g == this.b.getCount() - 1) {
                this.h = (this.c + i) - getWidth();
            }
            if (this.h < 0) {
                this.h = 0;
            }
            this.g++;
        }
    }

    private void b(int i, int i2) {
        while (i + i2 > 0 && this.f >= 0) {
            View view = this.b.getView(this.f, this.k.poll(), this);
            a(view, 0);
            i -= view.getMeasuredWidth();
            this.f--;
            this.i -= view.getMeasuredWidth();
        }
    }

    private void b(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.i += childAt.getMeasuredWidth();
            this.k.offer(childAt);
            removeViewInLayout(childAt);
            this.f++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.k.offer(childAt2);
            removeViewInLayout(childAt2);
            this.g--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void c(int i) {
        if (getChildCount() > 0) {
            this.i += i;
            int i2 = this.i;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.j.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.e.fling(this.d, 0, (int) (-f), 0, 0, this.h, 0, 0);
        }
        requestLayout();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(MotionEvent motionEvent) {
        this.e.forceFinished(true);
        return true;
    }
}
