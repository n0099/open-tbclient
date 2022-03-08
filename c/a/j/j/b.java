package c.a.j.j;

import androidx.core.view.InputDeviceCompat;
import c.a.j.h.b.i.c;
import c.a.j.j.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes.dex */
public final class b extends c.a.j.h.b.b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.j.h.b.d.a f3767d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.j.h.b.e.a f3768e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.j.h.b.h.a f3769f;

    /* renamed from: g  reason: collision with root package name */
    public final c f3770g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.j.h.b.f.b f3771h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.j.h.b.c.a f3772i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.j.h.b.g.a f3773j;
    public final c.a.j.j.e.a.a k;
    public final c.a.j.j.i.a l;

    public /* synthetic */ b(c.a.j.h.b.d.a aVar, c.a.j.h.b.e.a aVar2, c.a.j.h.b.h.a aVar3, c cVar, c.a.j.h.b.f.b bVar, c.a.j.h.b.c.a aVar4, c.a.j.h.b.g.a aVar5, c.a.j.j.e.a.a aVar6, c.a.j.j.i.a aVar7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, aVar2, aVar3, cVar, bVar, aVar4, aVar5, (i2 & 128) != 0 ? new c.a.j.j.e.a.b() : aVar6, (i2 & 256) != 0 ? new c.a.j.j.i.c() : aVar7);
    }

    @Override // c.a.j.h.b.a
    public c.a.j.h.b.g.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3773j : (c.a.j.h.b.g.a) invokeV.objValue;
    }

    @Override // c.a.j.h.b.a
    public c.a.j.h.b.h.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3769f : (c.a.j.h.b.h.a) invokeV.objValue;
    }

    @Override // c.a.j.h.b.a
    public c.a.j.h.b.c.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3772i : (c.a.j.h.b.c.a) invokeV.objValue;
    }

    @Override // c.a.j.j.d.a
    public c.a.j.j.e.a.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (c.a.j.j.e.a.a) invokeV.objValue;
    }

    @Override // c.a.j.h.b.a
    public c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3770g : (c) invokeV.objValue;
    }

    @Override // c.a.j.j.d.a
    public c.a.j.j.i.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (c.a.j.j.i.a) invokeV.objValue;
    }

    @Override // c.a.j.h.b.a
    public c.a.j.h.b.e.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3768e : (c.a.j.h.b.e.a) invokeV.objValue;
    }

    @Override // c.a.j.h.b.a
    public c.a.j.h.b.d.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3767d : (c.a.j.h.b.d.a) invokeV.objValue;
    }

    @Override // c.a.j.h.b.a
    public c.a.j.h.b.f.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f3771h : (c.a.j.h.b.f.b) invokeV.objValue;
    }

    public b(c.a.j.h.b.d.a aVar, c.a.j.h.b.e.a aVar2, c.a.j.h.b.h.a aVar3, c cVar, c.a.j.h.b.f.b bVar, c.a.j.h.b.c.a aVar4, c.a.j.h.b.g.a aVar5, c.a.j.j.e.a.a aVar6, c.a.j.j.i.a aVar7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, aVar3, cVar, bVar, aVar4, aVar5, aVar6, aVar7};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3767d = aVar;
        this.f3768e = aVar2;
        this.f3769f = aVar3;
        this.f3770g = cVar;
        this.f3771h = bVar;
        this.f3772i = aVar4;
        this.f3773j = aVar5;
        this.k = aVar6;
        this.l = aVar7;
    }
}
