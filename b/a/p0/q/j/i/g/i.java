package b.a.p0.q.j.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b.a.p0.q.j.i.b> f11823a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.q.f.f f11824b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.p0.q.i.f> f11825c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.p0.q.i.f> f11826d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.p0.q.i.f> f11827e;

    public i(b.a.p0.q.f.f fVar) {
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
        this.f11825c = new ArrayList();
        this.f11826d = new ArrayList();
        this.f11827e = new ArrayList();
        this.f11824b = fVar;
        this.f11823a = new ArrayList();
        d.b().e(this);
    }

    @Override // b.a.p0.q.j.i.g.b
    public <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
        }
    }

    @Override // b.a.p0.q.j.i.g.b
    public <T> void b(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar.k()) {
            return;
        }
        Iterator<b.a.p0.q.j.i.b> it = this.f11823a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b.a.p0.q.j.i.b next = it.next();
            if (next.b(fVar)) {
                int i2 = fVar.i();
                this.f11823a.remove(next);
                if (i2 == 2) {
                    this.f11827e.add(next.a().f11814e.f11813b);
                } else if (i2 == 3) {
                    this.f11826d.add(next.a().f11814e.f11813b);
                } else if (i2 == 10) {
                    this.f11825c.add(next.a().f11814e.f11813b);
                }
            }
        }
        d();
    }

    public void c(b.a.p0.q.j.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f11823a.add(bVar);
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f11823a.isEmpty()) {
                this.f11824b.b();
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
        for (b.a.p0.q.j.i.b bVar : this.f11823a) {
            bVar.c(false);
        }
    }
}
