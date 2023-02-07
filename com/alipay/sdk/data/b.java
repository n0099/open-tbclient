package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ConditionVariable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "virtualImeiAndImsi";
    public static final String e = "virtual_imei";
    public static final String f = "virtual_imsi";
    public static volatile b g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? "-1;-1" : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? "1" : (String) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public static class a implements APSecuritySdk.InitResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String[] a;
        public final /* synthetic */ ConditionVariable b;

        public a(String[] strArr, ConditionVariable conditionVariable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr, conditionVariable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = strArr;
            this.b = conditionVariable;
        }

        @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
        public void onResult(APSecuritySdk.TokenResult tokenResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tokenResult) == null) {
                if (tokenResult != null) {
                    this.a[0] = tokenResult.apdidToken;
                }
                this.b.open();
            }
        }
    }

    /* renamed from: com.alipay.sdk.data.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class CallableC0010b implements Callable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.alipay.sdk.sys.a a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ HashMap c;

        public CallableC0010b(com.alipay.sdk.sys.a aVar, Context context, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = context;
            this.c = hashMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return b.c(this.a, this.b, this.c);
            }
            return (String) invokeV.objValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "sdk-and-lite";
        String a2 = com.alipay.sdk.app.a.a();
        if (!com.alipay.sdk.app.a.b()) {
            this.b += '_' + a2;
        }
    }

    public static String f() {
        InterceptResult invokeV;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            Context b2 = com.alipay.sdk.sys.b.d().b();
            SharedPreferences sharedPreferences = b2.getSharedPreferences(d, 0);
            String string = sharedPreferences.getString(e, null);
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(com.alipay.sdk.tid.a.a(b2).d())) {
                    b = c();
                } else {
                    b = com.alipay.sdk.util.a.b(b2).b();
                }
                String str = b;
                sharedPreferences.edit().putString(e, str).apply();
                return str;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return Float.toString(new TextView(context).getTextSize());
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getBSSID();
            }
            return "00";
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
            return "-1";
        }
        return (String) invokeL.objValue;
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.sys.b.d().b()).edit().putString(com.alipay.sdk.cons.b.i, str).apply();
                com.alipay.sdk.cons.a.e = str;
            }
        }
    }

    public static synchronized b b() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                }
                bVar = g;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    String packageName = context.getPackageName();
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                    sb.append("(");
                    sb.append(packageName);
                    sb.append(";");
                    sb.append(packageInfo.versionCode);
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                    return sb.toString();
                } catch (Exception unused) {
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String b(com.alipay.sdk.sys.a aVar, Context context, HashMap<String, String> hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, aVar, context, hashMap)) == null) {
            try {
                return (String) Executors.newFixedThreadPool(2).submit(new CallableC0010b(aVar, context, hashMap)).get(3000L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.o, com.alipay.sdk.app.statistic.b.u, th);
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String hexString = Long.toHexString(System.currentTimeMillis());
            Random random = new Random();
            return hexString + (random.nextInt(9000) + 1000);
        }
        return (String) invokeV.objValue;
    }

    public static String c(com.alipay.sdk.sys.a aVar, Context context, HashMap<String, String> hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, aVar, context, hashMap)) == null) {
            String[] strArr = {""};
            try {
                APSecuritySdk aPSecuritySdk = APSecuritySdk.getInstance(context);
                ConditionVariable conditionVariable = new ConditionVariable();
                aPSecuritySdk.initToken(0, hashMap, new a(strArr, conditionVariable));
                conditionVariable.block(3000L);
            } catch (Throwable th) {
                c.a(th);
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.o, com.alipay.sdk.app.statistic.b.s, th);
            }
            if (TextUtils.isEmpty(strArr[0])) {
                com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.o, com.alipay.sdk.app.statistic.b.t, "missing token");
            }
            c.b(com.alipay.sdk.cons.a.x, "ap:" + strArr[0]);
            return strArr[0];
        }
        return (String) invokeLLL.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            Context b = com.alipay.sdk.sys.b.d().b();
            SharedPreferences sharedPreferences = b.getSharedPreferences(d, 0);
            String string = sharedPreferences.getString(f, null);
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(com.alipay.sdk.tid.a.a(b).d())) {
                    String c2 = com.alipay.sdk.sys.b.d().c();
                    if (!TextUtils.isEmpty(c2) && c2.length() >= 18) {
                        c = c2.substring(3, 18);
                    } else {
                        c = c();
                    }
                } else {
                    c = com.alipay.sdk.util.a.b(b).c();
                }
                String str = c;
                sharedPreferences.edit().putString(f, str).apply();
                return str;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.tid.a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2)) == null) {
            Context b = com.alipay.sdk.sys.b.d().b();
            com.alipay.sdk.util.a b2 = com.alipay.sdk.util.a.b(b);
            if (TextUtils.isEmpty(this.a)) {
                String e2 = l.e();
                String d2 = l.d();
                String c = l.c(b);
                String e3 = l.e(b);
                String f2 = l.f(b);
                String a2 = a(b);
                this.a = "Msp/15.8.02 (" + e2 + ";" + d2 + ";" + c + ";" + e3 + ";" + f2 + ";" + a2;
            }
            String b3 = com.alipay.sdk.util.a.d(b).b();
            String b4 = l.b(b);
            String e4 = e();
            String c2 = b2.c();
            String b5 = b2.b();
            String g2 = g();
            String f3 = f();
            if (aVar2 != null) {
                this.c = aVar2.c();
            }
            String replace = Build.MANUFACTURER.replace(";", " ");
            String replace2 = Build.MODEL.replace(";", " ");
            boolean e5 = com.alipay.sdk.sys.b.e();
            String d3 = b2.d();
            String d4 = d(b);
            String c3 = c(b);
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(";");
            sb.append(b3);
            sb.append(";");
            sb.append(b4);
            sb.append(";");
            sb.append(e4);
            sb.append(";");
            sb.append(c2);
            sb.append(";");
            sb.append(b5);
            sb.append(";");
            sb.append(this.c);
            sb.append(";");
            sb.append(replace);
            sb.append(";");
            sb.append(replace2);
            sb.append(";");
            sb.append(e5);
            sb.append(";");
            sb.append(d3);
            sb.append(";");
            sb.append(d());
            sb.append(";");
            sb.append(this.b);
            sb.append(";");
            sb.append(g2);
            sb.append(";");
            sb.append(f3);
            sb.append(";");
            sb.append(d4);
            sb.append(";");
            sb.append(c3);
            if (aVar2 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("tid", com.alipay.sdk.tid.a.a(b).d());
                hashMap.put(com.alipay.sdk.cons.b.g, com.alipay.sdk.sys.b.d().c());
                String b6 = b(aVar, b, hashMap);
                if (!TextUtils.isEmpty(b6)) {
                    sb.append(";;;");
                    sb.append(b6);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
