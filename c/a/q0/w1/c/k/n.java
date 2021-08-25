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
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes4.dex */
public class n implements c.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f27854h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f27855e;

    /* renamed from: f  reason: collision with root package name */
    public List<o> f27856f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27857g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1709416232, "Lc/a/q0/w1/c/k/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1709416232, "Lc/a/q0/w1/c/k/n;");
                return;
            }
        }
        f27854h = BdUniqueId.gen();
    }

    public n(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipSpecialList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27857g = true;
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f27855e = dVar;
        dVar.f(1);
        this.f27855e.e(vipSpecialList.class_name);
        this.f27855e.g(vipSpecialList.class_url_name);
        this.f27855e.h(vipSpecialList.class_url);
        this.f27856f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
            this.f27856f.add(new o(vipSpecialItem));
        }
    }

    public d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27855e : (d) invokeV.objValue;
    }

    public List<o> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27856f : (List) invokeV.objValue;
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f27854h : (BdUniqueId) invokeV.objValue;
    }
}
