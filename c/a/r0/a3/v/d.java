package c.a.r0.a3.v;

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
import c.a.q0.c1.t0;
import c.a.q0.r.r.e2;
import c.a.r0.a3.h;
import c.a.r0.a3.l;
import c.a.r0.a3.o;
import c.a.r0.a3.t;
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
import com.kuaishou.weapon.un.w0;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes2.dex */
public class d implements c.a.r0.a3.v.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public boolean A0;
    public ImageView B;
    public View.OnClickListener B0;
    public PercentSizeView C;
    public c.a.y.c C0;
    public TextView D;
    public McnAdInfo D0;
    public TextView E;
    public boolean E0;
    public TextView F;
    public k F0;
    public SwitchImageView G;
    public long G0;
    public SwitchImageView H;
    public h.c H0;
    public OperableVideoMediaControllerView I;
    public SeekBar.OnSeekBarChangeListener I0;
    public OperableVideoNetworkStateTipView J;
    public GestureDetector.SimpleOnGestureListener J0;
    public OperableVideoShareView K;
    public View.OnTouchListener K0;
    public ImageView L;
    public TbVideoViewSet.b L0;
    public View M;
    public final CustomMessageListener M0;
    public VideoGestureView N;
    public View O;
    public OperableVideoErrorView P;
    public WeakReference<Context> Q;
    public Context R;
    public View S;
    public ViewGroup T;
    public BdUniqueId U;
    public boolean V;
    public boolean W;
    public String X;
    public String Y;
    public long Z;
    public l a0;
    public boolean b0;
    public t c0;
    public e2 d0;

    /* renamed from: e  reason: collision with root package name */
    public int f14960e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public int f14961f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public int f14962g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public int f14963h;
    public String h0;

    /* renamed from: i  reason: collision with root package name */
    public int f14964i;
    public boolean i0;

    /* renamed from: j  reason: collision with root package name */
    public int f14965j;
    public int k;
    public float k0;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public float q0;
    public int r;
    public GestureDetector r0;
    public int s;
    public int s0;
    public int t;
    public int[] t0;
    public int u;
    public int u0;
    public Runnable v;
    public boolean v0;
    public TbVideoViewContainer w;
    public int w0;
    public TbImageView x;
    public int x0;
    public View y;
    public float y0;
    public TBLottieAnimationView z;
    public int z0;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14966e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14966e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f14966e;
                dVar.l0(dVar.f14963h);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14967e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14967e = dVar;
        }

        @Override // c.a.r0.a3.h.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f14967e.G0 <= 0) {
                    this.f14967e.G0 = i3;
                }
                if (this.f14967e.e0()) {
                    d dVar = this.f14967e;
                    if (!dVar.W && !dVar.b0 && dVar.E0) {
                        if (c.a.y.b.b().a(this.f14967e.D0.jump_url)) {
                            return;
                        }
                        long j2 = i3;
                        boolean z = j2 >= this.f14967e.D0.ad_start_time.longValue() * 1000 && j2 < this.f14967e.D0.ad_end_time.longValue() * 1000;
                        boolean z2 = this.f14967e.G0 >= (this.f14967e.D0.ad_start_time.longValue() * 1000) + 1000;
                        if (this.f14967e.C0 == null) {
                            d dVar2 = this.f14967e;
                            dVar2.C0 = new c.a.y.c(dVar2.R);
                        }
                        if (z) {
                            if (!this.f14967e.C0.c()) {
                                c.a.y.a aVar = new c.a.y.a();
                                aVar.f26578b = this.f14967e.D0.card_title;
                                aVar.f26579c = this.f14967e.D0.button_title;
                                aVar.f26580d = this.f14967e.D0.jump_url;
                                aVar.a = this.f14967e.D0.pic_url;
                                aVar.f26582f = String.valueOf(this.f14967e.Z);
                                d dVar3 = this.f14967e;
                                aVar.f26581e = dVar3.Y;
                                aVar.f26583g = dVar3.Y();
                                if (z2) {
                                    this.f14967e.C0.f(aVar, (ViewGroup) this.f14967e.S);
                                } else {
                                    this.f14967e.C0.e(aVar, (ViewGroup) this.f14967e.S);
                                }
                            }
                        } else if (this.f14967e.C0.c()) {
                            this.f14967e.C0.a();
                        }
                    }
                }
                if (this.f14967e.F0 != null) {
                    this.f14967e.F0.a(i2, i3);
                }
            }
        }
    }

    /* renamed from: c.a.r0.a3.v.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0957d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14968e;

        public C0957d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14968e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f14968e.z.setVisibility(8);
                this.f14968e.A.setVisibility(0);
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
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14969e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14969e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f14969e.z.setVisibility(8);
                this.f14969e.A.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f14969e.L();
                if (!this.f14969e.V) {
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
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14970e;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14970e = dVar;
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
                this.f14970e.T.setScaleX(1.0f);
                this.f14970e.T.setScaleY(1.0f);
                this.f14970e.T.setTranslationX(0.0f);
                this.f14970e.T.setTranslationY(0.0f);
                this.f14970e.K.setScaleX(1.0f);
                this.f14970e.K.setScaleY(1.0f);
                this.f14970e.T.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                if (this.f14970e.v0) {
                    return;
                }
                this.f14970e.R();
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
    public class g implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14971e;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14971e = dVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                d dVar = this.f14971e;
                dVar.l0(dVar.f14965j);
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) || seekBar == null || seekBar.getProgress() >= seekBar.getMax()) {
                return;
            }
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
            if (!this.f14971e.w.getControl().isPlaying()) {
                this.f14971e.w.getControl().start(this.f14971e.L0);
            }
            this.f14971e.P();
            if (this.f14971e.f0) {
                TiebaStatic.log(new StatisticItem("c13355").param("tid", this.f14971e.Y).param("fid", this.f14971e.Z).param("obj_type", this.f14971e.W ? 1 : 2).param("obj_locate", this.f14971e.b0 ? 1 : 2));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14972e;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14972e = dVar;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f14972e.w0 == i3 && this.f14972e.x0 == i2) {
                    return;
                }
                d dVar = this.f14972e;
                dVar.v0 = dVar.w0 - i3 > 0 || ((float) i3) < this.f14972e.k0 / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14972e.T.getLayoutParams();
                if (i3 != this.f14972e.w0) {
                    int i4 = this.f14972e.u0 - i3;
                    int i5 = (int) (i4 * this.f14972e.y0);
                    if (i5 < this.f14972e.z0) {
                        i5 = this.f14972e.z0;
                        i4 = (int) (i5 / this.f14972e.y0);
                    }
                    if (i5 != this.f14972e.z0) {
                        layoutParams.height = i4;
                        layoutParams.width = i5;
                        this.f14972e.T.setLayoutParams(layoutParams);
                    }
                    this.f14972e.w0 = i3;
                    d dVar2 = this.f14972e;
                    dVar2.T.setTranslationY(dVar2.w0);
                }
                if (i2 != this.f14972e.w0) {
                    this.f14972e.x0 = i2;
                    d dVar3 = this.f14972e;
                    dVar3.T.setTranslationX(dVar3.x0 + ((this.f14972e.q0 - layoutParams.width) / 2.0f));
                }
                this.f14972e.O.setAlpha((layoutParams.width - this.f14972e.z0) / (this.f14972e.q0 - this.f14972e.z0));
                if (this.f14972e.K.getVisibility() == 0) {
                    float f2 = this.f14972e.k0 / 6.0f;
                    float f3 = (f2 - i3) / f2;
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                    this.f14972e.K.setAlpha(f3);
                }
            }
        }

        public final void b(float f2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (f2 > 0.0f) {
                    d dVar = this.f14972e;
                    dVar.s0 -= 1000;
                    z = true;
                } else {
                    this.f14972e.s0 += 1000;
                    z = false;
                }
                int duration = this.f14972e.w.getControl().getDuration();
                if (this.f14972e.s0 < 0) {
                    this.f14972e.s0 = 0;
                } else if (this.f14972e.s0 > duration) {
                    this.f14972e.s0 = duration;
                }
                String str = StringHelper.stringForVideoTime(this.f14972e.s0) + " / " + StringHelper.stringForVideoTime(duration);
                VideoGestureView videoGestureView = this.f14972e.N;
                if (videoGestureView != null) {
                    videoGestureView.changeFFRew(z, str);
                }
                d dVar2 = this.f14972e;
                dVar2.I.setCurrentDuration(dVar2.s0, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.f14972e.w.getControl().isPlaying()) {
                    this.f14972e.w.getControl().pause();
                    d dVar = this.f14972e;
                    if (dVar.s == dVar.f14965j) {
                        dVar.l0(dVar.k);
                    } else {
                        dVar.l0(dVar.l);
                    }
                    this.f14972e.r0(R.id.video_pause);
                    return true;
                }
                d dVar2 = this.f14972e;
                int i2 = dVar2.s;
                int i3 = dVar2.k;
                if (i2 != i3 && i2 != (i3 | 1)) {
                    int i4 = dVar2.l;
                    if (i2 == i4 || i2 == (i4 | 1)) {
                        d dVar3 = this.f14972e;
                        dVar3.l0(dVar3.f14963h);
                        this.f14972e.w.getControl().start(this.f14972e.L0);
                        this.f14972e.r0(R.id.video_play);
                        return true;
                    }
                    return true;
                }
                d dVar4 = this.f14972e;
                dVar4.l0(dVar4.f14965j);
                this.f14972e.P();
                this.f14972e.w.getControl().start(this.f14972e.L0);
                this.f14972e.r0(R.id.video_play);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                this.f14972e.t = 0;
                d dVar = this.f14972e;
                if (dVar.b0) {
                    dVar.O((Activity) dVar.R, true);
                }
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (!this.f14972e.c0(motionEvent)) {
                    return super.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                Context context = this.f14972e.R;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.f14972e.R).disableSwipeJustOnce();
                } else {
                    Context context2 = this.f14972e.R;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.f14972e.R).disableSwipeJustOnce();
                    }
                }
                d dVar = this.f14972e;
                if (dVar.W && dVar.d0()) {
                    int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                    int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                    int i4 = this.f14972e.t;
                    if (i4 != 0) {
                        if (i4 == 4) {
                            a(rawX, rawY);
                        }
                    } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                        if (this.f14972e.w.getControl().isPlaying()) {
                            this.f14972e.w.getControl().pause();
                            d dVar2 = this.f14972e;
                            dVar2.l0(dVar2.p);
                        }
                        this.f14972e.t = 4;
                        d dVar3 = this.f14972e;
                        dVar3.u = dVar3.s;
                        d dVar4 = this.f14972e;
                        dVar4.s = dVar4.o;
                        dVar4.u0 = dVar4.T.getMeasuredHeight();
                        d dVar5 = this.f14972e;
                        dVar5.y0 = dVar5.q0 / this.f14972e.u0;
                        d dVar6 = this.f14972e;
                        dVar6.z0 = (int) (dVar6.S.getWidth() * 1.2f);
                        a(rawX, rawY);
                    }
                } else {
                    d dVar7 = this.f14972e;
                    int i5 = dVar7.s;
                    if (i5 == dVar7.f14963h || i5 == dVar7.f14965j || i5 == (i2 = dVar7.k) || i5 == (i3 = dVar7.l) || i5 == dVar7.o || i5 == (i2 | 1) || i5 == (i3 | 1)) {
                        int i6 = this.f14972e.t;
                        if (i6 == 0) {
                            if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                                this.f14972e.t = 3;
                                d dVar8 = this.f14972e;
                                dVar8.s0 = dVar8.w.getControl().getCurrentPosition();
                                b(f2);
                            } else if (motionEvent.getX() < this.f14972e.T.getWidth() / 2) {
                                this.f14972e.t = 2;
                                d dVar9 = this.f14972e;
                                dVar9.N.changeBright(dVar9.R, f3 > 0.0f);
                            } else {
                                this.f14972e.t = 1;
                                d dVar10 = this.f14972e;
                                dVar10.N.changeVolume(dVar10.R, f3 > 0.0f);
                            }
                            d dVar11 = this.f14972e;
                            int i7 = dVar11.s;
                            int i8 = dVar11.o;
                            if (i7 != i8) {
                                if ((i7 & 1) > 0) {
                                    dVar11.o = i8 | 1;
                                } else {
                                    dVar11.o = i8 & (-2);
                                }
                                d dVar12 = this.f14972e;
                                dVar12.l0(dVar12.o);
                            }
                        } else if (i6 == 1) {
                            d dVar13 = this.f14972e;
                            int i9 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                            dVar13.N.changeVolume(dVar13.R, i9 > 0);
                            if (i9 > 0) {
                                this.f14972e.onVolumeUp();
                            }
                        } else if (i6 == 2) {
                            d dVar14 = this.f14972e;
                            dVar14.N.changeBright(dVar14.R, f3 > 0.0f);
                        } else if (i6 == 3) {
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
                if (this.f14972e.w.getControl().isPlaying()) {
                    d dVar = this.f14972e;
                    int i2 = dVar.s;
                    int i3 = dVar.f14963h;
                    if (i2 != i3 && i2 != dVar.f14964i && i2 != dVar.r) {
                        if (i2 == dVar.f14965j) {
                            dVar.l0(i3);
                        }
                    } else {
                        d dVar2 = this.f14972e;
                        dVar2.l0(dVar2.f14965j);
                        this.f14972e.P();
                    }
                } else {
                    d dVar3 = this.f14972e;
                    int i4 = dVar3.s;
                    int i5 = dVar3.k;
                    if (i4 == i5) {
                        dVar3.l0(dVar3.l);
                    } else if (i4 == (i5 | 1)) {
                        dVar3.l0(dVar3.l | 1);
                    } else {
                        int i6 = dVar3.l;
                        if (i4 == i6) {
                            dVar3.l0(i5);
                        } else if (i4 == (i6 | 1)) {
                            dVar3.l0(i5 | 1);
                        } else {
                            dVar3.l0(dVar3.f14961f);
                            this.f14972e.startPlay();
                            this.f14972e.i0();
                        }
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14973e;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14973e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    d dVar = this.f14973e;
                    if (dVar.s == dVar.o) {
                        if (dVar.t == 4) {
                            this.f14973e.Q();
                            this.f14973e.w0 = 0;
                            this.f14973e.x0 = 0;
                        } else {
                            d dVar2 = this.f14973e;
                            dVar2.s = -1;
                            if (dVar2.t != 3) {
                                if (this.f14973e.u != -1) {
                                    d dVar3 = this.f14973e;
                                    dVar3.l0(dVar3.u);
                                    this.f14973e.u = -1;
                                } else if (this.f14973e.w.getControl().isPlaying()) {
                                    d dVar4 = this.f14973e;
                                    dVar4.l0(dVar4.f14963h);
                                } else {
                                    d dVar5 = this.f14973e;
                                    dVar5.l0(dVar5.k);
                                }
                            } else {
                                d dVar6 = this.f14973e;
                                dVar6.I.setCurrentDuration(dVar6.s0, true);
                                if (this.f14973e.s0 <= this.f14973e.w.getControl().getDuration()) {
                                    if (!this.f14973e.w.getControl().isPlaying()) {
                                        this.f14973e.w.getControl().start(this.f14973e.L0);
                                    }
                                    d dVar7 = this.f14973e;
                                    dVar7.l0(dVar7.f14963h);
                                }
                            }
                        }
                        d dVar8 = this.f14973e;
                        if (dVar8.f0) {
                            String str = null;
                            if (dVar8.t == 1) {
                                str = "c13361";
                            } else if (this.f14973e.t == 2) {
                                str = "c13346";
                            } else if (this.f14973e.t == 3) {
                                str = "c13362";
                            }
                            if (!m.isEmpty(str)) {
                                TiebaStatic.log(new StatisticItem(str).param("tid", this.f14973e.Y).param("fid", this.f14973e.Z));
                            }
                        }
                        this.f14973e.t = 0;
                        return true;
                    }
                }
                return this.f14973e.r0.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class j implements TbVideoViewSet.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                d dVar = this.a;
                dVar.l0(dVar.f14961f);
                this.a.p0();
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.w.clearCallbackAndRemoveFromWindow();
                this.a.n0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface k {
        void a(int i2, int i3);
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
        this.f14960e = 3000;
        this.f14961f = 8211;
        this.f14962g = 19;
        this.f14963h = 0;
        this.f14964i = 4;
        this.f14965j = w0.c1;
        this.k = 8416;
        this.l = 0;
        this.m = 513;
        this.n = 259;
        this.o = 2048;
        this.p = 0;
        this.q = 4099;
        this.r = 0;
        this.s = 8211;
        this.t = 0;
        this.u = -1;
        this.v = new b(this);
        this.Q = null;
        this.b0 = false;
        this.f0 = true;
        this.g0 = false;
        this.i0 = true;
        this.t0 = new int[2];
        this.w0 = 0;
        this.x0 = 0;
        this.A0 = false;
        this.B0 = null;
        this.E0 = false;
        this.G0 = -1L;
        this.H0 = new c(this);
        this.I0 = new g(this);
        this.J0 = new h(this);
        this.K0 = new i(this);
        this.L0 = new j(this);
        this.M0 = new a(this, 2000994);
        if (context == null || view == null) {
            return;
        }
        this.R = context;
        this.a0 = new l((Activity) context);
        this.S = view;
        this.k0 = n.i(this.R);
        this.q0 = n.k(this.R);
        a0();
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.s;
            if (i2 == this.f14964i || i2 == this.r) {
                l0(this.f14963h);
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.W && !"video_tab".equals(this.e0)) {
                this.f14965j = 104;
                this.k = 8290;
            } else {
                this.f14965j = w0.c1;
                this.k = 8418;
            }
            if (this.b0) {
                this.f14961f |= 1024;
                this.f14963h |= 1024;
                this.f14964i |= 1024;
                this.r |= 1024;
                this.f14965j |= 1024;
                this.k |= 1024;
                this.l |= 1024;
                this.m |= 1024;
                this.n |= 1024;
                this.s |= 1024;
                return;
            }
            this.f14961f &= -1025;
            this.f14963h &= -1025;
            this.f14964i &= -1025;
            this.r &= -1025;
            this.f14965j &= -1025;
            this.k &= -1025;
            this.l &= -1025;
            this.m &= -1025;
            this.n &= -1025;
            this.s &= -1025;
        }
    }

    public void N() {
        float dimension;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.J.changeViewLayout(this.W, this.b0);
            this.K.changeViewLayout(this.W, this.b0);
            Context context = this.R;
            if (context == null || context.getResources() == null) {
                return;
            }
            if (this.W) {
                dimension = this.R.getResources().getDimension(R.dimen.tbds44);
            } else if (this.b0) {
                dimension = this.R.getResources().getDimension(R.dimen.tbds78);
            } else {
                dimension = this.R.getResources().getDimension(R.dimen.tbds44);
            }
            int i2 = (int) dimension;
            this.D.setPadding(0, 0, "video_tab".equals(this.e0) ? 0 : i2, 0);
            SwitchImageView switchImageView = this.H;
            switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i2, 0);
            this.G.setPadding(i2, 0, 0, 0);
        }
    }

    public final void O(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, activity, z) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (this.W && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
            ViewGroup viewGroup = this.T;
            if (viewGroup == null) {
                return;
            }
            if (z) {
                viewGroup.setPadding(0, n.r((Activity) this.R), 0, 0);
            } else {
                viewGroup.setPadding(0, 0, 0, 0);
            }
        } else if (z) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags |= 1024;
            activity.getWindow().setAttributes(attributes);
            m0();
        } else {
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.T.setSystemUiVisibility(0);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.v);
            c.a.d.f.m.e.a().postDelayed(this.v, this.f14960e);
        }
    }

    public final void Q() {
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
            if (!this.W) {
                R();
            } else if (this.s == this.o) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.addListener(new f(this));
                if (!this.v0) {
                    float width = this.S.getWidth() / this.T.getWidth();
                    float height = this.S.getHeight() / this.T.getHeight();
                    this.T.setPivotX(0.0f);
                    this.T.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.T, "ScaleX", 1.0f, width);
                    objectAnimator = ObjectAnimator.ofFloat(this.T, "ScaleY", 1.0f, height);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.K, "ScaleX", 1.0f, 1.0f / width);
                    ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.K, "ScaleY", 1.0f, 1.0f / height);
                    ViewGroup viewGroup = this.T;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.t0[0]);
                    ViewGroup viewGroup2 = this.T;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.t0[1]);
                    View view = this.O;
                    ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, view.getAlpha(), 0.0f);
                    OperableVideoShareView operableVideoShareView = this.K;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, AnimationProperty.OPACITY, operableVideoShareView.getAlpha(), 0.0f);
                    ofFloat2 = ofFloat7;
                    objectAnimator2 = ofFloat9;
                    ofFloat3 = ofFloat8;
                } else {
                    float width2 = this.q0 / this.T.getWidth();
                    float height2 = this.u0 / this.T.getHeight();
                    this.T.setPivotX(0.0f);
                    this.T.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.T, "ScaleX", 1.0f, width2);
                    ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.T, "ScaleY", 1.0f, height2);
                    ofFloat2 = ObjectAnimator.ofFloat(this.K, "ScaleX", 1.0f, 1.0f / width2);
                    ofFloat3 = ObjectAnimator.ofFloat(this.K, "ScaleY", 1.0f, 1.0f / height2);
                    ViewGroup viewGroup3 = this.T;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup3, "TranslationX", viewGroup3.getTranslationX(), 0.0f);
                    ViewGroup viewGroup4 = this.T;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup4, "TranslationY", viewGroup4.getTranslationY(), 0.0f);
                    OperableVideoShareView operableVideoShareView2 = this.K;
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
                int i2 = this.u;
                if (i2 != -1) {
                    this.s = i2;
                    this.u = -1;
                    if (i2 == this.p || i2 == this.f14965j || i2 == this.f14963h) {
                        this.w.getControl().start(this.L0);
                        l0(this.f14963h);
                    }
                }
            } else {
                R();
            }
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            S(true);
        }
    }

    public void S(boolean z) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.S == null || this.T == null || (tbVideoViewContainer = this.w) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        Context context = this.R;
        if (context != null) {
            n.w(context, this.S);
        }
        if (this.b0) {
            if (this.O.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.O.getParent()).removeView(this.O);
            }
            if ((this.T.getParent() instanceof ViewGroup) && (this.S instanceof ViewGroup)) {
                this.b0 = false;
                this.g0 = true;
                ((ViewGroup) this.T.getParent()).removeView(this.T);
                ((ViewGroup) this.S).addView(this.T);
                this.g0 = false;
                O((Activity) this.R, this.b0);
            }
            if (!this.W && z) {
                this.a0.l();
            }
        } else {
            if (this.R != null) {
                if (!this.W && z) {
                    this.a0.l();
                }
                if (this.R instanceof Activity) {
                    this.T.getLocationOnScreen(this.t0);
                    View findViewById = ((Activity) this.R).findViewById(16908290);
                    if (findViewById instanceof ViewGroup) {
                        View childAt = ((ViewGroup) findViewById).getChildAt(0);
                        if (childAt instanceof ViewGroup) {
                            this.g0 = true;
                            ((ViewGroup) this.S).removeAllViews();
                            if (this.O == null) {
                                View view = new View(this.R);
                                this.O = view;
                                view.setClickable(true);
                                this.O.setBackgroundColor(SkinManager.getColor(R.color.black_alpha100));
                                this.O.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            }
                            if (this.O.getParent() instanceof ViewGroup) {
                                ((ViewGroup) this.O.getParent()).removeView(this.O);
                            }
                            this.O.setAlpha(1.0f);
                            ViewGroup viewGroup = (ViewGroup) childAt;
                            viewGroup.addView(this.O);
                            viewGroup.addView(this.T);
                            this.g0 = false;
                            this.b0 = true;
                            O((Activity) this.R, true);
                            c.a.y.c cVar = this.C0;
                            if (cVar != null && cVar.c()) {
                                this.C0.a();
                            }
                        }
                    }
                }
            }
            if (this.f0) {
                TiebaStatic.log(new StatisticItem("c13360").param("tid", this.Y).param("fid", this.Z).param("obj_type", this.W ? 1 : 2));
            }
        }
        M();
        N();
        if (this.w.getControl().isPlaying()) {
            l0(this.f14963h);
        } else {
            l0(this.s);
        }
        this.H.switchState();
        g0(this.b0);
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
            if (isVideoCardMute) {
                this.w.getControl().setVolume(1.0f, 1.0f);
                t0.f(this.Q, true);
                c.a.q0.i0.g.c.b().l(true);
                this.G.setState(0);
            } else {
                this.w.getControl().setVolume(0.0f, 0.0f);
                this.G.setState(1);
                t0.f(this.Q, false);
                c.a.q0.i0.g.c.b().l(false);
            }
            TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.a0.i(true);
            } else {
                this.a0.i(false);
            }
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.a0.j();
            } else {
                this.a0.k();
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.I.showProgress();
            TBLottieAnimationView tBLottieAnimationView = this.z;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.clearAnimation();
                this.z.animate().alpha(0.0f).setDuration(200L).setListener(new e(this)).start();
            }
        }
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.operable_video_container : invokeV.intValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public void a0() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (context = this.R) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(X(), (ViewGroup) null);
        this.T = viewGroup;
        View view = this.S;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).addView(viewGroup);
        }
        this.Q = new WeakReference<>(TbadkCoreApplication.getInst());
        this.x = (TbImageView) this.T.findViewById(R.id.video_thumbnail);
        this.y = this.T.findViewById(R.id.black_mask);
        this.z = (TBLottieAnimationView) this.T.findViewById(R.id.video_loading);
        this.A = (ImageView) this.T.findViewById(R.id.video_play);
        this.C = (PercentSizeView) this.T.findViewById(R.id.video_media_controller_mask);
        this.B = (ImageView) this.T.findViewById(R.id.video_pause);
        this.D = (TextView) this.T.findViewById(R.id.video_play_count);
        this.E = (TextView) this.T.findViewById(R.id.video_play_flag);
        this.F = (TextView) this.T.findViewById(R.id.video_duration);
        this.G = (SwitchImageView) this.T.findViewById(R.id.video_mute);
        this.H = (SwitchImageView) this.T.findViewById(R.id.video_full_screen);
        this.I = (OperableVideoMediaControllerView) this.T.findViewById(R.id.video_media_controller);
        this.J = (OperableVideoNetworkStateTipView) this.T.findViewById(R.id.video_network_state_tip);
        this.K = (OperableVideoShareView) this.T.findViewById(R.id.video_share_view);
        this.M = this.T.findViewById(R.id.video_back_btn_mask);
        this.L = (ImageView) this.T.findViewById(R.id.video_full_screen_back);
        this.N = (VideoGestureView) this.T.findViewById(R.id.video_gesture);
        this.P = (OperableVideoErrorView) this.T.findViewById(R.id.video_error_layout);
        this.K.setVideoContainer(this);
        this.z.addAnimatorListener(new C0957d(this));
        this.z.setAnimation(R.raw.lotti_video_loading);
        this.A.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.A.setOnClickListener(this);
        this.G.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
        this.G.setState(1);
        this.G.setOnClickListener(this);
        this.x.clearCornerFlag();
        this.x.setDrawCorner(false);
        this.x.setPlaceHolder(3);
        HomeGroupUbsUIHelper.handleImgMask(this.y, R.color.CAM_X0601);
        this.I.setOnSeekBarChangeListener(this.I0);
        this.C.setHeightPercent(0.583f);
        this.C.setBackgroundResource(R.drawable.video_mask_bg);
        this.H.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
        this.H.setState(0);
        this.H.setOnClickListener(this);
        this.B.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.B.setOnClickListener(this);
        this.L.setOnClickListener(this);
        TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.R);
        this.w = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setTryUseViewInSet(true);
        n0();
        this.J.setPlayViewOnClickListener(this);
        this.T.setOnClickListener(null);
        this.T.setOnTouchListener(this.K0);
        this.K.setOnTouchListener(this.K0);
        this.P.setOutOnClickListener(this);
        this.r0 = new GestureDetector(this.R, this.J0);
        l0(this.f14961f);
        c.a.q0.r.v.c.d(this.y).s(R.array.Mask_X003);
        c.a.q0.r.v.c.d(this.D).y(R.array.S_O_X001);
        c.a.q0.r.v.c.d(this.F).y(R.array.S_O_X001);
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (TbSingleton.getInstance().isVideoCardMute()) {
                this.w.getControl().setVolume(0.0f, 0.0f);
                this.G.setState(1);
                return;
            }
            this.w.getControl().setVolume(1.0f, 1.0f);
            this.G.setState(0);
            c.a.q0.i0.g.c.b().l(true);
        }
    }

    public boolean c0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) ? this.b0 : invokeL.booleanValue;
    }

    @Override // c.a.r0.a3.v.a
    public void changeRenderViewMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.w.getControl().changeRenderViewMode(i2);
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.W && this.b0 : invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.D0 != null : invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (UbsABTestHelper.isVideoTabAutoPlay() && "video_tab".equals(this.e0)) {
                return c.a.d.f.p.l.x();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.J;
            return operableVideoNetworkStateTipView != null && operableVideoNetworkStateTipView.isShowNetworkTips();
        }
        return invokeV.booleanValue;
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    @Override // c.a.r0.a3.v.a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.w.getControl().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.r0.a3.v.a
    public View getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.T : (View) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.v);
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.X);
            CustomMessage customMessage = new CustomMessage(2921387);
            customMessage.setTag(this.U);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // c.a.r0.a3.v.a
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.b0 : invokeV.booleanValue;
    }

    @Override // c.a.r0.a3.v.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.V || this.w.getControl().isPlaying() : invokeV.booleanValue;
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.E0 = z;
        }
    }

    public void k0(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, kVar) == null) {
            this.F0 = kVar;
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            h0();
            if (this.s == this.o) {
                this.u = i2;
                return;
            }
            this.s = i2;
            this.x.setVisibility((i2 & 1) > 0 ? 0 : 8);
            this.y.setVisibility((i2 & 2) > 0 ? 0 : 8);
            this.i0 = (i2 & 4) > 0;
            this.z.clearAnimation();
            this.z.setVisibility(this.i0 ? 0 : 8);
            if (!this.i0) {
                this.z.cancelAnimation();
            } else {
                this.z.setAlpha(1.0f);
            }
            this.A.setVisibility((i2 & 8192) > 0 ? 0 : 8);
            this.B.setVisibility((i2 & 8) > 0 ? 0 : 8);
            int i3 = i2 & 16;
            this.D.setVisibility(i3 > 0 ? 0 : 8);
            this.F.setVisibility(i3 > 0 ? 0 : 8);
            this.G.setVisibility((i2 & 32) > 0 ? 0 : 8);
            this.H.setVisibility((i2 & 64) > 0 ? 0 : 8);
            int i4 = i2 & 128;
            this.I.setVisibility(i4 > 0 ? 0 : 8);
            this.C.setVisibility(i4 > 0 ? 0 : 8);
            if (this.I.getVisibility() == 0) {
                this.I.showProgress();
            }
            this.J.setVisibility((i2 & 256) > 0 ? 0 : 8);
            this.K.setVisibility((i2 & 512) > 0 ? 0 : 8);
            if (this.K.getVisibility() == 0) {
                this.K.setAlpha(1.0f);
            }
            int i5 = i2 & 1024;
            this.L.setVisibility(i5 > 0 ? 0 : 8);
            this.M.setVisibility(i5 > 0 ? 0 : 8);
            this.N.setVisibility((i2 & 2048) > 0 ? 0 : 8);
            this.P.setVisibility((i2 & 4096) <= 0 ? 8 : 0);
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.T.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.T.setSystemUiVisibility(4);
            } else {
                this.T.setSystemUiVisibility(5894);
            }
        }
    }

    public void n0() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (tbVideoViewContainer = this.w) != null && tbVideoViewContainer.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.T.addView(this.w, 0);
            this.w.setLayoutParams(layoutParams);
            this.I.setPlayer(this.w.getControl());
            this.w.getControl().setContinuePlayEnable(true);
            this.w.getControl().setOperableVideoContainer(this);
            this.w.getControl().setOnSurfaceDestroyedListener(this);
            this.w.getControl().setVideoStatData(this.c0);
            this.w.getControl().setThreadDataForStatistic(this.d0);
            this.w.getControl().getMediaProgressObserver().j(this.H0);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            l0(this.f14964i);
            this.i0 = true;
            this.I.showProgress();
            W();
        }
    }

    @Override // c.a.r0.a3.v.a
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.b0) {
                Q();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a3.v.a
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
            if (z) {
                this.A0 = isPlaying();
                this.z.cancelAnimation();
                int i2 = this.s;
                if (i2 == this.f14963h || i2 == this.f14964i || i2 == this.f14965j || i2 == this.f14961f || i2 == this.r || i2 == this.f14962g) {
                    stopPlay();
                }
                int i3 = this.s | 1;
                this.s = i3;
                int i4 = i3 & (-8193);
                this.s = i4;
                l0(i4);
            } else {
                int i5 = this.s;
                if (i5 == this.f14961f || i5 == this.f14962g) {
                    if (this.A0) {
                        startPlay();
                        i0();
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
        if (!(interceptable == null || interceptable.invokeL(1048613, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        r0(id);
        if (id == R.id.video_mute) {
            T();
        } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
            Q();
        } else {
            if (id == R.id.video_replay) {
                l0(this.f14961f);
                startPlay();
                if (this.f0) {
                    TiebaStatic.log(new StatisticItem("c13345").param("tid", this.Y).param("fid", this.Z).param("obj_type", this.W ? 1 : 2).param("obj_locate", this.b0 ? 1 : 2));
                }
                i0();
            } else if (id == R.id.video_play) {
                int i2 = this.s;
                if (i2 != this.f14961f && i2 != this.f14962g) {
                    l0(this.f14965j);
                    P();
                    this.w.getControl().start(this.L0);
                } else {
                    startPlay();
                }
                if (this.f0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.Y).param("fid", this.Z).param("obj_type", this.W ? 1 : 2).param("obj_source", this.b0 ? 1 : 2).param("obj_locate", 1));
                }
                i0();
            } else if (id == R.id.video_pause) {
                l0(this.k);
                h0();
                this.w.getControl().pause();
                if (this.f0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.Y).param("fid", this.Z).param("obj_type", this.W ? 1 : 2).param("obj_source", this.b0 ? 1 : 2).param("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                l0(this.f14961f);
                startPlay();
            } else if (id == R.id.retry) {
                l0(this.f14961f);
                startPlay();
            }
        }
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            l0(this.m);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048615, this, i2, i3, obj)) == null) {
            l0(this.q);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048616, this, i2, i3, obj)) == null) {
            if (i2 == 3 || i2 == 904) {
                if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    q0();
                } else {
                    o0();
                }
            }
            if (i2 == 701) {
                this.i0 = true;
                p0();
                return false;
            } else if (i2 == 702) {
                q0();
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
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            b0();
            if (this.V) {
                if (this.b0) {
                    Context context = this.R;
                    if (context instanceof Activity) {
                        O((Activity) context, true);
                    }
                }
                this.w.getControl().start(this.L0);
            }
        }
    }

    @Override // c.a.r0.a3.v.a
    public void onScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.g0) {
            return;
        }
        int i2 = this.s;
        if (i2 != this.k && (i2 != this.l || this.w.getControl().isPlaying())) {
            if (this.s == this.m) {
                t0();
                l0(this.m);
                return;
            }
            t0();
            return;
        }
        t0();
        l0(this.k);
    }

    @Override // c.a.r0.a3.v.a
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (TbSingleton.getInstance().isVideoCardMute() && this.w.getControl().isPlaying() && !t0.c() && !c.a.q0.i0.g.c.b().j()) {
                this.w.getControl().setVolume(1.0f, 1.0f);
                this.G.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.i0) {
                this.z.setAlpha(1.0f);
                this.z.setVisibility(0);
                this.A.setVisibility(8);
            } else {
                this.z.setVisibility(8);
                this.A.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.z;
            if (tBLottieAnimationView == null || !this.i0) {
                return;
            }
            tBLottieAnimationView.loop(true);
            this.z.setMinAndMaxFrame(14, 80);
            this.z.playAnimation();
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            l0(this.r);
            this.I.showProgress();
            W();
        }
    }

    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
        }
    }

    public void s0() {
        t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || (tVar = this.c0) == null) {
            return;
        }
        t b2 = tVar.b();
        b2.a = this.e0;
        c.a.r0.a3.j.e(b2.m, "", "1", b2, this.w.getControl().getPcdnState());
    }

    @Override // c.a.r0.a3.v.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onClickListener) == null) {
            this.B0 = onClickListener;
        }
    }

    @Override // c.a.r0.a3.v.a
    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, e2Var) == null) || e2Var == null || e2Var.u1() == null) {
            return;
        }
        this.G0 = -1L;
        c.a.y.c cVar = this.C0;
        if (cVar != null) {
            cVar.d();
        }
        if (StringHelper.equals(this.X, e2Var.u1().video_url)) {
            return;
        }
        stopPlay();
        this.W = e2Var.u1().is_vertical.intValue() == 1;
        this.X = e2Var.u1().video_url;
        this.Y = e2Var.w1();
        e2Var.u1().video_length.intValue();
        e2Var.u1().video_duration.intValue();
        this.Z = e2Var.U();
        this.D0 = e2Var.u1().mcn_ad_card;
        M();
        N();
        l0(this.f14961f);
        int intValue = e2Var.u1().video_duration.intValue() * 1000;
        this.I.initDuration(intValue);
        this.I.setPlayer(this.w.getControl());
        this.F.setText(StringHelper.stringForVideoTime(intValue));
        this.D.setText(String.format(this.R.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(e2Var.u1().play_count.intValue())));
        this.J.setVideoLength(e2Var.u1().video_length.intValue());
        this.J.setVideoDuration(e2Var.u1().video_duration.intValue());
        this.J.setTid(this.Y);
        this.d0 = e2Var;
        this.w.getControl().setThreadDataForStatistic(e2Var);
        this.E.setVisibility(8);
        this.x.setPlaceHolder(3);
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() != 2 && TbadkCoreApplication.getInst().getVideoAutoPlay() != 0) {
            this.x.startLoad(e2Var.u1().thumbnail_url, 10, false);
        } else if (!m.isEmpty(e2Var.u1().first_frame_thumbnail)) {
            this.x.startLoad(e2Var.u1().first_frame_thumbnail, 10, false);
        } else {
            this.x.startLoad(e2Var.u1().thumbnail_url, 10, false);
        }
        this.K.setShareData(e2Var);
    }

    @Override // c.a.r0.a3.v.a
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.e0 = str;
        }
    }

    @Override // c.a.r0.a3.v.a
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, onClickListener) == null) {
        }
    }

    @Override // c.a.r0.a3.v.a
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.h0 = str;
        }
    }

    @Override // c.a.r0.a3.v.a
    public void setStatistic(t tVar) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, tVar) == null) || (tbVideoViewContainer = this.w) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.c0 = tVar;
        this.w.getControl().setVideoStatData(tVar);
    }

    @Override // c.a.r0.a3.v.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bdUniqueId) == null) {
            this.U = bdUniqueId;
        }
    }

    @Override // c.a.r0.a3.v.a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || StringUtils.isNull(this.X)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.M0);
        if (f0()) {
            l0(this.n);
            return;
        }
        this.V = true;
        if (this.w.getControl().isPlaying()) {
            return;
        }
        TbVideoViewContainer c2 = TbVideoViewSet.b().c(this.X);
        if (c2 == null) {
            this.w.clearCallbackAndRemoveFromWindow();
            if (!StringUtils.isNull(this.w.getControl().getOriginUrl())) {
                TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.R);
                this.w = tbVideoViewContainer;
                tbVideoViewContainer.getControl().setTryUseViewInSet(true);
            }
            n0();
            if (c.a.d.f.p.l.z()) {
                this.w.getControl().setVideoPath(this.X, this.Y);
                this.w.getControl().setStageType(this.h0);
                if (!UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    this.i0 = true;
                }
                p0();
                if (this.f0) {
                    s0();
                }
            }
        } else {
            TbVideoViewContainer tbVideoViewContainer2 = this.w;
            if (tbVideoViewContainer2 == c2) {
                tbVideoViewContainer2.clearCallbackAndRemoveFromWindow();
                n0();
            } else {
                tbVideoViewContainer2.clearCallbackAndRemoveFromWindow();
                c2.clearCallbackAndRemoveFromWindow();
                this.w = c2;
                c2.getControl().setTryUseViewInSet(true);
                n0();
            }
            this.w.getControl().monitorAndStatsAtPrepare();
            onPrepared();
            if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                q0();
            } else {
                o0();
            }
            if (this.f0) {
                s0();
            }
        }
        if (this.f0) {
            TiebaStatic.log(new StatisticItem("c13357").param("tid", this.Y).param("fid", this.Z).param("obj_type", this.W ? 1 : 2).param("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // c.a.r0.a3.v.a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.V = false;
            TBLottieAnimationView tBLottieAnimationView = this.z;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && TbSingleton.getInstance().getIsNeedReuseVideoPlayer() && !TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && this.X != null && (this.w.getControl() instanceof TbVideoView)) {
                this.w.getControl().setTryUseViewInSet(false);
                if (this.w.getControl().getPlayer() instanceof o) {
                    ((o) this.w.getControl().getPlayer()).detachKLayerToCache(TbVideoView.VIDEO_REUSE_PLAYER);
                }
            }
            this.w.getControl().stop();
            this.w.clearCallbackAndRemoveFromWindow();
            this.I.resetProgress();
            l0(this.f14961f);
            MessageManager.getInstance().unRegisterListener(this.M0);
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.V = false;
            TBLottieAnimationView tBLottieAnimationView = this.z;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.w.getControl().stop();
            this.I.resetProgress();
            l0(this.f14961f);
            MessageManager.getInstance().unRegisterListener(this.M0);
        }
    }
}
