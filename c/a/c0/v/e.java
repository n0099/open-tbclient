package c.a.c0.v;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f2133b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, b> a;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f2133b == null) {
                synchronized (c.a.c0.a0.g.a.class) {
                    if (f2133b == null) {
                        f2133b = new e();
                    }
                }
            }
            return f2133b;
        }
        return (e) invokeV.objValue;
    }

    @NonNull
    public b b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            b bVar = (b) c.a.c0.u.c.b(this.a, str);
            if (bVar == null) {
                synchronized (e.class) {
                    bVar = (b) c.a.c0.u.c.b(this.a, str);
                    if (bVar == null) {
                        if (TextUtils.isEmpty(str)) {
                            bVar = d.a().a();
                        } else {
                            bVar = d.a().b(str);
                        }
                        c.a.c0.u.c.e(this.a, str, bVar);
                    }
                }
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }
}
