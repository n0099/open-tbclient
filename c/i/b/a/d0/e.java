package c.i.b.a.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class e implements p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final p[] f33046e;

    public e(p[] pVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33046e = pVarArr;
    }

    @Override // c.i.b.a.d0.p
    public final boolean b(long j2) {
        InterceptResult invokeJ;
        p[] pVarArr;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            boolean z2 = false;
            do {
                long d2 = d();
                if (d2 == Long.MIN_VALUE) {
                    break;
                }
                z = false;
                for (p pVar : this.f33046e) {
                    long d3 = pVar.d();
                    boolean z3 = d3 != Long.MIN_VALUE && d3 <= j2;
                    if (d3 == d2 || z3) {
                        z |= pVar.b(j2);
                    }
                }
                z2 |= z;
            } while (z);
            return z2;
        }
        return invokeJ.booleanValue;
    }

    @Override // c.i.b.a.d0.p
    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = Long.MAX_VALUE;
            for (p pVar : this.f33046e) {
                long c2 = pVar.c();
                if (c2 != Long.MIN_VALUE) {
                    j2 = Math.min(j2, c2);
                }
            }
            if (j2 == Long.MAX_VALUE) {
                return Long.MIN_VALUE;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.d0.p
    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j2 = Long.MAX_VALUE;
            for (p pVar : this.f33046e) {
                long d2 = pVar.d();
                if (d2 != Long.MIN_VALUE) {
                    j2 = Math.min(j2, d2);
                }
            }
            if (j2 == Long.MAX_VALUE) {
                return Long.MIN_VALUE;
            }
            return j2;
        }
        return invokeV.longValue;
    }
}
