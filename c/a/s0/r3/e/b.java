package c.a.s0.r3.e;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.r0.l.d;
import c.a.r0.r0.l;
import c.a.s0.r3.b.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b implements c.a.s0.r3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.s0.r3.b.b a;

    /* renamed from: b  reason: collision with root package name */
    public final c f21979b;

    /* renamed from: c  reason: collision with root package name */
    public d f21980c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f21981d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21982e;

    /* renamed from: f  reason: collision with root package name */
    public long f21983f;

    /* renamed from: g  reason: collision with root package name */
    public long f21984g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f21985h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f21986i;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21987e;

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
            this.f21987e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21987e.a.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("splash_request_timeout"));
            TbadkCoreApplication.getInst().isDebugMode();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, this.f21987e.f21980c));
            this.f21987e.f21983f = System.currentTimeMillis();
        }
    }

    /* renamed from: c.a.s0.r3.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1312b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21988e;

        public RunnableC1312b(b bVar) {
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
            this.f21988e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21988e.f21982e || this.f21988e.f21981d == null || this.f21988e.f21981d.getChildCount() != 0) {
                return;
            }
            TiebaStatic.log(new StatisticItem("splash_timeout_go_maintab"));
            TbadkCoreApplication.getInst().isDebugMode();
            this.f21988e.a.getRootView().removeView(this.f21988e.f21981d);
            this.f21988e.f21979b.a();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    }

    public b(c.a.s0.r3.b.b bVar, c cVar) {
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
        this.f21982e = false;
        this.f21983f = 0L;
        this.f21984g = -1L;
        this.f21985h = new a(this);
        this.f21986i = new RunnableC1312b(this);
        this.a = bVar;
        this.f21979b = cVar;
    }

    @Override // c.a.s0.r3.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            d dVar = this.f21980c;
            if (dVar != null) {
                dVar.d(null);
                this.f21980c.c(null);
            }
        }
    }

    @Override // c.a.s0.r3.b.a
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21984g : invokeV.longValue;
    }

    public ViewGroup j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21981d : (ViewGroup) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21983f : invokeV.longValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e.a().postDelayed(this.f21986i, 500L);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e.a().removeCallbacks(this.f21986i);
            e.a().removeCallbacks(this.f21985h);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f21982e = z;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
                this.f21979b.a();
            } else if (MessageManager.getInstance().findTask(2016555) == null) {
                this.f21979b.a();
            } else {
                p();
            }
        }
    }

    @Override // c.a.s0.r3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        d dVar;
        c.a.r0.l.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (dVar = this.f21980c) == null || (bVar = dVar.f12708c) == null) {
            return;
        }
        bVar.a();
    }

    @Override // c.a.s0.r3.b.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // c.a.s0.r3.b.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f21984g = System.currentTimeMillis();
            this.f21980c = new d();
            this.f21981d = new RelativeLayout(this.a.getActivity());
            this.f21981d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.a.getRootView().addView(this.f21981d);
            this.f21980c.d(this.f21981d);
            this.f21980c.c(new c.a.s0.r3.e.a(this.a, this.f21979b, this));
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.f21980c);
            l.b().j(System.currentTimeMillis() - currentTimeMillis);
            e.a().postDelayed(this.f21985h, runTask != null ? ((Long) runTask.getData()).longValue() : 1000L);
        }
    }
}
