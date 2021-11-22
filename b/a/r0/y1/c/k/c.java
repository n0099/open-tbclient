package b.a.r0.y1.c.k;

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
/* loaded from: classes6.dex */
public class c implements b.a.e.m.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f28906e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f28907f;

    /* renamed from: g  reason: collision with root package name */
    public int f28908g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28909h;

    /* renamed from: i  reason: collision with root package name */
    public String f28910i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1265876139, "Lb/a/r0/y1/c/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1265876139, "Lb/a/r0/y1/c/k/c;");
                return;
            }
        }
        j = BdUniqueId.gen();
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
        this.f28908g = 0;
        this.f28909h = true;
        this.f28910i = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f28910i = vipBasicList.card_id;
        this.f28908g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f28906e = dVar;
        dVar.f(5);
        this.f28906e.e(vipBasicList.class_name);
        this.f28906e.g(vipBasicList.class_url_name);
        this.f28906e.h(vipBasicList.class_url);
        this.f28907f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f28907f.add(vipSpecialItem);
        }
    }

    public d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28906e : (d) invokeV.objValue;
    }

    public List<VipSpecialItem> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28907f : (List) invokeV.objValue;
    }

    @Override // b.a.e.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? j : (BdUniqueId) invokeV.objValue;
    }
}
