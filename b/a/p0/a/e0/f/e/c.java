package b.a.p0.a.e0.f.e;

import android.net.Uri;
import android.text.TextUtils;
import b.a.p0.a.k;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f4622e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f4623a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f4624b;

    /* renamed from: c  reason: collision with root package name */
    public String f4625c;

    /* renamed from: d  reason: collision with root package name */
    public String f4626d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1395289831, "Lb/a/p0/a/e0/f/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1395289831, "Lb/a/p0/a/e0/f/e/c;");
                return;
            }
        }
        f4622e = k.f6863a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static c b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            c cVar = new c();
            try {
                cVar.f4624b = jSONObject.getJSONArray("host");
                cVar.f4623a = jSONObject.getString("appKey");
                jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                cVar.f4625c = jSONObject.getString(ClientCookie.PORT_ATTR);
                cVar.f4626d = Uri.decode(jSONObject.optString("url"));
                return cVar;
            } catch (JSONException unused) {
                boolean z = f4622e;
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            JSONArray jSONArray = this.f4624b;
            if (jSONArray == null) {
                return "";
            }
            String optString = jSONArray.optString(i2);
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            return "http://" + optString + ":" + this.f4625c;
        }
        return (String) invokeI.objValue;
    }
}
