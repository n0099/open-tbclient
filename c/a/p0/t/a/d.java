package c.a.p0.t.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
import c.a.o0.o0.j;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d implements c.a.p0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f24115b;

    /* renamed from: c  reason: collision with root package name */
    public int f24116c;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f24117d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f24118e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f24119f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.l.b f24120g;

    /* loaded from: classes3.dex */
    public class a implements c.a.o0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24121a;

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
            this.f24121a = dVar;
        }

        @Override // c.a.o0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24121a.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.l.a f24122a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f24123b;

        public b(d dVar, c.a.o0.l.a aVar) {
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
            this.f24123b = dVar;
            this.f24122a = aVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("type", "cpc");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(c.a.p0.t.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsplashType, i2) == null) {
                c.a.p0.t.a.j.a.j(c.a.p0.t.a.j.a.f24159e, "0", i2);
                this.f24123b.f24119f = AdLoadState.SUCCEED;
                boolean z = c.a.p0.t.a.h.b.f24147a;
                if (this.f24123b.f24117d == null || this.f24123b.f24118e == null) {
                    return;
                }
                this.f24123b.f24115b = rsplashType;
                this.f24123b.f24116c = 0;
                c.a.p0.t.a.h.a.c().g(this.f24122a);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = c.a.p0.t.a.h.b.f24147a;
                c.a.o0.l.a aVar = this.f24122a;
                if (aVar != null) {
                    aVar.b(this.f24123b.f24115b == RsplashType.VIDEO, 1 == this.f24123b.f24116c, 7, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = this.f24123b.f24119f == AdLoadState.DISMISSED;
                this.f24123b.f24119f = AdLoadState.DISMISSED;
                c.a.o0.l.a aVar = this.f24122a;
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
                c.a.p0.t.a.j.a.j(c.a.p0.t.a.j.a.f24159e, str, 0);
                if (c.a.p0.t.a.h.b.f24147a) {
                    String str2 = "bes cpc ad loaded failed : " + str;
                }
                this.f24123b.f24119f = AdLoadState.FAILED;
                c.a.p0.t.a.h.a.c().g(this.f24122a);
                c.a.p0.t.a.j.a.k(c.a.p0.t.a.j.a.f24159e, "1");
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                boolean z = c.a.p0.t.a.h.b.f24147a;
                boolean z2 = 1 == this.f24123b.f24116c;
                c.a.o0.l.a aVar = this.f24122a;
                if (aVar != null) {
                    aVar.c(false, z2, 7);
                }
                c.a.p0.t.a.j.a.k(c.a.p0.t.a.j.a.f24159e, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            c.a.o0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f24122a) == null) {
                return;
            }
            aVar.onLpClosed();
        }
    }

    public d() {
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
        this.f24116c = 1;
        new AdSplashStyle();
        this.f24119f = AdLoadState.INIT;
        this.f24120g = new a(this);
    }

    @Override // c.a.p0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24119f : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.p0.t.a.h.b
    public void b(c.a.o0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f13281c = this.f24120g;
        c.a.o0.l.a a2 = dVar.a();
        this.f24118e = new WeakReference<>(dVar.b());
        b bVar = new b(this, a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + c.a.e0.a.b.a.f3041a.get().e());
            this.f24117d = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + c.a.e0.a.b.a.f3041a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), bVar);
            this.f24119f = AdLoadState.LOADING;
            this.f24117d.load();
            c.a.p0.t.a.j.a.i(c.a.p0.t.a.j.a.f24159e);
            boolean z = c.a.p0.t.a.h.b.f24147a;
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // c.a.p0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "cpc" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.t.a.h.b
    public void destroy() {
        SplashAd splashAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (splashAd = this.f24117d) == null) {
            return;
        }
        splashAd.destroy();
    }

    public final void m() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.f24118e) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24118e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f24118e.get().setLayoutParams(layoutParams);
    }

    @Override // c.a.p0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f24117d == null || (weakReference = this.f24118e) == null || weakReference.get() == null || this.f24119f != AdLoadState.SUCCEED) {
            return;
        }
        m();
        int i2 = this.f24116c;
        if (this.f24118e.get().getChildCount() > 0) {
            this.f24118e.get().removeAllViews();
        }
        boolean z = c.a.p0.t.a.h.b.f24147a;
        this.f24119f = AdLoadState.SHOWED;
        this.f24117d.show(this.f24118e.get());
    }
}
