package c.a.q0.s.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.YulePostActivity;
/* loaded from: classes3.dex */
public class q2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14311a;

    /* renamed from: b  reason: collision with root package name */
    public String f14312b;

    public q2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14311a : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14312b : (String) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.optLong(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY);
            jSONObject.optLong("end_time");
            this.f14311a = jSONObject.optString("activity_banner");
            jSONObject.optString("activity_url");
            jSONObject.optString("activity_desc");
            this.f14312b = jSONObject.optString("activity_button");
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void d(YulePostActivity yulePostActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, yulePostActivity) == null) || yulePostActivity == null) {
            return;
        }
        Long l = yulePostActivity.start_time;
        if (l != null) {
            l.longValue();
        }
        Long l2 = yulePostActivity.end_time;
        if (l2 != null) {
            l2.longValue();
        }
        this.f14311a = yulePostActivity.activity_banner;
        String str = yulePostActivity.activity_url;
        String str2 = yulePostActivity.activity_desc;
        this.f14312b = yulePostActivity.activity_button;
    }
}
