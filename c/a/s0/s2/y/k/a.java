package c.a.s0.s2.y.k;

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
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
import c.a.s0.s2.f;
import c.a.s0.s2.g;
import c.a.s0.s2.h;
import c.a.s0.s2.i;
import c.a.s0.s2.j;
import c.a.s0.z2.o;
import c.a.s0.z2.p;
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
public class a extends c.a.s0.z2.r.d {
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

    /* renamed from: c.a.s0.s2.y.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1384a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23531e;

        public RunnableC1384a(a aVar) {
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
            this.f23531e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23531e.M.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23532e;

        /* renamed from: c.a.s0.s2.y.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1385a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f23533e;

            public C1385a(b bVar) {
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
                this.f23533e = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f23533e.f23532e.U0();
                    e.a().postDelayed(this.f23533e.f23532e.j1, 5000L);
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
            this.f23532e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23532e.N0.hasConcerned()) {
                return;
            }
            Context context = this.f23532e.Q;
            int i2 = this.f23532e.V ? g.tbds210 : g.tbds244;
            this.f23532e.T0 = true;
            this.f23532e.U0.setFloatValues(-m.f(context, i2));
            this.f23532e.U0.removeAllListeners();
            this.f23532e.U0.addListener(new C1385a(this));
            this.f23532e.U0.start();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23534e;

        /* renamed from: c.a.s0.s2.y.k.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1386a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f23535e;

            public C1386a(c cVar) {
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
                this.f23535e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f23535e.f23534e.N0.setVisibility(8);
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
            this.f23534e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23534e.U0.setFloatValues(m.f(this.f23534e.Q, this.f23534e.V ? g.tbds210 : g.tbds244));
                this.f23534e.U0.removeAllListeners();
                this.f23534e.U0.addListener(new C1386a(this));
                this.f23534e.U0.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23536e;

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
            this.f23536e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23536e.e1 && (this.f23536e.Q instanceof Activity)) {
                this.f23536e.P0();
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
        this.h1 = new RunnableC1384a(this);
        this.i1 = new b(this);
        this.j1 = new c(this);
        this.k1 = new d(this);
        Q();
        if (context instanceof AbsPbActivity) {
            this.V0 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            this.d1 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        }
        a0(true);
        b0(true);
        this.f0 = false;
    }

    @Override // c.a.s0.z2.r.d, c.a.s0.z2.r.a
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.r == this.n) {
                return false;
            }
            this.M.setVisibility(0);
            this.M.changeVolume(this.Q, true, 10);
            e.a().removeCallbacks(this.h1);
            e.a().postDelayed(this.h1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.T0 || this.N0.hasConcerned()) {
            return;
        }
        this.N0.setTranslationX(0.0f);
        this.N0.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.N0.getLayoutParams()).bottomMargin = m.f(this.Q, this.V ? g.tbds248 : g.tbds428);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N0, AnimationProperty.TRANSLATE_X, 0.0f);
        this.U0 = ofFloat;
        ofFloat.setDuration(500);
        U0();
        e.a().postDelayed(this.i1, 5000L);
    }

    @Override // c.a.s0.z2.r.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.O();
            if (this.b0) {
                N0();
            }
        }
    }

    public final StatisticItem O0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", this.X).param("fid", this.Z).param("uid", TbadkCoreApplication.getCurrentAccount());
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
            Context context = this.Q;
            if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).getPbModel() != null) {
                param.param("ab_tag", ((AbsPbActivity) this.Q).getPbModel().W0()).param("obj_id", ((AbsPbActivity) this.Q).getPbModel().X0()).param("obj_source", ((AbsPbActivity) this.Q).getPbModel().Y0());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c1();
            UtilHelper.hideStatusBar((Activity) this.Q, this.b1);
            this.e1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.a1;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.setIsStatusBarShowing(false);
            }
        }
    }

    @Override // c.a.s0.z2.r.d
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.f26428f & (-33);
            this.f26428f = i2;
            int i3 = this.f26429g & (-33);
            this.f26429g = i3;
            int i4 = this.f26430h & (-33);
            this.f26430h = i4;
            int i5 = this.q & (-33);
            this.q = i5;
            int i6 = this.f26431i & (-33);
            this.f26431i = i6;
            int i7 = this.f26432j & (-33);
            this.f26432j = i7;
            int i8 = this.f26433k & (-33);
            this.f26433k = i8;
            int i9 = this.l & (-33);
            this.l = i9;
            int i10 = this.m & (-33);
            this.m = i10;
            int i11 = this.n & (-33);
            this.n = i11;
            this.f26428f = i2 | 1024;
            int i12 = i3 | 1024;
            this.f26429g = i12;
            this.f26430h = i4 & (-1025);
            this.q = i5 & (-1025);
            this.f26431i = i6 | 1024;
            this.f26432j = i7 | 1024;
            int i13 = i8 | 1024;
            this.f26433k = i13;
            int i14 = i9 | 1024;
            this.l = i14;
            this.m = i10 | 1024;
            this.n = i11 & (-1025);
            this.f26429g = i12 | 16384;
            this.f26433k = i13 | 16384;
            this.l = i14 & (-2);
        }
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e1 : invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.r.d, c.a.s0.z2.r.a
    public boolean R(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            U0();
            this.N0.setVisibility(8);
            if (!this.d1) {
                P0();
            }
            if (z) {
                int i2 = this.r;
                this.R0 = i2;
                if (i2 == this.f26432j || ((i2 == this.f26433k && !this.v.isPlaying()) || this.r == this.l)) {
                    this.R0 |= 1;
                }
                stopPlay();
            } else {
                int i3 = this.R0;
                if (i3 == -1) {
                    startPlay();
                } else if (i3 != this.f26429g && i3 != this.f26431i && i3 != this.f26430h && i3 != this.q) {
                    this.H.setCurrentDuration(o.d().c(this.W), false);
                    r0(this.R0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.V : invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.r.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.I.changeViewLayout(this.V, this.b0);
            this.J.changeViewLayout(this.V, this.b0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.H;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                ((PbVideoMediaController) operableVideoMediaControllerView).changeViewLayout(this.V, this.b0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
            int i2 = 0;
            int f2 = (this.b0 && this.V) ? m.f(this.Q, g.tbds42) : 0;
            if (this.b0 && !this.V) {
                i2 = m.f(this.Q, g.tbds34);
            }
            layoutParams.bottomMargin = f2;
            layoutParams.rightMargin = i2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Q0.getLayoutParams();
            int f3 = m.f(this.Q, (!this.b0 || this.V) ? g.tbds104 : g.tbds208);
            layoutParams3.leftMargin = f3;
            layoutParams2.rightMargin = f3;
            this.O0.changeViewLayout(this.V, this.b0);
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            U0();
            a0(false);
            b0(false);
        }
    }

    public boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.r == this.n) {
                return false;
            }
            this.M.setVisibility(0);
            this.M.changeVolume(this.Q, false, 10);
            e.a().removeCallbacks(this.h1);
            e.a().postDelayed(this.h1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e.a().removeCallbacks(this.i1);
            e.a().removeCallbacks(this.j1);
        }
    }

    public void V0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.O0.setIsCountDownValid(z);
        }
    }

    public void W0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.e1 = z;
        }
    }

    public void X0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, d2Var) == null) {
            if (d2Var != null && d2Var.t1() != null && !l.isEmpty(d2Var.t1().video_url)) {
                int i2 = this.r;
                if (i2 == this.f26431i || i2 == this.f26432j) {
                    int i3 = this.r | 32768;
                    this.r = i3;
                    r0(i3);
                }
                int i4 = this.r;
                if (i4 == this.l) {
                    int i5 = i4 | 131072;
                    this.r = i5;
                    r0(i5);
                }
                this.f26431i |= 32768;
                this.f26432j |= 32768;
                this.l |= 131072;
                this.O0.setDate(d2Var);
                return;
            }
            int i6 = this.r;
            if (i6 == this.f26431i || i6 == this.f26432j || i6 == this.l) {
                int i7 = this.r & (-32769);
                this.r = i7;
                int i8 = i7 & (-131073);
                this.r = i8;
                r0(i8);
            }
            this.f26431i &= -32769;
            this.f26432j &= -32769;
            this.l &= -131073;
        }
    }

    @Override // c.a.s0.z2.r.d
    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            Context context = this.Q;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.b0);
            }
            super.Y(z);
            U0();
            if (this.b0) {
                N0();
            } else {
                this.N0.setVisibility(8);
            }
        }
    }

    public void Y0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, d2Var) == null) {
            if (d2Var != null && d2Var.t1() != null && !l.isEmpty(d2Var.t1().video_url)) {
                int i2 = this.r;
                if (i2 == this.f26431i || i2 == this.f26432j) {
                    int i3 = this.r | 65536;
                    this.r = i3;
                    r0(i3);
                }
                this.f26431i |= 65536;
                this.f26432j |= 65536;
                return;
            }
            int i4 = this.r;
            if (i4 == this.f26431i || i4 == this.f26432j) {
                int i5 = this.r & (-65537);
                this.r = i5;
                r0(i5);
            }
            this.f26431i &= -65537;
            this.f26432j &= -65537;
        }
    }

    public void Z0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            this.b1 = view;
        }
    }

    public void a1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            this.c1 = view;
        }
    }

    public void b1(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, absVideoPbFragment) == null) {
            this.a1 = absVideoPbFragment;
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.g1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c1, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.g1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.g1.start();
        }
    }

    @Override // c.a.s0.z2.r.d
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? j.pb_operable_video_container : invokeV.intValue;
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.f1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c1, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.f1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.f1.start();
        }
    }

    @Override // c.a.s0.z2.r.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.g0();
            this.N0 = (PbVideoFullscreenAttentionLayout) this.S.findViewById(i.video_fullscreen_attention);
            this.O0 = (PbNextVideoLayout) this.S.findViewById(i.video_next_layout);
            this.P0 = (ImageView) this.S.findViewById(i.video_pre);
            this.Q0 = (ImageView) this.S.findViewById(i.video_next);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P0, h.ic_icon_pure_video_up44_svg, f.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.Q0, h.ic_icon_pure_video_down44_svg, f.CAM_X0101, null);
            this.w.clearCornerFlag();
            this.w.setDrawCorner(false);
            this.N0.setOnClickEvent(this);
            this.P0.setOnClickListener(this);
            this.Q0.setOnClickListener(this);
            this.O0.setOnClickListener(this);
            this.S0 = m.k(this.Q) / 10;
            this.J.setShareFrom(18);
        }
    }

    @Override // c.a.s0.z2.r.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.v.setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.s0.z2.r.d
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) ? this.b0 || motionEvent.getX() > ((float) this.S0) : invokeL.booleanValue;
    }

    @Override // c.a.s0.z2.r.d
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.r.d, android.view.View.OnClickListener
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
            U0();
            e.a().post(this.j1);
        } else if (id != i.video_next && id != i.video_next_layout) {
            if (id == i.video_pre) {
                VideoPbViewModel videoPbViewModel = this.V0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.loadPreVideo();
                }
                TiebaStatic.log(new StatisticItem("c13594"));
            } else if (id == i.pb_next_video_close) {
                this.l &= -131073;
                this.r &= -131073;
                this.O0.setVisibility(8);
            }
        } else {
            VideoPbViewModel videoPbViewModel2 = this.V0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.loadNextVideo(id == i.video_next_layout);
            }
            if (id == i.video_next) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        }
    }

    @Override // c.a.s0.z2.r.d
    public void r0(int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            if (i2 != this.f26432j && i2 != this.f26433k && i2 != this.f26431i && i2 != this.f26429g) {
                U0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.N0;
                if (pbVideoFullscreenAttentionLayout != null) {
                    pbVideoFullscreenAttentionLayout.setVisibility(8);
                }
            }
            int i3 = this.r;
            int i4 = this.n;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.h1);
                int i5 = this.r;
                if ((i5 & 16384) > 0) {
                    i2 = (i2 | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i2 = (i2 & (-16385)) | 128 | 64;
                }
                this.n = i2;
            }
            super.r0(i2);
            if (!this.b0) {
                this.K.setVisibility(8);
                this.L.setVisibility(8);
                VideoPbViewModel videoPbViewModel = this.V0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.setIsShowNavigationBar((i2 & 1024) > 0);
                }
            }
            VideoPbViewModel videoPbViewModel2 = this.V0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.setIsShowNavigationBar((i2 & 128) > 0);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.H;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                int i6 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i6 > 0 || (i2 & 128) > 0) ? 0 : 8);
                ((PbVideoMediaController) this.H).setBottomBarShow(i6 > 0);
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
                    TiebaStatic.log(O0("c13600"));
                }
            }
            if (this.b0 || this.d1 || !(this.Q instanceof Activity)) {
                return;
            }
            if ((i2 & 128) > 0) {
                if (this.e1) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment2 = this.a1;
                if (absVideoPbFragment2 == null || !absVideoPbFragment2.isStatusBarShowing()) {
                    d1();
                    UtilHelper.showStatusBar((Activity) this.Q, this.b1);
                }
                this.e1 = true;
                e.a().removeCallbacks(this.k1);
                e.a().postDelayed(this.k1, 3000L);
            } else if (this.e1 || ((absVideoPbFragment = this.a1) != null && absVideoPbFragment.isStatusBarShowing())) {
                P0();
            }
        }
    }

    @Override // c.a.s0.z2.r.d, c.a.s0.z2.r.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.Z0 = d2Var.L();
        p pVar = new p();
        pVar.a = "6";
        pVar.f26406c = d2Var.v1();
        pVar.f26407d = Long.toString(d2Var.U());
        pVar.f26408e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.Q;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (d2Var.T1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.W0 = intExtra;
                if (intExtra == 0) {
                    this.W0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.X0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    pVar.f26414k = this.X0;
                }
                pVar.f26412i = Integer.toString(this.W0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Y0 = stringExtra2;
                pVar.f26412i = stringExtra2;
            }
        }
        if (d2Var.t1() != null) {
            pVar.m = d2Var.t1().video_md5;
            pVar.p = String.valueOf(d2Var.t1().is_vertical);
        }
        N(pVar);
        this.T0 = false;
        if (this.V0.getData().s0()) {
            this.O0.setIsCountDownValid(true);
        } else {
            this.O0.setIsCountDownValid(false);
        }
        if (this.b0 && d2Var.t1() != null) {
            if (this.V != (d2Var.t1().is_vertical.intValue() == 1)) {
                X();
            }
        }
        super.setData(d2Var);
        a0(!this.V);
        if (d2Var.J() != null) {
            d2Var.J().setIsLike(d2Var.J().hadConcerned());
        }
        this.N0.setData(d2Var);
    }

    @Override // c.a.s0.z2.r.d, c.a.s0.z2.r.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.N0.setUniqueId(bdUniqueId);
        }
    }

    @Override // c.a.s0.z2.r.d
    public void x0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (i2 == i.video_full_screen) {
                if (!isFullScreen()) {
                    TiebaStatic.log(new StatisticItem("c13598"));
                } else {
                    TiebaStatic.log(new StatisticItem("c13599"));
                }
            } else if (i2 == i.video_replay) {
                TiebaStatic.log(O0("c13602"));
            } else if (i2 == i.video_play) {
                TiebaStatic.log(new StatisticItem("c13597"));
            } else if (i2 == i.video_pause) {
                TiebaStatic.log(new StatisticItem("c13596"));
            } else if (i2 == i.video_next_layout) {
                TiebaStatic.log(O0("c13601").param("obj_type", this.O0.isManualFinish ? 1 : 2));
            }
        }
    }

    @Override // c.a.s0.z2.r.d
    public void y0() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (pVar = this.c0) == null) {
            return;
        }
        p b2 = pVar.b();
        b2.a = "pb";
        c.a.s0.z2.h.e(b2.m, "", "2", b2, this.v.getPcdnState());
    }
}
