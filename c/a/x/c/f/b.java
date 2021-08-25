package c.a.x.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.x.b.g.c;
import c.a.x.c.g.d;
import c.a.x.c.g.e;
import c.a.x.c.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f31045a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f31046b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.x.b.a f31047c;

    /* renamed from: d  reason: collision with root package name */
    public g f31048d;

    /* renamed from: e  reason: collision with root package name */
    public e f31049e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f31050f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31051g;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<c> f31052a;

        /* renamed from: b  reason: collision with root package name */
        public d f31053b;

        public a(b bVar, ArrayList<c> arrayList, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, arrayList, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31052a = arrayList;
            this.f31053b = dVar;
        }
    }

    /* renamed from: c.a.x.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1438b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f31054a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1438b(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
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
            this.f31054a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        a aVar = (a) message.obj;
                        this.f31054a.n(aVar.f31052a, aVar.f31053b);
                        return;
                    case 1002:
                        this.f31054a.o();
                        return;
                    case 1003:
                        this.f31054a.r((ArrayList) message.obj);
                        return;
                    case 1004:
                        this.f31054a.q((c.a.x.b.e.c) message.obj);
                        return;
                    case 1005:
                        this.f31054a.k((message.arg1 << 32) | (message.arg2 & 4294967295L));
                        return;
                    case 1006:
                        this.f31054a.p();
                        return;
                    case 1007:
                        this.f31054a.m();
                        return;
                    case 1008:
                        this.f31054a.l();
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-92206229, "Lc/a/x/c/f/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-92206229, "Lc/a/x/c/f/b;");
        }
    }

    public b() {
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
        this.f31050f = false;
        this.f31051g = false;
    }

    public void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            int i2 = (int) (j2 >> 32);
            int i3 = (int) j2;
            if (this.f31046b == null || !this.f31050f) {
                return;
            }
            Handler handler = this.f31046b;
            handler.sendMessage(handler.obtainMessage(1005, i2, i3));
            synchronized (this.f31047c) {
                try {
                    if (this.f31051g) {
                        this.f31047c.wait(12L);
                    } else {
                        this.f31047c.wait(2L);
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g gVar = this.f31048d;
            if (gVar != null) {
                return gVar.d();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void k(long j2) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f31048d) == null) {
            return;
        }
        gVar.c(false);
        this.f31047c.a(j2);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Handler handler = this.f31046b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f31046b = null;
            }
            HandlerThread handlerThread = this.f31045a;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f31045a = null;
            }
        }
    }

    public final void m() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f31048d) == null) {
            return;
        }
        gVar.i();
        this.f31048d.e();
        this.f31048d = null;
        this.f31049e = null;
        this.f31047c.c();
        this.f31047c = null;
    }

    public final void n(ArrayList<c> arrayList, d dVar) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, arrayList, dVar) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f31048d) == null) {
            return;
        }
        gVar.l(dVar, this.f31049e);
        if (this.f31047c == null) {
            this.f31047c = new c.a.x.b.a(this.f31048d.k(), arrayList);
        }
    }

    public final void o() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f31048d) == null) {
            return;
        }
        gVar.h();
    }

    public final void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f31048d) == null) {
            return;
        }
        gVar.c(true);
    }

    public final void q(c.a.x.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f31047c.d(cVar);
    }

    public final void r(ArrayList<c> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f31047c.e(arrayList);
    }

    public final void s(e eVar, c.a.x.c.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, cVar) == null) {
            HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
            this.f31045a = handlerThread;
            handlerThread.start();
            this.f31046b = new HandlerC1438b(this, this.f31045a.getLooper());
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    this.f31048d = new g();
                } catch (VerifyError unused) {
                    if (this.f31048d == null) {
                        return;
                    }
                }
                this.f31048d.f(cVar);
                this.f31049e = eVar;
            }
            if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
                this.f31051g = true;
            } else {
                this.f31051g = false;
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HandlerThread handlerThread = this.f31045a;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f31046b != null && this.f31050f) {
            this.f31046b.removeMessages(1005);
        }
    }

    public void v() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (handler = this.f31046b) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.f31046b;
        handler2.sendMessage(handler2.obtainMessage(1007));
        Handler handler3 = this.f31046b;
        handler3.sendMessage(handler3.obtainMessage(1008));
    }

    public boolean w(ArrayList<c> arrayList, d dVar, e eVar, c.a.x.c.g.c cVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, arrayList, dVar, eVar, cVar)) == null) {
            if (t()) {
                return false;
            }
            s(eVar, cVar);
            a aVar = new a(this, arrayList, dVar);
            Handler handler = this.f31046b;
            handler.sendMessage(handler.obtainMessage(1001, aVar));
            this.f31050f = true;
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public void x() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (handler = this.f31046b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f31046b != null && this.f31050f) {
            this.f31050f = false;
            this.f31046b.removeMessages(1005);
            Handler handler = this.f31046b;
            handler.sendMessage(handler.obtainMessage(1006));
        }
    }

    public void z(ArrayList<c> arrayList) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || (handler = this.f31046b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1003, arrayList));
    }
}
