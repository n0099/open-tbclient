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
/* loaded from: classes3.dex */
public class g extends e {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, c.b.b.q.a<g>> j;
    public transient /* synthetic */ FieldHolder $fh;
    public h i;

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
        j = new HashMap();
    }

    public static void s(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            j.remove(application);
        }
    }

    public static void t(Application application) {
        c.b.b.q.a<g> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, application) == null) || (aVar = j.get(application)) == null) {
            return;
        }
        for (int i = 0; i < aVar.f22717b; i++) {
            aVar.get(i).w();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i.b() : invokeV.booleanValue;
    }

    public final void v(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            if (this.i != null && hVar.b() != this.i.b()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.i = hVar;
            a();
            c.b.b.f.f22336g.O(35866, 0, hVar.c(), hVar.getWidth(), hVar.getHeight(), hVar.getDepth(), 0, hVar.c(), hVar.e(), null);
            if (!hVar.a()) {
                hVar.prepare();
            }
            hVar.d();
            l(this.f22474c, this.f22475d);
            m(this.f22476e, this.f22477f);
            c.b.b.f.f22334e.N(this.a, 0);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (u()) {
                this.f22473b = c.b.b.f.f22334e.a();
                v(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload an unmanaged TextureArray");
        }
    }
}
