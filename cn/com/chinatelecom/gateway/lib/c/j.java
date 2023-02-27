package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "j";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public ConnectivityManager c;
    public ConnectivityManager.NetworkCallback d;
    public m e;
    public long f;
    public long g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1293515173, "Lcn/com/chinatelecom/gateway/lib/c/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1293515173, "Lcn/com/chinatelecom/gateway/lib/c/j;");
        }
    }

    public j() {
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
        this.b = false;
        this.c = null;
        this.d = null;
        this.f = 0L;
        this.g = 0L;
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

    public static /* synthetic */ ConnectivityManager a(j jVar, ConnectivityManager connectivityManager) {
        jVar.c = null;
        return null;
    }

    public static /* synthetic */ boolean a(j jVar, boolean z) {
        jVar.b = true;
        return true;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
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

    private boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, context, str)) == null) {
            boolean z = false;
            try {
                Class<?> cls = Class.forName("android.net.ConnectivityManager");
                this.f = 0L;
                this.g = System.currentTimeMillis();
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                this.c = connectivityManager;
                if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0) {
                    cls.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class).invoke(this.c, 0, "enableHIPRI");
                    for (int i = 0; i < 5 && this.c.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0; i++) {
                        Thread.sleep(500L);
                    }
                }
                z = ((Boolean) cls.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(this.c, 5, Integer.valueOf(a(b(str))))).booleanValue();
                this.f = System.currentTimeMillis() - this.g;
                String str2 = a;
                CtAuth.info(str2, "Switch network result ： " + z + " (4.x) , expendTime ：" + this.f);
                return z;
            } catch (Throwable th) {
                CtAuth.warn(a, "4.x网络切换异常", th);
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public static /* synthetic */ void c(j jVar) {
        ConnectivityManager connectivityManager;
        ConnectivityManager.NetworkCallback networkCallback;
        if (Build.VERSION.SDK_INT < 21 || (connectivityManager = jVar.c) == null || (networkCallback = jVar.d) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        } catch (Throwable th) {
            CtAuth.warn(a, "unregisterNetworkCallback", th);
        }
        jVar.c = null;
    }

    public final void a(Context context, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, mVar) == null) {
            this.e = mVar;
            try {
                this.f = 0L;
                this.c = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                this.g = System.currentTimeMillis();
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(12);
                builder.addTransportType(0);
                NetworkRequest build = builder.build();
                l lVar = new l(this);
                this.d = lVar;
                this.c.requestNetwork(build, lVar);
            } catch (Throwable th) {
                CtAuth.warn(a, "switchToMobileForAboveL", th);
                m mVar2 = this.e;
                if (mVar2 != null) {
                    mVar2.a(80801, "WIFI切换异常", -1L);
                }
            }
        }
    }

    public final boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) ? b(context, str) : invokeLL.booleanValue;
    }
}
