package c.a.x.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.x.c.g.c;
import c.a.x.c.g.d;
import c.a.x.c.g.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f31036a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f31037b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.x.c.g.a f31038c;

    /* renamed from: d  reason: collision with root package name */
    public e f31039d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f31040e;

    /* renamed from: c.a.x.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1437a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f31041a;

        /* renamed from: b  reason: collision with root package name */
        public int f31042b;

        /* renamed from: c  reason: collision with root package name */
        public long f31043c;

        public C1437a(a aVar, ByteBuffer byteBuffer, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31041a = byteBuffer;
            this.f31042b = i2;
            this.f31043c = j2;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31044a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31044a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        this.f31044a.k((d) message.obj);
                        return;
                    case 1002:
                        this.f31044a.l();
                        return;
                    case 1003:
                        C1437a c1437a = (C1437a) message.obj;
                        this.f31044a.h(c1437a.f31041a, c1437a.f31042b, c1437a.f31043c);
                        return;
                    case 1004:
                        this.f31044a.m();
                        return;
                    case 1005:
                        this.f31044a.j();
                        return;
                    case 1006:
                        this.f31044a.i();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-92206260, "Lc/a/x/c/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-92206260, "Lc/a/x/c/f/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31040e = false;
    }

    public void g(ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || byteBuffer == null || i2 <= 0) {
            return;
        }
        C1437a c1437a = new C1437a(this, byteBuffer, i2, j2);
        if (this.f31037b == null || !this.f31040e) {
            return;
        }
        Handler handler = this.f31037b;
        handler.sendMessage(handler.obtainMessage(1003, c1437a));
    }

    public final void h(ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f31038c.a(false, byteBuffer, i2, j2);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.f31037b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f31037b = null;
            }
            HandlerThread handlerThread = this.f31036a;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f31036a = null;
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        c.a.x.c.g.a aVar = this.f31038c;
        if (aVar != null) {
            aVar.i();
            this.f31038c.e();
        }
        this.f31038c = null;
        this.f31039d = null;
    }

    public final void k(d dVar) {
        c.a.x.c.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || Build.VERSION.SDK_INT < 18 || (aVar = this.f31038c) == null) {
            return;
        }
        aVar.k(dVar, this.f31039d);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f31038c.h();
    }

    public final void m() {
        c.a.x.c.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 18 || (aVar = this.f31038c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, cVar) == null) {
            HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
            this.f31036a = handlerThread;
            handlerThread.start();
            this.f31037b = new b(this, this.f31036a.getLooper());
            try {
                this.f31038c = new c.a.x.c.g.a();
            } catch (VerifyError unused) {
                if (this.f31038c == null) {
                    return;
                }
            }
            this.f31039d = eVar;
            if (Build.VERSION.SDK_INT >= 18) {
                this.f31038c.f(cVar);
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HandlerThread handlerThread = this.f31036a;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void p() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (handler = this.f31037b) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.f31037b;
        handler2.sendMessage(handler2.obtainMessage(1005));
        Handler handler3 = this.f31037b;
        handler3.sendMessage(handler3.obtainMessage(1006));
    }

    public boolean q(d dVar, e eVar, c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, dVar, eVar, cVar)) == null) {
            if (o()) {
                return false;
            }
            n(eVar, cVar);
            Handler handler = this.f31037b;
            handler.sendMessage(handler.obtainMessage(1001, dVar));
            this.f31040e = true;
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void r() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (handler = this.f31037b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f31037b != null && this.f31040e) {
            this.f31040e = false;
            Handler handler = this.f31037b;
            handler.sendMessage(handler.obtainMessage(1004));
        }
    }
}
