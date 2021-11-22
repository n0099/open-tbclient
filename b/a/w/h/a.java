package b.a.w.h;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final b.a.w.j.b f30194a;

    /* renamed from: b  reason: collision with root package name */
    public static final b.a.w.a.c f30195b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.w.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1457a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b<T> m;
        public c<T> n;

        public C1457a(b<T> bVar, c<T> cVar) {
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
                    b.a.w.j.a.c(th);
                    return null;
                }
            }
            return (T) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-788486304, "Lb/a/w/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-788486304, "Lb/a/w/h/a;");
                return;
            }
        }
        f30194a = b.a.w.j.b.a();
        f30195b = new b.a.w.a.c(BdAsyncTaskParallelType.SERIAL, f30194a);
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
                C1457a c1457a = new C1457a(bVar, cVar);
                c1457a.v(f30195b);
                c1457a.x(f30194a);
                c1457a.w(i2);
                c1457a.g(new String[0]);
                return c1457a;
            }
            return null;
        }
        return (BdAsyncTask) invokeLLI.objValue;
    }
}
