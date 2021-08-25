package c.a.q0.t.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
import c.a.p0.o0.j;
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
public class b implements c.a.q0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f24426b;

    /* renamed from: c  reason: collision with root package name */
    public int f24427c;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f24428d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f24429e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f24430f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.l.b f24431g;

    /* loaded from: classes3.dex */
    public class a implements c.a.p0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24432a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24432a = bVar;
        }

        @Override // c.a.p0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24432a.l();
            }
        }
    }

    /* renamed from: c.a.q0.t.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1130b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.l.a f24433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f24434b;

        public C1130b(b bVar, c.a.p0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24434b = bVar;
            this.f24433a = aVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("type", "gd");
                a2.b("locate", "splash");
                a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(c.a.q0.t.a.h.a.c().b()));
                a2.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a2);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsplashType, i2) == null) {
                c.a.q0.t.a.j.a.j(c.a.q0.t.a.j.a.f24489b, "0", i2);
                this.f24434b.f24430f = AdLoadState.SUCCEED;
                boolean z = c.a.q0.t.a.h.b.f24480a;
                this.f24434b.f24426b = rsplashType;
                if (this.f24434b.f24428d == null || this.f24434b.f24429e == null) {
                    return;
                }
                c.a.q0.t.a.h.a.c().g(this.f24433a);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = c.a.q0.t.a.h.b.f24480a;
                c.a.p0.l.a aVar = this.f24433a;
                if (aVar != null) {
                    aVar.b(this.f24434b.f24426b == RsplashType.VIDEO, 1 == this.f24434b.f24427c, 1, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = c.a.q0.t.a.h.b.f24480a;
                boolean z2 = this.f24434b.f24430f == AdLoadState.DISMISSED;
                this.f24434b.f24430f = AdLoadState.DISMISSED;
                c.a.p0.l.a aVar = this.f24433a;
                if (aVar == null || z2) {
                    return;
                }
                aVar.onAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                c.a.q0.t.a.j.a.j(c.a.q0.t.a.j.a.f24489b, str, 0);
                c.a.q0.t.a.j.a.k(c.a.q0.t.a.j.a.f24489b, "1");
                if (c.a.q0.t.a.h.b.f24480a) {
                    String str2 = "bes gd loaded loaded failed :" + str;
                }
                this.f24434b.f24430f = AdLoadState.FAILED;
                c.a.q0.t.a.h.a.c().g(this.f24433a);
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (c.a.q0.t.a.h.b.f24480a) {
                    String str = "bes gd present, and time is " + System.currentTimeMillis();
                }
                boolean z = 1 == this.f24434b.f24427c;
                c.a.p0.l.a aVar = this.f24433a;
                if (aVar != null) {
                    aVar.c(this.f24434b.f24426b == RsplashType.VIDEO, z, 1);
                }
                c.a.q0.t.a.j.a.k(c.a.q0.t.a.j.a.f24489b, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            c.a.p0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f24433a) == null) {
                return;
            }
            aVar.onLpClosed();
        }
    }

    public b() {
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
        this.f24427c = 1;
        new AdSplashStyle();
        this.f24430f = AdLoadState.INIT;
        this.f24431g = new a(this);
    }

    @Override // c.a.q0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24430f : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.q0.t.a.h.b
    public void b(c.a.p0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f13572c = this.f24431g;
        c.a.p0.l.a a2 = dVar.a();
        this.f24429e = new WeakReference<>(dVar.b());
        C1130b c1130b = new C1130b(this, a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + c.a.f0.a.b.a.f3346a.get().e());
            this.f24428d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + c.a.f0.a.b.a.f3346a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1130b);
            this.f24430f = AdLoadState.LOADING;
            this.f24428d.load();
            c.a.q0.t.a.j.a.i(c.a.q0.t.a.j.a.f24489b);
            boolean z = c.a.q0.t.a.h.b.f24480a;
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // c.a.q0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "bes_gd" : (String) invokeV.objValue;
    }

    @Override // c.a.q0.t.a.h.b
    public void destroy() {
        SplashAd splashAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (splashAd = this.f24428d) == null) {
            return;
        }
        splashAd.destroy();
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.f24429e) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24429e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f24429e.get().setLayoutParams(layoutParams);
    }

    @Override // c.a.q0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f24428d == null || (weakReference = this.f24429e) == null || weakReference.get() == null || this.f24430f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f24429e.get().getChildCount() > 0) {
            this.f24429e.get().removeAllViews();
        }
        this.f24430f = AdLoadState.SHOWED;
        if (c.a.q0.t.a.h.b.f24480a) {
            String str = "bes gd show, and time is " + System.currentTimeMillis();
        }
        this.f24428d.show(this.f24429e.get());
    }
}
