package b.h.b.a.a0;

import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class a implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f32198a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f32199b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f32200c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f32201d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f32202e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32203f;

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
        this.f32199b = iArr;
        this.f32200c = jArr;
        this.f32201d = jArr2;
        this.f32202e = jArr3;
        int length = iArr.length;
        this.f32198a = length;
        if (length > 0) {
            this.f32203f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f32203f = 0L;
        }
    }

    public int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? v.e(this.f32202e, j, true, true) : invokeJ.intValue;
    }

    @Override // b.h.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.h.b.a.a0.l
    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? this.f32200c[a(j)] : invokeJ.longValue;
    }

    @Override // b.h.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32203f : invokeV.longValue;
    }
}
