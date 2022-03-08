package c.a.r0.s3.d;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.q0.c1.f;
import c.a.q0.k.d;
import c.a.q0.r0.k;
import c.a.r0.s3.b.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
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
public class b implements c.a.r0.s3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.r0.s3.b.b a;

    /* renamed from: b  reason: collision with root package name */
    public final c f22113b;

    /* renamed from: c  reason: collision with root package name */
    public d f22114c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f22115d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22116e;

    /* renamed from: f  reason: collision with root package name */
    public long f22117f;

    /* renamed from: g  reason: collision with root package name */
    public long f22118g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22119h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f22120i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f22121j;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22122e;

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
            this.f22122e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22122e.a.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("splash_request_timeout"));
            TbadkCoreApplication.getInst().isDebugMode();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, this.f22122e.f22114c));
            this.f22122e.f22117f = System.currentTimeMillis();
        }
    }

    /* renamed from: c.a.r0.s3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1386b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22123e;

        public RunnableC1386b(b bVar) {
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
            this.f22123e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22123e.f22116e || this.f22123e.f22115d == null) {
                return;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921657, Boolean.class);
            if (runTask == null || runTask.getData() == null || !((Boolean) runTask.getData()).booleanValue()) {
                TiebaStatic.log(new StatisticItem("splash_timeout_go_maintab"));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 0).param("obj_type", "a064").param("obj_param1", 1).eventStat();
                TbadkCoreApplication.getInst().isDebugMode();
                this.f22123e.a.getRootView().removeView(this.f22123e.f22115d);
                this.f22123e.f22113b.a();
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    }

    public b(c.a.r0.s3.b.b bVar, c cVar) {
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
        this.f22116e = false;
        this.f22117f = 0L;
        this.f22118g = -1L;
        this.f22119h = false;
        this.f22120i = new a(this);
        this.f22121j = new RunnableC1386b(this);
        this.a = bVar;
        this.f22113b = cVar;
    }

    @Override // c.a.r0.s3.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            d dVar = this.f22114c;
            if (dVar != null) {
                dVar.f(null);
                this.f22114c.e(null);
            }
        }
    }

    @Override // c.a.r0.s3.b.a
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22118g : invokeV.longValue;
    }

    public ViewGroup j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22115d : (ViewGroup) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22117f : invokeV.longValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e.a().postDelayed(this.f22121j, 500L);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f22119h = true;
            e.a().removeCallbacks(this.f22121j);
            e.a().removeCallbacks(this.f22120i);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f22116e = z;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
                this.f22113b.a();
            } else if (MessageManager.getInstance().findTask(2016555) == null) {
                this.f22113b.a();
            } else {
                p();
            }
        }
    }

    @Override // c.a.r0.s3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        d dVar;
        c.a.q0.k.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (dVar = this.f22114c) == null || (bVar = dVar.f12669c) == null) {
            return;
        }
        bVar.a();
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f22119h = false;
            long currentTimeMillis = System.currentTimeMillis();
            this.f22118g = System.currentTimeMillis();
            this.f22114c = new d(this.a.i(), this.a.j());
            this.f22115d = new RelativeLayout(this.a.getActivity());
            this.f22115d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.a.getRootView().addView(this.f22115d);
            this.f22114c.f(this.f22115d);
            this.f22114c.e(new c.a.r0.s3.d.a(this.a, this.f22113b, this));
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.f22114c);
            if (this.f22119h) {
                return;
            }
            k.b().j(System.currentTimeMillis() - currentTimeMillis);
            long longValue = runTask != null ? ((Long) runTask.getData()).longValue() : 1000L;
            if (UbsABTestHelper.newSplashStrategy()) {
                e.a().postDelayed(this.f22121j, f.f() + 500);
            } else {
                e.a().postDelayed(this.f22120i, longValue);
            }
        }
    }
}
