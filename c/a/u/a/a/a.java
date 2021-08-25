package c.a.u.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f30010f;

    /* renamed from: g  reason: collision with root package name */
    public static int f30011g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f30012a;

    /* renamed from: b  reason: collision with root package name */
    public int f30013b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.u.a.d.a f30014c;

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f30015d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Integer, c.a.u.a.a.c> f30016e;

    /* renamed from: c.a.u.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1396a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30017e;

        public RunnableC1396a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30017e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30017e.f30014c.g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.u.a.a.c f30018e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f30019f;

        public b(a aVar, c.a.u.a.a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30019f = aVar;
            this.f30018e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30019f.f30014c.o(this.f30018e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.u.a.a.c f30020e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f30021f;

        public c(a aVar, c.a.u.a.a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30021f = aVar;
            this.f30020e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30021f.f30014c.j(this.f30020e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1083077226, "Lc/a/u/a/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1083077226, "Lc/a/u/a/a/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30016e = new ConcurrentHashMap<>();
        this.f30012a = context;
        this.f30013b = g.g(context, "flow_handle", f30011g);
        this.f30014c = c.a.u.a.d.a.n(this.f30012a);
        this.f30015d = Executors.newSingleThreadScheduledExecutor();
    }

    public static a h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f30010f == null) {
                synchronized (a.class) {
                    if (f30010f == null) {
                        f30010f = new a(context);
                    }
                }
            }
            return f30010f;
        }
        return (a) invokeL.objValue;
    }

    public synchronized c.a.u.a.a.c b(int i2) {
        InterceptResult invokeI;
        c.a.u.a.a.c d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this) {
                d2 = d(i2);
            }
            return d2;
        }
        return (c.a.u.a.a.c) invokeI.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f30015d.execute(new RunnableC1396a(this));
        }
    }

    public final c.a.u.a.a.c d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (!this.f30016e.containsKey(Integer.valueOf(i2))) {
                this.f30013b++;
                c.a.u.a.h.e.a("BehaviorProcess", "FlowHandle:" + this.f30013b);
                c.a.u.a.a.c cVar = new c.a.u.a.a.c(this.f30012a, i2, this.f30013b);
                this.f30016e.put(Integer.valueOf(i2), cVar);
                this.f30015d.execute(new b(this, cVar));
                g.l(this.f30012a, "flow_handle", this.f30013b);
                return cVar;
            }
            return this.f30016e.get(Integer.valueOf(i2));
        }
        return (c.a.u.a.a.c) invokeI.objValue;
    }

    public synchronized void e(c.a.u.a.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            synchronized (this) {
                if (this.f30016e.containsKey(Integer.valueOf(cVar.f30023a))) {
                    this.f30016e.remove(Integer.valueOf(cVar.f30023a));
                    c.a.u.a.h.e.a("BehaviorProcess", "flow endFlow");
                    this.f30015d.execute(new c(this, cVar));
                }
            }
        }
    }

    public ScheduledExecutorService f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30015d : (ScheduledExecutorService) invokeV.objValue;
    }

    public synchronized c.a.u.a.a.c g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            synchronized (this) {
                if (this.f30016e.containsKey(Integer.valueOf(i2))) {
                    return this.f30016e.get(Integer.valueOf(i2));
                }
                return new c.a.u.a.a.b(this.f30012a, i2, f30011g);
            }
        }
        return (c.a.u.a.a.c) invokeI.objValue;
    }
}
