package c.a.r0.t.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.q0.j;
import c.a.r0.q.b;
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
public class d implements c.a.r0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile SplashAd f24858g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile boolean f24859h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile SplashLpCloseListener f24860i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f24861b;

    /* renamed from: c  reason: collision with root package name */
    public int f24862c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f24863d;

    /* renamed from: e  reason: collision with root package name */
    public AdLoadState f24864e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.l.b f24865f;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24866a;

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
            this.f24866a = dVar;
        }

        @Override // c.a.q0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24866a.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.l.a f24867a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f24868b;

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
            this.f24868b = dVar;
            this.f24867a = aVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("type", "cpc");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(c.a.r0.t.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsplashType, i2) == null) {
                c.a.r0.t.a.j.a.j(c.a.r0.t.a.j.a.f24912e, "0", i2);
                this.f24868b.f24864e = AdLoadState.SUCCEED;
                boolean z = c.a.r0.t.a.h.b.f24900a;
                if (d.f24858g == null || this.f24868b.f24863d == null) {
                    return;
                }
                this.f24868b.f24861b = rsplashType;
                this.f24868b.f24862c = 0;
                c.a.r0.t.a.h.a.c().h(this.f24867a);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = c.a.r0.t.a.h.b.f24900a;
                c.a.q0.l.a aVar = this.f24867a;
                if (aVar != null) {
                    aVar.b(this.f24868b.f24861b == RsplashType.VIDEO, 1 == this.f24868b.f24862c, 7, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = this.f24868b.f24864e == AdLoadState.DISMISSED;
                this.f24868b.f24864e = AdLoadState.DISMISSED;
                c.a.q0.l.a aVar = this.f24867a;
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
                c.a.r0.t.a.j.a.j(c.a.r0.t.a.j.a.f24912e, str, 0);
                if (c.a.r0.t.a.h.b.f24900a) {
                    String str2 = "bes cpc ad loaded failed : " + str;
                }
                this.f24868b.f24864e = AdLoadState.FAILED;
                c.a.r0.t.a.h.a.c().h(this.f24867a);
                c.a.r0.t.a.j.a.k(c.a.r0.t.a.j.a.f24912e, "1");
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                boolean z = c.a.r0.t.a.h.b.f24900a;
                boolean z2 = 1 == this.f24868b.f24862c;
                c.a.q0.l.a aVar = this.f24867a;
                if (aVar != null) {
                    aVar.c(false, z2, 7);
                }
                c.a.r0.t.a.j.a.k(c.a.r0.t.a.j.a.f24912e, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            c.a.q0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f24867a) == null) {
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
        public final /* synthetic */ d f24869a;

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
            this.f24869a = dVar;
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rsplashType, i2) == null) {
                if (d.f24860i != null) {
                    d.f24860i.onADLoaded(rsplashType, i2);
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("rsplashType", rsplashType);
                hashMap.put("count", Integer.valueOf(i2));
                c.a.r0.q.b.c().a(this.f24869a.d(), "onADLoaded", hashMap);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || d.f24860i == null) {
                return;
            }
            d.f24860i.onAdClick();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || d.f24860i == null) {
                return;
            }
            d.f24860i.onAdDismissed();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (d.f24860i != null) {
                    d.f24860i.onAdFailed(str);
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", str);
                c.a.r0.q.b.c().a(this.f24869a.d(), "onAdFailed", hashMap);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || d.f24860i == null) {
                return;
            }
            d.f24860i.onAdPresent();
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || d.f24860i == null) {
                return;
            }
            d.f24860i.onLpClosed();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-135249397, "Lc/a/r0/t/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-135249397, "Lc/a/r0/t/a/d;");
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
        this.f24862c = 1;
        new AdSplashStyle();
        this.f24864e = AdLoadState.INIT;
        this.f24865f = new a(this);
    }

    @Override // c.a.r0.t.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q(new c(this), null);
            f24859h = true;
        }
    }

    @Override // c.a.r0.t.a.h.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24864e : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.r0.t.a.h.b
    public void c(c.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f13561c = this.f24865f;
        c.a.q0.l.a a2 = dVar.a();
        this.f24863d = new WeakReference<>(dVar.b());
        b bVar = new b(this, a2);
        dVar.b();
        if (f24859h) {
            f24860i = bVar;
            p();
            f24859h = false;
            return;
        }
        q(bVar, a2);
    }

    @Override // c.a.r0.t.a.h.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "cpc" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.t.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f24858g != null) {
                f24858g.destroy();
                f24858g = null;
            }
            f24860i = null;
        }
    }

    public final void o() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f24863d) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24863d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f24863d.get().setLayoutParams(layoutParams);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || f24860i == null || c.a.r0.q.b.c().d(d()).isEmpty()) {
            return;
        }
        for (b.a aVar : c.a.r0.q.b.c().d(d())) {
            String str = aVar.f24072a;
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
                f24860i.onADLoaded((RsplashType) aVar.f24073b.get("rsplashType"), ((Integer) aVar.f24073b.get("count")).intValue());
            } else if (c2 == 1) {
                f24860i.onAdFailed((String) aVar.f24073b.get("data"));
            }
        }
        c.a.r0.q.b.c().b(d());
    }

    public final void q(SplashLpCloseListener splashLpCloseListener, c.a.q0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, splashLpCloseListener, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
                RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + c.a.f0.a.b.a.f3337a.get().e());
                f24858g = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + c.a.f0.a.b.a.f3337a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), splashLpCloseListener);
                this.f24864e = AdLoadState.LOADING;
                f24858g.load();
                c.a.r0.t.a.j.a.i(c.a.r0.t.a.j.a.f24912e);
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || f24858g == null || (weakReference = this.f24863d) == null || weakReference.get() == null || this.f24864e != AdLoadState.SUCCEED) {
            return;
        }
        o();
        int i2 = this.f24862c;
        if (this.f24863d.get().getChildCount() > 0) {
            this.f24863d.get().removeAllViews();
        }
        boolean z = c.a.r0.t.a.h.b.f24900a;
        this.f24864e = AdLoadState.SHOWED;
        f24858g.show(this.f24863d.get());
    }
}
