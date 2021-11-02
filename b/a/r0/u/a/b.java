package b.a.r0.u.a;

import android.content.Context;
import android.view.ViewGroup;
import b.a.e.e.p.l;
import b.a.q0.q0.j;
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
/* loaded from: classes5.dex */
public class b implements b.a.r0.u.a.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f23873b;

    /* renamed from: c  reason: collision with root package name */
    public int f23874c;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f23875d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f23876e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f23877f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.l.a f23878g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.l.b f23879h;

    /* loaded from: classes5.dex */
    public class a implements b.a.q0.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f23880a;

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
            this.f23880a = bVar;
        }

        @Override // b.a.q0.l.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23880a.o();
            }
        }
    }

    /* renamed from: b.a.r0.u.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1157b implements SplashLpCloseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f23881a;

        public C1157b(b bVar) {
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
            this.f23881a = bVar;
        }

        public final void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                b.a.e.e.n.a a2 = j.a();
                a2.b("type", "gd");
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
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f23949b, "0", i2);
                this.f23881a.f23877f = AdLoadState.SUCCEED;
                boolean z = b.a.r0.u.a.h.b.f23940a;
                this.f23881a.f23873b = rsplashType;
                if (this.f23881a.f23875d == null || this.f23881a.f23876e == null) {
                    return;
                }
                b.a.r0.u.a.h.a.c().h(this.f23881a.f23878g);
                a("advert_load", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = b.a.r0.u.a.h.b.f23940a;
                if (this.f23881a.f23878g != null) {
                    this.f23881a.f23878g.a(this.f23881a.f23873b == RsplashType.VIDEO, 1 == this.f23881a.f23874c, 1, null, null);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = b.a.r0.u.a.h.b.f23940a;
                boolean z2 = this.f23881a.f23877f == AdLoadState.DISMISSED;
                this.f23881a.f23877f = AdLoadState.DISMISSED;
                if (this.f23881a.f23878g != null && !z2) {
                    this.f23881a.f23878g.onAdDismiss();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f23881a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.f23881a.f23878g != null ? this.f23881a.f23878g.hashCode() : 0).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(z2)));
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f23949b, str, 0);
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f23949b, "1");
                if (b.a.r0.u.a.h.b.f23940a) {
                    String str2 = "bes gd loaded loaded failed :" + str;
                }
                this.f23881a.f23877f = AdLoadState.FAILED;
                b.a.r0.u.a.h.a.c().h(this.f23881a.f23878g);
                a("advert_show", 0);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (b.a.r0.u.a.h.b.f23940a) {
                    String str = "bes gd present, and time is " + System.currentTimeMillis();
                }
                boolean z = 1 == this.f23881a.f23874c;
                if (this.f23881a.f23878g != null) {
                    this.f23881a.f23878g.e(this.f23881a.f23873b == RsplashType.VIDEO, z, 1);
                }
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f23949b, "0");
                a("advert_show", 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f23881a.f23878g == null) {
                return;
            }
            this.f23881a.f23878g.onLpClosed();
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
        this.f23874c = 1;
        new AdSplashStyle();
        this.f23877f = AdLoadState.INIT;
        this.f23878g = null;
        this.f23879h = new a(this);
    }

    @Override // b.a.r0.u.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // b.a.r0.u.a.h.b
    public void b() {
        b.a.q0.l.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f23878g) == null) {
            return;
        }
        aVar.d();
    }

    @Override // b.a.r0.u.a.h.b
    public AdLoadState c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23877f : (AdLoadState) invokeV.objValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void d(b.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f12714c = this.f23879h;
        this.f23878g = dVar.a();
        this.f23876e = new WeakReference<>(dVar.b());
        C1157b c1157b = new C1157b(this);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + b.a.f0.a.b.a.f2781a.get().e());
            this.f23875d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + b.a.f0.a.b.a.f2781a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1157b);
            this.f23877f = AdLoadState.LOADING;
            this.f23875d.load();
            b.a.r0.u.a.j.a.i(b.a.r0.u.a.j.a.f23949b);
            boolean z = b.a.r0.u.a.h.b.f23940a;
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            b.a.q0.l.a aVar = this.f23878g;
            if (aVar != null) {
                aVar.b("oom");
            }
        }
    }

    @Override // b.a.r0.u.a.h.b
    public void destroy() {
        SplashAd splashAd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (splashAd = this.f23875d) == null) {
            return;
        }
        splashAd.destroy();
    }

    @Override // b.a.r0.u.a.h.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "bes_gd" : (String) invokeV.objValue;
    }

    public final void o() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (weakReference = this.f23876e) == null || weakReference.get().getParent() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f23876e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f23876e.get().setLayoutParams(layoutParams);
    }

    @Override // b.a.r0.u.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f23875d == null || (weakReference = this.f23876e) == null || weakReference.get() == null || this.f23877f != AdLoadState.SUCCEED) {
            return;
        }
        b.a.q0.l.a aVar = this.f23878g;
        if (aVar != null) {
            aVar.c();
        }
        o();
        if (this.f23876e.get().getChildCount() > 0) {
            this.f23876e.get().removeAllViews();
        }
        this.f23877f = AdLoadState.SHOWED;
        if (b.a.r0.u.a.h.b.f23940a) {
            String str = "bes gd show, and time is " + System.currentTimeMillis();
        }
        this.f23875d.show(this.f23876e.get());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", b.class.getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, 0));
    }
}
