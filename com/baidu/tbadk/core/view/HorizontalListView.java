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
    public boolean acX;
    private int acY;
    private int acZ;
    protected int ada;
    protected int adb;
    private int adc;
    private int ade;
    private GestureDetector adf;
    private Queue<View> adg;
    private AdapterView.OnItemSelectedListener adh;
    private AdapterView.OnItemClickListener adi;
    private AdapterView.OnItemLongClickListener adj;
    private a adk;
    private boolean adl;
    private int adm;
    private boolean adn;
    private boolean ado;
    private f.b adp;
    private DataSetObserver adq;
    private GestureDetector.OnGestureListener adr;
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
        this.acX = true;
        this.acY = -1;
        this.acZ = 0;
        this.adc = Integer.MAX_VALUE;
        this.ade = 0;
        this.adg = new LinkedList();
        this.adl = false;
        this.adm = 0;
        this.adn = true;
        this.mActivePointerId = -1;
        this.ado = false;
        this.adq = new c(this);
        this.adr = new d(this);
        initView();
    }

    private synchronized void initView() {
        this.acY = -1;
        this.acZ = 0;
        this.ade = 0;
        this.ada = 0;
        this.adb = 0;
        this.adc = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.adf = new GestureDetector(getContext(), this.adr);
        this.adm = com.baidu.adp.lib.util.k.K(getContext()) / 2;
    }

    public void setSwipeControlInterface(f.b bVar) {
        this.adp = bVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.adn = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.adn) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.ado) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.ado = false;
                if (this.adp != null) {
                    this.adp.ob();
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
                        if (this.adp != null) {
                            this.adp.oc();
                            break;
                        }
                    }
                    break;
                case 1:
                default:
                    if (this.adp != null) {
                        this.adp.ob();
                        break;
                    }
                    break;
                case 2:
                    if (this.adp != null) {
                        this.adp.oc();
                    }
                    g(motionEvent);
                    if (this.ado) {
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.adn) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                this.mLastMotionX = motionEvent.getX();
                if (this.adp != null) {
                    this.adp.oc();
                    break;
                }
                break;
            case 1:
                this.ado = false;
                if (this.adp != null) {
                    this.adp.ob();
                    break;
                }
                break;
            case 2:
                if (this.adp != null) {
                    this.adp.oc();
                }
                if (!this.ado) {
                    g(motionEvent);
                }
                if (this.ado && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                if (this.adp != null) {
                    this.adp.ob();
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
                this.ado = true;
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
        this.adh = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.adi = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.adj = onItemLongClickListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.adk = aVar;
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
            this.mAdapter.unregisterDataSetObserver(this.adq);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.adq);
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
            View poll = this.adg.poll();
            if (poll == null) {
                view = this.mAdapter.getView(i4, null, this);
            } else {
                view = this.mAdapter.getView(i4, poll, this);
            }
            view.measure(i, 0);
            i3 += view.getMeasuredWidth();
            this.adg.add(view);
        }
        return Math.min(i3, i2);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            if (this.adl) {
                int i5 = this.ada;
                initView();
                removeAllViewsInLayout();
                this.adb = i5;
                this.adl = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                this.adb = this.mScroller.getCurrX();
            }
            if (this.adb <= 0) {
                this.adb = 0;
                this.mScroller.forceFinished(true);
            }
            if (this.adb >= this.adc) {
                this.adb = this.adc;
                this.mScroller.forceFinished(true);
            }
            int i6 = this.ada - this.adb;
            cF(i6);
            cE(i6);
            cG(i6);
            if (this.adk != null) {
                this.adk.cI(getMiddleViewPosition());
            }
            this.ada = this.adb;
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
        while (i + i2 < getWidth() && this.acZ < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.acZ, this.adg.poll(), this);
            l(view, -1);
            i += view.getMeasuredWidth();
            if (this.acZ == this.mAdapter.getCount() - 1) {
                this.adc = (this.ada + i) - getWidth();
            }
            if (this.adc < 0) {
                this.adc = 0;
            }
            this.acZ++;
        }
    }

    private void A(int i, int i2) {
        while (i + i2 > 0 && this.acY >= 0) {
            View view = this.mAdapter.getView(this.acY, this.adg.poll(), this);
            l(view, 0);
            i -= view.getMeasuredWidth();
            this.acY--;
            this.ade -= view.getMeasuredWidth();
        }
    }

    private void cF(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.ade += childAt.getMeasuredWidth();
            this.adg.offer(childAt);
            removeViewInLayout(childAt);
            this.acY++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.adg.offer(childAt2);
            removeViewInLayout(childAt2);
            this.acZ--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    private void cG(int i) {
        if (getChildCount() > 0) {
            this.ade += i;
            int i2 = this.ade;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    public synchronized void cH(int i) {
        this.mScroller.startScroll(this.adb, 0, i - this.adb, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent) | this.adf.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.adb, 0, (int) (-f), 0, 0, this.adc, 0, 0);
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
                if (childAt.getWidth() + childAt.getLeft() >= this.adm) {
                    return i + 1 + this.acY;
                }
            }
            return 0;
        }
        return 0;
    }
}
