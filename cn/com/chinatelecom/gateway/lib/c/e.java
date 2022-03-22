package cn.com.chinatelecom.gateway.lib.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.appcompat.widget.TooltipCompatHandler;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.net.InetAddress;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "e";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23692b;

    /* renamed from: c  reason: collision with root package name */
    public ConnectivityManager f23693c;

    /* renamed from: d  reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f23694d;

    /* renamed from: e  reason: collision with root package name */
    public a f23695e;

    /* renamed from: f  reason: collision with root package name */
    public long f23696f;

    /* renamed from: g  reason: collision with root package name */
    public long f23697g;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(int i, String str, long j);

        void a(Network network, long j);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1293515328, "Lcn/com/chinatelecom/gateway/lib/c/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1293515328, "Lcn/com/chinatelecom/gateway/lib/c/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23692b = false;
        this.f23693c = null;
        this.f23694d = null;
        this.f23696f = 0L;
        this.f23697g = 0L;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                byte[] address = InetAddress.getByName(str).getAddress();
                return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
            } catch (Throwable th) {
                CtAuth.warn(a, "When InetAddress.getByName(),throws exception", th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @TargetApi(21)
    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            this.f23696f = 0L;
            this.f23693c = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            this.f23697g = System.currentTimeMillis();
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback(this) { // from class: cn.com.chinatelecom.gateway.lib.c.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        e eVar = this.a;
                        eVar.f23696f = currentTimeMillis - eVar.f23697g;
                        this.a.f23692b = true;
                        if (this.a.f23695e != null) {
                            this.a.f23695e.a(network, this.a.f23696f);
                        }
                        if (this.a.f23693c != null) {
                            try {
                                this.a.f23693c.unregisterNetworkCallback(this);
                                this.a.f23693c = null;
                            } catch (Throwable th) {
                                CtAuth.warn(e.a, "switchToMobileForAboveL", th);
                            }
                        }
                    }
                }
            };
            this.f23694d = networkCallback;
            this.f23693c.requestNetwork(build, networkCallback);
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            int indexOf = str.indexOf("://");
            if (indexOf > 0) {
                str = str.substring(indexOf + 3);
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0) {
                str = str.substring(0, indexOf2);
            }
            int indexOf3 = str.indexOf(47);
            if (indexOf3 >= 0) {
                str = str.substring(0, indexOf3);
            }
            int indexOf4 = str.indexOf(63);
            return indexOf4 >= 0 ? str.substring(0, indexOf4) : str;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ConnectivityManager connectivityManager;
        ConnectivityManager.NetworkCallback networkCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || Build.VERSION.SDK_INT < 21 || (connectivityManager = this.f23693c) == null || (networkCallback = this.f23694d) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        } catch (Throwable th) {
            CtAuth.warn(a, "unregisterNetworkCallback", th);
        }
        this.f23693c = null;
    }

    private boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, context, str)) == null) {
            boolean z = false;
            try {
                Class<?> cls = Class.forName("android.net.ConnectivityManager");
                this.f23696f = 0L;
                this.f23697g = System.currentTimeMillis();
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                this.f23693c = connectivityManager;
                if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0) {
                    Method method = cls.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class);
                    ConnectivityManager connectivityManager2 = this.f23693c;
                    Object[] objArr = new Object[2];
                    objArr[0] = 0;
                    objArr[1] = "enableHIPRI";
                    method.invoke(connectivityManager2, objArr);
                    for (int i = 0; i < 5 && this.f23693c.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0; i++) {
                        Thread.sleep(500L);
                    }
                }
                z = ((Boolean) cls.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(this.f23693c, 5, Integer.valueOf(a(b(str))))).booleanValue();
                this.f23696f = System.currentTimeMillis() - this.f23697g;
                String str2 = a;
                StringBuilder sb = new StringBuilder();
                sb.append("Switch network result ： ");
                sb.append(z);
                sb.append(" (4.x) , expendTime ：");
                sb.append(this.f23696f);
                CtAuth.info(str2, sb.toString());
            } catch (Throwable th) {
                CtAuth.warn(a, "4.x网络切换异常", th);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            i.a().a(new Runnable(this, i) { // from class: cn.com.chinatelecom.gateway.lib.c.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f23698b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23698b = this;
                    this.a = i;
                }

                /* JADX WARN: Can't wrap try/catch for region: R(8:3|(4:25|26|27|(5:29|(1:31)|32|15|16))|5|6|(1:8)(1:22)|9|10|(2:12|(3:14|15|16)(2:18|19))(1:20)) */
                /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
                    cn.com.chinatelecom.gateway.lib.CtAuth.warn(cn.com.chinatelecom.gateway.lib.c.e.a, "timeoutCheckRunnable exception!", r0);
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.a > 2500) {
                            try {
                                Thread.sleep(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                            } catch (Throwable th) {
                                CtAuth.warn(e.a, "timeoutCheckRunnable exception!", th);
                            }
                            if (!this.f23698b.f23692b) {
                                if (this.f23698b.f23695e != null) {
                                    this.f23698b.f23695e.a(80800, "WIFI切换超时", TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                                }
                                CtAuth.info(e.a, "切换网络超时(L)");
                                this.f23698b.b();
                            }
                        }
                        Thread.sleep(this.a <= 2500 ? this.a : this.a - 2500);
                        if (this.f23698b.f23695e != null) {
                            if (this.f23698b.f23692b) {
                                this.f23698b.f23695e.a();
                                return;
                            }
                            this.f23698b.f23695e.a(80800, "WIFI切换超时", TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                            this.f23698b.b();
                        }
                    }
                }
            });
        }
    }

    public void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar) == null) {
            this.f23695e = aVar;
            try {
                a(context);
            } catch (Throwable th) {
                CtAuth.warn(a, "switchToMobileForAboveL", th);
                a aVar2 = this.f23695e;
                if (aVar2 != null) {
                    aVar2.a(80801, "WIFI切换异常", -1L);
                }
            }
        }
    }

    public boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) ? b(context, str) : invokeLL.booleanValue;
    }
}
