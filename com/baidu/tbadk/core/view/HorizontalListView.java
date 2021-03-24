package com.baidu.tbadk.core.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.baidu.adp.widget.SwipeBackLayout;
import d.b.b.e.p.l;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes3.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public SwipeBackLayout.c A;
    public boolean B;
    public DataSetObserver C;
    public GestureDetector.OnGestureListener D;

    /* renamed from: e  reason: collision with root package name */
    public int f13370e;

    /* renamed from: f  reason: collision with root package name */
    public ListAdapter f13371f;

    /* renamed from: g  reason: collision with root package name */
    public int f13372g;

    /* renamed from: h  reason: collision with root package name */
    public int f13373h;
    public int i;
    public int j;
    public int k;
    public int l;
    public Scroller m;
    public GestureDetector n;
    public Queue<View> o;
    public AdapterView.OnItemSelectedListener p;
    public AdapterView.OnItemClickListener q;
    public AdapterView.OnItemLongClickListener r;
    public d s;
    public boolean t;
    public int u;
    public boolean v;
    public float w;
    public float x;
    public int y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            synchronized (HorizontalListView.this) {
                HorizontalListView.this.t = true;
            }
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HorizontalListView.this.u();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HorizontalListView.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        public final boolean a(MotionEvent motionEvent, View view) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            rect.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
            return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.q(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return HorizontalListView.this.r(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            int childCount = HorizontalListView.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = HorizontalListView.this.getChildAt(i);
                if (a(motionEvent, childAt)) {
                    if (HorizontalListView.this.r != null) {
                        HorizontalListView.this.B = true;
                        AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.r;
                        HorizontalListView horizontalListView = HorizontalListView.this;
                        int i2 = horizontalListView.f13372g + 1 + i;
                        HorizontalListView horizontalListView2 = HorizontalListView.this;
                        onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i2, horizontalListView2.f13371f.getItemId(horizontalListView2.f13372g + 1 + i));
                        return;
                    }
                    return;
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (HorizontalListView.this.B) {
                return true;
            }
            synchronized (HorizontalListView.this) {
                HorizontalListView.this.j += (int) f2;
            }
            HorizontalListView.this.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int i = 0;
            while (true) {
                if (i >= HorizontalListView.this.getChildCount()) {
                    break;
                }
                View childAt = HorizontalListView.this.getChildAt(i);
                if (a(motionEvent, childAt)) {
                    if (HorizontalListView.this.q != null) {
                        AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.q;
                        HorizontalListView horizontalListView = HorizontalListView.this;
                        int i2 = horizontalListView.f13372g + 1 + i;
                        HorizontalListView horizontalListView2 = HorizontalListView.this;
                        onItemClickListener.onItemClick(horizontalListView, childAt, i2, horizontalListView2.f13371f.getItemId(horizontalListView2.f13372g + 1 + i));
                    }
                    if (HorizontalListView.this.p != null) {
                        AdapterView.OnItemSelectedListener onItemSelectedListener = HorizontalListView.this.p;
                        HorizontalListView horizontalListView3 = HorizontalListView.this;
                        int i3 = horizontalListView3.f13372g + 1 + i;
                        HorizontalListView horizontalListView4 = HorizontalListView.this;
                        onItemSelectedListener.onItemSelected(horizontalListView3, childAt, i3, horizontalListView4.f13371f.getItemId(horizontalListView4.f13372g + 1 + i));
                    }
                } else {
                    i++;
                }
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13372g = -1;
        this.f13373h = 0;
        this.k = Integer.MAX_VALUE;
        this.l = 0;
        this.o = new LinkedList();
        this.t = false;
        this.u = 0;
        this.v = true;
        this.y = -1;
        this.z = false;
        this.B = false;
        this.C = new a();
        this.D = new c();
        o();
    }

    private int getMiddleViewPosition() {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getLeft() + childAt.getWidth() >= this.u) {
                    return i + 1 + this.f13372g;
                }
            }
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this.B = false;
        }
        return this.n.onTouchEvent(motionEvent) | dispatchTouchEvent;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    public final void i(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    public final void j(MotionEvent motionEvent) {
        int i = this.y;
        int n = n(motionEvent, i);
        if (i == -1) {
            return;
        }
        try {
            float x = MotionEventCompat.getX(motionEvent, n);
            float y = MotionEventCompat.getY(motionEvent, n);
            float abs = Math.abs(x - this.w);
            float abs2 = Math.abs(y - this.x);
            if (abs <= this.f13370e || abs <= abs2) {
                return;
            }
            this.z = true;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    public final void k(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        m(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        l(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    public final void l(int i, int i2) {
        int i3;
        while (i + i2 > 0 && (i3 = this.f13372g) >= 0) {
            View view = this.f13371f.getView(i3, this.o.poll(), this);
            i(view, 0);
            i -= view.getMeasuredWidth();
            this.f13372g--;
            this.l -= view.getMeasuredWidth();
        }
    }

    public final void m(int i, int i2) {
        while (i + i2 < getWidth() && this.f13373h < this.f13371f.getCount()) {
            View view = this.f13371f.getView(this.f13373h, this.o.poll(), this);
            i(view, -1);
            i += view.getMeasuredWidth();
            if (this.f13373h == this.f13371f.getCount() - 1) {
                this.k = (this.i + i) - getWidth();
            }
            if (this.k < 0) {
                this.k = 0;
            }
            this.f13373h++;
        }
    }

    public final int n(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.y = -1;
        }
        return findPointerIndex;
    }

    public final synchronized void o() {
        this.f13372g = -1;
        this.f13373h = 0;
        this.l = 0;
        this.i = 0;
        this.j = 0;
        this.k = Integer.MAX_VALUE;
        this.m = new Scroller(getContext());
        this.n = new GestureDetector(getContext(), this.D);
        this.u = l.k(getContext()) / 2;
        this.f13370e = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.v) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.z) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action != 3 && action != 1) {
                if (action == 0) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    this.y = pointerId;
                    if (pointerId != -1) {
                        this.w = MotionEventCompat.getX(motionEvent, actionIndex);
                        this.x = MotionEventCompat.getY(motionEvent, actionIndex);
                        SwipeBackLayout.c cVar = this.A;
                        if (cVar != null) {
                            cVar.disableSwipeBack();
                        }
                    }
                } else if (action != 2) {
                    SwipeBackLayout.c cVar2 = this.A;
                    if (cVar2 != null) {
                        cVar2.enableSwipeBack();
                    }
                } else {
                    SwipeBackLayout.c cVar3 = this.A;
                    if (cVar3 != null) {
                        cVar3.disableSwipeBack();
                    }
                    j(motionEvent);
                    if (this.z) {
                        return true;
                    }
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.z = false;
            SwipeBackLayout.c cVar4 = this.A;
            if (cVar4 != null) {
                cVar4.enableSwipeBack();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f13371f == null) {
            return;
        }
        if (this.t) {
            int i5 = this.i;
            o();
            removeAllViewsInLayout();
            this.j = i5;
            this.t = false;
        }
        if (this.m.computeScrollOffset()) {
            this.j = this.m.getCurrX();
        }
        if (this.j <= 0) {
            this.j = 0;
            this.m.forceFinished(true);
        }
        if (this.j >= this.k) {
            this.j = this.k;
            this.m.forceFinished(true);
        }
        int i6 = this.i - this.j;
        t(i6);
        k(i6);
        s(i6);
        if (this.s != null) {
            this.s.a(getMiddleViewPosition());
        }
        this.i = this.j;
        if (!this.m.isFinished()) {
            post(new b());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            size = p(i, size);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.v) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.y = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
            SwipeBackLayout.c cVar = this.A;
            if (cVar != null) {
                cVar.disableSwipeBack();
            }
        } else if (action == 1) {
            this.z = false;
            SwipeBackLayout.c cVar2 = this.A;
            if (cVar2 != null) {
                cVar2.enableSwipeBack();
            }
        } else if (action != 2) {
            SwipeBackLayout.c cVar3 = this.A;
            if (cVar3 != null) {
                cVar3.enableSwipeBack();
            }
        } else {
            SwipeBackLayout.c cVar4 = this.A;
            if (cVar4 != null) {
                cVar4.disableSwipeBack();
            }
            if (!this.z) {
                j(motionEvent);
            }
            if (this.z && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final int p(int i, int i2) {
        View view;
        if (this.f13371f == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int count = this.f13371f.getCount();
        for (int i3 = 0; i3 < count; i3++) {
            View poll = this.o.poll();
            if (poll == null) {
                view = this.f13371f.getView(i3, null, this);
            } else {
                view = this.f13371f.getView(i3, poll, this);
            }
            view.measure(i, 0);
            paddingLeft += view.getMeasuredWidth();
            this.o.add(view);
        }
        return Math.min(paddingLeft, i2);
    }

    public boolean q(MotionEvent motionEvent) {
        this.m.forceFinished(true);
        return true;
    }

    public boolean r(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        synchronized (this) {
            this.m.fling(this.j, 0, (int) (-f2), 0, 0, this.k, 0, 0);
        }
        requestLayout();
        return true;
    }

    public final void s(int i) {
        if (getChildCount() > 0) {
            int i2 = this.l + i;
            this.l = i2;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += measuredWidth + childAt.getPaddingRight();
            }
        }
    }

    public void setDisableParentEvent(boolean z) {
        this.v = z;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.q = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.r = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.p = onItemSelectedListener;
    }

    public void setOnScrollChangedListener(d dVar) {
        this.s = dVar;
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
        v(childCount);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.A = cVar;
    }

    public final void t(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.l += childAt.getMeasuredWidth();
            this.o.offer(childAt);
            removeViewInLayout(childAt);
            this.f13372g++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.o.offer(childAt2);
            removeViewInLayout(childAt2);
            this.f13373h--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    public final synchronized void u() {
        o();
        removeAllViewsInLayout();
        requestLayout();
    }

    public synchronized void v(int i) {
        this.m.startScroll(this.j, 0, i - this.j, 0);
        requestLayout();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.f13371f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.f13371f;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.C);
        }
        this.f13371f = listAdapter;
        listAdapter.registerDataSetObserver(this.C);
        u();
    }
}
