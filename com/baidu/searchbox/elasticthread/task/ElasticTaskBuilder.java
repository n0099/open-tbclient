package com.baidu.searchbox.elasticthread.task;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ElasticTaskBuilder {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ElasticTaskBuilder sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public long currentTaskId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-421466406, "Lcom/baidu/searchbox/elasticthread/task/ElasticTaskBuilder;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-421466406, "Lcom/baidu/searchbox/elasticthread/task/ElasticTaskBuilder;");
        }
    }

    public ElasticTaskBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.currentTaskId = 0L;
    }

    public static ElasticTaskBuilder getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (ElasticTaskBuilder.class) {
                    if (sInstance == null) {
                        sInstance = new ElasticTaskBuilder();
                    }
                }
            }
            return sInstance;
        }
        return (ElasticTaskBuilder) invokeV.objValue;
    }

    public ElasticTask build(@NonNull Runnable runnable, @NonNull String str, int i) {
        InterceptResult invokeLLI;
        ElasticTask elasticTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, runnable, str, i)) == null) {
            if (runnable != null && !TextUtils.isEmpty(str)) {
                synchronized (this) {
                    long j = this.currentTaskId + 1;
                    this.currentTaskId = j;
                    elasticTask = new ElasticTask(runnable, str, j, i);
                }
                return elasticTask;
            }
            throw new IllegalArgumentException("illegal params");
        }
        return (ElasticTask) invokeLLI.objValue;
    }
}
