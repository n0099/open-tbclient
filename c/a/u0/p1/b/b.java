package c.a.u0.p1.b;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.l0;
import c.a.t0.s.r.n;
import c.a.t0.s.r.r1;
import c.a.t0.s.r.v1;
import c.a.u0.p1.k.h.c;
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
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.ActivityPageResIdl;
import tbclient.ActivityPage.DataRes;
import tbclient.ActivityPage.HotTopic;
import tbclient.ActivityPage.RecommendForumList;
import tbclient.ActivityPage.RecommendUserList;
import tbclient.ActivityPage.SpecialColumnList;
import tbclient.BannerImage;
import tbclient.Error;
/* loaded from: classes8.dex */
public class b extends c.a.t0.b1.e.a<ActivityPageResIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.b1.d.b f20308c;

    /* renamed from: d  reason: collision with root package name */
    public List<e2> f20309d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.t0.s.r.a> f20310e;

    /* renamed from: f  reason: collision with root package name */
    public n f20311f;

    /* renamed from: g  reason: collision with root package name */
    public l0 f20312g;

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
        this.f20308c = new c.a.t0.b1.d.b();
    }

    @Override // c.a.t0.b1.e.d
    public final void a(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bArr) == null) {
            ActivityPageResIdl activityPageResIdl = (ActivityPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ActivityPageResIdl.class);
            Error error = activityPageResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                b(num.intValue());
                c(activityPageResIdl.error.errmsg);
            }
            Error error2 = activityPageResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                b(activityPageResIdl.error.errorno.intValue());
                c(activityPageResIdl.error.errmsg);
            }
            if (getErrorCode() == 0 && (dataRes = activityPageResIdl.data) != null) {
                j(dataRes);
            }
        }
    }

    @Override // c.a.t0.b1.e.a
    public List<c.a.t0.s.r.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20310e : (List) invokeV.objValue;
    }

    @Override // c.a.t0.b1.e.a
    public List<e2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20309d : (List) invokeV.objValue;
    }

    @Override // c.a.t0.b1.e.a, c.a.t0.b1.e.d
    public c.a.t0.b1.d.b getPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20308c : (c.a.t0.b1.d.b) invokeV.objValue;
    }

    @Override // c.a.t0.b1.e.a
    public List<c.a.d.o.e.n> i(List<? extends c.a.d.o.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) ? c.a.t0.b1.h.b.a(list) : (List) invokeL.objValue;
    }

    public final void j(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) {
            m(dataRes);
            n(dataRes);
            l(dataRes);
            k(dataRes);
        }
    }

    public final void k(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dataRes) == null) {
            ArrayList arrayList = new ArrayList();
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && ListUtils.getCount(recommendForumList.forum_list) >= 5) {
                r1 r1Var = new r1();
                r1Var.o(recommendForumList.forum_list);
                r1Var.f13954j = recommendForumList.class_name;
                r1Var.floorPosition = recommendForumList.floor_position.intValue();
                r1Var.f13952h = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
                r1Var.f13953i = R.color.CAM_X0108;
                arrayList.add(r1Var);
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
                v1 v1Var = new v1();
                v1Var.i(recommendUserList.user_list);
                v1Var.floorPosition = recommendUserList.floor_position.intValue();
                v1Var.f13976e = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
                v1Var.f13977f = R.color.CAM_X0108;
                arrayList.add(v1Var);
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
                c cVar = new c();
                cVar.k(hotTopic);
                arrayList.add(cVar);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && ListUtils.getCount(specialColumnList.item_list) >= 3) {
                SpecialColumnListData specialColumnListData = new SpecialColumnListData();
                specialColumnListData.parserProtobuf(specialColumnList);
                arrayList.add(specialColumnListData);
            }
            this.f20310e = arrayList;
        }
    }

    public final void l(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            List<BannerImage> list = dataRes.banner_image;
            if (!ListUtils.isEmpty(list)) {
                n nVar = new n();
                this.f20311f = nVar;
                nVar.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (ListUtils.getCount(list2) >= 4) {
                l0 l0Var = new l0();
                this.f20312g = l0Var;
                l0Var.parserProtobuf(list2);
            }
        }
    }

    public final void m(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dataRes) == null) {
            this.f20308c.a(dataRes.page_info);
        }
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) {
            this.f20309d = c.a.t0.b1.h.b.c(dataRes.thread_list);
        }
    }
}
