package c.a.r.f.a;

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
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
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
/* loaded from: classes3.dex */
public class p implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static HashMap<String, Integer> f15404a;

        /* renamed from: b  reason: collision with root package name */
        public static a f15405b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.r.f.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0736a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f15406a;

            /* renamed from: b  reason: collision with root package name */
            public String f15407b;

            /* renamed from: c  reason: collision with root package name */
            public String f15408c;

            /* renamed from: d  reason: collision with root package name */
            public int f15409d;

            public C0736a(Context context) {
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
                b(context);
            }

            public final void a(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, context, networkInfo) == null) {
                    if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                        if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                            this.f15406a = lowerCase;
                            this.f15407b = "10.0.0.172";
                            return;
                        } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                            this.f15406a = lowerCase;
                            this.f15407b = "10.0.0.200";
                            return;
                        } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                            this.f15406a = lowerCase;
                            return;
                        }
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    int defaultPort = Proxy.getDefaultPort();
                    if (defaultHost == null || defaultHost.length() <= 0) {
                        return;
                    }
                    this.f15407b = defaultHost;
                    if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.f15407b.trim())) {
                        return;
                    }
                    Integer.toString(defaultPort);
                }
            }

            @SuppressLint({"MissingPermission"})
            public final void b(Context context) {
                NetworkInfo networkInfo;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
                    try {
                        networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                    } catch (Exception unused) {
                        networkInfo = null;
                    }
                    if (networkInfo != null) {
                        if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                            this.f15408c = "wifi";
                        } else {
                            a(context, networkInfo);
                            this.f15408c = this.f15406a;
                        }
                        this.f15409d = networkInfo.getSubtype();
                        networkInfo.getSubtypeName();
                    }
                }
            }

            public int c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15409d : invokeV.intValue;
            }

            public String d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15408c : (String) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-741043128, "Lc/a/r/f/a/p$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-741043128, "Lc/a/r/f/a/p$a;");
                    return;
                }
            }
            HashMap<String, Integer> hashMap = new HashMap<>();
            f15404a = hashMap;
            hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            f15404a.put("3GNET", 21);
            f15404a.put("3GWAP", 22);
            f15404a.put("CMNET", 31);
            f15404a.put("UNINET", 32);
            f15404a.put("CTNET", 33);
            f15404a.put("CMWAP", 41);
            f15404a.put("UNIWAP", 42);
            f15404a.put("CTWAP", 43);
            f15405b = new a();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f15405b : (a) invokeV.objValue;
        }

        public String b(Context context) {
            InterceptResult invokeL;
            StringBuilder sb;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                C0736a c0736a = new C0736a(context);
                String d2 = c0736a.d();
                int c2 = c0736a.c();
                if (TextUtils.isEmpty(d2)) {
                    sb = new StringBuilder();
                } else {
                    Integer num = f15404a.get(d2.toUpperCase());
                    r3 = num != null ? num : 5;
                    sb = new StringBuilder();
                }
                sb.append(r3);
                sb.append("_");
                sb.append(c2);
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static b f15410c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f15411a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f15412b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-741043097, "Lc/a/r/f/a/p$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-741043097, "Lc/a/r/f/a/p$b;");
                    return;
                }
            }
            f15410c = new b();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f15410c : (b) invokeV.objValue;
        }

        public static String d(Context context) {
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

        public String b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                synchronized (b.class) {
                    if (TextUtils.isEmpty(this.f15411a)) {
                        this.f15411a = c(context);
                    }
                }
                return this.f15411a;
            }
            return (String) invokeL.objValue;
        }

        public final String c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                int e2 = e(context.getApplicationContext());
                int f2 = f(context.getApplicationContext());
                int g2 = g(context.getApplicationContext());
                String d2 = d(context.getApplicationContext());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(e2);
                stringBuffer.append("_");
                stringBuffer.append(f2);
                stringBuffer.append("_");
                stringBuffer.append("android");
                stringBuffer.append("_");
                stringBuffer.append(d2);
                stringBuffer.append("_");
                stringBuffer.append(g2);
                return stringBuffer.toString();
            }
            return (String) invokeL.objValue;
        }

        public final int e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.f15412b;
                if (displayMetrics != null) {
                    return displayMetrics.widthPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.f15412b;
                if (displayMetrics != null) {
                    return displayMetrics.heightPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int g(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.f15412b;
                if (displayMetrics != null) {
                    return displayMetrics.densityDpi;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final void h(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && context != null && this.f15412b == null) {
                this.f15412b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static c f15413e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f15414a;

        /* renamed from: b  reason: collision with root package name */
        public String f15415b;

        /* renamed from: c  reason: collision with root package name */
        public String f15416c;

        /* renamed from: d  reason: collision with root package name */
        public String f15417d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-741043066, "Lc/a/r/f/a/p$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-741043066, "Lc/a/r/f/a/p$c;");
                    return;
                }
            }
            f15413e = new c();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f15413e : (c) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15417d : (String) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                String str = Build.MODEL;
                this.f15414a = str;
                if (TextUtils.isEmpty(str)) {
                    this.f15414a = "NUL";
                } else {
                    this.f15414a = this.f15414a.replace("_", "-");
                }
                String str2 = Build.MANUFACTURER;
                this.f15415b = str2;
                if (TextUtils.isEmpty(str2)) {
                    this.f15415b = "NUL";
                } else {
                    this.f15415b = this.f15415b.replace("_", "-");
                }
                String str3 = Build.VERSION.RELEASE;
                this.f15416c = str3;
                this.f15416c = TextUtils.isEmpty(str3) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : this.f15416c.replace("_", "-");
                this.f15417d = d();
            }
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.f15414a;
                String str2 = this.f15416c;
                int i2 = Build.VERSION.SDK_INT;
                String str3 = this.f15415b;
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

    @Override // c.a.r.f.a.l
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a().b() : (String) invokeV.objValue;
    }

    @Override // c.a.r.f.a.l
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? b.a().b(context) : (String) invokeL.objValue;
    }

    @Override // c.a.r.f.a.l
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.currentTimeMillis() : invokeV.longValue;
    }

    @Override // c.a.r.f.a.l
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName() : (String) invokeL.objValue;
    }

    @Override // c.a.r.f.a.l
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? c.a.r.b.e(context).g() : (String) invokeL.objValue;
    }

    @Override // c.a.r.f.a.l
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? a.a().b(context) : (String) invokeL.objValue;
    }
}
