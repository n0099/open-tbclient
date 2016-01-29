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
    private int afA;
    private int afB;
    private GestureDetector afC;
    private Queue<View> afD;
    private AdapterView.OnItemSelectedListener afE;
    private AdapterView.OnItemClickListener afF;
    private AdapterView.OnItemLongClickListener afG;
    private a afH;
    private boolean afI;
    private int afJ;
    private boolean afK;
    private boolean afL;
    private f.b afM;
    private DataSetObserver afN;
    private GestureDetector.OnGestureListener afO;
    public boolean afv;
    private int afw;
    private int afx;
    protected int afy;
    protected int afz;
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
        this.afv = true;
        this.afw = -1;
        this.afx = 0;
        this.afA = Integer.MAX_VALUE;
        this.afB = 0;
        this.afD = new LinkedList();
        this.afI = false;
        this.afJ = 0;
        this.afK = true;
        this.mActivePointerId = -1;
        this.afL = false;
        this.afN = new e(this);
        this.afO = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.afw = -1;
        this.afx = 0;
        this.afB = 0;
        this.afy = 0;
        this.afz = 0;
        this.afA = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.afC = new GestureDetector(getContext(), this.afO);
        this.afJ = com.baidu.adp.lib.util.k.K(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.afM = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.afK = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.afK) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.afL) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.afL = false;
                if (this.afM != null) {
                    this.afM.oa();
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
                        if (this.afM != null) {
                            this.afM.ob();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.afM != null) {
                        this.afM.oa();
                        break;
                    }
                    break;
                case 2:
                    if (this.afM != null) {
                        this.afM.ob();
                    }
                    c(motionEvent);
                    if (this.afL) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.afK) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.afM != null) {
                    this.afM.ob();
                    break;
                }
                break;
            case 1:
                this.afL = false;
                if (this.afM != null) {
                    this.afM.oa();
                    break;
                }
                break;
            case 2:
                if (this.afM != null) {
                    this.afM.ob();
                }
                if (!this.afL) {
                    c(motionEvent);
                }
                if (this.afL && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.afM != null) {
                    this.afM.oa();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void c(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i != -1) {
            try {
                float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                float y = MotionEventCompat.getY(motionEvent, pointerIndex);
                float abs = Math.abs(x - this.mInitialMotionX);
                float abs2 = Math.abs(y - this.mInitialMotionY);
                if (abs > this.mTouchSlop && abs > abs2) {
                    this.afL = true;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
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
        this.afE = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.afF = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.afG = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.afH = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.afN);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.afN);
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

    private void n(View view, int i) {
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
            View poll = this.afD.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.afD.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.afI) {
                int i5 = this.afy;
                initView();
                removeAllViewsInLayout();
                this.afz = i5;
                this.afI = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.afz = this.mScroller.getCurrX();
            }
            if (this.afz <= 0) {
                this.afz = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.afz >= this.afA) {
                this.afz = this.afA;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.afy - this.afz;
            cX(i6);
            cW(i6);
            cY(i6);
            if (this.afH != null) {
                this.afH.da(getMiddleViewPosition());
            }
            this.afy = this.afz;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void cW(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        v(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        w(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void v(int i, int i2) {
        while (i + i2 < getWidth() && this.afx < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.afx, this.afD.poll(), this);
            n(view, -1);
            i += view.getMeasuredWidth();
            if (this.afx == this.mAdapter.getCount() - 1) {
                this.afA = (this.afy + i) - getWidth();
            }
            if (this.afA < 0) {
                this.afA = 0;
            }
            this.afx++;
        }
    }

    private void w(int i, int i2) {
        while (i + i2 > 0 && this.afw >= 0) {
            View view = this.mAdapter.getView(this.afw, this.afD.poll(), this);
            n(view, 0);
            i -= view.getMeasuredWidth();
            this.afw--;
            this.afB -= view.getMeasuredWidth();
        }
    }

    private void cX(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.afB += childAt.getMeasuredWidth();
            this.afD.offer(childAt);
            removeViewInLayout(childAt);
            this.afw++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.afD.offer(childAt2);
            removeViewInLayout(childAt2);
            this.afx--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cY(int i) {
        if (getChildCount() > 0) {
            this.afB += i;
            int i2 = this.afB;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cZ(int i) {
        this.mScroller.startScroll(this.afz, 0, i - this.afz, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.afC.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.afz, 0, (int) (-f), 0, 0, this.afA, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.afJ) {
                    return i + 1 + this.afw;
                }
            }
            return 0;
        }
        return 0;
    }
}
