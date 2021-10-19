package c.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f31742a = new a();

    /* loaded from: classes4.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // c.d.b.b
        public z a(@Nullable d0 d0Var, b0 b0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d0Var, b0Var)) == null) {
                return null;
            }
            return (z) invokeLL.objValue;
        }
    }

    @Nullable
    z a(@Nullable d0 d0Var, b0 b0Var) throws IOException;
}
