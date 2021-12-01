package c.a.r0.e2.c.k;

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
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes5.dex */
public class g implements c.a.d.m.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f16833h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f16834e;

    /* renamed from: f  reason: collision with root package name */
    public List<h> f16835f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16836g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1755751035, "Lc/a/r0/e2/c/k/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1755751035, "Lc/a/r0/e2/c/k/g;");
                return;
            }
        }
        f16833h = BdUniqueId.gen();
    }

    public g(VipDailyList vipDailyList) {
        List<VipThemeItem> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipDailyList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16836g = true;
        if (vipDailyList == null || (list = vipDailyList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipDailyList.card_id;
        d dVar = new d();
        this.f16834e = dVar;
        dVar.f(1);
        this.f16834e.e(vipDailyList.class_name);
        this.f16834e.g(vipDailyList.class_url_name);
        this.f16834e.h(vipDailyList.class_url);
        this.f16835f = new ArrayList();
        for (VipThemeItem vipThemeItem : vipDailyList.item) {
            this.f16835f.add(new h(vipThemeItem));
        }
    }

    public d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16834e : (d) invokeV.objValue;
    }

    public List<h> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16835f : (List) invokeV.objValue;
    }

    @Override // c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f16833h : (BdUniqueId) invokeV.objValue;
    }
}
