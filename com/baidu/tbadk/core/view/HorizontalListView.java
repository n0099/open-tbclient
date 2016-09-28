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
    private int aeA;
    protected int aeB;
    protected int aeC;
    private int aeD;
    private int aeE;
    private GestureDetector aeF;
    private Queue<View> aeG;
    private AdapterView.OnItemSelectedListener aeH;
    private AdapterView.OnItemClickListener aeI;
    private AdapterView.OnItemLongClickListener aeJ;
    private a aeK;
    private boolean aeL;
    private int aeM;
    private boolean aeN;
    private boolean aeO;
    private f.b aeP;
    private DataSetObserver aeQ;
    private GestureDetector.OnGestureListener aeR;
    public boolean aey;
    private int aez;
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
        this.aey = true;
        this.aez = -1;
        this.aeA = 0;
        this.aeD = Integer.MAX_VALUE;
        this.aeE = 0;
        this.aeG = new LinkedList();
        this.aeL = false;
        this.aeM = 0;
        this.aeN = true;
        this.mActivePointerId = -1;
        this.aeO = false;
        this.aeQ = new e(this);
        this.aeR = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.aez = -1;
        this.aeA = 0;
        this.aeE = 0;
        this.aeB = 0;
        this.aeC = 0;
        this.aeD = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.aeF = new GestureDetector(getContext(), this.aeR);
        this.aeM = com.baidu.adp.lib.util.k.K(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.aeP = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aeN = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aeN) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.aeO) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.aeO = false;
                if (this.aeP != null) {
                    this.aeP.la();
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
                        if (this.aeP != null) {
                            this.aeP.lb();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.aeP != null) {
                        this.aeP.la();
                        break;
                    }
                    break;
                case 2:
                    if (this.aeP != null) {
                        this.aeP.lb();
                    }
                    e(motionEvent);
                    if (this.aeO) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aeN) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.aeP != null) {
                    this.aeP.lb();
                    break;
                }
                break;
            case 1:
                this.aeO = false;
                if (this.aeP != null) {
                    this.aeP.la();
                    break;
                }
                break;
            case 2:
                if (this.aeP != null) {
                    this.aeP.lb();
                }
                if (!this.aeO) {
                    e(motionEvent);
                }
                if (this.aeO && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.aeP != null) {
                    this.aeP.la();
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
                    this.aeO = true;
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
        this.aeH = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.aeI = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.aeJ = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.aeK = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.aeQ);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.aeQ);
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
            View poll = this.aeG.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.aeG.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.aeL) {
                int i5 = this.aeB;
                initView();
                removeAllViewsInLayout();
                this.aeC = i5;
                this.aeL = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.aeC = this.mScroller.getCurrX();
            }
            if (this.aeC <= 0) {
                this.aeC = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.aeC >= this.aeD) {
                this.aeC = this.aeD;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.aeB - this.aeC;
            cY(i6);
            cX(i6);
            cZ(i6);
            if (this.aeK != null) {
                this.aeK.db(getMiddleViewPosition());
            }
            this.aeB = this.aeC;
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
        while (i + i2 < getWidth() && this.aeA < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.aeA, this.aeG.poll(), this);
            n(view, -1);
            i += view.getMeasuredWidth();
            if (this.aeA == this.mAdapter.getCount() - 1) {
                this.aeD = (this.aeB + i) - getWidth();
            }
            if (this.aeD < 0) {
                this.aeD = 0;
            }
            this.aeA++;
        }
    }

    private void v(int i, int i2) {
        while (i + i2 > 0 && this.aez >= 0) {
            View view = this.mAdapter.getView(this.aez, this.aeG.poll(), this);
            n(view, 0);
            i -= view.getMeasuredWidth();
            this.aez--;
            this.aeE -= view.getMeasuredWidth();
        }
    }

    private void cY(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.aeE += childAt.getMeasuredWidth();
            this.aeG.offer(childAt);
            removeViewInLayout(childAt);
            this.aez++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.aeG.offer(childAt2);
            removeViewInLayout(childAt2);
            this.aeA--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cZ(int i) {
        if (getChildCount() > 0) {
            this.aeE += i;
            int i2 = this.aeE;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void da(int i) {
        this.mScroller.startScroll(this.aeC, 0, i - this.aeC, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.aeF.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.aeC, 0, (int) (-f), 0, 0, this.aeD, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.aeM) {
                    return i + 1 + this.aez;
                }
            }
            return 0;
        }
        return 0;
    }
}
