package c.a.p0.i2.p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0939c f19833a;

    /* renamed from: b  reason: collision with root package name */
    public int f19834b;

    /* renamed from: c  reason: collision with root package name */
    public int f19835c;

    /* renamed from: d  reason: collision with root package name */
    public float f19836d;

    /* renamed from: e  reason: collision with root package name */
    public float f19837e;

    /* renamed from: f  reason: collision with root package name */
    public float f19838f;

    /* renamed from: g  reason: collision with root package name */
    public int f19839g;

    /* renamed from: h  reason: collision with root package name */
    public int f19840h;

    /* renamed from: i  reason: collision with root package name */
    public b f19841i;

    /* renamed from: j  reason: collision with root package name */
    public int f19842j;
    public int k;
    public float l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public Random t;
    public Bitmap u;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19843a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f19844b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f19845c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f19846d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19847e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f19848f;

        /* renamed from: g  reason: collision with root package name */
        public int f19849g;

        /* renamed from: h  reason: collision with root package name */
        public int f19850h;

        /* renamed from: i  reason: collision with root package name */
        public int f19851i;

        /* renamed from: j  reason: collision with root package name */
        public int f19852j;
        public InterfaceC0939c k;

        public b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19843a = 10;
            this.f19844b = bitmap;
            this.f19845c = false;
            this.f19846d = false;
            this.f19847e = false;
            this.f19848f = false;
        }

        public c l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this, null) : (c) invokeV.objValue;
        }

        public b m(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                this.f19851i = i2;
                this.f19852j = i3;
                return this;
            }
            return (b) invokeII.objValue;
        }

        public b n(InterfaceC0939c interfaceC0939c) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0939c)) == null) {
                this.k = interfaceC0939c;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                this.f19849g = i2;
                this.f19850h = i3;
                this.f19844b = c.a(this.f19844b, i2, i3);
                this.f19846d = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b p(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                this.f19843a = i2;
                this.f19845c = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b q(int i2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                this.f19847e = z;
                this.f19848f = z2;
                return this;
            }
            return (b) invokeCommon.objValue;
        }
    }

    /* renamed from: c.a.p0.i2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0939c {
        float a();
    }

    public /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bitmap, i2, i3)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i2 / width, i3 / height);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public void b(Canvas canvas, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, paint) == null) {
            c();
            float f2 = this.f19837e;
            if (f2 > this.k) {
                return;
            }
            canvas.drawBitmap(this.u, this.f19836d, f2, paint);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d();
            e();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19836d = (float) (this.f19836d + (Math.sin(this.l) * 10.0d));
            if (this.s) {
                this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
            }
            float f2 = this.f19836d;
            int i2 = this.f19842j;
            int i3 = this.o;
            if (f2 > i2 - i3) {
                this.f19836d = i2 - i3;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19837e += this.f19838f;
        }
    }

    public final void f() {
        float nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.n) {
                this.u = this.f19841i.f19844b;
            } else {
                InterfaceC0939c interfaceC0939c = this.f19833a;
                if (interfaceC0939c != null) {
                    nextInt = interfaceC0939c.a();
                } else {
                    nextInt = (this.t.nextInt(10) + 1) * 0.1f;
                }
                int i2 = this.p;
                this.u = a(this.f19841i.f19844b, (int) (i2 > 0 ? Math.max(i2, this.f19841i.f19844b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f19841i.f19844b.getHeight(), this.q) : 0.0f));
            }
            this.u.getWidth();
            this.u.getHeight();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.m) {
                this.f19838f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f19834b;
            } else {
                this.f19838f = this.f19834b;
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.r) {
                this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f19835c) / 50.0d);
            } else {
                this.l = this.f19835c / 50.0f;
            }
            float f2 = this.l;
            if (f2 > 1.5707964f) {
                this.l = 1.5707964f;
            } else if (f2 < -1.5707964f) {
                this.l = -1.5707964f;
            }
        }
    }

    public c(b bVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19841i = bVar;
        this.f19842j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f19839g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f19840h = nextInt;
        this.f19836d = this.f19839g;
        this.f19837e = nextInt;
        this.m = bVar.f19845c;
        this.n = bVar.f19846d;
        this.f19833a = bVar.k;
        this.p = bVar.f19851i;
        this.q = bVar.f19852j;
        this.o = bVar.f19849g;
        int unused = bVar.f19850h;
        this.r = bVar.f19847e;
        this.s = bVar.f19848f;
        this.f19834b = bVar.f19843a;
        g();
        f();
        h();
    }

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
        this.f19841i = bVar;
        this.u = bVar.f19844b;
        this.o = bVar.f19849g;
        int unused = bVar.f19850h;
        this.p = bVar.f19851i;
        this.f19833a = bVar.k;
        this.q = bVar.f19852j;
        this.f19834b = bVar.f19843a;
        this.n = bVar.f19846d;
        this.r = bVar.f19847e;
        this.s = bVar.f19848f;
        this.m = bVar.f19845c;
    }
}
