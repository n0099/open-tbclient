package c.a.r0.n0.d;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.r1;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ForumRecommend.DataRes;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f22488a;

    /* renamed from: b  reason: collision with root package name */
    public r1 f22489b;

    /* renamed from: c  reason: collision with root package name */
    public ForumCreateInfoData f22490c;

    /* renamed from: d  reason: collision with root package name */
    public PrivateForumPopInfoData f22491d;

    /* renamed from: e  reason: collision with root package name */
    public j f22492e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.n0.f.a.a f22493f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22494g;

    /* renamed from: h  reason: collision with root package name */
    public int f22495h;

    /* renamed from: i  reason: collision with root package name */
    public HotSearchInfoData f22496i;

    /* renamed from: j  reason: collision with root package name */
    public int f22497j;

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
        this.f22494g = true;
        this.f22495h = 0;
        this.f22488a = new g();
        this.f22489b = new r1();
        this.f22490c = new ForumCreateInfoData();
        this.f22491d = new PrivateForumPopInfoData();
        this.f22492e = new j();
        this.f22493f = new c.a.r0.n0.f.a.a();
        this.f22494g = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() / c.a.q0.u.d.f15019a.longValue() == (((long) this.f22495h) * 1000) / c.a.q0.u.d.f15019a.longValue() : invokeV.booleanValue;
    }

    public ForumCreateInfoData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22490c : (ForumCreateInfoData) invokeV.objValue;
    }

    public c.a.r0.n0.f.a.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22493f : (c.a.r0.n0.f.a.a) invokeV.objValue;
    }

    public HotSearchInfoData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22496i : (HotSearchInfoData) invokeV.objValue;
    }

    public g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22488a : (g) invokeV.objValue;
    }

    public PrivateForumPopInfoData f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22491d : (PrivateForumPopInfoData) invokeV.objValue;
    }

    public r1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22489b : (r1) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22497j : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22494g : invokeV.booleanValue;
    }

    public void j(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            if (dataRes.forum_popup_info != null) {
                this.f22493f.f(dataRes.forum_popup_info);
            }
            s(dataRes.time.intValue());
            this.f22497j = dataRes.sort_type.intValue() == 0 ? 1 : dataRes.sort_type.intValue();
            if (dataRes.like_forum != null) {
                this.f22488a.c(dataRes.like_forum);
            }
            if (dataRes.recommend_forum_info != null) {
                this.f22489b.o(dataRes.recommend_forum_info);
            }
            if (dataRes.forum_create_info != null) {
                this.f22490c.A(dataRes.forum_create_info);
            }
            if (dataRes.private_forum_popinfo != null) {
                this.f22491d.A(dataRes.private_forum_popinfo);
            }
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.f22496i = hotSearchInfoData;
                hotSearchInfoData.x(dataRes.hot_search);
            }
            if (dataRes.nav_tab_info != null) {
                this.f22492e.a(dataRes.nav_tab_info);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void k(ForumCreateInfoData forumCreateInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, forumCreateInfoData) == null) {
            this.f22490c = forumCreateInfoData;
        }
    }

    public void l(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hotSearchInfoData) == null) {
            this.f22496i = hotSearchInfoData;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f22494g = z;
        }
    }

    public void n(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f22488a = gVar;
        }
    }

    public void o(PrivateForumPopInfoData privateForumPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, privateForumPopInfoData) == null) {
            this.f22491d = privateForumPopInfoData;
        }
    }

    public void p(r1 r1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, r1Var) == null) {
            this.f22489b = r1Var;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f22497j = i2;
        }
    }

    public void r(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jVar) == null) {
            this.f22492e = jVar;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f22495h = i2;
        }
    }

    public void t(c.a.r0.n0.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            this.f22493f = aVar;
        }
    }
}
