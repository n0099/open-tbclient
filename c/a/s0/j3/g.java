package c.a.s0.j3;

import android.text.TextUtils;
import android.view.View;
import c.a.r0.s.r.g0;
import c.a.s0.h.a.a;
import c.a.s0.v3.l0.a;
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
public class g implements c.a.s0.h.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f18370j;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerView a;

    /* renamed from: b  reason: collision with root package name */
    public g0 f18371b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18372c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.h.e.c f18373d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f18374e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1079a f18375f;

    /* renamed from: g  reason: collision with root package name */
    public String f18376g;

    /* renamed from: h  reason: collision with root package name */
    public String f18377h;

    /* renamed from: i  reason: collision with root package name */
    public BannerView.b f18378i;

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
                if (this.a.f18371b != null && this.a.f18371b.f13333i) {
                    String c2 = this.a.f18371b.c();
                    if (!StringUtils.isNULL(c2)) {
                        this.a.A(c2);
                    }
                    this.a.f18371b.f13333i = false;
                }
                if (this.a.a == null || !this.a.a.isBannerViewShowing() || this.a.f18372c) {
                    return;
                }
                this.a.f18372c = true;
                this.a.f18375f.a(this.a.f18373d, this.a.a);
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-309431089, "Lc/a/s0/j3/g$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-309431089, "Lc/a/s0/j3/g$c;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-764566930, "Lc/a/s0/j3/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-764566930, "Lc/a/s0/j3/g;");
                return;
            }
        }
        f18370j = Pattern.compile("(/p/){1}(\\d+)");
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
        this.f18372c = false;
        this.f18378i = new b(this);
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = c.a.s0.v3.l0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f18377h, this.f18376g, null);
        b2.d(TiebaStatic.Params.OBJ_URL, this.f18371b.b());
        b2.e();
    }

    public final void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = c.a.s0.v3.l0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f18377h, this.f18376g, null);
        b2.d(TiebaStatic.Params.OBJ_URL, str2);
        b2.e();
    }

    @Override // c.a.s0.h.a.a
    public void a(int i2) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (bannerView = this.a) == null) {
            return;
        }
        bannerView.onChangeSkin();
    }

    @Override // c.a.s0.h.a.a
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && (obj instanceof g0)) {
            this.f18371b = (g0) obj;
        }
    }

    @Override // c.a.s0.h.a.a
    public void f(a.InterfaceC1079a interfaceC1079a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC1079a) == null) {
            this.f18375f = interfaceC1079a;
        }
    }

    @Override // c.a.s0.h.a.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // c.a.s0.h.a.a
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f18374e == null || this.f18375f == null) {
            return;
        }
        g0 g0Var = this.f18371b;
        if (g0Var == null) {
            z();
        } else if (!g0Var.e()) {
            z();
        } else {
            if (!this.f18372c) {
                if (this.a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f18374e.getPageActivity());
                this.a = bannerView;
                bannerView.setVisibility(8);
                this.a.setBannerViewClickListener(this.f18378i);
                this.a.setBannerViewEvent(new a(this));
                if (this.f18371b.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f18374e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f18375f.a(this.f18373d, this.a);
            }
            this.a.setBannerData(this.f18371b);
            this.a.reset();
            if (this.f18371b.getType() != 1 || TextUtils.isEmpty(this.f18371b.b())) {
                return;
            }
            this.a.setData(this.f18374e, this.f18371b.b());
        }
    }

    @Override // c.a.s0.h.a.a
    public void j(int i2) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (bannerView = this.a) == null) {
            return;
        }
        bannerView.setBannerMaskColor(i2);
    }

    @Override // c.a.s0.h.e.a
    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        this.f18376g = map.get("forum_name");
        this.f18377h = map.get("forum_id");
    }

    public final void x() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (g0Var = this.f18371b) == null) {
            return;
        }
        String d2 = g0Var.d();
        String c2 = this.f18371b.c();
        if (this.f18371b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f18374e.getPageActivity(), d2, false, BannerView.FRS_BANNER)));
            B(c2, d2);
        } else if (this.f18371b.a() == 2) {
            if (d2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = f18370j.matcher(d2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f18374e.getPageActivity()).createNormalCfg(matcher.group(2), null, BannerView.FRS_BANNER);
                        createNormalCfg.setVideo_source("frs");
                        this.f18374e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        B(c2, d2);
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
            }
        } else if (this.f18371b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = c.a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f18374e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18374e.getPageActivity()).createNormalCfg(isNativeAddress.id, BannerView.FRS_BANNER)));
                } else if (i2 == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f18374e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, BannerView.FRS_BANNER);
                    createNormalCfg2.setVideo_source("frs");
                    this.f18374e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                y.q().e().c(this.f18374e.getPageActivity(), new String[]{d2}, null);
                if (!StringUtils.isNull(d2) && d2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f18374e.getPageActivity(), BannerView.FRS_BANNER, "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            B(c2, d2);
        } else if (this.f18371b.a() == 4) {
            this.f18374e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18374e.getPageActivity()).createNormalCfg(d2, BannerView.FRS_BANNER)));
            B(c2, d2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.h.e.a
    /* renamed from: y */
    public void n(c.a.s0.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f18373d = cVar;
            if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
                return;
            }
            this.f18374e = (TbPageContext) this.f18373d.a();
        }
    }

    public final void z() {
        BannerView bannerView;
        a.InterfaceC1079a interfaceC1079a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bannerView = this.a) == null || (interfaceC1079a = this.f18375f) == null) {
            return;
        }
        this.f18372c = false;
        interfaceC1079a.b(this.f18373d, bannerView);
        this.a = null;
    }
}
