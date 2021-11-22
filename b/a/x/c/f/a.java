package b.a.x.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import b.a.x.c.g.c;
import b.a.x.c.g.d;
import b.a.x.c.g.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f30312a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f30313b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.x.c.g.a f30314c;

    /* renamed from: d  reason: collision with root package name */
    public e f30315d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f30316e;

    /* renamed from: b.a.x.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1460a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f30317a;

        /* renamed from: b  reason: collision with root package name */
        public int f30318b;

        /* renamed from: c  reason: collision with root package name */
        public long f30319c;

        public C1460a(a aVar, ByteBuffer byteBuffer, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, byteBuffer, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30317a = byteBuffer;
            this.f30318b = i2;
            this.f30319c = j;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30320a;

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
            this.f30320a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        this.f30320a.k((d) message.obj);
                        return;
                    case 1002:
                        this.f30320a.l();
                        return;
                    case 1003:
                        C1460a c1460a = (C1460a) message.obj;
                        this.f30320a.h(c1460a.f30317a, c1460a.f30318b, c1460a.f30319c);
                        return;
                    case 1004:
                        this.f30320a.m();
                        return;
                    case 1005:
                        this.f30320a.j();
                        return;
                    case 1006:
                        this.f30320a.i();
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-221288979, "Lb/a/x/c/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-221288979, "Lb/a/x/c/f/a;");
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
        this.f30316e = false;
    }

    public void g(ByteBuffer byteBuffer, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) || byteBuffer == null || i2 <= 0) {
            return;
        }
        C1460a c1460a = new C1460a(this, byteBuffer, i2, j);
        if (this.f30313b == null || !this.f30316e) {
            return;
        }
        Handler handler = this.f30313b;
        handler.sendMessage(handler.obtainMessage(1003, c1460a));
    }

    public final void h(ByteBuffer byteBuffer, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f30314c.a(false, byteBuffer, i2, j);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.f30313b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f30313b = null;
            }
            HandlerThread handlerThread = this.f30312a;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f30312a = null;
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        b.a.x.c.g.a aVar = this.f30314c;
        if (aVar != null) {
            aVar.i();
            this.f30314c.e();
        }
        this.f30314c = null;
        this.f30315d = null;
    }

    public final void k(d dVar) {
        b.a.x.c.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || Build.VERSION.SDK_INT < 18 || (aVar = this.f30314c) == null) {
            return;
        }
        aVar.k(dVar, this.f30315d);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f30314c.h();
    }

    public final void m() {
        b.a.x.c.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 18 || (aVar = this.f30314c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, cVar) == null) {
            HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
            this.f30312a = handlerThread;
            handlerThread.start();
            this.f30313b = new b(this, this.f30312a.getLooper());
            try {
                this.f30314c = new b.a.x.c.g.a();
            } catch (VerifyError unused) {
                if (this.f30314c == null) {
                    return;
                }
            }
            this.f30315d = eVar;
            if (Build.VERSION.SDK_INT >= 18) {
                this.f30314c.f(cVar);
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HandlerThread handlerThread = this.f30312a;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void p() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (handler = this.f30313b) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.f30313b;
        handler2.sendMessage(handler2.obtainMessage(1005));
        Handler handler3 = this.f30313b;
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
            Handler handler = this.f30313b;
            handler.sendMessage(handler.obtainMessage(1001, dVar));
            this.f30316e = true;
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void r() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (handler = this.f30313b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f30313b != null && this.f30316e) {
            this.f30316e = false;
            Handler handler = this.f30313b;
            handler.sendMessage(handler.obtainMessage(1004));
        }
    }
}
