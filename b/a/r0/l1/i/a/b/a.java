package b.a.r0.l1.i.a.b;

import b.a.r0.l1.h.l;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b> f20165a;

    /* renamed from: b  reason: collision with root package name */
    public Page f20166b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20167c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20168d;

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
        this.f20165a = new ArrayList();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20167c : invokeV.booleanValue;
    }

    public List<b> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20165a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20168d : invokeV.booleanValue;
    }

    public void d(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dataRes) == null) || dataRes == null) {
            return;
        }
        Page page = dataRes.page;
        this.f20166b = page;
        if (page != null) {
            this.f20167c = page.has_more.intValue() == 1;
        }
        List<BroadcastInfo> list = dataRes.bcast_infos;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                b bVar = new b();
                bVar.l(list.get(i2));
                this.f20165a.add(bVar);
            }
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f20168d = z;
        }
    }

    public void f() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.f20165a) == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f20165a) {
            if (bVar != null) {
                l.t().x(bVar.e().forum_id.longValue(), bVar.b() * 100, bVar.i());
            }
        }
    }
}
