package c.a.p0.f.j;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f10705a;

    /* renamed from: b  reason: collision with root package name */
    public static a f10706b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1215847855, "Lc/a/p0/f/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1215847855, "Lc/a/p0/f/j/a;");
                return;
            }
        }
        f10705a = AppRuntime.getAppContext().getCacheDir() + File.separator + "gamenowGuide" + File.separator + "configCache";
        f10706b = new a();
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

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f10706b : (a) invokeV.objValue;
    }

    public synchronized void a(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
            synchronized (this) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j2 > elapsedRealtime) {
                    File file = new File(f10705a);
                    if (!file.exists() && !file.mkdirs()) {
                        boolean z = c.a.p0.a.k.f7077a;
                        return;
                    }
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2 != null && file2.exists() && file2.getName().startsWith(str)) {
                                c.a.p0.t.d.i(file2);
                            }
                        }
                    }
                    boolean M = c.a.p0.t.d.M(str2, new File(f10705a, b(str, j2)));
                    if (c.a.p0.a.k.f7077a) {
                        String str3 = "缓存配置信息成功：  " + M;
                    }
                    return;
                }
                if (c.a.p0.a.k.f7077a) {
                    String str4 = "缓存失败，参数异常  appKey = " + str + ",  config = " + str2 + ",  expiration = " + j2 + ",  currentTime = " + elapsedRealtime;
                }
            }
        }
    }

    public final String b(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2)) == null) {
            return str + "_" + j2;
        }
        return (String) invokeLJ.objValue;
    }

    public final boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
            if (file != null && file.exists()) {
                String[] split = file.getName().split("_");
                if (split.length != 2) {
                    return true;
                }
                try {
                    if (Long.valueOf(split[1]).longValue() > SystemClock.elapsedRealtime()) {
                        return false;
                    }
                } catch (Throwable th) {
                    if (c.a.p0.a.k.f7077a) {
                        th.printStackTrace();
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public synchronized String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    boolean z = c.a.p0.a.k.f7077a;
                    return null;
                }
                File file = new File(f10705a);
                if (!file.exists()) {
                    boolean z2 = c.a.p0.a.k.f7077a;
                    return null;
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    File file2 = null;
                    for (File file3 : listFiles) {
                        if (d(file3)) {
                            c.a.p0.t.d.i(file3);
                        } else if (file3.getName().startsWith(str)) {
                            file2 = file3;
                        }
                    }
                    if (file2 == null) {
                        return null;
                    }
                    return c.a.p0.t.d.D(file2);
                }
                boolean z3 = c.a.p0.a.k.f7077a;
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
