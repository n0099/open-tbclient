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
/* loaded from: classes9.dex */
public class d implements c.b.b.q.o0.c<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public final a f27704b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.b.j.f.a f27705c;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.q.o0.a f27706d;

    /* renamed from: e  reason: collision with root package name */
    public final long f27707e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f27708f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f27709g;

    /* renamed from: h  reason: collision with root package name */
    public volatile c.b.b.q.a<a> f27710h;

    /* renamed from: i  reason: collision with root package name */
    public volatile c.b.b.q.o0.b<Void> f27711i;

    /* renamed from: j  reason: collision with root package name */
    public volatile c.b.b.q.o0.b<Void> f27712j;

    /* renamed from: k  reason: collision with root package name */
    public volatile Object f27713k;
    public volatile boolean l;

    public d(e eVar, a aVar, c.b.b.j.f.a aVar2, c.b.b.q.o0.a aVar3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, aVar, aVar2, aVar3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eVar;
        this.f27704b = aVar;
        this.f27705c = aVar2;
        this.f27706d = aVar3;
        this.f27707e = eVar.q.d() == 3 ? m0.b() : 0L;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b.b.j.f.b bVar = (c.b.b.j.f.b) this.f27705c;
            if (!this.f27709g) {
                if (this.f27711i == null) {
                    this.f27711i = this.f27706d.a(this);
                } else if (this.f27711i.b()) {
                    try {
                        this.f27711i.a();
                        this.f27709g = true;
                        if (this.f27708f) {
                            e eVar = this.a;
                            a aVar = this.f27704b;
                            this.f27713k = bVar.d(eVar, aVar.a, d(this.f27705c, aVar), this.f27704b.f27702c);
                        }
                    } catch (Exception e2) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.f27704b.a, e2);
                    }
                }
            } else if (this.f27712j == null && !this.f27708f) {
                this.f27712j = this.f27706d.a(this);
            } else if (this.f27708f) {
                e eVar2 = this.a;
                a aVar2 = this.f27704b;
                this.f27713k = bVar.d(eVar2, aVar2.a, d(this.f27705c, aVar2), this.f27704b.f27702c);
            } else if (this.f27712j.b()) {
                try {
                    this.f27712j.a();
                    e eVar3 = this.a;
                    a aVar3 = this.f27704b;
                    this.f27713k = bVar.d(eVar3, aVar3.a, d(this.f27705c, aVar3), this.f27704b.f27702c);
                } catch (Exception e3) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.f27704b.a, e3);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            n nVar = (n) this.f27705c;
            if (!this.f27709g) {
                this.f27709g = true;
                a aVar = this.f27704b;
                this.f27710h = nVar.a(aVar.a, d(this.f27705c, aVar), this.f27704b.f27702c);
                if (this.f27710h == null) {
                    e eVar = this.a;
                    a aVar2 = this.f27704b;
                    this.f27713k = nVar.c(eVar, aVar2.a, d(this.f27705c, aVar2), this.f27704b.f27702c);
                    return;
                }
                c(this.f27710h);
                this.a.t(this.f27704b.a, this.f27710h);
                return;
            }
            e eVar2 = this.a;
            a aVar3 = this.f27704b;
            this.f27713k = nVar.c(eVar2, aVar3.a, d(this.f27705c, aVar3), this.f27704b.f27702c);
        }
    }

    public final void c(c.b.b.q.a<a> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            boolean z = aVar.f28144g;
            aVar.f28144g = true;
            for (int i2 = 0; i2 < aVar.f28143f; i2++) {
                String str = aVar.get(i2).a;
                GenericDeclaration genericDeclaration = aVar.get(i2).f27701b;
                for (int i3 = aVar.f28143f - 1; i3 > i2; i3--) {
                    if (genericDeclaration == aVar.get(i3).f27701b && str.equals(aVar.get(i3).a)) {
                        aVar.h(i3);
                    }
                }
            }
            aVar.f28144g = z;
        }
    }

    public final c.b.b.m.a d(c.b.b.j.f.a aVar, a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, aVar, aVar2)) == null) {
            if (aVar2.f27703d == null) {
                aVar2.f27703d = aVar.b(aVar2.a);
            }
            return aVar2.f27703d;
        }
        return (c.b.b.m.a) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.b.b.j.f.a aVar = this.f27705c;
            if (aVar instanceof c.b.b.j.f.b) {
                e eVar = this.a;
                a aVar2 = this.f27704b;
                ((c.b.b.j.f.b) aVar).e(eVar, aVar2.a, d(aVar, aVar2), this.f27704b.f27702c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f27705c instanceof n) {
                b();
            } else {
                a();
            }
            return this.f27713k != null;
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
            c.b.b.j.f.b bVar = (c.b.b.j.f.b) this.f27705c;
            if (!this.f27709g) {
                a aVar = this.f27704b;
                this.f27710h = bVar.a(aVar.a, d(this.f27705c, aVar), this.f27704b.f27702c);
                if (this.f27710h != null) {
                    c(this.f27710h);
                    this.a.t(this.f27704b.a, this.f27710h);
                } else {
                    e eVar = this.a;
                    a aVar2 = this.f27704b;
                    bVar.c(eVar, aVar2.a, d(this.f27705c, aVar2), this.f27704b.f27702c);
                    this.f27708f = true;
                }
            } else {
                e eVar2 = this.a;
                a aVar3 = this.f27704b;
                bVar.c(eVar2, aVar3.a, d(this.f27705c, aVar3), this.f27704b.f27702c);
                this.f27708f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }
}
