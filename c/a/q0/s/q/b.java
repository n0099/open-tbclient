package c.a.q0.s.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14067a;

    /* renamed from: b  reason: collision with root package name */
    public int f14068b;

    /* renamed from: c  reason: collision with root package name */
    public int f14069c;

    /* renamed from: d  reason: collision with root package name */
    public int f14070d;

    /* renamed from: e  reason: collision with root package name */
    public String f14071e;

    /* renamed from: f  reason: collision with root package name */
    public int f14072f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14073g;

    /* renamed from: h  reason: collision with root package name */
    public int f14074h;

    /* renamed from: i  reason: collision with root package name */
    public int f14075i;

    /* renamed from: j  reason: collision with root package name */
    public y1 f14076j;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14074h = 1;
        this.f14075i = 1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14067a : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14069c : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14070d : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14073g : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14068b : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14072f : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14071e : (String) invokeV.objValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f14067a = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f14068b = jSONObject.optInt("status");
            this.f14069c = jSONObject.optInt(ExternalTransferSpeedStats.UBC_APPLICATION_CREATE_KEY);
            this.f14070d = jSONObject.optInt("end_time");
            this.f14071e = jSONObject.optString("url");
            this.f14072f = jSONObject.optInt("total_num");
            jSONObject.optInt("activity_id");
            jSONObject.optInt("award_act_id");
            jSONObject.optInt("component_id");
            this.f14073g = jSONObject.optBoolean("is_senior");
            jSONObject.optString("banner_img");
            jSONObject.optInt("show_total_num");
            String optString = jSONObject.optString("banner_img_size");
            if (!c.a.e.e.p.k.isEmpty(optString)) {
                String[] split = optString.split(",");
                this.f14074h = c.a.e.e.m.b.e(split[0], 1);
                this.f14075i = c.a.e.e.m.b.e(split[1], 1);
            }
            if (this.f14074h <= 0) {
                this.f14074h = 1;
            }
            if (this.f14075i <= 0) {
                this.f14075i = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(ActInfo actInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, actInfo) == null) || actInfo == null) {
            return;
        }
        Integer num = actInfo.activity_type;
        this.f14067a = num != null ? num.intValue() : -1;
        Integer num2 = actInfo.status;
        this.f14068b = num2 != null ? num2.intValue() : -1;
        Integer num3 = actInfo.begin_time;
        this.f14069c = num3 != null ? num3.intValue() : -1;
        Integer num4 = actInfo.end_time;
        this.f14070d = num4 != null ? num4.intValue() : -1;
        this.f14071e = actInfo.url;
        Integer num5 = actInfo.total_num;
        this.f14072f = num5 != null ? num5.intValue() : -1;
        actInfo.activity_id.intValue();
        actInfo.award_act_id.intValue();
        actInfo.component_id.intValue();
        this.f14073g = actInfo.is_senior.booleanValue();
        String str = actInfo.banner_img;
        actInfo.show_total_num.intValue();
        String str2 = actInfo.banner_img_size;
        if (!c.a.e.e.p.k.isEmpty(str2)) {
            try {
                String[] split = str2.split(",");
                this.f14074h = c.a.e.e.m.b.e(split[0], 1);
                this.f14075i = c.a.e.e.m.b.e(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f14074h <= 0) {
            this.f14074h = 1;
        }
        if (this.f14075i <= 0) {
            this.f14075i = 1;
        }
        y1 y1Var = new y1();
        this.f14076j = y1Var;
        y1Var.a(actInfo.lottery_senior);
    }
}
