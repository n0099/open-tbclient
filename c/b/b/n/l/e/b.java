package c.b.b.n.l.e;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b extends c.b.b.n.l.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final long f27597i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f27598j;

    /* renamed from: k  reason: collision with root package name */
    public static final long f27599k;
    public static final long l;
    public static final long m;
    public static final long n;
    public static final long o;
    public static long p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.b.b.n.a f27600h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-390527271, "Lc/b/b/n/l/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-390527271, "Lc/b/b/n/l/e/b;");
                return;
            }
        }
        f27597i = c.b.b.n.l.a.d("diffuseColor");
        f27598j = c.b.b.n.l.a.d("specularColor");
        f27599k = c.b.b.n.l.a.d("ambientColor");
        l = c.b.b.n.l.a.d("emissiveColor");
        m = c.b.b.n.l.a.d("reflectionColor");
        n = c.b.b.n.l.a.d("ambientLightColor");
        long d2 = c.b.b.n.l.a.d("fogColor");
        o = d2;
        p = d2 | f27599k | f27597i | f27598j | l | m | n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(long j2) {
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
        this.f27600h = new c.b.b.n.a();
        if (!f(j2)) {
            throw new GdxRuntimeException("Invalid type specified");
        }
    }

    public static final boolean f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) ? (j2 & p) != 0 : invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(c.b.b.n.l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            long j2 = this.f27579e;
            long j3 = aVar.f27579e;
            return j2 != j3 ? (int) (j2 - j3) : ((b) aVar).f27600h.g() - this.f27600h.g();
        }
        return invokeL.intValue;
    }

    @Override // c.b.b.n.l.a
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (super.hashCode() * CyberPlayerManager.DP_MSG_INFO_CACHE_DURATION) + this.f27600h.g() : invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(long j2, c.b.b.n.a aVar) {
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
        if (aVar != null) {
            this.f27600h.e(aVar);
        }
    }
}
