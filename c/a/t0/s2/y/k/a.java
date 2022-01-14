package c.a.t0.s2.y.k;

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
import c.a.s0.s.q.e2;
import c.a.t0.s2.f;
import c.a.t0.s2.g;
import c.a.t0.s2.h;
import c.a.t0.s2.i;
import c.a.t0.s2.j;
import c.a.t0.z2.s;
import c.a.t0.z2.t;
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
/* loaded from: classes8.dex */
public class a extends c.a.t0.z2.v.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoFullscreenAttentionLayout M0;
    public PbNextVideoLayout N0;
    public ImageView O0;
    public ImageView P0;
    public int Q0;
    public int R0;
    public boolean S0;
    public ObjectAnimator T0;
    public VideoPbViewModel U0;
    public int V0;
    public String W0;
    public String X0;
    public BaijiahaoData Y0;
    public AbsVideoPbFragment Z0;
    public View a1;
    public View b1;
    public boolean c1;
    public boolean d1;
    public ObjectAnimator e1;
    public ObjectAnimator f1;
    public Runnable g1;
    public Runnable h1;
    public Runnable i1;
    public Runnable j1;

    /* renamed from: c.a.t0.s2.y.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1427a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23374e;

        public RunnableC1427a(a aVar) {
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
            this.f23374e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23374e.M.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23375e;

        /* renamed from: c.a.t0.s2.y.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1428a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f23376e;

            public C1428a(b bVar) {
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
                this.f23376e = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f23376e.f23375e.O0();
                    e.a().postDelayed(this.f23376e.f23375e.i1, 5000L);
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
            this.f23375e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23375e.M0.hasConcerned()) {
                return;
            }
            Context context = this.f23375e.Q;
            int i2 = this.f23375e.V ? g.tbds210 : g.tbds244;
            this.f23375e.S0 = true;
            this.f23375e.T0.setFloatValues(-n.f(context, i2));
            this.f23375e.T0.removeAllListeners();
            this.f23375e.T0.addListener(new C1428a(this));
            this.f23375e.T0.start();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23377e;

        /* renamed from: c.a.t0.s2.y.k.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1429a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f23378e;

            public C1429a(c cVar) {
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
                this.f23378e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f23378e.f23377e.M0.setVisibility(8);
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
            this.f23377e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23377e.T0.setFloatValues(n.f(this.f23377e.Q, this.f23377e.V ? g.tbds210 : g.tbds244));
                this.f23377e.T0.removeAllListeners();
                this.f23377e.T0.addListener(new C1429a(this));
                this.f23377e.T0.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23379e;

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
            this.f23379e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23379e.d1 && (this.f23379e.Q instanceof Activity)) {
                this.f23379e.J0();
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
        this.Q0 = -1;
        this.V0 = 0;
        this.g1 = new RunnableC1427a(this);
        this.h1 = new b(this);
        this.i1 = new c(this);
        this.j1 = new d(this);
        M();
        if (context instanceof AbsPbActivity) {
            this.U0 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            this.c1 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        }
        U(true);
        V(true);
        this.e0 = false;
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.S0 || this.M0.hasConcerned()) {
            return;
        }
        this.M0.setTranslationX(0.0f);
        this.M0.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.M0.getLayoutParams()).bottomMargin = n.f(this.Q, this.V ? g.tbds248 : g.tbds428);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.M0, AnimationProperty.TRANSLATE_X, 0.0f);
        this.T0 = ofFloat;
        ofFloat.setDuration(500);
        O0();
        e.a().postDelayed(this.h1, 5000L);
    }

    public final StatisticItem I0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", this.X).param("fid", this.Y).param("uid", TbadkCoreApplication.getCurrentAccount());
            BaijiahaoData baijiahaoData = this.Y0;
            if (baijiahaoData != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                param.param(TiebaStatic.Params.OBJ_PARAM6, this.Y0.oriUgcVid);
                int i2 = this.Y0.oriUgcType;
                if (i2 == 4) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (i2 == 2) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                }
            } else {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
            }
            Context context = this.Q;
            if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).getPbModel() != null) {
                param.param("ab_tag", ((AbsPbActivity) this.Q).getPbModel().W0()).param("obj_id", ((AbsPbActivity) this.Q).getPbModel().X0()).param("obj_source", ((AbsPbActivity) this.Q).getPbModel().Y0());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            W0();
            UtilHelper.hideStatusBar((Activity) this.Q, this.a1);
            this.d1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.Z0;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.setIsStatusBarShowing(false);
            }
        }
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d1 : invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.v.d
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.L();
            if (this.a0) {
                H0();
            }
        }
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.V : invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.v.d
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = this.f26095f & (-33);
            this.f26095f = i2;
            int i3 = this.f26096g & (-33);
            this.f26096g = i3;
            int i4 = this.f26097h & (-33);
            this.f26097h = i4;
            int i5 = this.q & (-33);
            this.q = i5;
            int i6 = this.f26098i & (-33);
            this.f26098i = i6;
            int i7 = this.f26099j & (-33);
            this.f26099j = i7;
            int i8 = this.k & (-33);
            this.k = i8;
            int i9 = this.l & (-33);
            this.l = i9;
            int i10 = this.m & (-33);
            this.m = i10;
            int i11 = this.n & (-33);
            this.n = i11;
            this.f26095f = i2 | 1024;
            int i12 = i3 | 1024;
            this.f26096g = i12;
            this.f26097h = i4 & (-1025);
            this.q = i5 & (-1025);
            this.f26098i = i6 | 1024;
            this.f26099j = i7 | 1024;
            int i13 = i8 | 1024;
            this.k = i13;
            int i14 = i9 | 1024;
            this.l = i14;
            this.m = i10 | 1024;
            this.n = i11 & (-1025);
            this.f26096g = i12 | 16384;
            this.k = i13 | 16384;
            this.l = i14 & (-2);
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

    @Override // c.a.t0.z2.v.d
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.I.changeViewLayout(this.V, this.a0);
            this.J.changeViewLayout(this.V, this.a0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.H;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                ((PbVideoMediaController) operableVideoMediaControllerView).changeViewLayout(this.V, this.a0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
            int i2 = 0;
            int f2 = (this.a0 && this.V) ? n.f(this.Q, g.tbds42) : 0;
            if (this.a0 && !this.V) {
                i2 = n.f(this.Q, g.tbds34);
            }
            layoutParams.bottomMargin = f2;
            layoutParams.rightMargin = i2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.O0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.P0.getLayoutParams();
            int f3 = n.f(this.Q, (!this.a0 || this.V) ? g.tbds104 : g.tbds208);
            layoutParams3.leftMargin = f3;
            layoutParams2.rightMargin = f3;
            this.N0.changeViewLayout(this.V, this.a0);
        }
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.r == this.n) {
                return false;
            }
            this.M.setVisibility(0);
            this.M.changeVolume(this.Q, false, 10);
            e.a().removeCallbacks(this.g1);
            e.a().postDelayed(this.g1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            e.a().removeCallbacks(this.h1);
            e.a().removeCallbacks(this.i1);
        }
    }

    public void P0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.N0.setIsCountDownValid(z);
        }
    }

    public void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.d1 = z;
        }
    }

    public void R0(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, e2Var) == null) {
            if (e2Var != null && e2Var.t1() != null && !m.isEmpty(e2Var.t1().video_url)) {
                int i2 = this.r;
                if (i2 == this.f26098i || i2 == this.f26099j) {
                    int i3 = this.r | 32768;
                    this.r = i3;
                    l0(i3);
                }
                int i4 = this.r;
                if (i4 == this.l) {
                    int i5 = i4 | 131072;
                    this.r = i5;
                    l0(i5);
                }
                this.f26098i |= 32768;
                this.f26099j |= 32768;
                this.l |= 131072;
                this.N0.setDate(e2Var);
                return;
            }
            int i6 = this.r;
            if (i6 == this.f26098i || i6 == this.f26099j || i6 == this.l) {
                int i7 = this.r & (-32769);
                this.r = i7;
                int i8 = i7 & (-131073);
                this.r = i8;
                l0(i8);
            }
            this.f26098i &= -32769;
            this.f26099j &= -32769;
            this.l &= -131073;
        }
    }

    @Override // c.a.t0.z2.v.d
    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            Context context = this.Q;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
            }
            super.S(z);
            O0();
            if (this.a0) {
                H0();
            } else {
                this.M0.setVisibility(8);
            }
        }
    }

    public void S0(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, e2Var) == null) {
            if (e2Var != null && e2Var.t1() != null && !m.isEmpty(e2Var.t1().video_url)) {
                int i2 = this.r;
                if (i2 == this.f26098i || i2 == this.f26099j) {
                    int i3 = this.r | 65536;
                    this.r = i3;
                    l0(i3);
                }
                this.f26098i |= 65536;
                this.f26099j |= 65536;
                return;
            }
            int i4 = this.r;
            if (i4 == this.f26098i || i4 == this.f26099j) {
                int i5 = this.r & (-65537);
                this.r = i5;
                l0(i5);
            }
            this.f26098i &= -65537;
            this.f26099j &= -65537;
        }
    }

    public void T0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            this.a1 = view;
        }
    }

    public void U0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
            this.b1 = view;
        }
    }

    public void V0(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, absVideoPbFragment) == null) {
            this.Z0 = absVideoPbFragment;
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.f1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b1, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.f1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.f1.start();
        }
    }

    @Override // c.a.t0.z2.v.d
    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? j.pb_operable_video_container : invokeV.intValue;
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.e1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b1, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.e1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.e1.start();
        }
    }

    @Override // c.a.t0.z2.v.d
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.a0();
            this.M0 = (PbVideoFullscreenAttentionLayout) this.S.findViewById(i.video_fullscreen_attention);
            this.N0 = (PbNextVideoLayout) this.S.findViewById(i.video_next_layout);
            this.O0 = (ImageView) this.S.findViewById(i.video_pre);
            this.P0 = (ImageView) this.S.findViewById(i.video_next);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O0, h.ic_icon_pure_video_up44_svg, f.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P0, h.ic_icon_pure_video_down44_svg, f.CAM_X0101, null);
            this.w.clearCornerFlag();
            this.w.setDrawCorner(false);
            this.M0.setOnClickEvent(this);
            this.O0.setOnClickListener(this);
            this.P0.setOnClickListener(this);
            this.N0.setOnClickListener(this);
            this.R0 = n.k(this.Q) / 10;
            this.J.setShareFrom(18);
        }
    }

    @Override // c.a.t0.z2.v.d
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.v.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.t0.z2.v.d
    public boolean c0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.R0) : invokeL.booleanValue;
    }

    @Override // c.a.t0.z2.v.d
    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.v.d
    public void l0(int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (i2 != this.f26099j && i2 != this.k && i2 != this.f26098i && i2 != this.f26096g) {
                O0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.M0;
                if (pbVideoFullscreenAttentionLayout != null) {
                    pbVideoFullscreenAttentionLayout.setVisibility(8);
                }
            }
            int i3 = this.r;
            int i4 = this.n;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.g1);
                int i5 = this.r;
                if ((i5 & 16384) > 0) {
                    i2 = (i2 | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i2 = (i2 & (-16385)) | 128 | 64;
                }
                this.n = i2;
            }
            super.l0(i2);
            if (!this.a0) {
                this.K.setVisibility(8);
                this.L.setVisibility(8);
                VideoPbViewModel videoPbViewModel = this.U0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.setIsShowNavigationBar((i2 & 1024) > 0);
                }
            }
            VideoPbViewModel videoPbViewModel2 = this.U0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.setIsShowNavigationBar((i2 & 128) > 0);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.H;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                int i6 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i6 > 0 || (i2 & 128) > 0) ? 0 : 8);
                ((PbVideoMediaController) this.H).setBottomBarShow(i6 > 0);
            }
            ImageView imageView = this.O0;
            if (imageView != null) {
                imageView.setVisibility((65536 & i2) > 0 ? 0 : 8);
            }
            ImageView imageView2 = this.P0;
            if (imageView2 != null) {
                imageView2.setVisibility((32768 & i2) > 0 ? 0 : 8);
            }
            if (this.N0 != null) {
                boolean z = (131072 & i2) > 0;
                this.N0.setVisibility(z ? 0 : 8);
                if (z) {
                    TiebaStatic.log(I0("c13600"));
                }
            }
            if (this.a0 || this.c1 || !(this.Q instanceof Activity)) {
                return;
            }
            if ((i2 & 128) > 0) {
                if (this.d1) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment2 = this.Z0;
                if (absVideoPbFragment2 == null || !absVideoPbFragment2.isStatusBarShowing()) {
                    X0();
                    UtilHelper.showStatusBar((Activity) this.Q, this.a1);
                }
                this.d1 = true;
                e.a().removeCallbacks(this.j1);
                e.a().postDelayed(this.j1, 3000L);
            } else if (this.d1 || ((absVideoPbFragment = this.Z0) != null && absVideoPbFragment.isStatusBarShowing())) {
                J0();
            }
        }
    }

    @Override // c.a.t0.z2.v.d, c.a.t0.z2.v.a
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            O0();
            this.M0.setVisibility(8);
            if (!this.c1) {
                J0();
            }
            if (z) {
                int i2 = this.r;
                this.Q0 = i2;
                if (i2 == this.f26099j || ((i2 == this.k && !this.v.getControl().isPlaying()) || this.r == this.l)) {
                    this.Q0 |= 1;
                }
                stopPlay();
            } else {
                int i3 = this.Q0;
                if (i3 == -1) {
                    startPlay();
                } else if (i3 != this.f26096g && i3 != this.f26098i && i3 != this.f26097h && i3 != this.q) {
                    this.H.setCurrentDuration(s.d().c(this.W), false);
                    l0(this.Q0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // c.a.t0.z2.v.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        if (id == i.play) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view);
        if (id == i.concern_video_info_item) {
            O0();
            e.a().post(this.i1);
        } else if (id != i.video_next && id != i.video_next_layout) {
            if (id == i.video_pre) {
                VideoPbViewModel videoPbViewModel = this.U0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.loadPreVideo();
                }
                TiebaStatic.log(new StatisticItem("c13594"));
            } else if (id == i.pb_next_video_close) {
                this.l &= -131073;
                this.r &= -131073;
                this.N0.setVisibility(8);
            }
        } else {
            VideoPbViewModel videoPbViewModel2 = this.U0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.loadNextVideo(id == i.video_next_layout);
            }
            if (id == i.video_next) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        }
    }

    @Override // c.a.t0.z2.v.d, c.a.t0.z2.v.a
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.r == this.n) {
                return false;
            }
            this.M.setVisibility(0);
            this.M.changeVolume(this.Q, true, 10);
            e.a().removeCallbacks(this.g1);
            e.a().postDelayed(this.g1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.v.d
    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (i2 == i.video_full_screen) {
                if (!isFullScreen()) {
                    TiebaStatic.log(new StatisticItem("c13598"));
                } else {
                    TiebaStatic.log(new StatisticItem("c13599"));
                }
            } else if (i2 == i.video_replay) {
                TiebaStatic.log(I0("c13602"));
            } else if (i2 == i.video_play) {
                TiebaStatic.log(new StatisticItem("c13597"));
            } else if (i2 == i.video_pause) {
                TiebaStatic.log(new StatisticItem("c13596"));
            } else if (i2 == i.video_next_layout) {
                TiebaStatic.log(I0("c13601").param("obj_type", this.N0.isManualFinish ? 1 : 2));
            }
        }
    }

    @Override // c.a.t0.z2.v.d
    public void s0() {
        t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (tVar = this.b0) == null) {
            return;
        }
        t b2 = tVar.b();
        b2.a = "pb";
        c.a.t0.z2.j.e(b2.m, "", "2", b2, this.v.getControl().getPcdnState());
    }

    @Override // c.a.t0.z2.v.d, c.a.t0.z2.v.a
    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, e2Var) == null) || e2Var == null) {
            return;
        }
        this.Y0 = e2Var.L();
        t tVar = new t();
        tVar.a = "6";
        tVar.f26074c = e2Var.v1();
        tVar.f26075d = Long.toString(e2Var.U());
        tVar.f26076e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.Q;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (e2Var.T1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.V0 = intExtra;
                if (intExtra == 0) {
                    this.V0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.W0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    tVar.k = this.W0;
                }
                tVar.f26080i = Integer.toString(this.V0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.X0 = stringExtra2;
                tVar.f26080i = stringExtra2;
            }
        }
        if (e2Var.t1() != null) {
            tVar.m = e2Var.t1().video_md5;
            tVar.p = String.valueOf(e2Var.t1().is_vertical);
        }
        setStatistic(tVar);
        this.S0 = false;
        if (this.U0.getData().s0()) {
            this.N0.setIsCountDownValid(true);
        } else {
            this.N0.setIsCountDownValid(false);
        }
        if (this.a0 && e2Var.t1() != null) {
            if (this.V != (e2Var.t1().is_vertical.intValue() == 1)) {
                R();
            }
        }
        super.setData(e2Var);
        U(!this.V);
        if (e2Var.J() != null) {
            e2Var.J().setIsLike(e2Var.J().hadConcerned());
        }
        this.M0.setData(e2Var);
    }

    @Override // c.a.t0.z2.v.d, c.a.t0.z2.v.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.M0.setUniqueId(bdUniqueId);
        }
    }
}
