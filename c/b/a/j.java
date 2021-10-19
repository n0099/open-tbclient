package c.b.a;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j extends s1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final y1 f31378e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(y1 y1Var) {
        super(true, false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31378e = y1Var;
    }

    @Override // c.b.a.s1
    public boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            SharedPreferences D = this.f31378e.D();
            String string = D.getString("install_id", null);
            String string2 = D.getString("device_id", null);
            String string3 = D.getString("ssid", null);
            z1.g(jSONObject, "install_id", string);
            z1.g(jSONObject, "device_id", string2);
            z1.g(jSONObject, "ssid", string3);
            long j2 = 0;
            long j3 = D.getLong("register_time", 0L);
            if ((z1.s(string) && z1.s(string2)) || j3 == 0) {
                j2 = j3;
            } else {
                D.edit().putLong("register_time", 0L).apply();
            }
            jSONObject.put("register_time", j2);
            return true;
        }
        return invokeL.booleanValue;
    }
}
