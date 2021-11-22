package b.a.r0.u.a;

import android.content.Context;
import android.view.ViewGroup;
import b.a.e.f.p.l;
import b.a.q0.q0.j;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RsplashType;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashLpCloseListener;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
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
/* loaded from: classes5.dex */
public class b implements b.a.r0.u.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f25361b;

    /* renamed from: c  reason: collision with root package name */
    public int f25362c;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f25363d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f25364e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f25365f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.l.a f25366g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.l.b f25367h;

    /* loaded from: classes5.dex */
    public class a implements b.a.q0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25368a;

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
            this.f25368a = bVar;
        }

        @Override // b.a.q0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25368a.n();
            }
        }
    }

    /* renamed from: b.a.r0.u.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1224b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25369a;

        public C1224b(b bVar) {
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
            this.f25369a = bVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                b.a.e.f.n.a a2 = j.a();
                a2.b("type", "gd");
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
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f25437b, "0", i2);
                this.f25369a.f25365f = AdLoadState.SUCCEED;
                boolean z = b.a.r0.u.a.h.b.f25428a;
                this.f25369a.f25361b = rsplashType;
                if (this.f25369a.f25363d == null || this.f25369a.f25364e == null) {
                    return;
                }
                b.a.r0.u.a.h.a.c().h(this.f25369a.f25366g);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = b.a.r0.u.a.h.b.f25428a;
                if (this.f25369a.f25366g != null) {
                    this.f25369a.f25366g.a(this.f25369a.f25361b == RsplashType.VIDEO, 1 == this.f25369a.f25362c, 1, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = b.a.r0.u.a.h.b.f25428a;
                boolean z2 = this.f25369a.f25365f == AdLoadState.DISMISSED;
                this.f25369a.f25365f = AdLoadState.DISMISSED;
                if (this.f25369a.f25366g != null && !z2) {
                    this.f25369a.f25366g.onAdDismiss();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f25369a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.f25369a.f25366g != null ? this.f25369a.f25366g.hashCode() : 0).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(z2)));
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f25437b, str, 0);
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f25437b, "1");
                if (b.a.r0.u.a.h.b.f25428a) {
                    String str2 = "bes gd loaded loaded failed :" + str;
                }
                this.f25369a.f25365f = AdLoadState.FAILED;
                b.a.r0.u.a.h.a.c().h(this.f25369a.f25366g);
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (b.a.r0.u.a.h.b.f25428a) {
                    String str = "bes gd present, and time is " + System.currentTimeMillis();
                }
                boolean z = 1 == this.f25369a.f25362c;
                if (this.f25369a.f25366g != null) {
                    this.f25369a.f25366g.e(this.f25369a.f25361b == RsplashType.VIDEO, z, 1);
                }
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f25437b, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f25369a.f25366g == null) {
                return;
            }
            this.f25369a.f25366g.onLpClosed();
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
        this.f25362c = 1;
        new AdSplashStyle();
        this.f25365f = AdLoadState.INIT;
        this.f25366g = null;
        this.f25367h = new a(this);
    }

    @Override // b.a.r0.u.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // b.a.r0.u.a.h.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25365f : (AdLoadState) invokeV.objValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void c(b.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f13464c = this.f25367h;
        this.f25366g = dVar.a();
        this.f25364e = new WeakReference<>(dVar.b());
        C1224b c1224b = new C1224b(this);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + b.a.f0.a.b.a.f2874a.get().e());
            this.f25363d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + b.a.f0.a.b.a.f2874a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1224b);
            this.f25365f = AdLoadState.LOADING;
            this.f25363d.load();
            b.a.r0.u.a.j.a.i(b.a.r0.u.a.j.a.f25437b);
            boolean z = b.a.r0.u.a.h.b.f25428a;
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            b.a.q0.l.a aVar = this.f25366g;
            if (aVar != null) {
                aVar.b("oom");
            }
        }
    }

    @Override // b.a.r0.u.a.h.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "bes_gd" : (String) invokeV.objValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void destroy() {
        SplashAd splashAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (splashAd = this.f25363d) == null) {
            return;
        }
        splashAd.destroy();
    }

    public final void n() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f25364e) == null || weakReference.get().getParent() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f25364e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f25364e.get().setLayoutParams(layoutParams);
    }

    @Override // b.a.r0.u.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f25363d == null || (weakReference = this.f25364e) == null || weakReference.get() == null || this.f25365f != AdLoadState.SUCCEED) {
            return;
        }
        b.a.q0.l.a aVar = this.f25366g;
        if (aVar != null) {
            aVar.d();
        }
        n();
        if (this.f25364e.get().getChildCount() > 0) {
            this.f25364e.get().removeAllViews();
        }
        this.f25365f = AdLoadState.SHOWED;
        if (b.a.r0.u.a.h.b.f25428a) {
            String str = "bes gd show, and time is " + System.currentTimeMillis();
        }
        this.f25363d.show(this.f25364e.get());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", b.class.getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, 0));
    }
}
