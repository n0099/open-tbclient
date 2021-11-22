package b.a.p0.a.t1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import b.a.p0.a.h0.g.l;
import b.a.p0.a.n2.n;
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
    public Timer P0;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f8459c;

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
            this.f8459c = jVar;
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.e0.d.k("SwanAppWxPayFragment", "title: " + str);
            }
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                b.a.p0.a.e0.d.k("SwanAppWxPayFragment", "onReceivedSslError:  statusCode = " + i2);
            }
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (str != null && str.startsWith("weixin://wap/pay")) {
                    b.a.p0.a.e0.d.i("SwanAppWxPayFragment", " weixin  url:   " + str);
                    n.K("wechatH5Action", "intoPayment", 0);
                    this.f8459c.P0.cancel();
                    this.f8459c.P0 = null;
                    l.V2();
                    return false;
                }
                return super.c(str);
            }
            return invokeL.booleanValue;
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void d(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, str2) == null) {
                String str3 = "onReceivedError:  failingUrl = " + str2 + " errorCode = " + i2 + " description = " + str;
                b.a.p0.a.e0.d.k("SwanAppWxPayFragment", str3);
                n.H(false, "wechatH5Action", n.m(str2, str3));
            }
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                b.a.p0.a.e0.d.k("SwanAppWxPayFragment", "url: " + str);
            }
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                b.a.p0.a.e0.d.k("SwanAppWxPayFragment", "goBack: ");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.e0.d.k("SwanAppWxPayFragment", " WeChat H5 pay redirect time out : ");
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

    @Override // b.a.p0.a.h0.g.l, b.a.p0.a.h0.g.d
    public void R1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            super.R1(view);
            this.o0.setTitle(getResources().getString(b.a.p0.a.h.aiapps_wx_pay_title));
            u2(false);
        }
    }

    @Override // b.a.p0.a.h0.g.l
    public void T2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout) == null) {
            frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(b.a.p0.a.g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // b.a.p0.a.h0.g.l
    public b.a.p0.a.h0.j.d W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (b.a.p0.a.h0.j.d) invokeV.objValue;
    }

    public Timer f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.p0.a.e0.d.k("SwanAppWxPayFragment", " start WeChat H5 redirect timer start : ");
            Timer timer = new Timer();
            try {
                timer.schedule(new b(this), 10000L);
            } catch (Exception e2) {
                if (l.O0) {
                    e2.printStackTrace();
                }
                b.a.p0.a.e0.d.k("SwanAppWxPayFragment", e2.getMessage());
            }
            return timer;
        }
        return (Timer) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.l
    public b.a.p0.a.p.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.P0 == null) {
                this.P0 = f3();
            }
            return b.a.p0.a.h0.u.g.U().f0().i(getContext());
        }
        return (b.a.p0.a.p.e.e) invokeV.objValue;
    }
}
