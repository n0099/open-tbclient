package b.a.r.f.a;

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
/* loaded from: classes4.dex */
public class p implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static HashMap<String, Integer> f14482a;

        /* renamed from: b  reason: collision with root package name */
        public static a f14483b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b.a.r.f.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0732a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f14484a;

            /* renamed from: b  reason: collision with root package name */
            public String f14485b;

            /* renamed from: c  reason: collision with root package name */
            public String f14486c;

            /* renamed from: d  reason: collision with root package name */
            public int f14487d;

            public C0732a(Context context) {
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
                            this.f14484a = lowerCase;
                            this.f14485b = "10.0.0.172";
                            return;
                        } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                            this.f14484a = lowerCase;
                            this.f14485b = "10.0.0.200";
                            return;
                        } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                            this.f14484a = lowerCase;
                            return;
                        }
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    int defaultPort = Proxy.getDefaultPort();
                    if (defaultHost == null || defaultHost.length() <= 0) {
                        return;
                    }
                    this.f14485b = defaultHost;
                    if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.f14485b.trim())) {
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
                            this.f14486c = "wifi";
                        } else {
                            a(context, networkInfo);
                            this.f14486c = this.f14484a;
                        }
                        this.f14487d = networkInfo.getSubtype();
                        networkInfo.getSubtypeName();
                    }
                }
            }

            public int c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14487d : invokeV.intValue;
            }

            public String d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14486c : (String) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-235484503, "Lb/a/r/f/a/p$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-235484503, "Lb/a/r/f/a/p$a;");
                    return;
                }
            }
            HashMap<String, Integer> hashMap = new HashMap<>();
            f14482a = hashMap;
            hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            f14482a.put("3GNET", 21);
            f14482a.put("3GWAP", 22);
            f14482a.put("CMNET", 31);
            f14482a.put("UNINET", 32);
            f14482a.put("CTNET", 33);
            f14482a.put("CMWAP", 41);
            f14482a.put("UNIWAP", 42);
            f14482a.put("CTWAP", 43);
            f14483b = new a();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f14483b : (a) invokeV.objValue;
        }

        public String b(Context context) {
            InterceptResult invokeL;
            StringBuilder sb;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                C0732a c0732a = new C0732a(context);
                String d2 = c0732a.d();
                int c2 = c0732a.c();
                if (TextUtils.isEmpty(d2)) {
                    sb = new StringBuilder();
                } else {
                    Integer num = f14482a.get(d2.toUpperCase());
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

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static b f14488c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f14489a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f14490b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-235484472, "Lb/a/r/f/a/p$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-235484472, "Lb/a/r/f/a/p$b;");
                    return;
                }
            }
            f14488c = new b();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f14488c : (b) invokeV.objValue;
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
                    if (TextUtils.isEmpty(this.f14489a)) {
                        this.f14489a = c(context);
                    }
                }
                return this.f14489a;
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
                DisplayMetrics displayMetrics = this.f14490b;
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
                DisplayMetrics displayMetrics = this.f14490b;
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
                DisplayMetrics displayMetrics = this.f14490b;
                if (displayMetrics != null) {
                    return displayMetrics.densityDpi;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final void h(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && context != null && this.f14490b == null) {
                this.f14490b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static c f14491e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f14492a;

        /* renamed from: b  reason: collision with root package name */
        public String f14493b;

        /* renamed from: c  reason: collision with root package name */
        public String f14494c;

        /* renamed from: d  reason: collision with root package name */
        public String f14495d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-235484441, "Lb/a/r/f/a/p$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-235484441, "Lb/a/r/f/a/p$c;");
                    return;
                }
            }
            f14491e = new c();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f14491e : (c) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14495d : (String) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                String str = Build.MODEL;
                this.f14492a = str;
                if (TextUtils.isEmpty(str)) {
                    this.f14492a = "NUL";
                } else {
                    this.f14492a = this.f14492a.replace("_", "-");
                }
                String str2 = Build.MANUFACTURER;
                this.f14493b = str2;
                if (TextUtils.isEmpty(str2)) {
                    this.f14493b = "NUL";
                } else {
                    this.f14493b = this.f14493b.replace("_", "-");
                }
                String str3 = Build.VERSION.RELEASE;
                this.f14494c = str3;
                this.f14494c = TextUtils.isEmpty(str3) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : this.f14494c.replace("_", "-");
                this.f14495d = d();
            }
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.f14492a;
                String str2 = this.f14494c;
                int i2 = Build.VERSION.SDK_INT;
                String str3 = this.f14493b;
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

    @Override // b.a.r.f.a.l
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a().b() : (String) invokeV.objValue;
    }

    @Override // b.a.r.f.a.l
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? b.a().b(context) : (String) invokeL.objValue;
    }

    @Override // b.a.r.f.a.l
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.currentTimeMillis() : invokeV.longValue;
    }

    @Override // b.a.r.f.a.l
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName() : (String) invokeL.objValue;
    }

    @Override // b.a.r.f.a.l
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? b.a.r.b.e(context).g() : (String) invokeL.objValue;
    }

    @Override // b.a.r.f.a.l
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? a.a().b(context) : (String) invokeL.objValue;
    }
}
