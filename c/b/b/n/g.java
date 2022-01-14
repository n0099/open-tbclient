package c.b.b.n;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class g extends e {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, c.b.b.q.a<g>> n;
    public transient /* synthetic */ FieldHolder $fh;
    public h m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(156777287, "Lc/b/b/n/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(156777287, "Lc/b/b/n/g;");
                return;
            }
        }
        n = new HashMap();
    }

    public static void s(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            n.remove(application);
        }
    }

    public static void t(Application application) {
        c.b.b.q.a<g> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, application) == null) || (aVar = n.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < aVar.f27361f; i2++) {
            aVar.get(i2).w();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m.b() : invokeV.booleanValue;
    }

    public final void v(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            if (this.m != null && hVar.b() != this.m.b()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.m = hVar;
            a();
            c.b.b.f.f26941g.O(35866, 0, hVar.c(), hVar.getWidth(), hVar.getHeight(), hVar.getDepth(), 0, hVar.c(), hVar.e(), null);
            if (!hVar.a()) {
                hVar.prepare();
            }
            hVar.d();
            l(this.f27087g, this.f27088h);
            m(this.f27089i, this.f27090j);
            c.b.b.f.f26939e.N(this.f27085e, 0);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (u()) {
                this.f27086f = c.b.b.f.f26939e.a();
                v(this.m);
                return;
            }
            throw new GdxRuntimeException("Tried to reload an unmanaged TextureArray");
        }
    }
}
