package c.b.b.n.l.g;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final BoundingBox f27247h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f27248b;

    /* renamed from: c  reason: collision with root package name */
    public int f27249c;

    /* renamed from: d  reason: collision with root package name */
    public int f27250d;

    /* renamed from: e  reason: collision with root package name */
    public Mesh f27251e;

    /* renamed from: f  reason: collision with root package name */
    public final Vector3 f27252f;

    /* renamed from: g  reason: collision with root package name */
    public final Vector3 f27253g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-390467689, "Lc/b/b/n/l/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-390467689, "Lc/b/b/n/l/g/b;");
                return;
            }
        }
        f27247h = new BoundingBox();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27252f = new Vector3();
        this.f27253g = new Vector3();
    }

    public boolean a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) ? bVar == this || (bVar != null && bVar.f27251e == this.f27251e && bVar.f27248b == this.f27248b && bVar.f27249c == this.f27249c && bVar.f27250d == this.f27250d) : invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj instanceof b) {
                return a((b) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27251e.f(f27247h, this.f27249c, this.f27250d);
            f27247h.getCenter(this.f27252f);
            f27247h.getDimensions(this.f27253g).m23scl(0.5f);
            this.f27253g.len();
        }
    }
}
