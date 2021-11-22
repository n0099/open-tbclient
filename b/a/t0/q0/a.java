package b.a.t0.q0;

import android.database.Cursor;
import b.a.t0.b0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f29755a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(855535774, "Lb/a/t0/q0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(855535774, "Lb/a/t0/q0/a;");
                return;
            }
        }
        f29755a = b0.m();
    }

    public static void a(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, cursor) == null) || cursor == null) {
            return;
        }
        try {
            if (cursor.isClosed()) {
                return;
            }
            cursor.close();
        } catch (Exception e2) {
            if (f29755a) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e2) {
            if (f29755a) {
                e2.printStackTrace();
            }
        }
    }
}
