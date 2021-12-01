package c.a.w.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final c.a.w.j.b a;

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.w.a.c f26672b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.w.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1521a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b<T> m;
        public c<T> n;

        public C1521a(b<T> bVar, c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = null;
            this.n = null;
            this.m = bVar;
            this.n = cVar;
        }

        @Override // com.baidu.live.asynctask.BdAsyncTask
        public void q(T t) {
            c<T> cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || (cVar = this.n) == null) {
                return;
            }
            cVar.onReturnDataInUI(t);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.asynctask.BdAsyncTask
        /* renamed from: z */
        public T f(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                try {
                    if (this.m != null) {
                        return this.m.a();
                    }
                    return null;
                } catch (Throwable th) {
                    c.a.w.j.a.c(th);
                    return null;
                }
            }
            return (T) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-984999809, "Lc/a/w/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-984999809, "Lc/a/w/h/a;");
                return;
            }
        }
        a = c.a.w.j.b.a();
        f26672b = new c.a.w.a.c(BdAsyncTaskParallelType.SERIAL, a);
    }

    public static <T> BdAsyncTask a(b<T> bVar, c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bVar, cVar)) == null) ? b(bVar, cVar, 2) : (BdAsyncTask) invokeLL.objValue;
    }

    public static <T> BdAsyncTask b(b<T> bVar, c<T> cVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, bVar, cVar, i2)) == null) {
            if (bVar != null) {
                C1521a c1521a = new C1521a(bVar, cVar);
                c1521a.v(f26672b);
                c1521a.x(a);
                c1521a.w(i2);
                c1521a.g(new String[0]);
                return c1521a;
            }
            return null;
        }
        return (BdAsyncTask) invokeLLI.objValue;
    }
}
