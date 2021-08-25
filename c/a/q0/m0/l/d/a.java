package c.a.q0.m0.l.d;

import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.q1;
import c.a.p0.s.q.w1;
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
    public ArrayList<n> f22158a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<w1> f22159b;

    /* renamed from: c  reason: collision with root package name */
    public q1 f22160c;

    /* renamed from: d  reason: collision with root package name */
    public c f22161d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22162e;

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
            aVar.f22158a = this.f22158a;
            aVar.f22159b = this.f22159b;
            aVar.f22160c = this.f22160c;
            aVar.f22161d = this.f22161d;
            aVar.f22162e = this.f22162e;
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22161d : (c) invokeV.objValue;
    }

    public q1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22160c : (q1) invokeV.objValue;
    }

    public ArrayList<w1> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22159b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22158a : (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22162e : invokeV.booleanValue;
    }

    public void g(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f22158a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            c2 c2Var = new c2();
            c2Var.S2(threadInfo);
            c2Var.E1();
            this.f22158a.add(c2Var);
        }
        this.f22159b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                w1 w1Var = new w1();
                w1Var.g(generalResource);
                this.f22159b.add(w1Var);
            }
        }
        q1 q1Var = new q1();
        this.f22160c = q1Var;
        q1Var.o(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f22161d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f22171a = hotUserRankEntry.hot_user;
            cVar.f22172b = hotUserRankEntry.module_name;
            cVar.f22173c = hotUserRankEntry.module_icon;
        }
        this.f22162e = dataRes.is_new_url.intValue() == 1;
    }
}
