package c.a.q0.s.q;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f14303a;

    /* renamed from: b  reason: collision with root package name */
    public int f14304b;

    /* renamed from: c  reason: collision with root package name */
    public int f14305c;

    /* renamed from: d  reason: collision with root package name */
    public int f14306d;

    /* renamed from: e  reason: collision with root package name */
    public int f14307e;

    /* renamed from: f  reason: collision with root package name */
    public int f14308f;

    /* renamed from: g  reason: collision with root package name */
    public int f14309g;

    public s() {
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
        this.f14307e = 25;
        this.f14308f = 25;
        this.f14309g = 10;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14306d : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14308f : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14304b : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14309g : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14307e : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14305c : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14303a : invokeV.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                i(new JSONObject(str));
            } catch (Exception e2) {
                this.f14303a = false;
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f14303a = true;
            } else {
                this.f14303a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f14306d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f14305c = optJSONObject2.optInt("time");
                this.f14304b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f14307e = optJSONObject3.optInt("succ");
                this.f14308f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f14309g = optJSONObject3.optInt("slow");
            }
            if (this.f14305c <= 0 || this.f14304b <= 0 || this.f14306d <= 0) {
                this.f14303a = false;
            }
        } catch (Exception e2) {
            this.f14303a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (this.f14303a != z) {
                c.a.e.e.n.a logItem = ImageLogger.getLogItem();
                logItem.b("act", "fallback");
                logItem.b("result", z ? "1" : "0");
                logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
                BdStatisticsManager.getInstance().debug("img", logItem);
            }
            this.f14303a = z;
        }
    }
}
