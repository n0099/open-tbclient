package c.a.n0.a.l0;

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
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile e f6910c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f6911a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<i> f6912b;

    public e() {
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
        this.f6911a = new ReentrantLock();
        this.f6912b = new ArrayList<>();
    }

    public static e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f6910c == null) {
                synchronized (e.class) {
                    if (f6910c == null) {
                        f6910c = new e();
                    }
                }
            }
            return f6910c;
        }
        return (e) invokeV.objValue;
    }

    public final Object[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.f6911a.lock();
                return this.f6912b.size() > 0 ? this.f6912b.toArray() : null;
            } finally {
                this.f6911a.unlock();
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
            ((i) obj).d(aVar);
        }
    }

    public void c(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((i) obj).b(aVar);
        }
    }

    public void d(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((i) obj).f(aVar);
        }
    }

    public void e(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((i) obj).c(aVar);
        }
    }

    public void f(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((i) obj).g(aVar);
        }
    }

    public void g(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((i) obj).a(aVar);
        }
    }

    public void h(a aVar) {
        Object[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || (a2 = a()) == null) {
            return;
        }
        for (Object obj : a2) {
            ((i) obj).e(aVar);
        }
    }
}
