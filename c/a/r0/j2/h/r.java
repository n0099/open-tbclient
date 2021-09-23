package c.a.r0.j2.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes3.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumData f19678a;

    /* renamed from: b  reason: collision with root package name */
    public PostData f19679b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<PostData> f19680c;

    /* renamed from: d  reason: collision with root package name */
    public int f19681d;

    /* renamed from: e  reason: collision with root package name */
    public int f19682e;

    /* renamed from: f  reason: collision with root package name */
    public int f19683f;

    /* renamed from: g  reason: collision with root package name */
    public int f19684g;

    /* renamed from: h  reason: collision with root package name */
    public int f19685h;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f19686i;

    /* renamed from: j  reason: collision with root package name */
    public d2 f19687j;
    public boolean k;
    public boolean l;
    public Error m;

    public r() {
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
        this.f19683f = 20;
        this.f19685h = -1;
        this.k = false;
        this.f19679b = null;
        this.f19680c = new ArrayList<>();
        this.f19681d = 1;
    }

    public static r w(DataRes dataRes, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dataRes, context)) == null) {
            if (dataRes == null) {
                return null;
            }
            try {
                r rVar = new r();
                AntiData antiData = new AntiData();
                antiData.parserProtobuf(dataRes.anti);
                rVar.x(antiData);
                d2 d2Var = new d2();
                d2Var.Y2(dataRes.thread);
                rVar.E(d2Var);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                rVar.A(forumData);
                PostData postData = new PostData();
                postData.l0(forumData.isBrandForum);
                postData.f0(dataRes.post, context, d2Var);
                rVar.C(postData);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<PostData> arrayList = new ArrayList<>();
                int A = postData.A();
                int i2 = 0;
                while (i2 < size) {
                    SubPostList subPostList = list.get(i2);
                    PostData postData2 = new PostData();
                    postData2.l0(forumData.isBrandForum);
                    int i3 = i2;
                    postData2.d0(subPostList, context, false, d2Var, A);
                    if (postData2.q() != null && postData2.q().baijiahaoData == null && d2Var.L() != null) {
                        postData2.q().baijiahaoData = d2Var.L();
                    }
                    arrayList.add(postData2);
                    i2 = i3 + 1;
                }
                rVar.D(arrayList);
                AntiData antiData2 = new AntiData();
                antiData2.parserProtobuf(dataRes.anti);
                rVar.x(antiData2);
                Page page = dataRes.page;
                if (page != null) {
                    int intValue = page.total_page.intValue();
                    int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                    int intValue3 = page.current_page.intValue();
                    int intValue4 = page.total_count.intValue();
                    rVar.z(intValue3);
                    rVar.B(intValue2);
                    rVar.F(intValue4);
                    rVar.G(intValue);
                }
                boolean z = true;
                if (dataRes.is_black_white.intValue() != 1) {
                    z = false;
                }
                rVar.y(z);
                return rVar;
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (r) invokeLL.objValue;
    }

    public void A(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumData) == null) {
            this.f19678a = forumData;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f19683f = i2;
    }

    public void C(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) {
            this.f19679b = postData;
        }
    }

    public void D(ArrayList<PostData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f19680c = arrayList;
        }
    }

    public void E(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) {
            this.f19687j = d2Var;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f19682e = i2;
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f19681d = i2;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.f19685h;
            if (i2 < 0) {
                this.f19685h = this.f19684g;
                return;
            }
            int i3 = this.f19684g;
            if (i2 > i3) {
                this.f19685h = i3;
            }
        }
    }

    public AntiData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19686i : (AntiData) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19684g : invokeV.intValue;
    }

    public Error c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (Error) invokeV.objValue;
    }

    public ForumData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f19678a : (ForumData) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d2 d2Var = this.f19687j;
            return (d2Var == null || this.f19679b == null || d2Var.J() == null || this.f19687j.J().getUserId() == null || this.f19679b.t() == null || this.f19679b.t().getUserId() == null || !this.f19687j.J().getUserId().equals(this.f19679b.t().getUserId())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f19683f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f19685h : invokeV.intValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f19679b : (PostData) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f19685h == -1) {
                this.f19685h = this.f19684g;
            }
            return this.f19685h;
        }
        return invokeV.intValue;
    }

    public ArrayList<PostData> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f19680c : (ArrayList) invokeV.objValue;
    }

    public d2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f19687j : (d2) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f19682e : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f19681d : invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f19684g < this.f19681d : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            d2 d2Var = this.f19687j;
            return d2Var != null && d2Var.D2();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void r(r rVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, rVar, z) == null) || rVar == null) {
            return;
        }
        x(rVar.a());
        A(rVar.d());
        C(rVar.i());
        E(rVar.l());
        y(rVar.q());
        if (rVar.k() != null) {
            z(rVar.b());
            B(rVar.g());
            F(rVar.m());
            G(rVar.n());
        }
        int size = this.f19680c.size();
        if (z && size % this.f19683f != 0) {
            for (int i2 = 0; i2 < size % this.f19683f; i2++) {
                ArrayList<PostData> arrayList = this.f19680c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f19680c.addAll(rVar.k());
    }

    public void s(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, rVar) == null) || rVar == null) {
            return;
        }
        x(rVar.a());
        A(rVar.d());
        C(rVar.i());
        E(rVar.l());
        y(rVar.q());
        if (rVar.k() != null && rVar.k().size() > 0) {
            z(rVar.b());
            B(rVar.g());
            F(rVar.m());
            G(rVar.n());
            int i2 = this.f19683f;
            int size = (this.f19684g - (((rVar.k().size() - 1) + i2) / i2)) + 1;
            this.f19685h = size;
            if (size < 0) {
                this.f19685h = 0;
            }
        }
        this.f19680c.addAll(rVar.k());
    }

    public void t(r rVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048603, this, rVar, z) == null) || rVar == null) {
            return;
        }
        x(rVar.a());
        A(rVar.d());
        C(rVar.i());
        E(rVar.l());
        y(rVar.q());
        if (rVar.k() != null && rVar.k().size() > 0) {
            z(rVar.b());
            B(rVar.g());
            F(rVar.m());
            G(rVar.n());
        }
        int size = this.f19680c.size();
        if (z && size % this.f19683f != 0) {
            for (int i2 = 0; i2 < size % this.f19683f; i2++) {
                ArrayList<PostData> arrayList = this.f19680c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f19680c.addAll(rVar.k());
        H();
    }

    public void u(r rVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, rVar, z) == null) {
            v(rVar, z);
        }
    }

    public void v(r rVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048605, this, rVar, z) == null) || rVar == null) {
            return;
        }
        x(rVar.a());
        this.f19685h = rVar.b();
        A(rVar.d());
        B(rVar.g());
        E(rVar.l());
        F(rVar.m());
        G(rVar.n());
        y(rVar.q());
        this.f19680c.addAll(0, rVar.k());
    }

    public void x(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, antiData) == null) {
            this.f19686i = antiData;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.l = z;
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.f19684g = i2;
        }
    }
}
