package b.i.b.a.c0.f;

import b.i.b.a.c0.c;
import b.i.b.a.i0.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class a implements b.i.b.a.c0.a {
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

    @Override // b.i.b.a.c0.a
    public Metadata a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            ByteBuffer byteBuffer = cVar.f32901g;
            byte[] array = byteBuffer.array();
            int limit = byteBuffer.limit();
            l lVar = new l(array, limit);
            String r = lVar.r();
            String r2 = lVar.r();
            long z = lVar.z();
            lVar.K(4);
            return new Metadata(new EventMessage(r, r2, (lVar.z() * 1000) / z, lVar.z(), Arrays.copyOfRange(array, lVar.c(), limit)));
        }
        return (Metadata) invokeL.objValue;
    }
}
