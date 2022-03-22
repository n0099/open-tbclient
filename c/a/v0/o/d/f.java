package c.a.v0.o.d;

import android.graphics.SurfaceTexture;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.o.f.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.io.File;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f21758b;

    /* renamed from: c  reason: collision with root package name */
    public int f21759c;

    /* renamed from: d  reason: collision with root package name */
    public int f21760d;

    /* renamed from: e  reason: collision with root package name */
    public float f21761e;

    /* renamed from: f  reason: collision with root package name */
    public float f21762f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.v0.o.f.a f21763g;

    /* renamed from: h  reason: collision with root package name */
    public a.f f21764h;
    public a.b i;
    public a.e j;
    public c.a.v0.o.g.b k;
    public String l;
    public int m;
    public SurfaceTexture n;
    public int o;
    public int p;
    public c.a.v0.o.g.c q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean v;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.f21758b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.f21759c = RecordConstants.DEFAULT_BIT_RATE_GTE_API18;
        this.f21760d = 1;
        this.f21761e = 1.0f;
        this.f21762f = 0.0f;
        this.p = -100;
        this.s = false;
        this.t = 10000;
        this.u = 30;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.v0.o.f.a aVar = this.f21763g;
            if (aVar != null) {
                aVar.c();
                this.f21763g.l(null);
            }
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f21762f = f2;
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.o = i;
        }
    }

    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) || i <= 0 || i2 <= 0) {
            return;
        }
        if (this.o <= 0) {
            this.o = RecordConstants.VIDEO_CONSTANT_WIDTH;
        }
        this.a = i;
        this.f21758b = i2;
        if (i2 > i) {
            int i3 = this.o;
            i2 = ((i2 * i3) / i) - (((i3 * i2) / i) % 16);
            i = i3;
        } else if (i2 < i) {
            int i4 = this.o;
            i = ((i * i4) / i2) - (((i4 * i) / i2) % 16);
            i2 = i4;
        }
        this.a = i;
        this.f21758b = i2;
    }

    public void e(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceTexture) == null) {
            this.n = surfaceTexture;
        }
    }

    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void g(a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.j = eVar;
        }
    }

    public void h(c.a.v0.o.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void i(c.a.v0.o.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.q = cVar;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.l = str;
            try {
                c.a.v0.o.f.a aVar = new c.a.v0.o.f.a();
                this.f21763g = aVar;
                aVar.d(this.f21761e);
                this.f21763g.B(this.p);
                if (this.f21762f != 0.0f) {
                    this.f21763g.A(this.f21762f);
                }
                this.f21763g.l(this.f21764h);
                this.f21763g.i(this.i);
                this.f21763g.k(this.j);
                this.f21763g.r(this.q);
                this.f21763g.E(this.r);
                this.f21763g.I(this.s);
                this.f21763g.s(this.v);
            } catch (Throwable th) {
                c.a.v0.r.c.c("VideoRecorder", th.toString());
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.v = z;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f21759c = i;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.r = z;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.m++;
            try {
                if (this.f21763g != null && this.f21763g.u(2)) {
                    File file = new File(this.l);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (this.f21762f == 90.0f || this.f21762f == 270.0f) {
                        int i = this.a;
                        this.a = this.f21758b;
                        this.f21758b = i;
                    }
                    this.f21763g.j(new a.d(file, this.a, this.f21758b, this.f21759c, this.u, null, this.n.getTimestamp(), this.t));
                }
                if (this.f21763g == null || this.m % this.f21760d != 0 || this.k == null) {
                    return;
                }
                this.k.a(this.f21763g, this.n);
            } catch (Throwable th) {
                c.a.v0.r.c.c("VideoRecorder", th.toString());
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.u = i;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.s = z;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.t = i;
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.v0.o.f.a aVar = this.f21763g;
            if (aVar != null) {
                return aVar.u(1);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.p = i;
        }
    }

    public void t(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            this.f21761e = f2;
            if (Math.abs(f2 - 3.0f) < 0.01f) {
                this.f21760d = 2;
                return;
            }
            int i = (Math.abs(this.f21761e - 2.0f) > 0.01f ? 1 : (Math.abs(this.f21761e - 2.0f) == 0.01f ? 0 : -1));
            this.f21760d = 1;
        }
    }
}
