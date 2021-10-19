package c.a.r0.z2.i0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29697a;

    /* renamed from: b  reason: collision with root package name */
    public int f29698b;

    /* renamed from: c  reason: collision with root package name */
    public int f29699c;

    /* renamed from: d  reason: collision with root package name */
    public long f29700d;

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
            eVar.f29697a = jSONObject.optInt("agree_num", -1);
            eVar.f29698b = jSONObject.optInt("share_num", -1);
            eVar.f29699c = jSONObject.optInt("reply_num", -1);
            eVar.f29700d = jSONObject.optLong("time", System.currentTimeMillis());
            return eVar;
        }
        return (e) invokeL.objValue;
    }
}
