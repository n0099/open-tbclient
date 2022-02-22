package c.a.d0.y;

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
    public static volatile e f3445b;
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
            if (f3445b == null) {
                synchronized (e.class) {
                    if (f3445b == null) {
                        f3445b = new e();
                    }
                }
            }
            return f3445b;
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
            b bVar = (b) c.a.d0.x.c.b(this.a, str);
            if (bVar == null) {
                synchronized (e.class) {
                    bVar = (b) c.a.d0.x.c.b(this.a, str);
                    if (bVar == null) {
                        if (TextUtils.isEmpty(str)) {
                            bVar = d.a().a();
                        } else {
                            bVar = d.a().b(str);
                        }
                        c.a.d0.x.c.e(this.a, str, bVar);
                    }
                }
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }
}
