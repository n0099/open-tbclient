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
/* loaded from: classes7.dex */
public class d implements c.b.b.q.o0.c<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public final a f27329b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.b.j.f.a f27330c;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.q.o0.a f27331d;

    /* renamed from: e  reason: collision with root package name */
    public final long f27332e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f27333f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f27334g;

    /* renamed from: h  reason: collision with root package name */
    public volatile c.b.b.q.a<a> f27335h;

    /* renamed from: i  reason: collision with root package name */
    public volatile c.b.b.q.o0.b<Void> f27336i;

    /* renamed from: j  reason: collision with root package name */
    public volatile c.b.b.q.o0.b<Void> f27337j;

    /* renamed from: k  reason: collision with root package name */
    public volatile Object f27338k;
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
        this.f27329b = aVar;
        this.f27330c = aVar2;
        this.f27331d = aVar3;
        this.f27332e = eVar.q.d() == 3 ? m0.b() : 0L;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b.b.j.f.b bVar = (c.b.b.j.f.b) this.f27330c;
            if (!this.f27334g) {
                if (this.f27336i == null) {
                    this.f27336i = this.f27331d.a(this);
                } else if (this.f27336i.b()) {
                    try {
                        this.f27336i.a();
                        this.f27334g = true;
                        if (this.f27333f) {
                            e eVar = this.a;
                            a aVar = this.f27329b;
                            this.f27338k = bVar.d(eVar, aVar.a, d(this.f27330c, aVar), this.f27329b.f27327c);
                        }
                    } catch (Exception e2) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.f27329b.a, e2);
                    }
                }
            } else if (this.f27337j == null && !this.f27333f) {
                this.f27337j = this.f27331d.a(this);
            } else if (this.f27333f) {
                e eVar2 = this.a;
                a aVar2 = this.f27329b;
                this.f27338k = bVar.d(eVar2, aVar2.a, d(this.f27330c, aVar2), this.f27329b.f27327c);
            } else if (this.f27337j.b()) {
                try {
                    this.f27337j.a();
                    e eVar3 = this.a;
                    a aVar3 = this.f27329b;
                    this.f27338k = bVar.d(eVar3, aVar3.a, d(this.f27330c, aVar3), this.f27329b.f27327c);
                } catch (Exception e3) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.f27329b.a, e3);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            n nVar = (n) this.f27330c;
            if (!this.f27334g) {
                this.f27334g = true;
                a aVar = this.f27329b;
                this.f27335h = nVar.a(aVar.a, d(this.f27330c, aVar), this.f27329b.f27327c);
                if (this.f27335h == null) {
                    e eVar = this.a;
                    a aVar2 = this.f27329b;
                    this.f27338k = nVar.c(eVar, aVar2.a, d(this.f27330c, aVar2), this.f27329b.f27327c);
                    return;
                }
                c(this.f27335h);
                this.a.t(this.f27329b.a, this.f27335h);
                return;
            }
            e eVar2 = this.a;
            a aVar3 = this.f27329b;
            this.f27338k = nVar.c(eVar2, aVar3.a, d(this.f27330c, aVar3), this.f27329b.f27327c);
        }
    }

    public final void c(c.b.b.q.a<a> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            boolean z = aVar.f27769g;
            aVar.f27769g = true;
            for (int i2 = 0; i2 < aVar.f27768f; i2++) {
                String str = aVar.get(i2).a;
                GenericDeclaration genericDeclaration = aVar.get(i2).f27326b;
                for (int i3 = aVar.f27768f - 1; i3 > i2; i3--) {
                    if (genericDeclaration == aVar.get(i3).f27326b && str.equals(aVar.get(i3).a)) {
                        aVar.h(i3);
                    }
                }
            }
            aVar.f27769g = z;
        }
    }

    public final c.b.b.m.a d(c.b.b.j.f.a aVar, a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, aVar, aVar2)) == null) {
            if (aVar2.f27328d == null) {
                aVar2.f27328d = aVar.b(aVar2.a);
            }
            return aVar2.f27328d;
        }
        return (c.b.b.m.a) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.b.b.j.f.a aVar = this.f27330c;
            if (aVar instanceof c.b.b.j.f.b) {
                e eVar = this.a;
                a aVar2 = this.f27329b;
                ((c.b.b.j.f.b) aVar).e(eVar, aVar2.a, d(aVar, aVar2), this.f27329b.f27327c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f27330c instanceof n) {
                b();
            } else {
                a();
            }
            return this.f27338k != null;
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
            c.b.b.j.f.b bVar = (c.b.b.j.f.b) this.f27330c;
            if (!this.f27334g) {
                a aVar = this.f27329b;
                this.f27335h = bVar.a(aVar.a, d(this.f27330c, aVar), this.f27329b.f27327c);
                if (this.f27335h != null) {
                    c(this.f27335h);
                    this.a.t(this.f27329b.a, this.f27335h);
                } else {
                    e eVar = this.a;
                    a aVar2 = this.f27329b;
                    bVar.c(eVar, aVar2.a, d(this.f27330c, aVar2), this.f27329b.f27327c);
                    this.f27333f = true;
                }
            } else {
                e eVar2 = this.a;
                a aVar3 = this.f27329b;
                bVar.c(eVar2, aVar3.a, d(this.f27330c, aVar3), this.f27329b.f27327c);
                this.f27333f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }
}
