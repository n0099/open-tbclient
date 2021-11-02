package b.a.r0.k2.r;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
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
/* loaded from: classes5.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumData f18805a;

    /* renamed from: b  reason: collision with root package name */
    public PostData f18806b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<PostData> f18807c;

    /* renamed from: d  reason: collision with root package name */
    public int f18808d;

    /* renamed from: e  reason: collision with root package name */
    public int f18809e;

    /* renamed from: f  reason: collision with root package name */
    public int f18810f;

    /* renamed from: g  reason: collision with root package name */
    public int f18811g;

    /* renamed from: h  reason: collision with root package name */
    public int f18812h;

    /* renamed from: i  reason: collision with root package name */
    public AntiData f18813i;
    public d2 j;
    public boolean k;
    public boolean l;
    public Error m;

    public s() {
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
        this.f18810f = 20;
        this.f18812h = -1;
        this.k = false;
        this.f18806b = null;
        this.f18807c = new ArrayList<>();
        this.f18808d = 1;
    }

    public static s w(DataRes dataRes, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dataRes, context)) == null) {
            if (dataRes == null) {
                return null;
            }
            try {
                s sVar = new s();
                AntiData antiData = new AntiData();
                antiData.parserProtobuf(dataRes.anti);
                sVar.x(antiData);
                d2 d2Var = new d2();
                d2Var.Y2(dataRes.thread);
                sVar.E(d2Var);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                sVar.A(forumData);
                PostData postData = new PostData();
                postData.o0(forumData.isBrandForum);
                postData.h0(dataRes.post, context, d2Var);
                sVar.C(postData);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<PostData> arrayList = new ArrayList<>();
                int A = postData.A();
                int i2 = 0;
                while (i2 < size) {
                    SubPostList subPostList = list.get(i2);
                    PostData postData2 = new PostData();
                    postData2.o0(forumData.isBrandForum);
                    int i3 = i2;
                    postData2.f0(subPostList, context, false, d2Var, A);
                    if (postData2.q() != null && postData2.q().baijiahaoData == null && d2Var.L() != null) {
                        postData2.q().baijiahaoData = d2Var.L();
                    }
                    arrayList.add(postData2);
                    i2 = i3 + 1;
                }
                sVar.D(arrayList);
                AntiData antiData2 = new AntiData();
                antiData2.parserProtobuf(dataRes.anti);
                sVar.x(antiData2);
                Page page = dataRes.page;
                if (page != null) {
                    int intValue = page.total_page.intValue();
                    int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                    int intValue3 = page.current_page.intValue();
                    int intValue4 = page.total_count.intValue();
                    sVar.z(intValue3);
                    sVar.B(intValue2);
                    sVar.F(intValue4);
                    sVar.G(intValue);
                }
                boolean z = true;
                if (dataRes.is_black_white.intValue() != 1) {
                    z = false;
                }
                sVar.y(z);
                return sVar;
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (s) invokeLL.objValue;
    }

    public void A(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumData) == null) {
            this.f18805a = forumData;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f18810f = i2;
    }

    public void C(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) {
            this.f18806b = postData;
        }
    }

    public void D(ArrayList<PostData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f18807c = arrayList;
        }
    }

    public void E(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) {
            this.j = d2Var;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f18809e = i2;
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f18808d = i2;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.f18812h;
            if (i2 < 0) {
                this.f18812h = this.f18811g;
                return;
            }
            int i3 = this.f18811g;
            if (i2 > i3) {
                this.f18812h = i3;
            }
        }
    }

    public AntiData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18813i : (AntiData) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f18811g : invokeV.intValue;
    }

    public Error c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (Error) invokeV.objValue;
    }

    public ForumData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f18805a : (ForumData) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d2 d2Var = this.j;
            return (d2Var == null || this.f18806b == null || d2Var.J() == null || this.j.J().getUserId() == null || this.f18806b.t() == null || this.f18806b.t().getUserId() == null || !this.j.J().getUserId().equals(this.f18806b.t().getUserId())) ? false : true;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f18810f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f18812h : invokeV.intValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f18806b : (PostData) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f18812h == -1) {
                this.f18812h = this.f18811g;
            }
            return this.f18812h;
        }
        return invokeV.intValue;
    }

    public ArrayList<PostData> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f18807c : (ArrayList) invokeV.objValue;
    }

    public d2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : (d2) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f18809e : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f18808d : invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f18811g < this.f18808d : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            d2 d2Var = this.j;
            return d2Var != null && d2Var.D2();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void r(s sVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, sVar, z) == null) || sVar == null) {
            return;
        }
        x(sVar.a());
        A(sVar.d());
        C(sVar.i());
        E(sVar.l());
        y(sVar.q());
        if (sVar.k() != null) {
            z(sVar.b());
            B(sVar.g());
            F(sVar.m());
            G(sVar.n());
        }
        int size = this.f18807c.size();
        if (z && size % this.f18810f != 0) {
            for (int i2 = 0; i2 < size % this.f18810f; i2++) {
                ArrayList<PostData> arrayList = this.f18807c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f18807c.addAll(sVar.k());
    }

    public void s(s sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, sVar) == null) || sVar == null) {
            return;
        }
        x(sVar.a());
        A(sVar.d());
        C(sVar.i());
        E(sVar.l());
        y(sVar.q());
        if (sVar.k() != null && sVar.k().size() > 0) {
            z(sVar.b());
            B(sVar.g());
            F(sVar.m());
            G(sVar.n());
            int i2 = this.f18810f;
            int size = (this.f18811g - (((sVar.k().size() - 1) + i2) / i2)) + 1;
            this.f18812h = size;
            if (size < 0) {
                this.f18812h = 0;
            }
        }
        this.f18807c.addAll(sVar.k());
    }

    public void t(s sVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048603, this, sVar, z) == null) || sVar == null) {
            return;
        }
        x(sVar.a());
        A(sVar.d());
        C(sVar.i());
        E(sVar.l());
        y(sVar.q());
        if (sVar.k() != null && sVar.k().size() > 0) {
            z(sVar.b());
            B(sVar.g());
            F(sVar.m());
            G(sVar.n());
        }
        int size = this.f18807c.size();
        if (z && size % this.f18810f != 0) {
            for (int i2 = 0; i2 < size % this.f18810f; i2++) {
                ArrayList<PostData> arrayList = this.f18807c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f18807c.addAll(sVar.k());
        H();
    }

    public void u(s sVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, sVar, z) == null) {
            v(sVar, z);
        }
    }

    public void v(s sVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048605, this, sVar, z) == null) || sVar == null) {
            return;
        }
        x(sVar.a());
        this.f18812h = sVar.b();
        A(sVar.d());
        B(sVar.g());
        E(sVar.l());
        F(sVar.m());
        G(sVar.n());
        y(sVar.q());
        this.f18807c.addAll(0, sVar.k());
    }

    public void x(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, antiData) == null) {
            this.f18813i = antiData;
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
            this.f18811g = i2;
        }
    }
}
