package com.baidu.sofire.k;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
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
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.mobstat.Config;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.rp.Report;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static String b = null;
    public static String c = null;
    public static int d = 0;
    public static int e = -1;
    public static JSONArray f = null;
    public static MyReceiver g = null;
    public static String h = "";
    public static String i = "";
    public static String j = "";
    public static String k = "";
    public static int l = -1;
    public static int m = -1;
    public static int n = -1;
    public static HashMap<Integer, ApkInfo> o;
    public transient /* synthetic */ FieldHolder $fh;

    public static Class<?> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
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
                int i2 = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (Class) invokeL.objValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
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
                int i2 = com.baidu.sofire.a.b.a;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x007d A[LOOP:0: B:15:0x002a->B:58:0x007d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x007b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, obj, str, clsArr, objArr)) == null) {
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
                    if (str.equals(method2.getName())) {
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        if ((parameterTypes != null && parameterTypes.length != 0) || (clsArr != null && clsArr.length != 0)) {
                            if (((clsArr != null && clsArr.length != 0) || parameterTypes == null || parameterTypes.length <= 0) && (((parameterTypes != null && parameterTypes.length != 0) || clsArr == null || clsArr.length <= 0) && parameterTypes != null && clsArr != null && parameterTypes.length == clsArr.length)) {
                                for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                                    if (parameterTypes[i3] == clsArr[i3]) {
                                    }
                                }
                            }
                        }
                        z = true;
                        if (!z) {
                            method = method2;
                            break;
                        }
                        i2++;
                    }
                    z = false;
                    if (!z) {
                    }
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", l);
                jSONObject.put("2", h);
                jSONObject.put("3", i);
                jSONObject.put("4", j);
                jSONObject.put("5", k);
                return jSONObject.toString();
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
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
                        int i3 = com.baidu.sofire.a.b.a;
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
                byte[] b2 = f.b(d.a, (e(context) + hexString).toString().getBytes(), false);
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                int i3 = a2.a.getInt("tk_sa_pu_cl", 0) + 1;
                a2.b.putInt("tk_sa_pu_cl", i3);
                a2.b.commit();
                String a3 = a(b2, i3);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a3);
                sb2.insert(sb2.length() - 2, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
                return sb2.toString().replace("\n", "");
            } catch (Throwable unused) {
                int i4 = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        int next;
        String attributeValue;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, str, str2)) == null) {
            try {
                XmlResourceParser openXmlResourceParser = context.createPackageContext(context.getPackageName(), 3).getAssets().openXmlResourceParser("AndroidManifest.xml");
                if (openXmlResourceParser != null) {
                    while (true) {
                        next = openXmlResourceParser.next();
                        if (next == 2 || next == 1) {
                            break;
                        }
                    }
                    if (next == 2 && openXmlResourceParser.getName().equals("manifest") && (attributeValue = openXmlResourceParser.getAttributeValue(null, "package")) != null && attributeValue.length() != 0) {
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
                                    if (charAt == '.') {
                                        z = true;
                                        z2 = true;
                                    } else {
                                        str3 = "bad character '" + charAt + "'";
                                        break;
                                    }
                                }
                                i2++;
                            } else if (!z) {
                                str3 = "must have at least one '.' separator";
                            } else {
                                str3 = null;
                            }
                        }
                        if (str3 != null && !"android".equals(attributeValue)) {
                            return null;
                        }
                        if (str2.equals("provider")) {
                            str4 = MyProvider.class.getCanonicalName();
                        } else if (str2.equals("service")) {
                            str4 = MyService.class.getCanonicalName();
                        } else if (str2.equals(SocialConstants.PARAM_RECEIVER)) {
                            str4 = MyReceiver.class.getCanonicalName();
                        } else {
                            str4 = null;
                        }
                        while (true) {
                            int next2 = openXmlResourceParser.next();
                            if (next2 == 1) {
                                break;
                            } else if (next2 == 2) {
                                String name = openXmlResourceParser.getName();
                                if ("provider".equals(name)) {
                                    if (openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name").equals(str4)) {
                                        String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "multiprocess");
                                        if (!TextUtils.isEmpty(attributeValue2) && "true".equals(attributeValue2.toLowerCase())) {
                                            return null;
                                        }
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
                                } else if ("service".equals(name)) {
                                    String attributeValue5 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                    if (!TextUtils.isEmpty(attributeValue5) && attributeValue5.equals(str4)) {
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
                                    if (!TextUtils.isEmpty(attributeValue7) && attributeValue7.equals(str4)) {
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
                int i3 = com.baidu.sofire.a.b.a;
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) {
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
                int i2 = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            String str = "";
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = TransactionIdCreater.FILL_BYTE + hexString;
                }
                str = str + hexString.toUpperCase();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            try {
                String g2 = g(context);
                if (TextUtils.isEmpty(i)) {
                    i = a(Process.myPid());
                }
                if (TextUtils.isEmpty(i)) {
                    return 0;
                }
                if (!TextUtils.isEmpty(g2)) {
                    if (g2.equals(i)) {
                        return 1;
                    }
                    return 2;
                } else if (context.getPackageName().equals(i)) {
                    return 3;
                } else {
                    return 4;
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String[] c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            if (TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) {
                String string = com.baidu.sofire.j.a.a(context).a.getString("svi_n", "");
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split("-");
                    if (split != null && split.length == 2) {
                        b = split[0];
                        c = split[1];
                        return split;
                    }
                    return new String[0];
                }
                return new String[0];
            }
            return new String[]{b, c};
        }
        return (String[]) invokeL.objValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                File file = new File(str);
                if (!file.exists()) {
                    return;
                }
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
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) {
            try {
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            if (TextUtils.isEmpty(h) && m != 1) {
                ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getPackageName() + ".sofire.ac.provider", 0);
                if (resolveContentProvider != null && !resolveContentProvider.multiprocess) {
                    h = resolveContentProvider.processName;
                }
                m = 1;
                return h;
            }
            return h;
        }
        return (String) invokeL.objValue;
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) {
            try {
                if (n < 0 && context != null) {
                    String packageName = context.getPackageName();
                    Field field = Class.forName(packageName + ".BuildConfig").getField("DEBUG");
                    field.setAccessible(true);
                    n = field.getBoolean(null) ? 1 : 0;
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            if (n != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65587, null, context) == null) {
            try {
                MyReceiver myReceiver = new MyReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.action.SOFIRE.VIEW");
                intentFilter.addCategory("com.baidu.category.SOFIRE");
                intentFilter.addCategory("android.intent.category.DEFAULT");
                context.registerReceiver(myReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }

    public static String a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bArr, i2)) == null) {
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
                int i6 = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeLI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey a(PackageInfo packageInfo, String str) {
        InterceptResult invokeLL;
        PublicKey publicKey;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, packageInfo, str)) == null) {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null && signatureArr.length > 0 && signatureArr[0] != null) {
                try {
                    Signature signature = signatureArr[0];
                    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
                    Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
                    byteArrayInputStream.close();
                    publicKey = generateCertificate.getPublicKey();
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
                if (publicKey != null) {
                    try {
                        if (TextUtils.isEmpty(str)) {
                            return null;
                        }
                        byte[] bArr = new byte[8192];
                        JarFile jarFile = new JarFile(str);
                        Enumeration<JarEntry> entries = jarFile.entries();
                        Certificate[] certificateArr = null;
                        while (entries.hasMoreElements()) {
                            JarEntry nextElement = entries.nextElement();
                            if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                                Certificate[] a2 = com.baidu.sofire.a.a.a(jarFile, nextElement, bArr);
                                if (a2 != null && a2.length > 0) {
                                    if (certificateArr == null) {
                                        certificateArr = a2;
                                    } else {
                                        for (int i3 = 0; i3 < certificateArr.length; i3++) {
                                            int i4 = 0;
                                            while (true) {
                                                if (i4 < a2.length) {
                                                    if (certificateArr[i3] != null && certificateArr[i3].equals(a2[i4])) {
                                                        z = true;
                                                        break;
                                                    }
                                                    i4++;
                                                } else {
                                                    z = false;
                                                    break;
                                                }
                                            }
                                            if (z && certificateArr.length == a2.length) {
                                            }
                                            jarFile.close();
                                            return null;
                                        }
                                        continue;
                                    }
                                }
                                jarFile.close();
                                return null;
                            }
                        }
                        jarFile.close();
                        if (certificateArr == null || certificateArr.length <= 0) {
                            return null;
                        }
                        return certificateArr[0].getPublicKey();
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
                return publicKey;
            }
            publicKey = null;
            if (publicKey != null) {
            }
        } else {
            return (PublicKey) invokeLL.objValue;
        }
    }

    public static JSONObject b(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        JSONObject jSONObject2;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, jSONObject)) == null) {
            JSONObject jSONObject3 = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject2 = jSONObject.getJSONObject("Common_section");
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
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
                jSONObject3.put("3", v.a(context));
                jSONObject3.put("4", d.a(context));
                jSONObject3.put("5", str);
                jSONObject3.put("6", j2);
                jSONObject3.put("7", str2);
                jSONObject3.put("8", str4);
                jSONObject3.put("9", str5);
                jSONObject3.put("10", str3);
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                jSONObject3.put("11", a2.e.getString("re_a_cv", ""));
                jSONObject3.put("12", a2.e.getString("re_a_lc", ""));
                jSONObject3.put("13", 1);
                if (d(context) == 4) {
                    jSONObject3.put("14", 1);
                } else {
                    jSONObject3.put("14", 2);
                }
                jSONObject3.put("28", l.a(context));
                if (e.b(context)) {
                    try {
                        str6 = DeviceId.getCUID(context);
                    } catch (Throwable unused2) {
                        int i3 = com.baidu.sofire.a.b.a;
                    }
                    jSONObject3.put("23", str6);
                } else {
                    jSONObject3.put("23", "");
                }
                Object obj = jSONObject.get("Module_section");
                if (obj instanceof JSONArray) {
                    jSONObject3.put("module_section", obj);
                } else {
                    jSONObject3.put("module_section", new JSONArray().put(obj));
                }
            } catch (Throwable unused3) {
                int i4 = com.baidu.sofire.a.b.a;
            }
            return jSONObject3;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x018f, code lost:
        r5.put("m", r3.apkMD5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0196, code lost:
        r5.put("l", r3.key);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x019e, code lost:
        r5.put("v", r3.versionName);
        r0.put(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01a7, code lost:
        r2 = r4.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01af, code lost:
        if (r2.hasNext() != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01b1, code lost:
        r3 = (com.baidu.sofire.core.ApkInfo) r2.next();
        r4 = new org.json.JSONObject();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01bf, code lost:
        r4.put(com.meizu.cloud.pushsdk.constants.PushConstants.URI_PACKAGE_NAME, r3.packageName);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01c6, code lost:
        r4.put("m", r3.apkMD5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01cd, code lost:
        r4.put("l", r3.key);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01d5, code lost:
        r4.put("v", r3.versionName);
        r0.put(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01df, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r7 != null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
        if (r7 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
        r0 = new org.json.JSONArray(r5);
        r4 = com.baidu.sofire.k.b.o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        if (r4 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004e, code lost:
        com.baidu.sofire.k.b.o = new java.util.HashMap<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0056, code lost:
        r4.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        r4 = new java.util.ArrayList();
        r5 = new java.util.ArrayList();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
        if (r7 < r0.length()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006a, code lost:
        r8 = r0.optJSONObject(r7);
        r9 = r8.optString("pkgname");
        r10 = r8.optString("version");
        r11 = r8.optInt("id");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0082, code lost:
        if (r11 > 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0084, code lost:
        r5.add(java.lang.Integer.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
        r8 = r8.optString(com.baidu.searchbox.pms.db.PackageTable.MD5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0095, code lost:
        if (android.text.TextUtils.isEmpty(r9) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a7, code lost:
        r12 = r3.a.getString("g_l_l_p_v_" + r11, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c4, code lost:
        if (android.text.TextUtils.isEmpty(r12) != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00cc, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ce, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00cf, code lost:
        if (r12 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00db, code lost:
        r15 = r13.versionName;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e1, code lost:
        if (android.text.TextUtils.isEmpty(r10) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ea, code lost:
        r6 = r10.split("\\.");
        r2 = r15.split("\\.");
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f8, code lost:
        if (r15 < r6.length) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00fd, code lost:
        r14 = java.lang.Integer.valueOf(r6[r15]).intValue() - java.lang.Integer.valueOf(r2[r15]).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0113, code lost:
        if (r14 != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0115, code lost:
        if (r14 > 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0118, code lost:
        r15 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x011d, code lost:
        if (r6.length > r2.length) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x011f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0121, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0122, code lost:
        if (r2 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0129, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012b, code lost:
        r14 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x012c, code lost:
        r2 = r8.toLowerCase();
        r6 = new com.baidu.sofire.core.ApkInfo();
        r6.packageName = r9;
        r6.versionName = r10;
        r6.key = r11;
        r6.apkMD5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x013d, code lost:
        if (r14 != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x013f, code lost:
        r4.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0143, code lost:
        com.baidu.sofire.k.b.o.put(java.lang.Integer.valueOf(r11), r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0151, code lost:
        r3.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x015a, code lost:
        if (com.baidu.sofire.k.b.o.size() > 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0163, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0165, code lost:
        r0 = new org.json.JSONArray();
        r2 = com.baidu.sofire.k.b.o.values().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0178, code lost:
        if (r2.hasNext() != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x017a, code lost:
        r3 = r2.next();
        r5 = new org.json.JSONObject();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0188, code lost:
        r5.put(com.meizu.cloud.pushsdk.constants.PushConstants.URI_PACKAGE_NAME, r3.packageName);
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013f A[Catch: all -> 0x01e2, TryCatch #2 {all -> 0x01e2, blocks: (B:7:0x0008, B:26:0x003d, B:30:0x0045, B:32:0x004e, B:34:0x0059, B:35:0x0064, B:37:0x006a, B:39:0x0084, B:40:0x008b, B:42:0x0097, B:44:0x009d, B:48:0x00a7, B:50:0x00c6, B:55:0x00d1, B:57:0x00db, B:59:0x00e3, B:77:0x0124, B:81:0x012c, B:83:0x013f, B:84:0x0143, B:85:0x014c, B:86:0x0151, B:88:0x015c, B:93:0x0165, B:94:0x0174, B:96:0x017a, B:98:0x0188, B:100:0x018f, B:102:0x0196, B:104:0x019e, B:105:0x01a7, B:106:0x01ab, B:108:0x01b1, B:110:0x01bf, B:112:0x01c6, B:114:0x01cd, B:116:0x01d5, B:33:0x0056, B:9:0x0013, B:23:0x0037, B:19:0x0030, B:20:0x0033), top: B:137:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0143 A[Catch: all -> 0x01e2, TryCatch #2 {all -> 0x01e2, blocks: (B:7:0x0008, B:26:0x003d, B:30:0x0045, B:32:0x004e, B:34:0x0059, B:35:0x0064, B:37:0x006a, B:39:0x0084, B:40:0x008b, B:42:0x0097, B:44:0x009d, B:48:0x00a7, B:50:0x00c6, B:55:0x00d1, B:57:0x00db, B:59:0x00e3, B:77:0x0124, B:81:0x012c, B:83:0x013f, B:84:0x0143, B:85:0x014c, B:86:0x0151, B:88:0x015c, B:93:0x0165, B:94:0x0174, B:96:0x017a, B:98:0x0188, B:100:0x018f, B:102:0x0196, B:104:0x019e, B:105:0x01a7, B:106:0x01ab, B:108:0x01b1, B:110:0x01bf, B:112:0x01c6, B:114:0x01cd, B:116:0x01d5, B:33:0x0056, B:9:0x0013, B:23:0x0037, B:19:0x0030, B:20:0x0033), top: B:137:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized JSONArray a(Context context) {
        InterceptResult invokeL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            synchronized (b.class) {
                try {
                    com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                    String str = "";
                    Properties properties = new Properties();
                    try {
                        inputStream = context.getAssets().open("sofire_local.cfg");
                        try {
                            properties.load(inputStream);
                            str = properties.getProperty("local");
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            th = th;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException unused3) {
                        inputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                } catch (Throwable unused4) {
                    int i2 = com.baidu.sofire.a.b.a;
                    return null;
                }
            }
        } else {
            return (JSONArray) invokeL.objValue;
        }
    }

    public static JSONObject a(Context context, com.baidu.sofire.e.a aVar, String str, boolean z) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, aVar, str, Boolean.valueOf(z)})) == null) {
            String str3 = aVar.a;
            String str4 = aVar.c;
            if (z) {
                str2 = aVar.d;
            } else {
                str2 = aVar.e;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", System.currentTimeMillis());
                jSONObject2.put("1", "0");
                jSONObject2.put("2", "0");
                String[] o2 = o(context);
                if (o2.length == 2) {
                    jSONObject2.put("3", o2[0]);
                } else {
                    jSONObject2.put("3", "3");
                }
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put("6", 1);
                jSONObject2.put("7", 0);
                jSONObject2.put("8", str3);
                jSONObject2.put("9", str4);
                jSONObject2.put("10", str2);
                JSONObject jSONObject3 = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject3 = new JSONObject(str);
                }
                jSONObject.put("Common_section", jSONObject2);
                jSONObject.put("Module_section", jSONObject3);
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    @SuppressLint({"WrongConstant"})
    public static void a(Context context, long j2) {
        PendingIntent service;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65548, null, context, j2) == null) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
            intent.setClassName(context, MyService.class.getCanonicalName());
            intent.setPackage(context.getPackageName());
            intent.addCategory("com.baidu.category.SOFIRE");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from_plugin_package", context.getPackageName());
            intent.putExtra("target_class", Receiver.class.getCanonicalName());
            intent.putExtra("target_method", "handleDailyWork");
            if (h(context)) {
                service = PendingIntent.getService(context, 101, intent, 201326592);
            } else {
                service = PendingIntent.getService(context, 101, intent, 134217728);
            }
            try {
                alarmManager.cancel(service);
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            try {
                alarmManager.set(1, System.currentTimeMillis() + j2, service);
            } catch (Throwable unused2) {
                int i3 = com.baidu.sofire.a.b.a;
            }
        }
    }

    public static void a(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65549, null, context, str, i2) != null) || i2 < 0) {
            return;
        }
        try {
            File file = new File(new File(context.getFilesDir(), "sofire_tmp"), ".tmp");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            if (i2 > 0) {
                if (file2.exists()) {
                    file2.delete();
                }
            } else if (i2 == 0 && !file2.exists()) {
                file2.createNewFile();
            }
        } catch (Throwable unused) {
            int i3 = com.baidu.sofire.a.b.a;
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        com.baidu.sofire.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, str, str2, str3, str4, str5}) == null) {
            c.a(context).a(false);
            c a2 = c.a(context);
            a2.getClass();
            Message message = new Message();
            message.what = 8;
            a2.b.a.sendMessage(message);
            com.baidu.sofire.e.a aVar2 = new com.baidu.sofire.e.a();
            aVar2.a = str;
            aVar2.b = str2;
            aVar2.c = str3;
            aVar2.d = str4;
            aVar2.e = str5;
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                com.baidu.sofire.j.a a3 = com.baidu.sofire.j.a.a(context);
                List<com.baidu.sofire.e.a> c2 = a3.c();
                if (c2 == null) {
                    a3.a(aVar2);
                } else if (!c2.contains(aVar2)) {
                    a3.a(aVar2);
                } else {
                    int indexOf = c2.indexOf(aVar2);
                    if (indexOf != -1 && (aVar = c2.get(indexOf)) != null) {
                        a3.f.putString("re_con", a3.e.getString("re_con", "").replace(com.baidu.sofire.e.a.a(aVar), com.baidu.sofire.e.a.a(aVar2)));
                        a3.f.commit();
                    }
                    com.baidu.sofire.i.a aVar3 = c.a(context).b;
                    aVar3.getClass();
                    Message message2 = new Message();
                    message2.what = 7;
                    aVar3.a.sendMessage(message2);
                    return;
                }
                String str6 = aVar2.e;
                SharedPreferences sharedPreferences = a3.e;
                if (!sharedPreferences.getBoolean("re_net_ins_" + str6, false)) {
                    c a4 = c.a(context);
                    com.baidu.sofire.i.a aVar4 = a4.b;
                    com.baidu.sofire.j.a aVar5 = aVar4.b;
                    String str7 = aVar2.e;
                    SharedPreferences sharedPreferences2 = aVar5.e;
                    String string = sharedPreferences2.getString("al_da" + str7, "");
                    String str8 = aVar2.e;
                    long currentTimeMillis = System.currentTimeMillis();
                    String jSONObject = a(aVar4.c, aVar2, string, false).toString();
                    com.baidu.sofire.f.a a5 = com.baidu.sofire.f.a.a(aVar4.c);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("b", str8);
                    contentValues.put("c", (Integer) 1);
                    contentValues.put("d", Long.valueOf(currentTimeMillis));
                    contentValues.put("e", (Integer) 0);
                    contentValues.put("g", (Integer) 1);
                    contentValues.put("f", (Integer) 0);
                    contentValues.put("i", (Integer) 0);
                    contentValues.put("j", (String) null);
                    try {
                        jSONObject = Base64.encodeToString(F.getInstance().ae(jSONObject.getBytes(), "xVOTuxgN3lkRN2v4".getBytes(IMAudioTransRequest.CHARSET)), 0);
                    } catch (Exception unused) {
                        int i2 = com.baidu.sofire.a.b.a;
                    }
                    contentValues.put("h", jSONObject);
                    try {
                        a5.b.insert("r", null, contentValues);
                    } catch (Throwable unused2) {
                        int i3 = com.baidu.sofire.a.b.a;
                    }
                    com.baidu.sofire.j.a aVar6 = aVar4.b;
                    String str9 = aVar2.e;
                    SharedPreferences.Editor editor = aVar6.f;
                    editor.putBoolean("re_net_ins_" + str9, true);
                    aVar6.f.commit();
                    a4.b.a(aVar2);
                }
                com.baidu.sofire.i.a aVar7 = c.a(context).b;
                aVar7.getClass();
                Message message3 = new Message();
                message3.what = 7;
                aVar7.a.sendMessage(message3);
                c.a(context).a();
            }
        }
    }

    public static void a(Context context, String str, Map<String, Object> map, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, str, map, Boolean.valueOf(z)}) == null) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", System.currentTimeMillis());
                jSONObject2.put("1", "");
                jSONObject2.put("2", "");
                String[] o2 = o(context);
                if (o2.length != 2 || TextUtils.isEmpty(o2[0]) || TextUtils.isEmpty(o2[1])) {
                    str2 = "3";
                } else {
                    str2 = o2[0];
                }
                jSONObject2.put("3", str2);
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put("6", 1);
                jSONObject2.put("7", 0);
                jSONObject2.put("8", "sofire");
                jSONObject2.put("9", "3.6.0.4");
                jSONObject2.put("10", str);
                jSONObject.put("Common_section", jSONObject2);
                if (map != null && map.size() > 0) {
                    jSONObject.put("Module_section", new JSONObject(map));
                } else {
                    jSONObject.put("Module_section", new JSONObject());
                }
                Report.getInstance(context).s(jSONObject.toString(), z);
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }

    public static void a(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65552, null, context, str, z) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                System.currentTimeMillis();
                a2.e.getInt("re_net_ty", 2);
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
                com.baidu.sofire.g.a aVar = new com.baidu.sofire.g.a();
                aVar.d = str;
                aVar.b = optString;
                aVar.g = optInt;
                aVar.c = 3;
                aVar.e = optLong;
                aVar.f = optInt2;
                aVar.h = optInt3;
                aVar.i = optInt4;
                aVar.j = "";
                c a3 = c.a(context);
                a3.getClass();
                Message message = new Message();
                if (!z && !d()) {
                    com.baidu.sofire.f.a.a(a3.a).a(aVar);
                    message.what = 10;
                    a3.b.a.sendMessage(message);
                }
                message.what = 1;
                message.obj = aVar;
                a3.b.a.sendMessage(message);
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        r6 = r6.optJSONObject("2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r6 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        r0 = r6.optString("0");
        r6 = r6.optString("1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (android.text.TextUtils.isEmpty(r6) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        com.baidu.sofire.b.b.a(r5).a(r0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, jSONObject) == null) {
            try {
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                String[] c2 = c(context);
                boolean z = true;
                if (a2.a.getInt("appinv_ky", 1) != 1 || (c2.length == 2 && !TextUtils.isEmpty(c2[0]) && !TextUtils.isEmpty(c2[1]))) {
                    z = false;
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }

    public static void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65554, null, str, z) == null) {
            a("771", str);
            if (z) {
                a("771", new File(str).getParentFile().getAbsolutePath());
            }
        }
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return !str.equals(str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, th) == null) {
            int i2 = com.baidu.sofire.a.b.a;
        }
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return a(new File(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(i)) {
                    i = a(Process.myPid());
                }
                return !str.equals(i);
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) {
            try {
                if (context.getApplicationInfo().targetSdkVersion >= 31) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                return activeNetworkInfo.isConnected();
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, context, broadcastReceiver, intentFilter)) == null) {
            try {
                context.registerReceiver(broadcastReceiver, intentFilter, context.getPackageName() + ".permission.sofire.RECEIVE", null);
                return true;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) {
            try {
                File file = new File(new File(context.getFilesDir(), "sofire_tmp"), ".tmp");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return !new File(file, str).exists();
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:15:0x003c, B:18:0x004c, B:20:0x0054, B:22:0x0060, B:26:0x006c, B:30:0x0076, B:34:0x0089, B:35:0x008e, B:32:0x0080), top: B:44:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0089 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:15:0x003c, B:18:0x004c, B:20:0x0054, B:22:0x0060, B:26:0x006c, B:30:0x0076, B:34:0x0089, B:35:0x008e, B:32:0x0080), top: B:44:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        ResolveInfo resolveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean z3 = false;
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context.getPackageName(), MyService.class.getCanonicalName()));
                resolveInfo = context.getPackageManager().resolveService(intent, 0);
                if (resolveInfo != null) {
                    try {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        if (serviceInfo != null) {
                            String str2 = serviceInfo.processName;
                            j = str2;
                            if (str.equals(str2)) {
                                z3 = true;
                            }
                        }
                    } catch (Throwable unused) {
                        int i2 = com.baidu.sofire.a.b.a;
                        if (resolveInfo == null) {
                        }
                        if (TextUtils.isEmpty(i)) {
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
                    String a2 = a(context, str, "service");
                    k = a2;
                    if (str.equals(a2)) {
                        z3 = true;
                    }
                } catch (Throwable unused3) {
                    int i3 = com.baidu.sofire.a.b.a;
                }
            }
            if (TextUtils.isEmpty(i)) {
                i = a(Process.myPid());
            }
            if (z2 && i.equals(str) && (!z3 || z)) {
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

    public static synchronized boolean a(Context context, boolean z) {
        InterceptResult invokeLZ;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65559, null, context, z)) == null) {
            synchronized (b.class) {
                boolean z2 = false;
                try {
                    int i2 = l;
                    if (i2 != -1) {
                        if (i2 == 1) {
                            z2 = true;
                        }
                        return z2;
                    }
                    String g2 = g(context);
                    if (TextUtils.isEmpty(g2)) {
                        a2 = a(context, context.getPackageName(), true, z);
                    } else {
                        a2 = a(context, g2, false, z);
                    }
                    if (a2) {
                        l = 1;
                    } else {
                        l = 0;
                    }
                    return a2;
                } catch (Throwable unused) {
                    int i3 = com.baidu.sofire.a.b.a;
                    return false;
                }
            }
        }
        return invokeLZ.booleanValue;
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, file)) == null) {
            if (file.exists() && file.isFile() && file.canRead() && file.length() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split("#");
                    if (split.length >= 4 && split[1].startsWith("c")) {
                        return split[1].substring(1);
                    }
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            return "com.baidu.sofire.engine.EngineImpl";
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            try {
                String str2 = new String(f.a(d.a, Base64.decode(str, 10), true), "UTF-8");
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
                return "";
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            try {
                networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                networkInfo = null;
            }
            if (networkInfo == null) {
                return 0;
            }
            if (1 == networkInfo.getType()) {
                return 2;
            }
            networkInfo.getType();
            return 1;
        }
        return invokeL.intValue;
    }

    public static int j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, context)) == null) {
            try {
                if (MyProvider.a) {
                    return 1;
                }
                if (e == -1) {
                    int b2 = b(context);
                    if (b2 == 1) {
                        e = 1;
                    } else if (b2 == 2) {
                        e = 0;
                    } else {
                        e = MyProvider.a ? 1 : 0;
                    }
                }
                return e;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() != 3 || !new File(str2).exists()) {
                return false;
            }
            try {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("chmod " + str + " " + str2 + "\n").waitFor();
                return true;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            try {
                return new String(F.getInstance().ad(Base64.decode("2s3neoRGrtMfJHEASAvJDkdImW3sImg0pRReW5cWEQQB2HfrzauSCia/ssvfdE6q", 0), d.a));
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                if (Looper.getMainLooper().getThread().getId() != Thread.currentThread().getId()) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65566, null, context, str) == null) {
            String str2 = "";
            com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
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
                            SharedPreferences.Editor editor = a2.f;
                            editor.putString("al_da" + str3, optString);
                            a2.f.commit();
                        }
                    }
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
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
                            SharedPreferences.Editor editor2 = a2.f;
                            editor2.putString("in_da" + str2, optString2);
                            a2.f.commit();
                        }
                    }
                } catch (Throwable unused2) {
                    int i3 = com.baidu.sofire.a.b.a;
                }
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("2");
                    if (optJSONArray != null) {
                        a2.f.putString("li_pk_s", optJSONArray.toString());
                        a2.f.commit();
                    }
                } catch (Throwable unused3) {
                    int i4 = com.baidu.sofire.a.b.a;
                }
            } catch (Throwable unused4) {
                int i5 = com.baidu.sofire.a.b.a;
            }
        }
    }

    public static boolean b(int i2) {
        InterceptResult invokeI;
        ApkInfo b2;
        com.baidu.sofire.b.i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65567, null, i2)) == null) {
            try {
                com.baidu.sofire.c.a aVar = com.baidu.sofire.c.a.d;
                if (aVar == null || (b2 = aVar.b(i2)) == null || b2.initStatus != 1 || (iVar = com.baidu.sofire.b.i.g) == null) {
                    return false;
                }
                if (iVar.b(b2.packageName) == null) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static void c(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, null, context, jSONObject) == null) {
            try {
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                String optString = jSONObject.optString("0");
                if (!TextUtils.isEmpty(optString)) {
                    a2.d.putString("gli", new String(Base64.encode(f.b(d.a, optString.getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.d.commit();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("4");
                if (optJSONObject == null) {
                    return;
                }
                a2.b.putInt("appinv_t", optJSONObject.optInt("app"));
                a2.b.commit();
                a2.b.putInt("appinv_js", optJSONObject.optInt("js"));
                a2.b.commit();
                a2.b.putInt("appinv_ky", optJSONObject.optInt("a", 1));
                a2.b.commit();
                a2.b.putInt("appplg_te", optJSONObject.optInt("pi", 360));
                a2.b.commit();
                int optInt = optJSONObject.optInt(Config.FEED_LIST_PART, 1);
                if (optInt > 0) {
                    int round = (int) Math.round(24.0d / optInt);
                    if (round > 0) {
                        a2.b.putInt("appal_te", round);
                        a2.b.commit();
                    } else {
                        a2.b.putInt("appal_te", 24);
                        a2.b.commit();
                    }
                }
                int optInt2 = optJSONObject.optInt("alm", 24);
                if (optInt2 > 0) {
                    a2.b.putInt("appal_daa", optInt2);
                    a2.b.commit();
                } else {
                    a2.b.putInt("appal_daa", 24);
                    a2.b.commit();
                }
                if (optJSONObject.optInt("0", 0) > 0) {
                    a2.b.putBoolean("a_a_c_b", true);
                    a2.b.commit();
                } else {
                    a2.b.putBoolean("a_a_c_b", false);
                    a2.b.commit();
                }
                if (optJSONObject.optInt("1", -1) == 1) {
                    a2.a.getBoolean("se_fg_s", false);
                    a2.b.putBoolean("se_fg_s", true);
                    a2.b.commit();
                } else {
                    a2.b.putBoolean("se_fg_s", false);
                    a2.b.commit();
                }
                a(context, "ampf", optJSONObject.optInt("mp", 0));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("pc");
                if (optJSONObject2 != null) {
                    com.baidu.sofire.j.a a3 = com.baidu.sofire.j.a.a(context);
                    a3.b.putString("p_s_p_c", optJSONObject2.toString());
                    a3.b.commit();
                    q.a(optJSONObject2);
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("pr");
                if (optJSONObject3 != null) {
                    com.baidu.sofire.a.a.a(context, optJSONObject3);
                }
                if (optJSONObject.optInt(Config.DEVICE_MAC_ID, 1) > 0) {
                    k.a = true;
                    a2.b.putBoolean("s_n_m_c_s", true);
                    a2.b.commit();
                    return;
                }
                k.a = false;
                a2.b.putBoolean("s_n_m_c_s", false);
                a2.b.commit();
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        File file;
        BufferedReader bufferedReader;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            if (Build.VERSION.SDK_INT > 22) {
                return Process.is64Bit();
            }
            try {
                file = new File("/proc/" + Process.myPid() + "/maps");
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            if (!file.exists() || file.isDirectory()) {
                return false;
            }
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (IOException unused2) {
                    int i3 = com.baidu.sofire.a.b.a;
                }
            } catch (Throwable unused3) {
            }
            do {
                try {
                    readLine = bufferedReader.readLine();
                } catch (Throwable unused4) {
                    bufferedReader2 = bufferedReader;
                    int i4 = com.baidu.sofire.a.b.a;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return false;
                }
                if (readLine == null) {
                    bufferedReader.close();
                    return false;
                }
            } while (!readLine.contains("/system/lib64/libc.so"));
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
                int i5 = com.baidu.sofire.a.b.a;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static String e(Context context) {
        int length;
        int length2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(d.a(context));
                sb.append(":");
                String hexString = Long.toHexString(System.currentTimeMillis() / 1000);
                if (!TextUtils.isEmpty(hexString) && (length2 = 8 - hexString.length()) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (length2 = 8 - hexString.length(); length2 > 0; length2--) {
                        sb2.append("0");
                    }
                    hexString = sb2.toString() + hexString;
                }
                String hexString2 = Long.toHexString(Long.valueOf(o(context)[0]).longValue());
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
                int i2 = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String[] o(Context context) {
        InterceptResult invokeL;
        String[] split;
        String[] split2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, context)) == null) {
            String str = b;
            String str2 = c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    String string = com.baidu.sofire.j.a.a(context).a.getString("svi_n", "");
                    if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length == 2) {
                        String str3 = split[0];
                        String str4 = split[1];
                        return split;
                    }
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    String string2 = com.baidu.sofire.j.a.a(context).a.getString("svi", "");
                    if (!TextUtils.isEmpty(string2) && (split2 = string2.split("-")) != null && split2.length == 2) {
                        String str5 = split2[0];
                        String str6 = split2[1];
                        return split2;
                    }
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    str = "3";
                    str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
                }
                return new String[]{str, str2};
            }
            return new String[]{str, str2};
        }
        return (String[]) invokeL.objValue;
    }

    public static void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65590, null, context) == null) {
            try {
                Report report = Report.getInstance(context);
                JSONObject jSONObject = new JSONObject();
                com.baidu.sofire.c.a a2 = com.baidu.sofire.c.a.a(context);
                HashMap hashMap = (HashMap) a2.c();
                jSONObject.put("0", hashMap.keySet());
                jSONObject.put("1", hashMap.values());
                synchronized (b.class) {
                    try {
                        if (f == null) {
                            f = new JSONArray();
                            try {
                                Class.forName("com.baidu.sofire.face.api.FaceApi");
                                f.put("1");
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable unused2) {
                        int i2 = com.baidu.sofire.a.b.a;
                    }
                }
                JSONArray jSONArray = f;
                if (jSONArray != null) {
                    jSONObject.put("2", jSONArray);
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("1003003", jSONObject);
                jSONObject2.put("0", jSONObject3);
                Map<Integer, String> d2 = a2.d();
                JSONArray jSONArray2 = new JSONArray();
                for (String str : ((HashMap) d2).values()) {
                    jSONArray2.put(str);
                }
                jSONArray2.put("com.baidu.sofire");
                jSONObject2.put("2", jSONArray2);
                report.w(jSONObject2.toString());
            } catch (Throwable unused3) {
            }
        }
    }

    public static String g(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable unused) {
                fileInputStream = null;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!z) {
                        sb.append('\n');
                    } else {
                        z = false;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                try {
                    fileInputStream.close();
                } catch (Throwable unused2) {
                }
                return sb2;
            } catch (Throwable unused3) {
                try {
                    int i2 = com.baidu.sofire.a.b.a;
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

    /* JADX WARN: Removed duplicated region for block: B:54:0x0119 A[Catch: all -> 0x012f, LOOP:1: B:52:0x0113->B:54:0x0119, LOOP_END, TRY_LEAVE, TryCatch #5 {all -> 0x0160, blocks: (B:5:0x0009, B:7:0x002a, B:8:0x002f, B:10:0x003d, B:16:0x0061, B:29:0x0090, B:31:0x00a4, B:34:0x00ac, B:35:0x00c4, B:37:0x00c9, B:39:0x00d4, B:61:0x0133, B:63:0x014c, B:66:0x015c, B:12:0x0057, B:18:0x006c, B:20:0x0073, B:22:0x007b, B:24:0x0083, B:26:0x0088, B:49:0x0104, B:51:0x010a, B:52:0x0113, B:54:0x0119, B:57:0x0127, B:46:0x00ff), top: B:74:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject n(Context context) {
        InterceptResult invokeL;
        List<PackageInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, context)) == null) {
            try {
                String str = b() + "p/5/aio";
                JSONObject jSONObject = new JSONObject();
                Object a2 = a(context);
                if (a2 != null) {
                    jSONObject.put("0", a2);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("1", d.a(context));
                jSONObject2.put("3", String.valueOf(Build.VERSION.SDK_INT));
                jSONObject2.put("4", "3.6.0.4");
                String packageName = context.getPackageName();
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
                if (packageInfo != null) {
                    String charSequence = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                    int length = charSequence.length();
                    int i2 = 0;
                    while (i2 < length && (charSequence.charAt(i2) <= ' ' || charSequence.charAt(i2) == 160)) {
                        i2++;
                    }
                    if (i2 > 0) {
                        charSequence = charSequence.substring(i2);
                    }
                    jSONObject2.put("5", charSequence);
                    jSONObject2.put("6", packageName);
                    PublicKey a3 = a(packageInfo, packageInfo.applicationInfo.sourceDir);
                    if (a3 != null) {
                        byte[] encoded = a3.getEncoded();
                        if (encoded != null) {
                            jSONObject2.put("7", j.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                        } else {
                            jSONObject2.put("7", "");
                        }
                    }
                    jSONObject2.put("8", packageInfo.versionName);
                    com.baidu.sofire.j.a a4 = com.baidu.sofire.j.a.a(context);
                    jSONObject2.put("9", String.valueOf(a4.a.getInt("opi", 0)));
                    if (a4.a.getBoolean("r_a_l_t", false)) {
                        try {
                        } catch (Throwable unused) {
                            int i3 = com.baidu.sofire.a.b.a;
                        }
                        if (q.e(context)) {
                            list = context.getPackageManager().getInstalledPackages(0);
                            if (list != null) {
                                JSONArray jSONArray = new JSONArray();
                                while (r1.hasNext()) {
                                }
                                jSONObject2.put("aps", jSONArray.toString());
                            }
                        } else {
                            list = null;
                            if (list != null && list.size() > 0) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (PackageInfo packageInfo2 : list) {
                                    jSONArray2.put(packageInfo2.packageName);
                                }
                                jSONObject2.put("aps", jSONArray2.toString());
                            }
                        }
                    }
                    jSONObject2.put("16", a.a(context));
                    jSONObject.put("1", jSONObject2);
                    String a5 = com.baidu.sofire.a.a.a(context, str, jSONObject.toString(), true, true);
                    if (TextUtils.isEmpty(a5)) {
                        return null;
                    }
                    JSONObject jSONObject3 = new JSONObject(a5);
                    a(context, jSONObject3);
                    com.baidu.sofire.h.a.a(context, jSONObject3);
                    c(context, jSONObject3);
                    return jSONObject3;
                }
                d = 6;
                return null;
            } catch (Throwable unused2) {
                int i4 = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
