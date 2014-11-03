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
    private int HA;
    private int HB;
    protected int HC;
    protected int HD;
    private int HE;
    private int HF;
    private GestureDetector HG;
    private Queue<View> HH;
    private AdapterView.OnItemSelectedListener HI;
    private AdapterView.OnItemClickListener HJ;
    private AdapterView.OnItemLongClickListener HK;
    private boolean HL;
    private DataSetObserver HM;
    private GestureDetector.OnGestureListener HN;
    public boolean Hz;
    protected ListAdapter mAdapter;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hz = true;
        this.HA = -1;
        this.HB = 0;
        this.HE = Integer.MAX_VALUE;
        this.HF = 0;
        this.HH = new LinkedList();
        this.HL = false;
        this.HM = new i(this);
        this.HN = new j(this);
        nu();
    }

    private synchronized void nu() {
        this.HA = -1;
        this.HB = 0;
        this.HF = 0;
        this.HC = 0;
        this.HD = 0;
        this.HE = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.HG = new GestureDetector(getContext(), this.HN);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.HI = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.HJ = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.HK = onItemLongClickListener;
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
            this.mAdapter.unregisterDataSetObserver(this.HM);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.HM);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reset() {
        nu();
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
        bK(childCount);
    }

    private void k(View view, int i) {
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
        if (this.mAdapter != null) {
            if (this.HL) {
                int i5 = this.HC;
                nu();
                removeAllViewsInLayout();
                this.HD = i5;
                this.HL = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.HD = this.mScroller.getCurrX();
            }
            if (this.HD <= 0) {
                this.HD = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.HD >= this.HE) {
                this.HD = this.HE;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.HC - this.HD;
            bI(i6);
            bH(i6);
            bJ(i6);
            this.HC = this.HD;
            if (!this.mScroller.isFinished()) {
                post(new k(this));
            }
        }
    }

    private void bH(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        o(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        p(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void o(int i, int i2) {
        while (i + i2 < getWidth() && this.HB < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.HB, this.HH.poll(), this);
            k(view, -1);
            i += view.getMeasuredWidth();
            if (this.HB == this.mAdapter.getCount() - 1) {
                this.HE = (this.HC + i) - getWidth();
            }
            if (this.HE < 0) {
                this.HE = 0;
            }
            this.HB++;
        }
    }

    private void p(int i, int i2) {
        while (i + i2 > 0 && this.HA >= 0) {
            View view = this.mAdapter.getView(this.HA, this.HH.poll(), this);
            k(view, 0);
            i -= view.getMeasuredWidth();
            this.HA--;
            this.HF -= view.getMeasuredWidth();
        }
    }

    private void bI(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.HF += childAt.getMeasuredWidth();
            this.HH.offer(childAt);
            removeViewInLayout(childAt);
            this.HA++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.HH.offer(childAt2);
            removeViewInLayout(childAt2);
            this.HB--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void bJ(int i) {
        if (getChildCount() > 0) {
            this.HF += i;
            int i2 = this.HF;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void bK(int i) {
        this.mScroller.startScroll(this.HD, 0, i - this.HD, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.HG.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.HD, 0, (int) (-f), 0, 0, this.HE, 0, 0);
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
