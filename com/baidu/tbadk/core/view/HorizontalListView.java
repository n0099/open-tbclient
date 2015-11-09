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
    public boolean ade;
    private int adf;
    private int adg;
    protected int adh;
    protected int adi;
    private int adj;
    private int adk;
    private GestureDetector adl;
    private Queue<View> adm;
    private AdapterView.OnItemSelectedListener adn;
    private AdapterView.OnItemClickListener ado;
    private AdapterView.OnItemLongClickListener adp;
    private a adq;
    private boolean adr;
    private int ads;
    private boolean adt;
    private boolean adu;
    private f.b adv;
    private DataSetObserver adw;
    private GestureDetector.OnGestureListener adx;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private float mLastMotionX;
    private float mLastMotionY;
    protected Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void cI(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ade = true;
        this.adf = -1;
        this.adg = 0;
        this.adj = Integer.MAX_VALUE;
        this.adk = 0;
        this.adm = new LinkedList();
        this.adr = false;
        this.ads = 0;
        this.adt = true;
        this.mActivePointerId = -1;
        this.adu = false;
        this.adw = new c(this);
        this.adx = new d(this);
        initView();
    }

    private synchronized void initView() {
        this.adf = -1;
        this.adg = 0;
        this.adk = 0;
        this.adh = 0;
        this.adi = 0;
        this.adj = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.adl = new GestureDetector(getContext(), this.adx);
        this.ads = com.baidu.adp.lib.util.k.K(getContext()) / 2;
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.adv = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.adt = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.adt) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.adu) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.adu = false;
                if (this.adv != null) {
                    this.adv.oc();
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
                        if (this.adv != null) {
                            this.adv.od();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.adv != null) {
                        this.adv.oc();
                        break;
                    }
                    break;
                case 2:
                    if (this.adv != null) {
                        this.adv.od();
                    }
                    g(motionEvent);
                    if (this.adu) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.adt) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                this.mLastMotionX = motionEvent.getX();
                if (this.adv != null) {
                    this.adv.od();
                    break;
                }
                break;
            case 1:
                this.adu = false;
                if (this.adv != null) {
                    this.adv.oc();
                    break;
                }
                break;
            case 2:
                if (this.adv != null) {
                    this.adv.od();
                }
                if (!this.adu) {
                    g(motionEvent);
                }
                if (this.adu && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.adv != null) {
                    this.adv.oc();
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
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float abs = Math.abs(x - this.mLastMotionX);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            if (abs > Math.abs(y - this.mLastMotionY)) {
                this.adu = true;
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
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
        this.adn = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ado = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.adp = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.adq = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.adw);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.adw);
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
        cH(childCount);
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
            size = y(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    final int y(int i, int i2) {
        View view;
        if (this.mAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.mAdapter.getCount();
        int i3 = paddingLeft;
        for (int i4 = 0; i4 < count; i4++) {
            View poll = this.adm.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.adm.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.adr) {
                int i5 = this.adh;
                initView();
                removeAllViewsInLayout();
                this.adi = i5;
                this.adr = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.adi = this.mScroller.getCurrX();
            }
            if (this.adi <= 0) {
                this.adi = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.adi >= this.adj) {
                this.adi = this.adj;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.adh - this.adi;
            cF(i6);
            cE(i6);
            cG(i6);
            if (this.adq != null) {
                this.adq.cI(getMiddleViewPosition());
            }
            this.adh = this.adi;
            if (!this.mScroller.isFinished()) {
                post(new e(this));
            }
        }
    }

    private void cE(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        z(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        A(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void z(int i, int i2) {
        while (i + i2 < getWidth() && this.adg < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.adg, this.adm.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.adg == this.mAdapter.getCount() - 1) {
                this.adj = (this.adh + i) - getWidth();
            }
            if (this.adj < 0) {
                this.adj = 0;
            }
            this.adg++;
        }
    }

    private void A(int i, int i2) {
        while (i + i2 > 0 && this.adf >= 0) {
            View view = this.mAdapter.getView(this.adf, this.adm.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.adf--;
            this.adk -= view.getMeasuredWidth();
        }
    }

    private void cF(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.adk += childAt.getMeasuredWidth();
            this.adm.offer(childAt);
            removeViewInLayout(childAt);
            this.adf++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.adm.offer(childAt2);
            removeViewInLayout(childAt2);
            this.adg--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cG(int i) {
        if (getChildCount() > 0) {
            this.adk += i;
            int i2 = this.adk;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cH(int i) {
        this.mScroller.startScroll(this.adi, 0, i - this.adi, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.adl.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.adi, 0, (int) (-f), 0, 0, this.adj, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.ads) {
                    return i + 1 + this.adf;
                }
            }
            return 0;
        }
        return 0;
    }
}
