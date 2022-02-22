package c.a.u0.p1.i.j;

import c.a.u0.g0.d0.p;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.Resource;
/* loaded from: classes8.dex */
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
        this.f17917e = resource.res_id.longValue();
        this.f17918f = resource.user_name;
        this.f17919g = resource.user_image;
        this.f17920h = resource.user_link;
        this.f17921i = resource.res_title;
        this.f17922j = resource.res_image;
        this.k = resource.res_link;
        this.l = resource.position.longValue();
        this.m = resource.icon_text;
    }
}
