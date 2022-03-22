package c.a.p0.n0.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public interface b {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static float a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bVar)) == null) {
                Intrinsics.checkNotNullParameter(bVar, "this");
                return 1 / (bVar.b() - 0.6f);
            }
            return invokeL.floatValue;
        }
    }

    int a();

    float b();

    int c();

    float d();

    float e();

    int getHeight();

    int getWidth();

    void setHeight(int i);

    void setWidth(int i);
}
