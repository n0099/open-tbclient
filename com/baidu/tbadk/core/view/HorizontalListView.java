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
    private GestureDetector aaA;
    private Queue<View> aaB;
    private AdapterView.OnItemSelectedListener aaC;
    private AdapterView.OnItemClickListener aaD;
    private AdapterView.OnItemLongClickListener aaE;
    private a aaF;
    private boolean aaG;
    private int aaH;
    private boolean aaI;
    private boolean aaJ;
    private f.b aaK;
    private DataSetObserver aaL;
    private GestureDetector.OnGestureListener aaM;
    public boolean aat;
    private int aau;
    private int aav;
    protected int aaw;
    protected int aax;
    private int aay;
    private int aaz;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void cM(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aat = true;
        this.aau = -1;
        this.aav = 0;
        this.aay = Integer.MAX_VALUE;
        this.aaz = 0;
        this.aaB = new LinkedList();
        this.aaG = false;
        this.aaH = 0;
        this.aaI = true;
        this.mActivePointerId = -1;
        this.aaJ = false;
        this.aaL = new e(this);
        this.aaM = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.aau = -1;
        this.aav = 0;
        this.aaz = 0;
        this.aaw = 0;
        this.aax = 0;
        this.aay = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.aaA = new GestureDetector(getContext(), this.aaM);
        this.aaH = com.baidu.adp.lib.util.k.B(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.aaK = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aaI = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aaI) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.aaJ) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.aaJ = false;
                if (this.aaK != null) {
                    this.aaK.kg();
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
                        if (this.aaK != null) {
                            this.aaK.kh();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.aaK != null) {
                        this.aaK.kg();
                        break;
                    }
                    break;
                case 2:
                    if (this.aaK != null) {
                        this.aaK.kh();
                    }
                    c(motionEvent);
                    if (this.aaJ) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aaI) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.aaK != null) {
                    this.aaK.kh();
                    break;
                }
                break;
            case 1:
                this.aaJ = false;
                if (this.aaK != null) {
                    this.aaK.kg();
                    break;
                }
                break;
            case 2:
                if (this.aaK != null) {
                    this.aaK.kh();
                }
                if (!this.aaJ) {
                    c(motionEvent);
                }
                if (this.aaJ && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.aaK != null) {
                    this.aaK.kg();
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
                    this.aaJ = true;
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
        this.aaC = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.aaD = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.aaE = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.aaF = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.aaL);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.aaL);
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
        cL(childCount);
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
            View poll = this.aaB.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.aaB.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.aaG) {
                int i5 = this.aaw;
                initView();
                removeAllViewsInLayout();
                this.aax = i5;
                this.aaG = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.aax = this.mScroller.getCurrX();
            }
            if (this.aax <= 0) {
                this.aax = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.aax >= this.aay) {
                this.aax = this.aay;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.aaw - this.aax;
            cJ(i6);
            cI(i6);
            cK(i6);
            if (this.aaF != null) {
                this.aaF.cM(getMiddleViewPosition());
            }
            this.aaw = this.aax;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void cI(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        s(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        t(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void s(int i, int i2) {
        while (i + i2 < getWidth() && this.aav < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.aav, this.aaB.poll(), this);
            n(view, -1);
            i += view.getMeasuredWidth();
            if (this.aav == this.mAdapter.getCount() - 1) {
                this.aay = (this.aaw + i) - getWidth();
            }
            if (this.aay < 0) {
                this.aay = 0;
            }
            this.aav++;
        }
    }

    private void t(int i, int i2) {
        while (i + i2 > 0 && this.aau >= 0) {
            View view = this.mAdapter.getView(this.aau, this.aaB.poll(), this);
            n(view, 0);
            i -= view.getMeasuredWidth();
            this.aau--;
            this.aaz -= view.getMeasuredWidth();
        }
    }

    private void cJ(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.aaz += childAt.getMeasuredWidth();
            this.aaB.offer(childAt);
            removeViewInLayout(childAt);
            this.aau++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.aaB.offer(childAt2);
            removeViewInLayout(childAt2);
            this.aav--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cK(int i) {
        if (getChildCount() > 0) {
            this.aaz += i;
            int i2 = this.aaz;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cL(int i) {
        this.mScroller.startScroll(this.aax, 0, i - this.aax, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.aaA.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.aax, 0, (int) (-f), 0, 0, this.aay, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.aaH) {
                    return i + 1 + this.aau;
                }
            }
            return 0;
        }
        return 0;
    }
}
