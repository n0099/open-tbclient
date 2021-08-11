package com.baidu.searchbox.logsystem.javacrash;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "loki-java-UncaughtExceptionHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public Thread.UncaughtExceptionHandler mPreHandler;
    public List<ProcessExceptionListener> mProcessExceptionListeners;

    public UncaughtExceptionHandler(@Nullable List<ProcessExceptionListener> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPreHandler = null;
        if (0 == 0) {
            this.mPreHandler = Thread.getDefaultUncaughtExceptionHandler();
        }
        this.mProcessExceptionListeners = list;
    }

    public abstract void processException(@NonNull Thread thread, @NonNull Throwable th);

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        List<ProcessExceptionListener> list;
        List<ProcessExceptionListener> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thread, th) == null) {
            Log.getStackTraceString(th);
            List<ProcessExceptionListener> list3 = this.mProcessExceptionListeners;
            boolean z = list3 != null && list3.size() > 0;
            if (z) {
                try {
                    if (this.mProcessExceptionListeners != null) {
                        for (ProcessExceptionListener processExceptionListener : this.mProcessExceptionListeners) {
                            if (processExceptionListener != null) {
                                processExceptionListener.onProcessExceptionStart(this, th);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    if (LLog.sDebug) {
                        th2.printStackTrace();
                    }
                    if (z && (list2 = this.mProcessExceptionListeners) != null) {
                        for (ProcessExceptionListener processExceptionListener2 : list2) {
                            if (processExceptionListener2 != null) {
                                try {
                                    processExceptionListener2.onProcessExceptionFail(this, th, th2);
                                } catch (Throwable th3) {
                                    if (LLog.sDebug) {
                                        Log.getStackTraceString(th3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            processException(thread, th);
            if (z && this.mProcessExceptionListeners != null) {
                for (ProcessExceptionListener processExceptionListener3 : this.mProcessExceptionListeners) {
                    if (processExceptionListener3 != null) {
                        processExceptionListener3.onProcessExceptionSuccess(this, th);
                    }
                }
            }
            if (this.mPreHandler != null) {
                if (z) {
                    try {
                        if (this.mProcessExceptionListeners != null) {
                            for (ProcessExceptionListener processExceptionListener4 : this.mProcessExceptionListeners) {
                                if (processExceptionListener4 != null) {
                                    processExceptionListener4.onProxyProcessExceptionStart(this.mPreHandler, th);
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        if (LLog.sDebug) {
                            th4.printStackTrace();
                        }
                        if (!z || (list = this.mProcessExceptionListeners) == null) {
                            return;
                        }
                        for (ProcessExceptionListener processExceptionListener5 : list) {
                            if (processExceptionListener5 != null) {
                                try {
                                    processExceptionListener5.onProxyProcessExceptionFail(this.mPreHandler, th4, th4);
                                } catch (Throwable th5) {
                                    if (LLog.sDebug) {
                                        Log.getStackTraceString(th5);
                                    }
                                }
                            }
                        }
                        return;
                    }
                }
                this.mPreHandler.uncaughtException(thread, th);
                if (!z || this.mProcessExceptionListeners == null) {
                    return;
                }
                for (ProcessExceptionListener processExceptionListener6 : this.mProcessExceptionListeners) {
                    if (processExceptionListener6 != null) {
                        processExceptionListener6.onProxyProcessExceptionSuccess(this.mPreHandler, th);
                    }
                }
            }
        }
    }
}
