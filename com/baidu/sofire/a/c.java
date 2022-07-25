package com.baidu.sofire.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, e> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2073961013, "Lcom/baidu/sofire/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2073961013, "Lcom/baidu/sofire/a/c;");
                return;
            }
        }
        a = new HashMap();
    }

    public static void a(Context context, int i, File file, File file2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65537, null, context, i, file, file2) == null) {
            try {
                if (com.baidu.sofire.k.a.a(file)) {
                    if (!com.baidu.sofire.k.a.a(file2)) {
                        com.baidu.sofire.k.a.a(file, file2);
                    }
                    if (a.containsKey(file.getAbsolutePath())) {
                        return;
                    }
                    e eVar = new e(context, i, file.getAbsolutePath(), file2.getAbsolutePath());
                    eVar.startWatching();
                    a.put(file.getAbsolutePath(), eVar);
                }
            } catch (Throwable unused) {
                int i2 = b.a;
            }
        }
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, file) == null) || file == null) {
            return;
        }
        try {
            e eVar = a.get(file.getAbsolutePath());
            if (eVar != null) {
                eVar.stopWatching();
                a.remove(file.getAbsolutePath());
                eVar.a();
            }
        } catch (Throwable unused) {
            int i = b.a;
        }
    }
}
