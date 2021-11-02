package b.a.r0.z2;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.g0;
import b.a.r0.g.a.a;
import b.a.r0.l3.l0.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class g implements b.a.r0.g.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BannerView f28072a;

    /* renamed from: b  reason: collision with root package name */
    public g0 f28073b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28074c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.g.e.c f28075d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f28076e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC0853a f28077f;

    /* renamed from: g  reason: collision with root package name */
    public String f28078g;

    /* renamed from: h  reason: collision with root package name */
    public String f28079h;

    /* renamed from: i  reason: collision with root package name */
    public BannerView.b f28080i;

    /* loaded from: classes6.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f28081a;

        public a(g gVar) {
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
            this.f28081a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.f28081a.f28073b != null && this.f28081a.f28073b.f13327i) {
                    String c2 = this.f28081a.f28073b.c();
                    if (!StringUtils.isNULL(c2)) {
                        this.f28081a.B(c2);
                    }
                    this.f28081a.f28073b.f13327i = false;
                }
                if (this.f28081a.f28072a == null || !this.f28081a.f28072a.isBannerViewShowing() || this.f28081a.f28074c) {
                    return;
                }
                this.f28081a.f28074c = true;
                this.f28081a.f28077f.a(this.f28081a.f28075d, this.f28081a.f28072a);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f28082a;

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
            this.f28082a = gVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28082a.A();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f28082a.y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28083a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1679168898, "Lb/a/r0/z2/g$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1679168898, "Lb/a/r0/z2/g$c;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f28083a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28083a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1673253857, "Lb/a/r0/z2/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1673253857, "Lb/a/r0/z2/g;");
                return;
            }
        }
        j = Pattern.compile("(/p/){1}(\\d+)");
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28072a = null;
        this.f28074c = false;
        this.f28080i = new b(this);
    }

    public final void A() {
        BannerView bannerView;
        a.InterfaceC0853a interfaceC0853a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bannerView = this.f28072a) == null || (interfaceC0853a = this.f28077f) == null) {
            return;
        }
        this.f28074c = false;
        interfaceC0853a.b(this.f28075d, bannerView);
        this.f28072a = null;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = b.a.r0.l3.l0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f28079h, this.f28078g, null);
        b2.d(TiebaStatic.Params.OBJ_URL, this.f28073b.b());
        b2.e();
    }

    public final void C(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = b.a.r0.l3.l0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f28079h, this.f28078g, null);
        b2.d(TiebaStatic.Params.OBJ_URL, str2);
        b2.e();
    }

    @Override // b.a.r0.g.a.a
    public void a(int i2) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (bannerView = this.f28072a) == null) {
            return;
        }
        bannerView.onChangeSkin();
    }

    @Override // b.a.r0.g.e.a
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        this.f28078g = map.get("forum_name");
        this.f28079h = map.get("forum_id");
    }

    @Override // b.a.r0.g.a.a
    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, obj) == null) && (obj instanceof g0)) {
            this.f28073b = (g0) obj;
        }
    }

    @Override // b.a.r0.g.a.a
    public void g(a.InterfaceC0853a interfaceC0853a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0853a) == null) {
            this.f28077f = interfaceC0853a;
        }
    }

    @Override // b.a.r0.g.a.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28072a : (View) invokeV.objValue;
    }

    @Override // b.a.r0.g.a.a
    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f28076e == null || this.f28077f == null) {
            return;
        }
        g0 g0Var = this.f28073b;
        if (g0Var == null) {
            A();
        } else if (!g0Var.e()) {
            A();
        } else {
            if (!this.f28074c) {
                if (this.f28072a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f28076e.getPageActivity());
                this.f28072a = bannerView;
                bannerView.setVisibility(8);
                this.f28072a.setBannerViewClickListener(this.f28080i);
                this.f28072a.setBannerViewEvent(new a(this));
                if (this.f28073b.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f28076e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f28077f.a(this.f28075d, this.f28072a);
            }
            this.f28072a.setBannerData(this.f28073b);
            this.f28072a.reset();
            if (this.f28073b.getType() != 1 || TextUtils.isEmpty(this.f28073b.b())) {
                return;
            }
            this.f28072a.setData(this.f28076e, this.f28073b.b());
        }
    }

    @Override // b.a.r0.g.a.a
    public void k(int i2) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (bannerView = this.f28072a) == null) {
            return;
        }
        bannerView.setBannerMaskColor(i2);
    }

    public final void y() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (g0Var = this.f28073b) == null) {
            return;
        }
        String d2 = g0Var.d();
        String c2 = this.f28073b.c();
        if (this.f28073b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f28076e.getPageActivity(), d2, false, BannerView.FRS_BANNER)));
            C(c2, d2);
        } else if (this.f28073b.a() == 2) {
            if (d2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = j.matcher(d2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f28076e.getPageActivity()).createNormalCfg(matcher.group(2), null, BannerView.FRS_BANNER);
                        createNormalCfg.setVideo_source("frs");
                        this.f28076e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        C(c2, d2);
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
            }
        } else if (this.f28073b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = c.f28083a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f28076e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f28076e.getPageActivity()).createNormalCfg(isNativeAddress.id, BannerView.FRS_BANNER)));
                } else if (i2 == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f28076e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, BannerView.FRS_BANNER);
                    createNormalCfg2.setVideo_source("frs");
                    this.f28076e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                y.o().e().c(this.f28076e.getPageActivity(), new String[]{d2}, null);
                if (!StringUtils.isNull(d2) && d2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f28076e.getPageActivity(), BannerView.FRS_BANNER, PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            C(c2, d2);
        } else if (this.f28073b.a() == 4) {
            this.f28076e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f28076e.getPageActivity()).createNormalCfg(d2, BannerView.FRS_BANNER)));
            C(c2, d2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.g.e.a
    /* renamed from: z */
    public void o(b.a.r0.g.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f28075d = cVar;
            if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
                return;
            }
            this.f28076e = (TbPageContext) this.f28075d.a();
        }
    }
}
