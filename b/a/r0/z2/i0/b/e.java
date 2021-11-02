package b.a.r0.z2.i0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f28110a;

    /* renamed from: b  reason: collision with root package name */
    public int f28111b;

    /* renamed from: c  reason: collision with root package name */
    public int f28112c;

    /* renamed from: d  reason: collision with root package name */
    public long f28113d;

    public e() {
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

    public static e a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            e eVar = new e();
            eVar.f28110a = jSONObject.optInt("agree_num", -1);
            eVar.f28111b = jSONObject.optInt("share_num", -1);
            eVar.f28112c = jSONObject.optInt("reply_num", -1);
            eVar.f28113d = jSONObject.optLong("time", System.currentTimeMillis());
            return eVar;
        }
        return (e) invokeL.objValue;
    }
}
