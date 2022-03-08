package c.a.p0.q.i.i.e;

import c.a.p0.q.i.i.g.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c extends a<f> implements c.a.p0.q.i.i.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile f f10983b;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p0.q.i.i.g.b
    public <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f10983b = fVar;
        }
    }

    @Override // c.a.p0.q.i.i.g.b
    public <T> void b(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            if (this.f10983b == fVar) {
                this.f10983b = null;
            }
            k(fVar);
        }
    }

    public synchronized f g() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                fVar = (f) super.c();
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    public synchronized void h(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            synchronized (this) {
                if (fVar == null) {
                    return;
                }
                if (this.f10983b != null && this.f10983b.d(fVar)) {
                    fVar.e().f(fVar.f());
                    return;
                }
                f e2 = e(fVar);
                if (e2 != null) {
                    fVar.e().f(fVar.f());
                    if (fVar.g() <= e2.g()) {
                        return;
                    }
                }
                int g2 = fVar.g();
                if (g2 != 200) {
                    if (g2 == 300) {
                        j(fVar);
                        if (e2 != null) {
                            this.a.remove(e2);
                            this.a.add(0, e2);
                        } else {
                            this.a.add(0, fVar);
                        }
                    } else if (e2 == null) {
                        this.a.add(fVar);
                    }
                } else if (e2 != null) {
                    this.a.remove(e2);
                    this.a.add(0, e2);
                } else {
                    this.a.add(0, fVar);
                }
                notifyAll();
            }
        }
    }

    public synchronized f i() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                fVar = (f) super.d();
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    public final void j(f fVar) {
        f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar.g() != 300 || (fVar2 = this.f10983b) == null || fVar2.g() == 300) {
            return;
        }
        fVar2.o();
        for (int i2 = 0; i2 < 500 && this.f10983b != null; i2++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void k(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) && fVar.k()) {
            fVar.r(true);
            this.a.add(0, fVar);
        }
    }
}
