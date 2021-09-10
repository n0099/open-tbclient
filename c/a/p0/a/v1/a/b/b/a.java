package c.a.p0.a.v1.a.b.b;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f9207d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f9208e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, c.a.p0.a.v1.a.b.c.a<c.a.p0.a.v1.a.b.a.b>> f9209a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f9210b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0428a f9211c;

    /* renamed from: c.a.p0.a.v1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class HandlerC0428a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0428a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f9212e;

        /* renamed from: f  reason: collision with root package name */
        public String f9213f;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9212e = new WeakReference<>(aVar);
            this.f9213f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f9212e.get()) == null) {
                return;
            }
            if (a.f9207d) {
                String str = "run: observer timeout " + this.f9213f;
            }
            c.a.p0.a.v1.a.b.a.b bVar = new c.a.p0.a.v1.a.b.a.b(this.f9213f);
            bVar.b(null);
            aVar.c(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2142513793, "Lc/a/p0/a/v1/a/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2142513793, "Lc/a/p0/a/v1/a/b/b/a;");
                return;
            }
        }
        f9207d = k.f7077a;
    }

    public a() {
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
        this.f9209a = new ConcurrentHashMap<>();
        this.f9210b = new ConcurrentHashMap<>();
        this.f9211c = new HandlerC0428a(Looper.getMainLooper());
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f9208e == null) {
                synchronized (a.class) {
                    if (f9208e == null) {
                        f9208e = new a();
                    }
                }
            }
            return f9208e;
        }
        return (a) invokeV.objValue;
    }

    public void c(@NonNull c.a.p0.a.v1.a.b.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            c.a.p0.a.v1.a.b.c.a<c.a.p0.a.v1.a.b.a.b> aVar = this.f9209a.get(bVar.c());
            if (aVar == null) {
                boolean z = f9207d;
                return;
            }
            String b2 = aVar.b();
            if (f9207d) {
                String str = "notify observer: " + b2;
            }
            aVar.onEvent(bVar);
            if (this.f9210b.containsKey(b2)) {
                if (f9207d) {
                    String str2 = "remove observer: " + b2 + " timeout runnable";
                }
                this.f9211c.removeCallbacks(this.f9210b.get(b2));
                this.f9210b.remove(b2);
            }
            if (aVar.c()) {
                if (f9207d) {
                    String str3 = "auto unregister disposable observer: " + b2;
                }
                f(aVar);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = f9207d;
            if (f9208e == null) {
                return;
            }
            this.f9209a.clear();
            for (Map.Entry<String, Runnable> entry : this.f9210b.entrySet()) {
                if (f9207d) {
                    String str = "remove observer: " + entry.getKey() + " timeout runnable";
                }
                this.f9211c.removeCallbacks(entry.getValue());
            }
            this.f9210b.clear();
            f9208e = null;
        }
    }

    public void e(c.a.p0.a.v1.a.b.c.a<c.a.p0.a.v1.a.b.a.b> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (aVar == null) {
                boolean z = f9207d;
                return;
            }
            String b2 = aVar.b();
            if (this.f9209a.containsKey(b2)) {
                if (f9207d) {
                    String str = "multiple register observer：" + b2;
                    return;
                }
                return;
            }
            if (f9207d) {
                String str2 = "register observer: " + b2;
            }
            this.f9209a.put(b2, aVar);
            long a2 = aVar.a();
            if (a2 <= 0 || !aVar.c()) {
                return;
            }
            if (f9207d) {
                String str3 = "post observer: " + b2 + " " + a2 + "ms timeout runnable";
            }
            b bVar = new b(this, b2);
            this.f9210b.put(b2, bVar);
            this.f9211c.postDelayed(bVar, a2);
        }
    }

    public void f(c.a.p0.a.v1.a.b.c.a<c.a.p0.a.v1.a.b.a.b> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar == null) {
                boolean z = f9207d;
                return;
            }
            String b2 = aVar.b();
            if (!this.f9209a.containsKey(b2)) {
                boolean z2 = f9207d;
                return;
            }
            if (f9207d) {
                String str = "unregister observer: " + b2;
            }
            this.f9209a.remove(b2);
        }
    }
}
