package c.a.n0.h.b;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
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
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static a f8411b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1838886251, "Lc/a/n0/h/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1838886251, "Lc/a/n0/h/b/a;");
                return;
            }
        }
        a = AppRuntime.getAppContext().getCacheDir() + File.separator + "gamenowGuide" + File.separator + "configCache";
        f8411b = new a();
    }

    public a() {
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

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f8411b : (a) invokeV.objValue;
    }

    public synchronized void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            synchronized (this) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j > elapsedRealtime) {
                    File file = new File(a);
                    if (!file.exists() && !file.mkdirs()) {
                        if (c.a.n0.a.a.a) {
                            Log.d("GameGuideConfigCache", "创建缓存目录失败");
                        }
                        return;
                    }
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2 != null && file2.exists() && file2.getName().startsWith(str)) {
                                c.a.n0.w.d.j(file2);
                            }
                        }
                    }
                    boolean N = c.a.n0.w.d.N(str2, new File(a, b(str, j)));
                    if (c.a.n0.a.a.a) {
                        Log.d("GameGuideConfigCache", "缓存配置信息成功：  " + N);
                    }
                    return;
                }
                if (c.a.n0.a.a.a) {
                    Log.d("GameGuideConfigCache", "缓存失败，参数异常  appKey = " + str + ",  config = " + str2 + ",  expiration = " + j + ",  currentTime = " + elapsedRealtime);
                }
            }
        }
    }

    public final String b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            return str + "_" + j;
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
                    if (c.a.n0.a.a.a) {
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
                    if (c.a.n0.a.a.a) {
                        Log.d("GameGuideConfigCache", "获取缓存配置失败， appKey为null");
                    }
                    return null;
                }
                File file = new File(a);
                if (!file.exists()) {
                    if (c.a.n0.a.a.a) {
                        Log.d("GameGuideConfigCache", "获取缓存配置失败， 缓存目录不存在");
                    }
                    return null;
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    File file2 = null;
                    for (File file3 : listFiles) {
                        if (d(file3)) {
                            c.a.n0.w.d.j(file3);
                        } else if (file3.getName().startsWith(str)) {
                            file2 = file3;
                        }
                    }
                    if (file2 == null) {
                        return null;
                    }
                    return c.a.n0.w.d.E(file2);
                }
                if (c.a.n0.a.a.a) {
                    Log.d("GameGuideConfigCache", "获取缓存配置失败， 缓存目录中的文件为空");
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
