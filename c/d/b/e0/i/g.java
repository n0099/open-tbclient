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
/* loaded from: classes7.dex */
public final class g implements t.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<t> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.b.e0.h.f f28165b;

    /* renamed from: c  reason: collision with root package name */
    public final c f28166c;

    /* renamed from: d  reason: collision with root package name */
    public final c.d.b.e0.h.c f28167d;

    /* renamed from: e  reason: collision with root package name */
    public final int f28168e;

    /* renamed from: f  reason: collision with root package name */
    public final z f28169f;

    /* renamed from: g  reason: collision with root package name */
    public final c.d.b.e f28170g;

    /* renamed from: h  reason: collision with root package name */
    public final p f28171h;

    /* renamed from: i  reason: collision with root package name */
    public final int f28172i;

    /* renamed from: j  reason: collision with root package name */
    public final int f28173j;

    /* renamed from: k  reason: collision with root package name */
    public final int f28174k;
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
        this.f28167d = cVar2;
        this.f28165b = fVar;
        this.f28166c = cVar;
        this.f28168e = i2;
        this.f28169f = zVar;
        this.f28170g = eVar;
        this.f28171h = pVar;
        this.f28172i = i3;
        this.f28173j = i4;
        this.f28174k = i5;
    }

    @Override // c.d.b.t.a
    public b0 a(z zVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zVar)) == null) ? d(zVar, this.f28165b, this.f28166c, this.f28167d) : (b0) invokeL.objValue;
    }

    public p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28171h : (p) invokeV.objValue;
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28166c : (c) invokeV.objValue;
    }

    public c.d.b.e call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28170g : (c.d.b.e) invokeV.objValue;
    }

    @Override // c.d.b.t.a
    public int connectTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28172i : invokeV.intValue;
    }

    @Override // c.d.b.t.a
    public c.d.b.i connection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28167d : (c.d.b.i) invokeV.objValue;
    }

    public b0 d(z zVar, c.d.b.e0.h.f fVar, c cVar, c.d.b.e0.h.c cVar2) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, zVar, fVar, cVar, cVar2)) == null) {
            if (this.f28168e < this.a.size()) {
                this.l++;
                if (this.f28166c != null && !this.f28167d.q(zVar.h())) {
                    throw new IllegalStateException("network interceptor " + this.a.get(this.f28168e - 1) + " must retain the same host and port");
                } else if (this.f28166c != null && this.l > 1) {
                    throw new IllegalStateException("network interceptor " + this.a.get(this.f28168e - 1) + " must call proceed() exactly once");
                } else {
                    g gVar = new g(this.a, fVar, cVar, cVar2, this.f28168e + 1, zVar, this.f28170g, this.f28171h, this.f28172i, this.f28173j, this.f28174k);
                    t tVar = this.a.get(this.f28168e);
                    b0 a = tVar.a(gVar);
                    if (cVar != null && this.f28168e + 1 < this.a.size() && gVar.l != 1) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28165b : (c.d.b.e0.h.f) invokeV.objValue;
    }

    @Override // c.d.b.t.a
    public int readTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28173j : invokeV.intValue;
    }

    @Override // c.d.b.t.a
    public z request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28169f : (z) invokeV.objValue;
    }

    @Override // c.d.b.t.a
    public int writeTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28174k : invokeV.intValue;
    }
}
