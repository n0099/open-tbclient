package com.baidu.tbadk.core.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.d;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    private int akR;
    private int akS;
    protected int akT;
    protected int akU;
    private int akV;
    private int akW;
    private GestureDetector akX;
    private Queue<View> akY;
    private AdapterView.OnItemSelectedListener akZ;
    private AdapterView.OnItemClickListener ala;
    private AdapterView.OnItemLongClickListener alb;
    private a alc;
    private int ald;
    private boolean ale;
    private boolean alf;
    private d.c alg;
    private DataSetObserver alh;
    private GestureDetector.OnGestureListener ali;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private boolean mDataChanged;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void di(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akR = -1;
        this.akS = 0;
        this.akV = Integer.MAX_VALUE;
        this.akW = 0;
        this.akY = new LinkedList();
        this.mDataChanged = false;
        this.ald = 0;
        this.ale = true;
        this.mActivePointerId = -1;
        this.alf = false;
        this.alh = new DataSetObserver() { // from class: com.baidu.tbadk.core.view.HorizontalListView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                synchronized (HorizontalListView.this) {
                    HorizontalListView.this.mDataChanged = true;
                }
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                HorizontalListView.this.reset();
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }
        };
        this.ali = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.core.view.HorizontalListView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return HorizontalListView.this.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return HorizontalListView.this.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                synchronized (HorizontalListView.this) {
                    HorizontalListView.this.akU += (int) f;
                }
                HorizontalListView.this.requestLayout();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < HorizontalListView.this.getChildCount()) {
                        View childAt = HorizontalListView.this.getChildAt(i2);
                        if (a(motionEvent, childAt)) {
                            if (HorizontalListView.this.ala != null) {
                                HorizontalListView.this.ala.onItemClick(HorizontalListView.this, childAt, HorizontalListView.this.akR + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.akR + 1 + i2));
                            }
                            if (HorizontalListView.this.akZ != null) {
                                HorizontalListView.this.akZ.onItemSelected(HorizontalListView.this, childAt, HorizontalListView.this.akR + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.akR + 1 + i2));
                                return true;
                            }
                            return true;
                        }
                        i = i2 + 1;
                    } else {
                        return true;
                    }
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                int childCount = HorizontalListView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = HorizontalListView.this.getChildAt(i);
                    if (a(motionEvent, childAt)) {
                        if (HorizontalListView.this.alb != null) {
                            HorizontalListView.this.alb.onItemLongClick(HorizontalListView.this, childAt, HorizontalListView.this.akR + 1 + i, HorizontalListView.this.mAdapter.getItemId(i + HorizontalListView.this.akR + 1));
                            return;
                        }
                        return;
                    }
                }
            }

            private boolean a(MotionEvent motionEvent, View view) {
                Rect rect = new Rect();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                rect.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
                return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
        };
        initView();
    }

    private synchronized void initView() {
        this.akR = -1;
        this.akS = 0;
        this.akW = 0;
        this.akT = 0;
        this.akU = 0;
        this.akV = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.akX = new GestureDetector(getContext(), this.ali);
        this.ald = l.ac(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(d.c cVar) {
        this.alg = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.ale = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ale) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.alf) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.alf = false;
                if (this.alg != null) {
                    this.alg.lm();
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            switch (action) {
                case 0:
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    if (this.mActivePointerId != -1) {
                        this.mInitialMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                        this.mInitialMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                        if (this.alg != null) {
                            this.alg.ln();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.alg != null) {
                        this.alg.lm();
                        break;
                    }
                    break;
                case 2:
                    if (this.alg != null) {
                        this.alg.ln();
                    }
                    i(motionEvent);
                    if (this.alf) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ale) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.alg != null) {
                    this.alg.ln();
                    break;
                }
                break;
            case 1:
                this.alf = false;
                if (this.alg != null) {
                    this.alg.lm();
                    break;
                }
                break;
            case 2:
                if (this.alg != null) {
                    this.alg.ln();
                }
                if (!this.alf) {
                    i(motionEvent);
                }
                if (this.alf && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.alg != null) {
                    this.alg.lm();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void i(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int b = b(motionEvent, i);
        if (i != -1) {
            try {
                float x = MotionEventCompat.getX(motionEvent, b);
                float y = MotionEventCompat.getY(motionEvent, b);
                float abs = Math.abs(x - this.mInitialMotionX);
                float abs2 = Math.abs(y - this.mInitialMotionY);
                if (abs > this.mTouchSlop && abs > abs2) {
                    this.alf = true;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private int b(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.akZ = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ala = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.alb = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.alc = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.alh);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.alh);
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
        dh(childCount);
    }

    private void m(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(getHeight(), ExploreByTouchHelper.INVALID_ID));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            size = z(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int z(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.akY.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.akY.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.mDataChanged) {
                int i5 = this.akT;
                initView();
                removeAllViewsInLayout();
                this.akU = i5;
                this.mDataChanged = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.akU = this.mScroller.getCurrX();
            }
            if (this.akU <= 0) {
                this.akU = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.akU >= this.akV) {
                this.akU = this.akV;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.akT - this.akU;
            df(i6);
            de(i6);
            dg(i6);
            if (this.alc != null) {
                this.alc.di(getMiddleViewPosition());
            }
            this.akT = this.akU;
            if (!this.mScroller.isFinished()) {
                post(new Runnable() { // from class: com.baidu.tbadk.core.view.HorizontalListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        HorizontalListView.this.requestLayout();
                    }
                });
            }
        }
    }

    private void de(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        A(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        B(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void A(int i, int i2) {
        while (i + i2 < getWidth() && this.akS < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.akS, this.akY.poll(), this);
            m(view, -1);
            i += view.getMeasuredWidth();
            if (this.akS == this.mAdapter.getCount() - 1) {
                this.akV = (this.akT + i) - getWidth();
            }
            if (this.akV < 0) {
                this.akV = 0;
            }
            this.akS++;
        }
    }

    private void B(int i, int i2) {
        while (i + i2 > 0 && this.akR >= 0) {
            View view = this.mAdapter.getView(this.akR, this.akY.poll(), this);
            m(view, 0);
            i -= view.getMeasuredWidth();
            this.akR--;
            this.akW -= view.getMeasuredWidth();
        }
    }

    private void df(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.akW += childAt.getMeasuredWidth();
            this.akY.offer(childAt);
            removeViewInLayout(childAt);
            this.akR++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.akY.offer(childAt2);
            removeViewInLayout(childAt2);
            this.akS--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void dg(int i) {
        if (getChildCount() > 0) {
            this.akW += i;
            int i2 = this.akW;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void dh(int i) {
        this.mScroller.startScroll(this.akU, 0, i - this.akU, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.akX.onTouchEvent(motionEvent);
    }

    protected boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.akU, 0, (int) (-f), 0, 0, this.akV, 0, 0);
        }
        requestLayout();
        return true;
    }

    protected boolean onDown(MotionEvent motionEvent) {
        this.mScroller.forceFinished(true);
        return true;
    }

    private int getMiddleViewPosition() {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getWidth() + childAt.getLeft() >= this.ald) {
                    return i + 1 + this.akR;
                }
            }
            return 0;
        }
        return 0;
    }
}
