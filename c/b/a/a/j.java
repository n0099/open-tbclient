package c.b.a.a;

import c.b.b.q.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public c.b.b.q.a<f> f22322b;

    /* renamed from: c  reason: collision with root package name */
    public c.b.a.c.b<f> f22323c;

    /* renamed from: d  reason: collision with root package name */
    public w<Class<?>, f> f22324d;

    /* renamed from: e  reason: collision with root package name */
    public c f22325e;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b implements Comparator<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = fVar.a;
                int i2 = fVar2.a;
                if (i > i2) {
                    return 1;
                }
                return i == i2 ? 0 : -1;
            }
            return invokeLL.intValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new b(null);
        c.b.b.q.a<f> aVar = new c.b.b.q.a<>(true, 16);
        this.f22322b = aVar;
        this.f22323c = new c.b.a.c.b<>(aVar);
        this.f22324d = new w<>();
        this.f22325e = cVar;
    }

    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            Class<?> cls = fVar.getClass();
            f b2 = b(cls);
            if (b2 != null) {
                d(b2);
            }
            this.f22322b.a(fVar);
            this.f22324d.i(cls, fVar);
            this.f22322b.sort(this.a);
            this.f22325e.b(fVar);
        }
    }

    public <T extends f> T b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? (T) this.f22324d.c(cls) : (T) invokeL.objValue;
    }

    public c.b.a.c.b<f> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22323c : (c.b.a.c.b) invokeV.objValue;
    }

    public void d(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) && this.f22322b.j(fVar, true)) {
            this.f22324d.k(fVar.getClass());
            this.f22325e.a(fVar);
        }
    }
}
