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
public class p implements b.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f27472i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27473e;

    /* renamed from: f  reason: collision with root package name */
    public d f27474f;

    /* renamed from: g  reason: collision with root package name */
    public int f27475g;

    /* renamed from: h  reason: collision with root package name */
    public String f27476h;

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
        f27472i = BdUniqueId.gen();
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
        this.f27473e = true;
        if (vipRank == null) {
            return;
        }
        String str = vipRank.card_id;
        d dVar = new d();
        this.f27474f = dVar;
        dVar.e(vipRank.class_name);
        this.f27474f.g(vipRank.class_url_name);
        this.f27474f.h(vipRank.class_url);
        this.f27475g = vipRank.my_score_rank.intValue();
        this.f27476h = vipUser.portrait;
    }

    public d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27474f : (d) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27476h : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f27475g < 0) {
                this.f27475g = 0;
            }
            if (this.f27475g > 9999) {
                return "9999+";
            }
            return "" + this.f27475g;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f27472i : (BdUniqueId) invokeV.objValue;
    }
}
