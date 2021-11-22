package b.h.b.a.e0.n;

import b.h.b.a.e0.e;
import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final b.h.b.a.e0.b[] f33233e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f33234f;

    public b(b.h.b.a.e0.b[] bVarArr, long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVarArr, jArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33233e = bVarArr;
        this.f33234f = jArr;
    }

    @Override // b.h.b.a.e0.e
    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            b.h.b.a.i0.a.a(i2 >= 0);
            b.h.b.a.i0.a.a(i2 < this.f33234f.length);
            return this.f33234f[i2];
        }
        return invokeI.longValue;
    }

    @Override // b.h.b.a.e0.e
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33234f.length : invokeV.intValue;
    }

    @Override // b.h.b.a.e0.e
    public int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            int b2 = v.b(this.f33234f, j, false, false);
            if (b2 < this.f33234f.length) {
                return b2;
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    @Override // b.h.b.a.e0.e
    public List<b.h.b.a.e0.b> d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            int e2 = v.e(this.f33234f, j, true, false);
            if (e2 != -1) {
                b.h.b.a.e0.b[] bVarArr = this.f33233e;
                if (bVarArr[e2] != null) {
                    return Collections.singletonList(bVarArr[e2]);
                }
            }
            return Collections.emptyList();
        }
        return (List) invokeJ.objValue;
    }
}
