package c.i.b.a.a0;

import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class a implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f32219a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f32220b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f32221c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f32222d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f32223e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32224f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, jArr, jArr2, jArr3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32220b = iArr;
        this.f32221c = jArr;
        this.f32222d = jArr2;
        this.f32223e = jArr3;
        int length = iArr.length;
        this.f32219a = length;
        if (length > 0) {
            this.f32224f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f32224f = 0L;
        }
    }

    public int a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? v.e(this.f32223e, j2, true, true) : invokeJ.intValue;
    }

    @Override // c.i.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.i.b.a.a0.l
    public long c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? this.f32221c[a(j2)] : invokeJ.longValue;
    }

    @Override // c.i.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32224f : invokeV.longValue;
    }
}
