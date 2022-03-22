package c.a.n0.a.h2.l.d;

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
    public String f4806b;

    /* renamed from: c  reason: collision with root package name */
    public String f4807c;

    /* renamed from: d  reason: collision with root package name */
    public String f4808d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4809e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            aVar.f4806b = jSONObject.optString("BSSID");
            aVar.f4809e = jSONObject.optBoolean("maunal");
            aVar.f4808d = jSONObject.optString(InputType.PASSWORD);
            aVar.f4807c = jSONObject.optString("identity");
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
