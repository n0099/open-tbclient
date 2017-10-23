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
    public boolean akb;
    private int akc;
    private int akd;
    protected int ake;
    protected int akf;
    private int akg;
    private int akh;
    private GestureDetector aki;
    private Queue<View> akj;
    private AdapterView.OnItemSelectedListener akk;
    private AdapterView.OnItemClickListener akl;
    private AdapterView.OnItemLongClickListener akm;
    private a akn;
    private int ako;
    private boolean akp;
    private boolean akq;
    private d.c akr;
    private DataSetObserver aks;
    private GestureDetector.OnGestureListener akt;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private boolean mDataChanged;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void dh(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akb = true;
        this.akc = -1;
        this.akd = 0;
        this.akg = Integer.MAX_VALUE;
        this.akh = 0;
        this.akj = new LinkedList();
        this.mDataChanged = false;
        this.ako = 0;
        this.akp = true;
        this.mActivePointerId = -1;
        this.akq = false;
        this.aks = new DataSetObserver() { // from class: com.baidu.tbadk.core.view.HorizontalListView.1
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
        this.akt = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.core.view.HorizontalListView.3
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
                    HorizontalListView.this.akf += (int) f;
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
                            if (HorizontalListView.this.akl != null) {
                                HorizontalListView.this.akl.onItemClick(HorizontalListView.this, childAt, HorizontalListView.this.akc + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.akc + 1 + i2));
                            }
                            if (HorizontalListView.this.akk != null) {
                                HorizontalListView.this.akk.onItemSelected(HorizontalListView.this, childAt, HorizontalListView.this.akc + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.akc + 1 + i2));
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
                        if (HorizontalListView.this.akm != null) {
                            HorizontalListView.this.akm.onItemLongClick(HorizontalListView.this, childAt, HorizontalListView.this.akc + 1 + i, HorizontalListView.this.mAdapter.getItemId(i + HorizontalListView.this.akc + 1));
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
        this.akc = -1;
        this.akd = 0;
        this.akh = 0;
        this.ake = 0;
        this.akf = 0;
        this.akg = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.aki = new GestureDetector(getContext(), this.akt);
        this.ako = l.ad(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(d.c cVar) {
        this.akr = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.akp = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.akp) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.akq) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.akq = false;
                if (this.akr != null) {
                    this.akr.ls();
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
                        if (this.akr != null) {
                            this.akr.lt();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.akr != null) {
                        this.akr.ls();
                        break;
                    }
                    break;
                case 2:
                    if (this.akr != null) {
                        this.akr.lt();
                    }
                    i(motionEvent);
                    if (this.akq) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.akp) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.akr != null) {
                    this.akr.lt();
                    break;
                }
                break;
            case 1:
                this.akq = false;
                if (this.akr != null) {
                    this.akr.ls();
                    break;
                }
                break;
            case 2:
                if (this.akr != null) {
                    this.akr.lt();
                }
                if (!this.akq) {
                    i(motionEvent);
                }
                if (this.akq && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.akr != null) {
                    this.akr.ls();
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
                    this.akq = true;
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
        this.akk = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.akl = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.akm = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.akn = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.aks);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.aks);
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
        dg(childCount);
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
            View poll = this.akj.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.akj.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.mDataChanged) {
                int i5 = this.ake;
                initView();
                removeAllViewsInLayout();
                this.akf = i5;
                this.mDataChanged = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.akf = this.mScroller.getCurrX();
            }
            if (this.akf <= 0) {
                this.akf = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.akf >= this.akg) {
                this.akf = this.akg;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.ake - this.akf;
            de(i6);
            dd(i6);
            df(i6);
            if (this.akn != null) {
                this.akn.dh(getMiddleViewPosition());
            }
            this.ake = this.akf;
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

    private void dd(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        A(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        B(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void A(int i, int i2) {
        while (i + i2 < getWidth() && this.akd < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.akd, this.akj.poll(), this);
            m(view, -1);
            i += view.getMeasuredWidth();
            if (this.akd == this.mAdapter.getCount() - 1) {
                this.akg = (this.ake + i) - getWidth();
            }
            if (this.akg < 0) {
                this.akg = 0;
            }
            this.akd++;
        }
    }

    private void B(int i, int i2) {
        while (i + i2 > 0 && this.akc >= 0) {
            View view = this.mAdapter.getView(this.akc, this.akj.poll(), this);
            m(view, 0);
            i -= view.getMeasuredWidth();
            this.akc--;
            this.akh -= view.getMeasuredWidth();
        }
    }

    private void de(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.akh += childAt.getMeasuredWidth();
            this.akj.offer(childAt);
            removeViewInLayout(childAt);
            this.akc++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.akj.offer(childAt2);
            removeViewInLayout(childAt2);
            this.akd--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void df(int i) {
        if (getChildCount() > 0) {
            this.akh += i;
            int i2 = this.akh;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void dg(int i) {
        this.mScroller.startScroll(this.akf, 0, i - this.akf, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.aki.onTouchEvent(motionEvent);
    }

    protected boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.akf, 0, (int) (-f), 0, 0, this.akg, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.ako) {
                    return i + 1 + this.akc;
                }
            }
            return 0;
        }
        return 0;
    }
}
