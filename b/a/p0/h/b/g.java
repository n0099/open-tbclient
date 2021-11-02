package b.a.p0.h.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f10222a;

    /* renamed from: b  reason: collision with root package name */
    public String f10223b;

    /* renamed from: c  reason: collision with root package name */
    public int f10224c;

    /* renamed from: d  reason: collision with root package name */
    public long f10225d;

    public g() {
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

    public static g a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            g gVar = new g();
            gVar.f10222a = jSONObject.optInt("state");
            gVar.f10223b = jSONObject.optString("msg");
            gVar.f10224c = jSONObject.optInt("switch_open");
            gVar.f10225d = jSONObject.optLong("heartbeat_time");
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "UpUseTimeModel{state=" + this.f10222a + ", limit='" + this.f10223b + ExtendedMessageFormat.QUOTE + ", open=" + this.f10224c + ", interval=" + this.f10225d + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
