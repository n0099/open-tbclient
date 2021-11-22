package b.c.b.e0.i;

import androidx.core.view.InputDeviceCompat;
import b.c.b.b0;
import b.c.b.p;
import b.c.b.t;
import b.c.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public final class g implements t.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<t> f31128a;

    /* renamed from: b  reason: collision with root package name */
    public final b.c.b.e0.h.f f31129b;

    /* renamed from: c  reason: collision with root package name */
    public final c f31130c;

    /* renamed from: d  reason: collision with root package name */
    public final b.c.b.e0.h.c f31131d;

    /* renamed from: e  reason: collision with root package name */
    public final int f31132e;

    /* renamed from: f  reason: collision with root package name */
    public final z f31133f;

    /* renamed from: g  reason: collision with root package name */
    public final b.c.b.e f31134g;

    /* renamed from: h  reason: collision with root package name */
    public final p f31135h;

    /* renamed from: i  reason: collision with root package name */
    public final int f31136i;
    public final int j;
    public final int k;
    public int l;

    public g(List<t> list, b.c.b.e0.h.f fVar, c cVar, b.c.b.e0.h.c cVar2, int i2, z zVar, b.c.b.e eVar, p pVar, int i3, int i4, int i5) {
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
        this.f31128a = list;
        this.f31131d = cVar2;
        this.f31129b = fVar;
        this.f31130c = cVar;
        this.f31132e = i2;
        this.f31133f = zVar;
        this.f31134g = eVar;
        this.f31135h = pVar;
        this.f31136i = i3;
        this.j = i4;
        this.k = i5;
    }

    @Override // b.c.b.t.a
    public b0 a(z zVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zVar)) == null) ? d(zVar, this.f31129b, this.f31130c, this.f31131d) : (b0) invokeL.objValue;
    }

    public p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31135h : (p) invokeV.objValue;
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31130c : (c) invokeV.objValue;
    }

    public b.c.b.e call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31134g : (b.c.b.e) invokeV.objValue;
    }

    @Override // b.c.b.t.a
    public int connectTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31136i : invokeV.intValue;
    }

    @Override // b.c.b.t.a
    public b.c.b.i connection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31131d : (b.c.b.i) invokeV.objValue;
    }

    public b0 d(z zVar, b.c.b.e0.h.f fVar, c cVar, b.c.b.e0.h.c cVar2) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, zVar, fVar, cVar, cVar2)) == null) {
            if (this.f31132e < this.f31128a.size()) {
                this.l++;
                if (this.f31130c != null && !this.f31131d.q(zVar.h())) {
                    throw new IllegalStateException("network interceptor " + this.f31128a.get(this.f31132e - 1) + " must retain the same host and port");
                } else if (this.f31130c != null && this.l > 1) {
                    throw new IllegalStateException("network interceptor " + this.f31128a.get(this.f31132e - 1) + " must call proceed() exactly once");
                } else {
                    g gVar = new g(this.f31128a, fVar, cVar, cVar2, this.f31132e + 1, zVar, this.f31134g, this.f31135h, this.f31136i, this.j, this.k);
                    t tVar = this.f31128a.get(this.f31132e);
                    b0 a2 = tVar.a(gVar);
                    if (cVar != null && this.f31132e + 1 < this.f31128a.size() && gVar.l != 1) {
                        throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
                    } else if (a2 != null) {
                        if (a2.a() != null) {
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

    public b.c.b.e0.h.f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31129b : (b.c.b.e0.h.f) invokeV.objValue;
    }

    @Override // b.c.b.t.a
    public int readTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // b.c.b.t.a
    public z request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f31133f : (z) invokeV.objValue;
    }

    @Override // b.c.b.t.a
    public int writeTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.intValue;
    }
}
