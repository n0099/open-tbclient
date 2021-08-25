package c.a.o0.a.a2.n;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public abstract class f<T> implements c.a.o0.a.b1.b<byte[], T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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
    @Override // c.a.o0.a.b1.b
    /* renamed from: a */
    public final byte[] call(T t) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            if (t == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            c.a.o0.a.b1.d dVar = new c.a.o0.a.b1.d(byteArrayOutputStream);
            b(t, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            dVar.close();
            byteArrayOutputStream.close();
            return byteArray;
        }
        return (byte[]) invokeL.objValue;
    }

    public abstract void b(@NonNull T t, @NonNull c.a.o0.a.b1.d dVar) throws Exception;
}
