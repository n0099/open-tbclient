package c.a.r0.u2.o.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import c.a.d.f.m.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.q0.r.r.e2;
import c.a.r0.a3.j;
import c.a.r0.a3.s;
import c.a.r0.a3.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.videoView.PbNextVideoLayout;
import com.baidu.tieba.pb.videopb.videoView.PbVideoFullscreenAttentionLayout;
import com.baidu.tieba.pb.videopb.videoView.PbVideoMediaController;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes3.dex */
public class a extends c.a.r0.a3.v.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoFullscreenAttentionLayout N0;
    public PbNextVideoLayout O0;
    public ImageView P0;
    public ImageView Q0;
    public int R0;
    public int S0;
    public boolean T0;
    public ObjectAnimator U0;
    public VideoPbViewModel V0;
    public int W0;
    public String X0;
    public String Y0;
    public BaijiahaoData Z0;
    public AbsVideoPbFragment a1;
    public View b1;
    public View c1;
    public boolean d1;
    public boolean e1;
    public ObjectAnimator f1;
    public ObjectAnimator g1;
    public Runnable h1;
    public Runnable i1;
    public Runnable j1;
    public Runnable k1;

    /* renamed from: c.a.r0.u2.o.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1478a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24066e;

        public RunnableC1478a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24066e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24066e.N.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24067e;

        /* renamed from: c.a.r0.u2.o.l.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1479a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f24068e;

            public C1479a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24068e = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f24068e.f24067e.O0();
                    e.a().postDelayed(this.f24068e.f24067e.j1, 5000L);
                }
            }
        }

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24067e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24067e.N0.hasConcerned()) {
                return;
            }
            Context context = this.f24067e.R;
            int i2 = this.f24067e.W ? R.dimen.tbds210 : R.dimen.tbds244;
            this.f24067e.T0 = true;
            this.f24067e.U0.setFloatValues(-n.f(context, i2));
            this.f24067e.U0.removeAllListeners();
            this.f24067e.U0.addListener(new C1479a(this));
            this.f24067e.U0.start();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24069e;

        /* renamed from: c.a.r0.u2.o.l.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1480a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f24070e;

            public C1480a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24070e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f24070e.f24069e.N0.setVisibility(8);
                }
            }
        }

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24069e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24069e.U0.setFloatValues(n.f(this.f24069e.R, this.f24069e.W ? R.dimen.tbds210 : R.dimen.tbds244));
                this.f24069e.U0.removeAllListeners();
                this.f24069e.U0.addListener(new C1480a(this));
                this.f24069e.U0.start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24071e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24071e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f24071e.e1 && (this.f24071e.R instanceof Activity)) {
                this.f24071e.J0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, View view) {
        super(context, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.R0 = -1;
        this.W0 = 0;
        this.h1 = new RunnableC1478a(this);
        this.i1 = new b(this);
        this.j1 = new c(this);
        this.k1 = new d(this);
        M();
        if (context instanceof AbsPbActivity) {
            this.V0 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            this.d1 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        }
        U(true);
        V(true);
        this.f0 = false;
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.T0 || this.N0.hasConcerned()) {
            return;
        }
        this.N0.setTranslationX(0.0f);
        this.N0.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.N0.getLayoutParams()).bottomMargin = n.f(this.R, this.W ? R.dimen.tbds248 : R.dimen.tbds428);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N0, AnimationProperty.TRANSLATE_X, 0.0f);
        this.U0 = ofFloat;
        ofFloat.setDuration(500);
        O0();
        e.a().postDelayed(this.i1, 5000L);
    }

    public final StatisticItem I0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", this.Y).param("fid", this.Z).param("uid", TbadkCoreApplication.getCurrentAccount());
            BaijiahaoData baijiahaoData = this.Z0;
            if (baijiahaoData != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                param.param(TiebaStatic.Params.OBJ_PARAM6, this.Z0.oriUgcVid);
                int i2 = this.Z0.oriUgcType;
                if (i2 == 4) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (i2 == 2) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                }
            } else {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
            }
            Context context = this.R;
            if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).getPbModel() != null) {
                param.param("ab_tag", ((AbsPbActivity) this.R).getPbModel().W0()).param("obj_id", ((AbsPbActivity) this.R).getPbModel().X0()).param("obj_source", ((AbsPbActivity) this.R).getPbModel().Y0());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            W0();
            UtilHelper.hideStatusBar((Activity) this.R, this.b1);
            this.e1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.a1;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.setIsStatusBarShowing(false);
            }
        }
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e1 : invokeV.booleanValue;
    }

    @Override // c.a.r0.a3.v.d
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.L();
            if (this.b0) {
                H0();
            }
        }
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.W : invokeV.booleanValue;
    }

    @Override // c.a.r0.a3.v.d
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = this.f14961f & (-33);
            this.f14961f = i2;
            int i3 = this.f14963h & (-33);
            this.f14963h = i3;
            int i4 = this.f14964i & (-33);
            this.f14964i = i4;
            int i5 = this.r & (-33);
            this.r = i5;
            int i6 = this.f14965j & (-33);
            this.f14965j = i6;
            int i7 = this.k & (-33);
            this.k = i7;
            int i8 = this.l & (-33);
            this.l = i8;
            int i9 = this.m & (-33);
            this.m = i9;
            int i10 = this.n & (-33);
            this.n = i10;
            int i11 = this.o & (-33);
            this.o = i11;
            this.f14961f = i2 | 1024;
            int i12 = i3 | 1024;
            this.f14963h = i12;
            this.f14964i = i4 & (-1025);
            this.r = i5 & (-1025);
            this.f14965j = i6 | 1024;
            this.k = i7 | 1024;
            int i13 = i8 | 1024;
            this.l = i13;
            int i14 = i9 | 1024;
            this.m = i14;
            this.n = i10 | 1024;
            this.o = i11 & (-1025);
            this.f14963h = i12 | 16384;
            this.l = i13 | 16384;
            this.m = i14 & (-2);
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            O0();
            U(false);
            V(false);
        }
    }

    @Override // c.a.r0.a3.v.d
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.J.changeViewLayout(this.W, this.b0);
            this.K.changeViewLayout(this.W, this.b0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.I;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                ((PbVideoMediaController) operableVideoMediaControllerView).changeViewLayout(this.W, this.b0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
            int i2 = 0;
            int f2 = (this.b0 && this.W) ? n.f(this.R, R.dimen.tbds42) : 0;
            if (this.b0 && !this.W) {
                i2 = n.f(this.R, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = f2;
            layoutParams.rightMargin = i2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Q0.getLayoutParams();
            int f3 = n.f(this.R, (!this.b0 || this.W) ? R.dimen.tbds104 : R.dimen.tbds208);
            layoutParams3.leftMargin = f3;
            layoutParams2.rightMargin = f3;
            this.O0.changeViewLayout(this.W, this.b0);
        }
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.s == this.o) {
                return false;
            }
            this.N.setVisibility(0);
            this.N.changeVolume(this.R, false, 10);
            e.a().removeCallbacks(this.h1);
            e.a().postDelayed(this.h1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            e.a().removeCallbacks(this.i1);
            e.a().removeCallbacks(this.j1);
        }
    }

    public void P0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.O0.setIsCountDownValid(z);
        }
    }

    public void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.e1 = z;
        }
    }

    public void R0(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, e2Var) == null) {
            if (e2Var != null && e2Var.u1() != null && !m.isEmpty(e2Var.u1().video_url)) {
                int i2 = this.s;
                if (i2 == this.f14965j || i2 == this.k) {
                    int i3 = this.s | 32768;
                    this.s = i3;
                    l0(i3);
                }
                int i4 = this.s;
                if (i4 == this.m) {
                    int i5 = i4 | 131072;
                    this.s = i5;
                    l0(i5);
                }
                this.f14965j |= 32768;
                this.k |= 32768;
                this.m |= 131072;
                this.O0.setDate(e2Var);
                return;
            }
            int i6 = this.s;
            if (i6 == this.f14965j || i6 == this.k || i6 == this.m) {
                int i7 = this.s & (-32769);
                this.s = i7;
                int i8 = i7 & (-131073);
                this.s = i8;
                l0(i8);
            }
            this.f14965j &= -32769;
            this.k &= -32769;
            this.m &= -131073;
        }
    }

    @Override // c.a.r0.a3.v.d
    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            Context context = this.R;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.b0);
            }
            super.S(z);
            O0();
            if (this.b0) {
                H0();
            } else {
                this.N0.setVisibility(8);
            }
        }
    }

    public void S0(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, e2Var) == null) {
            if (e2Var != null && e2Var.u1() != null && !m.isEmpty(e2Var.u1().video_url)) {
                int i2 = this.s;
                if (i2 == this.f14965j || i2 == this.k) {
                    int i3 = this.s | 65536;
                    this.s = i3;
                    l0(i3);
                }
                this.f14965j |= 65536;
                this.k |= 65536;
                return;
            }
            int i4 = this.s;
            if (i4 == this.f14965j || i4 == this.k) {
                int i5 = this.s & (-65537);
                this.s = i5;
                l0(i5);
            }
            this.f14965j &= -65537;
            this.k &= -65537;
        }
    }

    public void T0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            this.b1 = view;
        }
    }

    public void U0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
            this.c1 = view;
        }
    }

    public void V0(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, absVideoPbFragment) == null) {
            this.a1 = absVideoPbFragment;
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.g1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c1, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.g1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.g1.start();
        }
    }

    @Override // c.a.r0.a3.v.d
    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? R.layout.pb_operable_video_container : invokeV.intValue;
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c1, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.f1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.f1.start();
        }
    }

    @Override // c.a.r0.a3.v.d
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.a0();
            this.N0 = (PbVideoFullscreenAttentionLayout) this.T.findViewById(R.id.video_fullscreen_attention);
            this.O0 = (PbNextVideoLayout) this.T.findViewById(R.id.video_next_layout);
            this.P0 = (ImageView) this.T.findViewById(R.id.video_pre);
            this.Q0 = (ImageView) this.T.findViewById(R.id.video_next);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P0, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.Q0, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, null);
            this.x.clearCornerFlag();
            this.x.setDrawCorner(false);
            this.N0.setOnClickEvent(this);
            this.P0.setOnClickListener(this);
            this.Q0.setOnClickListener(this);
            this.O0.setOnClickListener(this);
            this.S0 = n.k(this.R) / 10;
            this.K.setShareFrom(18);
        }
    }

    @Override // c.a.r0.a3.v.d
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.w.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.r0.a3.v.d
    public boolean c0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) ? this.b0 || motionEvent.getX() > ((float) this.S0) : invokeL.booleanValue;
    }

    @Override // c.a.r0.a3.v.d
    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a3.v.d
    public void l0(int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (i2 != this.k && i2 != this.l && i2 != this.f14965j && i2 != this.f14963h) {
                O0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.N0;
                if (pbVideoFullscreenAttentionLayout != null) {
                    pbVideoFullscreenAttentionLayout.setVisibility(8);
                }
            }
            int i3 = this.s;
            int i4 = this.o;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.h1);
                int i5 = this.s;
                if ((i5 & 16384) > 0) {
                    i2 = (i2 | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i2 = (i2 & (-16385)) | 128 | 64;
                }
                this.o = i2;
            }
            super.l0(i2);
            if (!this.b0) {
                this.L.setVisibility(8);
                this.M.setVisibility(8);
                VideoPbViewModel videoPbViewModel = this.V0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.setIsShowNavigationBar((i2 & 1024) > 0);
                }
            }
            VideoPbViewModel videoPbViewModel2 = this.V0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.setIsShowNavigationBar((i2 & 128) > 0);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.I;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                int i6 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i6 > 0 || (i2 & 128) > 0) ? 0 : 8);
                ((PbVideoMediaController) this.I).setBottomBarShow(i6 > 0);
            }
            ImageView imageView = this.P0;
            if (imageView != null) {
                imageView.setVisibility((65536 & i2) > 0 ? 0 : 8);
            }
            ImageView imageView2 = this.Q0;
            if (imageView2 != null) {
                imageView2.setVisibility((32768 & i2) > 0 ? 0 : 8);
            }
            if (this.O0 != null) {
                boolean z = (131072 & i2) > 0;
                this.O0.setVisibility(z ? 0 : 8);
                if (z) {
                    TiebaStatic.log(I0("c13600"));
                }
            }
            if (this.b0 || this.d1 || !(this.R instanceof Activity)) {
                return;
            }
            if ((i2 & 128) > 0) {
                if (this.e1) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment2 = this.a1;
                if (absVideoPbFragment2 == null || !absVideoPbFragment2.isStatusBarShowing()) {
                    X0();
                    UtilHelper.showStatusBar((Activity) this.R, this.b1);
                }
                this.e1 = true;
                e.a().removeCallbacks(this.k1);
                e.a().postDelayed(this.k1, 3000L);
            } else if (this.e1 || ((absVideoPbFragment = this.a1) != null && absVideoPbFragment.isStatusBarShowing())) {
                J0();
            }
        }
    }

    @Override // c.a.r0.a3.v.d, c.a.r0.a3.v.a
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            O0();
            this.N0.setVisibility(8);
            if (!this.d1) {
                J0();
            }
            if (z) {
                int i2 = this.s;
                this.R0 = i2;
                if (i2 == this.k || ((i2 == this.l && !this.w.getControl().isPlaying()) || this.s == this.m)) {
                    this.R0 |= 1;
                }
                stopPlay();
            } else {
                int i3 = this.R0;
                if (i3 == -1) {
                    startPlay();
                } else if (i3 != this.f14963h && i3 != this.f14965j && i3 != this.f14964i && i3 != this.r) {
                    this.I.setCurrentDuration(s.d().c(this.X), false);
                    l0(this.R0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // c.a.r0.a3.v.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.play) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view);
        if (id == R.id.concern_video_info_item) {
            O0();
            e.a().post(this.j1);
        } else if (id == R.id.video_next || id == R.id.video_next_layout) {
            VideoPbViewModel videoPbViewModel = this.V0;
            if (videoPbViewModel != null) {
                videoPbViewModel.loadNextVideo(id == R.id.video_next_layout);
            }
            if (id == R.id.video_next) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        } else if (id == R.id.video_pre) {
            VideoPbViewModel videoPbViewModel2 = this.V0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.loadPreVideo();
            }
            TiebaStatic.log(new StatisticItem("c13594"));
        } else if (id == R.id.pb_next_video_close) {
            this.m &= -131073;
            this.s &= -131073;
            this.O0.setVisibility(8);
        }
    }

    @Override // c.a.r0.a3.v.d, c.a.r0.a3.v.a
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.s == this.o) {
                return false;
            }
            this.N.setVisibility(0);
            this.N.changeVolume(this.R, true, 10);
            e.a().removeCallbacks(this.h1);
            e.a().postDelayed(this.h1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a3.v.d
    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (i2 == R.id.video_full_screen) {
                if (!isFullScreen()) {
                    TiebaStatic.log(new StatisticItem("c13598"));
                } else {
                    TiebaStatic.log(new StatisticItem("c13599"));
                }
            } else if (i2 == R.id.video_replay) {
                TiebaStatic.log(I0("c13602"));
            } else if (i2 == R.id.video_play) {
                TiebaStatic.log(new StatisticItem("c13597"));
            } else if (i2 == R.id.video_pause) {
                TiebaStatic.log(new StatisticItem("c13596"));
            } else if (i2 == R.id.video_next_layout) {
                TiebaStatic.log(I0("c13601").param("obj_type", this.O0.isManualFinish ? 1 : 2));
            }
        }
    }

    @Override // c.a.r0.a3.v.d
    public void s0() {
        t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (tVar = this.c0) == null) {
            return;
        }
        t b2 = tVar.b();
        b2.a = "pb";
        j.e(b2.m, "", "2", b2, this.w.getControl().getPcdnState());
    }

    @Override // c.a.r0.a3.v.d, c.a.r0.a3.v.a
    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, e2Var) == null) || e2Var == null) {
            return;
        }
        this.Z0 = e2Var.L();
        t tVar = new t();
        tVar.a = "6";
        tVar.f14940c = e2Var.w1();
        tVar.f14941d = Long.toString(e2Var.U());
        tVar.f14942e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.R;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (e2Var.U1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.W0 = intExtra;
                if (intExtra == 0) {
                    this.W0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.X0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    tVar.k = this.X0;
                }
                tVar.f14946i = Integer.toString(this.W0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Y0 = stringExtra2;
                tVar.f14946i = stringExtra2;
            }
        }
        if (e2Var.u1() != null) {
            tVar.m = e2Var.u1().video_md5;
            tVar.p = String.valueOf(e2Var.u1().is_vertical);
        }
        setStatistic(tVar);
        this.T0 = false;
        if (this.V0.getData().s0()) {
            this.O0.setIsCountDownValid(true);
        } else {
            this.O0.setIsCountDownValid(false);
        }
        if (this.b0 && e2Var.u1() != null) {
            if (this.W != (e2Var.u1().is_vertical.intValue() == 1)) {
                R();
            }
        }
        super.setData(e2Var);
        U(!this.W);
        if (e2Var.J() != null) {
            e2Var.J().setIsLike(e2Var.J().hadConcerned());
        }
        this.N0.setData(e2Var);
    }

    @Override // c.a.r0.a3.v.d, c.a.r0.a3.v.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.N0.setUniqueId(bdUniqueId);
        }
    }
}
