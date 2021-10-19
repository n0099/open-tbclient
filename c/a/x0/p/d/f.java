package c.a.x0.p.d;

import android.graphics.SurfaceTexture;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.p.f.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.io.File;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f31099a;

    /* renamed from: b  reason: collision with root package name */
    public int f31100b;

    /* renamed from: c  reason: collision with root package name */
    public int f31101c;

    /* renamed from: d  reason: collision with root package name */
    public int f31102d;

    /* renamed from: e  reason: collision with root package name */
    public float f31103e;

    /* renamed from: f  reason: collision with root package name */
    public float f31104f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.x0.p.f.a f31105g;

    /* renamed from: h  reason: collision with root package name */
    public a.f f31106h;

    /* renamed from: i  reason: collision with root package name */
    public a.b f31107i;

    /* renamed from: j  reason: collision with root package name */
    public a.e f31108j;
    public c.a.x0.p.g.b k;
    public String l;
    public int m;
    public SurfaceTexture n;
    public int o;
    public int p;
    public c.a.x0.p.g.c q;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31099a = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.f31100b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.f31101c = RecordConstants.DEFAULT_BIT_RATE_GTE_API18;
        this.f31102d = 1;
        this.f31103e = 1.0f;
        this.f31104f = 0.0f;
        this.p = -100;
        this.s = false;
        this.t = 10000;
        this.u = 30;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.x0.p.f.a aVar = this.f31105g;
            if (aVar != null) {
                aVar.c();
                this.f31105g.l(null);
            }
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f31104f = f2;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.o = i2;
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        if (this.o <= 0) {
            this.o = RecordConstants.VIDEO_CONSTANT_WIDTH;
        }
        this.f31099a = i2;
        this.f31100b = i3;
        if (i3 > i2) {
            int i4 = this.o;
            i3 = ((i3 * i4) / i2) - (((i4 * i3) / i2) % 16);
            i2 = i4;
        } else if (i3 < i2) {
            int i5 = this.o;
            i2 = ((i2 * i5) / i3) - (((i5 * i2) / i3) % 16);
            i3 = i5;
        }
        this.f31099a = i2;
        this.f31100b = i3;
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
            this.f31107i = bVar;
        }
    }

    public void g(a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f31108j = eVar;
        }
    }

    public void h(c.a.x0.p.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void i(c.a.x0.p.g.c cVar) {
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
                c.a.x0.p.f.a aVar = new c.a.x0.p.f.a();
                this.f31105g = aVar;
                aVar.d(this.f31103e);
                this.f31105g.B(this.p);
                if (this.f31104f != 0.0f) {
                    this.f31105g.A(this.f31104f);
                }
                this.f31105g.l(this.f31106h);
                this.f31105g.i(this.f31107i);
                this.f31105g.k(this.f31108j);
                this.f31105g.r(this.q);
                this.f31105g.E(this.r);
                this.f31105g.I(this.s);
                this.f31105g.s(this.v);
            } catch (Throwable th) {
                c.a.x0.t.c.c("VideoRecorder", th.toString());
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.v = z;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f31101c = i2;
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
                if (this.f31105g != null && this.f31105g.u(2)) {
                    File file = new File(this.l);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (this.f31104f == 90.0f || this.f31104f == 270.0f) {
                        int i2 = this.f31099a;
                        this.f31099a = this.f31100b;
                        this.f31100b = i2;
                    }
                    this.f31105g.j(new a.d(file, this.f31099a, this.f31100b, this.f31101c, this.u, null, this.n.getTimestamp(), this.t));
                }
                if (this.f31105g == null || this.m % this.f31102d != 0 || this.k == null) {
                    return;
                }
                this.k.a(this.f31105g, this.n);
            } catch (Throwable th) {
                c.a.x0.t.c.c("VideoRecorder", th.toString());
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.u = i2;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.s = z;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.t = i2;
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.x0.p.f.a aVar = this.f31105g;
            if (aVar != null) {
                return aVar.u(1);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.p = i2;
        }
    }

    public void t(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            this.f31103e = f2;
            if (Math.abs(f2 - 3.0f) < 0.01f) {
                this.f31102d = 2;
                return;
            }
            int i2 = (Math.abs(this.f31103e - 2.0f) > 0.01f ? 1 : (Math.abs(this.f31103e - 2.0f) == 0.01f ? 0 : -1));
            this.f31102d = 1;
        }
    }
}
