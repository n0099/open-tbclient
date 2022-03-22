package c.a.p0.x1;

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
import c.a.a0.d.e.b;
import c.a.d.f.p.n;
import c.a.o0.a.e;
import c.a.o0.s.c.w;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean l = true;
    public static volatile c m;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f20641b;

    /* renamed from: c  reason: collision with root package name */
    public View f20642c;

    /* renamed from: d  reason: collision with root package name */
    public NadInsertingBaseView f20643d;

    /* renamed from: e  reason: collision with root package name */
    public RoundRelativeLayout f20644e;

    /* renamed from: f  reason: collision with root package name */
    public RoundRelativeLayout f20645f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20646g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20647h;
    public boolean i;
    public InterfaceC1545c j;
    public c.a.a0.d.e.a k;

    /* loaded from: classes3.dex */
    public class a implements c.a.a0.d.e.a {
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

        @Override // c.a.a0.d.e.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.a0.d.e.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.a0.d.e.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK);
                statisticItem.param("obj_type", "a002").param("obj_source", 1);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // c.a.a0.d.e.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.f20646g != null) {
                    this.a.f20646g.setVisibility(8);
                }
                this.a.j();
                this.a.f20643d = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921667, Boolean.TRUE));
                if (this.a.f20647h) {
                    this.a.f20647h = false;
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME);
                statisticItem.param("obj_type", "a002").param("obj_param1", 1).param("obj_source", 1);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // c.a.a0.d.e.a
        public void onShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_type", "a002");
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* loaded from: classes3.dex */
        public class a implements NadRequester.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: c.a.p0.x1.c$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C1544a implements b.d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C1544a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // c.a.a0.d.e.b.d
                public void a(@NonNull NadInsertingBaseView nadInsertingBaseView) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, nadInsertingBaseView) == null) {
                        this.a.a.a.f20643d = nadInsertingBaseView;
                        if (this.a.a.a.j != null) {
                            this.a.a.a.j.a();
                        }
                    }
                }

                @Override // c.a.a0.d.e.b.d
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                    c.a.a0.d.e.b.b(this.a.a.f20641b, this.a.a.f20644e, list, this.a.a.k, new C1544a(this));
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.a0.d.e.b.a("1638177515997", new a(this));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* renamed from: c.a.p0.x1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1545c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1685161051, "Lc/a/p0/x1/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1685161051, "Lc/a/p0/x1/c;");
        }
    }

    public c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20647h = false;
        this.i = false;
        this.k = new a(this);
        this.f20641b = activity;
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
            return !StringUtils.isNull(clipBoardContent) && e.j.matcher(clipBoardContent).find();
        }
        return invokeV.booleanValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20644e == null || this.f20645f == null) {
            return;
        }
        if (TbadkSettings.getInst().loadInt("skin_", 0) == 1) {
            this.f20644e.post(new Runnable() { // from class: c.a.p0.x1.b
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
            this.f20645f.setVisibility(8);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long m2 = c.a.o0.r.j0.b.k().m("key_home_insert_ad_show_time", 0L);
            int l2 = c.a.o0.r.j0.b.k().l("key_home_insert_ad_show_num", 0);
            if (StringHelper.isTaday(m2)) {
                c.a.o0.r.j0.b.k().w("key_home_insert_ad_show_num", l2 + 1);
                return;
            }
            c.a.o0.r.j0.b.k().x("key_home_insert_ad_show_time", System.currentTimeMillis());
            c.a.o0.r.j0.b.k().w("key_home_insert_ad_show_num", 1);
        }
    }

    public void C(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            if (this.f20643d != null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog == null || !alertDialog.isShowing()) {
                    if (!r(i, i2)) {
                        this.f20643d = null;
                        return;
                    }
                    RoundRelativeLayout roundRelativeLayout = this.f20644e;
                    if (roundRelativeLayout != null) {
                        roundRelativeLayout.setVisibility(0);
                    }
                    ImageView imageView = this.f20646g;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    this.f20643d.g();
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
            this.i = true;
        }
    }

    public void D() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (activity = this.f20641b) == null || activity.isFinishing()) {
            return;
        }
        AlertDialog alertDialog = this.a;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.a.dismiss();
        }
        if (this.a == null) {
            this.a = new AlertDialog.Builder(this.f20641b).create();
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
        View view = this.f20642c;
        if (view != null) {
            this.a.setContentView(view);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f20643d == null) {
            return;
        }
        this.f20647h = true;
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME);
        statisticItem.param("obj_type", "a002").param("obj_param1", 2).param("obj_source", 1);
        TiebaStatic.log(statisticItem);
        this.f20643d.a();
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
            View inflate = LayoutInflater.from(this.f20641b).inflate(R.layout.obfuscated_res_0x7f0d003b, (ViewGroup) null);
            this.f20642c = inflate;
            this.f20644e = (RoundRelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090d77);
            this.f20645f = (RoundRelativeLayout) this.f20642c.findViewById(R.id.obfuscated_res_0x7f090d78);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20644e.getLayoutParams();
            layoutParams.width = (n.k(this.f20641b) * 837) / 1076;
            layoutParams.height = -2;
            this.f20644e.setLayoutParams(layoutParams);
            this.f20644e.setRoundLayoutRadius(c.a.o0.r.v.a.y(R.string.J_X06));
            this.f20645f.setRoundLayoutRadius(c.a.o0.r.v.a.y(R.string.J_X06));
            ImageView imageView = (ImageView) this.f20642c.findViewById(R.id.obfuscated_res_0x7f090d76);
            this.f20646g = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.x1.a
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

    public final boolean n(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) {
            return o() && i == i2 && TbadkCoreApplication.getInst().getHomeBarShowType() == 1;
        }
        return invokeII.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int h2 = c.a.d.a.b.g().h();
            Activity f2 = c.a.d.a.b.g().f(h2 - 1);
            String localClassName = f2 != null ? f2.getLocalClassName() : "";
            if (StringUtils.isNull(localClassName) || !localClassName.contains("MainTabActivity")) {
                Activity f3 = c.a.d.a.b.g().f(h2 - 2);
                String localClassName2 = f3 != null ? f3.getLocalClassName() : "";
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
            if (UbsABTestHelper.isRequestInsertAd() && PermissionUtil.isAgreePrivacyPolicy() && !t()) {
                w homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                return (u() || (homeInsertAdData != null && homeInsertAdData.b() == 0) || s()) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean q(int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            AlertDialog alertDialog = this.a;
            if ((alertDialog == null || !alertDialog.isShowing()) && p() && n(i, i2)) {
                w homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                return (((System.currentTimeMillis() - j) / 1000) > ((long) (homeInsertAdData != null ? homeInsertAdData.c() : 30)) ? 1 : (((System.currentTimeMillis() - j) / 1000) == ((long) (homeInsertAdData != null ? homeInsertAdData.c() : 30)) ? 0 : -1)) > 0;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean r(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i, i2)) == null) ? (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || TbSingleton.getInstance().getExceptInsertAdDiaShow() || t() || !n(i, i2) || s()) ? false : true : invokeII.booleanValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (StringHelper.isTaday(c.a.o0.r.j0.b.k().m("key_home_insert_ad_show_time", 0L))) {
                int l2 = c.a.o0.r.j0.b.k().l("key_home_insert_ad_show_num", 0);
                w homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
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
        int width = this.f20644e.getWidth();
        int height = this.f20644e.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20645f.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.f20645f.setLayoutParams(layoutParams);
        this.f20645f.setVisibility(0);
        c.a.o0.r.v.c.d(this.f20645f).f(R.color.CAM_X0503);
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            m = null;
            j();
        }
    }

    public boolean y(String str, int i, int i2, long j, InterfaceC1545c interfaceC1545c, boolean z) {
        InterceptResult invokeCommon;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), interfaceC1545c, Boolean.valueOf(z)})) == null) {
            this.i = z;
            this.j = interfaceC1545c;
            if ("1".equals(str)) {
                q = p();
            } else {
                q = q(i, i2, j);
            }
            if (q) {
                return z(str, i, i2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean z(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, str, i, i2)) == null) {
            Activity activity = this.f20641b;
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
