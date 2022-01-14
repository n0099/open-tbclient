package c.a.t0.j3;

import android.text.TextUtils;
import android.view.View;
import c.a.s0.s.q.g0;
import c.a.t0.h.a.a;
import c.a.t0.w3.l0.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public class g implements c.a.t0.h.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f18374j;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerView a;

    /* renamed from: b  reason: collision with root package name */
    public g0 f18375b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18376c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.h.e.c f18377d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f18378e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1120a f18379f;

    /* renamed from: g  reason: collision with root package name */
    public String f18380g;

    /* renamed from: h  reason: collision with root package name */
    public String f18381h;

    /* renamed from: i  reason: collision with root package name */
    public BannerView.b f18382i;

    /* loaded from: classes7.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.a.f18375b != null && this.a.f18375b.f13393i) {
                    String c2 = this.a.f18375b.c();
                    if (!StringUtils.isNULL(c2)) {
                        this.a.A(c2);
                    }
                    this.a.f18375b.f13393i = false;
                }
                if (this.a.a == null || !this.a.a.isBannerViewShowing() || this.a.f18376c) {
                    return;
                }
                this.a.f18376c = true;
                this.a.f18379f.a(this.a.f18377d, this.a.a);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-505944594, "Lc/a/t0/j3/g$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-505944594, "Lc/a/t0/j3/g$c;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(978243405, "Lc/a/t0/j3/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(978243405, "Lc/a/t0/j3/g;");
                return;
            }
        }
        f18374j = Pattern.compile("(/p/){1}(\\d+)");
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
        this.a = null;
        this.f18376c = false;
        this.f18382i = new b(this);
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = c.a.t0.w3.l0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f18381h, this.f18380g, null);
        b2.d(TiebaStatic.Params.OBJ_URL, this.f18375b.b());
        b2.e();
    }

    public final void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = c.a.t0.w3.l0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f18381h, this.f18380g, null);
        b2.d(TiebaStatic.Params.OBJ_URL, str2);
        b2.e();
    }

    @Override // c.a.t0.h.a.a
    public void a(int i2) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (bannerView = this.a) == null) {
            return;
        }
        bannerView.onChangeSkin();
    }

    @Override // c.a.t0.h.a.a
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && (obj instanceof g0)) {
            this.f18375b = (g0) obj;
        }
    }

    @Override // c.a.t0.h.a.a
    public void f(a.InterfaceC1120a interfaceC1120a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC1120a) == null) {
            this.f18379f = interfaceC1120a;
        }
    }

    @Override // c.a.t0.h.a.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // c.a.t0.h.a.a
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f18378e == null || this.f18379f == null) {
            return;
        }
        g0 g0Var = this.f18375b;
        if (g0Var == null) {
            z();
        } else if (!g0Var.e()) {
            z();
        } else {
            if (!this.f18376c) {
                if (this.a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f18378e.getPageActivity());
                this.a = bannerView;
                bannerView.setVisibility(8);
                this.a.setBannerViewClickListener(this.f18382i);
                this.a.setBannerViewEvent(new a(this));
                if (this.f18375b.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f18378e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f18379f.a(this.f18377d, this.a);
            }
            this.a.setBannerData(this.f18375b);
            this.a.reset();
            if (this.f18375b.getType() != 1 || TextUtils.isEmpty(this.f18375b.b())) {
                return;
            }
            this.a.setData(this.f18378e, this.f18375b.b());
        }
    }

    @Override // c.a.t0.h.a.a
    public void j(int i2) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (bannerView = this.a) == null) {
            return;
        }
        bannerView.setBannerMaskColor(i2);
    }

    @Override // c.a.t0.h.e.a
    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        this.f18380g = map.get("forum_name");
        this.f18381h = map.get("forum_id");
    }

    public final void x() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (g0Var = this.f18375b) == null) {
            return;
        }
        String d2 = g0Var.d();
        String c2 = this.f18375b.c();
        if (this.f18375b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f18378e.getPageActivity(), d2, false, BannerView.FRS_BANNER)));
            B(c2, d2);
        } else if (this.f18375b.a() == 2) {
            if (d2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = f18374j.matcher(d2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f18378e.getPageActivity()).createNormalCfg(matcher.group(2), null, BannerView.FRS_BANNER);
                        createNormalCfg.setVideo_source("frs");
                        this.f18378e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        B(c2, d2);
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
            }
        } else if (this.f18375b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = c.a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f18378e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18378e.getPageActivity()).createNormalCfg(isNativeAddress.id, BannerView.FRS_BANNER)));
                } else if (i2 == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f18378e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, BannerView.FRS_BANNER);
                    createNormalCfg2.setVideo_source("frs");
                    this.f18378e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                y.q().e().c(this.f18378e.getPageActivity(), new String[]{d2}, null);
                if (!StringUtils.isNull(d2) && d2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f18378e.getPageActivity(), BannerView.FRS_BANNER, "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            B(c2, d2);
        } else if (this.f18375b.a() == 4) {
            this.f18378e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18378e.getPageActivity()).createNormalCfg(d2, BannerView.FRS_BANNER)));
            B(c2, d2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.h.e.a
    /* renamed from: y */
    public void n(c.a.t0.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f18377d = cVar;
            if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
                return;
            }
            this.f18378e = (TbPageContext) this.f18377d.a();
        }
    }

    public final void z() {
        BannerView bannerView;
        a.InterfaceC1120a interfaceC1120a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bannerView = this.a) == null || (interfaceC1120a = this.f18379f) == null) {
            return;
        }
        this.f18376c = false;
        interfaceC1120a.b(this.f18377d, bannerView);
        this.a = null;
    }
}
