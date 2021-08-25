package c.a.q0.w1.c.k;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes4.dex */
public class c implements c.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final BdUniqueId f27793j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f27794e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f27795f;

    /* renamed from: g  reason: collision with root package name */
    public int f27796g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27797h;

    /* renamed from: i  reason: collision with root package name */
    public String f27798i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1709415891, "Lc/a/q0/w1/c/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1709415891, "Lc/a/q0/w1/c/k/c;");
                return;
            }
        }
        f27793j = BdUniqueId.gen();
    }

    public c(VipBasicList vipBasicList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipBasicList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27796g = 0;
        this.f27797h = true;
        this.f27798i = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f27798i = vipBasicList.card_id;
        this.f27796g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f27794e = dVar;
        dVar.f(5);
        this.f27794e.e(vipBasicList.class_name);
        this.f27794e.g(vipBasicList.class_url_name);
        this.f27794e.h(vipBasicList.class_url);
        this.f27795f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f27795f.add(vipSpecialItem);
        }
    }

    public d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27794e : (d) invokeV.objValue;
    }

    public List<VipSpecialItem> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27795f : (List) invokeV.objValue;
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f27793j : (BdUniqueId) invokeV.objValue;
    }
}
