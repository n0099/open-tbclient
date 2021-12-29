package c.i.b.a.d0.u;

import c.i.b.a.d0.n;
import c.i.b.a.d0.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class b implements d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] a;

    /* renamed from: b  reason: collision with root package name */
    public final n[] f30078b;

    public b(int[] iArr, n[] nVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, nVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iArr;
        this.f30078b = nVarArr;
    }

    @Override // c.i.b.a.d0.u.d.b
    public c.i.b.a.a0.m a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(1048576, this, i2, i3)) != null) {
            return (c.i.b.a.a0.m) invokeII.objValue;
        }
        int i4 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i4 < iArr.length) {
                if (i3 == iArr[i4]) {
                    return this.f30078b[i4];
                }
                i4++;
            } else {
                String str = "Unmatched track of type: " + i3;
                return new c.i.b.a.a0.d();
            }
        }
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return (int[]) invokeV.objValue;
        }
        int[] iArr = new int[this.f30078b.length];
        int i2 = 0;
        while (true) {
            n[] nVarArr = this.f30078b;
            if (i2 >= nVarArr.length) {
                return iArr;
            }
            if (nVarArr[i2] != null) {
                iArr[i2] = nVarArr[i2].r();
            }
            i2++;
        }
    }

    public void c(long j2) {
        n[] nVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            for (n nVar : this.f30078b) {
                if (nVar != null) {
                    nVar.D(j2);
                }
            }
        }
    }
}
