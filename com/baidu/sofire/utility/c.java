package com.baidu.sofire.utility;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.rp.Report;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10514a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f10515b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f10516c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f10517d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f10518e = "3";

    /* renamed from: f  reason: collision with root package name */
    public static String f10519f = "925fc15df8a49bed0b3eca8d2b44cb7b";

    /* renamed from: g  reason: collision with root package name */
    public static MyReceiver f10520g = null;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<Integer, ApkInfo> f10521h = null;

    /* renamed from: i  reason: collision with root package name */
    public static JSONObject f10522i = null;
    public static long j = 0;
    public static int k = -1;
    public static String l = "";
    public static String m = "";
    public static int n = -1;
    public static int o = -1;
    public static int p = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1443542518, "Lcom/baidu/sofire/utility/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1443542518, "Lcom/baidu/sofire/utility/c;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            com.baidu.sofire.b.c();
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            if (TextUtils.isEmpty(l) && o != 1) {
                ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getPackageName() + ".sofire.ac.provider", 0);
                if (resolveContentProvider != null && !resolveContentProvider.multiprocess) {
                    l = resolveContentProvider.processName;
                }
                o = 1;
                return l;
            }
            return l;
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return a(new File(str));
        }
        return invokeL.booleanValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                File file = new File(str);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2.isDirectory()) {
                                d(file2.getAbsolutePath());
                            } else {
                                file2.delete();
                            }
                        }
                    }
                    file.delete();
                }
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
        }
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
        }
        return invokeL.booleanValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, str)) == null) {
            try {
                int length = str.length();
                int i2 = 0;
                while (i2 < length && (str.charAt(i2) <= ' ' || str.charAt(i2) == 160)) {
                    i2++;
                }
                return i2 > 0 ? str.substring(i2) : str;
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String[] g(Context context) {
        InterceptResult invokeL;
        String[] split;
        String[] split2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, context)) == null) {
            String str = f10515b;
            String str2 = f10516c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    String a2 = com.baidu.sofire.h.a.a(context).a();
                    if (!TextUtils.isEmpty(a2) && (split = a2.split("-")) != null && split.length == 2) {
                        return split;
                    }
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    String string = com.baidu.sofire.h.a.a(context).f10436a.getString("svi", "");
                    if (!TextUtils.isEmpty(string) && (split2 = string.split("-")) != null && split2.length == 2) {
                        return split2;
                    }
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    str = f10518e;
                    str2 = f10519f;
                }
                return new String[]{str, str2};
            }
            return new String[]{str, str2};
        }
        return (String[]) invokeL.objValue;
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65591, null, context) == null) {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = a2.f10436a.getLong("se_ae_fd", 0L);
            if (j2 == 0) {
                j2 = System.currentTimeMillis();
                a2.g();
            }
            if (currentTimeMillis - j2 > 86400000) {
                HashMap hashMap = new HashMap();
                hashMap.put("0", Integer.valueOf(a2.j() + 1));
                a2.c(0);
                a2.g();
                a(context, "1003119", (Map<String, Object>) hashMap, false);
                return;
            }
            a2.c(a2.j() + 1);
        }
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, context)) == null) {
            try {
                if (p < 0 && context != null) {
                    String packageName = context.getPackageName();
                    Field field = Class.forName(packageName + ".BuildConfig").getField("DEBUG");
                    field.setAccessible(true);
                    p = field.getBoolean(null) ? 1 : 0;
                }
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            return p == 1;
        }
        return invokeL.booleanValue;
    }

    public static void j(Context context) throws UnsupportedOperationException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65593, null, context) == null) && i(context) && !"com.baidu.input".equals(context.getPackageName())) {
            StringBuilder sb = new StringBuilder("SDK Self Check: ");
            int length = sb.length();
            try {
                System.loadLibrary("fire");
            } catch (Throwable unused) {
                sb.append("LoadLibrary Error,");
            }
            try {
                Class.forName("com.baidu.sofire.ac.F").getDeclaredMethod("getInstance", new Class[0]);
            } catch (Exception unused2) {
                sb.append("Proguard Error,");
            }
            try {
                boolean z = context.getPackageManager().resolveContentProvider(context.getPackageName() + ".sofire.ac.provider", 0).multiprocess;
            } catch (Throwable unused3) {
                sb.append("Provider Error,");
            }
            if (!a(context, false)) {
                sb.append("Service or Receiver Error.");
            }
            if (sb.length() > length) {
                throw new UnsupportedOperationException(sb.toString());
            }
        }
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    if (activeNetworkInfo.getType() == 1) {
                        return 4;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                                return 1;
                            case 3:
                                return 2;
                            case 4:
                                return 1;
                            case 5:
                            case 6:
                                return 2;
                            case 7:
                                return 1;
                            case 8:
                            case 9:
                            case 10:
                                return 2;
                            case 11:
                                return 1;
                            case 12:
                                return 2;
                            case 13:
                                return 3;
                            case 14:
                            case 15:
                                return 2;
                            default:
                                return 5;
                        }
                    }
                    return -2;
                }
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static JSONObject l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                String str = Build.BOARD;
                if (str == null) {
                    str = "";
                }
                jSONObject.put("0", str);
                String str2 = Build.DEVICE;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put("1", str2);
                String b2 = e.b();
                if (b2 == null) {
                    b2 = "";
                }
                jSONObject.put("2", b2);
                String str3 = Build.HOST;
                if (str3 == null) {
                    str3 = "";
                }
                jSONObject.put("3", str3);
                String a2 = e.a();
                if (a2 == null) {
                    a2 = "";
                }
                jSONObject.put("4", a2);
                String str4 = Build.PRODUCT;
                if (str4 == null) {
                    str4 = "";
                }
                jSONObject.put("5", str4);
                String str5 = Build.VERSION.CODENAME;
                if (str5 == null) {
                    str5 = "";
                }
                jSONObject.put("6", str5);
                String str6 = Build.VERSION.INCREMENTAL;
                if (str6 == null) {
                    str6 = "";
                }
                jSONObject.put("7", str6);
                jSONObject.put("8", e.b(context));
                String c2 = e.c();
                if (c2 == null) {
                    c2 = "";
                }
                jSONObject.put("9", c2);
                String d2 = e.d();
                if (d2 == null) {
                    d2 = "";
                }
                jSONObject.put("10", d2);
                jSONObject.put("11", e.f(context));
                String e2 = e.e();
                if (e2 == null) {
                    e2 = "";
                }
                jSONObject.put("12", e2);
                jSONObject.put("13", e.c(context));
                jSONObject.put("14", "");
                jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, s.k(context));
                jSONObject.put("18", s.l(context));
                jSONObject.put("20", Build.VERSION.SDK_INT);
                TimeZone timeZone = TimeZone.getDefault();
                if (timeZone != null) {
                    jSONObject.put("21", timeZone.getID());
                } else {
                    jSONObject.put("21", "-1");
                }
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static int m(Context context) {
        InterceptResult invokeL;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, context)) == null) {
            try {
                networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                networkInfo = null;
            }
            if (networkInfo == null) {
                return 0;
            }
            if (1 == networkInfo.getType()) {
                return 2;
            }
            if (networkInfo.getType() == 0) {
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65597, null, context) == null) {
            try {
                MyReceiver myReceiver = new MyReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.action.SOFIRE.VIEW");
                intentFilter.addCategory("com.baidu.category.SOFIRE");
                intentFilter.addCategory("android.intent.category.DEFAULT");
                context.registerReceiver(myReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0270 A[Catch: all -> 0x02bc, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0285 A[Catch: all -> 0x02bc, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0299 A[Catch: all -> 0x02bc, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02ae A[Catch: all -> 0x02bc, TRY_LEAVE, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02cd A[Catch: all -> 0x02f6, TRY_LEAVE, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0303 A[Catch: all -> 0x04e5, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0206 A[Catch: all -> 0x02bc, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x021a A[Catch: all -> 0x02bc, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022e A[Catch: all -> 0x02bc, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0243 A[Catch: all -> 0x02bc, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0257 A[Catch: all -> 0x02bc, TryCatch #14 {all -> 0x04f0, blocks: (B:5:0x001b, B:8:0x003d, B:9:0x0040, B:15:0x0078, B:18:0x009c, B:21:0x00a4, B:24:0x00ca, B:26:0x0107, B:83:0x01ed, B:22:0x00c2, B:228:0x04eb, B:113:0x02bf, B:119:0x02f9, B:122:0x0303, B:124:0x0358, B:126:0x0365, B:129:0x036f, B:131:0x0377, B:133:0x037e, B:135:0x0385, B:137:0x038e, B:139:0x0395, B:141:0x03a6, B:146:0x03c0, B:147:0x03cd, B:149:0x03d5, B:150:0x03d8, B:153:0x03e2, B:140:0x03a2, B:136:0x038a, B:132:0x037b, B:127:0x0369, B:155:0x03e8, B:156:0x03ee, B:160:0x03f8, B:163:0x0408, B:167:0x0412, B:170:0x0422, B:174:0x042c, B:178:0x043e, B:182:0x0448, B:186:0x045a, B:190:0x0464, B:193:0x046b, B:197:0x0475, B:200:0x047c, B:202:0x048d, B:203:0x0490, B:207:0x049a, B:211:0x04ac, B:214:0x04c4, B:218:0x04d0, B:220:0x04dd, B:213:0x04c1, B:209:0x04a7, B:199:0x0479, B:192:0x0468, B:184:0x0455, B:176:0x0439, B:169:0x041f, B:162:0x0405, B:114:0x02c3, B:116:0x02cd, B:11:0x006d, B:84:0x01f0, B:86:0x0206, B:87:0x0212, B:89:0x021a, B:90:0x0226, B:92:0x022e, B:93:0x023a, B:95:0x0243, B:96:0x024f, B:98:0x0257, B:99:0x0267, B:101:0x0270, B:102:0x027c, B:104:0x0285, B:105:0x0291, B:107:0x0299, B:108:0x02a6, B:110:0x02ae), top: B:255:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject o(Context context) {
        InterceptResult invokeL;
        String str;
        String str2;
        JSONObject jSONObject;
        int optInt;
        int optInt2;
        int optInt3;
        int optInt4;
        int optInt5;
        int optInt6;
        int optInt7;
        int optInt8;
        String optString;
        JSONObject optJSONObject;
        String str3;
        boolean z;
        int i2;
        com.baidu.sofire.h.a a2;
        String[] strArr;
        String[] strArr2;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, null, context)) == null) {
            try {
                String str4 = b() + "p/5/aio";
                JSONObject jSONObject2 = new JSONObject();
                JSONArray s = s(context);
                if (s != null) {
                    jSONObject2.put("0", s);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("0", Build.MODEL);
                jSONObject3.put("1", e.b(context));
                jSONObject3.put("3", String.valueOf(Build.VERSION.SDK_INT));
                jSONObject3.put("4", "3.5.8.7");
                String packageName = context.getPackageName();
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
                if (packageInfo != null) {
                    jSONObject3.put("5", f(packageInfo.applicationInfo.loadLabel(packageManager).toString()));
                    jSONObject3.put("6", packageName);
                    PublicKey a3 = a(packageInfo, packageInfo.applicationInfo.sourceDir);
                    if (a3 != null) {
                        byte[] encoded = a3.getEncoded();
                        if (encoded != null) {
                            a(context, encoded);
                            str = "5";
                            jSONObject3.put("7", o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                        } else {
                            str = "5";
                            jSONObject3.put("7", "");
                        }
                    } else {
                        str = "5";
                    }
                    jSONObject3.put("8", packageInfo.versionName);
                    jSONObject3.put("9", String.valueOf(com.baidu.sofire.h.a.a(context).f10436a.getInt("opi", 0)));
                    jSONObject3.put("14", s.i(context));
                    jSONObject3.put(Constants.VIA_REPORT_TYPE_WPA_STATE, s.j(context));
                    jSONObject2.put("1", jSONObject3);
                    String a4 = f.a(context, str4, jSONObject2.toString(), true, true);
                    if (TextUtils.isEmpty(a4)) {
                        return null;
                    }
                    JSONObject jSONObject4 = new JSONObject(a4);
                    try {
                        a2 = com.baidu.sofire.h.a.a(context);
                        if (TextUtils.isEmpty(f10515b) || TextUtils.isEmpty(f10516c)) {
                            String a5 = com.baidu.sofire.h.a.a(context).a();
                            if (TextUtils.isEmpty(a5)) {
                                strArr = new String[0];
                            } else {
                                strArr2 = a5.split("-");
                                if (strArr2 != null && strArr2.length == 2) {
                                    f10515b = strArr2[0];
                                    f10516c = strArr2[1];
                                }
                                strArr = new String[0];
                            }
                            strArr2 = strArr;
                        } else {
                            strArr2 = new String[]{f10515b, f10516c};
                        }
                    } catch (Throwable unused) {
                        str2 = "9";
                    }
                    if ((a2.f10436a.getInt("appinv_ky", 1) == 1 && (strArr2 == null || strArr2.length != 2 || TextUtils.isEmpty(strArr2[0]) || TextUtils.isEmpty(strArr2[1]))) && (optJSONObject2 = jSONObject4.optJSONObject("2")) != null) {
                        String optString2 = optJSONObject2.optString("0");
                        String optString3 = optJSONObject2.optString("1");
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                            com.baidu.sofire.core.c a6 = com.baidu.sofire.core.c.a(context);
                            try {
                            } catch (Throwable unused2) {
                                str2 = "9";
                            }
                            if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && (!f10518e.equals(optString2) || !f10519f.equals(optString3))) {
                                f10515b = optString2;
                                f10516c = optString3;
                                com.baidu.sofire.h.a aVar = a6.f10354a;
                                str2 = "9";
                                try {
                                    aVar.f10437b.putString("svi_n", optString2 + "-" + optString3);
                                    aVar.f10437b.commit();
                                } catch (Throwable unused3) {
                                    try {
                                        com.baidu.sofire.b.c();
                                    } catch (Throwable unused4) {
                                        com.baidu.sofire.b.c();
                                        jSONObject = jSONObject4.optJSONObject("3").getJSONObject("c");
                                        com.baidu.sofire.h.a a7 = com.baidu.sofire.h.a.a(context);
                                        optInt = jSONObject.optInt("n");
                                        if (optInt > 0) {
                                        }
                                        optInt2 = jSONObject.optInt("i");
                                        if (optInt2 > 0) {
                                        }
                                        optInt3 = jSONObject.optInt("i2");
                                        if (optInt3 > 0) {
                                        }
                                        optInt4 = jSONObject.optInt("w");
                                        if (optInt4 > 0) {
                                        }
                                        if (jSONObject.optInt("s1") > 0) {
                                        }
                                        optInt5 = jSONObject.optInt(Config.SESSTION_TRACK_START_TIME);
                                        if (optInt5 > 0) {
                                        }
                                        optInt6 = jSONObject.optInt("t");
                                        if (optInt6 > 0) {
                                        }
                                        optInt7 = jSONObject.optInt("l1");
                                        if (optInt7 > 0) {
                                        }
                                        optInt8 = jSONObject.optInt("l2");
                                        if (optInt8 > 0) {
                                        }
                                        com.baidu.sofire.h.a a8 = com.baidu.sofire.h.a.a(context);
                                        optString = jSONObject4.optString("0");
                                        if (!TextUtils.isEmpty(optString)) {
                                        }
                                        optJSONObject = jSONObject4.optJSONObject("4");
                                        if (optJSONObject == null) {
                                        }
                                        return jSONObject4;
                                    }
                                    jSONObject = jSONObject4.optJSONObject("3").getJSONObject("c");
                                    com.baidu.sofire.h.a a72 = com.baidu.sofire.h.a.a(context);
                                    optInt = jSONObject.optInt("n");
                                    if (optInt > 0) {
                                    }
                                    optInt2 = jSONObject.optInt("i");
                                    if (optInt2 > 0) {
                                    }
                                    optInt3 = jSONObject.optInt("i2");
                                    if (optInt3 > 0) {
                                    }
                                    optInt4 = jSONObject.optInt("w");
                                    if (optInt4 > 0) {
                                    }
                                    if (jSONObject.optInt("s1") > 0) {
                                    }
                                    optInt5 = jSONObject.optInt(Config.SESSTION_TRACK_START_TIME);
                                    if (optInt5 > 0) {
                                    }
                                    optInt6 = jSONObject.optInt("t");
                                    if (optInt6 > 0) {
                                    }
                                    optInt7 = jSONObject.optInt("l1");
                                    if (optInt7 > 0) {
                                    }
                                    optInt8 = jSONObject.optInt("l2");
                                    if (optInt8 > 0) {
                                    }
                                    com.baidu.sofire.h.a a82 = com.baidu.sofire.h.a.a(context);
                                    optString = jSONObject4.optString("0");
                                    if (!TextUtils.isEmpty(optString)) {
                                    }
                                    optJSONObject = jSONObject4.optJSONObject("4");
                                    if (optJSONObject == null) {
                                    }
                                    return jSONObject4;
                                }
                                jSONObject = jSONObject4.optJSONObject("3").getJSONObject("c");
                                com.baidu.sofire.h.a a722 = com.baidu.sofire.h.a.a(context);
                                optInt = jSONObject.optInt("n");
                                if (optInt > 0) {
                                    a722.f10441f.putInt("re_net_ty", optInt);
                                    a722.f10441f.commit();
                                }
                                optInt2 = jSONObject.optInt("i");
                                if (optInt2 > 0) {
                                    a722.f10441f.putInt("re_net_hr", optInt2);
                                    a722.f10441f.commit();
                                }
                                optInt3 = jSONObject.optInt("i2");
                                if (optInt3 > 0) {
                                    a722.f10441f.putInt("re_net_hr_bc", optInt3);
                                    a722.f10441f.commit();
                                }
                                optInt4 = jSONObject.optInt("w");
                                if (optInt4 > 0) {
                                    a722.f10441f.putInt("re_net_wt", optInt4);
                                    a722.f10441f.commit();
                                }
                                if (jSONObject.optInt("s1") > 0) {
                                    a722.f10441f.putInt("re_net_one_lt", jSONObject.optInt("s1"));
                                    a722.f10441f.commit();
                                }
                                optInt5 = jSONObject.optInt(Config.SESSTION_TRACK_START_TIME);
                                if (optInt5 > 0) {
                                    a722.f10441f.putInt("re_net_dy_lt", optInt5);
                                    a722.f10441f.commit();
                                }
                                optInt6 = jSONObject.optInt("t");
                                if (optInt6 > 0) {
                                    a722.f10441f.putInt("re_net_over", optInt6);
                                    a722.f10441f.commit();
                                }
                                optInt7 = jSONObject.optInt("l1");
                                if (optInt7 > 0) {
                                    a722.f10441f.putInt("up_nu_co", optInt7);
                                    a722.f10441f.commit();
                                }
                                optInt8 = jSONObject.optInt("l2");
                                if (optInt8 > 0) {
                                    a722.f10441f.putInt("up_nu_li", optInt8);
                                    a722.f10441f.commit();
                                }
                                com.baidu.sofire.h.a a822 = com.baidu.sofire.h.a.a(context);
                                optString = jSONObject4.optString("0");
                                if (!TextUtils.isEmpty(optString)) {
                                    a822.f10439d.putString("gli", new String(Base64.encode(g.a("30212102dicudiab".getBytes(), optString.getBytes("UTF-8"), true), 10), "UTF-8"));
                                    a822.f10439d.commit();
                                }
                                optJSONObject = jSONObject4.optJSONObject("4");
                                if (optJSONObject == null) {
                                    a822.f10437b.putInt("appinv_t", optJSONObject.optInt("app"));
                                    a822.f10437b.commit();
                                    a822.f10437b.putInt("appinv_js", optJSONObject.optInt("js"));
                                    a822.f10437b.commit();
                                    a822.f10437b.putInt("appinv_ky", optJSONObject.optInt("a", 1));
                                    a822.f10437b.commit();
                                    a822.f10437b.putInt("appplg_te", optJSONObject.optInt("pi", 360));
                                    a822.f10437b.commit();
                                    int optInt9 = optJSONObject.optInt(Config.FEED_LIST_PART, 1);
                                    if (optInt9 > 0) {
                                        str3 = "4";
                                        int round = (int) Math.round(24.0d / optInt9);
                                        if (round > 0) {
                                            a822.e(round);
                                        } else {
                                            a822.e(24);
                                        }
                                    } else {
                                        str3 = "4";
                                    }
                                    int optInt10 = optJSONObject.optInt("alm", 24);
                                    if (optInt10 > 0) {
                                        a822.d(optInt10);
                                    } else {
                                        a822.d(24);
                                    }
                                    if (optJSONObject.optInt("0", 0) > 0) {
                                        z = true;
                                        a822.c(true);
                                    } else {
                                        z = true;
                                        a822.c(false);
                                    }
                                    if (optJSONObject.optInt("1", -1) == z) {
                                        i2 = 0;
                                        a822.f10436a.getBoolean("se_fg_s", false);
                                        a822.b(z);
                                    } else {
                                        i2 = 0;
                                        a822.b(false);
                                    }
                                    a(context, "ampf", optJSONObject.optInt("mp", i2));
                                    int optInt11 = optJSONObject.optInt("tc", -1);
                                    if (optInt11 > 0 && optInt11 <= 20 && optInt11 <= 20) {
                                        a822.f10437b.putInt("s_t_p_c_s", optInt11);
                                        a822.f10437b.commit();
                                    }
                                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("pc");
                                    if (optJSONObject3 != null) {
                                        s.a(context, optJSONObject3);
                                    }
                                    JSONObject optJSONObject4 = optJSONObject.optJSONObject(Config.PRINCIPAL_PART);
                                    if (optJSONObject4 != null && context != null) {
                                        com.baidu.sofire.b.b a9 = com.baidu.sofire.b.b.a(context);
                                        if (optJSONObject4 != null) {
                                            w a10 = w.a(a9.f10322a);
                                            try {
                                                a10.f10568b.putBoolean("lt_sdcf", optJSONObject4.getInt("1") == 1);
                                                a10.f10568b.commit();
                                            } catch (JSONException unused5) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10568b.putBoolean("lt_sucf", optJSONObject4.getInt("2") == 1);
                                                a10.f10568b.commit();
                                            } catch (JSONException unused6) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10568b.putBoolean("lt_sbff", optJSONObject4.getInt("3") == 1);
                                                a10.f10568b.commit();
                                            } catch (JSONException unused7) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10568b.putBoolean("lt_sppf", optJSONObject4.getInt(str3) == 1);
                                                a10.f10568b.commit();
                                            } catch (JSONException unused8) {
                                                com.baidu.sofire.b.c();
                                            }
                                            String str5 = str;
                                            try {
                                                a10.a(optJSONObject4.getInt(str5) == 1);
                                            } catch (JSONException unused9) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.a(optJSONObject4.getInt(str5) == 1);
                                            } catch (JSONException unused10) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10568b.putLong("lt_sfii", optJSONObject4.getLong("7"));
                                                a10.f10568b.commit();
                                            } catch (JSONException unused11) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10568b.putBoolean("lt_sfff", optJSONObject4.getInt("8") == 1);
                                                a10.f10568b.commit();
                                            } catch (JSONException unused12) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10568b.putString("lt_sha", optJSONObject4.getJSONArray(str2).toString());
                                                a10.f10568b.commit();
                                            } catch (JSONException unused13) {
                                                com.baidu.sofire.b.c();
                                            }
                                            try {
                                                a10.f10568b.putBoolean("lt_sbwnp", optJSONObject4.getInt("10") == 1);
                                                a10.f10568b.commit();
                                            } catch (JSONException unused14) {
                                                com.baidu.sofire.b.c();
                                            }
                                        }
                                    }
                                }
                                return jSONObject4;
                            }
                        }
                    }
                    str2 = "9";
                    jSONObject = jSONObject4.optJSONObject("3").getJSONObject("c");
                    com.baidu.sofire.h.a a7222 = com.baidu.sofire.h.a.a(context);
                    optInt = jSONObject.optInt("n");
                    if (optInt > 0) {
                    }
                    optInt2 = jSONObject.optInt("i");
                    if (optInt2 > 0) {
                    }
                    optInt3 = jSONObject.optInt("i2");
                    if (optInt3 > 0) {
                    }
                    optInt4 = jSONObject.optInt("w");
                    if (optInt4 > 0) {
                    }
                    if (jSONObject.optInt("s1") > 0) {
                    }
                    optInt5 = jSONObject.optInt(Config.SESSTION_TRACK_START_TIME);
                    if (optInt5 > 0) {
                    }
                    optInt6 = jSONObject.optInt("t");
                    if (optInt6 > 0) {
                    }
                    optInt7 = jSONObject.optInt("l1");
                    if (optInt7 > 0) {
                    }
                    optInt8 = jSONObject.optInt("l2");
                    if (optInt8 > 0) {
                    }
                    com.baidu.sofire.h.a a8222 = com.baidu.sofire.h.a.a(context);
                    optString = jSONObject4.optString("0");
                    if (!TextUtils.isEmpty(optString)) {
                    }
                    optJSONObject = jSONObject4.optJSONObject("4");
                    if (optJSONObject == null) {
                    }
                    return jSONObject4;
                }
                f10517d = 6;
                return null;
            } catch (Throwable unused15) {
                com.baidu.sofire.b.c();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String p(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65599, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 21 || (packageManager = context.getPackageManager()) == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0)) == null) {
                    return "";
                }
                Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                return (String) declaredField.get(applicationInfo);
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, context)) == null) {
            try {
                String b2 = b(context);
                if (TextUtils.isEmpty(m)) {
                    m = b(Process.myPid());
                }
                if (TextUtils.isEmpty(m)) {
                    return 0;
                }
                return !TextUtils.isEmpty(b2) ? b2.equals(m) ? 1 : 2 : context.getPackageName().equals(m) ? 3 : 4;
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String r(Context context) {
        int length;
        int length2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, context)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(e.b(context));
                sb.append(":");
                String hexString = Long.toHexString(System.currentTimeMillis() / 1000);
                if (!TextUtils.isEmpty(hexString) && (length2 = 8 - hexString.length()) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (length2 = 8 - hexString.length(); length2 > 0; length2--) {
                        sb2.append("0");
                    }
                    hexString = sb2.toString() + hexString;
                }
                String hexString2 = Long.toHexString(Long.valueOf(g(context)[0]).longValue());
                if (!TextUtils.isEmpty(hexString2) && (length = 16 - hexString2.length()) > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    for (length = 16 - hexString2.length(); length > 0; length--) {
                        sb3.append("0");
                    }
                    hexString2 = sb3.toString() + hexString2;
                }
                sb.append(hexString);
                sb.append(hexString2);
                return sb.toString();
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized JSONArray s(Context context) {
        InterceptResult invokeL;
        ApkInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, context)) == null) {
            synchronized (c.class) {
                try {
                    com.baidu.sofire.h.a a3 = com.baidu.sofire.h.a.a(context);
                    String b2 = b(context, "sofire_local.cfg", "local");
                    if (TextUtils.isEmpty(b2)) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(b2);
                    if (f10521h == null) {
                        f10521h = new HashMap<>();
                    } else {
                        f10521h.clear();
                    }
                    ArrayList<ApkInfo> arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        String optString = optJSONObject.optString("pkgname");
                        String optString2 = optJSONObject.optString("version");
                        int optInt = optJSONObject.optInt("id");
                        if (optInt > 0) {
                            arrayList2.add(Integer.valueOf(optInt));
                        }
                        String optString3 = optJSONObject.optString(PackageTable.MD5);
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && optInt > 0) {
                            SharedPreferences sharedPreferences = a3.f10436a;
                            String string = sharedPreferences.getString("g_l_l_p_v_" + optInt, "");
                            boolean z = true;
                            boolean z2 = (TextUtils.isEmpty(string) || b(optString2, string)) ? false : true;
                            if (z2 || (a2 = com.baidu.sofire.a.a.a(context).a(optInt)) == null || d(optString2, a2.versionName) || a2.initStatus != 1) {
                                z = z2;
                            }
                            String lowerCase = optString3.toLowerCase();
                            ApkInfo apkInfo = new ApkInfo();
                            apkInfo.packageName = optString;
                            apkInfo.versionName = optString2;
                            apkInfo.key = optInt;
                            apkInfo.apkMD5 = lowerCase;
                            if (z) {
                                arrayList.add(apkInfo);
                            } else {
                                f10521h.put(Integer.valueOf(optInt), apkInfo);
                            }
                        }
                    }
                    a3.a(arrayList2);
                    if (f10521h.size() > 0 || arrayList.size() > 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (ApkInfo apkInfo2 : f10521h.values()) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pk", apkInfo2.packageName);
                            jSONObject.put("m", apkInfo2.apkMD5);
                            jSONObject.put("l", apkInfo2.key);
                            jSONObject.put("v", apkInfo2.versionName);
                            jSONArray2.put(jSONObject);
                        }
                        for (ApkInfo apkInfo3 : arrayList) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("pk", apkInfo3.packageName);
                            jSONObject2.put("m", apkInfo3.apkMD5);
                            jSONObject2.put("l", apkInfo3.key);
                            jSONObject2.put("v", apkInfo3.versionName);
                            jSONArray2.put(jSONObject2);
                        }
                        return jSONArray2;
                    }
                    return null;
                } catch (Throwable unused) {
                    com.baidu.sofire.b.c();
                    return null;
                }
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    public static String t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65603, null, context)) == null) {
            try {
                return DeviceId.getCUID(context);
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042 A[Catch: all -> 0x0076, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0076, blocks: (B:17:0x0039, B:20:0x0042, B:23:0x0067, B:22:0x004d), top: B:40:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d A[Catch: all -> 0x0072, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0076, blocks: (B:17:0x0039, B:20:0x0042, B:23:0x0067, B:22:0x004d), top: B:40:0x0039 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String u(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65604, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        String str2 = "";
        try {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            String m2 = a2.m();
            if (TextUtils.isEmpty(m2)) {
                String string = a2.f10438c.getString("xygls", "");
                if (TextUtils.isEmpty(string)) {
                    try {
                        str = j.a(context);
                    } catch (Throwable unused) {
                        str = "";
                    }
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                    } catch (Throwable unused2) {
                        try {
                            com.baidu.sofire.b.c();
                            string = str;
                            if (!TextUtils.isEmpty(string)) {
                            }
                            return string;
                        } catch (Throwable unused3) {
                            str2 = str;
                            com.baidu.sofire.b.c();
                            return str2;
                        }
                    }
                    string = str;
                }
                try {
                    if (!TextUtils.isEmpty(string)) {
                        a2.f10439d.putString("xyglsn", "");
                        a2.f10439d.commit();
                    } else {
                        a2.f10439d.putString("xyglsn", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), string.getBytes("UTF-8"), true), 10), "UTF-8"));
                        a2.f10439d.commit();
                    }
                    return string;
                } catch (Throwable unused4) {
                    str2 = string;
                    com.baidu.sofire.b.c();
                    return str2;
                }
            }
            return m2;
        } catch (Throwable unused5) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey a(PackageInfo packageInfo, String str) {
        InterceptResult invokeLL;
        PublicKey publicKey;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65546, null, packageInfo, str)) != null) {
            return (PublicKey) invokeLL.objValue;
        }
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null && signatureArr.length > 0 && signatureArr[0] != null) {
            try {
                publicKey = b.a(signatureArr[0]);
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            return publicKey != null ? b.a(str) : publicKey;
        }
        publicKey = null;
        if (publicKey != null) {
        }
    }

    public static boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65579, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                return false;
            }
            try {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("chmod " + str + " " + str2 + "\n").waitFor();
                return true;
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) {
            try {
                String str2 = new String(g.a("30212102dicudiab".getBytes(), Base64.decode(str, 10)), "UTF-8");
                return !TextUtils.isEmpty(str2) ? str2 : "";
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            try {
                if (cls.getCanonicalName().equals(Integer.TYPE.getCanonicalName())) {
                    return Integer.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Boolean.TYPE.getCanonicalName())) {
                    return Boolean.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Character.TYPE.getCanonicalName())) {
                    return Character.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Byte.TYPE.getCanonicalName())) {
                    return Byte.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Short.TYPE.getCanonicalName())) {
                    return Short.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Long.TYPE.getCanonicalName())) {
                    return Long.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Float.TYPE.getCanonicalName())) {
                    return Float.class.getCanonicalName();
                }
                if (cls.getCanonicalName().equals(Double.TYPE.getCanonicalName())) {
                    return Double.class.getCanonicalName();
                }
                return null;
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                return activeNetworkInfo.isConnected();
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, context) == null) {
            try {
                Report report = Report.getInstance(context);
                JSONObject jSONObject = new JSONObject();
                com.baidu.sofire.a.a a2 = com.baidu.sofire.a.a.a(context);
                Map<Integer, String> b2 = a2.b();
                jSONObject.put("0", b2.keySet());
                jSONObject.put("1", b2.values());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("1003003", jSONObject);
                jSONObject2.put("0", jSONObject3);
                Map<Integer, String> c2 = a2.c();
                JSONArray jSONArray = new JSONArray();
                for (String str : c2.values()) {
                    jSONArray.put(str);
                }
                jSONArray.put("com.baidu.sofire");
                jSONObject2.put("2", jSONArray);
                report.w(jSONObject2.toString());
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            try {
                return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(m)) {
                    m = b(Process.myPid());
                }
                return !str.equals(m);
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65580, null, context) == null) || TextUtils.isEmpty("3.5.8.7")) {
            return;
        }
        Report report = Report.getInstance(context);
        try {
            c(context);
            report.i("sofire", "com.baidu.sofire", "3.5.8.7", "1003003", "1003002");
        } catch (Throwable unused) {
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            try {
                return new String(F.getInstance().ad(Base64.decode(n.f10548a, 0), "30212102dicudiab".getBytes()));
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65583, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    for (int i2 = 0; i2 < split.length && i2 < split2.length; i2++) {
                        int intValue = Integer.valueOf(split[i2]).intValue() - Integer.valueOf(split2[i2]).intValue();
                        if (intValue != 0) {
                            return intValue > 0;
                        }
                    }
                    if (split.length > split2.length) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
        if (r2 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r2 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65571, null, context, str, str2)) != null) {
            return (String) invokeLLL.objValue;
        }
        String str3 = "";
        try {
            Properties properties = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                properties.load(inputStream);
                str3 = properties.getProperty(str2);
            } catch (IOException unused) {
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable unused3) {
            com.baidu.sofire.b.c();
        }
    }

    public static String g(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, str)) == null) {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable unused) {
                fileInputStream = null;
            }
            try {
                String a2 = a(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable unused2) {
                }
                return a2;
            } catch (Throwable unused3) {
                try {
                    com.baidu.sofire.b.c();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    throw th;
                }
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
        r4.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d() {
        InterceptResult invokeV;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            if (Build.VERSION.SDK_INT > 22) {
                return Process.is64Bit();
            }
            try {
                file = new File("/proc/" + Process.myPid() + "/maps");
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            if (!file.exists() || file.isDirectory()) {
                return false;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (readLine.contains("/system/lib64/libc.so")) {
                                try {
                                    bufferedReader2.close();
                                    return true;
                                } catch (IOException unused2) {
                                    com.baidu.sofire.b.c();
                                    return true;
                                }
                            }
                        } else {
                            try {
                                break;
                            } catch (IOException unused3) {
                                com.baidu.sofire.b.c();
                            }
                        }
                    } catch (Throwable unused4) {
                        bufferedReader = bufferedReader2;
                        com.baidu.sofire.b.c();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused5) {
                                com.baidu.sofire.b.c();
                            }
                        }
                        return false;
                    }
                    com.baidu.sofire.b.c();
                }
            } catch (Throwable unused6) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static Class<?> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                if (str.contains(Integer.class.getCanonicalName())) {
                    return Integer.TYPE;
                }
                if (str.contains(Boolean.class.getCanonicalName())) {
                    return Boolean.TYPE;
                }
                if (str.contains(Character.class.getCanonicalName())) {
                    return Character.TYPE;
                }
                if (str.contains(Byte.class.getCanonicalName())) {
                    return Byte.TYPE;
                }
                if (str.contains(Short.class.getCanonicalName())) {
                    return Short.TYPE;
                }
                if (str.contains(Long.class.getCanonicalName())) {
                    return Long.TYPE;
                }
                if (str.contains(Float.class.getCanonicalName())) {
                    return Float.TYPE;
                }
                if (str.contains(Double.class.getCanonicalName())) {
                    return Double.TYPE;
                }
                return null;
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return null;
            }
        }
        return (Class) invokeL.objValue;
    }

    public static boolean b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65572, null, context, i2)) == null) {
            if (i2 != 1 || e(context)) {
                return true;
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            if (f10520g == null) {
                f10520g = new MyReceiver().a();
            }
            a(context, f10520g, intentFilter);
            f10514a = true;
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v4 int), (r2v2 int), (r0v3 int)] */
    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            int i2 = calendar.get(1);
            int i3 = calendar.get(2);
            int i4 = calendar.get(5);
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(i3);
            sb.append(i4);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65575, null, str, str2)) == null) ? (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) ? false : true : invokeLL.booleanValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65569, null, i2)) == null) {
            String str2 = null;
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    str = Application.getProcessName();
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            return str.trim();
                        }
                    } catch (Throwable unused) {
                        str2 = str;
                        com.baidu.sofire.b.c();
                        return str2;
                    }
                } else {
                    str = null;
                }
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke instanceof String) {
                    str = (String) invoke;
                }
            } catch (Throwable unused2) {
            }
            if (!TextUtils.isEmpty(str)) {
                return str.trim();
            }
            str2 = g(String.format("/proc/%d/cmdline", Integer.valueOf(i2)));
            if (!TextUtils.isEmpty(str2)) {
                return str2.trim();
            }
            return str2;
        }
        return (String) invokeI.objValue;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                int i2 = 1;
                if (MyProvider.a()) {
                    return 1;
                }
                if (k == -1) {
                    int q = q(context);
                    if (q != 1 && (q == 2 || !MyProvider.a())) {
                        i2 = 0;
                    }
                    k = i2;
                }
                return k;
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static String a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, bArr, i2)) == null) {
            if (bArr != null) {
                try {
                    byte[] bytes = Long.toString(System.currentTimeMillis() / 1000).getBytes();
                    int length = bArr.length + bytes.length + 4;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    System.arraycopy(bytes, 0, bArr2, bArr.length, bytes.length);
                    int i3 = length - 4;
                    int[] iArr = new int[i3];
                    iArr[0] = i2;
                    for (int i4 = 1; i4 < i3; i4++) {
                        iArr[i4] = ((iArr[i4 - 1] * 3) + 1) % 128;
                    }
                    for (int i5 = 0; i5 < i3; i5++) {
                        bArr2[i5] = (byte) (bArr2[i5] ^ ((byte) iArr[i5]));
                    }
                    System.arraycopy(new byte[]{(byte) (i2 >>> 24), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)}, 0, bArr2, i3, 4);
                    return Base64.encodeToString(bArr2, 9).replace("\n", "");
                } catch (Throwable unused) {
                    com.baidu.sofire.b.c();
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, context, str)) == null) {
            try {
                File file = new File(context.getFilesDir(), ".tmp");
                if (!file.exists()) {
                    file.mkdir();
                }
                return !new File(file, str).exists();
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String a(Context context, int i2) {
        InterceptResult invokeLI;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2)) == null) {
            try {
                String hexString = Integer.toHexString(i2);
                if (!TextUtils.isEmpty(hexString) && (length = 4 - hexString.length()) > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (length = 4 - hexString.length(); length > 0; length--) {
                        sb.append("0");
                    }
                    hexString = sb.toString() + hexString;
                }
                byte[] a2 = g.a("30212102dicudiab".getBytes(), (r(context) + hexString).toString().getBytes(), false);
                com.baidu.sofire.h.a a3 = com.baidu.sofire.h.a.a(context);
                int i3 = a3.f10436a.getInt("tk_sa_pu_cl", 0) + 1;
                a3.f10437b.putInt("tk_sa_pu_cl", i3);
                a3.f10437b.commit();
                String a4 = a(a2, i3);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a4);
                sb2.insert(sb2.length() - 2, "A");
                return sb2.toString().replace("\n", "");
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return "";
            }
        }
        return (String) invokeLI.objValue;
    }

    public static synchronized boolean a(Context context, boolean z) {
        InterceptResult invokeLZ;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65565, null, context, z)) == null) {
            synchronized (c.class) {
                try {
                    if (n != -1) {
                        return n == 1;
                    }
                    String b2 = b(context);
                    if (TextUtils.isEmpty(b2)) {
                        a2 = a(context, context.getPackageName(), true, z);
                    } else {
                        a2 = a(context, b2, false, z);
                    }
                    if (a2) {
                        n = 1;
                    } else {
                        n = 0;
                    }
                    return a2;
                } catch (Throwable unused) {
                    com.baidu.sofire.b.c();
                    return false;
                }
            }
        }
        return invokeLZ.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x008f, blocks: (B:13:0x0039, B:16:0x0047, B:18:0x004f, B:20:0x005b, B:24:0x0067, B:28:0x0071, B:32:0x0084, B:33:0x0089, B:30:0x007b), top: B:46:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x008f, blocks: (B:13:0x0039, B:16:0x0047, B:18:0x004f, B:20:0x005b, B:24:0x0067, B:28:0x0071, B:32:0x0084, B:33:0x0089, B:30:0x007b), top: B:46:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        ResolveInfo resolveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean z3 = false;
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), MyService.class.getCanonicalName()));
                resolveInfo = context.getPackageManager().resolveService(intent, 0);
                if (resolveInfo != null) {
                    try {
                        if (str.equals(resolveInfo.serviceInfo.processName)) {
                            z3 = true;
                        }
                    } catch (Throwable unused) {
                        com.baidu.sofire.b.c();
                        if (resolveInfo == null) {
                        }
                        if (TextUtils.isEmpty(m)) {
                        }
                        if (z2) {
                            HashMap hashMap = new HashMap();
                            if (z3) {
                            }
                            if (z) {
                            }
                            a(context, "1003140", (Map<String, Object>) hashMap, true);
                        }
                        return z3;
                    }
                }
            } catch (Throwable unused2) {
                resolveInfo = null;
            }
            if (resolveInfo == null) {
                try {
                    if (str.equals(a(context, str, "service"))) {
                        z3 = true;
                    }
                } catch (Throwable unused3) {
                    com.baidu.sofire.b.c();
                }
            }
            if (TextUtils.isEmpty(m)) {
                m = b(Process.myPid());
            }
            if (z2 && m.equals(str) && (!z3 || z)) {
                HashMap hashMap2 = new HashMap();
                if (z3) {
                    hashMap2.put("0", Integer.toString(2));
                } else if (!z3) {
                    hashMap2.put("0", Integer.toString(1));
                }
                if (z) {
                    hashMap2.put("1", "0");
                }
                a(context, "1003140", (Map<String, Object>) hashMap2, true);
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65560, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a(new File(str), new File(str2));
    }

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        int next;
        String attributeValue;
        String str3;
        String canonicalName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2)) == null) {
            try {
                XmlResourceParser openXmlResourceParser = context.createPackageContext(context.getPackageName(), 3).getAssets().openXmlResourceParser("AndroidManifest.xml");
                if (openXmlResourceParser != null) {
                    do {
                        next = openXmlResourceParser.next();
                        if (next == 2) {
                            break;
                        }
                    } while (next != 1);
                    if (next == 2 && openXmlResourceParser.getName().equals("manifest") && (attributeValue = openXmlResourceParser.getAttributeValue(null, AsInstallService.SCHEME_PACKAGE_ADDED)) != null && attributeValue.length() != 0) {
                        int length = attributeValue.length();
                        int i2 = 0;
                        boolean z = false;
                        boolean z2 = true;
                        while (true) {
                            if (i2 < length) {
                                char charAt = attributeValue.charAt(i2);
                                if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                                    z2 = false;
                                } else if (z2 || ((charAt < '0' || charAt > '9') && charAt != '_')) {
                                    if (charAt != '.') {
                                        str3 = "bad character '" + charAt + "'";
                                        break;
                                    }
                                    z = true;
                                    z2 = true;
                                }
                                i2++;
                            } else {
                                str3 = z ? null : "must have at least one '.' separator";
                            }
                        }
                        if (str3 != null && !"android".equals(attributeValue)) {
                            return null;
                        }
                        if (str2.equals("provider")) {
                            canonicalName = MyProvider.class.getCanonicalName();
                        } else if (str2.equals("service")) {
                            canonicalName = MyService.class.getCanonicalName();
                        } else {
                            canonicalName = str2.equals(SocialConstants.PARAM_RECEIVER) ? MyReceiver.class.getCanonicalName() : null;
                        }
                        while (true) {
                            int next2 = openXmlResourceParser.next();
                            if (next2 == 1) {
                                break;
                            } else if (next2 == 2) {
                                String name = openXmlResourceParser.getName();
                                if ("provider".equals(name)) {
                                    if (openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name").equals(canonicalName)) {
                                        String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "multiprocess");
                                        if (TextUtils.isEmpty(attributeValue2) || !"true".equals(attributeValue2.toLowerCase())) {
                                            String attributeValue3 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "authorities");
                                            if (TextUtils.isEmpty(attributeValue3) || !str.equals(attributeValue3)) {
                                                return null;
                                            }
                                            String attributeValue4 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                            if (!TextUtils.isEmpty(attributeValue4)) {
                                                if (attributeValue4.startsWith(":")) {
                                                    return context.getPackageName() + attributeValue4;
                                                }
                                                return attributeValue4;
                                            }
                                            return context.getPackageName();
                                        }
                                        return null;
                                    }
                                } else if ("service".equals(name)) {
                                    String attributeValue5 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                    if (!TextUtils.isEmpty(attributeValue5) && attributeValue5.equals(canonicalName)) {
                                        String attributeValue6 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                        if (!TextUtils.isEmpty(attributeValue6)) {
                                            if (attributeValue6.startsWith(":")) {
                                                return context.getPackageName() + attributeValue6;
                                            }
                                            return attributeValue6;
                                        }
                                        return context.getPackageName();
                                    }
                                } else if (SocialConstants.PARAM_RECEIVER.equals(name)) {
                                    String attributeValue7 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                    if (!TextUtils.isEmpty(attributeValue7) && attributeValue7.equals(canonicalName)) {
                                        String attributeValue8 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                        if (!TextUtils.isEmpty(attributeValue8)) {
                                            if (attributeValue8.startsWith(":")) {
                                                return context.getPackageName() + attributeValue8;
                                            }
                                            return attributeValue8;
                                        }
                                        return context.getPackageName();
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                    return null;
                }
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    public static void a(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65559, null, file, file2) == null) || file == null || file2 == null || !a(file)) {
            return;
        }
        if (file2.exists()) {
            file2.delete();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable unused) {
                fileOutputStream = null;
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileInputStream.close();
            } catch (Throwable unused3) {
            }
            try {
                fileOutputStream.close();
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileInputStream2 = fileInputStream;
            try {
                com.baidu.sofire.b.c();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused6) {
                    }
                }
            } finally {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable unused7) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused8) {
                    }
                }
            }
        }
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, file)) == null) ? file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0 : invokeL.booleanValue;
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, obj, str, clsArr, objArr)) == null) {
            if (obj != null && !TextUtils.isEmpty(str)) {
                if (clsArr != null && objArr != null && clsArr.length != objArr.length) {
                    throw new NoSuchMethodException("paramTypes or args fail");
                }
                Method[] declaredMethods = obj.getClass().getDeclaredMethods();
                Method method = null;
                int length = declaredMethods.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Method method2 = declaredMethods[i2];
                    if (a(method2, str, clsArr)) {
                        method = method2;
                        break;
                    }
                    i2++;
                }
                if (method != null) {
                    return method.invoke(obj, objArr);
                }
                throw new NoSuchMethodException("cannot find method in target methodName=" + str);
            }
            throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
        }
        return invokeLLLL.objValue;
    }

    public static boolean a(Method method, String str, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, method, str, clsArr)) == null) {
            if (str.equals(method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if ((parameterTypes == null || parameterTypes.length == 0) && (clsArr == null || clsArr.length == 0)) {
                    return true;
                }
                if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                    return false;
                }
                if (((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) || parameterTypes == null || clsArr == null || parameterTypes.length != clsArr.length) {
                    return false;
                }
                for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                    if (parameterTypes[i2] != clsArr[i2]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65561, null, str, z) == null) {
            c("771", str);
            if (z) {
                c("771", new File(str).getParentFile().getAbsolutePath());
            }
        }
    }

    public static void a(Context context, String str, Map<String, Object> map, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, str, map, Boolean.valueOf(z)}) == null) && !TextUtils.isEmpty(str) && com.baidu.sofire.core.c.f10350c) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", System.currentTimeMillis());
                jSONObject2.put("1", "");
                jSONObject2.put("2", "");
                String[] g2 = g(context);
                if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                    str2 = g2[0];
                } else {
                    str2 = f10518e;
                }
                jSONObject2.put("3", str2);
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put("6", 1);
                jSONObject2.put("7", 0);
                jSONObject2.put("8", "sofire");
                jSONObject2.put("9", "3.5.8.7");
                jSONObject2.put("10", str);
                jSONObject.put("Common_section", jSONObject2);
                if (map.size() > 0) {
                    jSONObject.put("Module_section", new JSONObject(map));
                } else {
                    jSONObject.put("Module_section", new JSONObject());
                }
                Report.getInstance(context).s(jSONObject.toString(), z);
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
        }
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65555, null, context, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "");
            jSONObject2.put("2", "");
            String[] g2 = g(context);
            if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1])) {
                str2 = g2[0];
            } else {
                str2 = f10518e;
            }
            jSONObject2.put("3", str2);
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "sofire");
            jSONObject2.put("9", "3.5.8.7");
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            if (map.size() > 0) {
                jSONObject.put("Module_section", new JSONObject(map));
            } else {
                jSONObject.put("Module_section", new JSONObject());
            }
            Report.getInstance(context).sr(jSONObject.toString());
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
    }

    public static void a(Context context, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, context, bArr) == null) {
            try {
                String[] g2 = g(context);
                if (g2 == null || g2.length != 2) {
                    return;
                }
                if (TextUtils.isEmpty(g2[0]) || TextUtils.isEmpty(g2[1]) || !"200080".equals(g2[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                    return;
                }
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = (byte) (bArr[i2] ^ 246);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static JSONObject a(Context context, com.baidu.sofire.c.a aVar, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, aVar, str, Boolean.valueOf(z)})) == null) {
            return a(context, aVar.f10328a, aVar.f10330c, z ? aVar.f10331d : aVar.f10332e, str);
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static String a(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append('\n');
                }
                sb.append(readLine);
            } else {
                return sb.toString();
            }
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        JSONObject jSONObject2;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, jSONObject)) == null) {
            JSONObject jSONObject3 = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject2 = jSONObject.getJSONObject("Common_section");
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                jSONObject2 = null;
            }
            String str6 = "";
            if (jSONObject2 != null) {
                str = jSONObject2.optString("10");
                j2 = jSONObject2.optLong("0");
                str2 = jSONObject2.optString("1");
                str4 = jSONObject2.optString("3");
                str5 = jSONObject2.optString("8");
                str3 = jSONObject2.optString("9");
            } else {
                j2 = currentTimeMillis;
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            }
            try {
                jSONObject3.put("1", context.getApplicationInfo().loadLabel(context.getPackageManager()).toString());
                jSONObject3.put("2", context.getPackageName());
                jSONObject3.put("3", z.a(context));
                jSONObject3.put("4", e.b(context));
                jSONObject3.put("5", str);
                jSONObject3.put("6", j2);
                jSONObject3.put("7", str2);
                jSONObject3.put("8", str4);
                jSONObject3.put("9", str5);
                jSONObject3.put("10", str3);
                com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                jSONObject3.put("11", a2.f10440e.getString("re_a_cv", ""));
                jSONObject3.put("12", a2.f10440e.getString("re_a_lc", ""));
                jSONObject3.put("13", 1);
                if (k(context) == 4) {
                    jSONObject3.put("14", 1);
                } else {
                    jSONObject3.put("14", 2);
                }
                jSONObject3.put("20", s.g(context));
                jSONObject3.put("21", s.f(context));
                jSONObject3.put(Constants.VIA_REPORT_TYPE_DATALINE, e.c(context));
                jSONObject3.put(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS, u(context));
                jSONObject3.put("25", com.baidu.sofire.rp.a.a(context));
                jSONObject3.put("26", com.baidu.sofire.rp.a.b(context));
                jSONObject3.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, p.a(context));
                jSONObject3.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, t(context));
                String j3 = s.j(context);
                if (!TextUtils.isEmpty(j3)) {
                    str6 = j3;
                }
                jSONObject3.put(EventType.GiftEventID.LOAD_ALL_GIFT_SUCCESS, str6);
                Object obj = jSONObject.get("Module_section");
                if (obj instanceof JSONArray) {
                    jSONObject3.put("module_section", obj);
                } else {
                    jSONObject3.put("module_section", new JSONArray().put(obj));
                }
            } catch (Throwable unused2) {
                com.baidu.sofire.b.c();
            }
            return jSONObject3;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        int indexOf;
        com.baidu.sofire.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, str, str2, str3, str4, str5}) == null) {
            d.a(context).a();
            d a2 = d.a(context);
            Message message = new Message();
            message.what = 8;
            a2.f10525b.a(message);
            com.baidu.sofire.c.a aVar2 = new com.baidu.sofire.c.a();
            aVar2.f10328a = str;
            aVar2.f10329b = str2;
            aVar2.f10330c = str3;
            aVar2.f10331d = str4;
            aVar2.f10332e = str5;
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                return;
            }
            com.baidu.sofire.h.a a3 = com.baidu.sofire.h.a.a(context);
            List<com.baidu.sofire.c.a> t = a3.t();
            if (t == null) {
                a3.a(aVar2);
            } else if (!t.contains(aVar2)) {
                a3.a(aVar2);
            } else {
                if (t != null && (indexOf = t.indexOf(aVar2)) != -1 && (aVar = t.get(indexOf)) != null) {
                    a3.f10441f.putString("re_con", a3.f10440e.getString("re_con", "").replace(com.baidu.sofire.c.a.a(aVar), com.baidu.sofire.c.a.a(aVar2)));
                    a3.f10441f.commit();
                }
                d.a(context).b();
                return;
            }
            String str6 = aVar2.f10332e;
            SharedPreferences sharedPreferences = a3.f10440e;
            if (!sharedPreferences.getBoolean("re_net_ins_" + str6, false)) {
                d a4 = d.a(context);
                com.baidu.sofire.g.a aVar3 = a4.f10525b;
                String e2 = aVar3.f10428a.e(aVar2.f10332e);
                com.baidu.sofire.e.a aVar4 = new com.baidu.sofire.e.a();
                aVar4.f10415b = aVar2.f10332e;
                aVar4.f10420g = 0;
                aVar4.f10416c = 1;
                aVar4.f10418e = System.currentTimeMillis();
                aVar4.f10419f = 1;
                aVar4.f10417d = a(aVar3.f10429b, aVar2, e2, false).toString();
                com.baidu.sofire.d.a.a(aVar3.f10429b).a(aVar4);
                com.baidu.sofire.h.a aVar5 = aVar3.f10428a;
                String str7 = aVar2.f10332e;
                SharedPreferences.Editor editor = aVar5.f10441f;
                editor.putBoolean("re_net_ins_" + str7, true);
                aVar5.f10441f.commit();
                a4.f10525b.a(aVar2);
            }
            d.a(context).b();
            d.a(context).c();
        }
    }

    public static void a(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65557, null, context, str, z) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                System.currentTimeMillis();
                a2.f10440e.getInt("re_net_ty", 2);
                JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
                long optLong = optJSONObject.optLong("0");
                String optString = optJSONObject.optString("10");
                int optInt = optJSONObject.optInt("5");
                int optInt2 = optJSONObject.optInt("6");
                int optInt3 = optJSONObject.optInt("7");
                int optInt4 = optJSONObject.optInt("11");
                if (optInt2 == 0) {
                    optInt2 = 1;
                }
                com.baidu.sofire.e.a aVar = new com.baidu.sofire.e.a();
                aVar.f10417d = str;
                aVar.f10415b = optString;
                aVar.f10420g = optInt;
                aVar.f10416c = 3;
                aVar.f10418e = optLong;
                aVar.f10419f = optInt2;
                aVar.f10421h = optInt3;
                aVar.f10422i = optInt4;
                aVar.j = "";
                d a3 = d.a(context);
                Message message = new Message();
                if (!z && !e()) {
                    com.baidu.sofire.d.a.a(a3.f10524a).a(aVar);
                    message.what = 10;
                    a3.f10525b.a(message);
                }
                message.what = 1;
                message.obj = aVar;
                a3.f10525b.a(message);
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) {
            String str2 = "";
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("0");
                    if (optJSONObject != null) {
                        String str3 = "";
                        while (optJSONObject.keys().hasNext()) {
                            str3 = String.valueOf(optJSONObject.keys().next());
                            if (!TextUtils.isEmpty(str3)) {
                                break;
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            String optString = optJSONObject.optString(str3);
                            SharedPreferences.Editor editor = a2.f10441f;
                            editor.putString("al_da" + str3, optString);
                            a2.f10441f.commit();
                        }
                    }
                } catch (Throwable unused) {
                    com.baidu.sofire.b.c();
                }
                try {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("1");
                    if (optJSONObject2 != null) {
                        while (optJSONObject2.keys().hasNext()) {
                            str2 = String.valueOf(optJSONObject2.keys().next());
                            if (!TextUtils.isEmpty(str2)) {
                                break;
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            String optString2 = optJSONObject2.optString(str2);
                            SharedPreferences.Editor editor2 = a2.f10441f;
                            editor2.putString("in_da" + str2, optString2);
                            a2.f10441f.commit();
                        }
                    }
                } catch (Throwable unused2) {
                    com.baidu.sofire.b.c();
                }
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("2");
                    if (optJSONArray != null) {
                        a2.f10441f.putString("li_pk_s", optJSONArray.toString());
                        a2.f10441f.commit();
                    }
                } catch (Throwable unused3) {
                    com.baidu.sofire.b.c();
                }
            } catch (Throwable unused4) {
                com.baidu.sofire.b.c();
            }
        }
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65548, null, context, str, str2, str3, str4)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", System.currentTimeMillis());
                jSONObject2.put("1", "0");
                jSONObject2.put("2", "0");
                String[] g2 = g(context);
                if (g2 != null && g2.length == 2) {
                    jSONObject2.put("3", g2[0]);
                } else {
                    jSONObject2.put("3", f10518e);
                }
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put("6", 1);
                jSONObject2.put("7", 0);
                jSONObject2.put("8", str);
                jSONObject2.put("9", str2);
                jSONObject2.put("10", str3);
                JSONObject jSONObject3 = new JSONObject();
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject3 = new JSONObject(str4);
                }
                jSONObject.put("Common_section", jSONObject2);
                jSONObject.put("Module_section", jSONObject3);
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLLL.objValue;
    }

    public static void a(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65551, null, context, j2) == null) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.b.r.p");
            intent.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, intent, 134217728);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
            }
            try {
                alarmManager.set(1, System.currentTimeMillis() + j2, broadcast);
            } catch (Throwable unused2) {
                com.baidu.sofire.b.c();
            }
        }
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            String str = "";
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str = str + hexString.toUpperCase();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, context, broadcastReceiver, intentFilter)) == null) {
            try {
                context.registerReceiver(broadcastReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
                return true;
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void a(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65553, null, context, str, i2) == null) || i2 < 0) {
            return;
        }
        try {
            File file = new File(context.getFilesDir(), ".tmp");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, str);
            if (i2 > 0) {
                if (file2.exists()) {
                    file2.delete();
                }
            } else if (i2 != 0 || file2.exists()) {
            } else {
                file2.createNewFile();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.b.c();
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        ApkInfo a2;
        com.baidu.sofire.core.f a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i2)) == null) {
            try {
                com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f10282d;
                if (aVar == null || (a2 = aVar.a(i2)) == null || a2.initStatus != 1 || (a3 = com.baidu.sofire.core.f.a()) == null) {
                    return false;
                }
                return a3.d(a2.packageName) != null;
            } catch (Throwable unused) {
                com.baidu.sofire.b.c();
                return false;
            }
        }
        return invokeI.booleanValue;
    }
}
