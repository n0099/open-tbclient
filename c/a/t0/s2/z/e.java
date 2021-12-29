package c.a.t0.s2.z;

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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;

    /* renamed from: b  reason: collision with root package name */
    public int f24064b;

    /* renamed from: c  reason: collision with root package name */
    public int f24065c;

    /* renamed from: d  reason: collision with root package name */
    public float f24066d;

    /* renamed from: e  reason: collision with root package name */
    public float f24067e;

    /* renamed from: f  reason: collision with root package name */
    public float f24068f;

    /* renamed from: g  reason: collision with root package name */
    public int f24069g;

    /* renamed from: h  reason: collision with root package name */
    public int f24070h;

    /* renamed from: i  reason: collision with root package name */
    public b f24071i;

    /* renamed from: j  reason: collision with root package name */
    public int f24072j;

    /* renamed from: k  reason: collision with root package name */
    public int f24073k;
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

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f24074b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f24075c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f24076d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f24077e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f24078f;

        /* renamed from: g  reason: collision with root package name */
        public int f24079g;

        /* renamed from: h  reason: collision with root package name */
        public int f24080h;

        /* renamed from: i  reason: collision with root package name */
        public int f24081i;

        /* renamed from: j  reason: collision with root package name */
        public int f24082j;

        /* renamed from: k  reason: collision with root package name */
        public c f24083k;

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
            this.a = 10;
            this.f24074b = bitmap;
            this.f24075c = false;
            this.f24076d = false;
            this.f24077e = false;
            this.f24078f = false;
        }

        public e l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new e(this, null) : (e) invokeV.objValue;
        }

        public b m(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                this.f24081i = i2;
                this.f24082j = i3;
                return this;
            }
            return (b) invokeII.objValue;
        }

        public b n(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                this.f24083k = cVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                this.f24079g = i2;
                this.f24080h = i3;
                this.f24074b = e.a(this.f24074b, i2, i3);
                this.f24076d = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b p(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                this.a = i2;
                this.f24075c = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b q(int i2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                this.f24077e = z;
                this.f24078f = z2;
                return this;
            }
            return (b) invokeCommon.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        float a();
    }

    public /* synthetic */ e(b bVar, a aVar) {
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

    public boolean b(Canvas canvas, Paint paint) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, canvas, paint)) == null) {
            c();
            float f2 = this.f24067e;
            if (f2 > this.f24073k || f2 < 0.0f) {
                return false;
            }
            canvas.drawBitmap(this.u, this.f24066d, f2, paint);
            return true;
        }
        return invokeLL.booleanValue;
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
            this.f24066d = (float) (this.f24066d + (Math.sin(this.l) * 10.0d));
            if (this.s) {
                this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
            }
            float f2 = this.f24066d;
            int i2 = this.f24072j;
            int i3 = this.o;
            if (f2 > i2 - i3) {
                this.f24066d = i2 - i3;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24067e += this.f24068f;
        }
    }

    public final void f() {
        float nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.n) {
                this.u = this.f24071i.f24074b;
            } else {
                c cVar = this.a;
                if (cVar != null) {
                    nextInt = cVar.a();
                } else {
                    nextInt = (this.t.nextInt(10) + 1) * 0.1f;
                }
                int i2 = this.p;
                this.u = a(this.f24071i.f24074b, (int) (i2 > 0 ? Math.max(i2, this.f24071i.f24074b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f24071i.f24074b.getHeight(), this.q) : 0.0f));
            }
            this.u.getWidth();
            this.u.getHeight();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.m) {
                this.f24068f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f24064b;
            } else {
                this.f24068f = this.f24064b;
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.r) {
                this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f24065c) / 50.0d);
            } else {
                this.l = this.f24065c / 50.0f;
            }
            float f2 = this.l;
            if (f2 > 1.5707964f) {
                this.l = 1.5707964f;
            } else if (f2 < -1.5707964f) {
                this.l = -1.5707964f;
            }
        }
    }

    public e(b bVar, int i2, int i3) {
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
        this.f24071i = bVar;
        this.f24072j = i2;
        this.f24073k = i3;
        Random random = new Random();
        this.t = random;
        this.f24069g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f24070h = nextInt;
        this.f24066d = this.f24069g;
        this.f24067e = nextInt;
        this.m = bVar.f24075c;
        this.n = bVar.f24076d;
        this.a = bVar.f24083k;
        this.p = bVar.f24081i;
        this.q = bVar.f24082j;
        this.o = bVar.f24079g;
        int unused = bVar.f24080h;
        this.r = bVar.f24077e;
        this.s = bVar.f24078f;
        this.f24064b = bVar.a;
        g();
        f();
        h();
    }

    public e(b bVar) {
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
        this.f24071i = bVar;
        this.u = bVar.f24074b;
        this.o = bVar.f24079g;
        int unused = bVar.f24080h;
        this.p = bVar.f24081i;
        this.a = bVar.f24083k;
        this.q = bVar.f24082j;
        this.f24064b = bVar.a;
        this.n = bVar.f24076d;
        this.r = bVar.f24077e;
        this.s = bVar.f24078f;
        this.m = bVar.f24075c;
    }
}
