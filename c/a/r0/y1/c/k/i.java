package c.a.r0.y1.c.k;

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
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes4.dex */
public class i implements c.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f28709i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28710e;

    /* renamed from: f  reason: collision with root package name */
    public d f28711f;

    /* renamed from: g  reason: collision with root package name */
    public List<j> f28712g;

    /* renamed from: h  reason: collision with root package name */
    public List<j> f28713h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1776410130, "Lc/a/r0/y1/c/k/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1776410130, "Lc/a/r0/y1/c/k/i;");
                return;
            }
        }
        f28709i = BdUniqueId.gen();
    }

    public i(VipThemeList vipThemeList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipThemeList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28710e = true;
        if (vipThemeList == null) {
            return;
        }
        String str = vipThemeList.card_id;
        d dVar = new d();
        this.f28711f = dVar;
        dVar.f(2);
        this.f28711f.e(vipThemeList.class_name);
        this.f28711f.g(vipThemeList.class_url_name);
        this.f28711f.h(vipThemeList.class_url);
        if (vipThemeList.item != null) {
            this.f28712g = new ArrayList();
            for (VipThemeItem vipThemeItem : vipThemeList.item) {
                this.f28712g.add(new j(vipThemeItem));
            }
        }
        if (vipThemeList.item_card != null) {
            this.f28713h = new ArrayList();
            for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                this.f28713h.add(new j(vipThemeItem2));
            }
        }
    }

    public d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28711f : (d) invokeV.objValue;
    }

    public List<j> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28712g : (List) invokeV.objValue;
    }

    public List<j> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28713h : (List) invokeV.objValue;
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f28709i : (BdUniqueId) invokeV.objValue;
    }
}
