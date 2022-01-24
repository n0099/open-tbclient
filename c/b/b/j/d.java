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
    public final a f26973b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.b.j.f.a f26974c;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.q.o0.a f26975d;

    /* renamed from: e  reason: collision with root package name */
    public final long f26976e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f26977f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f26978g;

    /* renamed from: h  reason: collision with root package name */
    public volatile c.b.b.q.a<a> f26979h;

    /* renamed from: i  reason: collision with root package name */
    public volatile c.b.b.q.o0.b<Void> f26980i;

    /* renamed from: j  reason: collision with root package name */
    public volatile c.b.b.q.o0.b<Void> f26981j;
    public volatile Object k;
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
        this.f26973b = aVar;
        this.f26974c = aVar2;
        this.f26975d = aVar3;
        this.f26976e = eVar.q.d() == 3 ? m0.b() : 0L;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b.b.j.f.b bVar = (c.b.b.j.f.b) this.f26974c;
            if (!this.f26978g) {
                if (this.f26980i == null) {
                    this.f26980i = this.f26975d.a(this);
                } else if (this.f26980i.b()) {
                    try {
                        this.f26980i.a();
                        this.f26978g = true;
                        if (this.f26977f) {
                            e eVar = this.a;
                            a aVar = this.f26973b;
                            this.k = bVar.d(eVar, aVar.a, d(this.f26974c, aVar), this.f26973b.f26971c);
                        }
                    } catch (Exception e2) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.f26973b.a, e2);
                    }
                }
            } else if (this.f26981j == null && !this.f26977f) {
                this.f26981j = this.f26975d.a(this);
            } else if (this.f26977f) {
                e eVar2 = this.a;
                a aVar2 = this.f26973b;
                this.k = bVar.d(eVar2, aVar2.a, d(this.f26974c, aVar2), this.f26973b.f26971c);
            } else if (this.f26981j.b()) {
                try {
                    this.f26981j.a();
                    e eVar3 = this.a;
                    a aVar3 = this.f26973b;
                    this.k = bVar.d(eVar3, aVar3.a, d(this.f26974c, aVar3), this.f26973b.f26971c);
                } catch (Exception e3) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.f26973b.a, e3);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            n nVar = (n) this.f26974c;
            if (!this.f26978g) {
                this.f26978g = true;
                a aVar = this.f26973b;
                this.f26979h = nVar.a(aVar.a, d(this.f26974c, aVar), this.f26973b.f26971c);
                if (this.f26979h == null) {
                    e eVar = this.a;
                    a aVar2 = this.f26973b;
                    this.k = nVar.c(eVar, aVar2.a, d(this.f26974c, aVar2), this.f26973b.f26971c);
                    return;
                }
                c(this.f26979h);
                this.a.t(this.f26973b.a, this.f26979h);
                return;
            }
            e eVar2 = this.a;
            a aVar3 = this.f26973b;
            this.k = nVar.c(eVar2, aVar3.a, d(this.f26974c, aVar3), this.f26973b.f26971c);
        }
    }

    public final void c(c.b.b.q.a<a> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            boolean z = aVar.f27390g;
            aVar.f27390g = true;
            for (int i2 = 0; i2 < aVar.f27389f; i2++) {
                String str = aVar.get(i2).a;
                GenericDeclaration genericDeclaration = aVar.get(i2).f26970b;
                for (int i3 = aVar.f27389f - 1; i3 > i2; i3--) {
                    if (genericDeclaration == aVar.get(i3).f26970b && str.equals(aVar.get(i3).a)) {
                        aVar.h(i3);
                    }
                }
            }
            aVar.f27390g = z;
        }
    }

    public final c.b.b.m.a d(c.b.b.j.f.a aVar, a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, aVar, aVar2)) == null) {
            if (aVar2.f26972d == null) {
                aVar2.f26972d = aVar.b(aVar2.a);
            }
            return aVar2.f26972d;
        }
        return (c.b.b.m.a) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.b.b.j.f.a aVar = this.f26974c;
            if (aVar instanceof c.b.b.j.f.b) {
                e eVar = this.a;
                a aVar2 = this.f26973b;
                ((c.b.b.j.f.b) aVar).e(eVar, aVar2.a, d(aVar, aVar2), this.f26973b.f26971c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f26974c instanceof n) {
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
            c.b.b.j.f.b bVar = (c.b.b.j.f.b) this.f26974c;
            if (!this.f26978g) {
                a aVar = this.f26973b;
                this.f26979h = bVar.a(aVar.a, d(this.f26974c, aVar), this.f26973b.f26971c);
                if (this.f26979h != null) {
                    c(this.f26979h);
                    this.a.t(this.f26973b.a, this.f26979h);
                } else {
                    e eVar = this.a;
                    a aVar2 = this.f26973b;
                    bVar.c(eVar, aVar2.a, d(this.f26974c, aVar2), this.f26973b.f26971c);
                    this.f26977f = true;
                }
            } else {
                e eVar2 = this.a;
                a aVar3 = this.f26973b;
                bVar.c(eVar2, aVar3.a, d(this.f26974c, aVar3), this.f26973b.f26971c);
                this.f26977f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }
}
