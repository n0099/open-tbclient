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
    public boolean aeb;
    private int aec;
    private int aed;
    protected int aee;
    protected int aef;
    private int aeg;
    private int aeh;
    private GestureDetector aei;
    private Queue<View> aej;
    private AdapterView.OnItemSelectedListener aek;
    private AdapterView.OnItemClickListener ael;
    private AdapterView.OnItemLongClickListener aem;
    private a aen;
    private boolean aeo;
    private int aep;
    private boolean aeq;
    private boolean aer;
    private f.b aes;
    private DataSetObserver aet;
    private GestureDetector.OnGestureListener aeu;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mLastMotionX;
    private float mLastMotionY;
    protected Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void cQ(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeb = true;
        this.aec = -1;
        this.aed = 0;
        this.aeg = Integer.MAX_VALUE;
        this.aeh = 0;
        this.aej = new LinkedList();
        this.aeo = false;
        this.aep = 0;
        this.aeq = true;
        this.mActivePointerId = -1;
        this.aer = false;
        this.aet = new d(this);
        this.aeu = new e(this);
        initView();
    }

    private synchronized void initView() {
        this.aec = -1;
        this.aed = 0;
        this.aeh = 0;
        this.aee = 0;
        this.aef = 0;
        this.aeg = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.aei = new GestureDetector(getContext(), this.aeu);
        this.aep = com.baidu.adp.lib.util.k.K(getContext()) / 2;
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.aes = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aeq = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aeq) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.aer) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.aer = false;
                if (this.aes != null) {
                    this.aes.oi();
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
                        if (this.aes != null) {
                            this.aes.oj();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.aes != null) {
                        this.aes.oi();
                        break;
                    }
                    break;
                case 2:
                    if (this.aes != null) {
                        this.aes.oj();
                    }
                    g(motionEvent);
                    if (this.aer) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aeq) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                this.mLastMotionX = motionEvent.getX();
                if (this.aes != null) {
                    this.aes.oj();
                    break;
                }
                break;
            case 1:
                this.aer = false;
                if (this.aes != null) {
                    this.aes.oi();
                    break;
                }
                break;
            case 2:
                if (this.aes != null) {
                    this.aes.oj();
                }
                if (!this.aer) {
                    g(motionEvent);
                }
                if (this.aer && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.aes != null) {
                    this.aes.oi();
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
            try {
                float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                float y = MotionEventCompat.getY(motionEvent, pointerIndex);
                if (Math.abs(x - this.mLastMotionX) > Math.abs(y - this.mLastMotionY)) {
                    this.aer = true;
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
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
        this.aek = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ael = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.aem = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.aen = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.aet);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.aet);
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
        cP(childCount);
    }

    private void l(View view, int i) {
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
            size = z(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int z(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.aej.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.aej.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.aeo) {
                int i5 = this.aee;
                initView();
                removeAllViewsInLayout();
                this.aef = i5;
                this.aeo = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.aef = this.mScroller.getCurrX();
            }
            if (this.aef <= 0) {
                this.aef = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.aef >= this.aeg) {
                this.aef = this.aeg;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.aee - this.aef;
            cN(i6);
            cM(i6);
            cO(i6);
            if (this.aen != null) {
                this.aen.cQ(getMiddleViewPosition());
            }
            this.aee = this.aef;
            if (!this.mScroller.isFinished()) {
                post(new f(this));
            }
        }
    }

    private void cM(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        A(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        B(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void A(int i, int i2) {
        while (i + i2 < getWidth() && this.aed < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.aed, this.aej.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.aed == this.mAdapter.getCount() - 1) {
                this.aeg = (this.aee + i) - getWidth();
            }
            if (this.aeg < 0) {
                this.aeg = 0;
            }
            this.aed++;
        }
    }

    private void B(int i, int i2) {
        while (i + i2 > 0 && this.aec >= 0) {
            View view = this.mAdapter.getView(this.aec, this.aej.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.aec--;
            this.aeh -= view.getMeasuredWidth();
        }
    }

    private void cN(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.aeh += childAt.getMeasuredWidth();
            this.aej.offer(childAt);
            removeViewInLayout(childAt);
            this.aec++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.aej.offer(childAt2);
            removeViewInLayout(childAt2);
            this.aed--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cO(int i) {
        if (getChildCount() > 0) {
            this.aeh += i;
            int i2 = this.aeh;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cP(int i) {
        this.mScroller.startScroll(this.aef, 0, i - this.aef, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.aei.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.aef, 0, (int) (-f), 0, 0, this.aeg, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.aep) {
                    return i + 1 + this.aec;
                }
            }
            return 0;
        }
        return 0;
    }
}
