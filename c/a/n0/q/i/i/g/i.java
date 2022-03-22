package c.a.n0.q.i.i.g;

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
    public List<c.a.n0.q.i.i.b> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.q.e.f f9177b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.n0.q.h.f> f9178c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.n0.q.h.f> f9179d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.n0.q.h.f> f9180e;

    public i(c.a.n0.q.e.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9178c = new ArrayList();
        this.f9179d = new ArrayList();
        this.f9180e = new ArrayList();
        this.f9177b = fVar;
        this.a = new ArrayList();
        d.b().e(this);
    }

    @Override // c.a.n0.q.i.i.g.b
    public <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
        }
    }

    @Override // c.a.n0.q.i.i.g.b
    public <T> void b(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar.k()) {
            return;
        }
        Iterator<c.a.n0.q.i.i.b> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.n0.q.i.i.b next = it.next();
            if (next.b(fVar)) {
                int i = fVar.i();
                this.a.remove(next);
                if (i == 2) {
                    this.f9180e.add(next.a().a.f9167b);
                } else if (i == 3) {
                    this.f9179d.add(next.a().a.f9167b);
                } else if (i == 10) {
                    this.f9178c.add(next.a().a.f9167b);
                }
            }
        }
        d();
    }

    public void c(c.a.n0.q.i.i.b bVar) {
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
                this.f9177b.b();
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
        for (c.a.n0.q.i.i.b bVar : this.a) {
            bVar.c(false);
        }
    }
}
