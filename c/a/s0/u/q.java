package c.a.s0.u;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f12134f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f12135b;

    /* renamed from: c  reason: collision with root package name */
    public String f12136c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f12137d;

    /* renamed from: e  reason: collision with root package name */
    public List<g> f12138e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(252757072, "Lc/a/s0/u/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(252757072, "Lc/a/s0/u/q;");
                return;
            }
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        f12134f = concurrentHashMap;
        concurrentHashMap.put("1415", "66");
    }

    public q(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12138e = new ArrayList();
        this.f12136c = str;
        this.f12137d = jSONObject;
    }

    public List<g> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12138e : (List) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12136c : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12135b : invokeV.intValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                JSONObject jSONObject = this.f12137d;
                this.a = jSONObject.getInt("threshold");
                this.f12135b = jSONObject.getInt("timeup");
                JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    String string = jSONObject2.getString("ubcid");
                    if (TextUtils.isEmpty(string) || !f12134f.containsKey(string)) {
                        str = string;
                    } else {
                        String optString = jSONObject2.optString("bizid");
                        f12134f.get(string);
                        str = optString;
                    }
                    String string2 = jSONObject2.getString("switch");
                    String string3 = jSONObject2.getString(Constant.IS_REAL);
                    String string4 = jSONObject2.getString("isAbtest");
                    int parseInt = Integer.parseInt(jSONObject2.getString(com.alipay.sdk.data.a.O));
                    String string5 = jSONObject2.getString("type");
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                        g gVar = new g(str, string2, string3, parseInt, string5, string4);
                        if (jSONObject2.has("rate")) {
                            gVar.f12071g = Integer.parseInt(jSONObject2.getString("rate"));
                        }
                        if (jSONObject2.has("bizid")) {
                            jSONObject2.getString("bizid");
                        }
                        if (jSONObject2.has("c")) {
                            gVar.f12072h = jSONObject2.getString("c");
                        }
                        if (jSONObject2.has("limitUnit")) {
                            gVar.f12073i = Integer.parseInt(jSONObject2.getString("limitUnit"));
                        }
                        if (jSONObject2.has("limitCnt")) {
                            gVar.f12074j = Integer.parseInt(jSONObject2.getString("limitCnt"));
                        }
                        if (jSONObject2.has(Constant.ID_TYPE)) {
                            gVar.k = jSONObject2.getString(Constant.ID_TYPE);
                        }
                        if (jSONObject2.has("appblacklist")) {
                            jSONObject2.getString("appblacklist");
                        }
                        this.f12138e.add(gVar);
                    }
                }
                return true;
            } catch (NumberFormatException | JSONException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
