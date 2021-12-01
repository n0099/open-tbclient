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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final BoundingBox f27621h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f27622b;

    /* renamed from: c  reason: collision with root package name */
    public int f27623c;

    /* renamed from: d  reason: collision with root package name */
    public int f27624d;

    /* renamed from: e  reason: collision with root package name */
    public Mesh f27625e;

    /* renamed from: f  reason: collision with root package name */
    public final Vector3 f27626f;

    /* renamed from: g  reason: collision with root package name */
    public final Vector3 f27627g;

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
        f27621h = new BoundingBox();
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
        this.f27626f = new Vector3();
        this.f27627g = new Vector3();
    }

    public boolean a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) ? bVar == this || (bVar != null && bVar.f27625e == this.f27625e && bVar.f27622b == this.f27622b && bVar.f27623c == this.f27623c && bVar.f27624d == this.f27624d) : invokeL.booleanValue;
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
            this.f27625e.f(f27621h, this.f27623c, this.f27624d);
            f27621h.getCenter(this.f27626f);
            f27621h.getDimensions(this.f27627g).m23scl(0.5f);
            this.f27627g.len();
        }
    }
}
