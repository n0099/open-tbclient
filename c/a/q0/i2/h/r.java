package c.a.q0.i2.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
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
    public ForumData f19114a;

    /* renamed from: b  reason: collision with root package name */
    public PostData f19115b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<PostData> f19116c;

    /* renamed from: d  reason: collision with root package name */
    public int f19117d;

    /* renamed from: e  reason: collision with root package name */
    public int f19118e;

    /* renamed from: f  reason: collision with root package name */
    public int f19119f;

    /* renamed from: g  reason: collision with root package name */
    public int f19120g;

    /* renamed from: h  reason: collision with root package name */
    public int f19121h;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f19122i;

    /* renamed from: j  reason: collision with root package name */
    public c2 f19123j;
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
        this.f19119f = 20;
        this.f19121h = -1;
        this.k = false;
        this.f19115b = null;
        this.f19116c = new ArrayList<>();
        this.f19117d = 1;
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
                c2 c2Var = new c2();
                c2Var.S2(dataRes.thread);
                rVar.E(c2Var);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                rVar.A(forumData);
                PostData postData = new PostData();
                postData.j0(forumData.isBrandForum);
                postData.d0(dataRes.post, context, c2Var);
                rVar.C(postData);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<PostData> arrayList = new ArrayList<>();
                int A = postData.A();
                int i2 = 0;
                while (i2 < size) {
                    SubPostList subPostList = list.get(i2);
                    PostData postData2 = new PostData();
                    postData2.j0(forumData.isBrandForum);
                    int i3 = i2;
                    postData2.b0(subPostList, context, false, c2Var, A);
                    if (postData2.q() != null && postData2.q().baijiahaoData == null && c2Var.L() != null) {
                        postData2.q().baijiahaoData = c2Var.L();
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
            this.f19114a = forumData;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f19119f = i2;
    }

    public void C(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) {
            this.f19115b = postData;
        }
    }

    public void D(ArrayList<PostData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f19116c = arrayList;
        }
    }

    public void E(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c2Var) == null) {
            this.f19123j = c2Var;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f19118e = i2;
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f19117d = i2;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.f19121h;
            if (i2 < 0) {
                this.f19121h = this.f19120g;
                return;
            }
            int i3 = this.f19120g;
            if (i2 > i3) {
                this.f19121h = i3;
            }
        }
    }

    public AntiData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19122i : (AntiData) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19120g : invokeV.intValue;
    }

    public Error c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (Error) invokeV.objValue;
    }

    public ForumData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f19114a : (ForumData) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c2 c2Var = this.f19123j;
            return (c2Var == null || this.f19115b == null || c2Var.J() == null || this.f19123j.J().getUserId() == null || this.f19115b.t() == null || this.f19115b.t().getUserId() == null || !this.f19123j.J().getUserId().equals(this.f19115b.t().getUserId())) ? false : true;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f19119f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f19121h : invokeV.intValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f19115b : (PostData) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f19121h == -1) {
                this.f19121h = this.f19120g;
            }
            return this.f19121h;
        }
        return invokeV.intValue;
    }

    public ArrayList<PostData> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f19116c : (ArrayList) invokeV.objValue;
    }

    public c2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f19123j : (c2) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f19118e : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f19117d : invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f19120g < this.f19117d : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            c2 c2Var = this.f19123j;
            return c2Var != null && c2Var.z2();
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
        int size = this.f19116c.size();
        if (z && size % this.f19119f != 0) {
            for (int i2 = 0; i2 < size % this.f19119f; i2++) {
                ArrayList<PostData> arrayList = this.f19116c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f19116c.addAll(rVar.k());
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
            int i2 = this.f19119f;
            int size = (this.f19120g - (((rVar.k().size() - 1) + i2) / i2)) + 1;
            this.f19121h = size;
            if (size < 0) {
                this.f19121h = 0;
            }
        }
        this.f19116c.addAll(rVar.k());
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
        int size = this.f19116c.size();
        if (z && size % this.f19119f != 0) {
            for (int i2 = 0; i2 < size % this.f19119f; i2++) {
                ArrayList<PostData> arrayList = this.f19116c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f19116c.addAll(rVar.k());
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
        this.f19121h = rVar.b();
        A(rVar.d());
        B(rVar.g());
        E(rVar.l());
        F(rVar.m());
        G(rVar.n());
        y(rVar.q());
        this.f19116c.addAll(0, rVar.k());
    }

    public void x(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, antiData) == null) {
            this.f19122i = antiData;
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
            this.f19120g = i2;
        }
    }
}
