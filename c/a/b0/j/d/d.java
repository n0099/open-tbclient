package c.a.b0.j.d;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f1632b;

    /* renamed from: c  reason: collision with root package name */
    public String f1633c;

    /* renamed from: d  reason: collision with root package name */
    public String f1634d;

    /* renamed from: e  reason: collision with root package name */
    public String f1635e;

    /* renamed from: f  reason: collision with root package name */
    public String f1636f;

    /* renamed from: g  reason: collision with root package name */
    public String f1637g;

    /* renamed from: h  reason: collision with root package name */
    public String f1638h;

    /* renamed from: i  reason: collision with root package name */
    public String f1639i;

    /* renamed from: j  reason: collision with root package name */
    public String f1640j;

    public d() {
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

    public static String a(@NonNull d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", dVar.a);
                jSONObject.put("cmd", dVar.f1632b);
                jSONObject.put("defer_cmd", dVar.f1633c);
                jSONObject.put("init_text", dVar.f1634d);
                jSONObject.put("opt_icon", dVar.f1635e);
                jSONObject.put("opt_text", dVar.f1636f);
                jSONObject.put("app_icon_url", dVar.f1637g);
                jSONObject.put("app_name", dVar.f1638h);
                jSONObject.put("version_code", dVar.f1639i);
                jSONObject.put(LegoListActivityConfig.AD_ID, dVar.f1640j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
