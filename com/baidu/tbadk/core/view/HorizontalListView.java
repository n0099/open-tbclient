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
import com.baidu.adp.widget.f;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public boolean adO;
    private int adP;
    private int adQ;
    protected int adR;
    protected int adS;
    private int adT;
    private int adU;
    private GestureDetector adV;
    private Queue<View> adW;
    private AdapterView.OnItemSelectedListener adX;
    private AdapterView.OnItemClickListener adY;
    private AdapterView.OnItemLongClickListener adZ;
    private boolean aea;
    private boolean aeb;
    private boolean aec;
    private f.b aed;
    private DataSetObserver aee;
    private GestureDetector.OnGestureListener aef;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mLastMotionX;
    private float mLastMotionY;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adO = true;
        this.adP = -1;
        this.adQ = 0;
        this.adT = Integer.MAX_VALUE;
        this.adU = 0;
        this.adW = new LinkedList();
        this.aea = false;
        this.aeb = true;
        this.mActivePointerId = -1;
        this.aec = false;
        this.aee = new k(this);
        this.aef = new l(this);
        initView();
    }

    private synchronized void initView() {
        this.adP = -1;
        this.adQ = 0;
        this.adU = 0;
        this.adR = 0;
        this.adS = 0;
        this.adT = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.adV = new GestureDetector(getContext(), this.aef);
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.aed = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aeb = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aeb) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.aec) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.aec = false;
                if (this.aed != null) {
                    this.aed.oa();
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
                        if (this.aed != null) {
                            this.aed.ob();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.aed != null) {
                        this.aed.oa();
                        break;
                    }
                    break;
                case 2:
                    if (this.aed != null) {
                        this.aed.ob();
                    }
                    g(motionEvent);
                    if (this.aec) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aeb) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                this.mLastMotionX = motionEvent.getX();
                if (this.aed != null) {
                    this.aed.ob();
                    break;
                }
                break;
            case 1:
                this.aec = false;
                if (this.aed != null) {
                    this.aed.oa();
                    break;
                }
                break;
            case 2:
                if (this.aed != null) {
                    this.aed.ob();
                }
                if (!this.aec) {
                    g(motionEvent);
                }
                if (this.aec && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.aed != null) {
                    this.aed.oa();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void g(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i != -1) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float abs = Math.abs(x - this.mLastMotionX);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            if (abs > Math.abs(y - this.mLastMotionY)) {
                this.aec = true;
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
        this.adX = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.adY = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.adZ = onItemLongClickListener;
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
            this.mAdapter.unregisterDataSetObserver(this.aee);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.aee);
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
        cH(childCount);
    }

    private void k(View view, int i) {
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
            if (this.aea) {
                int i5 = this.adR;
                initView();
                removeAllViewsInLayout();
                this.adS = i5;
                this.aea = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.adS = this.mScroller.getCurrX();
            }
            if (this.adS <= 0) {
                this.adS = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.adS >= this.adT) {
                this.adS = this.adT;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.adR - this.adS;
            cF(i6);
            cE(i6);
            cG(i6);
            this.adR = this.adS;
            if (!this.mScroller.isFinished()) {
                post(new m(this));
            }
        }
    }

    private void cE(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        z(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        A(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void z(int i, int i2) {
        while (i + i2 < getWidth() && this.adQ < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.adQ, this.adW.poll(), this);
            k(view, -1);
            i += view.getMeasuredWidth();
            if (this.adQ == this.mAdapter.getCount() - 1) {
                this.adT = (this.adR + i) - getWidth();
            }
            if (this.adT < 0) {
                this.adT = 0;
            }
            this.adQ++;
        }
    }

    private void A(int i, int i2) {
        while (i + i2 > 0 && this.adP >= 0) {
            View view = this.mAdapter.getView(this.adP, this.adW.poll(), this);
            k(view, 0);
            i -= view.getMeasuredWidth();
            this.adP--;
            this.adU -= view.getMeasuredWidth();
        }
    }

    private void cF(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.adU += childAt.getMeasuredWidth();
            this.adW.offer(childAt);
            removeViewInLayout(childAt);
            this.adP++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.adW.offer(childAt2);
            removeViewInLayout(childAt2);
            this.adQ--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cG(int i) {
        if (getChildCount() > 0) {
            this.adU += i;
            int i2 = this.adU;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cH(int i) {
        this.mScroller.startScroll(this.adS, 0, i - this.adS, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.adV.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.adS, 0, (int) (-f), 0, 0, this.adT, 0, 0);
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
