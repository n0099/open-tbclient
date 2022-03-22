package c.a.n0.a.o1.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
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
    public static final boolean f5587d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f5588e;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, c.a.n0.a.o1.a.b.c.a<c.a.n0.a.o1.a.b.a.b>> a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f5589b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0397a f5590c;

    /* renamed from: c.a.n0.a.o1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class HandlerC0397a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0397a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public WeakReference<a> a;

        /* renamed from: b  reason: collision with root package name */
        public String f5591b;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(aVar);
            this.f5591b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.a.get()) == null) {
                return;
            }
            if (a.f5587d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.f5591b);
            }
            c.a.n0.a.o1.a.b.a.b bVar = new c.a.n0.a.o1.a.b.a.b(this.f5591b);
            bVar.setResult(null);
            aVar.c(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1427687814, "Lc/a/n0/a/o1/a/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1427687814, "Lc/a/n0/a/o1/a/b/b/a;");
                return;
            }
        }
        f5587d = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
        this.f5589b = new ConcurrentHashMap<>();
        this.f5590c = new HandlerC0397a(Looper.getMainLooper());
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f5588e == null) {
                synchronized (a.class) {
                    if (f5588e == null) {
                        f5588e = new a();
                    }
                }
            }
            return f5588e;
        }
        return (a) invokeV.objValue;
    }

    public void c(@NonNull c.a.n0.a.o1.a.b.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            c.a.n0.a.o1.a.b.c.a<c.a.n0.a.o1.a.b.a.b> aVar = this.a.get(bVar.b());
            if (aVar == null) {
                if (f5587d) {
                    Log.e("MDelegate-Observe", "notify a null observer");
                    return;
                }
                return;
            }
            String b2 = aVar.b();
            if (f5587d) {
                Log.d("MDelegate-Observe", "notify observer: " + b2);
            }
            aVar.onEvent(bVar);
            if (this.f5589b.containsKey(b2)) {
                if (f5587d) {
                    Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
                }
                this.f5590c.removeCallbacks(this.f5589b.get(b2));
                this.f5589b.remove(b2);
            }
            if (aVar.c()) {
                if (f5587d) {
                    Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
                }
                f(aVar);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f5587d) {
                Log.d("MDelegate-Observe", "release observable");
            }
            if (f5588e == null) {
                return;
            }
            this.a.clear();
            for (Map.Entry<String, Runnable> entry : this.f5589b.entrySet()) {
                if (f5587d) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.f5590c.removeCallbacks(entry.getValue());
            }
            this.f5589b.clear();
            f5588e = null;
        }
    }

    public void e(c.a.n0.a.o1.a.b.c.a<c.a.n0.a.o1.a.b.a.b> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (aVar == null) {
                if (f5587d) {
                    Log.e("MDelegate-Observe", "register a null observer");
                    return;
                }
                return;
            }
            String b2 = aVar.b();
            if (this.a.containsKey(b2)) {
                if (f5587d) {
                    Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                    return;
                }
                return;
            }
            if (f5587d) {
                Log.d("MDelegate-Observe", "register observer: " + b2);
            }
            this.a.put(b2, aVar);
            long a = aVar.a();
            if (a <= 0 || !aVar.c()) {
                return;
            }
            if (f5587d) {
                Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a + "ms timeout runnable");
            }
            b bVar = new b(this, b2);
            this.f5589b.put(b2, bVar);
            this.f5590c.postDelayed(bVar, a);
        }
    }

    public void f(c.a.n0.a.o1.a.b.c.a<c.a.n0.a.o1.a.b.a.b> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar == null) {
                if (f5587d) {
                    Log.e("MDelegate-Observe", "unregister a null observer");
                    return;
                }
                return;
            }
            String b2 = aVar.b();
            if (!this.a.containsKey(b2)) {
                if (f5587d) {
                    Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                    return;
                }
                return;
            }
            if (f5587d) {
                Log.d("MDelegate-Observe", "unregister observer: " + b2);
            }
            this.a.remove(b2);
        }
    }
}
