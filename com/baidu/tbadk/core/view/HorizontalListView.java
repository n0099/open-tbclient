package com.baidu.tbadk.core.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.baidu.adp.widget.SwipeBackLayout;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    private int aGN;
    private int aGO;
    private int aGP;
    private int aGQ;
    private GestureDetector aGR;
    private Queue<View> aGS;
    private AdapterView.OnItemSelectedListener aGT;
    private AdapterView.OnItemClickListener aGU;
    private AdapterView.OnItemLongClickListener aGV;
    private a aGW;
    private int aGX;
    private boolean aGY;
    private DataSetObserver aGZ;
    private GestureDetector.OnGestureListener aHa;
    private boolean isIntercept;
    private boolean isLongPress;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    protected int mCurrentX;
    private boolean mDataChanged;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected int mNextX;
    protected Scroller mScroller;
    private SwipeBackLayout.c mSwipeControlInterface;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void ei(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGN = -1;
        this.aGO = 0;
        this.aGP = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.aGQ = 0;
        this.aGS = new LinkedList();
        this.mDataChanged = false;
        this.aGX = 0;
        this.aGY = true;
        this.mActivePointerId = -1;
        this.isIntercept = false;
        this.isLongPress = false;
        this.aGZ = new DataSetObserver() { // from class: com.baidu.tbadk.core.view.HorizontalListView.1
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
        this.aHa = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.core.view.HorizontalListView.3
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
                if (!HorizontalListView.this.isLongPress) {
                    synchronized (HorizontalListView.this) {
                        HorizontalListView.this.mNextX += (int) f;
                    }
                    HorizontalListView.this.requestLayout();
                }
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
                            if (HorizontalListView.this.aGU != null) {
                                HorizontalListView.this.aGU.onItemClick(HorizontalListView.this, childAt, HorizontalListView.this.aGN + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.aGN + 1 + i2));
                            }
                            if (HorizontalListView.this.aGT != null) {
                                HorizontalListView.this.aGT.onItemSelected(HorizontalListView.this, childAt, HorizontalListView.this.aGN + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.aGN + 1 + i2));
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
                        if (HorizontalListView.this.aGV != null) {
                            HorizontalListView.this.isLongPress = true;
                            HorizontalListView.this.aGV.onItemLongClick(HorizontalListView.this, childAt, HorizontalListView.this.aGN + 1 + i, HorizontalListView.this.mAdapter.getItemId(i + HorizontalListView.this.aGN + 1));
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
        this.aGN = -1;
        this.aGO = 0;
        this.aGQ = 0;
        this.mCurrentX = 0;
        this.mNextX = 0;
        this.aGP = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mScroller = new Scroller(getContext());
        this.aGR = new GestureDetector(getContext(), this.aHa);
        this.aGX = com.baidu.adp.lib.util.l.aO(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.mSwipeControlInterface = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aGY = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aGY) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.isIntercept) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.isIntercept = false;
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.oR();
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
                        if (this.mSwipeControlInterface != null) {
                            this.mSwipeControlInterface.oS();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.mSwipeControlInterface != null) {
                        this.mSwipeControlInterface.oR();
                        break;
                    }
                    break;
                case 2:
                    if (this.mSwipeControlInterface != null) {
                        this.mSwipeControlInterface.oS();
                    }
                    determinIntercept(motionEvent);
                    if (this.isIntercept) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aGY) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.oS();
                    break;
                }
                break;
            case 1:
                this.isIntercept = false;
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.oR();
                    break;
                }
                break;
            case 2:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.oS();
                }
                if (!this.isIntercept) {
                    determinIntercept(motionEvent);
                }
                if (this.isIntercept && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.oR();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void determinIntercept(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i != -1) {
            try {
                float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                float y = MotionEventCompat.getY(motionEvent, pointerIndex);
                float abs = Math.abs(x - this.mInitialMotionX);
                float abs2 = Math.abs(y - this.mInitialMotionY);
                if (abs > this.mTouchSlop && abs > abs2) {
                    this.isIntercept = true;
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
        this.aGT = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.aGU = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.aGV = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.aGW = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.aGZ);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.aGZ);
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
        scrollTo(childCount);
    }

    private void l(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            size = D(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int D(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.aGS.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.aGS.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.mDataChanged) {
                int i5 = this.mCurrentX;
                initView();
                removeAllViewsInLayout();
                this.mNextX = i5;
                this.mDataChanged = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.mNextX = this.mScroller.getCurrX();
            }
            if (this.mNextX <= 0) {
                this.mNextX = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.mNextX >= this.aGP) {
                this.mNextX = this.aGP;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.mCurrentX - this.mNextX;
            eg(i6);
            ef(i6);
            eh(i6);
            if (this.aGW != null) {
                this.aGW.ei(getMiddleViewPosition());
            }
            this.mCurrentX = this.mNextX;
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

    private void ef(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        E(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        F(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void E(int i, int i2) {
        while (i + i2 < getWidth() && this.aGO < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.aGO, this.aGS.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.aGO == this.mAdapter.getCount() - 1) {
                this.aGP = (this.mCurrentX + i) - getWidth();
            }
            if (this.aGP < 0) {
                this.aGP = 0;
            }
            this.aGO++;
        }
    }

    private void F(int i, int i2) {
        while (i + i2 > 0 && this.aGN >= 0) {
            View view = this.mAdapter.getView(this.aGN, this.aGS.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.aGN--;
            this.aGQ -= view.getMeasuredWidth();
        }
    }

    private void eg(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.aGQ += childAt.getMeasuredWidth();
            this.aGS.offer(childAt);
            removeViewInLayout(childAt);
            this.aGN++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.aGS.offer(childAt2);
            removeViewInLayout(childAt2);
            this.aGO--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void eh(int i) {
        if (getChildCount() > 0) {
            this.aGQ += i;
            int i2 = this.aGQ;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void scrollTo(int i) {
        this.mScroller.startScroll(this.mNextX, 0, i - this.mNextX, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                this.isLongPress = false;
                break;
        }
        return dispatchTouchEvent | this.aGR.onTouchEvent(motionEvent);
    }

    protected boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.mNextX, 0, (int) (-f), 0, 0, this.aGP, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.aGX) {
                    return i + 1 + this.aGN;
                }
            }
            return 0;
        }
        return 0;
    }
}
