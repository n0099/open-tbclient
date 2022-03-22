package c.b.b.j;

import c.b.b.j.f.n;
import c.b.b.q.m0;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.GenericDeclaration;
/* loaded from: classes3.dex */
public class d implements c.b.b.q.o0.c<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public final a f22340b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.b.j.f.a f22341c;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.q.o0.a f22342d;

    /* renamed from: e  reason: collision with root package name */
    public final long f22343e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f22344f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f22345g;

    /* renamed from: h  reason: collision with root package name */
    public volatile c.b.b.q.a<a> f22346h;
    public volatile c.b.b.q.o0.b<Void> i;
    public volatile c.b.b.q.o0.b<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public d(e eVar, a aVar, c.b.b.j.f.a aVar2, c.b.b.q.o0.a aVar3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, aVar, aVar2, aVar3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eVar;
        this.f22340b = aVar;
        this.f22341c = aVar2;
        this.f22342d = aVar3;
        this.f22343e = eVar.m.d() == 3 ? m0.b() : 0L;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b.b.j.f.b bVar = (c.b.b.j.f.b) this.f22341c;
            if (!this.f22345g) {
                if (this.i == null) {
                    this.i = this.f22342d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.f22345g = true;
                        if (this.f22344f) {
                            e eVar = this.a;
                            a aVar = this.f22340b;
                            this.k = bVar.d(eVar, aVar.a, d(this.f22341c, aVar), this.f22340b.f22338c);
                        }
                    } catch (Exception e2) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.f22340b.a, e2);
                    }
                }
            } else if (this.j == null && !this.f22344f) {
                this.j = this.f22342d.a(this);
            } else if (this.f22344f) {
                e eVar2 = this.a;
                a aVar2 = this.f22340b;
                this.k = bVar.d(eVar2, aVar2.a, d(this.f22341c, aVar2), this.f22340b.f22338c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    e eVar3 = this.a;
                    a aVar3 = this.f22340b;
                    this.k = bVar.d(eVar3, aVar3.a, d(this.f22341c, aVar3), this.f22340b.f22338c);
                } catch (Exception e3) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.f22340b.a, e3);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            n nVar = (n) this.f22341c;
            if (!this.f22345g) {
                this.f22345g = true;
                a aVar = this.f22340b;
                this.f22346h = nVar.a(aVar.a, d(this.f22341c, aVar), this.f22340b.f22338c);
                if (this.f22346h == null) {
                    e eVar = this.a;
                    a aVar2 = this.f22340b;
                    this.k = nVar.c(eVar, aVar2.a, d(this.f22341c, aVar2), this.f22340b.f22338c);
                    return;
                }
                c(this.f22346h);
                this.a.t(this.f22340b.a, this.f22346h);
                return;
            }
            e eVar2 = this.a;
            a aVar3 = this.f22340b;
            this.k = nVar.c(eVar2, aVar3.a, d(this.f22341c, aVar3), this.f22340b.f22338c);
        }
    }

    public final void c(c.b.b.q.a<a> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            boolean z = aVar.f22718c;
            aVar.f22718c = true;
            for (int i = 0; i < aVar.f22717b; i++) {
                String str = aVar.get(i).a;
                GenericDeclaration genericDeclaration = aVar.get(i).f22337b;
                for (int i2 = aVar.f22717b - 1; i2 > i; i2--) {
                    if (genericDeclaration == aVar.get(i2).f22337b && str.equals(aVar.get(i2).a)) {
                        aVar.i(i2);
                    }
                }
            }
            aVar.f22718c = z;
        }
    }

    public final c.b.b.m.a d(c.b.b.j.f.a aVar, a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, aVar, aVar2)) == null) {
            if (aVar2.f22339d == null) {
                aVar2.f22339d = aVar.b(aVar2.a);
            }
            return aVar2.f22339d;
        }
        return (c.b.b.m.a) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.b.b.j.f.a aVar = this.f22341c;
            if (aVar instanceof c.b.b.j.f.b) {
                e eVar = this.a;
                a aVar2 = this.f22340b;
                ((c.b.b.j.f.b) aVar).e(eVar, aVar2.a, d(aVar, aVar2), this.f22340b.f22338c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f22341c instanceof n) {
                b();
            } else {
                a();
            }
            return this.k != null;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.q.o0.c
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            c.b.b.j.f.b bVar = (c.b.b.j.f.b) this.f22341c;
            if (!this.f22345g) {
                a aVar = this.f22340b;
                this.f22346h = bVar.a(aVar.a, d(this.f22341c, aVar), this.f22340b.f22338c);
                if (this.f22346h != null) {
                    c(this.f22346h);
                    this.a.t(this.f22340b.a, this.f22346h);
                } else {
                    e eVar = this.a;
                    a aVar2 = this.f22340b;
                    bVar.c(eVar, aVar2.a, d(this.f22341c, aVar2), this.f22340b.f22338c);
                    this.f22344f = true;
                }
            } else {
                e eVar2 = this.a;
                a aVar3 = this.f22340b;
                bVar.c(eVar2, aVar3.a, d(this.f22341c, aVar3), this.f22340b.f22338c);
                this.f22344f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }
}
