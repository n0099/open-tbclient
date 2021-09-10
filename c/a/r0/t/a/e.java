package c.a.r0.t.a;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.d1.u0;
import c.a.q0.q0.j;
import c.a.r0.q.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.sdk.api.RequestParameters;
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
/* loaded from: classes3.dex */
public class e implements c.a.r0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile c.a.f0.b.g.d f24870e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f24871f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile c.a.f0.b.d f24872g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f24873b;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f24874c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f24875d;

    /* loaded from: classes3.dex */
    public class a implements c.a.f0.b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.l.a f24876a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f24877b;

        public a(e eVar, c.a.q0.l.a aVar) {
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
            this.f24877b = eVar;
            this.f24876a = aVar;
        }

        @Override // c.a.f0.b.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.r0.t.a.j.a.j(c.a.r0.t.a.j.a.f24910c, str, 0);
                c.a.r0.t.a.j.a.k(c.a.r0.t.a.j.a.f24910c, "1");
                if (c.a.r0.t.a.h.b.f24900a) {
                    String str2 = "prologue ad loaded failed: " + str;
                }
                if (BdLog.isDebugMode()) {
                    BdLog.e("");
                }
                this.f24877b.f24874c = AdLoadState.FAILED;
                e("advert_show", 0);
            }
        }

        @Override // c.a.f0.b.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = c.a.r0.t.a.h.b.f24900a;
                c.a.q0.l.a aVar = this.f24876a;
                if (aVar != null) {
                    aVar.onAdDismiss();
                }
            }
        }

        @Override // c.a.f0.b.d
        public void c(c.a.j0.a.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                c.a.r0.t.a.j.a.j(c.a.r0.t.a.j.a.f24910c, "0", 0);
                boolean z = c.a.r0.t.a.h.b.f24900a;
                this.f24877b.f24874c = AdLoadState.SUCCEED;
                c.a.r0.t.a.h.a.c().h(this.f24876a);
                e("advert_load", 1);
            }
        }

        @Override // c.a.f0.b.d
        @NonNull
        public ViewGroup d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (ViewGroup) this.f24877b.f24875d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void e(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("type", "prologue");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(c.a.r0.t.a.h.a.c().b()));
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
                boolean z3 = c.a.r0.t.a.h.b.f24900a;
                if (this.f24876a != null) {
                    if (e.f24870e == null || e.f24870e.g() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = e.f24870e.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = e.f24870e.g().optInt("full_type", 0) == 1;
                    }
                    this.f24876a.b(z, z2, this.f24877b.f24873b, null, null);
                }
            }
        }

        @Override // c.a.f0.b.d
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                boolean z = c.a.r0.t.a.h.b.f24900a;
                c.a.q0.l.a aVar = this.f24876a;
                if (aVar != null) {
                    aVar.c(true, false, this.f24877b.f24873b);
                }
                c.a.r0.t.a.j.a.k(c.a.r0.t.a.j.a.f24910c, "0");
                e("advert_show", 1);
            }
        }

        @Override // c.a.f0.b.d
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                boolean z = c.a.r0.t.a.h.b.f24900a;
                if (e.f24870e != null) {
                    int i2 = 1;
                    boolean z2 = e.f24870e.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                    boolean z3 = e.f24870e.g().optInt("full_type", 0) == 1;
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
    public class b implements c.a.f0.b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f24878a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.j0.a.g.d f24879e;

            public a(b bVar, c.a.j0.a.g.d dVar) {
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
                this.f24879e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || e.f24872g == null) {
                    return;
                }
                e.f24872g.c(this.f24879e);
            }
        }

        /* renamed from: c.a.r0.t.a.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1153b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f24880e;

            public RunnableC1153b(b bVar, String str) {
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
                this.f24880e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || e.f24872g == null) {
                    return;
                }
                e.f24872g.a(this.f24880e);
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
            this.f24878a = eVar;
        }

        @Override // c.a.f0.b.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (e.f24872g == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    c.a.r0.q.b.c().a(this.f24878a.d(), "onAdLoadFailed", hashMap);
                } else if (l.C()) {
                    e.f24872g.a(str);
                } else {
                    c.a.e.e.m.e.a().post(new RunnableC1153b(this, str));
                }
            }
        }

        @Override // c.a.f0.b.d
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || e.f24872g == null) {
                return;
            }
            e.f24872g.b();
        }

        @Override // c.a.f0.b.d
        public void c(c.a.j0.a.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                if (e.f24872g == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", dVar);
                    c.a.r0.q.b.c().a(this.f24878a.d(), "onAdLoaded", hashMap);
                } else if (l.C()) {
                    e.f24872g.c(dVar);
                } else {
                    c.a.e.e.m.e.a().post(new a(this, dVar));
                }
            }
        }

        @Override // c.a.f0.b.d
        @NonNull
        public ViewGroup d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (e.f24872g != null) {
                    return e.f24872g.d();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // c.a.f0.b.d
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || e.f24872g == null) {
                return;
            }
            e.f24872g.onAdClick();
        }

        @Override // c.a.f0.b.d
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || e.f24872g == null) {
                return;
            }
            e.f24872g.onAdShow();
        }

        @Override // c.a.f0.b.d
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || e.f24872g == null) {
                return;
            }
            e.f24872g.onSkip();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements c.a.f0.a.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Application f24881b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f24882c;

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
            this.f24881b = application;
        }

        @Override // c.a.f0.a.b.a
        public boolean A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24881b.getResources().getConfiguration().orientation == 2 : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Settings.System.getString(this.f24881b.getContentResolver(), IAdRequestParam.ANDROID_ID) : (String) invokeV.objValue;
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
                if (e.f24871f) {
                    String p = c.a.q0.s.d0.b.j().p("key_prologue_ad_useragent", "");
                    if (!TextUtils.isEmpty(p)) {
                        return p;
                    }
                }
                String b2 = u0.b();
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
                AppPosInfo a2 = c.a.r0.y2.j0.a.e().a();
                return a2 != null ? a2.coordinate_type : "";
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        public JSONObject k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (this.f24882c == null) {
                    this.f24882c = new JSONObject();
                }
                return this.f24882c;
            }
            return (JSONObject) invokeV.objValue;
        }

        @Override // c.a.f0.a.b.a
        @NonNull
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                if (e.f24871f) {
                    String p = c.a.q0.s.d0.b.j().p("key_prologue_ad_baiduid", "");
                    if (!TextUtils.isEmpty(p)) {
                        return p;
                    }
                }
                return c.a.q0.m.a.e();
            }
            return (String) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f24881b : (Application) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (int) c.a.r0.t.a.j.a.e() : invokeV.intValue;
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
                if (c.a.r0.y2.j0.a.e() != null && (a2 = c.a.r0.y2.j0.a.e().a()) != null) {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-135249366, "Lc/a/r0/t/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-135249366, "Lc/a/r0/t/a/e;");
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
        this.f24873b = 5;
        this.f24874c = AdLoadState.INIT;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            c.a.b.f().g(new c(TbadkCoreApplication.getInst()));
        }
    }

    @Override // c.a.r0.t.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f24871f = true;
            l(new b(this), null);
        }
    }

    @Override // c.a.r0.t.a.h.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24874c : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.r0.t.a.h.b
    public void c(c.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        c.a.q0.l.a a2 = dVar.a();
        this.f24875d = new WeakReference<>(dVar.b());
        a aVar = new a(this, a2);
        f24872g = aVar;
        if (f24871f) {
            j();
            f24871f = false;
            return;
        }
        l(aVar, a2);
    }

    @Override // c.a.r0.t.a.h.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.t.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f24870e != null) {
                f24870e.f();
                f24870e = null;
            }
            f24872g = null;
        }
    }

    public final void i() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f24875d) == null || weakReference.get().getParent() == null || !(this.f24875d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24875d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f24875d.get().setLayoutParams(layoutParams);
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || f24872g == null || c.a.r0.q.b.c().d(d()).isEmpty()) {
            return;
        }
        for (b.a aVar : c.a.r0.q.b.c().d(d())) {
            String str = aVar.f24072a;
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
                f24872g.c((c.a.j0.a.g.d) aVar.f24073b.get("data"));
            } else if (c2 == 1) {
                f24872g.a((String) aVar.f24073b.get("data"));
            }
        }
        c.a.r0.q.b.c().b(d());
    }

    public final void l(c.a.f0.b.d dVar, c.a.q0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, dVar, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                f24870e = new c.a.f0.b.g.d(context, "1481698145541", new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).build(), dVar);
                this.f24874c = AdLoadState.LOADING;
                c.a.r0.t.a.j.a.i(c.a.r0.t.a.j.a.f24910c);
                f24870e.h();
                boolean z = c.a.r0.t.a.h.b.f24900a;
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (aVar != null) {
                    aVar.a("oom");
                }
            }
        }
    }

    @Override // c.a.r0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || f24870e == null || (weakReference = this.f24875d) == null || weakReference.get() == null || this.f24874c != AdLoadState.SUCCEED) {
            return;
        }
        i();
        this.f24874c = AdLoadState.SHOWED;
        boolean z = c.a.r0.t.a.h.b.f24900a;
        f24870e.l(this.f24875d.get());
    }
}
