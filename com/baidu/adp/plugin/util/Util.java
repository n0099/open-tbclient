package com.baidu.adp.plugin.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.b;
import c.a.e.e.p.f;
import c.a.e.e.p.m;
import c.a.e.e.p.q;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashSet;
import kotlin.UShort;
/* loaded from: classes4.dex */
public final class Util {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class VersionCompare {
        public static final /* synthetic */ VersionCompare[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final VersionCompare EQUAL;
        public static final VersionCompare GREATER;
        public static final VersionCompare LESS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1888935309, "Lcom/baidu/adp/plugin/util/Util$VersionCompare;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1888935309, "Lcom/baidu/adp/plugin/util/Util$VersionCompare;");
                    return;
                }
            }
            EQUAL = new VersionCompare("EQUAL", 0);
            LESS = new VersionCompare("LESS", 1);
            VersionCompare versionCompare = new VersionCompare("GREATER", 2);
            GREATER = versionCompare;
            $VALUES = new VersionCompare[]{EQUAL, LESS, versionCompare};
        }

        public VersionCompare(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static VersionCompare valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VersionCompare) Enum.valueOf(VersionCompare.class, str) : (VersionCompare) invokeL.objValue;
        }

        public static VersionCompare[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VersionCompare[]) $VALUES.clone() : (VersionCompare[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f36410a;

        /* renamed from: b  reason: collision with root package name */
        public String f36411b;

        /* renamed from: c  reason: collision with root package name */
        public int f36412c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36410a = false;
            this.f36411b = null;
            this.f36412c = 0;
        }
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, file) == null) && file != null && file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return;
                }
                for (File file2 : listFiles) {
                    try {
                        f(file2);
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    public static int b(Signature[] signatureArr, Signature[] signatureArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, signatureArr, signatureArr2)) == null) {
            if (signatureArr == null) {
                return signatureArr2 == null ? 1 : -1;
            } else if (signatureArr2 == null) {
                return -2;
            } else {
                HashSet hashSet = new HashSet();
                for (Signature signature : signatureArr) {
                    hashSet.add(signature);
                }
                HashSet hashSet2 = new HashSet();
                for (Signature signature2 : signatureArr2) {
                    hashSet2.add(signature2);
                }
                return hashSet.equals(hashSet2) ? 0 : -3;
            }
        }
        return invokeLL.intValue;
    }

    public static VersionCompare c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return VersionCompare.LESS;
            }
            if (TextUtils.isEmpty(str2)) {
                return VersionCompare.GREATER;
            }
            if (str.equals(str2)) {
                return VersionCompare.EQUAL;
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            int length = split.length;
            int length2 = split2.length;
            int i2 = length < length2 ? length : length2;
            for (int i3 = 0; i3 < i2; i3++) {
                int e2 = b.e(split[i3], 0);
                int e3 = b.e(split2[i3], 0);
                if (e2 > e3) {
                    return VersionCompare.GREATER;
                }
                if (e2 < e3) {
                    return VersionCompare.LESS;
                }
            }
            if (length == length2) {
                return VersionCompare.EQUAL;
            }
            if (length2 > length) {
                return VersionCompare.LESS;
            }
            return VersionCompare.GREATER;
        }
        return (VersionCompare) invokeLL.objValue;
    }

    public static a d(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, inputStream, file)) == null) {
            a aVar = new a();
            if (inputStream != null && file != null) {
                if (file.exists()) {
                    f.n(file);
                }
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    aVar.f36410a = true;
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream2 = fileOutputStream;
                    aVar.f36410a = false;
                    aVar.f36411b = e.toString();
                    c.a.e.e.m.a.d(fileOutputStream2);
                    return aVar;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    c.a.e.e.m.a.d(fileOutputStream2);
                    throw th;
                }
                c.a.e.e.m.a.d(fileOutputStream2);
                return aVar;
            }
            aVar.f36411b = "illegal_param";
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    public static void e(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file) == null) && file != null && file.exists()) {
            a(file);
            try {
                file.delete();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static void f(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file) == null) || file == null) {
            return;
        }
        if (file.isDirectory()) {
            e(file);
        } else if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Exception e2) {
                BdLog.e(e2);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static String h(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, applicationInfo)) == null) {
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return null;
            }
            StringBuilder sb = null;
            int i2 = 0;
            while (true) {
                Bundle bundle = applicationInfo.metaData;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cmd_range_");
                int i3 = i2 + 1;
                sb2.append(i2);
                String string = bundle.getString(sb2.toString());
                if (TextUtils.isEmpty(string)) {
                    break;
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(string);
                sb.append(",");
                i2 = i3;
            }
            if (sb == null || sb.length() <= 0) {
                return null;
            }
            return sb.substring(0, sb.length() - 1);
        }
        return (String) invokeL.objValue;
    }

    public static File i(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            PluginSetting P = PluginPackageManager.O().P(str);
            if (P == null || (str2 = P.apkPath) == null || str2.length() <= 4) {
                return null;
            }
            String str3 = P.apkPath;
            return new File(str3.substring(0, str3.length() - 4));
        }
        return (File) invokeL.objValue;
    }

    public static String j(PluginSetting pluginSetting) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pluginSetting)) == null) {
            if (pluginSetting == null) {
                return null;
            }
            return pluginSetting.packageName + ".apk_" + pluginSetting.tempVersionCode;
        }
        return (String) invokeL.objValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str + ".apk_";
        }
        return (String) invokeL.objValue;
    }

    public static String l(PluginSetting pluginSetting) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, pluginSetting)) == null) {
            if (pluginSetting == null) {
                return null;
            }
            return m() + File.separator + j(pluginSetting);
        }
        return (String) invokeL.objValue;
    }

    public static File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                File dir = BdBaseApplication.getInst().getDir("plugins", 0);
                if (!dir.exists()) {
                    if (!dir.mkdir()) {
                        return null;
                    }
                }
                return dir;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (File) invokeV.objValue;
    }

    public static String n(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return bundle.getString("replace_method_classes", null);
        }
        return (String) invokeL.objValue;
    }

    public static String o(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return String.valueOf(bundle.getInt("require_load"));
        }
        return (String) invokeL.objValue;
    }

    public static boolean p(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean("has_res", false);
        }
        return invokeL.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            try {
                String property = System.getProperty("java.vm.version");
                if (property != null) {
                    return property.startsWith("2");
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean r(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean("is_inject_classloader");
        }
        return invokeL.booleanValue;
    }

    public static boolean s(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean("is_patch", false);
        }
        return invokeL.booleanValue;
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            try {
                return Build.VERSION.class.getField("PREVIEW_SDK_INT").getInt(null) > 0;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static final boolean u(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65556, null, j2)) == null) {
            long g2 = g();
            if (j2 <= 0) {
                return g2 <= 0 || g2 >= 31457280;
            }
            long j3 = j2 * (Build.VERSION.SDK_INT < 19 ? 6 : 10);
            return (j3 <= 31457280 ? j3 : 31457280L) < g2;
        }
        return invokeJ.booleanValue;
    }

    public static boolean v(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean("is_third", false);
        }
        return invokeL.booleanValue;
    }

    public static int w(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, bArr, i2)) == null) {
            if (bArr == null) {
                return 0;
            }
            return ((short) ((bArr[i2] & 255) | (bArr[i2 + 1] << 8))) & UShort.MAX_VALUE;
        }
        return invokeLI.intValue;
    }

    public static c.a.e.h.k.f x(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, inputStream)) == null) {
            if (inputStream == null) {
                return null;
            }
            byte[] bArr = new byte[26];
            if (inputStream.read(new byte[4]) == -1 || inputStream.read(bArr, 0, 26) == -1) {
                return null;
            }
            int w = w(bArr, 6);
            int w2 = w(bArr, 8);
            c.a.e.h.k.f fVar = new c.a.e.h.k.f();
            fVar.b(((w2 >> 9) & 127) + 1980, (w2 >> 5) & 15, w2 & 31, (w >> 11) & 31, (w >> 5) & 63, (w & 31) << 1);
            return fVar;
        }
        return (c.a.e.h.k.f) invokeL.objValue;
    }

    public static String y(InputStream inputStream, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, inputStream, bArr)) == null) {
            String str = null;
            if (inputStream == null) {
                return null;
            }
            try {
                try {
                    byte[] bArr2 = new byte[1024];
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    if (bArr != null && bArr.length > 0) {
                        messageDigest.update(bArr, 0, bArr.length);
                    }
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr2, 0, read);
                    }
                    str = q.a(messageDigest.digest());
                } catch (Exception e2) {
                    BdLog.e(e2.toString());
                }
                return str;
            } finally {
                m.e(inputStream);
            }
        }
        return (String) invokeLL.objValue;
    }
}
