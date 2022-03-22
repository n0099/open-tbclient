package c.b.b.n.l.h.i;

import c.b.b.n.l.h.f.a;
import c.b.b.n.l.h.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class b<D extends a, T extends c.b.b.n.l.h.f.a<D>> extends c.b.b.n.l.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T a;

    /* renamed from: b  reason: collision with root package name */
    public D f22641b;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                this.a = aVar;
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
            this.a.a(this.f22641b);
        }
    }
}
