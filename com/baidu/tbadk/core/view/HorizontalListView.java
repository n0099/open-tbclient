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
    public boolean MN;
    private int MO;
    private int MP;
    protected int MQ;
    protected int MR;
    private int MS;
    private GestureDetector MT;
    private Queue<View> MU;
    private AdapterView.OnItemSelectedListener MV;
    private AdapterView.OnItemClickListener MW;
    private AdapterView.OnItemLongClickListener MX;
    private boolean MY;
    private DataSetObserver MZ;
    private GestureDetector.OnGestureListener Na;
    protected ListAdapter mAdapter;
    private int mMaxX;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MN = true;
        this.MO = -1;
        this.MP = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.MS = 0;
        this.MU = new LinkedList();
        this.MY = false;
        this.MZ = new q(this);
        this.Na = new r(this);
        initView();
    }

    private synchronized void initView() {
        this.MO = -1;
        this.MP = 0;
        this.MS = 0;
        this.MQ = 0;
        this.MR = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.MT = new GestureDetector(getContext(), this.Na);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.MV = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.MW = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.MX = onItemLongClickListener;
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
            this.mAdapter.unregisterDataSetObserver(this.MZ);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.MZ);
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
            if (this.MY) {
                int i5 = this.MQ;
                initView();
                removeAllViewsInLayout();
                this.MR = i5;
                this.MY = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.MR = this.mScroller.getCurrX();
            }
            if (this.MR <= 0) {
                this.MR = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.MR >= this.mMaxX) {
                this.MR = this.mMaxX;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.MQ - this.MR;
            cm(i6);
            cl(i6);
            cn(i6);
            this.MQ = this.MR;
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
        while (i + i2 < getWidth() && this.MP < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.MP, this.MU.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.MP == this.mAdapter.getCount() - 1) {
                this.mMaxX = (this.MQ + i) - getWidth();
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.MP++;
        }
    }

    private void s(int i, int i2) {
        while (i + i2 > 0 && this.MO >= 0) {
            View view = this.mAdapter.getView(this.MO, this.MU.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.MO--;
            this.MS -= view.getMeasuredWidth();
        }
    }

    private void cm(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.MS += childAt.getMeasuredWidth();
            this.MU.offer(childAt);
            removeViewInLayout(childAt);
            this.MO++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.MU.offer(childAt2);
            removeViewInLayout(childAt2);
            this.MP--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cn(int i) {
        if (getChildCount() > 0) {
            this.MS += i;
            int i2 = this.MS;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void co(int i) {
        this.mScroller.startScroll(this.MR, 0, i - this.MR, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.MT.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.MR, 0, (int) (-f), 0, 0, this.mMaxX, 0, 0);
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
