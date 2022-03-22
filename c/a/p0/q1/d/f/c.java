package c.a.p0.q1.d.f;

import c.a.d.o.e.n;
import c.a.o0.r.r.v0;
import c.a.p0.h0.e0.k;
import c.a.p0.o3.e.a;
import c.a.p0.q1.d.f.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
public class c extends c.a.o0.r.r.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f17202b;

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
                return;
            }
        }
        this.a = false;
    }

    public static c e(c.a.p0.o3.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            if (aVar == null || ListUtils.isEmpty(aVar.f16877b)) {
                return null;
            }
            c cVar = new c();
            ArrayList arrayList = new ArrayList();
            cVar.m(arrayList);
            for (a.b bVar : aVar.f16877b) {
                if (!ListUtils.isEmpty(bVar.f16883b)) {
                    d dVar = new d();
                    cVar.a = StringUtils.isNull(bVar.a) || cVar.a;
                    dVar.a = bVar.a;
                    for (int i = 0; i < bVar.f16883b.size() && i < 3; i++) {
                        dVar.f17205d[i] = new d.a();
                        d.a aVar2 = dVar.f17205d[i];
                        aVar2.r(bVar.f16883b.get(i).f16878b);
                        aVar2.q(bVar.f16883b.get(i).f16881e);
                        aVar2.x(bVar.f16883b.get(i).f16882f);
                        aVar2.p(bVar.f16883b.get(i).f16879c);
                        aVar2.s(bVar.f16883b.get(i).f16880d);
                        aVar2.u(Long.valueOf(bVar.f16883b.get(i).a));
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

    public static boolean q(DiscoverHotForum discoverHotForum, int i) {
        InterceptResult invokeLI;
        Integer num;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, discoverHotForum, i)) == null) ? TbadkCoreApplication.isLogin() && UbsABTestHelper.needShowRecommendBarCard() && discoverHotForum != null && (num = discoverHotForum.floor) != null && (i < 0 || i == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list) : invokeLI.booleanValue;
    }

    public List<n> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17202b : (List) invokeV.objValue;
    }

    @Override // c.a.o0.r.r.a
    public v0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (v0) invokeV.objValue;
    }

    @Override // c.a.o0.r.r.a
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? k.x0 : (BdUniqueId) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean k(List<DiscoverTabCard> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            List<n> arrayList = new ArrayList<>();
            m(arrayList);
            for (int i = 0; i < list.size(); i++) {
                DiscoverTabCard discoverTabCard = list.get(i);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    d dVar = new d();
                    this.a = StringUtils.isNull(discoverTabCard.name) || this.a;
                    dVar.a = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    dVar.f17203b = bool == null ? false : bool.booleanValue();
                    dVar.f17204c = discoverTabCard.jump_name;
                    for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                        dVar.f17205d[i2] = new d.a();
                        d.a aVar = dVar.f17205d[i2];
                        aVar.r(discoverTabCard.forum_list.get(i2).forum_name);
                        aVar.q(discoverTabCard.forum_list.get(i2).avatar);
                        aVar.v(discoverTabCard.forum_list.get(i2).hot_text);
                        aVar.x(discoverTabCard.forum_list.get(i2).slogan);
                        aVar.p(discoverTabCard.forum_list.get(i2).member_count.intValue());
                        aVar.s(discoverTabCard.forum_list.get(i2).thread_count.intValue());
                        aVar.n(discoverTabCard.forum_list.get(i2).is_like.intValue() == 1);
                        aVar.u(discoverTabCard.forum_list.get(i2).forum_id);
                        aVar.w(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
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

    public void m(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f17202b = list;
        }
    }
}
