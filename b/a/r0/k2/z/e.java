package b.a.r0.k2.z;

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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f19887a;

    /* renamed from: b  reason: collision with root package name */
    public int f19888b;

    /* renamed from: c  reason: collision with root package name */
    public int f19889c;

    /* renamed from: d  reason: collision with root package name */
    public float f19890d;

    /* renamed from: e  reason: collision with root package name */
    public float f19891e;

    /* renamed from: f  reason: collision with root package name */
    public float f19892f;

    /* renamed from: g  reason: collision with root package name */
    public int f19893g;

    /* renamed from: h  reason: collision with root package name */
    public int f19894h;

    /* renamed from: i  reason: collision with root package name */
    public b f19895i;
    public int j;
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

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19896a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f19897b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f19898c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f19899d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19900e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f19901f;

        /* renamed from: g  reason: collision with root package name */
        public int f19902g;

        /* renamed from: h  reason: collision with root package name */
        public int f19903h;

        /* renamed from: i  reason: collision with root package name */
        public int f19904i;
        public int j;
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
            this.f19896a = 10;
            this.f19897b = bitmap;
            this.f19898c = false;
            this.f19899d = false;
            this.f19900e = false;
            this.f19901f = false;
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
                this.f19904i = i2;
                this.j = i3;
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
                this.f19902g = i2;
                this.f19903h = i3;
                this.f19897b = e.a(this.f19897b, i2, i3);
                this.f19899d = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b p(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                this.f19896a = i2;
                this.f19898c = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b q(int i2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                this.f19900e = z;
                this.f19901f = z2;
                return this;
            }
            return (b) invokeCommon.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            float f2 = this.f19891e;
            if (f2 > this.k || f2 < 0.0f) {
                return false;
            }
            canvas.drawBitmap(this.u, this.f19890d, f2, paint);
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
            this.f19890d = (float) (this.f19890d + (Math.sin(this.l) * 10.0d));
            if (this.s) {
                this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
            }
            float f2 = this.f19890d;
            int i2 = this.j;
            int i3 = this.o;
            if (f2 > i2 - i3) {
                this.f19890d = i2 - i3;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19891e += this.f19892f;
        }
    }

    public final void f() {
        float nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.n) {
                this.u = this.f19895i.f19897b;
            } else {
                c cVar = this.f19887a;
                if (cVar != null) {
                    nextInt = cVar.a();
                } else {
                    nextInt = (this.t.nextInt(10) + 1) * 0.1f;
                }
                int i2 = this.p;
                this.u = a(this.f19895i.f19897b, (int) (i2 > 0 ? Math.max(i2, this.f19895i.f19897b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f19895i.f19897b.getHeight(), this.q) : 0.0f));
            }
            this.u.getWidth();
            this.u.getHeight();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.m) {
                this.f19892f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f19888b;
            } else {
                this.f19892f = this.f19888b;
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.r) {
                this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f19889c) / 50.0d);
            } else {
                this.l = this.f19889c / 50.0f;
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
        this.f19895i = bVar;
        this.j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f19893g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f19894h = nextInt;
        this.f19890d = this.f19893g;
        this.f19891e = nextInt;
        this.m = bVar.f19898c;
        this.n = bVar.f19899d;
        this.f19887a = bVar.k;
        this.p = bVar.f19904i;
        this.q = bVar.j;
        this.o = bVar.f19902g;
        int unused = bVar.f19903h;
        this.r = bVar.f19900e;
        this.s = bVar.f19901f;
        this.f19888b = bVar.f19896a;
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
        this.f19895i = bVar;
        this.u = bVar.f19897b;
        this.o = bVar.f19902g;
        int unused = bVar.f19903h;
        this.p = bVar.f19904i;
        this.f19887a = bVar.k;
        this.q = bVar.j;
        this.f19888b = bVar.f19896a;
        this.n = bVar.f19899d;
        this.r = bVar.f19900e;
        this.s = bVar.f19901f;
        this.m = bVar.f19898c;
    }
}
