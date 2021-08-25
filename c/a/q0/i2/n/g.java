package c.a.q0.i2.n;

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
import c.a.e.e.g.d;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.m1;
import c.a.q0.o2.c;
import c.a.q0.o2.f;
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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
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
    public c.a.e.e.g.c K;
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
    public RelativeLayout f19952a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.i2.k.e.e1.c f19953b;

    /* renamed from: c  reason: collision with root package name */
    public CustomFrameLayout f19954c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f19955d;

    /* renamed from: e  reason: collision with root package name */
    public c.y f19956e;

    /* renamed from: f  reason: collision with root package name */
    public String f19957f;

    /* renamed from: g  reason: collision with root package name */
    public VideoInfo f19958g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.o2.c f19959h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.o2.o f19960i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.i2.n.e f19961j;
    public boolean k;
    public c2 l;
    public c2 m;
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

    /* loaded from: classes3.dex */
    public class a implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoInfo f19962e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19963f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c2 f19964g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f19965h;

        public a(g gVar, VideoInfo videoInfo, String str, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, videoInfo, str, c2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19965h = gVar;
            this.f19962e = videoInfo;
            this.f19963f = str;
            this.f19964g = c2Var;
        }

        @Override // c.a.q0.o2.f.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f19965h.D <= 0) {
                    this.f19965h.D = i3;
                }
                McnAdInfo mcnAdInfo = this.f19962e.mcn_ad_card;
                if (mcnAdInfo == null) {
                    return;
                }
                boolean a2 = c.a.y.b.b().a(mcnAdInfo.jump_url);
                if (!this.f19965h.z || a2 || this.f19965h.p) {
                    return;
                }
                boolean z = true;
                boolean z2 = this.f19965h.D >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                long j2 = i3;
                if ((j2 < mcnAdInfo.ad_start_time.longValue() * 1000 || j2 >= mcnAdInfo.ad_end_time.longValue() * 1000) ? false : false) {
                    if (this.f19965h.A.c()) {
                        return;
                    }
                    c.a.y.a aVar = new c.a.y.a();
                    aVar.f31127b = mcnAdInfo.card_title;
                    aVar.f31128c = mcnAdInfo.button_title;
                    aVar.f31129d = mcnAdInfo.jump_url;
                    aVar.f31126a = mcnAdInfo.pic_url;
                    aVar.f31131f = this.f19963f;
                    aVar.f31130e = this.f19964g.q1();
                    aVar.f31132g = 4;
                    if (z2) {
                        this.f19965h.A.f(aVar, (ViewGroup) this.f19965h.f19959h.E0());
                    } else {
                        this.f19965h.A.e(aVar, (ViewGroup) this.f19965h.f19959h.E0());
                    }
                } else if (this.f19965h.A.c()) {
                    this.f19965h.A.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19966a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19967e;

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
                this.f19967e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f19967e.f19966a.C > 0) {
                        g gVar = this.f19967e.f19966a;
                        gVar.M(gVar.C);
                        g gVar2 = this.f19967e.f19966a;
                        gVar2.j0(gVar2.C);
                        this.f19967e.f19966a.C = 0;
                    }
                    this.f19967e.f19966a.G = true;
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
            this.f19966a = gVar;
        }

        @Override // c.a.q0.o2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19966a.f19955d.getBaseFragmentActivity().setSwipeBackEnabled(false);
                this.f19966a.G = false;
                g gVar = this.f19966a;
                gVar.C = gVar.P().getHeight();
            }
        }

        @Override // c.a.q0.o2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f19966a.f19955d.getBaseFragmentActivity().setSwipeBackEnabled(true);
                this.f19966a.H.postDelayed(new a(this), 200L);
                this.f19966a.D = -1L;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19968a;

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
            this.f19968a = gVar;
        }

        @Override // c.a.q0.o2.c.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19968a.f19955d == null || this.f19968a.m == null || StringUtils.isNull(this.f19968a.m.f0())) {
                return;
            }
            this.f19968a.f19955d.loadNextVideoPb(this.f19968a.m.f0());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19969a;

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
            this.f19969a = gVar;
        }

        @Override // c.a.q0.o2.c.e0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f19969a.l == null) {
                return;
            }
            this.f19969a.l0(z ? "1" : "2");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19970e;

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
            this.f19970e = gVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f19970e.f19957f);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements c.a.e.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19971a;

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
            this.f19971a = gVar;
        }

        @Override // c.a.e.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 5;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                ImageView imageView = new ImageView(this.f19971a.f19955d.getActivity());
                if (this.f19971a.L == null) {
                    try {
                        this.f19971a.L = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                        imageView.setImageBitmap(this.f19971a.L);
                    } catch (Throwable unused) {
                    }
                }
                return imageView;
            }
            return (View) invokeL.objValue;
        }

        @Override // c.a.e.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* renamed from: c.a.q0.i2.n.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0940g implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19972a;

        public C0940g(g gVar) {
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
            this.f19972a = gVar;
        }

        @Override // c.a.e.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19972a.K = null;
                if (this.f19972a.L != null && !this.f19972a.L.isRecycled()) {
                    this.f19972a.L.recycle();
                }
                this.f19972a.L = null;
            }
        }

        @Override // c.a.e.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

        @Override // c.a.q0.o2.c.d0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19973e;

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
            this.f19973e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g gVar = this.f19973e;
                gVar.j0(gVar.P().getHeight());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements c.k0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19974a;

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
            this.f19974a = gVar;
        }

        @Override // c.a.q0.o2.c.k0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19974a.f19955d == null || this.f19974a.f19955d.getPbModel() == null || this.f19974a.f19955d.getPbModel().O0() == null) {
                return;
            }
            PostData j2 = this.f19974a.f19955d.getPbModel().O0().j();
            if (j2 == null && ListUtils.getCount(this.f19974a.f19955d.getPbModel().O0().F()) > 1) {
                j2 = (PostData) ListUtils.getItem(this.f19974a.f19955d.getPbModel().O0().F(), 0);
            }
            c.a.q0.i2.m.a.b(this.f19974a.f19955d.getPbModel().O0(), j2, 1, 1, 4);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19975e;

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
            this.f19975e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19975e.m0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19976a;

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
            this.f19976a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19976a.f19958g == null) {
                return;
            }
            g gVar = this.f19976a;
            gVar.b0(gVar.f19958g);
            this.f19976a.f19959h.c1();
            this.f19976a.f19959h.q0();
            if (this.f19976a.x == null || this.f19976a.x.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f19976a.x.getLayoutParams();
            layoutParams.height = this.f19976a.v;
            this.f19976a.x.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public class n implements PbFullScreenFloatingHuajiAninationView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19977a;

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
            this.f19977a = gVar;
        }

        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19977a.N(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements c.h0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19978a;

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
            this.f19978a = gVar;
        }

        @Override // c.a.q0.o2.c.h0
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.q0.o2.c.h0
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f19978a.w >= 1.0d) {
                    if (!this.f19978a.f19955d.checkUpIsLogin()) {
                        return true;
                    }
                    this.f19978a.f19955d.hideKeyboardAndEditor();
                    if (this.f19978a.f19955d.getPbModel() != null && this.f19978a.f19955d.getPbModel().O0() != null && this.f19978a.f19955d.getPbModel().O0().S() != null) {
                        c.a.q0.i2.h.p S = this.f19978a.f19955d.getPbModel().O0().S();
                        if (this.f19978a.I == null) {
                            this.f19978a.I = new PbFullScreenFloatingHuajiAninationView(this.f19978a.f19955d.getActivity());
                            this.f19978a.I.setFloatingHuajiAninationListener(this.f19978a.J);
                        }
                        this.f19978a.I.startAnimation(!S.g());
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19979a;

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
            this.f19979a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && c.a.e.e.p.j.z()) {
                if (this.f19979a.f19959h != null) {
                    this.f19979a.f19959h.w1();
                }
                if (!c.a.e.e.p.j.x() || this.f19979a.f19959h == null || !this.f19979a.f19959h.T0() || this.f19979a.f19958g == null || this.f19979a.f19958g.video_length.intValue() <= 0 || this.f19979a.f19958g.video_duration.intValue() <= 0) {
                    return;
                }
                DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
                double intValue = ((this.f19979a.f19958g.video_length.intValue() * (1.0f - ((this.f19979a.f19959h.B0() * 1.0f) / (this.f19979a.f19958g.video_duration.intValue() * 1000)))) * 1.0f) / 1048576.0f;
                if (intValue >= 0.1d) {
                    c.a.e.e.p.l.M(this.f19979a.f19955d.getPageContext().getPageActivity(), String.format(this.f19979a.f19955d.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format(intValue)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements c.i0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19980a;

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
            this.f19980a = gVar;
        }

        @Override // c.a.q0.o2.c.i0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.f19980a.D = -1L;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements c.f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19981a;

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
            this.f19981a = gVar;
        }

        @Override // c.a.q0.o2.c.f0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.q0.o2.c.f0
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // c.a.q0.o2.c.f0
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
                            if (this.f19981a.f19955d.getListView() != null && this.f19981a.f19955d.getListView().getChildCount() > 0 && this.f19981a.f19955d.getListView().getChildAt(0) == this.f19981a.R()) {
                                this.f19981a.f19955d.getListView().setSelectionFromTop(0, this.f19981a.R + ((int) (motionEvent.getY() - this.f19981a.y)));
                            }
                        }
                    }
                    this.f19981a.y = 0.0f;
                    this.f19981a.R = 0;
                } else {
                    this.f19981a.y = motionEvent.getY();
                    if (this.f19981a.f19955d.getListView() != null && this.f19981a.f19955d.getListView().getChildCount() > 0 && this.f19981a.f19955d.getListView().getChildAt(0) == this.f19981a.R()) {
                        g gVar = this.f19981a;
                        gVar.R = gVar.R().getTop();
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19982e;

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
            this.f19982e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19982e.M = true;
                this.f19982e.B.setVisibility(8);
                this.f19982e.v0();
                TiebaStatic.log("c12618");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements c.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f19983a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f19984b;

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
            this.f19984b = gVar;
            this.f19983a = animation;
        }

        @Override // c.a.q0.o2.c.y
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f19984b.a0() && this.f19984b.f19953b != null) {
                this.f19983a.setAnimationListener(null);
                this.f19984b.f19953b.p().clearAnimation();
                this.f19984b.t0();
                if (z) {
                    this.f19983a.setAnimationListener(this.f19984b.S);
                    this.f19984b.f19953b.p().startAnimation(this.f19983a);
                }
            }
        }

        @Override // c.a.q0.o2.c.y
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f19984b.a0()) {
                this.f19984b.S();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19985a;

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
            this.f19985a = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f19985a.S();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-832317679, "Lc/a/q0/i2/n/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-832317679, "Lc/a/q0/i2/n/g;");
                return;
            }
        }
        U = new h();
        V = new i();
    }

    public g(PbFragment pbFragment, c.a.q0.i2.k.e.e1.c cVar, VideoInfo videoInfo, long j2) {
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
        this.f19957f = null;
        this.f19958g = null;
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
        this.f19955d = pbFragment;
        this.f19953b = cVar;
        this.s = c.a.e.e.p.l.g(pbFragment.getActivity(), R.dimen.ds240);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19954c.getLayoutParams();
        if ((layoutParams.width == -1 && layoutParams.height == -1) || i2 == 0) {
            return;
        }
        if (i2 > 0) {
            this.O = false;
            if (this.v != P().getHeight()) {
                this.f19954c.setLayoutParams(new RelativeLayout.LayoutParams(c.a.e.e.p.l.k(this.f19955d.getActivity()), Math.min(this.v, P().getHeight() + i2)));
                this.f19959h.q0();
            }
        } else if (c.a.e.e.p.l.k(this.f19955d.getActivity()) * 0.5625d != P().getHeight()) {
            this.f19954c.setLayoutParams(new RelativeLayout.LayoutParams(c.a.e.e.p.l.k(this.f19955d.getActivity()), (int) Math.max(c.a.e.e.p.l.k(this.f19955d.getActivity()) * 0.5625d, P().getHeight() + i2)));
            this.f19959h.q0();
        }
    }

    public final void N(boolean z) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (pbFragment = this.f19955d) == null) {
            return;
        }
        pbFragment.doPraiseClick();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.o2.c cVar = this.f19959h;
            if (cVar != null) {
                cVar.v0();
            }
            CustomFrameLayout customFrameLayout = this.f19954c;
            if (customFrameLayout != null) {
                customFrameLayout.clearAnimation();
            }
            c.a.q0.i2.n.e eVar = this.f19961j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19952a : (View) invokeV.objValue;
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
        c.a.q0.i2.k.e.e1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f19953b) == null) {
            return;
        }
        cVar.r();
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f19955d.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
            if (this.f19956e == null) {
                this.f19956e = new t(this, loadAnimation);
            }
            o0(this.f19956e);
            UtilHelper.getLightStatusBarHeight();
            c.a.e.e.p.l.g(this.f19955d.getActivity(), R.dimen.ds98);
            this.H = new Handler();
        }
    }

    public void U(VideoInfo videoInfo, c2 c2Var, String str) {
        c.a.q0.o2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoInfo, c2Var, str) == null) || videoInfo == null || (cVar = this.f19959h) == null || c2Var == null) {
            return;
        }
        this.f19958g = videoInfo;
        this.l = c2Var;
        this.f19957f = videoInfo.video_url;
        cVar.k2();
        c.a.q0.o2.o oVar = new c.a.q0.o2.o();
        this.f19960i = oVar;
        oVar.f23216a = "pb";
        oVar.f23218c = c2Var.q1();
        c.a.q0.o2.o oVar2 = this.f19960i;
        oVar2.f23219d = str;
        oVar2.f23220e = TbadkCoreApplication.getCurrentAccount();
        if (c2Var.N1()) {
            if (!StringUtils.isNull(this.f19955d.lastTid)) {
                this.f19960i.k = this.f19955d.lastTid;
            }
            c.a.q0.o2.o oVar3 = this.f19960i;
            oVar3.f23224i = this.f19955d.bjhFrom + "";
        } else {
            this.f19960i.f23224i = this.f19955d.getVideoSource();
        }
        m1 recomStatisticData = this.f19955d.getRecomStatisticData();
        if (recomStatisticData != null) {
            recomStatisticData.d(this.f19960i);
        }
        c.a.q0.o2.o oVar4 = this.f19960i;
        oVar4.m = videoInfo.video_md5;
        c.a.q0.o2.o b2 = oVar4.b();
        b2.f23216a = "6";
        this.D = -1L;
        if (this.f19959h.I0() != null && this.f19959h.I0().getMediaProgressObserver() != null) {
            this.f19959h.I0().getMediaProgressObserver().j(new a(this, videoInfo, str, c2Var));
        }
        this.f19959h.I0().setVideoStatData(b2);
        if (this.f19959h.H0()) {
            this.f19959h.q0();
        }
        this.f19959h.z1(this.F);
        this.n = null;
        this.m = null;
        this.f19959h.x1(null);
        this.f19959h.K0().setOnDragingListener(U);
        this.f19959h.y1(new b(this));
        this.f19959h.C1(new c(this));
        this.f19959h.E1(new d(this));
        this.f19959h.J1(new e(this));
        this.f19959h.S1(videoInfo.thumbnail_url);
        this.f19959h.Y1(this.f19957f, c2Var.q1());
        this.f19959h.m1(str);
        this.f19959h.X1(c2Var.getTitle());
        this.f19959h.D1(V);
        this.f19959h.a1();
        this.f19959h.a2();
    }

    public final void V(VideoInfo videoInfo) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoInfo) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19955d.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
            this.f19952a = relativeLayout;
            this.f19954c = (CustomFrameLayout) relativeLayout.findViewById(R.id.pb_video_container);
            int b0 = b0(videoInfo);
            int i2 = 0;
            this.z = ((double) this.v) <= (((double) c.a.e.e.p.l.k(this.f19955d.getActivity())) * 0.5625d) + 5.0d;
            int intValue = videoInfo.video_width.intValue();
            c.a.q0.o2.c cVar = new c.a.q0.o2.c(this.f19955d.getPageContext(), this.f19954c, true);
            this.f19959h = cVar;
            cVar.O1("2002");
            this.f19959h.Z1(this.P);
            this.f19959h.t1(false);
            this.f19959h.U1(this.E);
            this.f19959h.V1(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
            this.f19959h.N1(new q(this));
            if (TbSingleton.getInstance().isNotchScreen(this.f19955d.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f19955d.getBaseFragmentActivity())) {
                this.f19959h.o1(false);
            }
            this.f19959h.F1(new r(this));
            if (intValue > 0) {
                if (this.w >= 1.0d) {
                    this.f19959h.M1(false, true);
                } else {
                    this.f19959h.M1(true, false);
                }
                boolean z = ((float) b0) + this.s > ((float) c.a.e.e.p.l.i(this.f19955d.getActivity()));
                this.t = z;
                if (z) {
                    if (this.f19961j == null) {
                        this.f19961j = new c.a.q0.i2.n.e(this.f19955d.getPageContext(), this.f19954c);
                    }
                    this.f19955d.getPbView().d1();
                    this.k = true;
                }
            }
            u0();
            this.x = new View(this.f19955d.getContext());
            this.x.setLayoutParams(new AbsListView.LayoutParams(-1, this.v));
            c.a.q0.i2.k.e.e1.c cVar2 = this.f19953b;
            if (cVar2 != null && (navigationBar = cVar2.f19396a) != null) {
                navigationBar.getBarBgView().setAlpha(0.0f);
                this.f19953b.f19396a.getTopCoverBgView().setAlpha(1.0f);
                NavigationBar navigationBar2 = this.f19953b.f19396a;
                if (!DeviceInfoUtil.isHWnova() && !TbSingleton.getInstance().isNotchScreen(this.f19955d.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.f19955d.getBaseFragmentActivity())) {
                    i2 = 8;
                }
                navigationBar2.setStatusBarVisibility(i2);
            }
            PbVideoWifiTipLayout pbVideoWifiTipLayout = (PbVideoWifiTipLayout) this.f19952a.findViewById(R.id.layout_wifi_tip);
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
            return P().getBottom() > c.a.e.e.p.l.i(P().getContext()) - c.a.e.e.p.l.g(P().getContext(), R.dimen.ds50);
        }
        return invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f19961j == null) {
            return;
        }
        if (W()) {
            this.f19955d.getPbView().d1();
        } else if (this.f19961j.f().getVisibility() == 0) {
            this.f19955d.getPbView().d1();
            this.k = true;
        } else if (this.k) {
            this.f19955d.getPbView().f3(false);
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
                this.f19954c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                return c.a.e.e.p.l.k(this.f19955d.getActivity());
            }
            int k2 = c.a.e.e.p.l.k(this.f19955d.getActivity());
            Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.f19955d.getPageContext().getPageActivity());
            int i2 = visibilityRegion.height() <= 0 ? c.a.e.e.p.l.i(this.f19955d.getActivity()) : visibilityRegion.height();
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
            this.f19954c.setLayoutParams(new RelativeLayout.LayoutParams(k2, i3));
            return i3;
        }
        return invokeL.intValue;
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            c.a.q0.i2.k.e.e1.c cVar = this.f19953b;
            if (cVar != null) {
                cVar.w(i2);
            }
            PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
            if (pbFullScreenFloatingHuajiAninationView != null) {
                pbFullScreenFloatingHuajiAninationView.onChangeSkinType(i2);
            }
            c.a.q0.i2.n.e eVar = this.f19961j;
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
            if (this.f19959h == null || (customFrameLayout = this.f19954c) == null) {
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
                c.a.e.e.g.c cVar2 = this.K;
                if (cVar2 != null) {
                    cVar2.d();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.p = true;
                this.f19954c.setLayoutParams(layoutParams);
                this.f19955d.getPbView().d1();
                this.k = true;
            } else {
                b0(this.f19958g);
                t0();
                this.p = false;
                this.f19953b.C(true);
            }
            this.f19959h.V0(this.f19955d.getPageContext(), configuration);
        }
    }

    public boolean e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            c.a.q0.o2.c cVar = this.f19959h;
            if (cVar == null) {
                return false;
            }
            return cVar.f1(i2);
        }
        return invokeI.booleanValue;
    }

    public void f0() {
        c.a.q0.o2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.f19959h) == null) {
            return;
        }
        if (cVar.T0()) {
            this.o = true;
            this.f19959h.k2();
        } else if (this.f19959h.C0() == 3) {
            this.o = false;
        } else if (this.f19959h.C0() != 0 && this.f19959h.C0() != 1) {
            this.o = false;
            this.f19959h.k2();
        } else {
            this.o = true;
            this.f19959h.k2();
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.stopAnimation();
        }
    }

    public void g0() {
        c.a.q0.o2.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (cVar = this.f19959h) != null && this.o) {
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
                        if (this.N || !"nani_midpage".equals(this.f19955d.getVideoSource())) {
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

    public void k0(PostData postData, c2 c2Var, c.a.q0.i2.h.p pVar) {
        c.a.q0.i2.n.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048600, this, postData, c2Var, pVar) == null) || (eVar = this.f19961j) == null) {
            return;
        }
        eVar.m(postData, c2Var, pVar);
    }

    public final void l0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || this.f19958g == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            c.a.q0.o2.h.e(this.f19958g.video_md5, "", str, this.f19960i, this.f19959h.I0().getPcdnState());
        }
    }

    public void m0() {
        c.a.q0.o2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.f19959h) == null) {
            return;
        }
        cVar.g1();
    }

    public final void n0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.f19961j == null) {
            return;
        }
        c2 c2Var = this.l;
        if (c2Var != null && c2Var.z2()) {
            this.f19961j.f().setVisibility(8);
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
            this.f19961j.f().setVisibility(8);
        } else {
            this.f19961j.f().setVisibility(0);
        }
        this.f19961j.n(f4);
    }

    public void o0(c.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, yVar) == null) {
            this.F = yVar;
        }
    }

    public void p0(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, c2Var) == null) {
            this.m = c2Var;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.n = str;
            c.a.q0.o2.c cVar = this.f19959h;
            if (cVar != null) {
                cVar.x1(str);
            }
        }
    }

    public void r0(View.OnClickListener onClickListener) {
        c.a.q0.i2.n.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) || (eVar = this.f19961j) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.f19953b == null) {
            return;
        }
        this.f19953b.E(this.f19955d.isSimpleForum());
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || c.a.p0.s.d0.b.j().g("show_video_pb_double_tap_tips", false)) {
            return;
        }
        c.a.p0.s.d0.b.j().t("show_video_pb_double_tap_tips", true);
        c.a.e.e.g.d dVar = new c.a.e.e.g.d();
        dVar.d(true);
        dVar.h(false);
        dVar.k(16908290);
        dVar.c(153);
        dVar.i(false);
        dVar.a(new f(this));
        dVar.g(new C0940g(this));
        c.a.e.e.g.c b2 = dVar.b();
        this.K = b2;
        b2.p(this.f19955d.getActivity());
    }

    public void v0() {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.f19959h == null) {
            return;
        }
        if (c.a.e.e.p.j.x() && !this.M && !c.a.q0.w3.h.d().e()) {
            this.B.setVisibility(0);
            this.B.setData(this.f19958g);
            TiebaStatic.log("c12622");
            return;
        }
        if (StringUtils.isNull(this.f19957f) && (c2Var = this.l) != null && c2Var.o1() != null) {
            TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "pb").param("tid", this.l.q1()));
            this.f19957f = this.l.o1().video_url;
        }
        c.a.q0.o2.c cVar = this.f19959h;
        String str = this.f19957f;
        c2 c2Var2 = this.l;
        cVar.d2(str, c2Var2 == null ? "" : c2Var2.q1());
        l0("2");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    public void w0(String str) {
        c.a.q0.o2.o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || (oVar = this.f19960i) == null) {
            return;
        }
        oVar.f23219d = str;
    }
}
