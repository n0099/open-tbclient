package c.a.r0.p2.q;

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
import c.a.e.e.p.l;
import c.a.q0.d1.t0;
import c.a.q0.s.q.d2;
import c.a.r0.p2.f;
import c.a.r0.p2.o;
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
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes3.dex */
public class d implements c.a.r0.p2.q.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PercentSizeView A;
    public McnAdInfo A0;
    public TextView B;
    public boolean B0;
    public TextView C;
    public k C0;
    public TextView D;
    public long D0;
    public SwitchImageView E;
    public f.c E0;
    public SwitchImageView F;
    public SeekBar.OnSeekBarChangeListener F0;
    public OperableVideoMediaControllerView G;
    public GestureDetector.SimpleOnGestureListener G0;
    public OperableVideoNetworkStateTipView H;
    public View.OnTouchListener H0;
    public OperableVideoShareView I;
    public TbVideoViewSet.b I0;
    public ImageView J;
    public final CustomMessageListener J0;
    public View K;
    public VideoGestureView L;
    public View M;
    public OperableVideoErrorView N;
    public WeakReference<Context> O;
    public Context P;
    public View Q;
    public ViewGroup R;
    public BdUniqueId S;
    public boolean T;
    public boolean U;
    public String V;
    public String W;
    public int X;
    public long Y;
    public c.a.r0.p2.j Z;
    public boolean a0;
    public o b0;
    public d2 c0;

    /* renamed from: e  reason: collision with root package name */
    public int f23847e;

    /* renamed from: f  reason: collision with root package name */
    public int f23848f;

    /* renamed from: g  reason: collision with root package name */
    public int f23849g;

    /* renamed from: h  reason: collision with root package name */
    public int f23850h;

    /* renamed from: i  reason: collision with root package name */
    public int f23851i;
    public String i0;

    /* renamed from: j  reason: collision with root package name */
    public int f23852j;
    public boolean j0;
    public int k;
    public boolean k0;
    public int l;
    public String l0;
    public int m;
    public float m0;
    public int n;
    public float n0;
    public int o;
    public GestureDetector o0;
    public int p;
    public int p0;
    public int q;
    public int[] q0;
    public int r;
    public int r0;
    public int s;
    public boolean s0;
    public Runnable t;
    public int t0;
    public TbCyberVideoView u;
    public int u0;
    public TbImageView v;
    public float v0;
    public View w;
    public int w0;
    public TBLottieAnimationView x;
    public boolean x0;
    public ImageView y;
    public View.OnClickListener y0;
    public ImageView z;
    public c.a.y.c z0;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23853a;

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
            this.f23853a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.f23853a.stopPlay();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23854e;

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
            this.f23854e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f23854e;
                dVar.r0(dVar.f23849g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23855e;

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
            this.f23855e = dVar;
        }

        @Override // c.a.r0.p2.f.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f23855e.D0 <= 0) {
                    this.f23855e.D0 = i3;
                }
                if (this.f23855e.k0()) {
                    d dVar = this.f23855e;
                    if (!dVar.U && !dVar.a0 && dVar.B0) {
                        if (c.a.y.b.b().a(this.f23855e.A0.jump_url)) {
                            return;
                        }
                        long j2 = i3;
                        boolean z = j2 >= this.f23855e.A0.ad_start_time.longValue() * 1000 && j2 < this.f23855e.A0.ad_end_time.longValue() * 1000;
                        boolean z2 = this.f23855e.D0 >= (this.f23855e.A0.ad_start_time.longValue() * 1000) + 1000;
                        if (z) {
                            if (!this.f23855e.z0.c()) {
                                c.a.y.a aVar = new c.a.y.a();
                                aVar.f31205b = this.f23855e.A0.card_title;
                                aVar.f31206c = this.f23855e.A0.button_title;
                                aVar.f31207d = this.f23855e.A0.jump_url;
                                aVar.f31204a = this.f23855e.A0.pic_url;
                                aVar.f31209f = String.valueOf(this.f23855e.Y);
                                d dVar2 = this.f23855e;
                                aVar.f31208e = dVar2.W;
                                aVar.f31210g = dVar2.e0();
                                if (z2) {
                                    this.f23855e.z0.f(aVar, (ViewGroup) this.f23855e.Q);
                                } else {
                                    this.f23855e.z0.e(aVar, (ViewGroup) this.f23855e.Q);
                                }
                            }
                        } else if (this.f23855e.z0.c()) {
                            this.f23855e.z0.a();
                        }
                    }
                }
                if (this.f23855e.C0 != null) {
                    this.f23855e.C0.a(i2, i3);
                }
            }
        }
    }

    /* renamed from: c.a.r0.p2.q.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1108d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23856e;

        public C1108d(d dVar) {
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
            this.f23856e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f23856e.x.setVisibility(8);
                this.f23856e.y.setVisibility(0);
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

    /* loaded from: classes3.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23857e;

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
            this.f23857e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f23857e.x.setVisibility(8);
                this.f23857e.y.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f23857e.R();
                if (!this.f23857e.T) {
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

    /* loaded from: classes3.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23858e;

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
            this.f23858e = dVar;
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
                this.f23858e.R.setScaleX(1.0f);
                this.f23858e.R.setScaleY(1.0f);
                this.f23858e.R.setTranslationX(0.0f);
                this.f23858e.R.setTranslationY(0.0f);
                this.f23858e.I.setScaleX(1.0f);
                this.f23858e.I.setScaleY(1.0f);
                this.f23858e.R.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                if (this.f23858e.s0) {
                    return;
                }
                this.f23858e.X();
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

    /* loaded from: classes3.dex */
    public class g implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23859e;

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
            this.f23859e = dVar;
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
                d dVar = this.f23859e;
                dVar.r0(dVar.f23851i);
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
            if (!this.f23859e.u.isPlaying()) {
                d dVar = this.f23859e;
                dVar.u.start(dVar.I0);
            }
            this.f23859e.V();
            if (this.f23859e.j0) {
                TiebaStatic.log(new StatisticItem("c13355").param("tid", this.f23859e.W).param("fid", this.f23859e.Y).param("obj_type", this.f23859e.U ? 1 : 2).param("obj_locate", this.f23859e.a0 ? 1 : 2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23860e;

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
            this.f23860e = dVar;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f23860e.t0 == i3 && this.f23860e.u0 == i2) {
                    return;
                }
                d dVar = this.f23860e;
                dVar.s0 = dVar.t0 - i3 > 0 || ((float) i3) < this.f23860e.m0 / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f23860e.R.getLayoutParams();
                if (i3 != this.f23860e.t0) {
                    int i4 = this.f23860e.r0 - i3;
                    int i5 = (int) (i4 * this.f23860e.v0);
                    if (i5 < this.f23860e.w0) {
                        i5 = this.f23860e.w0;
                        i4 = (int) (i5 / this.f23860e.v0);
                    }
                    if (i5 != this.f23860e.w0) {
                        layoutParams.height = i4;
                        layoutParams.width = i5;
                        this.f23860e.R.setLayoutParams(layoutParams);
                    }
                    this.f23860e.t0 = i3;
                    d dVar2 = this.f23860e;
                    dVar2.R.setTranslationY(dVar2.t0);
                }
                if (i2 != this.f23860e.t0) {
                    this.f23860e.u0 = i2;
                    d dVar3 = this.f23860e;
                    dVar3.R.setTranslationX(dVar3.u0 + ((this.f23860e.n0 - layoutParams.width) / 2.0f));
                }
                this.f23860e.M.setAlpha((layoutParams.width - this.f23860e.w0) / (this.f23860e.n0 - this.f23860e.w0));
                if (this.f23860e.I.getVisibility() == 0) {
                    float f2 = this.f23860e.m0 / 6.0f;
                    float f3 = (f2 - i3) / f2;
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                    this.f23860e.I.setAlpha(f3);
                }
            }
        }

        public final void b(float f2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (f2 > 0.0f) {
                    d dVar = this.f23860e;
                    dVar.p0 -= 1000;
                    z = true;
                } else {
                    this.f23860e.p0 += 1000;
                    z = false;
                }
                int duration = this.f23860e.u.getDuration();
                if (this.f23860e.p0 < 0) {
                    this.f23860e.p0 = 0;
                } else if (this.f23860e.p0 > duration) {
                    this.f23860e.p0 = duration;
                }
                String str = StringHelper.stringForVideoTime(this.f23860e.p0) + " / " + StringHelper.stringForVideoTime(duration);
                VideoGestureView videoGestureView = this.f23860e.L;
                if (videoGestureView != null) {
                    videoGestureView.changeFFRew(z, str);
                }
                d dVar2 = this.f23860e;
                dVar2.G.setCurrentDuration(dVar2.p0, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.f23860e.u.isPlaying()) {
                    this.f23860e.u.pause();
                    d dVar = this.f23860e;
                    if (dVar.q == dVar.f23851i) {
                        dVar.r0(dVar.f23852j);
                    } else {
                        dVar.r0(dVar.k);
                    }
                    this.f23860e.w0(R.id.video_pause);
                    return true;
                }
                d dVar2 = this.f23860e;
                int i2 = dVar2.q;
                int i3 = dVar2.f23852j;
                if (i2 != i3 && i2 != (i3 | 1)) {
                    int i4 = dVar2.k;
                    if (i2 == i4 || i2 == (i4 | 1)) {
                        d dVar3 = this.f23860e;
                        dVar3.r0(dVar3.f23849g);
                        d dVar4 = this.f23860e;
                        dVar4.u.start(dVar4.I0);
                        this.f23860e.w0(R.id.video_play);
                        return true;
                    }
                    return true;
                }
                d dVar5 = this.f23860e;
                dVar5.r0(dVar5.f23851i);
                this.f23860e.V();
                d dVar6 = this.f23860e;
                dVar6.u.start(dVar6.I0);
                this.f23860e.w0(R.id.video_play);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                this.f23860e.r = 0;
                d dVar = this.f23860e;
                if (dVar.a0) {
                    dVar.U((Activity) dVar.P, true);
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
                if (!this.f23860e.i0(motionEvent)) {
                    return super.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                Context context = this.f23860e.P;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.f23860e.P).disableSwipeJustOnce();
                } else {
                    Context context2 = this.f23860e.P;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.f23860e.P).disableSwipeJustOnce();
                    }
                }
                d dVar = this.f23860e;
                if (dVar.U && dVar.j0()) {
                    int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                    int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                    int i4 = this.f23860e.r;
                    if (i4 != 0) {
                        if (i4 == 4) {
                            a(rawX, rawY);
                        }
                    } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                        if (this.f23860e.u.isPlaying()) {
                            this.f23860e.u.pause();
                            d dVar2 = this.f23860e;
                            dVar2.r0(dVar2.o);
                        }
                        this.f23860e.r = 4;
                        d dVar3 = this.f23860e;
                        dVar3.s = dVar3.q;
                        d dVar4 = this.f23860e;
                        dVar4.q = dVar4.n;
                        dVar4.r0 = dVar4.R.getMeasuredHeight();
                        d dVar5 = this.f23860e;
                        dVar5.v0 = dVar5.n0 / this.f23860e.r0;
                        d dVar6 = this.f23860e;
                        dVar6.w0 = (int) (dVar6.Q.getWidth() * 1.2f);
                        a(rawX, rawY);
                    }
                } else {
                    d dVar7 = this.f23860e;
                    int i5 = dVar7.q;
                    if (i5 == dVar7.f23849g || i5 == dVar7.f23851i || i5 == (i2 = dVar7.f23852j) || i5 == (i3 = dVar7.k) || i5 == dVar7.n || i5 == (i2 | 1) || i5 == (i3 | 1)) {
                        int i6 = this.f23860e.r;
                        if (i6 == 0) {
                            if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                                this.f23860e.r = 3;
                                d dVar8 = this.f23860e;
                                dVar8.p0 = dVar8.u.getCurrentPosition();
                                b(f2);
                            } else if (motionEvent.getX() < this.f23860e.R.getWidth() / 2) {
                                this.f23860e.r = 2;
                                d dVar9 = this.f23860e;
                                dVar9.L.changeBright(dVar9.P, f3 > 0.0f);
                            } else {
                                this.f23860e.r = 1;
                                d dVar10 = this.f23860e;
                                dVar10.L.changeVolume(dVar10.P, f3 > 0.0f);
                            }
                            d dVar11 = this.f23860e;
                            int i7 = dVar11.q;
                            int i8 = dVar11.n;
                            if (i7 != i8) {
                                if ((i7 & 1) > 0) {
                                    dVar11.n = i8 | 1;
                                } else {
                                    dVar11.n = i8 & (-2);
                                }
                                d dVar12 = this.f23860e;
                                dVar12.r0(dVar12.n);
                            }
                        } else if (i6 == 1) {
                            d dVar13 = this.f23860e;
                            int i9 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                            dVar13.L.changeVolume(dVar13.P, i9 > 0);
                            if (i9 > 0) {
                                this.f23860e.F();
                            }
                        } else if (i6 == 2) {
                            d dVar14 = this.f23860e;
                            dVar14.L.changeBright(dVar14.P, f3 > 0.0f);
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
                if (this.f23860e.u.isPlaying()) {
                    d dVar = this.f23860e;
                    int i2 = dVar.q;
                    int i3 = dVar.f23849g;
                    if (i2 != i3 && i2 != dVar.f23850h) {
                        if (i2 == dVar.f23851i) {
                            dVar.r0(i3);
                        }
                    } else {
                        d dVar2 = this.f23860e;
                        dVar2.r0(dVar2.f23851i);
                        this.f23860e.V();
                    }
                } else {
                    d dVar3 = this.f23860e;
                    int i4 = dVar3.q;
                    int i5 = dVar3.f23852j;
                    if (i4 == i5) {
                        dVar3.r0(dVar3.k);
                    } else if (i4 == (i5 | 1)) {
                        dVar3.r0(dVar3.k | 1);
                    } else {
                        int i6 = dVar3.k;
                        if (i4 == i6) {
                            dVar3.r0(i5);
                        } else if (i4 == (i6 | 1)) {
                            dVar3.r0(i5 | 1);
                        } else {
                            dVar3.r0(dVar3.f23848f);
                            this.f23860e.startPlay();
                            this.f23860e.o0();
                        }
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23861e;

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
            this.f23861e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    d dVar = this.f23861e;
                    if (dVar.q == dVar.n) {
                        if (dVar.r == 4) {
                            this.f23861e.W();
                            this.f23861e.t0 = 0;
                            this.f23861e.u0 = 0;
                        } else {
                            d dVar2 = this.f23861e;
                            dVar2.q = -1;
                            if (dVar2.r != 3) {
                                if (this.f23861e.s != -1) {
                                    d dVar3 = this.f23861e;
                                    dVar3.r0(dVar3.s);
                                    this.f23861e.s = -1;
                                } else if (this.f23861e.u.isPlaying()) {
                                    d dVar4 = this.f23861e;
                                    dVar4.r0(dVar4.f23849g);
                                } else {
                                    d dVar5 = this.f23861e;
                                    dVar5.r0(dVar5.f23852j);
                                }
                            } else {
                                d dVar6 = this.f23861e;
                                dVar6.G.setCurrentDuration(dVar6.p0, true);
                                if (this.f23861e.p0 <= this.f23861e.u.getDuration()) {
                                    if (!this.f23861e.u.isPlaying()) {
                                        d dVar7 = this.f23861e;
                                        dVar7.u.start(dVar7.I0);
                                    }
                                    d dVar8 = this.f23861e;
                                    dVar8.r0(dVar8.f23849g);
                                }
                            }
                        }
                        d dVar9 = this.f23861e;
                        if (dVar9.j0) {
                            String str = null;
                            if (dVar9.r == 1) {
                                str = "c13361";
                            } else if (this.f23861e.r == 2) {
                                str = "c13346";
                            } else if (this.f23861e.r == 3) {
                                str = "c13362";
                            }
                            if (!c.a.e.e.p.k.isEmpty(str)) {
                                TiebaStatic.log(new StatisticItem(str).param("tid", this.f23861e.W).param("fid", this.f23861e.Y));
                            }
                        }
                        this.f23861e.r = 0;
                        return true;
                    }
                }
                return this.f23861e.o0.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements TbVideoViewSet.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23862a;

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
            this.f23862a = dVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f23862a;
                dVar.r0(dVar.f23848f);
                this.f23862a.v0();
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f23862a.u.clearCallbackAndRemoveFromWindow();
                this.f23862a.t0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f23847e = 3000;
        this.f23848f = 8211;
        this.f23849g = 0;
        this.f23850h = 4;
        this.f23851i = 232;
        this.f23852j = 8416;
        this.k = 0;
        this.l = 513;
        this.m = 259;
        this.n = 2048;
        this.o = 0;
        this.p = 4099;
        this.q = 8211;
        this.r = 0;
        this.s = -1;
        this.t = new b(this);
        this.O = null;
        this.a0 = false;
        this.j0 = true;
        this.k0 = false;
        this.q0 = new int[2];
        this.t0 = 0;
        this.u0 = 0;
        this.x0 = false;
        this.y0 = null;
        this.B0 = false;
        this.D0 = -1L;
        this.E0 = new c(this);
        this.F0 = new g(this);
        this.G0 = new h(this);
        this.H0 = new i(this);
        this.I0 = new j(this);
        this.J0 = new a(this, 2000994);
        if (context == null || view == null) {
            return;
        }
        this.P = context;
        this.Z = new c.a.r0.p2.j((Activity) context);
        this.Q = view;
        this.m0 = l.i(this.P);
        this.n0 = l.k(this.P);
        g0();
    }

    @Override // c.a.r0.p2.q.a
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a0) {
                W();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.p2.q.a
    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.u.getRenderView().setDisplayMode(i2);
        }
    }

    @Override // c.a.r0.p2.q.a
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TbSingleton.getInstance().isVideoCardMute() && this.u.isPlaying() && !t0.c()) {
                this.u.setVolume(1.0f, 1.0f);
                this.E.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.p2.q.a
    public void G(o oVar) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || (tbCyberVideoView = this.u) == null) {
            return;
        }
        this.b0 = oVar;
        tbCyberVideoView.setVideoStatData(oVar);
    }

    @Override // c.a.r0.p2.q.a
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.r0.p2.q.a
    public boolean I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                this.x0 = isPlaying();
                this.x.cancelAnimation();
                int i2 = this.q;
                if (i2 == this.f23849g || i2 == this.f23850h || i2 == this.f23851i || i2 == this.f23848f) {
                    stopPlay();
                }
                int i3 = this.q | 1;
                this.q = i3;
                r0(i3);
            } else if (this.q == this.f23848f) {
                if (this.x0) {
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

    @Override // c.a.r0.p2.q.a
    public void M(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.q == this.f23850h) {
            r0(this.f23849g);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.U && !"video_tab".equals(this.i0)) {
                this.f23851i = 104;
                this.f23852j = 8290;
            } else {
                this.f23851i = 232;
                this.f23852j = 8418;
            }
            if (this.a0) {
                this.f23848f |= 1024;
                this.f23849g |= 1024;
                this.f23850h |= 1024;
                this.f23851i |= 1024;
                this.f23852j |= 1024;
                this.k |= 1024;
                this.l |= 1024;
                this.m |= 1024;
                this.q |= 1024;
                return;
            }
            this.f23848f &= -1025;
            this.f23849g &= -1025;
            this.f23850h &= -1025;
            this.f23851i &= -1025;
            this.f23852j &= -1025;
            this.k &= -1025;
            this.l &= -1025;
            this.m &= -1025;
            this.q &= -1025;
        }
    }

    public void T() {
        float dimension;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.H.changeViewLayout(this.U, this.a0);
            this.I.changeViewLayout(this.U, this.a0);
            Context context = this.P;
            if (context == null || context.getResources() == null) {
                return;
            }
            if (this.U) {
                dimension = this.P.getResources().getDimension(R.dimen.tbds44);
            } else if (this.a0) {
                dimension = this.P.getResources().getDimension(R.dimen.tbds78);
            } else {
                dimension = this.P.getResources().getDimension(R.dimen.tbds44);
            }
            int i2 = (int) dimension;
            this.B.setPadding(0, 0, "video_tab".equals(this.i0) ? 0 : i2, 0);
            SwitchImageView switchImageView = this.F;
            switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i2, 0);
            this.E.setPadding(i2, 0, 0, 0);
        }
    }

    public final void U(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, activity, z) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (this.U && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
            ViewGroup viewGroup = this.R;
            if (viewGroup == null) {
                return;
            }
            if (z) {
                viewGroup.setPadding(0, l.r((Activity) this.P), 0, 0);
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
            this.R.setSystemUiVisibility(0);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.t);
            c.a.e.e.m.e.a().postDelayed(this.t, this.f23847e);
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
            if (!this.U) {
                X();
            } else if (this.q == this.n) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.addListener(new f(this));
                if (!this.s0) {
                    float width = this.Q.getWidth() / this.R.getWidth();
                    float height = this.Q.getHeight() / this.R.getHeight();
                    this.R.setPivotX(0.0f);
                    this.R.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.R, "ScaleX", 1.0f, width);
                    objectAnimator = ObjectAnimator.ofFloat(this.R, "ScaleY", 1.0f, height);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.I, "ScaleX", 1.0f, 1.0f / width);
                    ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.I, "ScaleY", 1.0f, 1.0f / height);
                    ViewGroup viewGroup = this.R;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.q0[0]);
                    ViewGroup viewGroup2 = this.R;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.q0[1]);
                    View view = this.M;
                    ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), 0.0f);
                    OperableVideoShareView operableVideoShareView = this.I;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, "alpha", operableVideoShareView.getAlpha(), 0.0f);
                    ofFloat2 = ofFloat7;
                    objectAnimator2 = ofFloat9;
                    ofFloat3 = ofFloat8;
                } else {
                    float width2 = this.n0 / this.R.getWidth();
                    float height2 = this.r0 / this.R.getHeight();
                    this.R.setPivotX(0.0f);
                    this.R.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.R, "ScaleX", 1.0f, width2);
                    ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.R, "ScaleY", 1.0f, height2);
                    ofFloat2 = ObjectAnimator.ofFloat(this.I, "ScaleX", 1.0f, 1.0f / width2);
                    ofFloat3 = ObjectAnimator.ofFloat(this.I, "ScaleY", 1.0f, 1.0f / height2);
                    ViewGroup viewGroup3 = this.R;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup3, "TranslationX", viewGroup3.getTranslationX(), 0.0f);
                    ViewGroup viewGroup4 = this.R;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup4, "TranslationY", viewGroup4.getTranslationY(), 0.0f);
                    OperableVideoShareView operableVideoShareView2 = this.I;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView2, "alpha", operableVideoShareView2.getAlpha(), 1.0f);
                    objectAnimator = ofFloat10;
                    objectAnimator2 = null;
                }
                if (objectAnimator2 != null) {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(objectAnimator2).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                } else {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                }
                animatorSet.start();
                int i2 = this.s;
                if (i2 != -1) {
                    this.q = i2;
                    this.s = -1;
                    if (i2 == this.o || i2 == this.f23851i || i2 == this.f23849g) {
                        this.u.start(this.I0);
                        r0(this.f23849g);
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
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (view = this.Q) == null || this.R == null || this.u == null) {
            return;
        }
        Context context = this.P;
        if (context != null) {
            l.x(context, view);
        }
        if (this.a0) {
            if (this.M.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.M.getParent()).removeView(this.M);
            }
            if ((this.R.getParent() instanceof ViewGroup) && (this.Q instanceof ViewGroup)) {
                this.a0 = false;
                this.k0 = true;
                ((ViewGroup) this.R.getParent()).removeView(this.R);
                ((ViewGroup) this.Q).addView(this.R);
                this.k0 = false;
                U((Activity) this.P, this.a0);
            }
            if (!this.U && z) {
                this.Z.l();
            }
        } else {
            if (this.P != null) {
                if (!this.U && z) {
                    this.Z.l();
                }
                if (this.P instanceof Activity) {
                    this.R.getLocationOnScreen(this.q0);
                    View findViewById = ((Activity) this.P).findViewById(16908290);
                    if (findViewById instanceof ViewGroup) {
                        View childAt = ((ViewGroup) findViewById).getChildAt(0);
                        if (childAt instanceof ViewGroup) {
                            this.k0 = true;
                            ((ViewGroup) this.Q).removeAllViews();
                            if (this.M == null) {
                                View view2 = new View(this.P);
                                this.M = view2;
                                view2.setClickable(true);
                                this.M.setBackgroundColor(SkinManager.getColor(R.color.black_alpha100));
                                this.M.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            }
                            if (this.M.getParent() instanceof ViewGroup) {
                                ((ViewGroup) this.M.getParent()).removeView(this.M);
                            }
                            this.M.setAlpha(1.0f);
                            ViewGroup viewGroup = (ViewGroup) childAt;
                            viewGroup.addView(this.M);
                            viewGroup.addView(this.R);
                            this.k0 = false;
                            this.a0 = true;
                            U((Activity) this.P, true);
                            c.a.y.c cVar = this.z0;
                            if (cVar != null && cVar.c()) {
                                this.z0.a();
                            }
                        }
                    }
                }
            }
            if (this.j0) {
                TiebaStatic.log(new StatisticItem("c13360").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2));
            }
        }
        S();
        T();
        if (this.u.isPlaying()) {
            r0(this.f23849g);
        } else {
            r0(this.q);
        }
        this.F.switchState();
        m0(this.a0);
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
            if (isVideoCardMute) {
                this.u.setVolume(1.0f, 1.0f);
                t0.f(this.O, true);
                this.E.setState(0);
            } else {
                this.u.setVolume(0.0f, 0.0f);
                this.E.setState(1);
                t0.f(this.O, false);
            }
            TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                this.Z.i(true);
            } else {
                this.Z.i(false);
            }
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                this.Z.j();
            } else {
                this.Z.k();
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            r0(this.f23850h);
            this.G.showProgress();
            TBLottieAnimationView tBLottieAnimationView = this.x;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.clearAnimation();
                this.x.animate().alpha(0.0f).setDuration(200L).setListener(new e(this)).start();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.V : (String) invokeV.objValue;
    }

    public void g0() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (context = this.P) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d0(), (ViewGroup) null);
        this.R = viewGroup;
        View view = this.Q;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).addView(viewGroup);
        }
        this.O = new WeakReference<>(TbadkCoreApplication.getInst());
        this.v = (TbImageView) this.R.findViewById(R.id.video_thumbnail);
        this.w = this.R.findViewById(R.id.black_mask);
        this.x = (TBLottieAnimationView) this.R.findViewById(R.id.video_loading);
        this.y = (ImageView) this.R.findViewById(R.id.video_play);
        this.A = (PercentSizeView) this.R.findViewById(R.id.video_media_controller_mask);
        this.z = (ImageView) this.R.findViewById(R.id.video_pause);
        this.B = (TextView) this.R.findViewById(R.id.video_play_count);
        this.C = (TextView) this.R.findViewById(R.id.video_play_flag);
        this.D = (TextView) this.R.findViewById(R.id.video_duration);
        this.E = (SwitchImageView) this.R.findViewById(R.id.video_mute);
        this.F = (SwitchImageView) this.R.findViewById(R.id.video_full_screen);
        this.G = (OperableVideoMediaControllerView) this.R.findViewById(R.id.video_media_controller);
        this.H = (OperableVideoNetworkStateTipView) this.R.findViewById(R.id.video_network_state_tip);
        this.I = (OperableVideoShareView) this.R.findViewById(R.id.video_share_view);
        this.K = this.R.findViewById(R.id.video_back_btn_mask);
        this.J = (ImageView) this.R.findViewById(R.id.video_full_screen_back);
        this.L = (VideoGestureView) this.R.findViewById(R.id.video_gesture);
        this.N = (OperableVideoErrorView) this.R.findViewById(R.id.video_error_layout);
        this.I.setVideoContainer(this);
        this.x.addAnimatorListener(new C1108d(this));
        this.x.setAnimation(R.raw.lotti_video_loading);
        this.y.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.y.setOnClickListener(this);
        this.E.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
        this.E.setState(1);
        this.E.setOnClickListener(this);
        this.v.clearCornerFlag();
        this.v.setDrawCorner(false);
        this.v.setPlaceHolder(3);
        c.a.q0.b.g.b.h(this.w, R.color.CAM_X0601);
        this.G.setOnSeekBarChangeListener(this.F0);
        this.A.setHeightPercent(0.583f);
        this.A.setBackgroundResource(R.drawable.video_mask_bg);
        this.F.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
        this.F.setState(0);
        this.F.setOnClickListener(this);
        this.z.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.z.setOnClickListener(this);
        this.J.setOnClickListener(this);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(this.P);
        this.u = tbCyberVideoView;
        tbCyberVideoView.setTryUseViewInSet(true);
        t0();
        this.H.setPlayViewOnClickListener(this);
        this.R.setOnClickListener(null);
        this.R.setOnTouchListener(this.H0);
        this.I.setOnTouchListener(this.H0);
        this.N.setOutOnClickListener(this);
        this.o0 = new GestureDetector(this.P, this.G0);
        r0(this.f23848f);
        this.z0 = new c.a.y.c(this.P);
        c.a.q0.s.u.c.d(this.w).t(R.array.Mask_X003);
        c.a.q0.s.u.c.d(this.B).z(R.array.S_O_X001);
        c.a.q0.s.u.c.d(this.D).z(R.array.S_O_X001);
    }

    @Override // c.a.r0.p2.q.a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.u.getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.r0.p2.q.a
    public View getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.R : (View) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (TbSingleton.getInstance().isVideoCardMute()) {
                this.u.setVolume(0.0f, 0.0f);
                this.E.setState(1);
                return;
            }
            this.u.setVolume(1.0f, 1.0f);
            this.E.setState(0);
        }
    }

    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) ? this.a0 : invokeL.booleanValue;
    }

    @Override // c.a.r0.p2.q.a
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.a0 : invokeV.booleanValue;
    }

    @Override // c.a.r0.p2.q.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.T || this.u.isPlaying() : invokeV.booleanValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.U && this.a0 : invokeV.booleanValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.A0 != null : invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (c.a.q0.b.d.c0() && "video_tab".equals(this.i0)) {
                return c.a.e.e.p.j.x();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.H;
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
            c.a.e.e.m.e.a().removeCallbacks(this.t);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.V);
            CustomMessage customMessage = new CustomMessage(2921387);
            customMessage.setTag(this.S);
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
        w0(id);
        if (id == R.id.video_mute) {
            Z();
        } else if (id != R.id.video_full_screen && id != R.id.video_full_screen_back) {
            if (id == R.id.video_replay) {
                r0(this.f23848f);
                startPlay();
                if (this.j0) {
                    TiebaStatic.log(new StatisticItem("c13345").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_locate", this.a0 ? 1 : 2));
                }
                o0();
            } else if (id == R.id.video_play) {
                if (this.q == this.f23848f) {
                    startPlay();
                } else {
                    r0(this.f23851i);
                    V();
                    this.u.start(this.I0);
                }
                if (this.j0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", this.a0 ? 1 : 2).param("obj_locate", 1));
                }
                o0();
            } else if (id == R.id.video_pause) {
                r0(this.f23852j);
                n0();
                this.u.pause();
                if (this.j0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", this.a0 ? 1 : 2).param("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                r0(this.f23848f);
                startPlay();
            } else if (id == R.id.retry) {
                r0(this.f23848f);
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
                u0();
            }
            if (i2 == 701) {
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
            if (this.T) {
                if (this.a0) {
                    Context context = this.P;
                    if (context instanceof Activity) {
                        U((Activity) context, true);
                    }
                }
                this.u.start(this.I0);
            }
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
    public void onSurfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.k0) {
            return;
        }
        int i2 = this.q;
        if (i2 != this.f23852j && (i2 != this.k || this.u.isPlaying())) {
            if (this.q == this.l) {
                y0();
                r0(this.l);
                return;
            } else if (this.x0) {
                return;
            } else {
                y0();
                return;
            }
        }
        y0();
        r0(this.f23852j);
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.B0 = z;
        }
    }

    public void q0(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, kVar) == null) {
            this.C0 = kVar;
        }
    }

    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            n0();
            if (this.q == this.n) {
                this.s = i2;
                return;
            }
            this.q = i2;
            this.v.setVisibility((i2 & 1) > 0 ? 0 : 8);
            this.w.setVisibility((i2 & 2) > 0 ? 0 : 8);
            boolean z = (i2 & 4) > 0;
            this.x.clearAnimation();
            this.x.setVisibility(z ? 0 : 8);
            if (!z) {
                this.x.cancelAnimation();
            } else {
                this.x.setAlpha(1.0f);
            }
            this.y.setVisibility((i2 & 8192) > 0 ? 0 : 8);
            this.z.setVisibility((i2 & 8) > 0 ? 0 : 8);
            int i3 = i2 & 16;
            this.B.setVisibility(i3 > 0 ? 0 : 8);
            this.D.setVisibility(i3 > 0 ? 0 : 8);
            this.E.setVisibility((i2 & 32) > 0 ? 0 : 8);
            this.F.setVisibility((i2 & 64) > 0 ? 0 : 8);
            int i4 = i2 & 128;
            this.G.setVisibility(i4 > 0 ? 0 : 8);
            this.A.setVisibility(i4 > 0 ? 0 : 8);
            if (this.G.getVisibility() == 0) {
                this.G.showProgress();
            }
            this.H.setVisibility((i2 & 256) > 0 ? 0 : 8);
            this.I.setVisibility((i2 & 512) > 0 ? 0 : 8);
            if (this.I.getVisibility() == 0) {
                this.I.setAlpha(1.0f);
            }
            int i5 = i2 & 1024;
            this.J.setVisibility(i5 > 0 ? 0 : 8);
            this.K.setVisibility(i5 > 0 ? 0 : 8);
            this.L.setVisibility((i2 & 2048) > 0 ? 0 : 8);
            this.N.setVisibility((i2 & 4096) <= 0 ? 8 : 0);
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.R.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.R.setSystemUiVisibility(4);
            } else {
                this.R.setSystemUiVisibility(5894);
            }
        }
    }

    @Override // c.a.r0.p2.q.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onClickListener) == null) {
            this.y0 = onClickListener;
        }
    }

    @Override // c.a.r0.p2.q.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, d2Var) == null) || d2Var == null || d2Var.q1() == null) {
            return;
        }
        this.D0 = -1L;
        c.a.y.c cVar = this.z0;
        if (cVar != null) {
            cVar.d();
        }
        if (StringHelper.equals(this.V, d2Var.q1().video_url)) {
            return;
        }
        stopPlay();
        this.U = d2Var.q1().is_vertical.intValue() == 1;
        this.V = d2Var.q1().video_url;
        this.W = d2Var.s1();
        d2Var.q1().video_length.intValue();
        this.X = d2Var.q1().video_duration.intValue();
        this.Y = d2Var.T();
        this.A0 = d2Var.q1().mcn_ad_card;
        S();
        T();
        r0(this.f23848f);
        int intValue = d2Var.q1().video_duration.intValue() * 1000;
        this.G.initDuration(intValue);
        this.G.setPlayer(this.u);
        this.D.setText(StringHelper.stringForVideoTime(intValue));
        this.B.setText(String.format(this.P.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(d2Var.q1().play_count.intValue())));
        this.H.setVideoLength(d2Var.q1().video_length.intValue());
        this.H.setVideoDuration(d2Var.q1().video_duration.intValue());
        this.H.setTid(this.W);
        this.c0 = d2Var;
        this.u.setThreadDataForStatistic(d2Var);
        this.C.setVisibility(8);
        this.v.setPlaceHolder(3);
        this.v.startLoad(d2Var.q1().thumbnail_url, 10, false);
        this.I.setShareData(d2Var);
    }

    @Override // c.a.r0.p2.q.a
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.i0 = str;
        }
    }

    @Override // c.a.r0.p2.q.a
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.l0 = str;
        }
    }

    @Override // c.a.r0.p2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bdUniqueId) == null) {
            this.S = bdUniqueId;
        }
    }

    @Override // c.a.r0.p2.q.a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || StringUtils.isNull(this.V)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.J0);
        if (l0()) {
            r0(this.m);
            return;
        }
        this.T = true;
        if (this.u.isPlaying()) {
            return;
        }
        TbCyberVideoView e2 = TbVideoViewSet.d().e(this.V);
        if (e2 == null) {
            this.u.clearCallbackAndRemoveFromWindow();
            if (!StringUtils.isNull(this.u.getOriginUrl())) {
                TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(this.P);
                this.u = tbCyberVideoView;
                tbCyberVideoView.setTryUseViewInSet(true);
            }
            t0();
            if (c.a.e.e.p.j.z()) {
                this.u.setVideoDuration(this.X);
                this.u.setVideoPath(this.V, this.W);
                this.u.setStageType(this.l0);
                v0();
                if (this.j0) {
                    x0();
                }
            }
        } else {
            TbCyberVideoView tbCyberVideoView2 = this.u;
            if (tbCyberVideoView2 == e2) {
                if (tbCyberVideoView2.getParent() == null || this.u.getParent() != e2.getParent()) {
                    this.u.clearCallbackAndRemoveFromWindow();
                    t0();
                }
            } else {
                tbCyberVideoView2.clearCallbackAndRemoveFromWindow();
                e2.clearCallbackAndRemoveFromWindow();
                this.u = e2;
                e2.setTryUseViewInSet(true);
                t0();
            }
            this.u.monitorAndStatsAtPrepare();
            onPrepared();
            u0();
            if (this.j0) {
                x0();
            }
        }
        if (this.j0) {
            TiebaStatic.log(new StatisticItem("c13357").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // c.a.r0.p2.q.a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.T = false;
            TBLottieAnimationView tBLottieAnimationView = this.x;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.u.stop();
            this.u.clearCallbackAndRemoveFromWindow();
            this.G.resetProgress();
            r0(this.f23848f);
            MessageManager.getInstance().unRegisterListener(this.J0);
        }
    }

    public void t0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (tbCyberVideoView = this.u) != null && tbCyberVideoView.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.R.addView(this.u.getView(), 0);
            this.u.getView().setLayoutParams(layoutParams);
            this.G.setPlayer(this.u);
            this.u.setContinuePlayEnable(true);
            this.u.setOnPreparedListener(this);
            this.u.setOnCompletionListener(this);
            this.u.setOnErrorListener(this);
            this.u.setOnSurfaceDestroyedListener(this);
            this.u.setOnInfoListener(this);
            this.u.setVideoStatData(this.b0);
            this.u.setThreadDataForStatistic(this.c0);
            this.u.getMediaProgressObserver().j(this.E0);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            r0(this.f23850h);
            this.G.showProgress();
            c0();
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.x.setAlpha(1.0f);
            this.x.setVisibility(0);
            this.y.setVisibility(8);
            TBLottieAnimationView tBLottieAnimationView = this.x;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.loop(true);
                this.x.setMinAndMaxFrame(14, 80);
                this.x.playAnimation();
            }
        }
    }

    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
        }
    }

    public void x0() {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || (oVar = this.b0) == null) {
            return;
        }
        o b2 = oVar.b();
        b2.f23822a = this.i0;
        c.a.r0.p2.h.e(b2.m, "", "1", b2, this.u.getPcdnState());
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.T = false;
            TBLottieAnimationView tBLottieAnimationView = this.x;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.u.stop();
            this.G.resetProgress();
            r0(this.f23848f);
            MessageManager.getInstance().unRegisterListener(this.J0);
        }
    }
}
