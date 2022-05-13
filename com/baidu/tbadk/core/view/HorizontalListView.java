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
import com.repackage.mi;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes3.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ListAdapter b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Scroller i;
    public GestureDetector j;
    public Queue<View> k;
    public AdapterView.OnItemSelectedListener l;
    public AdapterView.OnItemClickListener m;
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

    /* loaded from: classes3.dex */
    public class a extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalListView a;

        public a(HorizontalListView horizontalListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalListView;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a) {
                    this.a.p = true;
                }
                this.a.invalidate();
                this.a.requestLayout();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.u();
                this.a.invalidate();
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalListView a;

        public b(HorizontalListView horizontalListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalListView a;

        public c(HorizontalListView horizontalListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalListView;
        }

        public final boolean a(MotionEvent motionEvent, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, motionEvent, view2)) == null) {
                Rect rect = new Rect();
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                rect.set(i, i2, view2.getWidth() + i, view2.getHeight() + i2);
                return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
            return invokeLL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.a.q(motionEvent) : invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) ? this.a.r(motionEvent, motionEvent2, f, f2) : invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                int childCount = this.a.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.a.getChildAt(i);
                    if (a(motionEvent, childAt)) {
                        if (this.a.n != null) {
                            this.a.x = true;
                            AdapterView.OnItemLongClickListener onItemLongClickListener = this.a.n;
                            HorizontalListView horizontalListView = this.a;
                            int i2 = horizontalListView.c + 1 + i;
                            HorizontalListView horizontalListView2 = this.a;
                            onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i2, horizontalListView2.b.getItemId(horizontalListView2.c + 1 + i));
                            return;
                        }
                        return;
                    }
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (this.a.x) {
                    return true;
                }
                synchronized (this.a) {
                    this.a.f += (int) f;
                }
                this.a.requestLayout();
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                int i = 0;
                while (true) {
                    if (i >= this.a.getChildCount()) {
                        break;
                    }
                    View childAt = this.a.getChildAt(i);
                    if (a(motionEvent, childAt)) {
                        if (this.a.m != null) {
                            AdapterView.OnItemClickListener onItemClickListener = this.a.m;
                            HorizontalListView horizontalListView = this.a;
                            int i2 = horizontalListView.c + 1 + i;
                            HorizontalListView horizontalListView2 = this.a;
                            onItemClickListener.onItemClick(horizontalListView, childAt, i2, horizontalListView2.b.getItemId(horizontalListView2.c + 1 + i));
                        }
                        if (this.a.l != null) {
                            AdapterView.OnItemSelectedListener onItemSelectedListener = this.a.l;
                            HorizontalListView horizontalListView3 = this.a;
                            int i3 = horizontalListView3.c + 1 + i;
                            HorizontalListView horizontalListView4 = this.a;
                            onItemSelectedListener.onItemSelected(horizontalListView3, childAt, i3, horizontalListView4.b.getItemId(horizontalListView4.c + 1 + i));
                        }
                    } else {
                        i++;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.d = 0;
        this.g = Integer.MAX_VALUE;
        this.h = 0;
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
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt.getLeft() + childAt.getWidth() >= this.q) {
                        return i + 1 + this.c;
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
            return this.j.onTouchEvent(motionEvent) | dispatchTouchEvent;
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

    public final void i(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, view2, i) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            addViewInLayout(view2, i, layoutParams, true);
            view2.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
        }
    }

    public final void j(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) {
            int i = this.u;
            int n = n(motionEvent, i);
            if (i == -1) {
                return;
            }
            try {
                float x = MotionEventCompat.getX(motionEvent, n);
                float y = MotionEventCompat.getY(motionEvent, n);
                float abs = Math.abs(x - this.s);
                float abs2 = Math.abs(y - this.t);
                if (abs <= this.a || abs <= abs2) {
                    return;
                }
                this.v = true;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            View childAt = getChildAt(getChildCount() - 1);
            m(childAt != null ? childAt.getRight() : 0, i);
            View childAt2 = getChildAt(0);
            l(childAt2 != null ? childAt2.getLeft() : 0, i);
        }
    }

    public final void l(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            while (i + i2 > 0 && (i3 = this.c) >= 0) {
                View view2 = this.b.getView(i3, this.k.poll(), this);
                i(view2, 0);
                i -= view2.getMeasuredWidth();
                this.c--;
                this.h -= view2.getMeasuredWidth();
            }
        }
    }

    public final void m(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            while (i + i2 < getWidth() && this.d < this.b.getCount()) {
                View view2 = this.b.getView(this.d, this.k.poll(), this);
                i(view2, -1);
                i += view2.getMeasuredWidth();
                if (this.d == this.b.getCount() - 1) {
                    this.g = (this.e + i) - getWidth();
                }
                if (this.g < 0) {
                    this.g = 0;
                }
                this.d++;
            }
        }
    }

    public final int n(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, motionEvent, i)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
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
                this.c = -1;
                this.d = 0;
                this.h = 0;
                this.e = 0;
                this.f = 0;
                this.g = Integer.MAX_VALUE;
                this.i = new Scroller(getContext());
                this.j = new GestureDetector(getContext(), this.z);
                this.q = mi.k(getContext()) / 2;
                this.a = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
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
    public synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            synchronized (this) {
                super.onLayout(z, i, i2, i3, i4);
                if (this.b == null) {
                    return;
                }
                if (this.p) {
                    int i5 = this.e;
                    o();
                    removeAllViewsInLayout();
                    this.f = i5;
                    this.p = false;
                }
                if (this.i.computeScrollOffset()) {
                    this.f = this.i.getCurrX();
                }
                if (this.f <= 0) {
                    this.f = 0;
                    this.i.forceFinished(true);
                }
                if (this.f >= this.g) {
                    this.f = this.g;
                    this.i.forceFinished(true);
                }
                int i6 = this.e - this.f;
                t(i6);
                k(i6);
                s(i6);
                if (this.o != null) {
                    this.o.a(getMiddleViewPosition());
                }
                this.e = this.f;
                if (!this.i.isFinished()) {
                    post(new b(this));
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == Integer.MIN_VALUE) {
                size = p(i, size);
            }
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
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

    public final int p(int i, int i2) {
        InterceptResult invokeII;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i, i2)) == null) {
            if (this.b == null) {
                return getPaddingLeft() + getPaddingRight();
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int count = this.b.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                View poll = this.k.poll();
                if (poll == null) {
                    view2 = this.b.getView(i3, null, this);
                } else {
                    view2 = this.b.getView(i3, poll, this);
                }
                view2.measure(i, 0);
                paddingLeft += view2.getMeasuredWidth();
                this.k.add(view2);
            }
            return Math.min(paddingLeft, i2);
        }
        return invokeII.intValue;
    }

    public boolean q(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            this.i.forceFinished(true);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean r(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            synchronized (this) {
                this.i.fling(this.f, 0, (int) (-f), 0, 0, this.g, 0, 0);
            }
            requestLayout();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || getChildCount() <= 0) {
            return;
        }
        int i2 = this.h + i;
        this.h = i2;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            int measuredWidth = childAt.getMeasuredWidth();
            childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
            i2 += measuredWidth + childAt.getPaddingRight();
        }
    }

    public void setDisableParentEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.r = z;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onItemClickListener) == null) {
            this.m = onItemClickListener;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onItemLongClickListener) == null) {
            this.n = onItemLongClickListener;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onItemSelectedListener) == null) {
            this.l = onItemSelectedListener;
        }
    }

    public void setOnScrollChangedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, dVar) == null) {
            this.o = dVar;
        }
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
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
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cVar) == null) {
            this.w = cVar;
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i <= 0) {
                this.h += childAt.getMeasuredWidth();
                this.k.offer(childAt);
                removeViewInLayout(childAt);
                this.c++;
                childAt = getChildAt(0);
            }
            View childAt2 = getChildAt(getChildCount() - 1);
            while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
                this.k.offer(childAt2);
                removeViewInLayout(childAt2);
                this.d--;
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

    public synchronized void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            synchronized (this) {
                this.i.startScroll(this.f, 0, i - this.f, 0);
                requestLayout();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (ListAdapter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, listAdapter) == null) {
            ListAdapter listAdapter2 = this.b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(this.y);
            }
            this.b = listAdapter;
            listAdapter.registerDataSetObserver(this.y);
            u();
        }
    }
}
