package com.baidu.cyberplayer.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.kuaishou.weapon.un.s;
import com.kuaishou.weapon.un.w0;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes4.dex */
public class o {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = ".video_cache";

    /* renamed from: b  reason: collision with root package name */
    public static String f32186b = "last_file_cache_time";

    /* renamed from: c  reason: collision with root package name */
    public static long f32187c = 86400000;

    /* renamed from: d  reason: collision with root package name */
    public static long f32188d = 104857600;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f32189e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static volatile int f32190f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f32191g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-598477212, "Lcom/baidu/cyberplayer/sdk/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-598477212, "Lcom/baidu/cyberplayer/sdk/o;");
        }
    }

    public static long a(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bool)) == null) {
            if (bool.booleanValue() || r()) {
                long i2 = d.i();
                d.a(bool.booleanValue() ? 0L : CyberCfgManager.getInstance().getCfgLongValue("file_lru_expired_duration", 600L));
                long i3 = d.i();
                CyberCfgManager.getInstance().setPrefLong(f32186b, System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("delete file success,  beforeSpace = ");
                sb.append(i2);
                sb.append(" afterSpace = ");
                sb.append(i3);
                sb.append(" deleteSpaceSize = ");
                long j2 = i2 - i3;
                sb.append(j2);
                CyberLog.i("sdk_Utils", sb.toString());
                return j2;
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static Bitmap a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bitmap)) == null) {
            if (bitmap != null) {
                Matrix matrix = new Matrix();
                matrix.postScale(1.0f, -1.0f);
                try {
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Context applicationContext = CyberPlayerManager.getApplicationContext();
            File filesDir = applicationContext.getFilesDir();
            if (filesDir != null) {
                return filesDir.getAbsolutePath();
            }
            return "/data/data/" + applicationContext.getPackageName() + "/files";
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String str = null;
            try {
                if (c(context)) {
                    str = Environment.getExternalStorageDirectory().getAbsolutePath();
                } else if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                    str = context.getExternalCacheDir().getPath();
                }
            } catch (Exception unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String a(File file) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            if (file != null && file.isFile()) {
                byte[] bArr = new byte[1024];
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    FileInputStream fileInputStream = new FileInputStream(file);
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    fileInputStream.close();
                    byte[] digest = messageDigest.digest();
                    char[] charArray = "0123456789abcdef".toCharArray();
                    StringBuilder sb = new StringBuilder(digest.length * 2);
                    for (i2 = 0; i2 < digest.length; i2++) {
                        sb.append(charArray[(digest[i2] >> 4) & 15]);
                        sb.append(charArray[digest[i2] & 15]);
                    }
                    return sb.toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            if (bArr != null && bArr.length >= 1) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr, 0, bArr.length);
                    byte[] digest = messageDigest.digest();
                    char[] charArray = "0123456789abcdef".toCharArray();
                    StringBuilder sb = new StringBuilder(digest.length * 2);
                    for (int i2 = 0; i2 < digest.length; i2++) {
                        sb.append(charArray[(digest[i2] >> 4) & 15]);
                        sb.append(charArray[digest[i2] & 15]);
                    }
                    return sb.toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bArr, str)) == null) {
            try {
                byte[] bytes = str.getBytes();
                byte[] bArr2 = new byte[256];
                for (int i2 = 0; i2 < 256; i2++) {
                    bArr2[i2] = (byte) i2;
                }
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < 256; i5++) {
                    i4 = ((bytes[i3] & 255) + bArr2[i5] + i4) & 255;
                    byte b2 = bArr2[i5];
                    bArr2[i5] = bArr2[i4];
                    bArr2[i4] = b2;
                    i3 = (i3 + 1) % bytes.length;
                }
                int length = bArr.length;
                byte[] bArr3 = new byte[length];
                int length2 = bArr.length;
                if (length2 <= length) {
                    int i6 = 0;
                    int i7 = 0;
                    for (int i8 = 0; i8 < length2; i8++) {
                        i6 = (i6 + 1) & 255;
                        i7 = (bArr2[i6] + i7) & 255;
                        byte b3 = bArr2[i6];
                        bArr2[i6] = bArr2[i7];
                        bArr2[i7] = b3;
                        bArr3[i8] = (byte) (bArr[i8] ^ bArr2[(bArr2[i6] + bArr2[i7]) & 255]);
                    }
                    return new String(bArr3, "utf-8");
                }
                throw new RuntimeException("output buffer too short");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static ArrayList<String> a(File file, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, file, str)) == null) {
            CyberLog.d("sdk_Utils", "unzipFile start");
            if (file != null) {
                if (file.exists()) {
                    if (file.length() <= 524288000) {
                        if (str != null) {
                            File file2 = new File(str);
                            if (file2.exists() && file2.isDirectory()) {
                                ArrayList<String> arrayList = new ArrayList<>();
                                ZipFile zipFile = new ZipFile(file);
                                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                                byte[] bArr = new byte[1024];
                                while (entries.hasMoreElements()) {
                                    ZipEntry nextElement = entries.nextElement();
                                    if (!nextElement.getName().contains("../")) {
                                        File file3 = new File(str, nextElement.getName());
                                        if (nextElement.isDirectory()) {
                                            try {
                                                if (!file3.exists()) {
                                                    file3.mkdirs();
                                                    arrayList.add(nextElement.getName());
                                                }
                                            } catch (Exception unused) {
                                            }
                                        } else {
                                            try {
                                                if (!file3.getParentFile().exists()) {
                                                    file3.mkdirs();
                                                }
                                            } catch (Exception unused2) {
                                            }
                                            arrayList.add(nextElement.getName());
                                            CyberLog.d("sdk_Utils", "dstFile:" + file3.getAbsolutePath());
                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                                            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                            while (true) {
                                                int read = bufferedInputStream.read(bArr, 0, 1024);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, read);
                                            }
                                            bufferedInputStream.close();
                                            bufferedOutputStream.close();
                                        }
                                    }
                                }
                                zipFile.close();
                                CyberLog.w("sdk_Utils", "unzipFile success");
                                return arrayList;
                            }
                            throw new Exception("directory not exist");
                        }
                        throw new Exception("unzipFolder is null");
                    }
                    throw new Exception("zip file too large");
                }
                throw new Exception("zip file not exist");
            }
            throw new Exception("zip file is null");
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static Map<String, String> a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, map)) == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            String str = map.get("User-Agent");
            if (TextUtils.isEmpty(str)) {
                str = "dumedia/7.32.10.41";
            } else if (str.indexOf("dumedia") == -1) {
                str = str + " dumedia/" + SDKVersion.VERSION;
            }
            map.put("User-Agent", str);
            return map;
        }
        return (Map) invokeL.objValue;
    }

    public static void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65546, null, j2) == null) {
            d.b(j2);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(new File(str));
        }
    }

    public static void a(String str, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, str, arrayList) == null) || str == null || arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a(str + File.separator + arrayList.get(i2));
        }
    }

    public static void a(StringBuilder sb, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{sb, str, Long.valueOf(j2)}) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(j2);
        }
    }

    public static void a(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, sb, str, str2) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(str2);
        }
    }

    public static boolean a(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw null;
            }
            File file = new File(str2);
            if (!file.exists()) {
                throw new Exception(file.getName() + " is not exists");
            }
            String a2 = a(file);
            CyberLog.d("sdk_Utils", str2 + "---->MD5\n" + str + StringUtils.LF + a2);
            return str.equalsIgnoreCase(a2);
        }
        return invokeLL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return a() + File.separator + "cybermedia";
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            String str = null;
            if (context == null) {
                CyberLog.e("sdk_Utils", "getVideoStatisticsPath ctx = null");
                return null;
            }
            String a2 = a(context);
            if (!TextUtils.isEmpty(a2)) {
                str = a2 + File.separator + "baidu" + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + "duplayer" + File.separator + context.getPackageName();
            }
            String str2 = context.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
            CyberLog.i("sdk_Utils", "Utils.getExternalStorageSpace():" + f());
            if (f() < 10485760 || str == null) {
                str = str2;
            }
            new File(str).mkdirs();
            if (!m()) {
                str = str + File.separator + "remote";
            }
            CyberLog.i("sdk_Utils", "getVideoStatisticsPath folder:" + str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, file) == null) {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        b(file2);
                    }
                }
                file.delete();
            } catch (Exception e2) {
                CyberLog.w("sdk_Utils", e2.toString());
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            File file = new File(str);
            try {
                if (file.exists() && file.isDirectory()) {
                    return;
                }
                file.mkdirs();
            } catch (Exception unused) {
            }
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            StringBuilder sb = new StringBuilder();
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost == null || defaultHost.length() <= 0 || defaultPort < 0 || defaultPort > 65535) {
                return null;
            }
            sb.append(defaultHost);
            sb.append(":");
            sb.append(String.valueOf(defaultPort));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static Map<String, String> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            HashMap hashMap = new HashMap();
            if (str != null) {
                try {
                    JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.getString(next));
                    }
                } catch (Throwable th) {
                    CyberLog.d("sdk_Utils", "setCloudSettings parserData JSONTokener error " + th);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            if (context != null && (packageManager = context.getPackageManager()) != null) {
                try {
                    if (Build.VERSION.SDK_INT < 30) {
                        return packageManager.checkPermission(s.f53810i, context.getPackageName()) == 0 && packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0;
                    }
                    CyberLog.i("sdk_Utils", "android 11 no ExternalStorage Permission!");
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())) : (String) invokeV.objValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? CyberPlayerManager.getApplicationContext().getFilesDir().getUsableSpace() : invokeV.longValue;
    }

    public static long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    String path = Environment.getExternalStorageDirectory().getPath();
                    if (path == null || path.length() <= 0) {
                        CyberLog.w("sdk_Utils", "External path is null, so SDCard no free space");
                        return -1L;
                    }
                    StatFs statFs = new StatFs(path);
                    return statFs.getBlockSize() * statFs.getAvailableBlocks();
                }
                return -1L;
            } catch (Exception unused) {
                CyberLog.w("sdk_Utils", "SDCard no free space");
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public static String g() {
        InterceptResult invokeV;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            String p = p();
            if (TextUtils.isEmpty(p)) {
                return Build.CPU_ABI;
            }
            String str2 = "AArch64";
            if (p.contains("ARMv5")) {
                str2 = "armv5";
            } else if (p.contains("ARMv6")) {
                str2 = "armv6";
            } else {
                if (!p.contains("ARMv7")) {
                    if (p.contains(w0.o1)) {
                        str2 = "x86";
                    } else if (!p.contains("AArch64")) {
                        if (TextUtils.isEmpty(Build.CPU_ABI)) {
                            str2 = "unknown";
                        } else if (!Build.CPU_ABI.equals("armeabi-v7a")) {
                            str2 = Build.CPU_ABI;
                        }
                    }
                }
                str2 = "armv7";
            }
            if (p.contains("neon")) {
                sb = new StringBuilder();
                sb.append(str2);
                str = "-neon";
            } else if (p.contains("vfpv3")) {
                sb = new StringBuilder();
                sb.append(str2);
                str = "-vfpv3";
            } else if (p.contains(" vfp")) {
                sb = new StringBuilder();
                sb.append(str2);
                str = "-vfp";
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                str = "-none";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            SharedPreferences.Editor edit = CyberPlayerManager.getApplicationContext().getSharedPreferences(VideoCloudSetting.PREF_NAME, 0).edit();
            edit.putString(VideoCloudSetting.PREF_KEY_CYBER_SDK_VERSION, SDKVersion.VERSION);
            edit.putString(VideoCloudSetting.PREF_KEY_CYBER_CORE_VERSION, CyberVersion.getCoreVersionInternal());
            edit.commit();
        }
    }

    public static String i() {
        InterceptResult invokeV;
        WifiInfo connectionInfo;
        int rssi;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            try {
                Context applicationContext = CyberPlayerManager.getApplicationContext();
                ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        return "Disconnect";
                    }
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        return TextUtils.isEmpty(extraInfo) ? "Disconnect" : extraInfo;
                    } else if (type == 1) {
                        WifiManager wifiManager = (WifiManager) applicationContext.getSystemService("wifi");
                        if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && (rssi = connectionInfo.getRssi()) > -127) {
                            return "wifi:" + rssi;
                        }
                        return "Disconnect";
                    }
                }
            } catch (Exception unused) {
            }
            return "N/A";
        }
        return (String) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, null) == null) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.o.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        o.a(Boolean.FALSE);
                    }
                }
            });
        }
    }

    public static long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? d.i() : invokeV.longValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            if (TextUtils.isEmpty(f32191g)) {
                f32191g = t();
                if (TextUtils.isEmpty(f32191g)) {
                    f32191g = u();
                }
                return f32191g;
            }
            return f32191g;
        }
        return (String) invokeV.objValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            if (f32189e < 0) {
                Context applicationContext = CyberPlayerManager.getApplicationContext();
                if (applicationContext == null || applicationContext.getPackageName().equals(l())) {
                    f32189e = 1;
                } else {
                    f32189e = 0;
                }
            }
            return f32189e == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            Context applicationContext = CyberPlayerManager.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            try {
                ActivityManager activityManager = (ActivityManager) applicationContext.getSystemService("activity");
                if (activityManager != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                        if (packageName.equals(runningAppProcessInfo.processName)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            if (f32190f < 0) {
                f32190f = Build.VERSION.SDK_INT >= 23 ? Process.is64Bit() : ((BaseDexClassLoader) CyberPlayerManager.getApplicationContext().getClassLoader()).findLibrary("c").contains("lib64");
            }
            return f32190f == 1 ? "arm64-v8a" : "armeabi-v7a";
        }
        return (String) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
                return w0.o1;
            }
            String str = "";
            try {
                byte[] bArr = new byte[1024];
                RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
                randomAccessFile.read(bArr);
                String str2 = new String(bArr);
                int indexOf = str2.indexOf(0);
                str = indexOf != -1 ? str2.substring(0, indexOf) : str2;
                randomAccessFile.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? CyberCfgManager.getInstance().getCfgLongValue("file_cache_max_size", f32188d) : invokeV.longValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                long prefLong = CyberCfgManager.getInstance().getPrefLong(f32186b, 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (prefLong > 0) {
                    return (((currentTimeMillis - prefLong) > s() ? 1 : ((currentTimeMillis - prefLong) == s() ? 0 : -1)) > 0) || ((d.i() > q() ? 1 : (d.i() == q() ? 0 : -1)) > 0);
                }
                CyberCfgManager.getInstance().setPrefLong(f32186b, currentTimeMillis);
                return false;
            } catch (Exception | OutOfMemoryError unused) {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? CyberCfgManager.getInstance().getCfgLongValue("file_cache_delete_interval", f32187c) : invokeV.longValue;
    }

    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            int myPid = Process.myPid();
            try {
                ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService("activity");
                if (activityManager != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                        if (runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String u() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65576, null)) != null) {
            return (String) invokeV.objValue;
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
