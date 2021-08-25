package c.a.q0.i2.o.k;

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
import c.a.e.e.m.e;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
import c.a.q0.o2.h;
import c.a.q0.o2.n;
import c.a.q0.o2.o;
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
/* loaded from: classes3.dex */
public class a extends c.a.q0.o2.q.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoFullscreenAttentionLayout L0;
    public PbNextVideoLayout M0;
    public ImageView N0;
    public ImageView O0;
    public int P0;
    public int Q0;
    public boolean R0;
    public ObjectAnimator S0;
    public VideoPbViewModel T0;
    public int U0;
    public String V0;
    public String W0;
    public BaijiahaoData X0;
    public AbsVideoPbFragment Y0;
    public View Z0;
    public View a1;
    public boolean b1;
    public boolean c1;
    public ObjectAnimator d1;
    public ObjectAnimator e1;
    public Runnable f1;
    public Runnable g1;
    public Runnable h1;
    public Runnable i1;

    /* renamed from: c.a.q0.i2.o.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0947a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20137e;

        public RunnableC0947a(a aVar) {
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
            this.f20137e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20137e.L.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20138e;

        /* renamed from: c.a.q0.i2.o.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0948a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f20139e;

            public C0948a(b bVar) {
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
                this.f20139e = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f20139e.f20138e.T0();
                    e.a().postDelayed(this.f20139e.f20138e.h1, 5000L);
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
            this.f20138e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20138e.L0.hasConcerned()) {
                return;
            }
            Context context = this.f20138e.P;
            int i2 = this.f20138e.U ? R.dimen.tbds210 : R.dimen.tbds244;
            this.f20138e.R0 = true;
            this.f20138e.S0.setFloatValues(-l.g(context, i2));
            this.f20138e.S0.removeAllListeners();
            this.f20138e.S0.addListener(new C0948a(this));
            this.f20138e.S0.start();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20140e;

        /* renamed from: c.a.q0.i2.o.k.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0949a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f20141e;

            public C0949a(c cVar) {
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
                this.f20141e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f20141e.f20140e.L0.setVisibility(8);
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
            this.f20140e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20140e.S0.setFloatValues(l.g(this.f20140e.P, this.f20140e.U ? R.dimen.tbds210 : R.dimen.tbds244));
                this.f20140e.S0.removeAllListeners();
                this.f20140e.S0.addListener(new C0949a(this));
                this.f20140e.S0.start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20142e;

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
            this.f20142e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20142e.c1 && (this.f20142e.P instanceof Activity)) {
                this.f20142e.O0();
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
        this.P0 = -1;
        this.U0 = 0;
        this.f1 = new RunnableC0947a(this);
        this.g1 = new b(this);
        this.h1 = new c(this);
        this.i1 = new d(this);
        S();
        if (context instanceof AbsPbActivity) {
            this.T0 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            this.b1 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        }
        a0(true);
        b0(true);
        this.j0 = false;
    }

    @Override // c.a.q0.o2.q.d, c.a.q0.o2.q.a
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.q == this.n) {
                return false;
            }
            this.L.setVisibility(0);
            this.L.changeVolume(this.P, true, 10);
            e.a().removeCallbacks(this.f1);
            e.a().postDelayed(this.f1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.o2.q.d, c.a.q0.o2.q.a
    public boolean I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            T0();
            this.L0.setVisibility(8);
            if (!this.b1) {
                O0();
            }
            if (z) {
                int i2 = this.q;
                this.P0 = i2;
                if (i2 == this.f23246j || ((i2 == this.k && !this.u.isPlaying()) || this.q == this.l)) {
                    this.P0 |= 1;
                }
                stopPlay();
            } else {
                int i3 = this.P0;
                if (i3 == -1) {
                    startPlay();
                } else if (i3 != this.f23243g && i3 != this.f23245i && i3 != this.f23244h) {
                    this.G.setCurrentDuration(n.d().c(this.V), false);
                    r0(this.P0);
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.R0 || this.L0.hasConcerned()) {
            return;
        }
        this.L0.setTranslationX(0.0f);
        this.L0.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.L0.getLayoutParams()).bottomMargin = l.g(this.P, this.U ? R.dimen.tbds248 : R.dimen.tbds428);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.L0, "translationX", 0.0f);
        this.S0 = ofFloat;
        ofFloat.setDuration(500);
        T0();
        e.a().postDelayed(this.g1, 5000L);
    }

    public final StatisticItem N0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", this.W).param("fid", this.Y).param("uid", TbadkCoreApplication.getCurrentAccount());
            BaijiahaoData baijiahaoData = this.X0;
            if (baijiahaoData != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                param.param(TiebaStatic.Params.OBJ_PARAM6, this.X0.oriUgcVid);
                int i2 = this.X0.oriUgcType;
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
                param.param("ab_tag", ((AbsPbActivity) this.P).getPbModel().T0()).param("obj_id", ((AbsPbActivity) this.P).getPbModel().U0()).param("obj_source", ((AbsPbActivity) this.P).getPbModel().V0());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b1();
            UtilHelper.hideStatusBar((Activity) this.P, this.Z0);
            this.c1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.Y0;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.setIsStatusBarShowing(false);
            }
        }
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c1 : invokeV.booleanValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.U : invokeV.booleanValue;
    }

    @Override // c.a.q0.o2.q.d
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

    @Override // c.a.q0.o2.q.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int i2 = this.f23242f & (-33);
            this.f23242f = i2;
            int i3 = this.f23243g & (-33);
            this.f23243g = i3;
            int i4 = this.f23244h & (-33);
            this.f23244h = i4;
            int i5 = this.f23245i & (-33);
            this.f23245i = i5;
            int i6 = this.f23246j & (-33);
            this.f23246j = i6;
            int i7 = this.k & (-33);
            this.k = i7;
            int i8 = this.l & (-33);
            this.l = i8;
            int i9 = this.m & (-33);
            this.m = i9;
            int i10 = this.n & (-33);
            this.n = i10;
            this.f23242f = i2 | 1024;
            int i11 = i3 | 1024;
            this.f23243g = i11;
            this.f23244h = i4 & (-1025);
            this.f23245i = i5 | 1024;
            this.f23246j = i6 | 1024;
            int i12 = i7 | 1024;
            this.k = i12;
            int i13 = i8 | 1024;
            this.l = i13;
            this.m = i9 | 1024;
            this.n = i10 & (-1025);
            this.f23243g = i11 | 16384;
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
            e.a().removeCallbacks(this.f1);
            e.a().postDelayed(this.f1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.o2.q.d
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
            int g2 = (this.a0 && this.U) ? l.g(this.P, R.dimen.tbds42) : 0;
            if (this.a0 && !this.U) {
                i2 = l.g(this.P, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = g2;
            layoutParams.rightMargin = i2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.O0.getLayoutParams();
            int g3 = l.g(this.P, (!this.a0 || this.U) ? R.dimen.tbds104 : R.dimen.tbds208);
            layoutParams3.leftMargin = g3;
            layoutParams2.rightMargin = g3;
            this.M0.changeViewLayout(this.U, this.a0);
        }
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e.a().removeCallbacks(this.g1);
            e.a().removeCallbacks(this.h1);
        }
    }

    public void U0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.M0.setIsCountDownValid(z);
        }
    }

    public void V0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.c1 = z;
        }
    }

    public void W0(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, c2Var) == null) {
            if (c2Var != null && c2Var.o1() != null && !k.isEmpty(c2Var.o1().video_url)) {
                int i2 = this.q;
                if (i2 == this.f23245i || i2 == this.f23246j) {
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
                this.f23245i |= 32768;
                this.f23246j |= 32768;
                this.l |= 131072;
                this.M0.setDate(c2Var);
                return;
            }
            int i6 = this.q;
            if (i6 == this.f23245i || i6 == this.f23246j || i6 == this.l) {
                int i7 = this.q & (-32769);
                this.q = i7;
                int i8 = i7 & (-131073);
                this.q = i8;
                r0(i8);
            }
            this.f23245i &= -32769;
            this.f23246j &= -32769;
            this.l &= -131073;
        }
    }

    public void X0(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, c2Var) == null) {
            if (c2Var != null && c2Var.o1() != null && !k.isEmpty(c2Var.o1().video_url)) {
                int i2 = this.q;
                if (i2 == this.f23245i || i2 == this.f23246j) {
                    int i3 = this.q | 65536;
                    this.q = i3;
                    r0(i3);
                }
                this.f23245i |= 65536;
                this.f23246j |= 65536;
                return;
            }
            int i4 = this.q;
            if (i4 == this.f23245i || i4 == this.f23246j) {
                int i5 = this.q & (-65537);
                this.q = i5;
                r0(i5);
            }
            this.f23245i &= -65537;
            this.f23246j &= -65537;
        }
    }

    @Override // c.a.q0.o2.q.d
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
                this.L0.setVisibility(8);
            }
        }
    }

    public void Y0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            this.Z0 = view;
        }
    }

    public void Z0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            this.a1 = view;
        }
    }

    public void a1(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, absVideoPbFragment) == null) {
            this.Y0 = absVideoPbFragment;
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.e1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a1, "alpha", 1.0f, 0.0f);
                this.e1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.e1.start();
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.d1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a1, "alpha", 0.0f, 1.0f);
                this.d1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.d1.start();
        }
    }

    @Override // c.a.q0.o2.q.d
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? R.layout.pb_operable_video_container : invokeV.intValue;
    }

    @Override // c.a.q0.o2.q.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.g0();
            this.L0 = (PbVideoFullscreenAttentionLayout) this.R.findViewById(R.id.video_fullscreen_attention);
            this.M0 = (PbNextVideoLayout) this.R.findViewById(R.id.video_next_layout);
            this.N0 = (ImageView) this.R.findViewById(R.id.video_pre);
            this.O0 = (ImageView) this.R.findViewById(R.id.video_next);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.N0, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O0, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, null);
            this.v.clearCornerFlag();
            this.v.setDrawCorner(false);
            this.L0.setOnClickEvent(this);
            this.N0.setOnClickListener(this);
            this.O0.setOnClickListener(this);
            this.M0.setOnClickListener(this);
            this.Q0 = l.k(this.P) / 10;
            this.I.setShareFrom(18);
        }
    }

    @Override // c.a.q0.o2.q.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.u.setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.q0.o2.q.d
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.Q0) : invokeL.booleanValue;
    }

    @Override // c.a.q0.o2.q.d
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.o2.q.d, android.view.View.OnClickListener
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
            T0();
            e.a().post(this.h1);
        } else if (id != R.id.video_next && id != R.id.video_next_layout) {
            if (id == R.id.video_pre) {
                VideoPbViewModel videoPbViewModel = this.T0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.loadPreVideo();
                }
                TiebaStatic.log(new StatisticItem("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.l &= -131073;
                this.q &= -131073;
                this.M0.setVisibility(8);
            }
        } else {
            VideoPbViewModel videoPbViewModel2 = this.T0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.loadNextVideo(id == R.id.video_next_layout);
            }
            if (id == R.id.video_next) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        }
    }

    @Override // c.a.q0.o2.q.d
    public void r0(int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            if (i2 != this.f23246j && i2 != this.k && i2 != this.f23245i && i2 != this.f23243g) {
                T0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.L0;
                if (pbVideoFullscreenAttentionLayout != null) {
                    pbVideoFullscreenAttentionLayout.setVisibility(8);
                }
            }
            int i3 = this.q;
            int i4 = this.n;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.f1);
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
                VideoPbViewModel videoPbViewModel = this.T0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.setIsShowNavigationBar((i2 & 1024) > 0);
                }
            }
            VideoPbViewModel videoPbViewModel2 = this.T0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.setIsShowNavigationBar((i2 & 128) > 0);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                int i6 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i6 > 0 || (i2 & 128) > 0) ? 0 : 8);
                ((PbVideoMediaController) this.G).setBottomBarShow(i6 > 0);
            }
            ImageView imageView = this.N0;
            if (imageView != null) {
                imageView.setVisibility((65536 & i2) > 0 ? 0 : 8);
            }
            ImageView imageView2 = this.O0;
            if (imageView2 != null) {
                imageView2.setVisibility((32768 & i2) > 0 ? 0 : 8);
            }
            if (this.M0 != null) {
                boolean z = (131072 & i2) > 0;
                this.M0.setVisibility(z ? 0 : 8);
                if (z) {
                    TiebaStatic.log(N0("c13600"));
                }
            }
            if (this.a0 || this.b1 || !(this.P instanceof Activity)) {
                return;
            }
            if ((i2 & 128) > 0) {
                if (this.c1) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment2 = this.Y0;
                if (absVideoPbFragment2 == null || !absVideoPbFragment2.isStatusBarShowing()) {
                    c1();
                    UtilHelper.showStatusBar((Activity) this.P, this.Z0);
                }
                this.c1 = true;
                e.a().removeCallbacks(this.i1);
                e.a().postDelayed(this.i1, 3000L);
            } else if (this.c1 || ((absVideoPbFragment = this.Y0) != null && absVideoPbFragment.isStatusBarShowing())) {
                O0();
            }
        }
    }

    @Override // c.a.q0.o2.q.d, c.a.q0.o2.q.a
    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, c2Var) == null) || c2Var == null) {
            return;
        }
        this.X0 = c2Var.L();
        o oVar = new o();
        oVar.f23216a = "6";
        oVar.f23218c = c2Var.q1();
        oVar.f23219d = Long.toString(c2Var.T());
        oVar.f23220e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (c2Var.N1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.U0 = intExtra;
                if (intExtra == 0) {
                    this.U0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.V0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    oVar.k = this.V0;
                }
                oVar.f23224i = Integer.toString(this.U0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.W0 = stringExtra2;
                oVar.f23224i = stringExtra2;
            }
        }
        if (c2Var.o1() != null) {
            oVar.m = c2Var.o1().video_md5;
            oVar.p = String.valueOf(c2Var.o1().is_vertical);
        }
        G(oVar);
        this.R0 = false;
        if (this.T0.getData().q0()) {
            this.M0.setIsCountDownValid(true);
        } else {
            this.M0.setIsCountDownValid(false);
        }
        if (this.a0 && c2Var.o1() != null) {
            if (this.U != (c2Var.o1().is_vertical.intValue() == 1)) {
                X();
            }
        }
        super.setData(c2Var);
        a0(!this.U);
        if (c2Var.J() != null) {
            c2Var.J().setIsLike(c2Var.J().hadConcerned());
        }
        this.L0.setData(c2Var);
    }

    @Override // c.a.q0.o2.q.d, c.a.q0.o2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.L0.setUniqueId(bdUniqueId);
        }
    }

    @Override // c.a.q0.o2.q.d
    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (i2 == R.id.video_full_screen) {
                if (!isFullScreen()) {
                    TiebaStatic.log(new StatisticItem("c13598"));
                } else {
                    TiebaStatic.log(new StatisticItem("c13599"));
                }
            } else if (i2 == R.id.video_replay) {
                TiebaStatic.log(N0("c13602"));
            } else if (i2 == R.id.video_play) {
                TiebaStatic.log(new StatisticItem("c13597"));
            } else if (i2 == R.id.video_pause) {
                TiebaStatic.log(new StatisticItem("c13596"));
            } else if (i2 == R.id.video_next_layout) {
                TiebaStatic.log(N0("c13601").param("obj_type", this.M0.isManualFinish ? 1 : 2));
            }
        }
    }

    @Override // c.a.q0.o2.q.d
    public void x0() {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (oVar = this.b0) == null) {
            return;
        }
        o b2 = oVar.b();
        b2.f23216a = "pb";
        h.e(b2.m, "", "2", b2, this.u.getPcdnState());
    }
}
