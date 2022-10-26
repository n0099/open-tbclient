package com.baidu.searchbox.logsystem.basic.javacrash;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class BaseProcessExceptionListener implements ProcessExceptionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProcessExceptionFail(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th, Throwable th2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, uncaughtExceptionHandler, th, th2) == null) {
        }
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProcessExceptionStart(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uncaughtExceptionHandler, th) == null) {
        }
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProcessExceptionSuccess(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uncaughtExceptionHandler, th) == null) {
        }
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProxyProcessExceptionFail(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th, Throwable th2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, uncaughtExceptionHandler, th, th2) == null) {
        }
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProxyProcessExceptionStart(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, uncaughtExceptionHandler, th) == null) {
        }
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener
    public void onProxyProcessExceptionSuccess(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, uncaughtExceptionHandler, th) == null) {
        }
    }

    public BaseProcessExceptionListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
