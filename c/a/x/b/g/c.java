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
/* loaded from: classes7.dex */
public class c implements Cloneable, Comparable<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EGLContext f26749e;

    /* renamed from: f  reason: collision with root package name */
    public d f26750f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.x.b.f.c f26751g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.x.b.f.a f26752h;

    /* renamed from: i  reason: collision with root package name */
    public a f26753i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f26754j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.x.b.e.c f26755k;
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
        this.f26749e = eGLContext;
        this.m = i2;
        this.n = z;
        this.f26750f = new d();
        this.f26751g = new c.a.x.b.f.c();
        this.f26752h = new c.a.x.b.f.b();
        this.f26753i = new a();
        this.f26754j = false;
        this.f26755k = null;
        this.l = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public c clone() {
        c cVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                cVar = (c) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                cVar = null;
            }
            if (cVar != null) {
                cVar.n(this.f26753i.clone());
                cVar.q(this.l.clone());
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? this.m < cVar.e() ? -1 : 1 : invokeL.intValue;
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26753i : (a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public c.a.x.b.f.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26752h : (c.a.x.b.f.a) invokeV.objValue;
    }

    public EGLContext g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f26749e : (EGLContext) invokeV.objValue;
    }

    public c.a.x.b.e.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f26755k : (c.a.x.b.e.c) invokeV.objValue;
    }

    public b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : (b) invokeV.objValue;
    }

    public c.a.x.b.f.c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f26751g : (c.a.x.b.f.c) invokeV.objValue;
    }

    public d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f26750f : (d) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f26754j : invokeV.booleanValue;
    }

    public void n(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.f26753i = aVar;
        }
    }

    public void o(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eGLContext) == null) {
            this.f26749e = eGLContext;
        }
    }

    public void p(c.a.x.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f26755k = cVar;
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void r(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
            this.f26750f = dVar;
        }
    }
}
