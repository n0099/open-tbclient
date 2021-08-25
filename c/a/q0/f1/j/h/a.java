package c.a.q0.f1.j.h;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.l0;
import c.a.p0.s.q.n;
import c.a.p0.s.q.q1;
import c.a.p0.s.q.u1;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f17911a;

    /* renamed from: b  reason: collision with root package name */
    public int f17912b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c2> f17913c;

    /* renamed from: d  reason: collision with root package name */
    public n f17914d;

    /* renamed from: e  reason: collision with root package name */
    public l0 f17915e;

    /* renamed from: f  reason: collision with root package name */
    public q1 f17916f;

    /* renamed from: g  reason: collision with root package name */
    public u1 f17917g;

    /* renamed from: h  reason: collision with root package name */
    public b f17918h;

    /* renamed from: i  reason: collision with root package name */
    public SpecialColumnListData f17919i;

    public a() {
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
        this.f17911a = true;
        this.f17912b = 1;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17914d : (n) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17912b : invokeV.intValue;
    }

    public l0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17915e : (l0) invokeV.objValue;
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17918h : (b) invokeV.objValue;
    }

    public q1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f17916f : (q1) invokeV.objValue;
    }

    public u1 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f17917g : (u1) invokeV.objValue;
    }

    public SpecialColumnListData g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f17919i : (SpecialColumnListData) invokeV.objValue;
    }

    public ArrayList<c2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f17913c : (ArrayList) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f17911a : invokeV.booleanValue;
    }

    public void j(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) || dataRes == null) {
            return;
        }
        Page page = dataRes.page_info;
        if (page != null) {
            this.f17912b = page.current_page.intValue();
            this.f17911a = page.has_more.intValue() == 1;
        }
        this.f17913c = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            c2 c2Var = new c2();
            c2Var.S2(threadInfo);
            c2Var.E1();
            this.f17913c.add(c2Var);
        }
        List<BannerImage> list = dataRes.banner_image;
        if (!ListUtils.isEmpty(list)) {
            n nVar = new n();
            this.f17914d = nVar;
            nVar.parserProtobuf(list);
        }
        List<BannerImage> list2 = dataRes.grid;
        if (ListUtils.getCount(list2) >= 4) {
            l0 l0Var = new l0();
            this.f17915e = l0Var;
            l0Var.parserProtobuf(list2);
        }
        RecommendForumList recommendForumList = dataRes.recommend_forum;
        if (recommendForumList != null && ListUtils.getCount(recommendForumList.forum_list) >= 5) {
            q1 q1Var = new q1();
            this.f17916f = q1Var;
            q1Var.o(recommendForumList.forum_list);
            q1 q1Var2 = this.f17916f;
            q1Var2.f14327j = recommendForumList.class_name;
            q1Var2.floorPosition = recommendForumList.floor_position.intValue();
            this.f17916f.f14325h = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
            this.f17916f.f14326i = R.color.CAM_X0108;
        }
        RecommendUserList recommendUserList = dataRes.recommend_user;
        if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
            u1 u1Var = new u1();
            this.f17917g = u1Var;
            u1Var.i(recommendUserList.user_list);
            this.f17917g.floorPosition = recommendUserList.floor_position.intValue();
            this.f17917g.f14359e = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
            this.f17917g.f14360f = R.color.CAM_X0108;
        }
        HotTopic hotTopic = dataRes.hot_topic;
        if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
            b bVar = new b();
            this.f17918h = bVar;
            bVar.k(hotTopic);
        }
        SpecialColumnList specialColumnList = dataRes.special_column;
        if (specialColumnList == null || ListUtils.getCount(specialColumnList.item_list) < 3) {
            return;
        }
        SpecialColumnListData specialColumnListData = new SpecialColumnListData();
        this.f17919i = specialColumnListData;
        specialColumnListData.parserProtobuf(specialColumnList);
    }
}
