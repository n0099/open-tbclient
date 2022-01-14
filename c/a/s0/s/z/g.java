package c.a.s0.s.z;

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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<?> a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f13689b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f13690c;

        /* renamed from: d  reason: collision with root package name */
        public final Method f13691d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f13692e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f13693f;

        /* renamed from: g  reason: collision with root package name */
        public final c f13694g;

        /* renamed from: h  reason: collision with root package name */
        public final int f13695h;

        /* renamed from: i  reason: collision with root package name */
        public final j f13696i;

        /* renamed from: j  reason: collision with root package name */
        public int f13697j;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f13698e;

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
                this.f13698e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f13698e.f13696i.a(this.f13698e.f());
                    this.f13698e.f13694g.c();
                    this.f13698e.g();
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
                this.f13694g.c();
            }
        }

        public final List<Long> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13694g.f13699e : (List) invokeV.objValue;
        }

        public final void i() throws InvocationTargetException, IllegalAccessException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f13693f.invoke(this.f13692e, this.f13689b);
            }
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i2 = this.f13697j;
                if (i2 >= this.f13695h) {
                    c.a.d.f.m.e.a().post(new a(this));
                    return;
                }
                this.f13697j = i2 + 1;
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
            this.f13697j = 0;
            this.f13690c = Class.forName("android.view.Choreographer");
            this.a = Class.forName("android.view.Choreographer$FrameCallback");
            this.f13694g = new c(this);
            this.f13689b = Proxy.newProxyInstance(this.a.getClassLoader(), new Class[]{this.a}, this.f13694g);
            Method method = this.f13690c.getMethod("getInstance", new Class[0]);
            this.f13691d = method;
            this.f13692e = method.invoke(null, new Object[0]);
            this.f13693f = this.f13690c.getMethod("postFrameCallback", this.a);
            this.f13695h = i2 <= 0 ? 16 : i2;
            this.f13696i = jVar;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final List<Long> f13699e;

        /* renamed from: f  reason: collision with root package name */
        public final List<Integer> f13700f;

        /* renamed from: g  reason: collision with root package name */
        public b f13701g;

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
            this.f13701g = bVar;
            this.f13699e = new ArrayList(240);
            this.f13700f = new ArrayList(15);
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13701g = null;
                this.f13699e.clear();
                this.f13700f.clear();
            }
        }

        public final void d(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f13699e.add(Long.valueOf(j2));
                this.f13701g.j();
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

    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(345353169, "Lc/a/s0/s/z/g$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(345353169, "Lc/a/s0/s/z/g$d;");
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
