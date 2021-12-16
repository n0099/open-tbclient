package c.b.a.a;

import c.b.b.q.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public c.b.b.q.a<f> f27684b;

    /* renamed from: c  reason: collision with root package name */
    public c.b.a.c.b<f> f27685c;

    /* renamed from: d  reason: collision with root package name */
    public w<Class<?>, f> f27686d;

    /* renamed from: e  reason: collision with root package name */
    public c f27687e;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b implements Comparator<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, fVar2)) == null) {
                int i2 = fVar.f27659e;
                int i3 = fVar2.f27659e;
                if (i2 > i3) {
                    return 1;
                }
                return i2 == i3 ? 0 : -1;
            }
            return invokeLL.intValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(f fVar);

        void b(f fVar);
    }

    public j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new b(null);
        c.b.b.q.a<f> aVar = new c.b.b.q.a<>(true, 16);
        this.f27684b = aVar;
        this.f27685c = new c.b.a.c.b<>(aVar);
        this.f27686d = new w<>();
        this.f27687e = cVar;
    }

    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            Class<?> cls = fVar.getClass();
            f b2 = b(cls);
            if (b2 != null) {
                d(b2);
            }
            this.f27684b.a(fVar);
            this.f27686d.i(cls, fVar);
            this.f27684b.sort(this.a);
            this.f27687e.b(fVar);
        }
    }

    public <T extends f> T b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? (T) this.f27686d.c(cls) : (T) invokeL.objValue;
    }

    public c.b.a.c.b<f> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27685c : (c.b.a.c.b) invokeV.objValue;
    }

    public void d(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) && this.f27684b.i(fVar, true)) {
            this.f27686d.k(fVar.getClass());
            this.f27687e.a(fVar);
        }
    }
}
