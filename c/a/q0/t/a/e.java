package c.a.q0.t.a;

import android.app.Application;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.b1.t0;
import c.a.p0.o0.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes3.dex */
public class e implements c.a.q0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f24456b;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f24457c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.f0.b.g.d f24458d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f24459e;

    /* loaded from: classes3.dex */
    public class a implements c.a.f0.b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.l.a f24460a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f24461b;

        public a(e eVar, c.a.p0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24461b = eVar;
            this.f24460a = aVar;
        }

        @Override // c.a.f0.b.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.q0.t.a.j.a.j(c.a.q0.t.a.j.a.f24490c, str, 0);
                c.a.q0.t.a.j.a.k(c.a.q0.t.a.j.a.f24490c, "1");
                if (c.a.q0.t.a.h.b.f24480a) {
                    String str2 = "prologue ad loaded failed: " + str;
                }
                if (BdLog.isDebugMode()) {
                    BdLog.e("");
                }
                this.f24461b.f24457c = AdLoadState.FAILED;
                e("advert_show", 0);
            }
        }

        @Override // c.a.f0.b.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = c.a.q0.t.a.h.b.f24480a;
                c.a.p0.l.a aVar = this.f24460a;
                if (aVar != null) {
                    aVar.onAdDismiss();
                }
            }
        }

        @Override // c.a.f0.b.d
        public void c(c.a.i0.a.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                c.a.q0.t.a.j.a.j(c.a.q0.t.a.j.a.f24490c, "0", 0);
                boolean z = c.a.q0.t.a.h.b.f24480a;
                this.f24461b.f24457c = AdLoadState.SUCCEED;
                c.a.q0.t.a.h.a.c().g(this.f24460a);
                e("advert_load", 1);
            }
        }

        @Override // c.a.f0.b.d
        @NonNull
        public ViewGroup d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (ViewGroup) this.f24461b.f24459e.get() : (ViewGroup) invokeV.objValue;
        }

        public final void e(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("type", "prologue");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(c.a.q0.t.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // c.a.f0.b.d
        public void onAdClick() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                boolean z3 = c.a.q0.t.a.h.b.f24480a;
                if (this.f24460a != null) {
                    if (this.f24461b.f24458d == null || this.f24461b.f24458d.g() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = this.f24461b.f24458d.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = this.f24461b.f24458d.g().optInt("full_type", 0) == 1;
                    }
                    this.f24460a.b(z, z2, this.f24461b.f24456b, null, null);
                }
            }
        }

        @Override // c.a.f0.b.d
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                boolean z = c.a.q0.t.a.h.b.f24480a;
                c.a.p0.l.a aVar = this.f24460a;
                if (aVar != null) {
                    aVar.c(true, false, this.f24461b.f24456b);
                }
                c.a.q0.t.a.j.a.k(c.a.q0.t.a.j.a.f24490c, "0");
                e("advert_show", 1);
            }
        }

        @Override // c.a.f0.b.d
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                boolean z = c.a.q0.t.a.h.b.f24480a;
                if (this.f24461b.f24458d != null) {
                    int i2 = 1;
                    boolean z2 = this.f24461b.f24458d.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                    boolean z3 = this.f24461b.f24458d.g().optInt("full_type", 0) == 1;
                    if (z3 && z2) {
                        i2 = 4;
                    } else if (z2) {
                        i2 = 3;
                    } else if (z3) {
                        i2 = 2;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 5).param("obj_type", i2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c.a.f0.a.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Application f24462b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f24463c;

        public b(Application application) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {application};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24462b = application;
        }

        @Override // c.a.f0.a.b.a
        public boolean A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24462b.getResources().getConfiguration().orientation == 2 : invokeV.booleanValue;
        }

        @Override // c.a.f0.a.b.a
        public int B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.drawable.bg_bes_splash_logo_blue : invokeV.intValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbadkCoreApplication.getInst().getImei() : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbConfig.getVersion() : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public int E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.drawable.bg_bes_splash_logo_white : invokeV.intValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Settings.System.getString(this.f24462b.getContentResolver(), IAdRequestParam.ANDROID_ID) : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "1099a" : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return 120;
            }
            return invokeV.intValue;
        }

        @Override // c.a.f0.a.b.a
        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.drawable.pic_splash_logo : invokeV.intValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? TbadkCoreApplication.getInst().getCuidGalaxy2() : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public String from() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "1099a" : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Build.VERSION.RELEASE : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                String b2 = t0.b();
                if (TextUtils.isEmpty(b2)) {
                    b2 = "bdtb for Android " + TbConfig.getVersion();
                }
                if (BdLog.isDebugMode()) {
                    BdLog.e("userAgent=" + b2);
                }
                return b2;
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TbadkCoreApplication.getInst().getPackageName() : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                AppPosInfo a2 = c.a.q0.x2.j0.a.e().a();
                return a2 != null ? a2.coordinate_type : "";
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public JSONObject k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (this.f24463c == null) {
                    this.f24463c = new JSONObject();
                }
                return this.f24463c;
            }
            return (JSONObject) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? c.a.p0.m.a.f() : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "1481698145541" : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? c.a.r.b.e(TbadkCoreApplication.getInst()).f() : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                int[] b2 = c.a.f0.b.b.a().b();
                return TextUtils.join("_", new String[]{String.valueOf(b2[0]), String.valueOf(b2[1]), "android", D(), String.valueOf(b2[2])});
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public Application p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f24462b : (Application) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? "2" : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? Build.MODEL : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public String s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? "bb3808eb" : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public boolean t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? TbadkCoreApplication.getInst().isDebugMode() : invokeV.booleanValue;
        }

        @Override // c.a.f0.a.b.a
        public int u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (int) c.a.q0.t.a.j.a.e() : invokeV.intValue;
        }

        @Override // c.a.f0.a.b.a
        public String v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? "tieba" : (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public boolean w(String str, c.a.f0.c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, bVar)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, str));
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                return currentAccount == null ? "" : currentAccount;
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public String[] y() {
            InterceptResult invokeV;
            AppPosInfo a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                if (c.a.q0.x2.j0.a.e() != null && (a2 = c.a.q0.x2.j0.a.e().a()) != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("" + a2.longitude + "|" + a2.latitude);
                    }
                    return new String[]{a2.longitude, a2.latitude};
                }
                if (BdLog.isDebugMode()) {
                    BdLog.e("0, 0");
                }
                return new String[]{"0", "0"};
            }
            return (String[]) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public String z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) ? "" : TbadkCoreApplication.getInst().getAdAdSense().q : (String) invokeV.objValue;
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24456b = 5;
        this.f24457c = AdLoadState.INIT;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c.a.b.f().g(new b(TbadkCoreApplication.getInst()));
        }
    }

    @Override // c.a.q0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24457c : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.q0.t.a.h.b
    public void b(c.a.p0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        c.a.p0.l.a a2 = dVar.a();
        this.f24459e = new WeakReference<>(dVar.b());
        try {
            this.f24458d = new c.a.f0.b.g.d(TbadkCoreApplication.getInst().getContext(), "1481698145541", new RequestParameters.Builder().setHeight(l.k(dVar.b().getContext())).setWidth(l.i(dVar.b().getContext())).build(), new a(this, a2));
            this.f24457c = AdLoadState.LOADING;
            c.a.q0.t.a.j.a.i(c.a.q0.t.a.j.a.f24490c);
            this.f24458d.h();
            boolean z = c.a.q0.t.a.h.b.f24480a;
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            a2.a("oom");
        }
    }

    @Override // c.a.q0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    @Override // c.a.q0.t.a.h.b
    public void destroy() {
        c.a.f0.b.g.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (dVar = this.f24458d) == null) {
            return;
        }
        dVar.f();
        this.f24458d = null;
    }

    public final void g() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.f24459e) == null || weakReference.get().getParent() == null || !(this.f24459e.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24459e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f24459e.get().setLayoutParams(layoutParams);
    }

    @Override // c.a.q0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f24458d == null || (weakReference = this.f24459e) == null || weakReference.get() == null || this.f24457c != AdLoadState.SUCCEED) {
            return;
        }
        g();
        this.f24457c = AdLoadState.SHOWED;
        boolean z = c.a.q0.t.a.h.b.f24480a;
        this.f24458d.l(this.f24459e.get());
    }
}
