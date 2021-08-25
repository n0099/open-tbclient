package c.a.x.b.g;

import android.opengl.EGLContext;
import androidx.core.view.InputDeviceCompat;
import c.a.x.b.f.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c implements Cloneable, Comparable<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EGLContext f31002e;

    /* renamed from: f  reason: collision with root package name */
    public d f31003f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.x.b.f.c f31004g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.x.b.f.a f31005h;

    /* renamed from: i  reason: collision with root package name */
    public a f31006i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f31007j;
    public c.a.x.b.e.c k;
    public b l;
    public int m;
    public boolean n;

    public c(EGLContext eGLContext, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31002e = eGLContext;
        this.m = i2;
        this.n = z;
        this.f31003f = new d();
        this.f31004g = new c.a.x.b.f.c();
        this.f31005h = new c.a.x.b.f.b();
        this.f31006i = new a();
        this.f31007j = false;
        this.k = null;
        this.l = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public c clone() {
        c cVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                cVar = (c) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                cVar = null;
            }
            if (cVar != null) {
                cVar.p(this.f31006i.clone());
                cVar.s(this.l.clone());
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) ? this.m < cVar.g() ? -1 : 1 : invokeL.intValue;
    }

    public a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31006i : (a) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public c.a.x.b.f.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31005h : (c.a.x.b.f.a) invokeV.objValue;
    }

    public EGLContext i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31002e : (EGLContext) invokeV.objValue;
    }

    public c.a.x.b.e.c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (c.a.x.b.e.c) invokeV.objValue;
    }

    public b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : (b) invokeV.objValue;
    }

    public c.a.x.b.f.c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f31004g : (c.a.x.b.f.c) invokeV.objValue;
    }

    public d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f31003f : (d) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f31007j : invokeV.booleanValue;
    }

    public void p(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.f31006i = aVar;
        }
    }

    public void q(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eGLContext) == null) {
            this.f31002e = eGLContext;
        }
    }

    public void r(c.a.x.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void s(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
            this.f31003f = dVar;
        }
    }
}
