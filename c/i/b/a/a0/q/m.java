package c.i.b.a.a0.q;

import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f32671a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f32672b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f32673c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32674d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f32675e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f32676f;

    public m(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr, iArr, Integer.valueOf(i2), jArr2, iArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.a.a(iArr.length == jArr2.length);
        c.i.b.a.i0.a.a(jArr.length == jArr2.length);
        c.i.b.a.i0.a.a(iArr2.length == jArr2.length);
        this.f32672b = jArr;
        this.f32673c = iArr;
        this.f32674d = i2;
        this.f32675e = jArr2;
        this.f32676f = iArr2;
        this.f32671a = jArr.length;
    }

    public int a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            for (int e2 = v.e(this.f32675e, j2, true, false); e2 >= 0; e2--) {
                if ((this.f32676f[e2] & 1) != 0) {
                    return e2;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public int b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            for (int b2 = v.b(this.f32675e, j2, true, false); b2 < this.f32675e.length; b2++) {
                if ((this.f32676f[b2] & 1) != 0) {
                    return b2;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }
}
