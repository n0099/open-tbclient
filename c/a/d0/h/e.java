package c.a.d0.h;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final g f2722f;

    /* renamed from: g  reason: collision with root package name */
    public final i f2723g;

    /* renamed from: h  reason: collision with root package name */
    public final j f2724h;

    public e() {
        i iVar;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2722f = a.c().a();
        synchronized (a.class) {
            iVar = (i) ServiceManager.getService(i.f2726b);
            iVar = iVar == null ? i.f2727c : iVar;
        }
        this.f2723g = iVar;
        synchronized (a.class) {
            jVar = (j) ServiceManager.getService(j.f2728d);
            jVar = jVar == null ? j.f2729e : jVar;
        }
        this.f2724h = jVar;
    }

    @Override // c.a.d0.h.g
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2722f.a() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2722f.b() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2722f.c() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2722f.d() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2722f.e() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.i
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2723g.f() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2722f.g() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2722f.h() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2722f.i() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f2722f.j() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2722f.k() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f2722f.l() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f2722f.m() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.j
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f2724h.n() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    @NonNull
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f2722f.o() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f2722f.p() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String packageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f2722f.packageName() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f2722f.q() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.j
    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f2724h.r() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.j
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f2724h.s() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f2722f.t() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f2722f.u() : (String) invokeV.objValue;
    }

    @Override // c.a.d0.h.g
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f2722f.v() : invokeV.booleanValue;
    }
}
