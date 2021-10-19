package c.a.w.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.w.j.b f30435a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallelType f30436b;

    /* renamed from: c  reason: collision with root package name */
    public int f30437c;

    public c(BdAsyncTaskParallelType bdAsyncTaskParallelType, c.a.w.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdAsyncTaskParallelType, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30435a = null;
        this.f30436b = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.f30437c = 1;
        if (bdAsyncTaskParallelType != null && bVar != null) {
            this.f30436b = bdAsyncTaskParallelType;
            this.f30435a = bVar;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30437c : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.w.j.b bVar = this.f30435a;
            if (bVar == null) {
                return 0;
            }
            return bVar.b();
        }
        return invokeV.intValue;
    }

    public BdAsyncTaskParallelType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30436b : (BdAsyncTaskParallelType) invokeV.objValue;
    }
}
