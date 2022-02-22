package c.a.s0.a.r2.l.d;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.InputType;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f8963b;

    /* renamed from: c  reason: collision with root package name */
    public String f8964c;

    /* renamed from: d  reason: collision with root package name */
    public String f8965d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8966e;

    public a() {
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

    @NonNull
    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            a aVar = new a();
            if (jSONObject == null) {
                return aVar;
            }
            aVar.a = jSONObject.optString("SSID");
            aVar.f8963b = jSONObject.optString("BSSID");
            aVar.f8966e = jSONObject.optBoolean("maunal");
            aVar.f8965d = jSONObject.optString(InputType.PASSWORD);
            aVar.f8964c = jSONObject.optString("identity");
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
