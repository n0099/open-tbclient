package c.a.r0.k2.p;

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
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f20916a;

    /* renamed from: b  reason: collision with root package name */
    public int f20917b;

    /* renamed from: c  reason: collision with root package name */
    public int f20918c;

    /* renamed from: d  reason: collision with root package name */
    public float f20919d;

    /* renamed from: e  reason: collision with root package name */
    public float f20920e;

    /* renamed from: f  reason: collision with root package name */
    public float f20921f;

    /* renamed from: g  reason: collision with root package name */
    public int f20922g;

    /* renamed from: h  reason: collision with root package name */
    public int f20923h;

    /* renamed from: i  reason: collision with root package name */
    public b f20924i;

    /* renamed from: j  reason: collision with root package name */
    public int f20925j;
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
        public int f20926a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f20927b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f20928c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f20929d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20930e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f20931f;

        /* renamed from: g  reason: collision with root package name */
        public int f20932g;

        /* renamed from: h  reason: collision with root package name */
        public int f20933h;

        /* renamed from: i  reason: collision with root package name */
        public int f20934i;

        /* renamed from: j  reason: collision with root package name */
        public int f20935j;
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
            this.f20926a = 10;
            this.f20927b = bitmap;
            this.f20928c = false;
            this.f20929d = false;
            this.f20930e = false;
            this.f20931f = false;
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
                this.f20934i = i2;
                this.f20935j = i3;
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
                this.f20932g = i2;
                this.f20933h = i3;
                this.f20927b = e.a(this.f20927b, i2, i3);
                this.f20929d = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b p(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                this.f20926a = i2;
                this.f20928c = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b q(int i2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                this.f20930e = z;
                this.f20931f = z2;
                return this;
            }
            return (b) invokeCommon.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
            float f2 = this.f20920e;
            if (f2 > this.k || f2 < 0.0f) {
                return false;
            }
            canvas.drawBitmap(this.u, this.f20919d, f2, paint);
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
            this.f20919d = (float) (this.f20919d + (Math.sin(this.l) * 10.0d));
            if (this.s) {
                this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
            }
            float f2 = this.f20919d;
            int i2 = this.f20925j;
            int i3 = this.o;
            if (f2 > i2 - i3) {
                this.f20919d = i2 - i3;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20920e += this.f20921f;
        }
    }

    public final void f() {
        float nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.n) {
                this.u = this.f20924i.f20927b;
            } else {
                c cVar = this.f20916a;
                if (cVar != null) {
                    nextInt = cVar.a();
                } else {
                    nextInt = (this.t.nextInt(10) + 1) * 0.1f;
                }
                int i2 = this.p;
                this.u = a(this.f20924i.f20927b, (int) (i2 > 0 ? Math.max(i2, this.f20924i.f20927b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f20924i.f20927b.getHeight(), this.q) : 0.0f));
            }
            this.u.getWidth();
            this.u.getHeight();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.m) {
                this.f20921f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f20917b;
            } else {
                this.f20921f = this.f20917b;
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.r) {
                this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f20918c) / 50.0d);
            } else {
                this.l = this.f20918c / 50.0f;
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
        this.f20924i = bVar;
        this.f20925j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f20922g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f20923h = nextInt;
        this.f20919d = this.f20922g;
        this.f20920e = nextInt;
        this.m = bVar.f20928c;
        this.n = bVar.f20929d;
        this.f20916a = bVar.k;
        this.p = bVar.f20934i;
        this.q = bVar.f20935j;
        this.o = bVar.f20932g;
        int unused = bVar.f20933h;
        this.r = bVar.f20930e;
        this.s = bVar.f20931f;
        this.f20917b = bVar.f20926a;
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
        this.f20924i = bVar;
        this.u = bVar.f20927b;
        this.o = bVar.f20932g;
        int unused = bVar.f20933h;
        this.p = bVar.f20934i;
        this.f20916a = bVar.k;
        this.q = bVar.f20935j;
        this.f20917b = bVar.f20926a;
        this.n = bVar.f20929d;
        this.r = bVar.f20930e;
        this.s = bVar.f20931f;
        this.m = bVar.f20928c;
    }
}
