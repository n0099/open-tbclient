package b.e.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.eventbus.EventBusException;
/* loaded from: classes6.dex */
public final class c extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f31528a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31529b;

    /* renamed from: c  reason: collision with root package name */
    public final b f31530c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31531d;

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
        this.f31530c = bVar;
        this.f31529b = i2;
        this.f31528a = new e();
    }

    public void a(g gVar, EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, gVar, event) == null) {
            d a2 = d.a(gVar, event);
            synchronized (this) {
                this.f31528a.b(a2);
                if (!this.f31531d) {
                    this.f31531d = true;
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
                    d a2 = this.f31528a.a();
                    if (a2 == null) {
                        synchronized (this) {
                            a2 = this.f31528a.a();
                            if (a2 == null) {
                                this.f31531d = false;
                                return;
                            }
                        }
                    }
                    this.f31530c.d(a2);
                } while (SystemClock.uptimeMillis() - uptimeMillis < this.f31529b);
                if (sendMessage(obtainMessage())) {
                    this.f31531d = true;
                    return;
                }
                throw new EventBusException("Could not send handler message");
            } finally {
                this.f31531d = false;
            }
        }
    }
}
