package com.baidu.clientupdate.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.a.d;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.clientupdate.d.j;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static StringBuilder A;
    public static a a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f33577b;

    /* renamed from: c  reason: collision with root package name */
    public static String f33578c;

    /* renamed from: d  reason: collision with root package name */
    public static String f33579d;

    /* renamed from: f  reason: collision with root package name */
    public static String f33580f;

    /* renamed from: g  reason: collision with root package name */
    public static String f33581g;
    public static String l;
    public static String m;
    public static String n;
    public static String w;
    public static String x;
    public transient /* synthetic */ FieldHolder $fh;
    public d B;

    /* renamed from: e  reason: collision with root package name */
    public String f33582e;

    /* renamed from: h  reason: collision with root package name */
    public String f33583h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33584i;

    /* renamed from: j  reason: collision with root package name */
    public String f33585j;
    public Map k;
    public String o;
    public String p;
    public String q;
    public String r;
    public ActivityManager s;
    public String t;
    public String u;
    public String v;
    public String y;
    public Boolean z;

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
        this.f33584i = false;
        this.k = new HashMap();
        this.z = Boolean.FALSE;
        Context applicationContext = context.getApplicationContext();
        f33577b = applicationContext;
        this.B = d.a(applicationContext);
        d();
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
                aVar = a;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    private String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            int i4 = displayMetrics.densityDpi;
            String str = !TextUtils.isEmpty(this.v) ? this.v : "android";
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i2);
            stringBuffer.append("_");
            stringBuffer.append(i3);
            stringBuffer.append("_");
            stringBuffer.append(str);
            stringBuffer.append("_");
            stringBuffer.append(f33578c);
            stringBuffer.append("_");
            stringBuffer.append(i4);
            String stringBuffer2 = stringBuffer.toString();
            LogUtil.logD("BaiduParamManager", "ua = " + stringBuffer2);
            return stringBuffer2;
        }
        return (String) invokeL.objValue;
    }

    private String c(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return "";
            }
            if (activeNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
                return "WF";
            }
            int subtype = activeNetworkInfo.getSubtype();
            return (subtype == 7 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 10 || subtype == 9 || subtype == 3 || subtype == 14 || subtype == 12 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "2G";
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? Pattern.compile("[0-9]*").matcher(str).matches() : invokeL.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.f33582e = f33577b.getPackageName();
            this.s = (ActivityManager) f33577b.getSystemService("activity");
            try {
                PackageInfo packageInfo = f33577b.getPackageManager().getPackageInfo(this.f33582e, 64);
                f33578c = packageInfo.versionName;
                f33579d = String.valueOf(packageInfo.versionCode);
                x = new File(packageInfo.applicationInfo.publicSourceDir).length() + "";
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            w = j.a(f33577b, this.f33582e);
            f33580f = g();
            this.f33583h = f();
            f33581g = b(f33577b);
        }
    }

    private void e() {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            File file = new File(Environment.getExternalStorageDirectory(), "clientupdate_server.cfg");
            if (!file.exists()) {
                LogUtil.logD("BaiduParamManager", "not found config file");
                return;
            }
            Properties properties = new Properties();
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                properties.load(fileInputStream);
                if (properties.getProperty("server") != null) {
                    this.u = String.valueOf(properties.getProperty("server"));
                }
                LogUtil.logD("BaiduParamManager", "设置server:" + this.u);
                fileInputStream.close();
            } catch (Exception e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    private String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            String str = Build.MODEL;
            String str2 = Build.VERSION.RELEASE;
            int i2 = Build.VERSION.SDK_INT;
            String str3 = Build.MANUFACTURER;
            String str4 = str.replace("_", "-") + "_" + str2.replace("_", "-") + "_" + i2 + "_" + str3.replace("_", "-");
            LogUtil.logD("BaiduParamManager", "get ut : " + str4);
            return str4;
        }
        return (String) invokeV.objValue;
    }

    private String g() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (TextUtils.isEmpty(f33580f)) {
                try {
                    str = CommonParam.getCUID(f33577b);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = System.currentTimeMillis() + "";
                }
                LogUtil.logD("BaiduParamManager", "new generated uid " + str);
                return str;
            }
            return f33580f;
        }
        return (String) invokeV.objValue;
    }

    private String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            String j2 = j();
            if (j2 == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(j2);
            sb.append("_");
            sb.append(i());
            return sb.reverse().toString();
        }
        return (String) invokeV.objValue;
    }

    private String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            this.s.getMemoryInfo(memoryInfo);
            LogUtil.logD("BaiduParamManager", "Avaialbe memory: " + memoryInfo.availMem);
            return Long.toHexString(memoryInfo.availMem);
        }
        return (String) invokeV.objValue;
    }

    private String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) f33577b.getSystemService("activity")).getMemoryInfo(memoryInfo);
                return Long.toHexString(memoryInfo.totalMem);
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
                String readLine = bufferedReader.readLine();
                LogUtil.logE("BaiduParamManager", "读取meminfo第一行，系统总内存大小==" + readLine);
                bufferedReader.close();
                if (readLine != null) {
                    String[] split = readLine.split("\\s+");
                    for (String str : split) {
                        LogUtil.logI("BaiduParamManager", str);
                    }
                    try {
                        if (c(split[1])) {
                            return Long.toHexString(Integer.valueOf(split[1]).intValue() * 1024);
                        }
                        return null;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.z.booleanValue()) {
                LogUtil.logE("BaiduParamManager", "读取手机根目录cfg文件");
                e();
                String str = this.u;
                if (str != null) {
                    return str;
                }
            }
            return "https://update.baidu.com";
        }
        return (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.v = str;
            f33581g = b(f33577b);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.k.put(str, str2);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.z = Boolean.valueOf(z);
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            A = sb;
            sb.append("{\"cid\":\"" + f33580f + "\",");
            StringBuilder sb2 = A;
            sb2.append("\"pl\":\"" + l + "\",");
            StringBuilder sb3 = A;
            sb3.append("\"os\":\"" + f33581g + "\",");
            StringBuilder sb4 = A;
            sb4.append("\"ot\":\"" + m + "\",");
            StringBuilder sb5 = A;
            sb5.append("\"cl\":\"" + n + "\",");
            StringBuilder sb6 = A;
            sb6.append("\"cvn\":\"" + f33578c + "\",");
            StringBuilder sb7 = A;
            sb7.append("\"cvc\":\"" + f33579d + "\",");
            StringBuilder sb8 = A;
            sb8.append("\"csz\":\"" + x + "\",");
            StringBuilder sb9 = A;
            sb9.append("\"cmd5\":\"" + w + "\",");
            ClientUpdateInfo a2 = com.baidu.clientupdate.d.a.a(f33577b).a();
            RuleInfo b2 = com.baidu.clientupdate.d.a.a(f33577b).b();
            if (a2 == null || b2 == null) {
                A.append("\"ug\":\"\",");
                A.append("\"vn\":\"\",");
                A.append("\"vc\":\"\",");
                A.append("\"sz\":\"\",");
                A.append("\"md5\":\"\",");
            } else {
                StringBuilder sb10 = A;
                sb10.append("\"ug\":\"" + b2.mUpgradeid + "\",");
                StringBuilder sb11 = A;
                sb11.append("\"vn\":\"" + a2.mVername + "\",");
                StringBuilder sb12 = A;
                sb12.append("\"vc\":\"" + a2.mVercode + "\",");
                StringBuilder sb13 = A;
                sb13.append("\"sz\":\"" + a2.mSize + "\",");
                StringBuilder sb14 = A;
                sb14.append("\"md5\":\"" + a2.mApkMd5 + "\",");
            }
            LogUtil.logE("BaiduParamManager", A.toString());
            return A.toString();
        }
        return (String) invokeV.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                b bVar = new b(a() + str);
                bVar.a("versioncode", f33579d);
                bVar.a("versionname", f33578c);
                bVar.a("pkgname", this.f33582e);
                bVar.a("cuid", f33580f);
                bVar.a("ua", f33581g);
                bVar.a("ut", this.f33583h);
                bVar.a("auto", String.valueOf(this.f33584i));
                String c2 = c(f33577b);
                this.f33585j = c2;
                bVar.a("network", c2);
                String h2 = h();
                this.t = h2;
                if (h2 != null) {
                    bVar.a("utm", h2);
                }
                bVar.a("osname", l);
                bVar.a(SocialConstants.PARAM_TYPE_ID, m);
                bVar.a("from", n);
                bVar.a("osbranch", this.o);
                bVar.a("cfrom", this.p);
                bVar.a("ignore", this.q);
                bVar.a("time", this.r);
                for (Map.Entry entry : this.k.entrySet()) {
                    bVar.b((String) entry.getKey(), (String) entry.getValue());
                }
                if (!TextUtils.isEmpty(w)) {
                    bVar.a("usermd5", w);
                }
                String a2 = j.a(f33577b, "com.baidu.appsearch");
                this.y = a2;
                if (!TextUtils.isEmpty(a2)) {
                    bVar.a("appsearchmd5", this.y);
                }
                d dVar = this.B;
                String c3 = c();
                String b2 = b();
                dVar.a(c3, "0", b2, "a2", "0", (System.currentTimeMillis() / 1000) + "", "", "SDKParamManager", "");
                return bVar.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                d dVar2 = this.B;
                String c4 = c();
                String b3 = b();
                dVar2.a(c4, "0", b3, "a2", "1", (System.currentTimeMillis() / 1000) + "", "", "SDKParamManager", e2.toString());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f33584i = z;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RuleInfo b2 = com.baidu.clientupdate.d.a.a(f33577b).b();
            return b2 != null ? b2.mUpgradeid : "-1";
        }
        return (String) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            f33578c = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            f33579d = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            l = str;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            m = str;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            n = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.o = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.p = str;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.q = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.r = str;
        }
    }
}
