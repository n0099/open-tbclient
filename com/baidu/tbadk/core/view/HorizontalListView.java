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
    public boolean aiB;
    private int aiC;
    private int aiD;
    protected int aiE;
    protected int aiF;
    private int aiG;
    private int aiH;
    private GestureDetector aiI;
    private Queue<View> aiJ;
    private AdapterView.OnItemSelectedListener aiK;
    private AdapterView.OnItemClickListener aiL;
    private AdapterView.OnItemLongClickListener aiM;
    private a aiN;
    private boolean aiO;
    private int aiP;
    private boolean aiQ;
    private boolean aiR;
    private f.c aiS;
    private DataSetObserver aiT;
    private GestureDetector.OnGestureListener aiU;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void da(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiB = true;
        this.aiC = -1;
        this.aiD = 0;
        this.aiG = Integer.MAX_VALUE;
        this.aiH = 0;
        this.aiJ = new LinkedList();
        this.aiO = false;
        this.aiP = 0;
        this.aiQ = true;
        this.mActivePointerId = -1;
        this.aiR = false;
        this.aiT = new e(this);
        this.aiU = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.aiC = -1;
        this.aiD = 0;
        this.aiH = 0;
        this.aiE = 0;
        this.aiF = 0;
        this.aiG = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.aiI = new GestureDetector(getContext(), this.aiU);
        this.aiP = com.baidu.adp.lib.util.k.af(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.aiS = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aiQ = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aiQ) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.aiR) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.aiR = false;
                if (this.aiS != null) {
                    this.aiS.lB();
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
                        if (this.aiS != null) {
                            this.aiS.lC();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.aiS != null) {
                        this.aiS.lB();
                        break;
                    }
                    break;
                case 2:
                    if (this.aiS != null) {
                        this.aiS.lC();
                    }
                    i(motionEvent);
                    if (this.aiR) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aiQ) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.aiS != null) {
                    this.aiS.lC();
                    break;
                }
                break;
            case 1:
                this.aiR = false;
                if (this.aiS != null) {
                    this.aiS.lB();
                    break;
                }
                break;
            case 2:
                if (this.aiS != null) {
                    this.aiS.lC();
                }
                if (!this.aiR) {
                    i(motionEvent);
                }
                if (this.aiR && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.aiS != null) {
                    this.aiS.lB();
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
                    this.aiR = true;
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
        this.aiK = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.aiL = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.aiM = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.aiN = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.aiT);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.aiT);
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
        cZ(childCount);
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
            size = y(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int y(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.aiJ.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.aiJ.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.aiO) {
                int i5 = this.aiE;
                initView();
                removeAllViewsInLayout();
                this.aiF = i5;
                this.aiO = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.aiF = this.mScroller.getCurrX();
            }
            if (this.aiF <= 0) {
                this.aiF = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.aiF >= this.aiG) {
                this.aiF = this.aiG;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.aiE - this.aiF;
            cX(i6);
            cW(i6);
            cY(i6);
            if (this.aiN != null) {
                this.aiN.da(getMiddleViewPosition());
            }
            this.aiE = this.aiF;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void cW(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        z(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        A(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void z(int i, int i2) {
        while (i + i2 < getWidth() && this.aiD < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.aiD, this.aiJ.poll(), this);
            m(view, -1);
            i += view.getMeasuredWidth();
            if (this.aiD == this.mAdapter.getCount() - 1) {
                this.aiG = (this.aiE + i) - getWidth();
            }
            if (this.aiG < 0) {
                this.aiG = 0;
            }
            this.aiD++;
        }
    }

    private void A(int i, int i2) {
        while (i + i2 > 0 && this.aiC >= 0) {
            View view = this.mAdapter.getView(this.aiC, this.aiJ.poll(), this);
            m(view, 0);
            i -= view.getMeasuredWidth();
            this.aiC--;
            this.aiH -= view.getMeasuredWidth();
        }
    }

    private void cX(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.aiH += childAt.getMeasuredWidth();
            this.aiJ.offer(childAt);
            removeViewInLayout(childAt);
            this.aiC++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.aiJ.offer(childAt2);
            removeViewInLayout(childAt2);
            this.aiD--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cY(int i) {
        if (getChildCount() > 0) {
            this.aiH += i;
            int i2 = this.aiH;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cZ(int i) {
        this.mScroller.startScroll(this.aiF, 0, i - this.aiF, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.aiI.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.aiF, 0, (int) (-f), 0, 0, this.aiG, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.aiP) {
                    return i + 1 + this.aiC;
                }
            }
            return 0;
        }
        return 0;
    }
}
