package b.a.p0.u;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
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
/* loaded from: classes4.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f12252f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12253a;

    /* renamed from: b  reason: collision with root package name */
    public int f12254b;

    /* renamed from: c  reason: collision with root package name */
    public String f12255c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f12256d;

    /* renamed from: e  reason: collision with root package name */
    public List<g> f12257e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-612802612, "Lb/a/p0/u/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-612802612, "Lb/a/p0/u/q;");
                return;
            }
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        f12252f = concurrentHashMap;
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
        this.f12257e = new ArrayList();
        this.f12255c = str;
        this.f12256d = jSONObject;
    }

    public List<g> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12257e : (List) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12255c : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12253a : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12254b : invokeV.intValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                JSONObject jSONObject = this.f12256d;
                this.f12253a = jSONObject.getInt("threshold");
                this.f12254b = jSONObject.getInt("timeup");
                JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    String string = jSONObject2.getString("ubcid");
                    if (TextUtils.isEmpty(string) || !f12252f.containsKey(string)) {
                        str = string;
                    } else {
                        String optString = jSONObject2.optString("bizid");
                        f12252f.get(string);
                        str = optString;
                    }
                    String string2 = jSONObject2.getString(SetImageWatermarkTypeReqMsg.SWITCH);
                    String string3 = jSONObject2.getString(Constant.IS_REAL);
                    String string4 = jSONObject2.getString("isAbtest");
                    int parseInt = Integer.parseInt(jSONObject2.getString("timeout"));
                    String string5 = jSONObject2.getString("type");
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                        g gVar = new g(str, string2, string3, parseInt, string5, string4);
                        if (jSONObject2.has("rate")) {
                            gVar.f12186g = Integer.parseInt(jSONObject2.getString("rate"));
                        }
                        if (jSONObject2.has("bizid")) {
                            jSONObject2.getString("bizid");
                        }
                        if (jSONObject2.has("c")) {
                            gVar.f12187h = jSONObject2.getString("c");
                        }
                        if (jSONObject2.has("limitUnit")) {
                            gVar.f12188i = Integer.parseInt(jSONObject2.getString("limitUnit"));
                        }
                        if (jSONObject2.has("limitCnt")) {
                            gVar.j = Integer.parseInt(jSONObject2.getString("limitCnt"));
                        }
                        if (jSONObject2.has(Constant.ID_TYPE)) {
                            gVar.k = jSONObject2.getString(Constant.ID_TYPE);
                        }
                        if (jSONObject2.has("appblacklist")) {
                            jSONObject2.getString("appblacklist");
                        }
                        this.f12257e.add(gVar);
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
