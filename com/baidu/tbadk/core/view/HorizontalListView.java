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
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes4.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwipeBackLayout.c A;
    public boolean B;
    public DataSetObserver C;
    public GestureDetector.OnGestureListener D;

    /* renamed from: e  reason: collision with root package name */
    public int f12413e;

    /* renamed from: f  reason: collision with root package name */
    public ListAdapter f12414f;

    /* renamed from: g  reason: collision with root package name */
    public int f12415g;

    /* renamed from: h  reason: collision with root package name */
    public int f12416h;

    /* renamed from: i  reason: collision with root package name */
    public int f12417i;
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

    /* loaded from: classes4.dex */
    public class a extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalListView f12418a;

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
            this.f12418a = horizontalListView;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f12418a) {
                    this.f12418a.t = true;
                }
                this.f12418a.invalidate();
                this.f12418a.requestLayout();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f12418a.u();
                this.f12418a.invalidate();
                this.f12418a.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalListView f12419e;

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
            this.f12419e = horizontalListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12419e.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalListView f12420e;

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
            this.f12420e = horizontalListView;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.f12420e.q(motionEvent) : invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.f12420e.r(motionEvent, motionEvent2, f2, f3) : invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                int childCount = this.f12420e.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.f12420e.getChildAt(i2);
                    if (a(motionEvent, childAt)) {
                        if (this.f12420e.r != null) {
                            this.f12420e.B = true;
                            AdapterView.OnItemLongClickListener onItemLongClickListener = this.f12420e.r;
                            HorizontalListView horizontalListView = this.f12420e;
                            int i3 = horizontalListView.f12415g + 1 + i2;
                            HorizontalListView horizontalListView2 = this.f12420e;
                            onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i3, horizontalListView2.f12414f.getItemId(horizontalListView2.f12415g + 1 + i2));
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
                if (this.f12420e.B) {
                    return true;
                }
                synchronized (this.f12420e) {
                    this.f12420e.j += (int) f2;
                }
                this.f12420e.requestLayout();
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
                    if (i2 >= this.f12420e.getChildCount()) {
                        break;
                    }
                    View childAt = this.f12420e.getChildAt(i2);
                    if (a(motionEvent, childAt)) {
                        if (this.f12420e.q != null) {
                            AdapterView.OnItemClickListener onItemClickListener = this.f12420e.q;
                            HorizontalListView horizontalListView = this.f12420e;
                            int i3 = horizontalListView.f12415g + 1 + i2;
                            HorizontalListView horizontalListView2 = this.f12420e;
                            onItemClickListener.onItemClick(horizontalListView, childAt, i3, horizontalListView2.f12414f.getItemId(horizontalListView2.f12415g + 1 + i2));
                        }
                        if (this.f12420e.p != null) {
                            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f12420e.p;
                            HorizontalListView horizontalListView3 = this.f12420e;
                            int i4 = horizontalListView3.f12415g + 1 + i2;
                            HorizontalListView horizontalListView4 = this.f12420e;
                            onItemSelectedListener.onItemSelected(horizontalListView3, childAt, i4, horizontalListView4.f12414f.getItemId(horizontalListView4.f12415g + 1 + i2));
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

    /* loaded from: classes4.dex */
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
        this.f12415g = -1;
        this.f12416h = 0;
        this.k = Integer.MAX_VALUE;
        this.l = 0;
        this.o = new LinkedList();
        this.t = false;
        this.u = 0;
        this.v = true;
        this.y = -1;
        this.z = false;
        this.B = false;
        this.C = new a(this);
        this.D = new c(this);
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
                    if (childAt.getLeft() + childAt.getWidth() >= this.u) {
                        return i2 + 1 + this.f12415g;
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
                this.B = false;
            }
            return this.n.onTouchEvent(motionEvent) | dispatchTouchEvent;
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
            int i2 = this.y;
            int n = n(motionEvent, i2);
            if (i2 == -1) {
                return;
            }
            try {
                float x = MotionEventCompat.getX(motionEvent, n);
                float y = MotionEventCompat.getY(motionEvent, n);
                float abs = Math.abs(x - this.w);
                float abs2 = Math.abs(y - this.x);
                if (abs <= this.f12413e || abs <= abs2) {
                    return;
                }
                this.z = true;
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
            while (i2 + i3 > 0 && (i4 = this.f12415g) >= 0) {
                View view = this.f12414f.getView(i4, this.o.poll(), this);
                i(view, 0);
                i2 -= view.getMeasuredWidth();
                this.f12415g--;
                this.l -= view.getMeasuredWidth();
            }
        }
    }

    public final void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            while (i2 + i3 < getWidth() && this.f12416h < this.f12414f.getCount()) {
                View view = this.f12414f.getView(this.f12416h, this.o.poll(), this);
                i(view, -1);
                i2 += view.getMeasuredWidth();
                if (this.f12416h == this.f12414f.getCount() - 1) {
                    this.k = (this.f12417i + i2) - getWidth();
                }
                if (this.k < 0) {
                    this.k = 0;
                }
                this.f12416h++;
            }
        }
    }

    public final int n(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, motionEvent, i2)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (findPointerIndex == -1) {
                this.y = -1;
            }
            return findPointerIndex;
        }
        return invokeLI.intValue;
    }

    public final synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.f12415g = -1;
                this.f12416h = 0;
                this.l = 0;
                this.f12417i = 0;
                this.j = 0;
                this.k = Integer.MAX_VALUE;
                this.m = new Scroller(getContext());
                this.n = new GestureDetector(getContext(), this.D);
                this.u = l.k(getContext()) / 2;
                this.f12413e = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public synchronized void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            synchronized (this) {
                super.onLayout(z, i2, i3, i4, i5);
                if (this.f12414f == null) {
                    return;
                }
                if (this.t) {
                    int i6 = this.f12417i;
                    o();
                    removeAllViewsInLayout();
                    this.j = i6;
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
                int i7 = this.f12417i - this.j;
                t(i7);
                k(i7);
                s(i7);
                if (this.s != null) {
                    this.s.a(getMiddleViewPosition());
                }
                this.f12417i = this.j;
                if (!this.m.isFinished()) {
                    post(new b(this));
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    public final int p(int i2, int i3) {
        InterceptResult invokeII;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i2, i3)) == null) {
            if (this.f12414f == null) {
                return getPaddingLeft() + getPaddingRight();
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int count = this.f12414f.getCount();
            for (int i4 = 0; i4 < count; i4++) {
                View poll = this.o.poll();
                if (poll == null) {
                    view = this.f12414f.getView(i4, null, this);
                } else {
                    view = this.f12414f.getView(i4, poll, this);
                }
                view.measure(i2, 0);
                paddingLeft += view.getMeasuredWidth();
                this.o.add(view);
            }
            return Math.min(paddingLeft, i3);
        }
        return invokeII.intValue;
    }

    public boolean q(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            this.m.forceFinished(true);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean r(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            synchronized (this) {
                this.m.fling(this.j, 0, (int) (-f2), 0, 0, this.k, 0, 0);
            }
            requestLayout();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || getChildCount() <= 0) {
            return;
        }
        int i3 = this.l + i2;
        this.l = i3;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            int measuredWidth = childAt.getMeasuredWidth();
            childAt.layout(i3, 0, i3 + measuredWidth, childAt.getMeasuredHeight());
            i3 += measuredWidth + childAt.getPaddingRight();
        }
    }

    public void setDisableParentEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.v = z;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onItemClickListener) == null) {
            this.q = onItemClickListener;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onItemLongClickListener) == null) {
            this.r = onItemLongClickListener;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onItemSelectedListener) == null) {
            this.p = onItemSelectedListener;
        }
    }

    public void setOnScrollChangedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, dVar) == null) {
            this.s = dVar;
        }
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            int width = i2 * getWidth();
            int childCount = getChildCount() * getWidth();
            if (width <= 0) {
                width = 0;
            }
            if (width <= childCount) {
                childCount = width;
            }
            v(childCount);
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cVar) == null) {
            this.A = cVar;
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i2 <= 0) {
                this.l += childAt.getMeasuredWidth();
                this.o.offer(childAt);
                removeViewInLayout(childAt);
                this.f12415g++;
                childAt = getChildAt(0);
            }
            View childAt2 = getChildAt(getChildCount() - 1);
            while (childAt2 != null && childAt2.getLeft() + i2 >= getWidth()) {
                this.o.offer(childAt2);
                removeViewInLayout(childAt2);
                this.f12416h--;
                childAt2 = getChildAt(getChildCount() - 1);
            }
        }
    }

    public final synchronized void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                o();
                removeAllViewsInLayout();
                requestLayout();
            }
        }
    }

    public synchronized void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            synchronized (this) {
                this.m.startScroll(this.j, 0, i2 - this.j, 0);
                requestLayout();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12414f : (ListAdapter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, listAdapter) == null) {
            ListAdapter listAdapter2 = this.f12414f;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(this.C);
            }
            this.f12414f = listAdapter;
            listAdapter.registerDataSetObserver(this.C);
            u();
        }
    }
}
