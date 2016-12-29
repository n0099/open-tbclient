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
    private AdapterView.OnItemLongClickListener aeA;
    private a aeB;
    private boolean aeC;
    private int aeD;
    private boolean aeE;
    private boolean aeF;
    private f.c aeG;
    private DataSetObserver aeH;
    private GestureDetector.OnGestureListener aeI;
    public boolean aep;
    private int aeq;
    private int aer;
    protected int aes;
    protected int aet;
    private int aeu;
    private int aev;
    private GestureDetector aew;
    private Queue<View> aex;
    private AdapterView.OnItemSelectedListener aey;
    private AdapterView.OnItemClickListener aez;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void de(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aep = true;
        this.aeq = -1;
        this.aer = 0;
        this.aeu = Integer.MAX_VALUE;
        this.aev = 0;
        this.aex = new LinkedList();
        this.aeC = false;
        this.aeD = 0;
        this.aeE = true;
        this.mActivePointerId = -1;
        this.aeF = false;
        this.aeH = new e(this);
        this.aeI = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.aeq = -1;
        this.aer = 0;
        this.aev = 0;
        this.aes = 0;
        this.aet = 0;
        this.aeu = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.aew = new GestureDetector(getContext(), this.aeI);
        this.aeD = com.baidu.adp.lib.util.k.I(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.aeG = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aeE = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aeE) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.aeF) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.aeF = false;
                if (this.aeG != null) {
                    this.aeG.ld();
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
                        if (this.aeG != null) {
                            this.aeG.le();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.aeG != null) {
                        this.aeG.ld();
                        break;
                    }
                    break;
                case 2:
                    if (this.aeG != null) {
                        this.aeG.le();
                    }
                    e(motionEvent);
                    if (this.aeF) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aeE) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.aeG != null) {
                    this.aeG.le();
                    break;
                }
                break;
            case 1:
                this.aeF = false;
                if (this.aeG != null) {
                    this.aeG.ld();
                    break;
                }
                break;
            case 2:
                if (this.aeG != null) {
                    this.aeG.le();
                }
                if (!this.aeF) {
                    e(motionEvent);
                }
                if (this.aeF && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.aeG != null) {
                    this.aeG.ld();
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
                    this.aeF = true;
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
        this.aey = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.aez = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.aeA = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.aeB = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.aeH);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.aeH);
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
        dd(childCount);
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
            View poll = this.aex.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.aex.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.aeC) {
                int i5 = this.aes;
                initView();
                removeAllViewsInLayout();
                this.aet = i5;
                this.aeC = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.aet = this.mScroller.getCurrX();
            }
            if (this.aet <= 0) {
                this.aet = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.aet >= this.aeu) {
                this.aet = this.aeu;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.aes - this.aet;
            db(i6);
            da(i6);
            dc(i6);
            if (this.aeB != null) {
                this.aeB.de(getMiddleViewPosition());
            }
            this.aes = this.aet;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void da(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        u(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        v(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void u(int i, int i2) {
        while (i + i2 < getWidth() && this.aer < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.aer, this.aex.poll(), this);
            n(view, -1);
            i += view.getMeasuredWidth();
            if (this.aer == this.mAdapter.getCount() - 1) {
                this.aeu = (this.aes + i) - getWidth();
            }
            if (this.aeu < 0) {
                this.aeu = 0;
            }
            this.aer++;
        }
    }

    private void v(int i, int i2) {
        while (i + i2 > 0 && this.aeq >= 0) {
            View view = this.mAdapter.getView(this.aeq, this.aex.poll(), this);
            n(view, 0);
            i -= view.getMeasuredWidth();
            this.aeq--;
            this.aev -= view.getMeasuredWidth();
        }
    }

    private void db(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.aev += childAt.getMeasuredWidth();
            this.aex.offer(childAt);
            removeViewInLayout(childAt);
            this.aeq++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.aex.offer(childAt2);
            removeViewInLayout(childAt2);
            this.aer--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void dc(int i) {
        if (getChildCount() > 0) {
            this.aev += i;
            int i2 = this.aev;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void dd(int i) {
        this.mScroller.startScroll(this.aet, 0, i - this.aet, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.aew.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.aet, 0, (int) (-f), 0, 0, this.aeu, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.aeD) {
                    return i + 1 + this.aeq;
                }
            }
            return 0;
        }
        return 0;
    }
}
