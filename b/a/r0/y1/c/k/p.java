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
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes6.dex */
public class p implements b.a.e.m.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f28975i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28976e;

    /* renamed from: f  reason: collision with root package name */
    public d f28977f;

    /* renamed from: g  reason: collision with root package name */
    public int f28978g;

    /* renamed from: h  reason: collision with root package name */
    public String f28979h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1265875736, "Lb/a/r0/y1/c/k/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1265875736, "Lb/a/r0/y1/c/k/p;");
                return;
            }
        }
        f28975i = BdUniqueId.gen();
    }

    public p(VipRank vipRank, VipUser vipUser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipRank, vipUser};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28976e = true;
        if (vipRank == null) {
            return;
        }
        String str = vipRank.card_id;
        d dVar = new d();
        this.f28977f = dVar;
        dVar.e(vipRank.class_name);
        this.f28977f.g(vipRank.class_url_name);
        this.f28977f.h(vipRank.class_url);
        this.f28978g = vipRank.my_score_rank.intValue();
        this.f28979h = vipUser.portrait;
    }

    public d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28977f : (d) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28979h : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f28978g < 0) {
                this.f28978g = 0;
            }
            if (this.f28978g > 9999) {
                return "9999+";
            }
            return "" + this.f28978g;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.e.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f28975i : (BdUniqueId) invokeV.objValue;
    }
}
