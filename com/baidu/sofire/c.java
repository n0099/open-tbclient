package com.baidu.sofire;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, d> f45317a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1932882311, "Lcom/baidu/sofire/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1932882311, "Lcom/baidu/sofire/c;");
                return;
            }
        }
        f45317a = new HashMap();
    }

    public static void a(Context context, int i2, File file, File file2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65537, null, context, i2, file, file2) == null) || file == null) {
            return;
        }
        try {
            if (com.baidu.sofire.utility.c.a(file)) {
                if (!com.baidu.sofire.utility.c.a(file2)) {
                    com.baidu.sofire.utility.c.a(file, file2);
                }
                if (f45317a.containsKey(file.getAbsolutePath())) {
                    return;
                }
                d dVar = new d(context, i2, file.getAbsolutePath(), file2.getAbsolutePath());
                dVar.startWatching();
                f45317a.put(file.getAbsolutePath(), dVar);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, file) == null) || file == null) {
            return;
        }
        try {
            d dVar = f45317a.get(file.getAbsolutePath());
            if (dVar != null) {
                dVar.stopWatching();
                f45317a.remove(file.getAbsolutePath());
                dVar.a();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }
}
