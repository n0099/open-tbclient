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
    public Handler f40640a;

    /* renamed from: b  reason: collision with root package name */
    public Object f40641b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40642c;

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
        this.f40640a = null;
        this.f40641b = new Object();
        this.f40642c = false;
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
        this.f40640a = null;
        this.f40641b = new Object();
        this.f40642c = false;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (a.f40614a) {
                a.a("Looper thread quit()");
            }
            this.f40640a.getLooper().quit();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f40641b) {
                try {
                    if (!this.f40642c) {
                        this.f40641b.wait();
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
            synchronized (this.f40641b) {
                this.f40642c = true;
                this.f40641b.notifyAll();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Looper.prepare();
            this.f40640a = new Handler();
            if (a.f40614a) {
                a.a("new Handler() finish!!");
            }
            Looper.loop();
            if (a.f40614a) {
                a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
            }
        }
    }
}
