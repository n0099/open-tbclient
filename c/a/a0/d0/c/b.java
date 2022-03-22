package c.a.a0.d0.c;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.executor.BaseExecutorCell;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public abstract class b extends BaseExecutorCell {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1117d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1117d = false;
    }

    @Override // com.baidu.nadcore.thread.executor.BaseExecutorCell
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1117d && e() < this.f27643b : invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.thread.executor.BaseExecutorCell
    public void g(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, elasticTask) == null) {
            super.g(elasticTask);
            if (this.f1117d) {
                c.a.a0.d0.f.c.f().k();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f1117d) {
                Log.w(d(), "This executor cell is already opened.");
                return;
            }
            this.f1117d = true;
            this.f27644c.setKeepAliveTime(5000L, TimeUnit.MILLISECONDS);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.f1117d) {
                Log.w(d(), "This executor cell is already shutdown.");
                return;
            }
            this.f1117d = false;
            this.f27644c.setKeepAliveTime(100L, TimeUnit.MILLISECONDS);
        }
    }
}
