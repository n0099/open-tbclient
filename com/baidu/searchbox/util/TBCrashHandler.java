package com.baidu.searchbox.util;

import android.util.Log;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
/* loaded from: classes3.dex */
public class TBCrashHandler implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread.UncaughtExceptionHandler mHandler;

    public TBCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uncaughtExceptionHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = uncaughtExceptionHandler;
    }

    private boolean isLsPatchException(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, th)) == null) {
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString != null && stackTraceString.contains("com.baidu.tieba/cache/lspatch/origin") && stackTraceString.contains("java.lang.ClassNotFoundException")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isBlock(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, th)) == null) {
            try {
                boolean isLsPatchException = isLsPatchException(th);
                if (isLsPatchException) {
                    try {
                        TiebaStatic.log(new StatisticItem("tb_block_err").addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_param1", Log.getStackTraceString(th)));
                        return isLsPatchException;
                    } catch (Exception unused) {
                        return isLsPatchException;
                    }
                }
                return isLsPatchException;
            } catch (Exception unused2) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, thread, th) == null) && !isBlock(th) && (uncaughtExceptionHandler = this.mHandler) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
