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
    public boolean ajd;
    private int aje;
    private int ajf;
    protected int ajg;
    protected int ajh;
    private int aji;
    private int ajj;
    private GestureDetector ajk;
    private Queue<View> ajl;
    private AdapterView.OnItemSelectedListener ajm;
    private AdapterView.OnItemClickListener ajn;
    private AdapterView.OnItemLongClickListener ajo;
    private a ajp;
    private boolean ajq;
    private int ajr;
    private boolean ajs;
    private boolean ajt;
    private f.c aju;
    private DataSetObserver ajv;
    private GestureDetector.OnGestureListener ajw;
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
        this.ajd = true;
        this.aje = -1;
        this.ajf = 0;
        this.aji = Integer.MAX_VALUE;
        this.ajj = 0;
        this.ajl = new LinkedList();
        this.ajq = false;
        this.ajr = 0;
        this.ajs = true;
        this.mActivePointerId = -1;
        this.ajt = false;
        this.ajv = new e(this);
        this.ajw = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.aje = -1;
        this.ajf = 0;
        this.ajj = 0;
        this.ajg = 0;
        this.ajh = 0;
        this.aji = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.ajk = new GestureDetector(getContext(), this.ajw);
        this.ajr = com.baidu.adp.lib.util.k.af(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.aju = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.ajs = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ajs) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.ajt) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.ajt = false;
                if (this.aju != null) {
                    this.aju.lT();
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
                        if (this.aju != null) {
                            this.aju.lU();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.aju != null) {
                        this.aju.lT();
                        break;
                    }
                    break;
                case 2:
                    if (this.aju != null) {
                        this.aju.lU();
                    }
                    i(motionEvent);
                    if (this.ajt) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ajs) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.aju != null) {
                    this.aju.lU();
                    break;
                }
                break;
            case 1:
                this.ajt = false;
                if (this.aju != null) {
                    this.aju.lT();
                    break;
                }
                break;
            case 2:
                if (this.aju != null) {
                    this.aju.lU();
                }
                if (!this.ajt) {
                    i(motionEvent);
                }
                if (this.ajt && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.aju != null) {
                    this.aju.lT();
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
                    this.ajt = true;
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
        this.ajm = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ajn = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.ajo = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.ajp = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.ajv);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.ajv);
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
            View poll = this.ajl.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.ajl.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.ajq) {
                int i5 = this.ajg;
                initView();
                removeAllViewsInLayout();
                this.ajh = i5;
                this.ajq = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.ajh = this.mScroller.getCurrX();
            }
            if (this.ajh <= 0) {
                this.ajh = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.ajh >= this.aji) {
                this.ajh = this.aji;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.ajg - this.ajh;
            db(i6);
            da(i6);
            dc(i6);
            if (this.ajp != null) {
                this.ajp.de(getMiddleViewPosition());
            }
            this.ajg = this.ajh;
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
        while (i + i2 < getWidth() && this.ajf < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.ajf, this.ajl.poll(), this);
            m(view, -1);
            i += view.getMeasuredWidth();
            if (this.ajf == this.mAdapter.getCount() - 1) {
                this.aji = (this.ajg + i) - getWidth();
            }
            if (this.aji < 0) {
                this.aji = 0;
            }
            this.ajf++;
        }
    }

    private void C(int i, int i2) {
        while (i + i2 > 0 && this.aje >= 0) {
            View view = this.mAdapter.getView(this.aje, this.ajl.poll(), this);
            m(view, 0);
            i -= view.getMeasuredWidth();
            this.aje--;
            this.ajj -= view.getMeasuredWidth();
        }
    }

    private void db(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.ajj += childAt.getMeasuredWidth();
            this.ajl.offer(childAt);
            removeViewInLayout(childAt);
            this.aje++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.ajl.offer(childAt2);
            removeViewInLayout(childAt2);
            this.ajf--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void dc(int i) {
        if (getChildCount() > 0) {
            this.ajj += i;
            int i2 = this.ajj;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void dd(int i) {
        this.mScroller.startScroll(this.ajh, 0, i - this.ajh, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.ajk.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.ajh, 0, (int) (-f), 0, 0, this.aji, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.ajr) {
                    return i + 1 + this.aje;
                }
            }
            return 0;
        }
        return 0;
    }
}
