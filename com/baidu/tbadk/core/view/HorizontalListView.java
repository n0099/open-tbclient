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
    public boolean adE;
    private int adF;
    private int adG;
    protected int adH;
    protected int adI;
    private int adJ;
    private int adK;
    private GestureDetector adL;
    private Queue<View> adM;
    private AdapterView.OnItemSelectedListener adN;
    private AdapterView.OnItemClickListener adO;
    private AdapterView.OnItemLongClickListener adP;
    private boolean adQ;
    private boolean adR;
    private boolean adS;
    private f.b adT;
    private DataSetObserver adU;
    private GestureDetector.OnGestureListener adV;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mLastMotionX;
    private float mLastMotionY;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adE = true;
        this.adF = -1;
        this.adG = 0;
        this.adJ = Integer.MAX_VALUE;
        this.adK = 0;
        this.adM = new LinkedList();
        this.adQ = false;
        this.adR = true;
        this.mActivePointerId = -1;
        this.adS = false;
        this.adU = new k(this);
        this.adV = new l(this);
        initView();
    }

    private synchronized void initView() {
        this.adF = -1;
        this.adG = 0;
        this.adK = 0;
        this.adH = 0;
        this.adI = 0;
        this.adJ = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.adL = new GestureDetector(getContext(), this.adV);
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.adT = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.adR = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.adR) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.adS) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.adS = false;
                if (this.adT != null) {
                    this.adT.od();
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
                        if (this.adT != null) {
                            this.adT.oe();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.adT != null) {
                        this.adT.od();
                        break;
                    }
                    break;
                case 2:
                    if (this.adT != null) {
                        this.adT.oe();
                    }
                    g(motionEvent);
                    if (this.adS) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.adR) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                this.mLastMotionX = motionEvent.getX();
                if (this.adT != null) {
                    this.adT.oe();
                    break;
                }
                break;
            case 1:
                this.adS = false;
                if (this.adT != null) {
                    this.adT.od();
                    break;
                }
                break;
            case 2:
                if (this.adT != null) {
                    this.adT.oe();
                }
                if (!this.adS) {
                    g(motionEvent);
                }
                if (this.adS && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.adT != null) {
                    this.adT.od();
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
                this.adS = true;
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
        this.adN = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.adO = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.adP = onItemLongClickListener;
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
            this.mAdapter.unregisterDataSetObserver(this.adU);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.adU);
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
        cB(childCount);
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
            if (this.adQ) {
                int i5 = this.adH;
                initView();
                removeAllViewsInLayout();
                this.adI = i5;
                this.adQ = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.adI = this.mScroller.getCurrX();
            }
            if (this.adI <= 0) {
                this.adI = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.adI >= this.adJ) {
                this.adI = this.adJ;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.adH - this.adI;
            cz(i6);
            cy(i6);
            cA(i6);
            this.adH = this.adI;
            if (!this.mScroller.isFinished()) {
                post(new m(this));
            }
        }
    }

    private void cy(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        z(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        A(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void z(int i, int i2) {
        while (i + i2 < getWidth() && this.adG < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.adG, this.adM.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.adG == this.mAdapter.getCount() - 1) {
                this.adJ = (this.adH + i) - getWidth();
            }
            if (this.adJ < 0) {
                this.adJ = 0;
            }
            this.adG++;
        }
    }

    private void A(int i, int i2) {
        while (i + i2 > 0 && this.adF >= 0) {
            View view = this.mAdapter.getView(this.adF, this.adM.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.adF--;
            this.adK -= view.getMeasuredWidth();
        }
    }

    private void cz(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.adK += childAt.getMeasuredWidth();
            this.adM.offer(childAt);
            removeViewInLayout(childAt);
            this.adF++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.adM.offer(childAt2);
            removeViewInLayout(childAt2);
            this.adG--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cA(int i) {
        if (getChildCount() > 0) {
            this.adK += i;
            int i2 = this.adK;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cB(int i) {
        this.mScroller.startScroll(this.adI, 0, i - this.adI, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.adL.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.adI, 0, (int) (-f), 0, 0, this.adJ, 0, 0);
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
