package c.a.s0.a.l0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f7843c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<j> f7844b;

    public f() {
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
        this.a = new ReentrantLock();
        this.f7844b = new ArrayList<>();
    }

    public static f i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f7843c == null) {
                synchronized (f.class) {
                    if (f7843c == null) {
                        f7843c = new f();
                    }
                }
            }
            return f7843c;
        }
        return (f) invokeV.objValue;
    }

    public final Object[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.a.lock();
                return this.f7844b.size() > 0 ? this.f7844b.toArray() : null;
            } finally {
                this.a.unlock();
            }
        }
        return (Object[]) invokeV.objValue;
    }

    public void b(a aVar) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j) obj).d(aVar);
        }
    }

    public void c(a aVar) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j) obj).b(aVar);
        }
    }

    public void d(a aVar) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j) obj).f(aVar);
        }
    }

    public void e(a aVar) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j) obj).c(aVar);
        }
    }

    public void f(a aVar) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j) obj).g(aVar);
        }
    }

    public void g(a aVar) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j) obj).a(aVar);
        }
    }

    public void h(a aVar) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((j) obj).e(aVar);
        }
    }
}
