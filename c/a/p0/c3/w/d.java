package c.a.p0.c3.w;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.c1.t0;
import c.a.p0.c3.h;
import c.a.p0.c3.o;
import c.a.p0.c3.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.operableVideoView.OperableVideoErrorView;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import com.baidu.tieba.play.operableVideoView.OperableVideoShareView;
import com.baidu.tieba.play.operableVideoView.PercentSizeView;
import com.baidu.tieba.play.operableVideoView.VideoGestureView;
import com.baidu.tieba.view.SwitchImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.kuaishou.weapon.un.w0;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes2.dex */
public class d implements c.a.p0.c3.w.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public c.a.x.c A0;
    public TextView B;
    public McnAdInfo B0;
    public TextView C;
    public boolean C0;
    public SwitchImageView D;
    public l D0;
    public SwitchImageView E;
    public long E0;
    public OperableVideoMediaControllerView F;
    public h.c F0;
    public OperableVideoNetworkStateTipView G;
    public CustomMessageListener G0;
    public OperableVideoShareView H;
    public SeekBar.OnSeekBarChangeListener H0;
    public ImageView I;
    public GestureDetector.SimpleOnGestureListener I0;
    public View J;
    public View.OnTouchListener J0;
    public VideoGestureView K;
    public TbVideoViewSet.b K0;
    public View L;
    public final CustomMessageListener L0;
    public OperableVideoErrorView M;
    public WeakReference<Context> N;
    public Context O;
    public View P;
    public ViewGroup Q;
    public BdUniqueId R;
    public boolean S;
    public boolean T;
    public String U;
    public String V;
    public long W;
    public c.a.p0.c3.l X;
    public boolean Y;
    public u Z;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13522b;

    /* renamed from: c  reason: collision with root package name */
    public int f13523c;

    /* renamed from: d  reason: collision with root package name */
    public int f13524d;

    /* renamed from: e  reason: collision with root package name */
    public int f13525e;

    /* renamed from: f  reason: collision with root package name */
    public int f13526f;

    /* renamed from: g  reason: collision with root package name */
    public int f13527g;
    public ThreadData g0;

    /* renamed from: h  reason: collision with root package name */
    public int f13528h;
    public String h0;
    public int i;
    public boolean i0;
    public int j;
    public boolean j0;
    public int k;
    public String k0;
    public int l;
    public boolean l0;
    public int m;
    public boolean m0;
    public int n;
    public float n0;
    public int o;
    public float o0;
    public int p;
    public GestureDetector p0;
    public int q;
    public int q0;
    public int r;
    public int[] r0;
    public Runnable s;
    public int s0;
    public TbVideoViewContainer t;
    public boolean t0;
    public TbImageView u;
    public int u0;
    public View v;
    public int v0;
    public TBLottieAnimationView w;
    public float w0;
    public ImageView x;
    public int x0;
    public ImageView y;
    public boolean y0;
    public PercentSizeView z;
    public View.OnClickListener z0;

    /* loaded from: classes2.dex */
    public class a implements TbVideoViewSet.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.m0) {
                    d dVar = this.a;
                    dVar.n0(dVar.o);
                    this.a.m0 = false;
                } else {
                    d dVar2 = this.a;
                    dVar2.n0(dVar2.f13522b);
                }
                this.a.r0();
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.t.a();
                this.a.p0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.a.stopPlay();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.a;
                dVar.n0(dVar.f13524d);
            }
        }
    }

    /* renamed from: c.a.p0.c3.w.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1017d implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public C1017d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.c3.h.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.E0 <= 0) {
                    this.a.E0 = i2;
                }
                if (this.a.g0()) {
                    d dVar = this.a;
                    if (!dVar.T && !dVar.Y && dVar.C0) {
                        if (c.a.x.b.b().a(this.a.B0.jump_url)) {
                            return;
                        }
                        long j = i2;
                        boolean z = j >= this.a.B0.ad_start_time.longValue() * 1000 && j < this.a.B0.ad_end_time.longValue() * 1000;
                        boolean z2 = this.a.E0 >= (this.a.B0.ad_start_time.longValue() * 1000) + 1000;
                        if (this.a.A0 == null) {
                            d dVar2 = this.a;
                            dVar2.A0 = new c.a.x.c(dVar2.O);
                        }
                        if (z) {
                            if (!this.a.A0.c()) {
                                c.a.x.a aVar = new c.a.x.a();
                                aVar.f21975b = this.a.B0.card_title;
                                aVar.f21976c = this.a.B0.button_title;
                                aVar.f21977d = this.a.B0.jump_url;
                                aVar.a = this.a.B0.pic_url;
                                aVar.f21979f = String.valueOf(this.a.W);
                                d dVar3 = this.a;
                                aVar.f21978e = dVar3.V;
                                aVar.f21980g = dVar3.a0();
                                if (z2) {
                                    this.a.A0.f(aVar, (ViewGroup) this.a.P);
                                } else {
                                    this.a.A0.e(aVar, (ViewGroup) this.a.P);
                                }
                            }
                        } else if (this.a.A0.c()) {
                            this.a.A0.a();
                        }
                    }
                }
                if (this.a.D0 != null) {
                    this.a.D0.a(i, i2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(0);
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

    /* loaded from: classes2.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && m.isEquals(this.a.U, (String) customResponsedMessage.getData()) && UbsABTestHelper.isFeedVideoImmersionTransition() && TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                this.a.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                TbSingleton.getInstance().setVideoCurrentFrame(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.N();
                if (!this.a.S) {
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
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
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
                this.a.Q.setScaleX(1.0f);
                this.a.Q.setScaleY(1.0f);
                this.a.Q.setTranslationX(0.0f);
                this.a.Q.setTranslationY(0.0f);
                this.a.H.setScaleX(1.0f);
                this.a.H.setScaleY(1.0f);
                this.a.Q.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                if (this.a.t0) {
                    return;
                }
                this.a.T();
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

    /* loaded from: classes2.dex */
    public class i implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                d dVar = this.a;
                dVar.n0(dVar.f13526f);
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e4f));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) || seekBar == null || seekBar.getProgress() >= seekBar.getMax()) {
                return;
            }
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e4e));
            if (!this.a.t.getControl().isPlaying()) {
                this.a.t.getControl().p(this.a.K0);
            }
            this.a.R();
            if (this.a.i0) {
                TiebaStatic.log(new StatisticItem("c13355").param("tid", this.a.V).param("fid", this.a.W).param("obj_type", this.a.T ? 1 : 2).param("obj_locate", this.a.Y ? 1 : 2));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        public final void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.u0 == i2 && this.a.v0 == i) {
                    return;
                }
                d dVar = this.a;
                dVar.t0 = dVar.u0 - i2 > 0 || ((float) i2) < this.a.n0 / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.Q.getLayoutParams();
                if (i2 != this.a.u0) {
                    int i3 = this.a.s0 - i2;
                    int i4 = (int) (i3 * this.a.w0);
                    if (i4 < this.a.x0) {
                        i4 = this.a.x0;
                        i3 = (int) (i4 / this.a.w0);
                    }
                    if (i4 != this.a.x0) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        this.a.Q.setLayoutParams(layoutParams);
                    }
                    this.a.u0 = i2;
                    d dVar2 = this.a;
                    dVar2.Q.setTranslationY(dVar2.u0);
                }
                if (i != this.a.u0) {
                    this.a.v0 = i;
                    d dVar3 = this.a;
                    dVar3.Q.setTranslationX(dVar3.v0 + ((this.a.o0 - layoutParams.width) / 2.0f));
                }
                this.a.L.setAlpha((layoutParams.width - this.a.x0) / (this.a.o0 - this.a.x0));
                if (this.a.H.getVisibility() == 0) {
                    float f2 = this.a.n0 / 6.0f;
                    float f3 = (f2 - i2) / f2;
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                    this.a.H.setAlpha(f3);
                }
            }
        }

        public final void b(float f2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (f2 > 0.0f) {
                    d dVar = this.a;
                    dVar.q0 -= 1000;
                    z = true;
                } else {
                    this.a.q0 += 1000;
                    z = false;
                }
                int duration = this.a.t.getControl().getDuration();
                if (this.a.q0 < 0) {
                    this.a.q0 = 0;
                } else if (this.a.q0 > duration) {
                    this.a.q0 = duration;
                }
                String str = StringHelper.stringForVideoTime(this.a.q0) + " / " + StringHelper.stringForVideoTime(duration);
                VideoGestureView videoGestureView = this.a.K;
                if (videoGestureView != null) {
                    videoGestureView.b(z, str);
                }
                d dVar2 = this.a;
                dVar2.F.setCurrentDuration(dVar2.q0, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.a.t.getControl().isPlaying()) {
                    this.a.t.getControl().pause();
                    d dVar = this.a;
                    if (dVar.p == dVar.f13526f) {
                        dVar.n0(dVar.f13527g);
                    } else {
                        dVar.n0(dVar.f13528h);
                    }
                    this.a.t0(R.id.obfuscated_res_0x7f092356);
                    return true;
                }
                d dVar2 = this.a;
                int i = dVar2.p;
                int i2 = dVar2.f13527g;
                if (i != i2 && i != (i2 | 1)) {
                    int i3 = dVar2.f13528h;
                    if (i == i3 || i == (i3 | 1)) {
                        d dVar3 = this.a;
                        dVar3.n0(dVar3.f13524d);
                        this.a.t.getControl().p(this.a.K0);
                        this.a.t0(R.id.obfuscated_res_0x7f092361);
                        return true;
                    }
                    return true;
                }
                d dVar4 = this.a;
                dVar4.n0(dVar4.f13526f);
                this.a.R();
                this.a.t.getControl().p(this.a.K0);
                this.a.t0(R.id.obfuscated_res_0x7f092361);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                this.a.q = 0;
                d dVar = this.a;
                if (dVar.Y) {
                    dVar.Q((Activity) dVar.O, true);
                }
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (!this.a.e0(motionEvent)) {
                    return super.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                Context context = this.a.O;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.a.O).disableSwipeJustOnce();
                } else {
                    Context context2 = this.a.O;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.a.O).disableSwipeJustOnce();
                    }
                }
                d dVar = this.a;
                if (dVar.T && dVar.f0()) {
                    int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                    int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                    int i3 = this.a.q;
                    if (i3 != 0) {
                        if (i3 == 4) {
                            a(rawX, rawY);
                        }
                    } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                        if (this.a.t.getControl().isPlaying()) {
                            this.a.t.getControl().pause();
                            d dVar2 = this.a;
                            dVar2.n0(dVar2.l);
                        }
                        this.a.q = 4;
                        d dVar3 = this.a;
                        dVar3.r = dVar3.p;
                        d dVar4 = this.a;
                        dVar4.p = dVar4.k;
                        dVar4.s0 = dVar4.Q.getMeasuredHeight();
                        d dVar5 = this.a;
                        dVar5.w0 = dVar5.o0 / this.a.s0;
                        d dVar6 = this.a;
                        dVar6.x0 = (int) (dVar6.P.getWidth() * 1.2f);
                        a(rawX, rawY);
                    }
                } else {
                    d dVar7 = this.a;
                    int i4 = dVar7.p;
                    if (i4 == dVar7.f13524d || i4 == dVar7.f13526f || i4 == (i = dVar7.f13527g) || i4 == (i2 = dVar7.f13528h) || i4 == dVar7.k || i4 == (i | 1) || i4 == (i2 | 1)) {
                        int i5 = this.a.q;
                        if (i5 == 0) {
                            if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                                this.a.q = 3;
                                d dVar8 = this.a;
                                dVar8.q0 = dVar8.t.getControl().getCurrentPosition();
                                b(f2);
                            } else if (motionEvent.getX() < this.a.Q.getWidth() / 2) {
                                this.a.q = 2;
                                d dVar9 = this.a;
                                dVar9.K.a(dVar9.O, f3 > 0.0f);
                            } else {
                                this.a.q = 1;
                                d dVar10 = this.a;
                                dVar10.K.c(dVar10.O, f3 > 0.0f);
                            }
                            d dVar11 = this.a;
                            int i6 = dVar11.p;
                            int i7 = dVar11.k;
                            if (i6 != i7) {
                                if ((i6 & 1) > 0) {
                                    dVar11.k = i7 | 1;
                                } else {
                                    dVar11.k = i7 & (-2);
                                }
                                d dVar12 = this.a;
                                dVar12.n0(dVar12.k);
                            }
                        } else if (i5 == 1) {
                            d dVar13 = this.a;
                            int i8 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                            dVar13.K.c(dVar13.O, i8 > 0);
                            if (i8 > 0) {
                                this.a.onVolumeUp();
                            }
                        } else if (i5 == 2) {
                            d dVar14 = this.a;
                            dVar14.K.a(dVar14.O, f3 > 0.0f);
                        } else if (i5 == 3) {
                            b(f2);
                        }
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                if (this.a.t.getControl().isPlaying()) {
                    d dVar = this.a;
                    int i = dVar.p;
                    int i2 = dVar.f13524d;
                    if (i != i2 && i != dVar.f13525e && i != dVar.n) {
                        if (i == dVar.f13526f) {
                            dVar.n0(i2);
                        }
                    } else {
                        d dVar2 = this.a;
                        dVar2.n0(dVar2.f13526f);
                        this.a.R();
                    }
                } else {
                    d dVar3 = this.a;
                    int i3 = dVar3.p;
                    int i4 = dVar3.f13527g;
                    if (i3 == i4) {
                        dVar3.n0(dVar3.f13528h);
                    } else if (i3 == (i4 | 1)) {
                        dVar3.n0(dVar3.f13528h | 1);
                    } else {
                        int i5 = dVar3.f13528h;
                        if (i3 == i5) {
                            dVar3.n0(i4);
                        } else if (i3 == (i5 | 1)) {
                            dVar3.n0(i4 | 1);
                        } else {
                            dVar3.n0(dVar3.f13522b);
                            this.a.startPlay();
                            this.a.k0();
                        }
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    d dVar = this.a;
                    if (dVar.p == dVar.k) {
                        if (dVar.q == 4) {
                            this.a.S();
                            this.a.u0 = 0;
                            this.a.v0 = 0;
                        } else {
                            d dVar2 = this.a;
                            dVar2.p = -1;
                            if (dVar2.q != 3) {
                                if (this.a.r != -1) {
                                    d dVar3 = this.a;
                                    dVar3.n0(dVar3.r);
                                    this.a.r = -1;
                                } else if (this.a.t.getControl().isPlaying()) {
                                    d dVar4 = this.a;
                                    dVar4.n0(dVar4.f13524d);
                                } else {
                                    d dVar5 = this.a;
                                    dVar5.n0(dVar5.f13527g);
                                }
                            } else {
                                d dVar6 = this.a;
                                dVar6.F.setCurrentDuration(dVar6.q0, true);
                                if (this.a.q0 <= this.a.t.getControl().getDuration()) {
                                    if (!this.a.t.getControl().isPlaying()) {
                                        this.a.t.getControl().p(this.a.K0);
                                    }
                                    d dVar7 = this.a;
                                    dVar7.n0(dVar7.f13524d);
                                }
                            }
                        }
                        d dVar8 = this.a;
                        if (dVar8.i0) {
                            String str = null;
                            if (dVar8.q == 1) {
                                str = "c13361";
                            } else if (this.a.q == 2) {
                                str = "c13346";
                            } else if (this.a.q == 3) {
                                str = "c13362";
                            }
                            if (!m.isEmpty(str)) {
                                TiebaStatic.log(new StatisticItem(str).param("tid", this.a.V).param("fid", this.a.W));
                            }
                        }
                        this.a.q = 0;
                        return true;
                    }
                }
                return this.a.p0.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface l {
        void a(int i, int i2);
    }

    public d(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3000;
        this.f13522b = 8211;
        this.f13523c = 19;
        this.f13524d = 0;
        this.f13525e = 4;
        this.f13526f = w0.c1;
        this.f13527g = 8416;
        this.f13528h = 0;
        this.i = 513;
        this.j = ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256;
        this.k = 2048;
        this.l = 0;
        this.m = 4099;
        this.n = 0;
        this.o = 1;
        this.p = 8211;
        this.q = 0;
        this.r = -1;
        this.s = new c(this);
        this.N = null;
        this.Y = false;
        this.i0 = true;
        this.j0 = false;
        this.l0 = true;
        this.m0 = false;
        this.r0 = new int[2];
        this.u0 = 0;
        this.v0 = 0;
        this.y0 = false;
        this.z0 = null;
        this.C0 = false;
        this.E0 = -1L;
        this.F0 = new C1017d(this);
        this.G0 = new f(this, 2921679);
        this.H0 = new i(this);
        this.I0 = new j(this);
        this.J0 = new k(this);
        this.K0 = new a(this);
        this.L0 = new b(this, 2000994);
        if (context == null || view == null) {
            return;
        }
        this.O = context;
        this.X = new c.a.p0.c3.l((Activity) context);
        this.P = view;
        this.n0 = n.i(this.O);
        this.o0 = n.k(this.O);
        c0();
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.p;
            if (i2 == this.f13525e || i2 == this.n) {
                n0(this.f13524d);
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.T && !"video_tab".equals(this.h0)) {
                this.f13526f = 104;
                this.f13527g = 8290;
            } else {
                this.f13526f = w0.c1;
                this.f13527g = 8418;
            }
            if (this.Y) {
                this.f13522b |= 1024;
                this.o |= 8192;
                this.f13524d |= 1024;
                this.f13525e |= 1024;
                this.n |= 1024;
                this.f13526f |= 1024;
                this.f13527g |= 1024;
                this.f13528h |= 1024;
                this.i |= 1024;
                this.j |= 1024;
                this.p |= 1024;
                return;
            }
            this.f13522b &= -1025;
            this.o &= -1025;
            this.f13524d &= -1025;
            this.f13525e &= -1025;
            this.n &= -1025;
            this.f13526f &= -1025;
            this.f13527g &= -1025;
            this.f13528h &= -1025;
            this.i &= -1025;
            this.j &= -1025;
            this.p &= -1025;
        }
    }

    public void P() {
        float dimension;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.G.a(this.T, this.Y);
            this.H.e(this.T, this.Y);
            Context context = this.O;
            if (context == null || context.getResources() == null) {
                return;
            }
            if (this.T) {
                dimension = this.O.getResources().getDimension(R.dimen.tbds44);
            } else if (this.Y) {
                dimension = this.O.getResources().getDimension(R.dimen.tbds78);
            } else {
                dimension = this.O.getResources().getDimension(R.dimen.tbds44);
            }
            int i2 = (int) dimension;
            this.A.setPadding(0, 0, "video_tab".equals(this.h0) ? 0 : i2, 0);
            SwitchImageView switchImageView = this.E;
            switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i2, 0);
            this.D.setPadding(i2, 0, 0, 0);
        }
    }

    public final void Q(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, activity, z) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (this.T && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
            ViewGroup viewGroup = this.Q;
            if (viewGroup == null) {
                return;
            }
            if (z) {
                viewGroup.setPadding(0, n.r((Activity) this.O), 0, 0);
            } else {
                viewGroup.setPadding(0, 0, 0, 0);
            }
        } else if (z) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags |= 1024;
            activity.getWindow().setAttributes(attributes);
            o0();
        } else {
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.Q.setSystemUiVisibility(0);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.s);
            c.a.d.f.m.e.a().postDelayed(this.s, this.a);
        }
    }

    public final void S() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!this.T) {
                T();
            } else if (this.p == this.k) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.addListener(new h(this));
                if (!this.t0) {
                    float width = this.P.getWidth() / this.Q.getWidth();
                    float height = this.P.getHeight() / this.Q.getHeight();
                    this.Q.setPivotX(0.0f);
                    this.Q.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.Q, "ScaleX", 1.0f, width);
                    objectAnimator = ObjectAnimator.ofFloat(this.Q, "ScaleY", 1.0f, height);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.H, "ScaleX", 1.0f, 1.0f / width);
                    ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.H, "ScaleY", 1.0f, 1.0f / height);
                    ViewGroup viewGroup = this.Q;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.r0[0]);
                    ViewGroup viewGroup2 = this.Q;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.r0[1]);
                    View view = this.L;
                    ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, view.getAlpha(), 0.0f);
                    OperableVideoShareView operableVideoShareView = this.H;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, AnimationProperty.OPACITY, operableVideoShareView.getAlpha(), 0.0f);
                    ofFloat2 = ofFloat7;
                    objectAnimator2 = ofFloat9;
                    ofFloat3 = ofFloat8;
                } else {
                    float width2 = this.o0 / this.Q.getWidth();
                    float height2 = this.s0 / this.Q.getHeight();
                    this.Q.setPivotX(0.0f);
                    this.Q.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.Q, "ScaleX", 1.0f, width2);
                    ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.Q, "ScaleY", 1.0f, height2);
                    ofFloat2 = ObjectAnimator.ofFloat(this.H, "ScaleX", 1.0f, 1.0f / width2);
                    ofFloat3 = ObjectAnimator.ofFloat(this.H, "ScaleY", 1.0f, 1.0f / height2);
                    ViewGroup viewGroup3 = this.Q;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup3, "TranslationX", viewGroup3.getTranslationX(), 0.0f);
                    ViewGroup viewGroup4 = this.Q;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup4, "TranslationY", viewGroup4.getTranslationY(), 0.0f);
                    OperableVideoShareView operableVideoShareView2 = this.H;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView2, AnimationProperty.OPACITY, operableVideoShareView2.getAlpha(), 1.0f);
                    objectAnimator = ofFloat10;
                    objectAnimator2 = null;
                }
                if (objectAnimator2 != null) {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(objectAnimator2).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                } else {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                }
                animatorSet.start();
                int i2 = this.r;
                if (i2 != -1) {
                    this.p = i2;
                    this.r = -1;
                    if (i2 == this.l || i2 == this.f13526f || i2 == this.f13524d) {
                        this.t.getControl().p(this.K0);
                        n0(this.f13524d);
                    }
                }
            } else {
                T();
            }
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            U(true);
        }
    }

    public void U(boolean z) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.P == null || this.Q == null || (tbVideoViewContainer = this.t) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        Context context = this.O;
        if (context != null) {
            n.w(context, this.P);
        }
        if (this.Y) {
            if (this.L.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.L.getParent()).removeView(this.L);
            }
            if ((this.Q.getParent() instanceof ViewGroup) && (this.P instanceof ViewGroup)) {
                this.Y = false;
                this.j0 = true;
                ((ViewGroup) this.Q.getParent()).removeView(this.Q);
                ((ViewGroup) this.P).addView(this.Q);
                this.j0 = false;
                Q((Activity) this.O, this.Y);
            }
            if (!this.T && z) {
                this.X.l();
            }
        } else {
            if (this.O != null) {
                if (!this.T && z) {
                    this.X.l();
                }
                if (this.O instanceof Activity) {
                    this.Q.getLocationOnScreen(this.r0);
                    View findViewById = ((Activity) this.O).findViewById(16908290);
                    if (findViewById instanceof ViewGroup) {
                        View childAt = ((ViewGroup) findViewById).getChildAt(0);
                        if (childAt instanceof ViewGroup) {
                            this.j0 = true;
                            ((ViewGroup) this.P).removeAllViews();
                            if (this.L == null) {
                                View view = new View(this.O);
                                this.L = view;
                                view.setClickable(true);
                                this.L.setBackgroundColor(SkinManager.getColor(R.color.black_alpha100));
                                this.L.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            }
                            if (this.L.getParent() instanceof ViewGroup) {
                                ((ViewGroup) this.L.getParent()).removeView(this.L);
                            }
                            this.L.setAlpha(1.0f);
                            ViewGroup viewGroup = (ViewGroup) childAt;
                            viewGroup.addView(this.L);
                            viewGroup.addView(this.Q);
                            this.j0 = false;
                            this.Y = true;
                            Q((Activity) this.O, true);
                            c.a.x.c cVar = this.A0;
                            if (cVar != null && cVar.c()) {
                                this.A0.a();
                            }
                        }
                    }
                }
            }
            if (this.i0) {
                TiebaStatic.log(new StatisticItem("c13360").param("tid", this.V).param("fid", this.W).param("obj_type", this.T ? 1 : 2));
            }
        }
        O();
        P();
        if (this.t.getControl().isPlaying()) {
            n0(this.f13524d);
        } else {
            n0(this.p);
        }
        this.E.g();
        i0(this.Y);
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
            if (isVideoCardMute) {
                this.t.getControl().setVolume(1.0f, 1.0f);
                t0.f(this.N, true);
                c.a.o0.i0.g.c.b().l(true);
                this.D.setState(0);
            } else {
                this.t.getControl().setVolume(0.0f, 0.0f);
                this.D.setState(1);
                t0.f(this.N, false);
                c.a.o0.i0.g.c.b().l(false);
            }
            TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.X.i(true);
            } else {
                this.X.i(false);
            }
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.X.j();
            } else {
                this.X.k();
            }
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.F.p();
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.clearAnimation();
                this.w.animate().alpha(0.0f).setDuration(200L).setListener(new g(this)).start();
            }
        }
    }

    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.obfuscated_res_0x7f0d064c : invokeV.intValue;
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    public void c0() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (context = this.O) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(Z(), (ViewGroup) null);
        this.Q = viewGroup;
        View view = this.P;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).addView(viewGroup);
        }
        this.N = new WeakReference<>(TbadkCoreApplication.getInst());
        this.u = (TbImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092392);
        this.v = this.Q.findViewById(R.id.obfuscated_res_0x7f090382);
        this.w = (TBLottieAnimationView) this.Q.findViewById(R.id.obfuscated_res_0x7f092340);
        this.x = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092361);
        this.z = (PercentSizeView) this.Q.findViewById(R.id.obfuscated_res_0x7f092345);
        this.y = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092356);
        this.A = (TextView) this.Q.findViewById(R.id.obfuscated_res_0x7f092363);
        this.B = (TextView) this.Q.findViewById(R.id.obfuscated_res_0x7f092365);
        this.C = (TextView) this.Q.findViewById(R.id.obfuscated_res_0x7f092323);
        this.D = (SwitchImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f09234c);
        this.E = (SwitchImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092328);
        this.F = (OperableVideoMediaControllerView) this.Q.findViewById(R.id.obfuscated_res_0x7f092344);
        this.G = (OperableVideoNetworkStateTipView) this.Q.findViewById(R.id.obfuscated_res_0x7f09234e);
        this.H = (OperableVideoShareView) this.Q.findViewById(R.id.obfuscated_res_0x7f092377);
        this.J = this.Q.findViewById(R.id.obfuscated_res_0x7f092313);
        this.I = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092329);
        this.K = (VideoGestureView) this.Q.findViewById(R.id.obfuscated_res_0x7f09232b);
        this.M = (OperableVideoErrorView) this.Q.findViewById(R.id.obfuscated_res_0x7f092325);
        this.H.setVideoContainer(this);
        this.w.addAnimatorListener(new e(this));
        this.w.setAnimation(R.raw.obfuscated_res_0x7f110017);
        this.x.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.x.setOnClickListener(this);
        this.D.setSvgStateImage(new SvgPureType(R.drawable.obfuscated_res_0x7f080634, R.color.CAM_X0101), new SvgPureType(R.drawable.obfuscated_res_0x7f080632, R.color.CAM_X0101));
        this.D.setState(1);
        this.D.setOnClickListener(this);
        this.u.s();
        this.u.setDrawCorner(false);
        this.u.setPlaceHolder(3);
        HomeGroupUbsUIHelper.handleImgMask(this.v, R.color.CAM_X0601);
        this.F.setOnSeekBarChangeListener(this.H0);
        this.z.setHeightPercent(0.583f);
        this.z.setBackgroundResource(R.drawable.obfuscated_res_0x7f081236);
        this.E.setSvgStateImage(new SvgPureType(R.drawable.obfuscated_res_0x7f08062b, R.color.CAM_X0101), new SvgPureType(R.drawable.obfuscated_res_0x7f080633, R.color.CAM_X0101));
        this.E.setState(0);
        this.E.setOnClickListener(this);
        this.y.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809dd, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.y.setOnClickListener(this);
        this.I.setOnClickListener(this);
        TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.O);
        this.t = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setTryUseViewInSet(true);
        p0();
        this.G.setPlayViewOnClickListener(this);
        this.Q.setOnClickListener(null);
        this.Q.setOnTouchListener(this.J0);
        this.H.setOnTouchListener(this.J0);
        this.M.setOutOnClickListener(this);
        this.p0 = new GestureDetector(this.O, this.I0);
        n0(this.f13522b);
        c.a.o0.r.v.c.d(this.v).s(R.array.Mask_X003);
        c.a.o0.r.v.c.d(this.A).y(R.array.S_O_X001);
        c.a.o0.r.v.c.d(this.C).y(R.array.S_O_X001);
        if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
            Context context2 = this.O;
            if (context2 instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context2).registerListener(this.G0);
            }
        }
    }

    @Override // c.a.p0.c3.w.a
    public void changeRenderViewMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.t.getControl().changeRenderViewMode(i2);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (TbSingleton.getInstance().isVideoCardMute()) {
                this.t.getControl().setVolume(0.0f, 0.0f);
                this.D.setState(1);
                return;
            }
            this.t.getControl().setVolume(1.0f, 1.0f);
            this.D.setState(0);
            c.a.o0.i0.g.c.b().l(true);
        }
    }

    public boolean e0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) ? this.Y : invokeL.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.T && this.Y : invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.B0 != null : invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.w.a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.t.getControl().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.p0.c3.w.a
    public View getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.Q : (View) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (UbsABTestHelper.isVideoTabAutoPlay() && "video_tab".equals(this.h0)) {
                return c.a.d.f.p.l.x();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.G;
            return operableVideoNetworkStateTipView != null && operableVideoNetworkStateTipView.d();
        }
        return invokeV.booleanValue;
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
        }
    }

    @Override // c.a.p0.c3.w.a
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.Y : invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.w.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.S || this.t.getControl().isPlaying() : invokeV.booleanValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.s);
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.U);
            CustomMessage customMessage = new CustomMessage(2921387);
            customMessage.setTag(this.R);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.C0 = z;
        }
    }

    public void m0(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, lVar) == null) {
            this.D0 = lVar;
        }
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            j0();
            if (this.p == this.k) {
                this.r = i2;
                return;
            }
            this.p = i2;
            this.u.setVisibility((i2 & 1) > 0 ? 0 : 8);
            this.v.setVisibility((i2 & 2) > 0 ? 0 : 8);
            this.l0 = (i2 & 4) > 0;
            this.w.clearAnimation();
            this.w.setVisibility(this.l0 ? 0 : 8);
            if (!this.l0) {
                this.w.cancelAnimation();
            } else {
                this.w.setAlpha(1.0f);
            }
            this.x.setVisibility((i2 & 8192) > 0 ? 0 : 8);
            this.y.setVisibility((i2 & 8) > 0 ? 0 : 8);
            int i3 = i2 & 16;
            this.A.setVisibility(i3 > 0 ? 0 : 8);
            this.C.setVisibility(i3 > 0 ? 0 : 8);
            this.D.setVisibility((i2 & 32) > 0 ? 0 : 8);
            this.E.setVisibility((i2 & 64) > 0 ? 0 : 8);
            int i4 = i2 & 128;
            this.F.setVisibility(i4 > 0 ? 0 : 8);
            this.z.setVisibility(i4 > 0 ? 0 : 8);
            if (this.F.getVisibility() == 0) {
                this.F.p();
            }
            this.G.setVisibility((i2 & 256) > 0 ? 0 : 8);
            this.H.setVisibility((i2 & 512) > 0 ? 0 : 8);
            if (this.H.getVisibility() == 0) {
                this.H.setAlpha(1.0f);
            }
            int i5 = i2 & 1024;
            this.I.setVisibility(i5 > 0 ? 0 : 8);
            this.J.setVisibility(i5 > 0 ? 0 : 8);
            this.K.setVisibility((i2 & 2048) > 0 ? 0 : 8);
            this.M.setVisibility((i2 & 4096) <= 0 ? 8 : 0);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.Q.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.Q.setSystemUiVisibility(4);
            } else {
                this.Q.setSystemUiVisibility(5894);
            }
        }
    }

    @Override // c.a.p0.c3.w.a
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.Y) {
                S();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.w.a
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
            if (z) {
                this.y0 = isPlaying();
                this.w.cancelAnimation();
                int i2 = this.p;
                if (i2 == this.f13524d || i2 == this.f13525e || i2 == this.f13526f || i2 == this.f13522b || i2 == this.n || i2 == this.o || i2 == this.f13523c) {
                    stopPlay();
                }
                int i3 = this.p | 1;
                this.p = i3;
                int i4 = i3 & (-8193);
                this.p = i4;
                n0(i4);
            } else {
                int i5 = this.p;
                if (i5 == this.f13522b || i5 == this.f13523c || i5 == this.o) {
                    if (this.y0) {
                        startPlay();
                        k0();
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        t0(id);
        if (id == R.id.obfuscated_res_0x7f09234c) {
            V();
        } else if (id == R.id.obfuscated_res_0x7f092328 || id == R.id.obfuscated_res_0x7f092329) {
            S();
        } else {
            if (id == R.id.obfuscated_res_0x7f092371) {
                n0(this.f13522b);
                startPlay();
                if (this.i0) {
                    TiebaStatic.log(new StatisticItem("c13345").param("tid", this.V).param("fid", this.W).param("obj_type", this.T ? 1 : 2).param("obj_locate", this.Y ? 1 : 2));
                }
                k0();
            } else if (id == R.id.obfuscated_res_0x7f092361) {
                int i2 = this.p;
                if (i2 != this.f13522b && i2 != this.f13523c && i2 != this.o) {
                    n0(this.f13526f);
                    R();
                    this.t.getControl().p(this.K0);
                } else {
                    startPlay();
                }
                if (this.i0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.V).param("fid", this.W).param("obj_type", this.T ? 1 : 2).param("obj_source", this.Y ? 1 : 2).param("obj_locate", 1));
                }
                k0();
            } else if (id == R.id.obfuscated_res_0x7f092356) {
                n0(this.f13527g);
                j0();
                this.t.getControl().pause();
                if (this.i0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.V).param("fid", this.W).param("obj_type", this.T ? 1 : 2).param("obj_source", this.Y ? 1 : 2).param("obj_locate", 2));
                }
            } else if (id == R.id.obfuscated_res_0x7f091853) {
                n0(this.f13522b);
                startPlay();
            } else if (id == R.id.obfuscated_res_0x7f091a78) {
                n0(this.f13522b);
                startPlay();
            }
        }
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            n0(this.i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048613, this, i2, i3, obj)) == null) {
            n0(this.m);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048614, this, i2, i3, obj)) == null) {
            if (i2 == 3 || i2 == 904) {
                if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    s0();
                } else {
                    q0();
                }
            }
            if (i2 == 701) {
                this.l0 = true;
                r0();
                return false;
            } else if (i2 == 702) {
                s0();
                return false;
            } else {
                return false;
            }
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            d0();
            if (this.S) {
                if (this.Y) {
                    Context context = this.O;
                    if (context instanceof Activity) {
                        Q((Activity) context, true);
                    }
                }
                this.t.getControl().p(this.K0);
            }
        }
    }

    @Override // c.a.p0.c3.w.a
    public void onScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || this.j0) {
            return;
        }
        int i2 = this.p;
        if (i2 != this.f13527g && (i2 != this.f13528h || this.t.getControl().isPlaying())) {
            if (this.p == this.i) {
                v0();
                n0(this.i);
                return;
            }
            v0();
            return;
        }
        v0();
        n0(this.f13527g);
    }

    @Override // c.a.p0.c3.w.a
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (TbSingleton.getInstance().isVideoCardMute() && this.t.getControl().isPlaying() && !t0.c() && !c.a.o0.i0.g.c.b().j()) {
                this.t.getControl().setVolume(1.0f, 1.0f);
                this.D.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void p0() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.Q.addView(this.t, 0);
            this.t.setLayoutParams(layoutParams);
            this.F.setPlayer(this.t.getControl());
            this.t.getControl().setContinuePlayEnable(true);
            this.t.getControl().setOperableVideoContainer(this);
            this.t.getControl().setOnSurfaceDestroyedListener(this);
            this.t.getControl().setVideoStatData(this.Z);
            this.t.getControl().setThreadDataForStatistic(this.g0);
            this.t.getControl().getMediaProgressObserver().j(this.F0);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            n0(this.f13525e);
            this.l0 = true;
            this.F.p();
            Y();
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.l0) {
                this.w.setAlpha(1.0f);
                this.w.setVisibility(0);
                this.x.setVisibility(8);
            } else {
                this.w.setVisibility(8);
                this.x.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView == null || !this.l0) {
                return;
            }
            tBLottieAnimationView.loop(true);
            this.w.setMinAndMaxFrame(14, 80);
            this.w.playAnimation();
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            n0(this.n);
            this.F.p();
            Y();
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onClickListener) == null) {
            this.z0 = onClickListener;
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null) {
            return;
        }
        this.E0 = -1L;
        c.a.x.c cVar = this.A0;
        if (cVar != null) {
            cVar.d();
        }
        if (StringHelper.equals(this.U, threadData.getThreadVideoInfo().video_url)) {
            return;
        }
        stopPlay();
        this.T = threadData.getThreadVideoInfo().is_vertical.intValue() == 1;
        this.U = threadData.getThreadVideoInfo().video_url;
        this.V = threadData.getTid();
        threadData.getThreadVideoInfo().video_length.intValue();
        threadData.getThreadVideoInfo().video_duration.intValue();
        this.W = threadData.getFid();
        this.B0 = threadData.getThreadVideoInfo().mcn_ad_card;
        O();
        P();
        n0(this.f13522b);
        int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
        this.F.j(intValue);
        this.F.setPlayer(this.t.getControl());
        this.C.setText(StringHelper.stringForVideoTime(intValue));
        this.A.setText(String.format(this.O.getResources().getString(R.string.obfuscated_res_0x7f0f0e4b), StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue())));
        this.G.setVideoLength(threadData.getThreadVideoInfo().video_length.intValue());
        this.G.setVideoDuration(threadData.getThreadVideoInfo().video_duration.intValue());
        this.G.setTid(this.V);
        this.g0 = threadData;
        this.t.getControl().setThreadDataForStatistic(threadData);
        this.B.setVisibility(8);
        this.u.setPlaceHolder(3);
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() != 2 && TbadkCoreApplication.getInst().getVideoAutoPlay() != 0) {
            this.u.J(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
        } else {
            this.u.setImageBitmap(null);
            if (!m.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                this.u.J(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
            } else {
                this.u.J(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            }
        }
        this.H.setShareData(threadData);
    }

    @Override // c.a.p0.c3.w.a
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.h0 = str;
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, onClickListener) == null) {
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.k0 = str;
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setStatistic(u uVar) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, uVar) == null) || (tbVideoViewContainer = this.t) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.Z = uVar;
        this.t.getControl().setVideoStatData(uVar);
    }

    @Override // c.a.p0.c3.w.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, bdUniqueId) == null) {
            this.R = bdUniqueId;
        }
    }

    @Override // c.a.p0.c3.w.a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || StringUtils.isNull(this.U)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.L0);
        if (h0()) {
            n0(this.j);
            return;
        }
        this.S = true;
        if (this.t.getControl().isPlaying()) {
            return;
        }
        TbVideoViewContainer c2 = TbVideoViewSet.b().c(this.U);
        if (c2 == null) {
            this.t.a();
            if (!StringUtils.isNull(this.t.getControl().getOriginUrl()) || UbsABTestHelper.isFeedVideoImmersionTransition()) {
                TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.O);
                this.t = tbVideoViewContainer;
                tbVideoViewContainer.getControl().setTryUseViewInSet(true);
            }
            p0();
            if (c.a.d.f.p.l.z()) {
                this.t.getControl().setVideoPath(this.U, this.V);
                this.t.getControl().setStageType(this.k0);
                if (!UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    this.l0 = true;
                }
                r0();
                if (this.i0) {
                    u0();
                }
            }
        } else {
            TbVideoViewContainer tbVideoViewContainer2 = this.t;
            if (tbVideoViewContainer2 == c2) {
                tbVideoViewContainer2.a();
                p0();
            } else {
                if (UbsABTestHelper.isFeedVideoImmersionTransition() && (TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() || TbSingleton.getInstance().getIsJumpFromVideoMiddleView().booleanValue())) {
                    this.t = new TbVideoViewContainer(this.O);
                    TbVideoViewSet.b().e(this.t, this.U);
                    this.m0 = true;
                    TbSingleton.getInstance().setIsJumpFromVideoMiddleView(false);
                } else {
                    this.t.a();
                    c2.a();
                    this.t = c2;
                }
                this.t.getControl().setTryUseViewInSet(true);
                p0();
                if (TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                    this.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                    TbSingleton.getInstance().setVideoCurrentFrame(null);
                }
            }
            this.t.getControl().o();
            onPrepared();
            if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                s0();
            } else {
                q0();
            }
            if (this.i0) {
                u0();
            }
        }
        if (this.i0) {
            TiebaStatic.log(new StatisticItem("c13357").param("tid", this.V).param("fid", this.W).param("obj_type", this.T ? 1 : 2).param("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // c.a.p0.c3.w.a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.S = false;
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.t.getControl().stop();
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && TbSingleton.getInstance().getIsNeedReuseVideoPlayer() && !TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && this.U != null && (this.t.getControl() instanceof TbVideoView) && (this.t.getControl().getPlayer() instanceof o)) {
                ((TbVideoView) this.t.getControl()).M();
                if (this.u != null && TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                    this.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                    TbSingleton.getInstance().setVideoCurrentFrame(null);
                }
                ((o) this.t.getControl().getPlayer()).detachKLayerToCache("video_reuse_player");
                this.m0 = true;
            }
            this.t.a();
            this.F.n();
            if (this.m0) {
                n0(this.o);
                this.m0 = false;
            } else {
                n0(this.f13522b);
            }
            MessageManager.getInstance().unRegisterListener(this.L0);
        }
    }

    public void t0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
        }
    }

    public void u0() {
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (uVar = this.Z) == null) {
            return;
        }
        u b2 = uVar.b();
        b2.a = this.h0;
        c.a.p0.c3.j.e(b2.m, "", "1", b2, this.t.getControl().getPcdnState());
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.S = false;
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.t.getControl().stop();
            this.F.n();
            n0(this.f13522b);
            MessageManager.getInstance().unRegisterListener(this.L0);
        }
    }
}
