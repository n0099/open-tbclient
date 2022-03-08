package c.a.u.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.u.a.a.d;
import c.a.u.a.a.g;
import c.a.u.a.f.b;
import c.a.u.a.h.e;
import c.a.u.a.h.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes3.dex */
public class c implements b.a, Observer {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c.a.u.a.b.b f26165h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile c f26166i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f26167e;

    /* renamed from: f  reason: collision with root package name */
    public int f26168f;

    /* renamed from: g  reason: collision with root package name */
    public b f26169g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c this$0;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f26170e;

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
                this.f26170e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f26170e.this$0.d("netchange");
                }
            }
        }

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                e.a("LCPClientManager", "NetStatusReceiver changed");
                if (RequsetNetworkUtils.isNetworkAvailable(context) && f.m(context)) {
                    e.b("LCPClientManager", "NetStatusReceiver reconnect");
                    c.a.u.a.g.a.a(context).b(new a(this));
                }
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1083047373, "Lc/a/u/a/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1083047373, "Lc/a/u/a/b/c;");
                return;
            }
        }
        f26165h = new c.a.u.a.b.b();
        new LinkedHashMap();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26168f = -1;
        new LinkedBlockingQueue();
    }

    public static synchronized c e() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (c.class) {
                if (f26166i == null) {
                    synchronized (c.class) {
                        if (f26166i == null) {
                            f26166i = new c();
                        }
                    }
                }
                cVar = f26166i;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f26165h.a : invokeV.intValue;
    }

    public void b(Context context, String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Integer.valueOf(i2), str3}) == null) {
            if (f26165h.a != -2 && f26165h.a != 0) {
                if (!TextUtils.isEmpty(str3) && UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE.equals(str3)) {
                    d.h(context).f();
                }
                c(context, str, str2, i2, str3);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SocketConnect state is ");
            sb.append(f26165h.a == 0 ? "connected" : "connecting");
            e.a("LCPClientManager", sb.toString());
        }
    }

    public synchronized void c(Context context, String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, Integer.valueOf(i2), str3}) == null) {
            synchronized (this) {
                if (context == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && RequsetNetworkUtils.isConnected(context)) {
                    this.f26167e = context;
                    if (TextUtils.isEmpty(f.b(context))) {
                        f.q(context, str);
                    }
                    if (TextUtils.isEmpty(f.e(context))) {
                        f.s(context, str2);
                    }
                    c.a.u.a.c.e.S(context).addObserver(f26166i);
                    if (f26165h.a != -2 && f26165h.a != 0) {
                        if (this.f26169g == null) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                            b bVar = new b(this, null);
                            this.f26169g = bVar;
                            context.registerReceiver(bVar, intentFilter);
                        }
                        if (g.f(context) && !d.i().booleanValue()) {
                            d.h(context).e(context, String.valueOf(601110), 10);
                            g.m(context, i2);
                        }
                        if (!f.k(context)) {
                            if (this.f26168f < 0) {
                                c.a.u.a.a.a.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", str3).c("token_begin", System.currentTimeMillis());
                                l();
                            }
                            return;
                        }
                        e.b("LCPClientManager", "token is not null ");
                        c.a.u.a.a.a.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", str3);
                        k(0);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("SocketConnect state is ");
                    sb.append(f26165h.a == 0 ? "connected" : "connecting");
                    e.a("LCPClientManager", sb.toString());
                    return;
                }
                e.a("LCPClientManager", "flow 参数错误、网络错误无法连接 增加打点");
                c.a.u.a.a.a.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("P0", "connect param not correct or net unconnected").d("con_err_code", "P0").c("flow_end_time", System.currentTimeMillis()).d("source", str3).e();
            }
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Context context = this.f26167e;
            b(context, f.b(context), f.e(this.f26167e), g.c(this.f26167e), str);
        }
    }

    public void g(@NonNull BLCPRequest bLCPRequest, @Nullable c.a.u.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bLCPRequest, bVar) == null) {
            Context context = this.f26167e;
            if (context == null || !f.m(context)) {
                if (bVar != null) {
                    bVar.onResponse(8010, "unconnected", bLCPRequest.a, bLCPRequest.f33258b, bLCPRequest.f33260d, new byte[0]);
                }
            } else if (f26165h.a != 0) {
                if (!(bLCPRequest instanceof c.a.u.a.b.d.a) && bVar != null) {
                    bVar.onResponse(8010, "unconnected", bLCPRequest.a, bLCPRequest.f33258b, bLCPRequest.f33260d, new byte[0]);
                }
                if (f26165h.a == -1 || !j()) {
                    d("invoke");
                }
            } else {
                c.a.u.a.c.e.S(this.f26167e).H(bLCPRequest, bVar);
                if (bLCPRequest.f33258b == 1 && bLCPRequest.a == 4) {
                    e.a("LCPClientManager", "云控登录打点");
                    Context context2 = this.f26167e;
                    c.a.u.a.h.b.a(context2, 1L, "invoke", bLCPRequest.f33260d + "");
                }
                if (bLCPRequest.f33258b == 50 && bLCPRequest.a == 2) {
                    Context context3 = this.f26167e;
                    c.a.u.a.h.b.a(context3, 50L, "invoke", bLCPRequest.f33260d + "");
                }
            }
        }
    }

    public void h() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (context = this.f26167e) == null) {
            return;
        }
        c.a.u.a.c.e.S(context).b0();
    }

    public void i(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, context) == null) || context == null) {
            return;
        }
        this.f26167e = context;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Context context = this.f26167e;
            return context == null || c.a.u.a.c.e.S(context).R().a != -1;
        }
        return invokeV.booleanValue;
    }

    public final void k(int i2) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && (context = this.f26167e) != null && f.m(context)) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return;
                }
                e.a("LCPClientManager", "socketAction closeSocket");
                c.a.u.a.c.e.S(this.f26167e).i0("socketAction closeSocket:", c.a.u.a.c.e.S(this.f26167e).x);
                return;
            }
            e.a("LCPClientManager", "socketAction createSocket");
            f26165h.a = -2;
            c.a.u.a.a.a.h(this.f26167e).g(601110).d("P8", "socketAction createSocket").d("con_err_code", "P8");
            c.a.u.a.c.e.S(this.f26167e).h0();
        }
    }

    public void l() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Context context2 = this.f26167e;
            if (context2 != null && RequsetNetworkUtils.isConnected(context2)) {
                this.f26168f++;
                c.a.u.a.a.a.h(this.f26167e).g(601110).b("token_count", this.f26168f);
                e.a("LCPClientManager", "no token, so request token, and tryCount = " + this.f26168f);
                if (this.f26168f < 3) {
                    c.a.u.a.f.b bVar = new c.a.u.a.f.b(this.f26167e, this);
                    c.a.u.a.f.c.e(bVar, bVar);
                    return;
                }
                this.f26168f = -1;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("context = ");
            sb.append(this.f26167e);
            sb.append(", net :");
            sb.append(this.f26167e == null ? "" : Boolean.valueOf(!RequsetNetworkUtils.isConnected(context)));
            e.a("LCPClientManager", sb.toString());
            c.a.u.a.a.a.h(this.f26167e).g(601110).d("P1", "token request net unconnected").d("con_err_code", "P1").c("flow_end_time", System.currentTimeMillis()).e();
        }
    }

    @Override // c.a.u.a.f.b.a
    public void onFailure(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            e.b("LCPClientManager", "getToken :" + str);
            c.a.u.a.a.c g2 = c.a.u.a.a.a.h(this.f26167e).g(601110);
            g2.d("P4", "getToken errCode:" + i2 + ",errMsg:" + str).d("con_err_code", "P4");
            l();
            if (this.f26168f == 2) {
                c.a.u.a.a.c c2 = c.a.u.a.a.a.h(this.f26167e).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P5", "token request count is max:" + this.f26168f).d("con_err_code", "P5").e();
                f26165h.a = -1;
                c.a.u.a.c.e.S(this.f26167e).Z();
            }
        }
    }

    @Override // c.a.u.a.f.b.a
    public void onResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.u.a.a.a.h(this.f26167e).g(601110).d("P3", "accessToken success").d("con_err_code", "P3");
            this.f26168f = -1;
            k(0);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, observable, obj) == null) && (obj instanceof c.a.u.a.b.b)) {
            f26165h.a = ((c.a.u.a.b.b) obj).a;
            e.a("LCPClientManager", "Manager update connectState :" + f26165h.a);
        }
    }
}
