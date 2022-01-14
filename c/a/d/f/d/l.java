package c.a.d.f.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface l<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(String str, T t);
    }

    /* loaded from: classes.dex */
    public static class b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public T f2728b;

        /* renamed from: c  reason: collision with root package name */
        public long f2729c;

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
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c<T> extends l<T> {
        void b();

        k<T> c();

        String j();
    }

    void a(String str, T t);

    void d(String str);

    void e(String str, T t, long j2);

    void f(String str, a<T> aVar);

    void g(String str, T t);

    T get(String str);

    b<T> h(String str);

    void i(String str, T t, long j2);

    void remove(String str);
}
