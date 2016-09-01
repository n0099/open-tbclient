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
    private boolean aeA;
    private int aeB;
    private boolean aeC;
    private boolean aeD;
    private f.b aeE;
    private DataSetObserver aeF;
    private GestureDetector.OnGestureListener aeG;
    public boolean aen;
    private int aeo;
    private int aep;
    protected int aeq;
    protected int aer;
    private int aes;
    private int aet;
    private GestureDetector aeu;
    private Queue<View> aev;
    private AdapterView.OnItemSelectedListener aew;
    private AdapterView.OnItemClickListener aex;
    private AdapterView.OnItemLongClickListener aey;
    private a aez;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
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
        this.aen = true;
        this.aeo = -1;
        this.aep = 0;
        this.aes = Integer.MAX_VALUE;
        this.aet = 0;
        this.aev = new LinkedList();
        this.aeA = false;
        this.aeB = 0;
        this.aeC = true;
        this.mActivePointerId = -1;
        this.aeD = false;
        this.aeF = new e(this);
        this.aeG = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.aeo = -1;
        this.aep = 0;
        this.aet = 0;
        this.aeq = 0;
        this.aer = 0;
        this.aes = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.aeu = new GestureDetector(getContext(), this.aeG);
        this.aeB = com.baidu.adp.lib.util.k.K(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.aeE = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aeC = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aeC) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.aeD) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.aeD = false;
                if (this.aeE != null) {
                    this.aeE.la();
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
                        if (this.aeE != null) {
                            this.aeE.lb();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.aeE != null) {
                        this.aeE.la();
                        break;
                    }
                    break;
                case 2:
                    if (this.aeE != null) {
                        this.aeE.lb();
                    }
                    e(motionEvent);
                    if (this.aeD) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aeC) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.aeE != null) {
                    this.aeE.lb();
                    break;
                }
                break;
            case 1:
                this.aeD = false;
                if (this.aeE != null) {
                    this.aeE.la();
                    break;
                }
                break;
            case 2:
                if (this.aeE != null) {
                    this.aeE.lb();
                }
                if (!this.aeD) {
                    e(motionEvent);
                }
                if (this.aeD && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.aeE != null) {
                    this.aeE.la();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void e(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i != -1) {
            try {
                float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                float y = MotionEventCompat.getY(motionEvent, pointerIndex);
                float abs = Math.abs(x - this.mInitialMotionX);
                float abs2 = Math.abs(y - this.mInitialMotionY);
                if (abs > this.mTouchSlop && abs > abs2) {
                    this.aeD = true;
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
        this.aew = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.aex = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.aey = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.aez = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.aeF);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.aeF);
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
            size = t(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int t(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.aev.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.aev.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.aeA) {
                int i5 = this.aeq;
                initView();
                removeAllViewsInLayout();
                this.aer = i5;
                this.aeA = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.aer = this.mScroller.getCurrX();
            }
            if (this.aer <= 0) {
                this.aer = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.aer >= this.aes) {
                this.aer = this.aes;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.aeq - this.aer;
            cY(i6);
            cX(i6);
            cZ(i6);
            if (this.aez != null) {
                this.aez.db(getMiddleViewPosition());
            }
            this.aeq = this.aer;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void cX(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        u(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        v(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void u(int i, int i2) {
        while (i + i2 < getWidth() && this.aep < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.aep, this.aev.poll(), this);
            n(view, -1);
            i += view.getMeasuredWidth();
            if (this.aep == this.mAdapter.getCount() - 1) {
                this.aes = (this.aeq + i) - getWidth();
            }
            if (this.aes < 0) {
                this.aes = 0;
            }
            this.aep++;
        }
    }

    private void v(int i, int i2) {
        while (i + i2 > 0 && this.aeo >= 0) {
            View view = this.mAdapter.getView(this.aeo, this.aev.poll(), this);
            n(view, 0);
            i -= view.getMeasuredWidth();
            this.aeo--;
            this.aet -= view.getMeasuredWidth();
        }
    }

    private void cY(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.aet += childAt.getMeasuredWidth();
            this.aev.offer(childAt);
            removeViewInLayout(childAt);
            this.aeo++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.aev.offer(childAt2);
            removeViewInLayout(childAt2);
            this.aep--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cZ(int i) {
        if (getChildCount() > 0) {
            this.aet += i;
            int i2 = this.aet;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void da(int i) {
        this.mScroller.startScroll(this.aer, 0, i - this.aer, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.aeu.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.aer, 0, (int) (-f), 0, 0, this.aes, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.aeB) {
                    return i + 1 + this.aeo;
                }
            }
            return 0;
        }
        return 0;
    }
}
