package c.a.n0.a.u.f.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f6406b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f6407c;

    /* renamed from: d  reason: collision with root package name */
    public String f6408d;

    /* renamed from: e  reason: collision with root package name */
    public String f6409e;

    /* renamed from: f  reason: collision with root package name */
    public String f6410f;

    /* renamed from: g  reason: collision with root package name */
    public String f6411g;

    /* renamed from: h  reason: collision with root package name */
    public long f6412h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738608539, "Lc/a/n0/a/u/f/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1738608539, "Lc/a/n0/a/u/f/d/c;");
                return;
            }
        }
        i = c.a.n0.a.a.a;
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

    @NonNull
    public static c c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            c cVar = new c();
            try {
                cVar.f6407c = jSONObject.getJSONArray("host");
                cVar.f6406b = jSONObject.getString("appKey");
                cVar.a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                cVar.f6408d = jSONObject.getString("serverPort");
                cVar.f6410f = jSONObject.getString("wsServerPort");
                Uri.decode(jSONObject.optString("url"));
                cVar.f6411g = jSONObject.optString("notInHistory", "1");
                cVar.f6412h = jSONObject.optLong("coreVersion");
            } catch (JSONException unused) {
                if (i) {
                    Log.e("RemoteDebugModel", "DebuggerLaunchAction params: JSONException");
                }
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            JSONArray jSONArray = this.f6407c;
            return jSONArray == null ? "" : jSONArray.optString(i2);
        }
        return (String) invokeI.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return "http://" + str + ":" + this.f6408d + "/app.zip";
        }
        return (String) invokeL.objValue;
    }
}
