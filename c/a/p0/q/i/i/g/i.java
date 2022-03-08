package c.a.p0.q.i.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class i implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.p0.q.i.i.b> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.q.e.f f11000b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.p0.q.h.f> f11001c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.p0.q.h.f> f11002d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.p0.q.h.f> f11003e;

    public i(c.a.p0.q.e.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11001c = new ArrayList();
        this.f11002d = new ArrayList();
        this.f11003e = new ArrayList();
        this.f11000b = fVar;
        this.a = new ArrayList();
        d.b().e(this);
    }

    @Override // c.a.p0.q.i.i.g.b
    public <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
        }
    }

    @Override // c.a.p0.q.i.i.g.b
    public <T> void b(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar.k()) {
            return;
        }
        Iterator<c.a.p0.q.i.i.b> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.p0.q.i.i.b next = it.next();
            if (next.b(fVar)) {
                int i2 = fVar.i();
                this.a.remove(next);
                if (i2 == 2) {
                    this.f11003e.add(next.a().f10990e.f10989b);
                } else if (i2 == 3) {
                    this.f11002d.add(next.a().f10990e.f10989b);
                } else if (i2 == 10) {
                    this.f11001c.add(next.a().f10990e.f10989b);
                }
            }
        }
        d();
    }

    public void c(c.a.p0.q.i.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.a.add(bVar);
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.f11000b.b();
                d.b().g(this);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || d()) {
            return;
        }
        for (c.a.p0.q.i.i.b bVar : this.a) {
            bVar.c(false);
        }
    }
}
