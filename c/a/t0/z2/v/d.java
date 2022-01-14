package c.a.t0.z2.v;

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
import c.a.s0.e1.t0;
import c.a.s0.s.q.e2;
import c.a.t0.z2.h;
import c.a.t0.z2.l;
import c.a.t0.z2.t;
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
/* loaded from: classes9.dex */
public class d implements c.a.t0.z2.v.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public View.OnClickListener A0;
    public PercentSizeView B;
    public c.a.z.c B0;
    public TextView C;
    public McnAdInfo C0;
    public TextView D;
    public boolean D0;
    public TextView E;
    public k E0;
    public SwitchImageView F;
    public long F0;
    public SwitchImageView G;
    public h.c G0;
    public OperableVideoMediaControllerView H;
    public SeekBar.OnSeekBarChangeListener H0;
    public OperableVideoNetworkStateTipView I;
    public GestureDetector.SimpleOnGestureListener I0;
    public OperableVideoShareView J;
    public View.OnTouchListener J0;
    public ImageView K;
    public TbVideoViewSet.b K0;
    public View L;
    public final CustomMessageListener L0;
    public VideoGestureView M;
    public View N;
    public OperableVideoErrorView O;
    public WeakReference<Context> P;
    public Context Q;
    public View R;
    public ViewGroup S;
    public BdUniqueId T;
    public boolean U;
    public boolean V;
    public String W;
    public String X;
    public long Y;
    public l Z;
    public boolean a0;
    public t b0;
    public e2 c0;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public int f26094e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public int f26095f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public int f26096g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public int f26097h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public int f26098i;
    public float i0;

    /* renamed from: j  reason: collision with root package name */
    public int f26099j;
    public int k;
    public float k0;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public GestureDetector q0;
    public int r;
    public int r0;
    public int s;
    public int[] s0;
    public int t;
    public int t0;
    public Runnable u;
    public boolean u0;
    public TbVideoViewContainer v;
    public int v0;
    public TbImageView w;
    public int w0;
    public View x;
    public float x0;
    public TBLottieAnimationView y;
    public int y0;
    public ImageView z;
    public boolean z0;

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26100e;

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
            this.f26100e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f26100e;
                dVar.l0(dVar.f26096g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26101e;

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
            this.f26101e = dVar;
        }

        @Override // c.a.t0.z2.h.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f26101e.F0 <= 0) {
                    this.f26101e.F0 = i3;
                }
                if (this.f26101e.e0()) {
                    d dVar = this.f26101e;
                    if (!dVar.V && !dVar.a0 && dVar.D0) {
                        if (c.a.z.b.b().a(this.f26101e.C0.jump_url)) {
                            return;
                        }
                        long j2 = i3;
                        boolean z = j2 >= this.f26101e.C0.ad_start_time.longValue() * 1000 && j2 < this.f26101e.C0.ad_end_time.longValue() * 1000;
                        boolean z2 = this.f26101e.F0 >= (this.f26101e.C0.ad_start_time.longValue() * 1000) + 1000;
                        if (this.f26101e.B0 == null) {
                            d dVar2 = this.f26101e;
                            dVar2.B0 = new c.a.z.c(dVar2.Q);
                        }
                        if (z) {
                            if (!this.f26101e.B0.c()) {
                                c.a.z.a aVar = new c.a.z.a();
                                aVar.f26856b = this.f26101e.C0.card_title;
                                aVar.f26857c = this.f26101e.C0.button_title;
                                aVar.f26858d = this.f26101e.C0.jump_url;
                                aVar.a = this.f26101e.C0.pic_url;
                                aVar.f26860f = String.valueOf(this.f26101e.Y);
                                d dVar3 = this.f26101e;
                                aVar.f26859e = dVar3.X;
                                aVar.f26861g = dVar3.Y();
                                if (z2) {
                                    this.f26101e.B0.f(aVar, (ViewGroup) this.f26101e.R);
                                } else {
                                    this.f26101e.B0.e(aVar, (ViewGroup) this.f26101e.R);
                                }
                            }
                        } else if (this.f26101e.B0.c()) {
                            this.f26101e.B0.a();
                        }
                    }
                }
                if (this.f26101e.E0 != null) {
                    this.f26101e.E0.a(i2, i3);
                }
            }
        }
    }

    /* renamed from: c.a.t0.z2.v.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1575d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26102e;

        public C1575d(d dVar) {
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
            this.f26102e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f26102e.y.setVisibility(8);
                this.f26102e.z.setVisibility(0);
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

    /* loaded from: classes9.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26103e;

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
            this.f26103e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f26103e.y.setVisibility(8);
                this.f26103e.z.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f26103e.L();
                if (!this.f26103e.U) {
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

    /* loaded from: classes9.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26104e;

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
            this.f26104e = dVar;
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
                this.f26104e.S.setScaleX(1.0f);
                this.f26104e.S.setScaleY(1.0f);
                this.f26104e.S.setTranslationX(0.0f);
                this.f26104e.S.setTranslationY(0.0f);
                this.f26104e.J.setScaleX(1.0f);
                this.f26104e.J.setScaleY(1.0f);
                this.f26104e.S.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                if (this.f26104e.u0) {
                    return;
                }
                this.f26104e.R();
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

    /* loaded from: classes9.dex */
    public class g implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26105e;

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
            this.f26105e = dVar;
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
                d dVar = this.f26105e;
                dVar.l0(dVar.f26098i);
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
            if (!this.f26105e.v.getControl().isPlaying()) {
                this.f26105e.v.getControl().start(this.f26105e.K0);
            }
            this.f26105e.P();
            if (this.f26105e.e0) {
                TiebaStatic.log(new StatisticItem("c13355").param("tid", this.f26105e.X).param("fid", this.f26105e.Y).param("obj_type", this.f26105e.V ? 1 : 2).param("obj_locate", this.f26105e.a0 ? 1 : 2));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26106e;

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
            this.f26106e = dVar;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f26106e.v0 == i3 && this.f26106e.w0 == i2) {
                    return;
                }
                d dVar = this.f26106e;
                dVar.u0 = dVar.v0 - i3 > 0 || ((float) i3) < this.f26106e.i0 / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26106e.S.getLayoutParams();
                if (i3 != this.f26106e.v0) {
                    int i4 = this.f26106e.t0 - i3;
                    int i5 = (int) (i4 * this.f26106e.x0);
                    if (i5 < this.f26106e.y0) {
                        i5 = this.f26106e.y0;
                        i4 = (int) (i5 / this.f26106e.x0);
                    }
                    if (i5 != this.f26106e.y0) {
                        layoutParams.height = i4;
                        layoutParams.width = i5;
                        this.f26106e.S.setLayoutParams(layoutParams);
                    }
                    this.f26106e.v0 = i3;
                    d dVar2 = this.f26106e;
                    dVar2.S.setTranslationY(dVar2.v0);
                }
                if (i2 != this.f26106e.v0) {
                    this.f26106e.w0 = i2;
                    d dVar3 = this.f26106e;
                    dVar3.S.setTranslationX(dVar3.w0 + ((this.f26106e.k0 - layoutParams.width) / 2.0f));
                }
                this.f26106e.N.setAlpha((layoutParams.width - this.f26106e.y0) / (this.f26106e.k0 - this.f26106e.y0));
                if (this.f26106e.J.getVisibility() == 0) {
                    float f2 = this.f26106e.i0 / 6.0f;
                    float f3 = (f2 - i3) / f2;
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                    this.f26106e.J.setAlpha(f3);
                }
            }
        }

        public final void b(float f2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (f2 > 0.0f) {
                    d dVar = this.f26106e;
                    dVar.r0 -= 1000;
                    z = true;
                } else {
                    this.f26106e.r0 += 1000;
                    z = false;
                }
                int duration = this.f26106e.v.getControl().getDuration();
                if (this.f26106e.r0 < 0) {
                    this.f26106e.r0 = 0;
                } else if (this.f26106e.r0 > duration) {
                    this.f26106e.r0 = duration;
                }
                String str = StringHelper.stringForVideoTime(this.f26106e.r0) + " / " + StringHelper.stringForVideoTime(duration);
                VideoGestureView videoGestureView = this.f26106e.M;
                if (videoGestureView != null) {
                    videoGestureView.changeFFRew(z, str);
                }
                d dVar2 = this.f26106e;
                dVar2.H.setCurrentDuration(dVar2.r0, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.f26106e.v.getControl().isPlaying()) {
                    this.f26106e.v.getControl().pause();
                    d dVar = this.f26106e;
                    if (dVar.r == dVar.f26098i) {
                        dVar.l0(dVar.f26099j);
                    } else {
                        dVar.l0(dVar.k);
                    }
                    this.f26106e.r0(R.id.video_pause);
                    return true;
                }
                d dVar2 = this.f26106e;
                int i2 = dVar2.r;
                int i3 = dVar2.f26099j;
                if (i2 != i3 && i2 != (i3 | 1)) {
                    int i4 = dVar2.k;
                    if (i2 == i4 || i2 == (i4 | 1)) {
                        d dVar3 = this.f26106e;
                        dVar3.l0(dVar3.f26096g);
                        this.f26106e.v.getControl().start(this.f26106e.K0);
                        this.f26106e.r0(R.id.video_play);
                        return true;
                    }
                    return true;
                }
                d dVar4 = this.f26106e;
                dVar4.l0(dVar4.f26098i);
                this.f26106e.P();
                this.f26106e.v.getControl().start(this.f26106e.K0);
                this.f26106e.r0(R.id.video_play);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                this.f26106e.s = 0;
                d dVar = this.f26106e;
                if (dVar.a0) {
                    dVar.O((Activity) dVar.Q, true);
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
                if (!this.f26106e.c0(motionEvent)) {
                    return super.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                Context context = this.f26106e.Q;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.f26106e.Q).disableSwipeJustOnce();
                } else {
                    Context context2 = this.f26106e.Q;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.f26106e.Q).disableSwipeJustOnce();
                    }
                }
                d dVar = this.f26106e;
                if (dVar.V && dVar.d0()) {
                    int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                    int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                    int i4 = this.f26106e.s;
                    if (i4 != 0) {
                        if (i4 == 4) {
                            a(rawX, rawY);
                        }
                    } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                        if (this.f26106e.v.getControl().isPlaying()) {
                            this.f26106e.v.getControl().pause();
                            d dVar2 = this.f26106e;
                            dVar2.l0(dVar2.o);
                        }
                        this.f26106e.s = 4;
                        d dVar3 = this.f26106e;
                        dVar3.t = dVar3.r;
                        d dVar4 = this.f26106e;
                        dVar4.r = dVar4.n;
                        dVar4.t0 = dVar4.S.getMeasuredHeight();
                        d dVar5 = this.f26106e;
                        dVar5.x0 = dVar5.k0 / this.f26106e.t0;
                        d dVar6 = this.f26106e;
                        dVar6.y0 = (int) (dVar6.R.getWidth() * 1.2f);
                        a(rawX, rawY);
                    }
                } else {
                    d dVar7 = this.f26106e;
                    int i5 = dVar7.r;
                    if (i5 == dVar7.f26096g || i5 == dVar7.f26098i || i5 == (i2 = dVar7.f26099j) || i5 == (i3 = dVar7.k) || i5 == dVar7.n || i5 == (i2 | 1) || i5 == (i3 | 1)) {
                        int i6 = this.f26106e.s;
                        if (i6 == 0) {
                            if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                                this.f26106e.s = 3;
                                d dVar8 = this.f26106e;
                                dVar8.r0 = dVar8.v.getControl().getCurrentPosition();
                                b(f2);
                            } else if (motionEvent.getX() < this.f26106e.S.getWidth() / 2) {
                                this.f26106e.s = 2;
                                d dVar9 = this.f26106e;
                                dVar9.M.changeBright(dVar9.Q, f3 > 0.0f);
                            } else {
                                this.f26106e.s = 1;
                                d dVar10 = this.f26106e;
                                dVar10.M.changeVolume(dVar10.Q, f3 > 0.0f);
                            }
                            d dVar11 = this.f26106e;
                            int i7 = dVar11.r;
                            int i8 = dVar11.n;
                            if (i7 != i8) {
                                if ((i7 & 1) > 0) {
                                    dVar11.n = i8 | 1;
                                } else {
                                    dVar11.n = i8 & (-2);
                                }
                                d dVar12 = this.f26106e;
                                dVar12.l0(dVar12.n);
                            }
                        } else if (i6 == 1) {
                            d dVar13 = this.f26106e;
                            int i9 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                            dVar13.M.changeVolume(dVar13.Q, i9 > 0);
                            if (i9 > 0) {
                                this.f26106e.onVolumeUp();
                            }
                        } else if (i6 == 2) {
                            d dVar14 = this.f26106e;
                            dVar14.M.changeBright(dVar14.Q, f3 > 0.0f);
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
                if (this.f26106e.v.getControl().isPlaying()) {
                    d dVar = this.f26106e;
                    int i2 = dVar.r;
                    int i3 = dVar.f26096g;
                    if (i2 != i3 && i2 != dVar.f26097h && i2 != dVar.q) {
                        if (i2 == dVar.f26098i) {
                            dVar.l0(i3);
                        }
                    } else {
                        d dVar2 = this.f26106e;
                        dVar2.l0(dVar2.f26098i);
                        this.f26106e.P();
                    }
                } else {
                    d dVar3 = this.f26106e;
                    int i4 = dVar3.r;
                    int i5 = dVar3.f26099j;
                    if (i4 == i5) {
                        dVar3.l0(dVar3.k);
                    } else if (i4 == (i5 | 1)) {
                        dVar3.l0(dVar3.k | 1);
                    } else {
                        int i6 = dVar3.k;
                        if (i4 == i6) {
                            dVar3.l0(i5);
                        } else if (i4 == (i6 | 1)) {
                            dVar3.l0(i5 | 1);
                        } else {
                            dVar3.l0(dVar3.f26095f);
                            this.f26106e.startPlay();
                            this.f26106e.i0();
                        }
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26107e;

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
            this.f26107e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    d dVar = this.f26107e;
                    if (dVar.r == dVar.n) {
                        if (dVar.s == 4) {
                            this.f26107e.Q();
                            this.f26107e.v0 = 0;
                            this.f26107e.w0 = 0;
                        } else {
                            d dVar2 = this.f26107e;
                            dVar2.r = -1;
                            if (dVar2.s != 3) {
                                if (this.f26107e.t != -1) {
                                    d dVar3 = this.f26107e;
                                    dVar3.l0(dVar3.t);
                                    this.f26107e.t = -1;
                                } else if (this.f26107e.v.getControl().isPlaying()) {
                                    d dVar4 = this.f26107e;
                                    dVar4.l0(dVar4.f26096g);
                                } else {
                                    d dVar5 = this.f26107e;
                                    dVar5.l0(dVar5.f26099j);
                                }
                            } else {
                                d dVar6 = this.f26107e;
                                dVar6.H.setCurrentDuration(dVar6.r0, true);
                                if (this.f26107e.r0 <= this.f26107e.v.getControl().getDuration()) {
                                    if (!this.f26107e.v.getControl().isPlaying()) {
                                        this.f26107e.v.getControl().start(this.f26107e.K0);
                                    }
                                    d dVar7 = this.f26107e;
                                    dVar7.l0(dVar7.f26096g);
                                }
                            }
                        }
                        d dVar8 = this.f26107e;
                        if (dVar8.e0) {
                            String str = null;
                            if (dVar8.s == 1) {
                                str = "c13361";
                            } else if (this.f26107e.s == 2) {
                                str = "c13346";
                            } else if (this.f26107e.s == 3) {
                                str = "c13362";
                            }
                            if (!m.isEmpty(str)) {
                                TiebaStatic.log(new StatisticItem(str).param("tid", this.f26107e.X).param("fid", this.f26107e.Y));
                            }
                        }
                        this.f26107e.s = 0;
                        return true;
                    }
                }
                return this.f26107e.q0.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
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
                dVar.l0(dVar.f26095f);
                this.a.p0();
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.v.clearCallbackAndRemoveFromWindow();
                this.a.n0();
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f26094e = 3000;
        this.f26095f = 8211;
        this.f26096g = 0;
        this.f26097h = 4;
        this.f26098i = w0.c1;
        this.f26099j = 8416;
        this.k = 0;
        this.l = 513;
        this.m = 259;
        this.n = 2048;
        this.o = 0;
        this.p = 4099;
        this.q = 0;
        this.r = 8211;
        this.s = 0;
        this.t = -1;
        this.u = new b(this);
        this.P = null;
        this.a0 = false;
        this.e0 = true;
        this.f0 = false;
        this.h0 = true;
        this.s0 = new int[2];
        this.v0 = 0;
        this.w0 = 0;
        this.z0 = false;
        this.A0 = null;
        this.D0 = false;
        this.F0 = -1L;
        this.G0 = new c(this);
        this.H0 = new g(this);
        this.I0 = new h(this);
        this.J0 = new i(this);
        this.K0 = new j(this);
        this.L0 = new a(this, 2000994);
        if (context == null || view == null) {
            return;
        }
        this.Q = context;
        this.Z = new l((Activity) context);
        this.R = view;
        this.i0 = n.i(this.Q);
        this.k0 = n.k(this.Q);
        a0();
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.r;
            if (i2 == this.f26097h || i2 == this.q) {
                l0(this.f26096g);
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.V && !"video_tab".equals(this.d0)) {
                this.f26098i = 104;
                this.f26099j = 8290;
            } else {
                this.f26098i = w0.c1;
                this.f26099j = 8418;
            }
            if (this.a0) {
                this.f26095f |= 1024;
                this.f26096g |= 1024;
                this.f26097h |= 1024;
                this.q |= 1024;
                this.f26098i |= 1024;
                this.f26099j |= 1024;
                this.k |= 1024;
                this.l |= 1024;
                this.m |= 1024;
                this.r |= 1024;
                return;
            }
            this.f26095f &= -1025;
            this.f26096g &= -1025;
            this.f26097h &= -1025;
            this.q &= -1025;
            this.f26098i &= -1025;
            this.f26099j &= -1025;
            this.k &= -1025;
            this.l &= -1025;
            this.m &= -1025;
            this.r &= -1025;
        }
    }

    public void N() {
        float dimension;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.I.changeViewLayout(this.V, this.a0);
            this.J.changeViewLayout(this.V, this.a0);
            Context context = this.Q;
            if (context == null || context.getResources() == null) {
                return;
            }
            if (this.V) {
                dimension = this.Q.getResources().getDimension(R.dimen.tbds44);
            } else if (this.a0) {
                dimension = this.Q.getResources().getDimension(R.dimen.tbds78);
            } else {
                dimension = this.Q.getResources().getDimension(R.dimen.tbds44);
            }
            int i2 = (int) dimension;
            this.C.setPadding(0, 0, "video_tab".equals(this.d0) ? 0 : i2, 0);
            SwitchImageView switchImageView = this.G;
            switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i2, 0);
            this.F.setPadding(i2, 0, 0, 0);
        }
    }

    public final void O(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, activity, z) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (this.V && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
            ViewGroup viewGroup = this.S;
            if (viewGroup == null) {
                return;
            }
            if (z) {
                viewGroup.setPadding(0, n.r((Activity) this.Q), 0, 0);
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
            this.S.setSystemUiVisibility(0);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.u);
            c.a.d.f.m.e.a().postDelayed(this.u, this.f26094e);
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
            if (!this.V) {
                R();
            } else if (this.r == this.n) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.addListener(new f(this));
                if (!this.u0) {
                    float width = this.R.getWidth() / this.S.getWidth();
                    float height = this.R.getHeight() / this.S.getHeight();
                    this.S.setPivotX(0.0f);
                    this.S.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.S, "ScaleX", 1.0f, width);
                    objectAnimator = ObjectAnimator.ofFloat(this.S, "ScaleY", 1.0f, height);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.J, "ScaleX", 1.0f, 1.0f / width);
                    ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.J, "ScaleY", 1.0f, 1.0f / height);
                    ViewGroup viewGroup = this.S;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.s0[0]);
                    ViewGroup viewGroup2 = this.S;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.s0[1]);
                    View view = this.N;
                    ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, view.getAlpha(), 0.0f);
                    OperableVideoShareView operableVideoShareView = this.J;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, AnimationProperty.OPACITY, operableVideoShareView.getAlpha(), 0.0f);
                    ofFloat2 = ofFloat7;
                    objectAnimator2 = ofFloat9;
                    ofFloat3 = ofFloat8;
                } else {
                    float width2 = this.k0 / this.S.getWidth();
                    float height2 = this.t0 / this.S.getHeight();
                    this.S.setPivotX(0.0f);
                    this.S.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.S, "ScaleX", 1.0f, width2);
                    ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.S, "ScaleY", 1.0f, height2);
                    ofFloat2 = ObjectAnimator.ofFloat(this.J, "ScaleX", 1.0f, 1.0f / width2);
                    ofFloat3 = ObjectAnimator.ofFloat(this.J, "ScaleY", 1.0f, 1.0f / height2);
                    ViewGroup viewGroup3 = this.S;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup3, "TranslationX", viewGroup3.getTranslationX(), 0.0f);
                    ViewGroup viewGroup4 = this.S;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup4, "TranslationY", viewGroup4.getTranslationY(), 0.0f);
                    OperableVideoShareView operableVideoShareView2 = this.J;
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
                int i2 = this.t;
                if (i2 != -1) {
                    this.r = i2;
                    this.t = -1;
                    if (i2 == this.o || i2 == this.f26098i || i2 == this.f26096g) {
                        this.v.getControl().start(this.K0);
                        l0(this.f26096g);
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
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.R == null || this.S == null || (tbVideoViewContainer = this.v) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        Context context = this.Q;
        if (context != null) {
            n.w(context, this.R);
        }
        if (this.a0) {
            if (this.N.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.N.getParent()).removeView(this.N);
            }
            if ((this.S.getParent() instanceof ViewGroup) && (this.R instanceof ViewGroup)) {
                this.a0 = false;
                this.f0 = true;
                ((ViewGroup) this.S.getParent()).removeView(this.S);
                ((ViewGroup) this.R).addView(this.S);
                this.f0 = false;
                O((Activity) this.Q, this.a0);
            }
            if (!this.V && z) {
                this.Z.l();
            }
        } else {
            if (this.Q != null) {
                if (!this.V && z) {
                    this.Z.l();
                }
                if (this.Q instanceof Activity) {
                    this.S.getLocationOnScreen(this.s0);
                    View findViewById = ((Activity) this.Q).findViewById(16908290);
                    if (findViewById instanceof ViewGroup) {
                        View childAt = ((ViewGroup) findViewById).getChildAt(0);
                        if (childAt instanceof ViewGroup) {
                            this.f0 = true;
                            ((ViewGroup) this.R).removeAllViews();
                            if (this.N == null) {
                                View view = new View(this.Q);
                                this.N = view;
                                view.setClickable(true);
                                this.N.setBackgroundColor(SkinManager.getColor(R.color.black_alpha100));
                                this.N.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            }
                            if (this.N.getParent() instanceof ViewGroup) {
                                ((ViewGroup) this.N.getParent()).removeView(this.N);
                            }
                            this.N.setAlpha(1.0f);
                            ViewGroup viewGroup = (ViewGroup) childAt;
                            viewGroup.addView(this.N);
                            viewGroup.addView(this.S);
                            this.f0 = false;
                            this.a0 = true;
                            O((Activity) this.Q, true);
                            c.a.z.c cVar = this.B0;
                            if (cVar != null && cVar.c()) {
                                this.B0.a();
                            }
                        }
                    }
                }
            }
            if (this.e0) {
                TiebaStatic.log(new StatisticItem("c13360").param("tid", this.X).param("fid", this.Y).param("obj_type", this.V ? 1 : 2));
            }
        }
        M();
        N();
        if (this.v.getControl().isPlaying()) {
            l0(this.f26096g);
        } else {
            l0(this.r);
        }
        this.G.switchState();
        g0(this.a0);
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
            if (isVideoCardMute) {
                this.v.getControl().setVolume(1.0f, 1.0f);
                t0.f(this.P, true);
                c.a.s0.j0.g.c.b().l(true);
                this.F.setState(0);
            } else {
                this.v.getControl().setVolume(0.0f, 0.0f);
                this.F.setState(1);
                t0.f(this.P, false);
                c.a.s0.j0.g.c.b().l(false);
            }
            TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.Z.i(true);
            } else {
                this.Z.i(false);
            }
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.Z.j();
            } else {
                this.Z.k();
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.H.showProgress();
            TBLottieAnimationView tBLottieAnimationView = this.y;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.clearAnimation();
                this.y.animate().alpha(0.0f).setDuration(200L).setListener(new e(this)).start();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public void a0() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (context = this.Q) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(X(), (ViewGroup) null);
        this.S = viewGroup;
        View view = this.R;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).addView(viewGroup);
        }
        this.P = new WeakReference<>(TbadkCoreApplication.getInst());
        this.w = (TbImageView) this.S.findViewById(R.id.video_thumbnail);
        this.x = this.S.findViewById(R.id.black_mask);
        this.y = (TBLottieAnimationView) this.S.findViewById(R.id.video_loading);
        this.z = (ImageView) this.S.findViewById(R.id.video_play);
        this.B = (PercentSizeView) this.S.findViewById(R.id.video_media_controller_mask);
        this.A = (ImageView) this.S.findViewById(R.id.video_pause);
        this.C = (TextView) this.S.findViewById(R.id.video_play_count);
        this.D = (TextView) this.S.findViewById(R.id.video_play_flag);
        this.E = (TextView) this.S.findViewById(R.id.video_duration);
        this.F = (SwitchImageView) this.S.findViewById(R.id.video_mute);
        this.G = (SwitchImageView) this.S.findViewById(R.id.video_full_screen);
        this.H = (OperableVideoMediaControllerView) this.S.findViewById(R.id.video_media_controller);
        this.I = (OperableVideoNetworkStateTipView) this.S.findViewById(R.id.video_network_state_tip);
        this.J = (OperableVideoShareView) this.S.findViewById(R.id.video_share_view);
        this.L = this.S.findViewById(R.id.video_back_btn_mask);
        this.K = (ImageView) this.S.findViewById(R.id.video_full_screen_back);
        this.M = (VideoGestureView) this.S.findViewById(R.id.video_gesture);
        this.O = (OperableVideoErrorView) this.S.findViewById(R.id.video_error_layout);
        this.J.setVideoContainer(this);
        this.y.addAnimatorListener(new C1575d(this));
        this.y.setAnimation(R.raw.lotti_video_loading);
        this.z.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.z.setOnClickListener(this);
        this.F.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
        this.F.setState(1);
        this.F.setOnClickListener(this);
        this.w.clearCornerFlag();
        this.w.setDrawCorner(false);
        this.w.setPlaceHolder(3);
        c.a.s0.b.g.b.h(this.x, R.color.CAM_X0601);
        this.H.setOnSeekBarChangeListener(this.H0);
        this.B.setHeightPercent(0.583f);
        this.B.setBackgroundResource(R.drawable.video_mask_bg);
        this.G.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
        this.G.setState(0);
        this.G.setOnClickListener(this);
        this.A.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.A.setOnClickListener(this);
        this.K.setOnClickListener(this);
        TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.Q);
        this.v = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setTryUseViewInSet(true);
        n0();
        this.I.setPlayViewOnClickListener(this);
        this.S.setOnClickListener(null);
        this.S.setOnTouchListener(this.J0);
        this.J.setOnTouchListener(this.J0);
        this.O.setOutOnClickListener(this);
        this.q0 = new GestureDetector(this.Q, this.I0);
        l0(this.f26095f);
        c.a.s0.s.u.c.d(this.x).s(R.array.Mask_X003);
        c.a.s0.s.u.c.d(this.C).y(R.array.S_O_X001);
        c.a.s0.s.u.c.d(this.E).y(R.array.S_O_X001);
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (TbSingleton.getInstance().isVideoCardMute()) {
                this.v.getControl().setVolume(0.0f, 0.0f);
                this.F.setState(1);
                return;
            }
            this.v.getControl().setVolume(1.0f, 1.0f);
            this.F.setState(0);
            c.a.s0.j0.g.c.b().l(true);
        }
    }

    public boolean c0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) ? this.a0 : invokeL.booleanValue;
    }

    @Override // c.a.t0.z2.v.a
    public void changeRenderViewMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.v.getControl().changeRenderViewMode(i2);
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.V && this.a0 : invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.C0 != null : invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (c.a.s0.b.d.q0() && "video_tab".equals(this.d0)) {
                return c.a.d.f.p.l.x();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.I;
            return operableVideoNetworkStateTipView != null && operableVideoNetworkStateTipView.isShowNetworkTips();
        }
        return invokeV.booleanValue;
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    @Override // c.a.t0.z2.v.a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.v.getControl().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.t0.z2.v.a
    public View getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.S : (View) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.u);
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.W);
            CustomMessage customMessage = new CustomMessage(2921387);
            customMessage.setTag(this.T);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // c.a.t0.z2.v.a
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.a0 : invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.v.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.U || this.v.getControl().isPlaying() : invokeV.booleanValue;
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.D0 = z;
        }
    }

    public void k0(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, kVar) == null) {
            this.E0 = kVar;
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            h0();
            if (this.r == this.n) {
                this.t = i2;
                return;
            }
            this.r = i2;
            this.w.setVisibility((i2 & 1) > 0 ? 0 : 8);
            this.x.setVisibility((i2 & 2) > 0 ? 0 : 8);
            this.h0 = (i2 & 4) > 0;
            this.y.clearAnimation();
            this.y.setVisibility(this.h0 ? 0 : 8);
            if (!this.h0) {
                this.y.cancelAnimation();
            } else {
                this.y.setAlpha(1.0f);
            }
            this.z.setVisibility((i2 & 8192) > 0 ? 0 : 8);
            this.A.setVisibility((i2 & 8) > 0 ? 0 : 8);
            int i3 = i2 & 16;
            this.C.setVisibility(i3 > 0 ? 0 : 8);
            this.E.setVisibility(i3 > 0 ? 0 : 8);
            this.F.setVisibility((i2 & 32) > 0 ? 0 : 8);
            this.G.setVisibility((i2 & 64) > 0 ? 0 : 8);
            int i4 = i2 & 128;
            this.H.setVisibility(i4 > 0 ? 0 : 8);
            this.B.setVisibility(i4 > 0 ? 0 : 8);
            if (this.H.getVisibility() == 0) {
                this.H.showProgress();
            }
            this.I.setVisibility((i2 & 256) > 0 ? 0 : 8);
            this.J.setVisibility((i2 & 512) > 0 ? 0 : 8);
            if (this.J.getVisibility() == 0) {
                this.J.setAlpha(1.0f);
            }
            int i5 = i2 & 1024;
            this.K.setVisibility(i5 > 0 ? 0 : 8);
            this.L.setVisibility(i5 > 0 ? 0 : 8);
            this.M.setVisibility((i2 & 2048) > 0 ? 0 : 8);
            this.O.setVisibility((i2 & 4096) <= 0 ? 8 : 0);
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.S.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.S.setSystemUiVisibility(4);
            } else {
                this.S.setSystemUiVisibility(5894);
            }
        }
    }

    public void n0() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (tbVideoViewContainer = this.v) != null && tbVideoViewContainer.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.S.addView(this.v, 0);
            this.v.setLayoutParams(layoutParams);
            this.H.setPlayer(this.v.getControl());
            this.v.getControl().setContinuePlayEnable(true);
            this.v.getControl().setOperableVideoContainer(this);
            this.v.getControl().setOnSurfaceDestroyedListener(this);
            this.v.getControl().setVideoStatData(this.b0);
            this.v.getControl().setThreadDataForStatistic(this.c0);
            this.v.getControl().getMediaProgressObserver().j(this.G0);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            l0(this.f26097h);
            this.h0 = true;
            this.H.showProgress();
            W();
        }
    }

    @Override // c.a.t0.z2.v.a
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.a0) {
                Q();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.v.a
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
            if (z) {
                this.z0 = isPlaying();
                this.y.cancelAnimation();
                int i2 = this.r;
                if (i2 == this.f26096g || i2 == this.f26097h || i2 == this.f26098i || i2 == this.f26095f || i2 == this.q) {
                    stopPlay();
                }
                int i3 = this.r | 1;
                this.r = i3;
                l0(i3);
            } else if (this.r == this.f26095f) {
                if (this.z0) {
                    startPlay();
                    i0();
                    return false;
                }
                return false;
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
        } else if (id != R.id.video_full_screen && id != R.id.video_full_screen_back) {
            if (id == R.id.video_replay) {
                l0(this.f26095f);
                startPlay();
                if (this.e0) {
                    TiebaStatic.log(new StatisticItem("c13345").param("tid", this.X).param("fid", this.Y).param("obj_type", this.V ? 1 : 2).param("obj_locate", this.a0 ? 1 : 2));
                }
                i0();
            } else if (id == R.id.video_play) {
                if (this.r == this.f26095f) {
                    startPlay();
                } else {
                    l0(this.f26098i);
                    P();
                    this.v.getControl().start(this.K0);
                }
                if (this.e0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.X).param("fid", this.Y).param("obj_type", this.V ? 1 : 2).param("obj_source", this.a0 ? 1 : 2).param("obj_locate", 1));
                }
                i0();
            } else if (id == R.id.video_pause) {
                l0(this.f26099j);
                h0();
                this.v.getControl().pause();
                if (this.e0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.X).param("fid", this.Y).param("obj_type", this.V ? 1 : 2).param("obj_source", this.a0 ? 1 : 2).param("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                l0(this.f26095f);
                startPlay();
            } else if (id == R.id.retry) {
                l0(this.f26095f);
                startPlay();
            }
        } else {
            Q();
        }
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            l0(this.l);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048615, this, i2, i3, obj)) == null) {
            l0(this.p);
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
                if (c.a.s0.b.d.l()) {
                    q0();
                } else {
                    o0();
                }
            }
            if (i2 == 701) {
                this.h0 = true;
                p0();
                return false;
            } else if (i2 == 702) {
                o0();
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
            if (this.U) {
                if (this.a0) {
                    Context context = this.Q;
                    if (context instanceof Activity) {
                        O((Activity) context, true);
                    }
                }
                this.v.getControl().start(this.K0);
            }
        }
    }

    @Override // c.a.t0.z2.v.a
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
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.f0) {
            return;
        }
        int i2 = this.r;
        if (i2 != this.f26099j && (i2 != this.k || this.v.getControl().isPlaying())) {
            if (this.r == this.l) {
                t0();
                l0(this.l);
                return;
            }
            t0();
            return;
        }
        t0();
        l0(this.f26099j);
    }

    @Override // c.a.t0.z2.v.a
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (TbSingleton.getInstance().isVideoCardMute() && this.v.getControl().isPlaying() && !t0.c() && !c.a.s0.j0.g.c.b().j()) {
                this.v.getControl().setVolume(1.0f, 1.0f);
                this.F.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.h0) {
                this.y.setAlpha(1.0f);
                this.y.setVisibility(0);
                this.z.setVisibility(8);
            } else {
                this.y.setVisibility(8);
                this.z.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.y;
            if (tBLottieAnimationView == null || !this.h0) {
                return;
            }
            tBLottieAnimationView.loop(true);
            this.y.setMinAndMaxFrame(14, 80);
            this.y.playAnimation();
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            l0(this.q);
            this.H.showProgress();
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
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || (tVar = this.b0) == null) {
            return;
        }
        t b2 = tVar.b();
        b2.a = this.d0;
        c.a.t0.z2.j.e(b2.m, "", "1", b2, this.v.getControl().getPcdnState());
    }

    @Override // c.a.t0.z2.v.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onClickListener) == null) {
            this.A0 = onClickListener;
        }
    }

    @Override // c.a.t0.z2.v.a
    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, e2Var) == null) || e2Var == null || e2Var.t1() == null) {
            return;
        }
        this.F0 = -1L;
        c.a.z.c cVar = this.B0;
        if (cVar != null) {
            cVar.d();
        }
        if (StringHelper.equals(this.W, e2Var.t1().video_url)) {
            return;
        }
        stopPlay();
        this.V = e2Var.t1().is_vertical.intValue() == 1;
        this.W = e2Var.t1().video_url;
        this.X = e2Var.v1();
        e2Var.t1().video_length.intValue();
        e2Var.t1().video_duration.intValue();
        this.Y = e2Var.U();
        this.C0 = e2Var.t1().mcn_ad_card;
        M();
        N();
        l0(this.f26095f);
        int intValue = e2Var.t1().video_duration.intValue() * 1000;
        this.H.initDuration(intValue);
        this.H.setPlayer(this.v.getControl());
        this.E.setText(StringHelper.stringForVideoTime(intValue));
        this.C.setText(String.format(this.Q.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(e2Var.t1().play_count.intValue())));
        this.I.setVideoLength(e2Var.t1().video_length.intValue());
        this.I.setVideoDuration(e2Var.t1().video_duration.intValue());
        this.I.setTid(this.X);
        this.c0 = e2Var;
        this.v.getControl().setThreadDataForStatistic(e2Var);
        this.D.setVisibility(8);
        this.w.setPlaceHolder(3);
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() != 2 && TbadkCoreApplication.getInst().getVideoAutoPlay() != 0) {
            this.w.startLoad(e2Var.t1().thumbnail_url, 10, false);
        } else if (!m.isEmpty(e2Var.t1().first_frame_thumbnail)) {
            this.w.startLoad(e2Var.t1().first_frame_thumbnail, 10, false);
        } else {
            this.w.startLoad(e2Var.t1().thumbnail_url, 10, false);
        }
        this.J.setShareData(e2Var);
    }

    @Override // c.a.t0.z2.v.a
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.d0 = str;
        }
    }

    @Override // c.a.t0.z2.v.a
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, onClickListener) == null) {
        }
    }

    @Override // c.a.t0.z2.v.a
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.g0 = str;
        }
    }

    @Override // c.a.t0.z2.v.a
    public void setStatistic(t tVar) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, tVar) == null) || (tbVideoViewContainer = this.v) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.b0 = tVar;
        this.v.getControl().setVideoStatData(tVar);
    }

    @Override // c.a.t0.z2.v.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bdUniqueId) == null) {
            this.T = bdUniqueId;
        }
    }

    @Override // c.a.t0.z2.v.a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || StringUtils.isNull(this.W)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.L0);
        if (f0()) {
            l0(this.m);
            return;
        }
        this.U = true;
        if (this.v.getControl().isPlaying()) {
            return;
        }
        TbVideoViewContainer e2 = TbVideoViewSet.d().e(this.W);
        if (e2 == null) {
            this.v.clearCallbackAndRemoveFromWindow();
            if (!StringUtils.isNull(this.v.getControl().getOriginUrl())) {
                TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.Q);
                this.v = tbVideoViewContainer;
                tbVideoViewContainer.getControl().setTryUseViewInSet(true);
            }
            n0();
            if (c.a.d.f.p.l.z()) {
                this.v.getControl().setVideoPath(this.W, this.X);
                this.v.getControl().setStageType(this.g0);
                if (!c.a.s0.b.d.l()) {
                    this.h0 = true;
                }
                p0();
                if (this.e0) {
                    s0();
                }
            }
        } else {
            TbVideoViewContainer tbVideoViewContainer2 = this.v;
            if (tbVideoViewContainer2 == e2) {
                if (tbVideoViewContainer2.getParent() == null || this.v.getParent() != e2.getParent()) {
                    this.v.clearCallbackAndRemoveFromWindow();
                    n0();
                }
            } else {
                tbVideoViewContainer2.clearCallbackAndRemoveFromWindow();
                e2.clearCallbackAndRemoveFromWindow();
                this.v = e2;
                e2.getControl().setTryUseViewInSet(true);
                n0();
            }
            this.v.getControl().monitorAndStatsAtPrepare();
            onPrepared();
            if (c.a.s0.b.d.l()) {
                q0();
            } else {
                o0();
            }
            if (this.e0) {
                s0();
            }
        }
        if (this.e0) {
            TiebaStatic.log(new StatisticItem("c13357").param("tid", this.X).param("fid", this.Y).param("obj_type", this.V ? 1 : 2).param("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // c.a.t0.z2.v.a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.U = false;
            TBLottieAnimationView tBLottieAnimationView = this.y;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.v.getControl().stop();
            this.v.clearCallbackAndRemoveFromWindow();
            this.H.resetProgress();
            l0(this.f26095f);
            MessageManager.getInstance().unRegisterListener(this.L0);
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.U = false;
            TBLottieAnimationView tBLottieAnimationView = this.y;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.v.getControl().stop();
            this.H.resetProgress();
            l0(this.f26095f);
            MessageManager.getInstance().unRegisterListener(this.L0);
        }
    }
}
