package c.a.r0.n0.l.d;

import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.r1;
import c.a.q0.s.q.x1;
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
    public ArrayList<n> f22726a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<x1> f22727b;

    /* renamed from: c  reason: collision with root package name */
    public r1 f22728c;

    /* renamed from: d  reason: collision with root package name */
    public c f22729d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22730e;

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
            aVar.f22726a = this.f22726a;
            aVar.f22727b = this.f22727b;
            aVar.f22728c = this.f22728c;
            aVar.f22729d = this.f22729d;
            aVar.f22730e = this.f22730e;
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22729d : (c) invokeV.objValue;
    }

    public r1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22728c : (r1) invokeV.objValue;
    }

    public ArrayList<x1> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22727b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22726a : (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22730e : invokeV.booleanValue;
    }

    public void g(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f22726a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            d2 d2Var = new d2();
            d2Var.Y2(threadInfo);
            d2Var.G1();
            this.f22726a.add(d2Var);
        }
        this.f22727b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                x1 x1Var = new x1();
                x1Var.g(generalResource);
                this.f22727b.add(x1Var);
            }
        }
        r1 r1Var = new r1();
        this.f22728c = r1Var;
        r1Var.o(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f22729d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f22739a = hotUserRankEntry.hot_user;
            cVar.f22740b = hotUserRankEntry.module_name;
            cVar.f22741c = hotUserRankEntry.module_icon;
        }
        this.f22730e = dataRes.is_new_url.intValue() == 1;
    }
}
