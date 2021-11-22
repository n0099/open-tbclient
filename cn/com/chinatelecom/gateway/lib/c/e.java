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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.net.InetAddress;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f34642a = "e";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34643b;

    /* renamed from: c  reason: collision with root package name */
    public ConnectivityManager f34644c;

    /* renamed from: d  reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f34645d;

    /* renamed from: e  reason: collision with root package name */
    public a f34646e;

    /* renamed from: f  reason: collision with root package name */
    public long f34647f;

    /* renamed from: g  reason: collision with root package name */
    public long f34648g;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(int i2, String str, long j);

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34643b = false;
        this.f34644c = null;
        this.f34645d = null;
        this.f34647f = 0L;
        this.f34648g = 0L;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                byte[] address = InetAddress.getByName(str).getAddress();
                return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
            } catch (Throwable th) {
                CtAuth.warn(f34642a, "When InetAddress.getByName(),throws exception", th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @TargetApi(21)
    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) {
            this.f34647f = 0L;
            this.f34644c = (ConnectivityManager) context.getSystemService("connectivity");
            this.f34648g = System.currentTimeMillis();
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback(this) { // from class: cn.com.chinatelecom.gateway.lib.c.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f34651a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34651a = this;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        e eVar = this.f34651a;
                        eVar.f34647f = currentTimeMillis - eVar.f34648g;
                        this.f34651a.f34643b = true;
                        if (this.f34651a.f34646e != null) {
                            this.f34651a.f34646e.a(network, this.f34651a.f34647f);
                        }
                        if (this.f34651a.f34644c != null) {
                            try {
                                this.f34651a.f34644c.unregisterNetworkCallback(this);
                                this.f34651a.f34644c = null;
                            } catch (Throwable th) {
                                CtAuth.warn(e.f34642a, "switchToMobileForAboveL", th);
                            }
                        }
                    }
                }
            };
            this.f34645d = networkCallback;
            this.f34644c.requestNetwork(build, networkCallback);
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
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || Build.VERSION.SDK_INT < 21 || (connectivityManager = this.f34644c) == null || (networkCallback = this.f34645d) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        } catch (Throwable th) {
            CtAuth.warn(f34642a, "unregisterNetworkCallback", th);
        }
        this.f34644c = null;
    }

    private boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, context, str)) == null) {
            boolean z = false;
            try {
                Class<?> cls = Class.forName("android.net.ConnectivityManager");
                this.f34647f = 0L;
                this.f34648g = System.currentTimeMillis();
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                this.f34644c = connectivityManager;
                if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0) {
                    Method method = cls.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class);
                    ConnectivityManager connectivityManager2 = this.f34644c;
                    Object[] objArr = new Object[2];
                    objArr[0] = 0;
                    objArr[1] = "enableHIPRI";
                    method.invoke(connectivityManager2, objArr);
                    for (int i2 = 0; i2 < 5 && this.f34644c.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0; i2++) {
                        Thread.sleep(500L);
                    }
                }
                z = ((Boolean) cls.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(this.f34644c, 5, Integer.valueOf(a(b(str))))).booleanValue();
                this.f34647f = System.currentTimeMillis() - this.f34648g;
                String str2 = f34642a;
                StringBuilder sb = new StringBuilder();
                sb.append("Switch network result ： ");
                sb.append(z);
                sb.append(" (4.x) , expendTime ：");
                sb.append(this.f34647f);
                CtAuth.info(str2, sb.toString());
            } catch (Throwable th) {
                CtAuth.warn(f34642a, "4.x网络切换异常", th);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            i.a(new Runnable(this, i2) { // from class: cn.com.chinatelecom.gateway.lib.c.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f34649a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f34650b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34650b = this;
                    this.f34649a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f34649a > 2500) {
                            try {
                                Thread.sleep(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                            } catch (Throwable th) {
                                CtAuth.warn(e.f34642a, "timeoutCheckRunnable exception!", th);
                            }
                            if (!this.f34650b.f34643b) {
                                if (this.f34650b.f34646e != null) {
                                    this.f34650b.f34646e.a(80800, "WIFI切换超时", TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                                }
                                CtAuth.info(e.f34642a, "切换网络超时(L)");
                                this.f34650b.b();
                                return;
                            }
                        }
                        try {
                            Thread.sleep(this.f34649a <= 2500 ? this.f34649a : this.f34649a - 2500);
                        } catch (Throwable th2) {
                            CtAuth.warn(e.f34642a, "timeoutCheckRunnable exception!", th2);
                        }
                        if (this.f34650b.f34646e != null) {
                            this.f34650b.f34646e.a();
                        }
                    }
                }
            });
        }
    }

    public void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar) == null) {
            this.f34646e = aVar;
            try {
                a(context);
            } catch (Throwable th) {
                CtAuth.warn(f34642a, "switchToMobileForAboveL", th);
                a aVar2 = this.f34646e;
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
