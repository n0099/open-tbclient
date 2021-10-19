package c.a.r0.u.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
import c.a.q0.q0.j;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RsplashType;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashLpCloseListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
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
public class b implements c.a.r0.u.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f25027b;

    /* renamed from: c  reason: collision with root package name */
    public int f25028c;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f25029d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f25030e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f25031f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.l.b f25032g;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25033a;

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
            this.f25033a = bVar;
        }

        @Override // c.a.q0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25033a.m();
            }
        }
    }

    /* renamed from: c.a.r0.u.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1158b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.l.a f25034a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f25035b;

        public C1158b(b bVar, c.a.q0.l.a aVar) {
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
            this.f25035b = bVar;
            this.f25034a = aVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("type", "gd");
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
                c.a.r0.u.a.j.a.j(c.a.r0.u.a.j.a.f25105b, "0", i2);
                this.f25035b.f25031f = AdLoadState.SUCCEED;
                boolean z = c.a.r0.u.a.h.b.f25096a;
                this.f25035b.f25027b = rsplashType;
                if (this.f25035b.f25029d == null || this.f25035b.f25030e == null) {
                    return;
                }
                c.a.r0.u.a.h.a.c().h(this.f25034a);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = c.a.r0.u.a.h.b.f25096a;
                c.a.q0.l.a aVar = this.f25034a;
                if (aVar != null) {
                    aVar.b(this.f25035b.f25027b == RsplashType.VIDEO, 1 == this.f25035b.f25028c, 1, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = c.a.r0.u.a.h.b.f25096a;
                boolean z2 = this.f25035b.f25031f == AdLoadState.DISMISSED;
                this.f25035b.f25031f = AdLoadState.DISMISSED;
                c.a.q0.l.a aVar = this.f25034a;
                if (aVar != null && !z2) {
                    aVar.onAdDismiss();
                }
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f25035b.getClass().getSimpleName()).param("obj_param1", 1);
                c.a.q0.l.a aVar2 = this.f25034a;
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, aVar2 != null ? aVar2.hashCode() : 0).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(z2)));
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                c.a.r0.u.a.j.a.j(c.a.r0.u.a.j.a.f25105b, str, 0);
                c.a.r0.u.a.j.a.k(c.a.r0.u.a.j.a.f25105b, "1");
                if (c.a.r0.u.a.h.b.f25096a) {
                    String str2 = "bes gd loaded loaded failed :" + str;
                }
                this.f25035b.f25031f = AdLoadState.FAILED;
                c.a.r0.u.a.h.a.c().h(this.f25034a);
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (c.a.r0.u.a.h.b.f25096a) {
                    String str = "bes gd present, and time is " + System.currentTimeMillis();
                }
                boolean z = 1 == this.f25035b.f25028c;
                c.a.q0.l.a aVar = this.f25034a;
                if (aVar != null) {
                    aVar.c(this.f25035b.f25027b == RsplashType.VIDEO, z, 1);
                }
                c.a.r0.u.a.j.a.k(c.a.r0.u.a.j.a.f25105b, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            c.a.q0.l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f25034a) == null) {
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
        this.f25028c = 1;
        new AdSplashStyle();
        this.f25031f = AdLoadState.INIT;
        this.f25032g = new a(this);
    }

    @Override // c.a.r0.u.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.a.r0.u.a.h.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25031f : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.r0.u.a.h.b
    public void c(c.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f13576c = this.f25032g;
        c.a.q0.l.a a2 = dVar.a();
        this.f25030e = new WeakReference<>(dVar.b());
        C1158b c1158b = new C1158b(this, a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + c.a.f0.a.b.a.f3338a.get().e());
            this.f25029d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + c.a.f0.a.b.a.f3338a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1158b);
            this.f25031f = AdLoadState.LOADING;
            this.f25029d.load();
            c.a.r0.u.a.j.a.i(c.a.r0.u.a.j.a.f25105b);
            boolean z = c.a.r0.u.a.h.b.f25096a;
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // c.a.r0.u.a.h.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "bes_gd" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.u.a.h.b
    public void destroy() {
        SplashAd splashAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (splashAd = this.f25029d) == null) {
            return;
        }
        splashAd.destroy();
    }

    public final void m() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f25030e) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25030e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f25030e.get().setLayoutParams(layoutParams);
    }

    @Override // c.a.r0.u.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f25029d == null || (weakReference = this.f25030e) == null || weakReference.get() == null || this.f25031f != AdLoadState.SUCCEED) {
            return;
        }
        m();
        if (this.f25030e.get().getChildCount() > 0) {
            this.f25030e.get().removeAllViews();
        }
        this.f25031f = AdLoadState.SHOWED;
        if (c.a.r0.u.a.h.b.f25096a) {
            String str = "bes gd show, and time is " + System.currentTimeMillis();
        }
        this.f25029d.show(this.f25030e.get());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", b.class.getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, 0));
    }
}
