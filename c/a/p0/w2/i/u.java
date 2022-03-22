package c.a.p0.w2.i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;

    /* renamed from: b  reason: collision with root package name */
    public PostData f19859b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<PostData> f19860c;

    /* renamed from: d  reason: collision with root package name */
    public int f19861d;

    /* renamed from: e  reason: collision with root package name */
    public int f19862e;

    /* renamed from: f  reason: collision with root package name */
    public int f19863f;

    /* renamed from: g  reason: collision with root package name */
    public int f19864g;

    /* renamed from: h  reason: collision with root package name */
    public int f19865h;
    public AntiData i;
    public ThreadData j;
    public boolean k;
    public boolean l;
    public Error m;

    public u() {
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
        this.f19863f = 20;
        this.f19865h = -1;
        this.k = false;
        this.f19859b = null;
        this.f19860c = new ArrayList<>();
        this.f19861d = 1;
    }

    public static u w(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataRes)) == null) {
            if (dataRes == null) {
                return null;
            }
            try {
                u uVar = new u();
                AntiData antiData = new AntiData();
                antiData.parserProtobuf(dataRes.anti);
                uVar.x(antiData);
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(dataRes.thread);
                uVar.E(threadData);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                uVar.A(forumData);
                PostData postData = new PostData();
                postData.p0(forumData.isBrandForum);
                postData.i0(dataRes.post, threadData);
                uVar.C(postData);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<PostData> arrayList = new ArrayList<>();
                int A = postData.A();
                for (int i = 0; i < size; i++) {
                    PostData postData2 = new PostData();
                    postData2.p0(forumData.isBrandForum);
                    postData2.g0(list.get(i), false, threadData, A);
                    if (postData2.q() != null && postData2.q().baijiahaoData == null && threadData.getBaijiahaoData() != null) {
                        postData2.q().baijiahaoData = threadData.getBaijiahaoData();
                    }
                    arrayList.add(postData2);
                }
                uVar.D(arrayList);
                AntiData antiData2 = new AntiData();
                antiData2.parserProtobuf(dataRes.anti);
                uVar.x(antiData2);
                Page page = dataRes.page;
                if (page != null) {
                    int intValue = page.total_page.intValue();
                    int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                    int intValue3 = page.current_page.intValue();
                    int intValue4 = page.total_count.intValue();
                    uVar.z(intValue3);
                    uVar.B(intValue2);
                    uVar.F(intValue4);
                    uVar.G(intValue);
                }
                uVar.y(dataRes.is_black_white.intValue() == 1);
                return uVar;
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (u) invokeL.objValue;
    }

    public void A(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumData) == null) {
            this.a = forumData;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i == 0) {
            return;
        }
        this.f19863f = i;
    }

    public void C(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) {
            this.f19859b = postData;
        }
    }

    public void D(ArrayList<PostData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f19860c = arrayList;
        }
    }

    public void E(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            this.j = threadData;
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f19862e = i;
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f19861d = i;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.f19865h;
            if (i < 0) {
                this.f19865h = this.f19864g;
                return;
            }
            int i2 = this.f19864g;
            if (i > i2) {
                this.f19865h = i2;
            }
        }
    }

    public AntiData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (AntiData) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19864g : invokeV.intValue;
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
            ThreadData threadData = this.j;
            return (threadData == null || this.f19859b == null || threadData.getAuthor() == null || this.j.getAuthor().getUserId() == null || this.f19859b.s() == null || this.f19859b.s().getUserId() == null || !this.j.getAuthor().getUserId().equals(this.f19859b.s().getUserId())) ? false : true;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f19863f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f19865h : invokeV.intValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f19859b : (PostData) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f19865h == -1) {
                this.f19865h = this.f19864g;
            }
            return this.f19865h;
        }
        return invokeV.intValue;
    }

    public ArrayList<PostData> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f19860c : (ArrayList) invokeV.objValue;
    }

    public ThreadData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : (ThreadData) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f19862e : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f19861d : invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f19864g < this.f19861d : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ThreadData threadData = this.j;
            return threadData != null && threadData.isUgcThreadType();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void r(u uVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, uVar, z) == null) || uVar == null) {
            return;
        }
        x(uVar.a());
        A(uVar.d());
        C(uVar.i());
        E(uVar.l());
        y(uVar.q());
        if (uVar.k() != null) {
            z(uVar.b());
            B(uVar.g());
            F(uVar.m());
            G(uVar.n());
        }
        int size = this.f19860c.size();
        if (z && size % this.f19863f != 0) {
            for (int i = 0; i < size % this.f19863f; i++) {
                ArrayList<PostData> arrayList = this.f19860c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f19860c.addAll(uVar.k());
    }

    public void s(u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, uVar) == null) || uVar == null) {
            return;
        }
        x(uVar.a());
        A(uVar.d());
        C(uVar.i());
        E(uVar.l());
        y(uVar.q());
        if (uVar.k() != null && uVar.k().size() > 0) {
            z(uVar.b());
            B(uVar.g());
            F(uVar.m());
            G(uVar.n());
            int i = this.f19863f;
            int size = (this.f19864g - (((uVar.k().size() - 1) + i) / i)) + 1;
            this.f19865h = size;
            if (size < 0) {
                this.f19865h = 0;
            }
        }
        this.f19860c.addAll(uVar.k());
    }

    public void t(u uVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048603, this, uVar, z) == null) || uVar == null) {
            return;
        }
        x(uVar.a());
        A(uVar.d());
        C(uVar.i());
        E(uVar.l());
        y(uVar.q());
        if (uVar.k() != null && uVar.k().size() > 0) {
            z(uVar.b());
            B(uVar.g());
            F(uVar.m());
            G(uVar.n());
        }
        int size = this.f19860c.size();
        if (z && size % this.f19863f != 0) {
            for (int i = 0; i < size % this.f19863f; i++) {
                ArrayList<PostData> arrayList = this.f19860c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.f19860c.addAll(uVar.k());
        H();
    }

    public void u(u uVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, uVar, z) == null) {
            v(uVar, z);
        }
    }

    public void v(u uVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048605, this, uVar, z) == null) || uVar == null) {
            return;
        }
        x(uVar.a());
        this.f19865h = uVar.b();
        A(uVar.d());
        B(uVar.g());
        E(uVar.l());
        F(uVar.m());
        G(uVar.n());
        y(uVar.q());
        this.f19860c.addAll(0, uVar.k());
    }

    public void x(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, antiData) == null) {
            this.i = antiData;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.l = z;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.f19864g = i;
        }
    }
}
