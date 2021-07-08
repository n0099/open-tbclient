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
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public Context f1697a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.apmobilesecuritysdk.b.a f1698b;

    /* renamed from: c  reason: collision with root package name */
    public int f1699c;

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
        this.f1698b = com.alipay.apmobilesecuritysdk.b.a.a();
        this.f1699c = 4;
        this.f1697a = context;
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
                String a2 = i.a(str);
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    String a3 = g.a(context, str);
                    i.a(str, a3);
                    return !com.alipay.security.mobile.module.a.a.a(a3) ? a3 : "";
                }
                return a2;
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
                Context context = this.f1697a;
                d dVar = new d();
                String a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                String a3 = com.alipay.security.mobile.module.a.a.a(map, "sessionId", "");
                String a4 = com.alipay.security.mobile.module.a.a.a(map, "rpcVersion", "");
                String a5 = a(context, a2);
                String securityToken = UmidSdkWrapper.getSecurityToken(context);
                String d2 = h.d(context);
                if (com.alipay.security.mobile.module.a.a.b(a3)) {
                    dVar.f2108c = a3;
                } else {
                    dVar.f2108c = a5;
                }
                dVar.f2109d = securityToken;
                dVar.f2110e = d2;
                dVar.f2106a = "android";
                com.alipay.apmobilesecuritysdk.e.c c3 = com.alipay.apmobilesecuritysdk.e.d.c(context);
                if (c3 != null) {
                    str2 = c3.f1707a;
                    str = c3.f1709c;
                } else {
                    str = "";
                    str2 = str;
                }
                if (com.alipay.security.mobile.module.a.a.a(str2) && (c2 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                    str2 = c2.f1704a;
                    str = c2.f1706c;
                }
                com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b();
                if (b3 != null) {
                    str4 = b3.f1707a;
                    str3 = b3.f1709c;
                } else {
                    str3 = "";
                }
                if (com.alipay.security.mobile.module.a.a.a(str4) && (b2 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                    str4 = b2.f1704a;
                    str3 = b2.f1706c;
                }
                dVar.f2113h = str2;
                dVar.f2112g = str4;
                dVar.j = a4;
                if (com.alipay.security.mobile.module.a.a.a(str2)) {
                    dVar.f2107b = str4;
                    dVar.f2114i = str3;
                } else {
                    dVar.f2107b = str2;
                    dVar.f2114i = str;
                }
                dVar.f2111f = e.a(context, map);
                return com.alipay.security.mobile.module.http.d.b(this.f1697a, this.f1698b.c()).a(dVar);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                String b2 = i.b();
                if (com.alipay.security.mobile.module.a.a.a(b2)) {
                    com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b(context);
                    if (b3 != null) {
                        i.a(b3);
                        String str = b3.f1707a;
                        if (com.alipay.security.mobile.module.a.a.b(str)) {
                            return str;
                        }
                    }
                    b b4 = com.alipay.apmobilesecuritysdk.e.a.b(context);
                    if (b4 != null) {
                        i.a(b4);
                        String str2 = b4.f1704a;
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8 A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:5:0x000a, B:7:0x003b, B:10:0x0044, B:39:0x00c2, B:70:0x01e9, B:72:0x0204, B:74:0x020a, B:76:0x0210, B:80:0x0219, B:82:0x021f, B:42:0x00d8, B:44:0x00f0, B:50:0x00fd, B:51:0x010d, B:53:0x0114, B:57:0x0126, B:59:0x0176, B:61:0x0180, B:63:0x0188, B:65:0x0195, B:67:0x019f, B:69:0x01a7, B:68:0x01a3, B:62:0x0184, B:13:0x0059, B:15:0x0067, B:18:0x0072, B:20:0x0078, B:23:0x0083, B:26:0x008c, B:29:0x0099, B:32:0x00a6, B:35:0x00b4), top: B:92:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0204 A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:5:0x000a, B:7:0x003b, B:10:0x0044, B:39:0x00c2, B:70:0x01e9, B:72:0x0204, B:74:0x020a, B:76:0x0210, B:80:0x0219, B:82:0x021f, B:42:0x00d8, B:44:0x00f0, B:50:0x00fd, B:51:0x010d, B:53:0x0114, B:57:0x0126, B:59:0x0176, B:61:0x0180, B:63:0x0188, B:65:0x0195, B:67:0x019f, B:69:0x01a7, B:68:0x01a3, B:62:0x0184, B:13:0x0059, B:15:0x0067, B:18:0x0072, B:20:0x0078, B:23:0x0083, B:26:0x008c, B:29:0x0099, B:32:0x00a6, B:35:0x00b4), top: B:92:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x020a A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:5:0x000a, B:7:0x003b, B:10:0x0044, B:39:0x00c2, B:70:0x01e9, B:72:0x0204, B:74:0x020a, B:76:0x0210, B:80:0x0219, B:82:0x021f, B:42:0x00d8, B:44:0x00f0, B:50:0x00fd, B:51:0x010d, B:53:0x0114, B:57:0x0126, B:59:0x0176, B:61:0x0180, B:63:0x0188, B:65:0x0195, B:67:0x019f, B:69:0x01a7, B:68:0x01a3, B:62:0x0184, B:13:0x0059, B:15:0x0067, B:18:0x0072, B:20:0x0078, B:23:0x0083, B:26:0x008c, B:29:0x0099, B:32:0x00a6, B:35:0x00b4), top: B:92:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0219 A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:5:0x000a, B:7:0x003b, B:10:0x0044, B:39:0x00c2, B:70:0x01e9, B:72:0x0204, B:74:0x020a, B:76:0x0210, B:80:0x0219, B:82:0x021f, B:42:0x00d8, B:44:0x00f0, B:50:0x00fd, B:51:0x010d, B:53:0x0114, B:57:0x0126, B:59:0x0176, B:61:0x0180, B:63:0x0188, B:65:0x0195, B:67:0x019f, B:69:0x01a7, B:68:0x01a3, B:62:0x0184, B:13:0x0059, B:15:0x0067, B:18:0x0072, B:20:0x0078, B:23:0x0083, B:26:0x008c, B:29:0x0099, B:32:0x00a6, B:35:0x00b4), top: B:92:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(Map<String, String> map) {
        InterceptResult invokeL;
        String a2;
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
                com.alipay.apmobilesecuritysdk.c.a.a(this.f1697a, com.alipay.security.mobile.module.a.a.a(map, "tid", ""), com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f1847g, ""), a(this.f1697a));
                a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                b();
                b(this.f1697a);
                a(this.f1697a, a2);
                i.a();
                z = false;
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
            if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.f1697a)) {
                e.a();
                if (!(!com.alipay.security.mobile.module.a.a.a(e.b(this.f1697a, map), i.c()))) {
                    String a3 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                    String a4 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f1847g, "");
                    if (com.alipay.security.mobile.module.a.a.b(a3)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a3, i.d())) {
                        }
                    }
                    if (com.alipay.security.mobile.module.a.a.b(a4)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a4, i.e())) {
                        }
                    }
                    if (i.a(this.f1697a, a2)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a(this.f1697a, a2))) {
                            if (com.alipay.security.mobile.module.a.a.a(b(this.f1697a))) {
                            }
                            z2 = false;
                            h.b(this.f1697a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
                            if (z2) {
                                new com.alipay.apmobilesecuritysdk.c.b();
                                UmidSdkWrapper.startUmidTaskSync(this.f1697a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                                c b3 = b(map);
                                int a5 = b3 != null ? b3.a() : 2;
                                if (a5 != 1) {
                                    if (a5 != 3) {
                                        if (b3 != null) {
                                            str = "Server error, result:" + b3.f2098b;
                                        } else {
                                            str = "Server error, returned null";
                                        }
                                        com.alipay.apmobilesecuritysdk.c.a.a(str);
                                        if (com.alipay.security.mobile.module.a.a.a(a(this.f1697a, a2))) {
                                            i2 = 4;
                                        }
                                    } else {
                                        i2 = 1;
                                    }
                                    this.f1699c = i2;
                                    b2 = com.alipay.security.mobile.module.http.d.b(this.f1697a, this.f1698b.c());
                                    context = this.f1697a;
                                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                    activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                                        z = true;
                                    }
                                    if (z && h.c(context)) {
                                        new com.alipay.security.mobile.module.c.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                                    }
                                    return this.f1699c;
                                }
                                h.a(this.f1697a, b3.b());
                                h.d(this.f1697a, b3.c());
                                h.e(this.f1697a, b3.l);
                                h.a(this.f1697a, b3.m);
                                h.f(this.f1697a, b3.n);
                                h.g(this.f1697a, b3.p);
                                i.c(e.b(this.f1697a, map));
                                i.a(a2, b3.f2105i);
                                i.b(b3.f2104h);
                                i.d(b3.o);
                                String a6 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                                if (!com.alipay.security.mobile.module.a.a.b(a6) || com.alipay.security.mobile.module.a.a.a(a6, i.d())) {
                                    a6 = i.d();
                                } else {
                                    i.e(a6);
                                }
                                i.e(a6);
                                String a7 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f1847g, "");
                                if (!com.alipay.security.mobile.module.a.a.b(a7) || com.alipay.security.mobile.module.a.a.a(a7, i.e())) {
                                    a7 = i.e();
                                } else {
                                    i.f(a7);
                                }
                                i.f(a7);
                                i.a();
                                com.alipay.apmobilesecuritysdk.e.d.a(this.f1697a, i.g());
                                com.alipay.apmobilesecuritysdk.e.d.a();
                                com.alipay.apmobilesecuritysdk.e.a.a(this.f1697a, new b(i.b(), i.c(), i.f()));
                                com.alipay.apmobilesecuritysdk.e.a.a();
                                g.a(this.f1697a, a2, i.a(a2));
                                g.a();
                                h.a(this.f1697a, a2, System.currentTimeMillis());
                            }
                            i2 = 0;
                            this.f1699c = i2;
                            b2 = com.alipay.security.mobile.module.http.d.b(this.f1697a, this.f1698b.c());
                            context = this.f1697a;
                            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager2 != null) {
                            }
                            if (activeNetworkInfo != null) {
                                z = true;
                            }
                            if (z) {
                                new com.alipay.security.mobile.module.c.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                            }
                            return this.f1699c;
                        }
                    }
                }
                z2 = true;
                h.b(this.f1697a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
                if (z2) {
                }
                i2 = 0;
                this.f1699c = i2;
                b2 = com.alipay.security.mobile.module.http.d.b(this.f1697a, this.f1698b.c());
                context = this.f1697a;
                ConnectivityManager connectivityManager22 = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager22 != null) {
                }
                if (activeNetworkInfo != null) {
                }
                if (z) {
                }
                return this.f1699c;
            }
            if (!com.alipay.security.mobile.module.a.a.a(a(this.f1697a, a2))) {
                if (com.alipay.security.mobile.module.a.a.a(b(this.f1697a))) {
                }
                z2 = false;
                h.b(this.f1697a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
                if (z2) {
                }
                i2 = 0;
                this.f1699c = i2;
                b2 = com.alipay.security.mobile.module.http.d.b(this.f1697a, this.f1698b.c());
                context = this.f1697a;
                ConnectivityManager connectivityManager222 = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager222 != null) {
                }
                if (activeNetworkInfo != null) {
                }
                if (z) {
                }
                return this.f1699c;
            }
            z2 = true;
            h.b(this.f1697a, String.valueOf(com.alipay.security.mobile.module.deviceinfo.b.a().u()));
            if (z2) {
            }
            i2 = 0;
            this.f1699c = i2;
            b2 = com.alipay.security.mobile.module.http.d.b(this.f1697a, this.f1698b.c());
            context = this.f1697a;
            ConnectivityManager connectivityManager2222 = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager2222 != null) {
            }
            if (activeNetworkInfo != null) {
            }
            if (z) {
            }
            return this.f1699c;
        }
        return invokeL.intValue;
    }
}
