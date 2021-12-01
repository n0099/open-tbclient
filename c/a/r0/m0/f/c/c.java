package c.a.r0.m0.f.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class c implements Comparator<c.b.a.a.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(c.b.a.a.d entity1, c.b.a.a.d entity2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entity1, entity2)) == null) {
            Intrinsics.checkNotNullParameter(entity1, "entity1");
            Intrinsics.checkNotNullParameter(entity2, "entity2");
            c.a.r0.m0.f.d.b b2 = c.a.r0.m0.g.d.b(entity2);
            c.a.r0.m0.e.a a = b2 == null ? null : b2.a();
            if (a == null) {
                return 0;
            }
            c.a.r0.m0.f.d.b b3 = c.a.r0.m0.g.d.b(entity1);
            c.a.r0.m0.e.a a2 = b3 != null ? b3.a() : null;
            if (a2 == null) {
                return 0;
            }
            return a2.compareTo(a);
        }
        return invokeLL.intValue;
    }
}
