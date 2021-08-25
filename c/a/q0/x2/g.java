package c.a.q0.x2;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.g0;
import c.a.q0.f.a.a;
import c.a.q0.i3.k0.a;
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
/* loaded from: classes4.dex */
public class g implements c.a.q0.f.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f28845j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BannerView f28846a;

    /* renamed from: b  reason: collision with root package name */
    public g0 f28847b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28848c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.f.e.c f28849d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f28850e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC0827a f28851f;

    /* renamed from: g  reason: collision with root package name */
    public String f28852g;

    /* renamed from: h  reason: collision with root package name */
    public String f28853h;

    /* renamed from: i  reason: collision with root package name */
    public BannerView.b f28854i;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f28855a;

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
            this.f28855a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.f28855a.f28847b != null && this.f28855a.f28847b.f14241i) {
                    String c2 = this.f28855a.f28847b.c();
                    if (!StringUtils.isNULL(c2)) {
                        this.f28855a.B(c2);
                    }
                    this.f28855a.f28847b.f14241i = false;
                }
                if (this.f28855a.f28846a == null || !this.f28855a.f28846a.isBannerViewShowing() || this.f28855a.f28848c) {
                    return;
                }
                this.f28855a.f28848c = true;
                this.f28855a.f28851f.a(this.f28855a.f28849d, this.f28855a.f28846a);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f28856a;

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
            this.f28856a = gVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28856a.A();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f28856a.y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28857a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-404883584, "Lc/a/q0/x2/g$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-404883584, "Lc/a/q0/x2/g$c;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f28857a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28857a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(57679199, "Lc/a/q0/x2/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(57679199, "Lc/a/q0/x2/g;");
                return;
            }
        }
        f28845j = Pattern.compile("(/p/){1}(\\d+)");
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
        this.f28846a = null;
        this.f28848c = false;
        this.f28854i = new b(this);
    }

    public final void A() {
        BannerView bannerView;
        a.InterfaceC0827a interfaceC0827a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bannerView = this.f28846a) == null || (interfaceC0827a = this.f28851f) == null) {
            return;
        }
        this.f28848c = false;
        interfaceC0827a.b(this.f28849d, bannerView);
        this.f28846a = null;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = c.a.q0.i3.k0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f28853h, this.f28852g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, this.f28847b.b());
        b2.f();
    }

    public final void C(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = c.a.q0.i3.k0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f28853h, this.f28852g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, str2);
        b2.f();
    }

    @Override // c.a.q0.f.a.a
    public void a(int i2) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (bannerView = this.f28846a) == null) {
            return;
        }
        bannerView.onChangeSkin();
    }

    @Override // c.a.q0.f.e.a
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        this.f28852g = map.get("forum_name");
        this.f28853h = map.get("forum_id");
    }

    @Override // c.a.q0.f.a.a
    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, obj) == null) && (obj instanceof g0)) {
            this.f28847b = (g0) obj;
        }
    }

    @Override // c.a.q0.f.a.a
    public void g(a.InterfaceC0827a interfaceC0827a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0827a) == null) {
            this.f28851f = interfaceC0827a;
        }
    }

    @Override // c.a.q0.f.a.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28846a : (View) invokeV.objValue;
    }

    @Override // c.a.q0.f.a.a
    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f28850e == null || this.f28851f == null) {
            return;
        }
        g0 g0Var = this.f28847b;
        if (g0Var == null) {
            A();
        } else if (!g0Var.f()) {
            A();
        } else {
            if (!this.f28848c) {
                if (this.f28846a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f28850e.getPageActivity());
                this.f28846a = bannerView;
                bannerView.setVisibility(8);
                this.f28846a.setBannerViewClickListener(this.f28854i);
                this.f28846a.setBannerViewEvent(new a(this));
                if (this.f28847b.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f28850e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f28851f.a(this.f28849d, this.f28846a);
            }
            this.f28846a.setBannerData(this.f28847b);
            this.f28846a.reset();
            if (this.f28847b.d() != 1 || TextUtils.isEmpty(this.f28847b.b())) {
                return;
            }
            this.f28846a.setData(this.f28850e, this.f28847b.b());
        }
    }

    @Override // c.a.q0.f.a.a
    public void k(int i2) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (bannerView = this.f28846a) == null) {
            return;
        }
        bannerView.setBannerMaskColor(i2);
    }

    public final void y() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (g0Var = this.f28847b) == null) {
            return;
        }
        String e2 = g0Var.e();
        String c2 = this.f28847b.c();
        if (this.f28847b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f28850e.getPageActivity(), e2, false, BannerView.FRS_BANNER)));
            C(c2, e2);
        } else if (this.f28847b.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = f28845j.matcher(e2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f28850e.getPageActivity()).createNormalCfg(matcher.group(2), null, BannerView.FRS_BANNER);
                        createNormalCfg.setVideo_source("frs");
                        this.f28850e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        C(c2, e2);
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f28847b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = c.f28857a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f28850e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f28850e.getPageActivity()).createNormalCfg(isNativeAddress.id, BannerView.FRS_BANNER)));
                } else if (i2 == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f28850e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, BannerView.FRS_BANNER);
                    createNormalCfg2.setVideo_source("frs");
                    this.f28850e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                y.o().e().c(this.f28850e.getPageActivity(), new String[]{e2}, null);
                if (!StringUtils.isNull(e2) && e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f28850e.getPageActivity(), BannerView.FRS_BANNER, PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            C(c2, e2);
        } else if (this.f28847b.a() == 4) {
            this.f28850e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f28850e.getPageActivity()).createNormalCfg(e2, BannerView.FRS_BANNER)));
            C(c2, e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.f.e.a
    /* renamed from: z */
    public void o(c.a.q0.f.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f28849d = cVar;
            if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
                return;
            }
            this.f28850e = (TbPageContext) this.f28849d.a();
        }
    }
}
