package c.a.x.c;

import android.content.Context;
import android.opengl.EGLContext;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mario.audio.AudioParams;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.ShortCompanionObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f30704a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.x.b.g.c f30705b;

    /* renamed from: c  reason: collision with root package name */
    public int f30706c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30707d;

    /* renamed from: e  reason: collision with root package name */
    public long f30708e;

    /* renamed from: f  reason: collision with root package name */
    public long f30709f;

    /* renamed from: g  reason: collision with root package name */
    public long f30710g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30711h;

    /* renamed from: i  reason: collision with root package name */
    public d f30712i;

    /* renamed from: j  reason: collision with root package name */
    public e f30713j;
    public c.a.x.c.g.d k;
    public boolean l;
    public Context m;
    public int n;
    public c.a.x.c.c o;
    public c.a.x.c.a p;
    public c.a.x.a.a.a q;
    public int r;
    public int s;
    public byte[] t;
    public ByteBuffer u;
    public Timer v;
    public TimerTask w;
    public boolean x;
    public boolean y;
    public long z;

    /* loaded from: classes4.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f30714a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30714a = bVar;
        }

        @Override // c.a.x.c.e
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f30714a.f30710g = j2;
                if (j2 <= this.f30714a.f30704a || !this.f30714a.l) {
                    return;
                }
                this.f30714a.I();
            }
        }

        @Override // c.a.x.c.e
        public void onRecorderComplete(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                String unused = b.A;
                String str2 = "on RecorderComplete record time :" + this.f30714a.f30710g;
                if (this.f30714a.o != null) {
                    this.f30714a.o.w((int) this.f30714a.f30710g, str);
                }
            }
        }

        @Override // c.a.x.c.e
        public void onRecorderError(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                String unused = b.A;
                String str = "onRecorderError:" + i2;
                if (this.f30714a.o != null) {
                    this.f30714a.o.onError(i2);
                }
            }
        }

        @Override // c.a.x.c.e
        public void onRecorderStart(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.f30714a.o == null) {
                return;
            }
            this.f30714a.o.onStart();
            this.f30714a.x = true;
        }
    }

    /* renamed from: c.a.x.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1416b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30715e;

        public C1416b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30715e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f30715e.x && !this.f30715e.y) {
                    String unused = b.A;
                    this.f30715e.H();
                    this.f30715e.y = false;
                    return;
                }
                b bVar = this.f30715e;
                bVar.K(bVar.u, 3840, System.nanoTime() - this.f30715e.z);
                this.f30715e.y = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements c.a.x.a.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<b> f30716a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30716a = new WeakReference<>(bVar);
            String unused = b.A;
            String str = "gameRecorderRef is:" + this.f30716a.get();
        }

        @Override // c.a.x.a.a.a
        public void a(boolean z, AudioParams audioParams) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, audioParams) == null) || this.f30716a.get() == null) {
                return;
            }
            this.f30716a.get().G(z, audioParams);
            String unused = b.A;
        }

        @Override // c.a.x.a.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f30716a.get() == null) {
                return;
            }
            this.f30716a.get().y = false;
            this.f30716a.get().K(byteBuffer, i2, j2);
        }

        @Override // c.a.x.a.a.a
        public void onAudioStop(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                String unused = b.A;
                if (this.f30716a.get() != null) {
                    this.f30716a.get().H();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-956519582, "Lc/a/x/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-956519582, "Lc/a/x/c/b;");
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30704a = 120000;
        this.f30706c = -1;
        this.f30707d = false;
        this.f30711h = false;
        this.r = 0;
        this.s = 0;
        this.t = ByteBuffer.allocate(3840).putShort(ShortCompanionObject.MIN_VALUE).array();
        this.u = ByteBuffer.allocate(3840).put(this.t);
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = false;
        this.z = 0L;
        this.m = context;
        this.f30712i = d.x();
        this.p = null;
        this.f30713j = new a(this);
        D(new c.a.x.c.g.d(), this.f30713j);
    }

    public void A(c.a.x.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void B(c.a.x.c.g.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.k = dVar;
        }
    }

    public void C(c.a.x.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void D(c.a.x.c.g.d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, dVar, eVar) == null) {
            B(dVar);
            this.f30713j = eVar;
        }
    }

    public final void E(AudioParams audioParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, audioParams) == null) {
            if (this.q == null) {
                q();
            }
            if (audioParams == null) {
                new AudioParams();
            }
            if (this.p != null) {
                String str = "set audio engie:" + this.p;
                this.p.a(this.q);
            }
        }
    }

    public void F(boolean z, int i2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2)}) == null) || this.l) {
            return;
        }
        this.z = System.nanoTime();
        this.k.u(str);
        this.k.s(z);
        int i3 = i2 * 1000;
        this.k.v(i3);
        this.k.x(this.r);
        this.k.w(this.s);
        this.f30708e = 0L;
        this.f30710g = 0L;
        if (i2 > 0 && i2 < 120) {
            this.f30704a = i3;
        } else {
            this.f30704a = 120000;
        }
        E(null);
    }

    public final void G(boolean z, AudioParams audioParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, audioParams) == null) {
            if (audioParams != null) {
                this.k.t(audioParams.getSampleRate());
                this.k.r(audioParams.getFrameSize());
                this.k.q(audioParams.getChannelConfig());
            }
            this.x = false;
            this.l = true;
            H();
            this.v = new Timer();
            C1416b c1416b = new C1416b(this);
            this.w = c1416b;
            this.v.schedule(c1416b, 300L, 20L);
        }
    }

    public final synchronized void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.v != null) {
                    this.v.cancel();
                    this.v = null;
                    this.w = null;
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            r();
            this.l = false;
            this.x = false;
            this.y = false;
            int i2 = this.n;
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                    throw new RuntimeException("unknown status " + this.n);
                }
                this.n = 0;
                d dVar = this.f30712i;
                if (dVar != null) {
                    dVar.U();
                }
            }
        }
    }

    public final void J(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (this.l && this.k != null) {
                int i3 = this.n;
                if (i3 == 0) {
                    p();
                    d dVar = this.f30712i;
                    if (dVar != null) {
                        dVar.S(this.m, this.k, this.f30713j);
                    }
                    this.n = 1;
                } else if (i3 != 1) {
                    if (i3 == 2) {
                        this.f30705b.m().j(i2);
                        d dVar2 = this.f30712i;
                        if (dVar2 != null) {
                            dVar2.W(this.f30705b);
                        }
                        this.n = 1;
                    } else {
                        throw new RuntimeException("unknown status " + this.n);
                    }
                }
            }
            d dVar3 = this.f30712i;
            if (dVar3 == null || this.f30707d) {
                return;
            }
            dVar3.H(j2 - this.f30708e);
        }
    }

    public final void K(ByteBuffer byteBuffer, int i2, long j2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (dVar = this.f30712i) == null || !this.l || byteBuffer == null || i2 <= 0 || this.f30707d) {
            return;
        }
        dVar.F(byteBuffer, i2, j2 - this.f30708e);
    }

    public final void p() {
        c.a.x.c.g.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (dVar = this.k) == null || this.f30705b == null) {
            return;
        }
        int l = dVar.l();
        int n = this.k.n();
        if (l >= 1920 || n >= 1920) {
            l = (int) ((l * 2) / 3.0f);
            n = (int) ((n * 2) / 3.0f);
        }
        if (l % 2 == 1) {
            l++;
        }
        if (n % 2 == 1) {
            n++;
        }
        String str = "Record video width:" + n + " ;video height:" + l;
        this.k.x(n);
        this.k.w(l);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.q == null) {
            this.q = new c(this);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f30707d) {
            this.f30708e += System.nanoTime() - this.f30709f;
            this.f30707d = false;
        }
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f30710g : invokeV.longValue;
    }

    public void t(boolean z, EGLContext eGLContext, int i2, int i3, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), eGLContext, Integer.valueOf(i2), Integer.valueOf(i3), context}) == null) || eGLContext == null) {
            return;
        }
        this.m = context;
        String str = "onContextChanged:" + eGLContext + "; w:" + i2 + "; h:" + i3 + "; isFlip:" + z;
        c.a.x.b.g.c cVar = this.f30705b;
        if (cVar == null) {
            this.f30705b = new c.a.x.b.g.c(eGLContext, 0, true);
        } else {
            cVar.q(eGLContext);
        }
        this.f30705b.l().h(i2);
        this.f30705b.l().g(i3);
        if (z) {
            this.f30705b.f().m(MirrorType.VERTICALLY);
        }
        this.r = i2;
        this.s = i3;
        this.k.x(i2);
        this.k.w(i3);
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.f30705b == null) {
            return;
        }
        if (this.f30706c != i2) {
            c.a.x.b.f.d dVar = new c.a.x.b.f.d();
            dVar.j(i2);
            this.f30705b.t(dVar);
            d dVar2 = this.f30712i;
            if (dVar2 != null) {
                dVar2.s(this.f30705b);
            }
            this.f30706c = i2;
        }
        J(this.f30706c, System.nanoTime());
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !this.f30707d && this.l) {
            this.f30707d = true;
            this.f30709f = System.nanoTime();
            this.f30708e = 0L;
            d dVar = this.f30712i;
            if (dVar != null) {
                dVar.I();
                long y = (this.f30709f - (this.f30710g * 1000000)) - this.f30712i.y();
                this.f30708e = y;
                if (y < 0) {
                    this.f30708e = 0L;
                }
            }
            c.a.x.c.c cVar = this.o;
            if (cVar != null) {
                cVar.onPause();
            }
            H();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!this.f30707d) {
                this.f30711h = true;
                v();
                return;
            }
            this.f30711h = false;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d dVar = this.f30712i;
            if (dVar != null) {
                dVar.G();
                this.f30712i = null;
            }
            if (this.f30713j != null) {
                this.f30713j = null;
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.f30707d) {
            this.f30708e += System.nanoTime() - this.f30709f;
            this.f30707d = false;
            E(null);
            c.a.x.c.c cVar = this.o;
            if (cVar != null) {
                cVar.onResume();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f30707d && this.f30711h) {
                y();
            }
            this.f30711h = false;
        }
    }
}
