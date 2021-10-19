package c.a.r0.u.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.q0.j;
import c.a.r0.r.b;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RsplashType;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashLpCloseListener;
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
/* loaded from: classes3.dex */
public class d implements c.a.r0.u.a.h.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile SplashAd f25052g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile boolean f25053h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile SplashLpCloseListener f25054i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f25055b;

    /* renamed from: c  reason: collision with root package name */
    public int f25056c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f25057d;

    /* renamed from: e  reason: collision with root package name */
    public AdLoadState f25058e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.l.b f25059f;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25060a;

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
            this.f25060a = dVar;
        }

        @Override // c.a.q0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25060a.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.l.a f25061a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f25062b;

        public b(d dVar, c.a.q0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25062b = dVar;
            this.f25061a = aVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("type", "cpc");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(c.a.r0.u.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsplashType, i2) == null) {
                c.a.r0.u.a.j.a.j(c.a.r0.u.a.j.a.f25108e, "0", i2);
                this.f25062b.f25058e = AdLoadState.SUCCEED;
                boolean z = c.a.r0.u.a.h.b.f25096a;
                if (d.f25052g == null || this.f25062b.f25057d == null) {
                    return;
                }
                this.f25062b.f25055b = rsplashType;
                this.f25062b.f25056c = 0;
                c.a.r0.u.a.h.a.c().h(this.f25061a);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = c.a.r0.u.a.h.b.f25096a;
                c.a.q0.l.a aVar = this.f25061a;
                if (aVar != null) {
                    aVar.b(this.f25062b.f25055b == RsplashType.VIDEO, 1 == this.f25062b.f25056c, 7, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = this.f25062b.f25058e == AdLoadState.DISMISSED;
                this.f25062b.f25058e = AdLoadState.DISMISSED;
                c.a.q0.l.a aVar = this.f25061a;
                if (aVar == null || z) {
                    return;
                }
                aVar.onAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                c.a.r0.u.a.j.a.j(c.a.r0.u.a.j.a.f25108e, str, 0);
                if (c.a.r0.u.a.h.b.f25096a) {
                    String str2 = "bes cpc ad loaded failed : " + str;
                }
                this.f25062b.f25058e = AdLoadState.FAILED;
                c.a.r0.u.a.h.a.c().h(this.f25061a);
                c.a.r0.u.a.j.a.k(c.a.r0.u.a.j.a.f25108e, "1");
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                boolean z = c.a.r0.u.a.h.b.f25096a;
                boolean z2 = 1 == this.f25062b.f25056c;
                c.a.q0.l.a aVar = this.f25061a;
                if (aVar != null) {
                    aVar.c(false, z2, 7);
                }
                c.a.r0.u.a.j.a.k(c.a.r0.u.a.j.a.f25108e, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            c.a.q0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f25061a) == null) {
                return;
            }
            aVar.onLpClosed();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25063a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RsplashType f25064e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f25065f;

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
                this.f25064e = rsplashType;
                this.f25065f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.f25054i == null) {
                    return;
                }
                d.f25054i.onADLoaded(this.f25064e, this.f25065f);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f25066e;

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
                this.f25066e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.f25054i == null) {
                    return;
                }
                d.f25054i.onAdFailed(this.f25066e);
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
            this.f25063a = dVar;
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rsplashType, i2) == null) {
                if (d.f25054i == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("rsplashType", rsplashType);
                    hashMap.put("count", Integer.valueOf(i2));
                    c.a.r0.r.b.c().a(this.f25063a.d(), "onADLoaded", hashMap);
                } else if (l.C()) {
                    d.f25054i.onADLoaded(rsplashType, i2);
                } else {
                    c.a.e.e.m.e.a().post(new a(this, rsplashType, i2));
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || d.f25054i == null) {
                return;
            }
            d.f25054i.onAdClick();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || d.f25054i == null) {
                return;
            }
            d.f25054i.onAdDismissed();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (d.f25054i == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    c.a.r0.r.b.c().a(this.f25063a.d(), "onAdFailed", hashMap);
                } else if (l.C()) {
                    d.f25054i.onAdFailed(str);
                } else {
                    c.a.e.e.m.e.a().post(new b(this, str));
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || d.f25054i == null) {
                return;
            }
            d.f25054i.onAdPresent();
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || d.f25054i == null) {
                return;
            }
            d.f25054i.onLpClosed();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-106620246, "Lc/a/r0/u/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-106620246, "Lc/a/r0/u/a/d;");
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
        this.f25056c = 1;
        new AdSplashStyle();
        this.f25058e = AdLoadState.INIT;
        this.f25059f = new a(this);
    }

    @Override // c.a.r0.u.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q(new c(this), null);
            f25053h = true;
        }
    }

    @Override // c.a.r0.u.a.h.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25058e : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.r0.u.a.h.b
    public void c(c.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f13576c = this.f25059f;
        c.a.q0.l.a a2 = dVar.a();
        this.f25057d = new WeakReference<>(dVar.b());
        b bVar = new b(this, a2);
        dVar.b();
        if (f25053h) {
            f25054i = bVar;
            p();
            f25053h = false;
            return;
        }
        q(bVar, a2);
    }

    @Override // c.a.r0.u.a.h.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "cpc" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.u.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f25052g != null) {
                f25052g.destroy();
                f25052g = null;
            }
            f25054i = null;
        }
    }

    public final void o() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f25057d) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25057d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f25057d.get().setLayoutParams(layoutParams);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || f25054i == null || c.a.r0.r.b.c().d(d()).isEmpty()) {
            return;
        }
        for (b.a aVar : c.a.r0.r.b.c().d(d())) {
            String str = aVar.f24263a;
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
                f25054i.onADLoaded((RsplashType) aVar.f24264b.get("rsplashType"), ((Integer) aVar.f24264b.get("count")).intValue());
            } else if (c2 == 1) {
                f25054i.onAdFailed((String) aVar.f24264b.get("data"));
            }
        }
        c.a.r0.r.b.c().b(d());
    }

    public final void q(SplashLpCloseListener splashLpCloseListener, c.a.q0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, splashLpCloseListener, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
                RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + c.a.f0.a.b.a.f3338a.get().e());
                f25052g = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + c.a.f0.a.b.a.f3338a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), splashLpCloseListener);
                this.f25058e = AdLoadState.LOADING;
                f25052g.load();
                c.a.r0.u.a.j.a.i(c.a.r0.u.a.j.a.f25108e);
                boolean z = c.a.r0.u.a.h.b.f25096a;
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (aVar != null) {
                    aVar.a("oom");
                }
            }
        }
    }

    @Override // c.a.r0.u.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || f25052g == null || (weakReference = this.f25057d) == null || weakReference.get() == null || this.f25058e != AdLoadState.SUCCEED) {
            return;
        }
        o();
        int i2 = this.f25056c;
        if (this.f25057d.get().getChildCount() > 0) {
            this.f25057d.get().removeAllViews();
        }
        boolean z = c.a.r0.u.a.h.b.f25096a;
        this.f25058e = AdLoadState.SHOWED;
        f25052g.show(this.f25057d.get());
    }
}
