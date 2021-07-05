package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.app.i;
import com.alipay.sdk.util.n;
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
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1872a = "virtualImeiAndImsi";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1873b = "virtual_imei";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1874c = "virtual_imsi";

    /* renamed from: d  reason: collision with root package name */
    public static c f1875d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f1876e;

    /* renamed from: f  reason: collision with root package name */
    public String f1877f;

    /* renamed from: g  reason: collision with root package name */
    public String f1878g;

    public c() {
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
        this.f1877f = "sdk-and-lite";
        String a2 = i.a();
        if (i.b()) {
            return;
        }
        this.f1877f += '_' + a2;
    }

    public static synchronized c b() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (c.class) {
                if (f1875d == null) {
                    f1875d = new c();
                }
                cVar = f1875d;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    private String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? "1" : (String) invokeV.objValue;
    }

    private String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? "-1;-1" : (String) invokeV.objValue;
    }

    private String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            String hexString = Long.toHexString(System.currentTimeMillis());
            Random random = new Random();
            return hexString + (random.nextInt(9000) + 1000);
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context b3 = com.alipay.sdk.sys.b.a().b();
            SharedPreferences sharedPreferences = b3.getSharedPreferences(f1872a, 0);
            String string = sharedPreferences.getString(f1873b, null);
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a(b3).a())) {
                    b2 = g();
                } else {
                    b2 = com.alipay.sdk.util.a.a(b3).b();
                }
                String str = b2;
                sharedPreferences.edit().putString(f1873b, str).commit();
                return str;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context b2 = com.alipay.sdk.sys.b.a().b();
            SharedPreferences sharedPreferences = b2.getSharedPreferences(f1872a, 0);
            String string = sharedPreferences.getString(f1874c, null);
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a(b2).a())) {
                    String e2 = com.alipay.sdk.sys.b.a().e();
                    if (TextUtils.isEmpty(e2)) {
                        a2 = g();
                    } else {
                        a2 = e2.substring(3, 18);
                    }
                } else {
                    a2 = com.alipay.sdk.util.a.a(b2).a();
                }
                String str = a2;
                sharedPreferences.edit().putString(f1874c, str).commit();
                return str;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1878g : (String) invokeV.objValue;
    }

    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.sys.b.a().b()).edit().putString(com.alipay.sdk.cons.b.f1848i, str).commit();
                com.alipay.sdk.cons.a.f1833c = str;
            }
        }
    }

    private String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, this, context)) == null) ? Float.toString(new TextView(context).getTextSize()) : (String) invokeL.objValue;
    }

    private String b(Context context, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, context, hashMap)) == null) {
            try {
                return (String) Executors.newFixedThreadPool(2).submit(new d(this, context, hashMap)).get(3000L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f1826e, com.alipay.sdk.app.statistic.c.j, th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    private String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context)) == null) {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getSSID() : "-1";
        }
        return (String) invokeL.objValue;
    }

    public String a(com.alipay.sdk.tid.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            Context b2 = com.alipay.sdk.sys.b.a().b();
            com.alipay.sdk.util.a a2 = com.alipay.sdk.util.a.a(b2);
            if (TextUtils.isEmpty(this.f1876e)) {
                String b3 = n.b();
                String c2 = n.c();
                String d2 = n.d(b2);
                String f2 = n.f(b2);
                String e2 = n.e(b2);
                String b4 = b(b2);
                this.f1876e = "Msp/15.6.5 (" + b3 + ";" + c2 + ";" + d2 + ";" + f2 + ";" + e2 + ";" + b4;
            }
            String b5 = com.alipay.sdk.util.a.b(b2).b();
            String g2 = n.g(b2);
            String e3 = e();
            String a3 = a2.a();
            String b6 = a2.b();
            String d3 = d();
            String c3 = c();
            if (bVar != null) {
                this.f1878g = bVar.b();
            }
            String replace = Build.MANUFACTURER.replace(";", " ");
            String replace2 = Build.MODEL.replace(";", " ");
            boolean d4 = com.alipay.sdk.sys.b.d();
            String d5 = a2.d();
            String c4 = c(b2);
            String d6 = d(b2);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1876e);
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
            sb.append(this.f1878g);
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
            sb.append(this.f1877f);
            sb.append(";");
            sb.append(d3);
            sb.append(";");
            sb.append(c3);
            sb.append(";");
            sb.append(c4);
            sb.append(";");
            sb.append(d6);
            if (bVar != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("tid", com.alipay.sdk.tid.b.a(b2).a());
                hashMap.put(com.alipay.sdk.cons.b.f1846g, com.alipay.sdk.sys.b.a().e());
                String b7 = b(b2, hashMap);
                if (!TextUtils.isEmpty(b7)) {
                    sb.append(";");
                    sb.append(b7);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getBSSID() : "00";
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, context, hashMap)) == null) {
            try {
                str = SecurityClientMobile.GetApdid(context, hashMap);
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a(th);
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f1826e, com.alipay.sdk.app.statistic.c.f1829h, th);
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f1826e, com.alipay.sdk.app.statistic.c.f1830i, "apdid == null");
            }
            com.alipay.sdk.util.c.d(com.alipay.sdk.net.a.f1893a, "apdid:" + str);
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
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
