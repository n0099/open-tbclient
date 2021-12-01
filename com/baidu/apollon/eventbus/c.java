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
/* loaded from: classes8.dex */
public final class c extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32969b;

    /* renamed from: c  reason: collision with root package name */
    public final b f32970c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32971d;

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
        this.f32970c = bVar;
        this.f32969b = i2;
        this.a = new e();
    }

    public void a(g gVar, EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, gVar, event) == null) {
            d a = d.a(gVar, event);
            synchronized (this) {
                this.a.a(a);
                if (!this.f32971d) {
                    this.f32971d = true;
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
                    d a = this.a.a();
                    if (a == null) {
                        synchronized (this) {
                            a = this.a.a();
                            if (a == null) {
                                this.f32971d = false;
                                return;
                            }
                        }
                    }
                    this.f32970c.a(a);
                } while (SystemClock.uptimeMillis() - uptimeMillis < this.f32969b);
                if (sendMessage(obtainMessage())) {
                    this.f32971d = true;
                    return;
                }
                throw new EventBusException("Could not send handler message");
            } finally {
                this.f32971d = false;
            }
        }
    }
}
