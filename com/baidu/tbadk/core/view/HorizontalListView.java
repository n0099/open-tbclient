package com.baidu.tbadk.core.view;

import android.content.Context;
import android.database.DataSetObserver;
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
import com.baidu.adp.widget.f;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public boolean aje;
    private int ajf;
    private int ajg;
    protected int ajh;
    protected int aji;
    private int ajj;
    private int ajk;
    private GestureDetector ajl;
    private Queue<View> ajm;
    private AdapterView.OnItemSelectedListener ajn;
    private AdapterView.OnItemClickListener ajo;
    private AdapterView.OnItemLongClickListener ajp;
    private a ajq;
    private boolean ajr;
    private int ajs;
    private boolean ajt;
    private boolean aju;
    private f.c ajv;
    private DataSetObserver ajw;
    private GestureDetector.OnGestureListener ajx;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void de(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aje = true;
        this.ajf = -1;
        this.ajg = 0;
        this.ajj = Integer.MAX_VALUE;
        this.ajk = 0;
        this.ajm = new LinkedList();
        this.ajr = false;
        this.ajs = 0;
        this.ajt = true;
        this.mActivePointerId = -1;
        this.aju = false;
        this.ajw = new e(this);
        this.ajx = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.ajf = -1;
        this.ajg = 0;
        this.ajk = 0;
        this.ajh = 0;
        this.aji = 0;
        this.ajj = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.ajl = new GestureDetector(getContext(), this.ajx);
        this.ajs = com.baidu.adp.lib.util.k.af(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.ajv = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.ajt = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ajt) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.aju) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.aju = false;
                if (this.ajv != null) {
                    this.ajv.lU();
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
                        if (this.ajv != null) {
                            this.ajv.lV();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.ajv != null) {
                        this.ajv.lU();
                        break;
                    }
                    break;
                case 2:
                    if (this.ajv != null) {
                        this.ajv.lV();
                    }
                    i(motionEvent);
                    if (this.aju) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ajt) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.ajv != null) {
                    this.ajv.lV();
                    break;
                }
                break;
            case 1:
                this.aju = false;
                if (this.ajv != null) {
                    this.ajv.lU();
                    break;
                }
                break;
            case 2:
                if (this.ajv != null) {
                    this.ajv.lV();
                }
                if (!this.aju) {
                    i(motionEvent);
                }
                if (this.aju && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.ajv != null) {
                    this.ajv.lU();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void i(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int d = d(motionEvent, i);
        if (i != -1) {
            try {
                float x = MotionEventCompat.getX(motionEvent, d);
                float y = MotionEventCompat.getY(motionEvent, d);
                float abs = Math.abs(x - this.mInitialMotionX);
                float abs2 = Math.abs(y - this.mInitialMotionY);
                if (abs > this.mTouchSlop && abs > abs2) {
                    this.aju = true;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private int d(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.ajn = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ajo = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.ajp = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.ajq = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.ajw);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.ajw);
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
        dd(childCount);
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
            size = A(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int A(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.ajm.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.ajm.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.ajr) {
                int i5 = this.ajh;
                initView();
                removeAllViewsInLayout();
                this.aji = i5;
                this.ajr = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.aji = this.mScroller.getCurrX();
            }
            if (this.aji <= 0) {
                this.aji = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.aji >= this.ajj) {
                this.aji = this.ajj;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.ajh - this.aji;
            db(i6);
            da(i6);
            dc(i6);
            if (this.ajq != null) {
                this.ajq.de(getMiddleViewPosition());
            }
            this.ajh = this.aji;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void da(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        B(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        C(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void B(int i, int i2) {
        while (i + i2 < getWidth() && this.ajg < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.ajg, this.ajm.poll(), this);
            m(view, -1);
            i += view.getMeasuredWidth();
            if (this.ajg == this.mAdapter.getCount() - 1) {
                this.ajj = (this.ajh + i) - getWidth();
            }
            if (this.ajj < 0) {
                this.ajj = 0;
            }
            this.ajg++;
        }
    }

    private void C(int i, int i2) {
        while (i + i2 > 0 && this.ajf >= 0) {
            View view = this.mAdapter.getView(this.ajf, this.ajm.poll(), this);
            m(view, 0);
            i -= view.getMeasuredWidth();
            this.ajf--;
            this.ajk -= view.getMeasuredWidth();
        }
    }

    private void db(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.ajk += childAt.getMeasuredWidth();
            this.ajm.offer(childAt);
            removeViewInLayout(childAt);
            this.ajf++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.ajm.offer(childAt2);
            removeViewInLayout(childAt2);
            this.ajg--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void dc(int i) {
        if (getChildCount() > 0) {
            this.ajk += i;
            int i2 = this.ajk;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void dd(int i) {
        this.mScroller.startScroll(this.aji, 0, i - this.aji, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.ajl.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.aji, 0, (int) (-f), 0, 0, this.ajj, 0, 0);
        }
        requestLayout();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onDown(MotionEvent motionEvent) {
        this.mScroller.forceFinished(true);
        return true;
    }

    private int getMiddleViewPosition() {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getWidth() + childAt.getLeft() >= this.ajs) {
                    return i + 1 + this.ajf;
                }
            }
            return 0;
        }
        return 0;
    }
}
