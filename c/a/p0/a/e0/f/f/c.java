package c.a.p0.a.e0.f.f;

import android.net.Uri;
import android.text.TextUtils;
import c.a.p0.a.k;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f4772h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f4773b;

    /* renamed from: c  reason: collision with root package name */
    public String f4774c;

    /* renamed from: d  reason: collision with root package name */
    public String f4775d;

    /* renamed from: e  reason: collision with root package name */
    public String f4776e;

    /* renamed from: f  reason: collision with root package name */
    public String f4777f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f4778g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1902634903, "Lc/a/p0/a/e0/f/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1902634903, "Lc/a/p0/a/e0/f/f/c;");
                return;
            }
        }
        f4772h = k.a;
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

    public static c e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            c cVar = new c();
            try {
                cVar.a = jSONObject.getString("appKey");
                cVar.f4773b = jSONObject.getString("appUrl") + "?swanJsVersion=" + c.a.p0.a.q2.b.h(0) + "&appVersion=" + q0.D();
                cVar.f4774c = jSONObject.getString("wsUrl");
                cVar.f4775d = jSONObject.optString("notInHistory", "1");
                cVar.f4776e = jSONObject.optString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD);
                cVar.f4777f = jSONObject.optString("slavePreload");
                cVar.f4778g = jSONObject.optJSONArray("hosts");
                return cVar;
            } catch (JSONException unused) {
                boolean z = f4772h;
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? b(i2, this.f4773b) : (String) invokeI.objValue;
    }

    public final String b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            if (this.f4778g != null && !TextUtils.isEmpty(str) && i2 >= 0 && i2 < this.f4778g.length()) {
                Uri parse = Uri.parse(str);
                String optString = this.f4778g.optString(i2);
                if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                    return str.replace(parse.getHost(), optString);
                }
            }
            return str;
        }
        return (String) invokeIL.objValue;
    }

    public String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? b(i2, this.f4774c) : (String) invokeI.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f4773b) || TextUtils.isEmpty(this.f4774c) : invokeV.booleanValue;
    }
}
