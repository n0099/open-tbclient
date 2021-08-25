package c.a.o0.h.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f10983a;

    /* renamed from: b  reason: collision with root package name */
    public String f10984b;

    /* renamed from: c  reason: collision with root package name */
    public int f10985c;

    /* renamed from: d  reason: collision with root package name */
    public long f10986d;

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
            gVar.f10983a = jSONObject.optInt("state");
            gVar.f10984b = jSONObject.optString("msg");
            gVar.f10985c = jSONObject.optInt("switch_open");
            gVar.f10986d = jSONObject.optLong("heartbeat_time");
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "UpUseTimeModel{state=" + this.f10983a + ", limit='" + this.f10984b + ExtendedMessageFormat.QUOTE + ", open=" + this.f10985c + ", interval=" + this.f10986d + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
