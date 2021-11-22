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
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f34748a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.apmobilesecuritysdk.b.a f34749b;

    /* renamed from: c  reason: collision with root package name */
    public int f34750c;

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
        this.f34749b = com.alipay.apmobilesecuritysdk.b.a.a();
        this.f34750c = 4;
        this.f34748a = context;
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
                Context context = this.f34748a;
                d dVar = new d();
                String a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                String a3 = com.alipay.security.mobile.module.a.a.a(map, "sessionId", "");
                String a4 = com.alipay.security.mobile.module.a.a.a(map, "rpcVersion", "");
                String a5 = a(context, a2);
                String securityToken = UmidSdkWrapper.getSecurityToken(context);
                String d2 = h.d(context);
                if (com.alipay.security.mobile.module.a.a.b(a3)) {
                    dVar.f35174c = a3;
                } else {
                    dVar.f35174c = a5;
                }
                dVar.f35175d = securityToken;
                dVar.f35176e = d2;
                dVar.f35172a = "android";
                com.alipay.apmobilesecuritysdk.e.c c3 = com.alipay.apmobilesecuritysdk.e.d.c(context);
                if (c3 != null) {
                    str2 = c3.f34758a;
                    str = c3.f34760c;
                } else {
                    str = "";
                    str2 = str;
                }
                if (com.alipay.security.mobile.module.a.a.a(str2) && (c2 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                    str2 = c2.f34755a;
                    str = c2.f34757c;
                }
                com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b();
                if (b3 != null) {
                    str4 = b3.f34758a;
                    str3 = b3.f34760c;
                } else {
                    str3 = "";
                }
                if (com.alipay.security.mobile.module.a.a.a(str4) && (b2 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                    str4 = b2.f34755a;
                    str3 = b2.f34757c;
                }
                dVar.f35179h = str2;
                dVar.f35178g = str4;
                dVar.j = a4;
                if (com.alipay.security.mobile.module.a.a.a(str2)) {
                    dVar.f35173b = str4;
                    str = str3;
                } else {
                    dVar.f35173b = str2;
                }
                dVar.f35180i = str;
                dVar.f35177f = e.a(context, map);
                return com.alipay.security.mobile.module.http.d.b(this.f34748a, this.f34749b.c()).a(dVar);
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
                        String str = b3.f34758a;
                        if (com.alipay.security.mobile.module.a.a.b(str)) {
                            return str;
                        }
                    }
                    b b4 = com.alipay.apmobilesecuritysdk.e.a.b(context);
                    if (b4 != null) {
                        i.a(b4);
                        String str2 = b4.f34755a;
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

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bf, code lost:
        if (com.alipay.security.mobile.module.a.a.a(b(r9.f34748a)) != false) goto L13;
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
                com.alipay.apmobilesecuritysdk.c.a.a(this.f34748a, com.alipay.security.mobile.module.a.a.a(map, "tid", ""), com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f34912g, ""), a(this.f34748a));
                a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                b();
                b(this.f34748a);
                a(this.f34748a, a2);
                i.a();
                z = false;
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
            if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.f34748a)) {
                e.a();
                if (!(!com.alipay.security.mobile.module.a.a.a(e.b(this.f34748a, map), i.c()))) {
                    String a3 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                    String a4 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f34912g, "");
                    if (com.alipay.security.mobile.module.a.a.b(a3)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a3, i.d())) {
                        }
                    }
                    if (com.alipay.security.mobile.module.a.a.b(a4)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a4, i.e())) {
                        }
                    }
                    if (i.a(this.f34748a, a2)) {
                        if (!com.alipay.security.mobile.module.a.a.a(a(this.f34748a, a2))) {
                            if (com.alipay.security.mobile.module.a.a.a(b(this.f34748a))) {
                            }
                            z2 = false;
                            Context context2 = this.f34748a;
                            com.alipay.security.mobile.module.b.b.b();
                            h.b(context2, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                            if (z2) {
                                new com.alipay.apmobilesecuritysdk.c.b();
                                UmidSdkWrapper.startUmidTaskSync(this.f34748a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                                c b3 = b(map);
                                int c2 = b3 != null ? b3.c() : 2;
                                if (c2 != 1) {
                                    if (c2 != 3) {
                                        if (b3 != null) {
                                            str = "Server error, result:" + b3.f35164b;
                                        } else {
                                            str = "Server error, returned null";
                                        }
                                        com.alipay.apmobilesecuritysdk.c.a.a(str);
                                        if (com.alipay.security.mobile.module.a.a.a(a(this.f34748a, a2))) {
                                            i2 = 4;
                                        }
                                    } else {
                                        i2 = 1;
                                    }
                                    this.f34750c = i2;
                                    b2 = com.alipay.security.mobile.module.http.d.b(this.f34748a, this.f34749b.c());
                                    context = this.f34748a;
                                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                    activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                                        z = true;
                                    }
                                    if (z && h.c(context)) {
                                        new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                                    }
                                    return this.f34750c;
                                }
                                h.a(this.f34748a, b3.b());
                                h.d(this.f34748a, b3.a());
                                h.e(this.f34748a, b3.f35169g);
                                h.a(this.f34748a, b3.f35170h);
                                h.f(this.f34748a, b3.f35171i);
                                h.g(this.f34748a, b3.k);
                                i.c(e.b(this.f34748a, map));
                                i.a(a2, b3.f35166d);
                                i.b(b3.f35165c);
                                i.d(b3.j);
                                String a5 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                                if (!com.alipay.security.mobile.module.a.a.b(a5) || com.alipay.security.mobile.module.a.a.a(a5, i.d())) {
                                    a5 = i.d();
                                } else {
                                    i.e(a5);
                                }
                                i.e(a5);
                                String a6 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f34912g, "");
                                if (!com.alipay.security.mobile.module.a.a.b(a6) || com.alipay.security.mobile.module.a.a.a(a6, i.e())) {
                                    a6 = i.e();
                                } else {
                                    i.f(a6);
                                }
                                i.f(a6);
                                i.a();
                                com.alipay.apmobilesecuritysdk.e.d.a(this.f34748a, i.g());
                                com.alipay.apmobilesecuritysdk.e.d.a();
                                com.alipay.apmobilesecuritysdk.e.a.a(this.f34748a, new b(i.b(), i.c(), i.f()));
                                com.alipay.apmobilesecuritysdk.e.a.a();
                                g.a(this.f34748a, a2, i.a(a2));
                                g.a();
                                h.a(this.f34748a, a2, System.currentTimeMillis());
                            }
                            i2 = 0;
                            this.f34750c = i2;
                            b2 = com.alipay.security.mobile.module.http.d.b(this.f34748a, this.f34749b.c());
                            context = this.f34748a;
                            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager2 != null) {
                            }
                            if (activeNetworkInfo != null) {
                                z = true;
                            }
                            if (z) {
                                new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b2).a();
                            }
                            return this.f34750c;
                        }
                    }
                }
                z2 = true;
                Context context22 = this.f34748a;
                com.alipay.security.mobile.module.b.b.b();
                h.b(context22, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                if (z2) {
                }
                i2 = 0;
                this.f34750c = i2;
                b2 = com.alipay.security.mobile.module.http.d.b(this.f34748a, this.f34749b.c());
                context = this.f34748a;
                ConnectivityManager connectivityManager22 = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager22 != null) {
                }
                if (activeNetworkInfo != null) {
                }
                if (z) {
                }
                return this.f34750c;
            }
            if (!com.alipay.security.mobile.module.a.a.a(a(this.f34748a, a2))) {
            }
            z2 = true;
            Context context222 = this.f34748a;
            com.alipay.security.mobile.module.b.b.b();
            h.b(context222, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
            if (z2) {
            }
            i2 = 0;
            this.f34750c = i2;
            b2 = com.alipay.security.mobile.module.http.d.b(this.f34748a, this.f34749b.c());
            context = this.f34748a;
            ConnectivityManager connectivityManager222 = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager222 != null) {
            }
            if (activeNetworkInfo != null) {
            }
            if (z) {
            }
            return this.f34750c;
        }
        return invokeL.intValue;
    }
}
