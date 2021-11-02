package b.a.p0.a.a2.n;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
/* loaded from: classes.dex */
public abstract class e<T> implements b.a.p0.a.b1.b<T, byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    public abstract T a(@NonNull b.a.p0.a.b1.c cVar) throws Exception;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.b1.b
    public final T call(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            b.a.p0.a.b1.c cVar = new b.a.p0.a.b1.c(byteArrayInputStream);
            T a2 = a(cVar);
            cVar.close();
            byteArrayInputStream.close();
            return a2;
        }
        return (T) invokeL.objValue;
    }
}
