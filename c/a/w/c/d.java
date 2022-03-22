package c.a.w.c;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.w.c.g.f;
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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String u = "d";
    public static volatile int v;
    public static volatile boolean w;
    public static volatile d x;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Context f21902b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21903c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f21904d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f21905e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21906f;

    /* renamed from: g  reason: collision with root package name */
    public long f21907g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.w.c.g.d f21908h;
    public e i;
    public HandlerC1619d j;
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

    /* loaded from: classes3.dex */
    public class a implements c.a.w.c.g.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.w.c.g.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.p.v();
                this.a.p = null;
                this.a.q = null;
                this.a.v(2, z);
            }
        }

        @Override // c.a.w.c.g.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.a.p.x();
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
                this.a.r = z;
                this.a.u(2, z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.w.c.g.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.w.c.g.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.m.p();
                this.a.m = null;
                this.a.n = null;
                this.a.v(4, z);
            }
        }

        @Override // c.a.w.c.g.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.a.m.r();
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
                this.a.o = z;
                this.a.u(4, z);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.w.c.g.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.u(1, z);
            }
        }

        @Override // c.a.w.c.g.f
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.a.k.d();
                    this.a.k = null;
                }
                this.a.l = null;
                this.a.v(1, z);
            }
        }
    }

    /* renamed from: c.a.w.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1619d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1619d(d dVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                        if (this.a.i != null) {
                            this.a.i.onRecorderStart(((Boolean) message.obj).booleanValue());
                        }
                        this.a.f21905e = false;
                        break;
                    case w0.Y5 /* 7002 */:
                        if (this.a.i != null) {
                            this.a.i.a(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case w0.S5 /* 7003 */:
                        if (this.a.i != null) {
                            this.a.i.onRecorderComplete(((Boolean) message.obj).booleanValue(), this.a.f21908h != null ? this.a.f21908h.f() : null);
                            break;
                        }
                        break;
                    case w0.T5 /* 7004 */:
                        if (this.a.i != null) {
                            this.a.i.onRecorderError(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case w0.U5 /* 7005 */:
                        this.a.R();
                        break;
                    case w0.V5 /* 7006 */:
                        this.a.f21905e = false;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f21903c = false;
        this.f21905e = false;
        this.f21906f = false;
        this.f21907g = 0L;
        this.o = false;
        this.r = false;
    }

    public static void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            x = null;
        }
    }

    public static void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            v = i;
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
            if (this.f21908h.o()) {
                this.m = new c.a.w.c.f.a();
            } else {
                w = true;
            }
            this.p = new c.a.w.c.f.b();
            this.a = 0;
            if (!this.f21903c && this.f21904d == null) {
                HandlerThread handlerThread = new HandlerThread(u);
                this.f21904d = handlerThread;
                handlerThread.start();
            }
            HandlerC1619d handlerC1619d = this.j;
            if (handlerC1619d == null) {
                if (this.f21904d != null) {
                    this.j = new HandlerC1619d(this, this.f21904d.getLooper());
                } else {
                    this.j = new HandlerC1619d(this, this.f21902b.getMainLooper());
                }
            } else {
                handlerC1619d.removeCallbacksAndMessages(null);
            }
            this.f21908h.h();
        }
    }

    public final synchronized boolean B() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                String str = u;
                Log.i(str, "isMovieRecordStarted sMovieRecordState = " + v);
                int i = (v ^ 1) ^ 2;
                if (this.f21908h != null) {
                    if (this.f21908h.o()) {
                        i ^= 4;
                    }
                }
                z = i == 0;
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
            c.a.w.c.g.d dVar = this.f21908h;
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

    public void F(ByteBuffer byteBuffer, int i, long j) {
        c.a.w.c.f.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.o && (aVar = this.m) != null && aVar.o()) {
            this.m.g(byteBuffer, i, j);
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
            this.f21902b = null;
            this.f21908h = null;
            N(0);
            K();
            HandlerC1619d handlerC1619d = this.j;
            if (handlerC1619d != null) {
                handlerC1619d.removeCallbacksAndMessages(null);
                this.j = null;
            }
            HandlerThread handlerThread = this.f21904d;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f21904d = null;
            }
        }
    }

    public void H(long j) {
        c.a.w.c.f.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048583, this, j) == null) && (bVar = this.p) != null && bVar.t() && this.r && w) {
            this.p.i(j);
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
                Log.e(u, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
                this.m.s();
                this.m.p();
                z = false;
            }
            c.a.w.c.f.b bVar = this.p;
            if (bVar != null && bVar.t()) {
                Log.e(u, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
                this.p.y();
                this.p.v();
                z = false;
            }
            c.a.w.c.g.d dVar = this.f21908h;
            if (dVar == null || this.k.b(dVar.f(), this.f21908h.g(), this.l)) {
                return z;
            }
            Log.e(u, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String str = u;
            Log.i(str, "restartRecorder mRestartTried = " + this.f21906f);
            HandlerC1619d handlerC1619d = this.j;
            if (handlerC1619d != null) {
                this.f21906f = true;
                handlerC1619d.sendMessageDelayed(handlerC1619d.obtainMessage(w0.U5), 500L);
            }
        }
    }

    public final void M(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                v = i | v;
            }
            this.a++;
        }
    }

    public final void P() {
        c.a.w.c.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.q(this.f21908h, this.k, this.n);
    }

    public final void Q() {
        HandlerC1619d handlerC1619d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (handlerC1619d = this.j) == null) {
            return;
        }
        handlerC1619d.sendMessageDelayed(handlerC1619d.obtainMessage(7001, Boolean.FALSE), 500L);
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            A();
            z();
            if (J()) {
                P();
                T();
            } else if (!this.f21906f) {
                L();
            } else {
                Q();
            }
        }
    }

    public void S(Context context, c.a.w.c.g.d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, context, dVar, eVar) == null) {
            String str = u;
            Log.i(str, "startRecorder mStarting = " + this.f21905e);
            if (this.f21905e) {
                Q();
                return;
            }
            this.f21905e = true;
            this.f21902b = context;
            this.f21908h = dVar;
            this.i = eVar;
            R();
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Y();
            this.p.w(this.s, this.f21908h, this.k, this.q);
        }
    }

    public void U() {
        HandlerC1619d handlerC1619d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String str = u;
            Log.i(str, "stopRecorder mStarting = " + this.f21905e);
            if (this.f21905e) {
                if (!B() && (handlerC1619d = this.j) != null) {
                    handlerC1619d.sendMessage(handlerC1619d.obtainMessage(w0.T5, 4002));
                }
                Log.d(u, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
                HandlerC1619d handlerC1619d2 = this.j;
                if (handlerC1619d2 != null) {
                    handlerC1619d2.sendMessageDelayed(handlerC1619d2.obtainMessage(w0.V5), 500L);
                    return;
                }
                return;
            }
            this.o = false;
            this.r = false;
            this.f21907g = 0L;
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

    public void V(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.f21907g *= 1000000;
            e eVar = this.i;
            if (eVar != null) {
                eVar.a(j);
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
            c.a.w.b.g.a c2 = it.next().c();
            if (c2.d() == MirrorType.NO_MIRROR) {
                c2.i(-this.t);
            } else {
                c2.i(this.t);
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
        if (!(interceptable == null || interceptable.invokeLZ(1048600, this, cVar, z) == null) || cVar == null || cVar.f() == null) {
            return;
        }
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        int i = -1;
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            if (this.s.get(i2).d() == cVar.d()) {
                i = i2;
            }
        }
        if (i >= 0 && i < this.s.size()) {
            if (this.s.get(i).f() == cVar.f()) {
                return;
            }
            this.s.remove(i);
        }
        if (z) {
            this.s.add(cVar.clone());
        } else {
            this.s.add(cVar);
        }
        Collections.sort(this.s);
    }

    public final synchronized void u(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                String str = u;
                Log.i(str, "checkMovieRecordStartState condition = " + i + " && state = " + z);
                M(i, z);
                String str2 = u;
                Log.i(str2, "checkMovieRecordStartState sMovieRecordState = " + v);
                if (D()) {
                    this.j.sendMessage(this.j.obtainMessage(7001, Boolean.valueOf(B())));
                }
            }
        }
    }

    public final synchronized void v(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                String str = u;
                Log.i(str, "checkMovieRecordStopState condition = " + i + " && state = " + z);
                w(i, z);
                String str2 = u;
                Log.i(str2, "checkMovieRecordStopState sMovieRecordState = " + v);
                if (E() && this.j != null) {
                    this.j.sendMessage(this.j.obtainMessage(w0.S5, Boolean.valueOf(C())));
                }
            }
        }
    }

    public final void w(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                v = i ^ v;
            }
            this.a--;
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
