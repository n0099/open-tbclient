package b.a.h0.b.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f2905a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f2906b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(537504245, "Lb/a/h0/b/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(537504245, "Lb/a/h0/b/a/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Context a2 = e.a();
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) a2.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return -1;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.importance;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String str = f2905a;
            if (str == null) {
                synchronized (a.class) {
                    str = f2905a;
                    if (str == null) {
                        Context a2 = e.a();
                        String d2 = d();
                        if (d2 == null && (d2 = c(a2)) == null) {
                            d2 = a2.getPackageName();
                        }
                        f2905a = d2;
                        str = d2;
                    }
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0036 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x000c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static String d() {
        InterceptResult invokeV;
        ?? r2;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            BufferedReader bufferedReader2 = 0;
            BufferedReader bufferedReader3 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(ProcessUtils.CMD_LINE_NAME))));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
                r2 = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                    return readLine;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return readLine;
                }
            } catch (Exception e4) {
                e = e4;
                r2 = null;
                bufferedReader3 = bufferedReader;
                h("MultiProcess", e);
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                bufferedReader2 = r2;
                return bufferedReader2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            int i2 = f2906b;
            if (i2 == 0) {
                String b2 = b();
                String packageName = e.a().getPackageName();
                i2 = (TextUtils.equals(b2, packageName) || (b2.startsWith(packageName) && !b2.contains(":"))) ? i2 | 1 | 2 : i2 | 4;
                f2906b = i2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (e() & 1) != 0 : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? (e() & 2) != 0 : invokeV.booleanValue;
    }

    public static void h(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, exc) == null) {
        }
    }
}
