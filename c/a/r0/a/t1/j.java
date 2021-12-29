package c.a.r0.a.t1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import c.a.r0.a.h0.g.l;
import c.a.r0.a.n2.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class j extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer Q0;

    /* loaded from: classes.dex */
    public class a extends c.a.r0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f9075c;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9075c = jVar;
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.r0.a.e0.d.k("SwanAppWxPayFragment", "title: " + str);
            }
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.r0.a.e0.d.k("SwanAppWxPayFragment", "onReceivedSslError:  statusCode = " + i2);
            }
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (str != null && str.startsWith("weixin://wap/pay")) {
                    c.a.r0.a.e0.d.i("SwanAppWxPayFragment", " weixin  url:   " + str);
                    n.K("wechatH5Action", "intoPayment", 0);
                    this.f9075c.Q0.cancel();
                    this.f9075c.Q0 = null;
                    l.S2();
                    return false;
                }
                return super.c(str);
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void d(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, str2) == null) {
                String str3 = "onReceivedError:  failingUrl = " + str2 + " errorCode = " + i2 + " description = " + str;
                c.a.r0.a.e0.d.k("SwanAppWxPayFragment", str3);
                n.H(false, "wechatH5Action", n.m(str2, str3));
            }
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                c.a.r0.a.e0.d.k("SwanAppWxPayFragment", "url: " + str);
            }
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                c.a.r0.a.e0.d.k("SwanAppWxPayFragment", "goBack: ");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f9076e;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9076e = jVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.e0.d.k("SwanAppWxPayFragment", " WeChat H5 pay redirect time out : ");
                n.K("wechatH5Action", "outOfTime", 0);
            }
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.r0.a.h0.g.l, c.a.r0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            super.O1(view);
            this.k0.setTitle(getResources().getString(c.a.r0.a.h.aiapps_wx_pay_title));
            r2(false);
        }
    }

    @Override // c.a.r0.a.h0.g.l
    public void Q2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout) == null) {
            frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(c.a.r0.a.g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // c.a.r0.a.h0.g.l
    public c.a.r0.a.h0.j.d T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (c.a.r0.a.h0.j.d) invokeV.objValue;
    }

    public Timer c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.a.e0.d.k("SwanAppWxPayFragment", " start WeChat H5 redirect timer start : ");
            Timer timer = new Timer();
            try {
                timer.schedule(new b(this), 10000L);
            } catch (Exception e2) {
                if (l.P0) {
                    e2.printStackTrace();
                }
                c.a.r0.a.e0.d.k("SwanAppWxPayFragment", e2.getMessage());
            }
            return timer;
        }
        return (Timer) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.g.l
    public c.a.r0.a.p.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.Q0 == null) {
                this.Q0 = c3();
            }
            return c.a.r0.a.h0.u.g.U().f0().i(getContext());
        }
        return (c.a.r0.a.p.e.e) invokeV.objValue;
    }
}
