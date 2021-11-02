package b.a.x.c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import b.a.x.c.g.f;
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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String u = "d";
    public static volatile int v;
    public static volatile boolean w;
    public static volatile d x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29430a;

    /* renamed from: b  reason: collision with root package name */
    public Context f29431b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29432c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f29433d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f29434e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29435f;

    /* renamed from: g  reason: collision with root package name */
    public long f29436g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.x.c.g.d f29437h;

    /* renamed from: i  reason: collision with root package name */
    public e f29438i;
    public HandlerC1417d j;
    public b.a.x.c.g.e k;
    public f l;
    public b.a.x.c.f.a m;
    public b.a.x.c.g.c n;
    public volatile boolean o;
    public b.a.x.c.f.b p;
    public b.a.x.c.g.c q;
    public volatile boolean r;
    public ArrayList<b.a.x.b.g.c> s;
    public int t;

    /* loaded from: classes6.dex */
    public class a implements b.a.x.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f29439a;

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
            this.f29439a = dVar;
        }

        @Override // b.a.x.c.g.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f29439a.p.v();
                this.f29439a.p = null;
                this.f29439a.q = null;
                this.f29439a.v(2, z);
            }
        }

        @Override // b.a.x.c.g.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.f29439a.p.x();
            }
        }

        @Override // b.a.x.c.g.c
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        @Override // b.a.x.c.g.c
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f29439a.r = z;
                this.f29439a.u(2, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements b.a.x.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f29440a;

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
            this.f29440a = dVar;
        }

        @Override // b.a.x.c.g.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f29440a.m.p();
                this.f29440a.m = null;
                this.f29440a.n = null;
                this.f29440a.v(4, z);
            }
        }

        @Override // b.a.x.c.g.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.f29440a.m.r();
            }
        }

        @Override // b.a.x.c.g.c
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                boolean unused = d.w = z;
            }
        }

        @Override // b.a.x.c.g.c
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f29440a.o = z;
                this.f29440a.u(4, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f29441a;

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
            this.f29441a = dVar;
        }

        @Override // b.a.x.c.g.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f29441a.u(1, z);
            }
        }

        @Override // b.a.x.c.g.f
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f29441a.k.d();
                    this.f29441a.k = null;
                }
                this.f29441a.l = null;
                this.f29441a.v(1, z);
            }
        }
    }

    /* renamed from: b.a.x.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class HandlerC1417d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f29442a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1417d(d dVar, Looper looper) {
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
            this.f29442a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                        if (this.f29442a.f29438i != null) {
                            this.f29442a.f29438i.onRecorderStart(((Boolean) message.obj).booleanValue());
                        }
                        this.f29442a.f29434e = false;
                        break;
                    case 7002:
                        if (this.f29442a.f29438i != null) {
                            this.f29442a.f29438i.a(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7003:
                        if (this.f29442a.f29438i != null) {
                            this.f29442a.f29438i.onRecorderComplete(((Boolean) message.obj).booleanValue(), this.f29442a.f29437h != null ? this.f29442a.f29437h.f() : null);
                            break;
                        }
                        break;
                    case 7004:
                        if (this.f29442a.f29438i != null) {
                            this.f29442a.f29438i.onRecorderError(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7005:
                        this.f29442a.R();
                        break;
                    case 7006:
                        this.f29442a.f29434e = false;
                        this.f29442a.U();
                        break;
                }
                super.handleMessage(message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-760006015, "Lb/a/x/c/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-760006015, "Lb/a/x/c/d;");
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
        this.f29430a = 0;
        this.f29432c = false;
        this.f29434e = false;
        this.f29435f = false;
        this.f29436g = 0L;
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
                this.k = new b.a.x.c.g.e();
            }
            if (this.f29437h.o()) {
                this.m = new b.a.x.c.f.a();
            } else {
                w = true;
            }
            this.p = new b.a.x.c.f.b();
            this.f29430a = 0;
            if (!this.f29432c && this.f29433d == null) {
                HandlerThread handlerThread = new HandlerThread(u);
                this.f29433d = handlerThread;
                handlerThread.start();
            }
            HandlerC1417d handlerC1417d = this.j;
            if (handlerC1417d == null) {
                if (this.f29433d != null) {
                    this.j = new HandlerC1417d(this, this.f29433d.getLooper());
                } else {
                    this.j = new HandlerC1417d(this, this.f29431b.getMainLooper());
                }
            } else {
                handlerC1417d.removeCallbacksAndMessages(null);
            }
            this.f29437h.h();
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
                if (this.f29437h != null) {
                    if (this.f29437h.o()) {
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
            b.a.x.c.g.d dVar = this.f29437h;
            if (dVar == null) {
                return false;
            }
            if (dVar.o()) {
                if (this.f29430a == 3) {
                    return true;
                }
            } else if (this.f29430a == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29430a == 0 : invokeV.booleanValue;
    }

    public void F(ByteBuffer byteBuffer, int i2, long j) {
        b.a.x.c.f.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) && this.o && (aVar = this.m) != null && aVar.o()) {
            this.m.g(byteBuffer, i2, j);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ArrayList<b.a.x.b.g.c> arrayList = this.s;
            if (arrayList != null) {
                arrayList.clear();
                this.s = null;
            }
            this.f29431b = null;
            this.f29437h = null;
            N(0);
            K();
            HandlerC1417d handlerC1417d = this.j;
            if (handlerC1417d != null) {
                handlerC1417d.removeCallbacksAndMessages(null);
                this.j = null;
            }
            HandlerThread handlerThread = this.f29433d;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f29433d = null;
            }
        }
    }

    public void H(long j) {
        b.a.x.c.f.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048583, this, j) == null) && (bVar = this.p) != null && bVar.t() && this.r && w) {
            this.p.i(j);
        }
    }

    public void I() {
        b.a.x.c.f.b bVar;
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
            b.a.x.c.f.a aVar = this.m;
            if (aVar == null || !aVar.o()) {
                z = true;
            } else {
                this.m.s();
                this.m.p();
                z = false;
            }
            b.a.x.c.f.b bVar = this.p;
            if (bVar != null && bVar.t()) {
                this.p.y();
                this.p.v();
                z = false;
            }
            b.a.x.c.g.d dVar = this.f29437h;
            if (dVar == null || this.k.b(dVar.f(), this.f29437h.g(), this.l)) {
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String str = "restartRecorder mRestartTried = " + this.f29435f;
            HandlerC1417d handlerC1417d = this.j;
            if (handlerC1417d != null) {
                this.f29435f = true;
                handlerC1417d.sendMessageDelayed(handlerC1417d.obtainMessage(7005), 500L);
            }
        }
    }

    public final void M(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                v = i2 | v;
            }
            this.f29430a++;
        }
    }

    public final void P() {
        b.a.x.c.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.q(this.f29437h, this.k, this.n);
    }

    public final void Q() {
        HandlerC1417d handlerC1417d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (handlerC1417d = this.j) == null) {
            return;
        }
        handlerC1417d.sendMessageDelayed(handlerC1417d.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.FALSE), 500L);
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            A();
            z();
            if (J()) {
                P();
                T();
            } else if (!this.f29435f) {
                L();
            } else {
                Q();
            }
        }
    }

    public void S(Context context, b.a.x.c.g.d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, context, dVar, eVar) == null) {
            String str = "startRecorder mStarting = " + this.f29434e;
            if (this.f29434e) {
                Q();
                return;
            }
            this.f29434e = true;
            this.f29431b = context;
            this.f29437h = dVar;
            this.f29438i = eVar;
            R();
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Y();
            this.p.w(this.s, this.f29437h, this.k, this.q);
        }
    }

    public void U() {
        HandlerC1417d handlerC1417d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String str = "stopRecorder mStarting = " + this.f29434e;
            if (this.f29434e) {
                if (!B() && (handlerC1417d = this.j) != null) {
                    handlerC1417d.sendMessage(handlerC1417d.obtainMessage(7004, 4002));
                }
                HandlerC1417d handlerC1417d2 = this.j;
                if (handlerC1417d2 != null) {
                    handlerC1417d2.sendMessageDelayed(handlerC1417d2.obtainMessage(7006), 500L);
                    return;
                }
                return;
            }
            this.o = false;
            this.r = false;
            this.f29436g = 0L;
            b.a.x.c.f.a aVar = this.m;
            if (aVar != null && aVar.o()) {
                this.m.s();
            }
            b.a.x.c.f.b bVar = this.p;
            if (bVar != null && bVar.t()) {
                this.p.y();
            }
            O(false);
        }
    }

    public void V(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.f29436g *= 1000000;
            e eVar = this.f29438i;
            if (eVar != null) {
                eVar.a(j);
            }
        }
    }

    public void W(b.a.x.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            X(cVar, true);
        }
    }

    public void X(b.a.x.b.g.c cVar, boolean z) {
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
        ArrayList<b.a.x.b.g.c> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (arrayList = this.s) == null) {
            return;
        }
        Iterator<b.a.x.b.g.c> it = arrayList.iterator();
        while (it.hasNext()) {
            b.a.x.b.g.a c2 = it.next().c();
            if (c2.e() == MirrorType.NO_MIRROR) {
                c2.j(-this.t);
            } else {
                c2.j(this.t);
            }
        }
    }

    public void s(b.a.x.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            t(cVar, true);
        }
    }

    public void t(b.a.x.b.g.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048600, this, cVar, z) == null) || cVar == null || cVar.g() == null) {
            return;
        }
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            if (this.s.get(i3).e() == cVar.e()) {
                i2 = i3;
            }
        }
        if (i2 >= 0 && i2 < this.s.size()) {
            if (this.s.get(i2).g() == cVar.g()) {
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
                    this.j.sendMessage(this.j.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(B())));
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
                if (E() && this.j != null) {
                    this.j.sendMessage(this.j.obtainMessage(7003, Boolean.valueOf(C())));
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
            this.f29430a--;
        }
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            b.a.x.c.f.b bVar = this.p;
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
