package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f40529a;

    /* renamed from: b  reason: collision with root package name */
    public Object f40530b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40531c;

    public m() {
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
        this.f40529a = null;
        this.f40530b = new Object();
        this.f40531c = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40529a = null;
        this.f40530b = new Object();
        this.f40531c = false;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (a.f40503a) {
                a.a("Looper thread quit()");
            }
            this.f40529a.getLooper().quit();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f40530b) {
                try {
                    if (!this.f40531c) {
                        this.f40530b.wait();
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.f40530b) {
                this.f40531c = true;
                this.f40530b.notifyAll();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Looper.prepare();
            this.f40529a = new Handler();
            if (a.f40503a) {
                a.a("new Handler() finish!!");
            }
            Looper.loop();
            if (a.f40503a) {
                a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
            }
        }
    }
}
