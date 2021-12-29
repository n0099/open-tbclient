package c.a.y.c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.y.c.g.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String u = "d";
    public static volatile int v;
    public static volatile boolean w;
    public static volatile d x;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27583b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27584c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f27585d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f27586e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27587f;

    /* renamed from: g  reason: collision with root package name */
    public long f27588g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.y.c.g.d f27589h;

    /* renamed from: i  reason: collision with root package name */
    public e f27590i;

    /* renamed from: j  reason: collision with root package name */
    public HandlerC1586d f27591j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.y.c.g.e f27592k;
    public f l;
    public c.a.y.c.f.a m;
    public c.a.y.c.g.c n;
    public volatile boolean o;
    public c.a.y.c.f.b p;
    public c.a.y.c.g.c q;
    public volatile boolean r;
    public ArrayList<c.a.y.b.g.c> s;
    public int t;

    /* loaded from: classes9.dex */
    public class a implements c.a.y.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        @Override // c.a.y.c.g.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.p.v();
                this.a.p = null;
                this.a.q = null;
                this.a.v(2, z);
            }
        }

        @Override // c.a.y.c.g.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.a.p.x();
            }
        }

        @Override // c.a.y.c.g.c
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        @Override // c.a.y.c.g.c
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a.r = z;
                this.a.u(2, z);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.a.y.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        @Override // c.a.y.c.g.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.m.p();
                this.a.m = null;
                this.a.n = null;
                this.a.v(4, z);
            }
        }

        @Override // c.a.y.c.g.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.a.m.r();
            }
        }

        @Override // c.a.y.c.g.c
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                boolean unused = d.w = z;
            }
        }

        @Override // c.a.y.c.g.c
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a.o = z;
                this.a.u(4, z);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        @Override // c.a.y.c.g.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.u(1, z);
            }
        }

        @Override // c.a.y.c.g.f
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.a.f27592k.d();
                    this.a.f27592k = null;
                }
                this.a.l = null;
                this.a.v(1, z);
            }
        }
    }

    /* renamed from: c.a.y.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class HandlerC1586d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1586d(d dVar, Looper looper) {
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
            this.a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 7001:
                        if (this.a.f27590i != null) {
                            this.a.f27590i.onRecorderStart(((Boolean) message.obj).booleanValue());
                        }
                        this.a.f27586e = false;
                        break;
                    case w0.Y5 /* 7002 */:
                        if (this.a.f27590i != null) {
                            this.a.f27590i.a(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case w0.S5 /* 7003 */:
                        if (this.a.f27590i != null) {
                            this.a.f27590i.onRecorderComplete(((Boolean) message.obj).booleanValue(), this.a.f27589h != null ? this.a.f27589h.f() : null);
                            break;
                        }
                        break;
                    case w0.T5 /* 7004 */:
                        if (this.a.f27590i != null) {
                            this.a.f27590i.onRecorderError(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case w0.U5 /* 7005 */:
                        this.a.R();
                        break;
                    case w0.V5 /* 7006 */:
                        this.a.f27586e = false;
                        this.a.U();
                        break;
                }
                super.handleMessage(message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-927890369, "Lc/a/y/c/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-927890369, "Lc/a/y/c/d;");
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
        this.a = 0;
        this.f27584c = false;
        this.f27586e = false;
        this.f27587f = false;
        this.f27588g = 0L;
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
                this.f27592k = new c.a.y.c.g.e();
            }
            if (this.f27589h.o()) {
                this.m = new c.a.y.c.f.a();
            } else {
                w = true;
            }
            this.p = new c.a.y.c.f.b();
            this.a = 0;
            if (!this.f27584c && this.f27585d == null) {
                HandlerThread handlerThread = new HandlerThread(u);
                this.f27585d = handlerThread;
                handlerThread.start();
            }
            HandlerC1586d handlerC1586d = this.f27591j;
            if (handlerC1586d == null) {
                if (this.f27585d != null) {
                    this.f27591j = new HandlerC1586d(this, this.f27585d.getLooper());
                } else {
                    this.f27591j = new HandlerC1586d(this, this.f27583b.getMainLooper());
                }
            } else {
                handlerC1586d.removeCallbacksAndMessages(null);
            }
            this.f27589h.h();
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
                if (this.f27589h != null) {
                    if (this.f27589h.o()) {
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
            c.a.y.c.g.d dVar = this.f27589h;
            if (dVar == null) {
                return false;
            }
            if (dVar.o()) {
                if (this.a == 3) {
                    return true;
                }
            } else if (this.a == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a == 0 : invokeV.booleanValue;
    }

    public void F(ByteBuffer byteBuffer, int i2, long j2) {
        c.a.y.c.f.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && this.o && (aVar = this.m) != null && aVar.o()) {
            this.m.g(byteBuffer, i2, j2);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ArrayList<c.a.y.b.g.c> arrayList = this.s;
            if (arrayList != null) {
                arrayList.clear();
                this.s = null;
            }
            this.f27583b = null;
            this.f27589h = null;
            N(0);
            K();
            HandlerC1586d handlerC1586d = this.f27591j;
            if (handlerC1586d != null) {
                handlerC1586d.removeCallbacksAndMessages(null);
                this.f27591j = null;
            }
            HandlerThread handlerThread = this.f27585d;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f27585d = null;
            }
        }
    }

    public void H(long j2) {
        c.a.y.c.f.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) && (bVar = this.p) != null && bVar.t() && this.r && w) {
            this.p.i(j2);
        }
    }

    public void I() {
        c.a.y.c.f.b bVar;
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
            c.a.y.c.f.a aVar = this.m;
            if (aVar == null || !aVar.o()) {
                z = true;
            } else {
                this.m.s();
                this.m.p();
                z = false;
            }
            c.a.y.c.f.b bVar = this.p;
            if (bVar != null && bVar.t()) {
                this.p.y();
                this.p.v();
                z = false;
            }
            c.a.y.c.g.d dVar = this.f27589h;
            if (dVar == null || this.f27592k.b(dVar.f(), this.f27589h.g(), this.l)) {
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String str = "restartRecorder mRestartTried = " + this.f27587f;
            HandlerC1586d handlerC1586d = this.f27591j;
            if (handlerC1586d != null) {
                this.f27587f = true;
                handlerC1586d.sendMessageDelayed(handlerC1586d.obtainMessage(w0.U5), 500L);
            }
        }
    }

    public final void M(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                v = i2 | v;
            }
            this.a++;
        }
    }

    public final void P() {
        c.a.y.c.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.q(this.f27589h, this.f27592k, this.n);
    }

    public final void Q() {
        HandlerC1586d handlerC1586d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (handlerC1586d = this.f27591j) == null) {
            return;
        }
        handlerC1586d.sendMessageDelayed(handlerC1586d.obtainMessage(7001, Boolean.FALSE), 500L);
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            A();
            z();
            if (J()) {
                P();
                T();
            } else if (!this.f27587f) {
                L();
            } else {
                Q();
            }
        }
    }

    public void S(Context context, c.a.y.c.g.d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, context, dVar, eVar) == null) {
            String str = "startRecorder mStarting = " + this.f27586e;
            if (this.f27586e) {
                Q();
                return;
            }
            this.f27586e = true;
            this.f27583b = context;
            this.f27589h = dVar;
            this.f27590i = eVar;
            R();
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Y();
            this.p.w(this.s, this.f27589h, this.f27592k, this.q);
        }
    }

    public void U() {
        HandlerC1586d handlerC1586d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String str = "stopRecorder mStarting = " + this.f27586e;
            if (this.f27586e) {
                if (!B() && (handlerC1586d = this.f27591j) != null) {
                    handlerC1586d.sendMessage(handlerC1586d.obtainMessage(w0.T5, 4002));
                }
                HandlerC1586d handlerC1586d2 = this.f27591j;
                if (handlerC1586d2 != null) {
                    handlerC1586d2.sendMessageDelayed(handlerC1586d2.obtainMessage(w0.V5), 500L);
                    return;
                }
                return;
            }
            this.o = false;
            this.r = false;
            this.f27588g = 0L;
            c.a.y.c.f.a aVar = this.m;
            if (aVar != null && aVar.o()) {
                this.m.s();
            }
            c.a.y.c.f.b bVar = this.p;
            if (bVar != null && bVar.t()) {
                this.p.y();
            }
            O(false);
        }
    }

    public void V(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.f27588g *= 1000000;
            e eVar = this.f27590i;
            if (eVar != null) {
                eVar.a(j2);
            }
        }
    }

    public void W(c.a.y.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            X(cVar, true);
        }
    }

    public void X(c.a.y.b.g.c cVar, boolean z) {
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
        ArrayList<c.a.y.b.g.c> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (arrayList = this.s) == null) {
            return;
        }
        Iterator<c.a.y.b.g.c> it = arrayList.iterator();
        while (it.hasNext()) {
            c.a.y.b.g.a c2 = it.next().c();
            if (c2.e() == MirrorType.NO_MIRROR) {
                c2.j(-this.t);
            } else {
                c2.j(this.t);
            }
        }
    }

    public void s(c.a.y.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            t(cVar, true);
        }
    }

    public void t(c.a.y.b.g.c cVar, boolean z) {
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
                    this.f27591j.sendMessage(this.f27591j.obtainMessage(7001, Boolean.valueOf(B())));
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
                if (E() && this.f27591j != null) {
                    this.f27591j.sendMessage(this.f27591j.obtainMessage(w0.S5, Boolean.valueOf(C())));
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
            this.a--;
        }
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            c.a.y.c.f.b bVar = this.p;
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
