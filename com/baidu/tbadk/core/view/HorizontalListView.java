package com.baidu.tbadk.core.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
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
    private boolean agj;
    private Queue<View> cnA;
    private AdapterView.OnItemSelectedListener cnB;
    private AdapterView.OnItemClickListener cnC;
    private AdapterView.OnItemLongClickListener cnD;
    private a cnE;
    private int cnF;
    private boolean cnG;
    private DataSetObserver cnH;
    private GestureDetector.OnGestureListener cnI;
    private int cnv;
    private int cnw;
    private int cnx;
    private int cny;
    private GestureDetector cnz;
    private boolean isIntercept;
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
        void iE(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnv = -1;
        this.cnw = 0;
        this.cnx = Integer.MAX_VALUE;
        this.cny = 0;
        this.cnA = new LinkedList();
        this.mDataChanged = false;
        this.cnF = 0;
        this.cnG = true;
        this.mActivePointerId = -1;
        this.isIntercept = false;
        this.agj = false;
        this.cnH = new DataSetObserver() { // from class: com.baidu.tbadk.core.view.HorizontalListView.1
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
        this.cnI = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.core.view.HorizontalListView.3
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
                if (!HorizontalListView.this.agj) {
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
                            if (HorizontalListView.this.cnC != null) {
                                HorizontalListView.this.cnC.onItemClick(HorizontalListView.this, childAt, HorizontalListView.this.cnv + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.cnv + 1 + i2));
                            }
                            if (HorizontalListView.this.cnB != null) {
                                HorizontalListView.this.cnB.onItemSelected(HorizontalListView.this, childAt, HorizontalListView.this.cnv + 1 + i2, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.cnv + 1 + i2));
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
                        if (HorizontalListView.this.cnD != null) {
                            HorizontalListView.this.agj = true;
                            HorizontalListView.this.cnD.onItemLongClick(HorizontalListView.this, childAt, HorizontalListView.this.cnv + 1 + i, HorizontalListView.this.mAdapter.getItemId(i + HorizontalListView.this.cnv + 1));
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
        this.cnv = -1;
        this.cnw = 0;
        this.cny = 0;
        this.mCurrentX = 0;
        this.mNextX = 0;
        this.cnx = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.cnz = new GestureDetector(getContext(), this.cnI);
        this.cnF = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.mSwipeControlInterface = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.cnG = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.cnG) {
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
                    this.mSwipeControlInterface.enableSwipeBack();
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
                            this.mSwipeControlInterface.disableSwipeBack();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.mSwipeControlInterface != null) {
                        this.mSwipeControlInterface.enableSwipeBack();
                        break;
                    }
                    break;
                case 2:
                    if (this.mSwipeControlInterface != null) {
                        this.mSwipeControlInterface.disableSwipeBack();
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
        if (this.cnG) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.disableSwipeBack();
                    break;
                }
                break;
            case 1:
                this.isIntercept = false;
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.enableSwipeBack();
                    break;
                }
                break;
            case 2:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.disableSwipeBack();
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
                    this.mSwipeControlInterface.enableSwipeBack();
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
        this.cnB = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.cnC = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.cnD = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.cnE = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.cnH);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.cnH);
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

    private void g(View view, int i) {
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
            size = ae(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int ae(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.cnA.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.cnA.add(view);
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
            if (this.mNextX >= this.cnx) {
                this.mNextX = this.cnx;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.mCurrentX - this.mNextX;
            iC(i6);
            iB(i6);
            iD(i6);
            if (this.cnE != null) {
                this.cnE.iE(getMiddleViewPosition());
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

    private void iB(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        af(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        ag(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void af(int i, int i2) {
        while (i + i2 < getWidth() && this.cnw < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.cnw, this.cnA.poll(), this);
            g(view, -1);
            i += view.getMeasuredWidth();
            if (this.cnw == this.mAdapter.getCount() - 1) {
                this.cnx = (this.mCurrentX + i) - getWidth();
            }
            if (this.cnx < 0) {
                this.cnx = 0;
            }
            this.cnw++;
        }
    }

    private void ag(int i, int i2) {
        while (i + i2 > 0 && this.cnv >= 0) {
            View view = this.mAdapter.getView(this.cnv, this.cnA.poll(), this);
            g(view, 0);
            i -= view.getMeasuredWidth();
            this.cnv--;
            this.cny -= view.getMeasuredWidth();
        }
    }

    private void iC(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.cny += childAt.getMeasuredWidth();
            this.cnA.offer(childAt);
            removeViewInLayout(childAt);
            this.cnv++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.cnA.offer(childAt2);
            removeViewInLayout(childAt2);
            this.cnw--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void iD(int i) {
        if (getChildCount() > 0) {
            this.cny += i;
            int i2 = this.cny;
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
                this.agj = false;
                break;
        }
        return dispatchTouchEvent | this.cnz.onTouchEvent(motionEvent);
    }

    protected boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.mNextX, 0, (int) (-f), 0, 0, this.cnx, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.cnF) {
                    return i + 1 + this.cnv;
                }
            }
            return 0;
        }
        return 0;
    }
}
