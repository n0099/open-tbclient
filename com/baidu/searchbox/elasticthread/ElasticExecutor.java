package com.baidu.searchbox.elasticthread;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes11.dex */
public class ElasticExecutor extends ExecutorProxy {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final int TASK_PRIORITY_BACKGROUND = 3;
    @Deprecated
    public static final int TASK_PRIORITY_DEFAULT = 3;
    @Deprecated
    public static final int TASK_PRIORITY_INTIME = 2;
    @Deprecated
    public static final int TASK_PRIORITY_USER_RELATED = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElasticExecutor(String str, int i2) {
        super(str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy, java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            execute(runnable, this.mDefaultTaskName, this.mDefaultPriority);
        }
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy
    public void execute(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, str) == null) {
            execute(runnable, str, this.mDefaultPriority);
        }
    }

    @Override // com.baidu.searchbox.elasticthread.ExecutorProxy
    public void execute(@NonNull Runnable runnable, @NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, runnable, str, i2) == null) {
            ExecutorUtilsExt.postOnElastic(runnable, str, i2);
        }
    }
}
