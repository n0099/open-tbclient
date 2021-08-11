package c.p.a.e.a.h.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.heytap.mcssdk.PushManager;
import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PackageInfo a(@NonNull Context context, @NonNull File file, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, file, i2)) == null) {
            if (c.p.a.e.b.l.a.a(268435456) && (i3 = Build.VERSION.SDK_INT) >= 21 && i3 < 26) {
                try {
                    return b(file);
                } catch (Throwable th) {
                    f("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                    return g(context, file, i2);
                }
            }
            return g(context, file, i2);
        }
        return (PackageInfo) invokeLLI.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:126:0x0148 */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0072, code lost:
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PackageInfo b(@NonNull File file) {
        InterceptResult invokeL;
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        ZipFile zipFile;
        ZipInputStream zipInputStream2;
        ZipFile zipFile2;
        ZipEntry zipEntry;
        FileInputStream fileInputStream2;
        ZipInputStream zipInputStream3;
        ZipFile zipFile3;
        ZipInputStream zipInputStream4;
        int e2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, file)) != null) {
            return (PackageInfo) invokeL.objValue;
        }
        a aVar = null;
        aVar = null;
        String str = null;
        aVar = null;
        aVar = null;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    ZipInputStream zipInputStream5 = new ZipInputStream(fileInputStream3);
                    while (true) {
                        ZipEntry nextEntry = zipInputStream5.getNextEntry();
                        if (nextEntry == null) {
                            zipFile3 = null;
                            zipEntry = nextEntry;
                            fileInputStream = fileInputStream3;
                            zipInputStream4 = zipInputStream5;
                            zipInputStream3 = null;
                            break;
                        } else if (nextEntry.isDirectory()) {
                            try {
                                zipInputStream5.closeEntry();
                            } catch (Throwable unused) {
                            }
                        } else if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                            zipFile3 = null;
                            zipEntry = nextEntry;
                            fileInputStream = fileInputStream3;
                            zipInputStream4 = zipInputStream5;
                            zipInputStream3 = zipInputStream5;
                            break;
                        } else {
                            zipInputStream5.closeEntry();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    zipFile = null;
                    fileInputStream = fileInputStream3;
                    zipInputStream = null;
                    try {
                        throw new com.ss.android.socialbase.appdownloader.f.a.c("throwable: " + th.getMessage() + th.toString());
                    } catch (Throwable th2) {
                        if (aVar != null) {
                            try {
                                aVar.b();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                        throw th2;
                    }
                }
            } else {
                ZipFile zipFile4 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile4.entries();
                    ZipEntry zipEntry2 = null;
                    while (true) {
                        if (!entries.hasMoreElements()) {
                            zipInputStream2 = null;
                            zipFile2 = zipFile4;
                            zipEntry = zipEntry2;
                            fileInputStream2 = null;
                            break;
                        }
                        zipEntry2 = entries.nextElement();
                        if (!zipEntry2.isDirectory() && "AndroidManifest.xml".equals(zipEntry2.getName())) {
                            break;
                        }
                    }
                    fileInputStream = fileInputStream2;
                    zipInputStream4 = fileInputStream2;
                    zipFile3 = zipFile2;
                    zipInputStream3 = zipInputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    zipFile = zipFile4;
                    zipInputStream = null;
                    throw new com.ss.android.socialbase.appdownloader.f.a.c("throwable: " + th.getMessage() + th.toString());
                }
            }
            if (zipEntry != null) {
                try {
                    if ("AndroidManifest.xml".equals(zipEntry.getName())) {
                        a aVar2 = new a();
                        try {
                            aVar2.c(zipInputStream3);
                            do {
                                e2 = aVar2.e();
                                if (e2 == 1) {
                                    throw new com.ss.android.socialbase.appdownloader.f.a.c("已达到END_DOCUMENT");
                                }
                            } while (e2 != 2);
                            int i2 = aVar2.i();
                            String str2 = null;
                            String str3 = null;
                            for (int i3 = 0; i3 != i2; i3++) {
                                if (PushManager.APP_VERSION_NAME.equals(aVar2.a(i3))) {
                                    str2 = e(aVar2, i3);
                                } else if (PushManager.APP_VERSION_CODE.equals(aVar2.a(i3))) {
                                    str = e(aVar2, i3);
                                } else if (AsInstallService.SCHEME_PACKAGE_ADDED.equals(aVar2.a(i3))) {
                                    str3 = e(aVar2, i3);
                                }
                            }
                            try {
                                j2 = Long.parseLong(str);
                            } catch (com.ss.android.socialbase.appdownloader.f.a.c unused6) {
                                j2 = -1;
                            }
                            if (j2 != -1) {
                                PackageInfo packageInfo = new PackageInfo();
                                packageInfo.versionName = str2;
                                packageInfo.versionCode = (int) j2;
                                packageInfo.packageName = str3;
                                if (zipInputStream4 != null) {
                                    try {
                                        zipInputStream4.closeEntry();
                                    } catch (Throwable unused7) {
                                    }
                                }
                                try {
                                    aVar2.b();
                                } catch (Throwable unused8) {
                                }
                                if (zipInputStream3 != null) {
                                    try {
                                        zipInputStream3.close();
                                    } catch (Throwable unused9) {
                                    }
                                }
                                if (zipFile3 != null) {
                                    try {
                                        zipFile3.close();
                                    } catch (Throwable unused10) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused11) {
                                    }
                                }
                                return packageInfo;
                            }
                            throw new com.ss.android.socialbase.appdownloader.f.a.c("versionCode获取失败: " + str);
                        } catch (Throwable th4) {
                            zipInputStream = zipInputStream3;
                            th = th4;
                            aVar = aVar2;
                            zipFile = zipFile3;
                            throw new com.ss.android.socialbase.appdownloader.f.a.c("throwable: " + th.getMessage() + th.toString());
                        }
                    }
                } catch (Throwable th5) {
                    zipInputStream = zipInputStream3;
                    th = th5;
                    zipFile = zipFile3;
                }
            }
            throw new com.ss.android.socialbase.appdownloader.f.a.c("没有找到AndroidManifest.xml entry");
        } catch (Throwable th6) {
            th = th6;
            zipInputStream = aVar;
            fileInputStream = zipInputStream;
            zipFile = fileInputStream;
        }
    }

    public static String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? (i2 >>> 24) == 1 ? "android:" : "" : (String) invokeI.objValue;
    }

    public static String d(Context context, PackageInfo packageInfo, String str) {
        InterceptResult invokeLLL;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, packageInfo, str)) == null) {
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
                return null;
            }
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadLabel(context.getPackageManager()).toString();
            } catch (OutOfMemoryError e2) {
                f("getPackageInfo::fail_load_label", e2.getMessage());
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String e(a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, i2)) == null) {
            int f2 = aVar.f(i2);
            int g2 = aVar.g(i2);
            if (f2 == 3) {
                return aVar.h(i2);
            }
            return f2 == 2 ? String.format("?%s%08X", c(g2), Integer.valueOf(g2)) : (f2 < 16 || f2 > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(g2), Integer.valueOf(f2)) : String.valueOf(g2);
        }
        return (String) invokeLI.objValue;
    }

    public static void f(@NonNull String str, @NonNull String str2) {
        c.p.a.e.b.e.b t0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) || (t0 = c.p.a.e.b.g.e.t0()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException unused) {
        }
        t0.a(str, jSONObject, null, null);
    }

    public static PackageInfo g(@NonNull Context context, @NonNull File file, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, context, file, i2)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                f("unzip_getpackagearchiveinfo", "packageManager == null");
                return null;
            }
            try {
                return packageManager.getPackageArchiveInfo(file.getPath(), i2);
            } catch (Throwable th) {
                f("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
                return null;
            }
        }
        return (PackageInfo) invokeLLI.objValue;
    }
}
