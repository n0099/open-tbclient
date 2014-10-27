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
    protected int HB;
    protected int HC;
    private int HD;
    private int HE;
    private GestureDetector HF;
    private Queue<View> HG;
    private AdapterView.OnItemSelectedListener HH;
    private AdapterView.OnItemClickListener HI;
    private AdapterView.OnItemLongClickListener HJ;
    private boolean HK;
    private DataSetObserver HL;
    private GestureDetector.OnGestureListener HM;
    public boolean Hy;
    private int Hz;
    protected ListAdapter mAdapter;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hy = true;
        this.Hz = -1;
        this.HA = 0;
        this.HD = Integer.MAX_VALUE;
        this.HE = 0;
        this.HG = new LinkedList();
        this.HK = false;
        this.HL = new i(this);
        this.HM = new j(this);
        nu();
    }

    private synchronized void nu() {
        this.Hz = -1;
        this.HA = 0;
        this.HE = 0;
        this.HB = 0;
        this.HC = 0;
        this.HD = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.HF = new GestureDetector(getContext(), this.HM);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.HH = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.HI = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.HJ = onItemLongClickListener;
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
            this.mAdapter.unregisterDataSetObserver(this.HL);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.HL);
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
            if (this.HK) {
                int i5 = this.HB;
                nu();
                removeAllViewsInLayout();
                this.HC = i5;
                this.HK = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.HC = this.mScroller.getCurrX();
            }
            if (this.HC <= 0) {
                this.HC = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.HC >= this.HD) {
                this.HC = this.HD;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.HB - this.HC;
            bI(i6);
            bH(i6);
            bJ(i6);
            this.HB = this.HC;
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
        while (i + i2 < getWidth() && this.HA < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.HA, this.HG.poll(), this);
            k(view, -1);
            i += view.getMeasuredWidth();
            if (this.HA == this.mAdapter.getCount() - 1) {
                this.HD = (this.HB + i) - getWidth();
            }
            if (this.HD < 0) {
                this.HD = 0;
            }
            this.HA++;
        }
    }

    private void p(int i, int i2) {
        while (i + i2 > 0 && this.Hz >= 0) {
            View view = this.mAdapter.getView(this.Hz, this.HG.poll(), this);
            k(view, 0);
            i -= view.getMeasuredWidth();
            this.Hz--;
            this.HE -= view.getMeasuredWidth();
        }
    }

    private void bI(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.HE += childAt.getMeasuredWidth();
            this.HG.offer(childAt);
            removeViewInLayout(childAt);
            this.Hz++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.HG.offer(childAt2);
            removeViewInLayout(childAt2);
            this.HA--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void bJ(int i) {
        if (getChildCount() > 0) {
            this.HE += i;
            int i2 = this.HE;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void bK(int i) {
        this.mScroller.startScroll(this.HC, 0, i - this.HC, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.HF.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.HC, 0, (int) (-f), 0, 0, this.HD, 0, 0);
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
