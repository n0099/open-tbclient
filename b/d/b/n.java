package b.d.b;

import androidx.core.view.InputDeviceCompat;
import b.d.b.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f30542a;

    /* renamed from: b  reason: collision with root package name */
    public int f30543b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Runnable f30544c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f30545d;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<y.b> f30546e;

    /* renamed from: f  reason: collision with root package name */
    public final Deque<y.b> f30547f;

    /* renamed from: g  reason: collision with root package name */
    public final Deque<y> f30548g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(741424062, "Lb/d/b/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(741424062, "Lb/d/b/n;");
        }
    }

    public n(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f30542a = 64;
        this.f30543b = 5;
        this.f30546e = new ArrayDeque();
        this.f30547f = new ArrayDeque();
        this.f30548g = new ArrayDeque();
        this.f30545d = executorService;
    }

    public void a(y.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            synchronized (this) {
                this.f30546e.add(bVar);
            }
            g();
        }
    }

    public synchronized void b(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yVar) == null) {
            synchronized (this) {
                this.f30548g.add(yVar);
            }
        }
    }

    public synchronized ExecutorService c() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.f30545d == null) {
                    this.f30545d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), b.d.b.e0.e.F("OkHttp Dispatcher", false));
                }
                executorService = this.f30545d;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public void d(y.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            f(this.f30547f, bVar);
        }
    }

    public void e(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yVar) == null) {
            f(this.f30548g, yVar);
        }
    }

    public final <T> void f(Deque<T> deque, T t) {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, deque, t) == null) {
            synchronized (this) {
                if (deque.remove(t)) {
                    runnable = this.f30544c;
                } else {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            }
            if (g() || runnable == null) {
                return;
            }
            runnable.run();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<y.b> it = this.f30546e.iterator();
                while (it.hasNext()) {
                    y.b next = it.next();
                    if (this.f30547f.size() >= this.f30542a) {
                        break;
                    } else if (i(next) < this.f30543b) {
                        it.remove();
                        arrayList.add(next);
                        this.f30547f.add(next);
                    }
                }
                z = h() > 0;
            }
            int size = arrayList.size();
            for (i2 = 0; i2 < size; i2++) {
                ((y.b) arrayList.get(i2)).e(c());
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized int h() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                size = this.f30547f.size() + this.f30548g.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public final int i(y.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            int i2 = 0;
            for (y.b bVar2 : this.f30547f) {
                if (!bVar2.f().j && bVar2.g().equals(bVar.g())) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30542a = 64;
        this.f30543b = 5;
        this.f30546e = new ArrayDeque();
        this.f30547f = new ArrayDeque();
        this.f30548g = new ArrayDeque();
    }
}
