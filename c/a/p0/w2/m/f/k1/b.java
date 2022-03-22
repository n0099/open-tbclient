package c.a.p0.w2.m.f.k1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;

    /* renamed from: b  reason: collision with root package name */
    public Animator f20184b;

    /* renamed from: c  reason: collision with root package name */
    public Animator f20185c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f20186d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f20187e;

    /* renamed from: f  reason: collision with root package name */
    public AnimatorSet f20188f;

    /* renamed from: g  reason: collision with root package name */
    public AnimatorSet f20189g;

    /* renamed from: h  reason: collision with root package name */
    public View f20190h;
    public View i;
    public View j;
    public View k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public final Handler.Callback v;
    public final Handler w;

    /* loaded from: classes3.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if ((i == 1 || i == 2) && this.a.o()) {
                    this.a.w.sendEmptyMessageDelayed(message.what, 100L);
                    return true;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    this.a.D();
                    return true;
                } else if (i2 == 2) {
                    this.a.C();
                    return true;
                } else if (i2 != 3) {
                    return false;
                } else {
                    this.a.B();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: c.a.p0.w2.m.f.k1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1511b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1511b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.a.f20190h == null) {
                return;
            }
            this.a.f20190h.clearAnimation();
            if (this.a.s) {
                this.a.v(false);
            } else {
                this.a.v(true);
            }
            if (this.a.a != null) {
                this.a.a.a(false);
            }
            this.a.j.clearAnimation();
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
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.a.l;
                    this.a.k.setLayoutParams(layoutParams);
                }
                this.a.k.setVisibility(0);
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
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    this.a.k.setLayoutParams(layoutParams);
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = num.intValue();
                    this.a.k.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.a.f20190h == null) {
                return;
            }
            this.a.f20190h.clearAnimation();
            this.a.f20190h.setVisibility(0);
            this.a.v(false);
            if (this.a.a != null) {
                this.a.a.a(true);
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
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.k.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    this.a.k.setLayoutParams(layoutParams);
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.k.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.a.l;
                    this.a.k.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = num.intValue();
                    this.a.k.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(boolean z);
    }

    public b(Context context, View view, View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, view2, view3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = UtilHelper.getLightStatusBarHeight();
        this.m = false;
        this.o = false;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = true;
        this.v = new a(this);
        this.w = new Handler(this.v);
        this.f20190h = view;
        this.i = view2;
        this.j = view3;
        this.k = view3.findViewById(R.id.obfuscated_res_0x7f091db2);
        this.n = UtilHelper.canUseStyleImmersiveSticky();
        j();
        v(false);
    }

    public void A(boolean z, boolean z2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (view = this.f20190h) == null || view.getY() != 0.0f || o()) {
            return;
        }
        if (z2) {
            this.f20190h.setVisibility(8);
            if (this.s) {
                v(false);
                return;
            } else {
                v(true);
                return;
            }
        }
        this.f20190h.setVisibility(0);
        if (this.f20189g == null) {
            m();
        }
        AnimatorSet animatorSet = this.f20189g;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f20189g.setDuration(300L).start();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            A(false, true);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            A(false, false);
        }
    }

    public void D() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (view = this.f20190h) == null || view.getY() >= 0.0f || o()) {
            return;
        }
        this.f20190h.setVisibility(0);
        if (this.f20188f == null) {
            n();
        }
        AnimatorSet animatorSet = this.f20188f;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f20188f.setDuration(300L).start();
        }
    }

    public boolean i(AbsListView absListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, absListView)) == null) {
            if (absListView != null) {
                return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (view = this.i) == null) {
            return;
        }
        if (this.n && view.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.i.setLayoutParams(layoutParams);
            v(true);
            return;
        }
        v(false);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.w.removeCallbacksAndMessages(null);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.u) {
            if (this.o) {
                v(true);
            } else if (this.f20190h == null || this.q || this.r || !p()) {
            } else {
                Log.i("PbView", "hideFloatingView: startDragDown");
                y();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view = this.f20190h;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, (-view.getMeasuredHeight()) + this.j.getMeasuredHeight());
            this.f20184b = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.f20184b.addListener(new C1511b(this));
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.l);
            this.f20187e = ofInt;
            ofInt.setInterpolator(new LinearInterpolator());
            this.f20187e.addListener(new c(this));
            this.f20187e.addUpdateListener(new d(this));
            AnimatorSet animatorSet = new AnimatorSet();
            this.f20189g = animatorSet;
            animatorSet.play(this.f20184b).with(this.f20187e);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f20190h, AnimationProperty.TRANSLATE_Y, 0.0f);
            this.f20185c = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.f20185c.addListener(new e(this));
            ValueAnimator ofInt = ValueAnimator.ofInt(this.l, 0);
            this.f20186d = ofInt;
            ofInt.setInterpolator(new LinearInterpolator());
            this.f20186d.addListener(new f(this));
            this.f20186d.addUpdateListener(new g(this));
            AnimatorSet animatorSet = new AnimatorSet();
            this.f20188f = animatorSet;
            animatorSet.play(this.f20185c).with(this.f20186d);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        AnimatorSet animatorSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AnimatorSet animatorSet2 = this.f20188f;
            return (animatorSet2 != null && animatorSet2.isRunning()) || ((animatorSet = this.f20189g) != null && animatorSet.isRunning());
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f20190h.getVisibility() == 0 && this.f20190h.getY() >= 0.0f : invokeV.booleanValue;
    }

    public void q(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048588, this, absListView, i, i2, i3) == null) || !this.u || this.f20190h == null || this.q || this.r || !this.m) {
            return;
        }
        if (i > this.p && p()) {
            Log.i("PbView", "onScroll hideFloatingView");
            l();
        } else if (i < this.p && !p()) {
            Log.i("PbView", "onScroll showFloatingView");
            x();
        }
        this.p = i;
    }

    public void r(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, absListView, i) == null) {
            if (i == 1) {
                this.m = true;
            } else if (i == 0) {
                this.m = false;
            }
            if (!this.u || this.q || this.r) {
                return;
            }
            if (this.o) {
                v(true);
            } else if (absListView == null || i != 0) {
            } else {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                int i2 = this.p;
                if (firstVisiblePosition > i2) {
                    y();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < i2) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    z();
                } else if (firstVisiblePosition == i2) {
                    if (firstVisiblePosition != 0 && this.t && !i(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragDown:");
                        y();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                    z();
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.r = z;
        }
    }

    public void t(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hVar) == null) {
            this.a = hVar;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.t = z;
        }
    }

    public final void v(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (view = this.i) == null) {
            return;
        }
        if (this.n && z && view.getVisibility() != 0) {
            this.i.setVisibility(0);
        } else if (z || this.i.getVisibility() == 8) {
        } else {
            this.i.setVisibility(8);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.q = z;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.u) {
            if (this.o) {
                v(true);
            } else if (this.f20190h == null || p()) {
            } else {
                Log.i("PbView", "showFloatingView: startDragUp");
                z();
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.w.removeMessages(1);
            if (this.w.hasMessages(2)) {
                return;
            }
            this.w.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.w.removeMessages(2);
            if (this.w.hasMessages(1)) {
                return;
            }
            this.w.sendEmptyMessageDelayed(1, 60L);
        }
    }
}
