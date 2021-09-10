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
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f35781a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.apmobilesecuritysdk.b.a f35782b;

    /* renamed from: c  reason: collision with root package name */
    public int f35783c;

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
        this.f35782b = com.alipay.apmobilesecuritysdk.b.a.a();
        this.f35783c = 4;
        this.f35781a = context;
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
                Context context = this.f35781a;
                d dVar = new d();
                String a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                String a3 = com.alipay.security.mobile.module.a.a.a(map, "sessionId", "");
                String a4 = com.alipay.security.mobile.module.a.a.a(map, "rpcVersion", "");
                String a5 = a(context, a2);
                String securityToken = UmidSdkWrapper.getSecurityToken(context);
                String d2 = h.d(context);
                if (com.alipay.security.mobile.module.a.a.b(a3)) {
                    dVar.f36205c = a3;
                } else {
                    dVar.f36205c = a5;
                }
                dVar.f36206d = securityToken;
                dVar.f36207e = d2;
                dVar.f36203a = "android";
                com.alipay.apmobilesecuritysdk.e.c c3 = com.alipay.apmobilesecuritysdk.e.d.c(context);
                if (c3 != null) {
                    str2 = c3.f35791a;
                    str = c3.f35793c;
                } else {
                    str = "";
                    str2 = str;
                }
                if (com.alipay.security.mobile.module.a.a.a(str2) && (c2 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                    str2 = c2.f35788a;
                    str = c2.f35790c;
                }
                com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b();
                if (b3 != null) {
                    str4 = b3.f35791a;
                    str3 = b3.f35793c;
                } else {
                    str3 = "";
                }
                if (com.alipay.security.mobile.module.a.a.a(str4) && (b2 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                    str4 = b2.f35788a;
                    str3 = b2.f35790c;
                }
                dVar.f36210h = str2;
                dVar.f36209g = str4;
                dVar.f36212j = a4;
                if (com.alipay.security.mobile.module.a.a.a(str2)) {
                    dVar.f36204b = str4;
                    dVar.f36211i = str3;
                } else {
                    dVar.f36204b = str2;
                    dVar.f36211i = str;
                }
                dVar.f36208f = e.a(context, map);
                return com.alipay.security.mobile.module.http.d.b(this.f35781a, this.f35782b.c()).a(dVar);
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
                        String str = b3.f35791a;
                        if (com.alipay.security.mobile.module.a.a.b(str)) {
                            return str;
                        }
                    }
                    b b4 = com.alipay.apmobilesecuritysdk.e.a.b(context);
                    if (b4 != null) {
                        i.a(b4);
                        String str2 = b4.f35788a;
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

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7 A[Catch: Exception -> 0x0240, TryCatch #0 {Exception -> 0x0240, blocks: (B:5:0x000a, B:7:0x003b, B:10:0x0044, B:39:0x00c2, B:70:0x01e8, B:72:0x0203, B:74:0x0209, B:76:0x020f, B:80:0x0218, B:82:0x021e, B:42:0x00d7, B:44:0x00ef, B:50:0x00fc, B:51:0x010c, B:53:0x0113, B:57:0x0125, B:59:0x0175, B:61:0x017f, B:63:0x0187, B:65:0x0194, B:67:0x019e, B:69:0x01a6, B:68:0x01a2, B:62:0x0183, B:13:0x0059, B:15:0x0067, B:18:0x0072, B:20:0x0078, B:23:0x0083, B:26:0x008c, B:29:0x0099, B:32:0x00a6, B:35:0x00b4), top: B:92:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0203 A[Catch: Exception -> 0x0240, TryCatch #0 {Exception -> 0x0240, blocks: (B:5:0x000a, B:7:0x003b, B:10:0x0044, B:39:0x00c2, B:70:0x01e8, B:72:0x0203, B:74:0x0209, B:76:0x020f, B:80:0x0218, B:82:0x021e, B:42:0x00d7, B:44:0x00ef, B:50:0x00fc, B:51:0x010c, B:53:0x0113, B:57:0x0125, B:59:0x0175, B:61:0x017f, B:63:0x0187, B:65:0x0194, B:67:0x019e, B:69:0x01a6, B:68:0x01a2, B:62:0x0183, B:13:0x0059, B:15:0x0067, B:18:0x0072, B:20:0x0078, B:23:0x0083, B:26:0x008c, B:29:0x0099, B:32:0x00a6, B:35:0x00b4), top: B:92:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0209 A[Catch: Exception -> 0x0240, TryCatch #0 {Exception -> 0x0240, blocks: (B:5:0x000a, B:7:0x003b, B:10:0x0044, B:39:0x00c2, B:70:0x01e8, B:72:0x0203, B:74:0x0209, B:76:0x020f, B:80:0x0218, B:82:0x021e, B:42:0x00d7, B:44:0x00ef, B:50:0x00fc, B:51:0x010c, B:53:0x0113, B:57:0x0125, B:59:0x0175, B:61:0x017f, B:63:0x0187, B:65:0x0194, B:67:0x019e, B:69:0x01a6, B:68:0x01a2, B:62:0x0183, B:13:0x0059, B:15:0x0067, B:18:0x0072, B:20:0x0078, B:23:0x0083, B:26:0x008c, B:29:0x0099, B:32:0x00a6, B:35:0x00b4), top: B:92:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0218 A[Catch: Exception -> 0x0240, TryCatch #0 {Exception -> 0x0240, blocks: (B:5:0x000a, B:7:0x003b, B:10:0x0044, B:39:0x00c2, B:70:0x01e8, B:72:0x0203, B:74:0x0209, B:76:0x020f, B:80:0x0218, B:82:0x021e, B:42:0x00d7, B:44:0x00ef, B:50:0x00fc, B:51:0x010c, B:53:0x0113, B:57:0x0125, B:59:0x0175, B:61:0x017f, B:63:0x0187, B:65:0x0194, B:67:0x019e, B:69:0x01a6, B:68:0x01a2, B:62:0x0183, B:13:0x0059, B:15:0x0067, B:18:0x0072, B:20:0x0078, B:23:0x0083, B:26:0x008c, B:29:0x0099, B:32:0x00a6, B:35:0x00b4), top: B:92:0x000a }] */
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
                com.alipay.apmobilesecuritysdk.c.a.a(this.f35781a, com.alipay.security.mobile.module.a.a.a(map, "tid", ""), com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f35939g, ""), a(this.f35781a));
                a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                b();
                b(this.f35781a);
                a(this.f35781a, a2);
                i.a();
                z = false;
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
            if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.f35781a)) {
                e.a();
                if (!(!com.alipay.security.mobile.module.a.a.a(e.b(this.f35781a, map), i.c()))) {
                    String a3 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                    String a4 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f35939g, "");
                    if (com.alipay.security.mobile.module.a.a.b(a3)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a3, i.d())) {
                        }
                    }
                    if (com.alipay.security.mobile.module.a.a.b(a4)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a4, i.e())) {
                        }
                    }
                    if (i.a(this.f35781a, a2)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a(this.f35781a, a2))) {
                            if (com.alipay.security.mobile.module.a.a.a(b(this.f35781a))) {
                            }
                            z2 = false;
                            Context context2 = this.f35781a;
                            com.alipay.security.mobile.module.b.b.a();
                            h.b(context2, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                            if (z2) {
                                new com.alipay.apmobilesecuritysdk.c.b();
                                UmidSdkWrapper.startUmidTaskSync(this.f35781a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                                c b3 = b(map);
                                int a5 = b3 != null ? b3.a() : 2;
                                if (a5 != 1) {
                                    if (a5 != 3) {
                                        if (b3 != null) {
                                            str = "Server error, result:" + b3.f36194b;
                                        } else {
                                            str = "Server error, returned null";
                                        }
                                        com.alipay.apmobilesecuritysdk.c.a.a(str);
                                        if (com.alipay.security.mobile.module.a.a.a(a(this.f35781a, a2))) {
                                            i2 = 4;
                                        }
                                    } else {
                                        i2 = 1;
                                    }
                                    this.f35783c = i2;
                                    b2 = com.alipay.security.mobile.module.http.d.b(this.f35781a, this.f35782b.c());
                                    context = this.f35781a;
                                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                    activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                                        z = true;
                                    }
                                    if (z && h.c(context)) {
                                        new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                                    }
                                    return this.f35783c;
                                }
                                h.a(this.f35781a, b3.b());
                                h.d(this.f35781a, b3.c());
                                h.e(this.f35781a, b3.l);
                                h.a(this.f35781a, b3.m);
                                h.f(this.f35781a, b3.n);
                                h.g(this.f35781a, b3.p);
                                i.c(e.b(this.f35781a, map));
                                i.a(a2, b3.f36201i);
                                i.b(b3.f36200h);
                                i.d(b3.o);
                                String a6 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                                if (!com.alipay.security.mobile.module.a.a.b(a6) || com.alipay.security.mobile.module.a.a.a(a6, i.d())) {
                                    a6 = i.d();
                                } else {
                                    i.e(a6);
                                }
                                i.e(a6);
                                String a7 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f35939g, "");
                                if (!com.alipay.security.mobile.module.a.a.b(a7) || com.alipay.security.mobile.module.a.a.a(a7, i.e())) {
                                    a7 = i.e();
                                } else {
                                    i.f(a7);
                                }
                                i.f(a7);
                                i.a();
                                com.alipay.apmobilesecuritysdk.e.d.a(this.f35781a, i.g());
                                com.alipay.apmobilesecuritysdk.e.d.a();
                                com.alipay.apmobilesecuritysdk.e.a.a(this.f35781a, new b(i.b(), i.c(), i.f()));
                                com.alipay.apmobilesecuritysdk.e.a.a();
                                g.a(this.f35781a, a2, i.a(a2));
                                g.a();
                                h.a(this.f35781a, a2, System.currentTimeMillis());
                            }
                            i2 = 0;
                            this.f35783c = i2;
                            b2 = com.alipay.security.mobile.module.http.d.b(this.f35781a, this.f35782b.c());
                            context = this.f35781a;
                            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager2 != null) {
                            }
                            if (activeNetworkInfo != null) {
                                z = true;
                            }
                            if (z) {
                                new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                            }
                            return this.f35783c;
                        }
                    }
                }
                z2 = true;
                Context context22 = this.f35781a;
                com.alipay.security.mobile.module.b.b.a();
                h.b(context22, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                if (z2) {
                }
                i2 = 0;
                this.f35783c = i2;
                b2 = com.alipay.security.mobile.module.http.d.b(this.f35781a, this.f35782b.c());
                context = this.f35781a;
                ConnectivityManager connectivityManager22 = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager22 != null) {
                }
                if (activeNetworkInfo != null) {
                }
                if (z) {
                }
                return this.f35783c;
            }
            if (!com.alipay.security.mobile.module.a.a.a(a(this.f35781a, a2))) {
                if (com.alipay.security.mobile.module.a.a.a(b(this.f35781a))) {
                }
                z2 = false;
                Context context222 = this.f35781a;
                com.alipay.security.mobile.module.b.b.a();
                h.b(context222, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                if (z2) {
                }
                i2 = 0;
                this.f35783c = i2;
                b2 = com.alipay.security.mobile.module.http.d.b(this.f35781a, this.f35782b.c());
                context = this.f35781a;
                ConnectivityManager connectivityManager222 = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager222 != null) {
                }
                if (activeNetworkInfo != null) {
                }
                if (z) {
                }
                return this.f35783c;
            }
            z2 = true;
            Context context2222 = this.f35781a;
            com.alipay.security.mobile.module.b.b.a();
            h.b(context2222, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
            if (z2) {
            }
            i2 = 0;
            this.f35783c = i2;
            b2 = com.alipay.security.mobile.module.http.d.b(this.f35781a, this.f35782b.c());
            context = this.f35781a;
            ConnectivityManager connectivityManager2222 = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager2222 != null) {
            }
            if (activeNetworkInfo != null) {
            }
            if (z) {
            }
            return this.f35783c;
        }
        return invokeL.intValue;
    }
}
