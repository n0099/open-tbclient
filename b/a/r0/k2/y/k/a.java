package b.a.r0.k2.y.k;

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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import b.a.e.e.m.e;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.s.q.d2;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.q2.o;
import b.a.r0.q2.p;
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
/* loaded from: classes5.dex */
public class a extends b.a.r0.q2.r.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoFullscreenAttentionLayout K0;
    public PbNextVideoLayout L0;
    public ImageView M0;
    public ImageView N0;
    public int O0;
    public int P0;
    public boolean Q0;
    public ObjectAnimator R0;
    public VideoPbViewModel S0;
    public int T0;
    public String U0;
    public String V0;
    public BaijiahaoData W0;
    public AbsVideoPbFragment X0;
    public View Y0;
    public View Z0;
    public boolean a1;
    public boolean b1;
    public ObjectAnimator c1;
    public ObjectAnimator d1;
    public Runnable e1;
    public Runnable f1;
    public Runnable g1;
    public Runnable h1;

    /* renamed from: b.a.r0.k2.y.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0987a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19866e;

        public RunnableC0987a(a aVar) {
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
            this.f19866e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19866e.L.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19867e;

        /* renamed from: b.a.r0.k2.y.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0988a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19868e;

            public C0988a(b bVar) {
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
                this.f19868e = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f19868e.f19867e.T0();
                    e.a().postDelayed(this.f19868e.f19867e.g1, 5000L);
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
            this.f19867e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19867e.K0.hasConcerned()) {
                return;
            }
            Context context = this.f19867e.P;
            int i2 = this.f19867e.U ? g.tbds210 : g.tbds244;
            this.f19867e.Q0 = true;
            this.f19867e.R0.setFloatValues(-l.g(context, i2));
            this.f19867e.R0.removeAllListeners();
            this.f19867e.R0.addListener(new C0988a(this));
            this.f19867e.R0.start();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19869e;

        /* renamed from: b.a.r0.k2.y.k.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0989a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19870e;

            public C0989a(c cVar) {
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
                this.f19870e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f19870e.f19869e.K0.setVisibility(8);
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
            this.f19869e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19869e.R0.setFloatValues(l.g(this.f19869e.P, this.f19869e.U ? g.tbds210 : g.tbds244));
                this.f19869e.R0.removeAllListeners();
                this.f19869e.R0.addListener(new C0989a(this));
                this.f19869e.R0.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19871e;

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
            this.f19871e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19871e.b1 && (this.f19871e.P instanceof Activity)) {
                this.f19871e.O0();
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
        this.O0 = -1;
        this.T0 = 0;
        this.e1 = new RunnableC0987a(this);
        this.f1 = new b(this);
        this.g1 = new c(this);
        this.h1 = new d(this);
        S();
        if (context instanceof AbsPbActivity) {
            this.S0 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            this.a1 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        }
        a0(true);
        b0(true);
        this.j0 = false;
    }

    @Override // b.a.r0.q2.r.d, b.a.r0.q2.r.a
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.q == this.n) {
                return false;
            }
            this.L.setVisibility(0);
            this.L.changeVolume(this.P, true, 10);
            e.a().removeCallbacks(this.e1);
            e.a().postDelayed(this.e1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.r.d, b.a.r0.q2.r.a
    public boolean L(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            T0();
            this.K0.setVisibility(8);
            if (!this.a1) {
                O0();
            }
            if (z) {
                int i2 = this.q;
                this.O0 = i2;
                if (i2 == this.j || ((i2 == this.k && !this.u.isPlaying()) || this.q == this.l)) {
                    this.O0 |= 1;
                }
                stopPlay();
            } else {
                int i3 = this.O0;
                if (i3 == -1) {
                    startPlay();
                } else if (i3 != this.f22908g && i3 != this.f22910i && i3 != this.f22909h) {
                    this.G.setCurrentDuration(o.d().c(this.V), false);
                    r0(this.O0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.Q0 || this.K0.hasConcerned()) {
            return;
        }
        this.K0.setTranslationX(0.0f);
        this.K0.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.K0.getLayoutParams()).bottomMargin = l.g(this.P, this.U ? g.tbds248 : g.tbds428);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.K0, Key.TRANSLATION_X, 0.0f);
        this.R0 = ofFloat;
        ofFloat.setDuration(500);
        T0();
        e.a().postDelayed(this.f1, 5000L);
    }

    public final StatisticItem N0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", this.W).param("fid", this.Y).param("uid", TbadkCoreApplication.getCurrentAccount());
            BaijiahaoData baijiahaoData = this.W0;
            if (baijiahaoData != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                param.param(TiebaStatic.Params.OBJ_PARAM6, this.W0.oriUgcVid);
                int i2 = this.W0.oriUgcType;
                if (i2 == 4) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (i2 == 2) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                }
            } else {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
            }
            Context context = this.P;
            if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).getPbModel() != null) {
                param.param("ab_tag", ((AbsPbActivity) this.P).getPbModel().U0()).param("obj_id", ((AbsPbActivity) this.P).getPbModel().V0()).param("obj_source", ((AbsPbActivity) this.P).getPbModel().W0());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b1();
            UtilHelper.hideStatusBar((Activity) this.P, this.Y0);
            this.b1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.X0;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.setIsStatusBarShowing(false);
            }
        }
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b1 : invokeV.booleanValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.U : invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.r.d
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.R();
            if (this.a0) {
                M0();
            }
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            T0();
            a0(false);
            b0(false);
        }
    }

    @Override // b.a.r0.q2.r.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int i2 = this.f22907f & (-33);
            this.f22907f = i2;
            int i3 = this.f22908g & (-33);
            this.f22908g = i3;
            int i4 = this.f22909h & (-33);
            this.f22909h = i4;
            int i5 = this.f22910i & (-33);
            this.f22910i = i5;
            int i6 = this.j & (-33);
            this.j = i6;
            int i7 = this.k & (-33);
            this.k = i7;
            int i8 = this.l & (-33);
            this.l = i8;
            int i9 = this.m & (-33);
            this.m = i9;
            int i10 = this.n & (-33);
            this.n = i10;
            this.f22907f = i2 | 1024;
            int i11 = i3 | 1024;
            this.f22908g = i11;
            this.f22909h = i4 & (-1025);
            this.f22910i = i5 | 1024;
            this.j = i6 | 1024;
            int i12 = i7 | 1024;
            this.k = i12;
            int i13 = i8 | 1024;
            this.l = i13;
            this.m = i9 | 1024;
            this.n = i10 & (-1025);
            this.f22908g = i11 | 16384;
            this.k = i12 | 16384;
            this.l = i13 & (-2);
        }
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.q == this.n) {
                return false;
            }
            this.L.setVisibility(0);
            this.L.changeVolume(this.P, false, 10);
            e.a().removeCallbacks(this.e1);
            e.a().postDelayed(this.e1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.r.d
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.H.changeViewLayout(this.U, this.a0);
            this.I.changeViewLayout(this.U, this.a0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                ((PbVideoMediaController) operableVideoMediaControllerView).changeViewLayout(this.U, this.a0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
            int i2 = 0;
            int g2 = (this.a0 && this.U) ? l.g(this.P, g.tbds42) : 0;
            if (this.a0 && !this.U) {
                i2 = l.g(this.P, g.tbds34);
            }
            layoutParams.bottomMargin = g2;
            layoutParams.rightMargin = i2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.M0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.N0.getLayoutParams();
            int g3 = l.g(this.P, (!this.a0 || this.U) ? g.tbds104 : g.tbds208);
            layoutParams3.leftMargin = g3;
            layoutParams2.rightMargin = g3;
            this.L0.changeViewLayout(this.U, this.a0);
        }
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e.a().removeCallbacks(this.f1);
            e.a().removeCallbacks(this.g1);
        }
    }

    public void U0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.L0.setIsCountDownValid(z);
        }
    }

    public void V0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.b1 = z;
        }
    }

    public void W0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, d2Var) == null) {
            if (d2Var != null && d2Var.q1() != null && !k.isEmpty(d2Var.q1().video_url)) {
                int i2 = this.q;
                if (i2 == this.f22910i || i2 == this.j) {
                    int i3 = this.q | 32768;
                    this.q = i3;
                    r0(i3);
                }
                int i4 = this.q;
                if (i4 == this.l) {
                    int i5 = i4 | 131072;
                    this.q = i5;
                    r0(i5);
                }
                this.f22910i |= 32768;
                this.j |= 32768;
                this.l |= 131072;
                this.L0.setDate(d2Var);
                return;
            }
            int i6 = this.q;
            if (i6 == this.f22910i || i6 == this.j || i6 == this.l) {
                int i7 = this.q & (-32769);
                this.q = i7;
                int i8 = i7 & (-131073);
                this.q = i8;
                r0(i8);
            }
            this.f22910i &= -32769;
            this.j &= -32769;
            this.l &= -131073;
        }
    }

    public void X0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, d2Var) == null) {
            if (d2Var != null && d2Var.q1() != null && !k.isEmpty(d2Var.q1().video_url)) {
                int i2 = this.q;
                if (i2 == this.f22910i || i2 == this.j) {
                    int i3 = this.q | 65536;
                    this.q = i3;
                    r0(i3);
                }
                this.f22910i |= 65536;
                this.j |= 65536;
                return;
            }
            int i4 = this.q;
            if (i4 == this.f22910i || i4 == this.j) {
                int i5 = this.q & (-65537);
                this.q = i5;
                r0(i5);
            }
            this.f22910i &= -65537;
            this.j &= -65537;
        }
    }

    @Override // b.a.r0.q2.r.d
    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            Context context = this.P;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
            }
            super.Y(z);
            T0();
            if (this.a0) {
                M0();
            } else {
                this.K0.setVisibility(8);
            }
        }
    }

    public void Y0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            this.Y0 = view;
        }
    }

    public void Z0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            this.Z0 = view;
        }
    }

    public void a1(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, absVideoPbFragment) == null) {
            this.X0 = absVideoPbFragment;
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.d1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Z0, Key.ALPHA, 1.0f, 0.0f);
                this.d1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.d1.start();
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.c1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Z0, Key.ALPHA, 0.0f, 1.0f);
                this.c1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.c1.start();
        }
    }

    @Override // b.a.r0.q2.r.d
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? j.pb_operable_video_container : invokeV.intValue;
    }

    @Override // b.a.r0.q2.r.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.g0();
            this.K0 = (PbVideoFullscreenAttentionLayout) this.R.findViewById(i.video_fullscreen_attention);
            this.L0 = (PbNextVideoLayout) this.R.findViewById(i.video_next_layout);
            this.M0 = (ImageView) this.R.findViewById(i.video_pre);
            this.N0 = (ImageView) this.R.findViewById(i.video_next);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.M0, h.ic_icon_pure_video_up44_svg, f.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.N0, h.ic_icon_pure_video_down44_svg, f.CAM_X0101, null);
            this.v.clearCornerFlag();
            this.v.setDrawCorner(false);
            this.K0.setOnClickEvent(this);
            this.M0.setOnClickListener(this);
            this.N0.setOnClickListener(this);
            this.L0.setOnClickListener(this);
            this.P0 = l.k(this.P) / 10;
            this.I.setShareFrom(18);
        }
    }

    @Override // b.a.r0.q2.r.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.u.setVolume(1.0f, 1.0f);
        }
    }

    @Override // b.a.r0.q2.r.d
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.P0) : invokeL.booleanValue;
    }

    @Override // b.a.r0.q2.r.d
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.r.d, android.view.View.OnClickListener
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
            T0();
            e.a().post(this.g1);
        } else if (id != i.video_next && id != i.video_next_layout) {
            if (id == i.video_pre) {
                VideoPbViewModel videoPbViewModel = this.S0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.loadPreVideo();
                }
                TiebaStatic.log(new StatisticItem("c13594"));
            } else if (id == i.pb_next_video_close) {
                this.l &= -131073;
                this.q &= -131073;
                this.L0.setVisibility(8);
            }
        } else {
            VideoPbViewModel videoPbViewModel2 = this.S0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.loadNextVideo(id == i.video_next_layout);
            }
            if (id == i.video_next) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        }
    }

    @Override // b.a.r0.q2.r.d
    public void r0(int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            if (i2 != this.j && i2 != this.k && i2 != this.f22910i && i2 != this.f22908g) {
                T0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.K0;
                if (pbVideoFullscreenAttentionLayout != null) {
                    pbVideoFullscreenAttentionLayout.setVisibility(8);
                }
            }
            int i3 = this.q;
            int i4 = this.n;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.e1);
                int i5 = this.q;
                if ((i5 & 16384) > 0) {
                    i2 = (i2 | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i2 = (i2 & (-16385)) | 128 | 64;
                }
                this.n = i2;
            }
            super.r0(i2);
            if (!this.a0) {
                this.J.setVisibility(8);
                this.K.setVisibility(8);
                VideoPbViewModel videoPbViewModel = this.S0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.setIsShowNavigationBar((i2 & 1024) > 0);
                }
            }
            VideoPbViewModel videoPbViewModel2 = this.S0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.setIsShowNavigationBar((i2 & 128) > 0);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                int i6 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i6 > 0 || (i2 & 128) > 0) ? 0 : 8);
                ((PbVideoMediaController) this.G).setBottomBarShow(i6 > 0);
            }
            ImageView imageView = this.M0;
            if (imageView != null) {
                imageView.setVisibility((65536 & i2) > 0 ? 0 : 8);
            }
            ImageView imageView2 = this.N0;
            if (imageView2 != null) {
                imageView2.setVisibility((32768 & i2) > 0 ? 0 : 8);
            }
            if (this.L0 != null) {
                boolean z = (131072 & i2) > 0;
                this.L0.setVisibility(z ? 0 : 8);
                if (z) {
                    TiebaStatic.log(N0("c13600"));
                }
            }
            if (this.a0 || this.a1 || !(this.P instanceof Activity)) {
                return;
            }
            if ((i2 & 128) > 0) {
                if (this.b1) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment2 = this.X0;
                if (absVideoPbFragment2 == null || !absVideoPbFragment2.isStatusBarShowing()) {
                    c1();
                    UtilHelper.showStatusBar((Activity) this.P, this.Y0);
                }
                this.b1 = true;
                e.a().removeCallbacks(this.h1);
                e.a().postDelayed(this.h1, 3000L);
            } else if (this.b1 || ((absVideoPbFragment = this.X0) != null && absVideoPbFragment.isStatusBarShowing())) {
                O0();
            }
        }
    }

    @Override // b.a.r0.q2.r.d, b.a.r0.q2.r.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.W0 = d2Var.L();
        p pVar = new p();
        pVar.f22882a = "6";
        pVar.f22884c = d2Var.s1();
        pVar.f22885d = Long.toString(d2Var.T());
        pVar.f22886e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (d2Var.Q1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.T0 = intExtra;
                if (intExtra == 0) {
                    this.T0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.U0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    pVar.k = this.U0;
                }
                pVar.f22890i = Integer.toString(this.T0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.V0 = stringExtra2;
                pVar.f22890i = stringExtra2;
            }
        }
        if (d2Var.q1() != null) {
            pVar.m = d2Var.q1().video_md5;
            pVar.p = String.valueOf(d2Var.q1().is_vertical);
        }
        G(pVar);
        this.Q0 = false;
        if (this.S0.getData().s0()) {
            this.L0.setIsCountDownValid(true);
        } else {
            this.L0.setIsCountDownValid(false);
        }
        if (this.a0 && d2Var.q1() != null) {
            if (this.U != (d2Var.q1().is_vertical.intValue() == 1)) {
                X();
            }
        }
        super.setData(d2Var);
        a0(!this.U);
        if (d2Var.J() != null) {
            d2Var.J().setIsLike(d2Var.J().hadConcerned());
        }
        this.K0.setData(d2Var);
    }

    @Override // b.a.r0.q2.r.d, b.a.r0.q2.r.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.K0.setUniqueId(bdUniqueId);
        }
    }

    @Override // b.a.r0.q2.r.d
    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (i2 == i.video_full_screen) {
                if (!isFullScreen()) {
                    TiebaStatic.log(new StatisticItem("c13598"));
                } else {
                    TiebaStatic.log(new StatisticItem("c13599"));
                }
            } else if (i2 == i.video_replay) {
                TiebaStatic.log(N0("c13602"));
            } else if (i2 == i.video_play) {
                TiebaStatic.log(new StatisticItem("c13597"));
            } else if (i2 == i.video_pause) {
                TiebaStatic.log(new StatisticItem("c13596"));
            } else if (i2 == i.video_next_layout) {
                TiebaStatic.log(N0("c13601").param("obj_type", this.L0.isManualFinish ? 1 : 2));
            }
        }
    }

    @Override // b.a.r0.q2.r.d
    public void x0() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (pVar = this.b0) == null) {
            return;
        }
        p b2 = pVar.b();
        b2.f22882a = "pb";
        b.a.r0.q2.h.e(b2.m, "", "2", b2, this.u.getPcdnState());
    }
}
