package b.a.u.a.a;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f28911f;

    /* renamed from: g  reason: collision with root package name */
    public static int f28912g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f28913a;

    /* renamed from: b  reason: collision with root package name */
    public int f28914b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.u.a.d.a f28915c;

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f28916d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Integer, b.a.u.a.a.c> f28917e;

    /* renamed from: b.a.u.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1397a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28918e;

        public RunnableC1397a(a aVar) {
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
            this.f28918e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28918e.f28915c.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b.a.u.a.a.c f28919e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f28920f;

        public b(a aVar, b.a.u.a.a.c cVar) {
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
            this.f28920f = aVar;
            this.f28919e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28920f.f28915c.k(this.f28919e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b.a.u.a.a.c f28921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f28922f;

        public c(a aVar, b.a.u.a.a.c cVar) {
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
            this.f28922f = aVar;
            this.f28921e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28922f.f28915c.f(this.f28921e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1212159945, "Lb/a/u/a/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1212159945, "Lb/a/u/a/a/a;");
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
        this.f28917e = new ConcurrentHashMap<>();
        this.f28913a = context;
        this.f28914b = g.g(context, "flow_handle", f28912g);
        this.f28915c = b.a.u.a.d.a.j(this.f28913a);
        this.f28916d = Executors.newSingleThreadScheduledExecutor();
    }

    public static a h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f28911f == null) {
                synchronized (a.class) {
                    if (f28911f == null) {
                        f28911f = new a(context);
                    }
                }
            }
            return f28911f;
        }
        return (a) invokeL.objValue;
    }

    public synchronized b.a.u.a.a.c b(int i2) {
        InterceptResult invokeI;
        b.a.u.a.a.c d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this) {
                d2 = d(i2);
            }
            return d2;
        }
        return (b.a.u.a.a.c) invokeI.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f28916d.execute(new RunnableC1397a(this));
        }
    }

    public final b.a.u.a.a.c d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (!this.f28917e.containsKey(Integer.valueOf(i2))) {
                this.f28914b++;
                b.a.u.a.h.e.a("BehaviorProcess", "FlowHandle:" + this.f28914b);
                b.a.u.a.a.c cVar = new b.a.u.a.a.c(this.f28913a, i2, this.f28914b);
                this.f28917e.put(Integer.valueOf(i2), cVar);
                this.f28916d.execute(new b(this, cVar));
                g.l(this.f28913a, "flow_handle", this.f28914b);
                return cVar;
            }
            return this.f28917e.get(Integer.valueOf(i2));
        }
        return (b.a.u.a.a.c) invokeI.objValue;
    }

    public synchronized void e(b.a.u.a.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            synchronized (this) {
                if (this.f28917e.containsKey(Integer.valueOf(cVar.f28924a))) {
                    this.f28917e.remove(Integer.valueOf(cVar.f28924a));
                    b.a.u.a.h.e.a("BehaviorProcess", "flow endFlow");
                    this.f28916d.execute(new c(this, cVar));
                }
            }
        }
    }

    public ScheduledExecutorService f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28916d : (ScheduledExecutorService) invokeV.objValue;
    }

    public synchronized b.a.u.a.a.c g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            synchronized (this) {
                if (this.f28917e.containsKey(Integer.valueOf(i2))) {
                    return this.f28917e.get(Integer.valueOf(i2));
                }
                return new b.a.u.a.a.b(this.f28913a, i2, f28912g);
            }
        }
        return (b.a.u.a.a.c) invokeI.objValue;
    }
}
