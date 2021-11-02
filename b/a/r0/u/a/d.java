package b.a.r0.u.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.q0.j;
import b.a.r0.r.b;
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
/* loaded from: classes5.dex */
public class d implements b.a.r0.u.a.h.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile SplashAd f23897h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f23898i;
    public static volatile SplashLpCloseListener j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f23899b;

    /* renamed from: c  reason: collision with root package name */
    public int f23900c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f23901d;

    /* renamed from: e  reason: collision with root package name */
    public AdLoadState f23902e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.l.a f23903f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.l.b f23904g;

    /* loaded from: classes5.dex */
    public class a implements b.a.q0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23905a;

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
            this.f23905a = dVar;
        }

        @Override // b.a.q0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23905a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23906a;

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
            this.f23906a = dVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                b.a.e.e.n.a a2 = j.a();
                a2.b("type", "cpc");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(b.a.r0.u.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsplashType, i2) == null) {
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f23952e, "0", i2);
                this.f23906a.f23902e = AdLoadState.SUCCEED;
                boolean z = b.a.r0.u.a.h.b.f23940a;
                if (d.f23897h == null || this.f23906a.f23901d == null) {
                    return;
                }
                this.f23906a.f23899b = rsplashType;
                this.f23906a.f23900c = 0;
                b.a.r0.u.a.h.a.c().h(this.f23906a.f23903f);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = b.a.r0.u.a.h.b.f23940a;
                if (this.f23906a.f23903f != null) {
                    this.f23906a.f23903f.a(this.f23906a.f23899b == RsplashType.VIDEO, 1 == this.f23906a.f23900c, 7, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = this.f23906a.f23902e == AdLoadState.DISMISSED;
                this.f23906a.f23902e = AdLoadState.DISMISSED;
                if (this.f23906a.f23903f == null || z) {
                    return;
                }
                this.f23906a.f23903f.onAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f23952e, str, 0);
                if (b.a.r0.u.a.h.b.f23940a) {
                    String str2 = "bes cpc ad loaded failed : " + str;
                }
                this.f23906a.f23902e = AdLoadState.FAILED;
                b.a.r0.u.a.h.a.c().h(this.f23906a.f23903f);
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f23952e, "1");
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                boolean z = b.a.r0.u.a.h.b.f23940a;
                boolean z2 = 1 == this.f23906a.f23900c;
                if (this.f23906a.f23903f != null) {
                    this.f23906a.f23903f.e(false, z2, 7);
                }
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f23952e, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f23906a.f23903f == null) {
                return;
            }
            this.f23906a.f23903f.onLpClosed();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23907a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RsplashType f23908e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f23909f;

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
                this.f23908e = rsplashType;
                this.f23909f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.j == null) {
                    return;
                }
                d.j.onADLoaded(this.f23908e, this.f23909f);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f23910e;

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
                this.f23910e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.j == null) {
                    return;
                }
                d.j.onAdFailed(this.f23910e);
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
            this.f23907a = dVar;
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rsplashType, i2) == null) {
                if (d.j == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("rsplashType", rsplashType);
                    hashMap.put("count", Integer.valueOf(i2));
                    b.a.r0.r.b.c().a(this.f23907a.e(), "onADLoaded", hashMap);
                } else if (l.C()) {
                    d.j.onADLoaded(rsplashType, i2);
                } else {
                    b.a.e.e.m.e.a().post(new a(this, rsplashType, i2));
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
                    b.a.r0.r.b.c().a(this.f23907a.e(), "onAdFailed", hashMap);
                } else if (l.C()) {
                    d.j.onAdFailed(str);
                } else {
                    b.a.e.e.m.e.a().post(new b(this, str));
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
        this.f23900c = 1;
        new AdSplashStyle();
        this.f23902e = AdLoadState.INIT;
        this.f23903f = null;
        this.f23904g = new a(this);
    }

    @Override // b.a.r0.u.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s(new c(this), null);
            f23898i = true;
        }
    }

    @Override // b.a.r0.u.a.h.b
    public void b() {
        b.a.q0.l.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f23903f) == null) {
            return;
        }
        aVar.d();
    }

    @Override // b.a.r0.u.a.h.b
    public AdLoadState c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23902e : (AdLoadState) invokeV.objValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void d(b.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f12714c = this.f23904g;
        this.f23903f = dVar.a();
        this.f23901d = new WeakReference<>(dVar.b());
        b bVar = new b(this);
        dVar.b();
        if (f23898i) {
            j = bVar;
            r();
            f23898i = false;
            return;
        }
        s(bVar, this.f23903f);
    }

    @Override // b.a.r0.u.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f23897h != null) {
                f23897h.destroy();
                f23897h = null;
            }
            j = null;
        }
    }

    @Override // b.a.r0.u.a.h.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "cpc" : (String) invokeV.objValue;
    }

    public final void q() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (weakReference = this.f23901d) == null || weakReference.get().getParent() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f23901d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f23901d.get().setLayoutParams(layoutParams);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || j == null || b.a.r0.r.b.c().d(e()).isEmpty()) {
            return;
        }
        for (b.a aVar : b.a.r0.r.b.c().d(e())) {
            String str = aVar.f22935a;
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
                j.onADLoaded((RsplashType) aVar.f22936b.get("rsplashType"), ((Integer) aVar.f22936b.get("count")).intValue());
            } else if (c2 == 1) {
                j.onAdFailed((String) aVar.f22936b.get("data"));
            }
        }
        b.a.r0.r.b.c().b(e());
    }

    public final void s(SplashLpCloseListener splashLpCloseListener, b.a.q0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, splashLpCloseListener, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
                RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + b.a.f0.a.b.a.f2781a.get().e());
                f23897h = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + b.a.f0.a.b.a.f2781a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), splashLpCloseListener);
                this.f23902e = AdLoadState.LOADING;
                f23897h.load();
                b.a.r0.u.a.j.a.i(b.a.r0.u.a.j.a.f23952e);
                boolean z = b.a.r0.u.a.h.b.f23940a;
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || f23897h == null || (weakReference = this.f23901d) == null || weakReference.get() == null || this.f23902e != AdLoadState.SUCCEED) {
            return;
        }
        b.a.q0.l.a aVar = this.f23903f;
        if (aVar != null) {
            aVar.c();
        }
        q();
        int i2 = this.f23900c;
        if (this.f23901d.get().getChildCount() > 0) {
            this.f23901d.get().removeAllViews();
        }
        boolean z = b.a.r0.u.a.h.b.f23940a;
        this.f23902e = AdLoadState.SHOWED;
        f23897h.show(this.f23901d.get());
    }
}
