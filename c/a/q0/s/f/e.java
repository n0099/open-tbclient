package c.a.q0.s.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24248a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.p0.t.f.a> f24249b;

    public e() {
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

    public List<c.a.p0.t.f.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f24249b == null) {
                this.f24249b = new ArrayList();
            }
            return this.f24249b;
        }
        return (List) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24248a : (String) invokeV.objValue;
    }

    public void c(listData listdata) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, listdata) == null) || listdata == null) {
            return;
        }
        this.f24248a = listdata.key;
        if (listdata.friend_list != null) {
            this.f24249b = new ArrayList();
            for (friendList friendlist : listdata.friend_list) {
                c.a.p0.t.f.a aVar = new c.a.p0.t.f.a();
                aVar.j(friendlist);
                aVar.k(this.f24248a);
                this.f24249b.add(aVar);
            }
        }
    }

    public void d(robotsList robotslist) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, robotslist) == null) || robotslist == null) {
            return;
        }
        this.f24248a = robotslist.key;
        if (robotslist.friend_list != null) {
            this.f24249b = new ArrayList();
            for (friendList friendlist : robotslist.friend_list) {
                c.a.p0.t.f.a aVar = new c.a.p0.t.f.a();
                aVar.j(friendlist);
                aVar.k(this.f24248a);
                this.f24249b.add(aVar);
            }
        }
    }
}
