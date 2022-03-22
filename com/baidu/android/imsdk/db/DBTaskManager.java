package com.baidu.android.imsdk.db;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public class DBTaskManager {
    public static /* synthetic */ Interceptable $ic;
    public static DBTaskManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService writeService;

    public DBTaskManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.writeService = Executors.newSingleThreadExecutor();
    }

    public static synchronized DBTaskManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (DBTaskManager.class) {
                if (context == null) {
                    return null;
                }
                if (mInstance == null) {
                    mInstance = new DBTaskManager(context);
                }
                return mInstance;
            }
        }
        return (DBTaskManager) invokeL.objValue;
    }

    public <T> Future<T> submitForInsertOperation(Runnable runnable, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, runnable, t)) == null) ? this.writeService.submit(runnable, t) : (Future) invokeLL.objValue;
    }
}
