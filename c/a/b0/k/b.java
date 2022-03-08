package c.a.b0.k;

import c.a.b0.k.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class b implements h, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentLinkedQueue<j.b<?>> f1669e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f1670f;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1538392293, "Lc/a/b0/k/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1538392293, "Lc/a/b0/k/b$a;");
                    return;
                }
            }
            a = new b();
        }
    }

    public b() {
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
        this.f1669e = new ConcurrentLinkedQueue<>();
        this.f1670f = new AtomicBoolean(false);
    }

    public static h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (h) invokeV.objValue;
    }

    @Override // c.a.b0.k.h
    public <T extends f> void a(k kVar, i<T> iVar, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, kVar, iVar, t) == null) {
            if (c.a.b0.h.k.a()) {
                this.f1669e.offer(new j.b<>(kVar, iVar, t));
                if (this.f1670f.compareAndSet(false, true)) {
                    c.a.b0.d0.b.c(this, "BackgroundDeliver", 3);
                    return;
                }
                return;
            }
            iVar.onEvent(t);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        while (true) {
            j.b<?> poll = this.f1669e.poll();
            if (poll != null) {
                poll.a.onEvent(poll.f1675b);
            } else {
                this.f1670f.set(false);
                return;
            }
        }
    }
}
