package c.a.p0.c3;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.view.SwitchImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static int U0;
    public static CallStateReceiver V0;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public boolean A0;
    public CyberPlayerManager.OnPreparedListener B;
    public boolean B0;
    public CyberPlayerManager.OnCompletionListener C;
    public boolean C0;
    public CyberPlayerManager.OnErrorListener D;
    public boolean D0;
    public ImageView E;
    public boolean E0;
    public TextView F;
    public Activity F0;
    public boolean G;
    public g0 G0;
    public boolean H;
    public c.a.p0.c3.w.a H0;
    public boolean I;
    public VideoLoadingProgressView.c I0;
    public boolean J;
    public Runnable J0;
    public View.OnClickListener K;
    public Runnable K0;
    public Animation L;
    public Runnable L0;
    public Animation M;
    public TbVideoViewContainer.a M0;
    public t N;
    public Runnable N0;
    public int O;
    public View.OnClickListener O0;
    public GestureDetector P;
    public Animation.AnimationListener P0;
    public View Q;
    public Runnable Q0;
    public View R;
    public CustomMessageListener R0;
    public TextView S;
    public VideoControllerView.d S0;
    public SeekBar T;
    public SeekBar.OnSeekBarChangeListener T0;
    public ImageView U;
    public ImageView V;
    public AudioManager W;
    public u X;
    public int Y;
    public int Z;
    public int a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13455b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f13456c;
    public long c0;

    /* renamed from: d  reason: collision with root package name */
    public View f13457d;
    public f0 d0;

    /* renamed from: e  reason: collision with root package name */
    public View f13458e;
    public c.a.p0.c3.l e0;

    /* renamed from: f  reason: collision with root package name */
    public TbVideoViewContainer f13459f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.c3.r f13460g;
    public int g0;

    /* renamed from: h  reason: collision with root package name */
    public VideoListMediaControllerView f13461h;
    public int h0;
    public ProgressBar i;
    public boolean i0;
    public View j;
    public z j0;
    public View k;
    public y k0;
    public FrameLayout l;
    public a0 l0;
    public FrameLayout.LayoutParams m;
    public b0 m0;
    public ImageView n;
    public d0 n0;
    public View o;
    public r o0;
    public View p;
    public e0 p0;
    public View q;
    public c0 q0;
    public View r;
    public w r0;
    public boolean s;
    public x s0;
    public SwitchImageView t;
    public boolean t0;
    public TextView u;
    public boolean u0;
    public TextView v;
    public boolean v0;
    public TextView w;
    public int w0;
    public String x;
    public TextView x0;
    public String y;
    public boolean y0;
    public String z;
    public boolean z0;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.G0 != null) {
                    this.a.G0.a();
                }
                if (view.getId() != this.a.k.getId()) {
                    if (view.getId() != this.a.t.getId()) {
                        if (view.getId() == this.a.v.getId()) {
                            if (this.a.k0 != null) {
                                this.a.k0.a();
                                return;
                            }
                            return;
                        } else if (view.getId() == this.a.u.getId()) {
                            if (this.a.l0 != null) {
                                this.a.l0.a(false);
                            }
                            c cVar = this.a;
                            cVar.c2(cVar.x, this.a.y);
                            return;
                        } else if (view.getId() == this.a.n.getId()) {
                            int i = this.a.I ? 1 : 2;
                            if (this.a.s) {
                                TiebaStatic.log(new StatisticItem("c11714"));
                                TiebaStatic.log(new StatisticItem("c13262").param("tid", this.a.y).param("fid", this.a.z).param("obj_type", i).param("obj_source", 2));
                            } else {
                                TiebaStatic.log(new StatisticItem("c11710"));
                                TiebaStatic.log(new StatisticItem("c13262").param("tid", this.a.y).param("fid", this.a.z).param("obj_type", i).param("obj_source", 1));
                            }
                            if (this.a.q0 != null) {
                                this.a.q0.a();
                            }
                            if (this.a.S0()) {
                                c cVar2 = this.a;
                                if (cVar2.s) {
                                    cVar2.z0();
                                } else {
                                    cVar2.y0();
                                }
                                c cVar3 = this.a;
                                cVar3.n2(cVar3.s);
                                return;
                            }
                            this.a.l2();
                            return;
                        } else if (view.getId() != this.a.E.getId()) {
                            if (this.a.K != null) {
                                this.a.K.onClick(view);
                                return;
                            }
                            return;
                        } else {
                            TiebaStatic.log(new StatisticItem("c11713"));
                            if (this.a.q0 != null) {
                                this.a.q0.a();
                            }
                            if (this.a.S0()) {
                                this.a.z0();
                                this.a.n2(false);
                                return;
                            }
                            this.a.l2();
                            return;
                        }
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_PLAY_BTN_CLICK));
                    this.a.f1();
                    this.a.o2();
                    if (this.a.w0 != 1) {
                        this.a.W0();
                        this.a.x0();
                    } else {
                        this.a.w0();
                    }
                    if (this.a.o0 != null) {
                        this.a.o0.a(this.a.w0 == 1);
                        return;
                    }
                    return;
                }
                this.a.f13459f.getControl().stopPlayback();
                this.a.G = false;
                this.a.g2();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface a0 {
        void a(boolean z);
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13462b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f13463c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f13464d;

        public b(c cVar, v vVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, vVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13464d = cVar;
            this.a = vVar;
            this.f13462b = str;
            this.f13463c = str2;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f13464d.i1();
                aVar.dismiss();
                this.f13464d.e2(this.a, false, this.f13462b, this.f13463c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b0 {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* renamed from: c.a.p0.c3.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1015c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1015c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c0 {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d0 {
        boolean a();

        boolean b();
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.N0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface e0 {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes2.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.a.V0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f0 {
        void a();

        void b();

        void onPaused();

        void onPlayEnd();

        void onPrepared();

        void onStarted();

        void onUpdateProgress(int i);
    }

    /* loaded from: classes2.dex */
    public class g implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i) {
            TbVideoViewContainer tbVideoViewContainer;
            int duration;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (tbVideoViewContainer = this.a.f13459f) == null || tbVideoViewContainer.getControl() == null || (duration = this.a.f13459f.getControl().getDuration()) <= 0 || this.a.i == null) {
                return;
            }
            this.a.i.setProgress((int) ((i * this.a.f13458e.getWidth()) / duration));
            if (this.a.d0 != null) {
                this.a.d0.onUpdateProgress((this.a.f13459f.getControl().getCurrentPosition() * 100) / duration);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface g0 {
        void a();
    }

    /* loaded from: classes2.dex */
    public class h implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
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
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_SEEK_CLICK));
                this.a.W0();
                this.a.b2(false);
                if (this.a.o0 != null) {
                    this.a.o0.a(false);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.a.K0() != null) {
                    c cVar = this.a;
                    cVar.O1(cVar.K0().getSeekPosition());
                    if (!this.a.D0()) {
                        this.a.g2();
                    } else {
                        this.a.g1();
                        if (this.a.j0 != null) {
                            this.a.j0.a();
                        }
                    }
                }
                this.a.b2(true);
                this.a.u0();
                if (this.a.o0 != null) {
                    this.a.o0.a(true);
                }
                if (this.a.p0 != null) {
                    this.a.p0.onStopTrackingTouch(seekBar);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.a.m0 != null) {
                    this.a.m0.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = this.a.P.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (this.a.G) {
                        if (this.a.Y == 1 && this.a.b0 != 0) {
                            c cVar = this.a;
                            cVar.r0(cVar.b0 == 1 ? 1000.0f : -1000.0f, false);
                            this.a.b0 = 0;
                            this.a.a0 = 0;
                        }
                        if (!this.a.f13459f.getControl().isPlaying()) {
                            this.a.v.setVisibility(8);
                            this.a.u.setVisibility(8);
                            this.a.w.setVisibility(8);
                        }
                    }
                    this.a.X0();
                    if (this.a.m0 != null) {
                        this.a.m0.onStop();
                    }
                }
                return onTouchEvent;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class j extends c.a.o0.m.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public j(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.o0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity == this.a.F0) {
                MessageManager.getInstance().unRegisterListener(this.a.R0);
                TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements c.a.p0.c3.w.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public k(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.c3.w.a
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.p0.c3.w.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbVideoViewContainer tbVideoViewContainer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (tbVideoViewContainer = this.a.f13459f) == null || tbVideoViewContainer.getControl() == null) {
                return;
            }
            int duration = this.a.f13459f.getControl().getDuration();
            if (duration - getCurrentPosition() > 5000) {
                return;
            }
            this.a.G = false;
            this.a.B0 = false;
            this.a.O = 0;
            this.a.X0();
            this.a.j.setVisibility(0);
            this.a.i.setProgress(this.a.i.getMax());
            this.a.a = 100;
            if (this.a.C != null) {
                this.a.C.onCompletion();
            }
            this.a.w0 = 3;
            if (duration > 150000) {
                this.a.a1(false);
                this.a.b2(true);
            } else {
                this.a.O0();
                this.a.u.setVisibility(0);
            }
            c cVar = this.a;
            if (!cVar.s && duration <= 150000) {
                if (!cVar.y0) {
                    if (this.a.l0 != null) {
                        this.a.l0.a(true);
                    }
                    c cVar2 = this.a;
                    cVar2.d2(cVar2.x, this.a.y, false);
                } else {
                    this.a.w0 = 5;
                    this.a.f13459f.getControl().pause();
                    this.a.f13459f.getControl().seekTo(0);
                }
            }
            if (this.a.d0 != null) {
                this.a.d0.onUpdateProgress(this.a.i.getMax());
                this.a.d0.onPlayEnd();
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                this.a.k.setVisibility(0);
                this.a.f13460g.b();
                this.a.w0 = 4;
                if (this.a.D != null) {
                    this.a.D.onError(i, i2, null);
                }
                if (!c.a.d.f.p.l.z()) {
                    this.a.z0 = true;
                }
                if (this.a.d0 != null) {
                    this.a.d0.a();
                }
                this.a.B0 = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                if (i == 3 || i == 702 || i == 904) {
                    this.a.P0();
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TbVideoViewContainer tbVideoViewContainer;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                if (this.a.f13461h != null && (tbVideoViewContainer = this.a.f13459f) != null && tbVideoViewContainer.getControl() != null && this.a.f13459f.getControl().getDuration() > 0) {
                    this.a.f13461h.i(0, this.a.f13459f.getControl().getDuration());
                }
                this.a.i2();
                if (this.a.d0 != null) {
                    this.a.d0.onPrepared();
                }
            }
        }

        @Override // c.a.p0.c3.w.a
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.a.u0) {
                c.a.d.f.m.e.a().postDelayed(this.a.L0, 200L);
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setStatistic(c.a.p0.c3.u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, uVar) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public l(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i2();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public m(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.d.f.m.e.a().removeCallbacks(this.a.J0);
                if (this.a.A.getVisibility() == 8) {
                    return;
                }
                if (this.a.f13459f.getControl().getCurrentPosition() > this.a.a) {
                    this.a.P0();
                } else {
                    c.a.d.f.m.e.a().postDelayed(this.a.J0, 20L);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public n(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbVideoViewContainer tbVideoViewContainer = this.a.f13459f;
                if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null || !this.a.f13459f.getControl().isPlaying()) {
                    this.a.k.setVisibility(0);
                    this.a.f13460g.b();
                    if (this.a.d0 != null) {
                        this.a.d0.a();
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public o(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbVideoViewContainer tbVideoViewContainer = this.a.f13459f;
                if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null || !this.a.u0) {
                    c.a.d.f.m.e.a().postDelayed(this.a.J0, 200L);
                    this.a.u0 = false;
                } else if (this.a.O != this.a.f13459f.getControl().getCurrentPosition()) {
                    this.a.u0 = false;
                    c.a.d.f.m.e.a().postDelayed(this.a.J0, 20L);
                } else {
                    c.a.d.f.m.e.a().postDelayed(this.a.L0, 200L);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public p(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.G = false;
                if (this.a.I && !this.a.J) {
                    c.a.d.f.m.e.a().postDelayed(this.a.N0, 300L);
                }
                c.a.d.f.m.e.a().removeCallbacks(this.a.J0);
                c.a.d.f.m.e.a().removeCallbacks(this.a.K0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public q(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B0 = false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface r {
        void a(boolean z);
    }

    /* loaded from: classes2.dex */
    public class s extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public s(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.a.D0) {
                    if (this.a.n0 == null || !this.a.n0.b()) {
                        this.a.f1();
                        this.a.o2();
                        if (this.a.f13459f.getControl().isPlaying()) {
                            this.a.u0();
                        } else {
                            this.a.W0();
                        }
                        if (this.a.o0 != null) {
                            this.a.o0.a(this.a.f13459f.getControl().isPlaying());
                        }
                        return super.onDoubleTap(motionEvent);
                    }
                    return true;
                }
                return super.onDoubleTap(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.a.m0 != null) {
                    this.a.m0.onStart();
                }
                c cVar = this.a;
                if (cVar.s && cVar.G) {
                    if (this.a.Y == 1) {
                        this.a.O0();
                    }
                    if (this.a.Y != 0) {
                        if (this.a.Y == 1) {
                            this.a.r0(f2, true);
                        } else if (this.a.Y == 2) {
                            this.a.s0(f3);
                        }
                    } else {
                        c cVar2 = this.a;
                        if (cVar2.s) {
                            cVar2.P1();
                        }
                        if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                            this.a.Y = 1;
                            c cVar3 = this.a;
                            cVar3.a0 = cVar3.f13459f.getControl().getCurrentPosition();
                            this.a.r0(f2, true);
                        } else {
                            this.a.Y = 2;
                            this.a.s0(f3);
                        }
                    }
                    return super.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (!this.a.D0) {
                    if (this.a.G) {
                        if (this.a.n0 != null && this.a.n0.a()) {
                            return true;
                        }
                        this.a.k2();
                        if (this.a.f13459f.getControl().isPlaying()) {
                            this.a.u0();
                        } else {
                            this.a.W0();
                        }
                        if (this.a.o0 != null) {
                            this.a.o0.a(this.a.f13459f.getControl().isPlaying());
                        }
                    } else {
                        this.a.f1();
                        this.a.o2();
                        if (this.a.w0 != 1) {
                            this.a.W0();
                            this.a.x0();
                        } else {
                            this.a.w0();
                        }
                        if (this.a.o0 != null) {
                            this.a.o0.a(this.a.w0 == 1);
                        }
                    }
                    return super.onSingleTapConfirmed(motionEvent);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ s(c cVar, i iVar) {
            this(cVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface t {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public interface u {
        void a(boolean z);

        void b();
    }

    /* loaded from: classes2.dex */
    public interface v {
        void a(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface w {
        void a(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface x {
        void onPause();
    }

    /* loaded from: classes2.dex */
    public interface y {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface z {
        void a();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 100;
        this.f13455b = false;
        this.s = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.O = 0;
        this.Y = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 60000L;
        this.f0 = 0;
        this.i0 = false;
        this.t0 = true;
        this.u0 = false;
        this.v0 = false;
        this.w0 = -1;
        this.y0 = false;
        this.C0 = true;
        this.E0 = false;
        this.H0 = new k(this);
        this.I0 = new l(this);
        this.J0 = new m(this);
        this.K0 = new n(this);
        this.L0 = new o(this);
        this.M0 = new p(this);
        this.N0 = new q(this);
        this.O0 = new a(this);
        this.P0 = new d(this);
        this.Q0 = new e(this);
        this.R0 = new f(this, 2016503);
        this.S0 = new g(this);
        this.T0 = new h(this);
        if (tbPageContext == null) {
            return;
        }
        this.f13456c = tbPageContext;
        this.f13457d = view;
        this.C0 = z2;
        this.r = view;
        this.F0 = tbPageContext.getPageActivity();
        Q0();
    }

    public static String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int L0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static boolean M0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(SapiSystemBarTintManager.SystemBarConfig.k, "bool", "android");
            if (identifier != 0) {
                boolean z2 = resources.getBoolean(identifier);
                String F0 = F0();
                if ("1".equals(F0)) {
                    return false;
                }
                if ("0".equals(F0)) {
                    return true;
                }
                return z2;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        return invokeL.booleanValue;
    }

    public final void A0(Activity activity, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, activity, z2) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (z2) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags |= 1024;
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().addFlags(512);
            return;
        }
        WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
        attributes2.flags &= -1025;
        activity.getWindow().setAttributes(attributes2);
        activity.getWindow().clearFlags(512);
    }

    public void A1(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xVar) == null) {
            this.s0 = xVar;
        }
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.f13459f;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null) {
                return 0;
            }
            return this.f13459f.getControl().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public void B1(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yVar) == null) {
            this.k0 = yVar;
        }
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.w0 : invokeV.intValue;
    }

    public void C1(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zVar) == null) {
            this.j0 = zVar;
        }
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public void D1(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, a0Var) == null) {
            this.l0 = a0Var;
        }
    }

    public View E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13458e : (View) invokeV.objValue;
    }

    public void E1(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, b0Var) == null) {
            this.m0 = b0Var;
        }
    }

    public void F1(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, c0Var) == null) {
            this.q0 = c0Var;
        }
    }

    public int G0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            int i2 = 0;
            if (context == null) {
                return 0;
            }
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                if (context.getResources() != null && context.getResources().getConfiguration() != null && context.getResources().getConfiguration().orientation == 2) {
                    i2 = displayMetrics.widthPixels;
                } else {
                    i2 = displayMetrics.heightPixels;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return i2 == 0 ? c.a.d.f.p.n.i(context) : i2;
        }
        return invokeL.intValue;
    }

    public void G1(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.K = onClickListener;
        }
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? !this.s : invokeV.booleanValue;
    }

    public void H1(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onCompletionListener) == null) {
            this.C = onCompletionListener;
        }
    }

    public c.a.p0.c3.g I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f13459f.getControl() : (c.a.p0.c3.g) invokeV.objValue;
    }

    public void I1(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onErrorListener) == null) {
            this.D = onErrorListener;
        }
    }

    public View J0(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            return LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d0296, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public void J1(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onPreparedListener) == null) {
            this.B = onPreparedListener;
        }
    }

    public VideoListMediaControllerView K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f13461h : (VideoListMediaControllerView) invokeV.objValue;
    }

    public void K1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
        }
    }

    public void L1(boolean z2, boolean z3) {
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.e0 == null) {
            return;
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility((z2 || !z3) ? 0 : 8);
        }
        if (!z2 && z3 && (videoListMediaControllerView = this.f13461h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13461h.getLayoutParams();
            layoutParams.rightMargin = c.a.d.f.p.n.f(this.F0, R.dimen.tbds52);
            this.f13461h.setLayoutParams(layoutParams);
        }
        this.e0.i(z2);
    }

    public void M1(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, e0Var) == null) {
            this.p0 = e0Var;
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.o != null && this.H) {
            b2(false);
            t0();
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.i.setVisibility(0);
            this.L.setAnimationListener(this.P0);
            this.o.startAnimation(this.L);
            this.H = false;
            u uVar = this.X;
            if (uVar != null) {
                uVar.b();
            }
        }
    }

    public void N1(String str) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (tbVideoViewContainer = this.f13459f) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.f13459f.getControl().setStageType(str);
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.o != null && this.H) {
            this.M.cancel();
            this.L.cancel();
            b2(false);
            t0();
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.i.setVisibility(0);
            this.H = false;
            u uVar = this.X;
            if (uVar != null) {
                uVar.b();
            }
        }
    }

    public void O1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.O = i2;
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.A.getVisibility() == 8 && this.G) {
                return;
            }
            this.G = true;
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.f13460g.c();
            this.A.setVisibility(8);
            Y0();
            this.f13461h.p();
            this.i.setVisibility(0);
            CyberPlayerManager.OnPreparedListener onPreparedListener = this.B;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
            }
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.f13458e.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.f13458e.setSystemUiVisibility(4);
            } else {
                this.f13458e.setSystemUiVisibility(5894);
            }
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            View J0 = J0(this.F0);
            this.f13458e = J0;
            J0.setOnClickListener(this.O0);
            View view = this.f13457d;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.f13458e);
            }
            this.f13459f = new TbVideoViewContainer(this.F0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.f13458e).addView(this.f13459f, 0);
            this.f13459f.setLayoutParams(layoutParams);
            c.a.p0.c3.r rVar = new c.a.p0.c3.r((ViewGroup) this.f13458e.findViewById(R.id.obfuscated_res_0x7f0902e2));
            this.f13460g = rVar;
            rVar.f(this.I0);
            VideoListMediaControllerView videoListMediaControllerView = (VideoListMediaControllerView) this.f13458e.findViewById(R.id.obfuscated_res_0x7f0913c0);
            this.f13461h = videoListMediaControllerView;
            videoListMediaControllerView.setPlayer(this.f13459f.getControl());
            ProgressBar progressBar = (ProgressBar) this.f13458e.findViewById(R.id.obfuscated_res_0x7f09181e);
            this.i = progressBar;
            progressBar.setMax(c.a.d.f.p.n.k(this.F0));
            this.i.setProgress(0);
            this.f13461h.setOnSeekBarChangeListener(this.T0);
            this.f13461h.setOnProgressUpdatedListener(this.S0);
            this.j = this.f13458e.findViewById(R.id.obfuscated_res_0x7f090382);
            View findViewById = this.f13458e.findViewById(R.id.obfuscated_res_0x7f0911d9);
            this.k = findViewById;
            findViewById.setOnClickListener(this.O0);
            this.x0 = (TextView) this.f13458e.findViewById(R.id.obfuscated_res_0x7f0902e1);
            this.l = (FrameLayout) this.f13458e.findViewById(R.id.obfuscated_res_0x7f090755);
            ImageView imageView = (ImageView) this.f13458e.findViewById(R.id.obfuscated_res_0x7f090eb5);
            this.n = imageView;
            imageView.setOnClickListener(this.O0);
            this.o = this.f13458e.findViewById(R.id.obfuscated_res_0x7f0911ea);
            this.p = this.f13458e.findViewById(R.id.obfuscated_res_0x7f091ffe);
            this.f13459f.getControl().setContinuePlayEnable(true);
            this.f13459f.getControl().setOperableVideoContainer(this.H0);
            this.f13459f.getControl().setOnSurfaceDestroyedListener(this.M0);
            SwitchImageView switchImageView = (SwitchImageView) this.f13458e.findViewById(R.id.obfuscated_res_0x7f090ec9);
            this.t = switchImageView;
            switchImageView.setStateImage(R.drawable.obfuscated_res_0x7f080364, R.drawable.obfuscated_res_0x7f080366);
            this.t.setState(0);
            this.t.setOnClickListener(this.O0);
            TextView textView = (TextView) this.f13458e.findViewById(R.id.obfuscated_res_0x7f092242);
            this.u = textView;
            textView.setOnClickListener(this.O0);
            TextView textView2 = (TextView) this.f13458e.findViewById(R.id.obfuscated_res_0x7f092240);
            this.v = textView2;
            textView2.setOnClickListener(this.O0);
            this.w = (TextView) this.f13458e.findViewById(R.id.obfuscated_res_0x7f09223f);
            TbImageView tbImageView = (TbImageView) this.f13458e.findViewById(R.id.obfuscated_res_0x7f092392);
            this.A = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f6a);
            c.a.d.f.p.n.k(this.F0);
            G0(this.F0);
            ImageView imageView2 = (ImageView) this.f13458e.findViewById(R.id.obfuscated_res_0x7f090eb2);
            this.E = imageView2;
            imageView2.setOnClickListener(this.O0);
            this.F = (TextView) this.f13458e.findViewById(R.id.obfuscated_res_0x7f092394);
            View findViewById2 = this.f13458e.findViewById(R.id.obfuscated_res_0x7f0911fc);
            this.q = findViewById2;
            findViewById2.setVisibility(8);
            this.L = AnimationUtils.loadAnimation(this.F0, R.anim.obfuscated_res_0x7f010035);
            this.M = AnimationUtils.loadAnimation(this.F0, R.anim.obfuscated_res_0x7f01002b);
            this.P = new GestureDetector(this.F0, new s(this, null));
            AudioManager audioManager = (AudioManager) this.F0.getSystemService("audio");
            this.W = audioManager;
            this.Z = audioManager.getStreamMaxVolume(3);
            this.h0 = this.W.getStreamVolume(3);
            U0 = 100 / this.Z;
            this.f13458e.setOnTouchListener(new i(this));
            c.a.p0.c3.l lVar = new c.a.p0.c3.l(this.F0);
            this.e0 = lVar;
            if (this.C0) {
                lVar.j();
            }
            this.f0 = c.a.d.f.p.n.f(this.F0, R.dimen.obfuscated_res_0x7f0701be);
            if (V0 == null) {
                V0 = new CallStateReceiver();
            }
            V0.register(this.F0);
            Q1();
            MessageManager.getInstance().registerListener(this.R0);
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new j(this));
        }
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.t0) {
                if (!UtilHelper.canUseStyleImmersiveSticky() || TbSingleton.getInstance().isNotchScreen(this.F0) || TbSingleton.getInstance().isCutoutScreen(this.F0)) {
                    return;
                }
                this.f13458e.setSystemUiVisibility(4);
                return;
            }
            this.f13458e.setSystemUiVisibility(0);
        }
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public void R1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.A.J(str, 17, false);
        }
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.f13459f;
            return tbVideoViewContainer != null && tbVideoViewContainer.getHeight() >= this.f13459f.getWidth();
        }
        return invokeV.booleanValue;
    }

    public void S1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
        }
    }

    public boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.f13459f;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null) {
                return false;
            }
            return this.f13459f.getControl().isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void T1(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, g0Var) == null) {
            this.G0 = g0Var;
        }
    }

    public void U0(TbPageContext tbPageContext, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, tbPageContext, configuration) == null) {
            if (!this.i0) {
                if (this.s) {
                    TiebaStatic.log(new StatisticItem("c11712"));
                } else {
                    TiebaStatic.log(new StatisticItem("c11711"));
                }
            } else {
                this.i0 = false;
            }
            if (configuration.orientation == 2) {
                y0();
            } else {
                z0();
            }
            m2();
            if (this.F0 == c.a.d.a.b.g().b()) {
                g1();
            }
            o2();
            w0();
            r rVar = this.o0;
            if (rVar != null) {
                rVar.a(true);
            }
        }
    }

    public void U1(int i2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048614, this, i2) == null) || (tbImageView = this.A) == null) {
            return;
        }
        tbImageView.setDefaultBgResource(i2);
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.f13459f.getControl().pause();
            this.w0 = 2;
            c1();
        }
    }

    public void V1(int i2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i2) == null) || (tbImageView = this.A) == null) {
            return;
        }
        tbImageView.setPlaceHolder(i2);
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.Q0);
        }
    }

    public void W1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.F.setText(str);
        }
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.Y = 0;
            View view = this.Q;
            if (view != null && view.getParent() != null && (this.Q.getParent() instanceof ViewGroup)) {
                try {
                    ((ViewGroup) this.Q.getParent()).removeView(this.Q);
                    this.Q = null;
                } catch (IllegalArgumentException unused) {
                }
            }
            View view2 = this.R;
            if (view2 == null || view2.getParent() == null || !(this.R.getParent() instanceof ViewGroup)) {
                return;
            }
            try {
                ((ViewGroup) this.R.getParent()).removeView(this.R);
                this.R = null;
            } catch (IllegalArgumentException unused2) {
            }
        }
    }

    public void X1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, str, str2) == null) {
            this.x = str;
            this.y = str2;
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || this.o == null) {
            return;
        }
        this.M.setAnimationListener(null);
        this.L.setAnimationListener(null);
        this.o.clearAnimation();
    }

    public void Y1(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, d0Var) == null) {
            this.n0 = d0Var;
        }
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            a1(true);
        }
    }

    public void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.f13458e.setVisibility(0);
        }
    }

    public final void a1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) || this.o == null) {
            return;
        }
        this.j.setVisibility(0);
        this.v.setVisibility(8);
        this.u.setVisibility(8);
        this.w.setVisibility(8);
        this.f13460g.b();
        O0();
        this.i.setVisibility(8);
        this.k.setVisibility(8);
        this.f13461h.n();
        this.A.setVisibility(z2 ? 0 : 8);
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && c.a.d.f.p.l.x()) {
            c.a.p0.n4.h.c().f(this.F0);
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            c.a.d.f.p.n.k(this.f13456c.getPageActivity());
            G0(this.f13456c.getPageActivity());
        }
    }

    public void b2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            o2();
            if (z2) {
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
            }
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.f13460g.b();
            this.v.setVisibility(8);
            this.u.setVisibility(8);
            this.w.setVisibility(8);
            o2();
        }
    }

    public void c2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, str, str2) == null) {
            d2(str, str2, true);
        }
    }

    public final void d1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            if (z2) {
                this.A.setVisibility(0);
                O0();
                this.i.setProgress(0);
            } else {
                this.A.setVisibility(8);
                O0();
            }
            this.f13461h.p();
            this.j.setVisibility(8);
            this.v.setVisibility(8);
            this.u.setVisibility(8);
            this.w.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public final void d2(String str, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048632, this, str, str2, z2) == null) {
            a2();
            this.B0 = true;
            this.w0 = 0;
            X1(str, str2);
            c.a.p0.c3.s sVar = new c.a.p0.c3.s();
            sVar.f13499e = "ad_video_landing";
            sVar.f13498d = sVar.a("ad_video_landing");
            sVar.f13500f = sVar.c("1");
            this.f13459f.getControl().setVideoModel(sVar);
            this.f13459f.getControl().setVideoPath(str, str2);
            c.a.d.f.m.e.a().removeCallbacks(this.K0);
            if (this.c0 > 0) {
                c.a.d.f.m.e.a().postDelayed(this.K0, this.c0);
            }
            f0 f0Var = this.d0;
            if (f0Var != null) {
                f0Var.onStarted();
            }
            this.f13460g.g();
            d1(z2);
        }
    }

    public boolean e1(int i2) {
        InterceptResult invokeI;
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            if (i2 != 4) {
                if ((i2 == 24 || i2 == 25) && (audioManager = this.W) != null && this.Z > 0 && this.T != null) {
                    int streamVolume = audioManager.getStreamVolume(3);
                    this.h0 = streamVolume;
                    int i3 = (int) ((streamVolume * 100.0d) / this.Z);
                    this.g0 = i3;
                    this.T.setProgress(i3);
                }
                return false;
            } else if (this.s) {
                if (S0()) {
                    n2(false);
                    z0();
                    return true;
                }
                l2();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void e2(v vVar, boolean z2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{vVar, Boolean.valueOf(z2), str, str2}) == null) {
            if (this.v0) {
                f2(str, str2);
            } else {
                c2(str, str2);
            }
            if (vVar != null) {
                vVar.a(z2);
            }
        }
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            if (this.f13459f.getControl().isPlaying()) {
                V0();
                x xVar = this.s0;
                if (xVar != null) {
                    xVar.onPause();
                }
                f0 f0Var = this.d0;
                if (f0Var != null) {
                    f0Var.onPaused();
                }
            } else if (this.G) {
                g1();
                z zVar = this.j0;
                if (zVar != null) {
                    zVar.a();
                }
                f0 f0Var2 = this.d0;
                if (f0Var2 != null) {
                    f0Var2.b();
                }
            } else {
                g2();
            }
        }
    }

    public void f2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, str, str2) == null) {
            a2();
            this.B0 = true;
            this.w0 = 0;
            c.a.d.f.m.e.a().removeCallbacks(this.K0);
            if (this.c0 > 0) {
                c.a.d.f.m.e.a().postDelayed(this.K0, this.c0);
            }
            f0 f0Var = this.d0;
            if (f0Var != null) {
                f0Var.onStarted();
            }
            this.f13460g.g();
            d1(true);
        }
    }

    public void g1() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || (tbVideoViewContainer = this.f13459f) == null || tbVideoViewContainer.getControl() == null || this.f13461h == null) {
            return;
        }
        this.G = true;
        this.w0 = 1;
        this.f13459f.getControl().b(null);
        int c2 = c.a.p0.c3.t.d().c(this.x);
        this.O = c2;
        this.u0 = true;
        int i2 = 100;
        if (c2 > 100) {
            int duration = this.f13459f.getControl().getDuration();
            int i3 = this.O;
            if (duration > i3) {
                i2 = i3;
            }
        }
        this.a = i2;
        this.f13460g.b();
        d1(false);
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            h2(this.x, this.y, null, new Object[0]);
        }
    }

    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            g1();
            this.i.setVisibility(0);
        }
    }

    public void h2(String str, String str2, v vVar, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048640, this, str, str2, vVar, objArr) == null) {
            a2();
            if (c.a.d.f.p.l.x() && !c.a.p0.n4.h.c().d() && !TbSingleton.getInstance().hasAgreeToPlay()) {
                Date date = new Date(c.a.o0.r.j0.b.k().m("video_list_confirm_play_in_mobile_net", 0L));
                Date date2 = new Date();
                if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                    this.v0 = ((Boolean) objArr[0]).booleanValue();
                }
                if (date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay()) {
                    w wVar = this.r0;
                    if (wVar != null) {
                        wVar.a(true);
                        return;
                    }
                    if (!this.f13455b) {
                        this.f13455b = true;
                        c.a.d.f.p.n.M(this.F0, R.string.obfuscated_res_0x7f0f0e4d);
                    }
                    e2(vVar, true, str, str2);
                    return;
                }
                w wVar2 = this.r0;
                if (wVar2 != null) {
                    wVar2.a(false);
                    return;
                }
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.F0);
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e4c));
                aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f0516, new b(this, vVar, str, str2));
                aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f0515, new C1015c(this));
                aVar.create(this.f13456c).show();
                return;
            }
            e2(vVar, true, str, str2);
            c0 c0Var = this.q0;
            if (c0Var != null) {
                c0Var.b();
            }
        }
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            c.a.o0.r.j0.b.k().x("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
        }
    }

    public final void i2() {
        TbVideoViewContainer tbVideoViewContainer;
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (tbVideoViewContainer = this.f13459f) == null || tbVideoViewContainer.getControl() == null || (videoListMediaControllerView = this.f13461h) == null) {
            return;
        }
        videoListMediaControllerView.p();
        this.O = c.a.p0.c3.t.d().c(this.x);
        if (this.B0) {
            this.f13459f.getControl().setVolume(1.0f, 1.0f);
            this.f13459f.getControl().start();
            this.B0 = false;
            c.a.d.f.m.e.a().removeCallbacks(this.J0);
            c.a.d.f.m.e.a().postDelayed(this.J0, 20L);
            c.a.d.f.m.e.a().removeCallbacks(this.K0);
            c.a.d.f.m.e.a().removeCallbacks(this.N0);
            if (this.f13459f.getControl().n()) {
                this.w0 = 1;
                O0();
            }
            this.O = c.a.p0.c3.t.d().c(this.x);
            this.f13461h.setPlayer(this.f13459f.getControl());
            if (this.O != 0) {
                this.u0 = true;
            }
            if (!this.A0) {
                this.f13461h.p();
            }
            if (!this.I && this.f13459f.getControl().getDuration() <= 0) {
                K0().setVisibility(4);
            }
        }
        int i2 = 100;
        if (this.O > 100) {
            int duration = this.f13459f.getControl().getDuration();
            int i3 = this.O;
            if (duration > i3) {
                i2 = i3;
            }
        }
        this.a = i2;
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || this.f13459f.getControl().getDuration() < this.f13459f.getControl().getCurrentPosition()) {
            return;
        }
        c.a.p0.c3.t.d().update(this.x, this.f13459f.getControl().getCurrentPositionSync());
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            this.w0 = 5;
            c.a.d.f.m.e.a().removeCallbacks(this.J0);
            c.a.d.f.m.e.a().removeCallbacks(this.K0);
            c.a.d.f.m.e.a().removeCallbacks(this.N0);
            this.f13459f.getControl().stopPlayback();
            this.G = false;
            this.B0 = false;
            this.O = 0;
            Z0();
        }
    }

    public void k1(f0 f0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, f0Var) == null) {
            this.d0 = f0Var;
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || this.o == null) {
            return;
        }
        if (this.H) {
            O0();
        } else {
            x0();
        }
    }

    public void l1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.z = str;
        }
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.i0 = true;
            c.a.p0.c3.l lVar = this.e0;
            if (lVar != null) {
                lVar.l();
            }
        }
    }

    public void m1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z2) == null) {
            this.D0 = z2;
        }
    }

    public void m2() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048650, this) == null) || (tbVideoViewContainer = this.f13459f) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        int k2 = c.a.d.f.p.n.k(this.F0);
        if (this.s) {
            k2 = c.a.d.f.p.n.i(this.F0);
        }
        this.i.setMax(k2);
        int duration = this.f13459f.getControl().getDuration();
        if (duration > 0) {
            if (this.u.getVisibility() == 0) {
                ProgressBar progressBar = this.i;
                progressBar.setProgress(progressBar.getMax());
                return;
            }
            this.i.setProgress((int) ((this.f13459f.getControl().getCurrentPositionSync() * this.i.getMax()) / duration));
        }
    }

    public void n1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z2) == null) {
            this.t0 = z2;
            Q1();
        }
    }

    public void n2(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048652, this, z2) == null) && M0(this.F0) && (this.p.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            if (z2) {
                layoutParams.bottomMargin = L0(this.F0);
                this.p.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.p.setBackgroundResource(R.drawable.obfuscated_res_0x7f080304);
            }
            this.p.setLayoutParams(layoutParams);
        }
    }

    public void o1(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, rVar) == null) {
            this.o0 = rVar;
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            if (this.w0 == 1) {
                this.t.setState(1);
            } else {
                this.t.setState(0);
            }
        }
    }

    public final void p0() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            int i2 = this.Y;
            if (i2 == 1) {
                if (this.Q == null && (view2 = this.f13458e) != null && (view2 instanceof ViewGroup)) {
                    LayoutInflater.from(this.F0).inflate(R.layout.obfuscated_res_0x7f0d0297, (ViewGroup) this.f13458e, true);
                    View findViewById = this.f13458e.findViewById(R.id.obfuscated_res_0x7f0911b1);
                    this.Q = findViewById;
                    this.S = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091cf9);
                    this.V = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f0902a5);
                }
            } else if (i2 == 2 && this.R == null && (view = this.f13458e) != null && (view instanceof ViewGroup)) {
                LayoutInflater.from(this.F0).inflate(R.layout.obfuscated_res_0x7f0d0298, (ViewGroup) this.f13458e, true);
                View findViewById2 = this.f13458e.findViewById(R.id.obfuscated_res_0x7f0911ba);
                this.R = findViewById2;
                this.U = (ImageView) findViewById2.findViewById(R.id.obfuscated_res_0x7f0902ab);
                this.T = (SeekBar) this.R.findViewById(R.id.obfuscated_res_0x7f091cfb);
            }
        }
    }

    public void p1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z2) == null) {
            this.I = z2;
        }
    }

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            n2(false);
            z0();
        }
    }

    public void q0() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || (view = this.r) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f13458e.getLayoutParams();
        this.m = layoutParams2;
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        layoutParams2.topMargin = 0;
        Activity activity = this.F0;
        if (activity != null && activity.getResources() != null && this.F0.getResources().getConfiguration() != null && this.F0.getResources().getConfiguration().orientation == 2) {
            this.f13458e.setLayoutParams(new FrameLayout.LayoutParams(c.a.d.f.p.n.i(this.F0), c.a.d.f.p.n.k(this.F0)));
        } else {
            this.f13458e.setLayoutParams(this.m);
        }
    }

    public void q1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z2) == null) {
            this.J = z2;
        }
    }

    public final void r0(float f2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048660, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                if (f2 > 0.0f) {
                    this.a0 -= 1000;
                    this.b0 = 1;
                } else {
                    this.a0 += 1000;
                    this.b0 = 2;
                }
                int i2 = this.a0;
                if (i2 < 0) {
                    this.a0 = 0;
                } else if (i2 > this.f13459f.getControl().getDuration()) {
                    this.a0 = this.f13459f.getControl().getDuration();
                }
            }
            p0();
            String g2 = this.f13461h.g(this.a0);
            if (f2 > 0.0f) {
                this.V.setImageResource(R.drawable.obfuscated_res_0x7f080781);
            } else {
                this.V.setImageResource(R.drawable.obfuscated_res_0x7f080780);
            }
            if (!StringUtils.isNull(g2)) {
                TextView textView = this.S;
                StringBuilder sb = new StringBuilder();
                sb.append(g2);
                sb.append("/");
                sb.append(this.f13461h.g(this.f13459f.getControl().getDuration()));
                textView.setText(sb);
            }
            this.f13461h.setCurrentDuration(this.a0, !z2);
            O0();
            m2();
        }
    }

    public void r1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) {
            this.y0 = z2;
        }
    }

    public final void s0(float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048662, this, f2) == null) {
            if (!this.G) {
                this.Y = 0;
                return;
            }
            if (U0 == 0) {
                int streamMaxVolume = this.W.getStreamMaxVolume(3);
                this.Z = streamMaxVolume;
                int i6 = 100 / streamMaxVolume;
                U0 = i6;
                if (i6 == 0) {
                    U0 = 1;
                }
            }
            p0();
            int i7 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i7 > 0 && (i5 = this.g0) < 100) {
                this.g0 = i5 + 1;
            }
            int i8 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i8 < 0 && (i4 = this.g0) > 0) {
                this.g0 = i4 - 1;
            }
            if (this.g0 % U0 == 0) {
                if (i7 > 0 && (i3 = this.h0) < this.Z) {
                    this.h0 = i3 + 1;
                }
                if (i8 < 0 && (i2 = this.h0) > 0) {
                    this.h0 = i2 - 1;
                }
            }
            if (this.g0 > 0) {
                this.U.setImageResource(R.drawable.obfuscated_res_0x7f080a25);
            } else {
                this.U.setImageResource(R.drawable.obfuscated_res_0x7f080a24);
            }
            this.W.setStreamVolume(3, this.h0, 0);
            this.T.setProgress(this.g0);
        }
    }

    public void s1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048663, this, z2) == null) {
            this.I = z2;
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048664, this) == null) || this.o == null) {
            return;
        }
        c.a.d.f.m.e.a().removeCallbacks(this.Q0);
        this.M.setAnimationListener(null);
        this.L.setAnimationListener(null);
        this.o.clearAnimation();
    }

    public final void t1(int i2) {
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048665, this, i2) == null) && (videoListMediaControllerView = this.f13461h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13461h.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.f13461h.setLayoutParams(layoutParams);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.Q0);
            c.a.d.f.m.e.a().postDelayed(this.Q0, 3000L);
        }
    }

    public void u1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z2) == null) {
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            j2();
            c.a.d.f.m.e.a().removeCallbacks(this.Q0);
            c.a.d.f.m.e.a().removeCallbacks(this.J0);
            c.a.d.f.m.e.a().removeCallbacks(this.K0);
            c.a.d.f.m.e.a().removeCallbacks(this.L0);
            c.a.d.f.m.e.a().removeCallbacks(this.N0);
            this.e0.k();
            V0.unregister(this.F0);
        }
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && c.a.d.f.p.l.z() && this.z0 && !StringUtils.isNull(this.x) && !StringUtils.isNull(this.y)) {
            this.z0 = false;
            this.A0 = true;
            c2(this.x, this.y);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            x0();
            u0();
        }
    }

    public void w1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048672, this) == null) || this.o == null || this.H || this.E0) {
            return;
        }
        b2(true);
        t0();
        this.o.setVisibility(0);
        this.p.setVisibility(0);
        this.i.setVisibility(8);
        this.H = true;
        u uVar = this.X;
        if (uVar != null) {
            uVar.a(false);
        }
    }

    public void x1(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, tVar) == null) {
            this.N = tVar;
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            this.s = true;
            this.f13458e.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(c.a.o0.c1.l.d().g(this.F0)), Integer.parseInt(c.a.o0.c1.l.d().f(this.F0))));
            A0(this.F0, true);
            this.q.setVisibility(0);
            this.E.setVisibility(0);
            this.F.setVisibility(0);
            this.l.setVisibility(8);
            this.f13460g.b();
            this.A.setVisibility(8);
            this.n.setImageResource(R.drawable.obfuscated_res_0x7f080ac3);
            t1(this.f0);
            P1();
            t tVar = this.N;
            if (tVar != null) {
                tVar.a();
            }
        }
    }

    public void y1(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, uVar) == null) {
            this.X = uVar;
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            this.s = false;
            FrameLayout.LayoutParams layoutParams = this.m;
            if (layoutParams != null) {
                this.f13458e.setLayoutParams(layoutParams);
            }
            A0(this.F0, false);
            this.q.setVisibility(8);
            this.l.setVisibility(0);
            this.f13460g.b();
            this.A.setVisibility(8);
            this.n.setImageResource(R.drawable.obfuscated_res_0x7f080ab6);
            VideoListMediaControllerView videoListMediaControllerView = this.f13461h;
            if (videoListMediaControllerView != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f13461h.getLayoutParams();
                layoutParams2.leftMargin = c.a.d.f.p.n.f(this.F0, R.dimen.tbds24);
                layoutParams2.rightMargin = 0;
                this.f13461h.setLayoutParams(layoutParams2);
            }
            this.f13458e.setSystemUiVisibility(0);
            Q1();
            t tVar = this.N;
            if (tVar != null) {
                tVar.b();
            }
        }
    }

    public void z1(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, wVar) == null) {
            this.r0 = wVar;
        }
    }
}
