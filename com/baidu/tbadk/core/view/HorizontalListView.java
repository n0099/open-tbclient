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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import c.a.e.e.p.l;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes6.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47423e;

    /* renamed from: f  reason: collision with root package name */
    public int f47424f;

    /* renamed from: g  reason: collision with root package name */
    public int f47425g;

    /* renamed from: h  reason: collision with root package name */
    public int f47426h;

    /* renamed from: i  reason: collision with root package name */
    public int f47427i;

    /* renamed from: j  reason: collision with root package name */
    public GestureDetector f47428j;
    public Queue<View> k;
    public AdapterView.OnItemSelectedListener l;
    public AdapterView.OnItemClickListener m;
    public ListAdapter mAdapter;
    public int mCurrentX;
    public int mNextX;
    public Scroller mScroller;
    public AdapterView.OnItemLongClickListener n;
    public d o;
    public boolean p;
    public int q;
    public boolean r;
    public float s;
    public float t;
    public int u;
    public boolean v;
    public SwipeBackLayout.c w;
    public boolean x;
    public DataSetObserver y;
    public GestureDetector.OnGestureListener z;

    /* loaded from: classes6.dex */
    public class a extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalListView f47429a;

        public a(HorizontalListView horizontalListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47429a = horizontalListView;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f47429a) {
                    this.f47429a.p = true;
                }
                this.f47429a.invalidate();
                this.f47429a.requestLayout();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f47429a.s();
                this.f47429a.invalidate();
                this.f47429a.requestLayout();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalListView f47430e;

        public b(HorizontalListView horizontalListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47430e = horizontalListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47430e.requestLayout();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalListView f47431e;

        public c(HorizontalListView horizontalListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47431e = horizontalListView;
        }

        public final boolean a(MotionEvent motionEvent, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, motionEvent, view)) == null) {
                Rect rect = new Rect();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                rect.set(i2, i3, view.getWidth() + i2, view.getHeight() + i3);
                return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
            return invokeLL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.f47431e.onDown(motionEvent) : invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.f47431e.onFling(motionEvent, motionEvent2, f2, f3) : invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                int childCount = this.f47431e.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.f47431e.getChildAt(i2);
                    if (a(motionEvent, childAt)) {
                        if (this.f47431e.n != null) {
                            this.f47431e.x = true;
                            AdapterView.OnItemLongClickListener onItemLongClickListener = this.f47431e.n;
                            HorizontalListView horizontalListView = this.f47431e;
                            int i3 = horizontalListView.f47424f + 1 + i2;
                            HorizontalListView horizontalListView2 = this.f47431e;
                            onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i3, horizontalListView2.mAdapter.getItemId(horizontalListView2.f47424f + 1 + i2));
                            return;
                        }
                        return;
                    }
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f47431e.x) {
                    return true;
                }
                synchronized (this.f47431e) {
                    this.f47431e.mNextX += (int) f2;
                }
                this.f47431e.requestLayout();
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f47431e.getChildCount()) {
                        break;
                    }
                    View childAt = this.f47431e.getChildAt(i2);
                    if (a(motionEvent, childAt)) {
                        if (this.f47431e.m != null) {
                            AdapterView.OnItemClickListener onItemClickListener = this.f47431e.m;
                            HorizontalListView horizontalListView = this.f47431e;
                            int i3 = horizontalListView.f47424f + 1 + i2;
                            HorizontalListView horizontalListView2 = this.f47431e;
                            onItemClickListener.onItemClick(horizontalListView, childAt, i3, horizontalListView2.mAdapter.getItemId(horizontalListView2.f47424f + 1 + i2));
                        }
                        if (this.f47431e.l != null) {
                            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f47431e.l;
                            HorizontalListView horizontalListView3 = this.f47431e;
                            int i4 = horizontalListView3.f47424f + 1 + i2;
                            HorizontalListView horizontalListView4 = this.f47431e;
                            onItemSelectedListener.onItemSelected(horizontalListView3, childAt, i4, horizontalListView4.mAdapter.getItemId(horizontalListView4.f47424f + 1 + i2));
                        }
                    } else {
                        i2++;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47424f = -1;
        this.f47425g = 0;
        this.f47426h = Integer.MAX_VALUE;
        this.f47427i = 0;
        this.k = new LinkedList();
        this.p = false;
        this.q = 0;
        this.r = true;
        this.u = -1;
        this.v = false;
        this.x = false;
        this.y = new a(this);
        this.z = new c(this);
        o();
    }

    private int getMiddleViewPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int childCount = getChildCount();
            if (childCount > 0) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (childAt.getLeft() + childAt.getWidth() >= this.q) {
                        return i2 + 1 + this.f47424f;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if (action == 1 || action == 3) {
                this.x = false;
            }
            return this.f47428j.onTouchEvent(motionEvent) | dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void i(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, view, i2) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            addViewInLayout(view, i2, layoutParams, true);
            view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
        }
    }

    public final void j(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) {
            int i2 = this.u;
            int n = n(motionEvent, i2);
            if (i2 == -1) {
                return;
            }
            try {
                float x = MotionEventCompat.getX(motionEvent, n);
                float y = MotionEventCompat.getY(motionEvent, n);
                float abs = Math.abs(x - this.s);
                float abs2 = Math.abs(y - this.t);
                if (abs <= this.f47423e || abs <= abs2) {
                    return;
                }
                this.v = true;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            View childAt = getChildAt(getChildCount() - 1);
            m(childAt != null ? childAt.getRight() : 0, i2);
            View childAt2 = getChildAt(0);
            l(childAt2 != null ? childAt2.getLeft() : 0, i2);
        }
    }

    public final void l(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            while (i2 + i3 > 0 && (i4 = this.f47424f) >= 0) {
                View view = this.mAdapter.getView(i4, this.k.poll(), this);
                i(view, 0);
                i2 -= view.getMeasuredWidth();
                this.f47424f--;
                this.f47427i -= view.getMeasuredWidth();
            }
        }
    }

    public final void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            while (i2 + i3 < getWidth() && this.f47425g < this.mAdapter.getCount()) {
                View view = this.mAdapter.getView(this.f47425g, this.k.poll(), this);
                i(view, -1);
                i2 += view.getMeasuredWidth();
                if (this.f47425g == this.mAdapter.getCount() - 1) {
                    this.f47426h = (this.mCurrentX + i2) - getWidth();
                }
                if (this.f47426h < 0) {
                    this.f47426h = 0;
                }
                this.f47425g++;
            }
        }
    }

    public final int n(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, motionEvent, i2)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (findPointerIndex == -1) {
                this.u = -1;
            }
            return findPointerIndex;
        }
        return invokeLI.intValue;
    }

    public final synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.f47424f = -1;
                this.f47425g = 0;
                this.f47427i = 0;
                this.mCurrentX = 0;
                this.mNextX = 0;
                this.f47426h = Integer.MAX_VALUE;
                this.mScroller = new Scroller(getContext());
                this.f47428j = new GestureDetector(getContext(), this.z);
                this.q = l.k(getContext()) / 2;
                this.f47423e = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
            }
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            this.mScroller.forceFinished(true);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            synchronized (this) {
                this.mScroller.fling(this.mNextX, 0, (int) (-f2), 0, 0, this.f47426h, 0, 0);
            }
            requestLayout();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            if (this.r) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.onInterceptTouchEvent(motionEvent);
            } else if (this.v) {
                return true;
            } else {
                int action = motionEvent.getAction();
                if (action != 3 && action != 1) {
                    if (action == 0) {
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        this.u = pointerId;
                        if (pointerId != -1) {
                            this.s = MotionEventCompat.getX(motionEvent, actionIndex);
                            this.t = MotionEventCompat.getY(motionEvent, actionIndex);
                            SwipeBackLayout.c cVar = this.w;
                            if (cVar != null) {
                                cVar.disableSwipeBack();
                            }
                        }
                    } else if (action != 2) {
                        SwipeBackLayout.c cVar2 = this.w;
                        if (cVar2 != null) {
                            cVar2.enableSwipeBack();
                        }
                    } else {
                        SwipeBackLayout.c cVar3 = this.w;
                        if (cVar3 != null) {
                            cVar3.disableSwipeBack();
                        }
                        j(motionEvent);
                        if (this.v) {
                            return true;
                        }
                    }
                    return super.onInterceptTouchEvent(motionEvent);
                }
                this.v = false;
                SwipeBackLayout.c cVar4 = this.w;
                if (cVar4 != null) {
                    cVar4.enableSwipeBack();
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public synchronized void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            synchronized (this) {
                super.onLayout(z, i2, i3, i4, i5);
                if (this.mAdapter == null) {
                    return;
                }
                if (this.p) {
                    int i6 = this.mCurrentX;
                    o();
                    removeAllViewsInLayout();
                    this.mNextX = i6;
                    this.p = false;
                }
                if (this.mScroller.computeScrollOffset()) {
                    this.mNextX = this.mScroller.getCurrX();
                }
                if (this.mNextX <= 0) {
                    this.mNextX = 0;
                    this.mScroller.forceFinished(true);
                }
                if (this.mNextX >= this.f47426h) {
                    this.mNextX = this.f47426h;
                    this.mScroller.forceFinished(true);
                }
                int i7 = this.mCurrentX - this.mNextX;
                r(i7);
                k(i7);
                q(i7);
                if (this.o != null) {
                    this.o.a(getMiddleViewPosition());
                }
                this.mCurrentX = this.mNextX;
                if (!this.mScroller.isFinished()) {
                    post(new b(this));
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode == Integer.MIN_VALUE) {
                size = p(i2, size);
            }
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            if (this.r) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.u = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                SwipeBackLayout.c cVar = this.w;
                if (cVar != null) {
                    cVar.disableSwipeBack();
                }
            } else if (action == 1) {
                this.v = false;
                SwipeBackLayout.c cVar2 = this.w;
                if (cVar2 != null) {
                    cVar2.enableSwipeBack();
                }
            } else if (action != 2) {
                SwipeBackLayout.c cVar3 = this.w;
                if (cVar3 != null) {
                    cVar3.enableSwipeBack();
                }
            } else {
                SwipeBackLayout.c cVar4 = this.w;
                if (cVar4 != null) {
                    cVar4.disableSwipeBack();
                }
                if (!this.v) {
                    j(motionEvent);
                }
                if (this.v && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final int p(int i2, int i3) {
        InterceptResult invokeII;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i2, i3)) == null) {
            if (this.mAdapter == null) {
                return getPaddingLeft() + getPaddingRight();
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int count = this.mAdapter.getCount();
            for (int i4 = 0; i4 < count; i4++) {
                View poll = this.k.poll();
                if (poll == null) {
                    view = this.mAdapter.getView(i4, null, this);
                } else {
                    view = this.mAdapter.getView(i4, poll, this);
                }
                view.measure(i2, 0);
                paddingLeft += view.getMeasuredWidth();
                this.k.add(view);
            }
            return Math.min(paddingLeft, i3);
        }
        return invokeII.intValue;
    }

    public final void q(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || getChildCount() <= 0) {
            return;
        }
        int i3 = this.f47427i + i2;
        this.f47427i = i3;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            int measuredWidth = childAt.getMeasuredWidth();
            childAt.layout(i3, 0, i3 + measuredWidth, childAt.getMeasuredHeight());
            i3 += measuredWidth + childAt.getPaddingRight();
        }
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i2 <= 0) {
                this.f47427i += childAt.getMeasuredWidth();
                this.k.offer(childAt);
                removeViewInLayout(childAt);
                this.f47424f++;
                childAt = getChildAt(0);
            }
            View childAt2 = getChildAt(getChildCount() - 1);
            while (childAt2 != null && childAt2.getLeft() + i2 >= getWidth()) {
                this.k.offer(childAt2);
                removeViewInLayout(childAt2);
                this.f47425g--;
                childAt2 = getChildAt(getChildCount() - 1);
            }
        }
    }

    public final synchronized void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                o();
                removeAllViewsInLayout();
                requestLayout();
            }
        }
    }

    public synchronized void scrollTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            synchronized (this) {
                this.mScroller.startScroll(this.mNextX, 0, i2 - this.mNextX, 0);
                requestLayout();
            }
        }
    }

    public void setDisableParentEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.r = z;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onItemClickListener) == null) {
            this.m = onItemClickListener;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onItemLongClickListener) == null) {
            this.n = onItemLongClickListener;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onItemSelectedListener) == null) {
            this.l = onItemSelectedListener;
        }
    }

    public void setOnScrollChangedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, dVar) == null) {
            this.o = dVar;
        }
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            int width = i2 * getWidth();
            int childCount = getChildCount() * getWidth();
            if (width <= 0) {
                width = 0;
            }
            if (width <= childCount) {
                childCount = width;
            }
            scrollTo(childCount);
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, cVar) == null) {
            this.w = cVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAdapter : (ListAdapter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, listAdapter) == null) {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(this.y);
            }
            this.mAdapter = listAdapter;
            listAdapter.registerDataSetObserver(this.y);
            s();
        }
    }
}
