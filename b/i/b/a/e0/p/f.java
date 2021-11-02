package b.i.b.a.e0.p;

import b.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class f implements b.i.b.a.e0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final b f32406e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f32407f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, e> f32408g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, c> f32409h;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, map, map2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32406e = bVar;
        this.f32409h = map2;
        this.f32408g = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f32407f = bVar.j();
    }

    @Override // b.i.b.a.e0.e
    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f32407f[i2] : invokeI.longValue;
    }

    @Override // b.i.b.a.e0.e
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32407f.length : invokeV.intValue;
    }

    @Override // b.i.b.a.e0.e
    public int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            int b2 = v.b(this.f32407f, j, false, false);
            if (b2 < this.f32407f.length) {
                return b2;
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    @Override // b.i.b.a.e0.e
    public List<b.i.b.a.e0.b> d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.f32406e.h(j, this.f32408g, this.f32409h) : (List) invokeJ.objValue;
    }
}
