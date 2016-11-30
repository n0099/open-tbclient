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
    public boolean aeW;
    private int aeX;
    private int aeY;
    protected int aeZ;
    protected int afa;
    private int afb;
    private int afc;
    private GestureDetector afd;
    private Queue<View> afe;
    private AdapterView.OnItemSelectedListener aff;
    private AdapterView.OnItemClickListener afg;
    private AdapterView.OnItemLongClickListener afh;
    private a afi;
    private boolean afj;
    private int afk;
    private boolean afl;
    private boolean afm;
    private f.c afn;
    private DataSetObserver afo;
    private GestureDetector.OnGestureListener afp;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mInitialMotionX;
    private float mInitialMotionY;
    protected Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void dc(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeW = true;
        this.aeX = -1;
        this.aeY = 0;
        this.afb = Integer.MAX_VALUE;
        this.afc = 0;
        this.afe = new LinkedList();
        this.afj = false;
        this.afk = 0;
        this.afl = true;
        this.mActivePointerId = -1;
        this.afm = false;
        this.afo = new e(this);
        this.afp = new f(this);
        initView();
    }

    private synchronized void initView() {
        this.aeX = -1;
        this.aeY = 0;
        this.afc = 0;
        this.aeZ = 0;
        this.afa = 0;
        this.afb = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.afd = new GestureDetector(getContext(), this.afp);
        this.afk = com.baidu.adp.lib.util.k.K(getContext()) / 2;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.afn = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.afl = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.afl) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.afm) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.afm = false;
                if (this.afn != null) {
                    this.afn.ld();
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
                        if (this.afn != null) {
                            this.afn.le();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.afn != null) {
                        this.afn.ld();
                        break;
                    }
                    break;
                case 2:
                    if (this.afn != null) {
                        this.afn.le();
                    }
                    f(motionEvent);
                    if (this.afm) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.afl) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                if (this.afn != null) {
                    this.afn.le();
                    break;
                }
                break;
            case 1:
                this.afm = false;
                if (this.afn != null) {
                    this.afn.ld();
                    break;
                }
                break;
            case 2:
                if (this.afn != null) {
                    this.afn.le();
                }
                if (!this.afm) {
                    f(motionEvent);
                }
                if (this.afm && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.afn != null) {
                    this.afn.ld();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void f(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int c = c(motionEvent, i);
        if (i != -1) {
            try {
                float x = MotionEventCompat.getX(motionEvent, c);
                float y = MotionEventCompat.getY(motionEvent, c);
                float abs = Math.abs(x - this.mInitialMotionX);
                float abs2 = Math.abs(y - this.mInitialMotionY);
                if (abs > this.mTouchSlop && abs > abs2) {
                    this.afm = true;
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
        this.aff = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.afg = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.afh = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.afi = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.afo);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.afo);
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
        db(childCount);
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
            View poll = this.afe.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.afe.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.afj) {
                int i5 = this.aeZ;
                initView();
                removeAllViewsInLayout();
                this.afa = i5;
                this.afj = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.afa = this.mScroller.getCurrX();
            }
            if (this.afa <= 0) {
                this.afa = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.afa >= this.afb) {
                this.afa = this.afb;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.aeZ - this.afa;
            cZ(i6);
            cY(i6);
            da(i6);
            if (this.afi != null) {
                this.afi.dc(getMiddleViewPosition());
            }
            this.aeZ = this.afa;
            if (!this.mScroller.isFinished()) {
                post(new g(this));
            }
        }
    }

    private void cY(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        u(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        v(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void u(int i, int i2) {
        while (i + i2 < getWidth() && this.aeY < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.aeY, this.afe.poll(), this);
            n(view, -1);
            i += view.getMeasuredWidth();
            if (this.aeY == this.mAdapter.getCount() - 1) {
                this.afb = (this.aeZ + i) - getWidth();
            }
            if (this.afb < 0) {
                this.afb = 0;
            }
            this.aeY++;
        }
    }

    private void v(int i, int i2) {
        while (i + i2 > 0 && this.aeX >= 0) {
            View view = this.mAdapter.getView(this.aeX, this.afe.poll(), this);
            n(view, 0);
            i -= view.getMeasuredWidth();
            this.aeX--;
            this.afc -= view.getMeasuredWidth();
        }
    }

    private void cZ(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.afc += childAt.getMeasuredWidth();
            this.afe.offer(childAt);
            removeViewInLayout(childAt);
            this.aeX++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.afe.offer(childAt2);
            removeViewInLayout(childAt2);
            this.aeY--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void da(int i) {
        if (getChildCount() > 0) {
            this.afc += i;
            int i2 = this.afc;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void db(int i) {
        this.mScroller.startScroll(this.afa, 0, i - this.afa, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.afd.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.afa, 0, (int) (-f), 0, 0, this.afb, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.afk) {
                    return i + 1 + this.aeX;
                }
            }
            return 0;
        }
        return 0;
    }
}
