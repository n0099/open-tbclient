package c.a.q0.q.j.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class i implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.q0.q.j.i.b> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.q.f.f f11067b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.q0.q.i.f> f11068c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.q0.q.i.f> f11069d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.q0.q.i.f> f11070e;

    public i(c.a.q0.q.f.f fVar) {
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
        this.f11068c = new ArrayList();
        this.f11069d = new ArrayList();
        this.f11070e = new ArrayList();
        this.f11067b = fVar;
        this.a = new ArrayList();
        d.b().e(this);
    }

    @Override // c.a.q0.q.j.i.g.b
    public <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
        }
    }

    @Override // c.a.q0.q.j.i.g.b
    public <T> void b(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar.k()) {
            return;
        }
        Iterator<c.a.q0.q.j.i.b> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.q0.q.j.i.b next = it.next();
            if (next.b(fVar)) {
                int i2 = fVar.i();
                this.a.remove(next);
                if (i2 == 2) {
                    this.f11070e.add(next.a().f11057e.f11055b);
                } else if (i2 == 3) {
                    this.f11069d.add(next.a().f11057e.f11055b);
                } else if (i2 == 10) {
                    this.f11068c.add(next.a().f11057e.f11055b);
                }
            }
        }
        d();
    }

    public void c(c.a.q0.q.j.i.b bVar) {
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
                this.f11067b.b();
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
        for (c.a.q0.q.j.i.b bVar : this.a) {
            bVar.c(false);
        }
    }
}
