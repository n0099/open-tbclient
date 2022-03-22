package c.a.a0.j.d;

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
    public String f1261b;

    /* renamed from: c  reason: collision with root package name */
    public String f1262c;

    /* renamed from: d  reason: collision with root package name */
    public String f1263d;

    /* renamed from: e  reason: collision with root package name */
    public String f1264e;

    /* renamed from: f  reason: collision with root package name */
    public String f1265f;

    /* renamed from: g  reason: collision with root package name */
    public String f1266g;

    /* renamed from: h  reason: collision with root package name */
    public String f1267h;
    public String i;
    public String j;

    public d() {
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

    public static String a(@NonNull d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", dVar.a);
                jSONObject.put("cmd", dVar.f1261b);
                jSONObject.put("defer_cmd", dVar.f1262c);
                jSONObject.put("init_text", dVar.f1263d);
                jSONObject.put("opt_icon", dVar.f1264e);
                jSONObject.put("opt_text", dVar.f1265f);
                jSONObject.put("app_icon_url", dVar.f1266g);
                jSONObject.put("app_name", dVar.f1267h);
                jSONObject.put("version_code", dVar.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, dVar.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
