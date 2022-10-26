package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
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
/* loaded from: classes2.dex */
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return UUID.randomUUID().toString().replace("-", "");
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            return a(context.getFileStreamPath("libdueros_uuid.so"));
        }
        return (String) invokeL.objValue;
    }

    public static String a(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            String str = null;
            if (file != null && file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        String str2 = new String(bArr, 0, fileInputStream.read(bArr));
                        if (a.matcher(str2).matches()) {
                            str = str2;
                        }
                        bt.a(fileInputStream);
                        return str;
                    } catch (Exception unused) {
                        bt.a(fileInputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        bt.a(fileInputStream2);
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

    public static String c(Context context) {
        InterceptResult invokeL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
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

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            boolean z = false;
            FileOutputStream fileOutputStream = null;
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    i = 0;
                } else {
                    i = 1;
                }
                fileOutputStream = context.openFileOutput("libdueros_uuid.so", i);
                if (a(fileOutputStream, str)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        File fileStreamPath = context.getFileStreamPath("libdueros_uuid.so");
                        if (a(new File(applicationInfo.dataDir), 457)) {
                            if (a(fileStreamPath, 484)) {
                                z = true;
                            }
                        }
                        bt.a(fileOutputStream);
                        return z;
                    }
                    bt.a(fileOutputStream);
                    return true;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                bt.a(fileOutputStream);
                throw th;
            }
            bt.a(fileOutputStream);
            return false;
        }
        return invokeLL.booleanValue;
    }

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

    public static String optUUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            String b = b(context);
            if (b != null) {
                return b;
            }
            String c = c(context);
            if (c != null) {
                a(context, c);
                return c;
            }
            String a2 = a(context);
            if (a2 != null) {
                a(context, a2);
                return a2;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
