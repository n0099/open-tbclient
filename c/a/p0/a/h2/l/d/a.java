package c.a.p0.a.h2.l.d;

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
    public String f5691b;

    /* renamed from: c  reason: collision with root package name */
    public String f5692c;

    /* renamed from: d  reason: collision with root package name */
    public String f5693d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5694e;

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
            aVar.f5691b = jSONObject.optString("BSSID");
            aVar.f5694e = jSONObject.optBoolean("maunal");
            aVar.f5693d = jSONObject.optString(InputType.PASSWORD);
            aVar.f5692c = jSONObject.optString("identity");
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
