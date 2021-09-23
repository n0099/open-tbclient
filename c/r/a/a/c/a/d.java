package c.r.a.a.c.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import c.r.a.a.c.b.f;
import c.r.a.a.c.b.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yxcorp.kuaishou.addfp.android.Orange;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f35566a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f35567b = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(431830402, "Lc/r/a/a/c/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(431830402, "Lc/r/a/a/c/a/d;");
        }
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (f.e(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                    String str = "";
                    if (Build.VERSION.SDK_INT < 29) {
                        try {
                            str = g.d(context).f35578b.c();
                        } catch (Throwable unused) {
                        }
                        if (TextUtils.isEmpty(str) || str.startsWith("KWE")) {
                            str = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
                        }
                        return TextUtils.isEmpty(str) ? "KWE_N" : str;
                    }
                    String[] e2 = c.r.a.a.c.b.b.e(context);
                    Arrays.sort(e2);
                    for (int i2 = 0; i2 < 2; i2++) {
                        String str2 = e2[i2];
                        if (!TextUtils.isEmpty(str2) && !str2.startsWith("KWE")) {
                            str = str2;
                        }
                    }
                    return str;
                }
                return "KWE_PN";
            } catch (Throwable unused2) {
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                return Settings.System.getString(context.getContentResolver(), str);
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean d(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2)) == null) {
            try {
                return Settings.System.putString(context.getContentResolver(), str, str2);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) != null) {
            return invokeV.longValue;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            try {
                long parseLong = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]) << 10;
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return parseLong;
            } catch (Throwable th2) {
                th = th2;
                try {
                    c.r.a.a.c.b.c.c(th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return 0L;
                        } catch (IOException unused2) {
                            return 0L;
                        }
                    }
                    return 0L;
                } catch (Throwable th3) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        String str;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            try {
                if (!f.e(context, new String[]{"android.permission.READ_PHONE_STATE"}) || Build.VERSION.SDK_INT >= 29) {
                    return "";
                }
                try {
                    str = g.d(context).f35578b.a();
                } catch (Throwable unused) {
                    str = "";
                }
                if ((TextUtils.isEmpty(str) || str.startsWith("KWE")) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    return TextUtils.isEmpty(deviceId) ? "" : deviceId;
                }
                return str;
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x003e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized java.lang.String g() {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = c.r.a.a.c.a.d.$ic
            if (r0 != 0) goto L41
        L4:
            java.lang.Class<c.r.a.a.c.a.d> r0 = c.r.a.a.c.a.d.class
            monitor-enter(r0)
            java.lang.String r1 = c.r.a.a.c.a.d.f35566a     // Catch: java.lang.Throwable -> L3a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L3a
            if (r1 != 0) goto L13
            java.lang.String r1 = c.r.a.a.c.a.d.f35566a     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r0)
            return r1
        L13:
            com.yxcorp.kuaishou.addfp.android.Orange r1 = com.yxcorp.kuaishou.addfp.android.Orange.a()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r1 = r1.f()     // Catch: java.lang.Throwable -> L3a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "nammm :"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3a
            r2.append(r1)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3a
            c.r.a.a.c.b.c.f(r2)     // Catch: java.lang.Throwable -> L3a
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L3a
            if (r2 != 0) goto L36
            c.r.a.a.c.a.d.f35566a = r1     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r0)
            return r1
        L36:
            java.lang.String r1 = "KWE_OTHER"
            monitor-exit(r0)
            return r1
        L3a:
            java.lang.String r1 = "KWE_PE"
            monitor-exit(r0)
            return r1
        L3e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L41:
            r1 = r0
            r2 = 65543(0x10007, float:9.1845E-41)
            r3 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r1.invokeV(r2, r3)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.r.a.a.c.a.d.g():java.lang.String");
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return context.getPackageName().replace("=", "").replace("&", "");
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (d.class) {
                try {
                    if (TextUtils.isEmpty(f35567b)) {
                        String f2 = Orange.a().f();
                        c.r.a.a.c.b.c.f("user dis :" + f2);
                        if (!TextUtils.isEmpty(f2)) {
                            byte[] bytes = f2.getBytes();
                            for (int i2 = 0; i2 < bytes.length; i2++) {
                                bytes[i2] = (byte) (bytes[i2] ^ 165);
                            }
                            f35567b = "fuels:" + Base64.encodeToString(bytes, 0).replace(StringUtils.LF, "").replace(StringUtils.CR, "");
                        }
                        if (TextUtils.isEmpty(f35567b)) {
                            f35567b = "KWE_N";
                            return "KWE_N";
                        }
                        return f35567b;
                    }
                    return f35567b;
                }
            }
        }
        return (String) invokeV.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                String d2 = c.r.a.a.b.b().d(context, b.f35561a.e(), false);
                return !TextUtils.isEmpty(d2) ? d2 : "KWE_N";
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0 A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #1 {all -> 0x009e, blocks: (B:37:0x00a8, B:39:0x00b0), top: B:56:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6 A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #0 {all -> 0x00cd, blocks: (B:5:0x0008, B:8:0x001a, B:10:0x0027, B:12:0x0035, B:20:0x005b, B:22:0x0061, B:24:0x0067, B:26:0x0071, B:30:0x0081, B:32:0x0087, B:33:0x009e, B:41:0x00c0, B:43:0x00c6, B:28:0x0077, B:14:0x003c, B:16:0x0049, B:18:0x0057), top: B:54:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(Context context) {
        InterceptResult invokeL;
        String str;
        LinkedHashMap d2;
        int i2;
        ListIterator listIterator;
        JSONObject jSONObject;
        Map.Entry entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                String c2 = c(context, "k_w_o_d_out_dtt");
                String str2 = "";
                if (TextUtils.isEmpty(c2)) {
                    boolean g2 = f.g(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
                    c.r.a.a.c.b.b.b();
                    if (!g2) {
                        str = "KWE_PN";
                        if (TextUtils.isEmpty(c2) || !TextUtils.isEmpty(str2)) {
                            d2 = c.b(context).d(c2);
                            if (d2 != null || d2.size() == 0) {
                                d2 = c.b(context).d(str2);
                            }
                            if (d2 != null && d2.size() > 0) {
                                i2 = 0;
                                listIterator = new ArrayList(d2.entrySet()).listIterator(d2.size());
                                jSONObject = new JSONObject();
                                while (listIterator.hasPrevious() && i2 < 10) {
                                    try {
                                        entry = (Map.Entry) listIterator.previous();
                                        if (entry != null) {
                                            jSONObject.put((String) entry.getKey(), entry.getValue());
                                        }
                                        i2++;
                                    } catch (Throwable unused) {
                                    }
                                }
                                if (jSONObject.length() > 0) {
                                    return jSONObject.toString();
                                }
                            }
                            return str;
                        }
                        return "KWE_N";
                    }
                    str2 = c.b(context).g("Lm91a2R0ZnQ=");
                    if (!TextUtils.isEmpty(str2)) {
                        d(context, "k_w_o_d_out_dtt", str2);
                    }
                } else {
                    boolean g3 = f.g(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
                    c.r.a.a.c.b.b.b();
                    if (g3) {
                        str2 = c.b(context).g("Lm91a2R0ZnQ=");
                        if (TextUtils.isEmpty(str2)) {
                            c.e(context, c2);
                        }
                    }
                }
                str = "KWE_N";
                if (TextUtils.isEmpty(c2)) {
                }
                d2 = c.b(context).d(c2);
                if (d2 != null) {
                }
                d2 = c.b(context).d(str2);
                if (d2 != null) {
                    i2 = 0;
                    listIterator = new ArrayList(d2.entrySet()).listIterator(d2.size());
                    jSONObject = new JSONObject();
                    while (listIterator.hasPrevious()) {
                        entry = (Map.Entry) listIterator.previous();
                        if (entry != null) {
                        }
                        i2++;
                    }
                    if (jSONObject.length() > 0) {
                    }
                }
                return str;
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }
}
