package c.a.r0.g1.c.f;

import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.a0.d0.k;
import c.a.r0.g1.c.f.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class c extends c.a.q0.s.q.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17914e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f17915f;

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
        this.f17914e = false;
    }

    public static boolean p(DiscoverHotForum discoverHotForum, int i2) {
        InterceptResult invokeLI;
        Integer num;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, discoverHotForum, i2)) == null) ? TbadkCoreApplication.isLogin() && c.a.q0.b.d.g0() && discoverHotForum != null && (num = discoverHotForum.floor) != null && (i2 < 0 || i2 == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list) : invokeLI.booleanValue;
    }

    public List<n> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17915f : (List) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? k.B0 : (BdUniqueId) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f17914e : invokeV.booleanValue;
    }

    public boolean k(List<DiscoverTabCard> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            List<n> arrayList = new ArrayList<>();
            o(arrayList);
            for (int i2 = 0; i2 < list.size(); i2++) {
                DiscoverTabCard discoverTabCard = list.get(i2);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    d dVar = new d();
                    this.f17914e = StringUtils.isNull(discoverTabCard.name) || this.f17914e;
                    dVar.f17916e = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    dVar.f17917f = bool == null ? false : bool.booleanValue();
                    dVar.f17918g = discoverTabCard.jump_name;
                    for (int i3 = 0; i3 < discoverTabCard.forum_list.size() && i3 < 3; i3++) {
                        dVar.f17919h[i3] = new d.a();
                        d.a aVar = dVar.f17919h[i3];
                        aVar.s(discoverTabCard.forum_list.get(i3).forum_name);
                        aVar.q(discoverTabCard.forum_list.get(i3).avatar);
                        aVar.v(discoverTabCard.forum_list.get(i3).hot_text);
                        aVar.x(discoverTabCard.forum_list.get(i3).slogan);
                        aVar.p(discoverTabCard.forum_list.get(i3).member_count.intValue());
                        aVar.t(discoverTabCard.forum_list.get(i3).thread_count.intValue());
                        aVar.o(discoverTabCard.forum_list.get(i3).is_like.intValue() == 1);
                        aVar.u(discoverTabCard.forum_list.get(i3).forum_id);
                        aVar.w(discoverTabCard.forum_list.get(i3).hot_thread_id.longValue());
                    }
                    arrayList.add(dVar);
                    if (arrayList.size() >= 6) {
                        break;
                    }
                }
            }
            return arrayList.size() > 0;
        }
        return invokeL.booleanValue;
    }

    public void o(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f17915f = list;
        }
    }
}
