package c.a.p0.m0.l.d;

import c.a.e.k.e.n;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.q1;
import c.a.o0.s.q.w1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.HotUserRankEntry;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f21828a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<w1> f21829b;

    /* renamed from: c  reason: collision with root package name */
    public q1 f21830c;

    /* renamed from: d  reason: collision with root package name */
    public c f21831d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21832e;

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
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = new a();
            aVar.f21828a = this.f21828a;
            aVar.f21829b = this.f21829b;
            aVar.f21830c = this.f21830c;
            aVar.f21831d = this.f21831d;
            aVar.f21832e = this.f21832e;
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21831d : (c) invokeV.objValue;
    }

    public q1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21830c : (q1) invokeV.objValue;
    }

    public ArrayList<w1> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21829b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21828a : (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f21832e : invokeV.booleanValue;
    }

    public void g(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f21828a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            c2 c2Var = new c2();
            c2Var.S2(threadInfo);
            c2Var.E1();
            this.f21828a.add(c2Var);
        }
        this.f21829b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                w1 w1Var = new w1();
                w1Var.g(generalResource);
                this.f21829b.add(w1Var);
            }
        }
        q1 q1Var = new q1();
        this.f21830c = q1Var;
        q1Var.o(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f21831d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f21841a = hotUserRankEntry.hot_user;
            cVar.f21842b = hotUserRankEntry.module_name;
            cVar.f21843c = hotUserRankEntry.module_icon;
        }
        this.f21832e = dataRes.is_new_url.intValue() == 1;
    }
}
