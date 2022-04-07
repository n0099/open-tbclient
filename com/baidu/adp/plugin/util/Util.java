package com.baidu.adp.plugin.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ii;
import com.repackage.lg;
import com.repackage.pi;
import com.repackage.ui;
import com.repackage.xm;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashSet;
import kotlin.UShort;
/* loaded from: classes.dex */
public final class Util {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
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

        public VersionCompare(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public int c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            this.b = null;
            this.c = 0;
        }
    }

    public static int a(Signature[] signatureArr, Signature[] signatureArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, signatureArr, signatureArr2)) == null) {
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

    public static a b(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, inputStream, file)) == null) {
            a aVar = new a();
            if (inputStream != null && file != null) {
                if (file.exists()) {
                    ii.n(file);
                }
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception e) {
                        e = e;
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
                    aVar.a = true;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    aVar.a = false;
                    aVar.b = e.toString();
                    lg.d(fileOutputStream2);
                    return aVar;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    lg.d(fileOutputStream2);
                    throw th;
                }
                lg.d(fileOutputStream2);
                return aVar;
            }
            aVar.b = "illegal_param";
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Exception e) {
                BdLog.e(e);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static String d(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, applicationInfo)) == null) {
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return null;
            }
            StringBuilder sb = null;
            int i = 0;
            while (true) {
                Bundle bundle = applicationInfo.metaData;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cmd_range_");
                int i2 = i + 1;
                sb2.append(i);
                String string = bundle.getString(sb2.toString());
                if (TextUtils.isEmpty(string)) {
                    break;
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(string);
                sb.append(",");
                i = i2;
            }
            if (sb == null || sb.length() <= 0) {
                return null;
            }
            return sb.substring(0, sb.length() - 1);
        }
        return (String) invokeL.objValue;
    }

    public static File e(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            PluginSetting q = PluginPackageManager.p().q(str);
            if (q == null || (str2 = q.apkPath) == null || str2.length() <= 4) {
                return null;
            }
            String str3 = q.apkPath;
            return new File(str3.substring(0, str3.length() - 4));
        }
        return (File) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str + ".apk_";
        }
        return (String) invokeL.objValue;
    }

    public static File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                File dir = BdBaseApplication.getInst().getDir("plugins", 0);
                if (!dir.exists()) {
                    if (!dir.mkdir()) {
                        return null;
                    }
                }
                return dir;
            } catch (Exception e) {
                BdLog.e(e);
                return null;
            }
        }
        return (File) invokeV.objValue;
    }

    public static String h(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return bundle.getString("replace_method_classes", null);
        }
        return (String) invokeL.objValue;
    }

    public static String i(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return String.valueOf(bundle.getInt("require_load"));
        }
        return (String) invokeL.objValue;
    }

    public static boolean j(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean("has_res", false);
        }
        return invokeL.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
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

    public static boolean l(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean("is_inject_classloader");
        }
        return invokeL.booleanValue;
    }

    public static boolean m(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean("is_patch", false);
        }
        return invokeL.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            try {
                return Build.VERSION.class.getField("PREVIEW_SDK_INT").getInt(null) > 0;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static final boolean o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65550, null, j)) == null) {
            long c = c();
            if (j <= 0) {
                return c <= 0 || c >= 31457280;
            }
            long j2 = j * (Build.VERSION.SDK_INT < 19 ? 6 : 10);
            return (j2 <= 31457280 ? j2 : 31457280L) < c;
        }
        return invokeJ.booleanValue;
    }

    public static boolean p(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, applicationInfo)) == null) {
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean("is_third", false);
        }
        return invokeL.booleanValue;
    }

    public static int q(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, bArr, i)) == null) {
            if (bArr == null) {
                return 0;
            }
            return ((short) ((bArr[i] & 255) | (bArr[i + 1] << 8))) & UShort.MAX_VALUE;
        }
        return invokeLI.intValue;
    }

    public static xm r(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, inputStream)) == null) {
            if (inputStream == null) {
                return null;
            }
            byte[] bArr = new byte[26];
            if (inputStream.read(new byte[4]) == -1 || inputStream.read(bArr, 0, 26) == -1) {
                return null;
            }
            int q = q(bArr, 6);
            int q2 = q(bArr, 8);
            xm xmVar = new xm();
            xmVar.b(((q2 >> 9) & 127) + 1980, (q2 >> 5) & 15, q2 & 31, (q >> 11) & 31, (q >> 5) & 63, (q & 31) << 1);
            return xmVar;
        }
        return (xm) invokeL.objValue;
    }

    public static String s(InputStream inputStream, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, inputStream, bArr)) == null) {
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
                    str = ui.a(messageDigest.digest());
                } catch (Exception e) {
                    BdLog.e(e.toString());
                }
                return str;
            } finally {
                pi.e(inputStream);
            }
        }
        return (String) invokeLL.objValue;
    }
}
