package b.a.p0.a.l0;

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
    public static volatile f f6926c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f6927a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<j> f6928b;

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
        this.f6927a = new ReentrantLock();
        this.f6928b = new ArrayList<>();
    }

    public static f i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f6926c == null) {
                synchronized (f.class) {
                    if (f6926c == null) {
                        f6926c = new f();
                    }
                }
            }
            return f6926c;
        }
        return (f) invokeV.objValue;
    }

    public final Object[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.f6927a.lock();
                return this.f6928b.size() > 0 ? this.f6928b.toArray() : null;
            } finally {
                this.f6927a.unlock();
            }
        }
        return (Object[]) invokeV.objValue;
    }

    public void b(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((j) obj).d(aVar);
        }
    }

    public void c(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((j) obj).b(aVar);
        }
    }

    public void d(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((j) obj).f(aVar);
        }
    }

    public void e(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((j) obj).c(aVar);
        }
    }

    public void f(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((j) obj).g(aVar);
        }
    }

    public void g(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((j) obj).a(aVar);
        }
    }

    public void h(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((j) obj).e(aVar);
        }
    }
}
