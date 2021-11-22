package b.a.r0.i3.e;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.m.e;
import b.a.q0.q0.l;
import b.a.r0.i3.b.c;
import b.a.r0.i3.b.d;
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
/* loaded from: classes4.dex */
public class b implements b.a.r0.i3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f19469a;

    /* renamed from: b  reason: collision with root package name */
    public final d f19470b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.l.d f19471c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f19472d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19473e;

    /* renamed from: f  reason: collision with root package name */
    public long f19474f;

    /* renamed from: g  reason: collision with root package name */
    public long f19475g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f19476h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f19477i;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19478e;

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
            this.f19478e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19478e.f19469a.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("splash_request_timeout"));
            TbadkCoreApplication.getInst().isDebugMode();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, this.f19478e.f19471c));
            this.f19478e.f19474f = System.currentTimeMillis();
        }
    }

    /* renamed from: b.a.r0.i3.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0984b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19479e;

        public RunnableC0984b(b bVar) {
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
            this.f19479e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19479e.f19473e || this.f19479e.f19472d == null || this.f19479e.f19472d.getChildCount() != 0) {
                return;
            }
            TiebaStatic.log(new StatisticItem("splash_timeout_go_maintab"));
            TbadkCoreApplication.getInst().isDebugMode();
            this.f19479e.f19469a.getRootView().removeView(this.f19479e.f19472d);
            this.f19479e.f19470b.a();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    }

    public b(c cVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19473e = false;
        this.f19474f = 0L;
        this.f19475g = -1L;
        this.f19476h = new a(this);
        this.f19477i = new RunnableC0984b(this);
        this.f19469a = cVar;
        this.f19470b = dVar;
    }

    @Override // b.a.r0.i3.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            b.a.q0.l.d dVar = this.f19471c;
            if (dVar != null) {
                dVar.d(null);
                this.f19471c.c(null);
            }
        }
    }

    @Override // b.a.r0.i3.b.a
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19475g : invokeV.longValue;
    }

    public ViewGroup j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19472d : (ViewGroup) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19474f : invokeV.longValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e.a().postDelayed(this.f19477i, 500L);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e.a().removeCallbacks(this.f19477i);
            e.a().removeCallbacks(this.f19476h);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f19473e = z;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
                this.f19470b.a();
            } else if (MessageManager.getInstance().findTask(2016555) == null) {
                this.f19470b.a();
            } else {
                p();
            }
        }
    }

    @Override // b.a.r0.i3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        b.a.q0.l.d dVar;
        b.a.q0.l.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (dVar = this.f19471c) == null || (bVar = dVar.f13464c) == null) {
            return;
        }
        bVar.a();
    }

    @Override // b.a.r0.i3.b.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // b.a.r0.i3.b.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f19475g = System.currentTimeMillis();
            this.f19471c = new b.a.q0.l.d();
            this.f19472d = new RelativeLayout(this.f19469a.getActivity());
            this.f19472d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f19469a.getRootView().addView(this.f19472d);
            this.f19471c.d(this.f19472d);
            this.f19471c.c(new b.a.r0.i3.e.a(this.f19469a, this.f19470b, this));
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.f19471c);
            l.b().j(System.currentTimeMillis() - currentTimeMillis);
            e.a().postDelayed(this.f19476h, runTask != null ? ((Long) runTask.getData()).longValue() : 1000L);
        }
    }
}
