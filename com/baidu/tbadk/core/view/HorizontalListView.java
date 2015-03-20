package com.baidu.tbadk.core.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.MotionEventCompat;
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
    public boolean XS;
    private int XT;
    private int XU;
    protected int XV;
    protected int XW;
    private int XX;
    private GestureDetector XY;
    private Queue<View> XZ;
    private AdapterView.OnItemSelectedListener Ya;
    private AdapterView.OnItemClickListener Yb;
    private AdapterView.OnItemLongClickListener Yc;
    private boolean Yd;
    private boolean Ye;
    private boolean Yf;
    private com.baidu.adp.widget.t Yg;
    private DataSetObserver Yh;
    private GestureDetector.OnGestureListener Yi;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxX;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XS = true;
        this.XT = -1;
        this.XU = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.XX = 0;
        this.XZ = new LinkedList();
        this.Yd = false;
        this.Ye = true;
        this.mActivePointerId = -1;
        this.Yf = false;
        this.Yh = new m(this);
        this.Yi = new n(this);
        initView();
    }

    private synchronized void initView() {
        this.XT = -1;
        this.XU = 0;
        this.XX = 0;
        this.XV = 0;
        this.XW = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.XY = new GestureDetector(getContext(), this.Yi);
    }

    public void setSwipeControlInterface(com.baidu.adp.widget.t tVar) {
        this.Yg = tVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.Ye = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Ye) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.Yf) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.Yf = false;
                if (this.Yg != null) {
                    this.Yg.nD();
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            switch (action) {
                case 0:
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    if (this.mActivePointerId != -1) {
                        this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                        this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                        if (this.Yg != null) {
                            this.Yg.nE();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.Yg != null) {
                        this.Yg.nD();
                        break;
                    }
                    break;
                case 2:
                    if (this.Yg != null) {
                        this.Yg.nE();
                    }
                    h(motionEvent);
                    if (this.Yf) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ye) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                this.mLastMotionX = motionEvent.getX();
                if (this.Yg != null) {
                    this.Yg.nE();
                    break;
                }
                break;
            case 1:
                this.Yf = false;
                if (this.Yg != null) {
                    this.Yg.nD();
                    break;
                }
                break;
            case 2:
                if (this.Yg != null) {
                    this.Yg.nE();
                }
                if (!this.Yf) {
                    h(motionEvent);
                }
                if (this.Yf && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.Yg != null) {
                    this.Yg.nD();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void h(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i != -1) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float abs = Math.abs(x - this.mLastMotionX);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            if (abs > Math.abs(y - this.mLastMotionY)) {
                this.Yf = true;
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.Ya = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Yb = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.Yc = onItemLongClickListener;
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
            this.mAdapter.unregisterDataSetObserver(this.Yh);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.Yh);
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
        cp(childCount);
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
            if (this.Yd) {
                int i5 = this.XV;
                initView();
                removeAllViewsInLayout();
                this.XW = i5;
                this.Yd = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.XW = this.mScroller.getCurrX();
            }
            if (this.XW <= 0) {
                this.XW = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.XW >= this.mMaxX) {
                this.XW = this.mMaxX;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.XV - this.XW;
            cn(i6);
            cm(i6);
            co(i6);
            this.XV = this.XW;
            if (!this.mScroller.isFinished()) {
                post(new o(this));
            }
        }
    }

    private void cm(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        p(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        q(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void p(int i, int i2) {
        while (i + i2 < getWidth() && this.XU < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.XU, this.XZ.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.XU == this.mAdapter.getCount() - 1) {
                this.mMaxX = (this.XV + i) - getWidth();
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.XU++;
        }
    }

    private void q(int i, int i2) {
        while (i + i2 > 0 && this.XT >= 0) {
            View view = this.mAdapter.getView(this.XT, this.XZ.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.XT--;
            this.XX -= view.getMeasuredWidth();
        }
    }

    private void cn(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.XX += childAt.getMeasuredWidth();
            this.XZ.offer(childAt);
            removeViewInLayout(childAt);
            this.XT++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.XZ.offer(childAt2);
            removeViewInLayout(childAt2);
            this.XU--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void co(int i) {
        if (getChildCount() > 0) {
            this.XX += i;
            int i2 = this.XX;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cp(int i) {
        this.mScroller.startScroll(this.XW, 0, i - this.XW, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.XY.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.XW, 0, (int) (-f), 0, 0, this.mMaxX, 0, 0);
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
