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
    private Queue<View> aiA;
    private AdapterView.OnItemSelectedListener aiB;
    private AdapterView.OnItemClickListener aiC;
    private AdapterView.OnItemLongClickListener aiD;
    private a aiE;
    private int aiF;
    private boolean aiG;
    private boolean aiH;
    private f.c aiI;
    private DataSetObserver aiJ;
    private GestureDetector.OnGestureListener aiK;
    public boolean ais;
    private int ait;
    private int aiu;
    protected int aiv;
    protected int aiw;
    private int aix;
    private int aiy;
    private GestureDetector aiz;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private boolean mDataChanged;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void db(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ais = true;
        this.ait = -1;
        this.aiu = 0;
        this.aix = Integer.MAX_VALUE;
        this.aiy = 0;
        this.aiA = new LinkedList();
        this.mDataChanged = false;
        this.aiF = 0;
        this.aiG = true;
        this.mActivePointerId = -1;
        this.aiH = false;
        this.aiJ = new e(this);
        this.aiK = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.ait = -1;
        this.aiu = 0;
        this.aiy = 0;
        this.aiv = 0;
        this.aiw = 0;
        this.aix = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.aiz = new GestureDetector(getContext(), this.aiK);
        this.aiF = com.baidu.adp.lib.util.k.af(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.aiI = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aiG = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aiG) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.aiH) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.aiH = false;
                if (this.aiI != null) {
                    this.aiI.lt();
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
                        if (this.aiI != null) {
                            this.aiI.lu();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.aiI != null) {
                        this.aiI.lt();
                        break;
                    }
                    break;
                case 2:
                    if (this.aiI != null) {
                        this.aiI.lu();
                    }
                    i(motionEvent);
                    if (this.aiH) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aiG) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.aiI != null) {
                    this.aiI.lu();
                    break;
                }
                break;
            case 1:
                this.aiH = false;
                if (this.aiI != null) {
                    this.aiI.lt();
                    break;
                }
                break;
            case 2:
                if (this.aiI != null) {
                    this.aiI.lu();
                }
                if (!this.aiH) {
                    i(motionEvent);
                }
                if (this.aiH && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.aiI != null) {
                    this.aiI.lt();
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
                    this.aiH = true;
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
        this.aiB = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.aiC = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.aiD = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.aiE = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.aiJ);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.aiJ);
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
        da(childCount);
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
            View poll = this.aiA.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.aiA.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.mDataChanged) {
                int i5 = this.aiv;
                initView();
                removeAllViewsInLayout();
                this.aiw = i5;
                this.mDataChanged = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.aiw = this.mScroller.getCurrX();
            }
            if (this.aiw <= 0) {
                this.aiw = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.aiw >= this.aix) {
                this.aiw = this.aix;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.aiv - this.aiw;
            cY(i6);
            cX(i6);
            cZ(i6);
            if (this.aiE != null) {
                this.aiE.db(getMiddleViewPosition());
            }
            this.aiv = this.aiw;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void cX(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        y(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        z(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void y(int i, int i2) {
        while (i + i2 < getWidth() && this.aiu < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.aiu, this.aiA.poll(), this);
            m(view, -1);
            i += view.getMeasuredWidth();
            if (this.aiu == this.mAdapter.getCount() - 1) {
                this.aix = (this.aiv + i) - getWidth();
            }
            if (this.aix < 0) {
                this.aix = 0;
            }
            this.aiu++;
        }
    }

    private void z(int i, int i2) {
        while (i + i2 > 0 && this.ait >= 0) {
            View view = this.mAdapter.getView(this.ait, this.aiA.poll(), this);
            m(view, 0);
            i -= view.getMeasuredWidth();
            this.ait--;
            this.aiy -= view.getMeasuredWidth();
        }
    }

    private void cY(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.aiy += childAt.getMeasuredWidth();
            this.aiA.offer(childAt);
            removeViewInLayout(childAt);
            this.ait++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.aiA.offer(childAt2);
            removeViewInLayout(childAt2);
            this.aiu--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cZ(int i) {
        if (getChildCount() > 0) {
            this.aiy += i;
            int i2 = this.aiy;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void da(int i) {
        this.mScroller.startScroll(this.aiw, 0, i - this.aiw, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.aiz.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.aiw, 0, (int) (-f), 0, 0, this.aix, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.aiF) {
                    return i + 1 + this.ait;
                }
            }
            return 0;
        }
        return 0;
    }
}
