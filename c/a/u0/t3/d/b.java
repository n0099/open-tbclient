package c.a.u0.t3.d;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.t0.d1.f;
import c.a.t0.l.d;
import c.a.t0.s0.l;
import c.a.u0.t3.b.c;
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
/* loaded from: classes9.dex */
public class b implements c.a.u0.t3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.u0.t3.b.b a;

    /* renamed from: b  reason: collision with root package name */
    public final c f22818b;

    /* renamed from: c  reason: collision with root package name */
    public d f22819c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f22820d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22821e;

    /* renamed from: f  reason: collision with root package name */
    public long f22822f;

    /* renamed from: g  reason: collision with root package name */
    public long f22823g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22824h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f22825i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f22826j;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22827e;

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
            this.f22827e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22827e.a.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("splash_request_timeout"));
            TbadkCoreApplication.getInst().isDebugMode();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, this.f22827e.f22819c));
            this.f22827e.f22822f = System.currentTimeMillis();
        }
    }

    /* renamed from: c.a.u0.t3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1403b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22828e;

        public RunnableC1403b(b bVar) {
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
            this.f22828e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22828e.f22821e || this.f22828e.f22820d == null) {
                return;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921657, Boolean.class);
            if (runTask == null || runTask.getData() == null || !((Boolean) runTask.getData()).booleanValue()) {
                TiebaStatic.log(new StatisticItem("splash_timeout_go_maintab"));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 0).param("obj_type", "a064").param("obj_param1", 1).eventStat();
                TbadkCoreApplication.getInst().isDebugMode();
                this.f22828e.a.getRootView().removeView(this.f22828e.f22820d);
                this.f22828e.f22818b.a();
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    }

    public b(c.a.u0.t3.b.b bVar, c cVar) {
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
        this.f22821e = false;
        this.f22822f = 0L;
        this.f22823g = -1L;
        this.f22824h = false;
        this.f22825i = new a(this);
        this.f22826j = new RunnableC1403b(this);
        this.a = bVar;
        this.f22818b = cVar;
    }

    @Override // c.a.u0.t3.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            d dVar = this.f22819c;
            if (dVar != null) {
                dVar.f(null);
                this.f22819c.e(null);
            }
        }
    }

    @Override // c.a.u0.t3.b.a
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22823g : invokeV.longValue;
    }

    public ViewGroup j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22820d : (ViewGroup) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22822f : invokeV.longValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e.a().postDelayed(this.f22826j, 500L);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f22824h = true;
            e.a().removeCallbacks(this.f22826j);
            e.a().removeCallbacks(this.f22825i);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f22821e = z;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
                this.f22818b.a();
            } else if (MessageManager.getInstance().findTask(2016555) == null) {
                this.f22818b.a();
            } else {
                p();
            }
        }
    }

    @Override // c.a.u0.t3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        d dVar;
        c.a.t0.l.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (dVar = this.f22819c) == null || (bVar = dVar.f13253c) == null) {
            return;
        }
        bVar.a();
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f22824h = false;
            long currentTimeMillis = System.currentTimeMillis();
            this.f22823g = System.currentTimeMillis();
            this.f22819c = new d(this.a.i(), this.a.j());
            this.f22820d = new RelativeLayout(this.a.getActivity());
            this.f22820d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.a.getRootView().addView(this.f22820d);
            this.f22819c.f(this.f22820d);
            this.f22819c.e(new c.a.u0.t3.d.a(this.a, this.f22818b, this));
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.f22819c);
            if (this.f22824h) {
                return;
            }
            l.b().j(System.currentTimeMillis() - currentTimeMillis);
            long longValue = runTask != null ? ((Long) runTask.getData()).longValue() : 1000L;
            if (c.a.t0.b.d.K0()) {
                e.a().postDelayed(this.f22826j, f.f() + 500);
            } else {
                e.a().postDelayed(this.f22825i, longValue);
            }
        }
    }
}
