package c.a.n0.a.o0;

import androidx.annotation.NonNull;
import c.a.n0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b implements c.a.n0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Queue<c> f7516b;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.n0.a.o0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0324b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f7517a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1548865100, "Lc/a/n0/a/o0/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1548865100, "Lc/a/n0/a/o0/b$b;");
                    return;
                }
            }
            f7517a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0324b.f7517a : (b) invokeV.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.f7516b.clear();
            }
        }
    }

    public synchronized void c(@NonNull c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str) == null) {
            synchronized (this) {
                while (this.f7516b.size() > 0) {
                    c peek = this.f7516b.peek();
                    if (peek == null) {
                        this.f7516b.remove();
                    } else if (peek.a()) {
                        break;
                    } else {
                        this.f7516b.remove();
                    }
                }
                int size = this.f7516b.size();
                if (size == 0) {
                    this.f7516b.offer(cVar);
                    q0.d0(cVar);
                } else {
                    c peek2 = this.f7516b.peek();
                    this.f7516b.offer(cVar);
                    if (size == 1 && peek2 != null && peek2.b(str)) {
                        q0.d0(cVar);
                    } else {
                        q0.q().post(cVar);
                    }
                }
            }
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
        this.f7516b = new ConcurrentLinkedQueue();
    }
}
