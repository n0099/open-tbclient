package c.a.p0.a.e0.h;

import android.content.Context;
import c.a.p0.a.e0.f.f.d;
import c.a.p0.a.o2.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static int f4811d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public b f4812b;

    /* renamed from: c  reason: collision with root package name */
    public c f4813c;

    /* renamed from: c.a.p0.a.e0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0212a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4814e;

        public RunnableC0212a(a aVar) {
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
            this.f4814e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.p0.a.e0.f.b.e() || a.e() != 0) {
                    this.f4814e.f4813c = new c.a.p0.a.e0.h.c.c(String.format("v8in%s_devtools_remote", this.f4814e.a.getPackageName()), this.f4814e.f4812b);
                } else if (c.a.p0.a.e0.f.b.f()) {
                    this.f4814e.f4813c = new c.a.p0.a.e0.h.c.b(d.e(), this.f4814e.f4812b);
                } else {
                    c.a.p0.a.e0.d.c("V8Inspector", "Unknown inspect mode");
                    return;
                }
                this.f4814e.f4813c.start();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onConnected();
    }

    /* loaded from: classes.dex */
    public interface c {
        void start();

        void stop();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1575612594, "Lc/a/p0/a/e0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1575612594, "Lc/a/p0/a/e0/h/a;");
                return;
            }
        }
        f4811d = h.a().getBoolean("Inspector", false) ? 2 : 0;
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
        this.a = context;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f4811d : invokeV.intValue;
    }

    public static void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            h.a().putBoolean("Inspector", i2 == 2);
            f4811d = i2;
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f4812b = bVar;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ExecutorUtilsExt.postOnSerial(new RunnableC0212a(this), "V8Inspector");
        }
    }

    public void i() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f4813c) == null) {
            return;
        }
        cVar.stop();
        this.f4813c = null;
    }
}
