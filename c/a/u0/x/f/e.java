package c.a.u0.x.f;

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
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.t0.t.f.a> f25078b;

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

    public List<c.a.t0.t.f.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f25078b == null) {
                this.f25078b = new ArrayList();
            }
            return this.f25078b;
        }
        return (List) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public void c(listData listdata) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, listdata) == null) || listdata == null) {
            return;
        }
        this.a = listdata.key;
        if (listdata.friend_list != null) {
            this.f25078b = new ArrayList();
            for (friendList friendlist : listdata.friend_list) {
                c.a.t0.t.f.a aVar = new c.a.t0.t.f.a();
                aVar.j(friendlist);
                aVar.k(this.a);
                this.f25078b.add(aVar);
            }
        }
    }

    public void d(robotsList robotslist) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, robotslist) == null) || robotslist == null) {
            return;
        }
        this.a = robotslist.key;
        if (robotslist.friend_list != null) {
            this.f25078b = new ArrayList();
            for (friendList friendlist : robotslist.friend_list) {
                c.a.t0.t.f.a aVar = new c.a.t0.t.f.a();
                aVar.j(friendlist);
                aVar.k(this.a);
                this.f25078b.add(aVar);
            }
        }
    }
}
