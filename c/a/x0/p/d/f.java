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
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f27088b;

    /* renamed from: c  reason: collision with root package name */
    public int f27089c;

    /* renamed from: d  reason: collision with root package name */
    public int f27090d;

    /* renamed from: e  reason: collision with root package name */
    public float f27091e;

    /* renamed from: f  reason: collision with root package name */
    public float f27092f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.x0.p.f.a f27093g;

    /* renamed from: h  reason: collision with root package name */
    public a.f f27094h;

    /* renamed from: i  reason: collision with root package name */
    public a.b f27095i;

    /* renamed from: j  reason: collision with root package name */
    public a.e f27096j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.x0.p.g.b f27097k;
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
        this.a = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.f27088b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.f27089c = RecordConstants.DEFAULT_BIT_RATE_GTE_API18;
        this.f27090d = 1;
        this.f27091e = 1.0f;
        this.f27092f = 0.0f;
        this.p = -100;
        this.s = false;
        this.t = 10000;
        this.u = 30;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.x0.p.f.a aVar = this.f27093g;
            if (aVar != null) {
                aVar.c();
                this.f27093g.l(null);
            }
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f27092f = f2;
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
        this.a = i2;
        this.f27088b = i3;
        if (i3 > i2) {
            int i4 = this.o;
            i3 = ((i3 * i4) / i2) - (((i4 * i3) / i2) % 16);
            i2 = i4;
        } else if (i3 < i2) {
            int i5 = this.o;
            i2 = ((i2 * i5) / i3) - (((i5 * i2) / i3) % 16);
            i3 = i5;
        }
        this.a = i2;
        this.f27088b = i3;
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
            this.f27095i = bVar;
        }
    }

    public void g(a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f27096j = eVar;
        }
    }

    public void h(c.a.x0.p.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f27097k = bVar;
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
                this.f27093g = aVar;
                aVar.d(this.f27091e);
                this.f27093g.B(this.p);
                if (this.f27092f != 0.0f) {
                    this.f27093g.A(this.f27092f);
                }
                this.f27093g.l(this.f27094h);
                this.f27093g.i(this.f27095i);
                this.f27093g.k(this.f27096j);
                this.f27093g.r(this.q);
                this.f27093g.E(this.r);
                this.f27093g.I(this.s);
                this.f27093g.s(this.v);
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
            this.f27089c = i2;
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
                if (this.f27093g != null && this.f27093g.u(2)) {
                    File file = new File(this.l);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (this.f27092f == 90.0f || this.f27092f == 270.0f) {
                        int i2 = this.a;
                        this.a = this.f27088b;
                        this.f27088b = i2;
                    }
                    this.f27093g.j(new a.d(file, this.a, this.f27088b, this.f27089c, this.u, null, this.n.getTimestamp(), this.t));
                }
                if (this.f27093g == null || this.m % this.f27090d != 0 || this.f27097k == null) {
                    return;
                }
                this.f27097k.a(this.f27093g, this.n);
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
            c.a.x0.p.f.a aVar = this.f27093g;
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
            this.f27091e = f2;
            if (Math.abs(f2 - 3.0f) < 0.01f) {
                this.f27090d = 2;
                return;
            }
            int i2 = (Math.abs(this.f27091e - 2.0f) > 0.01f ? 1 : (Math.abs(this.f27091e - 2.0f) == 0.01f ? 0 : -1));
            this.f27090d = 1;
        }
    }
}
