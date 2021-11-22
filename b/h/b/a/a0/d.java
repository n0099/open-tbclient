package b.h.b.a.a0;

import b.h.b.a.a0.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class d implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // b.h.b.a.a0.m
    public void a(b.h.b.a.i0.l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, lVar, i2) == null) {
            lVar.K(i2);
        }
    }

    @Override // b.h.b.a.a0.m
    public void b(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, format) == null) {
        }
    }

    @Override // b.h.b.a.a0.m
    public void c(long j, int i2, int i3, int i4, m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), aVar}) == null) {
        }
    }

    @Override // b.h.b.a.a0.m
    public int d(f fVar, int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int b2 = fVar.b(i2);
            if (b2 == -1) {
                if (z) {
                    return -1;
                }
                throw new EOFException();
            }
            return b2;
        }
        return invokeCommon.intValue;
    }
}
