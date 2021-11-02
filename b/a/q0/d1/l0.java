package b.a.q0.d1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f12136a;

    /* renamed from: b  reason: collision with root package name */
    public static final BdAsyncTaskParallel f12137b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public i0<T> f12138a;

        /* renamed from: b  reason: collision with root package name */
        public q<T> f12139b;

        public a(i0<T> i0Var, q<T> qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var, qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12138a = null;
            this.f12139b = null;
            this.f12138a = i0Var;
            this.f12139b = qVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public T doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    if (this.f12138a != null) {
                        return this.f12138a.doInBackground();
                    }
                    return null;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return null;
                }
            }
            return (T) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            q<T> qVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || (qVar = this.f12139b) == null) {
                return;
            }
            qVar.onReturnDataInUI(t);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1507956158, "Lb/a/q0/d1/l0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1507956158, "Lb/a/q0/d1/l0;");
                return;
            }
        }
        f12136a = BdUniqueId.gen();
        f12137b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f12136a);
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            BdAsyncTask.removeAllTask(f12136a);
        }
    }

    public static <T> void b(i0<T> i0Var, q<T> qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, i0Var, qVar) == null) || i0Var == null) {
            return;
        }
        a aVar = new a(i0Var, qVar);
        aVar.setParallel(f12137b);
        aVar.setTag(f12136a);
        aVar.setPriority(4);
        aVar.execute(new String[0]);
    }

    public static <T> void c(i0<T> i0Var, q<T> qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, i0Var, qVar) == null) || i0Var == null) {
            return;
        }
        a aVar = new a(i0Var, qVar);
        aVar.setParallel(TiebaIMConfig.getParallel());
        aVar.setTag(f12136a);
        aVar.setPriority(4);
        aVar.execute(new String[0]);
    }
}
