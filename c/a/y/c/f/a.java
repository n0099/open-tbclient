package c.a.y.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.y.c.g.c;
import c.a.y.c.g.d;
import c.a.y.c.g.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f27170b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.y.c.g.a f27171c;

    /* renamed from: d  reason: collision with root package name */
    public e f27172d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f27173e;

    /* renamed from: c.a.y.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1566a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer a;

        /* renamed from: b  reason: collision with root package name */
        public int f27174b;

        /* renamed from: c  reason: collision with root package name */
        public long f27175c;

        public C1566a(a aVar, ByteBuffer byteBuffer, int i2, long j2) {
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
            this.a = byteBuffer;
            this.f27174b = i2;
            this.f27175c = j2;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        this.a.k((d) message.obj);
                        return;
                    case 1002:
                        this.a.l();
                        return;
                    case 1003:
                        C1566a c1566a = (C1566a) message.obj;
                        this.a.h(c1566a.a, c1566a.f27174b, c1566a.f27175c);
                        return;
                    case 1004:
                        this.a.m();
                        return;
                    case 1005:
                        this.a.j();
                        return;
                    case 1006:
                        this.a.i();
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1650604075, "Lc/a/y/c/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1650604075, "Lc/a/y/c/f/a;");
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
        this.f27173e = false;
    }

    public void g(ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || byteBuffer == null || i2 <= 0) {
            return;
        }
        C1566a c1566a = new C1566a(this, byteBuffer, i2, j2);
        if (this.f27170b == null || !this.f27173e) {
            return;
        }
        Handler handler = this.f27170b;
        handler.sendMessage(handler.obtainMessage(1003, c1566a));
    }

    public final void h(ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f27171c.a(false, byteBuffer, i2, j2);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.f27170b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f27170b = null;
            }
            HandlerThread handlerThread = this.a;
            if (handlerThread != null) {
                handlerThread.quit();
                this.a = null;
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        c.a.y.c.g.a aVar = this.f27171c;
        if (aVar != null) {
            aVar.i();
            this.f27171c.e();
        }
        this.f27171c = null;
        this.f27172d = null;
    }

    public final void k(d dVar) {
        c.a.y.c.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || Build.VERSION.SDK_INT < 18 || (aVar = this.f27171c) == null) {
            return;
        }
        aVar.k(dVar, this.f27172d);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f27171c.h();
    }

    public final void m() {
        c.a.y.c.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 18 || (aVar = this.f27171c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, cVar) == null) {
            HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
            this.a = handlerThread;
            handlerThread.start();
            this.f27170b = new b(this, this.a.getLooper());
            try {
                this.f27171c = new c.a.y.c.g.a();
            } catch (VerifyError unused) {
                if (this.f27171c == null) {
                    return;
                }
            }
            this.f27172d = eVar;
            if (Build.VERSION.SDK_INT >= 18) {
                this.f27171c.f(cVar);
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HandlerThread handlerThread = this.a;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void p() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (handler = this.f27170b) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.f27170b;
        handler2.sendMessage(handler2.obtainMessage(1005));
        Handler handler3 = this.f27170b;
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
            Handler handler = this.f27170b;
            handler.sendMessage(handler.obtainMessage(1001, dVar));
            this.f27173e = true;
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void r() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (handler = this.f27170b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f27170b != null && this.f27173e) {
            this.f27173e = false;
            Handler handler = this.f27170b;
            handler.sendMessage(handler.obtainMessage(1004));
        }
    }
}
