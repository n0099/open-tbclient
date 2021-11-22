package b.l.a.g;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f34017a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(572687146, "Lb/l/a/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(572687146, "Lb/l/a/g/c;");
                return;
            }
        }
        f34017a = SetsKt__SetsKt.setOf((Object[]) new String[]{"M", "L", "H", "V", "C", "S", "Q", "R", "A", "Z", "m", "l", "h", "v", "c", "s", IAdRequestParam.COST_NAME, r.f41000a, "a", "z"});
    }
}
