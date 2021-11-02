package b.a.r0.h3.e;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.m.e;
import b.a.q0.q0.l;
import b.a.r0.h3.b.c;
import b.a.r0.h3.b.d;
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
public class b implements b.a.r0.h3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f17758a;

    /* renamed from: b  reason: collision with root package name */
    public final d f17759b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.l.d f17760c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f17761d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17762e;

    /* renamed from: f  reason: collision with root package name */
    public long f17763f;

    /* renamed from: g  reason: collision with root package name */
    public long f17764g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f17765h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f17766i;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17767e;

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
            this.f17767e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17767e.f17758a.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("splash_request_timeout"));
            TbadkCoreApplication.getInst().isDebugMode();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, this.f17767e.f17760c));
            this.f17767e.f17763f = System.currentTimeMillis();
        }
    }

    /* renamed from: b.a.r0.h3.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0905b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17768e;

        public RunnableC0905b(b bVar) {
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
            this.f17768e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17768e.f17762e || this.f17768e.f17761d == null || this.f17768e.f17761d.getChildCount() != 0) {
                return;
            }
            TiebaStatic.log(new StatisticItem("splash_timeout_go_maintab"));
            TbadkCoreApplication.getInst().isDebugMode();
            this.f17768e.f17758a.getRootView().removeView(this.f17768e.f17761d);
            this.f17768e.f17759b.a();
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
        this.f17762e = false;
        this.f17763f = 0L;
        this.f17764g = -1L;
        this.f17765h = new a(this);
        this.f17766i = new RunnableC0905b(this);
        this.f17758a = cVar;
        this.f17759b = dVar;
    }

    @Override // b.a.r0.h3.b.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            b.a.q0.l.d dVar = this.f17760c;
            if (dVar != null) {
                dVar.d(null);
                this.f17760c.c(null);
            }
        }
    }

    @Override // b.a.r0.h3.b.a
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17764g : invokeV.longValue;
    }

    public ViewGroup j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17761d : (ViewGroup) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f17763f : invokeV.longValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e.a().postDelayed(this.f17766i, 500L);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e.a().removeCallbacks(this.f17766i);
            e.a().removeCallbacks(this.f17765h);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f17762e = z;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
                this.f17759b.a();
            } else if (MessageManager.getInstance().findTask(2016555) == null) {
                this.f17759b.a();
            } else {
                p();
            }
        }
    }

    @Override // b.a.r0.h3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        b.a.q0.l.d dVar;
        b.a.q0.l.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (dVar = this.f17760c) == null || (bVar = dVar.f12714c) == null) {
            return;
        }
        bVar.a();
    }

    @Override // b.a.r0.h3.b.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // b.a.r0.h3.b.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f17764g = System.currentTimeMillis();
            this.f17760c = new b.a.q0.l.d();
            this.f17761d = new RelativeLayout(this.f17758a.getActivity());
            this.f17761d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f17758a.getRootView().addView(this.f17761d);
            this.f17760c.d(this.f17761d);
            this.f17760c.c(new b.a.r0.h3.e.a(this.f17758a, this.f17759b, this));
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.f17760c);
            l.b().j(System.currentTimeMillis() - currentTimeMillis);
            e.a().postDelayed(this.f17765h, runTask != null ? ((Long) runTask.getData()).longValue() : 1000L);
        }
    }
}
