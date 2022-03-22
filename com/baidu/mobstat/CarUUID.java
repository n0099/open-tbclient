package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.system.Os;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class CarUUID {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1420997099, "Lcom/baidu/mobstat/CarUUID;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1420997099, "Lcom/baidu/mobstat/CarUUID;");
                return;
            }
        }
        a = Pattern.compile("(\\w{32})");
    }

    public CarUUID() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? UUID.randomUUID().toString().replace("-", "") : (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? a(context.getFileStreamPath("libdueros_uuid.so")) : (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (c(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                return a(new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".dueros_uuid"));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            for (ApplicationInfo applicationInfo2 : installedApplications) {
                if (!applicationInfo.packageName.equals(applicationInfo2.packageName) && (a2 = a(new File(new File(applicationInfo2.dataDir, "files"), "libdueros_uuid.so"))) != null) {
                    return a2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String optUUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            String b2 = b(context);
            if (b2 != null) {
                return b2;
            }
            String c2 = c(context);
            if (c2 != null) {
                a(context, c2);
                return c2;
            }
            String d2 = d(context);
            if (d2 != null) {
                a(context, d2);
                b(context, d2);
                return d2;
            }
            String a2 = a(context);
            if (a2 != null) {
                a(context, a2);
                b(context, a2);
                return a2;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            boolean z = false;
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = context.openFileOutput("libdueros_uuid.so", Build.VERSION.SDK_INT >= 21 ? 0 : 1);
                if (a(fileOutputStream, str)) {
                    if (Build.VERSION.SDK_INT < 21) {
                        bu.a(fileOutputStream);
                        return true;
                    }
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    File fileStreamPath = context.getFileStreamPath("libdueros_uuid.so");
                    if (a(new File(applicationInfo.dataDir), 457)) {
                        if (a(fileStreamPath, 484)) {
                            z = true;
                        }
                    }
                    bu.a(fileOutputStream);
                    return z;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                bu.a(fileOutputStream);
                throw th;
            }
            bu.a(fileOutputStream);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, null, context, str)) != null) {
            return invokeLL.booleanValue;
        }
        if (!c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".dueros_uuid"));
            try {
                boolean a2 = a(fileOutputStream, str);
                bu.a(fileOutputStream);
                return a2;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                bu.a(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                bu.a(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) ? context.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeLL.booleanValue;
    }

    public static String a(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            if (file != null && file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        String str = new String(bArr, 0, fileInputStream.read(bArr));
                        String str2 = a.matcher(str).matches() ? str : null;
                        bu.a(fileInputStream);
                        return str2;
                    } catch (Exception unused) {
                        bu.a(fileInputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        bu.a(fileInputStream2);
                        throw th;
                    }
                } catch (Exception unused2) {
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(FileOutputStream fileOutputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, fileOutputStream, str)) == null) {
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public static boolean a(File file, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, file, i)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return true;
            }
            try {
                Os.chmod(file.getAbsolutePath(), i);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLI.booleanValue;
    }
}
