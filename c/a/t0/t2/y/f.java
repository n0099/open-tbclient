package c.a.t0.t2.y;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import c.a.d.f.p.n;
import c.a.t0.t2.i;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.videopb.VideoContainerLayout;
import com.baidu.tieba.pb.videopb.VideoZoomBehavior;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f23547b;

    /* renamed from: c  reason: collision with root package name */
    public SwipeBackLayout f23548c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f23549d;

    /* renamed from: e  reason: collision with root package name */
    public View f23550e;

    /* renamed from: f  reason: collision with root package name */
    public View f23551f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup.LayoutParams f23552g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.LayoutParams f23553h;

    /* renamed from: i  reason: collision with root package name */
    public View f23554i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f23555j;
    public Rect k;
    public boolean l;
    public ValueAnimator m;
    public ValueAnimator n;
    public Animator.AnimatorListener o;
    public View[] p;
    public boolean q;

    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23556e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23556e = fVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f23556e.p(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23557e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23557e = fVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f23557e.o();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f23557e.o();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f23557e.o == null) {
                return;
            }
            this.f23557e.o.onAnimationStart(animator);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23558e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23558e = fVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f23558e.n(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23559e;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23559e = fVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f23559e.m();
                if (this.f23559e.o != null) {
                    this.f23559e.o.onAnimationCancel(animator);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f23559e.m();
                if (this.f23559e.o != null) {
                    this.f23559e.o.onAnimationEnd(animator);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View[] viewArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f23559e.f23547b.removeView(this.f23559e.f23550e);
                SkinManager.setBackgroundColor(this.f23559e.f23549d, c.a.t0.t2.f.CAM_X0201);
                for (View view : this.f23559e.p) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }
        }
    }

    public f(FragmentActivity fragmentActivity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = true;
        this.q = false;
        this.a = fragmentActivity;
        this.f23551f = view;
        ViewGroup viewGroup = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.f23547b = viewGroup;
        this.f23554i = viewGroup.findViewById(i.appbar_layout);
        this.f23549d = (ViewGroup) this.f23547b.findViewById(i.video_pb_root);
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View[] viewArr = new View[3];
            this.p = viewArr;
            viewArr[0] = this.f23547b.findViewById(i.pb_video_view_pager);
            this.p[1] = this.f23547b.findViewById(i.pb_video_tab_strip);
            this.p[2] = this.f23547b.findViewById(i.video_pb_comment_container);
            this.f23547b.findViewById(16908290).setBackgroundResource(c.a.t0.t2.f.transparent);
            this.f23547b.findViewById(i.container).setBackgroundResource(c.a.t0.t2.f.transparent);
            this.f23547b.findViewById(i.video_pb_root).setBackgroundResource(c.a.t0.t2.f.transparent);
            this.f23547b.findViewById(i.pb_video_nested_scroll_layout).setBackgroundResource(c.a.t0.t2.f.transparent);
            this.f23547b.findViewById(i.appbar_layout).setBackgroundResource(c.a.t0.t2.f.transparent);
            this.f23547b.findViewById(i.scroll_container).setBackgroundResource(c.a.t0.t2.f.transparent);
            if (this.f23547b.getChildAt(0) instanceof SwipeBackLayout) {
                SwipeBackLayout swipeBackLayout = (SwipeBackLayout) this.f23547b.getChildAt(0);
                this.f23548c = swipeBackLayout;
                swipeBackLayout.setBgTransparent();
            }
            View view = new View(this.a);
            this.f23550e = view;
            SkinManager.setBackgroundColor(view, c.a.t0.t2.f.CAM_X0201);
            this.f23547b.addView(this.f23550e, 0, new ViewGroup.LayoutParams(-1, -1));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.m = ofFloat;
            ofFloat.setInterpolator(new DecelerateInterpolator());
            this.m.setDuration(300L);
            this.m.addUpdateListener(new a(this));
            this.m.addListener(new b(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.n = ofFloat2;
            ofFloat2.setDuration(100L);
            this.n.addUpdateListener(new c(this));
            this.n.addListener(new d(this));
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Rect rect;
        Rect rect2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (!this.l || (rect = this.f23555j) == null || rect.isEmpty() || (rect2 = this.k) == null || rect2.isEmpty()) ? false : true : invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.q = false;
            for (View view : this.p) {
                view.setAlpha(1.0f);
            }
        }
    }

    public final void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            for (View view : this.p) {
                view.setAlpha(f2);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View view = this.f23550e;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            this.f23551f.setTranslationX(0.0f);
            this.f23551f.setTranslationY(0.0f);
            this.f23554i.setLayoutParams(this.f23552g);
            if (this.f23554i.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.f23554i.getLayoutParams()).getBehavior();
                if (behavior instanceof VideoZoomBehavior) {
                    View view2 = this.f23551f;
                    if (view2 instanceof VideoContainerLayout) {
                        ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) view2).getOriginHeight() - ((VideoContainerLayout) this.f23551f).getMaxHeight());
                    }
                }
            }
            this.f23551f.setLayoutParams(this.f23553h);
            this.n.start();
        }
    }

    public final void p(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            float width = this.f23555j.width() + ((this.k.width() - this.f23555j.width()) * f2);
            float height = this.f23555j.height() + ((this.k.height() - this.f23555j.height()) * f2);
            Rect rect = this.f23555j;
            int i2 = rect.left;
            Rect rect2 = this.k;
            int i3 = rect2.left;
            float f3 = i2 + ((i3 - i2) * f2);
            int i4 = rect.top;
            int i5 = rect2.top;
            float f4 = i4 + ((i5 - i4) * f2);
            int i6 = (int) (f3 - i3);
            int i7 = (int) (f4 - i5);
            View view = this.f23550e;
            if (view != null) {
                view.setAlpha(f2);
            }
            this.f23551f.setTranslationX(i6);
            this.f23551f.setTranslationY(i7);
            ViewGroup.LayoutParams layoutParams = this.f23551f.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = (int) width;
                layoutParams.height = (int) height;
                this.f23551f.setLayoutParams(layoutParams);
            }
        }
    }

    public void q(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, animatorListener) == null) {
            this.o = animatorListener;
        }
    }

    public void r(Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect, rect2) == null) {
            this.f23555j = rect;
            this.k = rect2;
            if (l()) {
                j();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l = false;
            this.q = true;
            for (View view : this.p) {
                view.setVisibility(8);
            }
            this.f23552g = this.f23554i.getLayoutParams();
            this.f23554i.setLayoutParams(new CoordinatorLayout.LayoutParams(n.k(TbadkCoreApplication.getInst()), n.i(TbadkCoreApplication.getInst())));
            this.f23553h = this.f23551f.getLayoutParams();
            View view2 = this.f23551f;
            ViewGroup.LayoutParams layoutParams = this.f23553h;
            view2.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height));
            View view3 = this.f23550e;
            if (view3 != null) {
                view3.setAlpha(0.0f);
            }
            this.m.start();
        }
    }
}
