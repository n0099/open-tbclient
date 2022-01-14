package c.a.d.f.p;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.service.AsyncService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.NetworkState;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public static Pattern m;
    public static boolean n;
    public static l o;
    public transient /* synthetic */ FieldHolder $fh;
    public NetworkInfo a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2996b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2997c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2998d;

    /* renamed from: e  reason: collision with root package name */
    public int f2999e;

    /* renamed from: f  reason: collision with root package name */
    public int f3000f;

    /* renamed from: g  reason: collision with root package name */
    public int f3001g;

    /* renamed from: h  reason: collision with root package name */
    public String f3002h;

    /* renamed from: i  reason: collision with root package name */
    public int f3003i;

    /* renamed from: j  reason: collision with root package name */
    public long f3004j;
    public boolean k;
    public Runnable l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int I = l.I();
                    long l = l.l();
                    l.e();
                    if (l.C()) {
                        NetworkState networkState = new NetworkState();
                        networkState.mLastNetState = I;
                        networkState.mCurNetState = l.I();
                        networkState.mlastChangedTime = l;
                        long currentTimeMillis = System.currentTimeMillis();
                        networkState.mCurChangedTime = currentTimeMillis;
                        l.M(currentTimeMillis);
                        MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangedMessage(networkState));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                AsyncService.INSTANCE.sendRunnable(l.k().l);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502488888, "Lc/a/d/f/p/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502488888, "Lc/a/d/f/p/l;");
                return;
            }
        }
        m = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
        n = true;
        try {
            b bVar = new b(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(bVar, intentFilter);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        o = null;
    }

    public l() {
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
        this.a = null;
        this.f2996b = true;
        this.f2997c = false;
        this.f2998d = true;
        this.f2999e = 0;
        this.f3000f = 0;
        this.f3001g = -1;
        this.f3002h = null;
        this.f3003i = -1;
        this.k = true;
        this.l = new a(this);
    }

    public static boolean A() {
        InterceptResult invokeV;
        NetworkInfo[] allNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity");
                if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null && allNetworkInfo.length > 0) {
                    for (NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? k().B() : invokeV.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? n : invokeV.booleanValue;
    }

    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            NetworkInfo h2 = k().h();
            return (h2 == null || h2.getExtraInfo() == null || !h2.getExtraInfo().contains("wap")) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? m.matcher(str).find() : invokeL.booleanValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? k().G() : invokeV.booleanValue;
    }

    public static int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (H()) {
                return 1;
            }
            if (t()) {
                return 2;
            }
            if (u()) {
                return 3;
            }
            return (v() || z()) ? 4 : 0;
        }
        return invokeV.intValue;
    }

    public static String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            int I = I();
            return I != 1 ? I != 2 ? I != 3 ? I != 4 ? "unreachable" : "4g" : "3g" : "2g" : "wifi";
        }
        return (String) invokeV.objValue;
    }

    public static String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String J = J();
            return J != null ? J.toUpperCase() : J;
        }
        return (String) invokeV.objValue;
    }

    public static int L() {
        InterceptResult invokeV;
        String substring;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
            if (networkOperator == null || networkOperator.length() < 4 || m.isEmptyStringAfterTrim(networkOperator) || (substring = networkOperator.substring(0, 3)) == null || !substring.equals("460")) {
                return 0;
            }
            try {
                i2 = Integer.parseInt(networkOperator.substring(3));
            } catch (NumberFormatException unused) {
                i2 = 0;
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3 && i2 != 5) {
                            if (i2 != 6) {
                                if (i2 != 7) {
                                    if (i2 != 11) {
                                        return 0;
                                    }
                                }
                            }
                        }
                        return 3;
                    }
                }
                return 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public static void M(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65548, null, j2) == null) {
            k().N(j2);
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? k().p() : (String) invokeV.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? k().q() : invokeV.intValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            k().j();
        }
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? k().o() : invokeV.intValue;
    }

    public static synchronized l k() {
        InterceptResult invokeV;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            synchronized (l.class) {
                if (o == null) {
                    o = new l();
                }
                lVar = o;
            }
            return lVar;
        }
        return (l) invokeV.objValue;
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? k().g() : invokeV.longValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? !z() ? "N" : H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : v() ? "4G" : u() ? "3G" : t() ? "2G" : "N" : (String) invokeV.objValue;
    }

    public static int n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i2)) == null) {
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 1;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 2;
                case 13:
                    return 3;
                default:
                    return 4;
            }
        }
        return invokeI.intValue;
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            s(true);
        }
    }

    public static void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
            k().O(z);
            k().j();
        }
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? 1 == k().i() : invokeV.booleanValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? 2 == k().i() : invokeV.booleanValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? 3 == k().i() : invokeV.booleanValue;
    }

    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? k().w() : invokeV.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? k().y() : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a == null) {
                j();
            }
            return this.f2996b;
        }
        return invokeV.booleanValue;
    }

    public final void N(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f3004j = j2;
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.k = z;
        }
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3004j : invokeV.longValue;
    }

    public final NetworkInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (NetworkInfo) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.a == null) {
                j();
            }
            return this.f3000f;
        }
        return invokeV.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NetworkInfo h2 = h();
            this.a = h2;
            if (h2 != null) {
                if (h2.getType() == 1) {
                    this.f2996b = true;
                    this.f2997c = false;
                } else if (h2.getType() == 0) {
                    this.f2996b = false;
                    this.f2997c = true;
                } else {
                    this.f2996b = false;
                    this.f2997c = false;
                }
                this.f2998d = true;
                int subtype = h2.getSubtype();
                this.f2999e = subtype;
                if (this.f2997c) {
                    this.f3000f = n(subtype);
                } else {
                    this.f3000f = 0;
                }
            } else {
                this.f2996b = false;
                this.f2997c = false;
                this.f2998d = false;
                this.f2999e = 0;
                this.f2999e = 0;
            }
            this.f3001g = L();
            this.f3002h = Proxy.getDefaultHost();
            this.f3003i = Proxy.getDefaultPort();
        }
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f3001g == -1) {
                try {
                    this.f3001g = L();
                } catch (Exception unused) {
                    this.f3001g = 0;
                }
            }
            return this.f3001g;
        }
        return invokeV.intValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f3002h == null) {
                this.f3002h = Proxy.getDefaultHost();
            }
            return this.f3002h;
        }
        return (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (-1 == this.f3003i) {
                this.f3003i = Proxy.getDefaultPort();
            }
            return this.f3003i;
        }
        return invokeV.intValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                j();
            }
            return this.f2997c;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == null) {
                j();
            }
            return this.f2998d;
        }
        return invokeV.booleanValue;
    }
}
