package c.a.s0.s.j0;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f extends c.a.d.n.e.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public final Animator.AnimatorListener D;
    public View k;
    public LinearLayout l;
    public ImageView m;
    public g n;
    public InterfaceC0869f o;
    public h p;
    public e q;
    public AnimationDrawable r;
    public ContinuousAnimationView s;
    public int t;
    public boolean u;
    public SmartBubbleAnimatedView v;
    public j w;
    public i x;
    public boolean y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f13094e;

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
            this.f13094e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13094e.B == null) {
                return;
            }
            this.f13094e.B.onClick(view);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f13095e;

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
            this.f13095e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimationDrawable animationDrawable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (animationDrawable = this.f13095e.r) == null) {
                return;
            }
            animationDrawable.start();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f13096e;

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
            this.f13096e = fVar;
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
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.f13096e.A) {
                return;
            }
            this.f13096e.A = true;
            this.f13096e.s.setSpeed(1.0f);
            this.f13096e.s.setMinAndMaxFrame(45, 105);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements SmartBubbleAnimatedView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

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
            this.a = fVar;
        }

        @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.w == null) {
                return;
            }
            this.a.w.onAnimationEnd();
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a();
    }

    /* renamed from: c.a.s0.s.j0.f$f  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0869f {
        void a(View view, boolean z);
    }

    /* loaded from: classes6.dex */
    public interface g {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f13097b;

        public i(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f13097b = i2;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13097b : invokeV.intValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface j {
        void a(int i2);

        void onAnimationEnd();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.t = Integer.MIN_VALUE;
        this.u = false;
        this.y = true;
        this.z = true;
        this.A = false;
        this.B = null;
        this.C = new a(this);
        this.D = new c(this);
    }

    public void C(int i2) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (H() && this.t != i2 && (continuousAnimationView = this.s) != null && !continuousAnimationView.isAnimating()) {
                this.t = i2;
                SkinManager.setLottieAnimation(this.s, R.raw.lottie_common_pull_refresh);
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.v;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.onChangeSkinType(i2);
            }
        }
    }

    public void D() {
        SmartBubbleAnimatedView smartBubbleAnimatedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.l == null || (smartBubbleAnimatedView = this.v) == null || smartBubbleAnimatedView.getParent() == null) {
            return;
        }
        this.l.removeView(this.v);
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.k == null) {
                this.k = i();
            }
            return this.k;
        }
        return (View) invokeV.objValue;
    }

    public g F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (g) invokeV.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.v;
            if (smartBubbleAnimatedView != null && smartBubbleAnimatedView.getParent() != null) {
                this.l.removeView(this.v);
            }
            if (H()) {
                ImageView imageView = this.m;
                if (imageView == null || this.s == null) {
                    return;
                }
                if (imageView.getVisibility() != 8) {
                    this.m.setVisibility(8);
                }
                if (this.s.getVisibility() != 0) {
                    this.s.setVisibility(0);
                }
                if (this.s.isAnimating()) {
                    this.s.cancelAnimation();
                }
                this.s.setMinAndMaxProgress(0.0f, 1.0f);
                this.s.setFrame(0);
                this.s.setSpeed(1.3f);
                return;
            }
            ImageView imageView2 = this.m;
            if (imageView2 == null || this.s == null) {
                return;
            }
            if (imageView2.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
            if (this.s.getVisibility() != 8) {
                this.s.setVisibility(8);
            }
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? PullViewHelper.getInstance().isShouldShowLoadingView() : invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public final void J() {
        AnimationDrawable animationDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && H() && (animationDrawable = this.r) != null) {
            animationDrawable.stop();
            this.r = null;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.y = z;
        }
    }

    public void L(int i2) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (continuousAnimationView = this.s) == null) {
            return;
        }
        SkinManager.setLottieAnimation(continuousAnimationView, i2);
    }

    public void M(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
            this.x = iVar;
        }
    }

    public void N(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public void O(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jVar) == null) {
            this.w = jVar;
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (I() && this.y && this.x != null && this.l != null) {
                this.m.setVisibility(8);
                this.s.setVisibility(8);
                if (this.v == null) {
                    SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(getContext());
                    this.v = smartBubbleAnimatedView;
                    smartBubbleAnimatedView.setExtrusionRemind(true);
                }
                this.v.tipText = this.x.b();
                this.v.delayDuring = this.x.a();
                if (this.v.getParent() != null) {
                    this.l.removeView(this.v);
                }
                this.l.addView(this.v);
                this.v.setOnBubbleAnimateListener(new d(this));
                j jVar = this.w;
                if (jVar != null) {
                    jVar.a(this.v.getTipViewHeight());
                }
                this.v.playExpansionAnimation();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Q() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && H() && (continuousAnimationView = this.s) != null) {
            continuousAnimationView.loop(false);
        }
    }

    public final void R() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (continuousAnimationView = this.s) == null) {
            return;
        }
        if (continuousAnimationView.isAnimating()) {
            this.s.cancelAnimation();
        }
        this.A = false;
        this.s.loop(true);
        this.s.setMinFrame(27);
        this.s.setRepeatMode(1);
        this.s.removeAllAnimatorListeners();
        this.s.addAnimatorListener(this.D);
        this.s.playAnimation();
    }

    public void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.n = gVar;
        }
    }

    public void b(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hVar) == null) {
            this.p = hVar;
        }
    }

    public void f(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.q = eVar;
        }
    }

    @Override // c.a.d.n.e.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public long getCompleteAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 600L;
        }
        return invokeV.longValue;
    }

    public void h(InterfaceC0869f interfaceC0869f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, interfaceC0869f) == null) {
            this.o = interfaceC0869f;
        }
    }

    @Override // c.a.d.n.e.c
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
            this.k = inflate;
            this.l = (LinearLayout) inflate.findViewById(R.id.pull_root);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.k.findViewById(R.id.continuous_loading_view);
            this.s = continuousAnimationView;
            SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_common_pull_refresh);
            this.s.setOnClickListener(this.C);
            ImageView imageView = (ImageView) this.k.findViewById(R.id.pull_image);
            this.m = imageView;
            imageView.setOnClickListener(this.C);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i2 = this.t;
            if (i2 != Integer.MIN_VALUE) {
                skinType = i2;
            }
            if (!H()) {
                this.r = PullViewHelper.getInstance().getDefaultAnimationDrawable(skinType);
            }
            this.m.setBackgroundDrawable(this.r);
            G();
            return this.k;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.n.e.c
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.z = true;
            if (H() && this.s.isAnimating()) {
                this.s.cancelAnimation();
            } else {
                AnimationDrawable animationDrawable = this.r;
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
            }
            J();
            InterfaceC0869f interfaceC0869f = this.o;
            if (interfaceC0869f != null) {
                interfaceC0869f.a(this.k, z);
            }
        }
    }

    @Override // c.a.d.n.e.c
    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || m()) {
            return;
        }
        e eVar = this.q;
        if (eVar != null) {
            eVar.a();
        }
        if (!P()) {
            Q();
            return;
        }
        ContinuousAnimationView continuousAnimationView = this.s;
        if (continuousAnimationView == null || !continuousAnimationView.isAnimating()) {
            return;
        }
        this.s.cancelAnimation();
    }

    @Override // c.a.d.n.e.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onPullPercentChange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.onPullPercentChange(f2, f3);
            if (H()) {
                this.s.setAlpha(f2);
                this.s.setFrame((int) Math.min(27.0f, ((f2 * 27.0f) * 5.0f) / 3.0f));
            }
        }
    }

    @Override // c.a.d.n.e.c
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || m()) {
            return;
        }
        g gVar = this.n;
        if (gVar != null && this.z) {
            gVar.onListPullRefresh(z);
        }
        this.z = true;
    }

    @Override // c.a.d.n.e.c
    public void r(boolean z) {
        AnimationDrawable animationDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            h hVar = this.p;
            if (hVar != null) {
                hVar.a(z);
            }
            G();
            if (H() || (animationDrawable = this.r) == null || this.m == null) {
                return;
            }
            animationDrawable.stop();
            this.m.setBackgroundDrawable(this.r.getFrame(0));
        }
    }

    @Override // c.a.d.n.e.c
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            G();
            if (H()) {
                if (m()) {
                    return;
                }
                R();
                return;
            }
            AnimationDrawable animationDrawable = this.r;
            if (animationDrawable == null || this.m == null) {
                return;
            }
            animationDrawable.stop();
            this.m.setBackgroundDrawable(this.r);
            this.m.post(new b(this));
        }
    }

    @Override // c.a.d.n.e.c
    public void t() {
        AnimationDrawable animationDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || H() || (animationDrawable = this.r) == null || this.m == null) {
            return;
        }
        animationDrawable.stop();
        this.m.setBackgroundDrawable(this.r.getFrame(0));
    }
}
