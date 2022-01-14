package c.a.d.n.e;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public m f3323b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f3324c;

    /* renamed from: d  reason: collision with root package name */
    public VelocityTracker f3325d;

    /* renamed from: e  reason: collision with root package name */
    public float f3326e;

    /* renamed from: f  reason: collision with root package name */
    public float f3327f;

    /* renamed from: g  reason: collision with root package name */
    public int f3328g;

    /* renamed from: h  reason: collision with root package name */
    public int f3329h;

    /* renamed from: i  reason: collision with root package name */
    public int f3330i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.s0.o.a f3331j;
    public RecyclerView.OnChildAttachStateChangeListener k;
    public RecyclerView.OnScrollListener l;
    public RecyclerView.OnItemTouchListener m;

    /* loaded from: classes.dex */
    public class a implements RecyclerView.OnChildAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.r(view);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.a.s(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                this.a.u(i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.a.t(i2, i3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements RecyclerView.OnItemTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, recyclerView, motionEvent)) == null) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    this.a.f3324c.stopScroll();
                    this.a.f3326e = motionEvent.getX();
                    this.a.f3327f = motionEvent.getY();
                    l lVar = this.a;
                    View x = lVar.x(lVar.f3326e, this.a.f3327f);
                    l lVar2 = this.a;
                    lVar2.f3328g = lVar2.f3324c.getChildAdapterPosition(x);
                    if (this.a.f3325d == null) {
                        this.a.f3325d = VelocityTracker.obtain();
                    }
                    this.a.f3325d.addMovement(motionEvent);
                    return false;
                }
                if (actionMasked != 2) {
                    if (actionMasked == 3 || actionMasked == 1) {
                        this.a.f3326e = 0.0f;
                        this.a.f3327f = 0.0f;
                        this.a.f3325d.clear();
                        return false;
                    }
                    return false;
                }
                float x2 = motionEvent.getX();
                float y = motionEvent.getY();
                int i2 = (this.a.f3330i == 2 ? y - this.a.f3327f : x2 - this.a.f3326e) >= 0.0f ? 2 : 1;
                if (i2 != this.a.f3329h) {
                    this.a.f3329h = i2;
                    this.a.f3325d.clear();
                }
                this.a.f3325d.addMovement(motionEvent);
                this.a.f3325d.computeCurrentVelocity(50);
                l lVar3 = this.a;
                lVar3.v(lVar3.f3325d.getXVelocity(), this.a.f3325d.getYVelocity());
                this.a.f3326e = x2;
                this.a.f3327f = y;
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recyclerView, motionEvent) == null) {
            }
        }
    }

    public l(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this);
        this.a = new i(jVar);
        this.f3323b = new m(jVar);
    }

    public void q(RecyclerView recyclerView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || recyclerView == null) {
            return;
        }
        RecyclerView recyclerView2 = this.f3324c;
        if (recyclerView2 != null) {
            recyclerView2.removeOnItemTouchListener(this.m);
            this.f3324c.removeOnScrollListener(this.l);
            this.f3324c.removeOnChildAttachStateChangeListener(this.k);
        }
        this.f3324c = recyclerView;
        this.f3330i = i2;
        if (recyclerView instanceof BdTypeRecyclerView) {
            this.f3323b.e((BdTypeRecyclerView) recyclerView, i2);
        } else {
            this.a.e(recyclerView, i2);
        }
        this.f3324c.addOnItemTouchListener(this.m);
        this.f3324c.addOnScrollListener(this.l);
        this.f3324c.addOnChildAttachStateChangeListener(this.k);
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (this.f3324c instanceof BdTypeRecyclerView) {
                this.f3323b.j(view);
            } else {
                this.a.g(view);
            }
        }
    }

    public final void s(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (this.f3324c instanceof BdTypeRecyclerView) {
                this.f3323b.k(view);
            } else {
                this.a.h(view);
            }
        }
    }

    public final void t(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            if (this.f3324c instanceof BdTypeRecyclerView) {
                this.f3323b.o(i2, i3, this.f3328g);
            }
            this.a.l(i2, i3, this.f3328g);
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                    if (this.f3331j == null) {
                        this.f3331j = new c.a.s0.s0.o.a("anim_switch_slide");
                    }
                    this.f3331j.b();
                }
            } else if (i2 == 0 && this.f3331j != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                this.f3331j.c();
            }
            if (this.f3324c instanceof BdTypeRecyclerView) {
                this.f3323b.p(i2);
            }
            this.a.m(i2);
        }
    }

    public final void v(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.f3324c instanceof BdTypeRecyclerView) {
                this.f3323b.s(f2, f3, this.f3328g);
            }
            this.a.o(f2, f3, this.f3328g);
        }
    }

    public void w() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (recyclerView = this.f3324c) == null) {
            return;
        }
        recyclerView.removeOnItemTouchListener(this.m);
        this.f3324c.removeOnScrollListener(this.l);
        this.f3324c.removeOnChildAttachStateChangeListener(this.k);
    }

    public View x(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            RecyclerView recyclerView = this.f3324c;
            if (recyclerView == null) {
                return null;
            }
            for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.f3324c.getChildAt(childCount);
                float translationX = childAt.getTranslationX();
                float translationY = childAt.getTranslationY();
                if (f2 >= childAt.getLeft() + translationX && f2 <= childAt.getRight() + translationX && f3 >= childAt.getTop() + translationY && f3 <= childAt.getBottom() + translationY) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
