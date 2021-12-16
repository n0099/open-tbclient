package c.a.s0.s2.y;

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
import c.a.d.f.p.m;
import c.a.s0.s2.f;
import c.a.s0.s2.i;
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
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f23420b;

    /* renamed from: c  reason: collision with root package name */
    public SwipeBackLayout f23421c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f23422d;

    /* renamed from: e  reason: collision with root package name */
    public View f23423e;

    /* renamed from: f  reason: collision with root package name */
    public View f23424f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup.LayoutParams f23425g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.LayoutParams f23426h;

    /* renamed from: i  reason: collision with root package name */
    public View f23427i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f23428j;

    /* renamed from: k  reason: collision with root package name */
    public Rect f23429k;
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
        public final /* synthetic */ e f23430e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23430e = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f23430e.p(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23431e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23431e = eVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f23431e.o();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f23431e.o();
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f23431e.o == null) {
                return;
            }
            this.f23431e.o.onAnimationStart(animator);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23432e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23432e = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f23432e.n(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23433e;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23433e = eVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f23433e.m();
                if (this.f23433e.o != null) {
                    this.f23433e.o.onAnimationCancel(animator);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f23433e.m();
                if (this.f23433e.o != null) {
                    this.f23433e.o.onAnimationEnd(animator);
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
                this.f23433e.f23420b.removeView(this.f23433e.f23423e);
                SkinManager.setBackgroundColor(this.f23433e.f23422d, f.CAM_X0201);
                for (View view : this.f23433e.p) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }
        }
    }

    public e(FragmentActivity fragmentActivity, View view) {
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
        this.f23424f = view;
        ViewGroup viewGroup = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.f23420b = viewGroup;
        this.f23427i = viewGroup.findViewById(i.appbar_layout);
        this.f23422d = (ViewGroup) this.f23420b.findViewById(i.video_pb_root);
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View[] viewArr = new View[3];
            this.p = viewArr;
            viewArr[0] = this.f23420b.findViewById(i.pb_video_view_pager);
            this.p[1] = this.f23420b.findViewById(i.pb_video_tab_strip);
            this.p[2] = this.f23420b.findViewById(i.video_pb_comment_container);
            this.f23420b.findViewById(16908290).setBackgroundResource(f.transparent);
            this.f23420b.findViewById(i.container).setBackgroundResource(f.transparent);
            this.f23420b.findViewById(i.video_pb_root).setBackgroundResource(f.transparent);
            this.f23420b.findViewById(i.pb_video_nested_scroll_layout).setBackgroundResource(f.transparent);
            this.f23420b.findViewById(i.appbar_layout).setBackgroundResource(f.transparent);
            this.f23420b.findViewById(i.scroll_container).setBackgroundResource(f.transparent);
            if (this.f23420b.getChildAt(0) instanceof SwipeBackLayout) {
                SwipeBackLayout swipeBackLayout = (SwipeBackLayout) this.f23420b.getChildAt(0);
                this.f23421c = swipeBackLayout;
                swipeBackLayout.setBgTransparent();
            }
            View view = new View(this.a);
            this.f23423e = view;
            SkinManager.setBackgroundColor(view, f.CAM_X0201);
            this.f23420b.addView(this.f23423e, 0, new ViewGroup.LayoutParams(-1, -1));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (!this.l || (rect = this.f23428j) == null || rect.isEmpty() || (rect2 = this.f23429k) == null || rect2.isEmpty()) ? false : true : invokeV.booleanValue;
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
            View view = this.f23423e;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            this.f23424f.setTranslationX(0.0f);
            this.f23424f.setTranslationY(0.0f);
            this.f23427i.setLayoutParams(this.f23425g);
            if (this.f23427i.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.f23427i.getLayoutParams()).getBehavior();
                if (behavior instanceof VideoZoomBehavior) {
                    View view2 = this.f23424f;
                    if (view2 instanceof VideoContainerLayout) {
                        ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) view2).getOriginHeight() - ((VideoContainerLayout) this.f23424f).getMaxHeight());
                    }
                }
            }
            this.f23424f.setLayoutParams(this.f23426h);
            this.n.start();
        }
    }

    public final void p(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            float width = this.f23428j.width() + ((this.f23429k.width() - this.f23428j.width()) * f2);
            float height = this.f23428j.height() + ((this.f23429k.height() - this.f23428j.height()) * f2);
            Rect rect = this.f23428j;
            int i2 = rect.left;
            Rect rect2 = this.f23429k;
            int i3 = rect2.left;
            float f3 = i2 + ((i3 - i2) * f2);
            int i4 = rect.top;
            int i5 = rect2.top;
            float f4 = i4 + ((i5 - i4) * f2);
            int i6 = (int) (f3 - i3);
            int i7 = (int) (f4 - i5);
            View view = this.f23423e;
            if (view != null) {
                view.setAlpha(f2);
            }
            this.f23424f.setTranslationX(i6);
            this.f23424f.setTranslationY(i7);
            ViewGroup.LayoutParams layoutParams = this.f23424f.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = (int) width;
                layoutParams.height = (int) height;
                this.f23424f.setLayoutParams(layoutParams);
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
            this.f23428j = rect;
            this.f23429k = rect2;
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
            this.f23425g = this.f23427i.getLayoutParams();
            this.f23427i.setLayoutParams(new CoordinatorLayout.LayoutParams(m.k(TbadkCoreApplication.getInst()), m.i(TbadkCoreApplication.getInst())));
            this.f23426h = this.f23424f.getLayoutParams();
            View view2 = this.f23424f;
            ViewGroup.LayoutParams layoutParams = this.f23426h;
            view2.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height));
            View view3 = this.f23423e;
            if (view3 != null) {
                view3.setAlpha(0.0f);
            }
            this.m.start();
        }
    }
}
