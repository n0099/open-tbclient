package c.a.a0.y;

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
    public static volatile e f1885b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, b> a;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (f1885b == null) {
                synchronized (e.class) {
                    if (f1885b == null) {
                        f1885b = new e();
                    }
                }
            }
            return f1885b;
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
            b bVar = (b) c.a.a0.x.c.b(this.a, str);
            if (bVar == null) {
                synchronized (e.class) {
                    bVar = (b) c.a.a0.x.c.b(this.a, str);
                    if (bVar == null) {
                        if (TextUtils.isEmpty(str)) {
                            bVar = d.a().a();
                        } else {
                            bVar = d.a().b(str);
                        }
                        c.a.a0.x.c.e(this.a, str, bVar);
                    }
                }
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }
}
