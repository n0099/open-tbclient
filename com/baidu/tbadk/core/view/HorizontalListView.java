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
    private int auV;
    private int auW;
    protected int auX;
    protected int auY;
    private int auZ;
    private int ava;
    private GestureDetector avb;
    private Queue<View> avc;
    private AdapterView.OnItemSelectedListener avd;
    private AdapterView.OnItemClickListener ave;
    private AdapterView.OnItemLongClickListener avf;
    private a avg;
    private int avh;
    private boolean avi;
    private DataSetObserver avj;
    private GestureDetector.OnGestureListener avk;
    private boolean isIntercept;
    private boolean isLongPress;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private boolean mDataChanged;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private SwipeBackLayout.c mSwipeControlInterface;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void dk(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auV = -1;
        this.auW = 0;
        this.auZ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.ava = 0;
        this.avc = new LinkedList();
        this.mDataChanged = false;
        this.avh = 0;
        this.avi = true;
        this.mActivePointerId = -1;
        this.isIntercept = false;
        this.isLongPress = false;
        this.avj = new DataSetObserver() { // from class: com.baidu.tbadk.core.view.HorizontalListView.1
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
        this.avk = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.core.view.HorizontalListView.3
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
                        HorizontalListView.this.auY += (int) f;
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
                            if (HorizontalListView.this.ave != null) {
                                HorizontalListView.this.ave.onItemClick(HorizontalListView.this, childAt, HorizontalListView.this.auV + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.auV + 1 + i2));
                            }
                            if (HorizontalListView.this.avd != null) {
                                HorizontalListView.this.avd.onItemSelected(HorizontalListView.this, childAt, HorizontalListView.this.auV + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.auV + 1 + i2));
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
                        if (HorizontalListView.this.avf != null) {
                            HorizontalListView.this.isLongPress = true;
                            HorizontalListView.this.avf.onItemLongClick(HorizontalListView.this, childAt, HorizontalListView.this.auV + 1 + i, HorizontalListView.this.mAdapter.getItemId(i + HorizontalListView.this.auV + 1));
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
        this.auV = -1;
        this.auW = 0;
        this.ava = 0;
        this.auX = 0;
        this.auY = 0;
        this.auZ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mScroller = new Scroller(getContext());
        this.avb = new GestureDetector(getContext(), this.avk);
        this.avh = com.baidu.adp.lib.util.l.ah(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.mSwipeControlInterface = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.avi = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.avi) {
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
                    this.mSwipeControlInterface.nG();
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
                            this.mSwipeControlInterface.nH();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.mSwipeControlInterface != null) {
                        this.mSwipeControlInterface.nG();
                        break;
                    }
                    break;
                case 2:
                    if (this.mSwipeControlInterface != null) {
                        this.mSwipeControlInterface.nH();
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
        if (this.avi) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.nH();
                    break;
                }
                break;
            case 1:
                this.isIntercept = false;
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.nG();
                    break;
                }
                break;
            case 2:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.nH();
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
                    this.mSwipeControlInterface.nG();
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
        this.avd = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ave = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.avf = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.avg = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.avj);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.avj);
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
        dj(childCount);
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
            View poll = this.avc.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.avc.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.mDataChanged) {
                int i5 = this.auX;
                initView();
                removeAllViewsInLayout();
                this.auY = i5;
                this.mDataChanged = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.auY = this.mScroller.getCurrX();
            }
            if (this.auY <= 0) {
                this.auY = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.auY >= this.auZ) {
                this.auY = this.auZ;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.auX - this.auY;
            dh(i6);
            dg(i6);
            di(i6);
            if (this.avg != null) {
                this.avg.dk(getMiddleViewPosition());
            }
            this.auX = this.auY;
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

    private void dg(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        A(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        B(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void A(int i, int i2) {
        while (i + i2 < getWidth() && this.auW < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.auW, this.avc.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.auW == this.mAdapter.getCount() - 1) {
                this.auZ = (this.auX + i) - getWidth();
            }
            if (this.auZ < 0) {
                this.auZ = 0;
            }
            this.auW++;
        }
    }

    private void B(int i, int i2) {
        while (i + i2 > 0 && this.auV >= 0) {
            View view = this.mAdapter.getView(this.auV, this.avc.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.auV--;
            this.ava -= view.getMeasuredWidth();
        }
    }

    private void dh(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.ava += childAt.getMeasuredWidth();
            this.avc.offer(childAt);
            removeViewInLayout(childAt);
            this.auV++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.avc.offer(childAt2);
            removeViewInLayout(childAt2);
            this.auW--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void di(int i) {
        if (getChildCount() > 0) {
            this.ava += i;
            int i2 = this.ava;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void dj(int i) {
        this.mScroller.startScroll(this.auY, 0, i - this.auY, 0);
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
        return dispatchTouchEvent | this.avb.onTouchEvent(motionEvent);
    }

    protected boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.auY, 0, (int) (-f), 0, 0, this.auZ, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.avh) {
                    return i + 1 + this.auV;
                }
            }
            return 0;
        }
        return 0;
    }
}
