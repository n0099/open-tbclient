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
/* loaded from: classes3.dex */
public class b extends c.b.b.n.l.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final long f22565e;

    /* renamed from: f  reason: collision with root package name */
    public static final long f22566f;

    /* renamed from: g  reason: collision with root package name */
    public static final long f22567g;

    /* renamed from: h  reason: collision with root package name */
    public static final long f22568h;
    public static final long i;
    public static final long j;
    public static final long k;
    public static long l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.n.a f22569d;

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
        f22565e = c.b.b.n.l.a.d("diffuseColor");
        f22566f = c.b.b.n.l.a.d("specularColor");
        f22567g = c.b.b.n.l.a.d("ambientColor");
        f22568h = c.b.b.n.l.a.d("emissiveColor");
        i = c.b.b.n.l.a.d("reflectionColor");
        j = c.b.b.n.l.a.d("ambientLightColor");
        long d2 = c.b.b.n.l.a.d("fogColor");
        k = d2;
        l = d2 | f22567g | f22565e | f22566f | f22568h | i | j;
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
        this.f22569d = new c.b.b.n.a();
        if (!f(j2)) {
            throw new GdxRuntimeException("Invalid type specified");
        }
    }

    public static final boolean f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) ? (j2 & l) != 0 : invokeJ.booleanValue;
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
            return j2 != j3 ? (int) (j2 - j3) : ((b) aVar).f22569d.g() - this.f22569d.g();
        }
        return invokeL.intValue;
    }

    @Override // c.b.b.n.l.a
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (super.hashCode() * CyberPlayerManager.DP_MSG_INFO_CACHE_DURATION) + this.f22569d.g() : invokeV.intValue;
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
            this.f22569d.e(aVar);
        }
    }
}
