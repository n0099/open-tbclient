package b.a.p0.a.r2.l.d;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8274a;

    /* renamed from: b  reason: collision with root package name */
    public String f8275b;

    /* renamed from: c  reason: collision with root package name */
    public String f8276c;

    /* renamed from: d  reason: collision with root package name */
    public String f8277d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8278e;

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
            aVar.f8274a = jSONObject.optString("SSID");
            aVar.f8275b = jSONObject.optString("BSSID");
            aVar.f8278e = jSONObject.optBoolean("maunal");
            aVar.f8277d = jSONObject.optString("password");
            aVar.f8276c = jSONObject.optString("identity");
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
