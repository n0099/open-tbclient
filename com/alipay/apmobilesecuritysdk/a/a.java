package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.security.mobile.module.http.model.c;
import com.alipay.security.mobile.module.http.model.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public com.alipay.apmobilesecuritysdk.b.a b;
    public int c;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = com.alipay.apmobilesecuritysdk.b.a.a();
        this.c = 4;
        this.a = context;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String b = b(context);
            return com.alipay.security.mobile.module.a.a.a(b) ? h.f(context) : b;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                b();
                String a = i.a(str);
                if (com.alipay.security.mobile.module.a.a.a(a)) {
                    String a2 = g.a(context, str);
                    i.a(str, a2);
                    return !com.alipay.security.mobile.module.a.a.a(a2) ? a2 : "";
                }
                return a;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
            int random = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
            for (int i = 0; i < 3; i++) {
                try {
                    String[] split = strArr[i].split(" ");
                    if (split != null && split.length == 2) {
                        Date date = new Date();
                        Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                        Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(parse2);
                        calendar.add(13, random);
                        Date time = calendar.getTime();
                        if (date.after(parse) && date.before(time)) {
                            return true;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private c b(Map<String, String> map) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        b b;
        b c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, map)) == null) {
            String str4 = "";
            try {
                Context context = this.a;
                d dVar = new d();
                String a = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                String a2 = com.alipay.security.mobile.module.a.a.a(map, "sessionId", "");
                String a3 = com.alipay.security.mobile.module.a.a.a(map, "rpcVersion", "");
                String a4 = a(context, a);
                String securityToken = UmidSdkWrapper.getSecurityToken(context);
                String d = h.d(context);
                if (com.alipay.security.mobile.module.a.a.b(a2)) {
                    dVar.c = a2;
                } else {
                    dVar.c = a4;
                }
                dVar.d = securityToken;
                dVar.e = d;
                dVar.a = "android";
                com.alipay.apmobilesecuritysdk.e.c c2 = com.alipay.apmobilesecuritysdk.e.d.c(context);
                if (c2 != null) {
                    str2 = c2.a;
                    str = c2.c;
                } else {
                    str = "";
                    str2 = str;
                }
                if (com.alipay.security.mobile.module.a.a.a(str2) && (c = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                    str2 = c.a;
                    str = c.c;
                }
                com.alipay.apmobilesecuritysdk.e.c b2 = com.alipay.apmobilesecuritysdk.e.d.b();
                if (b2 != null) {
                    str4 = b2.a;
                    str3 = b2.c;
                } else {
                    str3 = "";
                }
                if (com.alipay.security.mobile.module.a.a.a(str4) && (b = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                    str4 = b.a;
                    str3 = b.c;
                }
                dVar.h = str2;
                dVar.g = str4;
                dVar.j = a3;
                if (com.alipay.security.mobile.module.a.a.a(str2)) {
                    dVar.b = str4;
                    str = str3;
                } else {
                    dVar.b = str2;
                }
                dVar.i = str;
                dVar.f = e.a(context, map);
                return com.alipay.security.mobile.module.http.d.b(this.a, this.b.c()).a(dVar);
            } catch (Throwable th) {
                th.printStackTrace();
                com.alipay.apmobilesecuritysdk.c.a.a(th);
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                String b = i.b();
                if (com.alipay.security.mobile.module.a.a.a(b)) {
                    com.alipay.apmobilesecuritysdk.e.c b2 = com.alipay.apmobilesecuritysdk.e.d.b(context);
                    if (b2 != null) {
                        i.a(b2);
                        String str = b2.a;
                        if (com.alipay.security.mobile.module.a.a.b(str)) {
                            return str;
                        }
                    }
                    b b3 = com.alipay.apmobilesecuritysdk.e.a.b(context);
                    if (b3 != null) {
                        i.a(b3);
                        String str2 = b3.a;
                        return com.alipay.security.mobile.module.a.a.b(str2) ? str2 : "";
                    }
                    return "";
                }
                return b;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            try {
                String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
                for (int i = 0; i < 5; i++) {
                    String str = strArr[i];
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    File file = new File(externalStorageDirectory, ".SystemConfig/" + str);
                    if (file.exists() && file.canWrite()) {
                        file.delete();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:
        if (com.alipay.security.mobile.module.a.a.a(b(r9.a)) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7 A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:5:0x000b, B:7:0x003c, B:10:0x0045, B:39:0x00c3, B:71:0x01e7, B:73:0x0202, B:75:0x0208, B:77:0x020e, B:81:0x0217, B:83:0x021d, B:42:0x00d7, B:44:0x00ef, B:50:0x00fc, B:51:0x010c, B:53:0x0113, B:57:0x0125, B:59:0x0175, B:61:0x017f, B:63:0x0187, B:65:0x0194, B:67:0x019e, B:69:0x01a6, B:68:0x01a2, B:62:0x0183, B:13:0x005a, B:15:0x0068, B:18:0x0073, B:20:0x0079, B:23:0x0084, B:26:0x008d, B:29:0x009a, B:32:0x00a7, B:35:0x00b4), top: B:93:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0202 A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:5:0x000b, B:7:0x003c, B:10:0x0045, B:39:0x00c3, B:71:0x01e7, B:73:0x0202, B:75:0x0208, B:77:0x020e, B:81:0x0217, B:83:0x021d, B:42:0x00d7, B:44:0x00ef, B:50:0x00fc, B:51:0x010c, B:53:0x0113, B:57:0x0125, B:59:0x0175, B:61:0x017f, B:63:0x0187, B:65:0x0194, B:67:0x019e, B:69:0x01a6, B:68:0x01a2, B:62:0x0183, B:13:0x005a, B:15:0x0068, B:18:0x0073, B:20:0x0079, B:23:0x0084, B:26:0x008d, B:29:0x009a, B:32:0x00a7, B:35:0x00b4), top: B:93:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0208 A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:5:0x000b, B:7:0x003c, B:10:0x0045, B:39:0x00c3, B:71:0x01e7, B:73:0x0202, B:75:0x0208, B:77:0x020e, B:81:0x0217, B:83:0x021d, B:42:0x00d7, B:44:0x00ef, B:50:0x00fc, B:51:0x010c, B:53:0x0113, B:57:0x0125, B:59:0x0175, B:61:0x017f, B:63:0x0187, B:65:0x0194, B:67:0x019e, B:69:0x01a6, B:68:0x01a2, B:62:0x0183, B:13:0x005a, B:15:0x0068, B:18:0x0073, B:20:0x0079, B:23:0x0084, B:26:0x008d, B:29:0x009a, B:32:0x00a7, B:35:0x00b4), top: B:93:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0217 A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:5:0x000b, B:7:0x003c, B:10:0x0045, B:39:0x00c3, B:71:0x01e7, B:73:0x0202, B:75:0x0208, B:77:0x020e, B:81:0x0217, B:83:0x021d, B:42:0x00d7, B:44:0x00ef, B:50:0x00fc, B:51:0x010c, B:53:0x0113, B:57:0x0125, B:59:0x0175, B:61:0x017f, B:63:0x0187, B:65:0x0194, B:67:0x019e, B:69:0x01a6, B:68:0x01a2, B:62:0x0183, B:13:0x005a, B:15:0x0068, B:18:0x0073, B:20:0x0079, B:23:0x0084, B:26:0x008d, B:29:0x009a, B:32:0x00a7, B:35:0x00b4), top: B:93:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(Map<String, String> map) {
        InterceptResult invokeL;
        String a;
        boolean z;
        boolean z2;
        int i;
        String str;
        com.alipay.security.mobile.module.http.v2.a b;
        Context context;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            try {
                com.alipay.apmobilesecuritysdk.c.a.a(this.a, com.alipay.security.mobile.module.a.a.a(map, "tid", ""), com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.g, ""), a(this.a));
                a = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                b();
                b(this.a);
                a(this.a, a);
                i.a();
                z = false;
            } catch (Exception e) {
                com.alipay.apmobilesecuritysdk.c.a.a(e);
            }
            if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.a)) {
                e.a();
                if (!(!com.alipay.security.mobile.module.a.a.a(e.b(this.a, map), i.c()))) {
                    String a2 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                    String a3 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.g, "");
                    if (com.alipay.security.mobile.module.a.a.b(a2)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a2, i.d())) {
                        }
                    }
                    if (com.alipay.security.mobile.module.a.a.b(a3)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a3, i.e())) {
                        }
                    }
                    if (i.a(this.a, a)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a(this.a, a))) {
                            if (com.alipay.security.mobile.module.a.a.a(b(this.a))) {
                            }
                            z2 = false;
                            Context context2 = this.a;
                            com.alipay.security.mobile.module.b.b.b();
                            h.b(context2, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                            if (z2) {
                                new com.alipay.apmobilesecuritysdk.c.b();
                                UmidSdkWrapper.startUmidTaskSync(this.a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                                c b2 = b(map);
                                int c = b2 != null ? b2.c() : 2;
                                if (c != 1) {
                                    if (c != 3) {
                                        if (b2 != null) {
                                            str = "Server error, result:" + b2.b;
                                        } else {
                                            str = "Server error, returned null";
                                        }
                                        com.alipay.apmobilesecuritysdk.c.a.a(str);
                                        if (com.alipay.security.mobile.module.a.a.a(a(this.a, a))) {
                                            i = 4;
                                        }
                                    } else {
                                        i = 1;
                                    }
                                    this.c = i;
                                    b = com.alipay.security.mobile.module.http.d.b(this.a, this.b.c());
                                    context = this.a;
                                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                    activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                                        z = true;
                                    }
                                    if (z && h.c(context)) {
                                        new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b).a();
                                    }
                                    return this.c;
                                }
                                h.a(this.a, b2.b());
                                h.d(this.a, b2.a());
                                h.e(this.a, b2.g);
                                h.a(this.a, b2.h);
                                h.f(this.a, b2.i);
                                h.g(this.a, b2.k);
                                i.c(e.b(this.a, map));
                                i.a(a, b2.d);
                                i.b(b2.c);
                                i.d(b2.j);
                                String a4 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                                if (!com.alipay.security.mobile.module.a.a.b(a4) || com.alipay.security.mobile.module.a.a.a(a4, i.d())) {
                                    a4 = i.d();
                                } else {
                                    i.e(a4);
                                }
                                i.e(a4);
                                String a5 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.g, "");
                                if (!com.alipay.security.mobile.module.a.a.b(a5) || com.alipay.security.mobile.module.a.a.a(a5, i.e())) {
                                    a5 = i.e();
                                } else {
                                    i.f(a5);
                                }
                                i.f(a5);
                                i.a();
                                com.alipay.apmobilesecuritysdk.e.d.a(this.a, i.g());
                                com.alipay.apmobilesecuritysdk.e.d.a();
                                com.alipay.apmobilesecuritysdk.e.a.a(this.a, new b(i.b(), i.c(), i.f()));
                                com.alipay.apmobilesecuritysdk.e.a.a();
                                g.a(this.a, a, i.a(a));
                                g.a();
                                h.a(this.a, a, System.currentTimeMillis());
                            }
                            i = 0;
                            this.c = i;
                            b = com.alipay.security.mobile.module.http.d.b(this.a, this.b.c());
                            context = this.a;
                            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager2 != null) {
                            }
                            if (activeNetworkInfo != null) {
                                z = true;
                            }
                            if (z) {
                                new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b).a();
                            }
                            return this.c;
                        }
                    }
                }
                z2 = true;
                Context context22 = this.a;
                com.alipay.security.mobile.module.b.b.b();
                h.b(context22, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                if (z2) {
                }
                i = 0;
                this.c = i;
                b = com.alipay.security.mobile.module.http.d.b(this.a, this.b.c());
                context = this.a;
                ConnectivityManager connectivityManager22 = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager22 != null) {
                }
                if (activeNetworkInfo != null) {
                }
                if (z) {
                }
                return this.c;
            }
            if (!com.alipay.security.mobile.module.a.a.a(a(this.a, a))) {
            }
            z2 = true;
            Context context222 = this.a;
            com.alipay.security.mobile.module.b.b.b();
            h.b(context222, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
            if (z2) {
            }
            i = 0;
            this.c = i;
            b = com.alipay.security.mobile.module.http.d.b(this.a, this.b.c());
            context = this.a;
            ConnectivityManager connectivityManager222 = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager222 != null) {
            }
            if (activeNetworkInfo != null) {
            }
            if (z) {
            }
            return this.c;
        }
        return invokeL.intValue;
    }
}
