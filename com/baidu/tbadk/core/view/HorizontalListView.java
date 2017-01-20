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
    public boolean adA;
    private int adB;
    private int adC;
    protected int adD;
    protected int adE;
    private int adF;
    private int adG;
    private GestureDetector adH;
    private Queue<View> adI;
    private AdapterView.OnItemSelectedListener adJ;
    private AdapterView.OnItemClickListener adK;
    private AdapterView.OnItemLongClickListener adL;
    private a adM;
    private boolean adN;
    private int adO;
    private boolean adP;
    private boolean adQ;
    private f.c adR;
    private DataSetObserver adS;
    private GestureDetector.OnGestureListener adT;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void df(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adA = true;
        this.adB = -1;
        this.adC = 0;
        this.adF = Integer.MAX_VALUE;
        this.adG = 0;
        this.adI = new LinkedList();
        this.adN = false;
        this.adO = 0;
        this.adP = true;
        this.mActivePointerId = -1;
        this.adQ = false;
        this.adS = new e(this);
        this.adT = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.adB = -1;
        this.adC = 0;
        this.adG = 0;
        this.adD = 0;
        this.adE = 0;
        this.adF = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.adH = new GestureDetector(getContext(), this.adT);
        this.adO = com.baidu.adp.lib.util.k.I(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.adR = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.adP = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.adP) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.adQ) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.adQ = false;
                if (this.adR != null) {
                    this.adR.kV();
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
                        if (this.adR != null) {
                            this.adR.kW();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.adR != null) {
                        this.adR.kV();
                        break;
                    }
                    break;
                case 2:
                    if (this.adR != null) {
                        this.adR.kW();
                    }
                    e(motionEvent);
                    if (this.adQ) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.adP) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.adR != null) {
                    this.adR.kW();
                    break;
                }
                break;
            case 1:
                this.adQ = false;
                if (this.adR != null) {
                    this.adR.kV();
                    break;
                }
                break;
            case 2:
                if (this.adR != null) {
                    this.adR.kW();
                }
                if (!this.adQ) {
                    e(motionEvent);
                }
                if (this.adQ && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.adR != null) {
                    this.adR.kV();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void e(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int c = c(motionEvent, i);
        if (i != -1) {
            try {
                float x = MotionEventCompat.getX(motionEvent, c);
                float y = MotionEventCompat.getY(motionEvent, c);
                float abs = Math.abs(x - this.mInitialMotionX);
                float abs2 = Math.abs(y - this.mInitialMotionY);
                if (abs > this.mTouchSlop && abs > abs2) {
                    this.adQ = true;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private int c(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.adJ = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.adK = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.adL = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.adM = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.adS);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.adS);
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
        de(childCount);
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
            size = u(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int u(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.adI.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.adI.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.adN) {
                int i5 = this.adD;
                initView();
                removeAllViewsInLayout();
                this.adE = i5;
                this.adN = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.adE = this.mScroller.getCurrX();
            }
            if (this.adE <= 0) {
                this.adE = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.adE >= this.adF) {
                this.adE = this.adF;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.adD - this.adE;
            dc(i6);
            db(i6);
            dd(i6);
            if (this.adM != null) {
                this.adM.df(getMiddleViewPosition());
            }
            this.adD = this.adE;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void db(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        v(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        w(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void v(int i, int i2) {
        while (i + i2 < getWidth() && this.adC < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.adC, this.adI.poll(), this);
            m(view, -1);
            i += view.getMeasuredWidth();
            if (this.adC == this.mAdapter.getCount() - 1) {
                this.adF = (this.adD + i) - getWidth();
            }
            if (this.adF < 0) {
                this.adF = 0;
            }
            this.adC++;
        }
    }

    private void w(int i, int i2) {
        while (i + i2 > 0 && this.adB >= 0) {
            View view = this.mAdapter.getView(this.adB, this.adI.poll(), this);
            m(view, 0);
            i -= view.getMeasuredWidth();
            this.adB--;
            this.adG -= view.getMeasuredWidth();
        }
    }

    private void dc(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.adG += childAt.getMeasuredWidth();
            this.adI.offer(childAt);
            removeViewInLayout(childAt);
            this.adB++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.adI.offer(childAt2);
            removeViewInLayout(childAt2);
            this.adC--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void dd(int i) {
        if (getChildCount() > 0) {
            this.adG += i;
            int i2 = this.adG;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void de(int i) {
        this.mScroller.startScroll(this.adE, 0, i - this.adE, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.adH.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.adE, 0, (int) (-f), 0, 0, this.adF, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.adO) {
                    return i + 1 + this.adB;
                }
            }
            return 0;
        }
        return 0;
    }
}
