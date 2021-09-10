package c.a.r0.k1.i.a.b;

import c.a.r0.k1.h.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BroadcastInfo;
import tbclient.GetForumBroadcastList.DataRes;
import tbclient.Page;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b> f21381a;

    /* renamed from: b  reason: collision with root package name */
    public Page f21382b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21383c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21384d;

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
                return;
            }
        }
        this.f21381a = new ArrayList();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21383c : invokeV.booleanValue;
    }

    public List<b> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21381a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21384d : invokeV.booleanValue;
    }

    public void d(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dataRes) == null) || dataRes == null) {
            return;
        }
        Page page = dataRes.page;
        this.f21382b = page;
        if (page != null) {
            this.f21383c = page.has_more.intValue() == 1;
        }
        List<BroadcastInfo> list = dataRes.bcast_infos;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                b bVar = new b();
                bVar.l(list.get(i2));
                this.f21381a.add(bVar);
            }
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f21384d = z;
        }
    }

    public void f() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.f21381a) == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f21381a) {
            if (bVar != null) {
                l.t().x(bVar.e().forum_id.longValue(), bVar.b() * 100, bVar.i());
            }
        }
    }
}
