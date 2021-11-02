package b.d.b.e0.i;

import androidx.core.view.InputDeviceCompat;
import b.d.b.b0;
import b.d.b.p;
import b.d.b.t;
import b.d.b.z;
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
    public final List<t> f30270a;

    /* renamed from: b  reason: collision with root package name */
    public final b.d.b.e0.h.f f30271b;

    /* renamed from: c  reason: collision with root package name */
    public final c f30272c;

    /* renamed from: d  reason: collision with root package name */
    public final b.d.b.e0.h.c f30273d;

    /* renamed from: e  reason: collision with root package name */
    public final int f30274e;

    /* renamed from: f  reason: collision with root package name */
    public final z f30275f;

    /* renamed from: g  reason: collision with root package name */
    public final b.d.b.e f30276g;

    /* renamed from: h  reason: collision with root package name */
    public final p f30277h;

    /* renamed from: i  reason: collision with root package name */
    public final int f30278i;
    public final int j;
    public final int k;
    public int l;

    public g(List<t> list, b.d.b.e0.h.f fVar, c cVar, b.d.b.e0.h.c cVar2, int i2, z zVar, b.d.b.e eVar, p pVar, int i3, int i4, int i5) {
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
        this.f30270a = list;
        this.f30273d = cVar2;
        this.f30271b = fVar;
        this.f30272c = cVar;
        this.f30274e = i2;
        this.f30275f = zVar;
        this.f30276g = eVar;
        this.f30277h = pVar;
        this.f30278i = i3;
        this.j = i4;
        this.k = i5;
    }

    @Override // b.d.b.t.a
    public b0 a(z zVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zVar)) == null) ? d(zVar, this.f30271b, this.f30272c, this.f30273d) : (b0) invokeL.objValue;
    }

    public p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30277h : (p) invokeV.objValue;
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30272c : (c) invokeV.objValue;
    }

    public b.d.b.e call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30276g : (b.d.b.e) invokeV.objValue;
    }

    @Override // b.d.b.t.a
    public int connectTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30278i : invokeV.intValue;
    }

    @Override // b.d.b.t.a
    public b.d.b.i connection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30273d : (b.d.b.i) invokeV.objValue;
    }

    public b0 d(z zVar, b.d.b.e0.h.f fVar, c cVar, b.d.b.e0.h.c cVar2) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, zVar, fVar, cVar, cVar2)) == null) {
            if (this.f30274e < this.f30270a.size()) {
                this.l++;
                if (this.f30272c != null && !this.f30273d.q(zVar.h())) {
                    throw new IllegalStateException("network interceptor " + this.f30270a.get(this.f30274e - 1) + " must retain the same host and port");
                } else if (this.f30272c != null && this.l > 1) {
                    throw new IllegalStateException("network interceptor " + this.f30270a.get(this.f30274e - 1) + " must call proceed() exactly once");
                } else {
                    g gVar = new g(this.f30270a, fVar, cVar, cVar2, this.f30274e + 1, zVar, this.f30276g, this.f30277h, this.f30278i, this.j, this.k);
                    t tVar = this.f30270a.get(this.f30274e);
                    b0 a2 = tVar.a(gVar);
                    if (cVar != null && this.f30274e + 1 < this.f30270a.size() && gVar.l != 1) {
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

    public b.d.b.e0.h.f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30271b : (b.d.b.e0.h.f) invokeV.objValue;
    }

    @Override // b.d.b.t.a
    public int readTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // b.d.b.t.a
    public z request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f30275f : (z) invokeV.objValue;
    }

    @Override // b.d.b.t.a
    public int writeTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.intValue;
    }
}
