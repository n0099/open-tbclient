package c.a.r0.q2.x;

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
import c.a.d.f.g.d;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.n1;
import c.a.r0.x2.c;
import c.a.r0.x2.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static VideoControllerView.c U;
    public static c.d0 V;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.y.c A;
    public PbVideoWifiTipLayout B;
    public int C;
    public long D;
    public c.k0 E;
    public c.y F;
    public boolean G;
    public Handler H;
    public PbFullScreenFloatingHuajiAninationView I;
    public PbFullScreenFloatingHuajiAninationView.c J;
    public c.a.d.f.g.c K;
    public Bitmap L;
    public boolean M;
    public boolean N;
    public boolean O;
    public c.h0 P;
    public CustomMessageListener Q;
    public int R;
    public Animation.AnimationListener S;
    public CustomMessageListener T;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.q2.u.f.h1.c f22370b;

    /* renamed from: c  reason: collision with root package name */
    public CustomFrameLayout f22371c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f22372d;

    /* renamed from: e  reason: collision with root package name */
    public c.y f22373e;

    /* renamed from: f  reason: collision with root package name */
    public String f22374f;

    /* renamed from: g  reason: collision with root package name */
    public VideoInfo f22375g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.x2.c f22376h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.x2.p f22377i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.q2.x.e f22378j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f22379k;
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

    /* loaded from: classes6.dex */
    public class a implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoInfo f22380e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f22381f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d2 f22382g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f22383h;

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
            this.f22383h = gVar;
            this.f22380e = videoInfo;
            this.f22381f = str;
            this.f22382g = d2Var;
        }

        @Override // c.a.r0.x2.f.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f22383h.D <= 0) {
                    this.f22383h.D = i3;
                }
                McnAdInfo mcnAdInfo = this.f22380e.mcn_ad_card;
                if (mcnAdInfo == null) {
                    return;
                }
                boolean a = c.a.y.b.b().a(mcnAdInfo.jump_url);
                if (!this.f22383h.z || a || this.f22383h.p) {
                    return;
                }
                boolean z = true;
                boolean z2 = this.f22383h.D >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                long j2 = i3;
                if ((j2 < mcnAdInfo.ad_start_time.longValue() * 1000 || j2 >= mcnAdInfo.ad_end_time.longValue() * 1000) ? false : false) {
                    if (this.f22383h.A.c()) {
                        return;
                    }
                    c.a.y.a aVar = new c.a.y.a();
                    aVar.f27205b = mcnAdInfo.card_title;
                    aVar.f27206c = mcnAdInfo.button_title;
                    aVar.f27207d = mcnAdInfo.jump_url;
                    aVar.a = mcnAdInfo.pic_url;
                    aVar.f27209f = this.f22381f;
                    aVar.f27208e = this.f22382g.v1();
                    aVar.f27210g = 4;
                    if (z2) {
                        this.f22383h.A.f(aVar, (ViewGroup) this.f22383h.f22376h.E0());
                    } else {
                        this.f22383h.A.e(aVar, (ViewGroup) this.f22383h.f22376h.E0());
                    }
                } else if (this.f22383h.A.c()) {
                    this.f22383h.A.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f22384e;

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
                this.f22384e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f22384e.a.C > 0) {
                        g gVar = this.f22384e.a;
                        gVar.M(gVar.C);
                        g gVar2 = this.f22384e.a;
                        gVar2.j0(gVar2.C);
                        this.f22384e.a.C = 0;
                    }
                    this.f22384e.a.G = true;
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
            this.a = gVar;
        }

        @Override // c.a.r0.x2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f22372d.getBaseFragmentActivity().setSwipeBackEnabled(false);
                this.a.G = false;
                g gVar = this.a;
                gVar.C = gVar.P().getHeight();
            }
        }

        @Override // c.a.r0.x2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f22372d.getBaseFragmentActivity().setSwipeBackEnabled(true);
                this.a.H.postDelayed(new a(this), 200L);
                this.a.D = -1L;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.r0.x2.c.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f22372d == null || this.a.m == null || StringUtils.isNull(this.a.m.g0())) {
                return;
            }
            this.a.f22372d.loadNextVideoPb(this.a.m.g0());
        }
    }

    /* loaded from: classes6.dex */
    public class d implements c.e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.r0.x2.c.e0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.l == null) {
                return;
            }
            this.a.l0(z ? "1" : "2");
        }
    }

    /* loaded from: classes6.dex */
    public class e implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f22385e;

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
            this.f22385e = gVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f22385e.f22374f);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements c.a.d.f.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.d.f.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 5;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                ImageView imageView = new ImageView(this.a.f22372d.getActivity());
                if (this.a.L == null) {
                    try {
                        this.a.L = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), c.a.r0.q2.h.pb_video_guide_like);
                        imageView.setImageBitmap(this.a.L);
                    } catch (Throwable unused) {
                    }
                }
                return imageView;
            }
            return (View) invokeL.objValue;
        }

        @Override // c.a.d.f.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* renamed from: c.a.r0.q2.x.g$g  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1295g implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public C1295g(g gVar) {
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
            this.a = gVar;
        }

        @Override // c.a.d.f.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K = null;
                if (this.a.L != null && !this.a.L.isRecycled()) {
                    this.a.L.recycle();
                }
                this.a.L = null;
            }
        }

        @Override // c.a.d.f.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

        @Override // c.a.r0.x2.c.d0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f22386e;

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
            this.f22386e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g gVar = this.f22386e;
                gVar.j0(gVar.P().getHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements c.k0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.r0.x2.c.k0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f22372d == null || this.a.f22372d.getPbModel() == null || this.a.f22372d.getPbModel().R0() == null) {
                return;
            }
            PostData j2 = this.a.f22372d.getPbModel().R0().j();
            if (j2 == null && ListUtils.getCount(this.a.f22372d.getPbModel().R0().F()) > 1) {
                j2 = (PostData) ListUtils.getItem(this.a.f22372d.getPbModel().R0().F(), 0);
            }
            c.a.r0.q2.w.a.b(this.a.f22372d.getPbModel().R0(), j2, 1, 1, 4);
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f22387e;

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
            this.f22387e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22387e.m0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f22375g == null) {
                return;
            }
            g gVar = this.a;
            gVar.b0(gVar.f22375g);
            this.a.f22376h.c1();
            this.a.f22376h.q0();
            if (this.a.x == null || this.a.x.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.a.x.getLayoutParams();
            layoutParams.height = this.a.v;
            this.a.x.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes6.dex */
    public class n implements PbFullScreenFloatingHuajiAninationView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.N(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements c.h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.r0.x2.c.h0
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.x2.c.h0
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.w >= 1.0d) {
                    if (!this.a.f22372d.checkUpIsLogin()) {
                        return true;
                    }
                    this.a.f22372d.hideKeyboardAndEditor();
                    if (this.a.f22372d.getPbModel() != null && this.a.f22372d.getPbModel().R0() != null && this.a.f22372d.getPbModel().R0().S() != null) {
                        c.a.r0.q2.r.r S = this.a.f22372d.getPbModel().R0().S();
                        if (this.a.I == null) {
                            this.a.I = new PbFullScreenFloatingHuajiAninationView(this.a.f22372d.getActivity());
                            this.a.I.setFloatingHuajiAninationListener(this.a.J);
                        }
                        this.a.I.startAnimation(!S.g());
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && c.a.d.f.p.j.z()) {
                if (this.a.f22376h != null) {
                    this.a.f22376h.w1();
                }
                if (!c.a.d.f.p.j.x() || this.a.f22376h == null || !this.a.f22376h.T0() || this.a.f22375g == null || this.a.f22375g.video_length.intValue() <= 0 || this.a.f22375g.video_duration.intValue() <= 0) {
                    return;
                }
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                double intValue = ((this.a.f22375g.video_length.intValue() * (1.0f - ((this.a.f22376h.B0() * 1.0f) / (this.a.f22375g.video_duration.intValue() * 1000)))) * 1.0f) / 1048576.0f;
                if (intValue >= 0.1d) {
                    c.a.d.f.p.l.M(this.a.f22372d.getPageContext().getPageActivity(), String.format(this.a.f22372d.getPageContext().getString(c.a.r0.q2.l.pb_video_net_change_tip), decimalFormat.format(intValue)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements c.i0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.r0.x2.c.i0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.a.D = -1L;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements c.f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.r0.x2.c.f0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.r0.x2.c.f0
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // c.a.r0.x2.c.f0
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
                            if (this.a.f22372d.getListView() != null && this.a.f22372d.getListView().getChildCount() > 0 && this.a.f22372d.getListView().getChildAt(0) == this.a.R()) {
                                this.a.f22372d.getListView().setSelectionFromTop(0, this.a.R + ((int) (motionEvent.getY() - this.a.y)));
                            }
                        }
                    }
                    this.a.y = 0.0f;
                    this.a.R = 0;
                } else {
                    this.a.y = motionEvent.getY();
                    if (this.a.f22372d.getListView() != null && this.a.f22372d.getListView().getChildCount() > 0 && this.a.f22372d.getListView().getChildAt(0) == this.a.R()) {
                        g gVar = this.a;
                        gVar.R = gVar.R().getTop();
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f22388e;

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
            this.f22388e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22388e.M = true;
                this.f22388e.B.setVisibility(8);
                this.f22388e.v0();
                TiebaStatic.log("c12618");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements c.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f22389b;

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
            this.f22389b = gVar;
            this.a = animation;
        }

        @Override // c.a.r0.x2.c.y
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f22389b.a0() && this.f22389b.f22370b != null) {
                this.a.setAnimationListener(null);
                this.f22389b.f22370b.p().clearAnimation();
                this.f22389b.t0();
                if (z) {
                    this.a.setAnimationListener(this.f22389b.S);
                    this.f22389b.f22370b.p().startAnimation(this.a);
                }
            }
        }

        @Override // c.a.r0.x2.c.y
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f22389b.a0()) {
                this.f22389b.S();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.S();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1776528878, "Lc/a/r0/q2/x/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1776528878, "Lc/a/r0/q2/x/g;");
                return;
            }
        }
        U = new h();
        V = new i();
    }

    public g(PbFragment pbFragment, c.a.r0.q2.u.f.h1.c cVar, VideoInfo videoInfo, long j2) {
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
        this.f22374f = null;
        this.f22375g = null;
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
        this.f22372d = pbFragment;
        this.f22370b = cVar;
        this.s = c.a.d.f.p.l.f(pbFragment.getActivity(), c.a.r0.q2.g.ds240);
        V(videoInfo);
        T();
        MessageManager.getInstance().registerListener(this.Q);
        this.T.setTag(pbFragment.getUniqueId());
        this.T.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.T);
        this.A = new c.a.y.c(pbFragment.getActivity());
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || P().getHeight() + i2 <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22371c.getLayoutParams();
        if ((layoutParams.width == -1 && layoutParams.height == -1) || i2 == 0) {
            return;
        }
        if (i2 > 0) {
            this.O = false;
            if (this.v != P().getHeight()) {
                this.f22371c.setLayoutParams(new RelativeLayout.LayoutParams(c.a.d.f.p.l.k(this.f22372d.getActivity()), Math.min(this.v, P().getHeight() + i2)));
                this.f22376h.q0();
            }
        } else if (c.a.d.f.p.l.k(this.f22372d.getActivity()) * 0.5625d != P().getHeight()) {
            this.f22371c.setLayoutParams(new RelativeLayout.LayoutParams(c.a.d.f.p.l.k(this.f22372d.getActivity()), (int) Math.max(c.a.d.f.p.l.k(this.f22372d.getActivity()) * 0.5625d, P().getHeight() + i2)));
            this.f22376h.q0();
        }
    }

    public final void N(boolean z) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (pbFragment = this.f22372d) == null) {
            return;
        }
        pbFragment.doPraiseClick();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.x2.c cVar = this.f22376h;
            if (cVar != null) {
                cVar.v0();
            }
            CustomFrameLayout customFrameLayout = this.f22371c;
            if (customFrameLayout != null) {
                customFrameLayout.clearAnimation();
            }
            c.a.r0.q2.x.e eVar = this.f22378j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
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
        c.a.r0.q2.u.f.h1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f22370b) == null) {
            return;
        }
        cVar.r();
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f22372d.getActivity(), c.a.r0.q2.e.anim_alpha_1_to_0_duration_2000_accelerate);
            if (this.f22373e == null) {
                this.f22373e = new t(this, loadAnimation);
            }
            o0(this.f22373e);
            UtilHelper.getLightStatusBarHeight();
            c.a.d.f.p.l.f(this.f22372d.getActivity(), c.a.r0.q2.g.ds98);
            this.H = new Handler();
        }
    }

    public void U(VideoInfo videoInfo, d2 d2Var, String str) {
        c.a.r0.x2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoInfo, d2Var, str) == null) || videoInfo == null || (cVar = this.f22376h) == null || d2Var == null) {
            return;
        }
        this.f22375g = videoInfo;
        this.l = d2Var;
        this.f22374f = videoInfo.video_url;
        cVar.k2();
        c.a.r0.x2.p pVar = new c.a.r0.x2.p();
        this.f22377i = pVar;
        pVar.a = "pb";
        pVar.f25426c = d2Var.v1();
        c.a.r0.x2.p pVar2 = this.f22377i;
        pVar2.f25427d = str;
        pVar2.f25428e = TbadkCoreApplication.getCurrentAccount();
        if (d2Var.T1()) {
            if (!StringUtils.isNull(this.f22372d.lastTid)) {
                this.f22377i.f25434k = this.f22372d.lastTid;
            }
            c.a.r0.x2.p pVar3 = this.f22377i;
            pVar3.f25432i = this.f22372d.bjhFrom + "";
        } else {
            this.f22377i.f25432i = this.f22372d.getVideoSource();
        }
        n1 recomStatisticData = this.f22372d.getRecomStatisticData();
        if (recomStatisticData != null) {
            recomStatisticData.d(this.f22377i);
        }
        c.a.r0.x2.p pVar4 = this.f22377i;
        pVar4.m = videoInfo.video_md5;
        c.a.r0.x2.p b2 = pVar4.b();
        b2.a = "6";
        this.D = -1L;
        if (this.f22376h.I0() != null && this.f22376h.I0().getMediaProgressObserver() != null) {
            this.f22376h.I0().getMediaProgressObserver().j(new a(this, videoInfo, str, d2Var));
        }
        this.f22376h.I0().setVideoStatData(b2);
        if (this.f22376h.H0()) {
            this.f22376h.q0();
        }
        this.f22376h.z1(this.F);
        this.n = null;
        this.m = null;
        this.f22376h.x1(null);
        this.f22376h.K0().setOnDragingListener(U);
        this.f22376h.y1(new b(this));
        this.f22376h.C1(new c(this));
        this.f22376h.E1(new d(this));
        this.f22376h.J1(new e(this));
        this.f22376h.S1(videoInfo.thumbnail_url);
        this.f22376h.Y1(this.f22374f, d2Var.v1());
        this.f22376h.m1(str);
        this.f22376h.X1(d2Var.getTitle());
        this.f22376h.D1(V);
        this.f22376h.a1();
        this.f22376h.a2();
    }

    public final void V(VideoInfo videoInfo) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoInfo) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f22372d.getPageContext().getPageActivity()).inflate(c.a.r0.q2.j.video_pb_container_layout, (ViewGroup) null);
            this.a = relativeLayout;
            this.f22371c = (CustomFrameLayout) relativeLayout.findViewById(c.a.r0.q2.i.pb_video_container);
            int b0 = b0(videoInfo);
            int i2 = 0;
            this.z = ((double) this.v) <= (((double) c.a.d.f.p.l.k(this.f22372d.getActivity())) * 0.5625d) + 5.0d;
            int intValue = videoInfo.video_width.intValue();
            c.a.r0.x2.c cVar = new c.a.r0.x2.c(this.f22372d.getPageContext(), this.f22371c, true);
            this.f22376h = cVar;
            cVar.O1("2002");
            this.f22376h.Z1(this.P);
            this.f22376h.t1(false);
            this.f22376h.U1(this.E);
            this.f22376h.V1(SkinManager.getResourceId(c.a.r0.q2.h.pic_use_header_40_n));
            this.f22376h.N1(new q(this));
            if (TbSingleton.getInstance().isNotchScreen(this.f22372d.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f22372d.getBaseFragmentActivity())) {
                this.f22376h.o1(false);
            }
            this.f22376h.F1(new r(this));
            if (intValue > 0) {
                if (this.w >= 1.0d) {
                    this.f22376h.M1(false, true);
                } else {
                    this.f22376h.M1(true, false);
                }
                boolean z = ((float) b0) + this.s > ((float) c.a.d.f.p.l.i(this.f22372d.getActivity()));
                this.t = z;
                if (z) {
                    if (this.f22378j == null) {
                        this.f22378j = new c.a.r0.q2.x.e(this.f22372d.getPageContext(), this.f22371c);
                    }
                    this.f22372d.getPbView().c1();
                    this.f22379k = true;
                }
            }
            u0();
            this.x = new View(this.f22372d.getContext());
            this.x.setLayoutParams(new AbsListView.LayoutParams(-1, this.v));
            c.a.r0.q2.u.f.h1.c cVar2 = this.f22370b;
            if (cVar2 != null && (navigationBar = cVar2.a) != null) {
                navigationBar.getBarBgView().setAlpha(0.0f);
                this.f22370b.a.getTopCoverBgView().setAlpha(1.0f);
                NavigationBar navigationBar2 = this.f22370b.a;
                if (!DeviceInfoUtil.isHWnova() && !TbSingleton.getInstance().isNotchScreen(this.f22372d.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.f22372d.getBaseFragmentActivity())) {
                    i2 = 8;
                }
                navigationBar2.setStatusBarVisibility(i2);
            }
            PbVideoWifiTipLayout pbVideoWifiTipLayout = (PbVideoWifiTipLayout) this.a.findViewById(c.a.r0.q2.i.layout_wifi_tip);
            this.B = pbVideoWifiTipLayout;
            pbVideoWifiTipLayout.setOnPlayClickListener(new s(this));
            c.a.y.c cVar3 = this.A;
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
            return P().getBottom() > c.a.d.f.p.l.i(P().getContext()) - c.a.d.f.p.l.f(P().getContext(), c.a.r0.q2.g.ds50);
        }
        return invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f22378j == null) {
            return;
        }
        if (W()) {
            this.f22372d.getPbView().c1();
        } else if (this.f22378j.f().getVisibility() == 0) {
            this.f22372d.getPbView().c1();
            this.f22379k = true;
        } else if (this.f22379k) {
            this.f22372d.getPbView().c3(false);
            this.f22379k = false;
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
                this.f22371c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                return c.a.d.f.p.l.k(this.f22372d.getActivity());
            }
            int k2 = c.a.d.f.p.l.k(this.f22372d.getActivity());
            Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.f22372d.getPageContext().getPageActivity());
            int i2 = visibilityRegion.height() <= 0 ? c.a.d.f.p.l.i(this.f22372d.getActivity()) : visibilityRegion.height();
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
            this.f22371c.setLayoutParams(new RelativeLayout.LayoutParams(k2, i3));
            return i3;
        }
        return invokeL.intValue;
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            c.a.r0.q2.u.f.h1.c cVar = this.f22370b;
            if (cVar != null) {
                cVar.v(i2);
            }
            PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
            if (pbFullScreenFloatingHuajiAninationView != null) {
                pbFullScreenFloatingHuajiAninationView.onChangeSkinType(i2);
            }
            c.a.r0.q2.x.e eVar = this.f22378j;
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
            if (this.f22376h == null || (customFrameLayout = this.f22371c) == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customFrameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                c.a.y.c cVar = this.A;
                if (cVar != null && cVar.c()) {
                    this.A.b();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                c.a.d.f.g.c cVar2 = this.K;
                if (cVar2 != null) {
                    cVar2.e();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.p = true;
                this.f22371c.setLayoutParams(layoutParams);
                this.f22372d.getPbView().c1();
                this.f22379k = true;
            } else {
                b0(this.f22375g);
                t0();
                this.p = false;
                this.f22370b.B(true);
            }
            this.f22376h.V0(this.f22372d.getPageContext(), configuration);
        }
    }

    public boolean e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            c.a.r0.x2.c cVar = this.f22376h;
            if (cVar == null) {
                return false;
            }
            return cVar.f1(i2);
        }
        return invokeI.booleanValue;
    }

    public void f0() {
        c.a.r0.x2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.f22376h) == null) {
            return;
        }
        if (cVar.T0()) {
            this.o = true;
            this.f22376h.k2();
        } else if (this.f22376h.C0() == 3) {
            this.o = false;
        } else if (this.f22376h.C0() != 0 && this.f22376h.C0() != 1) {
            this.o = false;
            this.f22376h.k2();
        } else {
            this.o = true;
            this.f22376h.k2();
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.stopAnimation();
        }
    }

    public void g0() {
        c.a.r0.x2.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (cVar = this.f22376h) != null && this.o) {
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
                        if (this.N || !"nani_midpage".equals(this.f22372d.getVideoSource())) {
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

    public void k0(PostData postData, d2 d2Var, c.a.r0.q2.r.r rVar) {
        c.a.r0.q2.x.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048600, this, postData, d2Var, rVar) == null) || (eVar = this.f22378j) == null) {
            return;
        }
        eVar.m(postData, d2Var, rVar);
    }

    public final void l0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || this.f22375g == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            c.a.r0.x2.h.e(this.f22375g.video_md5, "", str, this.f22377i, this.f22376h.I0().getPcdnState());
        }
    }

    public void m0() {
        c.a.r0.x2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.f22376h) == null) {
            return;
        }
        cVar.g1();
    }

    public final void n0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.f22378j == null) {
            return;
        }
        d2 d2Var = this.l;
        if (d2Var != null && d2Var.G2()) {
            this.f22378j.f().setVisibility(8);
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
            this.f22378j.f().setVisibility(8);
        } else {
            this.f22378j.f().setVisibility(0);
        }
        this.f22378j.n(f4);
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
            c.a.r0.x2.c cVar = this.f22376h;
            if (cVar != null) {
                cVar.x1(str);
            }
        }
    }

    public void r0(View.OnClickListener onClickListener) {
        c.a.r0.q2.x.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) || (eVar = this.f22378j) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.f22370b == null) {
            return;
        }
        this.f22370b.D(this.f22372d.isSimpleForum());
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || c.a.q0.s.e0.b.j().g("show_video_pb_double_tap_tips", false)) {
            return;
        }
        c.a.q0.s.e0.b.j().t("show_video_pb_double_tap_tips", true);
        c.a.d.f.g.d dVar = new c.a.d.f.g.d();
        dVar.d(true);
        dVar.h(false);
        dVar.k(16908290);
        dVar.c(153);
        dVar.i(false);
        dVar.a(new f(this));
        dVar.g(new C1295g(this));
        c.a.d.f.g.c b2 = dVar.b();
        this.K = b2;
        b2.t(this.f22372d.getActivity());
    }

    public void v0() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.f22376h == null) {
            return;
        }
        if (c.a.d.f.p.j.x() && !this.M && !c.a.r0.h4.h.d().e()) {
            this.B.setVisibility(0);
            this.B.setData(this.f22375g);
            TiebaStatic.log("c12622");
            return;
        }
        if (StringUtils.isNull(this.f22374f) && (d2Var = this.l) != null && d2Var.t1() != null) {
            TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "pb").param("tid", this.l.v1()));
            this.f22374f = this.l.t1().video_url;
        }
        c.a.r0.x2.c cVar = this.f22376h;
        String str = this.f22374f;
        d2 d2Var2 = this.l;
        cVar.d2(str, d2Var2 == null ? "" : d2Var2.v1());
        l0("2");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    public void w0(String str) {
        c.a.r0.x2.p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || (pVar = this.f22377i) == null) {
            return;
        }
        pVar.f25427d = str;
    }
}
