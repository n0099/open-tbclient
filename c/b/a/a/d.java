package c.b.a.a;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.b.a.b.b<d> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.b.a.b.b<d> f26920b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26921c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26922d;

    /* renamed from: e  reason: collision with root package name */
    public ComponentOperationHandler f26923e;

    /* renamed from: f  reason: collision with root package name */
    public c.b.a.c.a<a> f26924f;

    /* renamed from: g  reason: collision with root package name */
    public c.b.b.q.a<a> f26925g;

    /* renamed from: h  reason: collision with root package name */
    public c.b.b.q.d f26926h;

    /* renamed from: i  reason: collision with root package name */
    public c.b.b.q.d f26927i;

    public d() {
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
        this.f26924f = new c.b.a.c.a<>();
        this.f26925g = new c.b.b.q.a<>(false, 16);
        this.f26926h = new c.b.b.q.d();
        this.f26927i = new c.b.b.q.d();
        this.a = new c.b.a.b.b<>();
        this.f26920b = new c.b.a.b.b<>();
    }

    public d a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (b(aVar)) {
                ComponentOperationHandler componentOperationHandler = this.f26923e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.a(this);
                } else {
                    g();
                }
            }
            return this;
        }
        return (d) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: c.b.a.a.d */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            Class<?> cls = aVar.getClass();
            a d2 = d(cls);
            if (aVar == d2) {
                return false;
            }
            if (d2 != null) {
                k(cls);
            }
            int d3 = b.d(cls);
            this.f26924f.d(d3, aVar);
            this.f26925g.a(aVar);
            this.f26926h.k(d3);
            return true;
        }
        return invokeL.booleanValue;
    }

    public <T extends a> T c(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            if (bVar.c() < this.f26924f.b()) {
                return (T) this.f26924f.a(bVar.c());
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public <T extends a> T d(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) ? (T) c(b.b(cls)) : (T) invokeL.objValue;
    }

    public c.b.b.q.d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26926h : (c.b.b.q.d) invokeV.objValue;
    }

    public c.b.b.q.d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26927i : (c.b.b.q.d) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.b(this);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26920b.b(this);
        }
    }

    public a i(Class<? extends a> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            a a = this.f26924f.a(b.b(cls).c());
            if (a != null && k(cls)) {
                ComponentOperationHandler componentOperationHandler = this.f26923e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.c(this);
                } else {
                    h();
                }
            }
            return a;
        }
        return (a) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: c.b.a.a.d */
    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048585, this) != null) {
            return;
        }
        while (true) {
            c.b.b.q.a<a> aVar = this.f26925g;
            if (aVar.f27389f <= 0) {
                return;
            }
            i(aVar.get(0).getClass());
        }
    }

    public boolean k(Class<? extends a> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) {
            int c2 = b.b(cls).c();
            a a = this.f26924f.a(c2);
            if (a != null) {
                this.f26924f.d(c2, null);
                this.f26925g.i(a, true);
                this.f26926h.c(c2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
