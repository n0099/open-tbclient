package c.p.a.e.b.k;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile SparseArray<c> f35147a;

    /* renamed from: b  reason: collision with root package name */
    public int f35148b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473359529, "Lc/p/a/e/b/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1473359529, "Lc/p/a/e/b/k/d;");
                return;
            }
        }
        new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("Download_OP_Thread"));
    }

    public d() {
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
        this.f35148b = 0;
        this.f35147a = new SparseArray<>();
    }

    public List<Integer> a() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (d.class) {
                f();
                arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.f35147a.size(); i2++) {
                    c cVar = this.f35147a.get(this.f35147a.keyAt(i2));
                    if (cVar != null) {
                        arrayList.add(Integer.valueOf(cVar.S()));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void b(int i2, long j2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (cVar = this.f35147a.get(i2)) == null) {
            return;
        }
        cVar.P(j2);
    }

    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            cVar.T();
            synchronized (d.class) {
                if (this.f35148b >= 500) {
                    f();
                    this.f35148b = 0;
                } else {
                    this.f35148b++;
                }
                this.f35147a.put(cVar.S(), cVar);
            }
            c.p.a.e.b.n.a O = cVar.O();
            try {
                ExecutorService E0 = c.p.a.e.b.g.e.E0();
                if (O != null && O.J() != null) {
                    if ("mime_type_plg".equals(O.J().getMimeType()) && c.p.a.e.b.j.a.r().b("divide_plugin", 1) == 1) {
                        O.J().safePutToDBJsonData("executor_group", 3);
                    }
                    int executorGroup = O.J().getExecutorGroup();
                    if (executorGroup == 3) {
                        E0 = c.p.a.e.b.g.e.C0();
                    } else if (executorGroup == 4) {
                        E0 = c.p.a.e.b.g.e.D0();
                    }
                }
                if (E0 != null) {
                    if (c.p.a.e.b.j.a.d(cVar.S()).q("pause_with_interrupt", false)) {
                        cVar.K(E0.submit(cVar));
                        return;
                    } else {
                        E0.execute(cVar);
                        return;
                    }
                }
                c.p.a.e.b.e.a.e(O.R(), O.J(), new BaseException(1003, "execute failed cpu thread executor service is null"), O.J() != null ? O.J().getStatus() : 0);
            } catch (Exception e2) {
                if (O != null) {
                    c.p.a.e.b.e.a.e(O.R(), O.J(), new BaseException(1003, c.p.a.e.b.l.f.a0(e2, "DownloadThreadPoolExecute")), O.J() != null ? O.J().getStatus() : 0);
                }
                e2.printStackTrace();
            } catch (OutOfMemoryError e3) {
                if (O != null) {
                    c.p.a.e.b.e.a.e(O.R(), O.J(), new BaseException(1003, "execute OOM"), O.J() != null ? O.J().getStatus() : 0);
                }
                e3.printStackTrace();
            }
        }
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            synchronized (d.class) {
                boolean z = false;
                if (this.f35147a != null && this.f35147a.size() > 0) {
                    c cVar = this.f35147a.get(i2);
                    if (cVar != null && cVar.Q()) {
                        z = true;
                    }
                    return z;
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public c e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            synchronized (d.class) {
                f();
                c cVar = this.f35147a.get(i2);
                if (cVar != null) {
                    cVar.M();
                    i(cVar);
                    this.f35147a.remove(i2);
                    return cVar;
                }
                return null;
            }
        }
        return (c) invokeI.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.f35147a.size(); i2++) {
                    int keyAt = this.f35147a.keyAt(i2);
                    if (!this.f35147a.get(keyAt).Q()) {
                        arrayList.add(Integer.valueOf(keyAt));
                    }
                }
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Integer num = (Integer) arrayList.get(i3);
                    if (num != null) {
                        this.f35147a.remove(num.intValue());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null) {
            return;
        }
        synchronized (d.class) {
            try {
                if (c.p.a.e.b.l.a.a(524288)) {
                    int indexOfValue = this.f35147a.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.f35147a.removeAt(indexOfValue);
                    }
                } else {
                    this.f35147a.remove(cVar.S());
                }
            }
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            synchronized (d.class) {
                f();
                c cVar = this.f35147a.get(i2);
                if (cVar != null) {
                    cVar.z();
                    i(cVar);
                    this.f35147a.remove(i2);
                }
            }
        }
    }

    public final void i(c cVar) {
        Future U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || cVar == null) {
            return;
        }
        try {
            ExecutorService E0 = c.p.a.e.b.g.e.E0();
            c.p.a.e.b.n.a O = cVar.O();
            if (O != null && O.J() != null) {
                int executorGroup = O.J().getExecutorGroup();
                if (executorGroup == 3) {
                    E0 = c.p.a.e.b.g.e.C0();
                } else if (executorGroup == 4) {
                    E0 = c.p.a.e.b.g.e.D0();
                }
            }
            if (E0 == null || !(E0 instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) E0).remove(cVar);
            if (!c.p.a.e.b.j.a.d(cVar.S()).q("pause_with_interrupt", false) || (U = cVar.U()) == null) {
                return;
            }
            U.cancel(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
