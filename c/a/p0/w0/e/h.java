package c.a.p0.w0.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.x;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ForumGuide.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes2.dex */
public class h extends x implements c.a.o0.k0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f19368d;

    /* renamed from: e  reason: collision with root package name */
    public String f19369e;

    /* renamed from: f  reason: collision with root package name */
    public int f19370f;

    /* renamed from: g  reason: collision with root package name */
    public int f19371g;

    /* renamed from: h  reason: collision with root package name */
    public int f19372h;
    public String i;
    public int j;
    public int k;
    public int l;
    public PrivateForumInfo m;
    public int n;
    public long o;
    public ThemeColorInfo p;
    public boolean q;
    public long r;
    public ArrayList<FrsTabItemData> s;

    public h() {
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
        g(1);
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19372h : invokeV.intValue;
    }

    public ThemeColorInfo B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : (ThemeColorInfo) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.intValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        PrivateForumInfo privateForumInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k == 1 && this.l == 1 && (privateForumInfo = this.m) != null && privateForumInfo.private_forum_status.intValue() == 1 && this.m.private_forum_audit_status.intValue() == 2 : invokeV.booleanValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.intValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : invokeV.intValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19371g : invokeV.intValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        PrivateForumInfo privateForumInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k == 1 && this.l == 1 && (privateForumInfo = this.m) != null && privateForumInfo.private_forum_status.intValue() == 1 : invokeV.booleanValue;
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
            this.f19368d = String.valueOf(likeForum.forum_id);
            this.f19369e = likeForum.forum_name;
            this.f19371g = likeForum.is_sign.intValue();
            this.f19370f = likeForum.level_id.intValue();
            this.i = likeForum.avatar;
            this.o = likeForum.sort_value.longValue();
            this.f19372h = likeForum.hot_num.intValue();
            this.p = likeForum.theme_color;
            this.q = likeForum.need_trans.booleanValue();
            this.s = new ArrayList<>();
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void K(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.r = j;
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f19371g = i;
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f19370f = i;
        }
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f19368d : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.r : invokeV.longValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.n : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f19370f : invokeV.intValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f19369e : (String) invokeV.objValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.o : invokeV.longValue;
    }

    public ArrayList<FrsTabItemData> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.s : (ArrayList) invokeV.objValue;
    }

    public ArrayList<Integer> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ThemeColorInfo themeColorInfo = this.p;
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                return null;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(c.a.p0.b2.o.k.b.b(this.p.day.light_color)));
            arrayList.add(Integer.valueOf(c.a.p0.b2.o.k.b.b(this.p.day.dark_color)));
            arrayList.add(Integer.valueOf(c.a.p0.b2.o.k.b.b(this.p.night.light_color)));
            arrayList.add(Integer.valueOf(c.a.p0.b2.o.k.b.b(this.p.night.dark_color)));
            arrayList.add(Integer.valueOf(c.a.p0.b2.o.k.b.b(this.p.dark.light_color)));
            arrayList.add(Integer.valueOf(c.a.p0.b2.o.k.b.b(this.p.dark.dark_color)));
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
