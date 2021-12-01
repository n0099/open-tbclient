package c.a.t.a.a;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f26140f;

    /* renamed from: g  reason: collision with root package name */
    public static int f26141g;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f26142b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t.a.d.a f26143c;

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f26144d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Integer, c.a.t.a.a.c> f26145e;

    /* renamed from: c.a.t.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1501a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26146e;

        public RunnableC1501a(a aVar) {
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
            this.f26146e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26146e.f26143c.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t.a.a.c f26147e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f26148f;

        public b(a aVar, c.a.t.a.a.c cVar) {
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
            this.f26148f = aVar;
            this.f26147e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26148f.f26143c.k(this.f26147e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t.a.a.c f26149e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f26150f;

        public c(a aVar, c.a.t.a.a.c cVar) {
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
            this.f26150f = aVar;
            this.f26149e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26150f.f26143c.f(this.f26149e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1469079735, "Lc/a/t/a/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1469079735, "Lc/a/t/a/a/a;");
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
        this.f26145e = new ConcurrentHashMap<>();
        this.a = context;
        this.f26142b = g.g(context, "flow_handle", f26141g);
        this.f26143c = c.a.t.a.d.a.j(this.a);
        this.f26144d = Executors.newSingleThreadScheduledExecutor();
    }

    public static a h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f26140f == null) {
                synchronized (a.class) {
                    if (f26140f == null) {
                        f26140f = new a(context);
                    }
                }
            }
            return f26140f;
        }
        return (a) invokeL.objValue;
    }

    public synchronized c.a.t.a.a.c b(int i2) {
        InterceptResult invokeI;
        c.a.t.a.a.c d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this) {
                d2 = d(i2);
            }
            return d2;
        }
        return (c.a.t.a.a.c) invokeI.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26144d.execute(new RunnableC1501a(this));
        }
    }

    public final c.a.t.a.a.c d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (!this.f26145e.containsKey(Integer.valueOf(i2))) {
                this.f26142b++;
                c.a.t.a.h.e.a("BehaviorProcess", "FlowHandle:" + this.f26142b);
                c.a.t.a.a.c cVar = new c.a.t.a.a.c(this.a, i2, this.f26142b);
                this.f26145e.put(Integer.valueOf(i2), cVar);
                this.f26144d.execute(new b(this, cVar));
                g.l(this.a, "flow_handle", this.f26142b);
                return cVar;
            }
            return this.f26145e.get(Integer.valueOf(i2));
        }
        return (c.a.t.a.a.c) invokeI.objValue;
    }

    public synchronized void e(c.a.t.a.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            synchronized (this) {
                if (this.f26145e.containsKey(Integer.valueOf(cVar.a))) {
                    this.f26145e.remove(Integer.valueOf(cVar.a));
                    c.a.t.a.h.e.a("BehaviorProcess", "flow endFlow");
                    this.f26144d.execute(new c(this, cVar));
                }
            }
        }
    }

    public ScheduledExecutorService f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26144d : (ScheduledExecutorService) invokeV.objValue;
    }

    public synchronized c.a.t.a.a.c g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            synchronized (this) {
                if (this.f26145e.containsKey(Integer.valueOf(i2))) {
                    return this.f26145e.get(Integer.valueOf(i2));
                }
                return new c.a.t.a.a.b(this.a, i2, f26141g);
            }
        }
        return (c.a.t.a.a.c) invokeI.objValue;
    }
}
