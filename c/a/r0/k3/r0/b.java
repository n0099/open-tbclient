package c.a.r0.k3.r0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f21250a;

    /* renamed from: b  reason: collision with root package name */
    public long f21251b;

    /* renamed from: c  reason: collision with root package name */
    public int f21252c;

    /* renamed from: d  reason: collision with root package name */
    public String f21253d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Long, a> f21254e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21250a = System.currentTimeMillis();
        this.f21254e = new HashMap();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f21250a);
            jSONObject.put("endTime", this.f21251b);
            jSONObject.put("errorCode", this.f21252c);
            jSONObject.put("errorMessage", this.f21253d);
            if (this.f21254e != null) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : this.f21254e.values()) {
                    jSONArray.put(aVar.a());
                }
                jSONObject.put("imageInfo", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
