package c.a.x.b.f;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f30980g;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f30981h;

    /* renamed from: i  reason: collision with root package name */
    public static final FloatBuffer f30982i;

    /* renamed from: j  reason: collision with root package name */
    public static final FloatBuffer f30983j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-120835380, "Lc/a/x/b/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-120835380, "Lc/a/x/b/f/b;");
                return;
            }
        }
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f30980g = fArr;
        f30981h = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f30982i = c.a.x.b.h.a.b(fArr);
        f30983j = c.a.x.b.h.a.b(f30981h);
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
        this.f30974a = f30982i;
        this.f30975b = f30983j;
        this.f30977d = 2;
        this.f30978e = 2 * 4;
        this.f30976c = f30980g.length / 2;
        this.f30979f = 8;
    }
}
