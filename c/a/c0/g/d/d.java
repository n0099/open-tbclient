package c.a.c0.g.d;

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
    public String f1534b;

    /* renamed from: c  reason: collision with root package name */
    public String f1535c;

    /* renamed from: d  reason: collision with root package name */
    public String f1536d;

    /* renamed from: e  reason: collision with root package name */
    public String f1537e;

    /* renamed from: f  reason: collision with root package name */
    public String f1538f;

    /* renamed from: g  reason: collision with root package name */
    public String f1539g;

    /* renamed from: h  reason: collision with root package name */
    public String f1540h;

    /* renamed from: i  reason: collision with root package name */
    public String f1541i;

    /* renamed from: j  reason: collision with root package name */
    public String f1542j;

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
                jSONObject.put("cmd", dVar.f1534b);
                jSONObject.put("defer_cmd", dVar.f1535c);
                jSONObject.put("init_text", dVar.f1536d);
                jSONObject.put("opt_icon", dVar.f1537e);
                jSONObject.put("opt_text", dVar.f1538f);
                jSONObject.put("app_icon_url", dVar.f1539g);
                jSONObject.put("app_name", dVar.f1540h);
                jSONObject.put("version_code", dVar.f1541i);
                jSONObject.put(LegoListActivityConfig.AD_ID, dVar.f1542j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
