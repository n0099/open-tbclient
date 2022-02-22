package c.a.u0.w1;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.d0.d.n.b;
import c.a.t0.a.e;
import c.a.t0.b.d;
import c.a.t0.t.c.y;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.inserting.NadInsertingBaseView;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.requester.NadRequester;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean l = true;
    public static volatile c m;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f24956b;

    /* renamed from: c  reason: collision with root package name */
    public View f24957c;

    /* renamed from: d  reason: collision with root package name */
    public NadInsertingBaseView f24958d;

    /* renamed from: e  reason: collision with root package name */
    public RoundRelativeLayout f24959e;

    /* renamed from: f  reason: collision with root package name */
    public RoundRelativeLayout f24960f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f24961g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24962h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24963i;

    /* renamed from: j  reason: collision with root package name */
    public InterfaceC1509c f24964j;
    public c.a.d0.d.n.a k;

    /* loaded from: classes9.dex */
    public class a implements c.a.d0.d.n.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.d0.d.n.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.d0.d.n.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.d0.d.n.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK);
                statisticItem.param("obj_type", "a002").param("obj_source", 1);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // c.a.d0.d.n.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.f24961g != null) {
                    this.a.f24961g.setVisibility(8);
                }
                this.a.j();
                this.a.f24958d = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921667, Boolean.TRUE));
                if (this.a.f24962h) {
                    this.a.f24962h = false;
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME);
                statisticItem.param("obj_type", "a002").param("obj_param1", 1).param("obj_source", 1);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // c.a.d0.d.n.a
        public void onShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_type", "a002");
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* loaded from: classes9.dex */
        public class a implements NadRequester.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: c.a.u0.w1.c$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1508a implements b.d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C1508a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // c.a.d0.d.n.b.d
                public void a(@NonNull NadInsertingBaseView nadInsertingBaseView) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, nadInsertingBaseView) == null) {
                        this.a.a.a.f24958d = nadInsertingBaseView;
                        if (this.a.a.a.f24964j != null) {
                            this.a.a.a.f24964j.a();
                        }
                    }
                }

                @Override // c.a.d0.d.n.b.d
                public void onFail() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }
            }

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
                this.a = bVar;
            }

            @Override // com.baidu.nadcore.requester.NadRequester.b
            public void a(@NonNull NadRequester.Error error) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, error) == null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST);
                    statisticItem.param("obj_type", "a002").param("obj_locate", 1).param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                }
            }

            @Override // com.baidu.nadcore.requester.NadRequester.b
            public void b(@NonNull List<AdBaseModel> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                    c.a.d0.d.n.b.b(this.a.a.f24956b, this.a.a.f24959e, list, this.a.a.k, new C1508a(this));
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST);
                    statisticItem.param("obj_type", "a002").param("obj_locate", 0).param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.d0.d.n.b.a("1638177515997", new a(this));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* renamed from: c.a.u0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1509c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1561967489, "Lc/a/u0/w1/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1561967489, "Lc/a/u0/w1/c;");
        }
    }

    public c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f24962h = false;
        this.f24963i = false;
        this.k = new a(this);
        this.f24956b = activity;
        m();
    }

    public static c k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) {
            if (m == null) {
                synchronized (c.class) {
                    if (m == null) {
                        m = new c(activity);
                    }
                }
            }
            return m;
        }
        return (c) invokeL.objValue;
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String clipBoardContent = UtilHelper.getClipBoardContent();
            return !StringUtils.isNull(clipBoardContent) && e.f12345i.matcher(clipBoardContent).find();
        }
        return invokeV.booleanValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24959e == null || this.f24960f == null) {
            return;
        }
        if (TbadkSettings.getInst().loadInt("skin_", 0) == 1) {
            this.f24959e.post(new Runnable() { // from class: c.a.u0.w1.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.this.w();
                    }
                }
            });
        } else {
            this.f24960f.setVisibility(8);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long m2 = c.a.t0.s.j0.b.k().m("key_home_insert_ad_show_time", 0L);
            int l2 = c.a.t0.s.j0.b.k().l("key_home_insert_ad_show_num", 0);
            if (StringHelper.isTaday(m2)) {
                c.a.t0.s.j0.b.k().w("key_home_insert_ad_show_num", l2 + 1);
                return;
            }
            c.a.t0.s.j0.b.k().x("key_home_insert_ad_show_time", System.currentTimeMillis());
            c.a.t0.s.j0.b.k().w("key_home_insert_ad_show_num", 1);
        }
    }

    public void C(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f24958d != null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog == null || !alertDialog.isShowing()) {
                    if (!r(i2, i3)) {
                        this.f24958d = null;
                        return;
                    }
                    RoundRelativeLayout roundRelativeLayout = this.f24959e;
                    if (roundRelativeLayout != null) {
                        roundRelativeLayout.setVisibility(0);
                    }
                    ImageView imageView = this.f24961g;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    this.f24958d.showAd();
                    D();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921667, Boolean.FALSE));
                    B();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.SHOW_AD_TIME);
                    statisticItem.param("obj_type", "a002").param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            this.f24963i = true;
        }
    }

    public void D() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (activity = this.f24956b) == null || activity.isFinishing()) {
            return;
        }
        if (this.a == null) {
            this.a = new AlertDialog.Builder(this.f24956b).create();
        }
        this.a.setCancelable(true);
        this.a.show();
        Window window = this.a.getWindow();
        window.getDecorView().setSystemUiVisibility(l());
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setNavigationBarColor(0);
        window.setAttributes(attributes);
        A();
        View view = this.f24957c;
        if (view != null) {
            this.a.setContentView(view);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f24958d == null) {
            return;
        }
        this.f24962h = true;
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME);
        statisticItem.param("obj_type", "a002").param("obj_param1", 2).param("obj_source", 1);
        TiebaStatic.log(statisticItem);
        this.f24958d.closeAd();
    }

    public final void j() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (alertDialog = this.a) != null && alertDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 1280;
        }
        return invokeV.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View inflate = LayoutInflater.from(this.f24956b).inflate(h.activity_inserting_view, (ViewGroup) null);
            this.f24957c = inflate;
            this.f24959e = (RoundRelativeLayout) inflate.findViewById(g.home_insert_container);
            this.f24960f = (RoundRelativeLayout) this.f24957c.findViewById(g.home_insert_container_cover);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24959e.getLayoutParams();
            layoutParams.width = (n.k(this.f24956b) * 837) / 1076;
            layoutParams.height = -2;
            this.f24959e.setLayoutParams(layoutParams);
            this.f24959e.setRoundLayoutRadius(c.a.t0.s.v.a.y(j.J_X06));
            this.f24960f.setRoundLayoutRadius(c.a.t0.s.v.a.y(j.J_X06));
            ImageView imageView = (ImageView) this.f24957c.findViewById(g.home_insert_close_icon);
            this.f24961g = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: c.a.u0.w1.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        c.this.v(view);
                    }
                }
            });
        }
    }

    public final boolean n(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            return o() && i2 == i3 && TbadkCoreApplication.getInst().getHomeBarShowType() == 1;
        }
        return invokeII.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int g2 = c.a.d.a.b.f().g();
            Activity e2 = c.a.d.a.b.f().e(g2 - 1);
            String localClassName = e2 != null ? e2.getLocalClassName() : "";
            if (StringUtils.isNull(localClassName) || !localClassName.contains("MainTabActivity")) {
                Activity e3 = c.a.d.a.b.f().e(g2 - 2);
                String localClassName2 = e3 != null ? e3.getLocalClassName() : "";
                return !StringUtils.isNull(localClassName) && !StringUtils.isNull(localClassName2) && localClassName.contains("LogoActivity") && localClassName2.contains("MainTabActivity");
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (d.i0() && PermissionUtil.isAgreePrivacyPolicy() && !c.a.t0.g1.b.c.d() && !t()) {
                y homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                return (u() || (homeInsertAdData != null && homeInsertAdData.b() == 0) || s()) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean q(int i2, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            AlertDialog alertDialog = this.a;
            if ((alertDialog == null || !alertDialog.isShowing()) && p() && n(i2, i3)) {
                y homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                return (((System.currentTimeMillis() - j2) / 1000) > ((long) (homeInsertAdData != null ? homeInsertAdData.c() : 30)) ? 1 : (((System.currentTimeMillis() - j2) / 1000) == ((long) (homeInsertAdData != null ? homeInsertAdData.c() : 30)) ? 0 : -1)) > 0;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean r(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) ? (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || TbSingleton.getInstance().getExceptInsertAdDiaShow() || t() || !n(i2, i3) || s()) ? false : true : invokeII.booleanValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (StringHelper.isTaday(c.a.t0.s.j0.b.k().m("key_home_insert_ad_show_time", 0L))) {
                int l2 = c.a.t0.s.j0.b.k().l("key_home_insert_ad_show_num", 0);
                y homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                if (l2 >= (homeInsertAdData != null ? homeInsertAdData.a() : 1)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ void v(View view) {
        i();
    }

    public /* synthetic */ void w() {
        int width = this.f24959e.getWidth();
        int height = this.f24959e.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24960f.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.f24960f.setLayoutParams(layoutParams);
        this.f24960f.setVisibility(0);
        c.a.t0.s.v.c.d(this.f24960f).f(c.a.u0.a4.d.CAM_X0503);
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            m = null;
            j();
        }
    }

    public boolean y(String str, int i2, int i3, long j2, InterfaceC1509c interfaceC1509c, boolean z) {
        InterceptResult invokeCommon;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), interfaceC1509c, Boolean.valueOf(z)})) == null) {
            this.f24963i = z;
            this.f24964j = interfaceC1509c;
            if ("1".equals(str)) {
                q = p();
            } else {
                q = q(i2, i3, j2);
            }
            if (q) {
                return z(str, i2, i3);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean z(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, str, i2, i3)) == null) {
            Activity activity = this.f24956b;
            if (activity == null || activity.isFinishing()) {
                return false;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.REQUEST_AD_TIME);
            statisticItem.param("obj_type", "a002").param("obj_param1", str);
            TiebaStatic.log(statisticItem);
            new b(this).execute(new Void[0]);
            return true;
        }
        return invokeLII.booleanValue;
    }
}
