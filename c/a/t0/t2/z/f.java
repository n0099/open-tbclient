package c.a.t0.t2.z;

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
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;

    /* renamed from: b  reason: collision with root package name */
    public int f23673b;

    /* renamed from: c  reason: collision with root package name */
    public int f23674c;

    /* renamed from: d  reason: collision with root package name */
    public float f23675d;

    /* renamed from: e  reason: collision with root package name */
    public float f23676e;

    /* renamed from: f  reason: collision with root package name */
    public float f23677f;

    /* renamed from: g  reason: collision with root package name */
    public int f23678g;

    /* renamed from: h  reason: collision with root package name */
    public int f23679h;

    /* renamed from: i  reason: collision with root package name */
    public b f23680i;

    /* renamed from: j  reason: collision with root package name */
    public int f23681j;
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
        public Bitmap f23682b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f23683c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f23684d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f23685e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f23686f;

        /* renamed from: g  reason: collision with root package name */
        public int f23687g;

        /* renamed from: h  reason: collision with root package name */
        public int f23688h;

        /* renamed from: i  reason: collision with root package name */
        public int f23689i;

        /* renamed from: j  reason: collision with root package name */
        public int f23690j;
        public c k;

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
            this.f23682b = bitmap;
            this.f23683c = false;
            this.f23684d = false;
            this.f23685e = false;
            this.f23686f = false;
        }

        public f l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new f(this, null) : (f) invokeV.objValue;
        }

        public b m(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                this.f23689i = i2;
                this.f23690j = i3;
                return this;
            }
            return (b) invokeII.objValue;
        }

        public b n(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                this.k = cVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                this.f23687g = i2;
                this.f23688h = i3;
                this.f23682b = f.a(this.f23682b, i2, i3);
                this.f23684d = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b p(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                this.a = i2;
                this.f23683c = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b q(int i2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                this.f23685e = z;
                this.f23686f = z2;
                return this;
            }
            return (b) invokeCommon.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        float a();
    }

    public /* synthetic */ f(b bVar, a aVar) {
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
            float f2 = this.f23676e;
            if (f2 > this.k || f2 < 0.0f) {
                return false;
            }
            canvas.drawBitmap(this.u, this.f23675d, f2, paint);
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
            this.f23675d = (float) (this.f23675d + (Math.sin(this.l) * 10.0d));
            if (this.s) {
                this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
            }
            float f2 = this.f23675d;
            int i2 = this.f23681j;
            int i3 = this.o;
            if (f2 > i2 - i3) {
                this.f23675d = i2 - i3;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23676e += this.f23677f;
        }
    }

    public final void f() {
        float nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.n) {
                this.u = this.f23680i.f23682b;
            } else {
                c cVar = this.a;
                if (cVar != null) {
                    nextInt = cVar.a();
                } else {
                    nextInt = (this.t.nextInt(10) + 1) * 0.1f;
                }
                int i2 = this.p;
                this.u = a(this.f23680i.f23682b, (int) (i2 > 0 ? Math.max(i2, this.f23680i.f23682b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f23680i.f23682b.getHeight(), this.q) : 0.0f));
            }
            this.u.getWidth();
            this.u.getHeight();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.m) {
                this.f23677f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f23673b;
            } else {
                this.f23677f = this.f23673b;
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.r) {
                this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f23674c) / 50.0d);
            } else {
                this.l = this.f23674c / 50.0f;
            }
            float f2 = this.l;
            if (f2 > 1.5707964f) {
                this.l = 1.5707964f;
            } else if (f2 < -1.5707964f) {
                this.l = -1.5707964f;
            }
        }
    }

    public f(b bVar, int i2, int i3) {
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
        this.f23680i = bVar;
        this.f23681j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f23678g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f23679h = nextInt;
        this.f23675d = this.f23678g;
        this.f23676e = nextInt;
        this.m = bVar.f23683c;
        this.n = bVar.f23684d;
        this.a = bVar.k;
        this.p = bVar.f23689i;
        this.q = bVar.f23690j;
        this.o = bVar.f23687g;
        int unused = bVar.f23688h;
        this.r = bVar.f23685e;
        this.s = bVar.f23686f;
        this.f23673b = bVar.a;
        g();
        f();
        h();
    }

    public f(b bVar) {
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
        this.f23680i = bVar;
        this.u = bVar.f23682b;
        this.o = bVar.f23687g;
        int unused = bVar.f23688h;
        this.p = bVar.f23689i;
        this.a = bVar.k;
        this.q = bVar.f23690j;
        this.f23673b = bVar.a;
        this.n = bVar.f23684d;
        this.r = bVar.f23685e;
        this.s = bVar.f23686f;
        this.m = bVar.f23683c;
    }
}
