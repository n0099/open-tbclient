package b.a.r0.k2.x;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.g.d;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.n1;
import b.a.r0.q2.c;
import b.a.r0.q2.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.video.CustomFrameLayout;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static VideoControllerView.c U;
    public static c.d0 V;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.y.c A;
    public PbVideoWifiTipLayout B;
    public int C;
    public long D;
    public c.k0 E;
    public c.y F;
    public boolean G;
    public Handler H;
    public PbFullScreenFloatingHuajiAninationView I;
    public PbFullScreenFloatingHuajiAninationView.c J;
    public b.a.e.e.g.c K;
    public Bitmap L;
    public boolean M;
    public boolean N;
    public boolean O;
    public c.h0 P;
    public CustomMessageListener Q;
    public int R;
    public Animation.AnimationListener S;
    public CustomMessageListener T;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f19690a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.u.f.g1.c f19691b;

    /* renamed from: c  reason: collision with root package name */
    public CustomFrameLayout f19692c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f19693d;

    /* renamed from: e  reason: collision with root package name */
    public c.y f19694e;

    /* renamed from: f  reason: collision with root package name */
    public String f19695f;

    /* renamed from: g  reason: collision with root package name */
    public VideoInfo f19696g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.q2.c f19697h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.q2.p f19698i;
    public b.a.r0.k2.x.e j;
    public boolean k;
    public d2 l;
    public d2 m;
    public String n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public float s;
    public boolean t;
    public boolean u;
    public int v;
    public double w;
    public View x;
    public float y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoInfo f19699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19700f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d2 f19701g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f19702h;

        public a(g gVar, VideoInfo videoInfo, String str, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, videoInfo, str, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19702h = gVar;
            this.f19699e = videoInfo;
            this.f19700f = str;
            this.f19701g = d2Var;
        }

        @Override // b.a.r0.q2.f.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f19702h.D <= 0) {
                    this.f19702h.D = i3;
                }
                McnAdInfo mcnAdInfo = this.f19699e.mcn_ad_card;
                if (mcnAdInfo == null) {
                    return;
                }
                boolean a2 = b.a.y.b.b().a(mcnAdInfo.jump_url);
                if (!this.f19702h.z || a2 || this.f19702h.p) {
                    return;
                }
                boolean z = true;
                boolean z2 = this.f19702h.D >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                long j = i3;
                if ((j < mcnAdInfo.ad_start_time.longValue() * 1000 || j >= mcnAdInfo.ad_end_time.longValue() * 1000) ? false : false) {
                    if (this.f19702h.A.c()) {
                        return;
                    }
                    b.a.y.a aVar = new b.a.y.a();
                    aVar.f29947b = mcnAdInfo.card_title;
                    aVar.f29948c = mcnAdInfo.button_title;
                    aVar.f29949d = mcnAdInfo.jump_url;
                    aVar.f29946a = mcnAdInfo.pic_url;
                    aVar.f29951f = this.f19700f;
                    aVar.f29950e = this.f19701g.s1();
                    aVar.f29952g = 4;
                    if (z2) {
                        this.f19702h.A.f(aVar, (ViewGroup) this.f19702h.f19697h.E0());
                    } else {
                        this.f19702h.A.e(aVar, (ViewGroup) this.f19702h.f19697h.E0());
                    }
                } else if (this.f19702h.A.c()) {
                    this.f19702h.A.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19703a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19704e;

            public a(b bVar) {
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
                this.f19704e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f19704e.f19703a.C > 0) {
                        g gVar = this.f19704e.f19703a;
                        gVar.M(gVar.C);
                        g gVar2 = this.f19704e.f19703a;
                        gVar2.j0(gVar2.C);
                        this.f19704e.f19703a.C = 0;
                    }
                    this.f19704e.f19703a.G = true;
                }
            }
        }

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19703a = gVar;
        }

        @Override // b.a.r0.q2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19703a.f19693d.getBaseFragmentActivity().setSwipeBackEnabled(false);
                this.f19703a.G = false;
                g gVar = this.f19703a;
                gVar.C = gVar.P().getHeight();
            }
        }

        @Override // b.a.r0.q2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f19703a.f19693d.getBaseFragmentActivity().setSwipeBackEnabled(true);
                this.f19703a.H.postDelayed(new a(this), 200L);
                this.f19703a.D = -1L;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19705a;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19705a = gVar;
        }

        @Override // b.a.r0.q2.c.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19705a.f19693d == null || this.f19705a.m == null || StringUtils.isNull(this.f19705a.m.f0())) {
                return;
            }
            this.f19705a.f19693d.loadNextVideoPb(this.f19705a.m.f0());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19706a;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19706a = gVar;
        }

        @Override // b.a.r0.q2.c.e0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f19706a.l == null) {
                return;
            }
            this.f19706a.l0(z ? "1" : "2");
        }
    }

    /* loaded from: classes5.dex */
    public class e implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19707e;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19707e = gVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f19707e.f19695f);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements b.a.e.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19708a;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19708a = gVar;
        }

        @Override // b.a.e.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 5;
            }
            return invokeV.intValue;
        }

        @Override // b.a.e.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // b.a.e.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                ImageView imageView = new ImageView(this.f19708a.f19693d.getActivity());
                if (this.f19708a.L == null) {
                    try {
                        this.f19708a.L = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), b.a.r0.k2.h.pb_video_guide_like);
                        imageView.setImageBitmap(this.f19708a.L);
                    } catch (Throwable unused) {
                    }
                }
                return imageView;
            }
            return (View) invokeL.objValue;
        }

        @Override // b.a.e.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // b.a.e.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* renamed from: b.a.r0.k2.x.g$g  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0979g implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19709a;

        public C0979g(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19709a = gVar;
        }

        @Override // b.a.e.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19709a.K = null;
                if (this.f19709a.L != null && !this.f19709a.L.isRecycled()) {
                    this.f19709a.L.recycle();
                }
                this.f19709a.L = null;
            }
        }

        @Override // b.a.e.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements c.d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.r0.q2.c.d0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19710e;

        public j(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19710e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g gVar = this.f19710e;
                gVar.j0(gVar.P().getHeight());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements c.k0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19711a;

        public k(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19711a = gVar;
        }

        @Override // b.a.r0.q2.c.k0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19711a.f19693d == null || this.f19711a.f19693d.getPbModel() == null || this.f19711a.f19693d.getPbModel().P0() == null) {
                return;
            }
            PostData j = this.f19711a.f19693d.getPbModel().P0().j();
            if (j == null && ListUtils.getCount(this.f19711a.f19693d.getPbModel().P0().F()) > 1) {
                j = (PostData) ListUtils.getItem(this.f19711a.f19693d.getPbModel().P0().F(), 0);
            }
            b.a.r0.k2.w.a.b(this.f19711a.f19693d.getPbModel().P0(), j, 1, 1, 4);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19712e;

        public l(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19712e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19712e.m0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19713a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
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
            this.f19713a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19713a.f19696g == null) {
                return;
            }
            g gVar = this.f19713a;
            gVar.b0(gVar.f19696g);
            this.f19713a.f19697h.c1();
            this.f19713a.f19697h.q0();
            if (this.f19713a.x == null || this.f19713a.x.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f19713a.x.getLayoutParams();
            layoutParams.height = this.f19713a.v;
            this.f19713a.x.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements PbFullScreenFloatingHuajiAninationView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19714a;

        public n(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19714a = gVar;
        }

        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19714a.N(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements c.h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19715a;

        public o(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19715a = gVar;
        }

        @Override // b.a.r0.q2.c.h0
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // b.a.r0.q2.c.h0
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f19715a.w >= 1.0d) {
                    if (!this.f19715a.f19693d.checkUpIsLogin()) {
                        return true;
                    }
                    this.f19715a.f19693d.hideKeyboardAndEditor();
                    if (this.f19715a.f19693d.getPbModel() != null && this.f19715a.f19693d.getPbModel().P0() != null && this.f19715a.f19693d.getPbModel().P0().S() != null) {
                        b.a.r0.k2.r.q S = this.f19715a.f19693d.getPbModel().P0().S();
                        if (this.f19715a.I == null) {
                            this.f19715a.I = new PbFullScreenFloatingHuajiAninationView(this.f19715a.f19693d.getActivity());
                            this.f19715a.I.setFloatingHuajiAninationListener(this.f19715a.J);
                        }
                        this.f19715a.I.startAnimation(!S.g());
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19716a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
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
            this.f19716a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && b.a.e.e.p.j.z()) {
                if (this.f19716a.f19697h != null) {
                    this.f19716a.f19697h.w1();
                }
                if (!b.a.e.e.p.j.x() || this.f19716a.f19697h == null || !this.f19716a.f19697h.T0() || this.f19716a.f19696g == null || this.f19716a.f19696g.video_length.intValue() <= 0 || this.f19716a.f19696g.video_duration.intValue() <= 0) {
                    return;
                }
                DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
                double intValue = ((this.f19716a.f19696g.video_length.intValue() * (1.0f - ((this.f19716a.f19697h.B0() * 1.0f) / (this.f19716a.f19696g.video_duration.intValue() * 1000)))) * 1.0f) / 1048576.0f;
                if (intValue >= 0.1d) {
                    b.a.e.e.p.l.M(this.f19716a.f19693d.getPageContext().getPageActivity(), String.format(this.f19716a.f19693d.getPageContext().getString(b.a.r0.k2.l.pb_video_net_change_tip), decimalFormat.format(intValue)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements c.i0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19717a;

        public q(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19717a = gVar;
        }

        @Override // b.a.r0.q2.c.i0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.f19717a.D = -1L;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements c.f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19718a;

        public r(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19718a = gVar;
        }

        @Override // b.a.r0.q2.c.f0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // b.a.r0.q2.c.f0
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // b.a.r0.q2.c.f0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.f19718a.f19693d.getListView() != null && this.f19718a.f19693d.getListView().getChildCount() > 0 && this.f19718a.f19693d.getListView().getChildAt(0) == this.f19718a.R()) {
                                this.f19718a.f19693d.getListView().setSelectionFromTop(0, this.f19718a.R + ((int) (motionEvent.getY() - this.f19718a.y)));
                            }
                        }
                    }
                    this.f19718a.y = 0.0f;
                    this.f19718a.R = 0;
                } else {
                    this.f19718a.y = motionEvent.getY();
                    if (this.f19718a.f19693d.getListView() != null && this.f19718a.f19693d.getListView().getChildCount() > 0 && this.f19718a.f19693d.getListView().getChildAt(0) == this.f19718a.R()) {
                        g gVar = this.f19718a;
                        gVar.R = gVar.R().getTop();
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19719e;

        public s(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19719e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19719e.M = true;
                this.f19719e.B.setVisibility(8);
                this.f19719e.v0();
                TiebaStatic.log("c12618");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements c.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f19720a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f19721b;

        public t(g gVar, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19721b = gVar;
            this.f19720a = animation;
        }

        @Override // b.a.r0.q2.c.y
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f19721b.a0() && this.f19721b.f19691b != null) {
                this.f19720a.setAnimationListener(null);
                this.f19721b.f19691b.p().clearAnimation();
                this.f19721b.t0();
                if (z) {
                    this.f19720a.setAnimationListener(this.f19721b.S);
                    this.f19721b.f19691b.p().startAnimation(this.f19720a);
                }
            }
        }

        @Override // b.a.r0.q2.c.y
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f19721b.a0()) {
                this.f19721b.S();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19722a;

        public u(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19722a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f19722a.S();
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1252032713, "Lb/a/r0/k2/x/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1252032713, "Lb/a/r0/k2/x/g;");
                return;
            }
        }
        U = new h();
        V = new i();
    }

    public g(PbFragment pbFragment, b.a.r0.k2.u.f.g1.c cVar, VideoInfo videoInfo, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar, videoInfo, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19695f = null;
        this.f19696g = null;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.r = 0;
        this.s = 0.0f;
        this.t = false;
        this.u = false;
        this.D = -1L;
        this.E = new k(this);
        this.G = true;
        this.J = new n(this);
        this.N = false;
        this.P = new o(this);
        this.Q = new p(this, 2000994);
        this.S = new u(this);
        this.T = new m(this, 2921414);
        this.f19693d = pbFragment;
        this.f19691b = cVar;
        this.s = b.a.e.e.p.l.g(pbFragment.getActivity(), b.a.r0.k2.g.ds240);
        V(videoInfo);
        T();
        MessageManager.getInstance().registerListener(this.Q);
        this.T.setTag(pbFragment.getUniqueId());
        this.T.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.T);
        this.A = new b.a.y.c(pbFragment.getActivity());
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || P().getHeight() + i2 <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19692c.getLayoutParams();
        if ((layoutParams.width == -1 && layoutParams.height == -1) || i2 == 0) {
            return;
        }
        if (i2 > 0) {
            this.O = false;
            if (this.v != P().getHeight()) {
                this.f19692c.setLayoutParams(new RelativeLayout.LayoutParams(b.a.e.e.p.l.k(this.f19693d.getActivity()), Math.min(this.v, P().getHeight() + i2)));
                this.f19697h.q0();
            }
        } else if (b.a.e.e.p.l.k(this.f19693d.getActivity()) * 0.5625d != P().getHeight()) {
            this.f19692c.setLayoutParams(new RelativeLayout.LayoutParams(b.a.e.e.p.l.k(this.f19693d.getActivity()), (int) Math.max(b.a.e.e.p.l.k(this.f19693d.getActivity()) * 0.5625d, P().getHeight() + i2)));
            this.f19697h.q0();
        }
    }

    public final void N(boolean z) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (pbFragment = this.f19693d) == null) {
            return;
        }
        pbFragment.doPraiseClick();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.r0.q2.c cVar = this.f19697h;
            if (cVar != null) {
                cVar.v0();
            }
            CustomFrameLayout customFrameLayout = this.f19692c;
            if (customFrameLayout != null) {
                customFrameLayout.clearAnimation();
            }
            b.a.r0.k2.x.e eVar = this.j;
            if (eVar != null) {
                eVar.k();
            }
            MessageManager.getInstance().unRegisterListener(this.Q);
            MessageManager.getInstance().unRegisterListener(this.T);
        }
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19690a : (View) invokeV.objValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : invokeV.intValue;
    }

    public View R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.x : (View) invokeV.objValue;
    }

    public void S() {
        b.a.r0.k2.u.f.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f19691b) == null) {
            return;
        }
        cVar.r();
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f19693d.getActivity(), b.a.r0.k2.e.anim_alpha_1_to_0_duration_2000_accelerate);
            if (this.f19694e == null) {
                this.f19694e = new t(this, loadAnimation);
            }
            o0(this.f19694e);
            UtilHelper.getLightStatusBarHeight();
            b.a.e.e.p.l.g(this.f19693d.getActivity(), b.a.r0.k2.g.ds98);
            this.H = new Handler();
        }
    }

    public void U(VideoInfo videoInfo, d2 d2Var, String str) {
        b.a.r0.q2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoInfo, d2Var, str) == null) || videoInfo == null || (cVar = this.f19697h) == null || d2Var == null) {
            return;
        }
        this.f19696g = videoInfo;
        this.l = d2Var;
        this.f19695f = videoInfo.video_url;
        cVar.k2();
        b.a.r0.q2.p pVar = new b.a.r0.q2.p();
        this.f19698i = pVar;
        pVar.f22882a = "pb";
        pVar.f22884c = d2Var.s1();
        b.a.r0.q2.p pVar2 = this.f19698i;
        pVar2.f22885d = str;
        pVar2.f22886e = TbadkCoreApplication.getCurrentAccount();
        if (d2Var.Q1()) {
            if (!StringUtils.isNull(this.f19693d.lastTid)) {
                this.f19698i.k = this.f19693d.lastTid;
            }
            b.a.r0.q2.p pVar3 = this.f19698i;
            pVar3.f22890i = this.f19693d.bjhFrom + "";
        } else {
            this.f19698i.f22890i = this.f19693d.getVideoSource();
        }
        n1 recomStatisticData = this.f19693d.getRecomStatisticData();
        if (recomStatisticData != null) {
            recomStatisticData.d(this.f19698i);
        }
        b.a.r0.q2.p pVar4 = this.f19698i;
        pVar4.m = videoInfo.video_md5;
        b.a.r0.q2.p b2 = pVar4.b();
        b2.f22882a = "6";
        this.D = -1L;
        if (this.f19697h.I0() != null && this.f19697h.I0().getMediaProgressObserver() != null) {
            this.f19697h.I0().getMediaProgressObserver().j(new a(this, videoInfo, str, d2Var));
        }
        this.f19697h.I0().setVideoStatData(b2);
        if (this.f19697h.H0()) {
            this.f19697h.q0();
        }
        this.f19697h.z1(this.F);
        this.n = null;
        this.m = null;
        this.f19697h.x1(null);
        this.f19697h.K0().setOnDragingListener(U);
        this.f19697h.y1(new b(this));
        this.f19697h.C1(new c(this));
        this.f19697h.E1(new d(this));
        this.f19697h.J1(new e(this));
        this.f19697h.S1(videoInfo.thumbnail_url);
        this.f19697h.Y1(this.f19695f, d2Var.s1());
        this.f19697h.m1(str);
        this.f19697h.X1(d2Var.getTitle());
        this.f19697h.D1(V);
        this.f19697h.a1();
        this.f19697h.a2();
    }

    public final void V(VideoInfo videoInfo) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoInfo) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19693d.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.video_pb_container_layout, (ViewGroup) null);
            this.f19690a = relativeLayout;
            this.f19692c = (CustomFrameLayout) relativeLayout.findViewById(b.a.r0.k2.i.pb_video_container);
            int b0 = b0(videoInfo);
            int i2 = 0;
            this.z = ((double) this.v) <= (((double) b.a.e.e.p.l.k(this.f19693d.getActivity())) * 0.5625d) + 5.0d;
            int intValue = videoInfo.video_width.intValue();
            b.a.r0.q2.c cVar = new b.a.r0.q2.c(this.f19693d.getPageContext(), this.f19692c, true);
            this.f19697h = cVar;
            cVar.O1("2002");
            this.f19697h.Z1(this.P);
            this.f19697h.t1(false);
            this.f19697h.U1(this.E);
            this.f19697h.V1(SkinManager.getResourceId(b.a.r0.k2.h.pic_use_header_40_n));
            this.f19697h.N1(new q(this));
            if (TbSingleton.getInstance().isNotchScreen(this.f19693d.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f19693d.getBaseFragmentActivity())) {
                this.f19697h.o1(false);
            }
            this.f19697h.F1(new r(this));
            if (intValue > 0) {
                if (this.w >= 1.0d) {
                    this.f19697h.M1(false, true);
                } else {
                    this.f19697h.M1(true, false);
                }
                boolean z = ((float) b0) + this.s > ((float) b.a.e.e.p.l.i(this.f19693d.getActivity()));
                this.t = z;
                if (z) {
                    if (this.j == null) {
                        this.j = new b.a.r0.k2.x.e(this.f19693d.getPageContext(), this.f19692c);
                    }
                    this.f19693d.getPbView().c1();
                    this.k = true;
                }
            }
            u0();
            this.x = new View(this.f19693d.getContext());
            this.x.setLayoutParams(new AbsListView.LayoutParams(-1, this.v));
            b.a.r0.k2.u.f.g1.c cVar2 = this.f19691b;
            if (cVar2 != null && (navigationBar = cVar2.f19282a) != null) {
                navigationBar.getBarBgView().setAlpha(0.0f);
                this.f19691b.f19282a.getTopCoverBgView().setAlpha(1.0f);
                NavigationBar navigationBar2 = this.f19691b.f19282a;
                if (!DeviceInfoUtil.isHWnova() && !TbSingleton.getInstance().isNotchScreen(this.f19693d.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.f19693d.getBaseFragmentActivity())) {
                    i2 = 8;
                }
                navigationBar2.setStatusBarVisibility(i2);
            }
            PbVideoWifiTipLayout pbVideoWifiTipLayout = (PbVideoWifiTipLayout) this.f19690a.findViewById(b.a.r0.k2.i.layout_wifi_tip);
            this.B = pbVideoWifiTipLayout;
            pbVideoWifiTipLayout.setOnPlayClickListener(new s(this));
            b.a.y.c cVar3 = this.A;
            if (cVar3 != null) {
                cVar3.d();
            }
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (P() == null) {
                return false;
            }
            return P().getBottom() > b.a.e.e.p.l.i(P().getContext()) - b.a.e.e.p.l.g(P().getContext(), b.a.r0.k2.g.ds50);
        }
        return invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.j == null) {
            return;
        }
        if (W()) {
            this.f19693d.getPbView().c1();
        } else if (this.j.f().getVisibility() == 0) {
            this.f19693d.getPbView().c1();
            this.k = true;
        } else if (this.k) {
            this.f19693d.getPbView().c3(false);
            this.k = false;
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.w >= 1.0d : invokeV.booleanValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? P().getY() >= 0.0f : invokeV.booleanValue;
    }

    public final int b0(VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, videoInfo)) == null) {
            if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
                this.f19692c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                return b.a.e.e.p.l.k(this.f19693d.getActivity());
            }
            int k2 = b.a.e.e.p.l.k(this.f19693d.getActivity());
            Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.f19693d.getPageContext().getPageActivity());
            int i2 = visibilityRegion.height() <= 0 ? b.a.e.e.p.l.i(this.f19693d.getActivity()) : visibilityRegion.height();
            int i3 = (int) (k2 * 0.5625d);
            int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
            int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
            if (intValue > 0) {
                double d2 = (intValue2 * 1.0d) / intValue;
                this.w = d2;
                if (d2 > 0.5625d) {
                    i3 = Math.min((intValue2 * k2) / intValue, i2);
                }
            }
            this.v = i3;
            this.f19692c.setLayoutParams(new RelativeLayout.LayoutParams(k2, i3));
            return i3;
        }
        return invokeL.intValue;
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            b.a.r0.k2.u.f.g1.c cVar = this.f19691b;
            if (cVar != null) {
                cVar.v(i2);
            }
            PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
            if (pbFullScreenFloatingHuajiAninationView != null) {
                pbFullScreenFloatingHuajiAninationView.onChangeSkinType(i2);
            }
            b.a.r0.k2.x.e eVar = this.j;
            if (eVar != null) {
                eVar.j(i2);
            }
        }
    }

    public void d0(Configuration configuration) {
        CustomFrameLayout customFrameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, configuration) == null) {
            this.p = false;
            if (this.f19697h == null || (customFrameLayout = this.f19692c) == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customFrameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                b.a.y.c cVar = this.A;
                if (cVar != null && cVar.c()) {
                    this.A.b();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                b.a.e.e.g.c cVar2 = this.K;
                if (cVar2 != null) {
                    cVar2.d();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.p = true;
                this.f19692c.setLayoutParams(layoutParams);
                this.f19693d.getPbView().c1();
                this.k = true;
            } else {
                b0(this.f19696g);
                t0();
                this.p = false;
                this.f19691b.B(true);
            }
            this.f19697h.V0(this.f19693d.getPageContext(), configuration);
        }
    }

    public boolean e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            b.a.r0.q2.c cVar = this.f19697h;
            if (cVar == null) {
                return false;
            }
            return cVar.f1(i2);
        }
        return invokeI.booleanValue;
    }

    public void f0() {
        b.a.r0.q2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.f19697h) == null) {
            return;
        }
        if (cVar.T0()) {
            this.o = true;
            this.f19697h.k2();
        } else if (this.f19697h.C0() == 3) {
            this.o = false;
        } else if (this.f19697h.C0() != 0 && this.f19697h.C0() != 1) {
            this.o = false;
            this.f19697h.k2();
        } else {
            this.o = true;
            this.f19697h.k2();
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.stopAnimation();
        }
    }

    public void g0() {
        b.a.r0.q2.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (cVar = this.f19697h) != null && this.o) {
            cVar.i1();
        }
    }

    public void h0(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, absListView, i2) == null) {
            if (absListView != null && absListView.getChildAt(0) != null) {
                View childAt = absListView.getChildAt(0);
                if (childAt == R()) {
                    int bottom = childAt.getBottom() - P().getBottom();
                    M((childAt.getHeight() == 0 || P().getHeight() == 0) ? 0 : 0);
                } else {
                    M((-this.v) + 2);
                }
            }
            if (!W() && this.G) {
                int i3 = this.q;
                if (i3 == 1) {
                    this.N = true;
                    j0(P().getHeight());
                } else if (i3 != 2) {
                    if (i3 == 0) {
                        if (this.N || !"nani_midpage".equals(this.f19693d.getVideoSource())) {
                            j0(P().getHeight());
                        }
                    }
                } else {
                    this.N = true;
                    int y = (int) P().getY();
                    if (this.r == y) {
                        j0(P().getHeight());
                    } else {
                        this.r = y;
                        j0(P().getHeight());
                    }
                    if (i2 == 0 && this.u) {
                        this.u = false;
                        this.H.postDelayed(new l(this), 100L);
                    }
                }
            }
        }
    }

    public void i0(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048598, this, absListView, i2) == null) || W()) {
            return;
        }
        this.q = i2;
        if (i2 == 0) {
            new Handler().postDelayed(new j(this), 100L);
        }
        Y();
    }

    public final void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            n0(i2);
            Y();
        }
    }

    public void k0(PostData postData, d2 d2Var, b.a.r0.k2.r.q qVar) {
        b.a.r0.k2.x.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048600, this, postData, d2Var, qVar) == null) || (eVar = this.j) == null) {
            return;
        }
        eVar.m(postData, d2Var, qVar);
    }

    public final void l0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || this.f19696g == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            b.a.r0.q2.h.e(this.f19696g.video_md5, "", str, this.f19698i, this.f19697h.I0().getPcdnState());
        }
    }

    public void m0() {
        b.a.r0.q2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.f19697h) == null) {
            return;
        }
        cVar.g1();
    }

    public final void n0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.j == null) {
            return;
        }
        d2 d2Var = this.l;
        if (d2Var != null && d2Var.D2()) {
            this.j.f().setVisibility(8);
            return;
        }
        if (i2 == 0) {
            i2 = this.v;
        }
        float f2 = this.v - i2;
        float f3 = this.s;
        float f4 = f2 > f3 ? 0.0f : 1.0f - (f2 / f3);
        if (this.O) {
            f4 = 0.0f;
        }
        if (f4 == 0.0f) {
            this.j.f().setVisibility(8);
        } else {
            this.j.f().setVisibility(0);
        }
        this.j.n(f4);
    }

    public void o0(c.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, yVar) == null) {
            this.F = yVar;
        }
    }

    public void p0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, d2Var) == null) {
            this.m = d2Var;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.n = str;
            b.a.r0.q2.c cVar = this.f19697h;
            if (cVar != null) {
                cVar.x1(str);
            }
        }
    }

    public void r0(View.OnClickListener onClickListener) {
        b.a.r0.k2.x.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) || (eVar = this.j) == null) {
            return;
        }
        eVar.o(onClickListener);
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.u = true;
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.f19691b == null) {
            return;
        }
        this.f19691b.D(this.f19693d.isSimpleForum());
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || b.a.q0.s.e0.b.j().g("show_video_pb_double_tap_tips", false)) {
            return;
        }
        b.a.q0.s.e0.b.j().t("show_video_pb_double_tap_tips", true);
        b.a.e.e.g.d dVar = new b.a.e.e.g.d();
        dVar.d(true);
        dVar.h(false);
        dVar.k(16908290);
        dVar.c(153);
        dVar.i(false);
        dVar.a(new f(this));
        dVar.g(new C0979g(this));
        b.a.e.e.g.c b2 = dVar.b();
        this.K = b2;
        b2.p(this.f19693d.getActivity());
    }

    public void v0() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.f19697h == null) {
            return;
        }
        if (b.a.e.e.p.j.x() && !this.M && !b.a.r0.z3.h.d().e()) {
            this.B.setVisibility(0);
            this.B.setData(this.f19696g);
            TiebaStatic.log("c12622");
            return;
        }
        if (StringUtils.isNull(this.f19695f) && (d2Var = this.l) != null && d2Var.q1() != null) {
            TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "pb").param("tid", this.l.s1()));
            this.f19695f = this.l.q1().video_url;
        }
        b.a.r0.q2.c cVar = this.f19697h;
        String str = this.f19695f;
        d2 d2Var2 = this.l;
        cVar.d2(str, d2Var2 == null ? "" : d2Var2.s1());
        l0("2");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    public void w0(String str) {
        b.a.r0.q2.p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || (pVar = this.f19698i) == null) {
            return;
        }
        pVar.f22885d = str;
    }
}
