package c.a.q.g.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class p implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static HashMap<String, Integer> a;

        /* renamed from: b  reason: collision with root package name */
        public static a f11652b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.q.g.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0800a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f11653b;

            /* renamed from: c  reason: collision with root package name */
            public String f11654c;

            /* renamed from: d  reason: collision with root package name */
            public int f11655d;

            public C0800a(Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                a(context);
            }

            @SuppressLint({"MissingPermission"})
            public final void a(Context context) {
                NetworkInfo networkInfo;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                    try {
                        networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                    } catch (Exception unused) {
                        networkInfo = null;
                    }
                    if (networkInfo != null) {
                        if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                            this.f11654c = "wifi";
                        } else {
                            b(context, networkInfo);
                            this.f11654c = this.a;
                        }
                        this.f11655d = networkInfo.getSubtype();
                        networkInfo.getSubtypeName();
                    }
                }
            }

            public final void b(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, networkInfo) == null) {
                    if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                        if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                            this.a = lowerCase;
                            this.f11653b = "10.0.0.172";
                            return;
                        } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                            this.a = lowerCase;
                            this.f11653b = "10.0.0.200";
                            return;
                        } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                            this.a = lowerCase;
                            return;
                        }
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    int defaultPort = Proxy.getDefaultPort();
                    if (defaultHost == null || defaultHost.length() <= 0) {
                        return;
                    }
                    this.f11653b = defaultHost;
                    if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.f11653b.trim())) {
                        return;
                    }
                    Integer.toString(defaultPort);
                }
            }

            public String c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11654c : (String) invokeV.objValue;
            }

            public int d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11655d : invokeV.intValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1198280712, "Lc/a/q/g/a/p$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1198280712, "Lc/a/q/g/a/p$a;");
                    return;
                }
            }
            HashMap<String, Integer> hashMap = new HashMap<>();
            a = hashMap;
            hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            a.put("3GNET", 21);
            a.put("3GWAP", 22);
            a.put("CMNET", 31);
            a.put("UNINET", 32);
            a.put("CTNET", 33);
            a.put("CMWAP", 41);
            a.put("UNIWAP", 42);
            a.put("CTWAP", 43);
            f11652b = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f11652b : (a) invokeV.objValue;
        }

        public String b(Context context) {
            InterceptResult invokeL;
            StringBuilder sb;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                C0800a c0800a = new C0800a(context);
                String c2 = c0800a.c();
                int d2 = c0800a.d();
                if (TextUtils.isEmpty(c2)) {
                    sb = new StringBuilder();
                } else {
                    Integer num = a.get(c2.toUpperCase());
                    r3 = num != null ? num : 5;
                    sb = new StringBuilder();
                }
                sb.append(r3);
                sb.append("_");
                sb.append(d2);
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static b f11656c;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f11657b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1198280743, "Lc/a/q/g/a/p$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1198280743, "Lc/a/q/g/a/p$b;");
                    return;
                }
            }
            f11656c = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f11656c : (b) invokeV.objValue;
        }

        public static String g(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
                try {
                    return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    return "0.8";
                }
            }
            return (String) invokeL.objValue;
        }

        public final String b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                int e2 = e(context.getApplicationContext());
                int d2 = d(context.getApplicationContext());
                int c2 = c(context.getApplicationContext());
                String g2 = g(context.getApplicationContext());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(e2);
                stringBuffer.append("_");
                stringBuffer.append(d2);
                stringBuffer.append("_");
                stringBuffer.append("android");
                stringBuffer.append("_");
                stringBuffer.append(g2);
                stringBuffer.append("_");
                stringBuffer.append(c2);
                return stringBuffer.toString();
            }
            return (String) invokeL.objValue;
        }

        public final int c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.f11657b;
                if (displayMetrics != null) {
                    return displayMetrics.densityDpi;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.f11657b;
                if (displayMetrics != null) {
                    return displayMetrics.heightPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.f11657b;
                if (displayMetrics != null) {
                    return displayMetrics.widthPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public String f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                synchronized (b.class) {
                    if (TextUtils.isEmpty(this.a)) {
                        this.a = b(context);
                    }
                }
                return this.a;
            }
            return (String) invokeL.objValue;
        }

        public final void h(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && context != null && this.f11657b == null) {
                this.f11657b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static c f11658e;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f11659b;

        /* renamed from: c  reason: collision with root package name */
        public String f11660c;

        /* renamed from: d  reason: collision with root package name */
        public String f11661d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1198280774, "Lc/a/q/g/a/p$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1198280774, "Lc/a/q/g/a/p$c;");
                    return;
                }
            }
            f11658e = new c();
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
            c();
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f11658e : (c) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11661d : (String) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                String str = Build.MODEL;
                this.a = str;
                if (TextUtils.isEmpty(str)) {
                    this.a = "NUL";
                } else {
                    this.a = this.a.replace("_", "-");
                }
                String str2 = Build.MANUFACTURER;
                this.f11659b = str2;
                if (TextUtils.isEmpty(str2)) {
                    this.f11659b = "NUL";
                } else {
                    this.f11659b = this.f11659b.replace("_", "-");
                }
                String str3 = Build.VERSION.RELEASE;
                this.f11660c = str3;
                this.f11660c = TextUtils.isEmpty(str3) ? "0.0" : this.f11660c.replace("_", "-");
                this.f11661d = d();
            }
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.a;
                String str2 = this.f11660c;
                int i2 = Build.VERSION.SDK_INT;
                String str3 = this.f11659b;
                return str + "_" + str2 + "_" + i2 + "_" + str3;
            }
            return (String) invokeV.objValue;
        }
    }

    public p() {
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

    @Override // c.a.q.g.a.l
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() : invokeV.longValue;
    }

    @Override // c.a.q.g.a.l
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? a.a().b(context) : (String) invokeL.objValue;
    }

    @Override // c.a.q.g.a.l
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a().b() : (String) invokeV.objValue;
    }

    @Override // c.a.q.g.a.l
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? c.a.q.b.f(context).h() : (String) invokeL.objValue;
    }

    @Override // c.a.q.g.a.l
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? b.a().f(context) : (String) invokeL.objValue;
    }

    @Override // c.a.q.g.a.l
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName() : (String) invokeL.objValue;
    }
}
