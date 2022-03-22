package c.a.p0.q1.i.j;

import c.a.p0.h0.e0.p;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void e(Resource resource) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, resource) == null) || resource == null) {
            return;
        }
        this.a = resource.res_id.longValue();
        this.f15345b = resource.user_name;
        this.f15346c = resource.user_image;
        this.f15347d = resource.user_link;
        this.f15348e = resource.res_title;
        this.f15349f = resource.res_image;
        this.f15350g = resource.res_link;
        this.f15351h = resource.position.longValue();
        this.i = resource.icon_text;
    }
}
