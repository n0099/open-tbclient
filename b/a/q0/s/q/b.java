package b.a.q0.s.q;

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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13203a;

    /* renamed from: b  reason: collision with root package name */
    public int f13204b;

    /* renamed from: c  reason: collision with root package name */
    public int f13205c;

    /* renamed from: d  reason: collision with root package name */
    public int f13206d;

    /* renamed from: e  reason: collision with root package name */
    public String f13207e;

    /* renamed from: f  reason: collision with root package name */
    public int f13208f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13209g;

    /* renamed from: h  reason: collision with root package name */
    public int f13210h;

    /* renamed from: i  reason: collision with root package name */
    public int f13211i;
    public y1 j;

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
        this.f13210h = 1;
        this.f13211i = 1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13203a : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13205c : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13206d : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13209g : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13204b : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13208f : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13207e : (String) invokeV.objValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f13203a = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f13204b = jSONObject.optInt("status");
            this.f13205c = jSONObject.optInt(ExternalTransferSpeedStats.UBC_APPLICATION_CREATE_KEY);
            this.f13206d = jSONObject.optInt("end_time");
            this.f13207e = jSONObject.optString("url");
            this.f13208f = jSONObject.optInt("total_num");
            jSONObject.optInt("activity_id");
            jSONObject.optInt("award_act_id");
            jSONObject.optInt("component_id");
            this.f13209g = jSONObject.optBoolean("is_senior");
            jSONObject.optString("banner_img");
            jSONObject.optInt("show_total_num");
            String optString = jSONObject.optString("banner_img_size");
            if (!b.a.e.e.p.k.isEmpty(optString)) {
                String[] split = optString.split(",");
                this.f13210h = b.a.e.e.m.b.e(split[0], 1);
                this.f13211i = b.a.e.e.m.b.e(split[1], 1);
            }
            if (this.f13210h <= 0) {
                this.f13210h = 1;
            }
            if (this.f13211i <= 0) {
                this.f13211i = 1;
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
        this.f13203a = num != null ? num.intValue() : -1;
        Integer num2 = actInfo.status;
        this.f13204b = num2 != null ? num2.intValue() : -1;
        Integer num3 = actInfo.begin_time;
        this.f13205c = num3 != null ? num3.intValue() : -1;
        Integer num4 = actInfo.end_time;
        this.f13206d = num4 != null ? num4.intValue() : -1;
        this.f13207e = actInfo.url;
        Integer num5 = actInfo.total_num;
        this.f13208f = num5 != null ? num5.intValue() : -1;
        actInfo.activity_id.intValue();
        actInfo.award_act_id.intValue();
        actInfo.component_id.intValue();
        this.f13209g = actInfo.is_senior.booleanValue();
        String str = actInfo.banner_img;
        actInfo.show_total_num.intValue();
        String str2 = actInfo.banner_img_size;
        if (!b.a.e.e.p.k.isEmpty(str2)) {
            try {
                String[] split = str2.split(",");
                this.f13210h = b.a.e.e.m.b.e(split[0], 1);
                this.f13211i = b.a.e.e.m.b.e(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f13210h <= 0) {
            this.f13210h = 1;
        }
        if (this.f13211i <= 0) {
            this.f13211i = 1;
        }
        y1 y1Var = new y1();
        this.j = y1Var;
        y1Var.a(actInfo.lottery_senior);
    }
}
