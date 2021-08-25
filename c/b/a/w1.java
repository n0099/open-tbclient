package c.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class w1 extends s1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f31332e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w1(Context context) {
        super(false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31332e = context;
    }

    @Override // c.b.a.s1
    public boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            SharedPreferences sharedPreferences = this.f31332e.getSharedPreferences("snssdk_openudid", 0);
            String string = sharedPreferences.getString("clientudid", null);
            if (!z1.q(string)) {
                try {
                    string = a("clientudid.dat", UUID.randomUUID().toString());
                } catch (Exception unused) {
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("clientudid", string);
                edit.apply();
            }
            jSONObject.put("clientudid", string);
            return true;
        }
        return invokeL.booleanValue;
    }
}
