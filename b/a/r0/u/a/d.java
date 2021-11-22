package b.a.r0.u.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.q0.q0.j;
import b.a.r0.r.b;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RsplashType;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashLpCloseListener;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.data.AdSplashStyle;
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
/* loaded from: classes5.dex */
public class d implements b.a.r0.u.a.h.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile SplashAd f25385h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f25386i;
    public static volatile SplashLpCloseListener j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f25387b;

    /* renamed from: c  reason: collision with root package name */
    public int f25388c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f25389d;

    /* renamed from: e  reason: collision with root package name */
    public AdLoadState f25390e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.l.a f25391f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.l.b f25392g;

    /* loaded from: classes5.dex */
    public class a implements b.a.q0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25393a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25393a = dVar;
        }

        @Override // b.a.q0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25393a.p();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25394a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25394a = dVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                b.a.e.f.n.a a2 = j.a();
                a2.b("type", "cpc");
                a2.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(b.a.r0.u.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsplashType, i2) == null) {
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f25440e, "0", i2);
                this.f25394a.f25390e = AdLoadState.SUCCEED;
                boolean z = b.a.r0.u.a.h.b.f25428a;
                if (d.f25385h == null || this.f25394a.f25389d == null) {
                    return;
                }
                this.f25394a.f25387b = rsplashType;
                this.f25394a.f25388c = 0;
                b.a.r0.u.a.h.a.c().h(this.f25394a.f25391f);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = b.a.r0.u.a.h.b.f25428a;
                if (this.f25394a.f25391f != null) {
                    this.f25394a.f25391f.a(this.f25394a.f25387b == RsplashType.VIDEO, 1 == this.f25394a.f25388c, 7, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = this.f25394a.f25390e == AdLoadState.DISMISSED;
                this.f25394a.f25390e = AdLoadState.DISMISSED;
                if (this.f25394a.f25391f == null || z) {
                    return;
                }
                this.f25394a.f25391f.onAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f25440e, str, 0);
                if (b.a.r0.u.a.h.b.f25428a) {
                    String str2 = "bes cpc ad loaded failed : " + str;
                }
                this.f25394a.f25390e = AdLoadState.FAILED;
                b.a.r0.u.a.h.a.c().h(this.f25394a.f25391f);
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f25440e, "1");
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                boolean z = b.a.r0.u.a.h.b.f25428a;
                boolean z2 = 1 == this.f25394a.f25388c;
                if (this.f25394a.f25391f != null) {
                    this.f25394a.f25391f.e(false, z2, 7);
                }
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f25440e, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f25394a.f25391f == null) {
                return;
            }
            this.f25394a.f25391f.onLpClosed();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25395a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RsplashType f25396e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f25397f;

            public a(c cVar, RsplashType rsplashType, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, rsplashType, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25396e = rsplashType;
                this.f25397f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.j == null) {
                    return;
                }
                d.j.onADLoaded(this.f25396e, this.f25397f);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f25398e;

            public b(c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25398e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.j == null) {
                    return;
                }
                d.j.onAdFailed(this.f25398e);
            }
        }

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25395a = dVar;
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rsplashType, i2) == null) {
                if (d.j == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("rsplashType", rsplashType);
                    hashMap.put("count", Integer.valueOf(i2));
                    b.a.r0.r.b.c().a(this.f25395a.d(), "onADLoaded", hashMap);
                } else if (l.C()) {
                    d.j.onADLoaded(rsplashType, i2);
                } else {
                    b.a.e.f.m.e.a().post(new a(this, rsplashType, i2));
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || d.j == null) {
                return;
            }
            d.j.onAdClick();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || d.j == null) {
                return;
            }
            d.j.onAdDismissed();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (d.j == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    b.a.r0.r.b.c().a(this.f25395a.d(), "onAdFailed", hashMap);
                } else if (l.C()) {
                    d.j.onAdFailed(str);
                } else {
                    b.a.e.f.m.e.a().post(new b(this, str));
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || d.j == null) {
                return;
            }
            d.j.onAdPresent();
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || d.j == null) {
                return;
            }
            d.j.onLpClosed();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(186782761, "Lb/a/r0/u/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(186782761, "Lb/a/r0/u/a/d;");
        }
    }

    public d() {
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
        this.f25388c = 1;
        new AdSplashStyle();
        this.f25390e = AdLoadState.INIT;
        this.f25391f = null;
        this.f25392g = new a(this);
    }

    @Override // b.a.r0.u.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r(new c(this), null);
            f25386i = true;
        }
    }

    @Override // b.a.r0.u.a.h.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25390e : (AdLoadState) invokeV.objValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void c(b.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f13464c = this.f25392g;
        this.f25391f = dVar.a();
        this.f25389d = new WeakReference<>(dVar.b());
        b bVar = new b(this);
        dVar.b();
        if (f25386i) {
            j = bVar;
            q();
            f25386i = false;
            return;
        }
        r(bVar, this.f25391f);
    }

    @Override // b.a.r0.u.a.h.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "cpc" : (String) invokeV.objValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f25385h != null) {
                f25385h.destroy();
                f25385h = null;
            }
            j = null;
        }
    }

    public final void p() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f25389d) == null || weakReference.get().getParent() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f25389d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f25389d.get().setLayoutParams(layoutParams);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || j == null || b.a.r0.r.b.c().d(d()).isEmpty()) {
            return;
        }
        for (b.a aVar : b.a.r0.r.b.c().d(d())) {
            String str = aVar.f24467a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1769079577) {
                if (hashCode == 676776255 && str.equals("onAdFailed")) {
                    c2 = 1;
                }
            } else if (str.equals("onADLoaded")) {
                c2 = 0;
            }
            if (c2 == 0) {
                j.onADLoaded((RsplashType) aVar.f24468b.get("rsplashType"), ((Integer) aVar.f24468b.get("count")).intValue());
            } else if (c2 == 1) {
                j.onAdFailed((String) aVar.f24468b.get("data"));
            }
        }
        b.a.r0.r.b.c().b(d());
    }

    public final void r(SplashLpCloseListener splashLpCloseListener, b.a.q0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, splashLpCloseListener, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
                RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + b.a.f0.a.b.a.f2874a.get().e());
                f25385h = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + b.a.f0.a.b.a.f2874a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), splashLpCloseListener);
                this.f25390e = AdLoadState.LOADING;
                f25385h.load();
                b.a.r0.u.a.j.a.i(b.a.r0.u.a.j.a.f25440e);
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || f25385h == null || (weakReference = this.f25389d) == null || weakReference.get() == null || this.f25390e != AdLoadState.SUCCEED) {
            return;
        }
        b.a.q0.l.a aVar = this.f25391f;
        if (aVar != null) {
            aVar.d();
        }
        p();
        int i2 = this.f25388c;
        if (this.f25389d.get().getChildCount() > 0) {
            this.f25389d.get().removeAllViews();
        }
        boolean z = b.a.r0.u.a.h.b.f25428a;
        this.f25390e = AdLoadState.SHOWED;
        f25385h.show(this.f25389d.get());
    }
}
