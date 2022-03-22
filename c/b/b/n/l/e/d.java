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
/* loaded from: classes3.dex */
public class d extends c.b.b.n.l.a {
    public static /* synthetic */ Interceptable $ic;
    public static final long j;
    public static final long k;
    public static final long l;
    public static final long m;
    public static final long n;
    public static final long o;
    public static final long p;
    public static long q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.n.l.i.a<Texture> f22572d;

    /* renamed from: e  reason: collision with root package name */
    public float f22573e;

    /* renamed from: f  reason: collision with root package name */
    public float f22574f;

    /* renamed from: g  reason: collision with root package name */
    public float f22575g;

    /* renamed from: h  reason: collision with root package name */
    public float f22576h;
    public int i;

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
        j = c.b.b.n.l.a.d("diffuseTexture");
        k = c.b.b.n.l.a.d("specularTexture");
        l = c.b.b.n.l.a.d("bumpTexture");
        m = c.b.b.n.l.a.d("normalTexture");
        n = c.b.b.n.l.a.d("ambientTexture");
        o = c.b.b.n.l.a.d("emissiveTexture");
        long d2 = c.b.b.n.l.a.d("reflectionTexture");
        p = d2;
        q = d2 | j | k | l | m | n | o;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22573e = 0.0f;
        this.f22574f = 0.0f;
        this.f22575g = 1.0f;
        this.f22576h = 1.0f;
        this.i = 0;
        if (f(j2)) {
            this.f22572d = new c.b.b.n.l.i.a<>();
            return;
        }
        throw new GdxRuntimeException("Invalid type specified");
    }

    public static final boolean f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j2)) == null) ? (j2 & q) != 0 : invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(c.b.b.n.l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            long j2 = this.a;
            long j3 = aVar.a;
            if (j2 != j3) {
                return j2 < j3 ? -1 : 1;
            }
            d dVar = (d) aVar;
            int compareTo = this.f22572d.compareTo(dVar.f22572d);
            if (compareTo != 0) {
                return compareTo;
            }
            int i = this.i;
            int i2 = dVar.i;
            if (i != i2) {
                return i - i2;
            }
            if (!com.badlogic.gdx.math.d.e(this.f22575g, dVar.f22575g)) {
                return this.f22575g > dVar.f22575g ? 1 : -1;
            } else if (!com.badlogic.gdx.math.d.e(this.f22576h, dVar.f22576h)) {
                return this.f22576h > dVar.f22576h ? 1 : -1;
            } else if (!com.badlogic.gdx.math.d.e(this.f22573e, dVar.f22573e)) {
                return this.f22573e > dVar.f22573e ? 1 : -1;
            } else if (com.badlogic.gdx.math.d.e(this.f22574f, dVar.f22574f)) {
                return 0;
            } else {
                return this.f22574f > dVar.f22574f ? 1 : -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // c.b.b.n.l.a
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (((((((((((super.hashCode() * 991) + this.f22572d.hashCode()) * 991) + t.b(this.f22573e)) * 991) + t.b(this.f22574f)) * 991) + t.b(this.f22575g)) * 991) + t.b(this.f22576h)) * 991) + this.i : invokeV.intValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f22572d.c(aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <T extends Texture> d(long j2, c.b.b.n.l.i.a<T> aVar, float f2, float f3, float f4, float f5, int i) {
        this(j2, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), aVar, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (c.b.b.n.l.i.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f22573e = f2;
        this.f22574f = f3;
        this.f22575g = f4;
        this.f22576h = f5;
        this.i = i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (c.b.b.n.l.i.a) objArr2[1], ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue(), ((Float) objArr2[4]).floatValue(), ((Float) objArr2[5]).floatValue(), ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }
}
