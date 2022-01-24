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
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.apmobilesecuritysdk.b.a f30725b;

    /* renamed from: c  reason: collision with root package name */
    public int f30726c;

    public a(Context context) {
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
        this.f30725b = com.alipay.apmobilesecuritysdk.b.a.a();
        this.f30726c = 4;
        this.a = context;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String b2 = b(context);
            return com.alipay.security.mobile.module.a.a.a(b2) ? h.f(context) : b2;
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
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    String[] split = strArr[i2].split(" ");
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
        b b2;
        b c2;
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
                String d2 = h.d(context);
                if (com.alipay.security.mobile.module.a.a.b(a2)) {
                    dVar.f31050c = a2;
                } else {
                    dVar.f31050c = a4;
                }
                dVar.f31051d = securityToken;
                dVar.f31052e = d2;
                dVar.a = "android";
                com.alipay.apmobilesecuritysdk.e.c c3 = com.alipay.apmobilesecuritysdk.e.d.c(context);
                if (c3 != null) {
                    str2 = c3.a;
                    str = c3.f30732c;
                } else {
                    str = "";
                    str2 = str;
                }
                if (com.alipay.security.mobile.module.a.a.a(str2) && (c2 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                    str2 = c2.a;
                    str = c2.f30730c;
                }
                com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b();
                if (b3 != null) {
                    str4 = b3.a;
                    str3 = b3.f30732c;
                } else {
                    str3 = "";
                }
                if (com.alipay.security.mobile.module.a.a.a(str4) && (b2 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                    str4 = b2.a;
                    str3 = b2.f30730c;
                }
                dVar.f31055h = str2;
                dVar.f31054g = str4;
                dVar.f31057j = a3;
                if (com.alipay.security.mobile.module.a.a.a(str2)) {
                    dVar.f31049b = str4;
                    str = str3;
                } else {
                    dVar.f31049b = str2;
                }
                dVar.f31056i = str;
                dVar.f31053f = e.a(context, map);
                return com.alipay.security.mobile.module.http.d.b(this.a, this.f30725b.c()).a(dVar);
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
                String b2 = i.b();
                if (com.alipay.security.mobile.module.a.a.a(b2)) {
                    com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b(context);
                    if (b3 != null) {
                        i.a(b3);
                        String str = b3.a;
                        if (com.alipay.security.mobile.module.a.a.b(str)) {
                            return str;
                        }
                    }
                    b b4 = com.alipay.apmobilesecuritysdk.e.a.b(context);
                    if (b4 != null) {
                        i.a(b4);
                        String str2 = b4.a;
                        return com.alipay.security.mobile.module.a.a.b(str2) ? str2 : "";
                    }
                    return "";
                }
                return b2;
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
                for (int i2 = 0; i2 < 5; i2++) {
                    String str = strArr[i2];
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

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bf, code lost:
        if (com.alipay.security.mobile.module.a.a.a(b(r9.a)) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8 A[Catch: Exception -> 0x0240, TryCatch #0 {Exception -> 0x0240, blocks: (B:5:0x000c, B:7:0x003d, B:10:0x0046, B:39:0x00c4, B:71:0x01e8, B:73:0x0203, B:75:0x0209, B:77:0x020f, B:81:0x0218, B:83:0x021e, B:42:0x00d8, B:44:0x00f0, B:50:0x00fd, B:51:0x010d, B:53:0x0114, B:57:0x0126, B:59:0x0176, B:61:0x0180, B:63:0x0188, B:65:0x0195, B:67:0x019f, B:69:0x01a7, B:68:0x01a3, B:62:0x0184, B:13:0x005b, B:15:0x0069, B:18:0x0074, B:20:0x007a, B:23:0x0085, B:26:0x008e, B:29:0x009b, B:32:0x00a8, B:35:0x00b5), top: B:93:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0203 A[Catch: Exception -> 0x0240, TryCatch #0 {Exception -> 0x0240, blocks: (B:5:0x000c, B:7:0x003d, B:10:0x0046, B:39:0x00c4, B:71:0x01e8, B:73:0x0203, B:75:0x0209, B:77:0x020f, B:81:0x0218, B:83:0x021e, B:42:0x00d8, B:44:0x00f0, B:50:0x00fd, B:51:0x010d, B:53:0x0114, B:57:0x0126, B:59:0x0176, B:61:0x0180, B:63:0x0188, B:65:0x0195, B:67:0x019f, B:69:0x01a7, B:68:0x01a3, B:62:0x0184, B:13:0x005b, B:15:0x0069, B:18:0x0074, B:20:0x007a, B:23:0x0085, B:26:0x008e, B:29:0x009b, B:32:0x00a8, B:35:0x00b5), top: B:93:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0209 A[Catch: Exception -> 0x0240, TryCatch #0 {Exception -> 0x0240, blocks: (B:5:0x000c, B:7:0x003d, B:10:0x0046, B:39:0x00c4, B:71:0x01e8, B:73:0x0203, B:75:0x0209, B:77:0x020f, B:81:0x0218, B:83:0x021e, B:42:0x00d8, B:44:0x00f0, B:50:0x00fd, B:51:0x010d, B:53:0x0114, B:57:0x0126, B:59:0x0176, B:61:0x0180, B:63:0x0188, B:65:0x0195, B:67:0x019f, B:69:0x01a7, B:68:0x01a3, B:62:0x0184, B:13:0x005b, B:15:0x0069, B:18:0x0074, B:20:0x007a, B:23:0x0085, B:26:0x008e, B:29:0x009b, B:32:0x00a8, B:35:0x00b5), top: B:93:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0218 A[Catch: Exception -> 0x0240, TryCatch #0 {Exception -> 0x0240, blocks: (B:5:0x000c, B:7:0x003d, B:10:0x0046, B:39:0x00c4, B:71:0x01e8, B:73:0x0203, B:75:0x0209, B:77:0x020f, B:81:0x0218, B:83:0x021e, B:42:0x00d8, B:44:0x00f0, B:50:0x00fd, B:51:0x010d, B:53:0x0114, B:57:0x0126, B:59:0x0176, B:61:0x0180, B:63:0x0188, B:65:0x0195, B:67:0x019f, B:69:0x01a7, B:68:0x01a3, B:62:0x0184, B:13:0x005b, B:15:0x0069, B:18:0x0074, B:20:0x007a, B:23:0x0085, B:26:0x008e, B:29:0x009b, B:32:0x00a8, B:35:0x00b5), top: B:93:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(Map<String, String> map) {
        InterceptResult invokeL;
        String a;
        boolean z;
        boolean z2;
        int i2;
        String str;
        com.alipay.security.mobile.module.http.v2.a b2;
        Context context;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            try {
                com.alipay.apmobilesecuritysdk.c.a.a(this.a, com.alipay.security.mobile.module.a.a.a(map, "tid", ""), com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f30852g, ""), a(this.a));
                a = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                b();
                b(this.a);
                a(this.a, a);
                i.a();
                z = false;
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
            if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.a)) {
                e.a();
                if (!(!com.alipay.security.mobile.module.a.a.a(e.b(this.a, map), i.c()))) {
                    String a2 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                    String a3 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f30852g, "");
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
                                c b3 = b(map);
                                int c2 = b3 != null ? b3.c() : 2;
                                if (c2 != 1) {
                                    if (c2 != 3) {
                                        if (b3 != null) {
                                            str = "Server error, result:" + b3.f31040b;
                                        } else {
                                            str = "Server error, returned null";
                                        }
                                        com.alipay.apmobilesecuritysdk.c.a.a(str);
                                        if (com.alipay.security.mobile.module.a.a.a(a(this.a, a))) {
                                            i2 = 4;
                                        }
                                    } else {
                                        i2 = 1;
                                    }
                                    this.f30726c = i2;
                                    b2 = com.alipay.security.mobile.module.http.d.b(this.a, this.f30725b.c());
                                    context = this.a;
                                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                    activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                                        z = true;
                                    }
                                    if (z && h.c(context)) {
                                        new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                                    }
                                    return this.f30726c;
                                }
                                h.a(this.a, b3.b());
                                h.d(this.a, b3.a());
                                h.e(this.a, b3.f31045g);
                                h.a(this.a, b3.f31046h);
                                h.f(this.a, b3.f31047i);
                                h.g(this.a, b3.k);
                                i.c(e.b(this.a, map));
                                i.a(a, b3.f31042d);
                                i.b(b3.f31041c);
                                i.d(b3.f31048j);
                                String a4 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                                if (!com.alipay.security.mobile.module.a.a.b(a4) || com.alipay.security.mobile.module.a.a.a(a4, i.d())) {
                                    a4 = i.d();
                                } else {
                                    i.e(a4);
                                }
                                i.e(a4);
                                String a5 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f30852g, "");
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
                            i2 = 0;
                            this.f30726c = i2;
                            b2 = com.alipay.security.mobile.module.http.d.b(this.a, this.f30725b.c());
                            context = this.a;
                            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager2 != null) {
                            }
                            if (activeNetworkInfo != null) {
                                z = true;
                            }
                            if (z) {
                                new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                            }
                            return this.f30726c;
                        }
                    }
                }
                z2 = true;
                Context context22 = this.a;
                com.alipay.security.mobile.module.b.b.b();
                h.b(context22, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                if (z2) {
                }
                i2 = 0;
                this.f30726c = i2;
                b2 = com.alipay.security.mobile.module.http.d.b(this.a, this.f30725b.c());
                context = this.a;
                ConnectivityManager connectivityManager22 = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager22 != null) {
                }
                if (activeNetworkInfo != null) {
                }
                if (z) {
                }
                return this.f30726c;
            }
            if (!com.alipay.security.mobile.module.a.a.a(a(this.a, a))) {
            }
            z2 = true;
            Context context222 = this.a;
            com.alipay.security.mobile.module.b.b.b();
            h.b(context222, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
            if (z2) {
            }
            i2 = 0;
            this.f30726c = i2;
            b2 = com.alipay.security.mobile.module.http.d.b(this.a, this.f30725b.c());
            context = this.a;
            ConnectivityManager connectivityManager222 = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager222 != null) {
            }
            if (activeNetworkInfo != null) {
            }
            if (z) {
            }
            return this.f30726c;
        }
        return invokeL.intValue;
    }
}
