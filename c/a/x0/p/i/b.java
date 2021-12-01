package c.a.x0.p.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f27188b;

    /* renamed from: c  reason: collision with root package name */
    public int f27189c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27190d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1544b f27191e;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27192e;

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
            this.f27192e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27192e.i();
            }
        }
    }

    /* renamed from: c.a.x0.p.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1544b {
        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1790647375, "Lc/a/x0/p/i/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1790647375, "Lc/a/x0/p/i/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f27189c;
            if (i2 != 0) {
                return i2;
            }
            int i3 = this.f27188b;
            return i3 != 0 ? i3 : this.a;
        }
        return invokeV.intValue;
    }

    public synchronized void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this) {
                if (i2 == this.f27189c) {
                    return;
                }
                if ((this.f27188b == 0 || i2 != this.f27188b) && (this.f27188b != 0 || i2 != this.a)) {
                    this.f27189c = i2;
                    if (i2 != 0 && !this.f27190d) {
                        this.f27190d = true;
                        g();
                    }
                }
                this.f27189c = 0;
            }
        }
    }

    public void c(InterfaceC1544b interfaceC1544b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1544b) == null) {
            this.f27191e = interfaceC1544b;
        }
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.f27189c != this.a) {
                    this.f27188b = this.f27189c;
                }
                this.f27189c = 0;
            }
        }
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.f27188b != 0) {
                    this.a = this.f27188b;
                }
                this.f27188b = 0;
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ThreadPool.b().e(new a(this));
        }
    }

    public final synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                this.f27190d = false;
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        while (true) {
            e();
            int i2 = this.f27188b;
            if (i2 == 0) {
                h();
                return;
            }
            InterfaceC1544b interfaceC1544b = this.f27191e;
            if (interfaceC1544b != null) {
                interfaceC1544b.a(i2);
            }
            f();
        }
    }
}
