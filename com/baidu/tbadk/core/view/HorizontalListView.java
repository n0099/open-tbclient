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
    public boolean YH;
    private int YI;
    private int YJ;
    protected int YK;
    protected int YL;
    private int YM;
    private GestureDetector YN;
    private Queue<View> YO;
    private AdapterView.OnItemSelectedListener YP;
    private AdapterView.OnItemClickListener YQ;
    private AdapterView.OnItemLongClickListener YR;
    private boolean YS;
    private boolean YT;
    private boolean YU;
    private com.baidu.adp.widget.t YV;
    private DataSetObserver YW;
    private GestureDetector.OnGestureListener YX;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxX;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YH = true;
        this.YI = -1;
        this.YJ = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.YM = 0;
        this.YO = new LinkedList();
        this.YS = false;
        this.YT = true;
        this.mActivePointerId = -1;
        this.YU = false;
        this.YW = new n(this);
        this.YX = new o(this);
        initView();
    }

    private synchronized void initView() {
        this.YI = -1;
        this.YJ = 0;
        this.YM = 0;
        this.YK = 0;
        this.YL = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.YN = new GestureDetector(getContext(), this.YX);
    }

    public void setSwipeControlInterface(com.baidu.adp.widget.t tVar) {
        this.YV = tVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.YT = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.YT) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.YU) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.YU = false;
                if (this.YV != null) {
                    this.YV.nU();
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
                        if (this.YV != null) {
                            this.YV.nV();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.YV != null) {
                        this.YV.nU();
                        break;
                    }
                    break;
                case 2:
                    if (this.YV != null) {
                        this.YV.nV();
                    }
                    h(motionEvent);
                    if (this.YU) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.YT) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                this.mLastMotionX = motionEvent.getX();
                if (this.YV != null) {
                    this.YV.nV();
                    break;
                }
                break;
            case 1:
                this.YU = false;
                if (this.YV != null) {
                    this.YV.nU();
                    break;
                }
                break;
            case 2:
                if (this.YV != null) {
                    this.YV.nV();
                }
                if (!this.YU) {
                    h(motionEvent);
                }
                if (this.YU && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.YV != null) {
                    this.YV.nU();
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
                this.YU = true;
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
        this.YP = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.YQ = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.YR = onItemLongClickListener;
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
            this.mAdapter.unregisterDataSetObserver(this.YW);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.YW);
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
        ct(childCount);
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
            if (this.YS) {
                int i5 = this.YK;
                initView();
                removeAllViewsInLayout();
                this.YL = i5;
                this.YS = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.YL = this.mScroller.getCurrX();
            }
            if (this.YL <= 0) {
                this.YL = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.YL >= this.mMaxX) {
                this.YL = this.mMaxX;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.YK - this.YL;
            cr(i6);
            cq(i6);
            cs(i6);
            this.YK = this.YL;
            if (!this.mScroller.isFinished()) {
                post(new p(this));
            }
        }
    }

    private void cq(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        p(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        q(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void p(int i, int i2) {
        while (i + i2 < getWidth() && this.YJ < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.YJ, this.YO.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.YJ == this.mAdapter.getCount() - 1) {
                this.mMaxX = (this.YK + i) - getWidth();
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.YJ++;
        }
    }

    private void q(int i, int i2) {
        while (i + i2 > 0 && this.YI >= 0) {
            View view = this.mAdapter.getView(this.YI, this.YO.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.YI--;
            this.YM -= view.getMeasuredWidth();
        }
    }

    private void cr(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.YM += childAt.getMeasuredWidth();
            this.YO.offer(childAt);
            removeViewInLayout(childAt);
            this.YI++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.YO.offer(childAt2);
            removeViewInLayout(childAt2);
            this.YJ--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cs(int i) {
        if (getChildCount() > 0) {
            this.YM += i;
            int i2 = this.YM;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void ct(int i) {
        this.mScroller.startScroll(this.YL, 0, i - this.YL, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.YN.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.YL, 0, (int) (-f), 0, 0, this.mMaxX, 0, 0);
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
