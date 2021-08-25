package c.a.q0.a3.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b> f15454a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15455b;

    public d() {
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
        this.f15454a = new ArrayList();
        this.f15455b = true;
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            b bVar = new b();
            bVar.f15445a = forumList.avatar;
            bVar.f15446b = forumList.forum_name;
            bVar.f15447c = String.valueOf(forumList.forum_id);
            this.f15454a.add(bVar);
        }
        this.f15455b = dataRes.has_more.intValue() == 1;
    }
}
