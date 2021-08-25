package c.a.q0.i3.i0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f20272a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f20273b;

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
                return;
            }
        }
        this.f20272a = new ArrayList<>();
        this.f20273b = new ArrayList<>();
    }

    public void a(ActPost actPost) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, actPost) == null) || actPost == null) {
            return;
        }
        String str = actPost.list_head;
        for (ActHot actHot : actPost.act_hot) {
            if (actHot != null) {
                a aVar = new a();
                aVar.g(actHot);
                this.f20272a.add(aVar);
            }
        }
        List<LinkInfo> list = actPost.link_info;
        for (LinkInfo linkInfo : list) {
            if (list != null) {
                b bVar = new b();
                bVar.a(linkInfo);
                this.f20273b.add(bVar);
            }
        }
    }
}
