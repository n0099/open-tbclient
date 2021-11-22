package b.a.r0.u.a;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.q0.c1.t0;
import b.a.q0.q0.j;
import b.a.r0.r.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes5.dex */
public class e implements b.a.r0.u.a.h.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile b.a.f0.b.g.d f25399f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f25400g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b.a.f0.b.d f25401h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f25402b;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f25403c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f25404d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.l.a f25405e;

    /* loaded from: classes5.dex */
    public class a implements b.a.f0.b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f25406a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25406a = eVar;
        }

        @Override // b.a.f0.b.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                boolean z = b.a.r0.u.a.h.b.f25428a;
                if (e.f25399f != null) {
                    int i2 = 1;
                    boolean z2 = e.f25399f.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                    boolean z3 = e.f25399f.g().optInt("full_type", 0) == 1;
                    if (z3 && z2) {
                        i2 = 4;
                    } else if (z2) {
                        i2 = 3;
                    } else if (z3) {
                        i2 = 2;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 5).param("obj_type", i2));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f25406a.getClass().getSimpleName()).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, this.f25406a.f25405e != null ? this.f25406a.f25405e.hashCode() : 0));
            }
        }

        @Override // b.a.f0.b.d
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f25438c, str, 0);
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f25438c, "1");
                if (b.a.r0.u.a.h.b.f25428a) {
                    String str2 = "prologue ad loaded failed: " + str;
                }
                if (BdLog.isDebugMode()) {
                    BdLog.e("");
                }
                this.f25406a.f25403c = AdLoadState.FAILED;
                b.a.r0.u.a.h.a.c().h(this.f25406a.f25405e);
                f("advert_show", 0);
            }
        }

        @Override // b.a.f0.b.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = b.a.r0.u.a.h.b.f25428a;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f25406a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.f25406a.f25405e == null ? 0 : this.f25406a.f25405e.hashCode()));
                if (this.f25406a.f25405e != null) {
                    this.f25406a.f25405e.onAdDismiss();
                }
            }
        }

        @Override // b.a.f0.b.d
        public void d(b.a.j0.a.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f25438c, "0", 0);
                boolean z = b.a.r0.u.a.h.b.f25428a;
                this.f25406a.f25403c = AdLoadState.SUCCEED;
                b.a.r0.u.a.h.a.c().h(this.f25406a.f25405e);
                f("advert_load", 1);
            }
        }

        @Override // b.a.f0.b.d
        @NonNull
        public ViewGroup e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (ViewGroup) this.f25406a.f25404d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void f(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
                b.a.e.f.n.a a2 = j.a();
                a2.b("type", "prologue");
                a2.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(b.a.r0.u.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // b.a.f0.b.d
        public void onAdClick() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                boolean z3 = b.a.r0.u.a.h.b.f25428a;
                if (this.f25406a.f25405e != null) {
                    if (e.f25399f == null || e.f25399f.g() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = e.f25399f.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = e.f25399f.g().optInt("full_type", 0) == 1;
                    }
                    this.f25406a.f25405e.a(z, z2, this.f25406a.f25402b, null, null);
                }
            }
        }

        @Override // b.a.f0.b.d
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                boolean z = b.a.r0.u.a.h.b.f25428a;
                if (this.f25406a.f25405e != null) {
                    this.f25406a.f25405e.e(true, false, this.f25406a.f25402b);
                }
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f25438c, "0");
                f("advert_show", 1);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f25406a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.f25406a.f25405e != null ? this.f25406a.f25405e.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.a.f0.b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f25407a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.j0.a.g.d f25408e;

            public a(b bVar, b.a.j0.a.g.d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25408e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || e.f25401h == null) {
                    return;
                }
                e.f25401h.d(this.f25408e);
            }
        }

        /* renamed from: b.a.r0.u.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1226b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f25409e;

            public RunnableC1226b(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25409e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || e.f25401h == null) {
                    return;
                }
                e.f25401h.b(this.f25409e);
            }
        }

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25407a = eVar;
        }

        @Override // b.a.f0.b.d
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || e.f25401h == null) {
                return;
            }
            e.f25401h.a();
        }

        @Override // b.a.f0.b.d
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (e.f25401h == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    b.a.r0.r.b.c().a(this.f25407a.d(), "onAdLoadFailed", hashMap);
                } else if (l.C()) {
                    e.f25401h.b(str);
                } else {
                    b.a.e.f.m.e.a().post(new RunnableC1226b(this, str));
                }
            }
        }

        @Override // b.a.f0.b.d
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || e.f25401h == null) {
                return;
            }
            e.f25401h.c();
        }

        @Override // b.a.f0.b.d
        public void d(b.a.j0.a.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
                if (e.f25401h == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", dVar);
                    b.a.r0.r.b.c().a(this.f25407a.d(), "onAdLoaded", hashMap);
                } else if (l.C()) {
                    e.f25401h.d(dVar);
                } else {
                    b.a.e.f.m.e.a().post(new a(this, dVar));
                }
            }
        }

        @Override // b.a.f0.b.d
        @NonNull
        public ViewGroup e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (e.f25401h != null) {
                    return e.f25401h.e();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // b.a.f0.b.d
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || e.f25401h == null) {
                return;
            }
            e.f25401h.onAdClick();
        }

        @Override // b.a.f0.b.d
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || e.f25401h == null) {
                return;
            }
            e.f25401h.onAdShow();
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements b.a.f0.a.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Application f25410b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f25411c;

        public c(Application application) {
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
            this.f25410b = application;
        }

        @Override // b.a.f0.a.b.a
        public int A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.drawable.bg_bes_splash_logo_blue : invokeV.intValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbadkCoreApplication.getInst().getImei() : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbConfig.getVersion() : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public int D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.drawable.bg_bes_splash_logo_white : invokeV.intValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Settings.System.getString(this.f25410b.getContentResolver(), IAdRequestParam.ANDROID_ID) : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "1099a" : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return 120;
            }
            return invokeV.intValue;
        }

        @Override // b.a.f0.a.b.a
        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? R.drawable.pic_splash_logo : invokeV.intValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TbadkCoreApplication.getInst().getCuidGalaxy2() : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public String from() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "1099a" : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Build.VERSION.RELEASE : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (e.f25400g) {
                    String p = b.a.q0.s.e0.b.j().p("key_prologue_ad_useragent", "");
                    if (!TextUtils.isEmpty(p)) {
                        return p;
                    }
                }
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

        @Override // b.a.f0.a.b.a
        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                AppPosInfo a2 = b.a.r0.a3.j0.a.e().a();
                return a2 != null ? a2.coordinate_type : "";
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public JSONObject j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.f25411c == null) {
                    this.f25411c = new JSONObject();
                }
                return this.f25411c;
            }
            return (JSONObject) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (e.f25400g) {
                    String p = b.a.q0.s.e0.b.j().p("key_prologue_ad_baiduid", "");
                    if (!TextUtils.isEmpty(p)) {
                        return p;
                    }
                }
                return b.a.q0.m.a.e();
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "1481698145541" : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? b.a.r.b.f(TbadkCoreApplication.getInst()).g() : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                int[] b2 = b.a.f0.b.b.a().b();
                return TextUtils.join("_", new String[]{String.valueOf(b2[0]), String.valueOf(b2[1]), "android", C(), String.valueOf(b2[2])});
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public Application o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f25410b : (Application) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? "2" : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String packageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? TbadkCoreApplication.getInst().getPackageName() : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? Build.MODEL : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public String r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? "bb3808eb" : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? TbadkCoreApplication.getInst().isDebugMode() : invokeV.booleanValue;
        }

        @Override // b.a.f0.a.b.a
        public int t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (int) b.a.r0.u.a.j.a.e() : invokeV.intValue;
        }

        @Override // b.a.f0.a.b.a
        public String u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? "tieba" : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public boolean v(String str, b.a.f0.c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, bVar)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, str + "&extInfo=" + b.a.f0.b.g.c.f2927a));
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.a.f0.a.b.a
        @NonNull
        public String w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                return currentAccount == null ? "" : currentAccount;
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public String[] x() {
            InterceptResult invokeV;
            AppPosInfo a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                if (b.a.r0.a3.j0.a.e() != null && (a2 = b.a.r0.a3.j0.a.e().a()) != null) {
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

        @Override // b.a.f0.a.b.a
        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) ? "" : TbadkCoreApplication.getInst().getAdAdSense().q : (String) invokeV.objValue;
        }

        @Override // b.a.f0.a.b.a
        public boolean z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f25410b.getResources().getConfiguration().orientation == 2 : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(186782792, "Lb/a/r0/u/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(186782792, "Lb/a/r0/u/a/e;");
        }
    }

    public e() {
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
        this.f25402b = 5;
        this.f25403c = AdLoadState.INIT;
        this.f25405e = null;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            b.a.b.f().g(new c(TbadkCoreApplication.getInst()));
        }
    }

    @Override // b.a.r0.u.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f25400g = true;
            m(new b(this), null);
        }
    }

    @Override // b.a.r0.u.a.h.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25403c : (AdLoadState) invokeV.objValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void c(b.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        this.f25405e = dVar.a();
        this.f25404d = new WeakReference<>(dVar.b());
        a aVar = new a(this);
        f25401h = aVar;
        if (f25400g) {
            k();
            f25400g = false;
            return;
        }
        m(aVar, this.f25405e);
    }

    @Override // b.a.r0.u.a.h.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f25399f != null) {
                f25399f.f();
                f25399f = null;
            }
            f25401h = null;
        }
    }

    public final void j() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f25404d) == null || weakReference.get().getParent() == null || !(this.f25404d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25404d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f25404d.get().setLayoutParams(layoutParams);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || f25401h == null || b.a.r0.r.b.c().d(d()).isEmpty()) {
            return;
        }
        for (b.a aVar : b.a.r0.r.b.c().d(d())) {
            String str = aVar.f24467a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -610376507) {
                if (hashCode == 861234439 && str.equals("onAdLoaded")) {
                    c2 = 0;
                }
            } else if (str.equals("onAdLoadFailed")) {
                c2 = 1;
            }
            if (c2 == 0) {
                f25401h.d((b.a.j0.a.g.d) aVar.f24468b.get("data"));
            } else if (c2 == 1) {
                f25401h.b((String) aVar.f24468b.get("data"));
            }
        }
        b.a.r0.r.b.c().b(d());
    }

    public final void m(b.a.f0.b.d dVar, b.a.q0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, dVar, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                f25399f = new b.a.f0.b.g.d(context, "1481698145541", new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).build(), dVar);
                this.f25403c = AdLoadState.LOADING;
                b.a.r0.u.a.j.a.i(b.a.r0.u.a.j.a.f25438c);
                f25399f.h();
                boolean z = b.a.r0.u.a.h.b.f25428a;
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (aVar != null) {
                    aVar.b("oom");
                }
            }
        }
    }

    @Override // b.a.r0.u.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || f25399f == null || (weakReference = this.f25404d) == null || weakReference.get() == null || this.f25403c != AdLoadState.SUCCEED) {
            return;
        }
        b.a.q0.l.a aVar = this.f25405e;
        if (aVar != null) {
            aVar.d();
        }
        j();
        this.f25403c = AdLoadState.SHOWED;
        boolean z = b.a.r0.u.a.h.b.f25428a;
        f25399f.l(this.f25404d.get());
    }
}
