package com.baidu.android.util.concurrent.task;

import android.os.Looper;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ThreadWorker implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object mLockObj;
    public Looper mLooper;

    public ThreadWorker(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLockObj = new Object();
        this.mLooper = null;
        Thread thread = new Thread(null, this, str);
        thread.setPriority(1);
        thread.start();
        synchronized (this.mLockObj) {
            while (this.mLooper == null) {
                try {
                    this.mLockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Looper getLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mLooper : (Looper) invokeV.objValue;
    }

    public void join() {
        Looper looper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (looper = getLooper()) == null) {
            return;
        }
        try {
            Thread thread = looper.getThread();
            if (thread != null) {
                thread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        Thread thread;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (thread = getLooper().getThread()) == null) {
            return;
        }
        try {
            synchronized (thread) {
                thread.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void quit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mLooper.quit();
        }
    }

    public void restart() {
        Thread thread;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (thread = getLooper().getThread()) == null) {
            return;
        }
        try {
            synchronized (thread) {
                thread.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this.mLockObj) {
                Process.setThreadPriority(10);
                Looper.prepare();
                this.mLooper = Looper.myLooper();
                this.mLockObj.notifyAll();
            }
            Looper.loop();
        }
    }
}
