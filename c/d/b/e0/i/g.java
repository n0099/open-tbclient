package c.d.b.e0.i;

import androidx.core.view.InputDeviceCompat;
import c.d.b.b0;
import c.d.b.p;
import c.d.b.t;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public final class g implements t.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<t> f31621a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.b.e0.h.f f31622b;

    /* renamed from: c  reason: collision with root package name */
    public final c f31623c;

    /* renamed from: d  reason: collision with root package name */
    public final c.d.b.e0.h.c f31624d;

    /* renamed from: e  reason: collision with root package name */
    public final int f31625e;

    /* renamed from: f  reason: collision with root package name */
    public final z f31626f;

    /* renamed from: g  reason: collision with root package name */
    public final c.d.b.e f31627g;

    /* renamed from: h  reason: collision with root package name */
    public final p f31628h;

    /* renamed from: i  reason: collision with root package name */
    public final int f31629i;

    /* renamed from: j  reason: collision with root package name */
    public final int f31630j;
    public final int k;
    public int l;

    public g(List<t> list, c.d.b.e0.h.f fVar, c cVar, c.d.b.e0.h.c cVar2, int i2, z zVar, c.d.b.e eVar, p pVar, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {list, fVar, cVar, cVar2, Integer.valueOf(i2), zVar, eVar, pVar, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31621a = list;
        this.f31624d = cVar2;
        this.f31622b = fVar;
        this.f31623c = cVar;
        this.f31625e = i2;
        this.f31626f = zVar;
        this.f31627g = eVar;
        this.f31628h = pVar;
        this.f31629i = i3;
        this.f31630j = i4;
        this.k = i5;
    }

    @Override // c.d.b.t.a
    public b0 a(z zVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zVar)) == null) ? e(zVar, this.f31622b, this.f31623c, this.f31624d) : (b0) invokeL.objValue;
    }

    public c.d.b.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31627g : (c.d.b.e) invokeV.objValue;
    }

    public p c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31628h : (p) invokeV.objValue;
    }

    @Override // c.d.b.t.a
    public int connectTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31629i : invokeV.intValue;
    }

    @Override // c.d.b.t.a
    public c.d.b.i connection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31624d : (c.d.b.i) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31623c : (c) invokeV.objValue;
    }

    public b0 e(z zVar, c.d.b.e0.h.f fVar, c cVar, c.d.b.e0.h.c cVar2) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, zVar, fVar, cVar, cVar2)) == null) {
            if (this.f31625e < this.f31621a.size()) {
                this.l++;
                if (this.f31623c != null && !this.f31624d.q(zVar.h())) {
                    throw new IllegalStateException("network interceptor " + this.f31621a.get(this.f31625e - 1) + " must retain the same host and port");
                } else if (this.f31623c != null && this.l > 1) {
                    throw new IllegalStateException("network interceptor " + this.f31621a.get(this.f31625e - 1) + " must call proceed() exactly once");
                } else {
                    g gVar = new g(this.f31621a, fVar, cVar, cVar2, this.f31625e + 1, zVar, this.f31627g, this.f31628h, this.f31629i, this.f31630j, this.k);
                    t tVar = this.f31621a.get(this.f31625e);
                    b0 a2 = tVar.a(gVar);
                    if (cVar != null && this.f31625e + 1 < this.f31621a.size() && gVar.l != 1) {
                        throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
                    } else if (a2 != null) {
                        if (a2.g() != null) {
                            return a2;
                        }
                        throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
                    } else {
                        throw new NullPointerException("interceptor " + tVar + " returned null");
                    }
                }
            }
            throw new AssertionError();
        }
        return (b0) invokeLLLL.objValue;
    }

    public c.d.b.e0.h.f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31622b : (c.d.b.e0.h.f) invokeV.objValue;
    }

    @Override // c.d.b.t.a
    public int readTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31630j : invokeV.intValue;
    }

    @Override // c.d.b.t.a
    public z request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f31626f : (z) invokeV.objValue;
    }

    @Override // c.d.b.t.a
    public int writeTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.intValue;
    }
}
