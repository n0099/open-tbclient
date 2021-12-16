package c.a.c0.s.h0;

import c.a.c0.s.c0.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class b implements c.a.c0.s.f0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.c0.s.j0.f a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2126087640, "Lc/a/c0/s/h0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2126087640, "Lc/a/c0/s/h0/b;");
                return;
            }
        }
        c.a.c0.s.d.f();
    }

    public b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j(map);
    }

    @Override // c.a.c0.s.f0.b
    public final void c(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null || this.a == null) {
            return;
        }
        int type = pVar.getType();
        if (type == 1) {
            i(pVar);
        } else if (type == 2) {
            f(pVar);
        } else if (type == 3) {
            g(pVar);
        } else if (type != 4) {
        } else {
            h(pVar);
        }
    }

    @Override // c.a.c0.s.f0.a
    public final <T extends c.a.c0.s.j0.b> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (c.a.c0.s.j0.f) t;
        }
    }

    public abstract void f(p pVar);

    public abstract void g(p pVar);

    public abstract void h(p pVar);

    public abstract void i(p pVar);

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, map) == null) || map == null || map.size() <= 0) {
            return;
        }
        if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
            String str = (String) c.a.c0.u.c.b(map, WriteActivityConfig.VIDEO_INFO);
        }
        if (map.containsKey("channel_id")) {
            String str2 = (String) c.a.c0.u.c.b(map, "channel_id");
        }
        if (map.containsKey("channel_title")) {
            String str3 = (String) c.a.c0.u.c.b(map, "channel_title");
        }
        if (map.containsKey("type")) {
            String str4 = (String) c.a.c0.u.c.b(map, "type");
        }
        if (map.containsKey("source")) {
            String str5 = (String) c.a.c0.u.c.b(map, "source");
        }
        if (map.containsKey("from")) {
            String str6 = (String) c.a.c0.u.c.b(map, "from");
        }
        if (map.containsKey("pd")) {
            String str7 = (String) c.a.c0.u.c.b(map, "pd");
        }
        if (map.containsKey("tpl")) {
            String str8 = (String) c.a.c0.u.c.b(map, "tpl");
        }
        if (map.containsKey("ext_request")) {
            String str9 = (String) c.a.c0.u.c.b(map, "ext_request");
        }
    }
}
