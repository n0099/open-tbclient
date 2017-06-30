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
    public boolean aja;
    private int ajb;
    private int ajc;
    protected int ajd;
    protected int aje;
    private int ajf;
    private int ajg;
    private GestureDetector ajh;
    private Queue<View> aji;
    private AdapterView.OnItemSelectedListener ajj;
    private AdapterView.OnItemClickListener ajk;
    private AdapterView.OnItemLongClickListener ajl;
    private a ajm;
    private int ajn;
    private boolean ajo;
    private boolean ajp;
    private f.c ajq;
    private DataSetObserver ajr;
    private GestureDetector.OnGestureListener ajs;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private boolean mDataChanged;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void dd(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aja = true;
        this.ajb = -1;
        this.ajc = 0;
        this.ajf = Integer.MAX_VALUE;
        this.ajg = 0;
        this.aji = new LinkedList();
        this.mDataChanged = false;
        this.ajn = 0;
        this.ajo = true;
        this.mActivePointerId = -1;
        this.ajp = false;
        this.ajr = new e(this);
        this.ajs = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.ajb = -1;
        this.ajc = 0;
        this.ajg = 0;
        this.ajd = 0;
        this.aje = 0;
        this.ajf = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.ajh = new GestureDetector(getContext(), this.ajs);
        this.ajn = com.baidu.adp.lib.util.k.af(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.ajq = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.ajo = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ajo) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.ajp) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.ajp = false;
                if (this.ajq != null) {
                    this.ajq.lr();
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
                        if (this.ajq != null) {
                            this.ajq.ls();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.ajq != null) {
                        this.ajq.lr();
                        break;
                    }
                    break;
                case 2:
                    if (this.ajq != null) {
                        this.ajq.ls();
                    }
                    i(motionEvent);
                    if (this.ajp) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ajo) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.ajq != null) {
                    this.ajq.ls();
                    break;
                }
                break;
            case 1:
                this.ajp = false;
                if (this.ajq != null) {
                    this.ajq.lr();
                    break;
                }
                break;
            case 2:
                if (this.ajq != null) {
                    this.ajq.ls();
                }
                if (!this.ajp) {
                    i(motionEvent);
                }
                if (this.ajp && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.ajq != null) {
                    this.ajq.lr();
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
                    this.ajp = true;
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
        this.ajj = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ajk = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.ajl = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.ajm = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.ajr);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.ajr);
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
        dc(childCount);
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
            size = x(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int x(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.aji.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.aji.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.mDataChanged) {
                int i5 = this.ajd;
                initView();
                removeAllViewsInLayout();
                this.aje = i5;
                this.mDataChanged = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.aje = this.mScroller.getCurrX();
            }
            if (this.aje <= 0) {
                this.aje = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.aje >= this.ajf) {
                this.aje = this.ajf;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.ajd - this.aje;
            da(i6);
            cZ(i6);
            db(i6);
            if (this.ajm != null) {
                this.ajm.dd(getMiddleViewPosition());
            }
            this.ajd = this.aje;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void cZ(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        y(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        z(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void y(int i, int i2) {
        while (i + i2 < getWidth() && this.ajc < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.ajc, this.aji.poll(), this);
            m(view, -1);
            i += view.getMeasuredWidth();
            if (this.ajc == this.mAdapter.getCount() - 1) {
                this.ajf = (this.ajd + i) - getWidth();
            }
            if (this.ajf < 0) {
                this.ajf = 0;
            }
            this.ajc++;
        }
    }

    private void z(int i, int i2) {
        while (i + i2 > 0 && this.ajb >= 0) {
            View view = this.mAdapter.getView(this.ajb, this.aji.poll(), this);
            m(view, 0);
            i -= view.getMeasuredWidth();
            this.ajb--;
            this.ajg -= view.getMeasuredWidth();
        }
    }

    private void da(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.ajg += childAt.getMeasuredWidth();
            this.aji.offer(childAt);
            removeViewInLayout(childAt);
            this.ajb++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.aji.offer(childAt2);
            removeViewInLayout(childAt2);
            this.ajc--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void db(int i) {
        if (getChildCount() > 0) {
            this.ajg += i;
            int i2 = this.ajg;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void dc(int i) {
        this.mScroller.startScroll(this.aje, 0, i - this.aje, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.ajh.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.aje, 0, (int) (-f), 0, 0, this.ajf, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.ajn) {
                    return i + 1 + this.ajb;
                }
            }
            return 0;
        }
        return 0;
    }
}
