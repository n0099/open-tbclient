package com.baidu.searchbox.elasticthread;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public abstract class ExecutorProxy implements Executor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDefaultPriority;
    public String mDefaultTaskName;

    @Override // java.util.concurrent.Executor
    public abstract void execute(@NonNull Runnable runnable);

    public abstract void execute(@NonNull Runnable runnable, @NonNull String str);

    public abstract void execute(@NonNull Runnable runnable, @NonNull String str, int i);

    public ExecutorProxy(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDefaultPriority = i;
        this.mDefaultTaskName = str;
    }

    public void setDefaultPriority(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.mDefaultPriority = i;
        }
    }

    public void setDefaultTaskName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mDefaultTaskName = str;
        }
    }
}
