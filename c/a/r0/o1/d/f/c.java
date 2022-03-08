package c.a.r0.o1.d.f;

import c.a.d.o.e.n;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.x0;
import c.a.r0.f0.d0.k;
import c.a.r0.m3.e.a;
import c.a.r0.o1.d.f.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
/* loaded from: classes2.dex */
public class c extends c.a.q0.r.r.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19764e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f19765f;

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
        this.f19764e = false;
    }

    public static c g(c.a.r0.m3.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            if (aVar == null || ListUtils.isEmpty(aVar.f19343b)) {
                return null;
            }
            c cVar = new c();
            ArrayList arrayList = new ArrayList();
            cVar.p(arrayList);
            for (a.b bVar : aVar.f19343b) {
                if (!ListUtils.isEmpty(bVar.f19349b)) {
                    d dVar = new d();
                    cVar.f19764e = StringUtils.isNull(bVar.a) || cVar.f19764e;
                    dVar.f19766e = bVar.a;
                    for (int i2 = 0; i2 < bVar.f19349b.size() && i2 < 3; i2++) {
                        dVar.f19769h[i2] = new d.a();
                        d.a aVar2 = dVar.f19769h[i2];
                        aVar2.s(bVar.f19349b.get(i2).f19344b);
                        aVar2.q(bVar.f19349b.get(i2).f19347e);
                        aVar2.x(bVar.f19349b.get(i2).f19348f);
                        aVar2.p(bVar.f19349b.get(i2).f19345c);
                        aVar2.t(bVar.f19349b.get(i2).f19346d);
                        aVar2.u(Long.valueOf(bVar.f19349b.get(i2).a));
                    }
                    arrayList.add(dVar);
                    if (arrayList.size() >= 6) {
                        break;
                    }
                }
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static boolean q(DiscoverHotForum discoverHotForum, int i2) {
        InterceptResult invokeLI;
        Integer num;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, discoverHotForum, i2)) == null) ? TbadkCoreApplication.isLogin() && UbsABTestHelper.needShowRecommendBarCard() && discoverHotForum != null && (num = discoverHotForum.floor) != null && (i2 < 0 || i2 == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list) : invokeLI.booleanValue;
    }

    @Override // c.a.q0.r.r.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.q0.r.r.a
    public e2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (e2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k.B0 : (BdUniqueId) invokeV.objValue;
    }

    public List<n> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19765f : (List) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19764e : invokeV.booleanValue;
    }

    public boolean o(List<DiscoverTabCard> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            List<n> arrayList = new ArrayList<>();
            p(arrayList);
            for (int i2 = 0; i2 < list.size(); i2++) {
                DiscoverTabCard discoverTabCard = list.get(i2);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    d dVar = new d();
                    this.f19764e = StringUtils.isNull(discoverTabCard.name) || this.f19764e;
                    dVar.f19766e = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    dVar.f19767f = bool == null ? false : bool.booleanValue();
                    dVar.f19768g = discoverTabCard.jump_name;
                    for (int i3 = 0; i3 < discoverTabCard.forum_list.size() && i3 < 3; i3++) {
                        dVar.f19769h[i3] = new d.a();
                        d.a aVar = dVar.f19769h[i3];
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

    public void p(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f19765f = list;
        }
    }
}
