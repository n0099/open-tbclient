package c.a.r0.t3.s0;

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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f23992b;

    /* renamed from: c  reason: collision with root package name */
    public int f23993c;

    /* renamed from: d  reason: collision with root package name */
    public String f23994d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Long, a> f23995e;

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
        this.a = System.currentTimeMillis();
        this.f23995e = new HashMap();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.a);
            jSONObject.put("endTime", this.f23992b);
            jSONObject.put("errorCode", this.f23993c);
            jSONObject.put("errorMessage", this.f23994d);
            if (this.f23995e != null) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : this.f23995e.values()) {
                    jSONArray.put(aVar.a());
                }
                jSONObject.put("imageInfo", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
