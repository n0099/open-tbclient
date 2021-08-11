package c.a.w.c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.w.c.g.f;
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
    public int f30681a;

    /* renamed from: b  reason: collision with root package name */
    public Context f30682b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30683c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f30684d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f30685e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30686f;

    /* renamed from: g  reason: collision with root package name */
    public long f30687g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.w.c.g.d f30688h;

    /* renamed from: i  reason: collision with root package name */
    public e f30689i;

    /* renamed from: j  reason: collision with root package name */
    public HandlerC1426d f30690j;
    public c.a.w.c.g.e k;
    public f l;
    public c.a.w.c.f.a m;
    public c.a.w.c.g.c n;
    public volatile boolean o;
    public c.a.w.c.f.b p;
    public c.a.w.c.g.c q;
    public volatile boolean r;
    public ArrayList<c.a.w.b.g.c> s;
    public int t;

    /* loaded from: classes4.dex */
    public class a implements c.a.w.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30691a;

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
            this.f30691a = dVar;
        }

        @Override // c.a.w.c.g.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f30691a.p.v();
                this.f30691a.p = null;
                this.f30691a.q = null;
                this.f30691a.v(2, z);
            }
        }

        @Override // c.a.w.c.g.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.f30691a.p.x();
            }
        }

        @Override // c.a.w.c.g.c
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        @Override // c.a.w.c.g.c
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f30691a.r = z;
                this.f30691a.u(2, z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.w.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30692a;

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
            this.f30692a = dVar;
        }

        @Override // c.a.w.c.g.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f30692a.m.p();
                this.f30692a.m = null;
                this.f30692a.n = null;
                this.f30692a.v(4, z);
            }
        }

        @Override // c.a.w.c.g.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.f30692a.m.r();
            }
        }

        @Override // c.a.w.c.g.c
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                boolean unused = d.w = z;
            }
        }

        @Override // c.a.w.c.g.c
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f30692a.o = z;
                this.f30692a.u(4, z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30693a;

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
            this.f30693a = dVar;
        }

        @Override // c.a.w.c.g.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f30693a.u(1, z);
            }
        }

        @Override // c.a.w.c.g.f
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f30693a.k.d();
                    this.f30693a.k = null;
                }
                this.f30693a.l = null;
                this.f30693a.v(1, z);
            }
        }
    }

    /* renamed from: c.a.w.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1426d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30694a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1426d(d dVar, Looper looper) {
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
            this.f30694a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                        if (this.f30694a.f30689i != null) {
                            this.f30694a.f30689i.onRecorderStart(((Boolean) message.obj).booleanValue());
                        }
                        this.f30694a.f30685e = false;
                        break;
                    case 7002:
                        if (this.f30694a.f30689i != null) {
                            this.f30694a.f30689i.a(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7003:
                        if (this.f30694a.f30689i != null) {
                            this.f30694a.f30689i.onRecorderComplete(((Boolean) message.obj).booleanValue(), this.f30694a.f30688h != null ? this.f30694a.f30688h.f() : null);
                            break;
                        }
                        break;
                    case 7004:
                        if (this.f30694a.f30689i != null) {
                            this.f30694a.f30689i.onRecorderError(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7005:
                        this.f30694a.R();
                        break;
                    case 7006:
                        this.f30694a.f30685e = false;
                        this.f30694a.U();
                        break;
                }
                super.handleMessage(message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-985148671, "Lc/a/w/c/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-985148671, "Lc/a/w/c/d;");
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
        this.f30681a = 0;
        this.f30683c = false;
        this.f30685e = false;
        this.f30686f = false;
        this.f30687g = 0L;
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
                this.k = new c.a.w.c.g.e();
            }
            if (this.f30688h.o()) {
                this.m = new c.a.w.c.f.a();
            } else {
                w = true;
            }
            this.p = new c.a.w.c.f.b();
            this.f30681a = 0;
            if (!this.f30683c && this.f30684d == null) {
                HandlerThread handlerThread = new HandlerThread(u);
                this.f30684d = handlerThread;
                handlerThread.start();
            }
            HandlerC1426d handlerC1426d = this.f30690j;
            if (handlerC1426d == null) {
                if (this.f30684d != null) {
                    this.f30690j = new HandlerC1426d(this, this.f30684d.getLooper());
                } else {
                    this.f30690j = new HandlerC1426d(this, this.f30682b.getMainLooper());
                }
            } else {
                handlerC1426d.removeCallbacksAndMessages(null);
            }
            this.f30688h.h();
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
                if (this.f30688h != null) {
                    if (this.f30688h.o()) {
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
            c.a.w.c.g.d dVar = this.f30688h;
            if (dVar == null) {
                return false;
            }
            if (dVar.o()) {
                if (this.f30681a == 3) {
                    return true;
                }
            } else if (this.f30681a == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30681a == 0 : invokeV.booleanValue;
    }

    public void F(ByteBuffer byteBuffer, int i2, long j2) {
        c.a.w.c.f.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && this.o && (aVar = this.m) != null && aVar.o()) {
            this.m.g(byteBuffer, i2, j2);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ArrayList<c.a.w.b.g.c> arrayList = this.s;
            if (arrayList != null) {
                arrayList.clear();
                this.s = null;
            }
            this.f30682b = null;
            this.f30688h = null;
            N(0);
            K();
            HandlerC1426d handlerC1426d = this.f30690j;
            if (handlerC1426d != null) {
                handlerC1426d.removeCallbacksAndMessages(null);
                this.f30690j = null;
            }
            HandlerThread handlerThread = this.f30684d;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f30684d = null;
            }
        }
    }

    public void H(long j2) {
        c.a.w.c.f.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) && (bVar = this.p) != null && bVar.t() && this.r && w) {
            this.p.i(j2);
        }
    }

    public void I() {
        c.a.w.c.f.b bVar;
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
            c.a.w.c.f.a aVar = this.m;
            if (aVar == null || !aVar.o()) {
                z = true;
            } else {
                this.m.s();
                this.m.p();
                z = false;
            }
            c.a.w.c.f.b bVar = this.p;
            if (bVar != null && bVar.t()) {
                this.p.y();
                this.p.v();
                z = false;
            }
            c.a.w.c.g.d dVar = this.f30688h;
            if (dVar == null || this.k.b(dVar.f(), this.f30688h.g(), this.l)) {
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String str = "restartRecorder mRestartTried = " + this.f30686f;
            HandlerC1426d handlerC1426d = this.f30690j;
            if (handlerC1426d != null) {
                this.f30686f = true;
                handlerC1426d.sendMessageDelayed(handlerC1426d.obtainMessage(7005), 500L);
            }
        }
    }

    public final void M(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                v = i2 | v;
            }
            this.f30681a++;
        }
    }

    public final void P() {
        c.a.w.c.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.q(this.f30688h, this.k, this.n);
    }

    public final void Q() {
        HandlerC1426d handlerC1426d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (handlerC1426d = this.f30690j) == null) {
            return;
        }
        handlerC1426d.sendMessageDelayed(handlerC1426d.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.FALSE), 500L);
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            A();
            z();
            if (J()) {
                P();
                T();
            } else if (!this.f30686f) {
                L();
            } else {
                Q();
            }
        }
    }

    public void S(Context context, c.a.w.c.g.d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, context, dVar, eVar) == null) {
            String str = "startRecorder mStarting = " + this.f30685e;
            if (this.f30685e) {
                Q();
                return;
            }
            this.f30685e = true;
            this.f30682b = context;
            this.f30688h = dVar;
            this.f30689i = eVar;
            R();
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Y();
            this.p.w(this.s, this.f30688h, this.k, this.q);
        }
    }

    public void U() {
        HandlerC1426d handlerC1426d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String str = "stopRecorder mStarting = " + this.f30685e;
            if (this.f30685e) {
                if (!B() && (handlerC1426d = this.f30690j) != null) {
                    handlerC1426d.sendMessage(handlerC1426d.obtainMessage(7004, 4002));
                }
                HandlerC1426d handlerC1426d2 = this.f30690j;
                if (handlerC1426d2 != null) {
                    handlerC1426d2.sendMessageDelayed(handlerC1426d2.obtainMessage(7006), 500L);
                    return;
                }
                return;
            }
            this.o = false;
            this.r = false;
            this.f30687g = 0L;
            c.a.w.c.f.a aVar = this.m;
            if (aVar != null && aVar.o()) {
                this.m.s();
            }
            c.a.w.c.f.b bVar = this.p;
            if (bVar != null && bVar.t()) {
                this.p.y();
            }
            O(false);
        }
    }

    public void V(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.f30687g *= 1000000;
            e eVar = this.f30689i;
            if (eVar != null) {
                eVar.a(j2);
            }
        }
    }

    public void W(c.a.w.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            X(cVar, true);
        }
    }

    public void X(c.a.w.b.g.c cVar, boolean z) {
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
        ArrayList<c.a.w.b.g.c> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (arrayList = this.s) == null) {
            return;
        }
        Iterator<c.a.w.b.g.c> it = arrayList.iterator();
        while (it.hasNext()) {
            c.a.w.b.g.a f2 = it.next().f();
            if (f2.g() == MirrorType.NO_MIRROR) {
                f2.l(-this.t);
            } else {
                f2.l(this.t);
            }
        }
    }

    public void s(c.a.w.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            t(cVar, true);
        }
    }

    public void t(c.a.w.b.g.c cVar, boolean z) {
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
                    this.f30690j.sendMessage(this.f30690j.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(B())));
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
                if (E() && this.f30690j != null) {
                    this.f30690j.sendMessage(this.f30690j.obtainMessage(7003, Boolean.valueOf(C())));
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
            this.f30681a--;
        }
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            c.a.w.c.f.b bVar = this.p;
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
