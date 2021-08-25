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
import com.alipay.sdk.util.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f35860a = "virtualImeiAndImsi";

    /* renamed from: b  reason: collision with root package name */
    public static final String f35861b = "virtual_imei";

    /* renamed from: c  reason: collision with root package name */
    public static final String f35862c = "virtual_imsi";

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f35863d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f35864e;

    /* renamed from: f  reason: collision with root package name */
    public String f35865f;

    /* renamed from: g  reason: collision with root package name */
    public String f35866g;

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
                return;
            }
        }
        this.f35865f = "sdk-and-lite";
        String a2 = com.alipay.sdk.app.a.a();
        if (com.alipay.sdk.app.a.b()) {
            return;
        }
        this.f35865f += '_' + a2;
    }

    public static synchronized b b() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (b.class) {
                if (f35863d == null) {
                    f35863d = new b();
                }
                bVar = f35863d;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            Context b3 = com.alipay.sdk.sys.b.a().b();
            SharedPreferences sharedPreferences = b3.getSharedPreferences(f35860a, 0);
            String string = sharedPreferences.getString(f35861b, null);
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(com.alipay.sdk.tid.a.a(b3).a())) {
                    b2 = g();
                } else {
                    b2 = com.alipay.sdk.util.a.a(b3).b();
                }
                String str = b2;
                sharedPreferences.edit().putString(f35861b, str).apply();
                return str;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            Context b2 = com.alipay.sdk.sys.b.a().b();
            SharedPreferences sharedPreferences = b2.getSharedPreferences(f35860a, 0);
            String string = sharedPreferences.getString(f35862c, null);
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(com.alipay.sdk.tid.a.a(b2).a())) {
                    String e2 = com.alipay.sdk.sys.b.a().e();
                    if (!TextUtils.isEmpty(e2) && e2.length() >= 18) {
                        a2 = e2.substring(3, 18);
                    } else {
                        a2 = g();
                    }
                } else {
                    a2 = com.alipay.sdk.util.a.a(b2).a();
                }
                String str = a2;
                sharedPreferences.edit().putString(f35862c, str).apply();
                return str;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? "1" : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? "-1;-1" : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String hexString = Long.toHexString(System.currentTimeMillis());
            Random random = new Random();
            return hexString + (random.nextInt(9000) + 1000);
        }
        return (String) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35866g : (String) invokeV.objValue;
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.sys.b.a().b()).edit().putString(com.alipay.sdk.cons.b.f35832i, str).apply();
                com.alipay.sdk.cons.a.f35818e = str;
            }
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? Float.toString(new TextView(context).getTextSize()) : (String) invokeL.objValue;
    }

    public static String b(com.alipay.sdk.sys.a aVar, Context context, HashMap<String, String> hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, aVar, context, hashMap)) == null) {
            String[] strArr = {""};
            try {
                APSecuritySdk aPSecuritySdk = APSecuritySdk.getInstance(context);
                ConditionVariable conditionVariable = new ConditionVariable();
                aPSecuritySdk.initToken(0, hashMap, new APSecuritySdk.InitResultListener(strArr, conditionVariable) { // from class: com.alipay.sdk.data.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String[] f35867a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ConditionVariable f35868b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {strArr, conditionVariable};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35867a = strArr;
                        this.f35868b = conditionVariable;
                    }

                    @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
                    public void onResult(APSecuritySdk.TokenResult tokenResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tokenResult) == null) {
                            if (tokenResult != null) {
                                this.f35867a[0] = tokenResult.apdidToken;
                            }
                            this.f35868b.open();
                        }
                    }
                });
                conditionVariable.block(3000L);
            } catch (Throwable th) {
                c.a(th);
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.f35808e, com.alipay.sdk.app.statistic.b.f35812i, th);
            }
            if (TextUtils.isEmpty(strArr[0])) {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.f35808e, com.alipay.sdk.app.statistic.b.f35813j, "missing token");
            }
            c.a(com.alipay.sdk.cons.a.x, "ap:" + strArr[0]);
            return strArr[0];
        }
        return (String) invokeLLL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getSSID() : "-1";
        }
        return (String) invokeL.objValue;
    }

    public String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.tid.a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2)) == null) {
            Context b2 = com.alipay.sdk.sys.b.a().b();
            com.alipay.sdk.util.a a2 = com.alipay.sdk.util.a.a(b2);
            if (TextUtils.isEmpty(this.f35864e)) {
                String b3 = k.b();
                String c2 = k.c();
                String d2 = k.d(b2);
                String f2 = k.f(b2);
                String e2 = k.e(b2);
                String b4 = b(b2);
                this.f35864e = "Msp/15.7.7 (" + b3 + ";" + c2 + ";" + d2 + ";" + f2 + ";" + e2 + ";" + b4;
            }
            String b5 = com.alipay.sdk.util.a.b(b2).b();
            String g2 = k.g(b2);
            String e3 = e();
            String a3 = a2.a();
            String b6 = a2.b();
            String d3 = d();
            String c3 = c();
            if (aVar2 != null) {
                this.f35866g = aVar2.b();
            }
            String replace = Build.MANUFACTURER.replace(";", " ");
            String replace2 = Build.MODEL.replace(";", " ");
            boolean d4 = com.alipay.sdk.sys.b.d();
            String d5 = a2.d();
            String c4 = c(b2);
            String d6 = d(b2);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f35864e);
            sb.append(";");
            sb.append(b5);
            sb.append(";");
            sb.append(g2);
            sb.append(";");
            sb.append(e3);
            sb.append(";");
            sb.append(a3);
            sb.append(";");
            sb.append(b6);
            sb.append(";");
            sb.append(this.f35866g);
            sb.append(";");
            sb.append(replace);
            sb.append(";");
            sb.append(replace2);
            sb.append(";");
            sb.append(d4);
            sb.append(";");
            sb.append(d5);
            sb.append(";");
            sb.append(f());
            sb.append(";");
            sb.append(this.f35865f);
            sb.append(";");
            sb.append(d3);
            sb.append(";");
            sb.append(c3);
            sb.append(";");
            sb.append(c4);
            sb.append(";");
            sb.append(d6);
            if (aVar2 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("tid", com.alipay.sdk.tid.a.a(b2).a());
                hashMap.put(com.alipay.sdk.cons.b.f35830g, com.alipay.sdk.sys.b.a().e());
                String c5 = c(aVar, b2, hashMap);
                if (!TextUtils.isEmpty(c5)) {
                    sb.append(";;;");
                    sb.append(c5);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getBSSID() : "00";
        }
        return (String) invokeL.objValue;
    }

    public static String c(com.alipay.sdk.sys.a aVar, Context context, HashMap<String, String> hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, aVar, context, hashMap)) == null) {
            try {
                return (String) Executors.newFixedThreadPool(2).submit(new Callable<String>(aVar, context, hashMap) { // from class: com.alipay.sdk.data.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ com.alipay.sdk.sys.a f35869a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f35870b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ HashMap f35871c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {aVar, context, hashMap};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35869a = aVar;
                        this.f35870b = context;
                        this.f35871c = hashMap;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public String call() throws Exception {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? b.b(this.f35869a, this.f35870b, this.f35871c) : (String) invokeV.objValue;
                    }
                }).get(3000L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.f35808e, com.alipay.sdk.app.statistic.b.k, th);
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
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
}
