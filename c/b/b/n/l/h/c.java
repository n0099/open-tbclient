package c.b.b.n.l.h;

import c.b.b.q.a;
import c.b.b.q.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.b.b.q.a<a> f27265e;

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
                return;
            }
        }
        this.f27265e = new c.b.b.q.a<>(true, 3, a.class);
    }

    public void a(c.b.b.j.e eVar, e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, eVar, eVar2) == null) {
            a.b<a> it = this.f27265e.iterator();
            while (it.hasNext()) {
                it.next().c(eVar, eVar2);
            }
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f27265e.f27361f;
            for (int i3 = 0; i3 < i2; i3++) {
                this.f27265e.get(i3).b();
            }
        }
    }

    public void f(c.b.b.q.a<c.b.b.n.l.h.f.a<?>> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            a.b<a> it = this.f27265e.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a.b<c.b.b.n.l.h.f.a<?>> it2 = aVar.iterator();
                while (it2.hasNext()) {
                    if (next.f27263g.h(it2.next())) {
                        break;
                    }
                }
            }
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.f27265e.f27361f;
            for (int i3 = 0; i3 < i2; i3++) {
                this.f27265e.get(i3).update();
            }
        }
    }

    public void update(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            int i2 = this.f27265e.f27361f;
            for (int i3 = 0; i3 < i2; i3++) {
                this.f27265e.get(i3).update(f2);
            }
        }
    }
}
