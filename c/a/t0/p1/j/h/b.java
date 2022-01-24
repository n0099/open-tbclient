package c.a.t0.p1.j.h;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.l0;
import c.a.s0.s.q.n;
import c.a.s0.s.q.r1;
import c.a.s0.s.q.v1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.DataRes;
import tbclient.ActivityPage.HotTopic;
import tbclient.ActivityPage.RecommendForumList;
import tbclient.ActivityPage.RecommendUserList;
import tbclient.ActivityPage.SpecialColumnList;
import tbclient.BannerImage;
import tbclient.Page;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f20955b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<e2> f20956c;

    /* renamed from: d  reason: collision with root package name */
    public n f20957d;

    /* renamed from: e  reason: collision with root package name */
    public l0 f20958e;

    /* renamed from: f  reason: collision with root package name */
    public r1 f20959f;

    /* renamed from: g  reason: collision with root package name */
    public v1 f20960g;

    /* renamed from: h  reason: collision with root package name */
    public c f20961h;

    /* renamed from: i  reason: collision with root package name */
    public SpecialColumnListData f20962i;

    public b() {
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
        this.a = true;
        this.f20955b = 1;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20957d : (n) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20955b : invokeV.intValue;
    }

    public l0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20958e : (l0) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20961h : (c) invokeV.objValue;
    }

    public r1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20959f : (r1) invokeV.objValue;
    }

    public v1 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20960g : (v1) invokeV.objValue;
    }

    public SpecialColumnListData g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20962i : (SpecialColumnListData) invokeV.objValue;
    }

    public ArrayList<e2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20956c : (ArrayList) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public void j(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) || dataRes == null) {
            return;
        }
        Page page = dataRes.page_info;
        if (page != null) {
            this.f20955b = page.current_page.intValue();
            this.a = page.has_more.intValue() == 1;
        }
        this.f20956c = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            e2 e2Var = new e2();
            e2Var.d3(threadInfo);
            e2Var.K1();
            this.f20956c.add(e2Var);
        }
        List<BannerImage> list = dataRes.banner_image;
        if (!ListUtils.isEmpty(list)) {
            n nVar = new n();
            this.f20957d = nVar;
            nVar.parserProtobuf(list);
        }
        List<BannerImage> list2 = dataRes.grid;
        if (ListUtils.getCount(list2) >= 4) {
            l0 l0Var = new l0();
            this.f20958e = l0Var;
            l0Var.parserProtobuf(list2);
        }
        RecommendForumList recommendForumList = dataRes.recommend_forum;
        if (recommendForumList != null && ListUtils.getCount(recommendForumList.forum_list) >= 5) {
            r1 r1Var = new r1();
            this.f20959f = r1Var;
            r1Var.o(recommendForumList.forum_list);
            r1 r1Var2 = this.f20959f;
            r1Var2.f13674j = recommendForumList.class_name;
            r1Var2.floorPosition = recommendForumList.floor_position.intValue();
            this.f20959f.f13672h = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
            this.f20959f.f13673i = R.color.CAM_X0108;
        }
        RecommendUserList recommendUserList = dataRes.recommend_user;
        if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
            v1 v1Var = new v1();
            this.f20960g = v1Var;
            v1Var.i(recommendUserList.user_list);
            this.f20960g.floorPosition = recommendUserList.floor_position.intValue();
            this.f20960g.f13698e = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
            this.f20960g.f13699f = R.color.CAM_X0108;
        }
        HotTopic hotTopic = dataRes.hot_topic;
        if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
            c cVar = new c();
            this.f20961h = cVar;
            cVar.k(hotTopic);
        }
        SpecialColumnList specialColumnList = dataRes.special_column;
        if (specialColumnList == null || ListUtils.getCount(specialColumnList.item_list) < 3) {
            return;
        }
        SpecialColumnListData specialColumnListData = new SpecialColumnListData();
        this.f20962i = specialColumnListData;
        specialColumnListData.parserProtobuf(specialColumnList);
    }
}
