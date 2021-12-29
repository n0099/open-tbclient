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
    public String f1961b;

    /* renamed from: c  reason: collision with root package name */
    public String f1962c;

    /* renamed from: d  reason: collision with root package name */
    public String f1963d;

    /* renamed from: e  reason: collision with root package name */
    public String f1964e;

    /* renamed from: f  reason: collision with root package name */
    public String f1965f;

    /* renamed from: g  reason: collision with root package name */
    public String f1966g;

    /* renamed from: h  reason: collision with root package name */
    public String f1967h;

    /* renamed from: i  reason: collision with root package name */
    public String f1968i;

    /* renamed from: j  reason: collision with root package name */
    public String f1969j;

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
                jSONObject.put("cmd", dVar.f1961b);
                jSONObject.put("defer_cmd", dVar.f1962c);
                jSONObject.put("init_text", dVar.f1963d);
                jSONObject.put("opt_icon", dVar.f1964e);
                jSONObject.put("opt_text", dVar.f1965f);
                jSONObject.put("app_icon_url", dVar.f1966g);
                jSONObject.put("app_name", dVar.f1967h);
                jSONObject.put("version_code", dVar.f1968i);
                jSONObject.put(LegoListActivityConfig.AD_ID, dVar.f1969j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
