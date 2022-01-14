package c.b.b.n.l.e;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.t;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class d extends c.b.b.n.l.a {
    public static /* synthetic */ Interceptable $ic;
    public static final long n;
    public static final long o;
    public static final long p;
    public static final long q;
    public static final long r;
    public static final long s;
    public static final long t;
    public static long u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.b.b.n.l.i.a<Texture> f27202h;

    /* renamed from: i  reason: collision with root package name */
    public float f27203i;

    /* renamed from: j  reason: collision with root package name */
    public float f27204j;
    public float k;
    public float l;
    public int m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-390527209, "Lc/b/b/n/l/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-390527209, "Lc/b/b/n/l/e/d;");
                return;
            }
        }
        n = c.b.b.n.l.a.d("diffuseTexture");
        o = c.b.b.n.l.a.d("specularTexture");
        p = c.b.b.n.l.a.d("bumpTexture");
        q = c.b.b.n.l.a.d("normalTexture");
        r = c.b.b.n.l.a.d("ambientTexture");
        s = c.b.b.n.l.a.d("emissiveTexture");
        long d2 = c.b.b.n.l.a.d("reflectionTexture");
        t = d2;
        u = d2 | n | o | p | q | r | s;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(long j2) {
        super(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27203i = 0.0f;
        this.f27204j = 0.0f;
        this.k = 1.0f;
        this.l = 1.0f;
        this.m = 0;
        if (f(j2)) {
            this.f27202h = new c.b.b.n.l.i.a<>();
            return;
        }
        throw new GdxRuntimeException("Invalid type specified");
    }

    public static final boolean f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j2)) == null) ? (j2 & u) != 0 : invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(c.b.b.n.l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            long j2 = this.f27181e;
            long j3 = aVar.f27181e;
            if (j2 != j3) {
                return j2 < j3 ? -1 : 1;
            }
            d dVar = (d) aVar;
            int compareTo = this.f27202h.compareTo(dVar.f27202h);
            if (compareTo != 0) {
                return compareTo;
            }
            int i2 = this.m;
            int i3 = dVar.m;
            if (i2 != i3) {
                return i2 - i3;
            }
            if (!com.badlogic.gdx.math.d.e(this.k, dVar.k)) {
                return this.k > dVar.k ? 1 : -1;
            } else if (!com.badlogic.gdx.math.d.e(this.l, dVar.l)) {
                return this.l > dVar.l ? 1 : -1;
            } else if (!com.badlogic.gdx.math.d.e(this.f27203i, dVar.f27203i)) {
                return this.f27203i > dVar.f27203i ? 1 : -1;
            } else if (com.badlogic.gdx.math.d.e(this.f27204j, dVar.f27204j)) {
                return 0;
            } else {
                return this.f27204j > dVar.f27204j ? 1 : -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // c.b.b.n.l.a
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (((((((((((super.hashCode() * 991) + this.f27202h.hashCode()) * 991) + t.b(this.f27203i)) * 991) + t.b(this.f27204j)) * 991) + t.b(this.k)) * 991) + t.b(this.l)) * 991) + this.m : invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <T extends Texture> d(long j2, c.b.b.n.l.i.a<T> aVar) {
        this(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27202h.c(aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <T extends Texture> d(long j2, c.b.b.n.l.i.a<T> aVar, float f2, float f3, float f4, float f5, int i2) {
        this(j2, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), aVar, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (c.b.b.n.l.i.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f27203i = f2;
        this.f27204j = f3;
        this.k = f4;
        this.l = f5;
        this.m = i2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <T extends Texture> d(long j2, c.b.b.n.l.i.a<T> aVar, float f2, float f3, float f4, float f5) {
        this(j2, aVar, f2, f3, f4, f5, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), aVar, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (c.b.b.n.l.i.a) objArr2[1], ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue(), ((Float) objArr2[4]).floatValue(), ((Float) objArr2[5]).floatValue(), ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }
}
