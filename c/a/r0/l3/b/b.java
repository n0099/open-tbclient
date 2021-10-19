package c.a.r0.l3.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f21957a;

    /* renamed from: b  reason: collision with root package name */
    public int f21958b;

    /* renamed from: c  reason: collision with root package name */
    public long f21959c;

    /* renamed from: d  reason: collision with root package name */
    public int f21960d;

    /* renamed from: e  reason: collision with root package name */
    public String f21961e;

    /* renamed from: f  reason: collision with root package name */
    public String f21962f;

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
        this.f21959c = 3000L;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f21960d;
            return i2 == 2 || i2 == 4;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21960d == 1 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f21960d;
            return i2 == 3 || i2 == 4;
        }
        return invokeV.booleanValue;
    }

    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f21957a = jSONObject.optInt("id", 0);
        jSONObject.optLong("update_time", 0L);
        jSONObject.optLong(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, 0L);
        jSONObject.optLong("end_time", 0L);
        this.f21960d = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE, 0);
        this.f21958b = jSONObject.optInt("show_status", 0);
        this.f21961e = jSONObject.optString("resource_url");
        this.f21962f = jSONObject.optString("link_url");
    }
}
