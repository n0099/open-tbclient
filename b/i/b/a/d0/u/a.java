package b.i.b.a.d0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public abstract class a extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b j;
    public int[] k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.i.b.a.h0.e eVar, b.i.b.a.h0.g gVar, Format format, int i2, Object obj, long j, long j2, int i3) {
        super(eVar, gVar, format, i2, obj, j, j2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {eVar, gVar, format, Integer.valueOf(i2), obj, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b.i.b.a.h0.e) objArr2[0], (b.i.b.a.h0.g) objArr2[1], (Format) objArr2[2], ((Integer) objArr2[3]).intValue(), objArr2[4], ((Long) objArr2[5]).longValue(), ((Long) objArr2[6]).longValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.k[i2] : invokeI.intValue;
    }

    public final b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (b) invokeV.objValue;
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.j = bVar;
            this.k = bVar.b();
        }
    }
}
