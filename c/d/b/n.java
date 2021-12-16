package c.d.b;

import androidx.core.view.InputDeviceCompat;
import c.d.b.y;
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
/* loaded from: classes9.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f28791b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Runnable f28792c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f28793d;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<y.b> f28794e;

    /* renamed from: f  reason: collision with root package name */
    public final Deque<y.b> f28795f;

    /* renamed from: g  reason: collision with root package name */
    public final Deque<y> f28796g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1810732899, "Lc/d/b/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1810732899, "Lc/d/b/n;");
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
        this.a = 64;
        this.f28791b = 5;
        this.f28794e = new ArrayDeque();
        this.f28795f = new ArrayDeque();
        this.f28796g = new ArrayDeque();
        this.f28793d = executorService;
    }

    public void a(y.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            synchronized (this) {
                this.f28794e.add(bVar);
            }
            g();
        }
    }

    public synchronized void b(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yVar) == null) {
            synchronized (this) {
                this.f28796g.add(yVar);
            }
        }
    }

    public synchronized ExecutorService c() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.f28793d == null) {
                    this.f28793d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.d.b.e0.e.F("OkHttp Dispatcher", false));
                }
                executorService = this.f28793d;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public void d(y.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            f(this.f28795f, bVar);
        }
    }

    public void e(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yVar) == null) {
            f(this.f28796g, yVar);
        }
    }

    public final <T> void f(Deque<T> deque, T t) {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, deque, t) == null) {
            synchronized (this) {
                if (deque.remove(t)) {
                    runnable = this.f28792c;
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
                Iterator<y.b> it = this.f28794e.iterator();
                while (it.hasNext()) {
                    y.b next = it.next();
                    if (this.f28795f.size() >= this.a) {
                        break;
                    } else if (i(next) < this.f28791b) {
                        it.remove();
                        arrayList.add(next);
                        this.f28795f.add(next);
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
                size = this.f28795f.size() + this.f28796g.size();
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
            for (y.b bVar2 : this.f28795f) {
                if (!bVar2.f().f28841j && bVar2.g().equals(bVar.g())) {
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
        this.a = 64;
        this.f28791b = 5;
        this.f28794e = new ArrayDeque();
        this.f28795f = new ArrayDeque();
        this.f28796g = new ArrayDeque();
    }
}
