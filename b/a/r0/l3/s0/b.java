package b.a.r0.l3.s0;

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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f20817a;

    /* renamed from: b  reason: collision with root package name */
    public long f20818b;

    /* renamed from: c  reason: collision with root package name */
    public int f20819c;

    /* renamed from: d  reason: collision with root package name */
    public String f20820d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Long, a> f20821e;

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
        this.f20817a = System.currentTimeMillis();
        this.f20821e = new HashMap();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f20817a);
            jSONObject.put("endTime", this.f20818b);
            jSONObject.put("errorCode", this.f20819c);
            jSONObject.put("errorMessage", this.f20820d);
            if (this.f20821e != null) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : this.f20821e.values()) {
                    jSONArray.put(aVar.a());
                }
                jSONObject.put("imageInfo", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
