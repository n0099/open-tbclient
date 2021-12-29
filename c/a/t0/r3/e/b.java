package c.a.t0.r3.e;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.s0.l.d;
import c.a.s0.s0.l;
import c.a.t0.r3.b.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b implements c.a.t0.r3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.t0.r3.b.b a;

    /* renamed from: b  reason: collision with root package name */
    public final c f22491b;

    /* renamed from: c  reason: collision with root package name */
    public d f22492c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f22493d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22494e;

    /* renamed from: f  reason: collision with root package name */
    public long f22495f;

    /* renamed from: g  reason: collision with root package name */
    public long f22496g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f22497h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f22498i;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22499e;

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
            this.f22499e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22499e.a.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("splash_request_timeout"));
            TbadkCoreApplication.getInst().isDebugMode();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, this.f22499e.f22492c));
            this.f22499e.f22495f = System.currentTimeMillis();
        }
    }

    /* renamed from: c.a.t0.r3.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1340b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22500e;

        public RunnableC1340b(b bVar) {
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
            this.f22500e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22500e.f22494e || this.f22500e.f22493d == null) {
                return;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921657, Boolean.class);
            if (runTask == null || runTask.getData() == null || !((Boolean) runTask.getData()).booleanValue()) {
                TiebaStatic.log(new StatisticItem("splash_timeout_go_maintab"));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 0).param("obj_type", "a064").param("obj_param1", 1).eventStat();
                TbadkCoreApplication.getInst().isDebugMode();
                this.f22500e.a.getRootView().removeView(this.f22500e.f22493d);
                this.f22500e.f22491b.a();
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    }

    public b(c.a.t0.r3.b.b bVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22494e = false;
        this.f22495f = 0L;
        this.f22496g = -1L;
        this.f22497h = new a(this);
        this.f22498i = new RunnableC1340b(this);
        this.a = bVar;
        this.f22491b = cVar;
    }

    @Override // c.a.t0.r3.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            d dVar = this.f22492c;
            if (dVar != null) {
                dVar.d(null);
                this.f22492c.c(null);
            }
        }
    }

    @Override // c.a.t0.r3.b.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            o();
            return true;
        }
        return invokeV.booleanValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22496g : invokeV.longValue;
    }

    public ViewGroup j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22493d : (ViewGroup) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22495f : invokeV.longValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e.a().postDelayed(this.f22498i, 500L);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e.a().removeCallbacks(this.f22498i);
            e.a().removeCallbacks(this.f22497h);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f22494e = z;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
                this.f22491b.a();
            } else if (MessageManager.getInstance().findTask(2016555) == null) {
                this.f22491b.a();
            } else {
                p();
            }
        }
    }

    @Override // c.a.t0.r3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        d dVar;
        c.a.s0.l.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (dVar = this.f22492c) == null || (bVar = dVar.f13172c) == null) {
            return;
        }
        bVar.a();
    }

    @Override // c.a.t0.r3.b.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // c.a.t0.r3.b.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f22496g = System.currentTimeMillis();
            this.f22492c = new d();
            this.f22493d = new RelativeLayout(this.a.getActivity());
            this.f22493d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.a.getRootView().addView(this.f22493d);
            this.f22492c.d(this.f22493d);
            this.f22492c.c(new c.a.t0.r3.e.a(this.a, this.f22491b, this));
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.f22492c);
            l.b().j(System.currentTimeMillis() - currentTimeMillis);
            e.a().postDelayed(this.f22497h, runTask != null ? ((Long) runTask.getData()).longValue() : 1000L);
        }
    }
}
