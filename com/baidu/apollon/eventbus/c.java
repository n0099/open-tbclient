package com.baidu.apollon.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class c extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f3712a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3713b;

    /* renamed from: c  reason: collision with root package name */
    public final b f3714c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3715d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper, int i2) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, looper, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3714c = bVar;
        this.f3713b = i2;
        this.f3712a = new e();
    }

    public void a(g gVar, EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, gVar, event) == null) {
            d a2 = d.a(gVar, event);
            synchronized (this) {
                this.f3712a.a(a2);
                if (!this.f3715d) {
                    this.f3715d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new EventBusException("Could not send handler message");
                    }
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                do {
                    d a2 = this.f3712a.a();
                    if (a2 == null) {
                        synchronized (this) {
                            a2 = this.f3712a.a();
                            if (a2 == null) {
                                this.f3715d = false;
                                return;
                            }
                        }
                    }
                    this.f3714c.a(a2);
                } while (SystemClock.uptimeMillis() - uptimeMillis < this.f3713b);
                if (sendMessage(obtainMessage())) {
                    this.f3715d = true;
                    return;
                }
                throw new EventBusException("Could not send handler message");
            } finally {
                this.f3715d = false;
            }
        }
    }
}
