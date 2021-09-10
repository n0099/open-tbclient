package c.a.p0.a.e0.f.f;

import android.net.Uri;
import android.text.TextUtils;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
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
    public static final boolean f5304h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f5305a;

    /* renamed from: b  reason: collision with root package name */
    public String f5306b;

    /* renamed from: c  reason: collision with root package name */
    public String f5307c;

    /* renamed from: d  reason: collision with root package name */
    public String f5308d;

    /* renamed from: e  reason: collision with root package name */
    public String f5309e;

    /* renamed from: f  reason: collision with root package name */
    public String f5310f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f5311g;

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
        f5304h = k.f7077a;
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
                cVar.f5305a = jSONObject.getString("appKey");
                cVar.f5306b = jSONObject.getString("appUrl") + "?swanJsVersion=" + c.a.p0.a.m2.b.h(0) + "&appVersion=" + q0.D();
                cVar.f5307c = jSONObject.getString("wsUrl");
                cVar.f5308d = jSONObject.optString("notInHistory", "1");
                cVar.f5309e = jSONObject.optString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD);
                cVar.f5310f = jSONObject.optString("slavePreload");
                cVar.f5311g = jSONObject.optJSONArray("hosts");
                return cVar;
            } catch (JSONException unused) {
                boolean z = f5304h;
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? b(i2, this.f5306b) : (String) invokeI.objValue;
    }

    public final String b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            if (this.f5311g != null && !TextUtils.isEmpty(str) && i2 >= 0 && i2 < this.f5311g.length()) {
                Uri parse = Uri.parse(str);
                String optString = this.f5311g.optString(i2);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? b(i2, this.f5307c) : (String) invokeI.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TextUtils.isEmpty(this.f5305a) || TextUtils.isEmpty(this.f5306b) || TextUtils.isEmpty(this.f5307c) : invokeV.booleanValue;
    }
}
