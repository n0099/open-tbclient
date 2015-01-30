package com.baidu.tbadk.core.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.widget.ExploreByTouchHelper;
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
    public boolean MQ;
    private int MR;
    private int MS;
    protected int MT;
    protected int MU;
    private int MV;
    private GestureDetector MW;
    private Queue<View> MX;
    private AdapterView.OnItemSelectedListener MY;
    private AdapterView.OnItemClickListener MZ;
    private AdapterView.OnItemLongClickListener Na;
    private boolean Nb;
    private DataSetObserver Nc;
    private GestureDetector.OnGestureListener Nd;
    protected ListAdapter mAdapter;
    private int mMaxX;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MQ = true;
        this.MR = -1;
        this.MS = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.MV = 0;
        this.MX = new LinkedList();
        this.Nb = false;
        this.Nc = new q(this);
        this.Nd = new r(this);
        initView();
    }

    private synchronized void initView() {
        this.MR = -1;
        this.MS = 0;
        this.MV = 0;
        this.MT = 0;
        this.MU = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.MW = new GestureDetector(getContext(), this.Nd);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.MY = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.MZ = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.Na = onItemLongClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.Nc);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.Nc);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        int width = i * getWidth();
        int childCount = getChildCount() * getWidth();
        if (width <= 0) {
            width = 0;
        }
        if (width <= childCount) {
            childCount = width;
        }
        co(childCount);
    }

    private void l(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(getHeight(), ExploreByTouchHelper.INVALID_ID));
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.Nb) {
                int i5 = this.MT;
                initView();
                removeAllViewsInLayout();
                this.MU = i5;
                this.Nb = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.MU = this.mScroller.getCurrX();
            }
            if (this.MU <= 0) {
                this.MU = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.MU >= this.mMaxX) {
                this.MU = this.mMaxX;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.MT - this.MU;
            cm(i6);
            cl(i6);
            cn(i6);
            this.MT = this.MU;
            if (!this.mScroller.isFinished()) {
                post(new s(this));
            }
        }
    }

    private void cl(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        r(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        s(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void r(int i, int i2) {
        while (i + i2 < getWidth() && this.MS < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.MS, this.MX.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.MS == this.mAdapter.getCount() - 1) {
                this.mMaxX = (this.MT + i) - getWidth();
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.MS++;
        }
    }

    private void s(int i, int i2) {
        while (i + i2 > 0 && this.MR >= 0) {
            View view = this.mAdapter.getView(this.MR, this.MX.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.MR--;
            this.MV -= view.getMeasuredWidth();
        }
    }

    private void cm(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.MV += childAt.getMeasuredWidth();
            this.MX.offer(childAt);
            removeViewInLayout(childAt);
            this.MR++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.MX.offer(childAt2);
            removeViewInLayout(childAt2);
            this.MS--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cn(int i) {
        if (getChildCount() > 0) {
            this.MV += i;
            int i2 = this.MV;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void co(int i) {
        this.mScroller.startScroll(this.MU, 0, i - this.MU, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.MW.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.MU, 0, (int) (-f), 0, 0, this.mMaxX, 0, 0);
        }
        requestLayout();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onDown(MotionEvent motionEvent) {
        this.mScroller.forceFinished(true);
        return true;
    }
}
