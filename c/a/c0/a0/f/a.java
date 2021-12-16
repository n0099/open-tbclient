package c.a.c0.a0.f;

import androidx.annotation.NonNull;
import com.baidu.nadcore.thread.executor.BaseExecutorCell;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public BaseExecutorCell a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public BaseExecutorCell f1328b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public BaseExecutorCell f1329c;

    public a() {
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
        this.a = BaseExecutorCell.b(c.a.c0.a0.a.f1317d, BaseExecutorCell.ExecutorType.ARTERY);
        this.f1328b = BaseExecutorCell.b(c.a.c0.a0.a.f1318e, BaseExecutorCell.ExecutorType.ARTERY);
        this.f1329c = BaseExecutorCell.b(c.a.c0.a0.a.f1319f, BaseExecutorCell.ExecutorType.ARTERY);
    }

    public boolean a(ElasticTask elasticTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, elasticTask)) == null) {
            int b2 = elasticTask.b();
            if (b2 == 0 || b2 == 1) {
                if (this.a.c(elasticTask) || this.f1328b.c(elasticTask)) {
                    return true;
                }
                return this.f1329c.c(elasticTask);
            } else if (b2 == 2) {
                if (this.f1328b.c(elasticTask)) {
                    return true;
                }
                return this.f1329c.c(elasticTask);
            } else if (b2 == 3) {
                return this.f1329c.c(elasticTask);
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
