package c.b.b.n.l.h.i;

import c.b.b.n.l.h.f.a;
import c.b.b.n.l.h.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class b<D extends a, T extends c.b.b.n.l.h.f.a<D>> extends c.b.b.n.l.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public T f27304e;

    /* renamed from: f  reason: collision with root package name */
    public D f27305f;

    public b() {
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

    public abstract boolean g(c.b.b.n.l.h.f.a<?> aVar);

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: c.b.b.n.l.h.f.a<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean h(c.b.b.n.l.h.f.a<?> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (g(aVar)) {
                this.f27304e = aVar;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.b.b.n.l.h.b
    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27304e.a(this.f27305f);
        }
    }
}
