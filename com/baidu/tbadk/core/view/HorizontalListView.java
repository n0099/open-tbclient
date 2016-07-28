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
    protected int abA;
    protected int abB;
    private int abC;
    private int abD;
    private GestureDetector abE;
    private Queue<View> abF;
    private AdapterView.OnItemSelectedListener abG;
    private AdapterView.OnItemClickListener abH;
    private AdapterView.OnItemLongClickListener abI;
    private a abJ;
    private boolean abK;
    private int abL;
    private boolean abM;
    private boolean abN;
    private f.b abO;
    private DataSetObserver abP;
    private GestureDetector.OnGestureListener abQ;
    public boolean abx;
    private int aby;
    private int abz;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void cN(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abx = true;
        this.aby = -1;
        this.abz = 0;
        this.abC = Integer.MAX_VALUE;
        this.abD = 0;
        this.abF = new LinkedList();
        this.abK = false;
        this.abL = 0;
        this.abM = true;
        this.mActivePointerId = -1;
        this.abN = false;
        this.abP = new e(this);
        this.abQ = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.aby = -1;
        this.abz = 0;
        this.abD = 0;
        this.abA = 0;
        this.abB = 0;
        this.abC = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.abE = new GestureDetector(getContext(), this.abQ);
        this.abL = com.baidu.adp.lib.util.k.A(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.abO = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.abM = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.abM) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.abN) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.abN = false;
                if (this.abO != null) {
                    this.abO.kf();
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
                        if (this.abO != null) {
                            this.abO.kg();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.abO != null) {
                        this.abO.kf();
                        break;
                    }
                    break;
                case 2:
                    if (this.abO != null) {
                        this.abO.kg();
                    }
                    c(motionEvent);
                    if (this.abN) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.abM) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.abO != null) {
                    this.abO.kg();
                    break;
                }
                break;
            case 1:
                this.abN = false;
                if (this.abO != null) {
                    this.abO.kf();
                    break;
                }
                break;
            case 2:
                if (this.abO != null) {
                    this.abO.kg();
                }
                if (!this.abN) {
                    c(motionEvent);
                }
                if (this.abN && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.abO != null) {
                    this.abO.kf();
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
                    this.abN = true;
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
        this.abG = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.abH = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.abI = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.abJ = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.abP);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.abP);
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
        cM(childCount);
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
            size = r(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int r(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.abF.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.abF.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.abK) {
                int i5 = this.abA;
                initView();
                removeAllViewsInLayout();
                this.abB = i5;
                this.abK = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.abB = this.mScroller.getCurrX();
            }
            if (this.abB <= 0) {
                this.abB = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.abB >= this.abC) {
                this.abB = this.abC;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.abA - this.abB;
            cK(i6);
            cJ(i6);
            cL(i6);
            if (this.abJ != null) {
                this.abJ.cN(getMiddleViewPosition());
            }
            this.abA = this.abB;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void cJ(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        s(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        t(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void s(int i, int i2) {
        while (i + i2 < getWidth() && this.abz < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.abz, this.abF.poll(), this);
            n(view, -1);
            i += view.getMeasuredWidth();
            if (this.abz == this.mAdapter.getCount() - 1) {
                this.abC = (this.abA + i) - getWidth();
            }
            if (this.abC < 0) {
                this.abC = 0;
            }
            this.abz++;
        }
    }

    private void t(int i, int i2) {
        while (i + i2 > 0 && this.aby >= 0) {
            View view = this.mAdapter.getView(this.aby, this.abF.poll(), this);
            n(view, 0);
            i -= view.getMeasuredWidth();
            this.aby--;
            this.abD -= view.getMeasuredWidth();
        }
    }

    private void cK(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.abD += childAt.getMeasuredWidth();
            this.abF.offer(childAt);
            removeViewInLayout(childAt);
            this.aby++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.abF.offer(childAt2);
            removeViewInLayout(childAt2);
            this.abz--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cL(int i) {
        if (getChildCount() > 0) {
            this.abD += i;
            int i2 = this.abD;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cM(int i) {
        this.mScroller.startScroll(this.abB, 0, i - this.abB, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.abE.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.abB, 0, (int) (-f), 0, 0, this.abC, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.abL) {
                    return i + 1 + this.aby;
                }
            }
            return 0;
        }
        return 0;
    }
}
