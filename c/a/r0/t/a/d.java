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
    public static volatile SplashAd f24877g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile boolean f24878h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile SplashLpCloseListener f24879i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f24880b;

    /* renamed from: c  reason: collision with root package name */
    public int f24881c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f24882d;

    /* renamed from: e  reason: collision with root package name */
    public AdLoadState f24883e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.l.b f24884f;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24885a;

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
            this.f24885a = dVar;
        }

        @Override // c.a.q0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24885a.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.l.a f24886a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f24887b;

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
            this.f24887b = dVar;
            this.f24886a = aVar;
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
                c.a.r0.t.a.j.a.j(c.a.r0.t.a.j.a.f24933e, "0", i2);
                this.f24887b.f24883e = AdLoadState.SUCCEED;
                boolean z = c.a.r0.t.a.h.b.f24921a;
                if (d.f24877g == null || this.f24887b.f24882d == null) {
                    return;
                }
                this.f24887b.f24880b = rsplashType;
                this.f24887b.f24881c = 0;
                c.a.r0.t.a.h.a.c().h(this.f24886a);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = c.a.r0.t.a.h.b.f24921a;
                c.a.q0.l.a aVar = this.f24886a;
                if (aVar != null) {
                    aVar.b(this.f24887b.f24880b == RsplashType.VIDEO, 1 == this.f24887b.f24881c, 7, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = this.f24887b.f24883e == AdLoadState.DISMISSED;
                this.f24887b.f24883e = AdLoadState.DISMISSED;
                c.a.q0.l.a aVar = this.f24886a;
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
                c.a.r0.t.a.j.a.j(c.a.r0.t.a.j.a.f24933e, str, 0);
                if (c.a.r0.t.a.h.b.f24921a) {
                    String str2 = "bes cpc ad loaded failed : " + str;
                }
                this.f24887b.f24883e = AdLoadState.FAILED;
                c.a.r0.t.a.h.a.c().h(this.f24886a);
                c.a.r0.t.a.j.a.k(c.a.r0.t.a.j.a.f24933e, "1");
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                boolean z = c.a.r0.t.a.h.b.f24921a;
                boolean z2 = 1 == this.f24887b.f24881c;
                c.a.q0.l.a aVar = this.f24886a;
                if (aVar != null) {
                    aVar.c(false, z2, 7);
                }
                c.a.r0.t.a.j.a.k(c.a.r0.t.a.j.a.f24933e, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            c.a.q0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f24886a) == null) {
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
        public final /* synthetic */ d f24888a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RsplashType f24889e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f24890f;

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
                this.f24889e = rsplashType;
                this.f24890f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.f24879i == null) {
                    return;
                }
                d.f24879i.onADLoaded(this.f24889e, this.f24890f);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f24891e;

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
                this.f24891e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.f24879i == null) {
                    return;
                }
                d.f24879i.onAdFailed(this.f24891e);
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
            this.f24888a = dVar;
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rsplashType, i2) == null) {
                if (d.f24879i == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("rsplashType", rsplashType);
                    hashMap.put("count", Integer.valueOf(i2));
                    c.a.r0.q.b.c().a(this.f24888a.d(), "onADLoaded", hashMap);
                } else if (l.C()) {
                    d.f24879i.onADLoaded(rsplashType, i2);
                } else {
                    c.a.e.e.m.e.a().post(new a(this, rsplashType, i2));
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || d.f24879i == null) {
                return;
            }
            d.f24879i.onAdClick();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || d.f24879i == null) {
                return;
            }
            d.f24879i.onAdDismissed();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                if (d.f24879i == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    c.a.r0.q.b.c().a(this.f24888a.d(), "onAdFailed", hashMap);
                } else if (l.C()) {
                    d.f24879i.onAdFailed(str);
                } else {
                    c.a.e.e.m.e.a().post(new b(this, str));
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || d.f24879i == null) {
                return;
            }
            d.f24879i.onAdPresent();
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || d.f24879i == null) {
                return;
            }
            d.f24879i.onLpClosed();
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
        this.f24881c = 1;
        new AdSplashStyle();
        this.f24883e = AdLoadState.INIT;
        this.f24884f = new a(this);
    }

    @Override // c.a.r0.t.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q(new c(this), null);
            f24878h = true;
        }
    }

    @Override // c.a.r0.t.a.h.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24883e : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.r0.t.a.h.b
    public void c(c.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f13557c = this.f24884f;
        c.a.q0.l.a a2 = dVar.a();
        this.f24882d = new WeakReference<>(dVar.b());
        b bVar = new b(this, a2);
        dVar.b();
        if (f24878h) {
            f24879i = bVar;
            p();
            f24878h = false;
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
            if (f24877g != null) {
                f24877g.destroy();
                f24877g = null;
            }
            f24879i = null;
        }
    }

    public final void o() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f24882d) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24882d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f24882d.get().setLayoutParams(layoutParams);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || f24879i == null || c.a.r0.q.b.c().d(d()).isEmpty()) {
            return;
        }
        for (b.a aVar : c.a.r0.q.b.c().d(d())) {
            String str = aVar.f24088a;
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
                f24879i.onADLoaded((RsplashType) aVar.f24089b.get("rsplashType"), ((Integer) aVar.f24089b.get("count")).intValue());
            } else if (c2 == 1) {
                f24879i.onAdFailed((String) aVar.f24089b.get("data"));
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
                RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + c.a.f0.a.b.a.f3338a.get().e());
                f24877g = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + c.a.f0.a.b.a.f3338a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), splashLpCloseListener);
                this.f24883e = AdLoadState.LOADING;
                f24877g.load();
                c.a.r0.t.a.j.a.i(c.a.r0.t.a.j.a.f24933e);
                boolean z = c.a.r0.t.a.h.b.f24921a;
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || f24877g == null || (weakReference = this.f24882d) == null || weakReference.get() == null || this.f24883e != AdLoadState.SUCCEED) {
            return;
        }
        o();
        int i2 = this.f24881c;
        if (this.f24882d.get().getChildCount() > 0) {
            this.f24882d.get().removeAllViews();
        }
        boolean z = c.a.r0.t.a.h.b.f24921a;
        this.f24883e = AdLoadState.SHOWED;
        f24877g.show(this.f24882d.get());
    }
}
