package com.baidu.tbadk.core.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.d;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    protected int akA;
    protected int akB;
    private int akC;
    private int akD;
    private GestureDetector akE;
    private Queue<View> akF;
    private AdapterView.OnItemSelectedListener akG;
    private AdapterView.OnItemClickListener akH;
    private AdapterView.OnItemLongClickListener akI;
    private a akJ;
    private int akK;
    private boolean akL;
    private boolean akM;
    private d.c akN;
    private DataSetObserver akO;
    private GestureDetector.OnGestureListener akP;
    private int aky;
    private int akz;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private boolean mDataChanged;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void dh(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aky = -1;
        this.akz = 0;
        this.akC = Integer.MAX_VALUE;
        this.akD = 0;
        this.akF = new LinkedList();
        this.mDataChanged = false;
        this.akK = 0;
        this.akL = true;
        this.mActivePointerId = -1;
        this.akM = false;
        this.akO = new DataSetObserver() { // from class: com.baidu.tbadk.core.view.HorizontalListView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                synchronized (HorizontalListView.this) {
                    HorizontalListView.this.mDataChanged = true;
                }
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                HorizontalListView.this.reset();
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }
        };
        this.akP = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.core.view.HorizontalListView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return HorizontalListView.this.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return HorizontalListView.this.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                synchronized (HorizontalListView.this) {
                    HorizontalListView.this.akB += (int) f;
                }
                HorizontalListView.this.requestLayout();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < HorizontalListView.this.getChildCount()) {
                        View childAt = HorizontalListView.this.getChildAt(i2);
                        if (a(motionEvent, childAt)) {
                            if (HorizontalListView.this.akH != null) {
                                HorizontalListView.this.akH.onItemClick(HorizontalListView.this, childAt, HorizontalListView.this.aky + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.aky + 1 + i2));
                            }
                            if (HorizontalListView.this.akG != null) {
                                HorizontalListView.this.akG.onItemSelected(HorizontalListView.this, childAt, HorizontalListView.this.aky + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.aky + 1 + i2));
                                return true;
                            }
                            return true;
                        }
                        i = i2 + 1;
                    } else {
                        return true;
                    }
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                int childCount = HorizontalListView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = HorizontalListView.this.getChildAt(i);
                    if (a(motionEvent, childAt)) {
                        if (HorizontalListView.this.akI != null) {
                            HorizontalListView.this.akI.onItemLongClick(HorizontalListView.this, childAt, HorizontalListView.this.aky + 1 + i, HorizontalListView.this.mAdapter.getItemId(i + HorizontalListView.this.aky + 1));
                            return;
                        }
                        return;
                    }
                }
            }

            private boolean a(MotionEvent motionEvent, View view) {
                Rect rect = new Rect();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                rect.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
                return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
        };
        initView();
    }

    private synchronized void initView() {
        this.aky = -1;
        this.akz = 0;
        this.akD = 0;
        this.akA = 0;
        this.akB = 0;
        this.akC = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.akE = new GestureDetector(getContext(), this.akP);
        this.akK = l.ac(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(d.c cVar) {
        this.akN = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.akL = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.akL) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.akM) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.akM = false;
                if (this.akN != null) {
                    this.akN.lm();
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
                        if (this.akN != null) {
                            this.akN.ln();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.akN != null) {
                        this.akN.lm();
                        break;
                    }
                    break;
                case 2:
                    if (this.akN != null) {
                        this.akN.ln();
                    }
                    i(motionEvent);
                    if (this.akM) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.akL) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.akN != null) {
                    this.akN.ln();
                    break;
                }
                break;
            case 1:
                this.akM = false;
                if (this.akN != null) {
                    this.akN.lm();
                    break;
                }
                break;
            case 2:
                if (this.akN != null) {
                    this.akN.ln();
                }
                if (!this.akM) {
                    i(motionEvent);
                }
                if (this.akM && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.akN != null) {
                    this.akN.lm();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void i(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int b = b(motionEvent, i);
        if (i != -1) {
            try {
                float x = MotionEventCompat.getX(motionEvent, b);
                float y = MotionEventCompat.getY(motionEvent, b);
                float abs = Math.abs(x - this.mInitialMotionX);
                float abs2 = Math.abs(y - this.mInitialMotionY);
                if (abs > this.mTouchSlop && abs > abs2) {
                    this.akM = true;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private int b(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.akG = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.akH = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.akI = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.akJ = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.akO);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.akO);
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
        dg(childCount);
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
            View poll = this.akF.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.akF.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.mDataChanged) {
                int i5 = this.akA;
                initView();
                removeAllViewsInLayout();
                this.akB = i5;
                this.mDataChanged = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.akB = this.mScroller.getCurrX();
            }
            if (this.akB <= 0) {
                this.akB = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.akB >= this.akC) {
                this.akB = this.akC;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.akA - this.akB;
            de(i6);
            dd(i6);
            df(i6);
            if (this.akJ != null) {
                this.akJ.dh(getMiddleViewPosition());
            }
            this.akA = this.akB;
            if (!this.mScroller.isFinished()) {
                post(new Runnable() { // from class: com.baidu.tbadk.core.view.HorizontalListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        HorizontalListView.this.requestLayout();
                    }
                });
            }
        }
    }

    private void dd(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        A(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        B(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void A(int i, int i2) {
        while (i + i2 < getWidth() && this.akz < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.akz, this.akF.poll(), this);
            m(view, -1);
            i += view.getMeasuredWidth();
            if (this.akz == this.mAdapter.getCount() - 1) {
                this.akC = (this.akA + i) - getWidth();
            }
            if (this.akC < 0) {
                this.akC = 0;
            }
            this.akz++;
        }
    }

    private void B(int i, int i2) {
        while (i + i2 > 0 && this.aky >= 0) {
            View view = this.mAdapter.getView(this.aky, this.akF.poll(), this);
            m(view, 0);
            i -= view.getMeasuredWidth();
            this.aky--;
            this.akD -= view.getMeasuredWidth();
        }
    }

    private void de(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.akD += childAt.getMeasuredWidth();
            this.akF.offer(childAt);
            removeViewInLayout(childAt);
            this.aky++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.akF.offer(childAt2);
            removeViewInLayout(childAt2);
            this.akz--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void df(int i) {
        if (getChildCount() > 0) {
            this.akD += i;
            int i2 = this.akD;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void dg(int i) {
        this.mScroller.startScroll(this.akB, 0, i - this.akB, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.akE.onTouchEvent(motionEvent);
    }

    protected boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.akB, 0, (int) (-f), 0, 0, this.akC, 0, 0);
        }
        requestLayout();
        return true;
    }

    protected boolean onDown(MotionEvent motionEvent) {
        this.mScroller.forceFinished(true);
        return true;
    }

    private int getMiddleViewPosition() {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getWidth() + childAt.getLeft() >= this.akK) {
                    return i + 1 + this.aky;
                }
            }
            return 0;
        }
        return 0;
    }
}
