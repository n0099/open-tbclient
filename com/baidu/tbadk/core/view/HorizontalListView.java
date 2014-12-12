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
    private Queue<View> MA;
    private AdapterView.OnItemSelectedListener MB;
    private AdapterView.OnItemClickListener MC;
    private AdapterView.OnItemLongClickListener MD;
    private boolean ME;
    private DataSetObserver MF;
    private GestureDetector.OnGestureListener MG;
    public boolean Mt;
    private int Mu;
    private int Mv;
    protected int Mw;
    protected int Mx;
    private int My;
    private GestureDetector Mz;
    protected ListAdapter mAdapter;
    private int mMaxX;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Mt = true;
        this.Mu = -1;
        this.Mv = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.My = 0;
        this.MA = new LinkedList();
        this.ME = false;
        this.MF = new q(this);
        this.MG = new r(this);
        initView();
    }

    private synchronized void initView() {
        this.Mu = -1;
        this.Mv = 0;
        this.My = 0;
        this.Mw = 0;
        this.Mx = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.Mz = new GestureDetector(getContext(), this.MG);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.MB = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.MC = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.MD = onItemLongClickListener;
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
            this.mAdapter.unregisterDataSetObserver(this.MF);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.MF);
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
        ch(childCount);
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
            if (this.ME) {
                int i5 = this.Mw;
                initView();
                removeAllViewsInLayout();
                this.Mx = i5;
                this.ME = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.Mx = this.mScroller.getCurrX();
            }
            if (this.Mx <= 0) {
                this.Mx = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.Mx >= this.mMaxX) {
                this.Mx = this.mMaxX;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.Mw - this.Mx;
            cf(i6);
            ce(i6);
            cg(i6);
            this.Mw = this.Mx;
            if (!this.mScroller.isFinished()) {
                post(new s(this));
            }
        }
    }

    private void ce(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        r(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        s(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void r(int i, int i2) {
        while (i + i2 < getWidth() && this.Mv < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.Mv, this.MA.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.Mv == this.mAdapter.getCount() - 1) {
                this.mMaxX = (this.Mw + i) - getWidth();
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.Mv++;
        }
    }

    private void s(int i, int i2) {
        while (i + i2 > 0 && this.Mu >= 0) {
            View view = this.mAdapter.getView(this.Mu, this.MA.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.Mu--;
            this.My -= view.getMeasuredWidth();
        }
    }

    private void cf(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.My += childAt.getMeasuredWidth();
            this.MA.offer(childAt);
            removeViewInLayout(childAt);
            this.Mu++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.MA.offer(childAt2);
            removeViewInLayout(childAt2);
            this.Mv--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cg(int i) {
        if (getChildCount() > 0) {
            this.My += i;
            int i2 = this.My;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void ch(int i) {
        this.mScroller.startScroll(this.Mx, 0, i - this.Mx, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.Mz.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.Mx, 0, (int) (-f), 0, 0, this.mMaxX, 0, 0);
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
