package b.a.x.c;

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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29418a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.x.b.g.c f29419b;

    /* renamed from: c  reason: collision with root package name */
    public int f29420c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29421d;

    /* renamed from: e  reason: collision with root package name */
    public long f29422e;

    /* renamed from: f  reason: collision with root package name */
    public long f29423f;

    /* renamed from: g  reason: collision with root package name */
    public long f29424g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29425h;

    /* renamed from: i  reason: collision with root package name */
    public d f29426i;
    public e j;
    public b.a.x.c.g.d k;
    public boolean l;
    public Context m;
    public int n;
    public b.a.x.c.c o;
    public b.a.x.c.a p;
    public b.a.x.a.a.a q;
    public int r;
    public int s;
    public byte[] t;
    public ByteBuffer u;
    public Timer v;
    public TimerTask w;
    public boolean x;
    public boolean y;
    public long z;

    /* loaded from: classes6.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f29427a;

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
            this.f29427a = bVar;
        }

        @Override // b.a.x.c.e
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f29427a.f29424g = j;
                if (j <= this.f29427a.f29418a || !this.f29427a.l) {
                    return;
                }
                this.f29427a.I();
            }
        }

        @Override // b.a.x.c.e
        public void onRecorderComplete(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                String unused = b.A;
                String str2 = "on RecorderComplete record time :" + this.f29427a.f29424g;
                if (this.f29427a.o != null) {
                    this.f29427a.o.v((int) this.f29427a.f29424g, str);
                }
            }
        }

        @Override // b.a.x.c.e
        public void onRecorderError(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                String unused = b.A;
                String str = "onRecorderError:" + i2;
                if (this.f29427a.o != null) {
                    this.f29427a.o.onError(i2);
                }
            }
        }

        @Override // b.a.x.c.e
        public void onRecorderStart(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.f29427a.o == null) {
                return;
            }
            this.f29427a.o.onStart();
            this.f29427a.x = true;
        }
    }

    /* renamed from: b.a.x.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1416b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29428e;

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
            this.f29428e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29428e.x && !this.f29428e.y) {
                    String unused = b.A;
                    this.f29428e.H();
                    this.f29428e.y = false;
                    return;
                }
                b bVar = this.f29428e;
                bVar.K(bVar.u, 3840, System.nanoTime() - this.f29428e.z);
                this.f29428e.y = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements b.a.x.a.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<b> f29429a;

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
            this.f29429a = new WeakReference<>(bVar);
            String unused = b.A;
            String str = "gameRecorderRef is:" + this.f29429a.get();
        }

        @Override // b.a.x.a.a.a
        public void a(boolean z, AudioParams audioParams) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, audioParams) == null) || this.f29429a.get() == null) {
                return;
            }
            this.f29429a.get().G(z, audioParams);
            String unused = b.A;
        }

        @Override // b.a.x.a.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f29429a.get() == null) {
                return;
            }
            this.f29429a.get().y = false;
            this.f29429a.get().K(byteBuffer, i2, j);
        }

        @Override // b.a.x.a.a.a
        public void onAudioStop(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                String unused = b.A;
                if (this.f29429a.get() != null) {
                    this.f29429a.get().H();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-760006077, "Lb/a/x/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-760006077, "Lb/a/x/c/b;");
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
        this.f29418a = 120000;
        this.f29420c = -1;
        this.f29421d = false;
        this.f29425h = false;
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
        this.f29426i = d.x();
        this.p = null;
        this.j = new a(this);
        D(new b.a.x.c.g.d(), this.j);
    }

    public void A(b.a.x.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void B(b.a.x.c.g.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.k = dVar;
        }
    }

    public void C(b.a.x.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void D(b.a.x.c.g.d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, dVar, eVar) == null) {
            B(dVar);
            this.j = eVar;
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
        this.f29422e = 0L;
        this.f29424g = 0L;
        if (i2 > 0 && i2 < 120) {
            this.f29418a = i3;
        } else {
            this.f29418a = 120000;
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
                d dVar = this.f29426i;
                if (dVar != null) {
                    dVar.U();
                }
            }
        }
    }

    public final void J(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (this.l && this.k != null) {
                int i3 = this.n;
                if (i3 == 0) {
                    p();
                    d dVar = this.f29426i;
                    if (dVar != null) {
                        dVar.S(this.m, this.k, this.j);
                    }
                    this.n = 1;
                } else if (i3 != 1) {
                    if (i3 == 2) {
                        this.f29419b.k().g(i2);
                        d dVar2 = this.f29426i;
                        if (dVar2 != null) {
                            dVar2.W(this.f29419b);
                        }
                        this.n = 1;
                    } else {
                        throw new RuntimeException("unknown status " + this.n);
                    }
                }
            }
            d dVar3 = this.f29426i;
            if (dVar3 == null || this.f29421d) {
                return;
            }
            dVar3.H(j - this.f29422e);
        }
    }

    public final void K(ByteBuffer byteBuffer, int i2, long j) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (dVar = this.f29426i) == null || !this.l || byteBuffer == null || i2 <= 0 || this.f29421d) {
            return;
        }
        dVar.F(byteBuffer, i2, j - this.f29422e);
    }

    public final void p() {
        b.a.x.c.g.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (dVar = this.k) == null || this.f29419b == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f29421d) {
            this.f29422e += System.nanoTime() - this.f29423f;
            this.f29421d = false;
        }
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f29424g : invokeV.longValue;
    }

    public void t(boolean z, EGLContext eGLContext, int i2, int i3, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), eGLContext, Integer.valueOf(i2), Integer.valueOf(i3), context}) == null) || eGLContext == null) {
            return;
        }
        this.m = context;
        String str = "onContextChanged:" + eGLContext + "; w:" + i2 + "; h:" + i3 + "; isFlip:" + z;
        b.a.x.b.g.c cVar = this.f29419b;
        if (cVar == null) {
            this.f29419b = new b.a.x.b.g.c(eGLContext, 0, true);
        } else {
            cVar.o(eGLContext);
        }
        this.f29419b.j().f(i2);
        this.f29419b.j().e(i3);
        if (z) {
            this.f29419b.c().k(MirrorType.VERTICALLY);
        }
        this.r = i2;
        this.s = i3;
        this.k.x(i2);
        this.k.w(i3);
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.f29419b == null) {
            return;
        }
        if (this.f29420c != i2) {
            b.a.x.b.f.d dVar = new b.a.x.b.f.d();
            dVar.g(i2);
            this.f29419b.r(dVar);
            d dVar2 = this.f29426i;
            if (dVar2 != null) {
                dVar2.s(this.f29419b);
            }
            this.f29420c = i2;
        }
        J(this.f29420c, System.nanoTime());
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !this.f29421d && this.l) {
            this.f29421d = true;
            this.f29423f = System.nanoTime();
            this.f29422e = 0L;
            d dVar = this.f29426i;
            if (dVar != null) {
                dVar.I();
                long y = (this.f29423f - (this.f29424g * 1000000)) - this.f29426i.y();
                this.f29422e = y;
                if (y < 0) {
                    this.f29422e = 0L;
                }
            }
            b.a.x.c.c cVar = this.o;
            if (cVar != null) {
                cVar.onPause();
            }
            H();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!this.f29421d) {
                this.f29425h = true;
                v();
                return;
            }
            this.f29425h = false;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d dVar = this.f29426i;
            if (dVar != null) {
                dVar.G();
                this.f29426i = null;
            }
            if (this.j != null) {
                this.j = null;
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.f29421d) {
            this.f29422e += System.nanoTime() - this.f29423f;
            this.f29421d = false;
            E(null);
            b.a.x.c.c cVar = this.o;
            if (cVar != null) {
                cVar.onResume();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f29421d && this.f29425h) {
                y();
            }
            this.f29425h = false;
        }
    }
}
