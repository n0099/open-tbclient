package c.a.q0.r.b0;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<?> a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f12847b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f12848c;

        /* renamed from: d  reason: collision with root package name */
        public final Method f12849d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f12850e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f12851f;

        /* renamed from: g  reason: collision with root package name */
        public final c f12852g;

        /* renamed from: h  reason: collision with root package name */
        public final int f12853h;

        /* renamed from: i  reason: collision with root package name */
        public final j f12854i;

        /* renamed from: j  reason: collision with root package name */
        public int f12855j;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f12856e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12856e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f12856e.f12854i.a(this.f12856e.f());
                    this.f12856e.f12852g.c();
                    this.f12856e.g();
                }
            }
        }

        public /* synthetic */ b(int i2, j jVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i2, jVar);
        }

        public final List<Long> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(24);
                List<Long> h2 = h();
                int size = h2.size();
                int i2 = 0;
                while (i2 < size - 1) {
                    long longValue = h2.get(i2).longValue();
                    i2++;
                    arrayList.add(Long.valueOf(h2.get(i2).longValue() - longValue));
                }
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f12852g.c();
            }
        }

        public final List<Long> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12852g.f12857e : (List) invokeV.objValue;
        }

        public final void i() throws InvocationTargetException, IllegalAccessException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f12851f.invoke(this.f12850e, this.f12847b);
            }
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i2 = this.f12855j;
                if (i2 >= this.f12853h) {
                    c.a.d.f.m.e.a().post(new a(this));
                    return;
                }
                this.f12855j = i2 + 1;
                try {
                    i();
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }

        public b(int i2, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12855j = 0;
            this.f12848c = Class.forName("android.view.Choreographer");
            this.a = Class.forName("android.view.Choreographer$FrameCallback");
            this.f12852g = new c(this);
            this.f12847b = Proxy.newProxyInstance(this.a.getClassLoader(), new Class[]{this.a}, this.f12852g);
            Method method = this.f12848c.getMethod("getInstance", new Class[0]);
            this.f12849d = method;
            this.f12850e = method.invoke(null, new Object[0]);
            this.f12851f = this.f12848c.getMethod("postFrameCallback", this.a);
            this.f12853h = i2 <= 0 ? 16 : i2;
            this.f12854i = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final List<Long> f12857e;

        /* renamed from: f  reason: collision with root package name */
        public final List<Integer> f12858f;

        /* renamed from: g  reason: collision with root package name */
        public b f12859g;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12859g = bVar;
            this.f12857e = new ArrayList(240);
            this.f12858f = new ArrayList(15);
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12859g = null;
                this.f12857e.clear();
                this.f12858f.clear();
            }
        }

        public final void d(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f12857e.add(Long.valueOf(j2));
                this.f12859g.j();
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, method, objArr)) == null) {
                String name = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                if ("doFrame".equals(name) && parameterTypes.length == 1 && parameterTypes[0] == Long.TYPE) {
                    d(((Long) objArr[0]).longValue());
                    return null;
                }
                return null;
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-476068690, "Lc/a/q0/r/b0/g$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-476068690, "Lc/a/q0/r/b0/g$d;");
                    return;
                }
            }
            a = new g();
        }
    }

    public g() {
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
        this.a = null;
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d.a : (g) invokeV.objValue;
    }

    public void b(int i2, j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, jVar) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            b bVar = new b(i2, jVar, null);
            this.a = bVar;
            bVar.j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
