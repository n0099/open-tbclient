package c.a.u0.h2.c.k;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import tbclient.AutoPayInfo;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipInfo;
import tbclient.GetVipInfo.VipUpgrade;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes8.dex */
public class l implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final BdUniqueId f18395j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f18396e;

    /* renamed from: f  reason: collision with root package name */
    public String f18397f;

    /* renamed from: g  reason: collision with root package name */
    public String f18398g;

    /* renamed from: h  reason: collision with root package name */
    public long f18399h;

    /* renamed from: i  reason: collision with root package name */
    public int f18400i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1015603254, "Lc/a/u0/h2/c/k/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1015603254, "Lc/a/u0/h2/c/k/l;");
                return;
            }
        }
        f18395j = BdUniqueId.gen();
    }

    public l(DataRes dataRes) {
        VipUser vipUser;
        VipUpgrade vipUpgrade;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataRes};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (dataRes == null || (vipUser = dataRes.user) == null || (vipUpgrade = dataRes.upgrade) == null) {
            return;
        }
        String str = vipUser.card_id;
        String str2 = vipUser.total_scores_link;
        String str3 = vipUser.speed_link;
        String str4 = vipUser.task_scores_link;
        vipUser.task_scores.intValue();
        String str5 = vipUser.name;
        vipUser.id.longValue();
        this.f18396e = vipUser.portrait;
        this.f18397f = vipUser.name_show;
        this.f18398g = vipUser.vip_link;
        VipInfo vipInfo = vipUser.vipInfo;
        if (vipInfo != null) {
            String str6 = vipInfo.icon_url;
            vipInfo.s_time.intValue();
            this.f18399h = vipUser.vipInfo.e_time.intValue();
            vipUser.now_time.intValue();
            this.f18400i = vipUser.vipInfo.v_status.intValue();
            vipUser.vipInfo.v_level.intValue();
            vipUser.vipInfo.ext_score.intValue();
            vipUser.vipInfo.a_score.intValue();
            vipUser.vipInfo.n_score.intValue();
        } else {
            this.f18400i = 0;
        }
        dataRes.today_get_score.intValue();
        dataRes.today_unget_score.intValue();
        vipUpgrade.normal.intValue();
        vipUpgrade.pay.intValue();
        AutoPayInfo autoPayInfo = dataRes.autopay_info;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18396e : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18397f : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new SimpleDateFormat("yyyy-MM-dd").format(new Date(this.f18399h * 1000)) : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18398g : (String) invokeV.objValue;
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f18395j : (BdUniqueId) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18400i : invokeV.intValue;
    }
}
