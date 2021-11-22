package b.h.b.a.d0.u;

import b.h.b.a.d0.n;
import b.h.b.a.d0.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class b implements d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int[] f32862a;

    /* renamed from: b  reason: collision with root package name */
    public final n[] f32863b;

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
        this.f32862a = iArr;
        this.f32863b = nVarArr;
    }

    @Override // b.h.b.a.d0.u.d.b
    public b.h.b.a.a0.m a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(1048576, this, i2, i3)) != null) {
            return (b.h.b.a.a0.m) invokeII.objValue;
        }
        int i4 = 0;
        while (true) {
            int[] iArr = this.f32862a;
            if (i4 < iArr.length) {
                if (i3 == iArr[i4]) {
                    return this.f32863b[i4];
                }
                i4++;
            } else {
                String str = "Unmatched track of type: " + i3;
                return new b.h.b.a.a0.d();
            }
        }
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return (int[]) invokeV.objValue;
        }
        int[] iArr = new int[this.f32863b.length];
        int i2 = 0;
        while (true) {
            n[] nVarArr = this.f32863b;
            if (i2 >= nVarArr.length) {
                return iArr;
            }
            if (nVarArr[i2] != null) {
                iArr[i2] = nVarArr[i2].r();
            }
            i2++;
        }
    }

    public void c(long j) {
        n[] nVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            for (n nVar : this.f32863b) {
                if (nVar != null) {
                    nVar.D(j);
                }
            }
        }
    }
}
