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
    public boolean XU;
    private int XV;
    private int XW;
    protected int XX;
    protected int XY;
    private int XZ;
    private GestureDetector Ya;
    private Queue<View> Yb;
    private AdapterView.OnItemSelectedListener Yc;
    private AdapterView.OnItemClickListener Yd;
    private AdapterView.OnItemLongClickListener Ye;
    private boolean Yf;
    private boolean Yg;
    private boolean Yh;
    private com.baidu.adp.widget.t Yi;
    private DataSetObserver Yj;
    private GestureDetector.OnGestureListener Yk;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxX;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XU = true;
        this.XV = -1;
        this.XW = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.XZ = 0;
        this.Yb = new LinkedList();
        this.Yf = false;
        this.Yg = true;
        this.mActivePointerId = -1;
        this.Yh = false;
        this.Yj = new m(this);
        this.Yk = new n(this);
        initView();
    }

    private synchronized void initView() {
        this.XV = -1;
        this.XW = 0;
        this.XZ = 0;
        this.XX = 0;
        this.XY = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.Ya = new GestureDetector(getContext(), this.Yk);
    }

    public void setSwipeControlInterface(com.baidu.adp.widget.t tVar) {
        this.Yi = tVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.Yg = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Yg) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.Yh) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.Yh = false;
                if (this.Yi != null) {
                    this.Yi.nD();
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
                        if (this.Yi != null) {
                            this.Yi.nE();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.Yi != null) {
                        this.Yi.nD();
                        break;
                    }
                    break;
                case 2:
                    if (this.Yi != null) {
                        this.Yi.nE();
                    }
                    h(motionEvent);
                    if (this.Yh) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Yg) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                this.mLastMotionX = motionEvent.getX();
                if (this.Yi != null) {
                    this.Yi.nE();
                    break;
                }
                break;
            case 1:
                this.Yh = false;
                if (this.Yi != null) {
                    this.Yi.nD();
                    break;
                }
                break;
            case 2:
                if (this.Yi != null) {
                    this.Yi.nE();
                }
                if (!this.Yh) {
                    h(motionEvent);
                }
                if (this.Yh && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.Yi != null) {
                    this.Yi.nD();
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
                this.Yh = true;
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
        this.Yc = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Yd = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.Ye = onItemLongClickListener;
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
            this.mAdapter.unregisterDataSetObserver(this.Yj);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.Yj);
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
            if (this.Yf) {
                int i5 = this.XX;
                initView();
                removeAllViewsInLayout();
                this.XY = i5;
                this.Yf = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.XY = this.mScroller.getCurrX();
            }
            if (this.XY <= 0) {
                this.XY = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.XY >= this.mMaxX) {
                this.XY = this.mMaxX;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.XX - this.XY;
            cn(i6);
            cm(i6);
            co(i6);
            this.XX = this.XY;
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
        while (i + i2 < getWidth() && this.XW < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.XW, this.Yb.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.XW == this.mAdapter.getCount() - 1) {
                this.mMaxX = (this.XX + i) - getWidth();
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.XW++;
        }
    }

    private void q(int i, int i2) {
        while (i + i2 > 0 && this.XV >= 0) {
            View view = this.mAdapter.getView(this.XV, this.Yb.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.XV--;
            this.XZ -= view.getMeasuredWidth();
        }
    }

    private void cn(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.XZ += childAt.getMeasuredWidth();
            this.Yb.offer(childAt);
            removeViewInLayout(childAt);
            this.XV++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.Yb.offer(childAt2);
            removeViewInLayout(childAt2);
            this.XW--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void co(int i) {
        if (getChildCount() > 0) {
            this.XZ += i;
            int i2 = this.XZ;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cp(int i) {
        this.mScroller.startScroll(this.XY, 0, i - this.XY, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.Ya.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.XY, 0, (int) (-f), 0, 0, this.mMaxX, 0, 0);
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
