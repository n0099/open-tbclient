package c.a.s0.z2.r;

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
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.d1.u0;
import c.a.r0.s.r.d2;
import c.a.s0.z2.f;
import c.a.s0.z2.p;
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
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
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
public class d implements c.a.s0.z2.r.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public boolean A0;
    public PercentSizeView B;
    public View.OnClickListener B0;
    public TextView C;
    public c.a.z.c C0;
    public TextView D;
    public McnAdInfo D0;
    public TextView E;
    public boolean E0;
    public SwitchImageView F;
    public k F0;
    public SwitchImageView G;
    public long G0;
    public OperableVideoMediaControllerView H;
    public f.c H0;
    public OperableVideoNetworkStateTipView I;
    public SeekBar.OnSeekBarChangeListener I0;
    public OperableVideoShareView J;
    public GestureDetector.SimpleOnGestureListener J0;
    public ImageView K;
    public View.OnTouchListener K0;
    public View L;
    public TbVideoViewSet.b L0;
    public VideoGestureView M;
    public final CustomMessageListener M0;
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
    public int Y;
    public long Z;
    public c.a.s0.z2.j a0;
    public boolean b0;
    public p c0;
    public d2 d0;

    /* renamed from: e  reason: collision with root package name */
    public int f26427e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public int f26428f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public int f26429g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public int f26430h;
    public String h0;

    /* renamed from: i  reason: collision with root package name */
    public int f26431i;
    public boolean i0;

    /* renamed from: j  reason: collision with root package name */
    public int f26432j;

    /* renamed from: k  reason: collision with root package name */
    public int f26433k;
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
    public Runnable u;
    public int u0;
    public TbCyberVideoView v;
    public boolean v0;
    public TbImageView w;
    public int w0;
    public View x;
    public int x0;
    public TBLottieAnimationView y;
    public float y0;
    public ImageView z;
    public int z0;

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
        public final /* synthetic */ d f26434e;

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
            this.f26434e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f26434e;
                dVar.r0(dVar.f26429g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26435e;

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
            this.f26435e = dVar;
        }

        @Override // c.a.s0.z2.f.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f26435e.G0 <= 0) {
                    this.f26435e.G0 = i3;
                }
                if (this.f26435e.k0()) {
                    d dVar = this.f26435e;
                    if (!dVar.V && !dVar.b0 && dVar.E0) {
                        if (c.a.z.b.b().a(this.f26435e.D0.jump_url)) {
                            return;
                        }
                        long j2 = i3;
                        boolean z = j2 >= this.f26435e.D0.ad_start_time.longValue() * 1000 && j2 < this.f26435e.D0.ad_end_time.longValue() * 1000;
                        boolean z2 = this.f26435e.G0 >= (this.f26435e.D0.ad_start_time.longValue() * 1000) + 1000;
                        if (z) {
                            if (!this.f26435e.C0.c()) {
                                c.a.z.a aVar = new c.a.z.a();
                                aVar.f27598b = this.f26435e.D0.card_title;
                                aVar.f27599c = this.f26435e.D0.button_title;
                                aVar.f27600d = this.f26435e.D0.jump_url;
                                aVar.a = this.f26435e.D0.pic_url;
                                aVar.f27602f = String.valueOf(this.f26435e.Z);
                                d dVar2 = this.f26435e;
                                aVar.f27601e = dVar2.X;
                                aVar.f27603g = dVar2.e0();
                                if (z2) {
                                    this.f26435e.C0.f(aVar, (ViewGroup) this.f26435e.R);
                                } else {
                                    this.f26435e.C0.e(aVar, (ViewGroup) this.f26435e.R);
                                }
                            }
                        } else if (this.f26435e.C0.c()) {
                            this.f26435e.C0.a();
                        }
                    }
                }
                if (this.f26435e.F0 != null) {
                    this.f26435e.F0.a(i2, i3);
                }
            }
        }
    }

    /* renamed from: c.a.s0.z2.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1534d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26436e;

        public C1534d(d dVar) {
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
            this.f26436e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f26436e.y.setVisibility(8);
                this.f26436e.z.setVisibility(0);
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
        public final /* synthetic */ d f26437e;

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
            this.f26437e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f26437e.y.setVisibility(8);
                this.f26437e.z.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f26437e.O();
                if (!this.f26437e.U) {
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
        public final /* synthetic */ d f26438e;

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
            this.f26438e = dVar;
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
                this.f26438e.S.setScaleX(1.0f);
                this.f26438e.S.setScaleY(1.0f);
                this.f26438e.S.setTranslationX(0.0f);
                this.f26438e.S.setTranslationY(0.0f);
                this.f26438e.J.setScaleX(1.0f);
                this.f26438e.J.setScaleY(1.0f);
                this.f26438e.S.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                if (this.f26438e.v0) {
                    return;
                }
                this.f26438e.X();
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
        public final /* synthetic */ d f26439e;

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
            this.f26439e = dVar;
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
                d dVar = this.f26439e;
                dVar.r0(dVar.f26431i);
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
            if (!this.f26439e.v.isPlaying()) {
                d dVar = this.f26439e;
                dVar.v.start(dVar.L0);
            }
            this.f26439e.V();
            if (this.f26439e.f0) {
                TiebaStatic.log(new StatisticItem("c13355").param("tid", this.f26439e.X).param("fid", this.f26439e.Z).param("obj_type", this.f26439e.V ? 1 : 2).param("obj_locate", this.f26439e.b0 ? 1 : 2));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26440e;

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
            this.f26440e = dVar;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f26440e.w0 == i3 && this.f26440e.x0 == i2) {
                    return;
                }
                d dVar = this.f26440e;
                dVar.v0 = dVar.w0 - i3 > 0 || ((float) i3) < this.f26440e.k0 / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26440e.S.getLayoutParams();
                if (i3 != this.f26440e.w0) {
                    int i4 = this.f26440e.u0 - i3;
                    int i5 = (int) (i4 * this.f26440e.y0);
                    if (i5 < this.f26440e.z0) {
                        i5 = this.f26440e.z0;
                        i4 = (int) (i5 / this.f26440e.y0);
                    }
                    if (i5 != this.f26440e.z0) {
                        layoutParams.height = i4;
                        layoutParams.width = i5;
                        this.f26440e.S.setLayoutParams(layoutParams);
                    }
                    this.f26440e.w0 = i3;
                    d dVar2 = this.f26440e;
                    dVar2.S.setTranslationY(dVar2.w0);
                }
                if (i2 != this.f26440e.w0) {
                    this.f26440e.x0 = i2;
                    d dVar3 = this.f26440e;
                    dVar3.S.setTranslationX(dVar3.x0 + ((this.f26440e.q0 - layoutParams.width) / 2.0f));
                }
                this.f26440e.N.setAlpha((layoutParams.width - this.f26440e.z0) / (this.f26440e.q0 - this.f26440e.z0));
                if (this.f26440e.J.getVisibility() == 0) {
                    float f2 = this.f26440e.k0 / 6.0f;
                    float f3 = (f2 - i3) / f2;
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                    this.f26440e.J.setAlpha(f3);
                }
            }
        }

        public final void b(float f2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (f2 > 0.0f) {
                    d dVar = this.f26440e;
                    dVar.s0 -= 1000;
                    z = true;
                } else {
                    this.f26440e.s0 += 1000;
                    z = false;
                }
                int duration = this.f26440e.v.getDuration();
                if (this.f26440e.s0 < 0) {
                    this.f26440e.s0 = 0;
                } else if (this.f26440e.s0 > duration) {
                    this.f26440e.s0 = duration;
                }
                String str = StringHelper.stringForVideoTime(this.f26440e.s0) + " / " + StringHelper.stringForVideoTime(duration);
                VideoGestureView videoGestureView = this.f26440e.M;
                if (videoGestureView != null) {
                    videoGestureView.changeFFRew(z, str);
                }
                d dVar2 = this.f26440e;
                dVar2.H.setCurrentDuration(dVar2.s0, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.f26440e.v.isPlaying()) {
                    this.f26440e.v.pause();
                    d dVar = this.f26440e;
                    if (dVar.r == dVar.f26431i) {
                        dVar.r0(dVar.f26432j);
                    } else {
                        dVar.r0(dVar.f26433k);
                    }
                    this.f26440e.x0(R.id.video_pause);
                    return true;
                }
                d dVar2 = this.f26440e;
                int i2 = dVar2.r;
                int i3 = dVar2.f26432j;
                if (i2 != i3 && i2 != (i3 | 1)) {
                    int i4 = dVar2.f26433k;
                    if (i2 == i4 || i2 == (i4 | 1)) {
                        d dVar3 = this.f26440e;
                        dVar3.r0(dVar3.f26429g);
                        d dVar4 = this.f26440e;
                        dVar4.v.start(dVar4.L0);
                        this.f26440e.x0(R.id.video_play);
                        return true;
                    }
                    return true;
                }
                d dVar5 = this.f26440e;
                dVar5.r0(dVar5.f26431i);
                this.f26440e.V();
                d dVar6 = this.f26440e;
                dVar6.v.start(dVar6.L0);
                this.f26440e.x0(R.id.video_play);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                this.f26440e.s = 0;
                d dVar = this.f26440e;
                if (dVar.b0) {
                    dVar.T((Activity) dVar.Q, true);
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
                if (!this.f26440e.i0(motionEvent)) {
                    return super.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                Context context = this.f26440e.Q;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.f26440e.Q).disableSwipeJustOnce();
                } else {
                    Context context2 = this.f26440e.Q;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.f26440e.Q).disableSwipeJustOnce();
                    }
                }
                d dVar = this.f26440e;
                if (dVar.V && dVar.j0()) {
                    int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                    int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                    int i4 = this.f26440e.s;
                    if (i4 != 0) {
                        if (i4 == 4) {
                            a(rawX, rawY);
                        }
                    } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                        if (this.f26440e.v.isPlaying()) {
                            this.f26440e.v.pause();
                            d dVar2 = this.f26440e;
                            dVar2.r0(dVar2.o);
                        }
                        this.f26440e.s = 4;
                        d dVar3 = this.f26440e;
                        dVar3.t = dVar3.r;
                        d dVar4 = this.f26440e;
                        dVar4.r = dVar4.n;
                        dVar4.u0 = dVar4.S.getMeasuredHeight();
                        d dVar5 = this.f26440e;
                        dVar5.y0 = dVar5.q0 / this.f26440e.u0;
                        d dVar6 = this.f26440e;
                        dVar6.z0 = (int) (dVar6.R.getWidth() * 1.2f);
                        a(rawX, rawY);
                    }
                } else {
                    d dVar7 = this.f26440e;
                    int i5 = dVar7.r;
                    if (i5 == dVar7.f26429g || i5 == dVar7.f26431i || i5 == (i2 = dVar7.f26432j) || i5 == (i3 = dVar7.f26433k) || i5 == dVar7.n || i5 == (i2 | 1) || i5 == (i3 | 1)) {
                        int i6 = this.f26440e.s;
                        if (i6 == 0) {
                            if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                                this.f26440e.s = 3;
                                d dVar8 = this.f26440e;
                                dVar8.s0 = dVar8.v.getCurrentPosition();
                                b(f2);
                            } else if (motionEvent.getX() < this.f26440e.S.getWidth() / 2) {
                                this.f26440e.s = 2;
                                d dVar9 = this.f26440e;
                                dVar9.M.changeBright(dVar9.Q, f3 > 0.0f);
                            } else {
                                this.f26440e.s = 1;
                                d dVar10 = this.f26440e;
                                dVar10.M.changeVolume(dVar10.Q, f3 > 0.0f);
                            }
                            d dVar11 = this.f26440e;
                            int i7 = dVar11.r;
                            int i8 = dVar11.n;
                            if (i7 != i8) {
                                if ((i7 & 1) > 0) {
                                    dVar11.n = i8 | 1;
                                } else {
                                    dVar11.n = i8 & (-2);
                                }
                                d dVar12 = this.f26440e;
                                dVar12.r0(dVar12.n);
                            }
                        } else if (i6 == 1) {
                            d dVar13 = this.f26440e;
                            int i9 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                            dVar13.M.changeVolume(dVar13.Q, i9 > 0);
                            if (i9 > 0) {
                                this.f26440e.J();
                            }
                        } else if (i6 == 2) {
                            d dVar14 = this.f26440e;
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
                if (this.f26440e.v.isPlaying()) {
                    d dVar = this.f26440e;
                    int i2 = dVar.r;
                    int i3 = dVar.f26429g;
                    if (i2 != i3 && i2 != dVar.f26430h && i2 != dVar.q) {
                        if (i2 == dVar.f26431i) {
                            dVar.r0(i3);
                        }
                    } else {
                        d dVar2 = this.f26440e;
                        dVar2.r0(dVar2.f26431i);
                        this.f26440e.V();
                    }
                } else {
                    d dVar3 = this.f26440e;
                    int i4 = dVar3.r;
                    int i5 = dVar3.f26432j;
                    if (i4 == i5) {
                        dVar3.r0(dVar3.f26433k);
                    } else if (i4 == (i5 | 1)) {
                        dVar3.r0(dVar3.f26433k | 1);
                    } else {
                        int i6 = dVar3.f26433k;
                        if (i4 == i6) {
                            dVar3.r0(i5);
                        } else if (i4 == (i6 | 1)) {
                            dVar3.r0(i5 | 1);
                        } else {
                            dVar3.r0(dVar3.f26428f);
                            this.f26440e.startPlay();
                            this.f26440e.o0();
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
        public final /* synthetic */ d f26441e;

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
            this.f26441e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    d dVar = this.f26441e;
                    if (dVar.r == dVar.n) {
                        if (dVar.s == 4) {
                            this.f26441e.W();
                            this.f26441e.w0 = 0;
                            this.f26441e.x0 = 0;
                        } else {
                            d dVar2 = this.f26441e;
                            dVar2.r = -1;
                            if (dVar2.s != 3) {
                                if (this.f26441e.t != -1) {
                                    d dVar3 = this.f26441e;
                                    dVar3.r0(dVar3.t);
                                    this.f26441e.t = -1;
                                } else if (this.f26441e.v.isPlaying()) {
                                    d dVar4 = this.f26441e;
                                    dVar4.r0(dVar4.f26429g);
                                } else {
                                    d dVar5 = this.f26441e;
                                    dVar5.r0(dVar5.f26432j);
                                }
                            } else {
                                d dVar6 = this.f26441e;
                                dVar6.H.setCurrentDuration(dVar6.s0, true);
                                if (this.f26441e.s0 <= this.f26441e.v.getDuration()) {
                                    if (!this.f26441e.v.isPlaying()) {
                                        d dVar7 = this.f26441e;
                                        dVar7.v.start(dVar7.L0);
                                    }
                                    d dVar8 = this.f26441e;
                                    dVar8.r0(dVar8.f26429g);
                                }
                            }
                        }
                        d dVar9 = this.f26441e;
                        if (dVar9.f0) {
                            String str = null;
                            if (dVar9.s == 1) {
                                str = "c13361";
                            } else if (this.f26441e.s == 2) {
                                str = "c13346";
                            } else if (this.f26441e.s == 3) {
                                str = "c13362";
                            }
                            if (!l.isEmpty(str)) {
                                TiebaStatic.log(new StatisticItem(str).param("tid", this.f26441e.X).param("fid", this.f26441e.Z));
                            }
                        }
                        this.f26441e.s = 0;
                        return true;
                    }
                }
                return this.f26441e.r0.onTouchEvent(motionEvent);
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
                dVar.r0(dVar.f26428f);
                this.a.v0();
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.v.clearCallbackAndRemoveFromWindow();
                this.a.t0();
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
        this.f26427e = 3000;
        this.f26428f = 8211;
        this.f26429g = 0;
        this.f26430h = 4;
        this.f26431i = w0.c1;
        this.f26432j = 8416;
        this.f26433k = 0;
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
        this.Q = context;
        this.a0 = new c.a.s0.z2.j((Activity) context);
        this.R = view;
        this.k0 = m.i(this.Q);
        this.q0 = m.k(this.Q);
        g0();
    }

    @Override // c.a.s0.z2.r.a
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b0) {
                W();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.r.a
    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.v.getRenderView().setDisplayMode(i2);
        }
    }

    @Override // c.a.s0.z2.r.a
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TbSingleton.getInstance().isVideoCardMute() && this.v.isPlaying() && !u0.c()) {
                this.v.setVolume(1.0f, 1.0f);
                this.F.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.r.a
    public void N(p pVar) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) || (tbCyberVideoView = this.v) == null) {
            return;
        }
        this.c0 = pVar;
        tbCyberVideoView.setVideoStatData(pVar);
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = this.r;
            if (i2 == this.f26430h || i2 == this.q) {
                r0(this.f26429g);
            }
        }
    }

    @Override // c.a.s0.z2.r.a
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.V && !"video_tab".equals(this.e0)) {
                this.f26431i = 104;
                this.f26432j = 8290;
            } else {
                this.f26431i = w0.c1;
                this.f26432j = 8418;
            }
            if (this.b0) {
                this.f26428f |= 1024;
                this.f26429g |= 1024;
                this.f26430h |= 1024;
                this.q |= 1024;
                this.f26431i |= 1024;
                this.f26432j |= 1024;
                this.f26433k |= 1024;
                this.l |= 1024;
                this.m |= 1024;
                this.r |= 1024;
                return;
            }
            this.f26428f &= -1025;
            this.f26429g &= -1025;
            this.f26430h &= -1025;
            this.q &= -1025;
            this.f26431i &= -1025;
            this.f26432j &= -1025;
            this.f26433k &= -1025;
            this.l &= -1025;
            this.m &= -1025;
            this.r &= -1025;
        }
    }

    @Override // c.a.s0.z2.r.a
    public boolean R(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (z) {
                this.A0 = isPlaying();
                this.y.cancelAnimation();
                int i2 = this.r;
                if (i2 == this.f26429g || i2 == this.f26430h || i2 == this.f26431i || i2 == this.f26428f || i2 == this.q) {
                    stopPlay();
                }
                int i3 = this.r | 1;
                this.r = i3;
                r0(i3);
            } else if (this.r == this.f26428f) {
                if (this.A0) {
                    startPlay();
                    o0();
                    return false;
                }
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void S() {
        float dimension;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.I.changeViewLayout(this.V, this.b0);
            this.J.changeViewLayout(this.V, this.b0);
            Context context = this.Q;
            if (context == null || context.getResources() == null) {
                return;
            }
            if (this.V) {
                dimension = this.Q.getResources().getDimension(R.dimen.tbds44);
            } else if (this.b0) {
                dimension = this.Q.getResources().getDimension(R.dimen.tbds78);
            } else {
                dimension = this.Q.getResources().getDimension(R.dimen.tbds44);
            }
            int i2 = (int) dimension;
            this.C.setPadding(0, 0, "video_tab".equals(this.e0) ? 0 : i2, 0);
            SwitchImageView switchImageView = this.G;
            switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i2, 0);
            this.F.setPadding(i2, 0, 0, 0);
        }
    }

    public final void T(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, activity, z) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (this.V && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
            ViewGroup viewGroup = this.S;
            if (viewGroup == null) {
                return;
            }
            if (z) {
                viewGroup.setPadding(0, m.r((Activity) this.Q), 0, 0);
            } else {
                viewGroup.setPadding(0, 0, 0, 0);
            }
        } else if (z) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags |= 1024;
            activity.getWindow().setAttributes(attributes);
            s0();
        } else {
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.S.setSystemUiVisibility(0);
        }
    }

    @Override // c.a.s0.z2.r.a
    public void U(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.u);
            c.a.d.f.m.e.a().postDelayed(this.u, this.f26427e);
        }
    }

    public final void W() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (!this.V) {
                X();
            } else if (this.r == this.n) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.addListener(new f(this));
                if (!this.v0) {
                    float width = this.R.getWidth() / this.S.getWidth();
                    float height = this.R.getHeight() / this.S.getHeight();
                    this.S.setPivotX(0.0f);
                    this.S.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.S, "ScaleX", 1.0f, width);
                    objectAnimator = ObjectAnimator.ofFloat(this.S, "ScaleY", 1.0f, height);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.J, "ScaleX", 1.0f, 1.0f / width);
                    ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.J, "ScaleY", 1.0f, 1.0f / height);
                    ViewGroup viewGroup = this.S;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.t0[0]);
                    ViewGroup viewGroup2 = this.S;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.t0[1]);
                    View view = this.N;
                    ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, view.getAlpha(), 0.0f);
                    OperableVideoShareView operableVideoShareView = this.J;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, AnimationProperty.OPACITY, operableVideoShareView.getAlpha(), 0.0f);
                    ofFloat2 = ofFloat7;
                    objectAnimator2 = ofFloat9;
                    ofFloat3 = ofFloat8;
                } else {
                    float width2 = this.q0 / this.S.getWidth();
                    float height2 = this.u0 / this.S.getHeight();
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
                    if (i2 == this.o || i2 == this.f26431i || i2 == this.f26429g) {
                        this.v.start(this.L0);
                        r0(this.f26429g);
                    }
                }
            } else {
                X();
            }
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Y(true);
        }
    }

    public void Y(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (view = this.R) == null || this.S == null || this.v == null) {
            return;
        }
        Context context = this.Q;
        if (context != null) {
            m.w(context, view);
        }
        if (this.b0) {
            if (this.N.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.N.getParent()).removeView(this.N);
            }
            if ((this.S.getParent() instanceof ViewGroup) && (this.R instanceof ViewGroup)) {
                this.b0 = false;
                this.g0 = true;
                ((ViewGroup) this.S.getParent()).removeView(this.S);
                ((ViewGroup) this.R).addView(this.S);
                this.g0 = false;
                T((Activity) this.Q, this.b0);
            }
            if (!this.V && z) {
                this.a0.l();
            }
        } else {
            if (this.Q != null) {
                if (!this.V && z) {
                    this.a0.l();
                }
                if (this.Q instanceof Activity) {
                    this.S.getLocationOnScreen(this.t0);
                    View findViewById = ((Activity) this.Q).findViewById(16908290);
                    if (findViewById instanceof ViewGroup) {
                        View childAt = ((ViewGroup) findViewById).getChildAt(0);
                        if (childAt instanceof ViewGroup) {
                            this.g0 = true;
                            ((ViewGroup) this.R).removeAllViews();
                            if (this.N == null) {
                                View view2 = new View(this.Q);
                                this.N = view2;
                                view2.setClickable(true);
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
                            this.g0 = false;
                            this.b0 = true;
                            T((Activity) this.Q, true);
                            c.a.z.c cVar = this.C0;
                            if (cVar != null && cVar.c()) {
                                this.C0.a();
                            }
                        }
                    }
                }
            }
            if (this.f0) {
                TiebaStatic.log(new StatisticItem("c13360").param("tid", this.X).param("fid", this.Z).param("obj_type", this.V ? 1 : 2));
            }
        }
        Q();
        S();
        if (this.v.isPlaying()) {
            r0(this.f26429g);
        } else {
            r0(this.r);
        }
        this.G.switchState();
        m0(this.b0);
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
            if (isVideoCardMute) {
                this.v.setVolume(1.0f, 1.0f);
                u0.f(this.P, true);
                this.F.setState(0);
            } else {
                this.v.setVolume(0.0f, 0.0f);
                this.F.setState(1);
                u0.f(this.P, false);
            }
            TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                this.a0.i(true);
            } else {
                this.a0.i(false);
            }
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                this.a0.j();
            } else {
                this.a0.k();
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.H.showProgress();
            TBLottieAnimationView tBLottieAnimationView = this.y;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.clearAnimation();
                this.y.animate().alpha(0.0f).setDuration(200L).setListener(new e(this)).start();
            }
        }
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? R.layout.operable_video_container : invokeV.intValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public void g0() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (context = this.Q) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d0(), (ViewGroup) null);
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
        this.y.addAnimatorListener(new C1534d(this));
        this.y.setAnimation(R.raw.lotti_video_loading);
        this.z.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.z.setOnClickListener(this);
        this.F.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
        this.F.setState(1);
        this.F.setOnClickListener(this);
        this.w.clearCornerFlag();
        this.w.setDrawCorner(false);
        this.w.setPlaceHolder(3);
        c.a.r0.b.g.b.h(this.x, R.color.CAM_X0601);
        this.H.setOnSeekBarChangeListener(this.I0);
        this.B.setHeightPercent(0.583f);
        this.B.setBackgroundResource(R.drawable.video_mask_bg);
        this.G.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
        this.G.setState(0);
        this.G.setOnClickListener(this);
        this.A.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.A.setOnClickListener(this);
        this.K.setOnClickListener(this);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(this.Q);
        this.v = tbCyberVideoView;
        tbCyberVideoView.setTryUseViewInSet(true);
        t0();
        this.I.setPlayViewOnClickListener(this);
        this.S.setOnClickListener(null);
        this.S.setOnTouchListener(this.K0);
        this.J.setOnTouchListener(this.K0);
        this.O.setOutOnClickListener(this);
        this.r0 = new GestureDetector(this.Q, this.J0);
        r0(this.f26428f);
        this.C0 = new c.a.z.c(this.Q);
        c.a.r0.s.v.c.d(this.x).s(R.array.Mask_X003);
        c.a.r0.s.v.c.d(this.C).y(R.array.S_O_X001);
        c.a.r0.s.v.c.d(this.E).y(R.array.S_O_X001);
    }

    @Override // c.a.s0.z2.r.a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.v.getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.s0.z2.r.a
    public View getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.S : (View) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (TbSingleton.getInstance().isVideoCardMute()) {
                this.v.setVolume(0.0f, 0.0f);
                this.F.setState(1);
                return;
            }
            this.v.setVolume(1.0f, 1.0f);
            this.F.setState(0);
        }
    }

    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) ? this.b0 : invokeL.booleanValue;
    }

    @Override // c.a.s0.z2.r.a
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.b0 : invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.r.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.U || this.v.isPlaying() : invokeV.booleanValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.V && this.b0 : invokeV.booleanValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.D0 != null : invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (c.a.r0.b.d.q0() && "video_tab".equals(this.e0)) {
                return c.a.d.f.p.k.x();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.I;
            return operableVideoNetworkStateTipView != null && operableVideoNetworkStateTipView.isShowNetworkTips();
        }
        return invokeV.booleanValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.u);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.W);
            CustomMessage customMessage = new CustomMessage(2921387);
            customMessage.setTag(this.T);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        x0(id);
        if (id == R.id.video_mute) {
            Z();
        } else if (id != R.id.video_full_screen && id != R.id.video_full_screen_back) {
            if (id == R.id.video_replay) {
                r0(this.f26428f);
                startPlay();
                if (this.f0) {
                    TiebaStatic.log(new StatisticItem("c13345").param("tid", this.X).param("fid", this.Z).param("obj_type", this.V ? 1 : 2).param("obj_locate", this.b0 ? 1 : 2));
                }
                o0();
            } else if (id == R.id.video_play) {
                if (this.r == this.f26428f) {
                    startPlay();
                } else {
                    r0(this.f26431i);
                    V();
                    this.v.start(this.L0);
                }
                if (this.f0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.X).param("fid", this.Z).param("obj_type", this.V ? 1 : 2).param("obj_source", this.b0 ? 1 : 2).param("obj_locate", 1));
                }
                o0();
            } else if (id == R.id.video_pause) {
                r0(this.f26432j);
                n0();
                this.v.pause();
                if (this.f0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.X).param("fid", this.Z).param("obj_type", this.V ? 1 : 2).param("obj_source", this.b0 ? 1 : 2).param("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                r0(this.f26428f);
                startPlay();
            } else if (id == R.id.retry) {
                r0(this.f26428f);
                startPlay();
            }
        } else {
            W();
        }
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            r0(this.l);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048613, this, i2, i3, obj)) == null) {
            r0(this.p);
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
                w0();
            }
            if (i2 == 701) {
                this.i0 = true;
                v0();
                return false;
            } else if (i2 == 702) {
                u0();
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
            h0();
            if (this.U) {
                if (this.b0) {
                    Context context = this.Q;
                    if (context instanceof Activity) {
                        T((Activity) context, true);
                    }
                }
                this.v.start(this.L0);
            }
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
    public void onSurfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.g0) {
            return;
        }
        int i2 = this.r;
        if (i2 != this.f26432j && (i2 != this.f26433k || this.v.isPlaying())) {
            if (this.r == this.l) {
                z0();
                r0(this.l);
                return;
            }
            z0();
            return;
        }
        z0();
        r0(this.f26432j);
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.E0 = z;
        }
    }

    public void q0(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, kVar) == null) {
            this.F0 = kVar;
        }
    }

    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            n0();
            if (this.r == this.n) {
                this.t = i2;
                return;
            }
            this.r = i2;
            this.w.setVisibility((i2 & 1) > 0 ? 0 : 8);
            this.x.setVisibility((i2 & 2) > 0 ? 0 : 8);
            this.i0 = (i2 & 4) > 0;
            this.y.clearAnimation();
            this.y.setVisibility(this.i0 ? 0 : 8);
            if (!this.i0) {
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

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
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

    @Override // c.a.s0.z2.r.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onClickListener) == null) {
            this.B0 = onClickListener;
        }
    }

    @Override // c.a.s0.z2.r.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, d2Var) == null) || d2Var == null || d2Var.t1() == null) {
            return;
        }
        this.G0 = -1L;
        c.a.z.c cVar = this.C0;
        if (cVar != null) {
            cVar.d();
        }
        if (StringHelper.equals(this.W, d2Var.t1().video_url)) {
            return;
        }
        stopPlay();
        this.V = d2Var.t1().is_vertical.intValue() == 1;
        this.W = d2Var.t1().video_url;
        this.X = d2Var.v1();
        d2Var.t1().video_length.intValue();
        this.Y = d2Var.t1().video_duration.intValue();
        this.Z = d2Var.U();
        this.D0 = d2Var.t1().mcn_ad_card;
        Q();
        S();
        r0(this.f26428f);
        int intValue = d2Var.t1().video_duration.intValue() * 1000;
        this.H.initDuration(intValue);
        this.H.setPlayer(this.v);
        this.E.setText(StringHelper.stringForVideoTime(intValue));
        this.C.setText(String.format(this.Q.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(d2Var.t1().play_count.intValue())));
        this.I.setVideoLength(d2Var.t1().video_length.intValue());
        this.I.setVideoDuration(d2Var.t1().video_duration.intValue());
        this.I.setTid(this.X);
        this.d0 = d2Var;
        this.v.setThreadDataForStatistic(d2Var);
        this.D.setVisibility(8);
        this.w.setPlaceHolder(3);
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() != 2 && TbadkCoreApplication.getInst().getVideoAutoPlay() != 0) {
            this.w.startLoad(d2Var.t1().thumbnail_url, 10, false);
        } else if (!l.isEmpty(d2Var.t1().first_frame_thumbnail)) {
            this.w.startLoad(d2Var.t1().first_frame_thumbnail, 10, false);
        } else {
            this.w.startLoad(d2Var.t1().thumbnail_url, 10, false);
        }
        this.J.setShareData(d2Var);
    }

    @Override // c.a.s0.z2.r.a
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.e0 = str;
        }
    }

    @Override // c.a.s0.z2.r.a
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.h0 = str;
        }
    }

    @Override // c.a.s0.z2.r.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bdUniqueId) == null) {
            this.T = bdUniqueId;
        }
    }

    @Override // c.a.s0.z2.r.a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || StringUtils.isNull(this.W)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.M0);
        if (l0()) {
            r0(this.m);
            return;
        }
        this.U = true;
        if (this.v.isPlaying()) {
            return;
        }
        TbCyberVideoView e2 = TbVideoViewSet.d().e(this.W);
        if (e2 == null) {
            this.v.clearCallbackAndRemoveFromWindow();
            if (!StringUtils.isNull(this.v.getOriginUrl())) {
                TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(this.Q);
                this.v = tbCyberVideoView;
                tbCyberVideoView.setTryUseViewInSet(true);
            }
            t0();
            if (c.a.d.f.p.k.z()) {
                this.v.setVideoDuration(this.Y);
                this.v.setVideoPath(this.W, this.X);
                this.v.setStageType(this.h0);
                v0();
                if (this.f0) {
                    y0();
                }
            }
        } else {
            TbCyberVideoView tbCyberVideoView2 = this.v;
            if (tbCyberVideoView2 == e2) {
                if (tbCyberVideoView2.getParent() == null || this.v.getParent() != e2.getParent()) {
                    this.v.clearCallbackAndRemoveFromWindow();
                    t0();
                }
            } else {
                tbCyberVideoView2.clearCallbackAndRemoveFromWindow();
                e2.clearCallbackAndRemoveFromWindow();
                this.v = e2;
                e2.setTryUseViewInSet(true);
                t0();
            }
            this.v.monitorAndStatsAtPrepare();
            onPrepared();
            w0();
            if (this.f0) {
                y0();
            }
        }
        if (this.f0) {
            TiebaStatic.log(new StatisticItem("c13357").param("tid", this.X).param("fid", this.Z).param("obj_type", this.V ? 1 : 2).param("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // c.a.s0.z2.r.a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.U = false;
            TBLottieAnimationView tBLottieAnimationView = this.y;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.v.stop();
            this.v.clearCallbackAndRemoveFromWindow();
            this.H.resetProgress();
            r0(this.f26428f);
            MessageManager.getInstance().unRegisterListener(this.M0);
        }
    }

    public void t0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (tbCyberVideoView = this.v) != null && tbCyberVideoView.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.S.addView(this.v.getView(), 0);
            this.v.getView().setLayoutParams(layoutParams);
            this.H.setPlayer(this.v);
            this.v.setContinuePlayEnable(true);
            this.v.setOnPreparedListener(this);
            this.v.setOnCompletionListener(this);
            this.v.setOnErrorListener(this);
            this.v.setOnSurfaceDestroyedListener(this);
            this.v.setOnInfoListener(this);
            this.v.setVideoStatData(this.c0);
            this.v.setThreadDataForStatistic(this.d0);
            this.v.getMediaProgressObserver().j(this.H0);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            r0(this.f26430h);
            this.i0 = true;
            this.H.showProgress();
            c0();
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (this.i0) {
                this.y.setAlpha(1.0f);
                this.y.setVisibility(0);
                this.z.setVisibility(8);
            } else {
                this.y.setVisibility(8);
                this.z.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.y;
            if (tBLottieAnimationView == null || !this.i0) {
                return;
            }
            tBLottieAnimationView.loop(true);
            this.y.setMinAndMaxFrame(14, 80);
            this.y.playAnimation();
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            r0(this.q);
            this.H.showProgress();
            c0();
        }
    }

    public void x0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
        }
    }

    public void y0() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (pVar = this.c0) == null) {
            return;
        }
        p b2 = pVar.b();
        b2.a = this.e0;
        c.a.s0.z2.h.e(b2.m, "", "1", b2, this.v.getPcdnState());
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.U = false;
            TBLottieAnimationView tBLottieAnimationView = this.y;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.v.stop();
            this.H.resetProgress();
            r0(this.f26428f);
            MessageManager.getInstance().unRegisterListener(this.M0);
        }
    }
}
