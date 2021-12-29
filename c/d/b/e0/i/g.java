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
/* loaded from: classes9.dex */
public final class g implements t.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<t> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.b.e0.h.f f28614b;

    /* renamed from: c  reason: collision with root package name */
    public final c f28615c;

    /* renamed from: d  reason: collision with root package name */
    public final c.d.b.e0.h.c f28616d;

    /* renamed from: e  reason: collision with root package name */
    public final int f28617e;

    /* renamed from: f  reason: collision with root package name */
    public final z f28618f;

    /* renamed from: g  reason: collision with root package name */
    public final c.d.b.e f28619g;

    /* renamed from: h  reason: collision with root package name */
    public final p f28620h;

    /* renamed from: i  reason: collision with root package name */
    public final int f28621i;

    /* renamed from: j  reason: collision with root package name */
    public final int f28622j;

    /* renamed from: k  reason: collision with root package name */
    public final int f28623k;
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
        this.a = list;
        this.f28616d = cVar2;
        this.f28614b = fVar;
        this.f28615c = cVar;
        this.f28617e = i2;
        this.f28618f = zVar;
        this.f28619g = eVar;
        this.f28620h = pVar;
        this.f28621i = i3;
        this.f28622j = i4;
        this.f28623k = i5;
    }

    @Override // c.d.b.t.a
    public b0 a(z zVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zVar)) == null) ? d(zVar, this.f28614b, this.f28615c, this.f28616d) : (b0) invokeL.objValue;
    }

    public p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28620h : (p) invokeV.objValue;
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28615c : (c) invokeV.objValue;
    }

    public c.d.b.e call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28619g : (c.d.b.e) invokeV.objValue;
    }

    @Override // c.d.b.t.a
    public int connectTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28621i : invokeV.intValue;
    }

    @Override // c.d.b.t.a
    public c.d.b.i connection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28616d : (c.d.b.i) invokeV.objValue;
    }

    public b0 d(z zVar, c.d.b.e0.h.f fVar, c cVar, c.d.b.e0.h.c cVar2) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, zVar, fVar, cVar, cVar2)) == null) {
            if (this.f28617e < this.a.size()) {
                this.l++;
                if (this.f28615c != null && !this.f28616d.q(zVar.h())) {
                    throw new IllegalStateException("network interceptor " + this.a.get(this.f28617e - 1) + " must retain the same host and port");
                } else if (this.f28615c != null && this.l > 1) {
                    throw new IllegalStateException("network interceptor " + this.a.get(this.f28617e - 1) + " must call proceed() exactly once");
                } else {
                    g gVar = new g(this.a, fVar, cVar, cVar2, this.f28617e + 1, zVar, this.f28619g, this.f28620h, this.f28621i, this.f28622j, this.f28623k);
                    t tVar = this.a.get(this.f28617e);
                    b0 a = tVar.a(gVar);
                    if (cVar != null && this.f28617e + 1 < this.a.size() && gVar.l != 1) {
                        throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
                    } else if (a != null) {
                        if (a.a() != null) {
                            return a;
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

    public c.d.b.e0.h.f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28614b : (c.d.b.e0.h.f) invokeV.objValue;
    }

    @Override // c.d.b.t.a
    public int readTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28622j : invokeV.intValue;
    }

    @Override // c.d.b.t.a
    public z request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28618f : (z) invokeV.objValue;
    }

    @Override // c.d.b.t.a
    public int writeTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28623k : invokeV.intValue;
    }
}
