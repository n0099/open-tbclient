package c.a.r0.k2.o;

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
import c.a.e.e.p.l;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.VideoContainerLayout;
import com.baidu.tieba.pb.videopb.VideoZoomBehavior;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f20767a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f20768b;

    /* renamed from: c  reason: collision with root package name */
    public SwipeBackLayout f20769c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f20770d;

    /* renamed from: e  reason: collision with root package name */
    public View f20771e;

    /* renamed from: f  reason: collision with root package name */
    public View f20772f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup.LayoutParams f20773g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.LayoutParams f20774h;

    /* renamed from: i  reason: collision with root package name */
    public View f20775i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f20776j;
    public Rect k;
    public boolean l;
    public ValueAnimator m;
    public ValueAnimator n;
    public Animator.AnimatorListener o;
    public View[] p;
    public boolean q;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f20777e;

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
            this.f20777e = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f20777e.p(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f20778e;

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
            this.f20778e = eVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f20778e.o();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f20778e.o();
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f20778e.o == null) {
                return;
            }
            this.f20778e.o.onAnimationStart(animator);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f20779e;

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
            this.f20779e = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f20779e.n(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f20780e;

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
            this.f20780e = eVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f20780e.m();
                if (this.f20780e.o != null) {
                    this.f20780e.o.onAnimationCancel(animator);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f20780e.m();
                if (this.f20780e.o != null) {
                    this.f20780e.o.onAnimationEnd(animator);
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
                this.f20780e.f20768b.removeView(this.f20780e.f20771e);
                SkinManager.setBackgroundColor(this.f20780e.f20770d, R.color.CAM_X0201);
                for (View view : this.f20780e.p) {
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
        this.f20767a = fragmentActivity;
        this.f20772f = view;
        ViewGroup viewGroup = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.f20768b = viewGroup;
        this.f20775i = viewGroup.findViewById(R.id.appbar_layout);
        this.f20770d = (ViewGroup) this.f20768b.findViewById(R.id.video_pb_root);
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View[] viewArr = new View[3];
            this.p = viewArr;
            viewArr[0] = this.f20768b.findViewById(R.id.pb_video_view_pager);
            this.p[1] = this.f20768b.findViewById(R.id.pb_video_tab_strip);
            this.p[2] = this.f20768b.findViewById(R.id.video_pb_comment_container);
            this.f20768b.findViewById(16908290).setBackgroundResource(R.color.transparent);
            this.f20768b.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
            this.f20768b.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
            this.f20768b.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
            this.f20768b.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
            this.f20768b.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
            if (this.f20768b.getChildAt(0) instanceof SwipeBackLayout) {
                SwipeBackLayout swipeBackLayout = (SwipeBackLayout) this.f20768b.getChildAt(0);
                this.f20769c = swipeBackLayout;
                swipeBackLayout.setBgTransparent();
            }
            View view = new View(this.f20767a);
            this.f20771e = view;
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
            this.f20768b.addView(this.f20771e, 0, new ViewGroup.LayoutParams(-1, -1));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (!this.l || (rect = this.f20776j) == null || rect.isEmpty() || (rect2 = this.k) == null || rect2.isEmpty()) ? false : true : invokeV.booleanValue;
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
            View view = this.f20771e;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            this.f20772f.setTranslationX(0.0f);
            this.f20772f.setTranslationY(0.0f);
            this.f20775i.setLayoutParams(this.f20773g);
            if (this.f20775i.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.f20775i.getLayoutParams()).getBehavior();
                if (behavior instanceof VideoZoomBehavior) {
                    View view2 = this.f20772f;
                    if (view2 instanceof VideoContainerLayout) {
                        ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) view2).getOriginHeight() - ((VideoContainerLayout) this.f20772f).getMaxHeight());
                    }
                }
            }
            this.f20772f.setLayoutParams(this.f20774h);
            this.n.start();
        }
    }

    public final void p(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            float width = this.f20776j.width() + ((this.k.width() - this.f20776j.width()) * f2);
            float height = this.f20776j.height() + ((this.k.height() - this.f20776j.height()) * f2);
            Rect rect = this.f20776j;
            int i2 = rect.left;
            Rect rect2 = this.k;
            int i3 = rect2.left;
            float f3 = i2 + ((i3 - i2) * f2);
            int i4 = rect.top;
            int i5 = rect2.top;
            float f4 = i4 + ((i5 - i4) * f2);
            int i6 = (int) (f3 - i3);
            int i7 = (int) (f4 - i5);
            View view = this.f20771e;
            if (view != null) {
                view.setAlpha(f2);
            }
            this.f20772f.setTranslationX(i6);
            this.f20772f.setTranslationY(i7);
            ViewGroup.LayoutParams layoutParams = this.f20772f.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = (int) width;
                layoutParams.height = (int) height;
                this.f20772f.setLayoutParams(layoutParams);
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
            this.f20776j = rect;
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
            this.f20773g = this.f20775i.getLayoutParams();
            this.f20775i.setLayoutParams(new CoordinatorLayout.LayoutParams(l.k(TbadkCoreApplication.getInst()), l.i(TbadkCoreApplication.getInst())));
            this.f20774h = this.f20772f.getLayoutParams();
            View view2 = this.f20772f;
            ViewGroup.LayoutParams layoutParams = this.f20774h;
            view2.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height));
            View view3 = this.f20771e;
            if (view3 != null) {
                view3.setAlpha(0.0f);
            }
            this.m.start();
        }
    }
}
