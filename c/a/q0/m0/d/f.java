package c.a.q0.m0.d;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.x;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.FrsTabInfo;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public class f extends x implements c.a.p0.i0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f21932h;

    /* renamed from: i  reason: collision with root package name */
    public String f21933i;

    /* renamed from: j  reason: collision with root package name */
    public int f21934j;
    public int k;
    public String l;
    public int m;
    public int n;
    public int o;
    public PrivateForumInfo p;
    public String q;
    public int r;
    public ThemeColorInfo s;
    public boolean t;
    public long u;
    public ArrayList<FrsTabItemData> v;

    public f() {
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
        i(1);
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public ThemeColorInfo B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : (ThemeColorInfo) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : invokeV.intValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        PrivateForumInfo privateForumInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n == 1 && this.o == 1 && (privateForumInfo = this.p) != null && privateForumInfo.private_forum_status.intValue() == 1 && this.p.private_forum_audit_status.intValue() == 2 : invokeV.booleanValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.intValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : invokeV.intValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : invokeV.intValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        PrivateForumInfo privateForumInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.n == 1 && this.o == 1 && (privateForumInfo = this.p) != null && privateForumInfo.private_forum_status.intValue() == 1 : invokeV.booleanValue;
    }

    public void I(LikeForum likeForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, likeForum) == null) || likeForum == null) {
            return;
        }
        J(likeForum, null);
    }

    public void J(LikeForum likeForum, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, likeForum, context) == null) || likeForum == null) {
            return;
        }
        try {
            this.f21932h = String.valueOf(likeForum.forum_id);
            this.f21933i = likeForum.forum_name;
            this.k = likeForum.is_sign.intValue();
            this.f21934j = likeForum.level_id.intValue();
            this.l = likeForum.avatar;
            this.n = likeForum.is_manager.intValue();
            this.o = likeForum.is_private_forum.intValue();
            this.p = likeForum.private_forum_info;
            this.m = likeForum.is_brand_forum.intValue();
            this.q = likeForum.content;
            this.r = likeForum.is_top.intValue();
            likeForum.sort_type.intValue();
            this.s = likeForum.theme_color;
            this.t = likeForum.need_trans.booleanValue();
            this.u = likeForum.hot_thread_id.longValue();
            this.v = new ArrayList<>();
            for (FrsTabInfo frsTabInfo : likeForum.tab_info) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.v.add(new FrsTabItemData(frsTabInfo));
                }
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void K(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.u = j2;
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.k = i2;
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f21934j = i2;
        }
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.u : invokeV.longValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f21932h : (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.r : invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f21934j : invokeV.intValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f21933i : (String) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public ArrayList<FrsTabItemData> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.v : (ArrayList) invokeV.objValue;
    }

    public ArrayList<Integer> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ThemeColorInfo themeColorInfo = this.s;
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                return null;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(c.a.q0.o1.o.k.b.b(this.s.day.light_color)));
            arrayList.add(Integer.valueOf(c.a.q0.o1.o.k.b.b(this.s.day.dark_color)));
            arrayList.add(Integer.valueOf(c.a.q0.o1.o.k.b.b(this.s.night.light_color)));
            arrayList.add(Integer.valueOf(c.a.q0.o1.o.k.b.b(this.s.night.dark_color)));
            arrayList.add(Integer.valueOf(c.a.q0.o1.o.k.b.b(this.s.dark.light_color)));
            arrayList.add(Integer.valueOf(c.a.q0.o1.o.k.b.b(this.s.dark.dark_color)));
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
