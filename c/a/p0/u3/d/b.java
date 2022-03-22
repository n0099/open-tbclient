package c.a.p0.u3.d;

import android.content.res.Configuration;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.o0.c1.f;
import c.a.o0.k.d;
import c.a.o0.r0.k;
import c.a.p0.u3.b.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
/* loaded from: classes2.dex */
public class b implements c.a.p0.u3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.u3.b.b a;

    /* renamed from: b  reason: collision with root package name */
    public final c f19008b;

    /* renamed from: c  reason: collision with root package name */
    public d f19009c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f19010d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19011e;

    /* renamed from: f  reason: collision with root package name */
    public long f19012f;

    /* renamed from: g  reason: collision with root package name */
    public long f19013g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19014h;
    public final Runnable i;
    public final Runnable j;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.a()) {
                return;
            }
            SpeedStatsManager.getInstance().setIsTimeout(true);
            TiebaStatic.log(new StatisticItem("splash_request_timeout"));
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                Log.d("IAdSdkSplash", "请求time out and switch next");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, this.a.f19009c));
            this.a.f19012f = System.currentTimeMillis();
        }
    }

    /* renamed from: c.a.p0.u3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1439b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public RunnableC1439b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f19011e || this.a.f19010d == null) {
                return;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921657, Boolean.class);
            if (runTask == null || runTask.getData() == null || !((Boolean) runTask.getData()).booleanValue()) {
                TiebaStatic.log(new StatisticItem("splash_timeout_go_maintab"));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 0).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_PARAM2, this.a.a.i() ? 2 : 1).param("obj_param1", 1).eventStat();
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    Log.d("IAdSdkSplash", "兜底time out and jump maintab");
                }
                this.a.a.getRootView().removeView(this.a.f19010d);
                this.a.f19008b.a();
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    }

    public b(c.a.p0.u3.b.b bVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19011e = false;
        this.f19012f = 0L;
        this.f19013g = -1L;
        this.f19014h = false;
        this.i = new a(this);
        this.j = new RunnableC1439b(this);
        this.a = bVar;
        this.f19008b = cVar;
    }

    @Override // c.a.p0.u3.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            d dVar = this.f19009c;
            if (dVar != null) {
                dVar.f(null);
                this.f19009c.e(null);
            }
        }
    }

    @Override // c.a.p0.u3.b.a
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19013g : invokeV.longValue;
    }

    public ViewGroup j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19010d : (ViewGroup) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19012f : invokeV.longValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e.a().postDelayed(this.j, 500L);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f19014h = true;
            e.a().removeCallbacks(this.j);
            e.a().removeCallbacks(this.i);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f19011e = z;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
                this.f19008b.a();
            } else if (MessageManager.getInstance().findTask(2016555) == null) {
                this.f19008b.a();
            } else {
                p();
            }
        }
    }

    @Override // c.a.p0.u3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        d dVar;
        c.a.o0.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (dVar = this.f19009c) == null || (bVar = dVar.f10363c) == null) {
            return;
        }
        bVar.a();
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f19014h = false;
            long currentTimeMillis = System.currentTimeMillis();
            this.f19013g = System.currentTimeMillis();
            this.f19009c = new d(this.a.i(), this.a.j());
            this.f19010d = new RelativeLayout(this.a.getActivity());
            this.f19010d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.a.getRootView().addView(this.f19010d);
            this.f19009c.f(this.f19010d);
            this.f19009c.e(new c.a.p0.u3.d.a(this.a, this.f19008b, this));
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.f19009c);
            if (this.f19014h) {
                return;
            }
            k.b().j(System.currentTimeMillis() - currentTimeMillis);
            long longValue = runTask != null ? ((Long) runTask.getData()).longValue() : 1000L;
            if (UbsABTestHelper.newSplashStrategy()) {
                e.a().postDelayed(this.j, f.l() + 500);
            } else {
                e.a().postDelayed(this.i, longValue);
            }
        }
    }
}
