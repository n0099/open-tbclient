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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f35701a = "e";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35702b;

    /* renamed from: c  reason: collision with root package name */
    public ConnectivityManager f35703c;

    /* renamed from: d  reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f35704d;

    /* renamed from: e  reason: collision with root package name */
    public a f35705e;

    /* renamed from: f  reason: collision with root package name */
    public long f35706f;

    /* renamed from: g  reason: collision with root package name */
    public long f35707g;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void a(int i2, String str, long j2);

        void a(Network network, long j2);
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
        this.f35702b = false;
        this.f35703c = null;
        this.f35704d = null;
        this.f35706f = 0L;
        this.f35707g = 0L;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                byte[] address = InetAddress.getByName(str).getAddress();
                return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
            } catch (Throwable th) {
                CtAuth.warn(f35701a, "When InetAddress.getByName(),throws exception", th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @TargetApi(21)
    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) {
            this.f35706f = 0L;
            this.f35703c = (ConnectivityManager) context.getSystemService("connectivity");
            this.f35707g = System.currentTimeMillis();
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback(this) { // from class: cn.com.chinatelecom.gateway.lib.c.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f35710a;

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
                    this.f35710a = this;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        e eVar = this.f35710a;
                        eVar.f35706f = currentTimeMillis - eVar.f35707g;
                        this.f35710a.f35702b = true;
                        if (this.f35710a.f35705e != null) {
                            this.f35710a.f35705e.a(network, this.f35710a.f35706f);
                        }
                        if (this.f35710a.f35703c != null) {
                            try {
                                this.f35710a.f35703c.unregisterNetworkCallback(this);
                                this.f35710a.f35703c = null;
                            } catch (Throwable th) {
                                CtAuth.warn(e.f35701a, "switchToMobileForAboveL", th);
                            }
                        }
                    }
                }
            };
            this.f35704d = networkCallback;
            this.f35703c.requestNetwork(build, networkCallback);
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
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || Build.VERSION.SDK_INT < 21 || (connectivityManager = this.f35703c) == null || (networkCallback = this.f35704d) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        } catch (Throwable th) {
            CtAuth.warn(f35701a, "unregisterNetworkCallback", th);
        }
        this.f35703c = null;
    }

    private boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, context, str)) == null) {
            boolean z = false;
            try {
                Class<?> cls = Class.forName("android.net.ConnectivityManager");
                this.f35706f = 0L;
                this.f35707g = System.currentTimeMillis();
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                this.f35703c = connectivityManager;
                if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0) {
                    Method method = cls.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class);
                    ConnectivityManager connectivityManager2 = this.f35703c;
                    Object[] objArr = new Object[2];
                    objArr[0] = 0;
                    objArr[1] = "enableHIPRI";
                    method.invoke(connectivityManager2, objArr);
                    for (int i2 = 0; i2 < 5 && this.f35703c.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0; i2++) {
                        Thread.sleep(500L);
                    }
                }
                z = ((Boolean) cls.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(this.f35703c, 5, Integer.valueOf(a(b(str))))).booleanValue();
                this.f35706f = System.currentTimeMillis() - this.f35707g;
                String str2 = f35701a;
                StringBuilder sb = new StringBuilder();
                sb.append("Switch network result ： ");
                sb.append(z);
                sb.append(" (4.x) , expendTime ：");
                sb.append(this.f35706f);
                CtAuth.info(str2, sb.toString());
            } catch (Throwable th) {
                CtAuth.warn(f35701a, "4.x网络切换异常", th);
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
                public final /* synthetic */ int f35708a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f35709b;

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
                    this.f35709b = this;
                    this.f35708a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f35708a > 2500) {
                            try {
                                Thread.sleep(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                            } catch (Throwable th) {
                                CtAuth.warn(e.f35701a, "timeoutCheckRunnable exception!", th);
                            }
                            if (!this.f35709b.f35702b) {
                                if (this.f35709b.f35705e != null) {
                                    this.f35709b.f35705e.a(80800, "WIFI切换超时", TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                                }
                                CtAuth.info(e.f35701a, "切换网络超时(L)");
                                this.f35709b.b();
                                return;
                            }
                        }
                        try {
                            Thread.sleep(this.f35708a <= 2500 ? this.f35708a : this.f35708a - 2500);
                        } catch (Throwable th2) {
                            CtAuth.warn(e.f35701a, "timeoutCheckRunnable exception!", th2);
                        }
                        if (this.f35709b.f35705e != null) {
                            this.f35709b.f35705e.a();
                        }
                    }
                }
            });
        }
    }

    public void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar) == null) {
            this.f35705e = aVar;
            try {
                a(context);
            } catch (Throwable th) {
                CtAuth.warn(f35701a, "switchToMobileForAboveL", th);
                a aVar2 = this.f35705e;
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
