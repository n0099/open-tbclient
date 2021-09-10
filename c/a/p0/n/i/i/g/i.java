package c.a.p0.n.i.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f11937f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.p0.n.i.i.b> f11938a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.n.f.d f11939b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.p0.n.h.e> f11940c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.p0.n.h.e> f11941d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.p0.n.h.e> f11942e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755783568, "Lc/a/p0/n/i/i/g/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755783568, "Lc/a/p0/n/i/i/g/i;");
                return;
            }
        }
        f11937f = c.a.p0.n.c.f11856a;
    }

    public i(c.a.p0.n.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11940c = new ArrayList();
        this.f11941d = new ArrayList();
        this.f11942e = new ArrayList();
        this.f11939b = dVar;
        this.f11938a = new ArrayList();
        d.b().e(this);
    }

    @Override // c.a.p0.n.i.i.g.b
    public <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
        }
    }

    @Override // c.a.p0.n.i.i.g.b
    public <T> void b(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar.j()) {
            return;
        }
        Iterator<c.a.p0.n.i.i.b> it = this.f11938a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.p0.n.i.i.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f11938a.remove(next);
                if (h2 == 2) {
                    this.f11942e.add(next.a().f11928e.f11927b);
                } else if (h2 == 3) {
                    this.f11941d.add(next.a().f11928e.f11927b);
                } else if (h2 != 10) {
                    if (c.a.p0.n.c.f11856a) {
                        String str = "notifyTaskEnd error state:" + h2;
                    }
                } else {
                    this.f11940c.add(next.a().f11928e.f11927b);
                }
            }
        }
        d();
    }

    public void c(c.a.p0.n.i.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f11938a.add(bVar);
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f11938a.isEmpty()) {
                this.f11939b.b();
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
        if (f11937f) {
            String str = c.a.p0.n.c.b().v() + " startDownload: total=" + this.f11938a.size();
        }
        for (c.a.p0.n.i.i.b bVar : this.f11938a) {
            if (f11937f) {
                String str2 = c.a.p0.n.c.b().v() + " startDownload: for handler=" + bVar;
            }
            bVar.c(false);
        }
    }
}
