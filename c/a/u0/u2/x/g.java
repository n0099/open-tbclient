package c.a.u0.u2.x;

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
import c.a.t0.s.r.e2;
import c.a.t0.s.r.n1;
import c.a.u0.b3.c;
import c.a.u0.b3.h;
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
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static VideoControllerView.c U;
    public static c.z V;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.a0.c A;
    public PbVideoWifiTipLayout B;
    public int C;
    public long D;
    public c.g0 E;
    public c.u F;
    public boolean G;
    public Handler H;
    public PbFullScreenFloatingHuajiAninationView I;
    public PbFullScreenFloatingHuajiAninationView.c J;
    public c.a.d.f.g.c K;
    public Bitmap L;
    public boolean M;
    public boolean N;
    public boolean O;
    public c.d0 P;
    public CustomMessageListener Q;
    public int R;
    public Animation.AnimationListener S;
    public CustomMessageListener T;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.u0.u2.u.f.i1.c f24004b;

    /* renamed from: c  reason: collision with root package name */
    public CustomFrameLayout f24005c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f24006d;

    /* renamed from: e  reason: collision with root package name */
    public c.u f24007e;

    /* renamed from: f  reason: collision with root package name */
    public String f24008f;

    /* renamed from: g  reason: collision with root package name */
    public VideoInfo f24009g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.u0.b3.c f24010h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.u0.b3.t f24011i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.u0.u2.x.e f24012j;
    public boolean k;
    public e2 l;
    public e2 m;
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

    /* loaded from: classes9.dex */
    public class a implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoInfo f24013e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f24014f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e2 f24015g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f24016h;

        public a(g gVar, VideoInfo videoInfo, String str, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, videoInfo, str, e2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24016h = gVar;
            this.f24013e = videoInfo;
            this.f24014f = str;
            this.f24015g = e2Var;
        }

        @Override // c.a.u0.b3.h.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f24016h.D <= 0) {
                    this.f24016h.D = i3;
                }
                McnAdInfo mcnAdInfo = this.f24013e.mcn_ad_card;
                if (mcnAdInfo == null) {
                    return;
                }
                boolean a = c.a.a0.b.b().a(mcnAdInfo.jump_url);
                if (!this.f24016h.z || a || this.f24016h.p) {
                    return;
                }
                boolean z = true;
                boolean z2 = this.f24016h.D >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                long j2 = i3;
                if ((j2 < mcnAdInfo.ad_start_time.longValue() * 1000 || j2 >= mcnAdInfo.ad_end_time.longValue() * 1000) ? false : false) {
                    if (this.f24016h.A.c()) {
                        return;
                    }
                    c.a.a0.a aVar = new c.a.a0.a();
                    aVar.f1084b = mcnAdInfo.card_title;
                    aVar.f1085c = mcnAdInfo.button_title;
                    aVar.f1086d = mcnAdInfo.jump_url;
                    aVar.a = mcnAdInfo.pic_url;
                    aVar.f1088f = this.f24014f;
                    aVar.f1087e = this.f24015g.w1();
                    aVar.f1089g = 4;
                    if (z2) {
                        this.f24016h.A.f(aVar, (ViewGroup) this.f24016h.f24010h.E0());
                    } else {
                        this.f24016h.A.e(aVar, (ViewGroup) this.f24016h.f24010h.E0());
                    }
                } else if (this.f24016h.A.c()) {
                    this.f24016h.A.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f24017e;

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
                this.f24017e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f24017e.a.C > 0) {
                        g gVar = this.f24017e.a;
                        gVar.M(gVar.C);
                        g gVar2 = this.f24017e.a;
                        gVar2.j0(gVar2.C);
                        this.f24017e.a.C = 0;
                    }
                    this.f24017e.a.G = true;
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

        @Override // c.a.u0.b3.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f24006d.getBaseFragmentActivity().setSwipeBackEnabled(false);
                this.a.G = false;
                g gVar = this.a;
                gVar.C = gVar.P().getHeight();
            }
        }

        @Override // c.a.u0.b3.c.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f24006d.getBaseFragmentActivity().setSwipeBackEnabled(true);
                this.a.H.postDelayed(new a(this), 200L);
                this.a.D = -1L;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements c.y {
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

        @Override // c.a.u0.b3.c.y
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f24006d == null || this.a.m == null || StringUtils.isNull(this.a.m.h0())) {
                return;
            }
            this.a.f24006d.loadNextVideoPb(this.a.m.h0());
        }
    }

    /* loaded from: classes9.dex */
    public class d implements c.a0 {
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

        @Override // c.a.u0.b3.c.a0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.l == null) {
                return;
            }
            this.a.l0(z ? "1" : "2");
        }
    }

    /* loaded from: classes9.dex */
    public class e implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24018e;

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
            this.f24018e = gVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f24018e.f24008f);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
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
                ImageView imageView = new ImageView(this.a.f24006d.getActivity());
                if (this.a.L == null) {
                    try {
                        this.a.L = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), c.a.u0.u2.h.pb_video_guide_like);
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

    /* renamed from: c.a.u0.u2.x.g$g  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1454g implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public C1454g(g gVar) {
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

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static class i implements c.z {
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

        @Override // c.a.u0.b3.c.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24019e;

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
            this.f24019e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g gVar = this.f24019e;
                gVar.j0(gVar.P().getHeight());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements c.g0 {
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

        @Override // c.a.u0.b3.c.g0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f24006d == null || this.a.f24006d.getPbModel() == null || this.a.f24006d.getPbModel().R0() == null) {
                return;
            }
            PostData j2 = this.a.f24006d.getPbModel().R0().j();
            if (j2 == null && ListUtils.getCount(this.a.f24006d.getPbModel().R0().F()) > 1) {
                j2 = (PostData) ListUtils.getItem(this.a.f24006d.getPbModel().R0().F(), 0);
            }
            c.a.u0.u2.w.a.b(this.a.f24006d.getPbModel().R0(), j2, 1, 1, 4);
        }
    }

    /* loaded from: classes9.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24020e;

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
            this.f24020e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24020e.m0();
            }
        }
    }

    /* loaded from: classes9.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f24009g == null) {
                return;
            }
            g gVar = this.a;
            gVar.b0(gVar.f24009g);
            this.a.f24010h.b1();
            this.a.f24010h.q0();
            if (this.a.x == null || this.a.x.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.a.x.getLayoutParams();
            layoutParams.height = this.a.v;
            this.a.x.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class o implements c.d0 {
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

        @Override // c.a.u0.b3.c.d0
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.u0.b3.c.d0
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.w >= 1.0d) {
                    if (!this.a.f24006d.checkUpIsLogin()) {
                        return true;
                    }
                    this.a.f24006d.hideKeyboardAndEditor();
                    if (this.a.f24006d.getPbModel() != null && this.a.f24006d.getPbModel().R0() != null && this.a.f24006d.getPbModel().R0().S() != null) {
                        c.a.u0.u2.r.r S = this.a.f24006d.getPbModel().R0().S();
                        if (this.a.I == null) {
                            this.a.I = new PbFullScreenFloatingHuajiAninationView(this.a.f24006d.getActivity());
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

    /* loaded from: classes9.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && c.a.d.f.p.l.z()) {
                if (this.a.f24010h != null) {
                    this.a.f24010h.v1();
                }
                if (!c.a.d.f.p.l.x() || this.a.f24010h == null || !this.a.f24010h.T0() || this.a.f24009g == null || this.a.f24009g.video_length.intValue() <= 0 || this.a.f24009g.video_duration.intValue() <= 0) {
                    return;
                }
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                double intValue = ((this.a.f24009g.video_length.intValue() * (1.0f - ((this.a.f24010h.B0() * 1.0f) / (this.a.f24009g.video_duration.intValue() * 1000)))) * 1.0f) / 1048576.0f;
                if (intValue >= 0.1d) {
                    c.a.d.f.p.n.N(this.a.f24006d.getPageContext().getPageActivity(), String.format(this.a.f24006d.getPageContext().getString(c.a.u0.u2.l.pb_video_net_change_tip), decimalFormat.format(intValue)));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements c.e0 {
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

        @Override // c.a.u0.b3.c.e0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.a.D = -1L;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r implements c.b0 {
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

        @Override // c.a.u0.b3.c.b0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.u0.b3.c.b0
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // c.a.u0.b3.c.b0
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
                            if (this.a.f24006d.getListView() != null && this.a.f24006d.getListView().getChildCount() > 0 && this.a.f24006d.getListView().getChildAt(0) == this.a.R()) {
                                this.a.f24006d.getListView().setSelectionFromTop(0, this.a.R + ((int) (motionEvent.getY() - this.a.y)));
                            }
                        }
                    }
                    this.a.y = 0.0f;
                    this.a.R = 0;
                } else {
                    this.a.y = motionEvent.getY();
                    if (this.a.f24006d.getListView() != null && this.a.f24006d.getListView().getChildCount() > 0 && this.a.f24006d.getListView().getChildAt(0) == this.a.R()) {
                        g gVar = this.a;
                        gVar.R = gVar.R().getTop();
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24021e;

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
            this.f24021e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24021e.M = true;
                this.f24021e.B.setVisibility(8);
                this.f24021e.v0();
                TiebaStatic.log("c12618");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t implements c.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f24022b;

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
            this.f24022b = gVar;
            this.a = animation;
        }

        @Override // c.a.u0.b3.c.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f24022b.a0() && this.f24022b.f24004b != null) {
                this.a.setAnimationListener(null);
                this.f24022b.f24004b.p().clearAnimation();
                this.f24022b.t0();
                if (z) {
                    this.a.setAnimationListener(this.f24022b.S);
                    this.f24022b.f24004b.p().startAnimation(this.a);
                }
            }
        }

        @Override // c.a.u0.b3.c.u
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f24022b.a0()) {
                this.f24022b.S();
            }
        }
    }

    /* loaded from: classes9.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(442035791, "Lc/a/u0/u2/x/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(442035791, "Lc/a/u0/u2/x/g;");
                return;
            }
        }
        U = new h();
        V = new i();
    }

    public g(PbFragment pbFragment, c.a.u0.u2.u.f.i1.c cVar, VideoInfo videoInfo, long j2) {
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
        this.f24008f = null;
        this.f24009g = null;
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
        this.f24006d = pbFragment;
        this.f24004b = cVar;
        this.s = c.a.d.f.p.n.f(pbFragment.getActivity(), c.a.u0.u2.g.ds240);
        V(videoInfo);
        T();
        MessageManager.getInstance().registerListener(this.Q);
        this.T.setTag(pbFragment.getUniqueId());
        this.T.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.T);
        this.A = new c.a.a0.c(pbFragment.getActivity());
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || P().getHeight() + i2 <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24005c.getLayoutParams();
        if ((layoutParams.width == -1 && layoutParams.height == -1) || i2 == 0) {
            return;
        }
        if (i2 > 0) {
            this.O = false;
            if (this.v != P().getHeight()) {
                this.f24005c.setLayoutParams(new RelativeLayout.LayoutParams(c.a.d.f.p.n.k(this.f24006d.getActivity()), Math.min(this.v, P().getHeight() + i2)));
                this.f24010h.q0();
            }
        } else if (c.a.d.f.p.n.k(this.f24006d.getActivity()) * 0.5625d != P().getHeight()) {
            this.f24005c.setLayoutParams(new RelativeLayout.LayoutParams(c.a.d.f.p.n.k(this.f24006d.getActivity()), (int) Math.max(c.a.d.f.p.n.k(this.f24006d.getActivity()) * 0.5625d, P().getHeight() + i2)));
            this.f24010h.q0();
        }
    }

    public final void N(boolean z) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (pbFragment = this.f24006d) == null) {
            return;
        }
        pbFragment.doPraiseClick();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.u0.b3.c cVar = this.f24010h;
            if (cVar != null) {
                cVar.v0();
            }
            CustomFrameLayout customFrameLayout = this.f24005c;
            if (customFrameLayout != null) {
                customFrameLayout.clearAnimation();
            }
            c.a.u0.u2.x.e eVar = this.f24012j;
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
        c.a.u0.u2.u.f.i1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f24004b) == null) {
            return;
        }
        cVar.r();
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f24006d.getActivity(), c.a.u0.u2.e.anim_alpha_1_to_0_duration_2000_accelerate);
            if (this.f24007e == null) {
                this.f24007e = new t(this, loadAnimation);
            }
            o0(this.f24007e);
            UtilHelper.getLightStatusBarHeight();
            c.a.d.f.p.n.f(this.f24006d.getActivity(), c.a.u0.u2.g.ds98);
            this.H = new Handler();
        }
    }

    public void U(VideoInfo videoInfo, e2 e2Var, String str) {
        c.a.u0.b3.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoInfo, e2Var, str) == null) || videoInfo == null || (cVar = this.f24010h) == null || e2Var == null) {
            return;
        }
        this.f24009g = videoInfo;
        this.l = e2Var;
        this.f24008f = videoInfo.video_url;
        cVar.j2();
        c.a.u0.b3.t tVar = new c.a.u0.b3.t();
        this.f24011i = tVar;
        tVar.a = "pb";
        tVar.f15610c = e2Var.w1();
        c.a.u0.b3.t tVar2 = this.f24011i;
        tVar2.f15611d = str;
        tVar2.f15612e = TbadkCoreApplication.getCurrentAccount();
        if (e2Var.U1()) {
            if (!StringUtils.isNull(this.f24006d.lastTid)) {
                this.f24011i.k = this.f24006d.lastTid;
            }
            c.a.u0.b3.t tVar3 = this.f24011i;
            tVar3.f15616i = this.f24006d.bjhFrom + "";
        } else {
            this.f24011i.f15616i = this.f24006d.getVideoSource();
        }
        n1 recomStatisticData = this.f24006d.getRecomStatisticData();
        if (recomStatisticData != null) {
            recomStatisticData.d(this.f24011i);
        }
        c.a.u0.b3.t tVar4 = this.f24011i;
        tVar4.m = videoInfo.video_md5;
        c.a.u0.b3.t b2 = tVar4.b();
        b2.a = "6";
        this.D = -1L;
        if (this.f24010h.I0() != null && this.f24010h.I0().getMediaProgressObserver() != null) {
            this.f24010h.I0().getMediaProgressObserver().j(new a(this, videoInfo, str, e2Var));
        }
        this.f24010h.I0().setVideoStatData(b2);
        if (this.f24010h.H0()) {
            this.f24010h.q0();
        }
        this.f24010h.y1(this.F);
        this.n = null;
        this.m = null;
        this.f24010h.w1(null);
        this.f24010h.K0().setOnDragingListener(U);
        this.f24010h.x1(new b(this));
        this.f24010h.B1(new c(this));
        this.f24010h.D1(new d(this));
        this.f24010h.I1(new e(this));
        this.f24010h.R1(videoInfo.thumbnail_url);
        this.f24010h.X1(this.f24008f, e2Var.w1());
        this.f24010h.l1(str);
        this.f24010h.W1(e2Var.getTitle());
        this.f24010h.C1(V);
        this.f24010h.Z0();
        this.f24010h.Z1();
    }

    public final void V(VideoInfo videoInfo) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoInfo) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f24006d.getPageContext().getPageActivity()).inflate(c.a.u0.u2.j.video_pb_container_layout, (ViewGroup) null);
            this.a = relativeLayout;
            this.f24005c = (CustomFrameLayout) relativeLayout.findViewById(c.a.u0.u2.i.pb_video_container);
            int b0 = b0(videoInfo);
            int i2 = 0;
            this.z = ((double) this.v) <= (((double) c.a.d.f.p.n.k(this.f24006d.getActivity())) * 0.5625d) + 5.0d;
            int intValue = videoInfo.video_width.intValue();
            c.a.u0.b3.c cVar = new c.a.u0.b3.c(this.f24006d.getPageContext(), this.f24005c, true);
            this.f24010h = cVar;
            cVar.N1("2002");
            this.f24010h.Y1(this.P);
            this.f24010h.s1(false);
            this.f24010h.T1(this.E);
            this.f24010h.U1(SkinManager.getResourceId(c.a.u0.u2.h.pic_use_header_40_n));
            this.f24010h.M1(new q(this));
            if (TbSingleton.getInstance().isNotchScreen(this.f24006d.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f24006d.getBaseFragmentActivity())) {
                this.f24010h.n1(false);
            }
            this.f24010h.E1(new r(this));
            if (intValue > 0) {
                if (this.w >= 1.0d) {
                    this.f24010h.L1(false, true);
                } else {
                    this.f24010h.L1(true, false);
                }
                boolean z = ((float) b0) + this.s > ((float) c.a.d.f.p.n.i(this.f24006d.getActivity()));
                this.t = z;
                if (z) {
                    if (this.f24012j == null) {
                        this.f24012j = new c.a.u0.u2.x.e(this.f24006d.getPageContext(), this.f24005c);
                    }
                    this.f24006d.getPbView().d1();
                    this.k = true;
                }
            }
            u0();
            this.x = new View(this.f24006d.getContext());
            this.x.setLayoutParams(new AbsListView.LayoutParams(-1, this.v));
            c.a.u0.u2.u.f.i1.c cVar2 = this.f24004b;
            if (cVar2 != null && (navigationBar = cVar2.a) != null) {
                navigationBar.getBarBgView().setAlpha(0.0f);
                this.f24004b.a.getTopCoverBgView().setAlpha(1.0f);
                NavigationBar navigationBar2 = this.f24004b.a;
                if (!DeviceInfoUtil.isHWnova() && !TbSingleton.getInstance().isNotchScreen(this.f24006d.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.f24006d.getBaseFragmentActivity())) {
                    i2 = 8;
                }
                navigationBar2.setStatusBarVisibility(i2);
            }
            PbVideoWifiTipLayout pbVideoWifiTipLayout = (PbVideoWifiTipLayout) this.a.findViewById(c.a.u0.u2.i.layout_wifi_tip);
            this.B = pbVideoWifiTipLayout;
            pbVideoWifiTipLayout.setOnPlayClickListener(new s(this));
            c.a.a0.c cVar3 = this.A;
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
            return P().getBottom() > c.a.d.f.p.n.i(P().getContext()) - c.a.d.f.p.n.f(P().getContext(), c.a.u0.u2.g.ds50);
        }
        return invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f24012j == null) {
            return;
        }
        if (W()) {
            this.f24006d.getPbView().d1();
        } else if (this.f24012j.f().getVisibility() == 0) {
            this.f24006d.getPbView().d1();
            this.k = true;
        } else if (this.k) {
            this.f24006d.getPbView().f3(false);
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
                this.f24005c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                return c.a.d.f.p.n.k(this.f24006d.getActivity());
            }
            int k2 = c.a.d.f.p.n.k(this.f24006d.getActivity());
            Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.f24006d.getPageContext().getPageActivity());
            int i2 = visibilityRegion.height() <= 0 ? c.a.d.f.p.n.i(this.f24006d.getActivity()) : visibilityRegion.height();
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
            this.f24005c.setLayoutParams(new RelativeLayout.LayoutParams(k2, i3));
            return i3;
        }
        return invokeL.intValue;
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            c.a.u0.u2.u.f.i1.c cVar = this.f24004b;
            if (cVar != null) {
                cVar.v(i2);
            }
            PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
            if (pbFullScreenFloatingHuajiAninationView != null) {
                pbFullScreenFloatingHuajiAninationView.onChangeSkinType(i2);
            }
            c.a.u0.u2.x.e eVar = this.f24012j;
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
            if (this.f24010h == null || (customFrameLayout = this.f24005c) == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customFrameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                c.a.a0.c cVar = this.A;
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
                this.f24005c.setLayoutParams(layoutParams);
                this.f24006d.getPbView().d1();
                this.k = true;
            } else {
                b0(this.f24009g);
                t0();
                this.p = false;
                this.f24004b.B(true);
            }
            this.f24010h.U0(this.f24006d.getPageContext(), configuration);
        }
    }

    public boolean e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            c.a.u0.b3.c cVar = this.f24010h;
            if (cVar == null) {
                return false;
            }
            return cVar.e1(i2);
        }
        return invokeI.booleanValue;
    }

    public void f0() {
        c.a.u0.b3.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.f24010h) == null) {
            return;
        }
        if (cVar.T0()) {
            this.o = true;
            this.f24010h.j2();
        } else if (this.f24010h.C0() == 3) {
            this.o = false;
        } else if (this.f24010h.C0() != 0 && this.f24010h.C0() != 1) {
            this.o = false;
            this.f24010h.j2();
        } else {
            this.o = true;
            this.f24010h.j2();
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.stopAnimation();
        }
    }

    public void g0() {
        c.a.u0.b3.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (cVar = this.f24010h) != null && this.o) {
            cVar.h1();
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
                        if (this.N || !"nani_midpage".equals(this.f24006d.getVideoSource())) {
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

    public void k0(PostData postData, e2 e2Var, c.a.u0.u2.r.r rVar) {
        c.a.u0.u2.x.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048600, this, postData, e2Var, rVar) == null) || (eVar = this.f24012j) == null) {
            return;
        }
        eVar.m(postData, e2Var, rVar);
    }

    public final void l0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || this.f24009g == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            c.a.u0.b3.j.e(this.f24009g.video_md5, "", str, this.f24011i, this.f24010h.I0().getPcdnState());
        }
    }

    public void m0() {
        c.a.u0.b3.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.f24010h) == null) {
            return;
        }
        cVar.f1();
    }

    public final void n0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.f24012j == null) {
            return;
        }
        e2 e2Var = this.l;
        if (e2Var != null && e2Var.H2()) {
            this.f24012j.f().setVisibility(8);
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
            this.f24012j.f().setVisibility(8);
        } else {
            this.f24012j.f().setVisibility(0);
        }
        this.f24012j.n(f4);
    }

    public void o0(c.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, uVar) == null) {
            this.F = uVar;
        }
    }

    public void p0(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, e2Var) == null) {
            this.m = e2Var;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.n = str;
            c.a.u0.b3.c cVar = this.f24010h;
            if (cVar != null) {
                cVar.w1(str);
            }
        }
    }

    public void r0(View.OnClickListener onClickListener) {
        c.a.u0.u2.x.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) || (eVar = this.f24012j) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.f24004b == null) {
            return;
        }
        this.f24004b.D(this.f24006d.isSimpleForum());
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || c.a.t0.s.j0.b.k().h("show_video_pb_double_tap_tips", false)) {
            return;
        }
        c.a.t0.s.j0.b.k().u("show_video_pb_double_tap_tips", true);
        c.a.d.f.g.d dVar = new c.a.d.f.g.d();
        dVar.d(true);
        dVar.h(false);
        dVar.k(16908290);
        dVar.c(153);
        dVar.i(false);
        dVar.a(new f(this));
        dVar.g(new C1454g(this));
        c.a.d.f.g.c b2 = dVar.b();
        this.K = b2;
        b2.t(this.f24006d.getActivity());
    }

    public void v0() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.f24010h == null) {
            return;
        }
        if (c.a.d.f.p.l.x() && !this.M && !c.a.u0.n4.h.c().d()) {
            this.B.setVisibility(0);
            this.B.setData(this.f24009g);
            TiebaStatic.log("c12622");
            return;
        }
        if (StringUtils.isNull(this.f24008f) && (e2Var = this.l) != null && e2Var.u1() != null) {
            TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "pb").param("tid", this.l.w1()));
            this.f24008f = this.l.u1().video_url;
        }
        c.a.u0.b3.c cVar = this.f24010h;
        String str = this.f24008f;
        e2 e2Var2 = this.l;
        cVar.c2(str, e2Var2 == null ? "" : e2Var2.w1());
        l0("2");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    public void w0(String str) {
        c.a.u0.b3.t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || (tVar = this.f24011i) == null) {
            return;
        }
        tVar.f15611d = str;
    }
}
