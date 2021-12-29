package c.a.t0.o1.h.j;

import c.a.t0.g0.f0.p;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.Resource;
/* loaded from: classes7.dex */
public class c extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void g(Resource resource) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, resource) == null) || resource == null) {
            return;
        }
        this.f18255e = resource.res_id.longValue();
        this.f18256f = resource.user_name;
        this.f18257g = resource.user_image;
        this.f18258h = resource.user_link;
        this.f18259i = resource.res_title;
        this.f18260j = resource.res_image;
        this.f18261k = resource.res_link;
        this.l = resource.position.longValue();
        this.m = resource.icon_text;
    }
}
