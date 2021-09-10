package c.a.x.c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.x.c.g.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String u = "d";
    public static volatile int v;
    public static volatile boolean w;
    public static volatile d x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f30649a;

    /* renamed from: b  reason: collision with root package name */
    public Context f30650b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30651c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f30652d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f30653e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30654f;

    /* renamed from: g  reason: collision with root package name */
    public long f30655g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.x.c.g.d f30656h;

    /* renamed from: i  reason: collision with root package name */
    public e f30657i;

    /* renamed from: j  reason: collision with root package name */
    public HandlerC1416d f30658j;
    public c.a.x.c.g.e k;
    public f l;
    public c.a.x.c.f.a m;
    public c.a.x.c.g.c n;
    public volatile boolean o;
    public c.a.x.c.f.b p;
    public c.a.x.c.g.c q;
    public volatile boolean r;
    public ArrayList<c.a.x.b.g.c> s;
    public int t;

    /* loaded from: classes4.dex */
    public class a implements c.a.x.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30659a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30659a = dVar;
        }

        @Override // c.a.x.c.g.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f30659a.p.v();
                this.f30659a.p = null;
                this.f30659a.q = null;
                this.f30659a.v(2, z);
            }
        }

        @Override // c.a.x.c.g.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.f30659a.p.x();
            }
        }

        @Override // c.a.x.c.g.c
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        @Override // c.a.x.c.g.c
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f30659a.r = z;
                this.f30659a.u(2, z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.x.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30660a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30660a = dVar;
        }

        @Override // c.a.x.c.g.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f30660a.m.p();
                this.f30660a.m = null;
                this.f30660a.n = null;
                this.f30660a.v(4, z);
            }
        }

        @Override // c.a.x.c.g.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.f30660a.m.r();
            }
        }

        @Override // c.a.x.c.g.c
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                boolean unused = d.w = z;
            }
        }

        @Override // c.a.x.c.g.c
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f30660a.o = z;
                this.f30660a.u(4, z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30661a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30661a = dVar;
        }

        @Override // c.a.x.c.g.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f30661a.u(1, z);
            }
        }

        @Override // c.a.x.c.g.f
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f30661a.k.d();
                    this.f30661a.k = null;
                }
                this.f30661a.l = null;
                this.f30661a.v(1, z);
            }
        }
    }

    /* renamed from: c.a.x.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1416d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30662a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1416d(d dVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, looper};
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
            this.f30662a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                        if (this.f30662a.f30657i != null) {
                            this.f30662a.f30657i.onRecorderStart(((Boolean) message.obj).booleanValue());
                        }
                        this.f30662a.f30653e = false;
                        break;
                    case 7002:
                        if (this.f30662a.f30657i != null) {
                            this.f30662a.f30657i.a(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7003:
                        if (this.f30662a.f30657i != null) {
                            this.f30662a.f30657i.onRecorderComplete(((Boolean) message.obj).booleanValue(), this.f30662a.f30656h != null ? this.f30662a.f30656h.f() : null);
                            break;
                        }
                        break;
                    case 7004:
                        if (this.f30662a.f30657i != null) {
                            this.f30662a.f30657i.onRecorderError(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7005:
                        this.f30662a.R();
                        break;
                    case 7006:
                        this.f30662a.f30653e = false;
                        this.f30662a.U();
                        break;
                }
                super.handleMessage(message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-956519520, "Lc/a/x/c/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-956519520, "Lc/a/x/c/d;");
        }
    }

    public d() {
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
        this.f30649a = 0;
        this.f30651c = false;
        this.f30653e = false;
        this.f30654f = false;
        this.f30655g = 0L;
        this.o = false;
        this.r = false;
    }

    public static void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            x = null;
        }
    }

    public static void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            v = i2;
        }
    }

    public static void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            w = z;
        }
    }

    public static d x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (x == null) {
                synchronized (d.class) {
                    if (x == null) {
                        x = new d();
                    }
                }
            }
            return x;
        }
        return (d) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.k = new c.a.x.c.g.e();
            }
            if (this.f30656h.o()) {
                this.m = new c.a.x.c.f.a();
            } else {
                w = true;
            }
            this.p = new c.a.x.c.f.b();
            this.f30649a = 0;
            if (!this.f30651c && this.f30652d == null) {
                HandlerThread handlerThread = new HandlerThread(u);
                this.f30652d = handlerThread;
                handlerThread.start();
            }
            HandlerC1416d handlerC1416d = this.f30658j;
            if (handlerC1416d == null) {
                if (this.f30652d != null) {
                    this.f30658j = new HandlerC1416d(this, this.f30652d.getLooper());
                } else {
                    this.f30658j = new HandlerC1416d(this, this.f30650b.getMainLooper());
                }
            } else {
                handlerC1416d.removeCallbacksAndMessages(null);
            }
            this.f30656h.h();
        }
    }

    public final synchronized boolean B() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                String str = "isMovieRecordStarted sMovieRecordState = " + v;
                int i2 = (v ^ 1) ^ 2;
                if (this.f30656h != null) {
                    if (this.f30656h.o()) {
                        i2 ^= 4;
                    }
                }
                z = i2 == 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final synchronized boolean C() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                z = v == 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.x.c.g.d dVar = this.f30656h;
            if (dVar == null) {
                return false;
            }
            if (dVar.o()) {
                if (this.f30649a == 3) {
                    return true;
                }
            } else if (this.f30649a == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30649a == 0 : invokeV.booleanValue;
    }

    public void F(ByteBuffer byteBuffer, int i2, long j2) {
        c.a.x.c.f.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && this.o && (aVar = this.m) != null && aVar.o()) {
            this.m.g(byteBuffer, i2, j2);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ArrayList<c.a.x.b.g.c> arrayList = this.s;
            if (arrayList != null) {
                arrayList.clear();
                this.s = null;
            }
            this.f30650b = null;
            this.f30656h = null;
            N(0);
            K();
            HandlerC1416d handlerC1416d = this.f30658j;
            if (handlerC1416d != null) {
                handlerC1416d.removeCallbacksAndMessages(null);
                this.f30658j = null;
            }
            HandlerThread handlerThread = this.f30652d;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f30652d = null;
            }
        }
    }

    public void H(long j2) {
        c.a.x.c.f.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) && (bVar = this.p) != null && bVar.t() && this.r && w) {
            this.p.i(j2);
        }
    }

    public void I() {
        c.a.x.c.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bVar = this.p) == null) {
            return;
        }
        bVar.u();
    }

    public final boolean J() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.x.c.f.a aVar = this.m;
            if (aVar == null || !aVar.o()) {
                z = true;
            } else {
                this.m.s();
                this.m.p();
                z = false;
            }
            c.a.x.c.f.b bVar = this.p;
            if (bVar != null && bVar.t()) {
                this.p.y();
                this.p.v();
                z = false;
            }
            c.a.x.c.g.d dVar = this.f30656h;
            if (dVar == null || this.k.b(dVar.f(), this.f30656h.g(), this.l)) {
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String str = "restartRecorder mRestartTried = " + this.f30654f;
            HandlerC1416d handlerC1416d = this.f30658j;
            if (handlerC1416d != null) {
                this.f30654f = true;
                handlerC1416d.sendMessageDelayed(handlerC1416d.obtainMessage(7005), 500L);
            }
        }
    }

    public final void M(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                v = i2 | v;
            }
            this.f30649a++;
        }
    }

    public final void P() {
        c.a.x.c.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.q(this.f30656h, this.k, this.n);
    }

    public final void Q() {
        HandlerC1416d handlerC1416d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (handlerC1416d = this.f30658j) == null) {
            return;
        }
        handlerC1416d.sendMessageDelayed(handlerC1416d.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.FALSE), 500L);
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            A();
            z();
            if (J()) {
                P();
                T();
            } else if (!this.f30654f) {
                L();
            } else {
                Q();
            }
        }
    }

    public void S(Context context, c.a.x.c.g.d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, context, dVar, eVar) == null) {
            String str = "startRecorder mStarting = " + this.f30653e;
            if (this.f30653e) {
                Q();
                return;
            }
            this.f30653e = true;
            this.f30650b = context;
            this.f30656h = dVar;
            this.f30657i = eVar;
            R();
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Y();
            this.p.w(this.s, this.f30656h, this.k, this.q);
        }
    }

    public void U() {
        HandlerC1416d handlerC1416d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String str = "stopRecorder mStarting = " + this.f30653e;
            if (this.f30653e) {
                if (!B() && (handlerC1416d = this.f30658j) != null) {
                    handlerC1416d.sendMessage(handlerC1416d.obtainMessage(7004, 4002));
                }
                HandlerC1416d handlerC1416d2 = this.f30658j;
                if (handlerC1416d2 != null) {
                    handlerC1416d2.sendMessageDelayed(handlerC1416d2.obtainMessage(7006), 500L);
                    return;
                }
                return;
            }
            this.o = false;
            this.r = false;
            this.f30655g = 0L;
            c.a.x.c.f.a aVar = this.m;
            if (aVar != null && aVar.o()) {
                this.m.s();
            }
            c.a.x.c.f.b bVar = this.p;
            if (bVar != null && bVar.t()) {
                this.p.y();
            }
            O(false);
        }
    }

    public void V(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.f30655g *= 1000000;
            e eVar = this.f30657i;
            if (eVar != null) {
                eVar.a(j2);
            }
        }
    }

    public void W(c.a.x.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            X(cVar, true);
        }
    }

    public void X(c.a.x.b.g.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, cVar, z) == null) || this.p == null) {
            return;
        }
        t(cVar, z);
        this.p.z(this.s);
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Z();
        }
    }

    public final void Z() {
        ArrayList<c.a.x.b.g.c> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (arrayList = this.s) == null) {
            return;
        }
        Iterator<c.a.x.b.g.c> it = arrayList.iterator();
        while (it.hasNext()) {
            c.a.x.b.g.a f2 = it.next().f();
            if (f2.g() == MirrorType.NO_MIRROR) {
                f2.l(-this.t);
            } else {
                f2.l(this.t);
            }
        }
    }

    public void s(c.a.x.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            t(cVar, true);
        }
    }

    public void t(c.a.x.b.g.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048600, this, cVar, z) == null) || cVar == null || cVar.i() == null) {
            return;
        }
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            if (this.s.get(i3).g() == cVar.g()) {
                i2 = i3;
            }
        }
        if (i2 >= 0 && i2 < this.s.size()) {
            if (this.s.get(i2).i() == cVar.i()) {
                return;
            }
            this.s.remove(i2);
        }
        if (z) {
            this.s.add(cVar.clone());
        } else {
            this.s.add(cVar);
        }
        Collections.sort(this.s);
    }

    public final synchronized void u(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                String str = "checkMovieRecordStartState condition = " + i2 + " && state = " + z;
                M(i2, z);
                String str2 = "checkMovieRecordStartState sMovieRecordState = " + v;
                if (D()) {
                    this.f30658j.sendMessage(this.f30658j.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(B())));
                }
            }
        }
    }

    public final synchronized void v(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                String str = "checkMovieRecordStopState condition = " + i2 + " && state = " + z;
                w(i2, z);
                String str2 = "checkMovieRecordStopState sMovieRecordState = " + v;
                if (E() && this.f30658j != null) {
                    this.f30658j.sendMessage(this.f30658j.obtainMessage(7003, Boolean.valueOf(C())));
                }
            }
        }
    }

    public final void w(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                v = i2 ^ v;
            }
            this.f30649a--;
        }
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            c.a.x.c.f.b bVar = this.p;
            if (bVar != null) {
                return bVar.j();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.q = new a(this);
            this.n = new b(this);
            this.l = new c(this);
        }
    }
}
