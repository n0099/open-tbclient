package c.a.j.m.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
/* loaded from: classes.dex */
public final class b<T> implements a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Stack<T> a;

    /* renamed from: b  reason: collision with root package name */
    public final ReentrantLock f4083b;

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
                return;
            }
        }
        this.a = new Stack<>();
        this.f4083b = new ReentrantLock(true);
    }

    @Override // c.a.j.m.d.a
    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            ReentrantLock reentrantLock = this.f4083b;
            reentrantLock.lock();
            try {
                this.a.push(t);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // c.a.j.m.d.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ReentrantLock reentrantLock = this.f4083b;
            reentrantLock.lock();
            try {
                this.a.clear();
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // c.a.j.m.d.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ReentrantLock reentrantLock = this.f4083b;
            reentrantLock.lock();
            try {
                return this.a.isEmpty();
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.j.m.d.a
    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ReentrantLock reentrantLock = this.f4083b;
            reentrantLock.lock();
            try {
                if (!c()) {
                    return this.a.pop();
                }
                return null;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (T) invokeV.objValue;
    }
}
