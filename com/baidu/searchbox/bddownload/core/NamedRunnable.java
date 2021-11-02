package com.baidu.searchbox.bddownload.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class NamedRunnable implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String name;

    public NamedRunnable(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.name = str;
    }

    public abstract void execute() throws InterruptedException;

    public abstract void finished();

    public abstract void interrupted(InterruptedException interruptedException);

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName(this.name);
            try {
                try {
                    execute();
                } catch (InterruptedException e2) {
                    interrupted(e2);
                }
            } finally {
                Thread.currentThread().setName(name);
                finished();
            }
        }
    }
}
