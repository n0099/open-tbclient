package c.a.c0.g.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d0.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(File file) {
        InterceptResult invokeL;
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) ? (file == null || TextUtils.isEmpty(file.getPath()) || (packageManager = c.a.c0.e.a.b().getPackageManager()) == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), 1)) == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) ? "" : applicationInfo.packageName : (String) invokeL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                c.a.c0.e.a.b().getPackageManager().getApplicationInfo(str, 0);
                return true;
            } catch (PackageManager.NameNotFoundException | Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean c(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) ? d(file, false) : invokeL.booleanValue;
    }

    public static boolean d(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, file, z)) == null) {
            if (f(file)) {
                Context b2 = c.a.c0.e.a.b();
                Intent intent = new Intent("android.intent.action.VIEW");
                try {
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    intent.setFlags(1342177280);
                    intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", b2.getPackageName());
                    if (z) {
                        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                    }
                    if (!f.b.e()) {
                        intent.setComponent(new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.PackageInstallerActivity"));
                    }
                    c.a.c0.d0.a.a(b2, file, intent);
                    c.a.c0.d0.a.c(b2, intent);
                } catch (Exception unused) {
                    intent.setComponent(null);
                    c.a.c0.d0.a.a(b2, file, intent);
                    try {
                        b2.startActivity(intent);
                    } catch (Exception unused2) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static void e(@NonNull c.a.c0.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) {
            if (!TextUtils.isEmpty(aVar.n.f1962c)) {
                c.a.c0.d.c.b(aVar.n.f1962c);
            } else {
                g(aVar.f1941d);
            }
        }
    }

    public static boolean f(File file) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) ? (file == null || TextUtils.isEmpty(file.getAbsolutePath()) || !file.exists() || (packageManager = c.a.c0.e.a.b().getPackageManager()) == null || packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 1) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = c.a.c0.e.a.b().getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || (next = queryIntentActivities.iterator().next()) == null) {
                return false;
            }
            String str2 = next.activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str2));
            intent2.setFlags(268435456);
            return c.a.c0.d0.a.d(c.a.c0.e.a.b(), intent2, true);
        }
        return invokeL.booleanValue;
    }
}
