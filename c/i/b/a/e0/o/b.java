package c.i.b.a.e0.o;

import c.i.b.a.e0.e;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class b implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.i.b.a.e0.b[] f33568e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f33569f;

    public b(c.i.b.a.e0.b[] bVarArr, long[] jArr) {
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
        this.f33568e = bVarArr;
        this.f33569f = jArr;
    }

    @Override // c.i.b.a.e0.e
    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            c.i.b.a.i0.a.a(i2 >= 0);
            c.i.b.a.i0.a.a(i2 < this.f33569f.length);
            return this.f33569f[i2];
        }
        return invokeI.longValue;
    }

    @Override // c.i.b.a.e0.e
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33569f.length : invokeV.intValue;
    }

    @Override // c.i.b.a.e0.e
    public int c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            int b2 = v.b(this.f33569f, j2, false, false);
            if (b2 < this.f33569f.length) {
                return b2;
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    @Override // c.i.b.a.e0.e
    public List<c.i.b.a.e0.b> d(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
            int e2 = v.e(this.f33569f, j2, true, false);
            if (e2 != -1) {
                c.i.b.a.e0.b[] bVarArr = this.f33568e;
                if (bVarArr[e2] != null) {
                    return Collections.singletonList(bVarArr[e2]);
                }
            }
            return Collections.emptyList();
        }
        return (List) invokeJ.objValue;
    }
}
