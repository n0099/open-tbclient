package c.a.s0.s.q;

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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13590b;

    /* renamed from: c  reason: collision with root package name */
    public int f13591c;

    /* renamed from: d  reason: collision with root package name */
    public int f13592d;

    /* renamed from: e  reason: collision with root package name */
    public String f13593e;

    /* renamed from: f  reason: collision with root package name */
    public int f13594f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13595g;

    /* renamed from: h  reason: collision with root package name */
    public int f13596h;

    /* renamed from: i  reason: collision with root package name */
    public int f13597i;

    /* renamed from: j  reason: collision with root package name */
    public y1 f13598j;

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
        this.f13596h = 1;
        this.f13597i = 1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13591c : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13592d : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13595g : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13590b : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13594f : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13593e : (String) invokeV.objValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f13590b = jSONObject.optInt("status");
            this.f13591c = jSONObject.optInt(ExternalTransferSpeedStats.UBC_APPLICATION_CREATE_KEY);
            this.f13592d = jSONObject.optInt("end_time");
            this.f13593e = jSONObject.optString("url");
            this.f13594f = jSONObject.optInt("total_num");
            jSONObject.optInt("activity_id");
            jSONObject.optInt("award_act_id");
            jSONObject.optInt("component_id");
            this.f13595g = jSONObject.optBoolean("is_senior");
            jSONObject.optString("banner_img");
            jSONObject.optInt("show_total_num");
            String optString = jSONObject.optString("banner_img_size");
            if (!c.a.d.f.p.m.isEmpty(optString)) {
                String[] split = optString.split(",");
                this.f13596h = c.a.d.f.m.b.e(split[0], 1);
                this.f13597i = c.a.d.f.m.b.e(split[1], 1);
            }
            if (this.f13596h <= 0) {
                this.f13596h = 1;
            }
            if (this.f13597i <= 0) {
                this.f13597i = 1;
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
        this.a = num != null ? num.intValue() : -1;
        Integer num2 = actInfo.status;
        this.f13590b = num2 != null ? num2.intValue() : -1;
        Integer num3 = actInfo.begin_time;
        this.f13591c = num3 != null ? num3.intValue() : -1;
        Integer num4 = actInfo.end_time;
        this.f13592d = num4 != null ? num4.intValue() : -1;
        this.f13593e = actInfo.url;
        Integer num5 = actInfo.total_num;
        this.f13594f = num5 != null ? num5.intValue() : -1;
        actInfo.activity_id.intValue();
        actInfo.award_act_id.intValue();
        actInfo.component_id.intValue();
        this.f13595g = actInfo.is_senior.booleanValue();
        String str = actInfo.banner_img;
        actInfo.show_total_num.intValue();
        String str2 = actInfo.banner_img_size;
        if (!c.a.d.f.p.m.isEmpty(str2)) {
            try {
                String[] split = str2.split(",");
                this.f13596h = c.a.d.f.m.b.e(split[0], 1);
                this.f13597i = c.a.d.f.m.b.e(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f13596h <= 0) {
            this.f13596h = 1;
        }
        if (this.f13597i <= 0) {
            this.f13597i = 1;
        }
        y1 y1Var = new y1();
        this.f13598j = y1Var;
        y1Var.a(actInfo.lottery_senior);
    }
}
