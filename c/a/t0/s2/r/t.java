package c.a.t0.s2.r;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
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
/* loaded from: classes8.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;

    /* renamed from: b  reason: collision with root package name */
    public PostData f22450b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<PostData> f22451c;

    /* renamed from: d  reason: collision with root package name */
    public int f22452d;

    /* renamed from: e  reason: collision with root package name */
    public int f22453e;

    /* renamed from: f  reason: collision with root package name */
    public int f22454f;

    /* renamed from: g  reason: collision with root package name */
    public int f22455g;

    /* renamed from: h  reason: collision with root package name */
    public int f22456h;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f22457i;

    /* renamed from: j  reason: collision with root package name */
    public e2 f22458j;
    public boolean k;
    public boolean l;
    public Error m;

    public t() {
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
        this.f22454f = 20;
        this.f22456h = -1;
        this.k = false;
        this.f22450b = null;
        this.f22451c = new ArrayList<>();
        this.f22452d = 1;
    }

    public static t w(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataRes)) == null) {
            if (dataRes == null) {
                return null;
            }
            try {
                t tVar = new t();
                AntiData antiData = new AntiData();
                antiData.parserProtobuf(dataRes.anti);
                tVar.x(antiData);
                e2 e2Var = new e2();
                e2Var.c3(dataRes.thread);
                tVar.E(e2Var);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                tVar.A(forumData);
                PostData postData = new PostData();
                postData.p0(forumData.isBrandForum);
                postData.i0(dataRes.post, e2Var);
                tVar.C(postData);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<PostData> arrayList = new ArrayList<>();
                int A = postData.A();
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData2 = new PostData();
                    postData2.p0(forumData.isBrandForum);
                    postData2.g0(list.get(i2), false, e2Var, A);
                    if (postData2.q() != null && postData2.q().baijiahaoData == null && e2Var.L() != null) {
                        postData2.q().baijiahaoData = e2Var.L();
                    }
                    arrayList.add(postData2);
                }
                tVar.D(arrayList);
                AntiData antiData2 = new AntiData();
                antiData2.parserProtobuf(dataRes.anti);
                tVar.x(antiData2);
                Page page = dataRes.page;
                if (page != null) {
                    int intValue = page.total_page.intValue();
                    int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                    int intValue3 = page.current_page.intValue();
                    int intValue4 = page.total_count.intValue();
                    tVar.z(intValue3);
                    tVar.B(intValue2);
                    tVar.F(intValue4);
                    tVar.G(intValue);
                }
                tVar.y(dataRes.is_black_white.intValue() == 1);
                return tVar;
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (t) invokeL.objValue;
    }

    public void A(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumData) == null) {
            this.a = forumData;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f22454f = i2;
    }

    public void C(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) {
            this.f22450b = postData;
        }
    }

    public void D(ArrayList<PostData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f22451c = arrayList;
        }
    }

    public void E(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, e2Var) == null) {
            this.f22458j = e2Var;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f22453e = i2;
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f22452d = i2;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.f22456h;
            if (i2 < 0) {
                this.f22456h = this.f22455g;
                return;
            }
            int i3 = this.f22455g;
            if (i2 > i3) {
                this.f22456h = i3;
            }
        }
    }

    public AntiData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22457i : (AntiData) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22455g : invokeV.intValue;
    }

    public Error c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (Error) invokeV.objValue;
    }

    public ForumData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (ForumData) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            e2 e2Var = this.f22458j;
            return (e2Var == null || this.f22450b == null || e2Var.J() == null || this.f22458j.J().getUserId() == null || this.f22450b.t() == null || this.f22450b.t().getUserId() == null || !this.f22458j.J().getUserId().equals(this.f22450b.t().getUserId())) ? false : true;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f22454f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f22456h : invokeV.intValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f22450b : (PostData) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f22456h == -1) {
                this.f22456h = this.f22455g;
            }
            return this.f22456h;
        }
        return invokeV.intValue;
    }

    public ArrayList<PostData> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f22451c : (ArrayList) invokeV.objValue;
    }

    public e2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f22458j : (e2) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f22453e : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f22452d : invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f22455g < this.f22452d : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            e2 e2Var = this.f22458j;
            return e2Var != null && e2Var.G2();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void r(t tVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, tVar, z) == null) || tVar == null) {
            return;
        }
        x(tVar.a());
        A(tVar.d());
        C(tVar.i());
        E(tVar.l());
        y(tVar.q());
        if (tVar.k() != null) {
            z(tVar.b());
            B(tVar.g());
            F(tVar.m());
            G(tVar.n());
        }
        int size = this.f22451c.size();
        if (z && size % this.f22454f != 0) {
            for (int i2 = 0; i2 < size % this.f22454f; i2++) {
                ArrayList<PostData> arrayList = this.f22451c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f22451c.addAll(tVar.k());
    }

    public void s(t tVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, tVar) == null) || tVar == null) {
            return;
        }
        x(tVar.a());
        A(tVar.d());
        C(tVar.i());
        E(tVar.l());
        y(tVar.q());
        if (tVar.k() != null && tVar.k().size() > 0) {
            z(tVar.b());
            B(tVar.g());
            F(tVar.m());
            G(tVar.n());
            int i2 = this.f22454f;
            int size = (this.f22455g - (((tVar.k().size() - 1) + i2) / i2)) + 1;
            this.f22456h = size;
            if (size < 0) {
                this.f22456h = 0;
            }
        }
        this.f22451c.addAll(tVar.k());
    }

    public void t(t tVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048603, this, tVar, z) == null) || tVar == null) {
            return;
        }
        x(tVar.a());
        A(tVar.d());
        C(tVar.i());
        E(tVar.l());
        y(tVar.q());
        if (tVar.k() != null && tVar.k().size() > 0) {
            z(tVar.b());
            B(tVar.g());
            F(tVar.m());
            G(tVar.n());
        }
        int size = this.f22451c.size();
        if (z && size % this.f22454f != 0) {
            for (int i2 = 0; i2 < size % this.f22454f; i2++) {
                ArrayList<PostData> arrayList = this.f22451c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f22451c.addAll(tVar.k());
        H();
    }

    public void u(t tVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, tVar, z) == null) {
            v(tVar, z);
        }
    }

    public void v(t tVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048605, this, tVar, z) == null) || tVar == null) {
            return;
        }
        x(tVar.a());
        this.f22456h = tVar.b();
        A(tVar.d());
        B(tVar.g());
        E(tVar.l());
        F(tVar.m());
        G(tVar.n());
        y(tVar.q());
        this.f22451c.addAll(0, tVar.k());
    }

    public void x(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, antiData) == null) {
            this.f22457i = antiData;
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
            this.f22455g = i2;
        }
    }
}
